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
package es.tekniker.framework.ktek.drugtreatment.mng.server.test;


import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import es.tekniker.framework.ktek.drugtreatment.mng.server.DrugTreatmentMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.server.test.TestDefines;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.TestData;

@Ignore("disable tests for first compilation")
public class TestDrugTreatmentMngServer {

	private static Log log =
		    LogFactory.getLog(TestDrugTreatmentMngServer.class);
	
	
	
	
	@org.junit.Test	
	public void testGetQuestionnaires4TypeMonitoringActivityFilter(){
		log.info("*************************************************************" );		
		log.info("testGetQuestionnaireList4Status: START " );

		DrugTreatmentMngServer objMngServer = new DrugTreatmentMngServer ();	
		
		String token= TestData.getLoginToken();
		
		int idlang=1;
		String codtelecareprogram="TBP1"; 
		boolean all=false;
		long datefrom=(long) 1421881200000.0; 
		long dateto=(long) 1422572399000.0;
		int orderby=1;
		
  	    List<KtekQuestionnaireItemFilterEntity> list = null;
		
		String  result= TestDefines.RESULT_OK;
		
		try {
			list = objMngServer.getQuestionnaires4TypeMonitoringActivityFilter(token, idlang,codtelecareprogram, all, datefrom, dateto, orderby);
			if(list!=null)
			{
				log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: list is not null "  );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetQuestionnaires4TypeMonitoringActivityFilter: list is NULL " );
				Assert.assertTrue(true);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			
			log.error("testGetQuestionnaires4TypeMonitoringActivityFilter: Exception " );
			Assert.assertTrue(true);
			result= TestDefines.RESULT_ERROR;
		}
				
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: RESULT "  + result );
		log.info("testGetQuestionnaires4TypeMonitoringActivityFilter: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
		
}
