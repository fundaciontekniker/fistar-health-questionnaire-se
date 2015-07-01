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
public class Ktek_question implements Serializable {
	public Ktek_question() {
	}
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitem;
	
	private int ktek_fk_idquestionnaireitemId;
	
	public void setKtek_fk_idquestionnaireitemId(int value) {
		this.ktek_fk_idquestionnaireitemId = value;
	}
	
	public int getKtek_fk_idquestionnaireitemId() {
		return ktek_fk_idquestionnaireitemId;
	}
	
	private short typeanswersortorder;
	
	private short typeanswer;
	
	private Short formatanswerunique;
	
	private es.tekniker.framework.ktek.Ktek_answerset ktek_fk_idanswerset;
	
	private short weightquestion;
	
	private java.util.Set ktek_answer = new java.util.HashSet();
	
	public void setTypeanswersortorder(short value) {
		this.typeanswersortorder = value;
	}
	
	public short getTypeanswersortorder() {
		return typeanswersortorder;
	}
	
	public void setTypeanswer(short value) {
		this.typeanswer = value;
	}
	
	public short getTypeanswer() {
		return typeanswer;
	}
	
	public void setFormatanswerunique(short value) {
		setFormatanswerunique(new Short(value));
	}
	
	public void setFormatanswerunique(Short value) {
		this.formatanswerunique = value;
	}
	
	public Short getFormatanswerunique() {
		return formatanswerunique;
	}
	
	public void setWeightquestion(short value) {
		this.weightquestion = value;
	}
	
	public short getWeightquestion() {
		return weightquestion;
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
	
	public void setKtek_fk_idanswerset(es.tekniker.framework.ktek.Ktek_answerset value) {
		this.ktek_fk_idanswerset = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_answerset getKtek_fk_idanswerset() {
		return ktek_fk_idanswerset;
	}
	
	public void setKtek_answer(java.util.Set value) {
		this.ktek_answer = value;
	}
	
	public java.util.Set getKtek_answer() {
		return ktek_answer;
	}
	
	
	public String toString() {
		return String.valueOf(((getKtek_fk_idquestionnaireitem() == null) ? "" : String.valueOf(getKtek_fk_idquestionnaireitem().getORMID())));
	}
	
}
