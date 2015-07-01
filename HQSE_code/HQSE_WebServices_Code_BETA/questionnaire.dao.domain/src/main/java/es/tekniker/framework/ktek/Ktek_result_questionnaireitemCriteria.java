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

public class Ktek_result_questionnaireitemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ktek_pk_idresultquestionnaireitem;
	public final ShortExpression typeresult;
	public final LongExpression integervalue;
	public final FloatExpression decimalvalue;
	public final StringExpression stringvalue;
	public final StringExpression textvalue;
	public final StringExpression codanswer;
	public final ShortExpression scoreanswer;
	
	public Ktek_result_questionnaireitemCriteria(Criteria criteria) {
		super(criteria);
		ktek_pk_idresultquestionnaireitem = new IntegerExpression("ktek_pk_idresultquestionnaireitem", this);
		typeresult = new ShortExpression("typeresult", this);
		integervalue = new LongExpression("integervalue", this);
		decimalvalue = new FloatExpression("decimalvalue", this);
		stringvalue = new StringExpression("stringvalue", this);
		textvalue = new StringExpression("textvalue", this);
		codanswer = new StringExpression("codanswer", this);
		scoreanswer = new ShortExpression("scoreanswer", this);
	}
	
	public Ktek_result_questionnaireitemCriteria(PersistentSession session) {
		this(session.createCriteria(Ktek_result_questionnaireitem.class));
	}
	
	public Ktek_result_questionnaireitemCriteria() throws PersistentException {
		this(es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession());
	}
	
	public Ktek_questionnaireitemCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_result_questionnairesectionCriteria createKtek_fk_idresultquestionnairesectionCriteria() {
		return new Ktek_result_questionnairesectionCriteria(createCriteria("ktek_fk_idresultquestionnairesection"));
	}
	
	public Ktek_result_questionnaireitem uniqueKtek_result_questionnaireitem() {
		return (Ktek_result_questionnaireitem) super.uniqueResult();
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitem() {
		java.util.List list = super.list();
		return (Ktek_result_questionnaireitem[]) list.toArray(new Ktek_result_questionnaireitem[list.size()]);
	}
}

