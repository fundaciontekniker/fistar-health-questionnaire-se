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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import es.tekniker.framework.ktek.Ktek_auditaccesslog;
import es.tekniker.framework.ktek.Ktek_language;
import es.tekniker.framework.ktek.Ktek_languageCriteria;
import es.tekniker.framework.ktek.Ktek_tpsettings;
import es.tekniker.framework.ktek.Ktek_tpsettingsCriteria;
import es.tekniker.framework.ktek.Ktek_translation_text;
import es.tekniker.framework.ktek.Ktek_translation_textCriteria;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.Ktek_userCriteria;
import es.tekniker.framework.ktek.Ktek_user_ext;
import es.tekniker.framework.ktek.Ktek_user_extCriteria;
import es.tekniker.framework.ktek.Ktek_usersessiondata;
import es.tekniker.framework.ktek.Ktek_usersessiondataCriteria;
import es.tekniker.framework.ktek.dao.Ktek_languageDAO;
import es.tekniker.framework.ktek.dao.Ktek_tpsettingsDAO;
import es.tekniker.framework.ktek.dao.Ktek_translation_textDAO;
import es.tekniker.framework.ktek.dao.Ktek_userDAO;
import es.tekniker.framework.ktek.dao.Ktek_user_extDAO;
import es.tekniker.framework.ktek.dao.Ktek_usersessiondataDAO;
import es.tekniker.framework.ktek.defines.KtekLanguageType;

public class CommonsManagerDB {

	private static final Log log = LogFactory.getLog(CommonsManagerDB.class);
	
	public Ktek_language[] getLanguages(){
		Ktek_language[]  arrayInstance = null;		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null; 
		Ktek_languageDAO instanceDAO = null;
		PersistentSession session = null;
		
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_languageDAO();			
			arrayInstance=instanceDAO.listKtek_languageByQuery(null, null);
			
			session.close();

			if (arrayInstance!=null)
	 			log.debug("getLanguages : instance is not null");
	 		else
	 			log.error("getLanguages : instance is null");
			
		}catch (Exception e) {
			log.error("getLanguages: exception " + e.getMessage());
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return arrayInstance;
	}
	
