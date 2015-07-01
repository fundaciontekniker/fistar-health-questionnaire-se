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
package es.tekniker.framework.ktek.commons.mng.db;

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

import es.tekniker.framework.ktek.commons.KTEKPersistentManager;

public class CommonsLoadFile {

	private static final Log log = LogFactory.getLog(CommonsLoadFile.class);
	
	
	private static String sql_end= ");";
	private static String sql_separator=",";
	private static String sql_quote="'";
	
	
	//COMMONS
	public static String TABLE_ktek_language= "ktek_language";
	public static String SQL_ktek_language = "INSERT INTO ktek_commons.ktek_language(ktek_pk_idlanguage, ktek_uk_codlanguage, deslanguage, isdefault) VALUES (";
	
	public static String TABLE_ktek_tpsettings= "ktek_tpsettings";
	public static String SQL_ktek_tpsettings = "INSERT INTO ktek_commons.ktek_tpsettings(ktek_fk_iduser, ktek_fk_idlanguage, typecomchannel) VALUES (";
										
	public static String TABLE_ktek_translation_text= "ktek_translation_text";
	public static String SQL_ktek_translation_text = "INSERT INTO ktek_commons.ktek_translation_text(ktek_pk_translation_text, ktek_idregister, ktek_keycolum, ktek_fk_language, ktek_columvalue) VALUES (";
		
	public static String TABLE_ktek_user= "ktek_user";
	public static String SQL_ktek_user= "INSERT INTO ktek_commons.ktek_user(ktek_pk_iduser, ktek_uk_coduser) VALUES (";
	
	public static String TABLE_ktek_user_ext= "ktek_user_ext";
	public static String SQL_ktek_user_ext= "INSERT INTO ktek_commons.ktek_user_ext(ktek_fk_iduser, ktek_uk_coduserid, email, mobile, keyuser, passworduser, name, surname) VALUES (";
	 																		 
	public static String TABLE_ktek_usersessiondata= "ktek_usersessiondata"; 
	public static String SQL_ktek_usersessiondata= "INSERT INTO ktek_commons.ktek_usersessiondata(ktek_fk_iduser, sessiontoken, dataexpiration) VALUES (";
	
	public static String TABLE_ktek_pathology= "ktek_pathology";
	public static String SQL_ktek_pathology= "INSERT INTO ktek_commons.ktek_pathology(ktek_pk_idpathology, ktek_uk_codpathology, namepathology,despathology) VALUES (";
	
	public static void main(String[] args) {		
		//Read FILE
		String filename="D:\\Proyectos\\FI-STAR\\code\\subversion\\trunk\\backend\\db\\dataloadCommons_QSE.csv";
		
		List<String> dataCommons = readFile (filename,false);	
		
		//LOAD data into DataBase
		loadData(dataCommons);
		
		
	}
		
	public static boolean loadData(List<String> data ){
		boolean boolOK=true;
				
		PersistentSession session = null;
		PersistentTransaction tr = null;
		Statement st;
		
		StringBuffer sql = null;
		String[] dataline = null;
		String tablename = null;
		boolean boolExec = false;
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
					if(tablename.equals(TABLE_ktek_language)){
						log.debug("language ");
						sql = getSQL4TABLE_LANGUAGE(dataline);
					}
					else if(tablename.equals(TABLE_ktek_tpsettings))
						sql = getSQL4TABLE_TPSETTINGS(dataline);
					else if(tablename.equals(TABLE_ktek_pathology))
						sql = getSQL4TABLE_PATHOLOGY(dataline);
					else if(tablename.equals(TABLE_ktek_translation_text))
						sql = getSQL4TABLE_TRANSLATION_TEXT(dataline);
					else if(tablename.equals(TABLE_ktek_user))
						sql = getSQL4TABLE_USER(dataline);
					else if(tablename.equals(TABLE_ktek_user_ext))
						sql = getSQL4TABLE_USER_EXT(dataline);
					else if(tablename.equals(TABLE_ktek_usersessiondata))
						sql = getSQL4TABLE_USERSESSIONDATA(dataline);
					else{
						log.debug("table name not found " +  dataline[0]);
					}
					
					//log.debug(sql);
					
					log.debug("i : "+ i + " SQL : "  + sql);
					if(sql!=null){
						boolExec= st.execute(sql.toString());
					
						log.debug(" executed " + boolExec);
					}
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				log.debug(" SQLException " + e.getMessage());
				e.printStackTrace();
				boolOK=false;
			}
			 
