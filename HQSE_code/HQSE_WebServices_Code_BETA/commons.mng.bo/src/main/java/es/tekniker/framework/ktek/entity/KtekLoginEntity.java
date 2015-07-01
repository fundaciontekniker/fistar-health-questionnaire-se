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
package es.tekniker.framework.ktek.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * Class used as input parameter on login service
 */

@XmlRootElement(name = "KtekLoginEntity")
@XmlType(
		namespace = "http://es.tekniker.framework.ktek",
        propOrder = {"reference", "password", "coordinates"})
public class KtekLoginEntity implements Serializable{

	private String reference;
	private String password;
	
	private KtekLoginCoordinatesEntity[] coordinates;
	
	
	public boolean isRequiredDataDefined(){
		boolean boolOK=true;
		
		if(reference.equals(""))
			boolOK=false;
		if(password.equals(""))
			boolOK=false;
		
		if(coordinates == null)
			boolOK=false;
		
		if(coordinates.length !=3)
			boolOK=false;
		
		if(coordinates[0].getLetter()==null && coordinates[0].getLetter().equals(""))
			boolOK=false;
		
		if(coordinates[0].getValue()==null && coordinates[0].getValue().equals(""))
			boolOK=false;
		
		if(coordinates[1].getLetter()==null && coordinates[1].getLetter().equals(""))
			boolOK=false;
		
		if(coordinates[1].getValue()==null && coordinates[1].getValue().equals(""))
			boolOK=false;
		
		if(coordinates[2].getLetter()==null && coordinates[2].getLetter().equals(""))
			boolOK=false;
		
		if(coordinates[2].getValue()==null && coordinates[2].getValue().equals(""))
			boolOK=false;
		
		return boolOK;		
	}
	
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}



	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the coordinates
	 */
	public KtekLoginCoordinatesEntity[] getCoordinates() {
		return coordinates;
	}



	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(KtekLoginCoordinatesEntity[] coordinates) {
		this.coordinates = coordinates;
	}



	public String toString(){
		String sData="reference:" + reference + " password:" + password ;		
		return sData;		
	}	
	
}
