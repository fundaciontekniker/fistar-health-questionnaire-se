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

import es.tekniker.framework.ktek.entity.KtekExceptionEntity;

public class ValidateParameter {
	
	public static boolean validateParameterString( String parameter, String sExceptionMessage, int iExceptionCode, String sFunction ) throws KtekExceptionEntity{
		
		boolean boolOK=true;
		CommonsMngServer manager = null;
		
		manager = new CommonsMngServer ();	
		if(parameter==null || parameter.equals("")){
			String exceptionText=null;					
			exceptionText = manager.getExceptionText(sExceptionMessage);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(iExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(parameter);
			
			throw e;
		}
		return boolOK;
	}
	
	public static boolean validateParameterInteger( int parameter, String sExceptionMessage, int iExceptionCode, String sFunction ) throws KtekExceptionEntity{
		
		boolean boolOK=true;
		CommonsMngServer manager = null;
		
		manager = new CommonsMngServer();	
		if(parameter==0){
			String exceptionText=null;					
			exceptionText = manager.getExceptionText(sExceptionMessage);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(iExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(parameter));
			
			throw e;
		}
		return boolOK;
	}
	
	public static boolean validateParameterLong( long parameter, String sExceptionMessage, int iExceptionCode, String sFunction ) throws KtekExceptionEntity{
		
		boolean boolOK=true;
		CommonsMngServer manager = null;
		
		manager = new CommonsMngServer();	
		if(parameter==0){
			String exceptionText=null;					
			exceptionText = manager.getExceptionText(sExceptionMessage);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(iExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(parameter));
			
			throw e;
		}
		return boolOK;
	}
	
	public static boolean validateParameterShort( short parameter, String sExceptionMessage, int iExceptionCode, String sFunction ) throws KtekExceptionEntity{
		
		boolean boolOK=true;
		CommonsMngServer manager = null;
		
		manager = new CommonsMngServer();	
		if(parameter<0){
			String exceptionText=null;					
			exceptionText = manager.getExceptionText(sExceptionMessage);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(iExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(parameter));
			
			throw e;
		}
		return boolOK;
	}
	public static boolean validateParameterShortArray( short[] array, String sExceptionMessage, int iExceptionCode, String sFunction ) throws KtekExceptionEntity{
		
		boolean boolOK=true;
		CommonsMngServer manager = null;
		
		manager = new CommonsMngServer();	
		if(array == null || array.length==0){
			String exceptionText=null;					
			exceptionText = manager.getExceptionText(sExceptionMessage);
			
			KtekExceptionEntity e= new KtekExceptionEntity();
			e.setCode(iExceptionCode);
			e.setMessage(exceptionText);
			e.setFunction(sFunction);
			e.setParams(String.valueOf(""));
			
			throw e;
		}
		return boolOK;
	}
}
