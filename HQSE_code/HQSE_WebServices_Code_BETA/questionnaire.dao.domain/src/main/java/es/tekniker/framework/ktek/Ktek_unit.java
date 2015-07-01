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
public class Ktek_unit implements Serializable {
	public Ktek_unit() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_unit))
			return false;
		Ktek_unit ktek_unit = (Ktek_unit)aObj;
		if (getKtek_pk_idunit() != ktek_unit.getKtek_pk_idunit())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idunit();
		return hashcode;
	}
	
	private int ktek_pk_idunit;
	
	private String ktek_uk_codunit;
	
	private java.util.Set ktek_unit_parameter = new java.util.HashSet();
	
	public void setKtek_pk_idunit(int value) {
		this.ktek_pk_idunit = value;
	}
	
	public int getKtek_pk_idunit() {
		return ktek_pk_idunit;
	}
	
	public int getORMID() {
		return getKtek_pk_idunit();
	}
	
	public void setKtek_uk_codunit(String value) {
		this.ktek_uk_codunit = value;
	}
	
	public String getKtek_uk_codunit() {
		return ktek_uk_codunit;
	}
	
	public void setKtek_unit_parameter(java.util.Set value) {
		this.ktek_unit_parameter = value;
	}
	
	public java.util.Set getKtek_unit_parameter() {
		return ktek_unit_parameter;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idunit());
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
