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

public class Ktek_questionnaireDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Ktek_questionnaireDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_questionnaire.class, es.tekniker.framework.ktek.Ktek_questionnaireCriteria.class);
		ktek_pk_idquestionnaire = new IntegerExpression("ktek_pk_idquestionnaire", this.getDetachedCriteria());
		idpathology = new StringExpression("idpathology", this.getDetachedCriteria());
		ktek_uk_codquestionnaire = new StringExpression("ktek_uk_codquestionnaire", this.getDetachedCriteria());
		namequestionnaire = new StringExpression("namequestionnaire", this.getDetachedCriteria());
		desquestionnaire = new StringExpression("desquestionnaire", this.getDetachedCriteria());
		desinstructionsquestionnaire = new StringExpression("desinstructionsquestionnaire", this.getDetachedCriteria());
		desevaluation = new StringExpression("desevaluation", this.getDetachedCriteria());
		ismultisection = new ShortExpression("ismultisection", this.getDetachedCriteria());
		typequestionnaire = new ShortExpression("typequestionnaire", this.getDetachedCriteria());
		typesortorder = new ShortExpression("typesortorder", this.getDetachedCriteria());
		typequestionnaireflow = new ShortExpression("typequestionnaireflow", this.getDetachedCriteria());
		datevalidfrom = new LongExpression("datevalidfrom", this.getDetachedCriteria());
		datevalidto = new LongExpression("datevalidto", this.getDetachedCriteria());
		datecreation = new LongExpression("datecreation", this.getDetachedCriteria());
		typemonitoringactivity = new ShortExpression("typemonitoringactivity", this.getDetachedCriteria());
		periodicityunit = new ShortExpression("periodicityunit", this.getDetachedCriteria());
		periodictyvalue = new ShortExpression("periodictyvalue", this.getDetachedCriteria());
		collectiontimefrom = new LongExpression("collectiontimefrom", this.getDetachedCriteria());
		collectiontimeto = new LongExpression("collectiontimeto", this.getDetachedCriteria());
		completionintervalunit = new ShortExpression("completionintervalunit", this.getDetachedCriteria());
		completionintervalvalue = new ShortExpression("completionintervalvalue", this.getDetachedCriteria());
		isdeleted = new ShortExpression("isdeleted", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_questionnaireCriteria.class);
		ktek_pk_idquestionnaire = new IntegerExpression("ktek_pk_idquestionnaire", this.getDetachedCriteria());
		idpathology = new StringExpression("idpathology", this.getDetachedCriteria());
		ktek_uk_codquestionnaire = new StringExpression("ktek_uk_codquestionnaire", this.getDetachedCriteria());
		namequestionnaire = new StringExpression("namequestionnaire", this.getDetachedCriteria());
		desquestionnaire = new StringExpression("desquestionnaire", this.getDetachedCriteria());
		desinstructionsquestionnaire = new StringExpression("desinstructionsquestionnaire", this.getDetachedCriteria());
		desevaluation = new StringExpression("desevaluation", this.getDetachedCriteria());
		ismultisection = new ShortExpression("ismultisection", this.getDetachedCriteria());
		typequestionnaire = new ShortExpression("typequestionnaire", this.getDetachedCriteria());
		typesortorder = new ShortExpression("typesortorder", this.getDetachedCriteria());
		typequestionnaireflow = new ShortExpression("typequestionnaireflow", this.getDetachedCriteria());
		datevalidfrom = new LongExpression("datevalidfrom", this.getDetachedCriteria());
		datevalidto = new LongExpression("datevalidto", this.getDetachedCriteria());
		datecreation = new LongExpression("datecreation", this.getDetachedCriteria());
		typemonitoringactivity = new ShortExpression("typemonitoringactivity", this.getDetachedCriteria());
		periodicityunit = new ShortExpression("periodicityunit", this.getDetachedCriteria());
		periodictyvalue = new ShortExpression("periodictyvalue", this.getDetachedCriteria());
		collectiontimefrom = new LongExpression("collectiontimefrom", this.getDetachedCriteria());
		collectiontimeto = new LongExpression("collectiontimeto", this.getDetachedCriteria());
		completionintervalunit = new ShortExpression("completionintervalunit", this.getDetachedCriteria());
		completionintervalvalue = new ShortExpression("completionintervalvalue", this.getDetachedCriteria());
		isdeleted = new ShortExpression("isdeleted", this.getDetachedCriteria());
	}
	
	public Ktek_formatquestionnaireDetachedCriteria createKtek_formatquestionnaireCriteria() {
		return new Ktek_formatquestionnaireDetachedCriteria(createCriteria("ktek_formatquestionnaire"));
	}
	
	public Ktek_qsection_questionnaireDetachedCriteria createKtek_qsection_questionnaireCriteria() {
		return new Ktek_qsection_questionnaireDetachedCriteria(createCriteria("ktek_qsection_questionnaire"));
	}
	
	public Ktek_result_questionnaireDetachedCriteria createKtek_result_questionnaireCriteria() {
		return new Ktek_result_questionnaireDetachedCriteria(createCriteria("ktek_result_questionnaire"));
	}
	
	public Ktek_userquestionnaire_planningDetachedCriteria createKtek_userquestionnaire_planningCriteria() {
		return new Ktek_userquestionnaire_planningDetachedCriteria(createCriteria("ktek_userquestionnaire_planning"));
	}
	
	public Ktek_questionnaire uniqueKtek_questionnaire(PersistentSession session) {
		return (Ktek_questionnaire) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_questionnaire[] listKtek_questionnaire(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_questionnaire[]) list.toArray(new Ktek_questionnaire[list.size()]);
	}
}

