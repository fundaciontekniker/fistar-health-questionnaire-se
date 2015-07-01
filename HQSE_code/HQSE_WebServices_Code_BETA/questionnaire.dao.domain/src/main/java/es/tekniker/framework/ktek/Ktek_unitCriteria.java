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

public class Ktek_unitCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idunit;
	public final StringExpression ktek_uk_codunit;
	
	public Ktek_unitCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idunit = new IntegerExpression("ktek_pk_idunit", this);
		ktek_uk_codunit = new StringExpression("ktek_uk_codunit", this);
	}
	
	public Ktek_unitCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_unit.class));
	}
	
	public Ktek_unitCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_unit_parameterCriteria createKtek_unit_parameterCriteria() {
		return new Ktek_unit_parameterCriteria(createCriteria("ktek_unit_parameter"));
	}
	
	public Ktek_unit uniqueKtek_unit() {
		return (Ktek_unit) super.uniqueResult();
	}
	
	public Ktek_unit[] listKtek_unit() {
		java.util.List list = super.list();
		return (Ktek_unit[]) list.toArray(new Ktek_unit[list.size()]);
	}
}

