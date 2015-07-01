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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EventServiceClient {

	private static Log log =LogFactory.getLog(EventServiceClient.class);
	
	public String endpointServerDefault="0.0.0.0";
	public String headerTokenDefault="tokenobtainedfromeventserviceadmin";			
	public String notificationEndpointDefault="http://0.0.0.0:8080/questionnaire.mng.rest/rest/ktek/questionnaire/notification/eventse";
	public String typeContextValue="Questionnaire";
	
	public String endpointServer = null;
	public String headerToken = null;
	public String notificationEndpoint = null;
	public int timeout=5000;	
	
	public String protocol="http";
	public String pathEventService="/NGSI10/";
	public String endpointEventService=endpointServer+"/NGSI10/";
	
	public String pathOauth="/oauth2/";
	public String endpointOauth=endpointServer+pathOauth;
	
	
	public String methodUpdateContext="updateContext";
	public String methodQueryContext="queryContext";
	public String methodSubscribeContext="subscribeContext";
	public String methodAccessToken="access_token";
		
	public String methodPOST="POST";
	public String methodGET="GET";
	
	public String headerContentType="Content-Type";	
	public String headerContentTypeJSON="application/json";
	public String headerContentTypePlainText="plain/text"; 
	public String headerContentTypeFormUrlencoded="application/x-www-form-urlencoded";
	
	public String headerAuthorization="Authorization";
	public String headerAuthorizationOAuth="OAuth";
	
	public EventServiceClient(String  endpointServer, int timeout, String headerToken  ){
		
		this.endpointServer = endpointServer;
		this.timeout = timeout;
		this.headerToken =headerToken;
		
		
		endpointEventService=endpointServer+pathEventService;			
		endpointOauth=endpointServer+endpointOauth;
	}
	
	private HttpURLConnection getEventServiceSEConnection(String method, String service, String contentType){
		HttpURLConnection conn = null;
		URL url = null;
		
		String urlStr=protocol + "://"+ service+method;
		log.debug( urlStr );
					
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(methodPOST);
			conn.setRequestProperty(headerContentType, contentType);
			conn.setRequestProperty(headerAuthorization, headerAuthorizationOAuth + " " + headerToken);
			conn.setConnectTimeout(timeout);
			
			log.debug(headerContentType + " " + contentType);
			
			log.debug(headerAuthorizationOAuth + " " + headerToken);
						
		} catch (MalformedURLException e) {
			log.error("MalformedURLException " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException " + e.getMessage());
			e.printStackTrace();	 
		}
			
		return conn;
	}
	
	public boolean updateContext(String codUser, String nameContext, String typeContext, String valueContext, boolean valueIsjson){
		HttpURLConnection conn = null;
		StringBuffer strBOutput=new StringBuffer (); 
		boolean boolOK=true;
		String input =  null;
		StringBuffer stbInput= new StringBuffer();
		
		try {
			log.debug("updateContext Start ");
			
			conn = getEventServiceSEConnection(methodUpdateContext,endpointEventService, headerContentTypeJSON);
			
			stbInput.append("{\"contextElements\": [{\"type\": \""  + typeContextValue +"\",\"isPattern\": \"false\",\"id\": \""+codUser+"\",\"attributes\":");			
			if(valueIsjson)
				stbInput.append(" [{\"name\": \""+nameContext+"\",\"type\": \"" + typeContext+"\",\"value\": "+valueContext+"}]}]");
			else
				stbInput.append(" [{\"name\": \""+nameContext+"\",\"type\": \"" + typeContext+"\",\"value\": \""+valueContext+"\"}]}]");
			stbInput.append(",\"updateAction\": \"APPEND\"}");
			
			input=stbInput.toString();
			log.debug( input );
								
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
			if (conn.getResponseCode() ==200){
				log.debug( "updateContext Response code " +  conn.getResponseCode() );
			}
			else{
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("updateContext Failed : HTTP error code : " + conn.getResponseCode());
				}
			}
			
			log.debug( "updateContext OutputStream wrote" );
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	 
			log.debug( "updateContext Waiting server response " );
			
			String output;
			log.debug("updateContext Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				strBOutput.append(output);
				log.debug(output);
			}
	 
			conn.disconnect();
	 
			boolOK=true;
			
		  } catch (MalformedURLException e) {
			  log.error("updateContext MalformedURLException " + e.getMessage());
			  e.printStackTrace();
			  boolOK=false;
		  } catch (IOException e) {
			  log.error("updateContext IOException " + e.getMessage());
			  e.printStackTrace();
			  boolOK=false;
		  }
		
		return boolOK;
	}

	public String queryContext(String codUser) {
		String strJSON= null;
		HttpURLConnection conn = null;
		StringBuffer strBOutput=new StringBuffer (); 
		boolean boolOK=true;
		String input =  null;
		StringBuffer stbInput= new StringBuffer();
		
		try {
			log.debug("queryContext Start ");
			
			conn = getEventServiceSEConnection(methodQueryContext,endpointEventService, headerContentTypeJSON);
			
			stbInput.append("{\"entities\": [ {\"type\": \""+ typeContextValue+ "\", \"isPattern\": \"false\", \"id\": \""+codUser+"\"}]}");			
			
			input=stbInput.toString();
			log.debug( input );
								
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
			if (conn.getResponseCode() ==200){
				log.debug( "queryContext Response code " +  conn.getResponseCode() );
			}
			else{
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
				}
			}
			
			log.debug( "queryContext OutputStream wrote" );
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	 
			log.debug( "queryContext Waiting server response " );
			
			String output;
			log.debug("queryContext Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				strBOutput.append(output);
				log.debug(output);
			}
	 
			conn.disconnect();
	 		
			strJSON = strBOutput.toString();
	
			boolOK=true;
			
		  } catch (MalformedURLException e) {
			  log.error("queryContext MalformedURLException " + e.getMessage());
			  e.printStackTrace();
		  } catch (IOException e) {
			  log.error("queryContext IOException " + e.getMessage());
			  e.printStackTrace();	 
		  }
		
		return strJSON;
	}

	public boolean subscribeContext(String codUser, String nameContext) {
		HttpURLConnection conn = null;
		StringBuffer strBOutput=new StringBuffer (); 
		boolean boolOK=true;
		String input =  null;
		StringBuffer stbInput= new StringBuffer();
		
		try {
			log.debug("subscribeContext Start ");
			
			conn = getEventServiceSEConnection(methodSubscribeContext,endpointEventService, headerContentTypeJSON);
						
			stbInput.append("{\"entities\": [{\"type\": \"" +typeContextValue+"\",\"isPattern\": \"false\",\"id\": \""+codUser+"\" } ],");			
			stbInput.append("\"attributes\": [\""+nameContext+"\"] ,");			
			stbInput.append("\"reference\": \""+notificationEndpoint+"\",");
			stbInput.append("\"duration\": \"P1M\",");
			stbInput.append("\"notifyConditions\": [ {\"type\": \"ONCHANGE\",\"condValues\": [\""+nameContext+"\"]}],\"throttling\": \"PT5S\"}");
						
			input=stbInput.toString();
			log.debug( input );
								
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
			if (conn.getResponseCode() ==200){
				log.debug( "subscribeContext Response code " +  conn.getResponseCode() );
			}
			else{
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("subscribeContext Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
			}
			
			log.debug( "subscribeContext OutputStream wrote" );
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	 
			log.debug( "subscribeContext Waiting server response " );
			
			String output;
			log.debug("subscribeContext Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				strBOutput.append(output);
				log.debug(output);
			}
	 
			conn.disconnect();
	 
			boolOK=true;
			
		  } catch (MalformedURLException e) {
			  log.error("subscribeContext MalformedURLException " + e.getMessage());
			  e.printStackTrace();
		  } catch (IOException e) {
			  log.error("subscribeContext IOException " + e.getMessage());
			  e.printStackTrace();	 
		  }
		
		return boolOK;
	}

	public boolean getAccessToken() {
		HttpURLConnection conn = null;
		StringBuffer strBOutput=new StringBuffer (); 
		boolean boolOK=true;
		String input =  null;
		StringBuffer stbInput= new StringBuffer();
		
		try {
			log.debug("getAccessToken Start ");
			
			conn = getEventServiceSEConnection(methodAccessToken,endpointOauth,headerContentTypeFormUrlencoded );
						
			stbInput.append("client_id=522a3819dc268f33c983&client_secret=169d587f10e75316501483280d0c4843c3333144&grant_type=password&username=ktekQuser&password=F20st67R&scope=write");
						
			input=stbInput.toString();
			log.debug( input );
								
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
			if (conn.getResponseCode() ==200){
				log.debug( "getAccessToken Response code " +  conn.getResponseCode() );
			}
			else{
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("getAccessToken Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
			}
			
			log.debug( "getAccessToken OutputStream wrote" );
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	 
			log.debug( "getAccessToken Waiting server response " );
			
			String output;
			log.debug("getAccessToken Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				strBOutput.append(output);
				log.debug(output);
			}
	 
			conn.disconnect();
	 
			boolOK=true;
			
		  } catch (MalformedURLException e) {
			  log.error("getAccessToken MalformedURLException " + e.getMessage());
			  e.printStackTrace();
		  } catch (IOException e) {
			  log.error("getAccessToken IOException " + e.getMessage());
			  e.printStackTrace();	 
		  }
		
		return boolOK;
	}
	
}
