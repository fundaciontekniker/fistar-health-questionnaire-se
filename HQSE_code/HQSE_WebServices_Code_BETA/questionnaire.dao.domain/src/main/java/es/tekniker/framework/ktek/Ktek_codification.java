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
public class Ktek_codification implements Serializable {
	public Ktek_codification() {
	}
	
	private int ktek_pk_idcodification;
	
	private String codcodification;
	
	private String descodification;
	
	private java.util.Set ktek_questionnaireitem_codification = new java.util.HashSet();
	
	public void setKtek_pk_idcodification(int value) {
		this.ktek_pk_idcodification = value;
	}
	
	public int getKtek_pk_idcodification() {
		return ktek_pk_idcodification;
	}
	
	public int getORMID() {
		return getKtek_pk_idcodification();
	}
	
	public void setCodcodification(String value) {
		this.codcodification = value;
	}
	
	public String getCodcodification() {
		return codcodification;
	}
	
	public void setDescodification(String value) {
		this.descodification = value;
	}
	
	public String getDescodification() {
		return descodification;
	}
	
	public void setKtek_questionnaireitem_codification(java.util.Set value) {
		this.ktek_questionnaireitem_codification = value;
	}
	
	public java.util.Set getKtek_questionnaireitem_codification() {
		return ktek_questionnaireitem_codification;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idcodification());
	}
	
}
