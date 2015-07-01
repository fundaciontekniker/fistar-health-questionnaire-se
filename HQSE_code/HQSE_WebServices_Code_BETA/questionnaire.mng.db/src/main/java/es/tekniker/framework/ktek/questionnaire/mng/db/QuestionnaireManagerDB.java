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
package es.tekniker.framework.ktek.questionnaire.mng.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import es.tekniker.framework.ktek.Ktek_answer;
import es.tekniker.framework.ktek.Ktek_answerCriteria;
import es.tekniker.framework.ktek.Ktek_answersetCriteria;
import es.tekniker.framework.ktek.Ktek_formatquestionnaire;
import es.tekniker.framework.ktek.Ktek_formatquestionnaireCriteria;
import es.tekniker.framework.ktek.Ktek_parameter;
import es.tekniker.framework.ktek.Ktek_parameterCriteria;
import es.tekniker.framework.ktek.Ktek_qitem_sectionCriteria;
import es.tekniker.framework.ktek.Ktek_qsection_questionnaireCriteria;
import es.tekniker.framework.ktek.Ktek_question;
import es.tekniker.framework.ktek.Ktek_questionCriteria;
import es.tekniker.framework.ktek.Ktek_questionnaire;
import es.tekniker.framework.ktek.Ktek_questionnaireCriteria;
import es.tekniker.framework.ktek.Ktek_questionnaireconfiguration;
import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_questionnaireitemCriteria;
import es.tekniker.framework.ktek.Ktek_questionnairesection;
import es.tekniker.framework.ktek.Ktek_questionnairesectionCriteria;
import es.tekniker.framework.ktek.Ktek_result_questionnaire;
import es.tekniker.framework.ktek.Ktek_result_questionnaireCriteria;
import es.tekniker.framework.ktek.Ktek_result_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_result_questionnaireitemCriteria;
import es.tekniker.framework.ktek.Ktek_result_questionnairesection;
import es.tekniker.framework.ktek.Ktek_result_questionnairesectionCriteria;
import es.tekniker.framework.ktek.Ktek_unit;
import es.tekniker.framework.ktek.Ktek_unitCriteria;
import es.tekniker.framework.ktek.Ktek_userquestionnaire_planning;
import es.tekniker.framework.ktek.Ktek_userquestionnaire_planningCriteria;
import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.dao.Ktek_answerDAO;
import es.tekniker.framework.ktek.dao.Ktek_formatquestionnaireDAO;
import es.tekniker.framework.ktek.dao.Ktek_parameterDAO;
import es.tekniker.framework.ktek.dao.Ktek_questionDAO;
import es.tekniker.framework.ktek.dao.Ktek_questionnaireDAO;
import es.tekniker.framework.ktek.dao.Ktek_questionnaireconfigurationDAO;
import es.tekniker.framework.ktek.dao.Ktek_questionnaireitemDAO;
import es.tekniker.framework.ktek.dao.Ktek_questionnairesectionDAO;
import es.tekniker.framework.ktek.dao.Ktek_result_questionnaireDAO;
import es.tekniker.framework.ktek.dao.Ktek_result_questionnaireitemDAO;
import es.tekniker.framework.ktek.dao.Ktek_result_questionnairesectionDAO;
import es.tekniker.framework.ktek.dao.Ktek_unitDAO;
import es.tekniker.framework.ktek.dao.Ktek_userquestionnaire_planningDAO;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.exception.KtekExceptionCode;
import es.tekniker.framework.ktek.exception.KtekExceptionMessage;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireItemResultType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireItemType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireParameterType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireQuestionFormatAnswerUniqueType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireStatus;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireType;
import es.tekniker.framework.ktek.questionnaire.DAOFactory;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionResultEntity;
import es.tekniker.framework.ktek.util.Utils;

public class QuestionnaireManagerDB {

	private static final Log log = LogFactory.getLog(QuestionnaireManagerDB.class);
	
