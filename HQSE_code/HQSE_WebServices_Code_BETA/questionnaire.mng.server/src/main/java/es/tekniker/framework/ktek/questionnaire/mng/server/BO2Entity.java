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

import java.util.ArrayList;
import java.util.List;

import es.tekniker.framework.ktek.Ktek_answer;
import es.tekniker.framework.ktek.Ktek_formatquestionnaire;
import es.tekniker.framework.ktek.Ktek_parameter;
import es.tekniker.framework.ktek.Ktek_question;
import es.tekniker.framework.ktek.Ktek_questionnaire;
import es.tekniker.framework.ktek.Ktek_questionnaireitem;
import es.tekniker.framework.ktek.Ktek_questionnairesection;
import es.tekniker.framework.ktek.Ktek_unit;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireItemType;
import es.tekniker.framework.ktek.questionaire.mng.defines.KtekQuestionnaireQuestionTypeAnswerSortOrder;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireAnswerEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireModelEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireConfigurationEntity;
import es.tekniker.framework.ktek.questionnaire.mng.db.QuestionnaireManagerDB;

public class BO2Entity {

	
	public static KtekQuestionnaireModelEntity QuestionnaireModelBaseBO2Entity(int idLang, Ktek_questionnaire instance) {

		KtekQuestionnaireModelEntity instanceMapped = new KtekQuestionnaireModelEntity();
		String desinstructionsText = null, desText = null, nameText = null; 
		
		if(instance!=null){
			
			nameText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_NAME,instance.getORMID(),idLang);
			if(nameText.equals("") )
				nameText = instance.getNamequestionnaire();
				
			desText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_DES,instance.getORMID(),idLang);
			if(desText.equals("") )
				desText = instance.getDesquestionnaire();
				
