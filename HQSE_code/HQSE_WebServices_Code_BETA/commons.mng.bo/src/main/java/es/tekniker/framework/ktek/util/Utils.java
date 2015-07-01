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
package es.tekniker.framework.ktek.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.RandomStringUtils;

public class Utils {

	public static String generateRandomLetter(){
		String sRandom= null;
		
		int count =1; 
		char[] chars = new char[16];

		chars[0]='a';
		chars[1]='b';
		chars[2]='d';
		chars[3]='e';
		
		chars[4]='f';
		chars[5]='g';
		chars[6]='h';
		chars[7]='i';
		
		chars[8]='j';
		chars[9]='k';
		chars[10]='l';
		chars[11]='m';
		
		chars[12]='n';
		chars[13]='o';
		chars[14]='p';
		chars[15]='r';

		sRandom = RandomStringUtils.random(count,chars);
		
		return sRandom;
	}

	public static Calendar getCalendarGMT(){		
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("GMT"));
		return c;
	}
	
	public static long getTimeinMillis4TimeGMT(int hours, int minutes, int seconds){
		Calendar c = getCalendarGMT();
		System.out.println("current: "+c.getTime());
		
		c.set(Calendar.HOUR_OF_DAY, hours);
		c.set(Calendar.MINUTE,  minutes);
		c.set(Calendar.SECOND, seconds);
		
		System.out.println("GMT Time: "+c.getTime());
		
		long timeinmillis= c.getTimeInMillis();
		System.out.println( " system time in millis " + timeinmillis);
		
		return timeinmillis;
	}
		
	public static long getTimeinMillis4FullDateTimeGMT(int year, int month , int day, int hours, int minutes, int seconds){
		Calendar c = getCalendarGMT();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		
		c.set(Calendar.HOUR_OF_DAY, hours);
		c.set(Calendar.MINUTE,  minutes);
		c.set(Calendar.SECOND, seconds);
		
		System.out.println("New Time: "+c.getTime());
		
		long timeinmillis= c.getTimeInMillis();
		System.out.println( " system time in millis " + timeinmillis);
		
		return timeinmillis;
	}
	
	
	private static Calendar getCalendarUTC(){
		Calendar c = Calendar.getInstance();
		System.out.println("current: "+c.getTime());
		
		TimeZone z = c.getTimeZone();
		int offset = z.getRawOffset();
		if(z.inDaylightTime(new Date())){
		    offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;
		
		System.out.println("offsetHrs: " + offsetHrs);
		System.out.println("offsetMins: " + offsetMins);
		c.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
		c.add(Calendar.MINUTE, (-offsetMins));
		
		System.out.println("GMT Time: "+c.getTime());
		
		return c;
	}
	
	private static long getTimeinMillisUTC(){
		Calendar c = getCalendarUTC();
		System.out.println("current: "+c.getTime());
		
		long timeinmillis= c.getTimeInMillis();
		System.out.println(" System time in millis " + timeinmillis);
		
		return timeinmillis;
	}
	
	private static long getTimeinMillis4TimeUTC(int hours, int minutes, int seconds){
		Calendar c = Calendar.getInstance();
		System.out.println("current: "+c.getTime());
		
		TimeZone z = c.getTimeZone();
		int offset = z.getRawOffset();
		if(z.inDaylightTime(new Date())){
		    offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;
		
		System.out.println("offsetHrs: " + offsetHrs);
		System.out.println("offsetMins: " + offsetMins);
		
		c.set(Calendar.HOUR_OF_DAY, (hours-offsetHrs));
		c.set(Calendar.MINUTE, ( minutes-offsetMins));
		c.set(Calendar.SECOND, seconds);
		
		System.out.println("GMT Time: "+c.getTime());
		
		long timeinmillis= c.getTimeInMillis();
		System.out.println( " system time in millis " + timeinmillis);
		
		return timeinmillis;
	}
	
	private static long getTimeinMillis4FullDateTimeUTC(int year, int month , int day, int hours, int minutes, int seconds){
		Calendar c = Calendar.getInstance();
		System.out.println("current: "+c.getTime());
		
		TimeZone z = c.getTimeZone();
		int offset = z.getRawOffset();
		if(z.inDaylightTime(new Date())){
		    offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;
		
		System.out.println("offsetHrs: " + offsetHrs);
		System.out.println("offsetMin: " + offsetMins);
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		
		c.set(Calendar.HOUR_OF_DAY, (hours-offsetHrs));
		c.set(Calendar.MINUTE, ( minutes-offsetMins));
		c.set(Calendar.SECOND, seconds);
		
		System.out.println("GMT Time: "+c.getTime());
		
		long timeinmillis= c.getTimeInMillis();
		System.out.println( " system time in millis " + timeinmillis);
		
		return timeinmillis;
	}
	

	
}
