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
public class Ktek_questionnaireitem implements Serializable {
	public Ktek_questionnaireitem() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_questionnaireitem))
			return false;
		Ktek_questionnaireitem ktek_questionnaireitem = (Ktek_questionnaireitem)aObj;
		if (getKtek_pk_idquestionnaireitem() != ktek_questionnaireitem.getKtek_pk_idquestionnaireitem())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idquestionnaireitem();
		return hashcode;
	}
	
	private int ktek_pk_idquestionnaireitem;
	
	private String ktek_uk_codquestionnaireitem;
	
	private String namequestionnaireitem;
	
	private String desquestionnaireitem;
	
	private short typequestionnaireitem;
	
	private short isrequired;
	
	private short isdeleted;
	
	private es.tekniker.framework.ktek.Ktek_parameter ktek_parameter;
	
	private java.util.Set ktek_qitem_section = new java.util.HashSet();
	
	private es.tekniker.framework.ktek.Ktek_question ktek_question;
	
	private java.util.Set ktek_questionnaireitem_codification = new java.util.HashSet();
	
	private java.util.Set ktek_result_questionnaireitem = new java.util.HashSet();
	
	public void setKtek_pk_idquestionnaireitem(int value) {
		this.ktek_pk_idquestionnaireitem = value;
	}
	
	public int getKtek_pk_idquestionnaireitem() {
		return ktek_pk_idquestionnaireitem;
	}
	
	public int getORMID() {
		return getKtek_pk_idquestionnaireitem();
	}
	
	public void setKtek_uk_codquestionnaireitem(String value) {
		this.ktek_uk_codquestionnaireitem = value;
	}
	
	public String getKtek_uk_codquestionnaireitem() {
		return ktek_uk_codquestionnaireitem;
	}
	
	public void setNamequestionnaireitem(String value) {
		this.namequestionnaireitem = value;
	}
	
	public String getNamequestionnaireitem() {
		return namequestionnaireitem;
	}
	
	public void setDesquestionnaireitem(String value) {
		this.desquestionnaireitem = value;
	}
	
	public String getDesquestionnaireitem() {
		return desquestionnaireitem;
	}
	
	public void setTypequestionnaireitem(short value) {
		this.typequestionnaireitem = value;
	}
	
	public short getTypequestionnaireitem() {
		return typequestionnaireitem;
	}
	
	public void setIsrequired(short value) {
		this.isrequired = value;
	}
	
	public short getIsrequired() {
		return isrequired;
	}
	
	public void setIsdeleted(short value) {
		this.isdeleted = value;
	}
	
	public short getIsdeleted() {
		return isdeleted;
	}
	
	public void setKtek_parameter(es.tekniker.framework.ktek.Ktek_parameter value) {
		this.ktek_parameter = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_parameter getKtek_parameter() {
		return ktek_parameter;
	}
	
	public void setKtek_qitem_section(java.util.Set value) {
		this.ktek_qitem_section = value;
	}
	
	public java.util.Set getKtek_qitem_section() {
		return ktek_qitem_section;
	}
	
	
	public void setKtek_question(es.tekniker.framework.ktek.Ktek_question value) {
		this.ktek_question = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_question getKtek_question() {
		return ktek_question;
	}
	
	public void setKtek_questionnaireitem_codification(java.util.Set value) {
		this.ktek_questionnaireitem_codification = value;
	}
	
	public java.util.Set getKtek_questionnaireitem_codification() {
		return ktek_questionnaireitem_codification;
	}
	
	
	public void setKtek_result_questionnaireitem(java.util.Set value) {
		this.ktek_result_questionnaireitem = value;
	}
	
	public java.util.Set getKtek_result_questionnaireitem() {
		return ktek_result_questionnaireitem;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idquestionnaireitem());
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
