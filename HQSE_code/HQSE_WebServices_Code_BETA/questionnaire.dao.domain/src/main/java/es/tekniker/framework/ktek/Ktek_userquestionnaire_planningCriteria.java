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

public class Ktek_userquestionnaire_planningCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_iduserquestionnaireplanning;
	public final StringExpression coduser;
	public final StringExpression codtelecareprogram;
	public final LongExpression plannedfrom;
	public final LongExpression plannedto;
	public final ShortExpression statusquestionnaire;
	
	public Ktek_userquestionnaire_planningCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_iduserquestionnaireplanning = new IntegerExpression("ktek_pk_iduserquestionnaireplanning", this);
		coduser = new StringExpression("coduser", this);
		codtelecareprogram = new StringExpression("codtelecareprogram", this);
		plannedfrom = new LongExpression("plannedfrom", this);
		plannedto = new LongExpression("plannedto", this);
		statusquestionnaire = new ShortExpression("statusquestionnaire", this);
	}
	
	public Ktek_userquestionnaire_planningCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_userquestionnaire_planning.class));
	}
	
	public Ktek_userquestionnaire_planningCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireCriteria createKtek_fk_idquestionnaireCriteria() {
		return new Ktek_questionnaireCriteria(createCriteria("ktek_fk_idquestionnaire"));
	}
	
	public Ktek_result_questionnaireCriteria createKtek_result_questionnaireCriteria() {
		return new Ktek_result_questionnaireCriteria(createCriteria("ktek_result_questionnaire"));
	}
	
	public Ktek_userquestionnaire_planning uniqueKtek_userquestionnaire_planning() {
		return (Ktek_userquestionnaire_planning) super.uniqueResult();
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planning() {
		java.util.List list = super.list();
		return (Ktek_userquestionnaire_planning[]) list.toArray(new Ktek_userquestionnaire_planning[list.size()]);
	}
}

