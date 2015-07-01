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
package es.tekniker.framework.ktek.questionnaire.mng.db;

import java.util.ArrayList;
import java.util.List;

import es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekLoginCoordinatesEntity;
import es.tekniker.framework.ktek.entity.KtekLoginEntity;
import es.tekniker.framework.ktek.entity.KtekUserEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireItemResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireResultEntity;
import es.tekniker.framework.ktek.questionnaire.mng.bo.KtekQuestionnaireSectionResultEntity;

public class TestData {

	private static String strLoginUserExists = "DNI-user2";

	public static KtekLoginEntity getLoginExists(){
		
		KtekLoginEntity login = new KtekLoginEntity ();
		
		login.setReference(strLoginUserExists);
		login.setPassword("pwd");

		KtekLoginCoordinatesEntity[] array= new KtekLoginCoordinatesEntity[3];
		
		KtekLoginCoordinatesEntity coord1 = new KtekLoginCoordinatesEntity ();		
		coord1.setLetter("A");
		coord1.setValue("vvvv");
		
		KtekLoginCoordinatesEntity coord2 = new KtekLoginCoordinatesEntity ();		
		coord2.setLetter("B");
		coord2.setValue("FDFSDFSDFSD");
		
		KtekLoginCoordinatesEntity coord3 = new KtekLoginCoordinatesEntity ();		
		coord3.setLetter("C");
		coord3.setValue("HJJGHJG");
		
		array[0] = coord1;
		array[1] = coord2;
		array[2] = coord3;
		
		
		login.setCoordinates(array);
		
		
		
		return login;
	}
	
	
	public static String getLoginToken(){		
		
		CommonsMngServer manager = new CommonsMngServer ();
		
		KtekLoginEntity login = null;
		
		String token = null;
		try {
			
			login = getLoginExists();
						
			KtekUserEntity instance = manager.login(login);
			
			if (instance!=null){				
				token =instance.getToken();
			}
	 		else{
	 			//nothing
	 		}
						
		} catch (KtekExceptionEntity e) {			
			e.printStackTrace();
		}
		
		return token;
				
	}
	
	public static KtekQuestionnaireSectionResultEntity getSectionWith4items(int idsection){
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems1 = null;
		KtekQuestionnaireItemResultEntity item1 = null, item2 = null, item3 = null, item4 = null;
		String[]  listCodAnswer1= new String[1];
		String[]  listCodAnswer2= new String[2];
		String[]  listCodAnswer3= new String[1];
		String[]  listCodAnswer4= new String[1];
				
		item1= new KtekQuestionnaireItemResultEntity();
		listCodAnswer1[0]="A2";
		item1.setListcodanswer(listCodAnswer1);
		item1.setIdquestionnaireitem(1);
		
		item2= new KtekQuestionnaireItemResultEntity();
		listCodAnswer2[0]="A5";
		
		item2.setListcodanswer(listCodAnswer2);		
		item2.setIdquestionnaireitem(2);
		
		item3= new KtekQuestionnaireItemResultEntity();
		listCodAnswer3[0]="A7";
		item3.setListcodanswer(listCodAnswer3);		
		item3.setIdquestionnaireitem(3);
		
		item4= new KtekQuestionnaireItemResultEntity();
		listCodAnswer4[0]="A12";
		item4.setListcodanswer(listCodAnswer4);		
		item4.setIdquestionnaireitem(4);
		
		listitems1= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems1.add(item1);
		listitems1.add(item2);
		listitems1.add(item3);
		listitems1.add(item4);
		
		
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(idsection);
		section.setListitems(listitems1);
		
		
		return section;
	}
	
