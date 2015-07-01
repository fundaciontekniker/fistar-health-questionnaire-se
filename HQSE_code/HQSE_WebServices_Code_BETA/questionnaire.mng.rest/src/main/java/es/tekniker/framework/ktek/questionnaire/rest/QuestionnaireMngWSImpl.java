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

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.api.IQuestionnaireMngWS;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireConfiguration;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemFilterEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntitySet;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.server.QuestionnaireMngServer;

@Path("")
@Produces(KtekDefines.MEDIATYPE_JSON)
public class QuestionnaireMngWSImpl implements IQuestionnaireMngWS {
		
	private static Log log =LogFactory.getLog(QuestionnaireMngWSImpl.class);

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/info/")
	public String DescriptionService() {
		StringBuffer sInfo= new StringBuffer();
		
		sInfo.append("KTEK Questionnaire Management Restful Services with Apache CXF. \n");
	
		return sInfo.toString();
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnairemodel/{idquestionnaire}")
	public KtekQuestionnaireModelEntity getQuestionnaireModel(@HeaderParam("token")String token,@HeaderParam("idlang")  int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("idquestionnaire")int idquestionnaire)throws KtekExceptionEntity {
		log.info("getQuestionnaireModel ");		
		KtekQuestionnaireModelEntity entity = null;		
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		entity=server.getQuestionnaireModelByToken(token, idlang, codtelecareprogram, idquestionnaire);			
		if (entity!=null)
			log.info("getQuestionnaireModel : OK" );
		else 
			log.info("getQuestionnaireModel : id " + idquestionnaire + " does not exists");
		
		return entity;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnairemodeldata/{idquestionnaire}")
	public KtekQuestionnaireModelEntity getQuestionnaireModelByIdUser(@HeaderParam("iduser")int iduser,@HeaderParam("idlang")  int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("idquestionnaire")int idquestionnaire)throws KtekExceptionEntity {
		log.info("getQuestionnaireModelByIdUser ");		
		KtekQuestionnaireModelEntity entity = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();		
		entity = server.getQuestionnaireModelData(iduser, idlang,codtelecareprogram, idquestionnaire);		
		if (entity!=null)
			log.info("getQuestionnaireModelByIdUser instance is not null" );
		else 
			log.info("getQuestionnaireModelByIdUser instance is null. Questionaire " + idquestionnaire + " does not exists");
		
		return entity;
	}	
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnaire/{idquestionnaire}/results")
	public List<KtekQuestionnaireItemFilterEntity> getQuestionnaireResults4IdQuestionnaire(@HeaderParam("idlang")  int idlang, @PathParam("idquestionnaire") int idquestionnaire){
		log.info("getQuestionnaireResults4IdQuestionnaire ");
		List<KtekQuestionnaireItemFilterEntity> list = null; 
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		list =server.getQuestionnaireResults4IdQuestionnaire(idquestionnaire, idlang);
		
		if (list!=null)
			log.info("getQuestionnaireResults4IdQuestionnaire  list is not null " + list.size() );
		else 
			log.info("getQuestionnaireResults4IdQuestionnaire list is null");
		
		return list;
	}
	
	@POST
	@Path("/questionnairemodel/")
	@Consumes("application/json")	
	public int saveQuestionnaireModel(@HeaderParam("token")String token, KtekQuestionnaireResultEntity resultData)	throws KtekExceptionEntity {
		log.info("saveQuestionnaireModel " );
		int resultQuestionnaireSave =0;			
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		resultQuestionnaireSave=server.saveQuestionnaireModel(token, resultData);			
		if (resultQuestionnaireSave==1)
			log.info("saveQuestionnaireModel OK with result "  + resultQuestionnaireSave);
		else 
			log.info("saveQuestionnaireModel NOK with result " +resultQuestionnaireSave);
		
		return resultQuestionnaireSave;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnairemonitoringschedule/{datefrom}/{dateto}/{typemonitoringactivity}")
	public List<KtekQuestionnaireMonitoringScheduleEntity> getQuestionnaireMonitoringSchedule(@HeaderParam("token")String token,@HeaderParam("status")short status, @PathParam("datefrom")long datefrom, @PathParam("dateto")long dateto, @PathParam("typemonitoringactivity")short typemonitoringactivity)throws KtekExceptionEntity {
		log.info("getKtekQuestionnaireMonitoringSchedule ");		
		List<KtekQuestionnaireMonitoringScheduleEntity>  list = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();		
		list= server.getKtekQuestionnaireMonitoringSchedule( token, datefrom, dateto, typemonitoringactivity, status);
		if (list!=null)
			log.info("getKtekQuestionnaireMonitoringSchedule  list is not null " + list.size() );
		else 
			log.info("getKtekQuestionnaireMonitoringSchedule list is null");				
		
		return list;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnairemonitoringschedulenum/{codtelecareprogram}/{typemonitoringactivity}")
	public int getQuestionnaireMonitoringScheduleNum(@HeaderParam("token")String token, @HeaderParam("status")short status, @PathParam("codtelecareprogram") String codtelecareprogram,@PathParam("typemonitoringactivity")short typemonitoringactivity)throws KtekExceptionEntity {
		log.info("getQuestionnaireMonitoringScheduleNum ");		
		int num=0;
		List<KtekQuestionnaireMonitoringScheduleEntity>  list = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();	
		list= server.getKtekQuestionnaireMonitoringScheduleNow( token, codtelecareprogram, typemonitoringactivity, status);				
		if(list!=null)
			num=list.size();
		
		log.info("getQuestionnaireMonitoringScheduleNum : num " +  num);
		
		return num;
	}
	
	@POST
	@Consumes("application/json")
	@Path("/questionnairemonitoringschedule")
	public boolean setQuestionnaireMonitoringSchedule(@HeaderParam("token") String token,KtekQuestionnaireMonitoringScheduleEntitySet data)throws KtekExceptionEntity {
		log.info("setQuestionnaireMonitoringSchedule ");		
		boolean boolOK=false;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();	
		boolOK = server.setQuestionnaireMonitoringSchedule(token,data);
		if (boolOK)
			log.info("setQuestionnaireMonitoringSchedule OK" );
		else 
			log.info("setQuestionnaireMonitoringSchedule ERROR");		
		
		return boolOK;
	}

	@POST 
	@Path("/loadfile")
	@Consumes("text/plain")
	public boolean loadfile (String  strfilename){
		log.info("loadfile ");				
		boolean boolOK=false;		
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();	
		boolOK=server.loadfileData(strfilename);
		if (boolOK)
			log.info("loadfile OK" );
		else 
			log.info("loadfile ERROR");				
		
		return boolOK;
	}
	
	@POST 
	@Path("/load")
	@Consumes("multipart/form-data")
	public boolean load( @Multipart(value = "stream")  InputStream stream ){
		log.info("load");
		boolean boolOK=false;	
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();	
		boolOK=server.loadfileDataStream(stream);
		if (boolOK)
			log.info("load OK" );
		else 
			log.info("load ERROR");				
				
		return boolOK;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnaireresult/{idresultquestionnaire}")
	public KtekQuestionnaireResultDataEntity getQuestionnaireResult(@HeaderParam("token")String token,@PathParam("idresultquestionnaire")int idresultquestionnaire)throws KtekExceptionEntity {
		log.info("getQuestionnaireResult");		
		KtekQuestionnaireResultDataEntity entity = null;		
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();		
		entity=server.getQuestionnaireResult(token, idresultquestionnaire);
		if (entity!=null)
			log.info("getQuestionnaireResult : OK" );
		else 
			log.info("getQuestionnaireResult : idresultquestionnaire " + idresultquestionnaire + " does not exists");
		
		return entity;
	}
	
	@GET
	@Produces(KtekDefines.MEDIATYPE_XML)
	@Path("/questionnaireresultxml/{idresultquestionnaire}")
	public KtekQuestionnaireResultDataEntity getQuestionnaireResultXML(@HeaderParam("token")String token,@PathParam("idresultquestionnaire")int idresultquestionnaire)throws KtekExceptionEntity {
		log.info("getQuestionnaireResultXML ");
		KtekQuestionnaireResultDataEntity entity = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		entity=server.getQuestionnaireResult(token, idresultquestionnaire);	
		
		if (entity!=null)
			log.info("getQuestionnaireResultXML : OK" );
		else 
			log.info("getQuestionnaireResultXML : idresultquestionnaire " + idresultquestionnaire + " does not exists");
		
		return entity;
	}
		
	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/questionnairemodelresult/{idresultquestionnaire}")
	public KtekQuestionnaireModelEntity getQuestionnaireModelWithResults(@HeaderParam("token")String token,@HeaderParam("idlang") int idlang, @HeaderParam("codtelecareprogram")String codtelecareprogram, @PathParam("idresultquestionnaire")int idresultquestionnaire)throws KtekExceptionEntity {
		log.info("getQuestionnaireModelWithResults");		
		KtekQuestionnaireModelEntity entity = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		entity=server.getQuestionnaireModelWithResults(token, idlang, codtelecareprogram, idresultquestionnaire);
		if (entity!=null)
			log.info("getQuestionnaireModelWithResults : OK" );
		else 
			log.info("getQuestionnaireModelWithResults : idresultquestionnaire " + idresultquestionnaire + " does not exists");
		
		return entity;
	}

	@GET
	@Produces(KtekDefines.MEDIATYPE_JSON)
	@Path("/configuration/")
	public KtekQuestionnaireConfiguration getQuestionnaireConfiguration()throws KtekExceptionEntity {
		log.info("getQuestionnaireConfiguration");		
		KtekQuestionnaireConfiguration entity = null;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		entity=server.getQuestionnaireConfiguration();
		if (entity!=null)
			log.info("getQuestionnaireConfiguration instance is not null" );
		else 
			log.info("getQuestionnaireConfiguration instance is null");
		
		return entity;
	}
	
	@POST
	@Consumes(KtekDefines.MEDIATYPE_JSON)
	@Path("/configuration/")
	public boolean saveQuestionnaireConfiguration(KtekQuestionnaireConfiguration instance)throws KtekExceptionEntity {
		log.info("setQuestionnaireConfiguration");
		boolean  boolOK= false;
		QuestionnaireMngServer server = null;
		
		server = new QuestionnaireMngServer ();
		boolOK=server.setQuestionnaireConfiguration(instance);
		if (boolOK)
			log.info("setQuestionnaireConfiguration : OK" );
		else 
			log.info("setQuestionnaireConfiguration : ERROR");
		
		return boolOK;
	}
	
}
