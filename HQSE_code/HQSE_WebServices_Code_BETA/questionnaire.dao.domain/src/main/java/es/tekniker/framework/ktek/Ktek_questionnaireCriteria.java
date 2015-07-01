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

public class Ktek_questionnaireCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idquestionnaire;
	public final StringExpression idpathology;
	public final StringExpression ktek_uk_codquestionnaire;
	public final StringExpression namequestionnaire;
	public final StringExpression desquestionnaire;
	public final StringExpression desinstructionsquestionnaire;
	public final StringExpression desevaluation;
	public final ShortExpression ismultisection;
	public final ShortExpression typequestionnaire;
	public final ShortExpression typesortorder;
	public final ShortExpression typequestionnaireflow;
	public final LongExpression datevalidfrom;
	public final LongExpression datevalidto;
	public final LongExpression datecreation;
	public final ShortExpression typemonitoringactivity;
	public final ShortExpression periodicityunit;
	public final ShortExpression periodictyvalue;
	public final LongExpression collectiontimefrom;
	public final LongExpression collectiontimeto;
	public final ShortExpression completionintervalunit;
	public final ShortExpression completionintervalvalue;
	public final ShortExpression isdeleted;
	
	public Ktek_questionnaireCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idquestionnaire = new IntegerExpression("ktek_pk_idquestionnaire", this);
		idpathology = new StringExpression("idpathology", this);
		ktek_uk_codquestionnaire = new StringExpression("ktek_uk_codquestionnaire", this);
		namequestionnaire = new StringExpression("namequestionnaire", this);
		desquestionnaire = new StringExpression("desquestionnaire", this);
		desinstructionsquestionnaire = new StringExpression("desinstructionsquestionnaire", this);
		desevaluation = new StringExpression("desevaluation", this);
		ismultisection = new ShortExpression("ismultisection", this);
		typequestionnaire = new ShortExpression("typequestionnaire", this);
		typesortorder = new ShortExpression("typesortorder", this);
		typequestionnaireflow = new ShortExpression("typequestionnaireflow", this);
		datevalidfrom = new LongExpression("datevalidfrom", this);
		datevalidto = new LongExpression("datevalidto", this);
		datecreation = new LongExpression("datecreation", this);
		typemonitoringactivity = new ShortExpression("typemonitoringactivity", this);
		periodicityunit = new ShortExpression("periodicityunit", this);
		periodictyvalue = new ShortExpression("periodictyvalue", this);
		collectiontimefrom = new LongExpression("collectiontimefrom", this);
		collectiontimeto = new LongExpression("collectiontimeto", this);
		completionintervalunit = new ShortExpression("completionintervalunit", this);
		completionintervalvalue = new ShortExpression("completionintervalvalue", this);
		isdeleted = new ShortExpression("isdeleted", this);
	}
	
	public Ktek_questionnaireCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_questionnaire.class));
	}
	
	public Ktek_questionnaireCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_formatquestionnaireCriteria createKtek_formatquestionnaireCriteria() {
		return new Ktek_formatquestionnaireCriteria(createCriteria("ktek_formatquestionnaire"));
	}
	
	public Ktek_qsection_questionnaireCriteria createKtek_qsection_questionnaireCriteria() {
		return new Ktek_qsection_questionnaireCriteria(createCriteria("ktek_qsection_questionnaire"));
	}
	
	public Ktek_result_questionnaireCriteria createKtek_result_questionnaireCriteria() {
		return new Ktek_result_questionnaireCriteria(createCriteria("ktek_result_questionnaire"));
	}
	
	public Ktek_userquestionnaire_planningCriteria createKtek_userquestionnaire_planningCriteria() {
		return new Ktek_userquestionnaire_planningCriteria(createCriteria("ktek_userquestionnaire_planning"));
	}
	
	public Ktek_questionnaire uniqueKtek_questionnaire() {
		return (Ktek_questionnaire) super.uniqueResult();
	}
	
	public Ktek_questionnaire[] listKtek_questionnaire() {
		java.util.List list = super.list();
		return (Ktek_questionnaire[]) list.toArray(new Ktek_questionnaire[list.size()]);
	}
}

