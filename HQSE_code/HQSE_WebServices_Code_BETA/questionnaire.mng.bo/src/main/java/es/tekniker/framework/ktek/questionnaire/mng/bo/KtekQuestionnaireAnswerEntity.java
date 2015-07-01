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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "KtekQuestionnaireAnswerEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"codanswer","nameanswer","desanswer","scoreanswer"})
public class KtekQuestionnaireAnswerEntity implements Serializable{

	
	private String codanswer;	
	private String nameanswer;	
	private String desanswer;
	private short scoreanswer;
	
	
	public KtekQuestionnaireAnswerEntity(){}

	/**
	 * @return the codanswer
	 */
	public String getCodanswer() {
		return codanswer;
	}

	/**
	 * @param codanswer the codanswer to set
	 */
	public void setCodanswer(String codanswer) {
		this.codanswer = codanswer;
	}

	/**
	 * @return the nameanswer
	 */
	public String getNameanswer() {
		return nameanswer;
	}


	/**
	 * @param nameanswer the nameanswer to set
	 */
	public void setNameanswer(String nameanswer) {
		this.nameanswer = nameanswer;
	}


	/**
	 * @return the desanswer
	 */
	public String getDesanswer() {
		return desanswer;
	}


	/**
	 * @param desanswer the desanswer to set
	 */
	public void setDesanswer(String desanswer) {
		this.desanswer = desanswer;
	}


	/**
	 * @return the scoreanswer
	 */
	public short getScoreanswer() {
		return scoreanswer;
	}


	/**
	 * @param scoreanswer the scoreanswer to set
	 */
	public void setScoreanswer(short scoreanswer) {
		this.scoreanswer = scoreanswer;
	}

		
	
}