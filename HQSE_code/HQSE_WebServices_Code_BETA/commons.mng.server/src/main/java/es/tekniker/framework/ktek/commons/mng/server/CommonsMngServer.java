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
package es.tekniker.framework.ktek.commons.mng.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.tekniker.framework.ktek.Ktek_language;
import es.tekniker.framework.ktek.Ktek_tpsettings;
import es.tekniker.framework.ktek.Ktek_user;
import es.tekniker.framework.ktek.Ktek_user_ext;
import es.tekniker.framework.ktek.Ktek_usersessiondata;
import es.tekniker.framework.ktek.commons.config.ConfigFile;
import es.tekniker.framework.ktek.commons.config.ExceptionTextFile;
import es.tekniker.framework.ktek.commons.mng.db.CommonsLoadFile;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerAdminDB;
import es.tekniker.framework.ktek.commons.mng.db.CommonsManagerDB;
import es.tekniker.framework.ktek.defines.KtekDefines;
import es.tekniker.framework.ktek.entity.KtekExceptionEntity;
import es.tekniker.framework.ktek.entity.KtekLanguageEntity;
import es.tekniker.framework.ktek.entity.KtekLoginBasicEntity;
import es.tekniker.framework.ktek.entity.KtekLoginEntity;
import es.tekniker.framework.ktek.entity.KtekUserTokenEntity;
import es.tekniker.framework.ktek.entity.KtekTpsettingsEntity;
import es.tekniker.framework.ktek.entity.KtekUserEntity;
import es.tekniker.framework.ktek.exception.KtekExceptionCode;
import es.tekniker.framework.ktek.exception.KtekExceptionMessage;
import es.tekniker.framework.ktek.util.Utils;

public class CommonsMngServer {
	
	private static Log log =
	    LogFactory.getLog(es.tekniker.framework.ktek.commons.mng.server.CommonsMngServer.class);
	
	public String authenticationMode="INTERNAL";
	public long authenticationTimeout=300000;
	
	public ExceptionTextFile exceptionTextFile;  
	
	public CommonsMngServer() {
		
		ConfigFile configFile;
		try {
			configFile = new ConfigFile("config.properties");
			authenticationMode = configFile.getStringParam("authentication.mode");
			authenticationTimeout = configFile.getLongParam("authentication.timeout");
			
			// maybe more parameters will be used
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error("config.properties file not found. Setting default values", e);
		}
		
		try {
			exceptionTextFile= new ExceptionTextFile("messages.properties");
			
			if(exceptionTextFile==null){
				log.error("messages.properties file Parser is null");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error("messages.properties file not found. Setting default values", e);
		}
		
	}
	
	public String getExceptionText(String key){
		String text=null;
		
		if(exceptionTextFile !=null)
			text = exceptionTextFile.getStringParam(key);
		else 
			text=key;
		
		return text;
	}
		
	public KtekLanguageEntity[] getLanguages() throws KtekExceptionEntity {		
		KtekLanguageEntity[]  arrayInstanceEntity=null;
		Ktek_language[]  arrayInstance=null;
		CommonsManagerDB db = null;
			
		db = new CommonsManagerDB();	
		arrayInstance=db.getLanguages();

		if (arrayInstance!=null)
			arrayInstanceEntity=BO2Entity.KtekLanguageBO2Entity(arrayInstance);
		else
			log.error("getLanguages arrayInstance is null ");
	
		return arrayInstanceEntity;
	}

	public boolean isTokenValid(String token) throws KtekExceptionEntity{
		boolean boolOK=false;
		Ktek_usersessiondata userdatasession = null;
		long nowtime=0;
		boolean boolParameterOK=false;
		CommonsManagerDB manager = new CommonsManagerDB(); 
		boolParameterOK = ValidateParameter.validateParameterString(token, 
																	KtekExceptionMessage.EXCEPTION_CODE_TOKEN_VALUE_NO_DEFINED, 
																	KtekExceptionCode.EXCEPTION_CODE_TOKEN_VALUE_NO_DEFINED,
																	"CommonsMngServer.isTokenValid");
		if(boolParameterOK){		
			if(this.authenticationMode.equals(KtekDefines.AUTENTICATION_MODE_INTERNAL))
			{
				userdatasession = manager.getUserSessionData(token);
				
				if(userdatasession!=null){
					
					nowtime=new Date().getTime();
					
					if(nowtime<userdatasession.getDataexpiration()){
						boolOK=true;
					}			
					else {				
						log.error("isTokenValid FALSE : nowtime " + nowtime  + " userdataSession.Dataexpiration " + userdatasession.getDataexpiration() + " LOGIN timeOUT " +KtekDefines.LOGIN_SESSION_TIMEOUT );
						
						String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
						
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
						e.setMessage(exceptionText);
						e.setFunction("CommonsMngServer.isTokenValid");
						e.setParams(token);
						
						throw e;
					}
				}else{
		
					log.error("isTokenValid FALSE : userdataSession.Data IS NULL " );
					
					String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_TOKEN_NOT_VALID);
	
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_TOKEN_NOT_VALID);
					e.setMessage(exceptionText);
					e.setFunction("CommonsMngServer.isTokenValid");
					e.setParams(token);
					
					throw e;
				}		
			}else if(this.authenticationMode.equals(KtekDefines.AUTENTICATION_MODE_EXTERNAL)){
				String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_AUTENTICATION_MODE_EXTERNAL_NOT_IMPLEMENTED);
	
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_AUTENTICATION_MODE_EXTERNAL_NOT_IMPLEMENTED);
				e.setMessage(exceptionText);
				e.setFunction("CommonsMngServer.isTokenValid");
				e.setParams(token);
				
