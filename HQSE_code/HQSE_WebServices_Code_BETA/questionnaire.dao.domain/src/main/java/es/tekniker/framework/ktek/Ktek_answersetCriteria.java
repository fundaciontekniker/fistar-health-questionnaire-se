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

public class Ktek_answersetCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idanswerset;
	public final StringExpression codanswersetl;
	public final StringExpression nameanswerset;
	
	public Ktek_answersetCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idanswerset = new IntegerExpression("ktek_pk_idanswerset", this);
		codanswersetl = new StringExpression("codanswersetl", this);
		nameanswerset = new StringExpression("nameanswerset", this);
	}
	
	public Ktek_answersetCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_answerset.class));
	}
	
	public Ktek_answersetCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_answerCriteria createKtek_fk_idanswerCriteria() {
		return new Ktek_answerCriteria(createCriteria("ktek_fk_idanswer"));
	}
	
	public Ktek_questionCriteria createKtek_questionCriteria() {
		return new Ktek_questionCriteria(createCriteria("ktek_question"));
	}
	
	public Ktek_answerset uniqueKtek_answerset() {
		return (Ktek_answerset) super.uniqueResult();
	}
	
	public Ktek_answerset[] listKtek_answerset() {
		java.util.List list = super.list();
		return (Ktek_answerset[]) list.toArray(new Ktek_answerset[list.size()]);
	}
}

