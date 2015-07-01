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


@XmlRootElement(name = "KtekQuestionnaireSectionEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnairesection","namequestionnairesection","desquestionnairesection", "desquestionnairesectioninstructions","score","listItems"})
public class KtekQuestionnaireSectionEntity implements Serializable{

	
	private long idquestionnairesection;
	private String namequestionnairesection;
	private String desquestionnairesection;
	private String desquestionnairesectioninstructions;
	private short score;
	
	private List<KtekQuestionnaireItemEntity> listItems ;
	
	public KtekQuestionnaireSectionEntity(){}

	/**
	 * @return the idquestionnairesection
	 */
	public long getIdquestionnairesection() {
		return idquestionnairesection;
	}

	/**
	 * @param idquestionnairesection the idquestionnairesection to set
	 */
	public void setIdquestionnairesection(long idquestionnairesection) {
		this.idquestionnairesection = idquestionnairesection;
	}

	/**
	 * @return the namequestionnairesection
	 */
	public String getNamequestionnairesection() {
		return namequestionnairesection;
	}

	/**
	 * @param namequestionnairesection the namequestionnairesection to set
	 */
	public void setNamequestionnairesection(String namequestionnairesection) {
		this.namequestionnairesection = namequestionnairesection;
	}

	/**
	 * @return the desquestionnairesection
	 */
	public String getDesquestionnairesection() {
		return desquestionnairesection;
	}

	/**
	 * @param desquestionnairesection the desquestionnairesection to set
	 */
	public void setDesquestionnairesection(String desquestionnairesection) {
		this.desquestionnairesection = desquestionnairesection;
	}

	/**
	 * @return the desquestionnairesectioninstructions
	 */
	public String getDesquestionnairesectioninstructions() {
		return desquestionnairesectioninstructions;
	}

	/**
	 * @param desquestionnairesectioninstructions the desquestionnairesectioninstructions to set
	 */
	public void setDesquestionnairesectioninstructions(
			String desquestionnairesectioninstructions) {
		this.desquestionnairesectioninstructions = desquestionnairesectioninstructions;
	}

	/**
	 * @return the listItems
	 */
	public List<KtekQuestionnaireItemEntity> getListItems() {
		return listItems;
	}

	/**
	 * @param listItems the listItems to set
	 */
	public void setListItems(List<KtekQuestionnaireItemEntity> listItems) {
		this.listItems = listItems;
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