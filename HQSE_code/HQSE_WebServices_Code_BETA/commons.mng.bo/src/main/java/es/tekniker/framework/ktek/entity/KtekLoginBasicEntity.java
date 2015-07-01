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
package es.tekniker.framework.ktek.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * Class used as input parameter on login service
 */

@XmlRootElement(name = "KtekLoginBasicEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"key", "password"})
public class KtekLoginBasicEntity implements Serializable{

	private String key;
	private String password;
	
	public boolean isRequiredDataDefined(){
		boolean boolOK=true;
		
		if(key.equals(""))
			boolOK=false;
		if(password.equals(""))
			boolOK=false;
		
		return boolOK;		
	}
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the reference to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString(){
		String sData="key:" + key + " password:" + password ;		
		return sData;		
	}	
	
}
