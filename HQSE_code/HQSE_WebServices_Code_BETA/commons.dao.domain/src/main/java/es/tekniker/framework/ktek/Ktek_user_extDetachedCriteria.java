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

public class Ktek_user_extDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression ktek_uk_coduserid;
	public final StringExpression email;
	public final StringExpression mobile;
	public final StringExpression keyuser;
	public final StringExpression passworduser;
	public final StringExpression name;
	public final StringExpression surname;
	
	public Ktek_user_extDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_user_ext.class, es.tekniker.framework.ktek.Ktek_user_extCriteria.class);
		ktek_uk_coduserid = new StringExpression("ktek_uk_coduserid", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		mobile = new StringExpression("mobile", this.getDetachedCriteria());
		keyuser = new StringExpression("keyuser", this.getDetachedCriteria());
		passworduser = new StringExpression("passworduser", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		surname = new StringExpression("surname", this.getDetachedCriteria());
	}
	
	public Ktek_user_extDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_user_extCriteria.class);
		ktek_uk_coduserid = new StringExpression("ktek_uk_coduserid", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		mobile = new StringExpression("mobile", this.getDetachedCriteria());
		keyuser = new StringExpression("keyuser", this.getDetachedCriteria());
		passworduser = new StringExpression("passworduser", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		surname = new StringExpression("surname", this.getDetachedCriteria());
	}
	
	public Ktek_userDetachedCriteria createKtek_fk_iduserCriteria() {
		return new Ktek_userDetachedCriteria(createCriteria("ktek_fk_iduser"));
	}
	
	public Ktek_user_ext uniqueKtek_user_ext(PersistentSession session) {
		return (Ktek_user_ext) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_user_ext[] listKtek_user_ext(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_user_ext[]) list.toArray(new Ktek_user_ext[list.size()]);
	}
}

