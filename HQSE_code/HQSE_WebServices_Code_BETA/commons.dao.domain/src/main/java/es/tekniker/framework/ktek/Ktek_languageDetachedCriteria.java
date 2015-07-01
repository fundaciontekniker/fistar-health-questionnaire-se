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

public class Ktek_languageDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idlanguage;
	public final StringExpression ktek_uk_codlanguage;
	public final StringExpression deslanguage;
	public final ShortExpression isdefault;
	
	public Ktek_languageDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_language.class, es.tekniker.framework.ktek.Ktek_languageCriteria.class);
		ktek_pk_idlanguage = new IntegerExpression("ktek_pk_idlanguage", this.getDetachedCriteria());
		ktek_uk_codlanguage = new StringExpression("ktek_uk_codlanguage", this.getDetachedCriteria());
		deslanguage = new StringExpression("deslanguage", this.getDetachedCriteria());
		isdefault = new ShortExpression("isdefault", this.getDetachedCriteria());
	}
	
	public Ktek_languageDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_languageCriteria.class);
		ktek_pk_idlanguage = new IntegerExpression("ktek_pk_idlanguage", this.getDetachedCriteria());
		ktek_uk_codlanguage = new StringExpression("ktek_uk_codlanguage", this.getDetachedCriteria());
		deslanguage = new StringExpression("deslanguage", this.getDetachedCriteria());
		isdefault = new ShortExpression("isdefault", this.getDetachedCriteria());
	}
	
	public Ktek_tpsettingsDetachedCriteria createKtek_tpsettingsCriteria() {
		return new Ktek_tpsettingsDetachedCriteria(createCriteria("ktek_tpsettings"));
	}
	
	public Ktek_translation_textDetachedCriteria createKtek_translation_textCriteria() {
		return new Ktek_translation_textDetachedCriteria(createCriteria("ktek_translation_text"));
	}
	
	public Ktek_language uniqueKtek_language(PersistentSession session) {
		return (Ktek_language) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_language[] listKtek_language(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_language[]) list.toArray(new Ktek_language[list.size()]);
	}
}

