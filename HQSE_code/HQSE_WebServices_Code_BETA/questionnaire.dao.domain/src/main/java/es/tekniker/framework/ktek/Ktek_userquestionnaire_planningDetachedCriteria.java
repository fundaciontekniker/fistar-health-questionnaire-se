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

public class Ktek_userquestionnaire_planningDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_iduserquestionnaireplanning;
	public final StringExpression coduser;
	public final StringExpression codtelecareprogram;
	public final LongExpression plannedfrom;
	public final LongExpression plannedto;
	public final ShortExpression statusquestionnaire;
	
	public Ktek_userquestionnaire_planningDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning.class, es.tekniker.framework.ktek.Ktek_userquestionnaire_planningCriteria.class);
		ktek_pk_iduserquestionnaireplanning = new IntegerExpression("ktek_pk_iduserquestionnaireplanning", this.getDetachedCriteria());
		coduser = new StringExpression("coduser", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		plannedfrom = new LongExpression("plannedfrom", this.getDetachedCriteria());
		plannedto = new LongExpression("plannedto", this.getDetachedCriteria());
		statusquestionnaire = new ShortExpression("statusquestionnaire", this.getDetachedCriteria());
	}
	
	public Ktek_userquestionnaire_planningDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_userquestionnaire_planningCriteria.class);
		ktek_pk_iduserquestionnaireplanning = new IntegerExpression("ktek_pk_iduserquestionnaireplanning", this.getDetachedCriteria());
		coduser = new StringExpression("coduser", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		plannedfrom = new LongExpression("plannedfrom", this.getDetachedCriteria());
		plannedto = new LongExpression("plannedto", this.getDetachedCriteria());
		statusquestionnaire = new ShortExpression("statusquestionnaire", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireDetachedCriteria createKtek_fk_idquestionnaireCriteria() {
		return new Ktek_questionnaireDetachedCriteria(createCriteria("ktek_fk_idquestionnaire"));
	}
	
	public Ktek_result_questionnaireDetachedCriteria createKtek_result_questionnaireCriteria() {
		return new Ktek_result_questionnaireDetachedCriteria(createCriteria("ktek_result_questionnaire"));
	}
	
	public Ktek_userquestionnaire_planning uniqueKtek_userquestionnaire_planning(PersistentSession session) {
		return (Ktek_userquestionnaire_planning) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planning(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_userquestionnaire_planning[]) list.toArray(new Ktek_userquestionnaire_planning[list.size()]);
	}
}

