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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.Ktek_questionnaireconfiguration;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireManagerDB;

public class EventServiceSEManager {

	private static Log log = LogFactory.getLog(es.tekniker.framework.ktek.questionnaire.mng.server.EventServiceSEManager.class);
	
	Ktek_questionnaireconfiguration configuration = null;	
	public String endpointServerEventServiceSE=null;
	public int timeout = 0;
	public String oauth2HeaderToken = null;
		
	public EventServiceSEManager(){
		
		QuestionnaireManagerDB db = new QuestionnaireManagerDB();
		Ktek_questionnaireconfiguration[] array = db.getQuestionnaireConfiguration();
		if(array != null && array.length>0){
			configuration = array[0];
			
			this.endpointServerEventServiceSE = configuration.getEndpointserver();			
			this.timeout = configuration.getTimeout();			
			this.oauth2HeaderToken = configuration.getEventserviceoauth2headertoken();		
			
			if(endpointServerEventServiceSE != null)
				log.debug("endpointServerEventServiceSE is NOT null " + endpointServerEventServiceSE);
			else
				log.debug("endpointServerEventServiceSE is null " );
			
			if(oauth2HeaderToken != null)
				log.debug("oauth2HeaderToken is NOT null " + oauth2HeaderToken);
			else
				log.debug("oauth2HeaderToken is null " );			
			
			log.debug("timeout value is " + timeout);
			
		}
	}
	
	public String queryContext(String codUser){
		log.info("queryContext");
		String json= null;
		EventServiceClient eventService= null;
				
		eventService= new EventServiceClient (this.endpointServerEventServiceSE,this.timeout, this.oauth2HeaderToken );
		json= eventService.queryContext(codUser);
		if(json !=null)
			log.info("queryContext json value is not null " + json);
		else
			log.info("queryContext json value is null " );
		
		return json;				
	}

	public boolean updateContext(String codUser, String nameContext,String typeContext, String valueContext, boolean b) {
		log.info("updateContext");		
		boolean boolOK=false;
		EventServiceClient eventService= null;
		
		eventService= new EventServiceClient (this.endpointServerEventServiceSE,this.timeout, this.oauth2HeaderToken );		
		boolOK = eventService.updateContext(codUser, nameContext, typeContext, valueContext, false);
		if(boolOK)
			log.info("updateContext OK" );
		else
			log.info("updateContext ERROR" );
		
		return boolOK;
	}

	public boolean subscribeContext(String codUser, String nameContext) {
		log.info("subscribeContext");	
		boolean boolOK=false;
		EventServiceClient eventService= null;
		
		eventService= new EventServiceClient (this.endpointServerEventServiceSE,this.timeout, this.oauth2HeaderToken );		
		boolOK = eventService.subscribeContext(codUser, nameContext);
		if(boolOK)
			log.info("subscribeContext OK" );
		else
			log.info("subscribeContext ERROR" );
		
		return boolOK;
	}

	public boolean getAccessToken() {
		log.info("getAccessToken");	
		boolean boolOK=false;
		EventServiceClient eventService= null;
		
		eventService= new EventServiceClient (this.endpointServerEventServiceSE,this.timeout, this.oauth2HeaderToken );		
		boolOK = eventService.getAccessToken();
		if(boolOK)
			log.info("getAccessToken OK" );
		else
			log.info("getAccessToken ERROR" );
		
		return boolOK;
	}
	
}
