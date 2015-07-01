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

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.commons.mng.api.ICommonsListMngWS;
import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekLanguageEntity;
import es.tekniker.framework.ktek.entity.KtekLanguageListEntity;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class CommonsListMngWSImpl  implements ICommonsListMngWS{
	
	private static Log log =LogFactory.getLog(CommonsListMngWSImpl.class);

	
	@GET
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Commons Management Restful Services with Apache CXF. \n");
		
	
		return sInfo.toString();
	}


	@GET
	@Path("/languages/")
	public KtekLanguageListEntity getListLanguages() throws KtekExceptionEntity {
		
		KtekLanguageListEntity instance = new KtekLanguageListEntity();
		KtekLanguageEntity[] arrayInstanceEntity= null;
		
		CommonsMngServer manager = new CommonsMngServer ();		
		arrayInstanceEntity= manager.getLanguages();

		instance.setLanguages(arrayInstanceEntity);
		if (arrayInstanceEntity!=null)
			log.info("getListLanguages : exists " );
		else 
			log.error("getListLanguages : does not exists");
		
		
		return instance;
	}
		
}
