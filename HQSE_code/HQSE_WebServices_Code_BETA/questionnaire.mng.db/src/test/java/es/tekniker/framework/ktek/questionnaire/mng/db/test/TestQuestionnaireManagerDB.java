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
package es.tekniker.framework.ktek.questionnaire.mng.db.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import es.tekniker.framework.ktek.Ktek_answer;
import es.tekniker.framework.ktek.Ktek_formatquestionnaire;
import es.tekniker.framework.ktek.Ktek_question;
import es.tekniker.framework.ktek.Ktek_questionnaire;
import es.tekniker.framework.ktek.Ktek_questionnaireconfiguration;
import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_questionnairesection;
import es.tekniker.framework.ktek.Ktek_result_questionnaire;
import es.tekniker.framework.ktek.Ktek_userquestionnaire_planning;
import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireStatus;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireManagerDB;
import es.tekniker.framework.ktek.questionnaire.mng.db.TestData;

@Ignore("disable tests for first compilation")
public class TestQuestionnaireManagerDB {

	private static Log log = LogFactory.getLog(TestQuestionnaireManagerDB.class);

		
	//@org.junit.Test	
	public void testGetQuestion4QuestionnaireItem(){
		log.info("*************************************************************" );		
		log.info("testGetQuestion4QuestionnaireItem: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaireitem=2;
		
		Ktek_question instance = db.getQuestion4QuestionnaireItem(idquestionnaireitem);
		
		if(instance!=null)
		{
			log.info("testGetQuestion4QuestionnaireItem: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestion4QuestionnaireItem: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestion4QuestionnaireItem: RESULT "  + result );
		log.info("testGetQuestion4QuestionnaireItem: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaire(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaire: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaire = 1;
		Ktek_questionnaire instance = null;
		PersistentSession session = null;
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();				
			
			instance = db.getQuestionnaire(session,idquestionnaire);
			session.close();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaire: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaire: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaire: RESULT "  + result );
		log.info("testGetQuestionnaire: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireAnswer(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireAnswer: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		String codAnswer ="A2";
		Ktek_answer instance = null;
		PersistentSession session = null;
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();				
			
			instance = db.getQuestionnaireAnswer(session,codAnswer);
			session.close();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireAnswer: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireAnswer: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireAnswer: RESULT "  + result );
		log.info("testGetQuestionnaireAnswer: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	//@org.junit.Test	
	public void testGetQuestionnaireAssesmentConfiguration(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireAssesmentConfiguration: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaire=1;
		
		Ktek_formatquestionnaire instance = db.getQuestionnaireAssessmentConfiguration(idquestionnaire);
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireAssesmentConfiguration: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireAssesmentConfiguration: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireAssesmentConfiguration: RESULT "  + result );
		log.info("testGetQuestionnaireAssesmentConfiguration: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireAssesmentModel(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireAssesmentModel: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaire=2;
		
		Ktek_questionnaire instance = db.getQuestionnaireModel(idquestionnaire);
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireAssesmentModel: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireAssesmentModel: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireAssesmentModel: RESULT "  + result );
		log.info("testGetQuestionnaireAssesmentModel: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireAssesmentSectionList(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireAssesmentSectionList: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaire=1;
		
		Ktek_questionnairesection[] instanceArray = db.getQuestionnaireAssessmentSectionList(idquestionnaire);
		
		if(instanceArray!=null)
		{
			log.info("testGetQuestionnaireAssesmentSectionList: Instance Array exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireAssesmentSectionList: instance Array is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireAssesmentSectionList: RESULT "  + result );
		log.info("testGetQuestionnaireAssesmentSectionList: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireItem(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireItem: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaireitem=2;
		Ktek_questionnaireitem instance = null;
		PersistentSession session = null;
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();				
			instance = db.getQuestionnaireItem(session,idquestionnaireitem);
			session.close();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireItem: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireItem: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireItem: RESULT "  + result );
		log.info("testGetQuestionnaireItem: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	//@org.junit.Test	
	public void testGetQuestionnaireItemAnwser4QuestionnaireItem(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireItemAnwser4QuestionnaireItem: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnaireitem=2;
		int idanswerset=0;
		
		Ktek_answer[] instance = db.getQuestionnaireItemAnwser4QuestionnaireItem(idquestionnaireitem,idanswerset);
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireItemAnwser4QuestionnaireItem: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireItemAnwser4QuestionnaireItem: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireItemAnwser4QuestionnaireItem: RESULT "  + result );
		log.info("testGetQuestionnaireItemAnwser4QuestionnaireItem: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireItemList4Section(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireItemList4Section: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnairesection=1;
		
		Ktek_questionnaireitem[] instanceArray = db.getQuestionnaireItemList4Section(idquestionnairesection);
		
		if(instanceArray!=null)
		{
			log.info("testGetQuestionnaireItemList4Section: Instance Array exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireItemList4Section: instance Array is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireItemList4Section: RESULT "  + result );
		log.info("testGetQuestionnaireItemList4Section: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireSection(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireSection: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		int idquestionnairesection = 1;
		Ktek_questionnairesection instance = null;
		PersistentSession session = null;
		try {
			
			session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();			
			session.beginTransaction();				
			
			instance = db.getQuestionnaireSection(session,idquestionnairesection);
			session.close();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(instance!=null)
		{
			log.info("testGetQuestionnaireSection: Instance exists " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireSection: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireSection: RESULT "  + result );
		log.info("testGetQuestionnaireSection: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	//@org.junit.Test	
	public void testSaveQuestionnaireAssesmentResultByStepsLogic(){
		log.info("*************************************************************" );		
		log.info("testSaveQuestionnaireAssesmentResultByStepsLogic: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		KtekQuestionnaireResultEntity resultData = null;
		resultData =TestData.getKtekQuestionnaireAssessmentResultEntityTest1();
		
		boolean boolOK=false;
		Ktek_result_questionnaire objResultQuestionnaire =  null;
		try {
			 objResultQuestionnaire = db.saveQuestionnaireResultByStepsLogic(resultData);
		} catch (KtekExceptionEntity e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("testSaveQuestionnaireAssesmentResultByStepsLogic: Exception " + e.getMessage() );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		if(objResultQuestionnaire  != null)		{
			log.info("testSaveQuestionnaireAssesmentResultByStepsLogic: OK " );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testSaveQuestionnaireAssesmentResultByStepsLogic: ERROR " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testSaveQuestionnaireAssesmentResultByStepsLogic: RESULT "  + result );
		log.info("testSaveQuestionnaireAssesmentResultByStepsLogic: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetQuestionnaireMonitoringSchedule(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireMonitoringSchedule: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		String codUser="User2";
		long datefrom=(long) 1413237600000.0;
		long dateto=(long) 1430431200000.0;
		short typemonitoringactivity=0;
		short status =1;
		Ktek_userquestionnaire_planning[] instanceArray = db.getQuestionnaireMonitoringSchedule(codUser, datefrom, dateto, typemonitoringactivity);
		
		if(instanceArray!=null)
		{
			log.info("testGetQuestionnaireMonitoringSchedule: instanceArray exists "+ instanceArray.length);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireMonitoringSchedule: instanceArray is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireMonitoringSchedule: RESULT "  + result );
		log.info("testGetQuestionnaireMonitoringSchedule: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	
	//@org.junit.Test	
	public void testGetQuestionnaireResults(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireResults: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		long datefrom=(long) 1417474800000.0;
		long dateto=(long) 1418165999000.0;
		short typemonitoringactivity= KtekApplicationitemType.DRUGSIDEEFFECTS;
		int orderby =1 ;
		String codUser= "User3";
		boolean all = false;
		String codtelecareprogram ="TBP1";
		
		Ktek_result_questionnaire[] instanceArray=null;
		try {
			instanceArray = db.getQuestionnaireResults(codUser, all, datefrom, dateto, orderby, codtelecareprogram, typemonitoringactivity);
		} catch (KtekExceptionEntity e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(instanceArray!=null)
		{
			log.info("testGetQuestionnaireResults: instanceArray exists "+ instanceArray.length);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireResults: instanceArray is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireResults: RESULT "  + result );
		log.info("testGetQuestionnaireResults: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	
	
	 
	
	//@org.junit.Test	
	public void testGetQuestionnaireResultsByIds(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireResultsByIds: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		long datefrom=(long) 1411206815000.0;
		long dateto=(long) 1412157215000.0;
		short typemonitoringactivity= KtekApplicationitemType.STATUSPARAMETERS;
		int orderby =1 ;
		boolean all = false;
		Integer[] ids= new Integer[1];
		
		String codUser="User1";
		
		ids[0]=(int) 0.0;
		
		Ktek_result_questionnaire[] instanceArray = db.getQuestionnaireResultsByIds( all,  datefrom,  dateto,  orderby,  typemonitoringactivity, ids, codUser);
		
		if(instanceArray!=null)
		{
			log.info("testGetQuestionnaireResultsByIds: instanceArray exists "+ instanceArray.length);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaireResultsByIds: instanceArray is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaireResultsByIds: RESULT "  + result );
		log.info("testGetQuestionnaireResultsByIds: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	//@org.junit.Test	
	public void testGetQuestionnaires4TypeMonitoringActivityPlanned(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		short status = KtekQuestionnaireStatus.QUESTIONNAIRE_STATUS_PENDING;
		
		String codtelecareprogram ="TBP1";
		String coduser ="User1";
		
		Ktek_questionnaire[] array = db.getQuestionnaires4TypeMonitoringActivityPlanned(KtekApplicationitemType.HEALTHSTATUS, coduser, codtelecareprogram, status);
		
		if(array!=null)
		{
			log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: array exists " + array.length );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetQuestionnaires4TypeMonitoringActivityPlanned: array is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: RESULT "  + result );
		log.info("testGetQuestionnaires4TypeMonitoringActivityPlanned: END " );
		log.info("*************************************************************" );
		log.info("");		
	}
	
	//@org.junit.Test	
	public void testGetUserPlanningQuestionnaire(){
		log.info("*************************************************************" );		
		log.info("testGetUserPlanningQuestionnaire: START " );

		QuestionnaireManagerDB db= new QuestionnaireManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		String codUser="User2";
		int ktek_pk_idquestionnaire=31;
		String  codTelecareprogram ="TBP1";
		
		Ktek_userquestionnaire_planning instance = db.getUserPlanningQuestionnaire(codUser, codTelecareprogram, ktek_pk_idquestionnaire);
		
		if(instance!=null)
		{
			log.info("testGetUserPlanningQuestionnaire: instance exists " + instance.getKtek_pk_iduserquestionnaireplanning() );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserPlanningQuestionnaire: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserPlanningQuestionnaire: RESULT "  + result );
		log.info("testGetUserPlanningQuestionnaire: END " );
		log.info("*************************************************************" );
		log.info("");		
	}

	@org.junit.Test	
		public void testGetQuestionnaireConfiguration(){
			log.info("*************************************************************" );		
			log.info("testGetQuestionnaireConfiguration: START " );

			QuestionnaireManagerDB db= new QuestionnaireManagerDB();
			String  result= TestDefines.RESULT_OK;
			
			Ktek_questionnaireconfiguration[] array = null;
			try {
				array = db.getQuestionnaireConfiguration();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(array!=null)
			{
				log.info("testGetQuestionnaireConfiguration: Instance exists " +array.length);
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetQuestionnaireConfiguration: instance is NULL " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
			
			log.info("testGetQuestionnaireConfiguration: RESULT "  + result );
			log.info("testGetQuestionnaireConfiguration: END " );
			log.info("*************************************************************" );
			log.info("");		
		}

	
		//@org.junit.Test	
		public void testGetQuestionnaireitemList4QuestionnairePlannedFinished(){
			log.info("*************************************************************" );		
			log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: START " );

			QuestionnaireManagerDB db= new QuestionnaireManagerDB();
			String  result= TestDefines.RESULT_OK;
			String coduser="User3";
			short[] typeMonitoringActivityArray=new short[2];
			String codtelecareprogram="TBP1";
			
			typeMonitoringActivityArray[0]=1;
			typeMonitoringActivityArray[1]=3;
			
			Ktek_questionnaireitem[] array = null;
			try {
				array = db.getQuestionnaireitemList4QuestionnairePlannedFinished( coduser, typeMonitoringActivityArray,  codtelecareprogram);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(array!=null)
			{
				log.info("testGetQuestionnaireitemList4QuestionnairePlannedFinished: Instance exists " +array.length);
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetQuestionnaireConfiguration: instance is NULL " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
			
			log.info("testGetQuestionnaireConfiguration: RESULT "  + result );
			log.info("testGetQuestionnaireConfiguration: END " );
			log.info("*************************************************************" );
			log.info("");		
		}
}
