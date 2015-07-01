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

@XmlRootElement(name = "KtekQuestionnaireResultEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaire","iduserquestionnaireplanning","codtelecareprogram","coduser","listsections"})
public class KtekQuestionnaireResultEntity implements Serializable{
	
	private int idquestionnaire;
	private int iduserquestionnaireplanning;
	private String codtelecareprogram;	
	private String coduser;
	
	private short score; 
	
	private List<KtekQuestionnaireSectionResultEntity> listsections;
	
	public KtekQuestionnaireResultEntity(){}
	
	/**
	 * @return the idquestionnaire
	 */
	public int getIdquestionnaire() {
		return idquestionnaire;
	}

	/**
	 * @param idquestionnaire the idquestionnaire to set
	 */
	public void setIdquestionnaire(int idquestionnaire) {
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
	 * @return the listsections
	 */
	public List<KtekQuestionnaireSectionResultEntity> getListsections() {
		return listsections;
	}

	/**
	 * @param listsections the listsections to set
	 */
	public void setListsections(
			List<KtekQuestionnaireSectionResultEntity> listsections) {
		this.listsections = listsections;
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
	 * @return the iduserquestionnaireplanning
	 */
	public int getIduserquestionnaireplanning() {
		return iduserquestionnaireplanning;
	}

	/**
	 * @param iduserquestionnaireplanning the iduserquestionnaireplanning to set
	 */
	public void setIduserquestionnaireplanning(int iduserquestionnaireplanning) {
		this.iduserquestionnaireplanning = iduserquestionnaireplanning;
	}

	
}