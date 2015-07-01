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
package es.tekniker.framework.ktek.questionnaire;

import es.tekniker.framework.ktek.dao.*;

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract Ktek_questionnaireDAO getKtek_questionnaireDAO();
	public abstract Ktek_result_questionnaireDAO getKtek_result_questionnaireDAO();
	public abstract Ktek_userquestionnaire_planningDAO getKtek_userquestionnaire_planningDAO();
	public abstract Ktek_answerDAO getKtek_answerDAO();
	public abstract Ktek_answersetDAO getKtek_answersetDAO();
	public abstract Ktek_codificationDAO getKtek_codificationDAO();
	public abstract Ktek_formatquestionnaireDAO getKtek_formatquestionnaireDAO();
	public abstract Ktek_parameterDAO getKtek_parameterDAO();
	public abstract Ktek_qitem_sectionDAO getKtek_qitem_sectionDAO();
	public abstract Ktek_qsection_questionnaireDAO getKtek_qsection_questionnaireDAO();
	public abstract Ktek_questionDAO getKtek_questionDAO();
	public abstract Ktek_questionnaireitemDAO getKtek_questionnaireitemDAO();
	public abstract Ktek_questionnaireitem_codificationDAO getKtek_questionnaireitem_codificationDAO();
	public abstract Ktek_questionnairesectionDAO getKtek_questionnairesectionDAO();
	public abstract Ktek_unitDAO getKtek_unitDAO();
	public abstract Ktek_unit_parameterDAO getKtek_unit_parameterDAO();
	public abstract Ktek_questionnaireconfigurationDAO getKtek_questionnaireconfigurationDAO();
	public abstract Ktek_result_questionnaireitemDAO getKtek_result_questionnaireitemDAO();
	public abstract Ktek_result_questionnairesectionDAO getKtek_result_questionnairesectionDAO();
}

