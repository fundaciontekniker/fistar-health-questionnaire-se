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
public class Ktek_questionnaireconfiguration implements Serializable {
	public Ktek_questionnaireconfiguration() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ktek_questionnaireconfiguration))
			return false;
		Ktek_questionnaireconfiguration ktek_questionnaireconfiguration = (Ktek_questionnaireconfiguration)aObj;
		if (getKtek_pk_ktek_idquestionnaireconfiguration() != ktek_questionnaireconfiguration.getKtek_pk_ktek_idquestionnaireconfiguration())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getKtek_pk_ktek_idquestionnaireconfiguration();
		return hashcode;
	}
	
	private int ktek_pk_ktek_idquestionnaireconfiguration;
	
	private int ktek_typesave;
	
	private String endpointserver;
	
	private String eventserviceoauth2headertoken;
	
	private Integer timeout;
	
	private Integer port;
	
	public void setKtek_pk_ktek_idquestionnaireconfiguration(int value) {
		this.ktek_pk_ktek_idquestionnaireconfiguration = value;
	}
	
	public int getKtek_pk_ktek_idquestionnaireconfiguration() {
		return ktek_pk_ktek_idquestionnaireconfiguration;
	}
	
	public int getORMID() {
		return getKtek_pk_ktek_idquestionnaireconfiguration();
	}
	
	public void setKtek_typesave(int value) {
		this.ktek_typesave = value;
	}
	
	public int getKtek_typesave() {
		return ktek_typesave;
	}
	
	public void setEndpointserver(String value) {
		this.endpointserver = value;
	}
	
	public String getEndpointserver() {
		return endpointserver;
	}
	
	public void setEventserviceoauth2headertoken(String value) {
		this.eventserviceoauth2headertoken = value;
	}
	
	public String getEventserviceoauth2headertoken() {
		return eventserviceoauth2headertoken;
	}
	
	public void setTimeout(int value) {
		setTimeout(new Integer(value));
	}
	
	public void setTimeout(Integer value) {
		this.timeout = value;
	}
	
	public Integer getTimeout() {
		return timeout;
	}
	
	public void setPort(int value) {
		setPort(new Integer(value));
	}
	
	public void setPort(Integer value) {
		this.port = value;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_ktek_idquestionnaireconfiguration());
	}
	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