			//if(boolOK)	
				tr.commit();
			
			session.close();
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boolOK;
	}
	
	
	/*
	 * COMMONS
	 */
	
	public static StringBuffer getSQL4TABLE_TRANSLATION_TEXT(String[] dataline){
		//INSERT INTO ktek_translation_text VALUES (1, 1, 'namequestionnaire', 1, '�Qu� es el transtorno bipolar?');
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_translation_text);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(dataline[4]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[5]);
		sql.append(sql_quote);		
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4TABLE_PATHOLOGY(String[] dataline){
		//INSERT INTO ktek_pathology VALUES (1, 'P1', 'Trastorno Bipolar', 'Trastorno Bipolar');
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_pathology);
		sql.append(dataline[1]);
		sql.append(sql_separator);		
		sql.append(sql_quote);		
		sql.append(dataline[2]);
		sql.append(sql_quote);				
		sql.append(sql_separator);		
		sql.append(sql_quote);
		sql.append(dataline[3]);
		sql.append(sql_quote);		
		sql.append(sql_separator);		
		sql.append(sql_quote);
		sql.append(dataline[4]);
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4TABLE_USERSESSIONDATA(String[] dataline){
		//INSERT INTO ktek_usersessiondata VALUES (3, '0', 0);
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_usersessiondata);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4TABLE_USER(String[] dataline){
		//INSERT INTO ktek_user VALUES (1, 'User1');
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_user);
		sql.append(dataline[1]);		
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2]);
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4TABLE_USER_EXT(String[] dataline){
		//INSERT INTO ktek_user_ext VALUES (1, '33333001A', 'paciente1@gmail.com', '666666001', 'usr_paciente1', 'pass_paciente1');
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_user_ext);
		sql.append(dataline[1]);		
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[4]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[5]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[6]);
		sql.append(sql_quote);		
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[7]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[8]);
		sql.append(sql_quote);
		sql.append(sql_end);
		
		return sql;
	}
	
	public static StringBuffer getSQL4TABLE_TPSETTINGS(String[] dataline){
		//INSERT INTO ktek_tpsettings VALUES (1, 1, 2);
		StringBuffer sql = null;
		
		sql = new StringBuffer();
		sql.append(SQL_ktek_tpsettings);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(dataline[2]);
		sql.append(sql_separator);
		sql.append(dataline[3]);
		sql.append(sql_end);
		
		return sql;
	}
	
	
	public static StringBuffer getSQL4TABLE_LANGUAGE(String[] dataline){
		//INSERT INTO ktek_language VALUES (1, 'es', 'Espa�ol', true);
		StringBuffer sql = null;
				
		sql = new StringBuffer();
		sql.append(SQL_ktek_language);
		sql.append(dataline[1]);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[2]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(sql_quote);
		sql.append(dataline[3]);
		sql.append(sql_quote);
		sql.append(sql_separator);
		sql.append(dataline[4]);
		sql.append(sql_end);
		
		
		log.debug("getSQL4TABLE_LANGUAGE "+ sql);
		return sql;
	}
	
	public static List<String> readFile(String filename, boolean print)
	{
		List<String> data = new ArrayList<String>();
	  
		BufferedReader br = null;
		String line = null;			
		//StringBuilder sb = new StringBuilder();
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
	            //sb.append(line);
	            //sb.append(System.lineSeparator());
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
//	        String everything = sb.toString();
	        
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.debug("FileNotFoundException " + filename + " " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("IOException " + filename + " " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				log.debug("IOException closing StringBuilder " + filename + " " + e.getMessage());
			}
	    }
		
		return data;
		
	}
}
