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
    // KO-VIEW-MODELS
    // -------------------------------------------------------    
    
    
    var questionnaireNotificationViewModel = function () 
    {
        // context
        var self = this;
        // properties
        self.display = ko.observable(false);    
        // binding
        self.bind = function() 
        {
            ko.applyBindings(self, $("#page-container")[0]);  
        };         
        self.goToMain = function() {
            window.location.href = "../../../index.html";
        };
    };
    
    
    // PAGE-LOAD
    // -------------------------------------------------------
    
    
    // Initialize app
    webapp = new WebApp();
    webapp.init();
    
    // Build UI
    try 
    {
        var qnVM = new questionnaireNotificationViewModel();
        qnVM.bind();
        qnVM.display(true);
    }
    catch (e) 
    {
        var errorMessage = i18n.t("global-app.error-building-ui");
        var errorException = e.message;
        webapp.messageBar.addExceptionMessage(errorMessage, errorException);
        webapp.scrollToTop();
    }
});