				throw e;
			}
		}
		
		return boolOK;
	}
	
	
	public KtekTpsettingsEntity getTpSettings(String token) throws KtekExceptionEntity{
		Ktek_tpsettings instanceDAO=null;
		KtekTpsettingsEntity instanceEntity=null;
		Ktek_user_ext userExt = null;
		
		CommonsManagerDB manager = new CommonsManagerDB();
		
		if(this.isTokenValid(token)==false){
			log.error("Token no valid ");
		    
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
			e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
			e.setFunction("CommonsMngServer.getApplicationmodulesright");
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;
			
		}else{
		
			instanceDAO=manager.getTpSettings(token);
			
			if(instanceDAO!=null){
				userExt = manager.getUserExtById(instanceDAO.getKtek_fk_iduserId());
			
				instanceEntity=BO2Entity.KtekTpsettingsBO2Entity(instanceDAO,userExt );
			}
			else 
				log.debug("getTpSettings instance is null" );
			
			if (instanceDAO!=null)
				log.debug("getTpSettings got  " + instanceDAO.getKtek_fk_iduserId());
			else 
				log.debug("getTpSettings does not exists");
		}
		return instanceEntity;
	}	
	
	private boolean saveUserSessionData(int idUserProgram, String token,long datacreation) throws KtekExceptionEntity{
		boolean boolOK=false;
		 
		String sFunction="UsersMngServer.saveUserSessionData";
				
		ValidateParameter.validateParameterLong(idUserProgram, 
				KtekExceptionMessage.EXCEPTION_CODE_USERPROGRAM_VALUE_NO_DEFINED, 
				KtekExceptionCode.EXCEPTION_CODE_USERPROGRAM_VALUE_NO_DEFINED,
				sFunction);
		
		
		CommonsManagerDB manager= new CommonsManagerDB();		
		boolOK=manager.saveUserSessionData(idUserProgram, token, datacreation);
		
		return boolOK;		
	}	
	
	public Ktek_user getUser(String code) throws KtekExceptionEntity{
		Ktek_user instanceDAO= null;
		String sFunction="UsersMngServer.getUser";
				
		ValidateParameter.validateParameterString(code, 
				KtekExceptionMessage.EXCEPTION_CODE_LOGIN_USER_VALUE_NO_DEFINED, 
				KtekExceptionCode.EXCEPTION_CODE_LOGIN_USER_VALUE_NO_DEFINED,
				sFunction);
		
		CommonsManagerDB manager = new CommonsManagerDB();
		
		instanceDAO=manager.getUserByCode(code);
		
		if (instanceDAO!=null)
			log.debug("getUser got  " + instanceDAO.getKtek_pk_iduser());
		else 
			log.debug("getUser code " + code + " does not exists");
		
		return instanceDAO;		
	}	

	public Ktek_user_ext getUserExtByCodUserId(String reference) throws KtekExceptionEntity{
		Ktek_user_ext instance= null;
		String sFunction="UsersMngServer.getUserExtByCodUserId";
				
		ValidateParameter.validateParameterString(reference, 
				KtekExceptionMessage.EXCEPTION_CODE_LOGIN_USER_VALUE_NO_DEFINED, 
				KtekExceptionCode.EXCEPTION_CODE_LOGIN_USER_VALUE_NO_DEFINED,
				sFunction);
		
		CommonsManagerDB manager = new CommonsManagerDB();
		
		instance=manager.getUserExtByCodUserId(reference);
		
		if (instance!=null)
			log.debug("getUserExtByCodUserId got  " + instance.getKtek_fk_iduserId());
		else 
			log.debug("getUserExtByCodUserId code " + reference + " does not exists");
		
		return instance;		
	}	

	
	
	
	public Ktek_user_ext getUserExtByKey(String key) throws KtekExceptionEntity{
		Ktek_user_ext instance= null;
		
		CommonsManagerDB manager = new CommonsManagerDB();
		
		instance=manager.getUserExtByKey(key);
		
		if (instance!=null)
			log.debug("getUserExtByKey got  " + instance.getKtek_fk_iduserId());
		else 
			log.debug("getUserExtByKey code " + key + " does not exists");
		
		return instance;		
	}	
	
	public Ktek_user getUserByToken(String token) throws KtekExceptionEntity{
		Ktek_user instanceDAO= null;
			
		CommonsManagerDB manager = new CommonsManagerDB();
		
		instanceDAO=manager.getUser4Token(token);
		
		if (instanceDAO!=null)
			log.debug("getUserByToken got  " + instanceDAO.getKtek_pk_iduser());
		else 
			log.debug("getUserByToken token " + token + " does not exists");
		
		return instanceDAO;		
	}	
	
	public Ktek_user getUserByIdUser(int iduser) throws KtekExceptionEntity{
		Ktek_user instanceDAO= null;
			
		CommonsManagerDB manager = new CommonsManagerDB();
		
		instanceDAO=manager.getUser(iduser);
		
		if (instanceDAO!=null)
			log.debug("getUserByIdUser got  " + instanceDAO.getKtek_pk_iduser());
		else 
			log.debug("getUserByIdUser iduser " + iduser + " does not exists");
		
		return instanceDAO;		
	}	
	
	public KtekUserEntity loginProfessional(String name) throws KtekExceptionEntity {
	    KtekUserEntity instanceEntity=null;
	    Ktek_user_ext instanceUserExt = null;
	    Ktek_user instanceUser = null;
	    String token =null;
	    long creationdata=0,  expirationdata =0;
	    boolean boolOK=false;
		KtekTpsettingsEntity instanceTpsettings = null;	    
	    
		long tokenDataExpiration = 0;
				
		instanceUserExt = getUserExtByKey(name);
		
		//2- CHECK IF INSTANCE IS NOT NULL 
    	if(instanceUserExt!=null){
    		
    		instanceUser= instanceUserExt.getKtek_fk_iduser();
    		
    		//GET ACTUAL EXPIRATION DATE FOR TOKEN
    		tokenDataExpiration = instanceUser.getKtek_usersessiondata().getDataexpiration();

    		creationdata= new Date().getTime();
    		expirationdata = creationdata + KtekDefines.LOGIN_SESSION_TIMEOUT;

    		instanceEntity= new KtekUserEntity();
			
    		if (tokenDataExpiration <creationdata){
    			//GENERATE TOKEN 
    			token = instanceEntity.generateToken();
    			//SAVE TOKEN IN DATABASE
	    		boolOK=saveUserSessionData(instanceUser.getKtek_pk_iduser(), token, expirationdata);
	    
    		}else{
    			token= instanceUser.getKtek_usersessiondata().getSessiontoken();
    			instanceEntity.setToken(token);
    			boolOK=true;
    		}
    		
    		instanceEntity.setName(instanceUser.getKtek_user_ext().getName());
    		instanceEntity.setSurname(instanceUser.getKtek_user_ext().getSurname());
    			    		
    		instanceEntity.setIduser(instanceUser.getKtek_pk_iduser());
    		if(instanceUser.getKtek_user_ext()!=null)
    			instanceEntity.setCode(instanceUser.getKtek_uk_coduser());
    		
    		if(boolOK==false){
    			log.error("ERROR saving datausersession");
			    
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
				e.setFunction("CommonsMngServer.login");
				e.setParams(name);
				
				log.error(e.getFunction() + " " +e.getMessage() );			
				throw e;
    		}else{
    			
    			instanceTpsettings = getTpSettings(token);
	    		if(instanceTpsettings ==null)
	    		{
	    			log.error("ERROR gettings settings");
				    
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
					e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
					e.setFunction("CommonsMngServer.login");
					e.setParams(name);
					
					log.error(e.getFunction() + " " +e.getMessage() );			
					throw e;
	    		}
	    		
	    		if(instanceTpsettings!=null){
	    			instanceEntity.setIdlanguage(instanceTpsettings.getIdlanguage());
	    			instanceEntity.setTypecomchannel(instanceTpsettings.getTypecomchannel());
	    		}
    		}    			
    	}
    	else{
    		log.error("login does not exist value for login received as parameter");
		    
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
			e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
			e.setFunction("CommonsMngServer.login");
			e.setParams(name);
			
			log.error(e.getFunction() + " " +e.getMessage() );		
			throw e;	   
    	}	    	
		
		return instanceEntity;
	}
	
	public KtekUserEntity login(KtekLoginEntity login) throws KtekExceptionEntity { 
	    
	    KtekUserEntity instanceEntity=null;
	    Ktek_user_ext instanceUserExt = null;
	    Ktek_user instanceUser = null;
	    String token =null;
	    long creationdata=0,  expirationdata =0;
	    boolean boolOK=false;
		KtekTpsettingsEntity instanceTpsettings = null;	    
	    
		long tokenDataExpiration = 0;
		
	    //1- CHECK IF REQUIRED DATA IS DEFINED 
	    if(login.isRequiredDataDefined()){	
	    	
	    	instanceUserExt = getUserExtByCodUserId(login.getReference());
	    	
	    //2- CHECK IF INSTANCE IS NOT NULL 
	    	if(instanceUserExt!=null){
	    		
	    		instanceUser= instanceUserExt.getKtek_fk_iduser();
	    		
	    		//GET ACTUAL EXPIRATION DATE FOR TOKEN
	    		tokenDataExpiration = instanceUser.getKtek_usersessiondata().getDataexpiration();

	    		creationdata= new Date().getTime();
	    		expirationdata = creationdata + KtekDefines.LOGIN_SESSION_TIMEOUT;

	    		instanceEntity= new KtekUserEntity();
    			
	    		if (tokenDataExpiration <creationdata){
	    			//GENERATE TOKEN 
	    			token = instanceEntity.generateToken();
	    			//SAVE TOKEN IN DATABASE
		    		boolOK=saveUserSessionData(instanceUser.getKtek_pk_iduser(), token, expirationdata);
		    
	    		}else{
	    			token= instanceUser.getKtek_usersessiondata().getSessiontoken();
	    			instanceEntity.setToken(token);
	    			boolOK=true;
	    		}
	    		
	    		instanceEntity.setName(instanceUser.getKtek_user_ext().getName());
	    		instanceEntity.setSurname(instanceUser.getKtek_user_ext().getSurname());
	    			    		
	    		instanceEntity.setIduser(instanceUser.getKtek_pk_iduser());
	    		if(instanceUser.getKtek_user_ext()!=null)
	    			instanceEntity.setCode(instanceUser.getKtek_uk_coduser());
	    		
	    		if(boolOK==false){
	    			log.error("ERROR saving datausersession");
				    
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
					e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
					e.setFunction("CommonsMngServer.login");
					e.setParams(login.toString());
					
					log.error(e.getFunction() + " " +e.getMessage() );			
					throw e;
	    		}else{
	    			
	    			instanceTpsettings = getTpSettings(token);
		    		if(instanceTpsettings ==null)
		    		{
		    			log.error("ERROR gettings settings");
					    
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
						e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
						e.setFunction("CommonsMngServer.login");
						e.setParams(login.toString());
						
						log.error(e.getFunction() + " " +e.getMessage() );			
						throw e;
		    		}
		    		
		    		if(instanceTpsettings!=null){
		    			instanceEntity.setIdlanguage(instanceTpsettings.getIdlanguage());
		    			instanceEntity.setTypecomchannel(instanceTpsettings.getTypecomchannel());
		    		}
	    		}
	    	}
	    	else{
	    		log.error("login does not exist value for login received as parameter");
			    
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
				e.setFunction("CommonsMngServer.login");
				e.setParams(login.toString());
				
				log.error(e.getFunction() + " " +e.getMessage() );		
				throw e;	   
	    	}	    	
	    }else{ 
			log.error("login All required Data not defined ");
			    
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_REQUIRED_DATA_NO_DEFINED);
			e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_REQUIRED_DATA_NO_DEFINED);
			e.setFunction("CommonsMngServer.login");
			e.setParams(login.toString());
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;	    	
	    }
	    
	    return instanceEntity;    
	}

	public boolean saveToken(KtekUserTokenEntity tokenEntity) {
		boolean boolOK=false; 		
		Ktek_user user = null;		
		CommonsManagerDB manager = null;
		
		manager = new CommonsManagerDB();
		user= manager.getUserByCode(tokenEntity.getUser());
		if(user!=null){
			boolOK=manager.saveUserSessionData(user.getKtek_pk_iduser(), tokenEntity.getToken(), tokenEntity.getDataexpiration());
		}else{
			log.error("saveToken User does not exist ");
		}
		
		if (boolOK)
			log.debug("saveToken OK  " );
		else 
			log.debug("saveToken ERROR ");
			
		return boolOK;
	}

	public KtekUserTokenEntity getUserToken(String codUser) throws KtekExceptionEntity {
		KtekUserTokenEntity instance = null;
		
		Ktek_user userInstance = null;
		Ktek_usersessiondata userDataInstance = null;
		
		CommonsManagerDB manager = null;
		
		manager = new CommonsManagerDB();		
		userInstance = manager.getUserByCode(codUser);
		if( userInstance != null ){
			userDataInstance = manager.getUserSessionDataByIdUser(userInstance.getKtek_pk_iduser());
			if(userDataInstance != null){
				instance = new KtekUserTokenEntity();
				instance.setDataexpiration(userDataInstance.getDataexpiration());
				instance.setToken(userDataInstance.getSessiontoken());
				instance.setUser(codUser);
			}else{
				log.error("getUserToken : UserSessionData does not exist ");
				
				String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
				e.setMessage(exceptionText);
				e.setFunction("CommonsMngServer.getUserToken");
				e.setParams(codUser);
				
				log.error(e.getFunction() + " " +e.getMessage() );			
				throw e;
			}
		}else{
			log.error("getUserToken : User does not exist ");
			
			String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
			e.setMessage(exceptionText);
			e.setFunction("CommonsMngServer.getUserToken");
			e.setParams(codUser);
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;
		}
		
		return instance;
	}
	
	
	public KtekUserTokenEntity getUserTokenById(int idUser) throws KtekExceptionEntity {
		KtekUserTokenEntity instance = null;
		Ktek_usersessiondata userDataInstance = null;
		CommonsManagerDB manager = null;
		
		manager = new CommonsManagerDB();		
		userDataInstance = manager.getUserSessionDataByIdUser(idUser);
		
		if(userDataInstance != null){
			instance = new KtekUserTokenEntity();
			instance.setDataexpiration(userDataInstance.getDataexpiration());
			instance.setToken(userDataInstance.getSessiontoken());
			
		}else{
			log.error("getUserTokenById : UserSessionData does not exist ");
			
			String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_DOES_NOT_EXIST);
			e.setMessage(exceptionText);
			e.setFunction("CommonsMngServer.getUserTokenById");
			e.setParams(String.valueOf(idUser));
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;
		}
	
		
		return instance;
	}
	

	public boolean deleteUser(String codUser) throws KtekExceptionEntity {
		boolean boolOK=false;
		
		CommonsManagerAdminDB manager = null;
		manager = new CommonsManagerAdminDB();
		
		//DELETE ALL RELATED DATA
		boolOK=manager.deleteUserAllTables(codUser);
		
		return boolOK;
		
	}

	public KtekUserTokenEntity[] getUserTokenList() {
		KtekUserTokenEntity[] instanceArray = null ;
		KtekUserTokenEntity instance= null ;
		Ktek_usersessiondata[] instanceArrayDAO = null;
		CommonsManagerDB manager = null;
				
		manager = new CommonsManagerDB();
		
		instanceArrayDAO = manager.getUserTokenList();
		
		if(instanceArrayDAO!=null){
			instanceArray = new KtekUserTokenEntity[instanceArrayDAO.length];
			
			for (int i=0; i< instanceArrayDAO.length ; i++){
				instance = new KtekUserTokenEntity();
				
				instance.setDataexpiration(instanceArrayDAO[i].getDataexpiration());
				instance.setToken(instanceArrayDAO[i].getSessiontoken());
				instance.setUser(instanceArrayDAO[i].getKtek_fk_iduser().getKtek_uk_coduser());
				
				instanceArray[i]=instance;				
			}			
		}else{
			instanceArray = new KtekUserTokenEntity[0]; 
		}
		
		return instanceArray;
	}

	public boolean createUserToken(KtekUserTokenEntity tokenEntity) throws KtekExceptionEntity {
		boolean boolOK = false;
		CommonsManagerAdminDB manager = null;
		Ktek_user userInstance = null;
		
		manager = new CommonsManagerAdminDB();
		
		if(tokenEntity == null){
			String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_CREATE_DATA_REQUIRED_NOT_DEFINED);
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_CREATE_DATA_REQUIRED_NOT_DEFINED);
			e.setMessage(exceptionText);
			e.setFunction("CommonsMngServer.createUserToken");
			e.setParams("null instance");
			
			throw e ;
		}
		
		try {
			userInstance = manager.createUserAllTable(tokenEntity);
		} catch (Exception e1) {
			e1.printStackTrace();
			userInstance = null;
		}
		
		if(userInstance == null){
			String exceptionText = getExceptionText(KtekExceptionMessage.EXCEPTION_CODE_USER_CREATE_ERROR);
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_USER_CREATE_ERROR);
			e.setMessage(exceptionText);
			e.setFunction("CommonsMngServer.createUserToken");
			e.setParams(tokenEntity.getUser());
			
			throw e ;
		}else{
			boolOK=true;
		}
				
				
		return boolOK;
	}

	public static boolean loadData(List<String> data) {
		boolean boolOK=false;
	
		boolOK=CommonsLoadFile.loadData(data);
		
		return boolOK;
	}

	public boolean loadfileData(String strfilename) {

		boolean boolOK=false;
		
		log.debug(strfilename);
		
		List<String> data = CommonsLoadFile.readFile(strfilename, true);
		
		boolOK=CommonsLoadFile.loadData(data);
		
		return boolOK;
		
	}

	public boolean setTpSettings(String token, KtekTpsettingsEntity data) throws KtekExceptionEntity {
		boolean boolOK = false;
		
		CommonsManagerDB manager = null;
		
		if(this.isTokenValid(token)==false){
			log.error("Token no valid ");
		    
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
			e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED);
			e.setFunction("CommonsMngServer.getApplicationmodulesright");
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;
			
		}else{
			manager = new CommonsManagerDB();
			boolOK=manager.setTPsettings(data.getIduser(), data.getIdlanguage(), data.getTypecomchannel(), data.getEmail(), data.getMobile());
		}
		
		return boolOK;
	} 

	
	public String[] getRandomLetters(){
		String[]  array =new String[3];
		
		array[0]=Utils.generateRandomLetter();
		array[1]=Utils.generateRandomLetter();
		array[2]=Utils.generateRandomLetter();
		
		return array;
	}
		
	public boolean loadfileDataStream(InputStream stream) {
		boolean boolOK=false;
		
		List<String> data = getStringLinesFromInputStream(stream);
		boolOK=CommonsMngServer.loadData(data);	
		
		return boolOK;
	}
	
	private List<String> getStringLinesFromInputStream(InputStream is) {
		List<String> data = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
			data = new ArrayList<String>(); 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
				data.add(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
			log.error("getStringLinesFromInputStream Exception " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	public KtekUserEntity loginBasic(KtekLoginBasicEntity login) throws KtekExceptionEntity {
		KtekUserEntity instanceEntity=null;
	    Ktek_user_ext instanceUserExt = null;
	    Ktek_user instanceUser = null;
	    String token =null;
	    long creationdata=0,  expirationdata =0;
	    boolean boolOK=false;
		KtekTpsettingsEntity instanceTpsettings = null;	    
	    
		long tokenDataExpiration = 0;
		
	    //1- CHECK IF REQUIRED DATA IS DEFINED 
	    if(login.isRequiredDataDefined()){	
	    	
	    	instanceUserExt = getUserExtByKey(login.getKey());
	    	
	    //2- CHECK IF INSTANCE IS NOT NULL 
	    	if(instanceUserExt!=null){
	    		
	    		if (instanceUserExt.getPassworduser().equals(login.getPassword())==false){
	    			log.error("ERROR password no right");
				    
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_PASSWORD_NOT_RIGHT);
					e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_PASSWORD_NOT_RIGHT);
					e.setFunction("CommonsMngServer.login");
					e.setParams(login.toString());
					
					log.error(e.getFunction() + " " +e.getMessage() );			
					throw e;
	    		}
	    		
	    		
	    		instanceUser= instanceUserExt.getKtek_fk_iduser();
	    		
	    		//GET ACTUAL EXPIRATION DATE FOR TOKEN
	    		tokenDataExpiration = instanceUser.getKtek_usersessiondata().getDataexpiration();

	    		creationdata= new Date().getTime();
	    		expirationdata = creationdata + KtekDefines.LOGIN_SESSION_TIMEOUT;

	    		instanceEntity= new KtekUserEntity();
    			
	    		if (tokenDataExpiration <creationdata){
	    			//GENERATE TOKEN 
	    			token = instanceEntity.generateToken();
	    			//SAVE TOKEN IN DATABASE
		    		boolOK=saveUserSessionData(instanceUser.getKtek_pk_iduser(), token, expirationdata);
		    
	    		}else{
	    			token= instanceUser.getKtek_usersessiondata().getSessiontoken();
	    			instanceEntity.setToken(token);
	    			boolOK=true;
	    		}
	    		
	    		instanceEntity.setName(instanceUser.getKtek_user_ext().getName());
	    		instanceEntity.setSurname(instanceUser.getKtek_user_ext().getSurname());
	    			    		
	    		instanceEntity.setIduser(instanceUser.getKtek_pk_iduser());
	    		if(instanceUser.getKtek_user_ext()!=null)
	    			instanceEntity.setCode(instanceUser.getKtek_uk_coduser());
	    		
	    		if(boolOK==false){
	    			log.error("ERROR saving datausersession");
				    
					KtekExceptionEntity e= new KtekExceptionEntity();
					e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
					e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER);
					e.setFunction("CommonsMngServer.login");
					e.setParams(login.toString());
					
					log.error(e.getFunction() + " " +e.getMessage() );			
					throw e;
	    		}else{
	    			
	    			instanceTpsettings = getTpSettings(token);
		    		if(instanceTpsettings ==null)
		    		{
		    			log.error("ERROR gettings settings");
					    
						KtekExceptionEntity e= new KtekExceptionEntity();
						e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
						e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED);
						e.setFunction("CommonsMngServer.login");
						e.setParams(login.toString());
						
						log.error(e.getFunction() + " " +e.getMessage() );			
						throw e;
		    		}
		    		
		    		if(instanceTpsettings!=null){
		    			instanceEntity.setIdlanguage(instanceTpsettings.getIdlanguage());
		    			//instanceEntity.setLanguage(instanceTpsettings.getLanguage());
		    			instanceEntity.setTypecomchannel(instanceTpsettings.getTypecomchannel());
		    		}
	    		}	
	    	}
	    	else{
	    		log.error("login does not exist value for login received as parameter");
			    
				KtekExceptionEntity e= new KtekExceptionEntity();
				e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
				e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST);
				e.setFunction("CommonsMngServer.login");
				e.setParams(login.toString());
				
				log.error(e.getFunction() + " " +e.getMessage() );		
				throw e;	   
	    	}	    	
	    }else{ 
			log.error("login All required Data not defined ");
			    
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(KtekExceptionCode.EXCEPTION_CODE_LOGIN_REQUIRED_DATA_NO_DEFINED);
			e.setMessage(KtekExceptionMessage.EXCEPTION_CODE_LOGIN_REQUIRED_DATA_NO_DEFINED);
			e.setFunction("CommonsMngServer.login");
			e.setParams(login.toString());
			
			log.error(e.getFunction() + " " +e.getMessage() );			
			throw e;	    	
	    }
	    
	    return instanceEntity; 
	}
	
}
