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
package es.tekniker.framework.ktek.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "KtekTpsettingsEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"iduser", "idlanguage",  "typecomchannel","email","mobile"})

public class KtekTpsettingsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7772234785138065182L;

	public KtekTpsettingsEntity() {
	}
	
	private int idlanguage;	
	private int iduser;
	private short typecomchannel;
	
	private String email;
	private String mobile;
	
	/**
	 * @return the idlanguage
	 */
	public int getIdlanguage() {
		return idlanguage;
	}

	/**
	 * @param idlanguage the idlanguage to set
	 */
	public void setIdlanguage(int idlanguage) {
		this.idlanguage = idlanguage;
	}


	
	
	public void setIduser(int value) {
		this.iduser = value;
	}
	
	public int getIduser() {
		return iduser;
	}
	
	
	
	
	public void setTypecomchannel(short value) {
		this.typecomchannel = value;
	}
	
	public short getTypecomchannel() {
		return typecomchannel;
	}
	
	
	public String toString() {
		return String.valueOf(iduser);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
}
