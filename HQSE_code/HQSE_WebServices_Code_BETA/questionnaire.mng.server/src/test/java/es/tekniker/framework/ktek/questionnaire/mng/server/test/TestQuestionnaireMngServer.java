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
package es.tekniker.framework.ktek.questionnaire.mng.server.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.drugtreatment.mng.server.DrugTreatmentMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireStatus;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntitySet;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleListEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.TestData;
import es.tekniker.framework.ktek.questionnaire.mng.server.QuestionnaireMngServer;

@Ignore("disable tests for first compilation")
public class TestQuestionnaireMngServer {

	private static Log log = LogFactory.getLog(TestQuestionnaireMngServer.class);
		
	//@org.junit.Test	
	public void testLoadFile(){
		log.info("*************************************************************" );		
		log.info("testLoadFile: START " );
	
		QuestionnaireMngServer mng= new QuestionnaireMngServer();
		String  result= TestDefines.RESULT_OK;
		
		boolean boolValid = false;
		String  strfilename = null;
		try {
			
			
			strfilename = "D:\\Proyectos\\FI-STAR\\code\\subversion\\trunk\\backend\\db\\dataLoadQuestionnaire_QSE.csv";
			
			boolValid = mng.loadfileData(strfilename);
			if(boolValid)
			{
				log.info("testLoadFile: Token Valid "  );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testLoadFile: Token NO Valid " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("testLoadFile EXCEPTION: " + e.getMessage());
			Assert.assertTrue(false);
			result= TestDefines.RESULT_EXCEPTION;
		}
		
		log.info("testLoadFile: RESULT "  + result );
		log.info("testLoadFile: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
	
	@org.junit.Test	
	public void testGetQuestionnaireModelByToken(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireModelByToken: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
 		int idlang=1;
		int idquestionnaire=1;
		KtekQuestionnaireModelEntity instance =  null;
		String codtelecareprogram ="TBP1";
 		try{  			 
 			token= TestData.getLoginToken();
			instance = manager.getQuestionnaireModelByToken(token, idlang, codtelecareprogram, idquestionnaire);
			
			if(instance!=null ){
				log.info("testGetQuestionnaireModelByToken: instanc is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaireModelByToken: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetQuestionnaireModelByToken:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetQuestionnaireModelByToken: RESULT "  + result );
		log.info("testGetQuestionnaireModelByToken: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireAssesment1(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireAssesment1: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireAssessmentResultEntity1();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK==1){
				log.info("testSaveKtekQuestionnaireAssesment1: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireAssesment1: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireAssesment1:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
		
		log.info("testSaveKtekQuestionnaireAssesment1: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireAssesment1: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireAssesment2(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireAssesment2: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireAssessmentResultEntity2();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK==1 ){
				log.info("testSaveKtekQuestionnaireAssesment2: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireAssesment2: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireAssesment2:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
		
		log.info("testSaveKtekQuestionnaireAssesment2: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireAssesment2: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireAssesment3(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireAssesment3: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireAssessmentResultEntity3();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1){
				log.info("testSaveKtekQuestionnaireAssesment3: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireAssesment3: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireAssesment3:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
		
		log.info("testSaveKtekQuestionnaireAssesment3: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireAssesment3: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireAssesmentError1(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireAssesmentError1: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireAssessmentResultEntityError1();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1){
				log.info("testSaveKtekQuestionnaireAssesmentError1: SAVE OK " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			else{		
				log.error("testSaveKtekQuestionnaireAssesmentError1: SAVE ERROR " );
				Assert.assertTrue(true);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireAssesmentError1:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
		
		log.info("testSaveKtekQuestionnaireAssesmentError1: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireAssesmentError1: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoringWithParameters(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoringWithParameters: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireMonitoringResultEntityWithParameters();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1 ){
				log.info("testSaveKtekQuestionnaireMonitoringWithParameters: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoringWithParameters: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireMonitoringWithParameters:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
		log.info("testSaveKtekQuestionnaireMonitoringWithParameters: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoringWithParameters: END " );
		log.info("*************************************************************" );
		log.info("");
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoringWithQuestions(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoringWithQuestions: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireMonitoringResultEntityWithQuestions();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1){
				log.info("testSaveKtekQuestionnaireMonitoringWithQuestions: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoringWithQuestions: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireMonitoringWithQuestions:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
		log.info("testSaveKtekQuestionnaireMonitoringWithQuestions: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoringWithQuestions: END " );
		log.info("*************************************************************" );
		log.info("");
	}

	@org.junit.Test	
	public void testGetKtekQuestionnaireMonitoringSchedule(){
		log.info("*************************************************************" );		
		log.info("testGetKtekQuestionnaireMonitoringSchedule: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
		KtekQuestionnaireMonitoringScheduleListEntity list =  null;
		long datefrom=0, dateto=0;
		short typemonitoringactivity=2;
		short status =1;
 		try{ 
 			datefrom=(long) 1417478400129.0;
 			dateto=(long)   1417564799129.0;
 					
 			token= TestData.getLoginToken();
 			list = manager.getKtekQuestionnaireMonitoringScheduleEntity(token, datefrom, dateto, typemonitoringactivity, status);
			
			if(list!=null ){
				log.info("testGetKtekQuestionnaireMonitoringSchedule: instance is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetKtekQuestionnaireMonitoringSchedule: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetKtekQuestionnaireMonitoringSchedule:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetKtekQuestionnaireMonitoringSchedule: RESULT "  + result );
		log.info("testGetKtekQuestionnaireMonitoringSchedule: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	@org.junit.Test	
	public void testGetKtekQuestionnaireMonitoringScheduleNow(){
		log.info("*************************************************************" );		
		log.info("testGetKtekQuestionnaireMonitoringSchedule: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
		short typemonitoringactivity=1;
		short status =1;
		String codtelecareprogram ="DEP1";
		
 		try{ 
 			token= TestData.getLoginToken();
 			List<KtekQuestionnaireMonitoringScheduleEntity> list = manager.getKtekQuestionnaireMonitoringScheduleNow(token, codtelecareprogram , typemonitoringactivity, status);
			
			if(list!=null ){
				log.info("testGetKtekQuestionnaireMonitoringSchedule: instance is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetKtekQuestionnaireMonitoringSchedule: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetKtekQuestionnaireMonitoringSchedule:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetKtekQuestionnaireMonitoringSchedule: RESULT "  + result );
		log.info("testGetKtekQuestionnaireMonitoringSchedule: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	//@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoringSchedule(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoringSchedule: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
		KtekQuestionnaireMonitoringScheduleEntitySet data = null;
		boolean boolOK = false;
		long datefrom=0,dateto=0;
		List<Integer> listquestionnaire;
		try{ 
			
			datefrom=(long) 1419206400000.0; // Dec 1 2014 11:28:01 GMT+0100
			
			dateto=(long) 1427068799000.0; // Wed Dec 31 2014 11:28:01 GMT+0100
			
			listquestionnaire= new ArrayList<Integer>();
						
			listquestionnaire.add(new Integer(36)); // day		
			
			
			data = new KtekQuestionnaireMonitoringScheduleEntitySet();
			data.setCodUser("User1");
			data.setDatefrom(datefrom);
			data.setDateto(dateto);
			data.setListquestionnaire(listquestionnaire);
			data.setCodtelecareprogram("TBP1");
			
 			token= TestData.getLoginToken();
			boolOK = manager.setQuestionnaireMonitoringSchedule(token, data);
			if(boolOK ){
				log.info("testSaveKtekQuestionnaireMonitoringSchedule: OK" );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoringSchedule: ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireMonitoringSchedule:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testSaveKtekQuestionnaireMonitoringSchedule: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoringSchedule: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}

	//@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireMonitoringResultEntityWithParametersWithQuestions();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1){
				log.info("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
		log.info("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoringWithParametersWithQuestions: END " );
		log.info("*************************************************************" );
		log.info("");
	}

	//@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoringIT18(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoringIT18: START " );
		String  result= TestDefines.RESULT_OK;
		
		String token = null;
		KtekQuestionnaireResultEntity resultData = null;
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		int boolOK = 0;
 		
		try{
			
			token= TestData.getLoginToken();
			resultData=es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireMonitoringResultEntityIT18();
			
			boolOK=manager.saveQuestionnaireModel(token, resultData);
		
			if(boolOK ==1){
				log.info("testSaveKtekQuestionnaireMonitoringIT18: SAVE OK " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoringIT18: SAVE ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (KtekExceptionEntity e) {			
			System.out.println("testSaveKtekQuestionnaireMonitoringIT18:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
		log.info("testSaveKtekQuestionnaireMonitoringIT18: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoringIT18: END " );
		log.info("*************************************************************" );
		log.info("");
	}

	@org.junit.Test	
	public void getQuestionnaires4TypeMonitoringActivityPlannedByToken(){
		log.info("*************************************************************" );		
		log.info("getQuestionnaires4TypeMonitoringActivityPlannedByToken: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
 		int idlang=1;
 		KtekQuestionnaireModelEntity[] array = null;
 		
 		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_PENDING;
		String codtelecareprogram ="TBP1";
		
			
		
 		try{  			 
 			token= TestData.getLoginToken();
			array = manager.getQuestionnaires4TypeMonitoringActivityPlannedByToken(token, codtelecareprogram, idlang, KtekApplicationitemType.STATUSPARAMETERS, status);
			
			if(array!=null ){
				log.info("getQuestionnaires4TypeMonitoringActivityPlannedByToken: array is NOT NULL " + array.length );
				Assert.assertTrue(true);
			}
			else{		
				log.error("getQuestionnaires4TypeMonitoringActivityPlannedByToken: array is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(true);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("getQuestionnaires4TypeMonitoringActivityPlannedByToken:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("getQuestionnaires4TypeMonitoringActivityPlannedByToken: RESULT "  + result );
		log.info("getQuestionnaires4TypeMonitoringActivityPlannedByToken: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
    @org.junit.Test	
	public void testGetQuestionnaires4TypeMonitoringActivityFilterWithIds(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
 		int idlang=1;
 		List<KtekResultQuestionnaireItemsEntity> array = null;
 		boolean all = false;
 		long datefrom =(long) 1420113600000.0;
 		long dateto=(long) 1451649600000.0;
 		int orderby=2;
 		short typemonitoringactivity=3;
 		String ids= "0";
 		String codtelecareprogram = "BD";
 		try{  			 
 			token ="token1";
 			array = manager.getQuestionnaires4TypeMonitoringActivityFilterWithIds(	token, idlang,  all,  datefrom,  dateto, orderby,  typemonitoringactivity,  ids, codtelecareprogram); 
 				
 			
			if(array!=null ){
				log.info("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds: array is NOT NULL " + array.size() );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds: array is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(true);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds: RESULT "  + result );
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilterWithIds: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}

    
    @org.junit.Test	
	public void testGetQuestionnaires4TypeMonitoringActivityFilter(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: START " );
		String  result= TestDefines.RESULT_OK;
				
		String token= null;
 		int idlang=1;
 		List<KtekResultQuestionnaireItemsEntity> array = null;
 		boolean all = false;
 		long datefrom =(long) 1420113600000.0;
 		long dateto=(long) 1451649600000.0;
 		int orderby=2;
 		String codtelecareprogram = "BD";
 		try{  			 
 			token ="token1";
 			DrugTreatmentMngServer objMngServer = new DrugTreatmentMngServer ();	
 			
 			List<KtekQuestionnaireItemFilterEntity> list = objMngServer.getQuestionnaires4TypeMonitoringActivityFilter(token, idlang,codtelecareprogram, all, datefrom, dateto, orderby);
 				
			if(list!=null ){
				log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: list is NOT NULL " + list.size() );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaires4TypeMonitoringActivityFilter: list is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(true);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetQuestionnaires4TypeMonitoringActivityFilter:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: RESULT "  + result );
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}

    
	@org.junit.Test	
	public void testGetQuestionnaireModelWithResults(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireModelWithResults: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		String token= null;
 		int idlang=1;
		int idresultquestionnaire=161;
		KtekQuestionnaireModelEntity instance =  null;
		String codtelecareprogram="TBP1"; 
 		try{  			 
 			token= TestData.getLoginToken();
			instance = manager.getQuestionnaireModelWithResults(token, idlang, codtelecareprogram, idresultquestionnaire);
			
			if(instance!=null ){
				log.info("testGetQuestionnaireModelWithResults: instanc is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaireModelWithResults: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(true);
			}
			
 		} catch (KtekExceptionEntity e) {			
			System.out.println("testGetQuestionnaireModelWithResults:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetQuestionnaireModelWithResults: RESULT "  + result );
		log.info("testGetQuestionnaireModelWithResults: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}
	
	@org.junit.Test
	public void testGetQuestionnaires4TypeMonitoringActivityPlanned(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: START " );
		String  result= TestDefines.RESULT_OK;
				
		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
 		
		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_PENDING;
		int idlang =1;
		String codtelecareprogram="TBP1";
		String codUser ="User1";
 		try{  
 			
 			List<KtekQuestionnaireModelEntity> list = manager.getQuestionnaires4TypeMonitoringActivityPlanned(idlang, KtekApplicationitemType.DRUGFOLLOWUP,codUser,codtelecareprogram, status);
 			
			if(list!=null ){
				log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: instanc is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaires4TypeMonitoringActivityPlanned: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
 		} catch (Exception e) {			
			System.out.println("testGetQuestionnaires4TypeMonitoringActivityPlanned:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}
 		
 		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: RESULT "  + result );
		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: END " );
		log.info("*************************************************************" );
		log.info("");
 		
	}

	@org.junit.Test
	public void testGetQuestionnaireitemList4QuestionnairePlannedFinished(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: START " );
		String  result= TestDefines.RESULT_OK;
		String coduser ="user1";
		short[] typeMonitoringActivityArray;
		String codtelecareprogram ="TBP1";
		try{
			
			typeMonitoringActivityArray = new short[1];
			typeMonitoringActivityArray[0]=1;
			
			QuestionnaireMngServer objMngServer = new QuestionnaireMngServer();
			
			Ktek_questionnaireitem[] array = objMngServer.getQuestionnaireitemList4QuestionnairePlannedFinished(coduser, typeMonitoringActivityArray, codtelecareprogram);
	
			if(array!=null ){
				log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: instanc is NOT NULL " );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetQuestionnaireitemList4QuestionnairePlannedFinished: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {			
			System.out.println("testGetQuestionnaireitemList4QuestionnairePlannedFinished:  exception " + e.getMessage());			
			e.printStackTrace();
			Assert.assertFalse(false);
		}

		log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: RESULT "  + result );
		log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: END " );
		log.info("*************************************************************" );
		log.info("");

	}
	
	
}
