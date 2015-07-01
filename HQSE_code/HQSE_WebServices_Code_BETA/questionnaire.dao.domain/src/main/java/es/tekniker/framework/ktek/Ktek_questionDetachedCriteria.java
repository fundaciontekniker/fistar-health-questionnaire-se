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

public class Ktek_questionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final ShortExpression typeanswersortorder;
	public final ShortExpression typeanswer;
	public final ShortExpression formatanswerunique;
	public final ShortExpression weightquestion;
	
	public Ktek_questionDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_question.class, es.tekniker.framework.ktek.Ktek_questionCriteria.class);
		typeanswersortorder = new ShortExpression("typeanswersortorder", this.getDetachedCriteria());
		typeanswer = new ShortExpression("typeanswer", this.getDetachedCriteria());
		formatanswerunique = new ShortExpression("formatanswerunique", this.getDetachedCriteria());
		weightquestion = new ShortExpression("weightquestion", this.getDetachedCriteria());
	}
	
	public Ktek_questionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_questionCriteria.class);
		typeanswersortorder = new ShortExpression("typeanswersortorder", this.getDetachedCriteria());
		typeanswer = new ShortExpression("typeanswer", this.getDetachedCriteria());
		formatanswerunique = new ShortExpression("formatanswerunique", this.getDetachedCriteria());
		weightquestion = new ShortExpression("weightquestion", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireitemDetachedCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemDetachedCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_answersetDetachedCriteria createKtek_fk_idanswersetCriteria() {
		return new Ktek_answersetDetachedCriteria(createCriteria("ktek_fk_idanswerset"));
	}
	
	public Ktek_answerDetachedCriteria createKtek_answerCriteria() {
		return new Ktek_answerDetachedCriteria(createCriteria("ktek_answer"));
	}
	
	public Ktek_question uniqueKtek_question(PersistentSession session) {
		return (Ktek_question) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_question[] listKtek_question(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_question[]) list.toArray(new Ktek_question[list.size()]);
	}
}

