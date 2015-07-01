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
package es.tekniker.framework.ktek.questionnaire.mng.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import es.tekniker.framework.ktek.Ktek_answer;
import es.tekniker.framework.ktek.Ktek_formatquestionnaire;
import es.tekniker.framework.ktek.Ktek_parameter;
import es.tekniker.framework.ktek.Ktek_question;
import es.tekniker.framework.ktek.Ktek_questionnaire;
import es.tekniker.framework.ktek.Ktek_questionnaireconfiguration;
import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_questionnairesection;
import es.tekniker.framework.ktek.Ktek_result_questionnaire;
import es.tekniker.framework.ktek.Ktek_result_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_result_questionnairesection;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.Ktek_userquestionnaire_planning;
import es.tekniker.framework.ktek.commons.config.ExceptionTextFile;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.util.Utils;
import es.tekniker.framework.ktek.defines.KtekAuditAccessLogTypeAction;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.exception.KtekExceptionCode;
import es.tekniker.framework.ktek.exception.KtekExceptionMessage;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireAnswerScoreType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireItemResultType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireItemType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireMonitoringScheduleTypes;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireQuestionTypeAnswer;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireTypeSave;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireConfiguration;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntitySet;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleListEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemValuesEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireLoadFile;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireManagerDB;

public class QuestionnaireMngServer {

	private static Log log =LogFactory.getLog(QuestionnaireMngServer.class);
	
	private static int TIMEOUT_DEFAULT = 5000;
	
	public ExceptionTextFile exceptionTextFile;  
		
	public boolean eventServiceEnabled = false;
	public boolean contextBrokerEnabled = false;
	public boolean saveOnDatabaseEnabled = false;		
	public long typesave = 0;
	
	public String nameContextQuestionnaireResultJson="QuestionnaireResult";
	public String typeContextQuestionnaireResultJson="json";
	
	public String nameContextQuestionnaireResultDBJson="QuestionnaireResultDB";
	public String typeContextQuestionnaireResultDBJson="json";
	
	public String nameContextQuestionnaireResult="QuestionnaireResult";
	public String typeContextQuestionnaireResult="id";

	public String endpointServerEventServiceSE=null;
	public String endpointServerContextBrokerGE=null;
	public int portContextBrokerGE=0;
	public int timeout = 0;
	public String oauth2HeaderToken = null;
	
	KtekQuestionnaireConfiguration configuration =null;
	
	public QuestionnaireMngServer() {
		
		try {
			exceptionTextFile= new ExceptionTextFile("messages.properties");
			
			if(exceptionTextFile==null){
				log.error("messages.properties file Parser is null");
			}			
		} catch (IOException e) {
			e.printStackTrace();
			log.error("messages.properties file not found. Setting default values", e);
		}		
	}
	
	private void getQuestionnaireConfigurationParameters(){
		String function="getQuestionnaireConfigurationParameters";
		String typeSaveString= null;
		try {
			
			configuration = this.getQuestionnaireConfiguration();
			if(configuration == null ){
				String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_NOT_DEFINED;
				int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_NOT_DEFINED;
				
				String exceptionText = getExceptionText(keyException);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(keyExceptionCode);
				e.setMessage(exceptionText);
				e.setFunction(function);
								
				throw e;
			}else{			
				typeSaveString=String.valueOf(configuration.getTypesave());
				timeout = configuration.getTimeout();		
				if(timeout<1000){
					timeout= TIMEOUT_DEFAULT;
					log.info("QuestionnaireMngServer :  Configuration timeout is less taht 1000 milliseconds, set default value " +  TIMEOUT_DEFAULT);
				}
				
				if(typeSaveString != null){
					if( typeSaveString.equals(String.valueOf(KtekQuestionnaireTypeSave.QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE))){ 
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE true" );						
						saveOnDatabaseEnabled = true;					
					}
					
					if( typeSaveString.equals(String.valueOf(KtekQuestionnaireTypeSave.QUESTIONNAIRE_TYPE_PUBLISH_EVENT_SERVICE))){
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_PUBLISH_EVENT_SERVICE true" );
						eventServiceEnabled = true;
					}
		
					if(typeSaveString.equals(String.valueOf(KtekQuestionnaireTypeSave.QUESTIONNAIRE_TYPE_PUBLISH_CONTEXT_BROKER))){
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_PUBLISH_CONTEXT_BROKER true" );
						contextBrokerEnabled = true;
					}
					
					if(typeSaveString.equals(String.valueOf(KtekQuestionnaireTypeSave.QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_CONTEXT_BROKER))){
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_CONTEXT_BROKER true" );
						contextBrokerEnabled = true;
						saveOnDatabaseEnabled = true;
					}
					
					if(typeSaveString.equals(String.valueOf(KtekQuestionnaireTypeSave.QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_EVENT_SERVICE))){
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE_PUBLISH_EVENT_SERVICE true" );	
						eventServiceEnabled = true;
						saveOnDatabaseEnabled = true;
					}
		
					if(saveOnDatabaseEnabled == false && eventServiceEnabled == false && contextBrokerEnabled == false){
						log.debug("QuestionnaireMngServer :  QUESTIONNAIRE_TYPE_SAVE NOT DEFINED set default  QUESTIONNAIRE_TYPE_SAVE_LOCAL_DATABASE" );					
						saveOnDatabaseEnabled = true;
					}
					
					if(contextBrokerEnabled){					
						this.endpointServerContextBrokerGE = configuration.getEndpointserver();
						this.portContextBrokerGE = configuration.getPort();
						
						if(this.endpointServerContextBrokerGE == null || this.endpointServerContextBrokerGE.equals("") ){
							contextBrokerEnabled =false;
							String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_ENDPOINT_NOT_DEFINED;
							int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_ENDPOINT_NOT_DEFINED;
							
							String exceptionText = getExceptionText(keyException);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(keyExceptionCode);
							e.setMessage(exceptionText);
							e.setFunction(function);
											
							throw e;
						}
						
						if( this.portContextBrokerGE ==0){
							contextBrokerEnabled =false;
							
							String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_PORT_NOT_DEFINED;
							int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_PORT_NOT_DEFINED;
							
							String exceptionText = getExceptionText(keyException);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(keyExceptionCode);
							e.setMessage(exceptionText);
							e.setFunction(function);
											
							throw e;
						}			
					}
					
					if(eventServiceEnabled){						
						this.endpointServerEventServiceSE = configuration.getEndpointserver();
						this.oauth2HeaderToken = configuration.getEventserviceoauth2headertoken();
						
						if(this.endpointServerEventServiceSE == null || this.endpointServerEventServiceSE.equals("")){
							eventServiceEnabled =false;
							String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_ENDPOINT_NOT_DEFINED;
							int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_ENDPOINT_NOT_DEFINED;
							
							String exceptionText = getExceptionText(keyException);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(keyExceptionCode);
							e.setMessage(exceptionText);
							e.setFunction(function);
											
							throw e;
						}
												
						if( this.oauth2HeaderToken == null || this.oauth2HeaderToken.equals("") ){
							contextBrokerEnabled =false;
							
							String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_TOKEN_NOT_DEFINED;
							int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_TOKEN_NOT_DEFINED;
							
							String exceptionText = getExceptionText(keyException);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(keyExceptionCode);
							e.setMessage(exceptionText);
							e.setFunction(function);
											
							throw e;
						}	
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Questionnaire Configuration error. Configure data properly ", e);
		}
	}
	
	public KtekQuestionnaireConfiguration getQuestionnaireConfiguration() throws KtekExceptionEntity{
		KtekQuestionnaireConfiguration instance = null;
		Ktek_questionnaireconfiguration[] array = null;
		Ktek_questionnaireconfiguration instanceDAO = null;
		QuestionnaireManagerDB db = null;
		
		db = new QuestionnaireManagerDB();
		array = db.getQuestionnaireConfiguration();
		
		if(array != null && array.length>0){
			instanceDAO = array[0];
			
			instance = new KtekQuestionnaireConfiguration();			
			
			instance.setEndpointserver(instanceDAO.getEndpointserver());
			instance.setEventserviceoauth2headertoken(instanceDAO.getEventserviceoauth2headertoken());
			instance.setIdquestionnaireconfiguration(instanceDAO.getKtek_pk_ktek_idquestionnaireconfiguration());
			instance.setPort(instanceDAO.getPort());
			instance.setTimeout(instanceDAO.getTimeout());
			instance.setTypesave(instanceDAO.getKtek_typesave());
			
		}else{
			log.error("Questionnaire Configuration data not defined.");
			
			String keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_NOT_DEFINED;
			int keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_NOT_DEFINED;
			
			String exceptionText = getExceptionText(keyException);				
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(keyExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction("QuestionnaireMngServer.getQuestionnaireConfiguration");
							
			throw e;			
		}
			
		return instance;
	}
	
	private String getExceptionText(String key){
		String text=null;
		
		if(exceptionTextFile !=null)
			text = exceptionTextFile.getStringParam(key);
		else 
			text=key;
		
		if(text==null)
			text=key;
		
		return text;
	}
	
	public KtekQuestionnaireModelEntity getQuestionnaireModelWithResults(String token, int idlang, String codtelecareprogram , int idresultquestionnaire) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity instance = null;		
		boolean boolTokenValid =false;
		QuestionnaireManagerDB db = null;
		Ktek_result_questionnaire instanceQuestionnaireResult = null;		
		Iterator<KtekQuestionnaireSectionEntity> itSections = null;
		KtekQuestionnaireSectionEntity section = null;		
		Iterator<KtekQuestionnaireItemEntity> itItems = null;
		KtekQuestionnaireItemEntity item = null;		
		int idquestionnaireitem = 0;		
		Ktek_result_questionnaireitem[] arrayResults = null;		
		List<String> values = null; 
		String value =null;		
		boolean resultIsSet =false;		
		Ktek_result_questionnairesection objResultQuestionnaireSection = null;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);		
		if(boolTokenValid){	
			db = new QuestionnaireManagerDB();		
			instanceQuestionnaireResult = db.getQuestionnaireResult(idresultquestionnaire);
			
			if(instanceQuestionnaireResult == null){
				log.error("getQuestionnaireModelWithResults : instanceQuestionnaireResult is null");
			}
			else{
				instance= getQuestionnaireModelByToken(token, idlang, codtelecareprogram, instanceQuestionnaireResult.getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
				//get results if exists  and set in instance
				if(instance == null){
					log.error("getQuestionnaireModelWithResults : instanceQuestionnaire Model is null");
				}else{
						
					//set score for result questionaire
					instance.setScore(instanceQuestionnaireResult.getEvaluationscorequestionnaire());
					
					itSections= instance.getListSections().iterator();
					
					while(itSections.hasNext()){
						
						section = itSections.next();
						
						objResultQuestionnaireSection = db.getQuestionnaireResultSection4Id(instanceQuestionnaireResult.getKtek_pk_idresultquestionnaire(), section.getIdquestionnairesection());						
						section.setScore(objResultQuestionnaireSection.getEvaluationscorequestionnairesection());
						
						itItems = section.getListItems().iterator();						
						while(itItems.hasNext()){

							values = null; 
							value = null;

							item = itItems.next();
							idquestionnaireitem = (int) item.getIdquestionnaireitem();
							arrayResults = db.getQuestionnaireResults4IdquestionnaireItem(idquestionnaireitem, idresultquestionnaire);
							
							if (arrayResults.length>0){
								values = new ArrayList<String>();
								
								for(int i=0; i< arrayResults.length ;i++){
									resultIsSet = false;
									
									if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_STRING){
										value = arrayResults[i].getStringvalue();
									}else if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_TEXT){
										value = arrayResults[i].getTextvalue();
									}else if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_INTEGER){
										value = String.valueOf(arrayResults[i].getIntegervalue());
									}else if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DECIMAL){
										value = String.valueOf(arrayResults[i].getDecimalvalue());
									}else if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DATETIME){
										value = String.valueOf(arrayResults[i].getIntegervalue());
									} else if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_ANSWERSET){
										value = arrayResults[i].getCodanswer();
										
										if(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_question().getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_UNIQUE ||
											arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_question().getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_PREDEFINED_SET_UNIQUE ||
											arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_question().getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_SET_UNIQUE) 
											resultIsSet = false;
										else
											resultIsSet = true;
									}									
									values.add(value);
								}
								
								if(resultIsSet)								
									item.setValues(values);
								else 
									item.setValue(value);
							}							
						}
					}
				}
				
