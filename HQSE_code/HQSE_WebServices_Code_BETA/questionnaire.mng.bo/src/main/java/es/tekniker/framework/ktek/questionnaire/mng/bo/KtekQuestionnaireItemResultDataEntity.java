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
package es.tekniker.framework.ktek.questionnaire.mng.bo;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "KtekQuestionnaireItemResultDataEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idresultquestionnaireitem","idquestionnaireitem","codquestionnaireitemvalue","codanswervalue","score"})
public class KtekQuestionnaireItemResultDataEntity implements Serializable{

	private long idresultquestionnaireitem;
	private long idquestionnaireitem;
	
	
	private String codquestionnaireitemvalue;	
	private String codanswervalue;
	
	private short score; 
	
	public KtekQuestionnaireItemResultDataEntity(){}

	/**
	 * @return the idresultquestionnaireitem
	 */
	public long getIdresultquestionnaireitem() {
		return idresultquestionnaireitem;
	}

	/**
	 * @param idresultquestionnaireitem the idresultquestionnaireitem to set
	 */
	public void setIdresultquestionnaireitem(long idresultquestionnaireitem) {
		this.idresultquestionnaireitem = idresultquestionnaireitem;
	}

	/**
	 * @return the idquestionnaireitem
	 */
	public long getIdquestionnaireitem() {
		return idquestionnaireitem;
	}

	/**
	 * @param idquestionnaireitem the idquestionnaireitem to set
	 */
	public void setIdquestionnaireitem(long idquestionnaireitem) {
		this.idquestionnaireitem = idquestionnaireitem;
	}

	

	/**
	 * @return the codquestionnaireitemvalue
	 */
	public String getCodquestionnaireitemvalue() {
		return codquestionnaireitemvalue;
	}

	/**
	 * @param codquestionnaireitemvalue the codquestionnaireitemvalue to set
	 */
	public void setCodquestionnaireitemvalue(String codquestionnaireitemvalue) {
		this.codquestionnaireitemvalue = codquestionnaireitemvalue;
	}

	/**
	 * @return the codanswervalue
	 */
	public String getCodanswervalue() {
		return codanswervalue;
	}

	/**
	 * @param codanswervalue the codanswervalue to set
	 */
	public void setCodanswervalue(String codanswervalue) {
		this.codanswervalue = codanswervalue;
	}

	/**
	 * @return the score
	 */
	public short getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(short score) {
		this.score = score;
	}
	
	
	
	
	
}
