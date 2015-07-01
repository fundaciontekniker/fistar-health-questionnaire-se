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
public class Ktek_language implements Serializable {
	public Ktek_language() {
	}
	
	private int ktek_pk_idlanguage;
	
	private String ktek_uk_codlanguage;
	
	private String deslanguage;
	
	private short isdefault;
	
	private java.util.Set ktek_tpsettings = new java.util.HashSet();
	
	private java.util.Set ktek_translation_text = new java.util.HashSet();
	
	public void setKtek_pk_idlanguage(int value) {
		this.ktek_pk_idlanguage = value;
	}
	
	public int getKtek_pk_idlanguage() {
		return ktek_pk_idlanguage;
	}
	
	public int getORMID() {
		return getKtek_pk_idlanguage();
	}
	
	public void setKtek_uk_codlanguage(String value) {
		this.ktek_uk_codlanguage = value;
	}
	
	public String getKtek_uk_codlanguage() {
		return ktek_uk_codlanguage;
	}
	
	public void setDeslanguage(String value) {
		this.deslanguage = value;
	}
	
	public String getDeslanguage() {
		return deslanguage;
	}
	
	public void setIsdefault(short value) {
		this.isdefault = value;
	}
	
	public short getIsdefault() {
		return isdefault;
	}
	
	public void setKtek_tpsettings(java.util.Set value) {
		this.ktek_tpsettings = value;
	}
	
	public java.util.Set getKtek_tpsettings() {
		return ktek_tpsettings;
	}
	
	
	public void setKtek_translation_text(java.util.Set value) {
		this.ktek_translation_text = value;
	}
	
	public java.util.Set getKtek_translation_text() {
		return ktek_translation_text;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idlanguage());
	}
	
}
