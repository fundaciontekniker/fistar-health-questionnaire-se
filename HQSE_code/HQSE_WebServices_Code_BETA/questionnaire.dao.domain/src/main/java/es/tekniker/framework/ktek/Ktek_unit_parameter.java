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
public class Ktek_unit_parameter implements Serializable {
	public Ktek_unit_parameter() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_unit_parameter))
			return false;
		Ktek_unit_parameter ktek_unit_parameter = (Ktek_unit_parameter)aObj;
		if (getKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem() != ktek_unit_parameter.getKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem())
			return false;
		if (getKtek_fk_idunit_ktek_pk_idunit() != ktek_unit_parameter.getKtek_fk_idunit_ktek_pk_idunit())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem();
		hashcode = hashcode + (int) getKtek_fk_idunit_ktek_pk_idunit();
		return hashcode;
	}
	
	private es.tekniker.framework.ktek.Ktek_parameter ktek_fk_idquestionnaireitem;
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitemId;
	
	private int ktek_fk_idquestionnaireitemIdId;
	
	public void setKtek_fk_idquestionnaireitemIdId(int value) {
		this.ktek_fk_idquestionnaireitemIdId = value;
	}
	
	public int getKtek_fk_idquestionnaireitemIdId() {
		return ktek_fk_idquestionnaireitemIdId;
	}
	
	public void setKtek_fk_idquestionnaireitemId(es.tekniker.framework.ktek.Ktek_questionnaireitem value) {
		this.ktek_fk_idquestionnaireitemId = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaireitem getKtek_fk_idquestionnaireitemId() {
		return ktek_fk_idquestionnaireitemId;
	}
	
	private es.tekniker.framework.ktek.Ktek_unit ktek_fk_idunit;
	
	private int ktek_fk_idunitId;
	
	public void setKtek_fk_idunitId(int value) {
		this.ktek_fk_idunitId = value;
	}
	
	public int getKtek_fk_idunitId() {
		return ktek_fk_idunitId;
	}
	
	private float valueconversion;
	
	private short isdefault;
	
	public void setValueconversion(float value) {
		this.valueconversion = value;
	}
	
	public float getValueconversion() {
		return valueconversion;
	}
	
	public void setIsdefault(short value) {
		this.isdefault = value;
	}
	
	public short getIsdefault() {
		return isdefault;
	}
	
	public void setKtek_fk_idquestionnaireitem(es.tekniker.framework.ktek.Ktek_parameter value) {
		this.ktek_fk_idquestionnaireitem = value;
		if (value != null) {
			ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = value.getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem();
		}
		else {
			ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_parameter getKtek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem;
	}
	
	public void setKtek_fk_idunit(es.tekniker.framework.ktek.Ktek_unit value) {
		this.ktek_fk_idunit = value;
		if (value != null) {
			ktek_fk_idunit_ktek_pk_idunit = value.getKtek_pk_idunit();
		}
		else {
			ktek_fk_idunit_ktek_pk_idunit = 0;
		}
	}
	
	public es.tekniker.framework.ktek.Ktek_unit getKtek_fk_idunit() {
		return ktek_fk_idunit;
	}
	
	public String toString() {
		return String.valueOf(getKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem() + " " + getKtek_fk_idunit_ktek_pk_idunit());
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
	
	
	private int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem;
	
	public void setKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem(int value) {
		this.ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = value;
	}
	
	public int getKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem;
	}
	
	private int ktek_fk_idunit_ktek_pk_idunit;
	
	public void setKtek_fk_idunit_ktek_pk_idunit(int value) {
		this.ktek_fk_idunit_ktek_pk_idunit = value;
	}
	
	public int getKtek_fk_idunit_ktek_pk_idunit() {
		return ktek_fk_idunit_ktek_pk_idunit;
	}
	
}
