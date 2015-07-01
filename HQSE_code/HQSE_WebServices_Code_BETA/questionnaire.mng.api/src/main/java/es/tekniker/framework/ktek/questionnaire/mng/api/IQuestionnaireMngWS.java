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
package es.tekniker.framework.ktek.questionnaire.mng.api;

import java.io.InputStream;
import java.util.List;

import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireConfiguration;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireMonitoringScheduleEntitySet;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultDataEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;

public interface IQuestionnaireMngWS {
		
	public KtekQuestionnaireConfiguration getQuestionnaireConfiguration()throws KtekExceptionEntity;
	
	public KtekQuestionnaireModelEntity getQuestionnaireModel (String token, int idlang,String codtelecareprogram,int idquestionnaire) throws KtekExceptionEntity;
	
	public KtekQuestionnaireModelEntity getQuestionnaireModelByIdUser(int iduser,  int idlang, String codtelecareprogram, int idquestionnaire)throws KtekExceptionEntity;
	
	public KtekQuestionnaireModelEntity getQuestionnaireModelWithResults(String token, int idlang, String codtelecareprogram, int idresultquestionnaire)throws KtekExceptionEntity;
		

	public List<KtekQuestionnaireMonitoringScheduleEntity> getQuestionnaireMonitoringSchedule(String token, short status, long datefrom , long dateto, short typemonitoringactivity) throws KtekExceptionEntity;
	
	public int getQuestionnaireMonitoringScheduleNum(String token, short status,  String codtelecareprogram,short typemonitoringactivity)throws KtekExceptionEntity;
	
	public KtekQuestionnaireResultDataEntity getQuestionnaireResult(String token,int idresultquestionnaire)throws KtekExceptionEntity;
	
	public KtekQuestionnaireResultDataEntity getQuestionnaireResultXML(String token,int idresultquestionnaire)throws KtekExceptionEntity;
	
	public boolean load(   InputStream stream );
	
	public boolean saveQuestionnaireConfiguration(KtekQuestionnaireConfiguration instance)throws KtekExceptionEntity ;
	
	public int saveQuestionnaireModel(String token, KtekQuestionnaireResultEntity resultData) throws KtekExceptionEntity;
	
	public boolean setQuestionnaireMonitoringSchedule (String token, KtekQuestionnaireMonitoringScheduleEntitySet data) throws KtekExceptionEntity;
	
}
