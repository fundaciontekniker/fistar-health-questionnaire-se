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

public class Ktek_codificationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idcodification;
	public final StringExpression codcodification;
	public final StringExpression descodification;
	
	public Ktek_codificationCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idcodification = new IntegerExpression("ktek_pk_idcodification", this);
		codcodification = new StringExpression("codcodification", this);
		descodification = new StringExpression("descodification", this);
	}
	
	public Ktek_codificationCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_codification.class));
	}
	
	public Ktek_codificationCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireitem_codificationCriteria createKtek_questionnaireitem_codificationCriteria() {
		return new Ktek_questionnaireitem_codificationCriteria(createCriteria("ktek_questionnaireitem_codification"));
	}
	
	public Ktek_codification uniqueKtek_codification() {
		return (Ktek_codification) super.uniqueResult();
	}
	
	public Ktek_codification[] listKtek_codification() {
		java.util.List list = super.list();
		return (Ktek_codification[]) list.toArray(new Ktek_codification[list.size()]);
	}
}

