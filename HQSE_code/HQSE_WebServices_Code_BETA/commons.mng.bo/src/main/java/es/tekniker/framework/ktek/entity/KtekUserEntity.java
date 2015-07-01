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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * Class used as output on login service
 */

@XmlRootElement(name = "KtekUserEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"iduser","token","code","name","surname","idlanguage","language","typecomchannel"})
public class KtekUserEntity implements Serializable {
	public KtekUserEntity() {
	}
		
	private String token;
	private long iduser;
	private String code;
	private String name;
	private String surname;	
	private long idlanguage;
	private String language;
	private short typecomchannel;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
		
	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	
	
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
	
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the idlanguage
	 */
	public long getIdlanguage() {
		return idlanguage;
	}

	/**
	 * @param idlanguage the idlanguage to set
	 */
	public void setIdlanguage(long idlanguage) {
		this.idlanguage = idlanguage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public short getTypecomchannel() {
		return typecomchannel;
	}

	public void setTypecomchannel(short typecomchannel) {
		this.typecomchannel = typecomchannel;
	}

	public String toString() {
		return String.valueOf(getToken());
	}

	/*
	 * The function string2md5 converts a string value to md5 value 
	 */
	private String string2md5(final String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest
	                .getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();
	 
	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < messageDigest.length; i++) {
	            String h = Integer.toHexString(0xFF & messageDigest[i]);
	            while (h.length() < 2)
	                h = "0" + h;
	            hexString.append(h);
	        }
	        return hexString.toString();
	 
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	public String generateToken(){	
		SecureRandom random = new SecureRandom();
	    
		this.token=new BigInteger(130, random).toString(32);
		
		return this.token;
	}

	
	
}
