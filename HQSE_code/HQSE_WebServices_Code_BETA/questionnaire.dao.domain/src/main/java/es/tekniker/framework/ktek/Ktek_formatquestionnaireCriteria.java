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

public class Ktek_formatquestionnaireCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idformatquestionnaire;
	public final ShortExpression formatpagination;
	public final ShortExpression formatintegerparameter;
	public final ShortExpression formatdecimalparameter;
	public final ShortExpression formatsetuniqueitem;
	public final ShortExpression formatsetmultitem;
	
	public Ktek_formatquestionnaireCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idformatquestionnaire = new IntegerExpression("ktek_pk_idformatquestionnaire", this);
		formatpagination = new ShortExpression("formatpagination", this);
		formatintegerparameter = new ShortExpression("formatintegerparameter", this);
		formatdecimalparameter = new ShortExpression("formatdecimalparameter", this);
		formatsetuniqueitem = new ShortExpression("formatsetuniqueitem", this);
		formatsetmultitem = new ShortExpression("formatsetmultitem", this);
	}
	
	public Ktek_formatquestionnaireCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_formatquestionnaire.class));
	}
	
	public Ktek_formatquestionnaireCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireCriteria createKtek_fk_questionnaireCriteria() {
		return new Ktek_questionnaireCriteria(createCriteria("ktek_fk_questionnaire"));
	}
	
	public Ktek_formatquestionnaire uniqueKtek_formatquestionnaire() {
		return (Ktek_formatquestionnaire) super.uniqueResult();
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaire() {
		java.util.List list = super.list();
		return (Ktek_formatquestionnaire[]) list.toArray(new Ktek_formatquestionnaire[list.size()]);
	}
}

