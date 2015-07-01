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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Ktek_usersessiondataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression sessiontoken;
	public final LongExpression dataexpiration;
	
	public Ktek_usersessiondataDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_usersessiondata.class, es.tekniker.framework.ktek.Ktek_usersessiondataCriteria.class);
		sessiontoken = new StringExpression("sessiontoken", this.getDetachedCriteria());
		dataexpiration = new LongExpression("dataexpiration", this.getDetachedCriteria());
	}
	
	public Ktek_usersessiondataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_usersessiondataCriteria.class);
		sessiontoken = new StringExpression("sessiontoken", this.getDetachedCriteria());
		dataexpiration = new LongExpression("dataexpiration", this.getDetachedCriteria());
	}
	
	public Ktek_userDetachedCriteria createKtek_fk_iduserCriteria() {
		return new Ktek_userDetachedCriteria(createCriteria("ktek_fk_iduser"));
	}
	
	public Ktek_usersessiondata uniqueKtek_usersessiondata(PersistentSession session) {
		return (Ktek_usersessiondata) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondata(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_usersessiondata[]) list.toArray(new Ktek_usersessiondata[list.size()]);
	}
}

