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


import es.tekniker.framework.ktek.Ktek_language;
import es.tekniker.framework.ktek.Ktek_tpsettings;
import es.tekniker.framework.ktek.Ktek_user_ext;
import es.tekniker.framework.ktek.entity.KtekLanguageEntity;
import es.tekniker.framework.ktek.entity.KtekTpsettingsEntity;

public class BO2Entity {

	public static KtekLanguageEntity[] KtekLanguageBO2Entity(Ktek_language[] arrayInstance) {

		KtekLanguageEntity[] arrayInstanceMapped= null; 
		KtekLanguageEntity instanceMapped= null;
		boolean languageDefault=false;
		
		if(arrayInstance!=null )
			arrayInstanceMapped = new KtekLanguageEntity[arrayInstance.length];
		
		for (int i=0 ; i< arrayInstance.length ; i++ )
		{
			languageDefault=false;
			instanceMapped= new KtekLanguageEntity();
			
			instanceMapped.setCodlanguage(arrayInstance[i].getKtek_uk_codlanguage());
			instanceMapped.setDeslanguage(arrayInstance[i].getDeslanguage());
			instanceMapped.setIdlanguage(arrayInstance[i].getKtek_pk_idlanguage());
			if(arrayInstance[i].getIsdefault()==1)
				languageDefault=true;
			instanceMapped.setIsdefault(languageDefault);
						
			arrayInstanceMapped[i]=instanceMapped;			
		}
		
		return arrayInstanceMapped; 		
	}
		

	public static KtekTpsettingsEntity KtekTpsettingsBO2Entity(Ktek_tpsettings instance, Ktek_user_ext userExt)
	{
		KtekTpsettingsEntity instanceMapped= new KtekTpsettingsEntity();
		
		instanceMapped.setIduser(instance.getKtek_fk_iduserId());
		instanceMapped.setIdlanguage(instance.getKtek_fk_idlanguage().getKtek_pk_idlanguage());
		instanceMapped.setTypecomchannel(instance.getTypecomchannel());
		
		instanceMapped.setEmail(userExt.getEmail());
		instanceMapped.setMobile(userExt.getMobile());
		
		return instanceMapped;		
	}
	
	public static Ktek_tpsettings KtekTpsettingsEntity2BO(KtekTpsettingsEntity instance)
	{
		Ktek_tpsettings instanceMapped= new Ktek_tpsettings();
		
		instanceMapped.setKtek_fk_iduserId(instance.getIduser());
		
		return instanceMapped;		
	}	
}
