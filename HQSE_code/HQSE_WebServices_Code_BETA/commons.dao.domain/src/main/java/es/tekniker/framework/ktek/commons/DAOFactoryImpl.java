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

import es.tekniker.framework.ktek.impl.*;
import es.tekniker.framework.ktek.dao.*;

public class DAOFactoryImpl extends DAOFactory {
	private Ktek_languageDAO _ktek_languageDAO = new Ktek_languageDAOImpl();
	public Ktek_languageDAO getKtek_languageDAO() {
		return _ktek_languageDAO;
	}
	
	private Ktek_pathologyDAO _ktek_pathologyDAO = new Ktek_pathologyDAOImpl();
	public Ktek_pathologyDAO getKtek_pathologyDAO() {
		return _ktek_pathologyDAO;
	}
	
	private Ktek_tpsettingsDAO _ktek_tpsettingsDAO = new Ktek_tpsettingsDAOImpl();
	public Ktek_tpsettingsDAO getKtek_tpsettingsDAO() {
		return _ktek_tpsettingsDAO;
	}
	
	private Ktek_translation_textDAO _ktek_translation_textDAO = new Ktek_translation_textDAOImpl();
	public Ktek_translation_textDAO getKtek_translation_textDAO() {
		return _ktek_translation_textDAO;
	}
	
	private Ktek_userDAO _ktek_userDAO = new Ktek_userDAOImpl();
	public Ktek_userDAO getKtek_userDAO() {
		return _ktek_userDAO;
	}
	
	private Ktek_user_extDAO _ktek_user_extDAO = new Ktek_user_extDAOImpl();
	public Ktek_user_extDAO getKtek_user_extDAO() {
		return _ktek_user_extDAO;
	}
	
	private Ktek_usersessiondataDAO _ktek_usersessiondataDAO = new Ktek_usersessiondataDAOImpl();
	public Ktek_usersessiondataDAO getKtek_usersessiondataDAO() {
		return _ktek_usersessiondataDAO;
	}
	
	private Ktek_auditaccesslogDAO _ktek_auditaccesslogDAO = new Ktek_auditaccesslogDAOImpl();
	public Ktek_auditaccesslogDAO getKtek_auditaccesslogDAO() {
		return _ktek_auditaccesslogDAO;
	}
	
}

