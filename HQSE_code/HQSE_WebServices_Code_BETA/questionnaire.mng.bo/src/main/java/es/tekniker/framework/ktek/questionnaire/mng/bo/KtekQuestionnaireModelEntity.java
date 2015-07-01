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


@XmlRootElement(name = "KtekQuestionnaireModelEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaire", "namequestionnaire","desquestionnaire", "desinstructionsquestionnaire","desevaluation","ismultisection","score", "iduserquestionnaireplanning","typemonitoringactivity","questionnaireConfiguration" ,"listSections"})
public class KtekQuestionnaireModelEntity implements Serializable{

	private long idquestionnaire;
	private String namequestionnaire;	
	private String desquestionnaire;	
	private String desinstructionsquestionnaire;
	private String desevaluation;	
	private short typemonitoringactivity;
	private short ismultisection;
	private short score;
	private KtekQuestionnaireConfigurationEntity questionnaireConfiguration;
	
	private int iduserquestionnaireplanning;
	
	private List<KtekQuestionnaireSectionEntity> listSections ;
	
	public KtekQuestionnaireModelEntity(){}

	
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
	 * @return the namequestionnaire
	 */
	public String getNamequestionnaire() {
		return namequestionnaire;
	}

	/**
	 * @param namequestionnaire the namequestionnaire to set
	 */
	public void setNamequestionnaire(String namequestionnaire) {
		this.namequestionnaire = namequestionnaire;
	}

	/**
	 * @return the desquestionnaire
	 */
	public String getDesquestionnaire() {
		return desquestionnaire;
	}

	/**
	 * @param desquestionnaire the desquestionnaire to set
	 */
	public void setDesquestionnaire(String desquestionnaire) {
		this.desquestionnaire = desquestionnaire;
	}

	/**
	 * @return the desinstructionsquestionnaire
	 */
	public String getDesinstructionsquestionnaire() {
		return desinstructionsquestionnaire;
	}

	/**
	 * @param desinstructionsquestionnaire the desinstructionsquestionnaire to set
	 */
	public void setDesinstructionsquestionnaire(String desinstructionsquestionnaire) {
		this.desinstructionsquestionnaire = desinstructionsquestionnaire;
	}

	/**
	 * @return the questionnaireConfiguration
	 */
	public KtekQuestionnaireConfigurationEntity getQuestionnaireConfiguration() {
		return questionnaireConfiguration;
	}


	/**
	 * @param questionnaireConfiguration the questionnaireConfiguration to set
	 */
	public void setQuestionnaireConfiguration(
			KtekQuestionnaireConfigurationEntity questionnaireConfiguration) {
		this.questionnaireConfiguration = questionnaireConfiguration;
	}


	/**
	 * @return the listSections
	 */
	public List<KtekQuestionnaireSectionEntity> getListSections() {
		return listSections;
	}


	/**
	 * @param listSections the listSections to set
	 */
	public void setListSections(
			List<KtekQuestionnaireSectionEntity> listSections) {
		this.listSections = listSections;
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


	/**
	 * @return the ismultisection
	 */
	public short getIsmultisection() {
		return ismultisection;
	}


	/**
	 * @param ismultisection the ismultisection to set
	 */
	public void setIsmultisection(short ismultisection) {
		this.ismultisection = ismultisection;
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
	 * @return the desevaluation
	 */
	public String getDesevaluation() {
		return desevaluation;
	}


	/**
	 * @param desevaluation the desevaluation to set
	 */
	public void setDesevaluation(String desevaluation) {
		this.desevaluation = desevaluation;
	}


	/**
	 * @return the typemonitoringactivity
	 */
	public short getTypemonitoringactivity() {
		return typemonitoringactivity;
	}


	/**
	 * @param typemonitoringactivity the typemonitoringactivity to set
	 */
	public void setTypemonitoringactivity(short typemonitoringactivity) {
		this.typemonitoringactivity = typemonitoringactivity;
	}


		
	
	
	
}
