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

public class Ktek_unitDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idunit;
	public final StringExpression ktek_uk_codunit;
	
	public Ktek_unitDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_unit.class, es.tekniker.framework.ktek.Ktek_unitCriteria.class);
		ktek_pk_idunit = new IntegerExpression("ktek_pk_idunit", this.getDetachedCriteria());
		ktek_uk_codunit = new StringExpression("ktek_uk_codunit", this.getDetachedCriteria());
	}
	
	public Ktek_unitDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_unitCriteria.class);
		ktek_pk_idunit = new IntegerExpression("ktek_pk_idunit", this.getDetachedCriteria());
		ktek_uk_codunit = new StringExpression("ktek_uk_codunit", this.getDetachedCriteria());
	}
	
	public Ktek_unit_parameterDetachedCriteria createKtek_unit_parameterCriteria() {
		return new Ktek_unit_parameterDetachedCriteria(createCriteria("ktek_unit_parameter"));
	}
	
	public Ktek_unit uniqueKtek_unit(PersistentSession session) {
		return (Ktek_unit) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_unit[] listKtek_unit(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_unit[]) list.toArray(new Ktek_unit[list.size()]);
	}
}

