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
public class Ktek_user implements Serializable {
	public Ktek_user() {
	}
	
	private int ktek_pk_iduser;
	
	private String ktek_uk_coduser;
	
	private java.util.Set ktek_auditaccesslog = new java.util.HashSet();
	
	private java.util.Set ktek_auditaccesslog1 = new java.util.HashSet();
	
	private es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings;
	
	private es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext;
	
	private es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata;
	
	public void setKtek_pk_iduser(int value) {
		this.ktek_pk_iduser = value;
	}
	
	public int getKtek_pk_iduser() {
		return ktek_pk_iduser;
	}
	
	public int getORMID() {
		return getKtek_pk_iduser();
	}
	
	public void setKtek_uk_coduser(String value) {
		this.ktek_uk_coduser = value;
	}
	
	public String getKtek_uk_coduser() {
		return ktek_uk_coduser;
	}
	
	public void setKtek_auditaccesslog(java.util.Set value) {
		this.ktek_auditaccesslog = value;
	}
	
	public java.util.Set getKtek_auditaccesslog() {
		return ktek_auditaccesslog;
	}
	
	
	public void setKtek_auditaccesslog1(java.util.Set value) {
		this.ktek_auditaccesslog1 = value;
	}
	
	public java.util.Set getKtek_auditaccesslog1() {
		return ktek_auditaccesslog1;
	}
	
	
	public void setKtek_tpsettings(es.tekniker.framework.ktek.Ktek_tpsettings value) {
		this.ktek_tpsettings = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_tpsettings getKtek_tpsettings() {
		return ktek_tpsettings;
	}
	
	public void setKtek_user_ext(es.tekniker.framework.ktek.Ktek_user_ext value) {
		this.ktek_user_ext = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_user_ext getKtek_user_ext() {
		return ktek_user_ext;
	}
	
	public void setKtek_usersessiondata(es.tekniker.framework.ktek.Ktek_usersessiondata value) {
		this.ktek_usersessiondata = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_usersessiondata getKtek_usersessiondata() {
		return ktek_usersessiondata;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_iduser());
	}
	
}