				//audit
				int idaccessuser =0,  idaccesseduser =0;
				short typeaction = KtekAuditAccessLogTypeAction.READ_UPDATED_QUESTIONNAIRE;
				int idaction = idresultquestionnaire;
				long logitemcreation = Utils.getCalendarGMT().getTimeInMillis();
					
				Ktek_user user = null;				
				user = UtilsQuestionnaire.getUserByToken(token);
				
				if(user !=null){
					idaccessuser = user.getKtek_pk_iduser();
					idaccesseduser = user.getKtek_pk_iduser();			
					UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);
				}
			}
		}
		return instance;
	}
	
	public KtekQuestionnaireModelEntity getQuestionnaireModelByIdUser(int iduser, int idlang, String codtelecareprogram, int idquestionnaire) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity instance= null;
				
		instance= getQuestionnaireModelData(iduser, idlang, codtelecareprogram, idquestionnaire);
		
		return instance;
	}
	
	public KtekQuestionnaireModelEntity getQuestionnaireModelByToken(String token, int idlang, String codtelecareprogram, int idquestionnaire) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity instance= null;
		boolean boolTokenValid=false;
		CommonsManagerDB commonsDB = null; 
		Ktek_user user = null;
		
		log.info("getQuestionnaireModelByToken : parameter received " + idquestionnaire);
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);
		
		if(boolTokenValid){	
			log.info("getQuestionnaireModelByToken : token valid " );
			
			commonsDB = new CommonsManagerDB();
			user = commonsDB.getUser4Token(token);
			
			log.info("getQuestionnaireModelByToken : user id " + user.getKtek_pk_iduser() );
			
			instance =getQuestionnaireModelData(user.getKtek_pk_iduser(), idlang, codtelecareprogram, idquestionnaire);
		}
		
		return instance;
	}

	public KtekQuestionnaireModelEntity getQuestionnaireModelData(int iduser, int idlang, String codtelecareprogram, int idquestionnaire) throws KtekExceptionEntity {
		log.info("getQuestionnaireModelData   " + idquestionnaire);
		
		KtekQuestionnaireModelEntity instance= null;		
		QuestionnaireManagerDB db= null;
		Ktek_questionnaire instanceDAO = null;
		Ktek_formatquestionnaire instanceConfigDAO = null;
		Ktek_questionnairesection[] instanceSectionListDAO = null;
		String keyException = null;
		int keyExceptionCode = 0;
		Ktek_userquestionnaire_planning userquestionnaireplanning = null;
		
		db = new QuestionnaireManagerDB();
		instanceDAO = db.getQuestionnaireModel(idquestionnaire);
		
		if(instanceDAO==null){
			
			keyException=KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST;
			keyExceptionCode=KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST;
			
			String exceptionText = getExceptionText(keyException);				
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(keyExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction("QuestionnaireMngServer.getQuestionnaireModel");
			e.setParams(String.valueOf(idquestionnaire));				
			throw e;
		}else{
			
			instanceConfigDAO = db.getQuestionnaireAssessmentConfiguration(idquestionnaire);
			instanceSectionListDAO = db.getQuestionnaireAssessmentSectionList(idquestionnaire);
			instance= BO2Entity.QuestionnaireAssessmentBO2Entity(idlang, instanceDAO, instanceConfigDAO,instanceSectionListDAO );
						
			if(instanceDAO.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING){
				CommonsManagerDB commonsDB = new CommonsManagerDB();
				Ktek_user user = commonsDB.getUser(iduser);
				
				userquestionnaireplanning = db.getUserPlanningQuestionnaire(user.getKtek_uk_coduser(), codtelecareprogram, instanceDAO.getKtek_pk_idquestionnaire());
				if (userquestionnaireplanning  != null )
					instance.setIduserquestionnaireplanning(userquestionnaireplanning.getKtek_pk_iduserquestionnaireplanning()); 
			}
			
			//audit
			int idaccessuser =0,  idaccesseduser =0;
			short typeaction = KtekAuditAccessLogTypeAction.READ_QUESTIONNAIRE;
			int idaction = idquestionnaire;
			long logitemcreation =Utils.getCalendarGMT().getTimeInMillis();
			
			idaccessuser = iduser;
			idaccesseduser = iduser;
					
			UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, codtelecareprogram, typeaction, idaction, logitemcreation);
			
		}
		return instance;
	}
	
	public int saveQuestionnaireModel(String token, KtekQuestionnaireResultEntity resultData) throws KtekExceptionEntity {
		int intSaveResult=0; 
		boolean boolOK=false;
		boolean boolSaveOnDatabase=true;
		boolean boolTokenValid=false;
		QuestionnaireManagerDB db= null;
		Ktek_result_questionnaire objResultQuestionnaire =  null;
		boolean boolValidation = false;
		boolean boolEventService = false;
		boolean boolContextBroker = false;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);
		
		if(boolTokenValid){
			
			getQuestionnaireConfigurationParameters();
						
			boolValidation = ValidateDataBeforeSaveQuestionnaire (resultData);
			if(boolValidation == false){
				intSaveResult = KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION;
				log.error("saveQuestionnaireModel : ValidateDataBeforeSaveQuestionnaire returned a false ");
			}
				
			//  CALCULATE SCORE FOR QUESTIONNAIRE / SECTIONS / ITEMS BASED ON ANSWERS AND PARAMETERS DEFINED AT RESULT INPUT PARAMETER
			db = new QuestionnaireManagerDB();				
			db.getScoreQuestionnaireResult( resultData);
			
			if(saveOnDatabaseEnabled){
				log.debug("saveQuestionnaireModel : Save data on database ");
				objResultQuestionnaire = db.saveQuestionnaireResultByStepsLogic(resultData);
				
				if(objResultQuestionnaire !=null ){
					boolSaveOnDatabase=true;
				}
				
				//audit
				int idaccessuser =0,  idaccesseduser =0;
				short typeaction = KtekAuditAccessLogTypeAction.SEND_QUESTIONNAIRE;
				int idaction = resultData.getIdquestionnaire();
				long logitemcreation =Utils.getCalendarGMT().getTimeInMillis();
				
				Ktek_user user = UtilsQuestionnaire.getUserByToken(token);
				if(user!=null){
					idaccessuser = user.getKtek_pk_iduser();
					idaccesseduser = user.getKtek_pk_iduser();
						
					UtilsQuestionnaire.auditAccessLog(idaccessuser, idaccesseduser, resultData.getCodtelecareprogram(), typeaction, idaction, logitemcreation);
				}
			}
			
			if(eventServiceEnabled){
				log.debug("saveQuestionnaireModel : Send QuestionnaireResult to EventService SE ");
				boolEventService=sendDataQuestionnaireResultEventServiceSE(objResultQuestionnaire, resultData);
			}else{
				boolEventService=true;
			}
			
			if(this.contextBrokerEnabled){
				log.debug("saveQuestionnaireModel : Send QuestionnaireResult to ContextBroker GE ");
				boolContextBroker=sendDataQuestionnaireResultOrionContextBrokerGE(objResultQuestionnaire, resultData);
			}else{
				boolContextBroker=true;
			}

			if(boolEventService && boolSaveOnDatabase && boolValidation && boolContextBroker)
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_OK;
			else if (boolValidation == false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION;
			else if (boolSaveOnDatabase == false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_SAVE_DATABASE;
			else if (boolEventService == false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_PUBLISH_EVENTSERVICE;
			else if (boolContextBroker == false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_PUBLISH_EVENTSERVICE;						
			else if (boolValidation == false && boolSaveOnDatabase==false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION_SAVE_DATABASE;
			else if (boolValidation == false && boolContextBroker==false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_VALIDATION_PUBLISH_CONTEXTBROKER;
			else if (boolSaveOnDatabase == false && boolContextBroker==false )
				intSaveResult= KtekQuestionnaireTypeSave.QUESTIONNAIRE_SAVE_RESULT_ERROR_AT_SAVE_DATABASE_PUBLISH_CONTEXTBROKER;
			
		}		
		
		log.debug("saveQuestionnaireModel : result of function " + intSaveResult);
		return intSaveResult;
	}	

	public boolean sendDataQuestionnaireResultEventServiceSE(Ktek_result_questionnaire objResultQuestionnaire, KtekQuestionnaireResultEntity resultData){
		boolean boolOK=false;
		
		EventServiceClient eventService = null;		
		String codUser = null, nameContext = null, typeContext = null, valueContext = null;
		ObjectMapper mapper = new ObjectMapper();
		
		if(resultData!=null){
		
			eventService = new EventServiceClient(this.endpointServerEventServiceSE,this.timeout, this.oauth2HeaderToken);
		 	
			// 1- save Questionnaire Result JSON			
			try {
				mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);				
				valueContext=mapper.writeValueAsString(resultData);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			codUser = resultData.getCoduser();
			nameContext = nameContextQuestionnaireResultJson;
			typeContext = typeContextQuestionnaireResultJson;					
			if (valueContext == null){
				//valueContext="{\"KtekQuestionnaireResultEntity\": {\"idquestionnaire\": 1,\"codtelecareprogram\": \"TBP1\",\"coduser\": \"User2\", \"listsections\": [ {\"idquestionnairesection\": 1,\"listitems\": [{\"idquestionnaireitem\": 1,\"listcodanswer\": [ \"A2\"]},{\"idquestionnaireitem\": 4,\"listcodanswer\": [\"A12\"]},{\"idquestionnaireitem\": 3,\"listcodanswer\": [\"A8\"]},{\"idquestionnaireitem\": 2,\"listcodanswer\": [\"A5\",\"A6\"]}]}]}}";
				valueContext="nothing";
				log.debug("json serialization error");
			}
			
			boolOK=eventService.updateContext(codUser, nameContext, typeContext, valueContext,true);
			
			if(boolOK)
				log.debug("sendDataQuestionnaireResultEventServiceSE : EventServiceSE.updateContext JSON OK");
			else
				log.debug("sendDataQuestionnaireResultEventServiceSE : EventServiceSE.updateContext JSON ERROR");
			
		}	
			
		 // 1- save idquestionnaire result id
		if (objResultQuestionnaire != null){
			codUser = resultData.getCoduser();
			nameContext = nameContextQuestionnaireResult;
			typeContext = typeContextQuestionnaireResult;					
			valueContext= String.valueOf(objResultQuestionnaire.getKtek_pk_idresultquestionnaire());
			
			boolOK=eventService.updateContext(codUser, nameContext, typeContext, valueContext,true);
			
			if(boolOK)
				log.debug("sendDataQuestionnaireResultEventServiceSE : EventServiceSE.updateContext OK");
			else
				log.debug("sendDataQuestionnaireResultEventServiceSE : EventServiceSE.updateContext ERROR");
		}	
		
		return boolOK;
	}
	
	public boolean sendDataQuestionnaireResultOrionContextBrokerGE(Ktek_result_questionnaire objResultQuestionnaire, KtekQuestionnaireResultEntity resultData){
		boolean boolOK=false;
		
		OrionContextBrokerClient orionContextBroker = null;		
		String codUser = null, nameContext = null, typeContext = null, valueContext = null;
		ObjectMapper mapper = new ObjectMapper();
		
		if(resultData!=null){
			
			orionContextBroker = new OrionContextBrokerClient(this.endpointServerContextBrokerGE, this.timeout, this.portContextBrokerGE);
		 	
			// 1- save Questionnaire Result JSON			
			try {
				mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);				
				valueContext=mapper.writeValueAsString(resultData);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			codUser = resultData.getCoduser();
			nameContext = nameContextQuestionnaireResultJson;
			typeContext = typeContextQuestionnaireResultJson;					
			if (valueContext == null){
				//valueContext="{\"KtekQuestionnaireResultEntity\": {\"idquestionnaire\": 1,\"codtelecareprogram\": \"TBP1\",\"coduser\": \"User2\", \"listsections\": [ {\"idquestionnairesection\": 1,\"listitems\": [{\"idquestionnaireitem\": 1,\"listcodanswer\": [ \"A2\"]},{\"idquestionnaireitem\": 4,\"listcodanswer\": [\"A12\"]},{\"idquestionnaireitem\": 3,\"listcodanswer\": [\"A8\"]},{\"idquestionnaireitem\": 2,\"listcodanswer\": [\"A5\",\"A6\"]}]}]}}";
				valueContext="nothing";
				log.debug("json serialization error");
			}
			
			boolOK=orionContextBroker.updateContext(codUser, nameContext, typeContext, valueContext,true);
			
			if(boolOK)
				log.debug("sendDataQuestionnaireResultOrionContextBrokerGE : OrionContextBrokerGE.updateContext JSON OK");
			else
				log.debug("sendDataQuestionnaireResultOrionContextBrokerGE : OrionContextBrokerGE.updateContext JSON ERROR");
			
		}	
		
		 // 1- save idquestionnaire result id
		if (objResultQuestionnaire != null){
			codUser = resultData.getCoduser();
			nameContext = nameContextQuestionnaireResult;
			typeContext = typeContextQuestionnaireResult;					
			valueContext= String.valueOf(objResultQuestionnaire.getKtek_pk_idresultquestionnaire());
			
			boolOK=orionContextBroker.updateContext(codUser, nameContext, typeContext, valueContext,true);
			
			if(boolOK)
				log.debug("sendDataQuestionnaireResultOrionContextBrokerGE : OrionContextBrokerGE.updateContext OK");
			else
				log.debug("sendDataQuestionnaireResultOrionContextBrokerGE : OrionContextBrokerGE.updateContext ERROR");
		}
		
		return boolOK;
	}
	
	private boolean ValidateDataBeforeSaveQuestionnaire( KtekQuestionnaireResultEntity resultData) throws KtekExceptionEntity{
		boolean boolOK=true;
		Iterator<KtekQuestionnaireSectionResultEntity> itSection = null;
		KtekQuestionnaireSectionResultEntity instanceSection = null;
		Ktek_questionnairesection[] instanceQuestionnaireSectionList = null;
		boolean boolSectionFound = false;		
		Iterator<KtekQuestionnaireItemResultEntity> itItems = null;
		KtekQuestionnaireItemResultEntity instanceItem = null;
		Ktek_questionnaireitem[] instanceQuestionnaireItemList = null;	
		Ktek_questionnaireitem instanceQuestionnaireItem= null;
		boolean boolItemFound = false;
		Ktek_question instanceQuestion = null;
		Ktek_answer[] instanceAnswerList = null;
		List<Ktek_answer> instanceAnswerListRight = null;
		QuestionnaireManagerDB questionnaireDB =null;
		String exceptionText=null;	
		String sFunction = null;
		int idanswerset = 0;
		boolean boolAnswerRightFound = false;
		Ktek_parameter parameterInstance =  null;
		float paramValue = 0;
		Ktek_questionnaire objQuestionnaire = null;
		
		sFunction = "QuestionnaireMngServer.ValidateDataBeforeSaveQuestionnaire";
		
		log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire START");
				
		//VALIDATION DATA OF QUESTIONNAIRE RESULT
		questionnaireDB = new QuestionnaireManagerDB();
		
		objQuestionnaire = questionnaireDB.getQuestionnaire( resultData.getIdquestionnaire());
		if(objQuestionnaire==null){
			log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire does not exist");
			exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);				
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(resultData.getIdquestionnaire()));				
			throw e;
		}
		
		log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire 1");
		
		//GET FROM DB THE SECTIONS FOR QUESTIONNAIRE
		instanceQuestionnaireSectionList = questionnaireDB.getQuestionnaireAssessmentSectionList(resultData.getIdquestionnaire());
		
		if(instanceQuestionnaireSectionList == null || instanceQuestionnaireSectionList.length==0){
			log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaireSectionList is null or has 0 elements");
			exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_DOES_NOT_EXIST);				
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_DOES_NOT_EXIST);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(resultData.getIdquestionnaire()));				
			throw e;
		}
		log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire 2");

		if (instanceQuestionnaireSectionList.length != resultData.getListsections().size() ){
			exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_ALL_DEFINED);				
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_ALL_DEFINED);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(resultData.getIdquestionnaire()));
			throw e;
		}
		
		
		for (int i=0; i< instanceQuestionnaireSectionList.length ;i++){
			boolSectionFound = false;
			
			log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire 3");

			itSection = resultData.getListsections().iterator();
			while (itSection.hasNext()){
				
				log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire 4");

				instanceSection = itSection.next();
				
				if (instanceSection.getIdquestionnairesection()==instanceQuestionnaireSectionList[i].getKtek_pk_idquestionnairesection()){
					
					log.info("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaire 5");
					
					boolSectionFound=true;		
					//GET FROM DB ITEMS FOR EACH SECTION
					instanceQuestionnaireItemList = questionnaireDB.getQuestionnaireItemList4Section(instanceSection.getIdquestionnairesection());
					if(instanceQuestionnaireItemList == null || instanceQuestionnaireItemList.length==0){
						log.debug("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaireItemList is null or has 0 elements");
						
						exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_ITEMS_DOES_NOT_EXIST);
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_ITEMS_DOES_NOT_EXIST);
						e.setMessage(exceptionText);
						e.setFunction(sFunction);
						e.setParams(String.valueOf(instanceSection.getIdquestionnairesection()));				
						throw e;
					}
					
					//CHECK REQUIRED ITEMS
					log.debug("ValidateDataBeforeSaveQuestionnaire instanceQuestionnaireItemList is not " + instanceQuestionnaireItemList.length);
					
					for(int j=0;j<instanceQuestionnaireItemList.length;j++){
						if(instanceQuestionnaireItemList[j].getIsrequired()==1){
							boolItemFound = false;
							if(instanceSection.getListitems() != null){
								itItems = instanceSection.getListitems().iterator();
								while(itItems.hasNext()){
									instanceItem = itItems.next();
									if(instanceItem.getIdquestionnaireitem()==instanceQuestionnaireItemList[j].getKtek_pk_idquestionnaireitem()){
										boolItemFound=true;
										break;
									}
								}
							}
							if(boolItemFound==false){
								exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_ITEM_NOT_DEFINED);				
								KtekExceptionEntity e= new KtekExceptionEntity();
								e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_ITEM_NOT_DEFINED);
								e.setMessage(exceptionText);
								e.setFunction(sFunction);
								e.setParams(String.valueOf(instanceQuestionnaireItemList[j].getKtek_pk_idquestionnaireitem()));
								throw e;
							}
						}
					}
					
					//VALIDATE ANSWERS
					log.debug("ValidateDataBeforeSaveQuestionnaire VALIDATE ANSWERS " );
					
					for(int j=0;j<instanceQuestionnaireItemList.length;j++){						
						instanceQuestionnaireItem=instanceQuestionnaireItemList[j];
						// GET instanceItem for idquestionnaireitem						
						itItems = instanceSection.getListitems().iterator();
						while(itItems.hasNext()){
							instanceItem = itItems.next();
							if(instanceItem.getIdquestionnaireitem()==instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem())
								break;
						}						
						
						// GET QUESTION DATA FOR IDANSWERSET FROM DB
						instanceQuestion = questionnaireDB.getQuestion4QuestionnaireItem(instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
						
						if(objQuestionnaire.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_ASSESSMENT){
							if(instanceQuestion==null){
								exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_QUESTION_DOES_NOT_EXISTS);				
								KtekExceptionEntity e= new KtekExceptionEntity();
								e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_QUESTION_DOES_NOT_EXISTS);
								e.setMessage(exceptionText);
								e.setFunction(sFunction);
								e.setParams(String.valueOf(instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem()));
								throw e;
							}
						}
						
						//GET ANSWERS FROM DB
						log.debug("ValidateDataBeforeSaveQuestionnaire GET ANSWERS FROM DB " + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem() );
						if(instanceQuestion!=null){
							if(instanceQuestion.getKtek_fk_idanswerset()!= null)
								idanswerset=instanceQuestion.getKtek_fk_idanswerset().getKtek_pk_idanswerset();
							
							instanceAnswerList = questionnaireDB.getQuestionnaireItemAnwser4QuestionnaireItem(instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem(), 
									idanswerset);
								
							//get only right answers
							instanceAnswerListRight = new ArrayList<Ktek_answer>();
							for(int k=0; k <instanceAnswerList.length;k++ ){
								if(instanceAnswerList[k].getScoreanswer()==KtekQuestionnaireAnswerScoreType.QUESTIONNAIRE_ANSWER_SCORE_TYPE_RIGHT){
									instanceAnswerListRight.add(instanceAnswerList[k]);
								}
							}
							
							if(instanceQuestion.getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_PREDEFINED_SET_UNIQUE ||
							   instanceQuestion.getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_SET_UNIQUE){
							
								if(instanceAnswerListRight.size()>1){
									//if TYPE ANSWER IS UNIQUE ONLY 1 ANSWER IS ALLOWED
									log.debug("ValidateDataBeforeSaveQuestionnaire TYPE ANSWER UNIQUE : MORE THAN ONE RIGHT ANSWER FOR ANSWER " + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
									return false;
								}
								
								if(instanceItem.getListcodanswer().length>1){
									//if TYPE ANSWER IS UNIQUE ONLY 1 ANSWER IS ALLOWED
									log.debug("ValidateDataBeforeSaveQuestionnaire TYPE ANSWER UNIQUE : MORE THAN ONE ANSWER FOR ANSWER " + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
									return false;
								}
							}	
							
							if(instanceQuestion.getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_PREDEFINED_SET_MULTI ||
							   instanceQuestion.getTypeanswer()==KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_SET_MULTI){
								
								if(instanceItem.getListcodanswer() ==null){
									//if TYPE ANSWER IS UNIQUE ONLY 1 ANSWER IS ALLOWED
									log.debug("ValidateDataBeforeSaveQuestionnaire TYPE ANSWER MULTI : INSTANCE ITEM LIST ANSWERS IS NULL " + + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
									return false;
								}
								
								if(instanceAnswerListRight.size() !=instanceItem.getListcodanswer().length){
									//if TYPE ANSWER IS UNIQUE ONLY 1 ANSWER IS ALLOWED
									log.debug("ValidateDataBeforeSaveQuestionnaire TYPE ANSWER MULTI : NUMBER OF ANSWERS IS NOT EQUAL TO RIGHT ANSWERS  " + + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
									return false;
								}
							}
							
							if(objQuestionnaire.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_ASSESSMENT){
								if(instanceQuestion.getTypeanswer()!=KtekQuestionnaireQuestionTypeAnswer.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_UNIQUE){
									//VERIFY ANSWERS FROM RESULT DATA
									log.debug("ValidateDataBeforeSaveQuestionnaire VERIFY ANSWERS TYPE UNIQUE FROM RESULT DATA " + instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem() );
								
									for(int k=0; k< instanceAnswerListRight.size() ; k++){
										boolAnswerRightFound=false;
										for(int l=0;l<instanceItem.getListcodanswer().length;l++){		
											log.debug("ValidateDataBeforeSaveQuestionnaire answer  " + instanceItem.getListcodanswer()[l] + " " + instanceAnswerListRight.get(k).getKtek_uk_codanswer());
											if(instanceItem.getListcodanswer()[l].equals(instanceAnswerListRight.get(k).getKtek_uk_codanswer())){
												boolAnswerRightFound=true;
												log.debug("ValidateDataBeforeSaveQuestionnaire answer  FOUND " + instanceItem.getListcodanswer()[l] );
											}											
										}
										if(boolAnswerRightFound==false){
											log.error("ValidateDataBeforeSaveQuestionnaire answer not right for Idquestionnaireitem " + instanceItem.getIdquestionnaireitem());
											return false;
										}
									}
								}
							}
						}
						
						log.debug("ValidateDataBeforeSaveQuestionnaire get params " );
						
						//get params
						if(objQuestionnaire.getTypequestionnaire()==KtekQuestionnaireType.QUESTIONNAIRE_TYPE_MONITORING){							
							itItems = instanceSection.getListitems().iterator();
							
							while(itItems.hasNext()){
								instanceItem = itItems.next();
								parameterInstance = questionnaireDB.getQuestionnaireParameters4QuestionnaireItem(instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem());
								if(parameterInstance !=null){
									
									if(instanceItem.getParamvalue()!=null){
										paramValue = Float.valueOf(instanceItem.getParamvalue());
										
										if(instanceItem.getIdquestionnaireitem()==instanceQuestionnaireItem.getKtek_pk_idquestionnaireitem()){
											if(paramValue>parameterInstance.getValuemax() || paramValue< parameterInstance.getValuemin()){
											
												//NACHO 2014/06/19
												//the function return false instead of indicate which is wrong	
												log.error("ValidateDataBeforeSaveQuestionnaire param value is not in range " + " paramValue  " + paramValue +  " idquestionnaireitem " + instanceItem.getIdquestionnaireitem());
												return false;
											}
										}
									}
								}
							}
						}
					}
				}					
			}	
			if(boolSectionFound==false){
				exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_DEFINED);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_DEFINED);
				e.setMessage(exceptionText);
				e.setFunction(sFunction);
				e.setParams(String.valueOf(instanceSection.getIdquestionnairesection()));
				throw e;
			}
		}
		
		return boolOK;
	}

	public List<KtekQuestionnaireMonitoringScheduleEntity> getKtekQuestionnaireMonitoringSchedule(String token, long datefrom, long dateto, short typemonitoringactivity, short status) throws KtekExceptionEntity {
		
		List<KtekQuestionnaireMonitoringScheduleEntity>  list = null;
		KtekQuestionnaireMonitoringScheduleEntity monitoringSchedule = null;
		boolean boolTokenValid=false;
		QuestionnaireManagerDB db = null;
		CommonsManagerDB commonsdb = null;
		Ktek_userquestionnaire_planning[] instanceArray =  null;
		Ktek_user user = null;
		String codUser = null;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);		
		if(boolTokenValid){			
			
			commonsdb = new CommonsManagerDB();
			user=commonsdb.getUser4Token(token); 
			if(user!=null)
				codUser=user.getKtek_uk_coduser();
			else{
				//throw exception
				String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				e.setMessage(exceptionText);
				e.setFunction("QuestionnaireMngServer.getKtekQuestionnaireMonitoringSchedule");
				e.setParams(String.valueOf(token));				
				throw e;
			}
			db = new QuestionnaireManagerDB();
			
			String sdatefrom = String.valueOf(datefrom);
			sdatefrom = sdatefrom.substring(0,sdatefrom.length()-3);
			sdatefrom =sdatefrom  +"000";
			
			Long datefromint= null;			
			datefromint=Long.valueOf(sdatefrom);
			
			String sdateto = String.valueOf(dateto);
			sdateto = sdateto.substring(0,sdateto.length()-3);
			sdateto =sdateto  +"000";
			
			Long datetoint=null;			
			datetoint=Long.valueOf(sdateto);
			
			log.error("datefrom :" + datefromint +  " dateto   :" +datetoint + " typemonitoringactivity: " + typemonitoringactivity );
			
			instanceArray = db.getQuestionnaireMonitoringSchedule(codUser, datefromint, datetoint,typemonitoringactivity);
			list= new ArrayList<KtekQuestionnaireMonitoringScheduleEntity>();
			if(instanceArray!=null){
				for(int i=0;i<instanceArray.length;i++ ){
					monitoringSchedule = new KtekQuestionnaireMonitoringScheduleEntity();					
					monitoringSchedule.setIdquestionnaire(instanceArray[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
					monitoringSchedule.setPlannedfrom(instanceArray[i].getPlannedfrom());
					monitoringSchedule.setPlannedto(instanceArray[i].getPlannedto());
					monitoringSchedule.setStatusquestionnaire(instanceArray[i].getStatusquestionnaire());
					monitoringSchedule.setCodtelecareprogram(instanceArray[i].getCodtelecareprogram());
					monitoringSchedule.setTypemonitoringactivity(typemonitoringactivity);
					
					list.add(monitoringSchedule);
				}
			}			
		}	
		return list;
	}
	
	public List<KtekQuestionnaireMonitoringScheduleEntity> getKtekQuestionnaireMonitoringScheduleNow(String token, String codtelecareprogram, short typemonitoringactivity, short status) throws KtekExceptionEntity {
		log.info("getKtekQuestionnaireMonitoringScheduleNow");
		
		List<KtekQuestionnaireMonitoringScheduleEntity>  list = null;
		KtekQuestionnaireMonitoringScheduleEntity monitoringSchedule = null;
		boolean boolTokenValid=false;
		QuestionnaireManagerDB db = null;
		CommonsManagerDB commonsdb = null;
		Ktek_userquestionnaire_planning[] instanceArray =  null;
		Ktek_user user = null;
		String codUser = null;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);		
		if(boolTokenValid){			
				
			commonsdb = new CommonsManagerDB();
			user=commonsdb.getUser4Token(token); 
			
			if(user!=null)
				codUser=user.getKtek_uk_coduser();			
			else{
				//throw exception
				String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				e.setMessage(exceptionText);
				e.setFunction("QuestionnaireMngServer.getKtekQuestionnaireMonitoringScheduleNow");
				e.setParams(String.valueOf(token));				
				throw e;
			}
			db = new QuestionnaireManagerDB();
			instanceArray = db.getQuestionnaireMonitoringScheduleNow(codUser,codtelecareprogram, typemonitoringactivity, status);
			
			list= new ArrayList<KtekQuestionnaireMonitoringScheduleEntity>();

			if(instanceArray!=null){
				
				for(int i=0;i<instanceArray.length;i++ ){
					monitoringSchedule = new KtekQuestionnaireMonitoringScheduleEntity();					
					monitoringSchedule.setIdquestionnaire(instanceArray[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
					monitoringSchedule.setPlannedfrom(instanceArray[i].getPlannedfrom());
					monitoringSchedule.setPlannedto(instanceArray[i].getPlannedto());
					monitoringSchedule.setStatusquestionnaire(instanceArray[i].getStatusquestionnaire());
					monitoringSchedule.setCodtelecareprogram(instanceArray[i].getCodtelecareprogram());
					
					list.add(monitoringSchedule);
				}
			}			
		}
		
		if(list != null)
			log.info("getKtekQuestionnaireMonitoringScheduleNow list is not null " + list.size());
		else
			log.info("getKtekQuestionnaireMonitoringScheduleNow list is null ");
		return list;
	}

	public boolean setQuestionnaireMonitoringSchedule(String token ,KtekQuestionnaireMonitoringScheduleEntitySet data) throws KtekExceptionEntity{
		boolean boolOK = false;
		boolean boolTokenValid = false;
		QuestionnaireManagerDB db = null;
		List<Ktek_userquestionnaire_planning> list = null;		
		Ktek_userquestionnaire_planning objKtek_userquestionnaire_planning = null;
		Ktek_questionnaire objKtekQuestionnaire = null;
		long datefromQuestionnaire=0, datetoQuestionnaire=0, periodicityvalueQuestionnaire=0;
		long collectiontimefromQuestionnaire=0,collectiontimetoQuestionnaire=0, completionintervalvalueQuestionnaire=0; 
		int looplimit=0, secondlooplimit=0;
		short status=0;
		long plannedfrom=0, plannedto=0;		
		long datefrom=0, dateto=0;
		String codtelecareprogram = null;
		
		long milliseconds=1000;		
		long dayinmilliseconds=24*60*60*milliseconds;
		long weekinmilliseconds=7*dayinmilliseconds;
		long monthinmilliseconds=30*dayinmilliseconds;
						
		long monthmillisincrease=0;
		int dayOfWeek = 0;
		String sFunction="QuestionnaireMngServer.setQuestionnaireMonitoringSchedule";

		boolTokenValid = true;
		if(boolTokenValid){
			if(data!=null){
				db = new QuestionnaireManagerDB();
				
				list = new ArrayList<Ktek_userquestionnaire_planning>();
				
				for(int i=0; i<data.getListquestionnaire().size();i++){
					//GET questionnaire data 
					objKtekQuestionnaire = db.getQuestionnaire(data.getListquestionnaire().get(i));
					
					if(objKtekQuestionnaire==null)
					{
						String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);				
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST);
						e.setMessage(exceptionText);
						e.setFunction(sFunction);
						e.setParams(String.valueOf(data.getListquestionnaire().get(i)));				
						throw e;
					}else{
						//SET STATUS AS PENDING
						status=KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_STATUS_PENDING;
						
						if(objKtekQuestionnaire.getDatevalidfrom()>0)
							datefromQuestionnaire=objKtekQuestionnaire.getDatevalidfrom();
						else{							
							String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_DATEVALIDFROM_NOT_DEFINED);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_DATEVALIDFROM_NOT_DEFINED);
							e.setMessage(exceptionText);
							e.setFunction(sFunction);
							e.setParams(String.valueOf(data.getListquestionnaire().get(i)));				
							throw e;
						}
						
						if(objKtekQuestionnaire.getDatevalidto()!=null)
							datetoQuestionnaire=objKtekQuestionnaire.getDatevalidto();
						else{		
							// nacho 201/25/11 datevalidto can be null
							datetoQuestionnaire = data.getDateto();
						}
						
						if(objKtekQuestionnaire.getPeriodictyvalue()!=null)
							periodicityvalueQuestionnaire=objKtekQuestionnaire.getPeriodictyvalue();
						else if (objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()!=KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_MILESTONE){
							String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_PERIODICITYVALUE_NOT_DEFINED);				
							KtekExceptionEntity e= new KtekExceptionEntity();
							e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_PERIODICITYVALUE_NOT_DEFINED);
							e.setMessage(exceptionText);
							e.setFunction(sFunction);
							e.setParams(String.valueOf(data.getListquestionnaire().get(i)));				
							throw e;
						}
						
						if(objKtekQuestionnaire.getCollectiontimeto()!=null)
							collectiontimetoQuestionnaire=objKtekQuestionnaire.getCollectiontimeto();
						else{							
							collectiontimetoQuestionnaire=0;
						}
						
						if(objKtekQuestionnaire.getCollectiontimefrom()!=null)
							collectiontimefromQuestionnaire=objKtekQuestionnaire.getCollectiontimefrom();
						else{							
							collectiontimefromQuestionnaire=0;
						}
						
						if(objKtekQuestionnaire.getCompletionintervalvalue()!=null)
							completionintervalvalueQuestionnaire=objKtekQuestionnaire.getCompletionintervalvalue();
						else if (objKtekQuestionnaire.getCompletionintervalunit()== null ){
							//nothing to do
							completionintervalvalueQuestionnaire=0;
						}
						else{
							completionintervalvalueQuestionnaire=0;
						}

						//Calculate datefrom dateto for the time range to create the schedule
						if(data.getDatefrom()<=datefromQuestionnaire){
							datefrom=datefromQuestionnaire;
						}else{
							datefrom=data.getDatefrom();
						}
						
						if(datetoQuestionnaire == 0){
							dateto=data.getDateto();
						}else{
							if(data.getDateto()>=datetoQuestionnaire){
								dateto=datetoQuestionnaire;
							}
							else{ 
								dateto=data.getDateto();
								
								
							}
						}
						
						int year, month, day;
						int hours, minutes,seconds;
						
						Calendar dateStart = Utils.getCalendarGMT();
						dateStart.setTimeInMillis(datefrom);
												
						year= dateStart.get(Calendar.YEAR);
						month= dateStart.get(Calendar.MONTH);
						day= dateStart.get(Calendar.DAY_OF_MONTH);						
						
						hours=0;minutes=0;seconds=0;
						datefrom =Utils.getTimeinMillis4FullDateTimeGMT(year,month,day,hours, minutes,seconds);
						
						Calendar dateEnd = Utils.getCalendarGMT();
						dateEnd.setTimeInMillis(dateto);
						
						year = dateEnd.get(Calendar.YEAR);
						month = dateEnd.get(Calendar.MONTH);
						day = dateEnd.get(Calendar.DAY_OF_MONTH);						
							
						hours=23;minutes=59;seconds=59;
						dateto =Utils.getTimeinMillis4FullDateTimeGMT(year, month,day,hours, minutes,seconds);
						
						codtelecareprogram = data.getCodtelecareprogram();
						
						if(objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_DAY){
							
							looplimit=(int) ((int) ((dateto-datefrom)/ dayinmilliseconds)/ periodicityvalueQuestionnaire);
							//add 1 more to avoid missing one questionnaire schedule
							looplimit=looplimit +1;
							
							for(int j=0; j<looplimit; j++){
								plannedfrom=datefrom + periodicityvalueQuestionnaire * j * dayinmilliseconds + collectiontimefromQuestionnaire;
								plannedto=datefrom + periodicityvalueQuestionnaire * j * dayinmilliseconds + collectiontimetoQuestionnaire;
									
								if(objKtekQuestionnaire.getCompletionintervalunit()!=null){
									if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_DAY){
										plannedto=plannedto + completionintervalvalueQuestionnaire *dayinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_WEEK){
										plannedto=plannedto + (completionintervalvalueQuestionnaire *weekinmilliseconds);//*(j+1);
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_MONTH){
										plannedto=plannedto + (completionintervalvalueQuestionnaire *monthinmilliseconds);//*(j+1);
									}
								}				
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
								objKtek_userquestionnaire_planning.setCodtelecareprogram(codtelecareprogram);
									
								list.add(objKtek_userquestionnaire_planning);
								
							}
						}else if(objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_WEEK){

							looplimit=(int) ((int) ((dateto -datefrom )/ weekinmilliseconds)/ periodicityvalueQuestionnaire);
							
							//add 1 more to avoid missing one questionnaire schedule
							looplimit=looplimit +1;
							
							for(int j=0; j<looplimit ; j++){
								
								plannedfrom=datefrom +  periodicityvalueQuestionnaire *j* weekinmilliseconds + collectiontimefromQuestionnaire;
								plannedto=datefrom + periodicityvalueQuestionnaire *j* weekinmilliseconds + collectiontimetoQuestionnaire;
																
								if(objKtekQuestionnaire.getCompletionintervalunit()!=null){
									if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_DAY){
										plannedto=plannedto + periodicityvalueQuestionnaire * completionintervalvalueQuestionnaire *dayinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_WEEK){
										plannedto=plannedto + periodicityvalueQuestionnaire * completionintervalvalueQuestionnaire *weekinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_MONTH){
										plannedto=plannedto + periodicityvalueQuestionnaire* completionintervalvalueQuestionnaire *monthinmilliseconds;
									}
										
									if (plannedto> dateto) {
										plannedto= dateto + collectiontimetoQuestionnaire;
									}
								}
								
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);
								
							}	
						}else if(objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_WEEKDAY){
							looplimit=(int) ((dateto -datefrom)/ dayinmilliseconds);
							secondlooplimit=(int) ((dateto - datefrom)/ weekinmilliseconds);

							//add 1 more to avoid missing one questionnaire schedule
							secondlooplimit=secondlooplimit +1;
							
							for(int j=0; j<looplimit ; j++){
								plannedfrom=datefrom + j* dayinmilliseconds;
								
								Calendar calendarDayOfWeek = Utils.getCalendarGMT();
								calendarDayOfWeek.setTimeInMillis(plannedfrom);
								dayOfWeek = calendarDayOfWeek.get(Calendar.DAY_OF_WEEK);
								
								//DAY_OF_WEEK 1 : sunday 2: monday...
								dayOfWeek=dayOfWeek-1;
								
								if (dayOfWeek == periodicityvalueQuestionnaire){
									datefrom=plannedfrom;
									break;
								}
							}
							
							for(int k=0; k<secondlooplimit ; k++){
								plannedfrom = datefrom + k * weekinmilliseconds + collectiontimefromQuestionnaire;
								plannedto = datefrom + k * weekinmilliseconds + collectiontimetoQuestionnaire;

								if(objKtekQuestionnaire.getCompletionintervalunit()!=null){			
									if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_DAY){
										plannedto=plannedto + completionintervalvalueQuestionnaire *dayinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_WEEK){
										plannedto=plannedto + completionintervalvalueQuestionnaire *weekinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_MONTH){
										plannedto=plannedto + completionintervalvalueQuestionnaire *monthinmilliseconds;
									}
									if (plannedto > dateto) {
										plannedto = dateto + collectiontimetoQuestionnaire;
									}
								}										
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);									
							}
							
						}else if(objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_MONTH){
							
							looplimit=(int) (((dateto -datefrom)/monthinmilliseconds)/ periodicityvalueQuestionnaire);
							
							// add 1 more to avoid missing one questionnaire schedule
							looplimit=looplimit +1;
							
							// maybe the 
							for(int j=0; j<looplimit ; j++){
								
								if(j==0){
									monthmillisincrease =0;	
								}else{
									Calendar calendarMonth = Utils.getCalendarGMT();
									calendarMonth.setTimeInMillis(plannedfrom);
									int days = calendarMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
									monthinmilliseconds = days*dayinmilliseconds;
									
									monthmillisincrease =monthmillisincrease  + monthinmilliseconds;
								}
								
								plannedfrom = datefrom + monthmillisincrease + collectiontimefromQuestionnaire;
								plannedto = datefrom + monthmillisincrease + collectiontimetoQuestionnaire;
								
								if(objKtekQuestionnaire.getCompletionintervalunit()!=null){
									if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_DAY){
										plannedto=plannedto + completionintervalvalueQuestionnaire *dayinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_WEEK){
										plannedto=plannedto + completionintervalvalueQuestionnaire *weekinmilliseconds;
									}else if(objKtekQuestionnaire.getCompletionintervalunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_COMPLETION_INTERVAL_UNIT_MONTH){
										plannedto=plannedto + completionintervalvalueQuestionnaire *monthinmilliseconds;
									}
										
									if (plannedto> dateto) {
										plannedto= dateto + collectiontimetoQuestionnaire;
									}
								}
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
								objKtek_userquestionnaire_planning.setCodtelecareprogram(codtelecareprogram);
									
								list.add(objKtek_userquestionnaire_planning);
								
							}
							
						}else if(objKtekQuestionnaire.getPeriodicityunit() != null && objKtekQuestionnaire.getPeriodicityunit()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_UNIT_MILESTONE){
							
							if(objKtekQuestionnaire.getPeriodictyvalue()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_VALUE_START){
								plannedfrom = datefrom + collectiontimefromQuestionnaire;
								plannedto = datefrom + collectiontimetoQuestionnaire;
								
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);
							}
							else if(objKtekQuestionnaire.getPeriodictyvalue()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_VALUE_END){
								plannedfrom = dateto + collectiontimefromQuestionnaire;
								plannedto = dateto + collectiontimetoQuestionnaire;
								
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);
							}else if(objKtekQuestionnaire.getPeriodictyvalue()==KtekQuestionnaireMonitoringScheduleTypes.QUESTIONNAIRE_MONITORING_SCHEDULE_PERIODICITY_VALUE_START_END){
							    //FIRST
								plannedfrom = datefrom + collectiontimefromQuestionnaire;
								plannedto = datefrom + collectiontimetoQuestionnaire;
								
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);
								
								//SECOND 
								plannedfrom = dateto + collectiontimefromQuestionnaire;
								plannedto = dateto + collectiontimetoQuestionnaire;
								
								objKtek_userquestionnaire_planning= new Ktek_userquestionnaire_planning();
								objKtek_userquestionnaire_planning.setCoduser(data.getCodUser());
								objKtek_userquestionnaire_planning.setKtek_fk_idquestionnaire(objKtekQuestionnaire);
								objKtek_userquestionnaire_planning.setPlannedfrom(plannedfrom);
								objKtek_userquestionnaire_planning.setPlannedto(plannedto);						
								objKtek_userquestionnaire_planning.setStatusquestionnaire(status);
									
								list.add(objKtek_userquestionnaire_planning);								
							}
						}
					}
				}
				boolOK=db.saveQuestionnaireMonitoringSchedule(list);
			}else{
				String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_SCHEDULE_DATA_NOT_DEFINED);				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_SCHEDULE_DATA_NOT_DEFINED);
				e.setMessage(exceptionText);
				e.setFunction(sFunction);
				e.setParams(String.valueOf(token));				
				throw e;
			}
		}
		return boolOK;
	
	}

	public boolean loadfileData(String strfilename) {
		boolean boolOK=false;		
		List<String> data = QuestionnaireLoadFile.readFile(strfilename, true);		
		boolOK=QuestionnaireLoadFile.loadData(data);		
		return boolOK;
	}

	public KtekQuestionnaireResultDataEntity getQuestionnaireResult(String token, int idresultquestionnaire) throws KtekExceptionEntity {
		QuestionnaireManagerDB db = null;
		boolean boolTokenValid = false;		
		KtekQuestionnaireResultDataEntity  entity = null;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);
		
		if(boolTokenValid){	
			db = new QuestionnaireManagerDB();
			entity = db.getQuestionnaireResultWithValues(idresultquestionnaire);
		}
		
		return entity;
	}

	public KtekQuestionnaireModelEntity[] getQuestionnaires4TypeMonitoringActivityPlannedByUserId(int iduser, String codtelecareprogram, int idLang, short typeMonitoringActivity, short status) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity[] array= null;
		array= getQuestionnaires4TypeMonitoringActivityPlannedData(iduser ,codtelecareprogram, idLang, typeMonitoringActivity, status);
		return array;
	}
	
	public List<KtekQuestionnaireModelEntity> getQuestionnaires4TypeMonitoringActivityPlannedByTokenList(String token , String codtelecareprogram, int idLang, short typeMonitoringActivity, short status) throws KtekExceptionEntity {
		List<KtekQuestionnaireModelEntity>  list = null;		
		KtekQuestionnaireModelEntity[] array= null;		
		
		list = new ArrayList<KtekQuestionnaireModelEntity> ();
		array= getQuestionnaires4TypeMonitoringActivityPlannedByToken(token , codtelecareprogram, idLang, typeMonitoringActivity, status);
		
		for(int i=0; i<array.length;i++){
			list.add(array[i]);
		}
		return list;
	}
	
	public KtekQuestionnaireModelEntity[] getQuestionnaires4TypeMonitoringActivityPlannedByToken(String token ,String codtelecareprogram, int idLang, short typeMonitoringActivity, short status) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity[] array= null;
		Ktek_user user = null;		
		boolean boolTokenValid = false;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);		
		if(boolTokenValid){	
			user = UtilsQuestionnaire.getUserByToken(token);
			array = getQuestionnaires4TypeMonitoringActivityPlannedData(user.getKtek_pk_iduser(), codtelecareprogram, idLang,typeMonitoringActivity, status);
		}
		
		return array;
	}
	
	private KtekQuestionnaireModelEntity[] getQuestionnaires4TypeMonitoringActivityPlannedData( int idUser, String codtelecareprogram,int idLang, short typeMonitoringActivity, short status) throws KtekExceptionEntity {
		KtekQuestionnaireModelEntity[] array= null;
		Ktek_questionnaire[] arrayInstance = null;		
		KtekQuestionnaireModelEntity instance = null;
		QuestionnaireManagerDB db = null;		
		Ktek_user user = null;		
		HashSet<Ktek_questionnaire> questionnaireIdHash ;
		Ktek_questionnaire instanceQuestionaire = null;
		
	
		db = new QuestionnaireManagerDB();
		try {
			user = UtilsQuestionnaire.getUserByIdUser(idUser);
			arrayInstance = db.getQuestionnaires4TypeMonitoringActivityPlanned(typeMonitoringActivity,user.getKtek_uk_coduser(),codtelecareprogram, status);
		} catch (Exception e) {				
			e.printStackTrace();
		}
		
		if(arrayInstance !=null && arrayInstance.length>0 ){
			array = new KtekQuestionnaireModelEntity[arrayInstance.length];
			for(int i=0 ;i <arrayInstance.length; i++){		
				instance = BO2Entity.QuestionnaireModelBaseBO2Entity(idLang, arrayInstance[i]);					
				array[i]=instance;					
			}
			
			questionnaireIdHash = new HashSet<Ktek_questionnaire>();			
			for(int i=0 ;i <arrayInstance.length; i++){					
				if(questionnaireIdHash.contains(arrayInstance[i])==false)
				{
					questionnaireIdHash.add(arrayInstance[i]);
				}
			}
			
			array = new KtekQuestionnaireModelEntity[questionnaireIdHash.size()];
			
			Iterator<Ktek_questionnaire> it= questionnaireIdHash.iterator();
			int i =0;
			while (it.hasNext())
			{
				instanceQuestionaire = it.next();
				instance = BO2Entity.QuestionnaireModelBaseBO2Entity(idLang, instanceQuestionaire);					
				array[i]=instance;
				i=i+1;
			}
		}else{
			//array = new KtekQuestionnaireModelEntity[1];
		}		
		
		return array;
	}

	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaires4TypeMonitoringActivityFilter(String token, int idlang, boolean all, long datefrom, long dateto, int orderby, String codtelecareprogram, short typemonitoringactivity) throws KtekExceptionEntity {
		List<KtekQuestionnaireItemFilterEntity> list = null;
		KtekQuestionnaireItemFilterEntity instance = null;
		Ktek_result_questionnaire[]  array = null;
		QuestionnaireManagerDB db = null;				
		CommonsManagerDB commonsdb = null;
		Ktek_user user = null;
		String codUser = null;		
		String nameText = null, desText =null;		
		boolean boolTokenValid = false;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);		
		if(boolTokenValid){	
		
			db = new QuestionnaireManagerDB();
			commonsdb = new CommonsManagerDB();
			try {
				
				user=commonsdb.getUser4Token(token); 
				if(user!=null)
					codUser=user.getKtek_uk_coduser();
				else{
					//throw exception
					String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);				
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
					e.setMessage(exceptionText);
					e.setFunction("QuestionnaireMngServer.getKtekQuestionnaireMonitoringSchedule");
					e.setParams(String.valueOf(token));				
					throw e;
				}
				array = db.getQuestionnaireResults( codUser, all, datefrom, dateto, orderby, codtelecareprogram, typemonitoringactivity);
				
				if(array!= null){
					list  = new ArrayList<KtekQuestionnaireItemFilterEntity>();
					
					for(int i=0; i< array.length;i++){
						instance = new KtekQuestionnaireItemFilterEntity();
					
						instance.setIdquestionnaire(array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
												
						nameText = UtilsQuestionnaire.getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_NAME,
									       array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire(),
									       idlang);
						
						if(nameText.equals("") )
							nameText = array[i].getKtek_fk_idquestionnaire().getNamequestionnaire();
							
						desText= UtilsQuestionnaire.getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_DES,
										 array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire(),
										 idlang);
						
						if(desText.equals("") )
							desText = array[i].getKtek_fk_idquestionnaire().getDesquestionnaire();
						
						
						instance.setNamequestionnaire(nameText);
						instance.setDesquestionnaire(desText);
						
						instance.setResultcreation(array[i].getResultcreation());
						instance.setIdresultquestionnaire(array[i].getKtek_pk_idresultquestionnaire());
												
						list.add(instance);
					}
				}else{
					log.debug("getQuestionnaires4TypeMonitoringActivityFilter :  array is null "+ datefrom + " "  +  dateto +  " " + typemonitoringactivity  );
				}
				
			}catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		return list;
	}	
	
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaires4TypeMonitoringActivityFilterWithIds(	String token, int idlang, boolean all, long datefrom, long dateto,int orderby, short typemonitoringactivity, String ids, String codtelecareprogram) throws KtekExceptionEntity {
		
		List<KtekResultQuestionnaireItemsEntity> list = null;
		KtekResultQuestionnaireItemsEntity instance = null;
		QuestionnaireManagerDB db = null;	
		String[] idsArray=null;
		Integer[] lids = null;
		Ktek_result_questionnaireitem[] arrayResults = null;
		List<KtekResultQuestionnaireItemValuesEntity> values = null;
		KtekResultQuestionnaireItemValuesEntity value = null;
		int idQuestionnaireItemPrevious =0;
		CommonsManagerDB commonsdb = null;
		Ktek_user user = null;
		String codUser = null;
		String nameQuestionnaireItem =null;
		boolean boolTokenValid = false;
		
		boolTokenValid= UtilsQuestionnaire.isTokenValid(token);
		if(boolTokenValid){	
		
			db = new QuestionnaireManagerDB();
			commonsdb = new CommonsManagerDB();
			try {
				
				idsArray= ids.split(",");
				
				if (idsArray!=null){
					lids = new Integer[idsArray.length];  
					for (int i = 0; i < idsArray.length; i++) {  
						lids[i] = Integer.valueOf( idsArray[i]);  
					}
				}
				
				user=commonsdb.getUser4Token(token); 
				if(user!=null)
					codUser=user.getKtek_uk_coduser();
				else{
					//throw exception
					String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);				
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
					e.setMessage(exceptionText);
					e.setFunction("QuestionnaireMngServer.getKtekQuestionnaireMonitoringSchedule");
					e.setParams(String.valueOf(token));				
					throw e;
				}
				
				arrayResults = db.getResultQuestionnaireItems4ResultQuestionnaire(all, datefrom, dateto, orderby, typemonitoringactivity,codUser,lids, codtelecareprogram);
				
				if(arrayResults!= null && arrayResults.length >0){
					
					log.debug("getQuestionnaires4TypeMonitoringActivityFilterWithIds :  arrayResults is  not null "+ arrayResults.length);
					list  = new ArrayList<KtekResultQuestionnaireItemsEntity>();
					
					for(int i=0 ; i<arrayResults.length ; i++){
						nameQuestionnaireItem =null;
						
						if(i==0){
							
							instance = new KtekResultQuestionnaireItemsEntity();
							
							instance.setIdquestionnaireitem(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem());
							instance.setCodquestionnaireitem(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_uk_codquestionnaireitem());
												
							nameQuestionnaireItem= UtilsQuestionnaire.getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_ITEM_NAME,
									arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem(),
									idlang);
							if(nameQuestionnaireItem == null || nameQuestionnaireItem.equals(""))
								nameQuestionnaireItem = arrayResults[i].getKtek_fk_idquestionnaireitem().getNamequestionnaireitem();
							
							instance.setNamequestionnaireitem(nameQuestionnaireItem);
							
							if(arrayResults[i].getKtek_fk_idquestionnaireitem().getTypequestionnaireitem()==KtekQuestionnaireItemType.QUESTIONNAIRE_ITEM_PARAMETER){
								instance.setValuemax(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_parameter().getValuemax());
								instance.setValuemin(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_parameter().getValuemin());
							}
							
							idQuestionnaireItemPrevious = arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem();
							values = new ArrayList<KtekResultQuestionnaireItemValuesEntity>();
							
							log.debug("getQuestionnaires4TypeMonitoringActivityFilterWithIds :  nameQuestionnaireItem  "+ nameQuestionnaireItem );														
						}
						else{
							if(idQuestionnaireItemPrevious != arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem()){
								
								instance.setValues(values);
								list.add(instance);
								
								instance = new KtekResultQuestionnaireItemsEntity();
								
								instance.setIdquestionnaireitem(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem());
								instance.setCodquestionnaireitem(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_uk_codquestionnaireitem());
								
								if(nameQuestionnaireItem == null || nameQuestionnaireItem.equals(""))
									nameQuestionnaireItem = arrayResults[i].getKtek_fk_idquestionnaireitem().getNamequestionnaireitem();
								
								instance.setNamequestionnaireitem(nameQuestionnaireItem);
								
								if(arrayResults[i].getKtek_fk_idquestionnaireitem().getTypequestionnaireitem()==KtekQuestionnaireItemType.QUESTIONNAIRE_ITEM_PARAMETER){
									instance.setValuemax(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_parameter().getValuemax());
									instance.setValuemin(arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_parameter().getValuemin());
								}
								idQuestionnaireItemPrevious = arrayResults[i].getKtek_fk_idquestionnaireitem().getKtek_pk_idquestionnaireitem();								
								values = new ArrayList<KtekResultQuestionnaireItemValuesEntity>();								
								
							}
						}
						
						value = new KtekResultQuestionnaireItemValuesEntity();
						value.setDate(arrayResults[i].getKtek_fk_idresultquestionnairesection().getKtek_fk_idresultquestionnaire().getResultcreation());
						
						if(arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_ANSWERSET){
							value.setValue(String.valueOf(arrayResults[i].getScoreanswer()));
						}else if (arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_INTEGER){
							value.setValue(String.valueOf(arrayResults[i].getIntegervalue()));
						}else if (arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DECIMAL){
							value.setValue(String.valueOf(arrayResults[i].getDecimalvalue()));
						}else if (arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_DATETIME){
							value.setValue(String.valueOf(arrayResults[i].getDecimalvalue()));
						}else if (arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_STRING){
							value.setValue(String.valueOf(arrayResults[i].getStringvalue()));
						}else if (arrayResults[i].getTyperesult()==KtekQuestionnaireItemResultType.QUESTIONNAIRE_ITEM_RESULT_TYPE_TEXT){
							value.setValue(String.valueOf(arrayResults[i].getTextvalue()));
						}
					
						if(value != null)
							values.add(value);
						
						
					}
					//add last
					if(values != null)
						instance.setValues(values);
					
					list.add(instance);
					
				}else{
					log.debug("getQuestionnaires4TypeMonitoringActivityFilterWithIds :  array is null "+ datefrom + " "  +  dateto +  " " + typemonitoringactivity  );
				}
				
			}catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<KtekQuestionnaireModelEntity> getQuestionnaires4TypeMonitoringActivityPlanned(int idlang, short typeMonitoringActivity, String codUser, String codtelecareprogram, short status){
		List<KtekQuestionnaireModelEntity> list = new ArrayList<KtekQuestionnaireModelEntity>();
		KtekQuestionnaireModelEntity instance = null;		
		Ktek_questionnaire[] array = null;
		QuestionnaireManagerDB questionnaireDB = null;
		
		questionnaireDB = new QuestionnaireManagerDB();		
		array = questionnaireDB.getQuestionnaires4TypeMonitoringActivityPlanned(typeMonitoringActivity,codUser,codtelecareprogram,status);
		
		int num= 0;
		if(array != null)
			num = array.length;
				
		log.info(" QuestionnaireMngServer.getQuestionnaires4TypeMonitoringActivityPlanned : typeMonitoringActivity " +  typeMonitoringActivity + " codUser " + codUser + " status: " + status + " num : " +num) ; 
		
		for(int i=0; i<array.length; i++){
			instance = BO2Entity.QuestionnaireModelBaseBO2Entity(idlang,array[i]);
			list.add(instance);
		}
			
		return list;		
	}

	public Ktek_questionnaireitem[] getQuestionnaireitemList4QuestionnaireSet(Integer[] idQuestionnaireArray, short[] typeMonitoringActivityArray){
		Ktek_questionnaireitem[] array = null;
		QuestionnaireManagerDB questionnaireDB = null;
		
		questionnaireDB = new QuestionnaireManagerDB();
		array= questionnaireDB.getQuestionnaireitemList4QuestionnaireSet(idQuestionnaireArray,typeMonitoringActivityArray);
	
		return array;
	}

	public Ktek_questionnaireitem[] getQuestionnaireitemList4QuestionnairePlannedFinished(String coduser, short[] typeMonitoringActivityArray, String codtelecareprogram){
		Ktek_questionnaireitem[] array = null;
		QuestionnaireManagerDB questionnaireDB = null;
		
		questionnaireDB = new QuestionnaireManagerDB();
		array = questionnaireDB.getQuestionnaireitemList4QuestionnairePlannedFinished(coduser, typeMonitoringActivityArray, codtelecareprogram);
		
		return array;
	}

	public KtekQuestionnaireMonitoringScheduleListEntity getKtekQuestionnaireMonitoringScheduleEntity(String token, long datefrom, long dateto,
			short typemonitoringactivity, short status) throws KtekExceptionEntity {
				
		KtekQuestionnaireMonitoringScheduleEntity[] array = null;
		Iterator<KtekQuestionnaireMonitoringScheduleEntity> it = null;
		int num =0;
		KtekQuestionnaireMonitoringScheduleEntity instance = null;
		KtekQuestionnaireMonitoringScheduleListEntity entity= new KtekQuestionnaireMonitoringScheduleListEntity();
		List<KtekQuestionnaireMonitoringScheduleEntity> schedules = null;
			
		schedules = getKtekQuestionnaireMonitoringSchedule(token, datefrom, dateto,typemonitoringactivity, status);	
		if (schedules !=null && schedules.size()>0){
			it = schedules.iterator();
			array = new KtekQuestionnaireMonitoringScheduleEntity[schedules.size()];
		
			while (it.hasNext()){
				instance = it.next();				
				array[num]= instance;
				num=num+1;			 
			}
		}
		
		entity.setSchedules(array);
		return entity;
	}

	public boolean loadfileDataStream(InputStream stream) {
		boolean boolOK=false;
		List<String> data = null;
		
		data = getStringLinesFromInputStream(stream);
		boolOK=QuestionnaireLoadFile.loadData(data);		
		
		return boolOK;
	}
	
	private List<String> getStringLinesFromInputStream(InputStream is) {
		List<String> data = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder(); 
		String line;
		
		try {
			data = new ArrayList<String>(); 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
				data.add(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
			log.error("getStringLinesFromInputStream Exception " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	
	public boolean setQuestionnaireConfiguration(KtekQuestionnaireConfiguration instance) {
		boolean boolOK =false;
		Ktek_questionnaireconfiguration instanceDAO= null;
		QuestionnaireManagerDB db = null;
		
		db = new QuestionnaireManagerDB();
		instanceDAO = new Ktek_questionnaireconfiguration ();
		if(instance != null){
			instanceDAO.setEndpointserver(instance.getEndpointserver());
			instanceDAO.setEventserviceoauth2headertoken(instance.getEventserviceoauth2headertoken());
			instanceDAO.setKtek_pk_ktek_idquestionnaireconfiguration(instance.getIdquestionnaireconfiguration());
			instanceDAO.setKtek_typesave(instance.getTypesave());
			instanceDAO.setPort(instance.getPort());
			instanceDAO.setTimeout(instance.getTimeout());
		}
		boolOK = db.saveQuestionaireConfiguration(instanceDAO);
	
		return boolOK;
	}

	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaireResults4IdQuestionnaire(int idquestionnaire, int idlang) {
		List<KtekQuestionnaireItemFilterEntity> list = null;
		KtekQuestionnaireItemFilterEntity instance = null; 
		Ktek_result_questionnaire[] array = null;
		QuestionnaireManagerDB db = null;
		String nameText = null;
		String desText = null;
		
		db = new QuestionnaireManagerDB();
		array = db.getQuestionnaireResult4IdQuestionnaire(idquestionnaire);		
		if(array != null && array.length>0){			
			list = new ArrayList<KtekQuestionnaireItemFilterEntity>();
			
			for (int i=0 ; i< array.length ;i++ ){				
				instance = new KtekQuestionnaireItemFilterEntity();				
				instance.setIdquestionnaire(array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire());
				instance.setIdresultquestionnaire(array[i].getKtek_pk_idresultquestionnaire());
				instance.setResultcreation(array[i].getResultcreation());
				
				nameText = UtilsQuestionnaire.getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_NAME,
							       array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire(),
							       idlang);
				
				if(nameText.equals(""))
					nameText = array[i].getKtek_fk_idquestionnaire().getNamequestionnaire();
					
				desText= UtilsQuestionnaire.getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_DES,
								 array[i].getKtek_fk_idquestionnaire().getKtek_pk_idquestionnaire(),
								 idlang);

				if(desText.equals(""))
					desText = array[i].getKtek_fk_idquestionnaire().getDesquestionnaire();
				
				instance.setNamequestionnaire(nameText);
				instance.setDesquestionnaire(desText);
								
				list.add(instance);
			}
		}		
		return list;		
	}	
}