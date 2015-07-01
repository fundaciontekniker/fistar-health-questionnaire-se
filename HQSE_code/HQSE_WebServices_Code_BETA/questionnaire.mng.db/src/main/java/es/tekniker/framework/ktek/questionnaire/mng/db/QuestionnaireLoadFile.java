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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager;

public class QuestionnaireLoadFile {

	private static final Log log = LogFactory.getLog(QuestionnaireLoadFile.class);
	
	private static String sql_end= ");";
	private static String sql_separator=",";
	private static String sql_quote="'";
	
	//QUESTIONNAIRE
	public static String TABLE_ktek_questionnaire= "ktek_questionnaire";
	public static String SQL_ktek_questionnaire= "INSERT INTO ktek_questionnaire.ktek_questionnaire(ktek_pk_idquestionnaire, idpathology, ktek_uk_codquestionnaire, namequestionnaire, desquestionnaire, desinstructionsquestionnaire, desevaluation, ismultisection, typequestionnaire, typesortorder, typequestionnaireflow, datevalidfrom, datevalidto, datecreation, typemonitoringactivity, periodicityunit, periodictyvalue, collectiontimefrom, collectiontimeto, completionintervalunit, completionintervalvalue, isdeleted ) VALUES (";
	
	public static String TABLE_ktek_formatquestionnaire= "ktek_formatquestionnaire";
	public static String SQL_ktek_formatquestionnaire= "INSERT INTO ktek_questionnaire.ktek_formatquestionnaire(ktek_pk_idformatquestionnaire, ktek_fk_questionnaire, formatpagination, formatintegerparameter, formatdecimalparameter, formatsetuniqueitem, formatsetmultitem ) VALUES (";
	
	public static String TABLE_ktek_questionnairesection= "ktek_questionnairesection";
	public static String SQL_ktek_questionnairesection= "INSERT INTO ktek_questionnaire.ktek_questionnairesection(ktek_pk_idquestionnairesection, namequestionnairesection, desquestionnairesection, desquestionnairesectioninstructions ) VALUES (";
	
	public static String TABLE_ktek_questionnaireitem= "ktek_questionnaireitem";
	public static String SQL_ktek_questionnaireitem= "INSERT INTO ktek_questionnaire.ktek_questionnaireitem(ktek_pk_idquestionnaireitem, ktek_uk_codquestionnaireitem, namequestionnaireitem, desquestionnaireitem, typequestionnaireitem, isrequired, isdeleted ) VALUES (";
	
	public static String TABLE_ktek_question= "ktek_question";
	public static String SQL_ktek_question= "INSERT INTO ktek_questionnaire.ktek_question(ktek_fk_idquestionnaireitem, typeanswersortorder, typeanswer, formatanswerunique, ktek_fk_idanswerset, weightquestion ) VALUES (";

	public static String TABLE_ktek_answer= "ktek_answer";
	public static String SQL_ktek_answer= "INSERT INTO ktek_questionnaire.ktek_answer(ktek_pk_idanswer, ktek_fk_idquestionnaireitem, ktek_uk_codanswer, nameanswer, desanswer, imageanswer, scoreanswer ) VALUES (";

	public static String TABLE_ktek_answerset= "ktek_answerset";
	public static String SQL_ktek_answerset= "INSERT INTO ktek_questionnaire.ktek_answerset(ktek_pk_idanswerset, codanswersetl, nameanswerset ) VALUES (";

	public static String TABLE_ktek_answerset_answer= "ktek_answerset_answer";
	public static String SQL_ktek_answerset_answer= "INSERT INTO ktek_questionnaire.ktek_answerset_answer(ktek_fk_idanswerset, ktek_fk_idanswer ) VALUES (";
	
	public static String TABLE_ktek_qitem_section= "ktek_qitem_section";
	public static String SQL_ktek_qitem_section= "INSERT INTO ktek_questionnaire.ktek_qitem_section(ktek_fk_idquestionnairesection, ktek_fk_idquestionnaireitem, sortorder ) VALUES (";

	public static String TABLE_ktek_qsection_questionnaire= "ktek_qsection_questionnaire";
	public static String SQL_ktek_qsection_questionnaire= "INSERT INTO ktek_questionnaire.ktek_qsection_questionnaire(ktek_fk_idquestionnaire, ktek_fk_idquestionnairesection, sortorder ) VALUES (";

	public static String TABLE_ktek_parameter= "ktek_parameter";
	public static String SQL_ktek_parameter= "INSERT INTO ktek_questionnaire.ktek_parameter(ktek_fk_idquestionnaireitem, typeparameter, typedatacapture, valuedefault, valuemin, valuemax ) VALUES (";
	
