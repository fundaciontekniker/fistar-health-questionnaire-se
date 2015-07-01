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

public class Ktek_questionnaireitemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idquestionnaireitem;
	public final StringExpression ktek_uk_codquestionnaireitem;
	public final StringExpression namequestionnaireitem;
	public final StringExpression desquestionnaireitem;
	public final ShortExpression typequestionnaireitem;
	public final ShortExpression isrequired;
	public final ShortExpression isdeleted;
	
	public Ktek_questionnaireitemDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_questionnaireitem.class, es.tekniker.framework.ktek.Ktek_questionnaireitemCriteria.class);
		ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_pk_idquestionnaireitem", this.getDetachedCriteria());
		ktek_uk_codquestionnaireitem = new StringExpression("ktek_uk_codquestionnaireitem", this.getDetachedCriteria());
		namequestionnaireitem = new StringExpression("namequestionnaireitem", this.getDetachedCriteria());
		desquestionnaireitem = new StringExpression("desquestionnaireitem", this.getDetachedCriteria());
		typequestionnaireitem = new ShortExpression("typequestionnaireitem", this.getDetachedCriteria());
		isrequired = new ShortExpression("isrequired", this.getDetachedCriteria());
		isdeleted = new ShortExpression("isdeleted", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireitemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_questionnaireitemCriteria.class);
		ktek_pk_idquestionnaireitem = new IntegerExpression("ktek_pk_idquestionnaireitem", this.getDetachedCriteria());
		ktek_uk_codquestionnaireitem = new StringExpression("ktek_uk_codquestionnaireitem", this.getDetachedCriteria());
		namequestionnaireitem = new StringExpression("namequestionnaireitem", this.getDetachedCriteria());
		desquestionnaireitem = new StringExpression("desquestionnaireitem", this.getDetachedCriteria());
		typequestionnaireitem = new ShortExpression("typequestionnaireitem", this.getDetachedCriteria());
		isrequired = new ShortExpression("isrequired", this.getDetachedCriteria());
		isdeleted = new ShortExpression("isdeleted", this.getDetachedCriteria());
	}
	
	public Ktek_parameterDetachedCriteria createKtek_parameterCriteria() {
		return new Ktek_parameterDetachedCriteria(createCriteria("ktek_parameter"));
	}
	
	public Ktek_qitem_sectionDetachedCriteria createKtek_qitem_sectionCriteria() {
		return new Ktek_qitem_sectionDetachedCriteria(createCriteria("ktek_qitem_section"));
	}
	
	public Ktek_questionDetachedCriteria createKtek_questionCriteria() {
		return new Ktek_questionDetachedCriteria(createCriteria("ktek_question"));
	}
	
	public Ktek_questionnaireitem_codificationDetachedCriteria createKtek_questionnaireitem_codificationCriteria() {
		return new Ktek_questionnaireitem_codificationDetachedCriteria(createCriteria("ktek_questionnaireitem_codification"));
	}
	
	public Ktek_result_questionnaireitemDetachedCriteria createKtek_result_questionnaireitemCriteria() {
		return new Ktek_result_questionnaireitemDetachedCriteria(createCriteria("ktek_result_questionnaireitem"));
	}
	
	public Ktek_questionnaireitem uniqueKtek_questionnaireitem(PersistentSession session) {
		return (Ktek_questionnaireitem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_questionnaireitem[]) list.toArray(new Ktek_questionnaireitem[list.size()]);
	}
}

