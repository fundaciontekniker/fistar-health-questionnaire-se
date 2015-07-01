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

public class Ktek_questionCriteria extends AbstractORMCriteria {
	public final ShortExpression typeanswersortorder;
	public final ShortExpression typeanswer;
	public final ShortExpression formatanswerunique;
	public final ShortExpression weightquestion;
	
	public Ktek_questionCriteria(Criteria criteria) {
		super(criteria);
		typeanswersortorder = new ShortExpression("typeanswersortorder", this);
		typeanswer = new ShortExpression("typeanswer", this);
		formatanswerunique = new ShortExpression("formatanswerunique", this);
		weightquestion = new ShortExpression("weightquestion", this);
	}
	
	public Ktek_questionCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_question.class));
	}
	
	public Ktek_questionCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireitemCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_answersetCriteria createKtek_fk_idanswersetCriteria() {
		return new Ktek_answersetCriteria(createCriteria("ktek_fk_idanswerset"));
	}
	
	public Ktek_answerCriteria createKtek_answerCriteria() {
		return new Ktek_answerCriteria(createCriteria("ktek_answer"));
	}
	
	public Ktek_question uniqueKtek_question() {
		return (Ktek_question) super.uniqueResult();
	}
	
	public Ktek_question[] listKtek_question() {
		java.util.List list = super.list();
		return (Ktek_question[]) list.toArray(new Ktek_question[list.size()]);
	}
}

