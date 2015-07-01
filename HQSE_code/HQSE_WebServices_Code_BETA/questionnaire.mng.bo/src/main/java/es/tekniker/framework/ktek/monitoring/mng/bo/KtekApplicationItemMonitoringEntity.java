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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "KtekApplicationItemMonitoringEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"codapplicationitem", "desapplicationitem", "typeapplicationitem", "numpendingstatusquestionnaires" , "numpendinghealthquestionnaires"})
public class KtekApplicationItemMonitoringEntity implements Serializable{
	
	public KtekApplicationItemMonitoringEntity(){}

	private String codapplicationitem;
	
	private String desapplicationitem;
	
	private short typeapplicationitem;

	private long numpendingstatusquestionnaires;
	
	private long numpendinghealthquestionnaires;
	
	
	/**
	 * @return the codapplicationitem
	 */
	public String getCodapplicationitem() {
		return codapplicationitem;
	}

	/**
	 * @param codapplicationitem the codapplicationitem to set
	 */
	public void setCodapplicationitem(String codapplicationitem) {
		this.codapplicationitem = codapplicationitem;
	}

	/**
	 * @return the desapplicationitem
	 */
	public String getDesapplicationitem() {
		return desapplicationitem;
	}

	/**
	 * @param desapplicationitem the desapplicationitem to set
	 */
	public void setDesapplicationitem(String desapplicationitem) {
		this.desapplicationitem = desapplicationitem;
	}

	/**
	 * @return the typeapplicationitem
	 */
	public short getTypeapplicationitem() {
		return typeapplicationitem;
	}

	/**
	 * @param typeapplicationitem the typeapplicationitem to set
	 */
	public void setTypeapplicationitem(short typeapplicationitem) {
		this.typeapplicationitem = typeapplicationitem;
	}

	/**
	 * @return the numpendingstatusquestionnaires
	 */
	public long getNumpendingstatusquestionnaires() {
		return numpendingstatusquestionnaires;
	}

	/**
	 * @param numpendingstatusquestionnaires the numpendingstatusquestionnaires to set
	 */
	public void setNumpendingstatusquestionnaires(
			long numpendingstatusquestionnaires) {
		this.numpendingstatusquestionnaires = numpendingstatusquestionnaires;
	}

	/**
	 * @return the numpendinghealthquestionnaires
	 */
	public long getNumpendinghealthquestionnaires() {
		return numpendinghealthquestionnaires;
	}

	/**
	 * @param numpendinghealthquestionnaires the numpendinghealthquestionnaires to set
	 */
	public void setNumpendinghealthquestionnaires(
			long numpendinghealthquestionnaires) {
		this.numpendinghealthquestionnaires = numpendinghealthquestionnaires;
	}

	
	
	
}
