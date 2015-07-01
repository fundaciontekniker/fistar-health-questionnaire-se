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
package es.tekniker.framework.ktek.monitoring.mng.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.defines.KtekAuditAccessLogTypeAction;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekParameterEntity;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireStatus;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireTypeMonitoringActivity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireManagerDB;
import es.tekniker.framework.ktek.questionnaire.mng.server.QuestionnaireMngServer;
import es.tekniker.framework.ktek.questionnaire.mng.server.UtilsQuestionnaire;
import es.tekniker.framework.ktek.util.Utils;

public class MonitoringMngServer {

	private static Log log = LogFactory.getLog(es.tekniker.framework.ktek.monitoring.mng.server.MonitoringMngServer.class);

	
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireListCompleted4IdUser(int idUserAccessed, int idUser, String codtelecareprogram,int idlang) throws KtekExceptionEntity{
		log.info("getQuestionnaireListCompleted4IdUser");
		
		KtekMonitoringQuestionnaireModelEntityList list =null;
		KtekMonitoringQuestionnaireModelEntityList listHealth =null;
		KtekMonitoringQuestionnaireModelEntityList listStatus =null;
		QuestionnaireMngServer server = null;
		KtekQuestionnaireModelEntity[] arrayHealth = null;
		KtekQuestionnaireModelEntity[] arrayStatus = null;
		ArrayList<KtekMonitoringQuestionnaireModelEntity> innerlist = null;
		
		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_COMPLETED;		
		short typeMonitoringActivityHealth = KtekApplicationitemType.HEALTHSTATUS;
		short typeMonitoringActivityStatus = KtekApplicationitemType.STATUSPARAMETERS;
		
		server = new QuestionnaireMngServer();
		arrayHealth = server.getQuestionnaires4TypeMonitoringActivityPlannedByUserId(idUserAccessed, codtelecareprogram, idlang, typeMonitoringActivityHealth , status);
		if (arrayHealth!=null)
			log.info("getQuestionnaireListCompleted4IdUser arrayHealth instance is not null " +arrayHealth.length);
		else 
			log.info("getQuestionnaireListCompleted4IdUser arrayHealth instance is null");
		
		
		arrayStatus = server.getQuestionnaires4TypeMonitoringActivityPlannedByUserId(idUserAccessed, codtelecareprogram, idlang, typeMonitoringActivityStatus , status);
		if (arrayStatus!=null)
			log.info("getQuestionnaireListCompleted4IdUser arrayStatus instance is not null " +arrayStatus.length);
		else 
			log.info("getQuestionnaireListCompleted4IdUser arrayStatus instance is null");
		
		
		if (arrayHealth!=null && arrayHealth.length>0){
			listHealth = UtilsQuestionnaire.array2List(arrayHealth);
		}		
		
		if (arrayStatus!=null && arrayStatus.length>0){
			listStatus = UtilsQuestionnaire.array2List(arrayStatus);
		}
		
		list = new KtekMonitoringQuestionnaireModelEntityList();		
		innerlist = new ArrayList<KtekMonitoringQuestionnaireModelEntity>();
		if(listHealth != null)
			innerlist.addAll(listHealth.getList());
		
		if(listStatus != null)
			innerlist.addAll(listStatus.getList());
		
		list.setList(innerlist);		
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_STATUS_QUESTIONAIRE_LOG;
		int idaction = 0;
		long logitemcreation = Utils.getCalendarGMT().getTimeInMillis();
		
		idaccessuser = idUser;
		idaccesseduser = idUserAccessed;				
		UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);
		
