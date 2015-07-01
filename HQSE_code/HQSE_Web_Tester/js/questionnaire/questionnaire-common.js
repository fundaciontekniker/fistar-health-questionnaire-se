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

// RESULTS
// -------------------------------------------------------


// questionnaire section result
var questionnaireResultSection = function(sectionId)
{
    // context
    var self = this;
    // properties
    self.idquestionnairesection = sectionId;
    self.listitems = new Array();
};     
// questionnaireitem-result-parameter
var questionnaireItemResultParameter = function(itemId, itemValue)
{
    // context
    var self = this;
    // properties
    self.idquestionnaireitem = itemId;
    self.paramvalue = itemValue;
};
// questionnaireitem-result-queestion-unique
var questionnaireItemResultQuestionUnique = function(itemId, itemValue)
{
    // context
    var self = this;
    // properties
    self.idquestionnaireitem = itemId;
    self.answervalue = itemValue;
};
// questionnaireitem-result-queestion-unique
var questionnaireItemResultQuestionMulti = function(itemId, itemValues)
{
    // context
    var self = this;
    // properties
    self.idquestionnaireitem = itemId;
    self.listcodanswer = itemValues;
};


// KO-MAPPINGS
// -------------------------------------------------------              


// model-entity-mapping
var questionnaireModelEntityMapping = 
{
    "KtekQuestionnaireModelEntity": 
    {
        create: function (options) {
            //console.log("mapping questionnaire...");            
            var model = (options.data) ? new questionnaireViewModel(options.data, options.parent.readOnly()) : null;
            return model;
        }
    }
};

// questionnaire-mapping
var questionnaireMapping = 
{
    "questionnaireConfiguration": 
    {
        create: function (options) 
        {
            //console.log("mapping questionnaire configuration...");
            var model = (options.data) ? new configurationViewModel(options.data) : null;
            return model;
        }
    },
    "listSections": 
    {
        create: function (options) 
        {
            //console.log("mapping questionnaire sections...");
            var parent = ko.mapping.toJS(options.parent);
            var model = (options.data) ? new sectionViewModel(options.data) : null;            
            return model;
        }
    }
};

// section-mapping
var sectionMapping = 
{
    "listItems": 
    {
        create: function (options) 
        {
            //console.log("mapping questionnaire items...");
            var parent = ko.mapping.toJS(options.parent);
            var model = (options.data) ? new itemViewModel(options.data) : null;
            return model;
        }
    }
};

// item-mapping
var itemMapping = 
{
    "listanswers": 
    {
        create: function (options) 
        {
            //console.log("mapping questionnaire answers...");
            var parent = ko.mapping.toJS(options.parent);
            var model = (options.data) ? new answerViewModel(options.data) : null;
            return model;
        }
    },
    "value": 
    {
        create: function(options) 
        {              
            // get value metadata
            
            var typeQuestionnaireItem = options.parent.typequestionnaireitem();
            var isRequired = options.parent.isrequired();
            var value = ko.observable(options.data);
            
            // set validation required
            
            value.extend({
                required: {
                    onlyIf: function () { return (isRequired === true); }
                }
            });  
            
            // set validation properties
            
            if (typeQuestionnaireItem === webapp.constants.typequestionnaireitem.QUESTION)
            {
                var typeAnswer = options.parent.typeanswer();
                var formatAnswer = options.parent.formatanswerunique();
                if (typeAnswer !== webapp.constants.typeanswer.PREDEFINED_SET_MULTI && 
                    typeAnswer !== webapp.constants.typeanswer.SET_MULTI)
                 {
                    switch (formatAnswer) 
                    {
                      case webapp.constants.formatanswerunique.INTEGER:
                        //console.log("validate formatanswerunique.INTEGER");
                        value.extend({ number: true });
                        break;
                      case webapp.constants.formatanswerunique.DECIMAL:
                        //console.log("validate formatanswerunique.DECIMAL");
                        value.extend({ number: true });
                        break;
                      case webapp.constants.formatanswerunique.STRING:
                        //console.log("validate formatanswerunique.STRING-255");
                        value.extend({ maxlength: 255 });
                        break;
                      case webapp.constants.formatanswerunique.TEXT:
                        //console.log("validate formatanswerunique.TEXT");
                        break;
                      case webapp.constants.formatanswerunique.DATE:
                         //console.log("validate formatanswerunique.DATE");
                         value.extend({ dateISO: true });
                        break;
                      default:
                        // console.log("validate formatanswerunique.UNKNOWN");                          
                        break;
                    }
                 }
            }
            else 
            {
                var typeParameter = options.parent.typeparameter();
                var typeDataCapture = options.parent.typedatacapture();
                var valueDefault = options.parent.valuedefault();
                var valueMin = options.parent.valuemin();
                var valueMax = options.parent.valuemax();
                value.extend({ number: true });
                value.extend({ min: valueMin });
                value.extend({ max: valueMax });
                if (valueDefault) {
                    value(valueDefault);
                }                
            }
            
            return value;
        }
    }
};


