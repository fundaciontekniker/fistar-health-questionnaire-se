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

public class Ktek_tpsettingsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final ShortExpression typecomchannel;
	
	public Ktek_tpsettingsDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_tpsettings.class, es.tekniker.framework.ktek.Ktek_tpsettingsCriteria.class);
		typecomchannel = new ShortExpression("typecomchannel", this.getDetachedCriteria());
	}
	
	public Ktek_tpsettingsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_tpsettingsCriteria.class);
		typecomchannel = new ShortExpression("typecomchannel", this.getDetachedCriteria());
	}
	
	public Ktek_userDetachedCriteria createKtek_fk_iduserCriteria() {
		return new Ktek_userDetachedCriteria(createCriteria("ktek_fk_iduser"));
	}
	
	public Ktek_languageDetachedCriteria createKtek_fk_idlanguageCriteria() {
		return new Ktek_languageDetachedCriteria(createCriteria("ktek_fk_idlanguage"));
	}
	
	public Ktek_tpsettings uniqueKtek_tpsettings(PersistentSession session) {
		return (Ktek_tpsettings) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_tpsettings[] listKtek_tpsettings(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_tpsettings[]) list.toArray(new Ktek_tpsettings[list.size()]);
	}
}

