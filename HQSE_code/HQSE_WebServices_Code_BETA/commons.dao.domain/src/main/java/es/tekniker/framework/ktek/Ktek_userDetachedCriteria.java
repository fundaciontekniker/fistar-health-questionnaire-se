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

public class Ktek_userDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_iduser;
	public final StringExpression ktek_uk_coduser;
	
	public Ktek_userDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_user.class, es.tekniker.framework.ktek.Ktek_userCriteria.class);
		ktek_pk_iduser = new IntegerExpression("ktek_pk_iduser", this.getDetachedCriteria());
		ktek_uk_coduser = new StringExpression("ktek_uk_coduser", this.getDetachedCriteria());
	}
	
	public Ktek_userDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_userCriteria.class);
		ktek_pk_iduser = new IntegerExpression("ktek_pk_iduser", this.getDetachedCriteria());
		ktek_uk_coduser = new StringExpression("ktek_uk_coduser", this.getDetachedCriteria());
	}
	
	public Ktek_auditaccesslogDetachedCriteria createKtek_auditaccesslogCriteria() {
		return new Ktek_auditaccesslogDetachedCriteria(createCriteria("ktek_auditaccesslog"));
	}
	
	public Ktek_auditaccesslogDetachedCriteria createKtek_auditaccesslog1Criteria() {
		return new Ktek_auditaccesslogDetachedCriteria(createCriteria("ktek_auditaccesslog1"));
	}
	
	public Ktek_tpsettingsDetachedCriteria createKtek_tpsettingsCriteria() {
		return new Ktek_tpsettingsDetachedCriteria(createCriteria("ktek_tpsettings"));
	}
	
	public Ktek_user_extDetachedCriteria createKtek_user_extCriteria() {
		return new Ktek_user_extDetachedCriteria(createCriteria("ktek_user_ext"));
	}
	
	public Ktek_usersessiondataDetachedCriteria createKtek_usersessiondataCriteria() {
		return new Ktek_usersessiondataDetachedCriteria(createCriteria("ktek_usersessiondata"));
	}
	
	public Ktek_user uniqueKtek_user(PersistentSession session) {
		return (Ktek_user) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_user[] listKtek_user(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_user[]) list.toArray(new Ktek_user[list.size()]);
	}
}

