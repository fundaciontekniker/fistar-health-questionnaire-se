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
package es.tekniker.framework.ktek;

import java.io.Serializable;
public class Ktek_questionnaire implements Serializable {
	public Ktek_questionnaire() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_questionnaire))
			return false;
		Ktek_questionnaire ktek_questionnaire = (Ktek_questionnaire)aObj;
		if (getKtek_pk_idquestionnaire() != ktek_questionnaire.getKtek_pk_idquestionnaire())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idquestionnaire();
		return hashcode;
	}
	
	private int ktek_pk_idquestionnaire;
	
	private String idpathology;
	
	private String ktek_uk_codquestionnaire;
	
	private String namequestionnaire;
	
	private String desquestionnaire;
	
	private String desinstructionsquestionnaire;
	
	private String desevaluation;
	
	private short ismultisection;
	
	private short typequestionnaire;
	
	private short typesortorder;
	
	private short typequestionnaireflow;
	
	private long datevalidfrom;
	
	private Long datevalidto;
	
	private long datecreation;
	
	private Short typemonitoringactivity;
	
	private Short periodicityunit;
	
	private Short periodictyvalue;
	
	private Long collectiontimefrom;
	
	private Long collectiontimeto;
	
	private Short completionintervalunit;
	
	private Short completionintervalvalue;
	
	private short isdeleted;
	
	private es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire;
	
	private java.util.Set ktek_qsection_questionnaire = new java.util.HashSet();
	
	private java.util.Set ktek_result_questionnaire = new java.util.HashSet();
	
	private java.util.Set ktek_userquestionnaire_planning = new java.util.HashSet();
	
	public void setKtek_pk_idquestionnaire(int value) {
		this.ktek_pk_idquestionnaire = value;
	}
	
	public int getKtek_pk_idquestionnaire() {
		return ktek_pk_idquestionnaire;
	}
	
	public int getORMID() {
		return getKtek_pk_idquestionnaire();
	}
	
	public void setIdpathology(String value) {
		this.idpathology = value;
	}
	
	public String getIdpathology() {
		return idpathology;
	}
	
	public void setKtek_uk_codquestionnaire(String value) {
		this.ktek_uk_codquestionnaire = value;
	}
	
	public String getKtek_uk_codquestionnaire() {
		return ktek_uk_codquestionnaire;
	}
	
	public void setNamequestionnaire(String value) {
		this.namequestionnaire = value;
	}
	
	public String getNamequestionnaire() {
		return namequestionnaire;
	}
	
	public void setDesquestionnaire(String value) {
		this.desquestionnaire = value;
	}
	
	public String getDesquestionnaire() {
		return desquestionnaire;
	}
	
	public void setDesinstructionsquestionnaire(String value) {
		this.desinstructionsquestionnaire = value;
	}
	
	public String getDesinstructionsquestionnaire() {
		return desinstructionsquestionnaire;
	}
	
	public void setDesevaluation(String value) {
		this.desevaluation = value;
	}
	
	public String getDesevaluation() {
		return desevaluation;
	}
	
	public void setIsmultisection(short value) {
		this.ismultisection = value;
	}
	
	public short getIsmultisection() {
		return ismultisection;
	}
	
	public void setTypequestionnaire(short value) {
		this.typequestionnaire = value;
	}
	
	public short getTypequestionnaire() {
		return typequestionnaire;
	}
	
	/**
	 * 
	 * 
	 *  
	 */
	public void setTypesortorder(short value) {
		this.typesortorder = value;
	}
	
	/**
	 * 
	 * 
	 *  
	 */
	public short getTypesortorder() {
		return typesortorder;
	}
	
	public void setTypequestionnaireflow(short value) {
		this.typequestionnaireflow = value;
	}
	
	public short getTypequestionnaireflow() {
		return typequestionnaireflow;
	}
	
	public void setDatevalidfrom(long value) {
		this.datevalidfrom = value;
	}
	
	public long getDatevalidfrom() {
		return datevalidfrom;
	}
	
	public void setDatevalidto(long value) {
		setDatevalidto(new Long(value));
	}
	
	public void setDatevalidto(Long value) {
		this.datevalidto = value;
	}
	
	public Long getDatevalidto() {
		return datevalidto;
	}
	
	public void setDatecreation(long value) {
		this.datecreation = value;
	}
	
	public long getDatecreation() {
		return datecreation;
	}
	
	public void setTypemonitoringactivity(short value) {
		setTypemonitoringactivity(new Short(value));
	}
	
	public void setTypemonitoringactivity(Short value) {
		this.typemonitoringactivity = value;
	}
	
	public Short getTypemonitoringactivity() {
		return typemonitoringactivity;
	}
	
	public void setPeriodicityunit(short value) {
		setPeriodicityunit(new Short(value));
	}
	
	public void setPeriodicityunit(Short value) {
		this.periodicityunit = value;
	}
	
	public Short getPeriodicityunit() {
		return periodicityunit;
	}
	
	public void setPeriodictyvalue(short value) {
		setPeriodictyvalue(new Short(value));
	}
	
	public void setPeriodictyvalue(Short value) {
		this.periodictyvalue = value;
	}
	
	public Short getPeriodictyvalue() {
		return periodictyvalue;
	}
	
	public void setCollectiontimefrom(long value) {
		setCollectiontimefrom(new Long(value));
	}
	
	public void setCollectiontimefrom(Long value) {
		this.collectiontimefrom = value;
	}
	
	public Long getCollectiontimefrom() {
		return collectiontimefrom;
	}
	
	public void setCollectiontimeto(long value) {
		setCollectiontimeto(new Long(value));
	}
	
	public void setCollectiontimeto(Long value) {
		this.collectiontimeto = value;
	}
	
	public Long getCollectiontimeto() {
		return collectiontimeto;
	}
	
	public void setCompletionintervalunit(short value) {
		setCompletionintervalunit(new Short(value));
	}
	
	public void setCompletionintervalunit(Short value) {
		this.completionintervalunit = value;
	}
	
	public Short getCompletionintervalunit() {
		return completionintervalunit;
	}
	
	public void setCompletionintervalvalue(short value) {
		setCompletionintervalvalue(new Short(value));
	}
	
	public void setCompletionintervalvalue(Short value) {
		this.completionintervalvalue = value;
	}
	
	public Short getCompletionintervalvalue() {
		return completionintervalvalue;
	}
	
	public void setIsdeleted(short value) {
		this.isdeleted = value;
	}
	
	public short getIsdeleted() {
		return isdeleted;
	}
	
	public void setKtek_formatquestionnaire(es.tekniker.framework.ktek.Ktek_formatquestionnaire value) {
		this.ktek_formatquestionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_formatquestionnaire getKtek_formatquestionnaire() {
		return ktek_formatquestionnaire;
	}
	
	public void setKtek_qsection_questionnaire(java.util.Set value) {
		this.ktek_qsection_questionnaire = value;
	}
	
	public java.util.Set getKtek_qsection_questionnaire() {
		return ktek_qsection_questionnaire;
	}
	
	
	public void setKtek_result_questionnaire(java.util.Set value) {
		this.ktek_result_questionnaire = value;
	}
	
	public java.util.Set getKtek_result_questionnaire() {
		return ktek_result_questionnaire;
	}
	
	
	public void setKtek_userquestionnaire_planning(java.util.Set value) {
		this.ktek_userquestionnaire_planning = value;
	}
	
	public java.util.Set getKtek_userquestionnaire_planning() {
		return ktek_userquestionnaire_planning;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idquestionnaire());
	}
	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