	public static String TABLE_ktek_unit= "ktek_unit";
	public static String SQL_ktek_unit= "INSERT INTO ktek_questionnaire.ktek_unit(ktek_pk_idunit, ktek_uk_codunit ) VALUES (";
	
	public static String TABLE_ktek_unit_parameter= "ktek_unit_parameter";
	public static String SQL_ktek_unit_parameter= "INSERT INTO ktek_questionnaire.ktek_unit_parameter(ktek_fk_idquestionnaireitem, ktek_fk_idunit, valueconversion, isdefault ) VALUES (";
	
	public static String TABLE_ktek_questionnaireconfiguration= "ktek_questionnaireconfiguration";
	public static String SQL_ktek_questionnaireconfiguration= "INSERT INTO ktek_questionnaire.ktek_questionnaireconfiguration(ktek_pk_ktek_idquestionnaireconfiguration, ktek_typesave, endpointserver, eventserviceoauth2headertoken, timeout, port) VALUES (";
	
	public static void main(String[] args) {		
		
		//Read FILE
		List<String> dataQuestionnaire = readFile ("D:\\Proyectos\\FI-STAR\\code\\subversion\\trunk\\backend\\db\\dataloadQuestionnaire.csv",false);	
				
		//LOAD data into DataBase
		loadData(dataQuestionnaire);
	}
	
