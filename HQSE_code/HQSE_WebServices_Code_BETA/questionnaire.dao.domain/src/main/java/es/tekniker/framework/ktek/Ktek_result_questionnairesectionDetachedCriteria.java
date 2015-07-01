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

public class Ktek_result_questionnairesectionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idresultquestionnairesection;
	public final ShortExpression evaluationscorequestionnairesection;
	
	public Ktek_result_questionnairesectionDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_result_questionnairesection.class, es.tekniker.framework.ktek.Ktek_result_questionnairesectionCriteria.class);
		ktek_pk_idresultquestionnairesection = new IntegerExpression("ktek_pk_idresultquestionnairesection", this.getDetachedCriteria());
		evaluationscorequestionnairesection = new ShortExpression("evaluationscorequestionnairesection", this.getDetachedCriteria());
	}
	
	public Ktek_result_questionnairesectionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_result_questionnairesectionCriteria.class);
		ktek_pk_idresultquestionnairesection = new IntegerExpression("ktek_pk_idresultquestionnairesection", this.getDetachedCriteria());
		evaluationscorequestionnairesection = new ShortExpression("evaluationscorequestionnairesection", this.getDetachedCriteria());
	}
	
	public Ktek_questionnairesectionDetachedCriteria createKtek_fk_idquestionnairesectionCriteria() {
		return new Ktek_questionnairesectionDetachedCriteria(createCriteria("ktek_fk_idquestionnairesection"));
	}
	
	public Ktek_result_questionnaireDetachedCriteria createKtek_fk_idresultquestionnaireCriteria() {
		return new Ktek_result_questionnaireDetachedCriteria(createCriteria("ktek_fk_idresultquestionnaire"));
	}
	
	public Ktek_result_questionnaireitemDetachedCriteria createKtek_result_questionnaireitemCriteria() {
		return new Ktek_result_questionnaireitemDetachedCriteria(createCriteria("ktek_result_questionnaireitem"));
	}
	
	public Ktek_result_questionnairesection uniqueKtek_result_questionnairesection(PersistentSession session) {
		return (Ktek_result_questionnairesection) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesection(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_result_questionnairesection[]) list.toArray(new Ktek_result_questionnairesection[list.size()]);
	}
}

