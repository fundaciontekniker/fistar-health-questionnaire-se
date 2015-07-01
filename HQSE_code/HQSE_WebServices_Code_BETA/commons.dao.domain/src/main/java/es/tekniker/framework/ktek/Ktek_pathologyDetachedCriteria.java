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

public class Ktek_pathologyDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idpathology;
	public final StringExpression ktek_uk_codpathology;
	public final StringExpression namepathology;
	public final StringExpression despathology;
	
	public Ktek_pathologyDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_pathology.class, es.tekniker.framework.ktek.Ktek_pathologyCriteria.class);
		ktek_pk_idpathology = new IntegerExpression("ktek_pk_idpathology", this.getDetachedCriteria());
		ktek_uk_codpathology = new StringExpression("ktek_uk_codpathology", this.getDetachedCriteria());
		namepathology = new StringExpression("namepathology", this.getDetachedCriteria());
		despathology = new StringExpression("despathology", this.getDetachedCriteria());
	}
	
	public Ktek_pathologyDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_pathologyCriteria.class);
		ktek_pk_idpathology = new IntegerExpression("ktek_pk_idpathology", this.getDetachedCriteria());
		ktek_uk_codpathology = new StringExpression("ktek_uk_codpathology", this.getDetachedCriteria());
		namepathology = new StringExpression("namepathology", this.getDetachedCriteria());
		despathology = new StringExpression("despathology", this.getDetachedCriteria());
	}
	
	public Ktek_pathology uniqueKtek_pathology(PersistentSession session) {
		return (Ktek_pathology) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_pathology[] listKtek_pathology(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_pathology[]) list.toArray(new Ktek_pathology[list.size()]);
	}
}

