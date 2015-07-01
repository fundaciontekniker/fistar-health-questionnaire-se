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

public class Ktek_result_questionnaireitemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ktek_pk_idresultquestionnaireitem;
	public final ShortExpression typeresult;
	public final LongExpression integervalue;
	public final FloatExpression decimalvalue;
	public final StringExpression stringvalue;
	public final StringExpression textvalue;
	public final StringExpression codanswer;
	public final ShortExpression scoreanswer;
	
	public Ktek_result_questionnaireitemDetachedCriteria() {
		super(es.tekniker.framework.ktek.Ktek_result_questionnaireitem.class, es.tekniker.framework.ktek.Ktek_result_questionnaireitemCriteria.class);
		ktek_pk_idresultquestionnaireitem = new IntegerExpression("ktek_pk_idresultquestionnaireitem", this.getDetachedCriteria());
		typeresult = new ShortExpression("typeresult", this.getDetachedCriteria());
		integervalue = new LongExpression("integervalue", this.getDetachedCriteria());
		decimalvalue = new FloatExpression("decimalvalue", this.getDetachedCriteria());
		stringvalue = new StringExpression("stringvalue", this.getDetachedCriteria());
		textvalue = new StringExpression("textvalue", this.getDetachedCriteria());
		codanswer = new StringExpression("codanswer", this.getDetachedCriteria());
		scoreanswer = new ShortExpression("scoreanswer", this.getDetachedCriteria());
	}
	
	public Ktek_result_questionnaireitemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, es.tekniker.framework.ktek.Ktek_result_questionnaireitemCriteria.class);
		ktek_pk_idresultquestionnaireitem = new IntegerExpression("ktek_pk_idresultquestionnaireitem", this.getDetachedCriteria());
		typeresult = new ShortExpression("typeresult", this.getDetachedCriteria());
		integervalue = new LongExpression("integervalue", this.getDetachedCriteria());
		decimalvalue = new FloatExpression("decimalvalue", this.getDetachedCriteria());
		stringvalue = new StringExpression("stringvalue", this.getDetachedCriteria());
		textvalue = new StringExpression("textvalue", this.getDetachedCriteria());
		codanswer = new StringExpression("codanswer", this.getDetachedCriteria());
		scoreanswer = new ShortExpression("scoreanswer", this.getDetachedCriteria());
	}
	
	public Ktek_questionnaireitemDetachedCriteria createKtek_fk_idquestionnaireitemCriteria() {
		return new Ktek_questionnaireitemDetachedCriteria(createCriteria("ktek_fk_idquestionnaireitem"));
	}
	
	public Ktek_result_questionnairesectionDetachedCriteria createKtek_fk_idresultquestionnairesectionCriteria() {
		return new Ktek_result_questionnairesectionDetachedCriteria(createCriteria("ktek_fk_idresultquestionnairesection"));
	}
	
	public Ktek_result_questionnaireitem uniqueKtek_result_questionnaireitem(PersistentSession session) {
		return (Ktek_result_questionnaireitem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ktek_result_questionnaireitem[]) list.toArray(new Ktek_result_questionnaireitem[list.size()]);
	}
}

