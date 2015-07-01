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

import es.tekniker.framework.ktek.Ktek_language;
import es.tekniker.framework.ktek.Ktek_tpsettings;
import es.tekniker.framework.ktek.commons.KTEKPersistentManager;

public class CommonsAdminold {


	private static final Log log = LogFactory.getLog(CommonsAdminold.class);
	
	public static String TABLE_ktek_applicationmodule= "ktek_applicationmodule";
	public static String TABLE_ktek_language= "ktek_language";
	public static String TABLE_ktek_tpsettings= "ktek_tpsettings";
	public static String TABLE_ktek_translation_text= "ktek_translation_text";
	public static String TABLE_ktek_user= "ktek_user";
	public static String TABLE_ktek_user_ext= "ktek_user_ext";
	public static String TABLE_ktek_usersessiondata= "ktek_usersessiondata";
	
	
	
	public static void main(String[] args) {		
		//Read FILE
		List<String> data = readFile ("d:\\proyectos\\FI-STAR\\dataloadCommons.csv",false);	
		
		//LOAD data into DataBase
		loadData(data);
		
	}
	
	public static boolean loadData(List<String> data ){
		boolean boolOK=false;
				
		PersistentSession session = null;
		PersistentTransaction tr = null;
		Statement st;
		
		StringBuffer sql = null;
		String[] dataline = null;
		Ktek_language language= null;
		
		try {
			session = KTEKPersistentManager.instance().getSession();
			tr = session.beginTransaction();
			
				for(int i=0; i<data.size();i++){
					
					dataline = data.get(i).split(";"); 
				/*
					if(dataline[0].equals(TABLE_ktek_language)){
						language = GetLanguageInstance(dataline);
						session.save(language);
					}
					else if(dataline[0].equals(TABLE_ktek_tpsettings)){
						tpsettings = GetTpsettingsInstance(dataline);
						session.save(tpsettings);
					}
					else if(dataline[0].equals(TABLE_ktek_translation_text)){
						translationtext = GetTranslationtextInstance(dataline);
						session.save(translationtext);
					}
					else if(dataline[0].equals(TABLE_ktek_user)){
						user = GetUserInstance(dataline);
						session.save(user);
					}
					else if(dataline[0].equals(TABLE_ktek_user_ext)){
						userext = GetUserExtInstance(dataline);
						session.save(userext);
					}
					else if(dataline[0].equals(TABLE_ktek_usersessiondata)){
						usersessiondata = GetUsersessiondataInstance(dataline);					
						session.save(usersessiondata);
					}
					*/					
					log.debug(sql);
					
					
				}	
			
			 
			if(boolOK)	
				tr.commit();
			
			session.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boolOK;
	}
	
	public static Ktek_language GetLanguageInstance(String[] dataline){
		
		String val1=null;
		String val2=null;
		String val3=null;
		String val4=null;
		String val5=null;
	
		short languagedefault = 0;
		
		val1=dataline[0];
		val2=dataline[1];
		val3=dataline[2];
		val4=dataline[3];
		val5=dataline[4];
		
		Ktek_language instance = new Ktek_language ();
		
		instance.setKtek_pk_idlanguage(Integer.valueOf(val2));
		instance.setKtek_uk_codlanguage(val3);
		instance.setDeslanguage(val4);
		if(Boolean.valueOf(val5))
			languagedefault=1;
		instance.setIsdefault(languagedefault);
		
		return instance;
	}
	
	
	
	public static List<String> readFile(String filename, boolean print)
	{
		List<String> data = new ArrayList<String>();
	  
		BufferedReader br = null;
		String line = null;			
		StringBuilder sb = new StringBuilder();
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
	            sb.append(line);
	            sb.append(System.lineSeparator());
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
	
}
