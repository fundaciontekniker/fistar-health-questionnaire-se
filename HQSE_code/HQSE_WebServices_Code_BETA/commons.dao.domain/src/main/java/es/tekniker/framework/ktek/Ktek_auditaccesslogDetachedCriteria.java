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

public class Ktek_auditaccesslogDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idauditaccesslog;
	public final StringExpression codtelecareprogram;
	public final ShortExpression typeaction;
	public final IntegerExpression idaction;
	public final LongExpression logitemcreation;
	
	public Ktek_auditaccesslogDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_auditaccesslog.class, es.tekniker.framework.ktek.Ktek_auditaccesslogCriteria.class);
		ktek_pk_idauditaccesslog = new IntegerExpression("ktek_pk_idauditaccesslog", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		typeaction = new ShortExpression("typeaction", this.getDetachedCriteria());
		idaction = new IntegerExpression("idaction", this.getDetachedCriteria());
		logitemcreation = new LongExpression("logitemcreation", this.getDetachedCriteria());
	}
	
	public Ktek_auditaccesslogDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_auditaccesslogCriteria.class);
		ktek_pk_idauditaccesslog = new IntegerExpression("ktek_pk_idauditaccesslog", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		typeaction = new ShortExpression("typeaction", this.getDetachedCriteria());
		idaction = new IntegerExpression("idaction", this.getDetachedCriteria());
		logitemcreation = new LongExpression("logitemcreation", this.getDetachedCriteria());
	}
	
	public Ktek_userDetachedCriteria createIdaccessuserCriteria() {
		return new Ktek_userDetachedCriteria(createCriteria("idaccessuser"));
	}
	
	public Ktek_userDetachedCriteria createIdaccesseduserCriteria() {
		return new Ktek_userDetachedCriteria(createCriteria("idaccesseduser"));
	}
	
	public Ktek_auditaccesslog uniqueKtek_auditaccesslog(PersistentSession session) {
		return (Ktek_auditaccesslog) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslog(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_auditaccesslog[]) list.toArray(new Ktek_auditaccesslog[list.size()]);
	}
}

