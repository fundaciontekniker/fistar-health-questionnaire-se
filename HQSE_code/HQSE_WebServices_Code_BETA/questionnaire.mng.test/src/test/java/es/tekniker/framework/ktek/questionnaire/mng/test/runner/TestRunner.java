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
package es.tekniker.framework.ktek.questionnaire.mng.test.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;



import es.tekniker.framework.ktek.questionnaire.mng.test.TestQuestionnaireMngServer;

public class TestRunner {

	public static void main(String[] args) {

		JUnitCore core= new JUnitCore();
		Result questionnaireResult= core.run(TestQuestionnaireMngServer.class);
		
		System.out.println("TestQuestionnaireMngServer TESTS");
		System.out.println("TOTAL Tests : " + questionnaireResult.getRunCount()  );
		System.out.println("RUNNED Tests: "  + questionnaireResult.getRunCount());		
		System.out.println("FAILURES Tests: "  + questionnaireResult.getFailureCount());
		
		System.out.println("TEST Time : "  + questionnaireResult.getRunTime() + " milliseconds" );
		
	}

	
	
}
