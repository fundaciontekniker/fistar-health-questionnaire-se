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

public class Ktek_unit_parameterDetachedCriteria extends AbstractORMDetachedCriteria {
	public final FloatExpression valueconversion;
	public final ShortExpression isdefault;
	public final IntegerExpression ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem;
	public final IntegerExpression ktek_fk_idunit_ktek_pk_idunit;
	
	public Ktek_unit_parameterDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_unit_parameter.class, es.tekniker.framework.ktek.Ktek_unit_parameterCriteria.class);
		valueconversion = new FloatExpression("valueconversion", this.getDetachedCriteria());
		isdefault = new ShortExpression("isdefault", this.getDetachedCriteria());
		ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem", this.getDetachedCriteria());
		ktek_fk_idunit_ktek_pk_idunit = new IntegerExpression("ktek_fk_idunit_ktek_pk_idunit", this.getDetachedCriteria());
	}
	
	public Ktek_unit_parameterDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_unit_parameterCriteria.class);
		valueconversion = new FloatExpression("valueconversion", this.getDetachedCriteria());
		isdefault = new ShortExpression("isdefault", this.getDetachedCriteria());
		ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem = new IntegerExpression("ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem", this.getDetachedCriteria());
		ktek_fk_idunit_ktek_pk_idunit = new IntegerExpression("ktek_fk_idunit_ktek_pk_idunit", this.getDetachedCriteria());
	}
	
	public Ktek_parameterDetachedCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_parameterDetachedCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_unitDetachedCriteria createKtek_fk_idunitCriteria() {
		return new Ktek_unitDetachedCriteria(createCriteria("ktek_fk_idunit"));
	}
	
	public Ktek_unit_parameter uniqueKtek_unit_parameter(PersistentSession session) {
		return (Ktek_unit_parameter) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameter(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_unit_parameter[]) list.toArray(new Ktek_unit_parameter[list.size()]);
	}
}

