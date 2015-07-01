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

public class Ktek_qitem_sectionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final ShortExpression sortorder;
	public final IntegerExpression ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection;
	public final IntegerExpression ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem;
	
	public Ktek_qitem_sectionDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_qitem_section.class, es.tekniker.framework.ktek.Ktek_qitem_sectionCriteria.class);
		sortorder = new ShortExpression("sortorder", this.getDetachedCriteria());
		ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = new IntegerExpression("ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection", this.getDetachedCriteria());
		ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem", this.getDetachedCriteria());
	}
	
	public Ktek_qitem_sectionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_qitem_sectionCriteria.class);
		sortorder = new ShortExpression("sortorder", this.getDetachedCriteria());
		ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection = new IntegerExpression("ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection", this.getDetachedCriteria());
		ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem", this.getDetachedCriteria());
	}
	
	public Ktek_questionnairesectionDetachedCriteria createKtek_fk_idquestionnairesectionCriteria() {
		return new Ktek_questionnairesectionDetachedCriteria(createCriteria("ktek_fk_idquestionnairesection"));
	}
	
	public Ktek_questionnaireitemDetachedCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemDetachedCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_qitem_section uniqueKtek_qitem_section(PersistentSession session) {
		return (Ktek_qitem_section) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_qitem_section[] listKtek_qitem_section(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_qitem_section[]) list.toArray(new Ktek_qitem_section[list.size()]);
	}
}

