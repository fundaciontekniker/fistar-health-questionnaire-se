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
package es.tekniker.framework.ktek.questionnaire.mng.test;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.TestData;
import es.tekniker.framework.ktek.questionnaire.mng.server.QuestionnaireMngServer;

public class TestQuestionnaireMngServer {

	private static Log log =
		    LogFactory.getLog(TestQuestionnaireMngServer.class);
	
	@org.junit.Test	
	public void testGetKtekQuestionnaireModelByToken(){
		log.info("*************************************************************" );		
		log.info("testGetKtekQuestionnaireModelByToken: START " );

		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
		String  result= TestDefines.RESULT_OK;
		Assert.assertTrue(true);
		
		int idquestionnaire = 1;
		int idlang = 1;		
		String token = null;
		KtekQuestionnaireModelEntity instance = null;
		String codtelecareprogram="TBP1"; 
		try {
			
			token= TestData.getLoginToken();
			
			instance = manager.getQuestionnaireModelByToken(token, idlang, codtelecareprogram, idquestionnaire);
						
			if(instance !=null )	{
				log.info("testGetKtekQuestionnaireModelByToken: instance  is not null" );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetKtekQuestionnaireModelByToken: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
		} catch (KtekExceptionEntity e) {
			log.error("testGetKtekQuestionnaireModelByToken:  Exception " + e.getMessage());			
			e.printStackTrace();
			result = TestDefines.RESULT_EXCEPTION;
			Assert.assertTrue(false);
		}
		
		log.info("testGetKtekQuestionnaireModelByToken: RESULT "  + result );
		log.info("testGetKtekQuestionnaireModelByToken: END " );
		log.info("*************************************************************" );
		log.info("");
	}
	
	@org.junit.Test	
	public void testSaveKtekQuestionnaireAssessment(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireAssessment: START " );

		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
		String  result= TestDefines.RESULT_OK;
		Assert.assertTrue(true);
		
		String token = null;
		int boolOK = 0;
		KtekQuestionnaireResultEntity resultData = null;
		try {
			
			token= TestData.getLoginToken();
						
			resultData = es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireAssessmentResultEntity1();
			
			boolOK = manager.saveQuestionnaireModel(token, resultData);
						
			if(boolOK==1)	{
				log.info("testSaveKtekQuestionnaireAssessment: OK" );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireAssessment: ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
		} catch (KtekExceptionEntity e) {
			log.error("testSaveKtekQuestionnaireAssessment:  Exception " + e.getMessage());			
			e.printStackTrace();
			result = TestDefines.RESULT_EXCEPTION;
			Assert.assertTrue(false);
		}
		
		log.info("testSaveKtekQuestionnaireAssessment: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireAssessment: END " );
		log.info("*************************************************************" );
		log.info("");
	}
	
	@org.junit.Test	
	public void testGetKtekQuestionnaireMonitoringByToken(){
		log.info("*************************************************************" );		
		log.info("testGetKtekQuestionnaireMonitoringByToken: START " );

		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
		String  result= TestDefines.RESULT_OK;
		Assert.assertTrue(true);
		
		int idquestionnaire = 12;
		int idlang = 1;		
		String token = null;
		KtekQuestionnaireModelEntity instance = null;
		String codtelecareprogram="TBP1"; 
		try {
			
			token= TestData.getLoginToken();
			
			instance = manager.getQuestionnaireModelByToken(token, idlang, codtelecareprogram, idquestionnaire);
						
			if(instance !=null )	{
				log.info("testGetKtekQuestionnaireMonitoringByToken: instance  is not null" );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testGetKtekQuestionnaireMonitoringByToken: instance is NULL " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
		} catch (KtekExceptionEntity e) {
			log.error("testGetKtekQuestionnaireMonitoringByToken:  Exception " + e.getMessage());			
			e.printStackTrace();
			result = TestDefines.RESULT_EXCEPTION;
			Assert.assertTrue(false);
		}
		
		log.info("testGetKtekQuestionnaireMonitoringByToken: RESULT "  + result );
		log.info("testGetKtekQuestionnaireMonitoringByToken: END " );
		log.info("*************************************************************" );
		log.info("");
	}
	
	@org.junit.Test	
	public void testSaveKtekQuestionnaireMonitoring(){
		log.info("*************************************************************" );		
		log.info("testSaveKtekQuestionnaireMonitoring: START " );

		QuestionnaireMngServer manager= new QuestionnaireMngServer ();
		String  result= TestDefines.RESULT_OK;
		Assert.assertTrue(true);
		
		String token = null;
		int boolOK = 0;
		KtekQuestionnaireResultEntity resultData = null;
		try {
			
			token= TestData.getLoginToken();
			
			resultData = es.tekniker.framework.ktek.questionnaire.mng.db.TestData.getKtekQuestionnaireMonitoringResultEntityWithParameters();
			
			boolOK = manager.saveQuestionnaireModel(token, resultData);
						
			if(boolOK==1)	{
				log.info("testSaveKtekQuestionnaireMonitoring: OK" );
				Assert.assertTrue(true);
			}
			else{		
				log.error("testSaveKtekQuestionnaireMonitoring: ERROR " );
				result= TestDefines.RESULT_ERROR;
				Assert.assertTrue(false);
			}
		} catch (KtekExceptionEntity e) {
			log.error("testSaveKtekQuestionnaireMonitoring:  Exception " + e.getMessage());			
			e.printStackTrace();
			result = TestDefines.RESULT_EXCEPTION;
			Assert.assertTrue(false);
		}
		
		log.info("testSaveKtekQuestionnaireMonitoring: RESULT "  + result );
		log.info("testSaveKtekQuestionnaireMonitoring: END " );
		log.info("*************************************************************" );
		log.info("");
	}
	
	
}