// KO-VIEW-MODELS
// -------------------------------------------------------


// configuration viewmodel
var configurationViewModel = function (data) 
{   
    // context
    var self = this;
    // mapping
    ko.mapping.fromJS(data, {}, self);
};

// questionnaire viewmodel
var questionnaireViewModel = function (data, readOnly)
{   
    // context
    var self = this;
    // mapping
    ko.mapping.fromJS(data, questionnaireMapping, self);
    // computed
    self.displayEvaluation = ko.computed(function () 
    {
        return (readOnly && 
                self.typemonitoringactivity() === webapp.constants.typemonitoringactivity.HEALTH_QUESTIONNAIRE);
    }, self);  
    self.className = ko.computed(function () 
    {
        var css = "";
        switch (self.typemonitoringactivity()) 
        {
            case webapp.constants.typemonitoringactivity.STATUS:
            case webapp.constants.typemonitoringactivity.HEALTH_QUESTIONNAIRE:
                css = "questionnaire-monitoring";
                break;
            case webapp.constants.typemonitoringactivity.DRUG_FOLLOW_UP:
            case webapp.constants.typemonitoringactivity.DRUG_SIDE_EFFECT:
                css = "questionnaire-treatment";
                break;
            default:
                css = "";
        }
        return css;
    }, self);      
};

// section viewmodel
var sectionViewModel = function (data) 
{
    // context
    var self = this;
    // mapping
    ko.mapping.fromJS(data, sectionMapping, self);
    // aggregates
    self.itemCount = ko.computed(function () 
    {
        return ((self.listItems) ? self.listItems().length : 0);
    }, self);        
    // validation (fix)
    if (self.itemCount() > 0) 
    {
        ko.utils.arrayForEach(self.listItems(), function(item) 
        {
            if (item.typequestionnaireitem() === webapp.constants.typequestionnaireitem.QUESTION && 
               (item.typeanswer() === webapp.constants.typeanswer.PREDEFINED_SET_MULTI || item.typeanswer() === webapp.constants.typeanswer.SET_MULTI) && 
               ko.isObservable(item.values) && 
               item.values() instanceof Array) 
            {
                item.values.extend({
                    requiredNonEmpty: (item.isrequired() === true)
                });
            }
        });      
    }        
};

// item viewmodel
var itemViewModel = function (data) 
{
    // context
    var self = this;
    // mapping
    ko.mapping.fromJS(data, itemMapping, self);
    // functions
    self.getIndexedName = function (index) 
    {
        var name = ((index + 1) + ".- " + self.namequestionnaireitem());
        if (self.isrequired())
            name = name + " (*)";
        return name;
    };
};

// answer viewmodel
var answerViewModel = function (data) 
{
    // context
    var self = this;
    // mapping
    ko.mapping.fromJS(data, {}, self);
};