			desinstructionsText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_DESINSTRUCTIONS,instance.getORMID(),idLang);
			if(desinstructionsText.equals("") )
				desinstructionsText = instance.getDesinstructionsquestionnaire();
			
			instanceMapped.setDesinstructionsquestionnaire(desinstructionsText);
			instanceMapped.setDesquestionnaire(desText);
			instanceMapped.setNamequestionnaire(nameText);
			instanceMapped.setIdquestionnaire(instance.getKtek_pk_idquestionnaire());
			instanceMapped.setIsmultisection(instance.getIsmultisection());
			instanceMapped.setDesevaluation(instance.getDesevaluation());
			if(instance.getTypemonitoringactivity()!=null)
				instanceMapped.setTypemonitoringactivity(instance.getTypemonitoringactivity());
		}
		return instanceMapped;
	}
	
	
	public static KtekQuestionnaireModelEntity QuestionnaireAssessmentBO2Entity(int idLang, Ktek_questionnaire instance, Ktek_formatquestionnaire instanceConfig, Ktek_questionnairesection[] instanceSectionArray) {

		KtekQuestionnaireModelEntity instanceMapped = new KtekQuestionnaireModelEntity();
		
		KtekQuestionnaireConfigurationEntity instanceConfigurationMapped = null;
		List<KtekQuestionnaireSectionEntity> listSections = null;
		KtekQuestionnaireSectionEntity instanceSectionMapped = null;
		
		QuestionnaireManagerDB db = null;
		Ktek_questionnaireitem[] itemsArray = null;
		List<KtekQuestionnaireItemEntity> listItems = null;
		
		String desinstructionsSectionText = null, desSectionText = null, nameSectionText = null; 
				
		if(instance!=null){
			instanceMapped=QuestionnaireModelBaseBO2Entity(idLang,instance);
		}
		
		if(instanceConfig !=null){
			instanceConfigurationMapped = new KtekQuestionnaireConfigurationEntity();
			instanceConfigurationMapped.setFormatpagination(instanceConfig.getFormatpagination());
			instanceConfigurationMapped.setFormatsetmultitem(instanceConfig.getFormatsetmultitem());
			instanceConfigurationMapped.setFormatsetuniqueitem(instanceConfig.getFormatsetuniqueitem());
			
			instanceConfigurationMapped.setFormatdecimalparameter(instanceConfig.getFormatdecimalparameter());
			instanceConfigurationMapped.setFormatintegerparameter(instanceConfig.getFormatintegerparameter());
			
			instanceMapped.setQuestionnaireConfiguration(instanceConfigurationMapped);			
		}
	
		if(instanceSectionArray!=null){
			db = new QuestionnaireManagerDB();
			listSections = new ArrayList<KtekQuestionnaireSectionEntity>();
			
			for (int i=0; i< instanceSectionArray.length;i++){
				
				nameSectionText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_SECTION_NAME,instanceSectionArray[i].getORMID(),idLang);
				if(nameSectionText.equals("") )
					nameSectionText = instanceSectionArray[i].getNamequestionnairesection();
				
				desSectionText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_SECTION_DES,instanceSectionArray[i].getORMID(),idLang);
				if(desSectionText.equals("") )
					desSectionText = instanceSectionArray[i].getDesquestionnairesection();
				
				desinstructionsSectionText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_SECTION_DESINSTRUCTIONS,instanceSectionArray[i].getORMID(),idLang);
				if(desinstructionsSectionText.equals("") )
					desinstructionsSectionText = instanceSectionArray[i].getDesquestionnairesectioninstructions();
				
				instanceSectionMapped = new  KtekQuestionnaireSectionEntity();
				instanceSectionMapped.setIdquestionnairesection(instanceSectionArray[i].getKtek_pk_idquestionnairesection());				
				instanceSectionMapped.setDesquestionnairesection(desSectionText);
				instanceSectionMapped.setDesquestionnairesectioninstructions(desinstructionsSectionText);
				instanceSectionMapped.setNamequestionnairesection(nameSectionText);
				
				itemsArray = db.getQuestionnaireItemList4Section(instanceSectionArray[i].getKtek_pk_idquestionnairesection());
				
				listItems=QuestionnaireAssessmentItemBO2Entity(itemsArray,idLang);				
				instanceSectionMapped.setListItems(listItems);
				
				listSections.add(instanceSectionMapped);
			}
			
			instanceMapped.setListSections(listSections);
		}
		
		return instanceMapped;
	}
	
	public static List<KtekQuestionnaireItemEntity> QuestionnaireAssessmentItemBO2Entity(Ktek_questionnaireitem[] itemsArray , int idLang ) {
		List<KtekQuestionnaireItemEntity> listMapped = new ArrayList<KtekQuestionnaireItemEntity>() ;
		KtekQuestionnaireItemEntity instance = null;
		QuestionnaireManagerDB db = null;
		Ktek_question instanceQuestion = null;
		int idAnswerSet =0;
		long typeanswersortorder=0;
		Ktek_answer[] instanceAnswerArray = null;
		List<KtekQuestionnaireAnswerEntity> listAnswers = null;
		Ktek_parameter instanceParameter =  null;
		Ktek_unit instanceUnit = null;
		
		String nameText = null, descText=null;
		boolean boolIsrequired =false;
		if(itemsArray!=null){
		
			db = new QuestionnaireManagerDB();
			for (int i=0; i< itemsArray.length;i++){
				
				nameText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_ITEM_NAME,itemsArray[i].getORMID(),idLang);
				if(nameText.equals(""))
					nameText=itemsArray[i].getNamequestionnaireitem();
				
				descText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_QUESTIONNAIRE_ITEM_DES,itemsArray[i].getORMID(),idLang);
				if(descText.equals(""))
					descText=itemsArray[i].getDesquestionnaireitem();
					
				instance = new KtekQuestionnaireItemEntity();
				instance.setIdquestionnaireitem(itemsArray[i].getKtek_pk_idquestionnaireitem());
				
				if (itemsArray[i].getIsrequired() == 1)
					boolIsrequired= true;
				else
					boolIsrequired =false;
				
				instance.setIsrequired(boolIsrequired);
				instance.setTypequestionnaireitem(itemsArray[i].getTypequestionnaireitem());
				instance.setDesquestionnaireitem(descText);
				instance.setNamequestionnaireitem(nameText);
			
				//GET questions 
				instanceQuestion=db.getQuestion4QuestionnaireItem(itemsArray[i].getKtek_pk_idquestionnaireitem());
				if(instanceQuestion!=null){
					instance.setTypeaswer(instanceQuestion.getTypeanswer());
					typeanswersortorder=instanceQuestion.getTypeanswersortorder();
					if(instanceQuestion.getFormatanswerunique()!=null)
						instance.setFormatanswerunique(instanceQuestion.getFormatanswerunique());
				}
				
				if(instanceQuestion != null && instanceQuestion.getKtek_fk_idanswerset() !=null){
					idAnswerSet= instanceQuestion.getKtek_fk_idanswerset().getKtek_pk_idanswerset();
				}else {
					 idAnswerSet =0;
				}			
				
				//GET Answers
				instanceAnswerArray = db.getQuestionnaireItemAnwser4QuestionnaireItem(itemsArray[i].getKtek_pk_idquestionnaireitem(),idAnswerSet);
				
				if(typeanswersortorder==KtekQuestionnaireQuestionTypeAnswerSortOrder.QUESTIONNAIRE_QUESTION_TYPE_ANSWER_SORT_ORDER_RANDOM){
					UtilsQuestionnaire.shuffleArray(instanceAnswerArray);
				}
				
				if(instanceAnswerArray !=null){
					listAnswers = QuestionnaireAnswerBO2Entity(instanceAnswerArray,idLang);					
					instance.setListanswers(listAnswers);
				}
				
				//GET PARAMETERS
				if(itemsArray[i].getTypequestionnaireitem()==KtekQuestionnaireItemType.QUESTIONNAIRE_ITEM_PARAMETER){
					instanceParameter = db.getQuestionnaireParameters4QuestionnaireItem(itemsArray[i].getKtek_pk_idquestionnaireitem());
					if(instanceParameter !=null){
						if(instanceParameter.getValuedefault() !=null)
							instance.setValuedefault(instanceParameter.getValuedefault());
						instance.setValuemax(instanceParameter.getValuemax());
						instance.setValuemin(instanceParameter.getValuemin());
						instance.setTypeparameter(instanceParameter.getTypeparameter());
						instance.setTypedatacapture(instanceParameter.getTypedatacapture());
					}
					
					// GET COD UNIT
					instanceUnit = db.getUnit4QuestionnaireItem(itemsArray[i].getKtek_pk_idquestionnaireitem());
					if(instanceUnit != null){
						instance.setCodunit(instanceUnit.getKtek_uk_codunit());
					}
				}
				
				listMapped.add(instance);
			}		
		}
		return listMapped;
	}
		
	public static List<KtekQuestionnaireAnswerEntity> QuestionnaireAnswerBO2Entity(Ktek_answer[] instanceArray, int idLang){
		List<KtekQuestionnaireAnswerEntity> list = null;
		KtekQuestionnaireAnswerEntity instance = null;		
		String nameText = null, desText = null;
		
		if(instanceArray != null){
			list = new ArrayList<KtekQuestionnaireAnswerEntity>();
			for(int i=0;i< instanceArray.length;i++ ){
												
				nameText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_ANSWER_NAME,instanceArray[i].getKtek_pk_idanswer(),idLang);
				if(nameText.equals(""))
					nameText=instanceArray[i].getNameanswer();
				
				desText= getText(es.tekniker.framework.ktek.questionaire.mng.defines.KtekTableFieldName.KTEK_ANSWER_DES,instanceArray[i].getKtek_pk_idanswer(),idLang);
				if(desText.equals(""))
					desText=instanceArray[i].getDesanswer();
				
				instance = new KtekQuestionnaireAnswerEntity();
				instance.setDesanswer(desText);
				instance.setNameanswer(nameText);
				instance.setCodanswer(instanceArray[i].getKtek_uk_codanswer());
				instance.setScoreanswer(instanceArray[i].getScoreanswer());
				
				list.add(instance);				
			}
		}
		return list; 
	}
	
	// GET TEXT FROM DB
	public static String getText(String textKey, long id, int idlang){
		String text= null;
		CommonsManagerDB db = new CommonsManagerDB();
		text=db.getText(textKey, id, idlang);
		return text;		
	}
		
}
