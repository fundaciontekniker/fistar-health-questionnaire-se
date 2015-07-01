/*
 
 Copyright 2015 IK4-Tekniker All Rights Reserved

 This file is part of Health Questionnaire SE at FISTAR https://www.fi-star.eu/  

 Health Questionnaire SE is free software: you can redistribute it and/or
 modify it under the terms of the GNU Affero General Public License as
 published by the Free Software Foundation, either version 3 of the
 License, or (at your option) any later version.

 Health Questionnaire SE is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero
 General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with Health Questionnaire SE. If not, see http://www.gnu.org/licenses/.

 For those usages not covered by this license please contact with
 patricia.casla at tekniker dot es

 Author: Rubén Ferreira Pérez
*/
$(function ()
{    
    // RESULTS
    // -------------------------------------------------------

    // questionnaire result creator
    var questionnaireResultCreator = function (data, telecareProgramCode, coduser) 
    {
        // vars
        var qResult, qData, qSection, qItem = null;

        // get questionnaire data
        qData = ko.mapping.toJS(data);    

        // compose result
        qResult = new questionnaireResult(
            qData.idquestionnaire,
            qData.iduserquestionnaireplanning || 0,
            telecareProgramCode,
            coduser
        );
        if (qData.listSections && qData.listSections.length > 0) 
        {
            $.each(qData.listSections, function( index, section ) 
            {
                qSection = new questionnaireResultSection(
                    section.idquestionnairesection
                );
                if (section.listItems.length > 0)
                {
                    $.each(section.listItems, function( index, item ) 
                    {
                        qItem = null;
                        if (item.typequestionnaireitem === webapp.constants.typequestionnaireitem.PARAMETER) 
                        { // parameter
                            if (item.value) {
                                qItem = new questionnaireItemResultParameter(
                                    item.idquestionnaireitem,
                                    item.value
                                );
                            }
                        }
                        else 
                        { // question
                            if (item.typeanswer === webapp.constants.typeanswer.PREDEFINED_SET_MULTI ||
                                item.typeanswer === webapp.constants.typeanswer.SET_MULTI) {
                                if (item.values) {                            
                                    qItem = new questionnaireItemResultQuestionMulti(
                                        item.idquestionnaireitem,
                                        item.values
                                    );
                                }
                            } else if (item.typeanswer === webapp.constants.typeanswer.PREDEFINED_SET_UNIQUE ||
                                       item.typeanswer === webapp.constants.typeanswer.SET_UNIQUE) {
                                   if (item.value) {
                                        var values = new Array();
                                        values.push(item.value);
                                        qItem = new questionnaireItemResultQuestionMulti(
                                            item.idquestionnaireitem,
                                            values
                                        );
                                   }
                            } else {
                                if (item.value) {
                                    qItem = new questionnaireItemResultQuestionUnique(
                                        item.idquestionnaireitem,
                                        item.value
                                    );
                                }
                            }                            
                        }
                        if (qItem) {
                            qSection.listitems.push(qItem);
                        }
                    }); // endfor-items
                }
                qResult.KtekQuestionnaireResultEntity.listsections.push(qSection);
            }); // endfor-sections
        } 

        return qResult;
    };
    
    // questionnaire result
    var questionnaireResult = function (questionnaireId, questionnairePlanningId, telecareProgramCode, coduser)
    {
        // context
        var self = this;
        // properties
        self.KtekQuestionnaireResultEntity  = {};
        self.KtekQuestionnaireResultEntity.idquestionnaire = questionnaireId;
        self.KtekQuestionnaireResultEntity.iduserquestionnaireplanning = questionnairePlanningId;        
        self.KtekQuestionnaireResultEntity.codtelecareprogram = telecareProgramCode;
        self.KtekQuestionnaireResultEntity.coduser = coduser;
        self.KtekQuestionnaireResultEntity.listsections = new Array();
    };    
    
    
    // KO-VIEW-MODELS
    // -------------------------------------------------------

    // standalone questionnaire viewmodel
    var standaloneQuestionnaireViewModel = function () 
    {
        // context
        var self = this;
        // properties
        self.display = ko.observable(false);
        self.readOnly = ko.observable(false);
        self.KtekQuestionnaireModelEntity = ko.observable();
        // binding
        self.bind = function() 
        {
            ko.applyBindings(self, $("#page-container")[0]);
        };            
        // data
        self.load = function (data) 
        {
            // print data in debug mode 
            if (webapp.options.debug) 
            {                                    
                console.log("==============================================");
                console.log("LOADING QUESTIONNAIRE DATA...");
                console.log(ko.toJSON(ko.mapping.toJS(data), null, 2));
            }    
            // map
            ko.mapping.fromJS(data, questionnaireModelEntityMapping, self);
        };
        // behavior
        self.send = function (data) 
        {
            // clear messagebar control
            console.clear();
            webapp.messageBar.clear();            
            
            // validate data
            if (self.isValid()) 
            { // client validation OK

                var question = i18n.t("global-app.confirm-operation") ;
                var answer = confirm(question);
                if (answer) 
                {
                    // create result to send
                    var qresult = questionnaireResultCreator(data, telecareProgramCode, userCode);
                    // print data in debug mode 
                    if (webapp.options.debug) 
                    {                  
                        console.log("==============================================");
                        console.log("CLIENT VALIDATION OK, BUILDING RESULT...");
                        console.log(ko.toJSON(ko.mapping.toJS(qresult), null, 2));
                    }
                    // send or store depending on network status
                    if (webapp.isNetworkRunning() === true)
                    { // network alive

                        // print data in debug mode 
                        if (webapp.options.debug) 
                        {                  
                            console.log("==============================================");
                            console.log("NETWORK IS ALIVE...");
                        }
                        // send questionnaire result
                        var result = webapp.questionnaireDataService.saveQuestionnaire(userToken, langId, userId, telecareProgramCode, qresult);
                        if (result) 
                        { // web service result exists

                            if (result.error) 
                            {
                                // show web service error
                                webapp.messageBar.addErrorMessage(result.error.code, result.error.message);
                                // scroll to the top of the window
                                webapp.scrollToTop();                            
                            } 
                            else 
                            {
                                console.log("==============================================");
                                console.log("SAVE RESULT...");
                                console.log(ko.toJSON(result, null, 2));
                                
                                // manage web service result
                                if ( parseInt(result.data.Integer) === 1) {
                                    var url = "../main/questionnaire-success.html";
                                    window.location.href = url;
                                } else {
                                    var message = i18n.t("page-questionnaire.error-send");
                                    webapp.messageBar.addDangerMessage(message);
                                    webapp.scrollToTop();
                                }
                            }
                        } 
                        else 
                        { // web service result doesn't exists

                           // show error message
                           var message = i18n.t("global-app.error-recovering-data");
                           webapp.messageBar.addDangerMessage(message);
                           // scroll to the top of the window
                           webapp.scrollToTop();
                        }
                    }
                    else 
                    { // network broken

                        // print data in debug mode 
                        if (webapp.options.debug) 
                        {                  
                            console.log("==============================================");
                            console.log("NETWORK BROKEN...");
                        }
                        // show warning message
                        var message = i18n.t("page-questionnaire.warning-send");
                        webapp.messageBar.addWarningMessage(message);                        
                        // scroll to the top of the window
                        webapp.scrollToTop();
                    }
                }
            } 
            else 
            { // client validation NOK
                
                // print data in debug mode 
                if (webapp.options.debug) 
                {                  
                    console.log("==============================================");
                    console.log("CLIENT VALIDATION NOK");
                }
                // show warning message
                var message = i18n.t("page-questionnaire.error-validation");
                webapp.messageBar.addWarningMessage(message);
                // show validation messages
                self.errors.showAllMessages(true);
                // scroll to the top of the window
                webapp.scrollToTop();
            }
        };
    };
    
    
    // PAGE-LOAD
    // -------------------------------------------------------        
    

    // Initialize app
    webapp = new WebApp();
    webapp.init();
    
    // Get parameters from URL    
    var userId = $.getQueryStringParameter("userId");
    var userToken = $.getQueryStringParameter("userToken") || "";
    var userCode = $.getQueryStringParameter("userCode") || "";
    var telecareProgramCode = $.getQueryStringParameter("telecareProgramCode") || "";
    var questionnaireId = $.getQueryStringParameter("questionnaireId");    
    var langId = 1;

    // Convert parameters
    userId = ($.isNumeric(userId)) ? parseInt(userId) : -1;
    questionnaireId = ($.isNumeric(userId)) ? parseInt(questionnaireId) : -1;
    
    // Check parameters
    if (webapp.options.debug) 
    {                                
        console.log("==============================================");
        console.log("PARAMETERS");
        console.log("userId: " + userId);
        console.log("userToken: " + userToken);
        console.log("userCode: " + userCode);
        console.log("telecareProgramCode: " + telecareProgramCode);
        console.log("questionnaireId: " + questionnaireId);
        console.log("langId: " + langId);
    }
    
    // Call to web service or local storage to get the questionnaire data
    var wsResult = null;
    wsResult = webapp.questionnaireDataService.getQuestionnaire(userToken, langId, userId, telecareProgramCode, questionnaireId);
    
    // Get questionnaire data from result
    var standaloneQuestionnaireVM = new standaloneQuestionnaireViewModel();    
    standaloneQuestionnaireVM.bind();
    var wsData = null;    
    if (wsResult) {        
        if (wsResult.error) {
            webapp.messageBar.addErrorMessage(wsResult.error.code, wsResult.error.message);
            webapp.scrollToTop();
        } else {
            wsData = wsResult.data;
            try 
            {
                standaloneQuestionnaireVM.load(wsData);
                standaloneQuestionnaireVM.errors = ko.validation.group(standaloneQuestionnaireVM, {deep: true});
                standaloneQuestionnaireVM.display(true);
            }
            catch (e) 
            {
                var errorMessage = i18n.t("global-app.error-building-ui");
                var errorException = e.message;
                webapp.messageBar.addExceptionMessage(errorMessage, errorException);
                webapp.scrollToTop();
            } 
        }
    } 
    else {
        var message = i18n.t("global-app.error-recovering-data");
        webapp.messageBar.addDangerMessage(message);
        webapp.scrollToTop();
    }    
});