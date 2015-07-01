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
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "KtekQuestionnaireItemEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
		propOrder = {"idquestionnaireitem","namequestionnaireitem","desquestionnaireitem", "typequestionnaireitem","isrequired",
				 "valuedefault", "valuemin", "valuemax","typeparameter","typedatacapture", "codunit","typeanswer","formatanswerunique", "listanswers","value","values"})
public class KtekQuestionnaireItemEntity implements Serializable{
	
	private long idquestionnaireitem;
	private String namequestionnaireitem;
	private String desquestionnaireitem;	
	private short typequestionnaireitem;	
	private boolean isrequired;
	
	private float valuedefault;
	private float valuemin;
	private float valuemax;
	
	private String codunit;		
	
	private short typeanswer;
	private short formatanswerunique;
	
	private short typeparameter;
	private short typedatacapture;
		
	private List<KtekQuestionnaireAnswerEntity> listanswers;
	
	//FOR JAVASCRIPT MAPPING PURPOSES MVMV FRAMEWORK
	private String value;
	private List<String> values= new ArrayList();
	
	public KtekQuestionnaireItemEntity(){}

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

	/**
	 * @return the desquestionnaireitem
	 */
	public String getDesquestionnaireitem() {
		return desquestionnaireitem;
	}

	/**
	 * @param desquestionnaireitem the desquestionnaireitem to set
	 */
	public void setDesquestionnaireitem(String desquestionnaireitem) {
		this.desquestionnaireitem = desquestionnaireitem;
	}

	/**
	 * @return the typequestionnaireitem
	 */
	public short getTypequestionnaireitem() {
		return typequestionnaireitem;
	}

	/**
	 * @param typequestionnaireitem the typequestionnaireitem to set
	 */
	public void setTypequestionnaireitem(short typequestionnaireitem) {
		this.typequestionnaireitem = typequestionnaireitem;
	}

	/**
	 * @return the isrequired
	 */
	public boolean isIsrequired() {
		return isrequired;
	}

	/**
	 * @param isrequired the isrequired to set
	 */
	public void setIsrequired(boolean isrequired) {
		this.isrequired = isrequired;
	}
	
	/**
	 * @return the typeaswer
	 */
	public short getTypeanswer() {
		return typeanswer;
	}

	/**
	 * @param typeaswer the typeaswer to set
	 */
	public void setTypeaswer(short typeanswer) {
		this.typeanswer = typeanswer;
	}
	
	
	/**
	 * @return the valuedefault
	 */
	public float getValuedefault() {
		return valuedefault;
	}

	/**
	 * @param valuedefault the valuedefault to set
	 */
	public void setValuedefault(float valuedefault) {
		this.valuedefault = valuedefault;
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
	 * @param valuemax the valuemax to set
	 */
	public void setValuemax(float valuemax) {
		this.valuemax = valuemax;
	}

	/**
	 * @return the codunit
	 */
	public String getCodunit() {
		return codunit;
	}

	/**
	 * @param codunit the codunit to set
	 */
	public void setCodunit(String codunit) {
		this.codunit = codunit;
	}

	/**
	 * @return the formatanswerunique
	 */
	public short getFormatanswerunique() {
		return formatanswerunique;
	}

	/**
	 * @param formatanswerunique the formatanswerunique to set
	 */
	public void setFormatanswerunique(short formatanswerunique) {
		this.formatanswerunique = formatanswerunique;
	}

	/**
	 * @return the listanswers
	 */
	public List<KtekQuestionnaireAnswerEntity> getListanswers() {
		return listanswers;
	}

	/**
	 * @param listanswers the listanswers to set
	 */
	public void setListanswers(List<KtekQuestionnaireAnswerEntity> listanswers) {
		this.listanswers = listanswers;
	}

	/**
	 * @param typeanswer the typeanswer to set
	 */
	public void setTypeanswer(short typeanswer) {
		this.typeanswer = typeanswer;
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
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}

	/**
	 * @return the typeparameter
	 */
	public short getTypeparameter() {
		return typeparameter;
	}

	/**
	 * @param typeparameter the typeparameter to set
	 */
	public void setTypeparameter(short typeparameter) {
		this.typeparameter = typeparameter;
	}

	/**
	 * @return the typedatacapture
	 */
	public short getTypedatacapture() {
		return typedatacapture;
	}

	/**
	 * @param typedatacapture the typedatacapture to set
	 */
	public void setTypedatacapture(short typedatacapture) {
		this.typedatacapture = typedatacapture;
	}
	

	
}