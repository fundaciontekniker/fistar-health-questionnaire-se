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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.tekniker.framework.ktek.Ktek_answer;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;

public class UtilsQuestionnaire {

	public static boolean auditAccessLog(int idaccessuser, int idaccesseduser, String codTelecareProgram , short typeaction, int idaction, long logitemcreation){
		boolean boolOK = false;
		CommonsManagerDB commonsDB = null;
		
		commonsDB = new CommonsManagerDB();
		boolOK = commonsDB.insertAuditAccessLog(idaccessuser, idaccesseduser, codTelecareProgram, typeaction, idaction, logitemcreation);
		return boolOK;
	}
	
	public static boolean isTokenValid(String token) throws KtekExceptionEntity{
		boolean boolTokenValid=false;
		CommonsMngServer manager = null;		
		
		manager = new CommonsMngServer ();		
		boolTokenValid= manager.isTokenValid(token);
		
		return boolTokenValid;
	}
	
	public static Ktek_user getUserByToken(String token){
		Ktek_user instance = null;		
		CommonsManagerDB commonsDB = null;
		
		commonsDB = new CommonsManagerDB();
		instance = commonsDB.getUser4Token(token);
		
		return instance;
	}
	
	public static Ktek_user getUserByIdUser(int iduser) throws KtekExceptionEntity{
		Ktek_user user =  null;
		CommonsMngServer manager = null;		
		
		manager = new CommonsMngServer ();		
		user = manager.getUserByIdUser(iduser);
		
		return user;
	}
	
	public static KtekMonitoringQuestionnaireModelEntityList array2List(KtekQuestionnaireModelEntity[] array) {
		KtekMonitoringQuestionnaireModelEntityList entitylist =null;
		List<KtekMonitoringQuestionnaireModelEntity> list =null;
		KtekMonitoringQuestionnaireModelEntity entity =null;
		
		if(array!=null){
			entitylist = new KtekMonitoringQuestionnaireModelEntityList();
			list = new ArrayList<KtekMonitoringQuestionnaireModelEntity>();
			
			for(int i =0 ; i<array.length ; i++){
				entity = new KtekMonitoringQuestionnaireModelEntity();
				if(array[i].getDesquestionnaire() !=null)
					entity.setDesquestionnaire(array[i].getDesquestionnaire());
				
				entity.setIdquestionnaire(array[i].getIdquestionnaire());
				if(array[i].getNamequestionnaire()!=null)
					entity.setNamequestionnaire(array[i].getNamequestionnaire());
				
				entity.setTypemonitoringactivity(array[i].getTypemonitoringactivity());
				
				list.add(entity);
			}
			entitylist.setList(list);
		}
		
		return entitylist;
	}
	
	// GET TEXT FROM DB
	public static String getText(String textKey, int id, int idlang){
		String text= null;
		CommonsManagerDB db = new CommonsManagerDB();
		text=db.getText(textKey, id, idlang);
		return text;		
	}

	//ARRAY RANDOM ORDER
	public static void shuffleArray(Ktek_answer[] instanceAnswerArray) {
	    int n = instanceAnswerArray.length;
	    Random random = new Random();
	    random.nextInt();
	    for (int i = 0; i < n; i++) {
	      int change = i + random.nextInt(n - i);
	      swapArray(instanceAnswerArray, i, change);
	    }
	}

	private static void swapArray(Ktek_answer[] a, int i, int change) {
		Ktek_answer helper = a[i];
	    a[i] = a[change];
	    a[change] = helper;
	}
}
