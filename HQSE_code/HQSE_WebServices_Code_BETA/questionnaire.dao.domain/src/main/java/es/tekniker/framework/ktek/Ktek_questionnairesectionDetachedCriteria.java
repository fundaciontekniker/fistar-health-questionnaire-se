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

public class Ktek_questionnairesectionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idquestionnairesection;
	public final StringExpression namequestionnairesection;
	public final StringExpression desquestionnairesection;
	public final StringExpression desquestionnairesectioninstructions;
	
	public Ktek_questionnairesectionDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_questionnairesection.class, es.tekniker.framework.ktek.Ktek_questionnairesectionCriteria.class);
		ktek_pk_idquestionnairesection = new IntegerExpression("ktek_pk_idquestionnairesection", this.getDetachedCriteria());
		namequestionnairesection = new StringExpression("namequestionnairesection", this.getDetachedCriteria());
		desquestionnairesection = new StringExpression("desquestionnairesection", this.getDetachedCriteria());
		desquestionnairesectioninstructions = new StringExpression("desquestionnairesectioninstructions", this.getDetachedCriteria());
	}
	
	public Ktek_questionnairesectionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_questionnairesectionCriteria.class);
		ktek_pk_idquestionnairesection = new IntegerExpression("ktek_pk_idquestionnairesection", this.getDetachedCriteria());
		namequestionnairesection = new StringExpression("namequestionnairesection", this.getDetachedCriteria());
		desquestionnairesection = new StringExpression("desquestionnairesection", this.getDetachedCriteria());
		desquestionnairesectioninstructions = new StringExpression("desquestionnairesectioninstructions", this.getDetachedCriteria());
	}
	
	public Ktek_qitem_sectionDetachedCriteria createKtek_qitem_sectionCriteria() {
		return new Ktek_qitem_sectionDetachedCriteria(createCriteria("ktek_qitem_section"));
	}
	
	public Ktek_qsection_questionnaireDetachedCriteria createKtek_qsection_questionnaireCriteria() {
		return new Ktek_qsection_questionnaireDetachedCriteria(createCriteria("ktek_qsection_questionnaire"));
	}
	
	public Ktek_result_questionnairesectionDetachedCriteria createKtek_result_questionnairesectionCriteria() {
		return new Ktek_result_questionnairesectionDetachedCriteria(createCriteria("ktek_result_questionnairesection"));
	}
	
	public Ktek_questionnairesection uniqueKtek_questionnairesection(PersistentSession session) {
		return (Ktek_questionnairesection) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesection(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_questionnairesection[]) list.toArray(new Ktek_questionnairesection[list.size()]);
	}
}

