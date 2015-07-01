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
package es.tekniker.framework.ktek.drugtreatment.mng.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.defines.KtekAuditAccessLogTypeAction;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireStatus;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;
import es.tekniker.framework.ktek.questionnaire.mng.server.QuestionnaireMngServer;
import es.tekniker.framework.ktek.questionnaire.mng.server.UtilsQuestionnaire;
import es.tekniker.framework.ktek.util.Utils;


public class DrugTreatmentMngServer {

	private static Log log = LogFactory.getLog(DrugTreatmentMngServer.class);
	
	
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireList4TypeMonitoringActivity(String token, String codtelecareprogram, int idlang, short typemonitoringactivity) throws KtekExceptionEntity{
		log.info("getQuestionnaireList4TypeMonitoringActivity ");
		KtekQuestionnaireModelEntity[] array= null;
		KtekMonitoringQuestionnaireModelEntityList list =null;		
		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_PENDING;		
		QuestionnaireMngServer server = null;	
		
		server = new QuestionnaireMngServer ();
		array=server.getQuestionnaires4TypeMonitoringActivityPlannedByToken(token, codtelecareprogram, idlang, typemonitoringactivity ,status);		
		if (array!=null)
			log.info("getQuestionnaireList4TypeMonitoringActivity array instance is not null " +array.length);
		else 
			log.info("getQuestionnaireList4TypeMonitoringActivity array instance is null");
		if (array!=null && array.length>0){
			list = UtilsQuestionnaire.array2List(array);
		}else{
			list = new KtekMonitoringQuestionnaireModelEntityList(); 
		}
		
		return list;
	}

	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireListCompleted4IdUser(int idUserAccessed, int idUser,String codtelecareprogram4User, int idlang) throws KtekExceptionEntity {
		log.info("getQuestionnaireListCompleted4IdUser");
		KtekMonitoringQuestionnaireModelEntityList list =null;
		KtekMonitoringQuestionnaireModelEntityList listDrugFollowUp =null;
		KtekMonitoringQuestionnaireModelEntityList listDrugSideEffects =null;
		QuestionnaireMngServer server = null;	
		KtekQuestionnaireModelEntity[] arrayDrugFollowUp = null;
		KtekQuestionnaireModelEntity[] arrayDrugSideEffects = null;

		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED;
		short typeMonitoringActivityDrugFollowUp = KtekApplicationitemType.DRUGFOLLOWUP;
		short typeMonitoringActivityDrugSideEffects = KtekApplicationitemType.DRUGSIDEEFFECTS;
		
		server = new QuestionnaireMngServer ();
		arrayDrugFollowUp = server.getQuestionnaires4TypeMonitoringActivityPlannedByUserId(idUserAccessed, codtelecareprogram4User, idlang, typeMonitoringActivityDrugFollowUp , status);
		
		if (arrayDrugFollowUp!=null)
			log.info("getQuestionnaireListCompleted4IdUser arrayDrugFollowUp instance is not null " +arrayDrugFollowUp.length);
		else 
			log.info("getQuestionnaireListCompleted4IdUser arrayDrugFollowUp instance is null");
		
		arrayDrugSideEffects= server.getQuestionnaires4TypeMonitoringActivityPlannedByUserId(idUserAccessed, codtelecareprogram4User, idlang, typeMonitoringActivityDrugSideEffects , status);		
		if (arrayDrugSideEffects!=null)
			log.info("getQuestionnaireListCompleted4IdUser arrayDrugSideEffects instance is not null " +arrayDrugSideEffects.length);
		else 
			log.info("getQuestionnaireListCompleted4IdUser arrayDrugSideEffects instance is null");
		
		if (arrayDrugFollowUp!=null && arrayDrugFollowUp.length>0)
			listDrugFollowUp = UtilsQuestionnaire.array2List(arrayDrugFollowUp);
		
		if (arrayDrugSideEffects!=null && arrayDrugSideEffects.length>0)
			listDrugSideEffects = UtilsQuestionnaire.array2List(arrayDrugSideEffects);
		
		list = new KtekMonitoringQuestionnaireModelEntityList();
		
		ArrayList<KtekMonitoringQuestionnaireModelEntity> innerlist = new ArrayList<KtekMonitoringQuestionnaireModelEntity>();
		if(listDrugFollowUp != null)
			innerlist.addAll(listDrugFollowUp.getList());
		
		if(listDrugSideEffects != null)
			innerlist.addAll(listDrugSideEffects.getList());
		
		list.setList(innerlist);
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_SIDE_EFFECTS_LOG;
		int idaction = 0;
		long logitemcreation = Utils.getCalendarGMT().getTimeInMillis();
		String codtelecareprogram =codtelecareprogram4User;		
		
		idaccessuser = idUser;
		idaccesseduser = idUserAccessed;				
		UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);
		
		return list;
	}		

	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaires4TypeMonitoringActivityFilter( String token, int idlang, String codtelecareprogram, boolean all, long datefrom, long dateto, int orderby) throws KtekExceptionEntity{
		log.info("getQuestionnaires4TypeMonitoringActivityFilter");
		
		List<KtekQuestionnaireItemFilterEntity> list =null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		list = server.getQuestionnaires4TypeMonitoringActivityFilter(token, idlang,  all, datefrom, dateto, orderby, codtelecareprogram, KtekApplicationitemType.DRUGSIDEEFFECTS );
	
		if (list!=null)
			log.info("getQuestionnaires4TypeMonitoringActivityFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaires4TypeMonitoringActivityFilter list instance is null");
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_SIDE_EFFECTS_LOG;
		int idaction = 0;
		long logitemcreation = Utils.getCalendarGMT().getTimeInMillis();		
		Ktek_user instance = null;
		
		instance=UtilsQuestionnaire.getUserByToken(token);
		
		if(instance!= null){
			idaccessuser = instance.getKtek_pk_iduser();
			idaccesseduser = instance.getKtek_pk_iduser(); 
		}		
		UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);	
				
		return list;
	}
	
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaires4TypeMonitoringActivityFilterWithIds(String token, int idlang, String codtelecareprogram, boolean all, long datefrom, long dateto,int orderby, short typemonitoringactivity, String ids) throws KtekExceptionEntity {
		log.info("getQuestionnaires4TypeMonitoringActivityFilterWithIds");
		
		List<KtekResultQuestionnaireItemsEntity> list =null;		
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();		
		list = server.getQuestionnaires4TypeMonitoringActivityFilterWithIds(token, idlang, all, datefrom, dateto, orderby, typemonitoringactivity, ids, codtelecareprogram);
				
		if (list!=null)
			log.info("getQuestionnaires4TypeMonitoringActivityFilterWithIds list instance is not null " +list.size());
		else 
			log.info("getQuestionnaires4TypeMonitoringActivityFilterWithIds list instance is null");
				
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_DRUGFOLLOWUP_LOG;
		int idaction = 0;
		long logitemcreation = Utils.getCalendarGMT().getTimeInMillis();		
		Ktek_user instance = null;
		
		instance=UtilsQuestionnaire.getUserByToken(token);
		
		if(instance!= null){
			idaccessuser = instance.getKtek_pk_iduser();
			idaccesseduser = instance.getKtek_pk_iduser(); 
		}		
		UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);	

		return list;
	}

	
}
