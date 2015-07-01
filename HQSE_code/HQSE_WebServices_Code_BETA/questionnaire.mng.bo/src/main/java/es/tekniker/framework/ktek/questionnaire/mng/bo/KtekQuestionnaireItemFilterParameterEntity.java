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
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "KtekQuestionnaireItemFilterParameterEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaireitem", "idresultquestionnaireitem","value", "min","max"})
public class KtekQuestionnaireItemFilterParameterEntity implements Serializable{

	private int idquestionnaireitem;
	private int  idresultquestionnaireitem;
	private String value;
	private int min;
	private int max;
	
	public KtekQuestionnaireItemFilterParameterEntity(){}

	/**
	 * @return the idquestionnaireitem
	 */
	public int getIdquestionnaireitem() {
		return idquestionnaireitem;
	}

	/**
	 * @param idquestionnaireitem the idquestionnaireitem to set
	 */
	public void setIdquestionnaireitem(int idquestionnaireitem) {
		this.idquestionnaireitem = idquestionnaireitem;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the idresultquestionnaireitem
	 */
	public int getIdresultquestionnaireitem() {
		return idresultquestionnaireitem;
	}

	/**
	 * @param idresultquestionnaireitem the idresultquestionnaireitem to set
	 */
	public void setIdresultquestionnaireitem(int idresultquestionnaireitem) {
		this.idresultquestionnaireitem = idresultquestionnaireitem;
	}

	
}
