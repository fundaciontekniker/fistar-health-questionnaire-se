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


@XmlRootElement(name = "KtekQuestionnaireMonitoringScheduleEntitySet")
@XmlType(
			namespace = "http://es.tekniker.framework.ktek",
	        propOrder = {"codUser", "datefrom","dateto","listquestionnaire", "codtelecareprogram"})
public class KtekQuestionnaireMonitoringScheduleEntitySet implements Serializable{
		
	private String codUser;
	private long datefrom;
	private long dateto;
	private List<Integer> listquestionnaire;
	private String codtelecareprogram;
	/**
	 * @return the codUser
	 */
	public String getCodUser() {
		return codUser;
	}
	/**
	 * @param codUser the codUser to set
	 */
	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	/**
	 * @return the datefrom
	 */
	public long getDatefrom() {
		return datefrom;
	}
	/**
	 * @param datefrom the datefrom to set
	 */
	public void setDatefrom(long datefrom) {
		this.datefrom = datefrom;
	}
	/**
	 * @return the dateto
	 */
	public long getDateto() {
		return dateto;
	}
	/**
	 * @param dateto the dateto to set
	 */
	public void setDateto(long dateto) {
		this.dateto = dateto;
	}
	/**
	 * @return the listquestionnaire
	 */
	public List<Integer> getListquestionnaire() {
		return listquestionnaire;
	}
	/**
	 * @param listquestionnaire the listquestionnaire to set
	 */
	public void setListquestionnaire(List<Integer> listquestionnaire) {
		this.listquestionnaire = listquestionnaire;
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

	
	
	
}
