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

public class KtekDefines {
	
	public static final long LOGIN_SESSION_TIMEOUT_1HOUR= 3600000; // 60*60*1000;	milliseconds = 1 hour
	
	public static final long LOGIN_SESSION_TIMEOUT_1DAY= LOGIN_SESSION_TIMEOUT_1HOUR *24; // 24 HOURS
	
	public static final long LOGIN_SESSION_TIMEOUT= LOGIN_SESSION_TIMEOUT_1DAY; // 24 HOURS
	public final static String MEDIATYPE_JSON="application/json";
	public final static String MEDIATYPE_XML="application/xml";
	
	
	public static final String AUTENTICATION_MODE_INTERNAL="INTERNAL";
	public static final String AUTENTICATION_MODE_EXTERNAL="EXTERNAL";
	
	
	
}
