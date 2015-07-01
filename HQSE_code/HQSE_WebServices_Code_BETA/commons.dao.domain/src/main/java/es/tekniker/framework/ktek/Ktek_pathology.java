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
public class Ktek_pathology implements Serializable {
	public Ktek_pathology() {
	}
	
	private int ktek_pk_idpathology;
	
	private String ktek_uk_codpathology;
	
	private String namepathology;
	
	private String despathology;
	
	public void setKtek_pk_idpathology(int value) {
		this.ktek_pk_idpathology = value;
	}
	
	public int getKtek_pk_idpathology() {
		return ktek_pk_idpathology;
	}
	
	public int getORMID() {
		return getKtek_pk_idpathology();
	}
	
	public void setKtek_uk_codpathology(String value) {
		this.ktek_uk_codpathology = value;
	}
	
	public String getKtek_uk_codpathology() {
		return ktek_uk_codpathology;
	}
	
	public void setNamepathology(String value) {
		this.namepathology = value;
	}
	
	public String getNamepathology() {
		return namepathology;
	}
	
	public void setDespathology(String value) {
		this.despathology = value;
	}
	
	public String getDespathology() {
		return despathology;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_idpathology());
	}
	
}
