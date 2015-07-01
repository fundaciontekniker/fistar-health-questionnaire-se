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
package es.tekniker.framework.ktek.drugtreatment.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.defines.KtekApplicationitemType;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.drugtreatment.mng.api.IDrugTreatmentMngWS;
import es.tekniker.framework.ktek.drugtreatment.mng.server.DrugTreatmentMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.monitoring.mng.bo.KtekMonitoringQuestionnaireModelEntityList;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekResultQuestionnaireItemsEntity;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class DrugTreatmentMngWSImpl implements IDrugTreatmentMngWS {
		
	private static Log log =LogFactory.getLog(DrugTreatmentMngWSImpl.class);

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Drug Treatment Management Restful Services with Apache CXF. \n");
		
		return sInfo.toString();
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/drugfollowuplist/{codtelecareprogram}")
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireDrugFollowUpList(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @PathParam("codtelecareprogram") String codtelecareprogram)throws KtekExceptionEntity {
		log.info("getQuestionnaireDrugFollowUpList " );
		KtekMonitoringQuestionnaireModelEntityList list =null;
		
		DrugTreatmentMngServer server = null;
		server = new DrugTreatmentMngServer();
		
		list =server.getQuestionnaireList4TypeMonitoringActivity(token, codtelecareprogram, idlang, KtekApplicationitemType.DRUGFOLLOWUP);
		if (list!=null)
			log.info("getQuestionnaireDrugFollowUpList list instance is not null " );
		else 
			log.info("getQuestionnaireDrugFollowUpList list instance is null");
		
		return list;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/drugsideeffectslist/{codtelecareprogram}")
	public KtekMonitoringQuestionnaireModelEntityList getQuestionnaireDrugSideEffectsList(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @PathParam("codtelecareprogram") String codtelecareprogram)throws KtekExceptionEntity {
		log.info("getQuestionnaireDrugSideEffectsList " );
		KtekMonitoringQuestionnaireModelEntityList list =null;
				
		DrugTreatmentMngServer server = null;
		server = new DrugTreatmentMngServer();
		
		list =server.getQuestionnaireList4TypeMonitoringActivity(token, codtelecareprogram, idlang, KtekApplicationitemType.DRUGSIDEEFFECTS);
		if (list!=null)
			log.info("getQuestionnaireDrugSideEffectsList list instance is not null " );
		else 
			log.info("getQuestionnaireDrugSideEffectsList list instance is null");
		
		return list;
	}
		
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/drugsideeffectsfilter/{all}/{datefrom}/{dateto}/{orderby}")
	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaireDrugSideEffectsFilter(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("all") boolean all, @PathParam("datefrom") long datefrom, @PathParam("dateto")long dateto, @PathParam("orderby") int orderby)throws KtekExceptionEntity {
		log.info("getQuestionnaireDrugSideEffectsFilter " );
		List<KtekQuestionnaireItemFilterEntity> list =null;		
		DrugTreatmentMngServer server = null;
		
		server = new DrugTreatmentMngServer();		
		list = server.getQuestionnaires4TypeMonitoringActivityFilter(token, idlang,codtelecareprogram, all, datefrom, dateto, orderby);		
		if (list!=null)
			log.info("getQuestionnaireDrugSideEffectsFilter array instance is not null " +list.size());
		else {
			log.info("getQuestionnaireDrugSideEffectsFilter array instance is null");		
			list = new ArrayList<KtekQuestionnaireItemFilterEntity>();
		}
		
		return list;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/drugfollowupfilter/{all}/{datefrom}/{dateto}/{orderby}/{ids}")
	public List<KtekResultQuestionnaireItemsEntity> getQuestionnaireDrugFollowUpFilter(@HeaderParam("token")String token,@HeaderParam("idlang")int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("all") boolean all, @PathParam("datefrom") long datefrom, @PathParam("dateto")long dateto, @PathParam("orderby") int orderby ,@PathParam("ids") String ids )throws KtekExceptionEntity {
		log.info("getQuestionnaireDrugFollowUpFilter" );
		List<KtekResultQuestionnaireItemsEntity> list =null;		
		DrugTreatmentMngServer server = null;
		
		server = new DrugTreatmentMngServer();
		list = server.getQuestionnaires4TypeMonitoringActivityFilterWithIds(token, idlang, codtelecareprogram, all, datefrom, dateto, orderby, KtekApplicationitemType.DRUGFOLLOWUP, ids);
		if (list!=null)
			log.info("getQuestionnaireDrugFollowUpFilter array instance is not null " +list.size());
		else 
			log.info("getQuestionnaireDrugFollowUpFilter array instance is null");
		
		return list;
	}

}
