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
public class Ktek_result_questionnairesection implements Serializable {
	public Ktek_result_questionnairesection() {
	}
	
	private int ktek_pk_idresultquestionnairesection;
	
	private es.tekniker.framework.ktek.Ktek_questionnairesection ktek_fk_idquestionnairesection;
	
	private es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_fk_idresultquestionnaire;
	
	private short evaluationscorequestionnairesection;
	
	private java.util.Set ktek_result_questionnaireitem = new java.util.HashSet();
	
	public void setKtek_pk_idresultquestionnairesection(int value) {
		this.ktek_pk_idresultquestionnairesection = value;
	}
	
	public int getKtek_pk_idresultquestionnairesection() {
		return ktek_pk_idresultquestionnairesection;
	}
	
	public int getORMID() {
		return getKtek_pk_idresultquestionnairesection();
	}
	
	public void setEvaluationscorequestionnairesection(short value) {
		this.evaluationscorequestionnairesection = value;
	}
	
	public short getEvaluationscorequestionnairesection() {
		return evaluationscorequestionnairesection;
	}
	
	public void setKtek_fk_idquestionnairesection(es.tekniker.framework.ktek.Ktek_questionnairesection value) {
		this.ktek_fk_idquestionnairesection = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnairesection getKtek_fk_idquestionnairesection() {
		return ktek_fk_idquestionnairesection;
	}
	
	public void setKtek_fk_idresultquestionnaire(es.tekniker.framework.ktek.Ktek_result_questionnaire value) {
		this.ktek_fk_idresultquestionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_result_questionnaire getKtek_fk_idresultquestionnaire() {
		return ktek_fk_idresultquestionnaire;
	}
	
	public void setKtek_result_questionnaireitem(java.util.Set value) {
		this.ktek_result_questionnaireitem = value;
	}
	
	public java.util.Set getKtek_result_questionnaireitem() {
		return ktek_result_questionnaireitem;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idresultquestionnairesection());
	}
	
}
