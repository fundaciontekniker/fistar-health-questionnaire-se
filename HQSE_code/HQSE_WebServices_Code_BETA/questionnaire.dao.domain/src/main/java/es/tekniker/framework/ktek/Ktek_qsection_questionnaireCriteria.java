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

public class Ktek_qsection_questionnaireCriteria extends AbstractORMCriteria {
	public final ShortExpression sortorder;
	public final IntegerExpression ktek_fk_idquestionnaire_ktek_pk_idquestionnaire;
	public final IntegerExpression ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	
	public Ktek_qsection_questionnaireCriteria(Criteria criteria) {
		super(criteria);
		sortorder = new ShortExpression("sortorder", this);
		ktek_fk_idquestionnaire_ktek_pk_idquestionnaire = new IntegerExpression("ktek_fk_idquestionnaire_ktek_pk_idquestionnaire", this);
		ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = new IntegerExpression("ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection", this);
	}
	
	public Ktek_qsection_questionnaireCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_qsection_questionnaire.class));
	}
	
	public Ktek_qsection_questionnaireCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireCriteria createKtek_fk_idquestionnaireCriteria() {
		return new Ktek_questionnaireCriteria(createCriteria("ktek_fk_idquestionnaire"));
	}
	
	public Ktek_questionnairesectionCriteria createKtek_fk_idquestionnairesectionCriteria() {
		return new Ktek_questionnairesectionCriteria(createCriteria("ktek_fk_idquestionnairesection"));
	}
	
	public Ktek_qsection_questionnaire uniqueKtek_qsection_questionnaire() {
		return (Ktek_qsection_questionnaire) super.uniqueResult();
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaire() {
		java.util.List list = super.list();
		return (Ktek_qsection_questionnaire[]) list.toArray(new Ktek_qsection_questionnaire[list.size()]);
	}
}

