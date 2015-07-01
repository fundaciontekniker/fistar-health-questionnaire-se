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

public class Ktek_answerCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idanswer;
	public final StringExpression ktek_uk_codanswer;
	public final StringExpression nameanswer;
	public final StringExpression desanswer;
	public final StringExpression imageanswer;
	public final ShortExpression scoreanswer;
	
	public Ktek_answerCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idanswer = new IntegerExpression("ktek_pk_idanswer", this);
		ktek_uk_codanswer = new StringExpression("ktek_uk_codanswer", this);
		nameanswer = new StringExpression("nameanswer", this);
		desanswer = new StringExpression("desanswer", this);
		imageanswer = new StringExpression("imageanswer", this);
		scoreanswer = new ShortExpression("scoreanswer", this);
	}
	
	public Ktek_answerCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_answer.class));
	}
	
	public Ktek_answerCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_answersetCriteria createKtek_fk_idanswersetCriteria() {
		return new Ktek_answersetCriteria(createCriteria("ktek_fk_idanswerset"));
	}
	
	public Ktek_answer uniqueKtek_answer() {
		return (Ktek_answer) super.uniqueResult();
	}
	
	public Ktek_answer[] listKtek_answer() {
		java.util.List list = super.list();
		return (Ktek_answer[]) list.toArray(new Ktek_answer[list.size()]);
	}
}

