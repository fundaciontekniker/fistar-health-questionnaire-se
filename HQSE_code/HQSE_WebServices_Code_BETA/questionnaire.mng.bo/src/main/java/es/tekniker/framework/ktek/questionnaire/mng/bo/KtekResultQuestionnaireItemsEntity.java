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


@XmlRootElement(name = "KtekResultQuestionnaireItemsEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaireitem", "codquestionnaireitem","namequestionnaireitem","valuemin", "valuemax" ,"values"})
public class KtekResultQuestionnaireItemsEntity implements Serializable{

	private long idquestionnaireitem;
	private String codquestionnaireitem;
	private String namequestionnaireitem;
	private float valuemin;
	private float valuemax;
	
		
	private List<KtekResultQuestionnaireItemValuesEntity> values;
	
	public KtekResultQuestionnaireItemsEntity(){}

	/**
	 * @return the idquestionnaireitem
	 */
	public long getIdquestionnaireitem() {
		return idquestionnaireitem;
	}

	/**
	 * @param idquestionnaireitem the idquestionnaireitem to set
	 */
	public void setIdquestionnaireitem(long idquestionnaireitem) {
		this.idquestionnaireitem = idquestionnaireitem;
	}

	/**
	 * @return the codquestionnaireitem
	 */
	public String getCodquestionnaireitem() {
		return codquestionnaireitem;
	}

	/**
	 * @param codquestionnaireitem the codquestionnaireitem to set
	 */
	public void setCodquestionnaireitem(String codquestionnaireitem) {
		this.codquestionnaireitem = codquestionnaireitem;
	}

	/**
	 * @return the valuemin
	 */
	public float getValuemin() {
		return valuemin;
	}

	/**
	 * @param valuemin the valuemin to set
	 */
	public void setValuemin(float valuemin) {
		this.valuemin = valuemin;
	}

	/**
	 * @return the valuemax
	 */
	public float getValuemax() {
		return valuemax;
	}

	/**
	 * @param f the valuemax to set
	 */
	public void setValuemax(float f) {
		this.valuemax = f;
	}

	/**
	 * @return the values
	 */
	public List<KtekResultQuestionnaireItemValuesEntity> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<KtekResultQuestionnaireItemValuesEntity> values) {
		this.values = values;
	}

	/**
	 * @return the namequestionnaireitem
	 */
	public String getNamequestionnaireitem() {
		return namequestionnaireitem;
	}

	/**
	 * @param namequestionnaireitem the namequestionnaireitem to set
	 */
	public void setNamequestionnaireitem(String namequestionnaireitem) {
		this.namequestionnaireitem = namequestionnaireitem;
	}

	
	
		
}
