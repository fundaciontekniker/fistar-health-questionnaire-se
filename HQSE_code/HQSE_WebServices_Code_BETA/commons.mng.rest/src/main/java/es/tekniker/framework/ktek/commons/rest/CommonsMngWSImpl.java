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
package es.tekniker.framework.ktek.commons.rest;

import java.io.InputStream;


import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import es.tekniker.framework.ktek.commons.mng.api.ICommonsMngWS;
import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class CommonsMngWSImpl  implements ICommonsMngWS{
	
	private static Log log =LogFactory.getLog(CommonsMngWSImpl.class);

	
	@GET
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Commons Management Restful Services with Apache CXF. \n");
		
		sInfo.append( "************************************************************************************\n");		
		sInfo.append( "Name: languages\n");		
		sInfo.append( "URL: http://ipserver:8080/commons.mng.rest/rest/ktek/commons/languages\n");		
		sInfo.append( "Method : GET\n");
		sInfo.append( "Response Data \n\n");		
		sInfo.append("1 {\"KtekLanguageEntity\":[{\"idlanguage\":1,\"codlanguage\":\"es\",\"deslanguage\":\"espa�ol\",\"isdefault\":true},{\"idlanguage\":2,\"codlanguage\":\"en\",\"deslanguage\":\"english\",\"isdefault\":false},{\"idlanguage\":3,\"codlanguage\":\"eu\",\"deslanguage\":\"euskera\",\"isdefault\":false}]}\n\n");
		sInfo.append( "************************************************************************************\n");		
				
		sInfo.append( "************************************************************************************\n");		
		
		return sInfo.toString();
	}
	
	

	@GET
	@Path("/istokenvalid/")
	public boolean isTokenValid(@HeaderParam("token") String token) throws KtekExceptionEntity {
		boolean boolOK=false;
		
		CommonsMngServer objMngServer = new CommonsMngServer ();		
		boolOK=objMngServer.isTokenValid(token);				
	
		return boolOK;
	}
	
	@POST 
	@Path("/load")
	@Consumes("multipart/form-data")
	public boolean load( @Multipart(value = "stream")  InputStream stream ){
		boolean boolOK=false;		
		log.debug("load" );
				
		CommonsMngServer objMngServer = new CommonsMngServer();
		boolOK=objMngServer.loadfileDataStream(stream);
				
		return boolOK;
	}
	
	@POST 
	@Path("/loadfile")
	@Consumes("text/plain")
	public boolean loadfilefromlocalfile (String  strfilename){
		boolean boolOK=false;
		
		log.debug("loadfile  "  + strfilename);
		
		CommonsMngServer objMngServer = new CommonsMngServer();
		boolOK=objMngServer.loadfileData(strfilename);
		
		return boolOK;
	}

	
}
