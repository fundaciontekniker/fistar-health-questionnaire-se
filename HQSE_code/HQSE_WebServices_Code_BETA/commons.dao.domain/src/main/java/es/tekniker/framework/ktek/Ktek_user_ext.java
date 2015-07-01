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
public class Ktek_user_ext implements Serializable {
	public Ktek_user_ext() {
	}
	
	private es.tekniker.framework.ktek.Ktek_user ktek_fk_iduser;
	
	private int ktek_fk_iduserId;
	
	public void setKtek_fk_iduserId(int value) {
		this.ktek_fk_iduserId = value;
	}
	
	public int getKtek_fk_iduserId() {
		return ktek_fk_iduserId;
	}
	
	private String ktek_uk_coduserid;
	
	private String email;
	
	private String mobile;
	
	private String keyuser;
	
	private String passworduser;
	
	private String name;
	
	private String surname;
	
	public void setKtek_uk_coduserid(String value) {
		this.ktek_uk_coduserid = value;
	}
	
	public String getKtek_uk_coduserid() {
		return ktek_uk_coduserid;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setMobile(String value) {
		this.mobile = value;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setKeyuser(String value) {
		this.keyuser = value;
	}
	
	public String getKeyuser() {
		return keyuser;
	}
	
	public void setPassworduser(String value) {
		this.passworduser = value;
	}
	
	public String getPassworduser() {
		return passworduser;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String value) {
		this.surname = value;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setKtek_fk_iduser(es.tekniker.framework.ktek.Ktek_user value) {
		this.ktek_fk_iduser = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_user getKtek_fk_iduser() {
		return ktek_fk_iduser;
	}
	
	public es.tekniker.framework.ktek.Ktek_user getORMID() {
		return getKtek_fk_iduser();
	}
	
	public String toString() {
		return String.valueOf(((getKtek_fk_iduser() == null) ? "" : String.valueOf(getKtek_fk_iduser().getORMID())));
	}
	
}
