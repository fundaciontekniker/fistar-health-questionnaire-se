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

public class Ktek_formatquestionnaireDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idformatquestionnaire;
	public final ShortExpression formatpagination;
	public final ShortExpression formatintegerparameter;
	public final ShortExpression formatdecimalparameter;
	public final ShortExpression formatsetuniqueitem;
	public final ShortExpression formatsetmultitem;
	
	public Ktek_formatquestionnaireDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_formatquestionnaire.class, es.tekniker.framework.ktek.Ktek_formatquestionnaireCriteria.class);
		ktek_pk_idformatquestionnaire = new IntegerExpression("ktek_pk_idformatquestionnaire", this.getDetachedCriteria());
		formatpagination = new ShortExpression("formatpagination", this.getDetachedCriteria());
		formatintegerparameter = new ShortExpression("formatintegerparameter", this.getDetachedCriteria());
		formatdecimalparameter = new ShortExpression("formatdecimalparameter", this.getDetachedCriteria());
		formatsetuniqueitem = new ShortExpression("formatsetuniqueitem", this.getDetachedCriteria());
		formatsetmultitem = new ShortExpression("formatsetmultitem", this.getDetachedCriteria());
	}
	
	public Ktek_formatquestionnaireDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_formatquestionnaireCriteria.class);
		ktek_pk_idformatquestionnaire = new IntegerExpression("ktek_pk_idformatquestionnaire", this.getDetachedCriteria());
		formatpagination = new ShortExpression("formatpagination", this.getDetachedCriteria());
		formatintegerparameter = new ShortExpression("formatintegerparameter", this.getDetachedCriteria());
		formatdecimalparameter = new ShortExpression("formatdecimalparameter", this.getDetachedCriteria());
		formatsetuniqueitem = new ShortExpression("formatsetuniqueitem", this.getDetachedCriteria());
		formatsetmultitem = new ShortExpression("formatsetmultitem", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireDetachedCriteria createKtek_fk_questionnaireCriteria() {
		return new Ktek_questionnaireDetachedCriteria(createCriteria("ktek_fk_questionnaire"));
	}
	
	public Ktek_formatquestionnaire uniqueKtek_formatquestionnaire(PersistentSession session) {
		return (Ktek_formatquestionnaire) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaire(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_formatquestionnaire[]) list.toArray(new Ktek_formatquestionnaire[list.size()]);
	}
}

