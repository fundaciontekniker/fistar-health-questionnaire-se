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
// GLOBAL VARIABLES
// -------------------------------------------------------

var webapp = { };


// HTML USER-CONTROLS
// -------------------------------------------------------

var MessageBarUSC = function ()
{
    // context
    var self = this;    
    // properties
    self.dangerMessages = ko.observableArray([]);
    self.warningMessages = ko.observableArray([]);
    self.infoMessages = ko.observableArray([]);
    self.successMessages = ko.observableArray([]);    
    // binding
    self.bind = function () 
    {
        if ($("#usc-messagebar").length > 0) {
            ko.applyBindings(self, $("#usc-messagebar")[0]);
        }
    };
    // functions
    self.init = function () 
    {
        self.bind();
    };
    self.clear = function ()
    {
        self.dangerMessages.removeAll();
        self.warningMessages.removeAll();
        self.infoMessages.removeAll();
        self.successMessages.removeAll();
    };    
    self.addDangerMessage = function (text) 
    {
        self.dangerMessages.unshift(text);
    };    
    self.addWarningMessage = function (text) 
    {
        self.warningMessages.unshift(text);
    };    
    self.addInfoMessage = function (text) 
    {
        self.infoMessages.unshift(text);
    };
    self.addSuccessMessage = function (text) 
    {
        self.successMessages.unshift(text);
    };
    self.addErrorMessage = function (code, error) 
    {
        var text = "(" + code + ") " + error;
        self.addDangerMessage(text);
    };
    self.addExceptionMessage = function (error, exception) 
    {
        self.addDangerMessage(exception);
        self.addDangerMessage(error);
    };    
};


// APPLICATION
// -------------------------------------------------------

var WebApp = function()
{
    // context
    var self = this;    
    // constants
    self.constants =  
    {
        "lang": {
            "UNKNOWN": 0,
            "SPANISH": 1,
            "BASQUE": 2,
            "ENGLISH": 3
        },        
        "typeapplicationmodule": {
            "UNKNOWN": 0,
            "LEARNING": 1,
            "STATUS_MONITORING": 2,
            "DRUG_TREATMENT": 3,
            "EVOLUTION": 4
        },                        
        "typeapplicationitem": {
            "UNKNOWN": 0,
            "STATUS_PARAMETERS": 1,
            "STATUS_HEALTH": 2,
            "DRUG_FOLLOW_UP": 3,
            "DRUG_SIDE_EFFECTS": 4
        },                
        "typemonitoringactivity": {
            "UNKNOWN": 0,
            "STATUS": 1,
            "HEALTH_QUESTIONNAIRE": 2,
            "DRUG_FOLLOW_UP": 3,
            "DRUG_SIDE_EFFECT": 4
        },
        "typequestionnaire": {
            "UNKNOWN": 0,
            "ASSESSMENT": 1,
            "MONITORING": 2
        },
        "typequestionnaireitem": {
            "UNKNOWN": 0,
            "PARAMETER": 1,
            "QUESTION": 2
        },
        "typeanswer": {
            "UNKNOWN": 0,
            "UNIQUE": 1,
            "PREDEFINED_SET_MULTI": 2,
            "PREDEFINED_SET_UNIQUE": 3,
            "SET_MULTI": 4,
            "SET_UNIQUE": 5
        },
        "formatanswerunique": {
            "UNKNOWN": 0,
            "INTEGER": 1,
            "DECIMAL": 2,
            "STRING": 3,
            "TEXT": 4,
            "DATE": 5
        },
        "typeparameter": {
            "UNKNOWN": 0,
            "INTEGER": 1,
            "DECIMAL": 2
        }
    };    
    // options
    self.options = 
    { 
        debug: true
    };    
    // user-controls
    self.messageBar = new MessageBarUSC();
    // data-services
    self.questionnaireDataService = (typeof QuestionnaireDataService !== "undefined") ? new QuestionnaireDataService() : null;
    // functions
    self.init = function ()
    {
        // set language manager settings
        var i18nSettings = {
            debug: true,
            getAsync: false,
            resGetPath: '../../../lang/__lng__/__ns__.min.json',
            lng: 'en',            
            load: 'unspecific',
            useCookie: false,
            fallbackLng: false,
            fallbackOnNull: false,
            fallbackOnEmpty: false,
            useLocalStorage: true,
            //localStorageExpirationTime: 86400000 // in ms, default 24 hours
            localStorageExpirationTime: 1 // in ms, default 1 minute
        };
        
        // initialize language manager
        i18n.init(i18nSettings, function( t ) { 
            ko.language(i18n.lng());
        });
        
        // initialize user controls
        self.messageBar.init();
    };    
    self.isNetworkRunning = function ()
    {
        jQuery.ajaxSetup({async:false});
        re="";
        r=Math.round(Math.random() * 10000);
        $.get("../../../favicon.ico",{subins:r},function(d){
         re=true;
        }).error(function(){
         re=false;
        });
        return re;        
    };        
    self.scrollToTop = function ()
    {
        window.scrollTo(0,0);
    };
};


