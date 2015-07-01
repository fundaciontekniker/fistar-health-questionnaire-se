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

// QUESTIONNAIRE SERVICES
// -------------------------------------------------------    


var QuestionnaireDataService = function() 
{
    var self = this;
    self.baseURL = BuildQuestionnaireRootURL() + "/questionnaire.mng.rest/rest/ktek";
    self.getQuestionnaire = function (token, langId, userId, telecareProgramCode, questionnaireId) 
    {
        var serviceData = null;
        var serviceError = null;        
        var urlComposer = new Array();        
        urlComposer.push(self.baseURL);
        urlComposer.push("questionnaire/questionnairemodel");
        urlComposer.push(questionnaireId);
        var url = urlComposer.join("/");
        
        if (webapp.options.debug) 
        {                            
            console.log("==============================================");
            console.log("WEB SERVICE CALL");
            console.log("url: " + url);
            console.log("token: " + token);            
            console.log("lang: " + langId);        
            console.log("iduser: " + userId);
            console.log("codtelecareprogram: " + telecareProgramCode);
            console.log("idquestionnaire: " + questionnaireId);
        }
        
        $.ajax({
            headers: {
                "token": token,
                "idlang": langId,
                "iduser": userId,
                "codtelecareprogram": telecareProgramCode                
            },                                 // headers
            async: false,                      // synchronous/asynchronous              
            url: url,                          // service url
            type: "GET",                       // http method
            data: null,                        // data to server
            dataType: "json",                  // type of data from the server
            contentType: "application/json",   // type of data to the server
            timeout: QSE_WS_TIMEOUT            // timeout
        })        
        .done(function( result ) 
        {
            if (!result)
                serviceError = {code: -999, message: i18n.t("global-app.error-service-result") };
            else if ( result.error )
                serviceError = result.error;
            else
                serviceData = result;
        })
        .fail(function( jqXHR, status, error ) 
        {
            serviceError = {
                code: jqXHR.status,
                message: error
            };
        });        
        return {
            data: serviceData,
            error: serviceError        
        };
    };
    self.getQuestionnaireResults = function (token, langId, userId, telecareProgramCode, questionnaireResultId) 
    {
        var serviceData = null;
        var serviceError = null;        
        var urlComposer = new Array();        
        urlComposer.push(self.baseURL);
        urlComposer.push("questionnaire/questionnairemodelresult");
        urlComposer.push(questionnaireResultId);
        var url = urlComposer.join("/");
        
        if (webapp.options.debug) 
        {                            
            console.log("==============================================");
            console.log("web service call");
            console.log("url: " + url);
            console.log("token: " + token);            
            console.log("lang: " + langId);        
            console.log("iduser: " + userId);
            console.log("codtelecareprogram: " + telecareProgramCode);
        }
        
        $.ajax({
            headers: {
                "token": token,
                "idlang": langId,
                "iduser": userId,
                "codtelecareprogram": telecareProgramCode                
            },                                 // headers
            async: false,                      // synchronous/asynchronous              
            url: url,                          // service url
            type: "GET",                       // http method
            data: null,                        // data to server
            dataType: "json",                  // type of data from the server
            contentType: "application/json",   // type of data to the server
            timeout: QSE_WS_TIMEOUT            // timeout
        })        
        .done(function( result ) 
        {
            if (!result)
                serviceError = {code: -999, message: i18n.t("global-app.error-service-result") };
            else if ( result.error )
                serviceError = result.error;
            else
                serviceData = result;
        })
        .fail(function( jqXHR, status, error ) 
        {
            serviceError = {
                code: jqXHR.status,
                message: error
            };
        });        
        return {
            data: serviceData,
            error: serviceError        
        };
    };    
    self.saveQuestionnaire = function (token, langId, userId, telecareProgramCode, data) 
    {
        var serviceData = null;
        var serviceError = null;        
        var urlComposer = new Array();        
        urlComposer.push(self.baseURL);
        urlComposer.push("questionnaire/questionnairemodel");
        var url = urlComposer.join("/");
        
        if (webapp.options.debug) 
        {                            
            console.log("==============================================");
            console.log("web service call");
            console.log("url: " + url);
            console.log("token: " + token);            
            console.log("lang: " + langId);        
            console.log("iduser: " + userId);
            console.log("codtelecareprogram: " + telecareProgramCode);
            console.log("data: " + JSON.stringify(data));        
        }
        
        $.ajax({
            headers: {
                "token": token,
                "idlang": langId,
                "iduser": userId,
                "codtelecareprogram": telecareProgramCode                
            },                                 // headers
            async: false,                      // synchronous/asynchronous              
            url: url,                          // service url
            type: "POST",                      // http method
            data: JSON.stringify(data),        // data to server
            dataType: "json",                  // type of data from the server
            contentType: "application/json",   // type of data to the server
            timeout: QSE_WS_TIMEOUT            // timeout
        })        
        .done(function( result ) 
        {
            if (!result)
                serviceError = {code: -999, message: i18n.t("global-app.error-service-result") };
            else if ( result.error )
                serviceError = result.error;
            else
                serviceData = result;
        })
        .fail(function( jqXHR, status, error ) 
        {
            serviceError = {
                code: jqXHR.status,
                message: error
            };
        });        
        return {
            data: serviceData,
            error: serviceError        
        };
    };
};