	public static List<String> readFile(String filename, boolean print)
	{
		List<String> data = new ArrayList<String>();
	  
		BufferedReader br = null;
		String line = null;			
		try {
		
			br = new BufferedReader(new FileReader(filename));
			
			line = br.readLine();
			if(line!=null)
            {
				data.add(line);
	            for (String retval: line.split(";")){
	            	if(print)
	            		System.out.print(retval+ "  ");
	            }
            }
			System.out.println();
	        while (line != null) {
	            line = br.readLine();
	            if(line!=null)
	            {
	            	if(line.equals("")==false)
	            		data.add(line);
	            	
		            for (String retval: line.split(";")){
		            	if(print)
		            		System.out.print(retval + "  ");
		            }
		            if(print)
		            	System.out.println();
	            }
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		return data;
		
	}

	public static boolean loadData(List<String> data) {

		boolean boolOK=true;
		
		PersistentSession session = null;
		PersistentTransaction tr = null;
		Statement st;
		
		StringBuffer sql = null;
		String[] dataline = null;
		String tablename = null;
		try {
			
			session = KTEKPersistentManager.instance().getSession();
			tr = session.beginTransaction();
			
			try {
				st = session.connection().createStatement();
				System.out.println(data.size());
				for(int i=0; i<data.size();i++){
					
					dataline = data.get(i).split(";"); 
					
					log.debug("data by line " + data.get(i) + " num items " + dataline.length + " data line 0 " + dataline[0]);
					
					tablename = dataline[0] ;
					
					tablename= tablename.trim();
					
					sql=null;
					if(tablename.equals(TABLE_ktek_questionnaire))
						sql = getSQL4_Table_Questionnaire(dataline);
					else if(dataline[0].equals(TABLE_ktek_formatquestionnaire))
						sql = getSQL4_Table_Formatquestionnaire(dataline);
					else if(dataline[0].equals(TABLE_ktek_questionnairesection))
						sql = getSQL4_Table_Questionnairesection(dataline);
					else if(dataline[0].equals(TABLE_ktek_questionnaireitem))
						sql = getSQL4_Table_Questionnaireitem(dataline);
					else if(dataline[0].equals(TABLE_ktek_question))
						sql = getSQL4_Table_Question(dataline);
					else if(dataline[0].equals(TABLE_ktek_answer))
						sql = getSQL4_Table_Answer(dataline);
					else if(dataline[0].equals(TABLE_ktek_answerset))
						sql = getSQL4_Table_Answerset(dataline);
					else if(dataline[0].equals(TABLE_ktek_answerset_answer))
						sql = getSQL4_Table_Answerset_answer(dataline);
					else if(dataline[0].equals(TABLE_ktek_qitem_section))
						sql = getSQL4_Table_Qitemsection(dataline);
					else if(dataline[0].equals(TABLE_ktek_qsection_questionnaire))
						sql = getSQL4_Table_Qsectionquestionnaire(dataline);
					
					else if(dataline[0].equals(TABLE_ktek_parameter))
						sql = getSQL4_Table_Parameter(dataline);
					else if(dataline[0].equals(TABLE_ktek_unit))
						sql = getSQL4_Table_Unit(dataline);
					else if(dataline[0].equals(TABLE_ktek_unit_parameter))
						sql = getSQL4_Table_Unit_parameter(dataline);
					else if(dataline[0].equals(TABLE_ktek_questionnaireconfiguration))
						sql = getSQL4_Table_Questionnaireconfiguration(dataline);
					
					
					else{
						log.debug("table name not found " +  dataline[0]);
					}
					log.debug("i : "+ i + " SQL : "  + sql);
					if(sql!=null)
						st.execute(sql.toString());
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug(" SQLException " + e.getMessage());
				boolOK=false;
			}
			tr.commit();
			
			session.close();
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boolOK;
	}
	
	public static StringBuffer getSQL4_Table_Answer(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_answer);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[4].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[5].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[6].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(dataline[7]);		
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Answerset(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_answerset);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3].trim());
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Answerset_answer(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_answerset_answer);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Qitemsection(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_qitem_section);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Qsectionquestionnaire(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_qsection_questionnaire);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_end);
		
		return sql;
	}
	
	
	public static StringBuffer getSQL4_Table_Parameter(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_parameter);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_separator);
		sql.append(dataline[4]);
		sql.append(sql_separator);
		sql.append(dataline[5]);
		sql.append(sql_separator);
		sql.append(dataline[6]);		
		sql.append(sql_end);
		
		return sql;
	}
	
	
	public static StringBuffer getSQL4_Table_Unit(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_unit);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2].trim());
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Unit_parameter(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_unit_parameter);
		sql.append(dataline[1]);
		sql.append(sql_separator);		
		sql.append(dataline[2]);		
		sql.append(sql_separator);		
		sql.append(dataline[3]);		
		sql.append(sql_separator);		
		sql.append(dataline[4]);		
		sql.append(sql_end);
		
		return sql;
	}
		
	public static StringBuffer getSQL4_Table_Questionnaireconfiguration(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_questionnaireconfiguration);
		sql.append(dataline[1]);
		sql.append(sql_separator);		
		sql.append(dataline[2]);		
		sql.append(sql_separator);		
		sql.append(dataline[3]);		
		sql.append(sql_separator);		
		sql.append(dataline[4]);	
		sql.append(sql_separator);		
		sql.append(dataline[5]);	
		sql.append(sql_separator);		
		sql.append(dataline[6]);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Questionnaire(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_questionnaire);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[4].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[5].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[6].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[7].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(dataline[8]);
		sql.append(sql_separator);
		sql.append(dataline[9]);
		sql.append(sql_separator);
		sql.append(dataline[10]);
		sql.append(sql_separator);
		sql.append(dataline[11]);
		sql.append(sql_separator);
		sql.append(dataline[12]);
		sql.append(sql_separator);
		sql.append(dataline[13]);
		sql.append(sql_separator);
		sql.append(dataline[14]);
		sql.append(sql_separator);
		sql.append(dataline[15]);
		sql.append(sql_separator);
		sql.append(dataline[16]);
		sql.append(sql_separator);
		sql.append(dataline[17]);
		sql.append(sql_separator);
		sql.append(dataline[18]);
		sql.append(sql_separator);
		sql.append(dataline[19]);
		sql.append(sql_separator);
		sql.append(dataline[20]);
		sql.append(sql_separator);
		sql.append(dataline[21]);
		sql.append(sql_separator);
		sql.append(dataline[22]);		
		sql.append(sql_end);
		
		return sql;
	}
	public static StringBuffer getSQL4_Table_Formatquestionnaire(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_formatquestionnaire);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_separator);
		sql.append(dataline[4]);
		sql.append(sql_separator);
		sql.append(dataline[5]);
		sql.append(sql_separator);
		sql.append(dataline[6]);
		sql.append(sql_separator);
		sql.append(dataline[7]);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Questionnairesection(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_questionnairesection);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[4]);
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Questionnaireitem(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_questionnaireitem);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3].trim());
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);		
		sql.append(dataline[4].trim());
		sql.append(sql_quote);		
		sql.append(sql_separator);
		sql.append(dataline[5]);
		sql.append(sql_separator);
		sql.append(dataline[6]);
		sql.append(sql_separator);
		sql.append(dataline[7]);
		
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4_Table_Question(String[] dataline){
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_question);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_separator);
		sql.append(dataline[4]);
		sql.append(sql_separator);
		sql.append(dataline[5]);
		sql.append(sql_separator);
		sql.append(dataline[6]);		
		sql.append(sql_end);
		
		return sql;
	}	
	
}


