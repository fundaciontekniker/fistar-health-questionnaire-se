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

public class Ktek_qitem_sectionCriteria extends AbstractORMCriteria {
	public final ShortExpression sortorder;
	public final IntegerExpression ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	public final IntegerExpression ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	
	public Ktek_qitem_sectionCriteria(Criteria criteria) {
		super(criteria);
		sortorder = new ShortExpression("sortorder", this);
		ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = new IntegerExpression("ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection", this);
		ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem", this);
	}
	
	public Ktek_qitem_sectionCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_qitem_section.class));
	}
	
	public Ktek_qitem_sectionCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnairesectionCriteria createKtek_fk_idquestionnairesectionCriteria() {
		return new Ktek_questionnairesectionCriteria(createCriteria("ktek_fk_idquestionnairesection"));
	}
	
	public Ktek_questionnaireitemCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_qitem_section uniqueKtek_qitem_section() {
		return (Ktek_qitem_section) super.uniqueResult();
	}
	
	public Ktek_qitem_section[] listKtek_qitem_section() {
		java.util.List list = super.list();
		return (Ktek_qitem_section[]) list.toArray(new Ktek_qitem_section[list.size()]);
	}
}

