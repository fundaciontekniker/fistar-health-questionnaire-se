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

public class Ktek_languageCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idlanguage;
	public final StringExpression ktek_uk_codlanguage;
	public final StringExpression deslanguage;
	public final ShortExpression isdefault;
	
	public Ktek_languageCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idlanguage = new IntegerExpression("ktek_pk_idlanguage", this);
		ktek_uk_codlanguage = new StringExpression("ktek_uk_codlanguage", this);
		deslanguage = new StringExpression("deslanguage", this);
		isdefault = new ShortExpression("isdefault", this);
	}
	
	public Ktek_languageCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_language.class));
	}
	
	public Ktek_languageCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_tpsettingsCriteria createKtek_tpsettingsCriteria() {
		return new Ktek_tpsettingsCriteria(createCriteria("ktek_tpsettings"));
	}
	
	public Ktek_translation_textCriteria createKtek_translation_textCriteria() {
		return new Ktek_translation_textCriteria(createCriteria("ktek_translation_text"));
	}
	
	public Ktek_language uniqueKtek_language() {
		return (Ktek_language) super.uniqueResult();
	}
	
	public Ktek_language[] listKtek_language() {
		java.util.List list = super.list();
		return (Ktek_language[]) list.toArray(new Ktek_language[list.size()]);
	}
}

