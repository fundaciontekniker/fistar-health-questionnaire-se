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


@XmlRootElement(name = "KtekQuestionnaireMonitoringScheduleEntity")
@XmlType(
			namespace = "http://es.tekniker.framework.ktek",
	        propOrder = {"idquestionnaire", "typemonitoringactivity","statusquestionnaire","plannedfrom","plannedto","codtelecareprogram"})
public class KtekQuestionnaireMonitoringScheduleEntity implements Serializable{
		
	private long idquestionnaire;
	private short typemonitoringactivity;
	private short statusquestionnaire;
	private long plannedfrom;
	private long plannedto;
	private String codtelecareprogram;
	
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
	 * @return the statusquestionnaire
	 */
	public short getStatusquestionnaire() {
		return statusquestionnaire;
	}
	/**
	 * @param statusquestionnaire the statusquestionnaire to set
	 */
	public void setStatusquestionnaire(short statusquestionnaire) {
		this.statusquestionnaire = statusquestionnaire;
	}
	/**
	 * @return the plannedfrom
	 */
	public long getPlannedfrom() {
		return plannedfrom;
	}
	/**
	 * @param plannedfrom the plannedfrom to set
	 */
	public void setPlannedfrom(long plannedfrom) {
		this.plannedfrom = plannedfrom;
	}
	/**
	 * @return the plannedto
	 */
	public long getPlannedto() {
		return plannedto;
	}
	/**
	 * @param plannedto the plannedto to set
	 */
	
	
	public void setPlannedto(long plannedto) {
		this.plannedto = plannedto;
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
