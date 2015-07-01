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

public class Ktek_questionnaireitemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idquestionnaireitem;
	public final StringExpression ktek_uk_codquestionnaireitem;
	public final StringExpression namequestionnaireitem;
	public final StringExpression desquestionnaireitem;
	public final ShortExpression typequestionnaireitem;
	public final ShortExpression isrequired;
	public final ShortExpression isdeleted;
	
	public Ktek_questionnaireitemCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_pk_idquestionnaireitem", this);
		ktek_uk_codquestionnaireitem = new StringExpression("ktek_uk_codquestionnaireitem", this);
		namequestionnaireitem = new StringExpression("namequestionnaireitem", this);
		desquestionnaireitem = new StringExpression("desquestionnaireitem", this);
		typequestionnaireitem = new ShortExpression("typequestionnaireitem", this);
		isrequired = new ShortExpression("isrequired", this);
		isdeleted = new ShortExpression("isdeleted", this);
	}
	
	public Ktek_questionnaireitemCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_questionnaireitem.class));
	}
	
	public Ktek_questionnaireitemCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_parameterCriteria createKtek_parameterCriteria() {
		return new Ktek_parameterCriteria(createCriteria("ktek_parameter"));
	}
	
	public Ktek_qitem_sectionCriteria createKtek_qitem_sectionCriteria() {
		return new Ktek_qitem_sectionCriteria(createCriteria("ktek_qitem_section"));
	}
	
	public Ktek_questionCriteria createKtek_questionCriteria() {
		return new Ktek_questionCriteria(createCriteria("ktek_question"));
	}
	
	public Ktek_questionnaireitem_codificationCriteria createKtek_questionnaireitem_codificationCriteria() {
		return new Ktek_questionnaireitem_codificationCriteria(createCriteria("ktek_questionnaireitem_codification"));
	}
	
	public Ktek_result_questionnaireitemCriteria createKtek_result_questionnaireitemCriteria() {
		return new Ktek_result_questionnaireitemCriteria(createCriteria("ktek_result_questionnaireitem"));
	}
	
	public Ktek_questionnaireitem uniqueKtek_questionnaireitem() {
		return (Ktek_questionnaireitem) super.uniqueResult();
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitem() {
		java.util.List list = super.list();
		return (Ktek_questionnaireitem[]) list.toArray(new Ktek_questionnaireitem[list.size()]);
	}
}

