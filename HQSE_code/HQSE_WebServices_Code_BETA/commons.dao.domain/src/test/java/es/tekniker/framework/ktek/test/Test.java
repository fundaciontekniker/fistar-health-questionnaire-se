package es.tekniker.framework.ktek.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;




public class Test {

	private static Log log =LogFactory.getLog(Test.class);
/*	
	static Ktek_language objLanguage = null; 
	static Ktek_pathology objPathology =null;
	static Ktek_faq objFaq =null;
	static Ktek_faqsection objFaqsection =null;
	static Ktek_faqitem objFaqitem =null;

	static Set<Ktek_faqsection> setFaqSection =null;	 	
	*/
	/*
	public static void main(String[] args) {
		
		//DropAllData();
		
		//readFile ("d:\\proyectos\\FI-STAR\\fistar.txt");
		
		getDataFaq();
		
		
	}
	*/
	/*
	@org.junit.Test	
	public void getDataFaq(){
		
		PersistentTransaction t=null;
		
		try {
			t = KTEKPersistentManager.instance().getSession().beginTransaction();		
		
			DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
		
			//FAQ
			Ktek_faqDAO objfaqDAO = lDAOFactory.getKtek_faqDAO();
			
			
			long ktek_pk_idfaq=8;
			
			Ktek_faq objFaq=objfaqDAO.getKtek_faqByORMID(ktek_pk_idfaq);			
			String sName = objFaq.getKtek_fk_idpathology().getKtek_uk_namepathology();
			
			System.out.println("Pathology name " + sName);
			
			System.out.println("faq NUM SECTIONS " + objFaq.getKtek_fk_idfaqsection().size());
				
			if (objFaq!=null)
	 			Assert.assertEquals(objFaq.getORMID(), ktek_pk_idfaq);
	 		else
	 			Assert.assertNull(objFaq);
			
			t.commit();
			
		}catch (Exception e) {
			try {
				t.rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	*/
	/*
	@org.junit.Test	
	public void getDataApplicationmodulesright(){
		
		PersistentTransaction t=null;
		
		try {
			t = KTEKPersistentManager.instance().getSession().beginTransaction();		
		
			DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
		
			
			Ktek_applicationmodulesrightDAO objApplicationmodulesrightDAO = lDAOFactory.getKtek_applicationmodulesrightDAO();
			
			short ktek_pk_role=1;
			
			Ktek_applicationmodulesright objApplicationmodulesright=objApplicationmodulesrightDAO.getKtek_applicationmodulesrightByORMID(ktek_pk_role);			
			
			if (objApplicationmodulesright!=null)
	 			Assert.assertEquals(objApplicationmodulesright.getORMID(), ktek_pk_role);
	 		else
	 			Assert.assertNull(objApplicationmodulesright);
			
			t.commit();
			
		}catch (Exception e) {
			try {
				t.rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	/*
	public static void DropAllData(){
		PersistentTransaction t=null;
		boolean boolOK= false;
		try {
			t = KTEKPersistentManager.instance().getSession().beginTransaction();		
		
			DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
								
			//FAQ
			Ktek_faqDAO objfaqDAO = lDAOFactory.getKtek_faqDAO();
			long ktek_pk_idfaq=8;
			
			Ktek_faq objfaqDelete;
			objfaqDelete= objfaqDAO.getKtek_faqByORMID(ktek_pk_idfaq);
			
			 boolOK=objfaqDAO.delete(objfaqDelete);
			if(boolOK)
				System.out.println("faq delete OK " );
			else
				System.out.println("faq delete  ERROR " );
			
			
			// PATHOLOGY
			Ktek_pathologyDAO objpathologyDAO = lDAOFactory.getKtek_pathologyDAO();
		
			long ktek_pk_idpathology=7;
			Ktek_pathology objktek_pathologyDelete;
		
			objktek_pathologyDelete = objpathologyDAO.getKtek_pathologyByORMID(ktek_pk_idpathology);
			
			// 
			// ERROR: update or delete on table "ktek_pathology" violates foreign key constraint "FKktek_faq352835" on table "ktek_faq"
			// SOLUTION: delete first faq
			 boolOK=objpathologyDAO.delete(objktek_pathologyDelete);
			 if(boolOK)
				System.out.println("pathology delete OK " );
			 else
				System.out.println("pathology delete  ERROR " );
				
						
			//boolean boolOK= objpathologyDAO.deleteAndDissociate(objktek_pathologyDelete);
			
			//if (boolOK)
			//	System.out.println("objpathologyDAO deleteAndDissociate OK " );
			//else
			//	System.out.println("objpathologyDAO deleteAndDissociate ERROR " );
			
			
			// NOTHING DO 
			//boolean boolOK= objpathologyDAO.evict(objktek_pathologyDelete);
			//if (boolOK)
			//	System.out.println("objpathologyDAO evict OK " );
			//else
			//	System.out.println("objpathologyDAO evict ERROR " );
			
			
			t.commit();
			
			
		}
		catch (Exception e) {
			try {
				t.rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
	}*/
	/*
	
	public static void readFile(String filename){
		
		BufferedReader br = null;
		String line = null;			
		StringBuilder sb = new StringBuilder();
		try {
		
			br = new BufferedReader(new FileReader(filename));
			line = br.readLine();
			
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	          
	            if(line!=null)
	            {
		            for (String retval: line.split(";")){		            	
		            	System.out.print(retval + "  ");
		            	
		            	if(retval.equals("KTEK_LANGUAGE")){		            	
		            		objLanguage= parseLanguage(line);
		            	}
		            	else if (retval.equals("KTEK_PATHOLOGY")){
		            		objPathology=parsePathology(line);
		            	}
		            	else if (retval.equals("KTEK_FAQ")){
		            		objFaq=parseFaq(line);
		            	}
		            	else if (retval.equals("KTEK_FAQ_SECTION")){
		            		objFaqsection=parseFaqSection(line);
		            	}
		            	else if (retval.equals("KTEK_FAQ_ITEM")){
		            		objFaqitem=parseFaqitem(line);
		            	}		            	
		            }
		            System.out.println();
	            }
	            line = br.readLine();
	        }
	        insertData2Database();
	        
	        
	        System.out.println("END readFile");
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public static boolean insertData2Database(){
		boolean boolOK=false;
		
		PersistentTransaction t=null;
		try {
			t = KTEKPersistentManager.instance().getSession().beginTransaction();		
		
			DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
			
			// KTEK_LANGUAGE
			Ktek_languageDAO lktekKtek_languageDAO = lDAOFactory.getKtek_languageDAO();			
			boolOK=lktekKtek_languageDAO.save(objLanguage);
			if(boolOK)
				System.out.println("LanguageId " +objLanguage.getKtek_pk_idlanguage());
			else 
				System.out.println("Language ERROR" );
			
			//KTEK_PATHOLOGY
			Ktek_pathologyDAO objPathologyDAO = lDAOFactory.getKtek_pathologyDAO();
			boolOK=objPathologyDAO.save(objPathology);
			if(boolOK){
				System.out.println("pathologyId " +objPathology.getKtek_pk_idpathology());
			}
			else 
				System.out.println("Pathology ERROR" );
			
			
			//KTEK_FAQsection
			Ktek_faqsectionDAO objFaqSectionDAO = lDAOFactory.getKtek_faqsectionDAO();
			
			boolOK=objFaqSectionDAO.save(objFaqsection);
			if(boolOK){
				System.out.println("faqsectionId " +objFaqsection.getKtek_pk_idfaqsection());
			}
			else 
				System.out.println("Faq section ERROR" );
			
			
			objFaq.setKtek_fk_idfaqsection(setFaqSection);
			
			//KTEK_FAQ
			Ktek_faqDAO objFaqDAO = lDAOFactory.getKtek_faqDAO();
			
			boolOK=objFaqDAO.save(objFaq);
			if(boolOK){
				System.out.println("faqId " +objFaq.getKtek_pk_idfaq());
			}
			else 
				System.out.println("Faq ERROR" );
			
			
			
			//KTEK_FAQitem
			Ktek_faqitemDAO objFaqItemDAO = lDAOFactory.getKtek_faqitemDAO();
			boolOK=objFaqItemDAO.save(objFaqitem);
			if(boolOK){
				System.out.println("faq item Id " +objFaqitem.getKtek_pk_idfaqitem());
			}
			else 
				System.out.println("Faq item ERROR" );
			
			
			
			t.commit();
			
			boolOK=true;
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			try {
				t.rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		return boolOK;
	}
	*/
	/*
	public static boolean setLanguage(String line)
	{	
		boolean boolOK=false;
		String codLanguage=null;
		String desLanguage=null;
		boolean defaultLanguage=false;
		
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		codLanguage=retval;
        	else if (index==2)
        		desLanguage=retval;
        	else if (index==3){
        		if (retval.equals("true"))
        			defaultLanguage=true;
        		else
        			defaultLanguage=false;
        	}
        	
        	index++;
        }

		System.out.println( "PARSED DATA " + codLanguage + " "+ desLanguage + " " + defaultLanguage);
		
			
		PersistentTransaction t=null;
		try {
			t = KTEKPersistentManager.instance().getSession().beginTransaction();		
		
			DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
			Ktek_languageDAO lktekKtek_languageDAO = lDAOFactory.getKtek_languageDAO();
			Ktek_language objLanguage = lktekKtek_languageDAO.createKtek_language();
						
			objLanguage.setKtek_uk_codlanguage(codLanguage);		
			objLanguage.setDeslanguage(desLanguage);
			objLanguage.setIsdefault(defaultLanguage);
			
			
			boolOK=lktekKtek_languageDAO.save(objLanguage);
			if(boolOK)
				System.out.println("LanguageId " +objLanguage.getKtek_pk_idlanguage());
			
			t.commit();
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			try {
				t.rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return boolOK;
	}
	
	public static Ktek_language parseLanguage(String line)
	{	
		String codLanguage=null;
		String desLanguage=null;
		boolean defaultLanguage=false;
		
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		codLanguage=retval;
        	else if (index==2)
        		desLanguage=retval;
        	else if (index==3){
        		if (retval.equals("true"))
        			defaultLanguage=true;
        		else
        			defaultLanguage=false;
        	}
        	
        	index++;
        }

		System.out.println( "PARSED DATA " + codLanguage + " "+ desLanguage + " " + defaultLanguage);
		
		DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
		Ktek_languageDAO lktekKtek_languageDAO = lDAOFactory.getKtek_languageDAO();
		Ktek_language objLanguage = lktekKtek_languageDAO.createKtek_language();
						
		objLanguage.setKtek_uk_codlanguage(codLanguage);		
		objLanguage.setDeslanguage(desLanguage);
		objLanguage.setIsdefault(defaultLanguage);
		
		return objLanguage;
	}
	
	public static Ktek_pathology parsePathology(String line)
	{	
		String cod=null;
		String des=null;
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		cod=retval;
        	else if (index==2)
        		des=retval;
        	
        	index++;
        }

		System.out.println( "PARSED DATA " + cod+ " "+ des );
		
		DAOFactory lDAOFactory = DAOFactory.getDAOFactory();
		Ktek_pathologyDAO objPathologyDAO = lDAOFactory.getKtek_pathologyDAO();			
		objPathology = objPathologyDAO.createKtek_pathology();					
		
		objPathology.setKtek_uk_namepathology(cod);		
		objPathology.setDespathology(des);
		
		return objPathology;	
	}
	
	public static Ktek_faq parseFaq(String line)
	{	
		String cod=null;
		String des=null;
		
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		cod=retval;
        	else if (index==2)
        		des=retval;
        	
        	index++;
        }
		System.out.println( "PARSED DATA " + cod+ " "+ des );
		
		DAOFactory lDAOFactory = DAOFactory.getDAOFactory();			
		Ktek_faqDAO objfaqDAO = lDAOFactory.getKtek_faqDAO();
		Ktek_faq objFaq = objfaqDAO.createKtek_faq();
		objFaq.setCodfaq(cod);		
		objFaq.setDesfaq(des);			
		objFaq.setKtek_fk_idpathology(objPathology);
				
		return objFaq;
	}	
	
	public static Ktek_faqsection parseFaqSection(String line)
	{	
		String des=null;
		
		setFaqSection =new HashSet<Ktek_faqsection>() ;	 	
		
		
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		des=retval;
        	
        	index++;
        }
		System.out.println( "PARSED DATA " +  des );
		
		DAOFactory lDAOFactory = DAOFactory.getDAOFactory();			
		Ktek_faqsectionDAO objfaqsectionDAO = lDAOFactory.getKtek_faqsectionDAO();
		Ktek_faqsection objFaqSection = objfaqsectionDAO.createKtek_faqsection();
		objFaqSection.setKtek_uk_desfaqsection(des);
		
		setFaqSection.add(objFaqSection);
		
				
		return objFaqSection;
	}	
	
	public static Ktek_faqitem parseFaqitem(String line)
	{	
		String question=null;
		String answer=null;
		
		int index=0;
		
		//Parse data
		for (String retval: line.split(";")){
        	//System.out.print(retval + "  ");
        	
        	if(index==1)
        		question=retval;
        	else if (index==2)
        		answer=retval;
        	
        	index++;
        }
		System.out.println( "PARSED DATA " + question+ " "+ answer );
		
		DAOFactory lDAOFactory = DAOFactory.getDAOFactory();			
		Ktek_faqitemDAO objfaqitemDAO = lDAOFactory.getKtek_faqitemDAO();
		Ktek_faqitem objFaqitem = objfaqitemDAO.createKtek_faqitem();
		objFaqitem.setQuestionfaq(question);		
		objFaqitem.setAnswerfaq(answer);			
				
		return objFaqitem;
	}	
	*/
}


