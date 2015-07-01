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

public class Ktek_answersetDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idanswerset;
	public final StringExpression codanswersetl;
	public final StringExpression nameanswerset;
	
	public Ktek_answersetDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_answerset.class, es.tekniker.framework.ktek.Ktek_answersetCriteria.class);
		ktek_pk_idanswerset = new IntegerExpression("ktek_pk_idanswerset", this.getDetachedCriteria());
		codanswersetl = new StringExpression("codanswersetl", this.getDetachedCriteria());
		nameanswerset = new StringExpression("nameanswerset", this.getDetachedCriteria());
	}
	
	public Ktek_answersetDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_answersetCriteria.class);
		ktek_pk_idanswerset = new IntegerExpression("ktek_pk_idanswerset", this.getDetachedCriteria());
		codanswersetl = new StringExpression("codanswersetl", this.getDetachedCriteria());
		nameanswerset = new StringExpression("nameanswerset", this.getDetachedCriteria());
	}
	
	public Ktek_answerDetachedCriteria createKtek_fk_idanswerCriteria() {
		return new Ktek_answerDetachedCriteria(createCriteria("ktek_fk_idanswer"));
	}
	
	public Ktek_questionDetachedCriteria createKtek_questionCriteria() {
		return new Ktek_questionDetachedCriteria(createCriteria("ktek_question"));
	}
	
	public Ktek_answerset uniqueKtek_answerset(PersistentSession session) {
		return (Ktek_answerset) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_answerset[] listKtek_answerset(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_answerset[]) list.toArray(new Ktek_answerset[list.size()]);
	}
}

