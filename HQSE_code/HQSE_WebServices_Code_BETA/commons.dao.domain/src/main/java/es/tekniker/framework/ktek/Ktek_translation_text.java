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
public class Ktek_translation_text implements Serializable {
	public Ktek_translation_text() {
	}
	
	private int ktek_pk_translation_text;
	
	private long ktek_idregister;
	
	private String ktek_keycolum;
	
	private es.tekniker.framework.ktek.Ktek_language ktek_fk_language;
	
	private String ktek_columvalue;
	
	public void setKtek_pk_translation_text(int value) {
		this.ktek_pk_translation_text = value;
	}
	
	public int getKtek_pk_translation_text() {
		return ktek_pk_translation_text;
	}
	
	public int getORMID() {
		return getKtek_pk_translation_text();
	}
	
	public void setKtek_idregister(long value) {
		this.ktek_idregister = value;
	}
	
	public long getKtek_idregister() {
		return ktek_idregister;
	}
	
	public void setKtek_keycolum(String value) {
		this.ktek_keycolum = value;
	}
	
	public String getKtek_keycolum() {
		return ktek_keycolum;
	}
	
	public void setKtek_columvalue(String value) {
		this.ktek_columvalue = value;
	}
	
	public String getKtek_columvalue() {
		return ktek_columvalue;
	}
	
	public void setKtek_fk_language(es.tekniker.framework.ktek.Ktek_language value) {
		this.ktek_fk_language = value;
	}
	
	public es.tekniker.framework.ktek.Ktek_language getKtek_fk_language() {
		return ktek_fk_language;
	}
	
	public String toString() {
		return String.valueOf(getKtek_pk_translation_text());
	}
	
}
