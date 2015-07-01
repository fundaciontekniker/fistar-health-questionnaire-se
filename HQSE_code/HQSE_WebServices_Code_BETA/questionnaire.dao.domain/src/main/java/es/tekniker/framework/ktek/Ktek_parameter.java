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
public class Ktek_parameter implements Serializable {
	public Ktek_parameter() {
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitem;
	
	private int ktek_fk_idquestionnaireitemId;
	
	public void setKtek_fk_idquestionnaireitemId(int value) {
		this.ktek_fk_idquestionnaireitemId = value;
	}
	
	public int getKtek_fk_idquestionnaireitemId() {
		return ktek_fk_idquestionnaireitemId;
	}
	
	private short typeparameter;
	
	private short typedatacapture;
	
	private Float valuedefault;
	
	private float valuemin;
	
	private float valuemax;
	
	private java.util.Set ktek_unit_parameter = new java.util.HashSet();
	
	public void setTypeparameter(short value) {
		this.typeparameter = value;
	}
	
	public short getTypeparameter() {
		return typeparameter;
	}
	
	public void setTypedatacapture(short value) {
		this.typedatacapture = value;
	}
	
	public short getTypedatacapture() {
		return typedatacapture;
	}
	
	public void setValuedefault(float value) {
		setValuedefault(new Float(value));
	}
	
	public void setValuedefault(Float value) {
		this.valuedefault = value;
	}
	
	public Float getValuedefault() {
		return valuedefault;
	}
	
	public void setValuemin(float value) {
		this.valuemin = value;
	}
	
	public float getValuemin() {
		return valuemin;
	}
	
	public void setValuemax(float value) {
		this.valuemax = value;
	}
	
	public float getValuemax() {
		return valuemax;
	}
	
	public void setKtek_fk_idquestionnaireitem(es.tekniker.framework.ktek.Ktek_questionnaireitem value) {
		this.ktek_fk_idquestionnaireitem = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaireitem getKtek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaireitem getORMID() {
		return getKtek_fk_idquestionnaireitem();
	}
	
	public void setKtek_unit_parameter(java.util.Set value) {
		this.ktek_unit_parameter = value;
	}
	
	public java.util.Set getKtek_unit_parameter() {
		return ktek_unit_parameter;
	}
	
	
	public String toString() {
		return String.valueOf(((getKtek_fk_idquestionnaireitem() == null) ? "" : String.valueOf(getKtek_fk_idquestionnaireitem().getORMID())));
	}
	
}
