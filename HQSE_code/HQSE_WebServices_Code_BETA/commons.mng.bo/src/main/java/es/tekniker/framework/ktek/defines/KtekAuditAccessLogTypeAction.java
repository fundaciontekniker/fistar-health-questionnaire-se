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
package es.tekniker.framework.ktek.defines;

public class KtekAuditAccessLogTypeAction  {
	
	

	public static short LOGIN = 1;
	
	public static short READ_QUESTIONNAIRE = 2;	
	public static short READ_UPDATED_QUESTIONNAIRE = 3;
	public static short UPDATE_QUESTIONNAIRE = 4;
	public static short SEND_QUESTIONNAIRE = 5;
	
	public static short READ_SESSION = 6;
	public static short READ_EXERCISE = 7;
	public static short READ_UPDATED_EXERCISE = 8;
	public static short UPDATE_EXERCISE = 9;
	public static short SEND_EXERCISE = 10;	
	public static short REVIEW_EXERCISE = 11;
	
	public static short ACCESS_EXERCISE_LOG = 12;
	public static short ACCESS_STATUS_QUESTIONAIRE_LOG = 13;
	public static short ACCESS_HEALTH_STATUS_QUESTIONAIRE_LOG = 14;
	public static short ACCESS_SIDE_EFFECTS_LOG = 15;

	public static short ACCESS_DRUGFOLLOWUP_LOG = 16;	
	public static short ACCESS_LEARNING_SUMMARY = 17;
	public static short ACCESS_PATIENTS_SUMMARY = 18;
	
	
	public static short READ_QUESTIONNAIRE_RESULT = 19;	
	
}
