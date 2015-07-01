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
public class Ktek_userquestionnaire_planning implements Serializable {
	public Ktek_userquestionnaire_planning() {
	}
	
	private int ktek_pk_iduserquestionnaireplanning;
	
	private es.tekniker.framework.ktek.Ktek_questionnaire ktek_fk_idquestionnaire;
	
	private String coduser;
	
	private String codtelecareprogram;
	
	private long plannedfrom;
	
	private long plannedto;
	
	private short statusquestionnaire;
	
	private es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire;
	
	public void setKtek_pk_iduserquestionnaireplanning(int value) {
		this.ktek_pk_iduserquestionnaireplanning = value;
	}
	
	public int getKtek_pk_iduserquestionnaireplanning() {
		return ktek_pk_iduserquestionnaireplanning;
	}
	
	public int getORMID() {
		return getKtek_pk_iduserquestionnaireplanning();
	}
	
	public void setCoduser(String value) {
		this.coduser = value;
	}
	
	public String getCoduser() {
		return coduser;
	}
	
	public void setCodtelecareprogram(String value) {
		this.codtelecareprogram = value;
	}
	
	public String getCodtelecareprogram() {
		return codtelecareprogram;
	}
	
	public void setPlannedfrom(long value) {
		this.plannedfrom = value;
	}
	
	public long getPlannedfrom() {
		return plannedfrom;
	}
	
	public void setPlannedto(long value) {
		this.plannedto = value;
	}
	
	public long getPlannedto() {
		return plannedto;
	}
	
	public void setStatusquestionnaire(short value) {
		this.statusquestionnaire = value;
	}
	
	public short getStatusquestionnaire() {
		return statusquestionnaire;
	}
	
	public void setKtek_fk_idquestionnaire(es.tekniker.framework.ktek.Ktek_questionnaire value) {
		this.ktek_fk_idquestionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaire getKtek_fk_idquestionnaire() {
		return ktek_fk_idquestionnaire;
	}
	
	public void setKtek_result_questionnaire(es.tekniker.framework.ktek.Ktek_result_questionnaire value) {
		this.ktek_result_questionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_result_questionnaire getKtek_result_questionnaire() {
		return ktek_result_questionnaire;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_iduserquestionnaireplanning());
	}
	
}
