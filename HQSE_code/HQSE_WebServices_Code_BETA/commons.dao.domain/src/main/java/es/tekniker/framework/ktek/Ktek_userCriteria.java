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

public class Ktek_userCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_iduser;
	public final StringExpression ktek_uk_coduser;
	
	public Ktek_userCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_iduser = new IntegerExpression("ktek_pk_iduser", this);
		ktek_uk_coduser = new StringExpression("ktek_uk_coduser", this);
	}
	
	public Ktek_userCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_user.class));
	}
	
	public Ktek_userCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_auditaccesslogCriteria createKtek_auditaccesslogCriteria() {
		return new Ktek_auditaccesslogCriteria(createCriteria("ktek_auditaccesslog"));
	}
	
	public Ktek_auditaccesslogCriteria createKtek_auditaccesslog1Criteria() {
		return new Ktek_auditaccesslogCriteria(createCriteria("ktek_auditaccesslog1"));
	}
	
	public Ktek_tpsettingsCriteria createKtek_tpsettingsCriteria() {
		return new Ktek_tpsettingsCriteria(createCriteria("ktek_tpsettings"));
	}
	
	public Ktek_user_extCriteria createKtek_user_extCriteria() {
		return new Ktek_user_extCriteria(createCriteria("ktek_user_ext"));
	}
	
	public Ktek_usersessiondataCriteria createKtek_usersessiondataCriteria() {
		return new Ktek_usersessiondataCriteria(createCriteria("ktek_usersessiondata"));
	}
	
	public Ktek_user uniqueKtek_user() {
		return (Ktek_user) super.uniqueResult();
	}
	
	public Ktek_user[] listKtek_user() {
		java.util.List list = super.list();
		return (Ktek_user[]) list.toArray(new Ktek_user[list.size()]);
	}
}

