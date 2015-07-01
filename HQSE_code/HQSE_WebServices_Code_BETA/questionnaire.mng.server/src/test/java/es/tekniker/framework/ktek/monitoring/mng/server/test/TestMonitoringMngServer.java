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
package es.tekniker.framework.ktek.monitoring.mng.server.test;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekParameterEntity;
import es.tekniker.framework.ktek.monitoring.mng.server.MonitoringMngServer;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.TestData;

@Ignore("disable tests for first compilation")
public class TestMonitoringMngServer {

	private static Log log =
		    LogFactory.getLog(TestMonitoringMngServer.class);
	
	@org.junit.Test	
	public void testGetQuestionnaireList4Status(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireList4Status: START " );

		MonitoringMngServer manager = new MonitoringMngServer();
		
		String token= TestData.getLoginToken();
		
		String  result= TestDefines.RESULT_OK;
		
		int idlang = 1;
		short status=KtekApplicationitemType.STATUSPARAMETERS; 
		KtekMonitoringQuestionnaireModelEntityList instance = null;
		String codtelecareprogram ="TBP1";
		
		try {
			instance = manager.getQuestionnaireList4TypeMonitoringActivity(token, codtelecareprogram, idlang, status);
			if(instance!=null)
			{
				log.info("testGetQuestionnaireList4Status: instance is not null "  );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetQuestionnaireList4Status: instance is NULL " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			
			log.error("testGetQuestionnaireList4Status: Exception " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
				
		log.info("testGetQuestionnaireList4Status: RESULT "  + result );
		log.info("testGetQuestionnaireList4Status: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	@org.junit.Test	
	public void testGetListQuestionnaireItemsPlannedByType4User(){
		log.info("*************************************************************" );		
		log.info("testGetListQuestionnaireItemsPlannedByType4User: START " );

		MonitoringMngServer manager = new MonitoringMngServer();
		
		String token= TestData.getLoginToken();
		
		String  result= TestDefines.RESULT_OK;
		List<KtekParameterEntity> list = null;
		String codtelecareprogram ="TBP1";
		short type=1;
		try {
			
			
			list = manager.getListQuestionnaireItemsPlannedByType4User(token, type, codtelecareprogram);
			if(list!=null)
			{
				log.info("testGetListQuestionnaireItemsPlannedByType4User: list is not null " + list.size() );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetListQuestionnaireItemsPlannedByType4User: list is NULL " );
				Assert.assertTrue(true);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			
			log.error("testGetListQuestionnaireItemsPlannedByType4User: Exception " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
				
		log.info("testGetListQuestionnaireItemsPlannedByType4User: RESULT "  + result );
		log.info("testGetListQuestionnaireItemsPlannedByType4User: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	@org.junit.Test	
	public void testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User(){
		log.info("*************************************************************" );		
		log.info("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: START " );

		MonitoringMngServer manager = new MonitoringMngServer();
		
		String token= TestData.getLoginToken();
		
		String  result= TestDefines.RESULT_OK;
		List<KtekParameterEntity> list = null;
		String codtelecareprogram ="DEP1";
		
		try {
			
			list = manager.getListQuestionnaireItemsPlannedStatusDrugFollowUp4User(token,  codtelecareprogram);
			if(list!=null)
			{
				log.info("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: list is not null " + list.size() );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: list is NULL " );
				Assert.assertTrue(true);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			
			log.error("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: Exception " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
				
		log.info("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: RESULT "  + result );
		log.info("testGetListQuestionnaireItemsPlannedStatusDrugFollowUp4User: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	
	
	@org.junit.Test	
	public void getQuestionnaireStatusHealthFilter(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireList4Status: START " );

		MonitoringMngServer manager = new MonitoringMngServer();
		
		String token= TestData.getLoginToken();
		String  result= TestDefines.RESULT_OK;
		int idlang = 1;
		List<KtekResultQuestionnaireItemsEntity> instance = null;
		
		try {
			String codtelecareprogram="DEP1";
			boolean all=false;
			long datefrom=(long) 1421884800000.0;
			long dateto=(long) 1422575999000.0;
			int orderby=1;
			String ids="1";
			instance = manager.getQuestionnaireStatusHealthFilter(token, idlang, codtelecareprogram, all, datefrom, dateto, orderby, ids);
			
			if(instance!=null)
			{
				log.info("testGetQuestionnaireList4Status: instance is not null "  );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetQuestionnaireList4Status: instance is NULL " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			
			log.error("testGetQuestionnaireList4Status: Exception " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
				
		log.info("testGetQuestionnaireList4Status: RESULT "  + result );
		log.info("testGetQuestionnaireList4Status: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	
}
