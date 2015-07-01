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
public class Ktek_result_questionnaireitem implements Serializable {
	public Ktek_result_questionnaireitem() {
	}
	
	private int ktek_pk_idresultquestionnaireitem;
	
	private es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_fk_idquestionnaireitem;
	
	private es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_fk_idresultquestionnairesection;
	
	private short typeresult;
	
	private Long integervalue;
	
	private Float decimalvalue;
	
	private String stringvalue;
	
	private String textvalue;
	
	private String codanswer;
	
	private Short scoreanswer;
	
	public void setKtek_pk_idresultquestionnaireitem(int value) {
		this.ktek_pk_idresultquestionnaireitem = value;
	}
	
	public int getKtek_pk_idresultquestionnaireitem() {
		return ktek_pk_idresultquestionnaireitem;
	}
	
	public int getORMID() {
		return getKtek_pk_idresultquestionnaireitem();
	}
	
	public void setTyperesult(short value) {
		this.typeresult = value;
	}
	
	public short getTyperesult() {
		return typeresult;
	}
	
	public void setIntegervalue(long value) {
		setIntegervalue(new Long(value));
	}
	
	public void setIntegervalue(Long value) {
		this.integervalue = value;
	}
	
	public Long getIntegervalue() {
		return integervalue;
	}
	
	public void setDecimalvalue(float value) {
		setDecimalvalue(new Float(value));
	}
	
	public void setDecimalvalue(Float value) {
		this.decimalvalue = value;
	}
	
	public Float getDecimalvalue() {
		return decimalvalue;
	}
	
	public void setStringvalue(String value) {
		this.stringvalue = value;
	}
	
	public String getStringvalue() {
		return stringvalue;
	}
	
	public void setTextvalue(String value) {
		this.textvalue = value;
	}
	
	public String getTextvalue() {
		return textvalue;
	}
	
	public void setCodanswer(String value) {
		this.codanswer = value;
	}
	
	public String getCodanswer() {
		return codanswer;
	}
	
	public void setScoreanswer(short value) {
		setScoreanswer(new Short(value));
	}
	
	public void setScoreanswer(Short value) {
		this.scoreanswer = value;
	}
	
	public Short getScoreanswer() {
		return scoreanswer;
	}
	
	public void setKtek_fk_idquestionnaireitem(es.tekniker.framework.ktek.Ktek_questionnaireitem value) {
		this.ktek_fk_idquestionnaireitem = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaireitem getKtek_fk_idquestionnaireitem() {
		return ktek_fk_idquestionnaireitem;
	}
	
	public void setKtek_fk_idresultquestionnairesection(es.tekniker.framework.ktek.Ktek_result_questionnairesection value) {
		this.ktek_fk_idresultquestionnairesection = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_result_questionnairesection getKtek_fk_idresultquestionnairesection() {
		return ktek_fk_idresultquestionnairesection;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_idresultquestionnaireitem());
	}
	
}
