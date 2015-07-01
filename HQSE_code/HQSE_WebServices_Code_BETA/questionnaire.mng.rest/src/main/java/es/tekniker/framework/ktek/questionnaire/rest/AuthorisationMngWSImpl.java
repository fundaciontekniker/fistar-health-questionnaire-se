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
package es.tekniker.framework.ktek.questionnaire.rest;

import javax.ws.rs.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekUserTokenEntity;
import es.tekniker.framework.ktek.questionnaire.mng.api.IAuthorisationMngWS;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class AuthorisationMngWSImpl  implements  IAuthorisationMngWS{
		
	private static Log log =LogFactory.getLog(AuthorisationMngWSImpl.class);

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Questionnaire Authorisation Management Restful Services with Apache CXF. \n");
		
		return sInfo.toString();
	}

	@GET 
	@Path("/usertoken/")
	@Produces(KtekDefines.MEDIATYPE_JSON)
	public KtekUserTokenEntity[] getUserTokenList()throws KtekExceptionEntity {
		log.info("getUserTokenList " );
		KtekUserTokenEntity[] instanceArray = null;
		CommonsMngServer server = null;
		
		server = new CommonsMngServer();
		instanceArray = server.getUserTokenList();				
		if (instanceArray != null)
			log.info("getUserTokenList : instance is not null " );
		else 
			log.info("getUserTokenList : instance is null " );
				
		return instanceArray;
	}
	
	@GET 
	@Path("/usertoken/{coduser}")
	@Produces(KtekDefines.MEDIATYPE_JSON)
	public KtekUserTokenEntity getUserToken(@PathParam("coduser") String codUser)throws KtekExceptionEntity {
		log.info("getUserToken " );
		KtekUserTokenEntity instance = null;
		CommonsMngServer server = null;
		
		server = new CommonsMngServer ();
		instance = server.getUserToken(codUser);				
		if (instance != null)
			log.info("getUserToken : instance is not null " );
		else 
			log.info("getUserToken : instance is null " );
				
		return instance;
	}
	
	@POST
	@Path("/usertoken/")
	@Consumes("application/json")
	public boolean createUserToken(KtekUserTokenEntity tokenEntity) throws KtekExceptionEntity {
		log.info("createUserToken " );
		boolean boolOK=false;		
		CommonsMngServer server = null;
		
		server = new CommonsMngServer ();				
		boolOK=server.createUserToken(tokenEntity);
		if (boolOK)
			log.info("createUserToken : OK " );
		else 
			log.info("createUserToken : ERROR " );
		
		return boolOK;
	}	
	
	@PUT
	@Path("/usertoken/")
	@Consumes("application/json")
	public boolean updateUserToken(KtekUserTokenEntity tokenEntity) throws KtekExceptionEntity {
		log.info("updateUserToken " );		
		boolean boolOK=false;				
		CommonsMngServer server = null;		
		
		server = new CommonsMngServer ();
		boolOK=server.saveToken(tokenEntity);
		if (boolOK)
			log.info("updateUserToken : OK " );
		else 
			log.info("updateUserToken : ERROR " );
		
		return boolOK;
	}	

	@DELETE
	@Path("/usertoken/{coduser}")
	public boolean deleteUserToken(@PathParam("coduser") String coduser)throws KtekExceptionEntity {
		log.info("deleteUserToken" );
		boolean boolOK=false;		
		CommonsMngServer server = null;		
		
		server = new CommonsMngServer ();		
		boolOK = server.deleteUser(coduser);						
		if (boolOK)
			log.info("deleteUser : OK " );
		else 
			log.info("deleteUser : ERROR " );
		
		return boolOK;		
	}
}
