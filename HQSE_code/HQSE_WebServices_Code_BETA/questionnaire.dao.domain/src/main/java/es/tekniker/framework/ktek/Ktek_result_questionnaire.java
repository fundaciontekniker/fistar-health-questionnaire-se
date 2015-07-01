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
public class Ktek_result_questionnaire implements Serializable {
	public Ktek_result_questionnaire() {
	}
	
	private int ktek_pk_idresultquestionnaire;
	
	private String codtelecareprogram;
	
	private String coduserid;
	
	private es.tekniker.framework.ktek.Ktek_questionnaire ktek_fk_idquestionnaire;
	
	private es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_fk_iduserquestionnaireplanning;
	
	private short evaluationscorequestionnaire;
	
	private long resultcreation;
	
	private java.util.Set ktek_result_questionnairesection = new java.util.HashSet();
	
	public void setKtek_pk_idresultquestionnaire(int value) {
		this.ktek_pk_idresultquestionnaire = value;
	}
	
	public int getKtek_pk_idresultquestionnaire() {
		return ktek_pk_idresultquestionnaire;
	}
	
	public int getORMID() {
		return getKtek_pk_idresultquestionnaire();
	}
	
	public void setCodtelecareprogram(String value) {
		this.codtelecareprogram = value;
	}
	
	public String getCodtelecareprogram() {
		return codtelecareprogram;
	}
	
	public void setCoduserid(String value) {
		this.coduserid = value;
	}
	
	public String getCoduserid() {
		return coduserid;
	}
	
	public void setEvaluationscorequestionnaire(short value) {
		this.evaluationscorequestionnaire = value;
	}
	
	public short getEvaluationscorequestionnaire() {
		return evaluationscorequestionnaire;
	}
	
	public void setResultcreation(long value) {
		this.resultcreation = value;
	}
	
	public long getResultcreation() {
		return resultcreation;
	}
	
	public void setKtek_fk_idquestionnaire(es.tekniker.framework.ktek.Ktek_questionnaire value) {
		this.ktek_fk_idquestionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaire getKtek_fk_idquestionnaire() {
		return ktek_fk_idquestionnaire;
	}
	
	public void setKtek_fk_iduserquestionnaireplanning(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning value) {
		this.ktek_fk_iduserquestionnaireplanning = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_userquestionnaire_planning getKtek_fk_iduserquestionnaireplanning() {
		return ktek_fk_iduserquestionnaireplanning;
	}
	
	public void setKtek_result_questionnairesection(java.util.Set value) {
		this.ktek_result_questionnairesection = value;
	}
	
	public java.util.Set getKtek_result_questionnairesection() {
		return ktek_result_questionnairesection;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idresultquestionnaire());
	}
	
}
