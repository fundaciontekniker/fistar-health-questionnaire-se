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
package es.tekniker.framework.ktek.monitoring.rest;

import java.util.List;

import javax.ws.rs.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekParameterEntity;
import es.tekniker.framework.ktek.monitoring.mng.api.IMonitoringMngWS;
import es.tekniker.framework.ktek.monitoring.mng.server.MonitoringMngServer;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class MonitoringMngWSImpl implements IMonitoringMngWS {
		
	private static Log log =LogFactory.getLog(MonitoringMngWSImpl.class);

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Monitoring Management Restful Services with Apache CXF. \n");
		
		return sInfo.toString();
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/statuslist/{codtelecareprogram}")
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireStatusList(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @PathParam ("codtelecareprogram") String codtelecareprogram)throws KtekExceptionEntity {
		log.info("getQuestionnaireStatusList " );
		KtekMonitoringQuestionnaireModelEntityList list =null;		
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer();		
		list =server.getQuestionnaireList4TypeMonitoringActivity(token, codtelecareprogram, idlang, KtekApplicationitemType.STATUSPARAMETERS);		
		if (list!=null)
			log.info("getQuestionnaireStatusList instance is not null " );
		else 
			log.info("getQuestionnaireStatusList instance is null");
		
		return list;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/healthlist/{codtelecareprogram}")
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireHealthList(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @PathParam("codtelecareprogram") String codtelecareprogram )throws KtekExceptionEntity {
		log.info("getQuestionnaireHealthList " );
		KtekMonitoringQuestionnaireModelEntityList list =null;		
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer();		
		list =server.getQuestionnaireList4TypeMonitoringActivity(token, codtelecareprogram, idlang,  KtekApplicationitemType.HEALTHSTATUS);
		if (list!=null)
			log.info("getQuestionnaireHealthList instance is not null " );
		else 
			log.info("getQuestionnaireHealthList instance is null");
		
		return list;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/statusfilter/{all}/{datefrom}/{dateto}/{orderby}/{ids}")
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaireStatusFilter(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang,@HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("all") boolean all, @PathParam("datefrom") long datefrom, @PathParam("dateto")long dateto, @PathParam("orderby") int orderby,@PathParam("ids") String ids  )throws KtekExceptionEntity {
		log.info("getQuestionnaireStatusFilter " );
		List<KtekResultQuestionnaireItemsEntity> list =null;						
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer();		
		list = server.getQuestionnaires4TypeMonitoringActivityStatusFilter(token, idlang, codtelecareprogram,  all, datefrom, dateto, orderby, ids);
				
		if (list!=null)
			log.info("getQuestionnaireStatusFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaireStatusFilter list instance is null");
		
		return list;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/healthfilter/{all}/{datefrom}/{dateto}/{orderby}")
	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaireHealthFilter(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram,@PathParam("all") boolean all,@PathParam("datefrom") long datefrom, @PathParam("dateto")long dateto, @PathParam("orderby") int orderby)throws KtekExceptionEntity {
		log.info("getQuestionnaireHealthFilter " );
		List<KtekQuestionnaireItemFilterEntity> list =null;		
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer();		
		list = server.getQuestionnaires4TypeMonitoringActivityHealthFilter(token, idlang, codtelecareprogram, all, datefrom, dateto, orderby);
		
		if (list!=null)
			log.info("getQuestionnaireHealthFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaireHealthFilter list instance is null");
		
		return list;
	}	

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/statusdrugfollowupfilter/{all}/{datefrom}/{dateto}/{orderby}/{ids}")
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaireStatusDrugFollowUpFilter(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("all") boolean all,@PathParam("datefrom") long datefrom, @PathParam("dateto")long dateto, @PathParam("orderby") int orderby ,@PathParam("ids") String ids  )throws KtekExceptionEntity {
		log.info("getQuestionnaireStatusDrugFollowUpFilter " );
		List<KtekResultQuestionnaireItemsEntity> list =null;		
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer ();
		list  = server.getQuestionnaireStatusHealthFilter(token, idlang, codtelecareprogram, all,datefrom,dateto, orderby, ids);		
		if (list!=null)
			log.info("getQuestionnaireStatusDrugFollowUpFilter list instance is not null " +list.size());
		else 
			log.info("getQuestionnaireStatusDrugFollowUpFilter list instance is null");
		
		return list;
	}	
	
	@GET
	@Path("/monitoringparameters/statusdrugfollowup/{codtelecareprogram}")
	public List <KtekParameterEntity> getListQuestionnaireItemsStatusDrugFollowUp4User(@HeaderParam("token")String token, @PathParam("codtelecareprogram") String codtelecareprogram) throws KtekExceptionEntity{
		log.info("getListQuestionnaireItemsStatusDrugFollowUp4User");
		List <KtekParameterEntity>  list = null;				
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer ();			
		list= server.getListQuestionnaireItemsPlannedStatusDrugFollowUp4User(token, codtelecareprogram);		
		if (list!=null)
			log.info("getListQuestionnaireItemsStatusDrugFollowUp4User list is not null " + list.size() );
		else 
			log.info("getListQuestionnaireItemsStatusDrugFollowUp4User list is null ");
		
		return list;
	}
	
	@GET
	@Path("/monitoringparameters/{typemonitoring}/{codtelecareprogram}")
	public List <KtekParameterEntity> getListQuestionnaireItemsByType4User(@HeaderParam("token")String token, @PathParam("typemonitoring")short typemonitoring, @PathParam("codtelecareprogram") String codtelecareprogram) throws KtekExceptionEntity{
		log.info("getListQuestionnaireItemsByType4User typemonitoring " + typemonitoring);
		List <KtekParameterEntity>  list = null;				
		MonitoringMngServer server = null;
		
		server = new MonitoringMngServer ();			
		list= server.getListQuestionnaireItemsPlannedByType4User(token,typemonitoring, codtelecareprogram);		
		if (list!=null)
			log.info("getListQuestionnaireItemsByType4User list is not null " + list.size() );
		else 
			log.info("getListQuestionnaireItemsByType4User list is null ");
		
		return list;
	}
	
}
