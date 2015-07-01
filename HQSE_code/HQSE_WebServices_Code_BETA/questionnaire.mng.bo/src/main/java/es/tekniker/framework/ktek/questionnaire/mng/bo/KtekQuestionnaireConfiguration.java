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

@XmlRootElement(name = "KtekQuestionnaireConfiguration")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"idquestionnaireconfiguration","typesave","endpointserver","eventserviceoauth2headertoken","timeout","port"})
public class KtekQuestionnaireConfiguration implements Serializable{

	private int idquestionnaireconfiguration;
	
	private int typesave;
	
	private String endpointserver;
	
	private String eventserviceoauth2headertoken;
	
	private Integer timeout;
	
	private Integer port;

	public KtekQuestionnaireConfiguration(){
		
	}

	/**
	 * @return the idquestionnaireconfiguration
	 */
	public int getIdquestionnaireconfiguration() {
		return idquestionnaireconfiguration;
	}

	/**
	 * @param idquestionnaireconfiguration the idquestionnaireconfiguration to set
	 */
	public void setIdquestionnaireconfiguration(int idquestionnaireconfiguration) {
		this.idquestionnaireconfiguration = idquestionnaireconfiguration;
	}

	/**
	 * @return the typesave
	 */
	public int getTypesave() {
		return typesave;
	}

	/**
	 * @param typesave the typesave to set
	 */
	public void setTypesave(int typesave) {
		this.typesave = typesave;
	}

	/**
	 * @return the endpointserver
	 */
	public String getEndpointserver() {
		return endpointserver;
	}

	/**
	 * @param endpointserver the endpointserver to set
	 */
	public void setEndpointserver(String endpointserver) {
		this.endpointserver = endpointserver;
	}

	/**
	 * @return the eventserviceoauth2headertoken
	 */
	public String getEventserviceoauth2headertoken() {
		return eventserviceoauth2headertoken;
	}

	/**
	 * @param eventserviceoauth2headertoken the eventserviceoauth2headertoken to set
	 */
	public void setEventserviceoauth2headertoken(
			String eventserviceoauth2headertoken) {
		this.eventserviceoauth2headertoken = eventserviceoauth2headertoken;
	}

	/**
	 * @return the timeout
	 */
	public Integer getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
}
