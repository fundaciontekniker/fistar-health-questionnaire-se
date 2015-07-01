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

public class Ktek_auditaccesslogCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idauditaccesslog;
	public final StringExpression codtelecareprogram;
	public final ShortExpression typeaction;
	public final IntegerExpression idaction;
	public final LongExpression logitemcreation;
	
	public Ktek_auditaccesslogCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idauditaccesslog = new IntegerExpression("ktek_pk_idauditaccesslog", this);
		codtelecareprogram = new StringExpression("codtelecareprogram", this);
		typeaction = new ShortExpression("typeaction", this);
		idaction = new IntegerExpression("idaction", this);
		logitemcreation = new LongExpression("logitemcreation", this);
	}
	
	public Ktek_auditaccesslogCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_auditaccesslog.class));
	}
	
	public Ktek_auditaccesslogCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_userCriteria createIdaccessuserCriteria() {
		return new Ktek_userCriteria(createCriteria("idaccessuser"));
	}
	
	public Ktek_userCriteria createIdaccesseduserCriteria() {
		return new Ktek_userCriteria(createCriteria("idaccesseduser"));
	}
	
	public Ktek_auditaccesslog uniqueKtek_auditaccesslog() {
		return (Ktek_auditaccesslog) super.uniqueResult();
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslog() {
		java.util.List list = super.list();
		return (Ktek_auditaccesslog[]) list.toArray(new Ktek_auditaccesslog[list.size()]);
	}
}

