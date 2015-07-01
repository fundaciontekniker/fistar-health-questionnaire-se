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
package es.tekniker.framework.ktek.commons.mng.server.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import es.tekniker.framework.ktek.Ktek_usersessiondata;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekLoginCoordinatesEntity;
import es.tekniker.framework.ktek.entity.KtekLoginEntity;
import es.tekniker.framework.ktek.entity.KtekUserEntity;

@Ignore("disable tests for first compilation")
public class TestCommonsMngServer {

	private static Log log =
		    LogFactory.getLog(TestCommonsMngServer.class);
			
	//@org.junit.Test	
	public void testLoadFile(){
		log.info("*************************************************************" );		
		log.info("testLoadFile: START " );
	
		CommonsMngServer mng= new CommonsMngServer();
		String  result= TestDefines.RESULT_OK;
		
		boolean boolValid = false;
		String  strfilename = null;
		try {
			
			strfilename = "dataLoadCommons_QSE.csv";
			
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
	
			
	//@org.junit.Test	
	public void testIsTokenValid(){
		log.info("*************************************************************" );		
		log.info("testIsTokenValid: START " );

		CommonsMngServer mng= new CommonsMngServer();
		String  result= TestDefines.RESULT_OK;
		
		String token="";
		int idUser =2;
		
		boolean boolValid;
		try {
			token=getToken4IdUser(idUser);
			
			boolValid = mng.isTokenValid(token);
			if(boolValid)
			{
				log.info("testIsTokenValid: Token Valid "  );
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testIsTokenValid: Token NO Valid " );
				Assert.assertTrue(false);
				result= TestDefines.RESULT_ERROR;
			}
		} catch (KtekExceptionEntity e) {
			e.printStackTrace();
			log.error("testIsTokenValid EXCEPTION: " + e.getMessage());
			Assert.assertTrue(false);
			result= TestDefines.RESULT_EXCEPTION;
		}
		
		log.info("testIsTokenValid: RESULT "  + result );
		log.info("testIsTokenValid: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
		
	
	
	
	private String getToken4IdUser(int idUser) {
		String token=null;
		
		CommonsManagerDB db = new CommonsManagerDB ();
		
		Ktek_usersessiondata instance = db.getUserSessionDataByIdUser(idUser);
		
		if(instance !=null)
			token = instance.getSessiontoken();
		
		return token;
	}

	@org.junit.Test	
	public void testLoginExists(){		
		
		log.info("*************************************************************" );		
		log.info("testLoginExists: START " );
		String  result= TestDefines.RESULT_OK;		
		
		KtekUserEntity instance = null;		
		
		CommonsMngServer manager = new CommonsMngServer ();
		
		KtekLoginEntity login = getLoginExists();
		
		try {
			instance = manager.login(login);
			
			if (instance!=null){				
				log.info("testLoginExists: instance is NOT NULL " + instance.getToken() );
	 			Assert.assertNotNull(instance);
			}
	 		else{
	 			log.error("testLoginExists: instance is NULL " );
	 			result= TestDefines.RESULT_ERROR;
	 			Assert.assertNull(instance);
	 		}
						
		} catch (KtekExceptionEntity e) {
			System.out.println("TestUsersMngServer.loginExists:  exception " + e.getMessage());
			e.printStackTrace();
			Assert.assertFalse(false);
		}
		
		log.info("testLoginExists: RESULT "  + result );
		log.info("testLoginExists: END " );
		log.info("*************************************************************" );
		log.info("");
	}

	@org.junit.Test	
	public void testRandomLetters(){
		
		String  result= TestDefines.RESULT_OK;		
		
		log.info("*************************************************************" );		
		log.info("testRandomLetters: START " );
		
		CommonsMngServer manager = new CommonsMngServer ();
		String[] array = manager.getRandomLetters();
		
		if(array !=null){
			for(int i =0 ; i<array.length;i++){
				log.info( array[i]);
			}
			
			Assert.assertTrue(true);
		}else{
			Assert.assertFalse(false);			
		}
		
		log.info("testRandomLetters: RESULT "  + result );
		log.info("testRandomLetters: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
	
	@org.junit.Test	
	public void testLoginNotExists(){

		log.info("*************************************************************" );		
		log.info("testLoginNotExists: START " );
		String  result= TestDefines.RESULT_OK;		
		
		KtekUserEntity instance = null;		
		
		CommonsMngServer manager = new CommonsMngServer ();
		
		KtekLoginEntity login = new KtekLoginEntity ();
		
		login.setReference("LoginDoesNotExist");
		login.setPassword("pwd");

		KtekLoginCoordinatesEntity[] array= new KtekLoginCoordinatesEntity[3];
		
		KtekLoginCoordinatesEntity coord1 = new KtekLoginCoordinatesEntity ();		
		coord1.setLetter("A");
		coord1.setValue("vvvv");
		
		KtekLoginCoordinatesEntity coord2 = new KtekLoginCoordinatesEntity ();		
		coord2.setLetter("B");
		coord2.setValue("FDFSDFSDFSD");
		
		KtekLoginCoordinatesEntity coord3 = new KtekLoginCoordinatesEntity ();		
		coord3.setLetter("C");
		coord3.setValue("HJJGHJG");
		
		array[0] = coord1;
		array[1] = coord2;
		array[2] = coord3;
		
		
		login.setCoordinates(array);

		
		try {
			instance = manager.login(login);
			
			if (instance!=null){				
				System.out.println("testLoginNotExists Login.token " + instance.getToken());
				result= TestDefines.RESULT_ERROR;
				Assert.assertFalse(true);
			}
	 		else{
	 			log.error("testLoginNotExists: instance is NULL " );
	 			result= TestDefines.RESULT_ERROR;
	 			Assert.assertNull(instance);
	 		}
						
		} catch (KtekExceptionEntity e) {
			System.out.println("TestUsersMngServer.loginExists:  exception " + e.getMessage());
			e.printStackTrace();			
			Assert.assertFalse(false);
		}
		
		log.info("testLoginNotExists: RESULT "  + result );
		log.info("testLoginNotExists: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
			
	public String strLoginUserExists="DNI-user1";

	public KtekLoginEntity getLoginExists(){
		
		KtekLoginEntity login = new KtekLoginEntity ();
		
		login.setReference(strLoginUserExists);
		login.setPassword("pwd");

		KtekLoginCoordinatesEntity[] array= new KtekLoginCoordinatesEntity[3];
		
		KtekLoginCoordinatesEntity coord1 = new KtekLoginCoordinatesEntity ();		
		coord1.setLetter("A");
		coord1.setValue("vvvv");
		
		KtekLoginCoordinatesEntity coord2 = new KtekLoginCoordinatesEntity ();		
		coord2.setLetter("B");
		coord2.setValue("FDFSDFSDFSD");
		
		KtekLoginCoordinatesEntity coord3 = new KtekLoginCoordinatesEntity ();		
		coord3.setLetter("C");
		coord3.setValue("HJJGHJG");
		
		array[0] = coord1;
		array[1] = coord2;
		array[2] = coord3;
		
		
		login.setCoordinates(array);
		
		
		
		return login;
	}
	

	//@org.junit.Test	
	public void testDeleteUserToken(){

		log.info("*************************************************************" );		
		log.info("testDeleteUserToken: START " );
		String  result= TestDefines.RESULT_OK;		
		
		KtekUserEntity instance = null;		
		
		CommonsMngServer manager = new CommonsMngServer ();
				
		String codUser ="newuser1";
		boolean boolOK =false;
		try {
			boolOK = manager.deleteUser(codUser);
			
			if (boolOK){				
				System.out.println("testDeleteUserToken OK " );
				result= TestDefines.RESULT_OK;
				Assert.assertFalse(true);
			}
	 		else{
	 			log.error("testDeleteUserToken: ERROR " );
	 			result= TestDefines.RESULT_ERROR;
	 			Assert.assertNull(instance);
	 		}
						
		} catch (KtekExceptionEntity e) {
			System.out.println("testDeleteUserToken :  exception " + e.getMessage());
			e.printStackTrace();			
			Assert.assertFalse(false);
		}
		
		log.info("testDeleteUserToken: RESULT "  + result );
		log.info("testDeleteUserToken: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}
			
	
}