	public static KtekQuestionnaireSectionResultEntity getSectionWith4itemsError(int idsection){
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems1 = null;
		KtekQuestionnaireItemResultEntity item1 = null, item2 = null, item3 = null, item4 = null;
		String[]  listCodAnswer1= new String[1] ;
		String[]  listCodAnswer2= new String[2] ;
		String[]  listCodAnswer3= new String[1] ;
		String[]  listCodAnswer4= new String[1] ;
				
		item1= new KtekQuestionnaireItemResultEntity();
		listCodAnswer1[0]="A2";
		
		item1.setListcodanswer(listCodAnswer1);
		item1.setIdquestionnaireitem(1);
		
		item2= new KtekQuestionnaireItemResultEntity();
		listCodAnswer2[0]="A5";
		listCodAnswer2[1]="A6";

		item2.setListcodanswer(listCodAnswer2);		
		item2.setIdquestionnaireitem(2);
		
		item3= new KtekQuestionnaireItemResultEntity();
		listCodAnswer3[0]="A8";
		item3.setListcodanswer(listCodAnswer3);		
		item3.setIdquestionnaireitem(3);
		
		item4= new KtekQuestionnaireItemResultEntity();
		listCodAnswer4[0]="A12";
		item4.setListcodanswer(listCodAnswer4);		
		item4.setIdquestionnaireitem(4);
		
		listitems1= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems1.add(item1);
		listitems1.add(item2);
		listitems1.add(item3);
		listitems1.add(item4);
		
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(idsection);
		section.setListitems(listitems1);
		
		return section;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireAssessmentResultEntity1(){
		KtekQuestionnaireResultEntity resultData = null;
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		String[]  listCodAnswer5= new String[2] ;
		String[]  listCodAnswer6= new String[1] ;
		
		KtekQuestionnaireItemResultEntity item5=null, item6=null, item7=null, item8=null , item9=null , item10=null , item11=null;
		
		listCodAnswer5[0]="A18";
		listCodAnswer5[1]="A21";
		
		item5 =  new KtekQuestionnaireItemResultEntity();
		item5.setListcodanswer(listCodAnswer5);
		item5.setIdquestionnaireitem(8);
		
		listCodAnswer6[0]="A20";		
		item6 =  new KtekQuestionnaireItemResultEntity();
		item6.setListcodanswer(listCodAnswer6);
		item6.setIdquestionnaireitem(9);
		
		item7 =  new KtekQuestionnaireItemResultEntity();
		item7.setAnswervalue("9");
		item7.setIdquestionnaireitem(14);
		
		item8 =  new KtekQuestionnaireItemResultEntity();
		item8.setAnswervalue("Me encuentro confuso");
		item8.setIdquestionnaireitem(15);
		
		item9 =  new KtekQuestionnaireItemResultEntity();
		item9.setAnswervalue("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		item9.setIdquestionnaireitem(16);
		
		item10 =  new KtekQuestionnaireItemResultEntity();
		item10.setAnswervalue("1402392504119");
		item10.setIdquestionnaireitem(17);
		
		item11 =  new KtekQuestionnaireItemResultEntity();
		item11.setAnswervalue("8.5");
		item11.setIdquestionnaireitem(18);
		
		
		section=getSectionWith4items(1);
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("33333001A");
		resultData.setIdquestionnaire(1);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireAssessmentResultEntity2(){
		KtekQuestionnaireResultEntity resultData = null;
		KtekQuestionnaireSectionResultEntity section = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
				
		section=getSectionWith4items(2);
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("33333001A");
		resultData.setIdquestionnaire(2);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireAssessmentResultEntity3(){
		KtekQuestionnaireResultEntity resultData = null;
		KtekQuestionnaireSectionResultEntity section = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
				
		section=getSectionWith4items(3);
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
				
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("33333001A");
		resultData.setIdquestionnaire(3);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireAssessmentResultEntityTest1(){
		KtekQuestionnaireResultEntity resultData = null;
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		String[]  listCodAnswer11= new String[1];
		String[]  listCodAnswer12= new String[1];
		String[]  listCodAnswer13= new String[1];
		String[]  listCodAnswer14= new String[1];
				
		List<KtekQuestionnaireItemResultEntity> list = null;
		
		KtekQuestionnaireItemResultEntity item5=null, item6=null, item7=null, item8=null ;
		
		listCodAnswer11[0]="A25";
		item5 =  new KtekQuestionnaireItemResultEntity();
		item5.setListcodanswer(listCodAnswer11);
		item5.setIdquestionnaireitem(11);
		
		listCodAnswer12[0]="A28";
		item6 =  new KtekQuestionnaireItemResultEntity();
		item6.setListcodanswer(listCodAnswer12);
		item6.setIdquestionnaireitem(12);
				
		listCodAnswer13[0]="A31";
		item7 =  new KtekQuestionnaireItemResultEntity();
		item7.setListcodanswer(listCodAnswer13);
		item7.setIdquestionnaireitem(13);
				
		listCodAnswer14[0]="A35";
		item8 =  new KtekQuestionnaireItemResultEntity();
		item8.setListcodanswer(listCodAnswer14);
		item8.setIdquestionnaireitem(14);
				
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(7);
		
		list = new ArrayList<KtekQuestionnaireItemResultEntity> ();
		
		list.add(item5);
		list.add(item6);
		list.add(item7);
		list.add(item8);
		
		section.setListitems(list);
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("User1");
		resultData.setIdquestionnaire(1);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireAssessmentResultEntityError1(){
		KtekQuestionnaireResultEntity resultData = null;
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		String[]  listCodAnswer5= new String[2] ;
		String[]  listCodAnswer6= new String[1] ;
		
		KtekQuestionnaireItemResultEntity item5=null, item6=null, item7=null, item8=null , item9=null , item10=null , item11=null;
		
		listCodAnswer5[0]="A18";
		listCodAnswer5[1]="A21";
		
		item5 =  new KtekQuestionnaireItemResultEntity();
		item5.setListcodanswer(listCodAnswer5);
		item5.setIdquestionnaireitem(8);
		
		listCodAnswer6[0]="A20";		
		item6 =  new KtekQuestionnaireItemResultEntity();
		item6.setListcodanswer(listCodAnswer6);
		item6.setIdquestionnaireitem(9);
		
		item7 =  new KtekQuestionnaireItemResultEntity();
		item7.setAnswervalue("9");
		item7.setIdquestionnaireitem(14);
		
		item8 =  new KtekQuestionnaireItemResultEntity();
		item8.setAnswervalue("Me encuentro confuso");
		item8.setIdquestionnaireitem(15);
		
		item9 =  new KtekQuestionnaireItemResultEntity();
		item9.setAnswervalue("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		item9.setIdquestionnaireitem(16);
		
		item10 =  new KtekQuestionnaireItemResultEntity();
		item10.setAnswervalue("1402392504119");
		item10.setIdquestionnaireitem(17);
		
		item11 =  new KtekQuestionnaireItemResultEntity();
		item11.setAnswervalue("8.5");
		item11.setIdquestionnaireitem(18);
		
		section=getSectionWith4itemsError(1);

		//add more items
		section.getListitems().add(item7);
		section.getListitems().add(item8);
		section.getListitems().add(item9);
		section.getListitems().add(item10);
		section.getListitems().add(item11);
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("33333001A");
		resultData.setIdquestionnaire(1);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireMonitoringResultEntityWithParameters(){
		KtekQuestionnaireResultEntity resultData = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		KtekQuestionnaireSectionResultEntity section1 = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems = null;
		KtekQuestionnaireItemResultEntity item1 = null;
		KtekQuestionnaireItemResultEntity item2 = null;
		
		item1= new KtekQuestionnaireItemResultEntity();
		item1.setParamvalue("58");
		item1.setIdquestionnaireitem(12);
		
		item2= new KtekQuestionnaireItemResultEntity();
		item2.setParamvalue("61.5");
		item2.setIdquestionnaireitem(13);
		
		listitems= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems.add(item1);
		listitems.add(item2);
		
		section1 = new KtekQuestionnaireSectionResultEntity();
		section1.setIdquestionnairesection(5);
		section1.setListitems(listitems);
	
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section1);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP2");
		resultData.setCoduser("33333002A");
		resultData.setIdquestionnaire(11);		
		resultData.setListsections(listsections);
		
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireMonitoringResultEntityWithQuestions(){
		KtekQuestionnaireResultEntity resultData = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		KtekQuestionnaireSectionResultEntity section = null;
	
		section=getSectionWithQuestions();
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP2");
		resultData.setCoduser("33333002A");
		resultData.setIdquestionnaire(10);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	public static KtekQuestionnaireResultEntity getKtekQuestionnaireMonitoringResultEntityWithParametersWithQuestions(){
		KtekQuestionnaireResultEntity resultData = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		
		KtekQuestionnaireSectionResultEntity section1 = null,section2 = null;
		
		section1=getSectionWithParameters();
		section2=getSectionWithQuestions();
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section1);
		listsections.add(section2);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP2");
		resultData.setCoduser("33333002A");
		resultData.setIdquestionnaire(12);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	private static KtekQuestionnaireSectionResultEntity getSectionWithParameters(){
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems = null;
		KtekQuestionnaireItemResultEntity item1 = null;
		KtekQuestionnaireItemResultEntity item2 = null;
		
		item1= new KtekQuestionnaireItemResultEntity();
		item1.setParamvalue("58");
		item1.setIdquestionnaireitem(12);
		
		item2= new KtekQuestionnaireItemResultEntity();
		item2.setParamvalue("61.5");
		item2.setIdquestionnaireitem(13);
		
		listitems= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems.add(item1);
		listitems.add(item2);
		
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(5);
		section.setListitems(listitems);
		
		return section;
	}
	
	private static KtekQuestionnaireSectionResultEntity getSectionWithQuestions(){
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems = null;
		KtekQuestionnaireItemResultEntity item1 = null , item2 = null, item3 = null;
		
		String[]  listCodAnswer= new String[1] ;
		
		item1= new KtekQuestionnaireItemResultEntity();
		item1.setAnswervalue("alguna cerveza");
		item1.setIdquestionnaireitem(9);
		
		item2= new KtekQuestionnaireItemResultEntity();
		listCodAnswer[0]="A30";
		item2.setListcodanswer(listCodAnswer);
		item2.setIdquestionnaireitem(10);
		
		item3= new KtekQuestionnaireItemResultEntity();
		item3.setAnswervalue("trabajo");
		item3.setIdquestionnaireitem(11);
		
		listitems= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems.add(item1);
		listitems.add(item2);
		listitems.add(item3);
		
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(4);
		section.setListitems(listitems);
		
		return section;
	}

	public static KtekQuestionnaireResultEntity getKtekQuestionnaireMonitoringResultEntityIT18(){
		KtekQuestionnaireResultEntity resultData = null;
		List<KtekQuestionnaireSectionResultEntity> listsections = null;
		KtekQuestionnaireSectionResultEntity section = null;
	
		section=getSectionIT18();
		
		listsections = new ArrayList<KtekQuestionnaireSectionResultEntity>();
		listsections.add(section);
		
		resultData = new KtekQuestionnaireResultEntity();
		resultData.setCodtelecareprogram("TBP1");
		resultData.setCoduser("33333002A");
		resultData.setIdquestionnaire(18);		
		resultData.setListsections(listsections);
		return resultData;
	}
	
	private static KtekQuestionnaireSectionResultEntity getSectionIT18(){
		KtekQuestionnaireSectionResultEntity section = null;
		
		List<KtekQuestionnaireItemResultEntity> listitems = null;
		KtekQuestionnaireItemResultEntity item1 = null ;
		
		String[]  listCodAnswer= new String[1] ;
		
		item1= new KtekQuestionnaireItemResultEntity();
		item1.setAnswervalue("Bad");
		item1.setIdquestionnaireitem(19);
		
		listitems= new ArrayList<KtekQuestionnaireItemResultEntity>();		
		listitems.add(item1);
		
		section = new KtekQuestionnaireSectionResultEntity();
		section.setIdquestionnairesection(4);
		section.setListitems(listitems);
		
		return section;
	}

	
}
