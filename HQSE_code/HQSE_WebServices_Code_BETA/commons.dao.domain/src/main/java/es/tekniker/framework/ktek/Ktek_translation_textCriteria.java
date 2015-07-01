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

public class Ktek_translation_textCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_translation_text;
	public final LongExpression ktek_idregister;
	public final StringExpression ktek_keycolum;
	public final StringExpression ktek_columvalue;
	
	public Ktek_translation_textCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_translation_text = new IntegerExpression("ktek_pk_translation_text", this);
		ktek_idregister = new LongExpression("ktek_idregister", this);
		ktek_keycolum = new StringExpression("ktek_keycolum", this);
		ktek_columvalue = new StringExpression("ktek_columvalue", this);
	}
	
	public Ktek_translation_textCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_translation_text.class));
	}
	
	public Ktek_translation_textCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_languageCriteria createKtek_fk_languageCriteria() {
		return new Ktek_languageCriteria(createCriteria("ktek_fk_language"));
	}
	
	public Ktek_translation_text uniqueKtek_translation_text() {
		return (Ktek_translation_text) super.uniqueResult();
	}
	
	public Ktek_translation_text[] listKtek_translation_text() {
		java.util.List list = super.list();
		return (Ktek_translation_text[]) list.toArray(new Ktek_translation_text[list.size()]);
	}
}

