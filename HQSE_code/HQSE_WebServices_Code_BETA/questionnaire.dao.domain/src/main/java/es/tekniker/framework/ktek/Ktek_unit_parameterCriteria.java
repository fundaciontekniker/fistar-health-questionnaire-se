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

public class Ktek_unit_parameterCriteria extends AbstractORMCriteria {
	public final FloatExpression valueconversion;
	public final ShortExpression isdefault;
	public final IntegerExpression ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem;
	public final IntegerExpression ktek_fk_idunit_ktek_pk_idunit;
	
	public Ktek_unit_parameterCriteria(Criteria criteria) {
		super(criteria);
		valueconversion = new FloatExpression("valueconversion", this);
		isdefault = new ShortExpression("isdefault", this);
		ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem", this);
		ktek_fk_idunit_ktek_pk_idunit = new IntegerExpression("ktek_fk_idunit_ktek_pk_idunit", this);
	}
	
	public Ktek_unit_parameterCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_unit_parameter.class));
	}
	
	public Ktek_unit_parameterCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_parameterCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_parameterCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_unitCriteria createKtek_fk_idunitCriteria() {
		return new Ktek_unitCriteria(createCriteria("ktek_fk_idunit"));
	}
	
	public Ktek_unit_parameter uniqueKtek_unit_parameter() {
		return (Ktek_unit_parameter) super.uniqueResult();
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameter() {
		java.util.List list = super.list();
		return (Ktek_unit_parameter[]) list.toArray(new Ktek_unit_parameter[list.size()]);
	}
}

