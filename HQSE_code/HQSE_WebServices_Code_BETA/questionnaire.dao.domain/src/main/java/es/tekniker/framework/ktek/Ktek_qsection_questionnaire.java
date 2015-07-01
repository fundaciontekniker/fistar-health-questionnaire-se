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
public class Ktek_qsection_questionnaire implements Serializable {
	public Ktek_qsection_questionnaire() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_qsection_questionnaire))
			return false;
		Ktek_qsection_questionnaire ktek_qsection_questionnaire = (Ktek_qsection_questionnaire)aObj;
		if (getKtek_fk_idquestionnaire_ktek_pk_idquestionnaire() != ktek_qsection_questionnaire.getKtek_fk_idquestionnaire_ktek_pk_idquestionnaire())
			return false;
		if (getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection() != ktek_qsection_questionnaire.getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_fk_idquestionnaire_ktek_pk_idquestionnaire();
		hashcode = hashcode + (int) getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection();
		return hashcode;
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnaire ktek_fk_idquestionnaire;
	
	private int ktek_fk_idquestionnaireId;
	
	public void setKtek_fk_idquestionnaireId(int value) {
		this.ktek_fk_idquestionnaireId = value;
	}
	
	public int getKtek_fk_idquestionnaireId() {
		return ktek_fk_idquestionnaireId;
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnairesection ktek_fk_idquestionnairesection;
	
	private int ktek_fk_idquestionnairesectionId;
	
	public void setKtek_fk_idquestionnairesectionId(int value) {
		this.ktek_fk_idquestionnairesectionId = value;
	}
	
	public int getKtek_fk_idquestionnairesectionId() {
		return ktek_fk_idquestionnairesectionId;
	}
	
	private short sortorder;
	
	public void setSortorder(short value) {
		this.sortorder = value;
	}
	
	public short getSortorder() {
		return sortorder;
	}
	
	public void setKtek_fk_idquestionnaire(es.tekniker.framework.ktek.Ktek_questionnaire value) {
		this.ktek_fk_idquestionnaire = value;
		if (value != null) {
			ktek_fk_idquestionnaire_ktek_pk_idquestionnaire = value.getKtek_pk_idquestionnaire();
		}
		else {
			ktek_fk_idquestionnaire_ktek_pk_idquestionnaire = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaire getKtek_fk_idquestionnaire() {
		return ktek_fk_idquestionnaire;
	}
	
	public void setKtek_fk_idquestionnairesection(es.tekniker.framework.ktek.Ktek_questionnairesection value) {
		this.ktek_fk_idquestionnairesection = value;
		if (value != null) {
			ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = value.getKtek_pk_idquestionnairesection();
		}
		else {
			ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnairesection getKtek_fk_idquestionnairesection() {
		return ktek_fk_idquestionnairesection;
	}
	
	public String toString() {
		return String.valueOf(getKtek_fk_idquestionnaire_ktek_pk_idquestionnaire() + " " + getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection());
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
	
	
	private int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire;
	
	public void setKtek_fk_idquestionnaire_ktek_pk_idquestionnaire(int value) {
		this.ktek_fk_idquestionnaire_ktek_pk_idquestionnaire = value;
	}
	
	public int getKtek_fk_idquestionnaire_ktek_pk_idquestionnaire() {
		return ktek_fk_idquestionnaire_ktek_pk_idquestionnaire;
	}
	
	private int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	
	public void setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(int value) {
		this.ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = value;
	}
	
	public int getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection() {
		return ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	}
	
}
