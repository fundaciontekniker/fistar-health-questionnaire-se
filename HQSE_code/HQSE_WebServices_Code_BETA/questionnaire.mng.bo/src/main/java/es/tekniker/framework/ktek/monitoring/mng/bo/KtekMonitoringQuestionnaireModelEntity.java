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
package es.tekniker.framework.ktek.monitoring.mng.bo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "KtekMonitoringQuestionnaireModelEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaire", "namequestionnaire","desquestionnaire","typemonitoringactivity","idresultquestionnaire"})
public class KtekMonitoringQuestionnaireModelEntity implements Serializable{

	private long idquestionnaire;
	private String namequestionnaire;	
	private String desquestionnaire;	
	private short typemonitoringactivity;
	
	private int idresultquestionnaire;

	public KtekMonitoringQuestionnaireModelEntity(){}

	
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


	/**
	 * @return the idresultquestionnaire
	 */
	public int getIdresultquestionnaire() {
		return idresultquestionnaire;
	}


	/**
	 * @param idresultquestionnaire the idresultquestionnaire to set
	 */
	public void setIdresultquestionnaire(int idresultquestionnaire) {
		this.idresultquestionnaire = idresultquestionnaire;
	}

	
	
}
