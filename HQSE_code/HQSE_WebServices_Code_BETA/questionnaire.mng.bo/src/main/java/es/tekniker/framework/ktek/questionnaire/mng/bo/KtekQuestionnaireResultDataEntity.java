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

@XmlRootElement(name = "KtekQuestionnaireResultDataEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idresultquestionnaire","idquestionnaire","codtelecareprogram","coduser","score","resultcreation","listsections"})
public class KtekQuestionnaireResultDataEntity implements Serializable{
	
	private long idresultquestionnaire;
	private long idquestionnaire;
	private String codtelecareprogram;	
	private String coduser;	
	private short score; 
	private long resultcreation;
	
	private List<KtekQuestionnaireSectionResultDataEntity> listsections;
	
	public KtekQuestionnaireResultDataEntity(){}

	/**
	 * @return the idresultquestionnaire
	 */
	public long getIdresultquestionnaire() {
		return idresultquestionnaire;
	}

	/**
	 * @param idresultquestionnaire the idresultquestionnaire to set
	 */
	public void setIdresultquestionnaire(long idresultquestionnaire) {
		this.idresultquestionnaire = idresultquestionnaire;
	}

	/**
	 * @return the idquestionnaire
	 */
	public long getIdquestionnaire() {
		return idquestionnaire;
	}

	/**
	 * @param idquestionnaire the idquestionnaire to set
	 */
	public void setIdquestionnaire(long idquestionnaire) {
		this.idquestionnaire = idquestionnaire;
	}

	/**
	 * @return the codtelecareprogram
	 */
	public String getCodtelecareprogram() {
		return codtelecareprogram;
	}

	/**
	 * @param codtelecareprogram the codtelecareprogram to set
	 */
	public void setCodtelecareprogram(String codtelecareprogram) {
		this.codtelecareprogram = codtelecareprogram;
	}

	/**
	 * @return the coduser
	 */
	public String getCoduser() {
		return coduser;
	}

	/**
	 * @param coduser the coduser to set
	 */
	public void setCoduser(String coduser) {
		this.coduser = coduser;
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

	/**
	 * @return the resultcreation
	 */
	public long getResultcreation() {
		return resultcreation;
	}

	/**
	 * @param resultcreation the resultcreation to set
	 */
	public void setResultcreation(long resultcreation) {
		this.resultcreation = resultcreation;
	}

	/**
	 * @return the listsections
	 */
	public List<KtekQuestionnaireSectionResultDataEntity> getListsections() {
		return listsections;
	}

	/**
	 * @param listsections the listsections to set
	 */
	public void setListsections(
			List<KtekQuestionnaireSectionResultDataEntity> listsections) {
		this.listsections = listsections;
	}
	
	
	
	
}