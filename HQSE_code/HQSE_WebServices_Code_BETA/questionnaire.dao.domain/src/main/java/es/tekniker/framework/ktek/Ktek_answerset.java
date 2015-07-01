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
public class Ktek_answerset implements Serializable {
	public Ktek_answerset() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_answerset))
			return false;
		Ktek_answerset ktek_answerset = (Ktek_answerset)aObj;
		if (getKtek_pk_idanswerset() != ktek_answerset.getKtek_pk_idanswerset())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idanswerset();
		return hashcode;
	}
	
	private int ktek_pk_idanswerset;
	
	private String codanswersetl;
	
	private String nameanswerset;
	
	private java.util.Set ktek_fk_idanswer = new java.util.HashSet();
	
	private java.util.Set ktek_question = new java.util.HashSet();
	
	public void setKtek_pk_idanswerset(int value) {
		this.ktek_pk_idanswerset = value;
	}
	
	public int getKtek_pk_idanswerset() {
		return ktek_pk_idanswerset;
	}
	
	public int getORMID() {
		return getKtek_pk_idanswerset();
	}
	
	public void setCodanswersetl(String value) {
		this.codanswersetl = value;
	}
	
	public String getCodanswersetl() {
		return codanswersetl;
	}
	
	public void setNameanswerset(String value) {
		this.nameanswerset = value;
	}
	
	public String getNameanswerset() {
		return nameanswerset;
	}
	
	public void setKtek_fk_idanswer(java.util.Set value) {
		this.ktek_fk_idanswer = value;
	}
	
	public java.util.Set getKtek_fk_idanswer() {
		return ktek_fk_idanswer;
	}
	
	
	public void setKtek_question(java.util.Set value) {
		this.ktek_question = value;
	}
	
	public java.util.Set getKtek_question() {
		return ktek_question;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idanswerset());
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
