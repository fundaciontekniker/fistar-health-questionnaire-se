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
public class Ktek_questionnaireitem_codification implements Serializable {
	public Ktek_questionnaireitem_codification() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_questionnaireitem_codification))
			return false;
		Ktek_questionnaireitem_codification ktek_questionnaireitem_codification = (Ktek_questionnaireitem_codification)aObj;
		if (getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem() != ktek_questionnaireitem_codification.getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem())
			return false;
		if (getKtek_fk_idcodification_ktek_pk_idcodification() != ktek_questionnaireitem_codification.getKtek_fk_idcodification_ktek_pk_idcodification())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem();
		hashcode = hashcode + (int) getKtek_fk_idcodification_ktek_pk_idcodification();
		return hashcode;
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitem;
	
	private int ktek_fk_idquestionnaireitemId;
	
	public void setKtek_fk_idquestionnaireitemId(int value) {
		this.ktek_fk_idquestionnaireitemId = value;
	}
	
	public int getKtek_fk_idquestionnaireitemId() {
		return ktek_fk_idquestionnaireitemId;
	}
	
	private es.tekniker.framework.ktek.Ktek_codification ktek_fk_idcodification;
	
	private int ktek_fk_idcodificationId;
	
	public void setKtek_fk_idcodificationId(int value) {
		this.ktek_fk_idcodificationId = value;
	}
	
	public int getKtek_fk_idcodificationId() {
		return ktek_fk_idcodificationId;
	}
	
	private String codquestionnaireitem;
	
	public void setCodquestionnaireitem(String value) {
		this.codquestionnaireitem = value;
	}
	
	public String getCodquestionnaireitem() {
		return codquestionnaireitem;
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
	
	public void setKtek_fk_idcodification(es.tekniker.framework.ktek.Ktek_codification value) {
		this.ktek_fk_idcodification = value;
		if (value != null) {
			ktek_fk_idcodification_ktek_pk_idcodification = value.getKtek_pk_idcodification();
		}
		else {
			ktek_fk_idcodification_ktek_pk_idcodification = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_codification getKtek_fk_idcodification() {
		return ktek_fk_idcodification;
	}
	
	public String toString() {
		return String.valueOf(getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem() + " " + getKtek_fk_idcodification_ktek_pk_idcodification());
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
	
	
	private int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	
	public void setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(int value) {
		this.ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = value;
	}
	
	public int getKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	}
	
	private int ktek_fk_idcodification_ktek_pk_idcodification;
	
	public void setKtek_fk_idcodification_ktek_pk_idcodification(int value) {
		this.ktek_fk_idcodification_ktek_pk_idcodification = value;
	}
	
	public int getKtek_fk_idcodification_ktek_pk_idcodification() {
		return ktek_fk_idcodification_ktek_pk_idcodification;
	}
	
}
