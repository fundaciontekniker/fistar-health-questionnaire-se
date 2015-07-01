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

import es.tekniker.framework.ktek.impl.*;
import es.tekniker.framework.ktek.dao.*;

public class DAOFactoryImpl extends DAOFactory {
	private Ktek_questionnaireDAO _ktek_questionnaireDAO = new Ktek_questionnaireDAOImpl();
	public Ktek_questionnaireDAO getKtek_questionnaireDAO() {
		return _ktek_questionnaireDAO;
	}
	
	private Ktek_result_questionnaireDAO _ktek_result_questionnaireDAO = new Ktek_result_questionnaireDAOImpl();
	public Ktek_result_questionnaireDAO getKtek_result_questionnaireDAO() {
		return _ktek_result_questionnaireDAO;
	}
	
	private Ktek_userquestionnaire_planningDAO _ktek_userquestionnaire_planningDAO = new Ktek_userquestionnaire_planningDAOImpl();
	public Ktek_userquestionnaire_planningDAO getKtek_userquestionnaire_planningDAO() {
		return _ktek_userquestionnaire_planningDAO;
	}
	
	private Ktek_answerDAO _ktek_answerDAO = new Ktek_answerDAOImpl();
	public Ktek_answerDAO getKtek_answerDAO() {
		return _ktek_answerDAO;
	}
	
	private Ktek_answersetDAO _ktek_answersetDAO = new Ktek_answersetDAOImpl();
	public Ktek_answersetDAO getKtek_answersetDAO() {
		return _ktek_answersetDAO;
	}
	
	private Ktek_codificationDAO _ktek_codificationDAO = new Ktek_codificationDAOImpl();
	public Ktek_codificationDAO getKtek_codificationDAO() {
		return _ktek_codificationDAO;
	}
	
	private Ktek_formatquestionnaireDAO _ktek_formatquestionnaireDAO = new Ktek_formatquestionnaireDAOImpl();
	public Ktek_formatquestionnaireDAO getKtek_formatquestionnaireDAO() {
		return _ktek_formatquestionnaireDAO;
	}
	
	private Ktek_parameterDAO _ktek_parameterDAO = new Ktek_parameterDAOImpl();
	public Ktek_parameterDAO getKtek_parameterDAO() {
		return _ktek_parameterDAO;
	}
	
	private Ktek_qitem_sectionDAO _ktek_qitem_sectionDAO = new Ktek_qitem_sectionDAOImpl();
	public Ktek_qitem_sectionDAO getKtek_qitem_sectionDAO() {
		return _ktek_qitem_sectionDAO;
	}
	
	private Ktek_qsection_questionnaireDAO _ktek_qsection_questionnaireDAO = new Ktek_qsection_questionnaireDAOImpl();
	public Ktek_qsection_questionnaireDAO getKtek_qsection_questionnaireDAO() {
		return _ktek_qsection_questionnaireDAO;
	}
	
	private Ktek_questionDAO _ktek_questionDAO = new Ktek_questionDAOImpl();
	public Ktek_questionDAO getKtek_questionDAO() {
		return _ktek_questionDAO;
	}
	
	private Ktek_questionnaireitemDAO _ktek_questionnaireitemDAO = new Ktek_questionnaireitemDAOImpl();
	public Ktek_questionnaireitemDAO getKtek_questionnaireitemDAO() {
		return _ktek_questionnaireitemDAO;
	}
	
	private Ktek_questionnaireitem_codificationDAO _ktek_questionnaireitem_codificationDAO = new Ktek_questionnaireitem_codificationDAOImpl();
	public Ktek_questionnaireitem_codificationDAO getKtek_questionnaireitem_codificationDAO() {
		return _ktek_questionnaireitem_codificationDAO;
	}
	
	private Ktek_questionnairesectionDAO _ktek_questionnairesectionDAO = new Ktek_questionnairesectionDAOImpl();
	public Ktek_questionnairesectionDAO getKtek_questionnairesectionDAO() {
		return _ktek_questionnairesectionDAO;
	}
	
	private Ktek_unitDAO _ktek_unitDAO = new Ktek_unitDAOImpl();
	public Ktek_unitDAO getKtek_unitDAO() {
		return _ktek_unitDAO;
	}
	
	private Ktek_unit_parameterDAO _ktek_unit_parameterDAO = new Ktek_unit_parameterDAOImpl();
	public Ktek_unit_parameterDAO getKtek_unit_parameterDAO() {
		return _ktek_unit_parameterDAO;
	}
	
	private Ktek_questionnaireconfigurationDAO _ktek_questionnaireconfigurationDAO = new Ktek_questionnaireconfigurationDAOImpl();
	public Ktek_questionnaireconfigurationDAO getKtek_questionnaireconfigurationDAO() {
		return _ktek_questionnaireconfigurationDAO;
	}
	
	private Ktek_result_questionnaireitemDAO _ktek_result_questionnaireitemDAO = new Ktek_result_questionnaireitemDAOImpl();
	public Ktek_result_questionnaireitemDAO getKtek_result_questionnaireitemDAO() {
		return _ktek_result_questionnaireitemDAO;
	}
	
	private Ktek_result_questionnairesectionDAO _ktek_result_questionnairesectionDAO = new Ktek_result_questionnairesectionDAOImpl();
	public Ktek_result_questionnairesectionDAO getKtek_result_questionnairesectionDAO() {
		return _ktek_result_questionnairesectionDAO;
	}
	
}

