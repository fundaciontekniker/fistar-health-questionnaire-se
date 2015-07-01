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
* Author: Francisco Javier Díez
*/
/**
 * 
 */
package es.tekniker.framework.ktek.questionnaire.mng.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Francisco Javier Díez
 *
 */
public class ConfigFile {

	private static Properties props = new Properties();
	private static String filePath = "config.properties";
	private static Log log =
	    LogFactory.getLog(ConfigFile.class);
	
	protected ConfigFile() {
		log.debug("ConfigFile default constructor");
	}
	
	public ConfigFile(String filePath) throws IOException{	
		log.debug("ConfigFile with file constructor");
		setFilePath(filePath);
	}
	
	protected static void setFilePath(String defaultFilePath) throws IOException {
		ConfigFile.filePath = defaultFilePath;
		log.debug("Loading properties for file " + filePath); 

        ClassLoader loader = ConfigFile.class.getClassLoader();
        if(loader==null)
          loader = ClassLoader.getSystemClassLoader();

        java.net.URL url = loader.getResource(filePath);
		props.load(url.openStream());		
		log.debug("Properties loaded"); 
	}

	protected static String getFilePath() {
		return filePath;
	}

	public String getStringParam(String paramName){
		String value = props.getProperty(paramName);
		log.debug("Param String " + paramName + " read. value: " + value);
		return value;
	}

	public long getLongParam(String paramName){
		String value = props.getProperty(paramName);
		log.debug("Param Long " + paramName + " read. value: " + value);
		if ( value == null){
			return 0;
		}
		else {
			return Long.parseLong(value);
		}
	}
	
	public int getIntParam(String paramName){
		String value = props.getProperty(paramName);
		log.debug("Param Integer " + paramName + " read. value: " + value);
		if ( value == null){
			return 0;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
	public List<String> getListStringParam(String paramName){
		List<String> values = new ArrayList<String>(); 
		boolean last = false;
		int counter = 0;
		while (!last){
			String value = props.getProperty(paramName+counter);
			if (value == null){
				last = true;
			}
			else {
				values.add(value);
				counter++;
			}
		}
		log.debug("Array Param String " + paramName + " read " + counter + " values");
		return values;
	}

	public List<Integer> getListIntegerParam(String paramName){
		List<Integer> values = new ArrayList<Integer>(); 
		boolean last = false;
		int counter = 0;
		while (!last){
			String value = props.getProperty(paramName+counter);
			if (value == null){
				last = true;
			}
			else {
				values.add(Integer.parseInt(value));
				counter++;
			}
		}
		log.debug("Array Param String " + paramName + " read " + counter + " values");
		return values;
	}

	public List<Long> getListLongParam(String paramName){
		List<Long> values = new ArrayList<Long>(); 
		boolean last = false;
		int counter = 0;
		while (last){
			String value = props.getProperty(paramName+counter);
			if (value == null){
				last = false;
			}
			else {
				values.add(Long.parseLong(value));
				counter++;
			}
		}
		log.debug("Array Param String " + paramName + " read " + counter + " values");
		return values;
	}


}
