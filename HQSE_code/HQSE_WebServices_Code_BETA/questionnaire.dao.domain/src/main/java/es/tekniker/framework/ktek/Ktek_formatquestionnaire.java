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
public class Ktek_formatquestionnaire implements Serializable {
	public Ktek_formatquestionnaire() {
	}
	
	private int ktek_pk_idformatquestionnaire;
	
	private es.tekniker.framework.ktek.Ktek_questionnaire ktek_fk_questionnaire;
	
	private short formatpagination;
	
	private short formatintegerparameter;
	
	private short formatdecimalparameter;
	
	private short formatsetuniqueitem;
	
	private short formatsetmultitem;
	
	public void setKtek_pk_idformatquestionnaire(int value) {
		this.ktek_pk_idformatquestionnaire = value;
	}
	
	public int getKtek_pk_idformatquestionnaire() {
		return ktek_pk_idformatquestionnaire;
	}
	
	public int getORMID() {
		return getKtek_pk_idformatquestionnaire();
	}
	
	public void setFormatpagination(short value) {
		this.formatpagination = value;
	}
	
	public short getFormatpagination() {
		return formatpagination;
	}
	
	public void setFormatintegerparameter(short value) {
		this.formatintegerparameter = value;
	}
	
	public short getFormatintegerparameter() {
		return formatintegerparameter;
	}
	
	public void setFormatdecimalparameter(short value) {
		this.formatdecimalparameter = value;
	}
	
	public short getFormatdecimalparameter() {
		return formatdecimalparameter;
	}
	
	public void setFormatsetuniqueitem(short value) {
		this.formatsetuniqueitem = value;
	}
	
	public short getFormatsetuniqueitem() {
		return formatsetuniqueitem;
	}
	
	public void setFormatsetmultitem(short value) {
		this.formatsetmultitem = value;
	}
	
	public short getFormatsetmultitem() {
		return formatsetmultitem;
	}
	
	public void setKtek_fk_questionnaire(es.tekniker.framework.ktek.Ktek_questionnaire value) {
		this.ktek_fk_questionnaire = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_questionnaire getKtek_fk_questionnaire() {
		return ktek_fk_questionnaire;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_idformatquestionnaire());
	}
	
}
