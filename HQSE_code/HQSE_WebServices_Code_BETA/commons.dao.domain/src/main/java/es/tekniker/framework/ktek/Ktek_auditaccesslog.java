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
public class Ktek_auditaccesslog implements Serializable {
	public Ktek_auditaccesslog() {
	}
	
	private int ktek_pk_idauditaccesslog;
	
	private es.tekniker.framework.ktek.Ktek_user idaccessuser;
	
	private es.tekniker.framework.ktek.Ktek_user idaccesseduser;
	
	private String codtelecareprogram;
	
	private short typeaction;
	
	private Integer idaction;
	
	private long logitemcreation;
	
	public void setKtek_pk_idauditaccesslog(int value) {
		this.ktek_pk_idauditaccesslog = value;
	}
	
	public int getKtek_pk_idauditaccesslog() {
		return ktek_pk_idauditaccesslog;
	}
	
	public int getORMID() {
		return getKtek_pk_idauditaccesslog();
	}
	
	public void setCodtelecareprogram(String value) {
		this.codtelecareprogram = value;
	}
	
	public String getCodtelecareprogram() {
		return codtelecareprogram;
	}
	
	public void setTypeaction(short value) {
		this.typeaction = value;
	}
	
	public short getTypeaction() {
		return typeaction;
	}
	
	public void setIdaction(int value) {
		setIdaction(new Integer(value));
	}
	
	public void setIdaction(Integer value) {
		this.idaction = value;
	}
	
	public Integer getIdaction() {
		return idaction;
	}
	
	public void setLogitemcreation(long value) {
		this.logitemcreation = value;
	}
	
	public long getLogitemcreation() {
		return logitemcreation;
	}
	
	public void setIdaccessuser(es.tekniker.framework.ktek.Ktek_user value) {
		this.idaccessuser = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_user getIdaccessuser() {
		return idaccessuser;
	}
	
	public void setIdaccesseduser(es.tekniker.framework.ktek.Ktek_user value) {
		this.idaccesseduser = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_user getIdaccesseduser() {
		return idaccesseduser;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_idauditaccesslog());
	}
	
}
