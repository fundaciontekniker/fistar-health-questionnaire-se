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
$(function() {

    function LoadConfiguration() 
    {
        var serviceUrl = BuildQuestionnaireRootURL() + "/questionnaire.mng.rest/rest/ktek/questionnaire/configuration";
        var serviceData = null;
        var serviceError = null;    
        $.ajax({
            headers: { },                      // headers                  
            async: false,                      // synchronous/asynchronous              
            url: serviceUrl,                   // service url
            type: "GET",                       // http method
            data: null,                        // data to server
            dataType: "json",                  // type of data from the server
            contentType: "application/json",   // type of data to the server
            timeout: QSE_WS_TIMEOUT            // timeout
        })        
        .done(function( result ) 
        {
            if (!result)
                serviceError = {code: -999, message: "An error occur loading data..." };
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

    function SaveConfiguration(data) 
    {
        var serviceUrl = BuildQuestionnaireRootURL() + "/questionnaire.mng.rest/rest/ktek/questionnaire/configuration";
        var serviceData = null;
        var serviceError = null;    
        $.ajax({
            headers: { },                      // headers                  
            async: false,                      // synchronous/asynchronous              
            url: serviceUrl,                   // service url
            type: "POST",                      // http method
            data: data,                        // data to server
            dataType: "json",                  // type of data from the server
            contentType: "application/json",   // type of data to the server
            timeout: QSE_WS_TIMEOUT            // timeout
        })        
        .done(function( result ) 
        {
            if (!result)
                serviceError = {code: -999, message: "An error occur saving data..." };
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

    var configurationMapping = {
        "KtekQuestionnaireConfiguration": {
            create: function (options) {
                var model = new configurationModel(options.data);
                return model;
            }
        }
    };

    var configurationModel = function (data) {
        var self = this;      
        ko.mapping.fromJS(data, {}, self);
        self.typesave.extend({ required: true });    
        self.endpointserver.extend({
            required: {
                onlyIf: function() {
                    return self.typesave() > 1;
                }
            }
        });        
        self.port.extend({
            required: {
                onlyIf: function() {
                    return self.typesave() > 1;
                }
            },
            number: true
        });                
        self.timeout.extend({
            required: {
                onlyIf: function() {
                    return self.typesave() > 1;
                }
            },
            number: true
        });
        self.eventserviceoauth2headertoken.extend({
            required: {
                onlyIf: function() {
                    return self.typesave() === 2 || self.typesave() === 3;
                }
            }
        });
    };

    var configurationViewModel = function () {
        var self = this;    
        self.KtekQuestionnaireConfiguration = ko.observable();
        self.bind = function () {
            ko.applyBindings(self, $("#page-container")[0]);    
        };
        self.load = function (data) {
            ko.mapping.fromJS(data, configurationMapping, self);
        };
        self.save = function (data) {
            $(".alert-danger").addClass("hidden");
            $(".alert-success").addClass("hidden");
            if (self.isValid()) {
                console.log("it's valid!");
                var serviceResult = SaveConfiguration(ko.mapping.toJSON(data));
                if (serviceResult.error) {
                    $("#danger-message").text("An error occur saving data.");
                    $(".alert-danger").removeClass("hidden");
                }
                else {
                    $("#success-message").text("Data saved successfully.");
                    $(".alert-success").removeClass("hidden");
                }            
                window.scrollTo(0,0);
            }
            else {
                console.log("it isnt't valid!");
                self.errors.showAllMessages(true);
            }        
        };
    };

    var serviceResult = LoadConfiguration() || {};
    if (serviceResult.data) {
        var configurationVM = new configurationViewModel();
        configurationVM.load(serviceResult.data);
        configurationVM.errors = ko.validation.group(configurationVM, {deep: true});        
        configurationVM.bind();     
    }    

});