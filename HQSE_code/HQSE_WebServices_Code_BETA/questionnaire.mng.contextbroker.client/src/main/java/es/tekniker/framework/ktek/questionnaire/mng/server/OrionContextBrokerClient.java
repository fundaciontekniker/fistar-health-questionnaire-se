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
 
 public class OrionContextBrokerClient
 {
	private static Log log = LogFactory.getLog(OrionContextBrokerClient.class);
	public String endpointServerDefault = "0.0.0.0";
	public int port = 1026;
    public String typeContextValue = "Questionnaire";
    public String endpointServer = null;
    public String headerToken = null;
    public String notificationEndpoint = null;
    public int timeout = 5000;
    public String protocol = "http";
    public String pathOrionContextBroker = "/v1/";
    public String endpointOrionContextBroker = this.endpointServer + this.pathOrionContextBroker;
    public String methodUpdateContext = "updateContext";
    public String methodQueryContext = "queryContext";
    public String methodSubscribeContext = "subscribeContext";
    public String methodPOST = "POST";
    public String methodGET = "GET";
    public String headerContentType = "Content-Type";
    public String headerContentTypeJSON = "application/json";
    public String headerContentTypePlainText = "plain/text";
    public String headerContentTypeFormUrlencoded = "application/x-www-form-urlencoded";
   
    public OrionContextBrokerClient(String endpointServer, int timeout, int port)
    {
    	this.endpointServerDefault = endpointServer;
    	this.port = port;
    	this.timeout = timeout;
     
    	this.endpointOrionContextBroker = (endpointServer + ":" + port + this.pathOrionContextBroker);
    }
   
    private HttpURLConnection getOrionContextBrokerGEConnection(String method, String service, String contentType)
    {
    	HttpURLConnection conn = null;
    	URL url = null;
     
    	String urlStr = this.protocol + "://" + service + method;
    	log.debug(urlStr);
    	try
    	{
	        url = new URL(urlStr);
	        conn = (HttpURLConnection)url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod(this.methodPOST);
	        conn.setRequestProperty(this.headerContentType, contentType);
	        conn.setConnectTimeout(this.timeout);
	       
	        log.debug(this.headerContentType + " " + contentType);
    	}
    	catch (MalformedURLException e)
    	{
    		log.error("MalformedURLException " + e.getMessage());
    		e.printStackTrace();
    	}
    	catch (IOException e)
    	{
    		log.error("IOException " + e.getMessage());
    		e.printStackTrace();
    	}
    	return conn;
   }
   
   public boolean updateContext(String codUser, String nameContext, String typeContext, String valueContext, boolean valueIsjson)
   {
       HttpURLConnection conn = null;
       StringBuffer strBOutput = new StringBuffer();
       boolean boolOK = true;
       String input = null;
       StringBuffer stbInput = new StringBuffer();
       try
       {
    	   log.debug("updateContext Start ");
       
    	   conn = getOrionContextBrokerGEConnection(this.methodUpdateContext, this.endpointOrionContextBroker, this.headerContentTypeJSON);
       
    	   stbInput.append("{\"contextElements\": [{\"type\": \"" + this.typeContextValue + "\",\"isPattern\": \"false\",\"id\": \"" + codUser + "\",\"attributes\":");
    	   if (valueIsjson) {
    		   stbInput.append(" [{\"name\": \"" + nameContext + "\",\"type\": \"" + typeContext + "\",\"value\": " + valueContext + "}]}]");
    	   } else {
    		   stbInput.append(" [{\"name\": \"" + nameContext + "\",\"type\": \"" + typeContext + "\",\"value\": \"" + valueContext + "\"}]}]");
    	   }
    	   stbInput.append(",\"updateAction\": \"APPEND\"}");
       
    	   input = stbInput.toString();
    	   log.debug(input);
       
    	   OutputStream os = conn.getOutputStream();
    	   os.write(input.getBytes());
    	   os.flush();
    	   if (conn.getResponseCode() == 200) {
    		   log.debug("updateContext Response code " + conn.getResponseCode());
    	   } else if (conn.getResponseCode() != 201) {
    		   throw new RuntimeException("updateContext Failed : HTTP error code : " + conn.getResponseCode());
    	   }
    	   log.debug("updateContext OutputStream wrote");
       
    	   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       
    	   log.debug("updateContext Waiting server response ");
       
 
    	   log.debug("updateContext Output from Server .... \n");
    	   String output;
    	   while ((output = br.readLine()) != null)
    	   {
    		   strBOutput.append(output);
    		   log.debug(output);
    	   }
    	   conn.disconnect();
       
    	   boolOK = true;
       }
       catch (MalformedURLException e)
       {
    	   log.error("updateContext MalformedURLException " + e.getMessage());
    	   e.printStackTrace();
    	   boolOK = false;
       }
       catch (IOException e)
       {
    	   log.error("updateContext IOException " + e.getMessage());
    	   e.printStackTrace();
    	   boolOK = false;
       }
       return boolOK;
   }
   
   public String queryContext(String codUser)
   {
      String strJSON = null;
      HttpURLConnection conn = null;
      StringBuffer strBOutput = new StringBuffer();
      boolean boolOK = true;
      String input = null;
      StringBuffer stbInput = new StringBuffer();
      try
      {
    	  log.debug("queryContext Start ");
       
    	  conn = getOrionContextBrokerGEConnection(this.methodQueryContext, this.endpointOrionContextBroker, this.headerContentTypeJSON);
       
    	  stbInput.append("{\"entities\": [ {\"type\": \"" + this.typeContextValue + "\", \"isPattern\": \"false\", \"id\": \"" + codUser + "\"}]}");
       
    	  input = stbInput.toString();
    	  log.debug(input);
       
    	  OutputStream os = conn.getOutputStream();
    	  os.write(input.getBytes());
    	  os.flush();
    	  if (conn.getResponseCode() == 200) {
    		  log.debug("queryContext Response code " + conn.getResponseCode());
    	  } else if (conn.getResponseCode() != 201) {
    		  throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
    	  }
    	  log.debug("queryContext OutputStream wrote");
       
    	  BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       
    	  log.debug("queryContext Waiting server response ");
       
 
    	  log.debug("queryContext Output from Server .... \n");
    	  String output;
    	  while ((output = br.readLine()) != null)
    	  {
			strBOutput.append(output);
            log.debug(output);
    	  }
    	  conn.disconnect();
       
    	  strJSON = strBOutput.toString();
       
    	  boolOK = true;
      }
      catch (MalformedURLException e)
      {
    	  log.error("queryContext MalformedURLException " + e.getMessage());
    	  e.printStackTrace();
      }
      catch (IOException e)
      {
    	  log.error("queryContext IOException " + e.getMessage());
    	  e.printStackTrace();
      }
      return strJSON;
   }
   
   public boolean subscribeContext(String codUser, String nameContext)
   {
       HttpURLConnection conn = null;
       StringBuffer strBOutput = new StringBuffer();
       boolean boolOK = true;
       String input = null;
       StringBuffer stbInput = new StringBuffer();
       try
       {
    	   log.debug("subscribeContext Start ");
       
    	   conn = getOrionContextBrokerGEConnection(this.methodSubscribeContext, this.endpointOrionContextBroker, this.headerContentTypeJSON);
       
    	   stbInput.append("{\"entities\": [{\"type\": \"" + this.typeContextValue + "\",\"isPattern\": \"false\",\"id\": \"" + codUser + "\" } ],");
    	   stbInput.append("\"attributes\": [\"" + nameContext + "\"] ,");
    	   stbInput.append("\"reference\": \"" + this.notificationEndpoint + "\",");
    	   stbInput.append("\"duration\": \"P1M\",");
    	   stbInput.append("\"notifyConditions\": [ {\"type\": \"ONCHANGE\",\"condValues\": [\"" + nameContext + "\"]}],\"throttling\": \"PT5S\"}");
       
    	   input = stbInput.toString();
    	   log.debug(input);
       
    	   OutputStream os = conn.getOutputStream();
    	   os.write(input.getBytes());
    	   os.flush();
    	   if (conn.getResponseCode() == 200) {
    		   log.debug("subscribeContext Response code " + conn.getResponseCode());
    	   } else if (conn.getResponseCode() != 201) {
    		   throw new RuntimeException("subscribeContext Failed : HTTP error code : " + 
    				   conn.getResponseCode());
    	   }
    	   log.debug("subscribeContext OutputStream wrote");
       
    	   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       
    	   log.debug("subscribeContext Waiting server response ");       
 
    	   log.debug("subscribeContext Output from Server .... \n");
    	   String output;
    	   while ((output = br.readLine()) != null)
    	   {
    		   strBOutput.append(output);
    		   log.debug(output);
    	   }
    	   conn.disconnect();
       
    	   boolOK = true;
       }
       catch (MalformedURLException e)
       {
    	   log.error("subscribeContext MalformedURLException " + e.getMessage());
    	   e.printStackTrace();	
       }
       catch (IOException e)
       {
    	   log.error("subscribeContext IOException " + e.getMessage());
    	   e.printStackTrace();
       }
       return boolOK;
   	}
 }


