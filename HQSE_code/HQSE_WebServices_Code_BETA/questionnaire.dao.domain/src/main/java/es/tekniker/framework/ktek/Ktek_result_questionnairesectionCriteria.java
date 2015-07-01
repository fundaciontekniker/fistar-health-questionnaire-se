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

public class Ktek_result_questionnairesectionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idresultquestionnairesection;
	public final ShortExpression evaluationscorequestionnairesection;
	
	public Ktek_result_questionnairesectionCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idresultquestionnairesection = new IntegerExpression("ktek_pk_idresultquestionnairesection", this);
		evaluationscorequestionnairesection = new ShortExpression("evaluationscorequestionnairesection", this);
	}
	
	public Ktek_result_questionnairesectionCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_result_questionnairesection.class));
	}
	
	public Ktek_result_questionnairesectionCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnairesectionCriteria createKtek_fk_idquestionnairesectionCriteria() {
		return new Ktek_questionnairesectionCriteria(createCriteria("ktek_fk_idquestionnairesection"));
	}
	
	public Ktek_result_questionnaireCriteria createKtek_fk_idresultquestionnaireCriteria() {
		return new Ktek_result_questionnaireCriteria(createCriteria("ktek_fk_idresultquestionnaire"));
	}
	
	public Ktek_result_questionnaireitemCriteria createKtek_result_questionnaireitemCriteria() {
		return new Ktek_result_questionnaireitemCriteria(createCriteria("ktek_result_questionnaireitem"));
	}
	
	public Ktek_result_questionnairesection uniqueKtek_result_questionnairesection() {
		return (Ktek_result_questionnairesection) super.uniqueResult();
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesection() {
		java.util.List list = super.list();
		return (Ktek_result_questionnairesection[]) list.toArray(new Ktek_result_questionnairesection[list.size()]);
	}
}

