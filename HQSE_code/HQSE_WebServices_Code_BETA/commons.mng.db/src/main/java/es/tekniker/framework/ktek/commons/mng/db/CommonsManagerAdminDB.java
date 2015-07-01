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
import org.hibernate.criterion.Order;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.Ktek_userCriteria;
import es.tekniker.framework.ktek.Ktek_usersessiondata;
import es.tekniker.framework.ktek.Ktek_usersessiondataCriteria;
import es.tekniker.framework.ktek.dao.Ktek_userDAO;
import es.tekniker.framework.ktek.dao.Ktek_usersessiondataDAO;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekUserTokenEntity;
import es.tekniker.framework.ktek.exception.KtekExceptionCode;
import es.tekniker.framework.ktek.exception.KtekExceptionMessage;

public class CommonsManagerAdminDB {

	private static final Log log = LogFactory.getLog(CommonsManagerAdminDB.class);
	
	public Ktek_user createUserAllTable(KtekUserTokenEntity tokenEntity) throws Exception {
		Ktek_user objKtek_user = null;
		PersistentSession session = null;
		PersistentTransaction tr = null;
		boolean boolOK = false;  
		try{
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			tr = session.beginTransaction();
			
			objKtek_user = createUser(session, tokenEntity);
			
			if(objKtek_user != null){
				boolOK = createUserSession (session, objKtek_user, tokenEntity.getDataexpiration(), tokenEntity.getToken());
			}
			
			if(boolOK)
				tr.commit();
			else {
				tr.rollback();
				objKtek_user = null;
			}
		
			session.close();
		}catch (Exception e) {
			log.error(" createUser Exception " + e.getMessage());			
			e.printStackTrace();	
			objKtek_user = null;
			try {
				tr.rollback();
			} catch (PersistentException e2) {				
				try {
					if(session!=null)
						session.close();
				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			throw e;
		}	
		
		return objKtek_user;
	}
		
	
	private Ktek_user createUser(PersistentSession session, KtekUserTokenEntity tokenEntity) throws Exception {
		boolean boolOK=false;
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_userDAO instanceDAO = null;
		Ktek_user objKtek_user = null;
		long idUser=0;
		try
		{
		
			//idUser=getNextUserId(session);
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_userDAO();
			
			objKtek_user = new Ktek_user();
			objKtek_user.setKtek_uk_coduser(tokenEntity.getUser());
			//objKtek_user.setKtek_pk_iduser(idUser);
			session.save(objKtek_user);
			
			if(objKtek_user.getKtek_pk_iduser()>0)
				log.info(" createUser OK  user : " + tokenEntity.getUser() + "  id: " + objKtek_user.getKtek_pk_iduser());
			else
				log.error(" createUser ERROR " );
			
		}catch (Exception e) {
			log.error(" createUser Exception " + e.getMessage());
			e.printStackTrace();
			throw e;
		}	
		
		return objKtek_user;		
	}

	private long getNextUserId(PersistentSession session) {
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_userDAO instanceDAO = null;
		Ktek_user[] list = null;
		Ktek_userCriteria objKtek_userCriteria = null;
		long nextUserId=0;
		long last=0;
		try{
			log.debug(" getNextUserId START " );
			
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_userDAO();
			
			objKtek_userCriteria = new Ktek_userCriteria();
			objKtek_userCriteria.addOrder(Order.desc("ktek_pk_iduser"));
			
			list = instanceDAO.listKtek_userByCriteria(objKtek_userCriteria);
			if(list!=null)
				last=list[0].getKtek_pk_iduser();
			
			log.debug(" getNextUserId last userId " + last);
			
			nextUserId=last+1;
			
			log.debug(" getNextUserId next userId " + nextUserId);
			
		}catch (Exception e) {
			log.error(" getNextUserId Exception " + e.getMessage());			
			e.printStackTrace();
		}
		return nextUserId;
	}


	private boolean createUserSession(PersistentSession session, Ktek_user instanceUser, long dataexpiration, String token) throws Exception {
		boolean boolOK = false;
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory =  null;
		Ktek_usersessiondataDAO instanceDAO = null;
		Ktek_usersessiondata objKtek_usersessiondata = null; 
		try{
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();			
			instanceDAO = lDAOFactory.getKtek_usersessiondataDAO();
			
			objKtek_usersessiondata = new Ktek_usersessiondata();
			objKtek_usersessiondata.setKtek_fk_iduser(instanceUser);
			objKtek_usersessiondata.setDataexpiration(dataexpiration);
			objKtek_usersessiondata.setSessiontoken(token);
			
			session.save(objKtek_usersessiondata);
			
			if(objKtek_usersessiondata.getKtek_fk_iduser() != null){
				log.info(" createUserSession OK " + objKtek_usersessiondata.getKtek_fk_iduser());
				boolOK=true;
			}
			else
				log.error(" createUserSession ERROR " );
			
		}catch (Exception e) {
			log.error(" createUserSession Exception " + e.getMessage());			
			e.printStackTrace();
			throw e;
		}
		return boolOK;
	}	
	
	private Ktek_user getUserByCode(PersistentSession session , String code){
		Ktek_user objKtek_user= null;
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		Ktek_userDAO objUsersDAO = null;
		Ktek_userCriteria ktek_userCriteria = null;
		try {
		
			lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
			objUsersDAO = lDAOFactory.getKtek_userDAO();
			
			ktek_userCriteria= new Ktek_userCriteria();			
			ktek_userCriteria.ktek_uk_coduser.eq(code);			
			objKtek_user= objUsersDAO.loadKtek_userByCriteria(ktek_userCriteria);
			
			if (objKtek_user!=null)
		 		log.debug("getUserByCode " + objKtek_user.getORMID() + " " +  code);
		 	else
		 		log.error("getUserByCode User " + code +" does not exists");
		
		}catch (Exception e) {
			log.error("getUserByCode Exception " + e.getMessage());
			e.printStackTrace();
		}		
		return objKtek_user;
	}
	
	public boolean deleteUserAllTables(String codUser) {
		boolean boolOK=false;
		
		PersistentSession session = null;
		PersistentTransaction tr = null;
		Ktek_user userInstance = null;
		Ktek_usersessiondata userSessionDataInstance = null;
		try{
			session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();			
			tr = session.beginTransaction();
			
			userInstance = getUserByCode(session,codUser);			
			if(userInstance == null){
				log.error("deleteUser : User does not exist ");
				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				e.setFunction("CommonsMngServer.deleteUserAllTables");
				e.setParams(codUser);
				
				log.error(e.getFunction() + " " +e.getMessage() );			
				throw e;
			}
			
			userSessionDataInstance = userInstance.getKtek_usersessiondata();			
			if(userSessionDataInstance != null){
				boolOK = deleteUserSessionData(session,userSessionDataInstance);				
			}			
			else{
				log.debug(" deleteUser : There is no userSessionData for the user" );
				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_ERROR_DELETE_USER_SESSION_DATA);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_USER_ERROR_DELETE_USER_SESSION_DATA);
				e.setFunction("CommonsMngServer.deleteUserAllTables");
				e.setParams(codUser);
				
				log.error(e.getFunction() + " " +e.getMessage() );			
				throw e;
			}

			if(boolOK==false){
				log.debug(" deleteUser Error deleting userSessionData " );
			}
			
			if (boolOK)
				boolOK = deleteUser(session,userInstance);
			
			if(boolOK==false){
				log.debug(" deleteUser Error deleting user " );
				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_ERROR_DELETE_USER);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_USER_ERROR_DELETE_USER);
				e.setFunction("CommonsMngServer.deleteUserAllTables");
				e.setParams(codUser);
				
				log.error(e.getFunction() + " " +e.getMessage() );			
				throw e;
			}
						
