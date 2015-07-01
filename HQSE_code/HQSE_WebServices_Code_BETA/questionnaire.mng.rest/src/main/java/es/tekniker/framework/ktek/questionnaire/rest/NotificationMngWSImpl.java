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

import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.api.INotificationMngWS;
import es.tekniker.framework.ktek.questionnaire.mng.server.ContextBrokerGEManager;
import es.tekniker.framework.ktek.questionnaire.mng.server.EventServiceSEManager;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class NotificationMngWSImpl implements INotificationMngWS {
	
	private static Log log =LogFactory.getLog(NotificationMngWSImpl.class);

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Questionnaire Notification Management Restful Services with Apache CXF. \n");
		
		return sInfo.toString();
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/eventservice/updatecontext/{coduser}/{namecontext}/{typecontext}/{valuecontext}")
	public boolean updateContextEventSE(@PathParam("coduser") String codUser, @PathParam("namecontext") String nameContext, @PathParam("typecontext")String typeContext, @PathParam("valuecontext")String valueContext)throws KtekExceptionEntity {
		log.info("updateContextEventSE"  );
		boolean boolOK=false;				
		EventServiceSEManager eventService= null;
		
		eventService= new EventServiceSEManager ();
		boolOK= eventService.updateContext(codUser, nameContext, typeContext, valueContext,false);
		if(boolOK)
			log.info("updateContextEventSE return TRUE"  );
		else
			log.info("updateContextEventSE return FALSE"  );
		
		return boolOK;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/eventservice/querycontext/{coduser}")
	public String queryContextEventSE(@PathParam("coduser") String codUser) throws KtekExceptionEntity {
		log.info("queryContextEventSE "  );		
		String json= null;
		EventServiceSEManager eventService= null;
		
		eventService= new EventServiceSEManager ();
		json= eventService.queryContext(codUser);		
		if(json != null)
			log.info("queryContextEventSE return json is not null " + json );
		else
			log.info("queryContextEventSE return json is null" );	
		
		return json;
	}
		
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/contextbroker/updatecontext/{coduser}/{namecontext}/{typecontext}/{valuecontext}")
	public boolean updateContextContextBrokerGE(@PathParam("coduser") String codUser, @PathParam("namecontext") String nameContext, @PathParam("typecontext")String typeContext, @PathParam("valuecontext")String valueContext)throws KtekExceptionEntity {
		log.debug("updateContextContextBrokerGE"  );
		boolean boolOK=false;
		ContextBrokerGEManager brokerService= null;
				
		brokerService= new ContextBrokerGEManager ();
		boolOK= brokerService.updateContext(codUser, nameContext, typeContext, valueContext,false);
		if(boolOK)
			log.info("updateContextContextBrokerGE return TRUE"  );
		else
			log.info("updateContextContextBrokerGE return FALSE"  );
		
		return boolOK;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/contextbroker/querycontext/{coduser}")
	public String queryContextContextBrokerGE(@PathParam("coduser") String codUser) throws KtekExceptionEntity {
		log.debug("queryContextContextBrokerGE ");
		String json= null;
		ContextBrokerGEManager brokerService= null;
		
		brokerService= new ContextBrokerGEManager ();
		json= brokerService.queryContext(codUser);
		if(json != null)
			log.info("queryContextContextBrokerGE return json is not null " + json );
		else
			log.info("queryContextContextBrokerGE return json is null" );	
		
		return json;
	}
	
}