// JQUERY EXTENSORS
// -------------------------------------------------------

(function($){
    $.getQueryStringParameter = function( parameter ) {
        parameter = parameter.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
        var expr = "[\\?&]"+parameter+"=([^&#]*)";
        var regex = new RegExp( expr );
        var results = regex.exec( window.location.href );
        if( results !== null ) {
            return results[1];
            return decodeURIComponent(results[1].replace(/\+/g, " "));
        } else {
            return false;
        }
    };
})(jQuery);

(function($){
    $.getParameter = function( parameter, string ) {
        parameter = parameter.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
        var expr = "[\\?&]"+parameter+"=([^&#]*)";
        var regex = new RegExp( expr );
        var results = regex.exec( string );
        if( results !== null ) {
            return results[1];
            return decodeURIComponent(results[1].replace(/\+/g, " "));
        } else {
            return false;
        }
    };
})(jQuery);


// KO BINDINGS
// -------------------------------------------------------

ko.bindingHandlers.hidden = 
{
    update: function(element, valueAccessor) {
        var value = ko.utils.unwrapObservable(valueAccessor());
        ko.bindingHandlers.visible.update(element, function() { 
            return !value; 
        });
    }
};
ko.bindingHandlers.id = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { id: valueAccessor() };
        });
    }
};
ko.bindingHandlers.name = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { name: valueAccessor() };
        });
    }
};
ko.bindingHandlers.placeholder = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { placeholder: valueAccessor()};
        });
    }
};
ko.bindingHandlers.href = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { href: valueAccessor()};
        });
    }
};
ko.bindingHandlers.src = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { src: valueAccessor()};
        });
    }
};
ko.bindingHandlers.title = 
{
    update: function (element, valueAccessor) {
        ko.bindingHandlers.attr.update(element, function () {
            return { title: valueAccessor()};
        });
    }
};
ko.bindingHandlers.uniqueId = 
{
    /*
      data-bind="uniqueId: $data" to stick a new id on $data and
      use it as the html id of the element.
      data-which="foo" (optional) adds foo to the id, to separate
      it from other ids made from this same $data.
    */
    counter: 0,
    _ensureId: function (value, element) {
	if (value.id === undefined) {
	    value.id = "elem" + (++ko.bindingHandlers.uniqueId.counter);
	}
	var id = value.id, which = element.getAttribute("data-which");
	if (which) {
	    id += "-" + which;
	}
	return id;
    },
    init: function(element, valueAccessor) {
        var value = valueAccessor();
        element.id = ko.bindingHandlers.uniqueId._ensureId(value, element);
    }
};
ko.bindingHandlers.uniqueFor = 
{
    /*
      data-bind="uniqueFor: $data" works like uniqueId above, and
      adds a for="the-new-id" attr to this element.
      data-which="foo" (optional) works like it does with uniqueId.
    */
    init: function(element, valueAccessor) {
        var value = valueAccessor();
        element.setAttribute(
	    "for", 
            ko.bindingHandlers.uniqueId._ensureId(value, element)
        );
    }
};


// KO EXTENSORS
// -------------------------------------------------------

ko.extenders.converter = function (target, options) 
{
    var name = options.name || 'converted';
    var fromValue = options.fromValue || passthrough;    // from target value (read)
    var toValue = options.toValue || passthrough;        // to target value (write)
    target[name] = ko.dependentObservable({
        read: function () {
            return fromValue(target());
        },
        write: function (value) {
            target(toValue(value));
        }
    });
    return target;

    function passthrough(value) { return value; }
};


// KO FUNCTIONS
// -------------------------------------------------------

function BooleanConverter(trueValue, falseValue, name) 
{
    this.name = name || 'converted';
    this.fromValue = function (value) {
        switch (value) {
            case trueValue: return true;
            case falseValue: return false;
            default: return false;
        }
    }.bind(this);
    this.toValue = function (value) {
        return !!value ? trueValue : falseValue;
    }.bind(this);
}