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
public class Ktek_questionnairesection implements Serializable {
	public Ktek_questionnairesection() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_questionnairesection))
			return false;
		Ktek_questionnairesection ktek_questionnairesection = (Ktek_questionnairesection)aObj;
		if (getKtek_pk_idquestionnairesection() != ktek_questionnairesection.getKtek_pk_idquestionnairesection())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idquestionnairesection();
		return hashcode;
	}
	
	private int ktek_pk_idquestionnairesection;
	
	private String namequestionnairesection;
	
	private String desquestionnairesection;
	
	private String desquestionnairesectioninstructions;
	
	private java.util.Set ktek_qitem_section = new java.util.HashSet();
	
	private java.util.Set ktek_qsection_questionnaire = new java.util.HashSet();
	
	private java.util.Set ktek_result_questionnairesection = new java.util.HashSet();
	
	public void setKtek_pk_idquestionnairesection(int value) {
		this.ktek_pk_idquestionnairesection = value;
	}
	
	public int getKtek_pk_idquestionnairesection() {
		return ktek_pk_idquestionnairesection;
	}
	
	public int getORMID() {
		return getKtek_pk_idquestionnairesection();
	}
	
	public void setNamequestionnairesection(String value) {
		this.namequestionnairesection = value;
	}
	
	public String getNamequestionnairesection() {
		return namequestionnairesection;
	}
	
	public void setDesquestionnairesection(String value) {
		this.desquestionnairesection = value;
	}
	
	public String getDesquestionnairesection() {
		return desquestionnairesection;
	}
	
	public void setDesquestionnairesectioninstructions(String value) {
		this.desquestionnairesectioninstructions = value;
	}
	
	public String getDesquestionnairesectioninstructions() {
		return desquestionnairesectioninstructions;
	}
	
	public void setKtek_qitem_section(java.util.Set value) {
		this.ktek_qitem_section = value;
	}
	
	public java.util.Set getKtek_qitem_section() {
		return ktek_qitem_section;
	}
	
	
	public void setKtek_qsection_questionnaire(java.util.Set value) {
		this.ktek_qsection_questionnaire = value;
	}
	
	public java.util.Set getKtek_qsection_questionnaire() {
		return ktek_qsection_questionnaire;
	}
	
	
	public void setKtek_result_questionnairesection(java.util.Set value) {
		this.ktek_result_questionnairesection = value;
	}
	
	public java.util.Set getKtek_result_questionnairesection() {
		return ktek_result_questionnairesection;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idquestionnairesection());
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
