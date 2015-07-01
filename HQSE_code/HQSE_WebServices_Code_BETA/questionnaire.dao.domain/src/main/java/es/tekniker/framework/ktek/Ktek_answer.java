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
public class Ktek_answer implements Serializable {
	public Ktek_answer() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_answer))
			return false;
		Ktek_answer ktek_answer = (Ktek_answer)aObj;
		if (getKtek_pk_idanswer() != ktek_answer.getKtek_pk_idanswer())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_idanswer();
		return hashcode;
	}
	
	private int ktek_pk_idanswer;
	
	private es.tekniker.framework.ktek.Ktek_question ktek_fk_idquestionnaireitem;
	
	private String ktek_uk_codanswer;
	
	private String nameanswer;
	
	private String desanswer;
	
	private String imageanswer;
	
	private short scoreanswer;
	
	private java.util.Set ktek_fk_idanswerset = new java.util.HashSet();
	
	public void setKtek_pk_idanswer(int value) {
		this.ktek_pk_idanswer = value;
	}
	
	public int getKtek_pk_idanswer() {
		return ktek_pk_idanswer;
	}
	
	public int getORMID() {
		return getKtek_pk_idanswer();
	}
	
	public void setKtek_uk_codanswer(String value) {
		this.ktek_uk_codanswer = value;
	}
	
	public String getKtek_uk_codanswer() {
		return ktek_uk_codanswer;
	}
	
	public void setNameanswer(String value) {
		this.nameanswer = value;
	}
	
	public String getNameanswer() {
		return nameanswer;
	}
	
	public void setDesanswer(String value) {
		this.desanswer = value;
	}
	
	public String getDesanswer() {
		return desanswer;
	}
	
	public void setImageanswer(String value) {
		this.imageanswer = value;
	}
	
	public String getImageanswer() {
		return imageanswer;
	}
	
	public void setScoreanswer(short value) {
		this.scoreanswer = value;
	}
	
	public short getScoreanswer() {
		return scoreanswer;
	}
	
	public void setKtek_fk_idquestionnaireitem(es.tekniker.framework.ktek.Ktek_question value) {
		this.ktek_fk_idquestionnaireitem = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_question getKtek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem;
	}
	
	public void setKtek_fk_idanswerset(java.util.Set value) {
		this.ktek_fk_idanswerset = value;
	}
	
	public java.util.Set getKtek_fk_idanswerset() {
		return ktek_fk_idanswerset;
	}
	
	
	public String toString() {
		return String.valueOf(getKtek_pk_idanswer());
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
