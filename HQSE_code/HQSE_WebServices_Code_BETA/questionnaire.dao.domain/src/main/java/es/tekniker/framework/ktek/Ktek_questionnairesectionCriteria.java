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

public class Ktek_questionnairesectionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idquestionnairesection;
	public final StringExpression namequestionnairesection;
	public final StringExpression desquestionnairesection;
	public final StringExpression desquestionnairesectioninstructions;
	
	public Ktek_questionnairesectionCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idquestionnairesection = new IntegerExpression("ktek_pk_idquestionnairesection", this);
		namequestionnairesection = new StringExpression("namequestionnairesection", this);
		desquestionnairesection = new StringExpression("desquestionnairesection", this);
		desquestionnairesectioninstructions = new StringExpression("desquestionnairesectioninstructions", this);
	}
	
	public Ktek_questionnairesectionCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_questionnairesection.class));
	}
	
	public Ktek_questionnairesectionCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_qitem_sectionCriteria createKtek_qitem_sectionCriteria() {
		return new Ktek_qitem_sectionCriteria(createCriteria("ktek_qitem_section"));
	}
	
	public Ktek_qsection_questionnaireCriteria createKtek_qsection_questionnaireCriteria() {
		return new Ktek_qsection_questionnaireCriteria(createCriteria("ktek_qsection_questionnaire"));
	}
	
	public Ktek_result_questionnairesectionCriteria createKtek_result_questionnairesectionCriteria() {
		return new Ktek_result_questionnairesectionCriteria(createCriteria("ktek_result_questionnairesection"));
	}
	
	public Ktek_questionnairesection uniqueKtek_questionnairesection() {
		return (Ktek_questionnairesection) super.uniqueResult();
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesection() {
		java.util.List list = super.list();
		return (Ktek_questionnairesection[]) list.toArray(new Ktek_questionnairesection[list.size()]);
	}
}

