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

public class Ktek_questionnaireconfigurationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_ktek_idquestionnaireconfiguration;
	public final IntegerExpression ktek_typesave;
	public final StringExpression endpointserver;
	public final StringExpression eventserviceoauth2headertoken;
	public final IntegerExpression timeout;
	public final IntegerExpression port;
	
	public Ktek_questionnaireconfigurationCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_ktek_idquestionnaireconfiguration = new IntegerExpression("ktek_pk_ktek_idquestionnaireconfiguration", this);
		ktek_typesave = new IntegerExpression("ktek_typesave", this);
		endpointserver = new StringExpression("endpointserver", this);
		eventserviceoauth2headertoken = new StringExpression("eventserviceoauth2headertoken", this);
		timeout = new IntegerExpression("timeout", this);
		port = new IntegerExpression("port", this);
	}
	
	public Ktek_questionnaireconfigurationCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_questionnaireconfiguration.class));
	}
	
	public Ktek_questionnaireconfigurationCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireconfiguration uniqueKtek_questionnaireconfiguration() {
		return (Ktek_questionnaireconfiguration) super.uniqueResult();
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfiguration() {
		java.util.List list = super.list();
		return (Ktek_questionnaireconfiguration[]) list.toArray(new Ktek_questionnaireconfiguration[list.size()]);
	}
}