	public Ktek_questionnaire getQuestionnaireModel(int idquestionnaire) {
		
		Ktek_questionnaire  instance = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireDAO instanceDAO =  null;
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null;
		long nowInMillis = 0;
		try {
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
						
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_questionnaireDAO();
			
			objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();
			objKtek_questionnaireCriteria.isdeleted.eq((short) 0);
			objKtek_questionnaireCriteria.datevalidfrom.lt(nowInMillis);

			objKtek_questionnaireCriteria.add(Restrictions.or(Restrictions.isNull("datevalidto"), Restrictions.gt("datevalidto", nowInMillis)));
			
			objKtek_questionnaireCriteria.ktek_pk_idquestionnaire.eq(idquestionnaire);
			instance = instanceDAO.loadKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
			
			session.close();
			
			if(instance!=null){
				log.debug("getQuestionnaireModel is not null " );
			}else {
				log.debug("getQuestionnaireModel is null " );
			}
			
		}catch (Exception e) {
			log.error("getQuestionnaireModel Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return instance;
	}

	public Ktek_formatquestionnaire getQuestionnaireAssessmentConfiguration(int idquestionnaire) {
		Ktek_formatquestionnaire  instance = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_formatquestionnaireDAO instanceDAO =  null;
		Ktek_formatquestionnaireCriteria objKtek_formatquestionnaireCriteria = null;
		Ktek_questionnaireCriteria objKtek_fk_questionnaireCriteria = null;
		long nowInMillis = 0;
		
		try {
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_formatquestionnaireDAO();		
			
			objKtek_formatquestionnaireCriteria = new Ktek_formatquestionnaireCriteria();
			objKtek_fk_questionnaireCriteria = objKtek_formatquestionnaireCriteria.createKtek_fk_questionnaireCriteria();			
			objKtek_fk_questionnaireCriteria.ktek_pk_idquestionnaire.eq(idquestionnaire);
			objKtek_fk_questionnaireCriteria.isdeleted.eq((short)0);
			objKtek_fk_questionnaireCriteria.datevalidfrom.lt(nowInMillis);
			objKtek_fk_questionnaireCriteria.add(Restrictions.or(Restrictions.isNull("datevalidto"), Restrictions.gt("datevalidto", nowInMillis)));
			
			instance = instanceDAO.loadKtek_formatquestionnaireByCriteria(objKtek_formatquestionnaireCriteria);
			
			session.close();
			
			if(instance!=null){
				log.debug("getQuestionnaireAssesmentConfiguration is not null " );
			}else {
				log.debug("getQuestionnaireAssesmentConfiguration is null " );
			}
			
		}catch (Exception e) {
			log.error("getQuestionnaireAssesmentConfiguration Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
		}
		return instance;
	}

	public Ktek_questionnairesection[] getQuestionnaireAssessmentSectionList(int idquestionnaire) {
		Ktek_questionnairesection[]  instanceArray= null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnairesectionDAO instanceDAO = null;
		Ktek_questionnairesectionCriteria objKtek_questionnairesectionCriteria = null;
		Ktek_qsection_questionnaireCriteria objKtek_qsection_questionnaireCriteria = null;
		Ktek_questionnaireCriteria objKtek_fk_idquestionnaireCriteria = null;
		long nowInMillis = 0;
		
		try {
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
						
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_questionnairesectionDAO();			
			objKtek_questionnairesectionCriteria = new Ktek_questionnairesectionCriteria();			
			objKtek_qsection_questionnaireCriteria = objKtek_questionnairesectionCriteria.createKtek_qsection_questionnaireCriteria();			
			objKtek_qsection_questionnaireCriteria.ktek_fk_idquestionnaire_ktek_pk_idquestionnaire.eq(idquestionnaire);
			
			objKtek_fk_idquestionnaireCriteria = objKtek_qsection_questionnaireCriteria.createKtek_fk_idquestionnaireCriteria();
			objKtek_fk_idquestionnaireCriteria.ktek_pk_idquestionnaire.eq(idquestionnaire);
			objKtek_fk_idquestionnaireCriteria.isdeleted.eq((short)0);
			objKtek_fk_idquestionnaireCriteria.datevalidfrom.lt(nowInMillis);
			
			objKtek_fk_idquestionnaireCriteria.add(Restrictions.or(Restrictions.isNull("datevalidto"), Restrictions.gt("datevalidto", nowInMillis)));
						
			instanceArray=instanceDAO.listKtek_questionnairesectionByCriteria(objKtek_questionnairesectionCriteria);
		
			session.close();
			
			if(instanceArray!=null){
				log.debug("getQuestionnaireAssesmentSectionList is not null " );
			}else {
				log.debug("getQuestionnaireAssesmentSectionList is null " );
			}
			
		}catch (Exception e) {
			log.error("getQuestionnaireAssesmentSectionList Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
		}
		return instanceArray;
	}
	
	public Ktek_questionnaireitem[] getQuestionnaireItemList4Section(int idQuestionaireSection){
		Ktek_questionnaireitem[] instanceArray = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireitemDAO instanceDAO = null;
		Ktek_questionnaireitemCriteria objKtek_questionnaireitemCriteria = null;
		Ktek_qitem_sectionCriteria objKtek_qitem_sectionCriteria = null;
		
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_questionnaireitemDAO();
			
			objKtek_questionnaireitemCriteria = new Ktek_questionnaireitemCriteria();
			objKtek_qitem_sectionCriteria = objKtek_questionnaireitemCriteria.createKtek_qitem_sectionCriteria();
			
			objKtek_qitem_sectionCriteria.ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection.eq(idQuestionaireSection);
			objKtek_qitem_sectionCriteria.addOrder(Order.asc("sortorder"));
			
			instanceArray = instanceDAO.listKtek_questionnaireitemByCriteria(objKtek_questionnaireitemCriteria);
						
			session.close();
			
		}catch (Exception e) {
			log.error("getQuestionnaireItemList4Section Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
		}
		return instanceArray;
	}
	
	public Ktek_answer[] getQuestionnaireItemAnwser4QuestionnaireItem(int idquestionnaireitem , int idanswerset){
		Ktek_answer[] arrayInstance = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_answerDAO instanceDAO = null;
		Ktek_answerCriteria objKtek_answerCriteria = null;
		Ktek_answersetCriteria objKtekAnswersetCriteria = null;
		Ktek_questionnaireitemCriteria objKtek_fk_idquestionnaireitemCriteria = null;
		try{
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_answerDAO();
			
			objKtek_answerCriteria = new Ktek_answerCriteria();
						
			if(idanswerset>0){				
				objKtekAnswersetCriteria = objKtek_answerCriteria.createKtek_fk_idanswersetCriteria();
				objKtekAnswersetCriteria.ktek_pk_idanswerset.eq(idanswerset);
			}else{
				objKtek_fk_idquestionnaireitemCriteria = objKtek_answerCriteria.createKtek_fk_idquestionnaireitemCriteria().createKtek_fk_idquestionnaireitemCriteria();
				objKtek_fk_idquestionnaireitemCriteria.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem);
				objKtek_fk_idquestionnaireitemCriteria.isdeleted.eq((short)0);
			}
			
			arrayInstance = instanceDAO.listKtek_answerByCriteria(objKtek_answerCriteria);
			
			session.close();
			
		}catch (Exception e) {
			log.error("getQuestionnaireItemAnwser4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
		}
		
		return arrayInstance;
	}
	
	public Ktek_question getQuestion4QuestionnaireItem(PersistentSession session, int idquestionnaireitem){
		Ktek_question instance = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionDAO instanceDAO = null;
		Ktek_questionCriteria objKtek_questionCriteria = null;
		Ktek_questionnaireitemCriteria objKtek_fk_idquestionnaireitemCriteria = null;
		try {
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_questionDAO();
			
			objKtek_questionCriteria= new Ktek_questionCriteria();
			objKtek_fk_idquestionnaireitemCriteria = objKtek_questionCriteria.createKtek_fk_idquestionnaireitemCriteria();
			objKtek_fk_idquestionnaireitemCriteria.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem);
			objKtek_fk_idquestionnaireitemCriteria.isdeleted.eq((short)0);
						
			instance=instanceDAO.loadKtek_questionByCriteria(objKtek_questionCriteria);
			
		}catch (Exception e) {
			log.error("getQuestion4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();
		}

		return instance;
	}
	
	public Ktek_question getQuestion4QuestionnaireItem(int idquestionnaireitem){
		Ktek_question instance = null;
		PersistentSession session = null;
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			instance=getQuestion4QuestionnaireItem(session,idquestionnaireitem );
			
			session.close();
			
		}catch (Exception e) {
			log.error("getQuestion4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
		}

		return instance;
	}
	
	public Ktek_result_questionnaire  saveQuestionnaireResultByStepsLogic(KtekQuestionnaireResultEntity instance) throws KtekExceptionEntity  {
		boolean boolOK=true;
		
		Ktek_questionnaire objQuestionnaire = null;
		Ktek_questionnairesection objQuestionnaireSection = null; 
		Ktek_questionnaireitem objQuestionnaireItem = null;
		Ktek_answer instanceAnswer = null;
		String codAnswer = null;		
		Ktek_result_questionnaire objResultQuestionnaire= null;		
		Ktek_result_questionnairesection objResultQuestionnaireSection = null;
		KtekQuestionnaireSectionResultEntity itResultQuestionnaireSection = null;
		KtekQuestionnaireItemResultEntity itResultQuestionnaireItem = null;
		Iterator<KtekQuestionnaireSectionResultEntity> itSection = null;
		Iterator<KtekQuestionnaireItemResultEntity> itItem =  null;
		PersistentSession session = null;
		PersistentTransaction tr = null;
		short scoreAnswer = 0; 
		short typeResult= 0; 
		short scoreQuestionnaireSection = 0;
		CommonsMngServer manager = null;
		String exceptionText = null;
		String paramValue = null;
		float decParamValue =0;
		long longParamValue=0;
		String stringParamValue =null, textParamValue = null;
		Ktek_parameter parameterDB = null;
		Ktek_userquestionnaire_planning instanceQuestionnaireUserPlanning = null;
		String sFunction ="QuestionnaireManagerDB.saveQuestionnaireResultByStepsLogic";
		
		try{
			
			log.info("saveQuestionnaireResultByStepsLogic START ");
			manager = new CommonsMngServer();
			
			// 1- OPEN CONNECTION AND TRANSACTION TO DATABASE
			log.info("saveQuestionnaireResultByStepsLogic 1: OPEN CONNECTION AND TRANSACTION TO DATABASE ");
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			tr = session.beginTransaction();

			// 2- GET KTEK_QUESTIONNAIRE
			log.info("saveQuestionnaireResultByStepsLogic 2: GET KTEK_QUESTIONNAIRE " );
			
			objQuestionnaire = getQuestionnaire(session, instance.getIdquestionnaire());
			
			if (objQuestionnaire == null)
			{
				log.debug("saveQuestionnaireResultByStepsLogic objQuestionnaire is null ");
				
				exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);
				e.setMessage(exceptionText);
				e.setFunction(sFunction);
				e.setParams(String.valueOf(instance.getIdquestionnaire()));				
				throw e;				
			}			
			if(objQuestionnaire.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING){
					
				// 3- GET Ktek_userquestionnaire_planning INSTANCE IS EXISTS
				if (instance.getIduserquestionnaireplanning()>0){
					instanceQuestionnaireUserPlanning = getQuestionnaireUserPlanning(session,instance.getIduserquestionnaireplanning());	
					
					log.debug("instanceQuestionnaireUserPlanning " + instance.getIduserquestionnaireplanning() );
					
					//CHECK IF STATUS IS DONE
					if(instanceQuestionnaireUserPlanning.getStatusquestionnaire()==KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED){
						log.debug("instanceQuestionnaireUserPlanning " + instance.getIduserquestionnaireplanning() + " with status " +KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED );
						
						exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_ALREADY_DONE);				
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_ALREADY_DONE);
						e.setMessage(exceptionText);
						e.setFunction(sFunction);
						e.setParams(String.valueOf(instance.getIdquestionnaire()));				
						throw e;	
					}				
				}else{
					log.debug("instanceQuestionnaireUserPlanning Iduserquestionnaireplanning no defined " + instance.getIduserquestionnaireplanning() );
					
					exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_NO_DEFINED);				
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_NO_DEFINED);
					e.setMessage(exceptionText);
					e.setFunction(sFunction);
					e.setParams(String.valueOf(instance.getIdquestionnaire()));				
					throw e;
				}
			}
			
			// 4- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE 
			log.info("saveQuestionnaireResultByStepsLogic 4: INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE  " );
			
			objResultQuestionnaire=saveQuestionnaireResult(session, instance.getCodtelecareprogram(), instance.getCoduser(), instance.getScore(), objQuestionnaire, instanceQuestionnaireUserPlanning );
			if (objResultQuestionnaire == null)
			{
				log.debug("saveQuestionnaireResultByStepsLogic objResultQuestionnaire is null ");
				
				exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);
				e.setMessage(exceptionText);
				e.setFunction(sFunction);
				e.setParams(String.valueOf(instance.getIdquestionnaire() + " "  + instance.getCodtelecareprogram() + " " + instance.getCoduser() ));				
				throw e;				
			}	
			
			// 5- PARSE RESULT QUESTIONNAIRE SECTIONS
			log.info("saveQuestionnaireResultByStepsLogic 5: PARSE RESULT QUESTIONNAIRE SECTIONS " );
			itSection = instance.getListsections().iterator();
			
