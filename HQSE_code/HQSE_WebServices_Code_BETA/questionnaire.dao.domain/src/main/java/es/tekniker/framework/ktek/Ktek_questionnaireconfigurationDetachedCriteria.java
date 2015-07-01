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

public class Ktek_questionnaireconfigurationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_ktek_idquestionnaireconfiguration;
	public final IntegerExpression ktek_typesave;
	public final StringExpression endpointserver;
	public final StringExpression eventserviceoauth2headertoken;
	public final IntegerExpression timeout;
	public final IntegerExpression port;
	
	public Ktek_questionnaireconfigurationDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration.class, es.tekniker.framework.ktek.Ktek_questionnaireconfigurationCriteria.class);
		ktek_pk_ktek_idquestionnaireconfiguration = new IntegerExpression("ktek_pk_ktek_idquestionnaireconfiguration", this.getDetachedCriteria());
		ktek_typesave = new IntegerExpression("ktek_typesave", this.getDetachedCriteria());
		endpointserver = new StringExpression("endpointserver", this.getDetachedCriteria());
		eventserviceoauth2headertoken = new StringExpression("eventserviceoauth2headertoken", this.getDetachedCriteria());
		timeout = new IntegerExpression("timeout", this.getDetachedCriteria());
		port = new IntegerExpression("port", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireconfigurationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_questionnaireconfigurationCriteria.class);
		ktek_pk_ktek_idquestionnaireconfiguration = new IntegerExpression("ktek_pk_ktek_idquestionnaireconfiguration", this.getDetachedCriteria());
		ktek_typesave = new IntegerExpression("ktek_typesave", this.getDetachedCriteria());
		endpointserver = new StringExpression("endpointserver", this.getDetachedCriteria());
		eventserviceoauth2headertoken = new StringExpression("eventserviceoauth2headertoken", this.getDetachedCriteria());
		timeout = new IntegerExpression("timeout", this.getDetachedCriteria());
		port = new IntegerExpression("port", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireconfiguration uniqueKtek_questionnaireconfiguration(PersistentSession session) {
		return (Ktek_questionnaireconfiguration) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfiguration(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_questionnaireconfiguration[]) list.toArray(new Ktek_questionnaireconfiguration[list.size()]);
	}
}