			if (boolOK)
				tr.commit();
			else 
				tr.rollback();
			
			session.close();
			
		}catch (Exception e) {
			log.error(" deleteUser Exception " + e.getMessage());			
			e.printStackTrace();
			try {
				tr.rollback();
				if(session!=null)
					session.close();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		
		return boolOK;
	}
	
	private boolean deleteUser(PersistentSession session, Ktek_user user) {
		boolean boolOK=false;
		
		try{
						
			session.delete(user);
			boolOK =  true;
			
		}catch (Exception e) {
			log.error(" deleteUser Exception " + e.getMessage());			
			e.printStackTrace();
		}	
		
		return boolOK;
	}
	
	private boolean deleteUserSessionData(PersistentSession session , Ktek_usersessiondata usersessiondata) {
		boolean boolOK=false;
		
		try{
		
			session.delete(usersessiondata);			
			boolOK=true;
			
		}catch (Exception e) {
			log.error(" deleteUserSessionData Exception " + e.getMessage());			
			e.printStackTrace();
		}	
		
		return boolOK;
	}	
	
	private Ktek_usersessiondata getUserSessionDataByIdUser(PersistentSession session, int idUser) throws PersistentException{
		
		es.tekniker.framework.ktek.commons.DAOFactory lDAOFactory = null;
		Ktek_usersessiondataDAO objKtek_usersessiondataDAO = null;
		Ktek_usersessiondataCriteria objKtek_usersessiondataCriteria = null;
		Ktek_usersessiondata objKtek_usersessiondata = null;

		lDAOFactory = es.tekniker.framework.ktek.commons.DAOFactory.getDAOFactory();
		objKtek_usersessiondataDAO=lDAOFactory.getKtek_usersessiondataDAO();
					
		objKtek_usersessiondataCriteria= new  Ktek_usersessiondataCriteria();
		objKtek_usersessiondataCriteria.createKtek_fk_iduserCriteria().ktek_pk_iduser.eq(idUser);
		
		objKtek_usersessiondata=objKtek_usersessiondataDAO.loadKtek_usersessiondataByCriteria(objKtek_usersessiondataCriteria);
		
		if(objKtek_usersessiondata!=null)
			log.debug("getUserSessionData instance not null");
		else
			log.debug("getUserSessionData instance is null");
			
		return objKtek_usersessiondata;
	}	

	
}
