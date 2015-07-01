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
public class Ktek_qitem_section implements Serializable {
	public Ktek_qitem_section() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_qitem_section))
			return false;
		Ktek_qitem_section ktek_qitem_section = (Ktek_qitem_section)aObj;
		if (getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection() != ktek_qitem_section.getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection())
			return false;
		if (getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem() != ktek_qitem_section.getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection();
		hashcode = hashcode + (int) getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem();
		return hashcode;
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnairesection ktek_fk_idquestionnairesection;
	
	private int ktek_fk_idquestionnairesectionId;
	
	public void setKtek_fk_idquestionnairesectionId(int value) {
		this.ktek_fk_idquestionnairesectionId = value;
	}
	
	public int getKtek_fk_idquestionnairesectionId() {
		return ktek_fk_idquestionnairesectionId;
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitem;
	
	private int ktek_fk_idquestionnaireitemId;
	
	public void setKtek_fk_idquestionnaireitemId(int value) {
		this.ktek_fk_idquestionnaireitemId = value;
	}
	
	public int getKtek_fk_idquestionnaireitemId() {
		return ktek_fk_idquestionnaireitemId;
	}
	
	private short sortorder;
	
	public void setSortorder(short value) {
		this.sortorder = value;
	}
	
	public short getSortorder() {
		return sortorder;
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
	
	public void setKtek_fk_idquestionnaireitem(es.tekniker.framework.ktek.Ktek_questionnaireitem value) {
		this.ktek_fk_idquestionnaireitem = value;
		if (value != null) {
			ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = value.getKtek_pk_idquestionnaireitem();
		}
		else {
			ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaireitem getKtek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem;
	}
	
	public String toString() {
		return String.valueOf(getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection() + " " + getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem());
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
	
	
	private int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	
	public void setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(int value) {
		this.ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = value;
	}
	
	public int getKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection() {
		return ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	}
	
	private int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	
	public void setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(int value) {
		this.ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = value;
	}
	
	public int getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	}
	
}
