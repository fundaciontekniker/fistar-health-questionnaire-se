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


@XmlRootElement(name = "KtekQuestionnaireConfigurationEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"formatpagination","formatintegerparameter", "formatdecimalparameter","formatsetuniqueitem", "formatsetmultitem"})
public class KtekQuestionnaireConfigurationEntity implements Serializable{

	
	public KtekQuestionnaireConfigurationEntity(){}
	
	private short formatpagination;
	private short formatintegerparameter;
	private short formatdecimalparameter;	
	private short formatsetuniqueitem;	
	private short formatsetmultitem;
	
	/**
	 * @return the formatpagination
	 */
	public short getFormatpagination() {
		return formatpagination;
	}
	/**
	 * @param formatpagination the formatpagination to set
	 */
	public void setFormatpagination(short formatpagination) {
		this.formatpagination = formatpagination;
	}	
	/**
	 * @return the formatintegerparameter
	 */
	public short getFormatintegerparameter() {
		return formatintegerparameter;
	}
	/**
	 * @param formatintegerparameter the formatintegerparameter to set
	 */
	public void setFormatintegerparameter(short formatintegerparameter) {
		this.formatintegerparameter = formatintegerparameter;
	}
	/**
	 * @return the formatdecimalparameter
	 */
	public short getFormatdecimalparameter() {
		return formatdecimalparameter;
	}
	/**
	 * @param formatdecimalparameter the formatdecimalparameter to set
	 */
	public void setFormatdecimalparameter(short formatdecimalparameter) {
		this.formatdecimalparameter = formatdecimalparameter;
	}
	/**
	 * @return the formatsetuniqueitem
	 */
	public short getFormatsetuniqueitem() {
		return formatsetuniqueitem;
	}
	/**
	 * @param formatsetuniqueitem the formatsetuniqueitem to set
	 */
	public void setFormatsetuniqueitem(short formatsetuniqueitem) {
		this.formatsetuniqueitem = formatsetuniqueitem;
	}
	/**
	 * @return the formatsetmultitem
	 */
	public short getFormatsetmultitem() {
		return formatsetmultitem;
	}
	/**
	 * @param formatsetmultitem the formatsetmultitem to set
	 */
	public void setFormatsetmultitem(short formatsetmultitem) {
		this.formatsetmultitem = formatsetmultitem;
	}
	
}