		return list;
	}		
	

	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireList4TypeMonitoringActivity(String token , String codtelecareprogram, int idlang, short typeMonitoringActivity) throws KtekExceptionEntity{
		log.info("getQuestionnaireList4TypeMonitoringActivity ");
		
		KtekMonitoringQuestionnaireModelEntityList list =null;		
		KtekQuestionnaireModelEntity[] array= null;
		QuestionnaireMngServer server = null;
	
		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_PENDING;
				
		server = new QuestionnaireMngServer ();
		array=server.getQuestionnaires4TypeMonitoringActivityPlannedByToken(token, codtelecareprogram, idlang, typeMonitoringActivity , status);
		
		if (array!=null)
			log.info("getQuestionnaireList4TypeMonitoringActivity array instance is not null " +array.length);
		else 
			log.info("getQuestionnaireList4TypeMonitoringActivity array instance is null");
		if (array!=null && array.length>0)
			list = UtilsQuestionnaire.array2List(array);
		else
			list = new KtekMonitoringQuestionnaireModelEntityList(); 
		
		return list;
	}
	
	public List <KtekParameterEntity> getListQuestionnaireItemsPlannedStatusDrugFollowUp4User(String token, String codtelecareprogram) throws KtekExceptionEntity{
		log.error("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User");
		
		List <KtekParameterEntity> list = null;
		KtekParameterEntity parameter = null;
		boolean boolTokenValid = false;
		QuestionnaireManagerDB questionnaireDB = null;
		CommonsManagerDB commonsDB = null;
		Ktek_questionnaireitem[] arrayQuestionnaireitem = null;
		Ktek_user user = null;
		String coduser = null;
		
		short[] typeMonitoringActivityArray= new short[2];
		
		try{
			
			typeMonitoringActivityArray[0]=KtekQuestionnaireTypeMonitoringActivity.QUESTIONNAIRE_TYPE_MONITORING_ACTIVITY_STATUS;
			typeMonitoringActivityArray[1]=KtekQuestionnaireTypeMonitoringActivity.QUESTIONNAIRE_TYPE_MONITORING_ACTIVITY_DRUGFOLLOWUP;
			
			boolTokenValid = UtilsQuestionnaire.isTokenValid(token);
			
			if(boolTokenValid){					
				questionnaireDB = new QuestionnaireManagerDB();
				commonsDB = new CommonsManagerDB();				
				user = commonsDB.getUser4Token(token);
				
				if(user!= null){
					coduser=user.getKtek_uk_coduser();
									
					arrayQuestionnaireitem = questionnaireDB.getQuestionnaireitemList4QuestionnairePlannedFinished(coduser, typeMonitoringActivityArray, codtelecareprogram);
						
					list  = new ArrayList <KtekParameterEntity>();					
					if(arrayQuestionnaireitem != null && arrayQuestionnaireitem.length>0){
						
						log.debug("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User arrayQuestionnaireitem is not null "+ arrayQuestionnaireitem.length );
						
						for( int i =0; i< arrayQuestionnaireitem.length ; i++){
							parameter = new KtekParameterEntity();
							parameter.setId(arrayQuestionnaireitem[i].getKtek_pk_idquestionnaireitem());
							parameter.setName(arrayQuestionnaireitem[i].getNamequestionnaireitem());
							
							list.add(parameter); 
						}
					}else{
						log.debug("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User arrayQuestionnaireitem is null ");
					}
				}else{
					log.debug("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User coduser is null ");
				}
			}
		}catch(Exception e){
			log.error("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User Exception " + e.getMessage());
		}
		
		if (list!=null)
			log.info("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User list instance is not null " +list.size());
		else 
			log.info("getListQuestionnaireItemsPlannedStatusDrugFollowUp4User list instance is null");
		
		return list;
	}

	public List <KtekParameterEntity> getListQuestionnaireItemsPlannedByType4User(String token, short type, String codtelecareprogram) throws KtekExceptionEntity{
		log.info("getListQuestionnaireItemsPlannedByType4User");
		List <KtekParameterEntity> list = null;
		KtekParameterEntity parameter = null;
		boolean boolTokenValid = false;				
		QuestionnaireManagerDB questionnaireDB = null;		
		CommonsManagerDB commonsDB = null;		
		Ktek_questionnaireitem[] arrayQuestionnaireitem = null;
		Ktek_user user = null;
		String coduser = null;
		
		short[] typeMonitoringActivityArray=new short[1];
		typeMonitoringActivityArray[0]= type;
		
		boolTokenValid = UtilsQuestionnaire.isTokenValid(token);
		
		if(boolTokenValid){	
			
			questionnaireDB = new QuestionnaireManagerDB();
			commonsDB = new CommonsManagerDB();
			
			user = commonsDB.getUser4Token(token);
			
			if(user!= null){
				coduser=user.getKtek_uk_coduser();
								
				arrayQuestionnaireitem = questionnaireDB.getQuestionnaireitemList4QuestionnairePlannedFinished(coduser, typeMonitoringActivityArray, codtelecareprogram);
					
				list  = new ArrayList <KtekParameterEntity>();
				
				if(arrayQuestionnaireitem != null && arrayQuestionnaireitem.length>0){
					
					log.debug("getListQuestionnaireItemsPlannedByType4User arrayQuestionnaireitem is not null "+ arrayQuestionnaireitem.length );
					
					
					for( int i =0; i< arrayQuestionnaireitem.length ; i++){
						parameter = new KtekParameterEntity();
						parameter.setId(arrayQuestionnaireitem[i].getKtek_pk_idquestionnaireitem());
						parameter.setName(arrayQuestionnaireitem[i].getNamequestionnaireitem());
						
						list.add(parameter); 
					}
				}else{
					log.debug("getListQuestionnaireItemsPlannedByType4User arrayQuestionnaireitem is null ");
				}
			}else{
				log.debug("getListQuestionnaireItemsPlannedByType4User user is null ");
			}
		}
		
		if (list!=null)
			log.info("getListQuestionnaireItemsPlannedByType4User list instance is not null " +list.size());
		else 
			log.info("getListQuestionnaireItemsPlannedByType4User list instance is null");
			
		return list;
	}
	
	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaires4TypeMonitoringActivityHealthFilter( String token, int idlang, String codtelecareprogram , boolean all, long datefrom, long dateto, int orderby) throws KtekExceptionEntity{
		log.info("getQuestionnaires4TypeMonitoringActivityHealthFilter");
		
		List<KtekQuestionnaireItemFilterEntity> list =null;		
		QuestionnaireMngServer server = null;	
	
		server = new QuestionnaireMngServer ();
		list = server.getQuestionnaires4TypeMonitoringActivityFilter(token, idlang,  all, datefrom, dateto, orderby, codtelecareprogram, KtekApplicationitemType.HEALTHSTATUS);
	
		if (list!=null)
			log.info("getQuestionnaires4TypeMonitoringActivityHealthFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaires4TypeMonitoringActivityHealthFilter list instance is null");
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_HEALTH_STATUS_QUESTIONAIRE_LOG;
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
	
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaires4TypeMonitoringActivityStatusFilter( String token, int idlang, String codtelecareprogram , boolean all, long datefrom, long dateto, int orderby, String ids) throws KtekExceptionEntity{
		log.info("getQuestionnaires4TypeMonitoringActivityStatusFilter");
		
		List<KtekResultQuestionnaireItemsEntity> list =null;		
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		list = server.getQuestionnaires4TypeMonitoringActivityFilterWithIds(token, idlang,   all, datefrom, dateto, orderby, KtekApplicationitemType.STATUSPARAMETERS, ids, codtelecareprogram);
		if (list!=null)
			log.info("getQuestionnaires4TypeMonitoringActivityStatusFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaires4TypeMonitoringActivityStatusFilter list instance is null");
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_STATUS_QUESTIONAIRE_LOG;
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
	
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaireStatusHealthFilter(String token, int idlang, String codtelecareprogram, boolean all, long datefrom, long dateto,  int orderby, String ids) throws KtekExceptionEntity{
		List<KtekResultQuestionnaireItemsEntity> list1 =null;
		List<KtekResultQuestionnaireItemsEntity> list2 =null;
		List<KtekResultQuestionnaireItemsEntity> list =null;
		QuestionnaireMngServer server = null;	
				
		server = new QuestionnaireMngServer ();
		list1 = server.getQuestionnaires4TypeMonitoringActivityFilterWithIds(token, idlang, all, datefrom, dateto, orderby, KtekApplicationitemType.DRUGFOLLOWUP, ids, codtelecareprogram);
		
		if (list1!=null )
			log.info("getQuestionnaireStatusHealthFilter array DRUGFOLLOWUP instance is not null " +list1.size());
		else 
			log.info("getQuestionnaireStatusHealthFilter array DRUGFOLLOWUP instance is null");
		
		list2 = server.getQuestionnaires4TypeMonitoringActivityFilterWithIds(token, idlang, all, datefrom, dateto, orderby, KtekApplicationitemType.STATUSPARAMETERS, ids, codtelecareprogram);
				
		if (list2!=null )
			log.info("getQuestionnaireStatusHealthFilter array STATUSPARAMETERS instance is not null " +list2.size());
		else 
			log.info("getQuestionnaireStatusHealthFilter array STATUSPARAMETERS instance is null");
		
		
		list = new ArrayList<KtekResultQuestionnaireItemsEntity>();
		if(list1 != null && list1.size()>0 )
			list.addAll(list1);
		if(list2!=null && list2.size()>0)
			list.addAll(list2);
		
		if (list!=null)
			log.info("getQuestionnaireStatusHealthFilter array TOTAL instance is not null " +list.size());
		
		//audit
		int idaccessuser =0,  idaccesseduser =0;
		short typeaction = KtekAuditAccessLogTypeAction.ACCESS_STATUS_QUESTIONAIRE_LOG;
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
