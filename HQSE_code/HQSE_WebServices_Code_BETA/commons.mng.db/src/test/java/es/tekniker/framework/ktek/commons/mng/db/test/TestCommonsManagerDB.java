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
package es.tekniker.framework.ktek.commons.mng.db.test;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import es.tekniker.framework.ktek.Ktek_language;
import es.tekniker.framework.ktek.Ktek_tpsettings;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.Ktek_user_ext;
import es.tekniker.framework.ktek.Ktek_usersessiondata;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;

@Ignore("disable tests for first compilation")
public class TestCommonsManagerDB {

	private static Log log = LogFactory.getLog(TestCommonsManagerDB.class);
	
	@org.junit.Test	
	public void testGetLanguages(){
		log.info("*************************************************************" );		
		log.info("testGetLanguages: START " );

		Ktek_language[] array = null;
		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		array = db.getLanguages();
		
		if(array!=null)
		{
			log.info("testGetLanguages: Languages " + array.length);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetLanguages: Array Languages is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetLanguages: RESULT "  + result );
		log.info("testGetLanguages: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	@org.junit.Test	
	public void testGetText(){
		log.info("*************************************************************" );		
		log.info("testGetText: START " );

		
		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;
		
		String key="";
		int id=1;
		int lang=1;
		String instance = db.getText(key,id,lang);
		
		if(instance!=null)
		{
			log.info("testGetText: Text value is " + instance);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetText: Text is NULL " + instance);
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetText: RESULT "  + result );
		log.info("testGetText: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	@org.junit.Test	
	public void testGetTpSettings(){
		log.info("*************************************************************" );		
		log.info("testGetTpSettings: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_tpsettings instance = null;
		String token ="";
		int idUser=2;
		token = getTokenForIdUser(idUser);
		
		instance = db.getTpSettings(token);
		
		if(instance!=null)
		{
			log.info("testGetTpSettings: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetTpSettings: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetTpSettings: RESULT "  + result );
		log.info("testGetTpSettings: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
	
	@org.junit.Test	
	public void testGetUser(){
		log.info("*************************************************************" );		
		log.info("testGetUser: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_user instance = null;
		int idUser =1;
		
		instance = db.getUser(idUser);
		
		if(instance!=null)
		{
			log.info("testGetUser: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUser: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUser: RESULT "  + result );
		log.info("testGetUser: END " );
		log.info("*************************************************************" );
		log.info("");
			
	}
	
	@org.junit.Test	
	public void testGetUserId4Token(){
		log.info("*************************************************************" );		
		log.info("testGetUserId4Token: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		long idUserValue = 0;
		
		int idUser =2;
		String token=null;
		token= getTokenForIdUser(idUser);
		
		idUserValue = db.getUserId4Token(token);
		
		if(idUserValue>0)
		{
			log.info("testGetUserId4Token: idUserValue is NOT NULL " +idUserValue );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserId4Token: idUserValue is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserId4Token: RESULT "  + result );
		log.info("testGetUserId4Token: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
	
	@org.junit.Test	
	public void testGetUser4Token(){
		log.info("*************************************************************" );		
		log.info("testGetUser4Token: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		int idUser =2;
		String token=null;
		token= getTokenForIdUser(idUser);
		
		Ktek_user user = db.getUser4Token(token);
		
		if(user!=null)
		{
			log.info("testGetUser4Token: User is NOT NULL " + user.getKtek_uk_coduser());
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUser4Token: User is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUser4Token: RESULT "  + result );
		log.info("testGetUser4Token: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}

	@org.junit.Test	
	public void testGetUserByCode(){
		log.info("*************************************************************" );		
		log.info("testGetUserByCode: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_user instance = null;
		String code="User2";
		
		instance = db.getUserByCode(code);
		
		if(instance!=null)
		{
			log.info("testGetUserByCode: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserByCode: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserByCode: RESULT "  + result );
		log.info("testGetUserByCode: END " );
		log.info("*************************************************************" );
		log.info("");
			
	}
	
	@org.junit.Test	
	public void testGetUserExtById(){
		log.info("*************************************************************" );		
		log.info("testGetUserExtById: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_user_ext instance = null;
		int idUser=2;
		
		instance = db.getUserExtById(idUser);
		
		if(instance!=null)
		{
			log.info("testGetUserExtById: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserExtById: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserExtById: RESULT "  + result );
		log.info("testGetUserExtById: END " );
		log.info("*************************************************************" );
		log.info("");
			
	}
	
	@org.junit.Test	
	public void testGetUserSessionData(){
		log.info("*************************************************************" );		
		log.info("testGetUserSessionData: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_usersessiondata instance = null;				
		String token= null;		
		int idUser=2;
		
		token=getTokenForIdUser(idUser);
				
		instance = db.getUserSessionData(token);
		
		if(instance!=null)
		{
			log.info("testGetUserSessionData: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserSessionData: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserSessionData: RESULT "  + result );
		log.info("testGetUserSessionData: END " );
		log.info("*************************************************************" );
		log.info("");
			
	}
	
	@org.junit.Test	
	public void testGetUserSessionDataByIdUser(){
		log.info("*************************************************************" );		
		log.info("testGetUserSessionDataByIdUser: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_usersessiondata instance = null;		
		int idUser=2;
		
		instance = db.getUserSessionDataByIdUser(idUser);
		
		if(instance!=null)
		{
			log.info("testGetUserSessionDataByIdUser: instance is NOT NULL "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserSessionDataByIdUser: instance is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserSessionDataByIdUser: RESULT "  + result );
		log.info("testGetUserSessionData: END " );
		log.info("*************testGetUserSessionDataByIdUser***********************************************" );
		log.info("");
			
	}
	
	
	
	//@org.junit.Test	
	public void testSaveUserSessionData(){
		log.info("*************************************************************" );		
		log.info("testSaveUserSessionData: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		boolean boolOK=false;
		int idUser=1;
		String token="";
		long datacreation=0;
		
		token= getTokenForIdUser(idUser);
		
		boolOK = db.saveUserSessionData( idUser,  token,  datacreation );
		
		if(boolOK)
		{
			log.info("testSaveUserSessionData: OK "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testSaveUserSessionData: ERROR " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testSaveUserSessionData: RESULT "  + result );
		log.info("testSaveUserSessionData: END " );
		log.info("*************************************************************" );
		log.info("");		
	}	

	//@org.junit.Test	
	public void testSaveTpsettings(){
		log.info("*************************************************************" );		
		log.info("testSaveTpsettings: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		
		short typecomchannel=1;
		int idlanguage=2;
		int iduser=2;
		String email ="d@e.es";
		String mobile="1234234";
		boolean boolOK = db.setTPsettings(iduser, idlanguage, typecomchannel,email,mobile);
		
		if(boolOK)
		{
			log.info("testSaveTpsettings: OK "  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testSaveTpsettings: ERROR " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testSaveTpsettings: RESULT "  + result );
		log.info("testSaveTpsettings: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
			

	@org.junit.Test	
	public void testGetUserTokenList(){
		log.info("*************************************************************" );		
		log.info("testGetUserTokenList: START " );

		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;		
		
		Ktek_usersessiondata[] array = null;		
		
		array = db.getUserTokenList();
		
		if(array!=null)
		{
			log.info("testGetUserTokenList: array is NOT NULL " +array.length  );
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetUserTokenList: array is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetUserTokenList: RESULT "  + result );
		log.info("testGetUserTokenList: END " );
		log.info("************************************************************" );
		log.info("");
			
	}
	
	@org.junit.Test	
	public void testGetToken4IdUser(){
		log.info("*************************************************************" );		
		log.info("testGetToken4IdUser: START " );
		
		CommonsManagerDB db= new CommonsManagerDB();
		String  result= TestDefines.RESULT_OK;
				
		int idUser=1;
		String token = db.getToken4IdUser(idUser);
		
		if(token!=null)
		{
			log.info("testGetToken4IdUser: token value is " + token);
			Assert.assertTrue(true);
		}
		else
		{
			log.error("testGetToken4IdUser: token is NULL " );
			Assert.assertTrue(false);
			result= TestDefines.RESULT_ERROR;
		}
		
		log.info("testGetToken4IdUser: RESULT "  + result );
		log.info("testGetToken4IdUser: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
	
	
	public static String getTokenForIdUser(int idUser){
		String token= "";
		Ktek_usersessiondata instance =  null;
		
		CommonsManagerDB db= new CommonsManagerDB();

		instance = db.getUserSessionDataByIdUser(idUser);
		
		if(instance !=null)
			token= instance.getSessiontoken();
				
		return token;
	}
	
}
