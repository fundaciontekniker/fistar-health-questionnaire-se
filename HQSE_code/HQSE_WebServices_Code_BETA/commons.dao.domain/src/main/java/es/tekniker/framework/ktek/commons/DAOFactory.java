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
package es.tekniker.framework.ktek.commons;

import es.tekniker.framework.ktek.dao.*;

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract Ktek_languageDAO getKtek_languageDAO();
	public abstract Ktek_pathologyDAO getKtek_pathologyDAO();
	public abstract Ktek_tpsettingsDAO getKtek_tpsettingsDAO();
	public abstract Ktek_translation_textDAO getKtek_translation_textDAO();
	public abstract Ktek_userDAO getKtek_userDAO();
	public abstract Ktek_user_extDAO getKtek_user_extDAO();
	public abstract Ktek_usersessiondataDAO getKtek_usersessiondataDAO();
	public abstract Ktek_auditaccesslogDAO getKtek_auditaccesslogDAO();
}

