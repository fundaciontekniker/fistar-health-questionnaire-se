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
package es.tekniker.framework.ktek;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Ktek_tpsettingsCriteria extends AbstractORMCriteria {
	public final ShortExpression typecomchannel;
	
	public Ktek_tpsettingsCriteria(Criteria criteria) {
		super(criteria);
		typecomchannel = new ShortExpression("typecomchannel", this);
	}
	
	public Ktek_tpsettingsCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_tpsettings.class));
	}
	
	public Ktek_tpsettingsCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_userCriteria createKtek_fk_iduserCriteria() {
		return new Ktek_userCriteria(createCriteria("ktek_fk_iduser"));
	}
	
	public Ktek_languageCriteria createKtek_fk_idlanguageCriteria() {
		return new Ktek_languageCriteria(createCriteria("ktek_fk_idlanguage"));
	}
	
	public Ktek_tpsettings uniqueKtek_tpsettings() {
		return (Ktek_tpsettings) super.uniqueResult();
	}
	
	public Ktek_tpsettings[] listKtek_tpsettings() {
		java.util.List list = super.list();
		return (Ktek_tpsettings[]) list.toArray(new Ktek_tpsettings[list.size()]);
	}
}

