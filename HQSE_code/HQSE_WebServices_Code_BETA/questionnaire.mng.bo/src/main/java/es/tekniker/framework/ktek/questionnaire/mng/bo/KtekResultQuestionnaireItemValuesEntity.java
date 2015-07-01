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
package es.tekniker.framework.ktek.questionnaire.mng.bo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "KtekResultQuestionnaireItemValuesEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"value", "date"})
public class KtekResultQuestionnaireItemValuesEntity implements Serializable{

	private String value;
	private long date;
	
	public KtekResultQuestionnaireItemValuesEntity(){
		
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param string the value to set
	 */
	public void setValue(String string) {
		this.value = string;
	}
	/**
	 * @return the date
	 */
	public long getDate() {
		return date;
	}
	/**
	 * @param l the date to set
	 */
	public void setDate(long l) {
		this.date = l;
	}
	
	
}
