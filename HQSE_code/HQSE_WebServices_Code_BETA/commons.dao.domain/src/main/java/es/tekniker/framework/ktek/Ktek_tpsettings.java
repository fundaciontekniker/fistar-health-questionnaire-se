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
public class Ktek_tpsettings implements Serializable {
	public Ktek_tpsettings() {
	}
	
	private es.tekniker.framework.ktek.Ktek_user ktek_fk_iduser;
	
	private int ktek_fk_iduserId;
	
	public void setKtek_fk_iduserId(int value) {
		this.ktek_fk_iduserId = value;
	}
	
	public int getKtek_fk_iduserId() {
		return ktek_fk_iduserId;
	}
	
	private es.tekniker.framework.ktek.Ktek_language ktek_fk_idlanguage;
	
	private short typecomchannel;
	
	public void setTypecomchannel(short value) {
		this.typecomchannel = value;
	}
	
	public short getTypecomchannel() {
		return typecomchannel;
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
	
	public void setKtek_fk_idlanguage(es.tekniker.framework.ktek.Ktek_language value) {
		this.ktek_fk_idlanguage = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_language getKtek_fk_idlanguage() {
		return ktek_fk_idlanguage;
	}
	
	public String toString() {
		return String.valueOf(((getKtek_fk_iduser() == null) ? "" : String.valueOf(getKtek_fk_iduser().getORMID())));
	}
	
}
