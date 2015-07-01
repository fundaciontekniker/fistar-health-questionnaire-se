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

public class Ktek_result_questionnaireDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idresultquestionnaire;
	public final StringExpression codtelecareprogram;
	public final StringExpression coduserid;
	public final ShortExpression evaluationscorequestionnaire;
	public final LongExpression resultcreation;
	
	public Ktek_result_questionnaireDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_result_questionnaire.class, es.tekniker.framework.ktek.Ktek_result_questionnaireCriteria.class);
		ktek_pk_idresultquestionnaire = new IntegerExpression("ktek_pk_idresultquestionnaire", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		coduserid = new StringExpression("coduserid", this.getDetachedCriteria());
		evaluationscorequestionnaire = new ShortExpression("evaluationscorequestionnaire", this.getDetachedCriteria());
		resultcreation = new LongExpression("resultcreation", this.getDetachedCriteria());
	}
	
	public Ktek_result_questionnaireDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_result_questionnaireCriteria.class);
		ktek_pk_idresultquestionnaire = new IntegerExpression("ktek_pk_idresultquestionnaire", this.getDetachedCriteria());
		codtelecareprogram = new StringExpression("codtelecareprogram", this.getDetachedCriteria());
		coduserid = new StringExpression("coduserid", this.getDetachedCriteria());
		evaluationscorequestionnaire = new ShortExpression("evaluationscorequestionnaire", this.getDetachedCriteria());
		resultcreation = new LongExpression("resultcreation", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireDetachedCriteria createKtek_fk_idquestionnaireCriteria() {
		return new Ktek_questionnaireDetachedCriteria(createCriteria("ktek_fk_idquestionnaire"));
	}
	
	public Ktek_userquestionnaire_planningDetachedCriteria createKtek_fk_iduserquestionnaireplanningCriteria() {
		return new Ktek_userquestionnaire_planningDetachedCriteria(createCriteria("ktek_fk_iduserquestionnaireplanning"));
	}
	
	public Ktek_result_questionnairesectionDetachedCriteria createKtek_result_questionnairesectionCriteria() {
		return new Ktek_result_questionnairesectionDetachedCriteria(createCriteria("ktek_result_questionnairesection"));
	}
	
	public Ktek_result_questionnaire uniqueKtek_result_questionnaire(PersistentSession session) {
		return (Ktek_result_questionnaire) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaire(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_result_questionnaire[]) list.toArray(new Ktek_result_questionnaire[list.size()]);
	}
}

