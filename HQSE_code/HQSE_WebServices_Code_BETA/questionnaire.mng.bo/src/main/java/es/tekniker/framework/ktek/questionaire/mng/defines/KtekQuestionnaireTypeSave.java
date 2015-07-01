/*
*
* Copyright 2015 IK4-Tekniker All Rights Reserved
*
* This file is part of Health Questionnaire SE at FISTAR https://www.fi-star.eu/  
*
* Health Questionnaire SE is free software: you can redistribute it and/or
* modify it under the terms of the GNU Affero General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* Health Questionnaire SE is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero
* General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with Health Questionnaire SE. If not, see http://www.gnu.org/licenses/.
*
* For those usages not covered by this license please contact with
* patricia.casla at tekniker dot es
*
* Author: Ignacio Lazaro Llorente
*/
package es.tekniker.framework.ktek.questionaire.mng.defines;

public class KtekQuestionnaireTypeSave {

	public static short QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE=1;
	public static short QUESTIONNAIRE_TYPE_PUBLISH_EVENT_SERVICE=2;
	public static short QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_EVENT_SERVICE=3;
	public static short QUESTIONNAIRE_TYPE_PUBLISH_CONTEXT_BROKER=4;
	public static short QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_CONTEXT_BROKER=5;
	
	public static short QUESTIONNAIRE_SAVE_RESULT_OK=1;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION=2;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_SAVE_DATABASE=3;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_PUBLISH_EVENTSERVICE=4;	
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION_SAVE_DATABASE=5;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION_PUBLISH_EVENTSERVICE=6;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_SAVE_DATABASE_PUBLISH_EVENTSERVICE=6;
	
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_PUBLISH_CONTEXTBROKER=7;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION_PUBLISH_CONTEXTBROKER=8;
	public static short QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_SAVE_DATABASE_PUBLISH_CONTEXTBROKER=9;
	
	
}
