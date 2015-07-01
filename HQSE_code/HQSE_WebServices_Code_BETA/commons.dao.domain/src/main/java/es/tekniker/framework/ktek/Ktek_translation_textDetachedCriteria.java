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

public class Ktek_translation_textDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_translation_text;
	public final LongExpression ktek_idregister;
	public final StringExpression ktek_keycolum;
	public final StringExpression ktek_columvalue;
	
	public Ktek_translation_textDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_translation_text.class, es.tekniker.framework.ktek.Ktek_translation_textCriteria.class);
		ktek_pk_translation_text = new IntegerExpression("ktek_pk_translation_text", this.getDetachedCriteria());
		ktek_idregister = new LongExpression("ktek_idregister", this.getDetachedCriteria());
		ktek_keycolum = new StringExpression("ktek_keycolum", this.getDetachedCriteria());
		ktek_columvalue = new StringExpression("ktek_columvalue", this.getDetachedCriteria());
	}
	
	public Ktek_translation_textDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_translation_textCriteria.class);
		ktek_pk_translation_text = new IntegerExpression("ktek_pk_translation_text", this.getDetachedCriteria());
		ktek_idregister = new LongExpression("ktek_idregister", this.getDetachedCriteria());
		ktek_keycolum = new StringExpression("ktek_keycolum", this.getDetachedCriteria());
		ktek_columvalue = new StringExpression("ktek_columvalue", this.getDetachedCriteria());
	}
	
	public Ktek_languageDetachedCriteria createKtek_fk_languageCriteria() {
		return new Ktek_languageDetachedCriteria(createCriteria("ktek_fk_language"));
	}
	
	public Ktek_translation_text uniqueKtek_translation_text(PersistentSession session) {
		return (Ktek_translation_text) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_translation_text[] listKtek_translation_text(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_translation_text[]) list.toArray(new Ktek_translation_text[list.size()]);
	}
}