	public String getText(String key, long id, int idlang){
		Ktek_translation_text  instance = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_translation_textDAO instanceDAO = null;
		Ktek_translation_textCriteria objKtek_translation_textCriteria = null;
		Ktek_languageCriteria objKtek_fk_languageCriteria = null;
		String strText="";
		PersistentSession session = null;
		
		try {
				
			if(this.isLanguageDefault(idlang)==false){			
				session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
				
				lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
				instanceDAO = lDAOFactory.getKtek_translation_textDAO();
				
				objKtek_translation_textCriteria = new Ktek_translation_textCriteria();
				objKtek_translation_textCriteria.ktek_keycolum.eq(key);
				objKtek_translation_textCriteria.ktek_idregister.eq(id);
				objKtek_fk_languageCriteria = objKtek_translation_textCriteria.createKtek_fk_languageCriteria();
				objKtek_fk_languageCriteria.ktek_pk_idlanguage.eq(idlang);
							
				instance=instanceDAO.loadKtek_translation_textByCriteria(objKtek_translation_textCriteria);
				
				session.close();
	
				if(instance!=null){
					log.debug("getText is not null " );
					strText=instance.getKtek_columvalue();
				}
		 		else
		 			log.info("getText is null for id: " + id + " key: " + key + " lang: " + idlang);
			}
		}catch (Exception e) {
			log.error("getText Exception " + e.getMessage());			
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return strText;
	}
	
	public Ktek_tpsettings getTpSettings(String token){
		Ktek_tpsettings instance=null;
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_tpsettingsDAO instanceDAO = null;
		Ktek_tpsettingsCriteria objKktek_tpsettingsCriteria = null;
		
		PersistentSession session = null;
		
		try {
			
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
	
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			
			instanceDAO = lDAOFactory.getKtek_tpsettingsDAO();
			
			objKktek_tpsettingsCriteria = new Ktek_tpsettingsCriteria();
			objKktek_tpsettingsCriteria.createKtek_fk_iduserCriteria().createKtek_usersessiondataCriteria().sessiontoken.eq(token);
						
			instance=instanceDAO.loadKtek_tpsettingsByCriteria(objKktek_tpsettingsCriteria);
			
			session.close();
			
		}catch (Exception e) {
			log.error("getTpSettings Exception " + e.getLocalizedMessage());
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return instance;
	}	

	public Ktek_usersessiondata getUserSessionDataByIdUser(int idUser){
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		Ktek_usersessiondataDAO objKtek_usersessiondataDAO = null;
		Ktek_usersessiondataCriteria objKtek_usersessiondataCriteria = null;
		Ktek_usersessiondata objKtek_usersessiondata = null;

		PersistentSession session = null;		
		
		try {
		
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
					
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			
			objKtek_usersessiondataDAO=lDAOFactory.getKtek_usersessiondataDAO();
						
			objKtek_usersessiondataCriteria= new  Ktek_usersessiondataCriteria();
			objKtek_usersessiondataCriteria.createKtek_fk_iduserCriteria().ktek_pk_iduser.eq(idUser);
			
			objKtek_usersessiondata=objKtek_usersessiondataDAO.loadKtek_usersessiondataByCriteria(objKtek_usersessiondataCriteria);
			
			session.close();
			
			if(objKtek_usersessiondata!=null)
				log.debug("getUserSessionData instance not null");
			else
				log.debug("getUserSessionData instance is null");
						
			
		}catch (Exception e) {
			log.debug("getUserSessionData Exception " + e.getMessage());
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return objKtek_usersessiondata;
		
	}

	public Ktek_user getUser(int idUser){
		Ktek_user objKtek_user= null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		Ktek_userDAO objUsersDAO = null;
		PersistentSession session = null;
		
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			

			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();		
			
			objUsersDAO = lDAOFactory.getKtek_userDAO();			
			objKtek_user= objUsersDAO.getKtek_userByORMID(idUser);
			
			session.close();

			if (objKtek_user!=null)
		 		log.debug(" getUser " + objKtek_user.getORMID() + " " +  idUser);
		 	else
		 		log.error("getUser User " + idUser +" does not exists");
			
		}catch (Exception e) {
			log.error("getUser User Exception " + e.getMessage() );
			e.printStackTrace();		
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return objKtek_user;
	}	

	public Ktek_user getUserByCode(String code){
		Ktek_user objKtek_user= null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		PersistentSession session = null;
		Ktek_userDAO objUsersDAO = null;
		Ktek_userCriteria ktek_userCriteria = null;
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			objUsersDAO = lDAOFactory.getKtek_userDAO();
			
			ktek_userCriteria= new Ktek_userCriteria();			
			ktek_userCriteria.ktek_uk_coduser.eq(code);			
			objKtek_user= objUsersDAO.loadKtek_userByCriteria(ktek_userCriteria);
							
			session.close();
			
			if (objKtek_user!=null)
		 		log.debug("getUserByCode " + objKtek_user.getORMID() + " " +  code);
		 	else
		 		log.error("getUserByCode User " + code +" does not exists");
		
		}catch (Exception e) {
			log.error("getUserByCode Exception " + e.getMessage());
			e.printStackTrace();			
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return objKtek_user;
	}
	
	public Ktek_user_ext getUserExtByCodUserId(String reference){
		Ktek_user_ext objKtek_user_ext = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		PersistentSession session = null;
		Ktek_user_extDAO objUsersExtDAO = null;
		Ktek_user_extCriteria objKtek_user_extCriteria;
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			objUsersExtDAO = lDAOFactory.getKtek_user_extDAO();
			
			objKtek_user_extCriteria = new Ktek_user_extCriteria();
			objKtek_user_extCriteria .ktek_uk_coduserid.eq(reference);
						
			objKtek_user_ext = objUsersExtDAO.loadKtek_user_extByCriteria(objKtek_user_extCriteria);
							
			session.close();
			
			if (objKtek_user_ext!=null)
		 		log.debug("getUserByReference " + objKtek_user_ext.getORMID() + " " +  reference);
		 	else
		 		log.error("getUserByReference User " + reference +" does not exists");
		
		}catch (Exception e) {
			log.error("getUserByReference Exception " + e.getMessage());
			e.printStackTrace();			
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return objKtek_user_ext;
	}
	
			
	public Ktek_user_ext getUserExtByKey(String key){
		Ktek_user_ext objKtek_user_ext = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		PersistentSession session = null;
		Ktek_user_extDAO objUsersExtDAO = null;
		Ktek_user_extCriteria objKtek_user_extCriteria;
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			objUsersExtDAO = lDAOFactory.getKtek_user_extDAO();
			
			objKtek_user_extCriteria = new Ktek_user_extCriteria();
			objKtek_user_extCriteria.keyuser.eq(key);
						
			objKtek_user_ext = objUsersExtDAO.loadKtek_user_extByCriteria(objKtek_user_extCriteria);
							
			session.close();
			
			if (objKtek_user_ext!=null)
		 		log.debug("getUserByReference " + objKtek_user_ext.getORMID() + " " +  key);
		 	else
		 		log.error("getUserByReference User " + key +" does not exists");
		
		}catch (Exception e) {
			log.error("getUserByReference Exception " + e.getMessage());
			e.printStackTrace();			
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return objKtek_user_ext;
	}
			
	
	public boolean saveUserSessionData(int idUser, String token, long dataexpiration){		
		boolean boolOK=false;
		PersistentTransaction t=null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
				
		Ktek_userDAO objKtek_userDAO = null;
		Ktek_user objKtek_user = null;
		
		log.debug("saveUserSessionData BEFORE SAVE objUsersessiondataDAO data " + idUser + " " + token + " "  + dataexpiration);
		PersistentSession session = null;
		
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			

			t = session.beginTransaction();		
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			objKtek_userDAO = lDAOFactory.getKtek_userDAO();			
			
			objKtek_user= objKtek_userDAO.getKtek_userByORMID(idUser);
			
			objKtek_user.getKtek_usersessiondata().setSessiontoken(token);
			objKtek_user.getKtek_usersessiondata().setDataexpiration(dataexpiration);
						
			boolOK=objKtek_userDAO.save(objKtek_user);
			
			t.commit();
			session.close();
			
			log.debug("saveUserSessionData OK");
		}catch (Exception e) {
			try {
				boolOK=false;
				log.error("saveUserSessionData Exception " + e.getMessage());
				e.printStackTrace();
				t.rollback();
				
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				log.error("saveUserSessionData PersistentException " + e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (boolOK)
	 		log.debug("saveUserSessionData saved OK");
	 	else
	 		log.error("saveUserSessionData ERROR saving ");
		
		return boolOK;
	}
	
	public int getUserId4Token(String token){
		int idUser=0;
		Ktek_usersessiondata instance = null;
		
		instance = getUserSessionData(token);
		if(instance !=null)			
			idUser=instance.getKtek_fk_iduserId();
		
		return idUser;
	}
	
	public String getToken4IdUser(int idUser){
		String token = null;
		
		Ktek_usersessiondata instance = null;
		
		instance = getUserSessionDataByIdUser(idUser);
		if(instance !=null)	
			token=instance.getSessiontoken();
				
		return token;		
	}
	
	public Ktek_usersessiondata getUserSessionData(String token){
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		Ktek_usersessiondataDAO objKtek_usersessiondataDAO = null;
		Ktek_usersessiondataCriteria objKtek_usersessiondataCriteria = null;
		Ktek_usersessiondata objKtek_usersessiondata = null;

		PersistentSession session = null;
				
		try {
		
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
					
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			
			objKtek_usersessiondataDAO=lDAOFactory.getKtek_usersessiondataDAO();
						
			objKtek_usersessiondataCriteria= new  Ktek_usersessiondataCriteria();
			objKtek_usersessiondataCriteria.sessiontoken.eq(token);
			
			objKtek_usersessiondata=objKtek_usersessiondataDAO.loadKtek_usersessiondataByCriteria(objKtek_usersessiondataCriteria);
			
			session.close();
			
			if(objKtek_usersessiondata!=null)
				log.debug("getUserSessionData instance not null");
			else
				log.debug("getUserSessionData instance is null");
						
			
		}catch (Exception e) {
			log.debug("getUserSessionData Exception " + e.getMessage());
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return objKtek_usersessiondata;		
	}
	
	
	
	public Ktek_user getUser4Token(String token){
		Ktek_user instance=null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_userDAO objDAO = null;
		PersistentSession session = null;
		Ktek_userCriteria objKtek_userCriteria = null;
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();		
			objDAO = lDAOFactory.getKtek_userDAO();
			
			objKtek_userCriteria= new Ktek_userCriteria();
			objKtek_userCriteria.createKtek_usersessiondataCriteria().sessiontoken.eq(token);
						
			instance=objDAO.loadKtek_userByCriteria(objKtek_userCriteria);
			
			session.close();
			
			if (instance!=null){
		 		log.debug(" getUser4Token is not null " );		 		
			}
		 	else
		 		log.error(" getUser4Token is null ");
						
		}catch (Exception e) {
			log.error(" getUser4Token Exception " + e.getMessage());			
			e.printStackTrace();		
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
			
		return instance;
	}

	public Ktek_user_ext getUserExtById(int iduser) {
		Ktek_user_ext instance = null;
		
		PersistentSession session = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_user_extDAO instanceDAO = null;
		Ktek_user_extCriteria objKtek_user_extCriteria  = null;
		
		try{
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_user_extDAO();
			
			objKtek_user_extCriteria = new Ktek_user_extCriteria();
			objKtek_user_extCriteria.createKtek_fk_iduserCriteria().ktek_pk_iduser.eq(iduser);			
			instance= instanceDAO.loadKtek_user_extByCriteria(objKtek_user_extCriteria);
			
			session.close();
			
			if (instance!=null){
		 		log.debug(" getUserExtById is not null " );		 		
			}
		 	else
		 		log.error(" getUserExtById is null " );
			
		}catch (Exception e) {
			log.error(" getUserExtById Exception " + e.getMessage());			
			e.printStackTrace();		
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		return instance;
	}
	
	public Ktek_usersessiondata[] getUserTokenList() {
		PersistentSession session = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_usersessiondataDAO instanceDAO = null;
		Ktek_usersessiondata[] instanceArray = null;
		try
		{
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			instanceDAO = lDAOFactory.getKtek_usersessiondataDAO();
			
			instanceArray = instanceDAO.listKtek_usersessiondataByQuery(null, null);
			
			session.close();
			
		}catch (Exception e) {
			log.error(" getUserTokenList Exception " + e.getMessage());			
			e.printStackTrace();		
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		return instanceArray;	
	}
	
	public boolean setTPsettings(int iduser, int idlanguage,short typecomchannel,String email, String mobile) {
		boolean boolOK = false;
		
		Ktek_tpsettings objKtek_tpsettings = null;
		Ktek_user_ext objKtek_user_ext = null;
		Ktek_language language = null;
		Ktek_user user = null;
		PersistentSession session = null;
		PersistentTransaction t = null;
		try {
			
			language = this.getLanguage(idlanguage);			
			user = this.getUser(iduser);
			
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			t = session.beginTransaction();
			
			//tpsettings
			
			objKtek_tpsettings = new Ktek_tpsettings();
			objKtek_tpsettings.setTypecomchannel(typecomchannel);
			objKtek_tpsettings.setKtek_fk_iduser(user);
			
			objKtek_tpsettings.setKtek_fk_iduserId(iduser);			
			objKtek_tpsettings.setKtek_fk_idlanguage(language);			
			user.setKtek_tpsettings(objKtek_tpsettings);			
			
			session.update(objKtek_tpsettings);
			
			
			//userext
			
			objKtek_user_ext = user.getKtek_user_ext();
			objKtek_user_ext.setMobile(mobile);
			objKtek_user_ext.setEmail(email);
			
			session.update(objKtek_user_ext);
			
			t.commit();
			
			
			session.close();
						
			boolOK =  true;
		}catch (Exception e) {
			log.error("setTPsettings Exception " + e.getLocalizedMessage());
			e.printStackTrace();
			try {
				
				t.rollback();
				
				if(session!=null){
					session.close();
				}
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		
		return boolOK;
	}

	public boolean setUserExt(int iduser, String email, String mobile) {
		boolean boolOK = false;
		
		Ktek_user_ext objKtek_user_ext = null;
		PersistentSession session = null;
		PersistentTransaction t = null;
		try {
			
			objKtek_user_ext = this.getUserExtById(iduser);
			
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			t = session.beginTransaction();
			
			//userext
			
			objKtek_user_ext.setMobile(mobile);
			objKtek_user_ext.setEmail(email);
			
			session.update(objKtek_user_ext);
			
			t.commit();
			
			session.close();
						
			boolOK =  true;
		}catch (Exception e) {
			log.error("setTPsettings Exception " + e.getLocalizedMessage());
			e.printStackTrace();
			try {
				if(session!=null){
					t.rollback();
					session.close();
				}
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		
		return boolOK;
	}

	private boolean isLanguageDefault(int idlanguage){
		boolean boolOK=false;
		
		Ktek_language lang = getLanguage (idlanguage);
		
		if(lang !=null ){
			if(lang.getIsdefault()==KtekLanguageType.LANGUAGE_DEFAULT)
				boolOK=true;
		}
		
		return boolOK;
	}
	
	private Ktek_language getLanguage(int idlanguage) {
		Ktek_language  instance = null;		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null; 
		Ktek_languageDAO instanceDAO = null;
		PersistentSession session = null;
		
		try {
				
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_languageDAO();			
			instance=instanceDAO.getKtek_languageByORMID(idlanguage);
			
			session.close();

			if (instance!=null)
	 			log.debug("getLanguage : instance is not null");
	 		else
	 			log.error("getLanguage : instance is null");
			
		}catch (Exception e) {
			log.error("getLanguage: exception " + e.getMessage());
			e.printStackTrace();	
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return instance;
	}

	public Ktek_user_ext getUserExtByKeyUser(String keyUser) {
		Ktek_user_ext instance = null;
		
		PersistentSession session = null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_user_extDAO instanceDAO = null;
		Ktek_user_extCriteria objKtek_user_extCriteria  = null;
		
		try{
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_user_extDAO();
			
			objKtek_user_extCriteria = new Ktek_user_extCriteria();
			objKtek_user_extCriteria.keyuser.eq(keyUser);			
			instance= instanceDAO.loadKtek_user_extByCriteria(objKtek_user_extCriteria);
			
			session.close();
			
			if (instance!=null){
		 		log.debug(" getUserExtByKeyUser is not null " );		 		
			}
		 	else
		 		log.error(" getUserExtByKeyUser is null " );
			
		}catch (Exception e) {
			log.error(" getUserExtByKeyUser Exception " + e.getMessage());			
			e.printStackTrace();		
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		return instance;		
	}

	public boolean insertAuditAccessLog(int idAccessUser , int idAccessedUser,  String codTelecareProgram, short typeaction, int idaction, long logitemcreation){
		boolean boolOK = false;
		
		PersistentSession session = null;
		Ktek_auditaccesslog instance = null;
		
		Ktek_user instanceAccessUser = null;
		Ktek_user instanceAccessedUser = null;
		
		PersistentTransaction tr = null;
		try{
			
			if(idAccessUser  >0){
				
				instanceAccessUser = this.getUser(idAccessUser);
				instanceAccessedUser = this.getUser(idAccessedUser);
							
				session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
				tr = session .beginTransaction();
				
				instance = new Ktek_auditaccesslog();
				
				instance.setIdaccessuser(instanceAccessUser);
				instance.setIdaccesseduser(instanceAccessedUser);
				instance.setCodtelecareprogram(codTelecareProgram);
				instance.setIdaction(idaction);
				instance.setTypeaction(typeaction);
				instance.setLogitemcreation(logitemcreation);
				
				session.save(instance);
				
				tr.commit();
				
				session.close();
				
				boolOK = true;
			}else{
				log.error("insertAuditAccessLog idAccessUserProgram is not defined");
			}
			
		}catch (Exception e) {
			log.error("insertAuditAccessLog Exception " + e.getMessage());
			e.printStackTrace();
			try {
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return boolOK;
	}
	
}