			while(itSection.hasNext()){
				itResultQuestionnaireSection = (KtekQuestionnaireSectionResultEntity)itSection.next();
				
			// 6 GET QUESTIONNAIRE SECTION 
				log.info("saveQuestionnaireResultByStepsLogic 6- GET QUESTIONNAIRE SECTION " );
				objQuestionnaireSection = getQuestionnaireSection(session, itResultQuestionnaireSection.getIdquestionnairesection());
				
				if(objQuestionnaireSection==null){
					log.debug("saveQuestionnaireResultByStepsLogic objQuestionnaireSection is null ");
					
					exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_DOES_NOT_EXIST);				
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_DOES_NOT_EXIST);
					e.setMessage(exceptionText);
					e.setFunction(sFunction);
					e.setParams(String.valueOf(itResultQuestionnaireSection.getIdquestionnairesection()));				
					throw e;
				}
				
			// 7- INSERT in TABLE KTEK_RESULT_QUESTIONNAIRESECTION 
				log.info("saveQuestionnaireResultByStepsLogic 7- INSERT in TABLE KTEK_RESULT_QUESTIONAIRESECTION " );
				scoreQuestionnaireSection = itResultQuestionnaireSection.getScore();
				objResultQuestionnaireSection=saveQuestionnaireSectionResult(session, scoreQuestionnaireSection, objResultQuestionnaire, objQuestionnaireSection );
							
			// 8- PARSE RESULT QUESTIONNAIRE ITEMS
				log.info("saveQuestionnaireResultByStepsLogic 8- PARSE RESULT QUESTIONNAIRE ITEMS " );
				itItem = itResultQuestionnaireSection.getListitems().iterator();			

				while(itItem.hasNext()){
					itResultQuestionnaireItem = (KtekQuestionnaireItemResultEntity)itItem.next();
				
			// 9- GET QUESTIONNAIRE ITEM
					log.info("saveQuestionnaireResultByStepsLogic 9- GET QUESTIONNAIRE ITEM " );
					objQuestionnaireItem = getQuestionnaireItem(session, itResultQuestionnaireItem.getIdquestionnaireitem());
					
			// 10- GET LIST CODANSWER
					if(itResultQuestionnaireItem.getListcodanswer() != null){
						for(int i=0; i<itResultQuestionnaireItem.getListcodanswer().length;i++){
							
							codAnswer = itResultQuestionnaireItem.getListcodanswer()[i];
							instanceAnswer = getQuestionnaireAnswer(session, codAnswer);
							
							if(instanceAnswer == null){
								log.debug("saveQuestionnaireResultByStepsLogic instanceAnswer is null ");
								
								exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_ANSWER_DOES_NOT_EXIST);				
								KtekExceptionEntity e= new KtekExceptionEntity();
								e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_ANSWER_DOES_NOT_EXIST);
								e.setMessage(exceptionText);
								e.setFunction(sFunction);
								e.setParams(String.valueOf(itResultQuestionnaireSection.getIdquestionnairesection()) + "  codAnswer " + codAnswer);				
								throw e;
							}else{
								scoreAnswer=instanceAnswer.getScoreanswer();
							}
							
			// 11- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM
							log.info("saveQuestionnaireResultByStepsLogic 11- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM answer " +codAnswer );
							typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_ANSWERSET;
							decParamValue=0;
							longParamValue=0;
							stringParamValue=null;
							textParamValue=null;
							saveQuestionnaireItemResult(session,
														codAnswer,
														decParamValue,
														longParamValue,
														stringParamValue,
														textParamValue,
														objQuestionnaireItem,
														objResultQuestionnaireSection,
														scoreAnswer,
														typeResult);
						}
					}
			//12 - Get PARAMETERs 
					else if(objQuestionnaireItem.getTypequestionnaireitem()==KtekQuestionnaireItemType.QUESTIONNAIRE_ITEM_PARAMETER){
						
						paramValue = itResultQuestionnaireItem.getParamvalue();
						if(paramValue != null && objQuestionnaireItem.getKtek_pk_idquestionnaireitem()>0){
							parameterDB = getQuestionnaireParameters4QuestionnaireItem(session, objQuestionnaireItem.getKtek_pk_idquestionnaireitem());
							if(parameterDB != null){
								decParamValue=0;
								longParamValue=0;
								if(parameterDB.getTypeparameter()==KtekQuestionnaireParameterType.QUESTIONNAIRE_PARAMETER_TYPE_INTEGER){
									longParamValue = Integer.valueOf(paramValue);
									typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_INTEGER;
								} else if(parameterDB.getTypeparameter()==KtekQuestionnaireParameterType.QUESTIONNAIRE_PARAMETER_TYPE_DECIMAL){
									decParamValue = Float.valueOf(paramValue);
									typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DECIMAL;
								}
								
								codAnswer=null;
								scoreAnswer=0;
								stringParamValue=null;
								textParamValue=null;

								log.info("saveQuestionnaireResultByStepsLogic 12- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM parameter" );
		
								saveQuestionnaireItemResult(session,
										codAnswer,
										decParamValue,
										longParamValue,
										stringParamValue,
										textParamValue,
										objQuestionnaireItem,
										objResultQuestionnaireSection,
										scoreAnswer,
										typeResult);
							}
						}else{
							log.info("saveQuestionnaireResultByStepsLogic 12- NO parameter to INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM " );
						}
					}
			//13 - Get ANSWERs values 
					else if(objQuestionnaireItem.getTypequestionnaireitem()==KtekQuestionnaireItemType.QUESTIONNAIRE_ITEM_QUESTION){
						paramValue = itResultQuestionnaireItem.getAnswervalue();
						if(paramValue != null && objQuestionnaireItem.getKtek_pk_idquestionnaireitem()>0){
							//get ktek_question to verify typeanswer and formatanswerunique
							
							longParamValue = 0;
							decParamValue = 0;
							stringParamValue = null;
							textParamValue = null;
							decParamValue = 0;
							
							if(objQuestionnaireItem.getKtek_question().getFormatanswerunique()==KtekQuestionnaireQuestionFormatAnswerUniqueType.QUESTIONNAIRE_QUESTION_FORMAT_ANSWER_UNIQUE_INTEGER){
								longParamValue = Integer.valueOf(paramValue);
								typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_INTEGER;
							}else if(objQuestionnaireItem.getKtek_question().getFormatanswerunique()==KtekQuestionnaireQuestionFormatAnswerUniqueType.QUESTIONNAIRE_QUESTION_FORMAT_ANSWER_UNIQUE_DECIMAL){
								decParamValue = Float.valueOf(paramValue);
								typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DECIMAL;
							}else if(objQuestionnaireItem.getKtek_question().getFormatanswerunique()==KtekQuestionnaireQuestionFormatAnswerUniqueType.QUESTIONNAIRE_QUESTION_FORMAT_ANSWER_UNIQUE_STRING){
								stringParamValue = paramValue;
								typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_STRING;
							}else if(objQuestionnaireItem.getKtek_question().getFormatanswerunique()==KtekQuestionnaireQuestionFormatAnswerUniqueType.QUESTIONNAIRE_QUESTION_FORMAT_ANSWER_UNIQUE_TEXT){
								textParamValue = paramValue;
								typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_TEXT;
							}else if(objQuestionnaireItem.getKtek_question().getFormatanswerunique()==KtekQuestionnaireQuestionFormatAnswerUniqueType.QUESTIONNAIRE_QUESTION_FORMAT_ANSWER_UNIQUE_DATE){
								decParamValue = Float.valueOf(paramValue);
								typeResult= KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DATETIME;
							}						
							
							//reset previous value 	
							scoreAnswer=0;
							
							instanceAnswer = getQuestionnaireAnswer(session, codAnswer);
							
							if(instanceAnswer != null){
								scoreAnswer=instanceAnswer.getScoreanswer();
								log.info("saveQuestionnaireResultByStepsLogic 13- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM answers scoreAnswer " + scoreAnswer );
							}
							
							codAnswer=null;
							log.info("saveQuestionnaireResultByStepsLogic 13- INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM answers values" );
	
							saveQuestionnaireItemResult(session,
									codAnswer,
									decParamValue,
									longParamValue,
									stringParamValue,
									textParamValue,
									objQuestionnaireItem,
									objResultQuestionnaireSection,
									scoreAnswer,
									typeResult);
						}else{
							log.info("saveQuestionnaireResultByStepsLogic 13- NO answer value to INSERT IN TABLE KTEK_RESULT_QUESTIONNAIRE ITEM " );
						}
					}
					
				}
			}		
			
			// 14- UPDATE USER QUESTIONNAIRE PLANNING STATE : ONLY FOR MONITORING QUESTIONNAIRE
			if(objQuestionnaire.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING){
				
				if(instance.getIduserquestionnaireplanning()>0){
					boolOK= updateUserQuestionnairePlanning(session , instance.getIduserquestionnaireplanning(), KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED);
				}
				else{
					log.error("Questionnaire has no value for Iduserquestionnaireplanning");
				}
			}
			
			if(tr.wasCommitted()==false)
				tr.commit();
			
			session.close();
			
			log.info("saveQuestionnaireResultByStepsLogic END ");

		}catch (PersistentException e) {			
			e.printStackTrace();	
			try {
				if(tr!=null)
					tr.rollback();
				
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);				
			KtekExceptionEntity eQsave= new KtekExceptionEntity();
			eQsave.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);
			eQsave.setMessage(exceptionText);
			eQsave.setFunction(sFunction);
			eQsave.setParams(String.valueOf(instance.getIdquestionnaire()));				
			throw eQsave;
			
		}catch (KtekExceptionEntity eKtekExceptionEntity) {
			throw eKtekExceptionEntity;
		}catch (Exception e) {
			e.printStackTrace();	
			try {
				if(tr!=null)
					tr.rollback();
				
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				e1.printStackTrace();
			}
			exceptionText = manager.getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);				
			KtekExceptionEntity eQsave= new KtekExceptionEntity();
			eQsave.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR);
			eQsave.setMessage(exceptionText);
			eQsave.setFunction(sFunction);
			eQsave.setParams(String.valueOf(instance.getIdquestionnaire()));				
			throw eQsave;
		}
	
		return objResultQuestionnaire;
	}
	
	private Ktek_userquestionnaire_planning getQuestionnaireUserPlanning(PersistentSession session , int iduserquestionnaireplanning) {
		Ktek_userquestionnaire_planning instance = null;
		DAOFactory lDAOFactory = null;
		Ktek_userquestionnaire_planningDAO instanceDAO = null;
		
		try {
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_userquestionnaire_planningDAO();
			instance= instanceDAO.getKtek_userquestionnaire_planningByORMID(iduserquestionnaireplanning);
			
		} catch (PersistentException e) {
			log.error("getQuestionnaireUserPlanning Exception " + e.getMessage());			
			e.printStackTrace();	
		}
		
		return instance;
	}

	private boolean updateUserQuestionnairePlanning(PersistentSession session,int iduserquestionnaireplanning, short state) {
		boolean boolOK=true;
		DAOFactory lDAOFactory = null;
		Ktek_userquestionnaire_planningDAO instanceDAO = null;
		Ktek_userquestionnaire_planning instance = null;
		
		try {
		
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_userquestionnaire_planningDAO();
			
			instance = instanceDAO.getKtek_userquestionnaire_planningByORMID(iduserquestionnaireplanning);
			instance.setStatusquestionnaire(state);
			
			boolOK=instanceDAO.save(instance);
		
		} catch (PersistentException e) {
			boolOK=false;
			log.error("updateUserQuestionnairePlanning Exception " + e.getMessage());
			e.printStackTrace();				
		}
		
		return boolOK;
	}

	private Ktek_result_questionnaire saveQuestionnaireResult(PersistentSession session, String codTelecareProgram, String codUserId, short score, Ktek_questionnaire idquestionnaire, Ktek_userquestionnaire_planning userquestionnaireplanning) throws Exception{
		
		boolean boolOK=true;
		Ktek_result_questionnaire objKtek_result_questionnaire = null;
		long resultCreation=0;
				
		try {
			
			resultCreation = Utils.getCalendarGMT().getTimeInMillis();
						
			objKtek_result_questionnaire = new Ktek_result_questionnaire();			
			objKtek_result_questionnaire.setCodtelecareprogram(codTelecareProgram);
			objKtek_result_questionnaire.setCoduserid(codUserId);
			objKtek_result_questionnaire.setEvaluationscorequestionnaire(score);
			objKtek_result_questionnaire.setKtek_fk_idquestionnaire(idquestionnaire);
			objKtek_result_questionnaire.setResultcreation(resultCreation);
			if(userquestionnaireplanning!=null)
				objKtek_result_questionnaire.setKtek_fk_iduserquestionnaireplanning(userquestionnaireplanning);	
			
			session.save(objKtek_result_questionnaire);
			if(boolOK){
				log.info("saveQuestionnaireResult OK " + objKtek_result_questionnaire.getKtek_pk_idresultquestionnaire());				
			}else{
				log.info("saveQuestionnaireResult ERROR");
			}
			
		}catch (Exception e) {
			log.error("saveQuestionnaireResult Exception " + e.getMessage());			
			e.printStackTrace();	
			throw e;
		}
		return objKtek_result_questionnaire;
	}
	
	private Ktek_result_questionnairesection saveQuestionnaireSectionResult(PersistentSession session , short score, Ktek_result_questionnaire idResultQuestionnaire, Ktek_questionnairesection idQuestionnaireSection) throws Exception{
		Ktek_result_questionnairesection objKtek_result_questionnairesection  = null;
		
		try {
			objKtek_result_questionnairesection = new Ktek_result_questionnairesection();			
			objKtek_result_questionnairesection.setEvaluationscorequestionnairesection(score);
			objKtek_result_questionnairesection.setKtek_fk_idresultquestionnaire(idResultQuestionnaire);
			objKtek_result_questionnairesection.setKtek_fk_idquestionnairesection(idQuestionnaireSection);
						
			session.save(objKtek_result_questionnairesection);
			
		}catch (Exception e) {
			log.error("saveQuestionnaireSectionResult Exception " + e.getMessage());			
			e.printStackTrace();	
			throw e;
		}
		
		return objKtek_result_questionnairesection;
	}
		
	
	private Ktek_result_questionnaireitem saveQuestionnaireItemResult(PersistentSession session, String codAnswer, double decValue, long longValue, String stringValue, String textValue, Ktek_questionnaireitem objQuestionnaireItem, Ktek_result_questionnairesection objQuestionnaireSection, short score, short type) throws Exception {
		Ktek_result_questionnaireitem instance =null;		
		Ktek_result_questionnaireitem objKtek_result_questionnaireitem = null;
		boolean boolOK= true;
		
		try {
						
			objKtek_result_questionnaireitem = new Ktek_result_questionnaireitem ();		
			
			if(codAnswer !=null){ //for ANSWERS
				objKtek_result_questionnaireitem.setCodanswer(codAnswer);
				objKtek_result_questionnaireitem.setScoreanswer(score);				
			}else{ // for PARAMETERS
				objKtek_result_questionnaireitem.setDecimalvalue((float) decValue);
				objKtek_result_questionnaireitem.setIntegervalue(longValue);
				
				objKtek_result_questionnaireitem.setTextvalue(textValue);
				objKtek_result_questionnaireitem.setStringvalue(stringValue);
			}
			
			objKtek_result_questionnaireitem.setKtek_fk_idquestionnaireitem(objQuestionnaireItem); //objQuestionnaireItem
			objKtek_result_questionnaireitem.setKtek_fk_idresultquestionnairesection(objQuestionnaireSection);
			objKtek_result_questionnaireitem.setTyperesult(type);
			
			session.save(objKtek_result_questionnaireitem);
			
			if(boolOK){
				log.info("saveQuestionnaireItemResult OK ");
			}
			else{
				log.info("saveQuestionnaireItemResult ERROR ");
			}
			
		}catch (Exception e) {
			log.error("saveQuestionnaireItemResult Exception " + e.getMessage());			
			e.printStackTrace();
			throw e;
		}
		return instance;		
	}
	
	public Ktek_questionnaire getQuestionnaire(int idquestionnaire) {
		Ktek_questionnaire instance= null;		
		DAOFactory lDAOFactory = null;
		PersistentSession session = null;
		Ktek_questionnaireDAO instanceDAO = null;
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null; 
		long nowInMillis = 0;
		try{
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireDAO();
			
			objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();
			objKtek_questionnaireCriteria.ktek_pk_idquestionnaire.eq(idquestionnaire);
			objKtek_questionnaireCriteria.isdeleted.eq((short)0);
			objKtek_questionnaireCriteria.datevalidfrom.lt(nowInMillis);

			objKtek_questionnaireCriteria.add(Restrictions.or(Restrictions.isNull("datevalidto"), Restrictions.gt("datevalidto", nowInMillis)));
						
			instance=instanceDAO.loadKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
						
			if (instance!=null)
				log.debug("getQuestionnaire instance is not null");
			else
				log.info("getQuestionnaire instance is null for idquestionnaire " + idquestionnaire);
			
			session.close();
			
		}catch (Exception e) {
			log.error("getQuestionnaire Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)						
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return instance;
	}

	public Ktek_questionnaire getQuestionnaire(PersistentSession session , int idquestionnaire) throws Exception{
		Ktek_questionnaire instance= null;		
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireDAO instanceDAO = null;
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null; 
		long nowInMillis = 0;
		try{
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireDAO();
			
			objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();
			objKtek_questionnaireCriteria.ktek_pk_idquestionnaire.eq(idquestionnaire);
			objKtek_questionnaireCriteria.isdeleted.eq((short)0);
			objKtek_questionnaireCriteria.datevalidfrom.lt(nowInMillis);
			
			objKtek_questionnaireCriteria.add(Restrictions.or(Restrictions.isNull("datevalidto"), Restrictions.gt("datevalidto", nowInMillis)));
			
			instance=instanceDAO.loadKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
						
			if (instance!=null)
				log.debug("getQuestionnaire instance is not null");
			else
				log.info("getQuestionnaire instance is null for idquestionnaire " + idquestionnaire);
			
		}catch (Exception e) {
			log.error("getQuestionnaire Exception " + e.getMessage());			
			e.printStackTrace();	
			throw e;
		}
		
		return instance;
	}

	public Ktek_questionnaireitem getQuestionnaireItem(int idresultquestionnaire) throws Exception {
		Ktek_questionnaireitem instance = null;
		DAOFactory lDAOFactory = null;		
		PersistentSession session = null;
		Ktek_questionnaireitemDAO instanceDAO = null;
		
		Ktek_questionnaireitemCriteria objKtek_questionnaireitemCriteria = null; 
		
		try{
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			
			instanceDAO = lDAOFactory.getKtek_questionnaireitemDAO();
			
			objKtek_questionnaireitemCriteria = new Ktek_questionnaireitemCriteria();
			objKtek_questionnaireitemCriteria.createKtek_result_questionnaireitemCriteria()
											 .createKtek_fk_idresultquestionnairesectionCriteria()
											 .createKtek_fk_idresultquestionnaireCriteria().ktek_pk_idresultquestionnaire.eq(idresultquestionnaire);
			
			instance =instanceDAO.loadKtek_questionnaireitemByCriteria(objKtek_questionnaireitemCriteria);
			
			session.close();
			
			if (instance!=null)
				log.debug("getQuestionnaireItem instance is not null");
			else
				log.info("getQuestionnaireItem instance is null for idresultquestionnaire " + idresultquestionnaire);
		}catch (Exception e) {
			log.error("getQuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();
			throw e;
		}
		
		return instance;	
	}
	
	public Ktek_questionnaireitem getQuestionnaireItem(PersistentSession session ,int idquestionnaireitem) throws Exception {
		Ktek_questionnaireitem instance = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireitemDAO instanceDAO = null;
		Ktek_questionnaireitemCriteria objKtek_questionnaireitemCriteria = null;
		try{
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireitemDAO();
			
			objKtek_questionnaireitemCriteria = new Ktek_questionnaireitemCriteria();
			objKtek_questionnaireitemCriteria.isdeleted.eq((short)0);
			
			objKtek_questionnaireitemCriteria.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem); 
			instance= instanceDAO.loadKtek_questionnaireitemByCriteria(objKtek_questionnaireitemCriteria );

			if (instance!=null)
				log.debug("getQuestionnaireItem instance is not null");
			else
				log.info("getQuestionnaireItem instance is null for idquestionnaire " + idquestionnaireitem);
		}catch (Exception e) {
			log.error("getQuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();
			throw e;
		}
		
		return instance;	
	}

	public Ktek_questionnairesection getQuestionnaireSection(PersistentSession session, int idquestionnairesection) throws Exception {
		Ktek_questionnairesection instance = null;		
		DAOFactory lDAOFactory = null;
		Ktek_questionnairesectionDAO instanceDAO = null;
		
		try{
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO=lDAOFactory.getKtek_questionnairesectionDAO();
			instance=instanceDAO.getKtek_questionnairesectionByORMID(session,idquestionnairesection);
			if (instance!=null)
				log.debug("getQuestionnaireSection instance is not null");
			else
				log.info("getQuestionnaireSection instance is null for idquestionnaire " + idquestionnairesection);
		}catch (Exception e) {
			log.error("getQuestionnaireSection Exception " + e.getMessage());			
			e.printStackTrace();
			throw e;
		}		
		
		return instance;
	}

	public Ktek_answer getQuestionnaireAnswer(PersistentSession session , String codAnswer) throws Exception{
		Ktek_answer instance= null;		
		DAOFactory lDAOFactory = null;
		Ktek_answerDAO instanceDAO = null;
		Ktek_answerCriteria objKtek_answerCriteria  = null;
		
		try{
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_answerDAO();
			
			objKtek_answerCriteria = new Ktek_answerCriteria(session);
			objKtek_answerCriteria.ktek_uk_codanswer.eq(codAnswer);
			
			instance=instanceDAO.loadKtek_answerByCriteria(objKtek_answerCriteria);
						
			if (instance!=null)
				log.debug("getQuestionnaireAnswer instance is not null");
			else
				log.info("getQuestionnaireAnswer instance is null for idAnswer " + codAnswer);
			
		}catch (Exception e) {
			log.error("getQuestionnaireAnswer Exception " + e.getMessage());			
			e.printStackTrace();	
			throw e;
		}
		
		return instance;
	}

	public Ktek_parameter getQuestionnaireParameters4QuestionnaireItem(int idquestionnaireitem) {
		Ktek_parameter instance = null;

		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_parameterDAO instanceDAO =  null;
		Ktek_parameterCriteria objKtek_parameterCriteria = null;
		Ktek_questionnaireitemCriteria objKtek_fk_idquestionnaireitemCriteria = null;
		
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_parameterDAO();
			
			objKtek_parameterCriteria = new Ktek_parameterCriteria();
			objKtek_fk_idquestionnaireitemCriteria = objKtek_parameterCriteria.createKtek_fk_idquestionnaireitemCriteria();
			objKtek_fk_idquestionnaireitemCriteria.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem);
			objKtek_fk_idquestionnaireitemCriteria.isdeleted.eq((short)0);
			
			instance = instanceDAO.loadKtek_parameterByCriteria(objKtek_parameterCriteria);
			
			session.close();
			
			if(instance!=null){
				log.debug("getQuestionnaireParameters4QuestionnaireItem instance is not null " );
			}else {
				log.debug("getQuestionnaireParameters4QuestionnaireItem instance is null " );
			}
			
		}catch (Exception e) {
			log.error("getQuestionnaireParameters4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return instance;		
	}

	private Ktek_parameter getQuestionnaireParameters4QuestionnaireItem(PersistentSession session, int idquestionnaireitem) {
		Ktek_parameter instance = null;

		DAOFactory lDAOFactory = null;
		Ktek_parameterDAO instanceDAO =  null;
		Ktek_parameterCriteria objKtek_parameterCriteria = null;
		Ktek_questionnaireitemCriteria objKtek_fk_idquestionnaireitemCriteria = null;
		
		try {
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_parameterDAO();
			
			objKtek_parameterCriteria = new Ktek_parameterCriteria();
			objKtek_fk_idquestionnaireitemCriteria = objKtek_parameterCriteria.createKtek_fk_idquestionnaireitemCriteria();
			objKtek_fk_idquestionnaireitemCriteria.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem);
			objKtek_fk_idquestionnaireitemCriteria.isdeleted.eq((short)0);
			
			instance = instanceDAO.loadKtek_parameterByCriteria(objKtek_parameterCriteria);
			
			if(instance!=null){
				log.debug("getQuestionnaireParameters4QuestionnaireItem instance is not null " );
			}else {
				log.debug("getQuestionnaireParameters4QuestionnaireItem instance is null " );
			}
			
		}catch (Exception e) {
			log.error("getQuestionnaireParameters4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();	
		}
		return instance;		
	}
	
	public Ktek_unit getUnit4QuestionnaireItem(int idquestionnaireitem) {
		Ktek_unit  instance = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_unitDAO instanceDAO = null;
		Ktek_unitCriteria objKtek_unitCriteria = null;
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_unitDAO();
			
			objKtek_unitCriteria = new Ktek_unitCriteria();
			objKtek_unitCriteria.createKtek_unit_parameterCriteria().ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem.eq(idquestionnaireitem);
			instance = instanceDAO.loadKtek_unitByCriteria(objKtek_unitCriteria);
						
			session.close();
			
			if(instance!=null){
				log.debug("getUnit4QuestionnaireItem instance is not null " );
			}else {
				log.debug("getUnit4QuestionnaireItem instance is null " );
			}
			
		}catch (Exception e) {
			log.error("getUnit4QuestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return instance;		
	}

	public Ktek_userquestionnaire_planning[] getQuestionnaireMonitoringSchedule(String codUser, long datefrom, long dateto, short typemonitoringactivity) {
		Ktek_userquestionnaire_planning[]  instanceArray = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_userquestionnaire_planningDAO instanceDAO = null;
		Ktek_userquestionnaire_planningCriteria objKtek_userquestionnaire_planningCriteria = null;
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();
		
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_userquestionnaire_planningDAO();
						
			objKtek_userquestionnaire_planningCriteria = new Ktek_userquestionnaire_planningCriteria();			
			
			objKtek_userquestionnaire_planningCriteria.plannedfrom.ge(datefrom);
			objKtek_userquestionnaire_planningCriteria.plannedto.le(dateto);						
			objKtek_userquestionnaire_planningCriteria.coduser.eq(codUser);			
			
			if(typemonitoringactivity>0)
				objKtek_userquestionnaire_planningCriteria.createKtek_fk_idquestionnaireCriteria().typemonitoringactivity.eq(typemonitoringactivity);
			
			instanceArray= instanceDAO.listKtek_userquestionnaire_planningByCriteria(objKtek_userquestionnaire_planningCriteria);
			
			if(instanceArray!=null){
				log.debug("getKtekQuestionnaireMonitoringSchedule instanceArray is not null " +instanceArray.length);
			}else {
				log.debug("getKtekQuestionnaireMonitoringSchedule instanceArray is null " );
			}
			session.close();
			
		}catch (Exception e) {
			log.error("getKtekQuestionnaireMonitoringSchedule Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return instanceArray;		
	}

	public Ktek_userquestionnaire_planning[] getQuestionnaireMonitoringScheduleNow(String codUser, String codtelecareprogram, short typemonitoringactivity, short status) {
		Ktek_userquestionnaire_planning[]  instanceArray = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_userquestionnaire_planningDAO instanceDAO = null;
		Ktek_userquestionnaire_planningCriteria objKtek_userquestionnaire_planningCriteria = null;
		long nowInImillis=0; 
		try {
			
			nowInImillis = Utils.getCalendarGMT().getTimeInMillis();			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_userquestionnaire_planningDAO();
						
			objKtek_userquestionnaire_planningCriteria = new Ktek_userquestionnaire_planningCriteria();			
			objKtek_userquestionnaire_planningCriteria.plannedfrom.le(nowInImillis);
			objKtek_userquestionnaire_planningCriteria.plannedto.ge(nowInImillis);			
			objKtek_userquestionnaire_planningCriteria.codtelecareprogram.eq(codtelecareprogram);			
			objKtek_userquestionnaire_planningCriteria.coduser.eq(codUser);
			
			if(status>0)
				objKtek_userquestionnaire_planningCriteria.statusquestionnaire.eq(status);
			
			if(typemonitoringactivity>0)
				objKtek_userquestionnaire_planningCriteria.createKtek_fk_idquestionnaireCriteria().typemonitoringactivity.eq(typemonitoringactivity);

			instanceArray= instanceDAO.listKtek_userquestionnaire_planningByCriteria(objKtek_userquestionnaire_planningCriteria);
			
			if(instanceArray!=null){
				log.debug("getQuestionnaireMonitoringScheduleNow instanceArray is not null " +instanceArray.length);
			}else {
				log.debug("getQuestionnaireMonitoringScheduleNow instanceArray is null " );
			}
			session.close();
			
		}catch (Exception e) {
			log.error("getQuestionnaireMonitoringScheduleNow Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return instanceArray;		
	}
	
	public boolean saveQuestionnaireMonitoringSchedule(List<Ktek_userquestionnaire_planning> list) {
		boolean boolOK=false;		
		PersistentSession session = null;
		PersistentTransaction tr =  null;
		
		try {
		
			if(list!=null){
				session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
				tr = session.beginTransaction();
				
				for(int i=0; i<list.size();i++){				
					session.save(list.get(i));
				}
			
				if(tr.wasCommitted()==false)
					tr.commit();
			
				session.close();
			}
			boolOK=true;
			
		}catch (Exception e) {
			log.error("setQuestionnaireMonitoringSchedule Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return boolOK;
	}

	public int getScoreQuestionnaireResult( KtekQuestionnaireResultEntity instance ){
		int score = 0;
		PersistentSession session = null;
		PersistentTransaction tr = null;
					
		try {
		
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			tr = session.beginTransaction();
		
			score =getScoreQuestionnaireResult( session , instance );
			
			if(tr.wasCommitted()==false)
				tr.commit();			
			
			session.close();
					
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return score;
	}
	
	private int getScoreQuestionnaireResult( PersistentSession session , KtekQuestionnaireResultEntity instance ){
		int score = 0;
		int scoreSection = 0;
		int weightQuestion = 0;
		
		Iterator<KtekQuestionnaireSectionResultEntity> itSection = null;
		Iterator<KtekQuestionnaireItemResultEntity> itItem = null;
		KtekQuestionnaireSectionResultEntity itResultQuestionnaireSection = null;
		KtekQuestionnaireItemResultEntity itResultQuestionnaireItem = null;
		String codAnswer  = null;
		Ktek_questionnairesection objQuestionnaireSection = null;
		Ktek_answer instanceAnswer = null;
		Ktek_question instanceQuestion = null;
		itSection = instance.getListsections().iterator();
		
		try {
			while(itSection.hasNext()){
				itResultQuestionnaireSection = (KtekQuestionnaireSectionResultEntity)itSection.next();
				
			// GET QUESTIONNAIRE SECTION 
				log.debug("getScoreQuestionnaireResult 5- GET QUESTIONNAIRE SECTION " );
				objQuestionnaireSection = getQuestionnaireSection(session, itResultQuestionnaireSection.getIdquestionnairesection());
				
				if(objQuestionnaireSection!=null){
					// PARSE RESULT QUESTIONNAIRE ITEMS
					itItem = itResultQuestionnaireSection.getListitems().iterator();
					while(itItem.hasNext()){
						itResultQuestionnaireItem = (KtekQuestionnaireItemResultEntity)itItem.next();
					
					// GET LIST CODANSWER
						if(itResultQuestionnaireItem.getListcodanswer() != null){
							for(int i=0; i<itResultQuestionnaireItem.getListcodanswer().length;i++){
								
								codAnswer = itResultQuestionnaireItem.getListcodanswer()[i];
								instanceAnswer = getQuestionnaireAnswer(session, codAnswer);
								
								instanceQuestion = getQuestion4QuestionnaireItem(session, itResultQuestionnaireItem.getIdquestionnaireitem());
								if(instanceQuestion!=null){									
									weightQuestion= instanceQuestion.getWeightquestion();
									log.debug("getScoreQuestionnaireResult weight is NOT null " + weightQuestion);
								}else{
									log.debug("getScoreQuestionnaireResult weight is null " );
								}
								
								if(instanceAnswer != null){
									itResultQuestionnaireItem.setScore(instanceAnswer.getScoreanswer());
									scoreSection = scoreSection +(instanceAnswer.getScoreanswer())*weightQuestion;
									
									log.debug("getScoreQuestionnaireResult Idquestionnaireitem " + itResultQuestionnaireItem.getIdquestionnaireitem());
									log.debug("getScoreQuestionnaireResult weight " + weightQuestion);
									log.debug("getScoreQuestionnaireResult score answer " + instanceAnswer.getScoreanswer() );
									log.debug("getScoreQuestionnaireResult score section " + scoreSection );
								}
							}
						}
					}
					score= score +scoreSection;
					itResultQuestionnaireSection.setScore((short)scoreSection);
				}
				instance.setScore((short)score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return score;
	}

	public KtekQuestionnaireResultDataEntity getQuestionnaireResultWithValues(int idresultquestionnaire) throws KtekExceptionEntity {
		Ktek_result_questionnaire instanceResult= null;
		PersistentSession session = null;
		
		List<KtekQuestionnaireSectionResultDataEntity> listsections = null;
		KtekQuestionnaireSectionResultDataEntity instanceSection = null;
		
		List<KtekQuestionnaireItemResultDataEntity> listItems = null;
		KtekQuestionnaireItemResultDataEntity instanceItem = null;
		
		Ktek_result_questionnairesection instanceResultSection = null;
		Ktek_result_questionnaireitem instanceResultItem= null;
		
		Iterator<Ktek_result_questionnairesection> itSections =  null;
		Iterator<Ktek_result_questionnaireitem> itItems = null;
		String sValueCodQuestionnaireItem = null;
		String sValueCodAnswer = null;
		
		KtekQuestionnaireResultDataEntity entity = null;

		String keyException = null;
		int keyExceptionCode = 0;
		
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			
			instanceResult = getQuestionnaireResultBySession (session,idresultquestionnaire );
			
			
			if(instanceResult==null){
				
				keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_DOES_NOT_EXIST;
				keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_RESULT_DOES_NOT_EXIST;
				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(keyExceptionCode);
				e.setMessage(keyException);
				e.setFunction("QuestionnaireManagerDB.getQuestionnaireResultWithValues");
				e.setParams(String.valueOf(idresultquestionnaire));				
				throw e;
			}else{
				entity = new KtekQuestionnaireResultDataEntity();
						
				entity.setCodtelecareprogram(instanceResult.getCodtelecareprogram());
				entity.setCoduser(instanceResult.getCoduserid());
				entity.setIdquestionnaire(instanceResult.getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
				entity.setIdresultquestionnaire(instanceResult.getKtek_pk_idresultquestionnaire());
				entity.setResultcreation(instanceResult.getResultcreation());
				entity.setScore(instanceResult.getEvaluationscorequestionnaire());
				
				if(instanceResult.getKtek_result_questionnairesection()!=null){
					listsections = new ArrayList<KtekQuestionnaireSectionResultDataEntity>();
					
					itSections = instanceResult.getKtek_result_questionnairesection().iterator();
					while(itSections.hasNext()){
						instanceResultSection = (Ktek_result_questionnairesection) itSections.next();
						
						instanceSection = new KtekQuestionnaireSectionResultDataEntity();
						instanceSection.setScore(instanceResultSection.getEvaluationscorequestionnairesection());
						instanceSection.setIdquestionnairesection(instanceResultSection.getKtek_fk_idquestionnairesection().getKtek_pk_idquestionnairesection());
						instanceSection.setIdresultquestionnairesection(instanceResultSection.getKtek_pk_idresultquestionnairesection());
						
						if(instanceResultSection.getKtek_result_questionnaireitem()!=null){
							listItems = new ArrayList<KtekQuestionnaireItemResultDataEntity>();
							
							itItems = instanceResultSection.getKtek_result_questionnaireitem().iterator();
							while(itItems.hasNext()){
								instanceResultItem =  (Ktek_result_questionnaireitem) itItems.next();
								
								instanceItem = new KtekQuestionnaireItemResultDataEntity();
								
								instanceItem.setIdquestionnaireitem(instanceResultItem.getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem());
								instanceItem.setIdresultquestionnaireitem(instanceResultItem.getKtek_pk_idresultquestionnaireitem());
								if(instanceResultItem.getScoreanswer() !=null)
									instanceItem.setScore(instanceResultItem.getScoreanswer());
								
								if(instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_INTEGER)
									sValueCodAnswer= String.valueOf(instanceResultItem.getIntegervalue());
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DECIMAL)
									sValueCodAnswer= String.valueOf(instanceResultItem.getDecimalvalue());
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_STRING)
									sValueCodAnswer= instanceResultItem.getStringvalue();
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_TEXT)
									sValueCodAnswer= instanceResultItem.getTextvalue();
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_ANSWERSET)
									sValueCodAnswer= String.valueOf(instanceResultItem.getCodanswer());
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DATETIME)
									sValueCodAnswer= String.valueOf(instanceResultItem.getDecimalvalue());
								else if (instanceResultItem.getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_IMAGE)
									sValueCodAnswer= instanceResultItem.getStringvalue();
								else
									sValueCodAnswer = instanceResultItem.getCodanswer();
								
								sValueCodQuestionnaireItem= instanceResultItem.getKtek_fk_idquestionnaireitem().getKtek_uk_codquestionnaireitem();
								
								instanceItem.setCodquestionnaireitemvalue(sValueCodQuestionnaireItem);
								instanceItem.setCodanswervalue(sValueCodAnswer );
															
								listItems.add(instanceItem);
							}
						}
						instanceSection.setListItems(listItems);						
						listsections.add(instanceSection);
					}						
				}
				entity.setListsections(listsections);	
			}
			
			session.close();
			
			if(entity!=null){
				log.debug("getQuestionnaireResultWithValues is not null " );
			}else {
				log.debug("getQuestionnaireResultWithValues is null " );
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return entity;
	}
	
	private  Ktek_result_questionnaire getQuestionnaireResultBySession(PersistentSession session, int idresultquestionnaire) {
		Ktek_result_questionnaire instance = null;
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnaireDAO instanceDAO = null;
		
		try {
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();		
			instanceDAO = lDAOFactory.getKtek_result_questionnaireDAO();
			
			instance= instanceDAO.getKtek_result_questionnaireByORMID(idresultquestionnaire);
			
			if(instance!=null){
				log.debug("getQuestionnaireResultBySession is not null " );
			}else {
				log.debug("getQuestionnaireResultBySession is null " );
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}
	
	public Ktek_result_questionnaire getQuestionnaireResult( int idresultquestionnaire) {
		Ktek_result_questionnaire instance = null;
		PersistentSession session = null;
		
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			instance = getQuestionnaireResultBySession(session, idresultquestionnaire);
			session.close();
			
			if(instance!=null){
				log.debug("getQuestionnaireResult is not null " );
			}else {
				log.debug("getQuestionnaireResult is null " );
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}
	
	
	
	public Ktek_questionnaire[] getQuestionnaires4TypeMonitoringActivityPlanned(short typeMonitoringActivity, String codUser, String codtelecareprogram, short status) {
		Ktek_questionnaire[] arrayInstance= null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireDAO instanceDAO = null;
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null; 
		long nowInMillis = 0 , todayStartInMillis =0, todayEndInMillis =0;
		PersistentSession session = null;		
		Ktek_userquestionnaire_planningCriteria objKtek_userquestionnaire_planningCriteria =null;
		
		try{
			int hours, minutes,seconds;
			nowInMillis=Utils.getCalendarGMT().getTimeInMillis();
			
			hours=0;minutes=0;seconds=0;
			todayStartInMillis =Utils.getTimeinMillis4TimeGMT(hours, minutes, seconds);
			
			hours=23;minutes=59;seconds=59;
			todayEndInMillis =Utils.getTimeinMillis4TimeGMT(hours, minutes,seconds);
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireDAO();
			
			objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();			
			objKtek_questionnaireCriteria.typemonitoringactivity.eq(typeMonitoringActivity);
			objKtek_questionnaireCriteria.isdeleted.eq((short)0);
			objKtek_questionnaireCriteria.datevalidfrom.lt(nowInMillis);
						
			objKtek_userquestionnaire_planningCriteria= objKtek_questionnaireCriteria.createKtek_userquestionnaire_planningCriteria();
			objKtek_userquestionnaire_planningCriteria.coduser.eq(codUser);
			objKtek_userquestionnaire_planningCriteria.codtelecareprogram.eq(codtelecareprogram);			
			objKtek_userquestionnaire_planningCriteria.statusquestionnaire.eq(status);			
			objKtek_userquestionnaire_planningCriteria.plannedfrom.le(nowInMillis);
			objKtek_userquestionnaire_planningCriteria.plannedto.ge(nowInMillis);
			
			objKtek_questionnaireCriteria.setProjection(Projections.projectionList()
			        .add(Projections.groupProperty("ktek_pk_idquestionnaire"), "ktek_pk_idquestionnaire")).setResultTransformer(Transformers.aliasToBean(Ktek_questionnaire.class));
						
			arrayInstance=instanceDAO.listKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
						
			log.error("nowInMillis " + nowInMillis);
			
			if (arrayInstance!=null)
				log.debug("getQuestionnaires4TypeMonitoringActivityPlanned instance is not null Before Filter unique values " + arrayInstance.length);
			else
				log.info("getQuestionnaires4TypeMonitoringActivityPlanned instance is null for typeMonitoringActivity " + typeMonitoringActivity);
			
			if(arrayInstance.length >0){
				Integer[] arrayIds = new Integer[arrayInstance.length]; 
				for(int i=0 ;i <arrayInstance.length; i++){
					arrayIds[i]=arrayInstance[i].getKtek_pk_idquestionnaire();
				}
				
				objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();
				objKtek_questionnaireCriteria.ktek_pk_idquestionnaire.in(arrayIds);
				arrayInstance=instanceDAO.listKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
			}
			
			session.close();
			
		}catch (PersistentException e) {
			log.error("getQuestionnaires4TypeMonitoringActivityPlanned Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return arrayInstance;
	}

	public Ktek_result_questionnaire[] getQuestionnaireResults(String codUser, boolean all, long datefrom, long dateto, int orderby, String codtelecareprogram, short typemonitoringactivity) throws KtekExceptionEntity {
		Ktek_result_questionnaire[] array = null;
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnaireDAO instanceDAO = null;
		Ktek_result_questionnaireCriteria objKtek_result_questionnaireCriteria =null;
		Ktek_questionnaireCriteria objKtek_fk_idquestionnaireCriteria = null;
		PersistentSession session = null;
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_result_questionnaireDAO();
			
			objKtek_result_questionnaireCriteria = new Ktek_result_questionnaireCriteria();			

			objKtek_fk_idquestionnaireCriteria = objKtek_result_questionnaireCriteria.createKtek_fk_idquestionnaireCriteria();			
			objKtek_fk_idquestionnaireCriteria.typequestionnaire.eq(KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING);
			objKtek_fk_idquestionnaireCriteria.typemonitoringactivity.eq(typemonitoringactivity);			
			objKtek_result_questionnaireCriteria.codtelecareprogram.eq(codtelecareprogram);

			if(all==false)
				objKtek_result_questionnaireCriteria.resultcreation.between(datefrom,dateto);
			
			if (orderby ==1)
				objKtek_result_questionnaireCriteria.addOrder(Order.desc("resultcreation"));
			else if (orderby ==2)
				objKtek_result_questionnaireCriteria.addOrder(Order.asc("resultcreation"));
						
			objKtek_result_questionnaireCriteria.coduserid.eq(codUser);
			
			array = instanceDAO.listKtek_result_questionnaireByCriteria(objKtek_result_questionnaireCriteria);
			
			session.close();
			
			if(array == null)
				log.debug("getQuestionnaireResults array is null" );
			else 
				log.debug("getQuestionnaireResults array is not null "  + array.length);
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireResults Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			KtekExceptionEntity eDB= new KtekExceptionEntity();
			eDB.setCode(KtekExceptionCode.EXCEPTION_CODE_PERSISSTENT_EXCEPTION);
			eDB.setMessage(e.getMessage());
			eDB.setFunction("QuestionnaireManagerDB.getQuestionnaireResults");
			eDB.setParams("");				
			throw eDB;			
		}
		
		return array;
	}
	
	public Ktek_result_questionnaireitem[] getResultQuestionnaireItems4ResultQuestionnaire(boolean all, long datefrom, long dateto, int orderby, short typemonitoringactivity, String codUser, Integer[] ids, String codtelecareprogram){
		
		Ktek_result_questionnaireitem[] array =null;
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnaireitemDAO instanceDAO = null;
		Ktek_result_questionnaireitemCriteria objKtek_result_questionnaireitemCriteria = null;
		Ktek_result_questionnaireCriteria objKtek_result_questionnaireCriteria = null;
		Ktek_questionnaireCriteria objKtek_fk_idquestionnaireCriteria = null;
		try{
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			
			instanceDAO = lDAOFactory.getKtek_result_questionnaireitemDAO();
			
			objKtek_result_questionnaireitemCriteria = new Ktek_result_questionnaireitemCriteria();
			
			objKtek_result_questionnaireCriteria = objKtek_result_questionnaireitemCriteria
												    .createKtek_fk_idresultquestionnairesectionCriteria()
												    .createKtek_fk_idresultquestionnaireCriteria();
			
			objKtek_fk_idquestionnaireCriteria = objKtek_result_questionnaireCriteria.createKtek_fk_idquestionnaireCriteria();			
			objKtek_fk_idquestionnaireCriteria.typequestionnaire.eq(KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING);
			objKtek_fk_idquestionnaireCriteria.typemonitoringactivity.eq(typemonitoringactivity);
			
			objKtek_result_questionnaireCriteria.createKtek_fk_iduserquestionnaireplanningCriteria().codtelecareprogram.eq(codtelecareprogram);
			
			if(all==false)
				objKtek_result_questionnaireCriteria.resultcreation.between(datefrom,dateto);
			
			objKtek_result_questionnaireCriteria.coduserid.eq(codUser);
			objKtek_result_questionnaireitemCriteria.addOrder(Order.asc("ktek_fk_idquestionnaireitem"));
			
			
			/* ORDER BY parameter*/
			if (orderby ==1)
				objKtek_result_questionnaireCriteria.addOrder(Order.desc("resultcreation"));
			else if (orderby ==2)
				objKtek_result_questionnaireCriteria.addOrder(Order.asc("resultcreation"));
			
			if (ids !=null && ids.length >0 && ids[0] != 0){				
				objKtek_result_questionnaireitemCriteria.createKtek_fk_idquestionnaireitemCriteria().ktek_pk_idquestionnaireitem.in(ids);				
			}else{
				if (ids !=null && ids.length >0)
					log.debug("getResultQuestionnaireItems4ResultQuestionnaire ids[0] value is "+ids[0] );
			}
			
			array = instanceDAO.listKtek_result_questionnaireitemByCriteria(objKtek_result_questionnaireitemCriteria);
			
			if(array!=null)
				log.debug("getResultQuestionnaireItems4ResultQuestionnaire array is not null " + array.length);
			else
				log.debug("getResultQuestionnaireItems4ResultQuestionnaire array is null");
			session.close();
				
		}catch (PersistentException e) {
			log.error("getResultQuestionnaireItems4ResultQuestionnaire Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return array;		
	}
	
	public Ktek_result_questionnaire[] getQuestionnaireResultsByIds(boolean all, long datefrom, long dateto, int orderby, short typemonitoringactivity, Integer[] ids, String codUser) {
		Ktek_result_questionnaire[] array = null;
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnaireDAO instanceDAO = null;
		Ktek_result_questionnaireCriteria objKtek_result_questionnaireCriteria =null;
		Ktek_questionnaireCriteria objKtek_fk_idquestionnaireCriteria = null;
		PersistentSession session = null;
		
		try{
		
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_result_questionnaireDAO();
			
			objKtek_result_questionnaireCriteria = new Ktek_result_questionnaireCriteria();			

			objKtek_fk_idquestionnaireCriteria = objKtek_result_questionnaireCriteria.createKtek_fk_idquestionnaireCriteria();			
			objKtek_fk_idquestionnaireCriteria.typequestionnaire.eq(KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING);
			objKtek_fk_idquestionnaireCriteria.typemonitoringactivity.eq(typemonitoringactivity);
						
			if(all==false)
				objKtek_result_questionnaireCriteria.resultcreation.between(datefrom,dateto);
			
			if (ids !=null && ids.length >0 && ids[0] != 0){
				objKtek_result_questionnaireCriteria
					.createKtek_result_questionnairesectionCriteria()
					.createKtek_result_questionnaireitemCriteria()
					.createKtek_fk_idquestionnaireitemCriteria()
					.ktek_pk_idquestionnaireitem.in(ids);
			}else{
				if (ids !=null && ids.length >0)
					log.debug("getQuestionnaireResultsByIds ids[0] value is "+ids[0] );
			}
			
			objKtek_result_questionnaireCriteria.coduserid.eq(codUser);
			
			if (orderby ==1)
				objKtek_result_questionnaireCriteria.addOrder(Order.desc("resultcreation"));
			else if (orderby ==2)
				objKtek_result_questionnaireCriteria.addOrder(Order.asc("resultcreation"));
						
			array = instanceDAO.listKtek_result_questionnaireByCriteria(objKtek_result_questionnaireCriteria);
			
			session.close();
			
			if(array == null)
				log.debug("getQuestionnaireResultsByIds array is null" );
			else 
				log.debug("getQuestionnaireResultsByIds array is not null "  + array.length);
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireResultsByIds Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return array;
	}
	
	public Ktek_questionnaire[] getQuestionnaireWithResults(long datefrom, long dateto, int orderby, short type) {
		Ktek_questionnaire[] array = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireDAO instanceDAO = null;
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null;
		Ktek_result_questionnaireCriteria objKtek_result_questionnaireCriteria = null;
		PersistentSession session = null;
		try{
		
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireDAO();
			
			objKtek_questionnaireCriteria = new Ktek_questionnaireCriteria();
			
			objKtek_result_questionnaireCriteria = objKtek_questionnaireCriteria.createKtek_result_questionnaireCriteria();
			objKtek_result_questionnaireCriteria.resultcreation.between(datefrom,dateto);
			objKtek_questionnaireCriteria.typequestionnaire.eq(type);
			if (orderby ==1)
				objKtek_result_questionnaireCriteria.addOrder(Order.desc("resultcreation"));
			else if (orderby ==2)
				objKtek_result_questionnaireCriteria.addOrder(Order.asc("resultcreation"));
						
			array = instanceDAO.listKtek_questionnaireByCriteria(objKtek_questionnaireCriteria);
			
			session.close();
			
			if(array == null)
				log.debug("getQuestionnaireWithResults array is null" );
			else 
				log.debug("getQuestionnaireWithResults array is not null "  + array.length);
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireWithResults Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return array;
	}

	public Ktek_questionnaireitem[] getQuestionnaireitemList4QuestionnaireSet(Integer[] idQuestionnaireArray, short[] typeMonitoringActivityArray){
		Ktek_questionnaireitem[]  array =null;
		Ktek_questionnaireitemCriteria objKtek_questionnaireitemCriteria = null;
		
		Ktek_questionnaireCriteria objKtek_questionnaireCriteria = null;
		
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireitemDAO instanceDAO = null;
		PersistentSession session = null;
		
		try {
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_questionnaireitemDAO();
			
			objKtek_questionnaireitemCriteria = new Ktek_questionnaireitemCriteria();			
			
			objKtek_questionnaireCriteria = objKtek_questionnaireitemCriteria.createKtek_qitem_sectionCriteria()
											 .createKtek_fk_idquestionnairesectionCriteria()
											 .createKtek_qsection_questionnaireCriteria()
											 .createKtek_fk_idquestionnaireCriteria();
			
			objKtek_questionnaireCriteria.typemonitoringactivity.in(typeMonitoringActivityArray);			
			objKtek_questionnaireCriteria.ktek_pk_idquestionnaire.in(idQuestionnaireArray);				
			objKtek_questionnaireitemCriteria.isdeleted.eq((short)0);
			
			objKtek_questionnaireitemCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			array = instanceDAO.listKtek_questionnaireitemByCriteria(objKtek_questionnaireitemCriteria);
			
			session.close();
			if(array == null)
				log.debug("getQuestionnaireitemList4QuestionnaireSet array is null" );
			else 
				log.debug("getQuestionnaireitemList4QuestionnaireSet array is not null "  + array.length);
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return array;
	}
	
	public Ktek_questionnaireitem[] getQuestionnaireitemList4QuestionnairePlannedFinished(String coduser, short[] typeMonitoringActivityArray, String codtelecareprogram){
		Ktek_questionnaireitem[]  array =null;
		Ktek_questionnaireitemCriteria objKtek_questionnaireitemCriteria = null;
				
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireitemDAO instanceDAO = null;
		PersistentSession session = null;
		Ktek_userquestionnaire_planningCriteria objKtek_userquestionnaire_planningCriteria = null;
		
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory .getKtek_questionnaireitemDAO();
			
			objKtek_questionnaireitemCriteria = new Ktek_questionnaireitemCriteria();
			
			
			objKtek_questionnaireitemCriteria.createKtek_result_questionnaireitemCriteria()
											 .createKtek_fk_idresultquestionnairesectionCriteria()
											 .createKtek_fk_idquestionnairesectionCriteria()
											 .createKtek_qsection_questionnaireCriteria()
											 .createKtek_fk_idquestionnaireCriteria()
											 .typemonitoringactivity.in(typeMonitoringActivityArray);
			
			objKtek_userquestionnaire_planningCriteria = objKtek_questionnaireitemCriteria.
				createKtek_qitem_sectionCriteria().
				createKtek_fk_idquestionnairesectionCriteria().
				createKtek_qsection_questionnaireCriteria().
				createKtek_fk_idquestionnaireCriteria().createKtek_userquestionnaire_planningCriteria();
			
			objKtek_userquestionnaire_planningCriteria.coduser.eq(coduser);
			objKtek_userquestionnaire_planningCriteria.statusquestionnaire.eq(KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED);
			objKtek_userquestionnaire_planningCriteria.codtelecareprogram.eq(codtelecareprogram);
				
			objKtek_questionnaireitemCriteria.isdeleted.eq((short)0);
			
			objKtek_questionnaireitemCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			array = instanceDAO.listKtek_questionnaireitemByCriteria(objKtek_questionnaireitemCriteria);
			
			session.close();
			if(array == null)
				log.debug("getQuestionnaireitemList4QuestionnairePlannedFinished array is null" );
			else 
				log.debug("getQuestionnaireitemList4QuestionnairePlannedFinished array is not null "  + array.length);
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			log.error("PersistentException " + e.getMessage() );
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(array == null)
			log.debug("getQuestionnaireitemList4QuestionnairePlannedFinished return array is null" );
		else 
			log.debug("getQuestionnaireitemList4QuestionnairePlannedFinished return array is not null "  + array.length);
			
		return array;
	}

	public Ktek_userquestionnaire_planning getUserPlanningQuestionnaire(String codUser, String codTelecareprogram, int ktek_pk_idquestionnaire) {
		Ktek_userquestionnaire_planning[] array = null;
		Ktek_userquestionnaire_planning instance = null;		
		DAOFactory lDAOFactory = null;
		Ktek_userquestionnaire_planningDAO instanceDAO = null;
		long nowInMillis = 0 ;
		PersistentSession session = null;		
		Ktek_userquestionnaire_planningCriteria objKtek_userquestionnaire_planningCriteria =null;
		
		try{
			
			nowInMillis = Utils.getCalendarGMT().getTimeInMillis();
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_userquestionnaire_planningDAO();			
			
			objKtek_userquestionnaire_planningCriteria = new Ktek_userquestionnaire_planningCriteria();			
			objKtek_userquestionnaire_planningCriteria.createKtek_fk_idquestionnaireCriteria().ktek_pk_idquestionnaire.eq(ktek_pk_idquestionnaire);			
			objKtek_userquestionnaire_planningCriteria.coduser.eq(codUser);
			objKtek_userquestionnaire_planningCriteria.codtelecareprogram.eq(codTelecareprogram);
			
			objKtek_userquestionnaire_planningCriteria.plannedfrom.lt(nowInMillis);
			objKtek_userquestionnaire_planningCriteria.plannedto.gt(nowInMillis);
			objKtek_userquestionnaire_planningCriteria.addOrder(Order.desc("plannedfrom"));
			
			array = instanceDAO.listKtek_userquestionnaire_planningByCriteria(objKtek_userquestionnaire_planningCriteria);
						
			if (array!=null)
				log.debug("getUserPlanningQuestionnaire instance " + nowInMillis+ "  is not null for ktek_pk_idquestionnaire " + ktek_pk_idquestionnaire + " " + array.length);
			else
				log.info("getUserPlanningQuestionnaire instance " + nowInMillis + " is null for ktek_pk_idquestionnaire " + ktek_pk_idquestionnaire);
			
			if(array.length>0)
				instance= array[0];
			
			session.close();
			
		}catch (PersistentException e) {
			log.error("getUserPlanningQuestionnaire Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return instance;
	}

	public Ktek_result_questionnaireitem[] getQuestionnaireResultItems4QuestionnaireResult(int idresultquestionnaire) {
		Ktek_result_questionnaireitem[] array = null;
		
		PersistentSession session = null;		
		DAOFactory lDAOFactory = null;
		
		Ktek_result_questionnaireitemDAO instanceDAO = null;
		Ktek_result_questionnaireitemCriteria objKtek_result_questionnaireitemCriteria = null;
		
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_result_questionnaireitemDAO();
			
			objKtek_result_questionnaireitemCriteria = new Ktek_result_questionnaireitemCriteria ();
			
			objKtek_result_questionnaireitemCriteria.createKtek_fk_idresultquestionnairesectionCriteria()
													.createKtek_fk_idresultquestionnaireCriteria()
													.ktek_pk_idresultquestionnaire.eq(idresultquestionnaire);
													
			array = instanceDAO.listKtek_result_questionnaireitemByCriteria(objKtek_result_questionnaireitemCriteria);
						
			session.close();
			
			if (array == null)
				log.info("getQuestionnaireResultItems4QuestionnaireResult array is null ");
			else				
				log.debug("getQuestionnaireResultItems4QuestionnaireResult array is NOT null " + array.length);
		
		}catch (PersistentException e) {
			log.error("getQuestionnaireResultItems4QuestionnaireResult Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return array;
	}

	public Ktek_result_questionnaireitem[] getQuestionnaireResults4IdquestionnaireItem(int idquestionnaireitem, int idresultquestionnaire) {
		Ktek_result_questionnaireitem[] array = null;

		PersistentSession session = null;		
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnaireitemDAO instanceDAO = null;
		Ktek_result_questionnaireitemCriteria objKtek_result_questionnaireitemCriteria  = null;
		
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			session.beginTransaction();
			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_result_questionnaireitemDAO();
			
			objKtek_result_questionnaireitemCriteria = new Ktek_result_questionnaireitemCriteria();
			objKtek_result_questionnaireitemCriteria.createKtek_fk_idresultquestionnairesectionCriteria()
													.createKtek_fk_idresultquestionnaireCriteria()
													.ktek_pk_idresultquestionnaire.eq(idresultquestionnaire);
			
			objKtek_result_questionnaireitemCriteria.createKtek_fk_idquestionnaireitemCriteria()
													.ktek_pk_idquestionnaireitem.eq(idquestionnaireitem);
			
			array = instanceDAO.listKtek_result_questionnaireitemByCriteria(objKtek_result_questionnaireitemCriteria);
			
			if(array == null)
				log.debug("getQuestionnaireResults4IdquestionnaireItem  array is null " );
			else
				log.debug("getQuestionnaireResults4IdquestionnaireItem  array is not null " + array.length );
			
			session.close();
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireResults4IdquestionnaireItem Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return array;
	}

	public Ktek_result_questionnairesection getQuestionnaireResultSection4Id(int ktek_pk_idresultquestionnaire, long idquestionnairesection) {
		Ktek_result_questionnairesection instance =null;
		
		PersistentSession session = null;		
		DAOFactory lDAOFactory = null;
		Ktek_result_questionnairesectionDAO instanceDAO = null;
		Ktek_result_questionnairesectionCriteria objKtek_result_questionnairesectionCriteria = null;
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			
			instanceDAO = lDAOFactory.getKtek_result_questionnairesectionDAO();
			
			objKtek_result_questionnairesectionCriteria = new Ktek_result_questionnairesectionCriteria();
			objKtek_result_questionnairesectionCriteria.createKtek_fk_idresultquestionnaireCriteria().ktek_pk_idresultquestionnaire.eq(ktek_pk_idresultquestionnaire);
			
			objKtek_result_questionnairesectionCriteria.createKtek_fk_idquestionnairesectionCriteria().ktek_pk_idquestionnairesection.eq((int) idquestionnairesection);
			
			instance = instanceDAO.loadKtek_result_questionnairesectionByCriteria(objKtek_result_questionnairesectionCriteria);
			
			if(instance ==null)
				log.debug("getQuestionnaireResultSection4Id  instance is null");
			else
				log.debug("getQuestionnaireResultSection4Id  instance is NOT null");
			
			session.close();			
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireResultSection4Id Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return instance;
	}

	public Ktek_questionnaireconfiguration[] getQuestionnaireConfiguration(){
		PersistentSession session = null;		
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireconfigurationDAO instanceDAO = null;
		Ktek_questionnaireconfiguration[] array = null;
		
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireconfigurationDAO();
			
			array = instanceDAO.listKtek_questionnaireconfigurationByQuery(null, null);
			
			if(array!=null)
				log.debug("getQuestionnaireConfiguration array is not null " + array.length );
			else
				log.debug("getQuestionnaireConfiguration array is null" );
			
			session.close();
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireConfiguration Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return array;
	}

	public boolean saveQuestionaireConfiguration(Ktek_questionnaireconfiguration instance) {
		boolean boolOK= false;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;
		Ktek_questionnaireconfigurationDAO instanceDAO = null;
		Ktek_questionnaireconfiguration instanceDB = null;
		PersistentTransaction t = null;
		boolean boolToUpdate = false;
		try{	
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			t = session.beginTransaction();
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_questionnaireconfigurationDAO();
			
			instanceDB = instanceDAO.getKtek_questionnaireconfigurationByORMID(instance.getKtek_pk_ktek_idquestionnaireconfiguration());
			
			if(instanceDB == null){
				log.debug("instanceDB does not exist");
				instanceDB = new Ktek_questionnaireconfiguration();
				instanceDB.setKtek_pk_ktek_idquestionnaireconfiguration(1);
			}
			else{
				log.debug("instanceDB exist");
				boolToUpdate = true;
			}
			
			instanceDB.setEndpointserver(instance.getEndpointserver());
			instanceDB.setEventserviceoauth2headertoken(instance.getEventserviceoauth2headertoken());
			instanceDB.setKtek_typesave(instance.getKtek_typesave());
			instanceDB.setTimeout(instance.getTimeout());
			instanceDB.setPort(instance.getPort());
			
			if(boolToUpdate){
				log.debug("instanceDB to be updated");
				session.update(instanceDB);
			}
			else{
				log.debug("instanceDB to be created ");
				session.saveOrUpdate(instanceDB);
			}
			
			t.commit();
			
			session.close();
			boolOK=true;
		
		}catch (PersistentException e) {
			log.error("saveQuestionaireConfiguration Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return boolOK;		
	}

	public Ktek_result_questionnaire[] getQuestionnaireResult4IdQuestionnaire(int idquestionnaire) {
		Ktek_result_questionnaire[] array = null;
		
		PersistentSession session = null;
		DAOFactory lDAOFactory = null;		
		Ktek_result_questionnaireDAO instanceDAO = null;
		Ktek_result_questionnaireCriteria objktek_result_questionnaireCriteria =null;
				
		try{
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			lDAOFactory = es.tekniker.framework.ktek.questionnaire.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_result_questionnaireDAO();
			
			objktek_result_questionnaireCriteria = new Ktek_result_questionnaireCriteria();			
			objktek_result_questionnaireCriteria.createKtek_fk_idquestionnaireCriteria().ktek_pk_idquestionnaire.eq(idquestionnaire);
			
			array = instanceDAO.listKtek_result_questionnaireByCriteria(objktek_result_questionnaireCriteria);
			
			if(array !=null)
				log.debug("getQuestionnaireResult4IdQuestionnaire array is not null " + array.length);
			else
				log.debug("getQuestionnaireResult4IdQuestionnaire array is null");
			
		}catch (PersistentException e) {
			log.error("getQuestionnaireResult4IdQuestionnaire Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
		return array;
	}	
	
}
