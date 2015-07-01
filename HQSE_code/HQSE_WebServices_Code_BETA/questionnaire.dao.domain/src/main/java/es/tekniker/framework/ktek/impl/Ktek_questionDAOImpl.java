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
package es.tekniker.framework.ktek.impl;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;
import es.tekniker.framework.ktek.*;

public class Ktek_questionDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionDAOImpl.class);
	public List queryKtek_question(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_question(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_question(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_question(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_question(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_question(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question[] listKtek_questionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question[] listKtek_questionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_question(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_question as Ktek_question");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_question(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_question as Ktek_question");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_question", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question[] listKtek_questionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_question(session, condition, orderBy);
			return (Ktek_question[]) list.toArray(new Ktek_question[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question[] listKtek_questionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_question(session, condition, orderBy, lockMode);
			return (Ktek_question[]) list.toArray(new Ktek_question[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question loadKtek_questionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question loadKtek_questionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question loadKtek_questionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_question[] ktek_questions = listKtek_questionByQuery(session, condition, orderBy);
		if (ktek_questions != null && ktek_questions.length > 0)
			return ktek_questions[0];
		else
			return null;
	}
	
	public Ktek_question loadKtek_questionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_question[] ktek_questions = listKtek_questionByQuery(session, condition, orderBy, lockMode);
		if (ktek_questions != null && ktek_questions.length > 0)
			return ktek_questions[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_question as Ktek_question");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_question as Ktek_question");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_question", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question createKtek_question() {
		return new es.tekniker.framework.ktek.Ktek_question();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_question ktek_question) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_question);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_question ktek_question)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_question ktek_question) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_question);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_question ktek_question)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_question ktek_question)throws PersistentException {
		try {
			if(ktek_question.getKtek_fk_idquestionnaireitem() != null) {
				ktek_question.getKtek_fk_idquestionnaireitem().setKtek_question(null);
			}
			
			if(ktek_question.getKtek_fk_idanswerset() != null) {
				ktek_question.getKtek_fk_idanswerset().getKtek_question().remove(ktek_question);
			}
			
			es.tekniker.framework.ktek.Ktek_answer[] lKtek_answers = (es.tekniker.framework.ktek.Ktek_answer[])ktek_question.getKtek_answer().toArray(new es.tekniker.framework.ktek.Ktek_answer[ktek_question.getKtek_answer().size()]);
			for(int i = 0; i < lKtek_answers.length; i++) {
				lKtek_answers[i].setKtek_fk_idquestionnaireitem(null);
			}
			return delete(ktek_question);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_question ktek_question, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_question.getKtek_fk_idquestionnaireitem() != null) {
				ktek_question.getKtek_fk_idquestionnaireitem().setKtek_question(null);
			}
			
			if(ktek_question.getKtek_fk_idanswerset() != null) {
				ktek_question.getKtek_fk_idanswerset().getKtek_question().remove(ktek_question);
			}
			
			es.tekniker.framework.ktek.Ktek_answer[] lKtek_answers = (es.tekniker.framework.ktek.Ktek_answer[])ktek_question.getKtek_answer().toArray(new es.tekniker.framework.ktek.Ktek_answer[ktek_question.getKtek_answer().size()]);
			for(int i = 0; i < lKtek_answers.length; i++) {
				lKtek_answers[i].setKtek_fk_idquestionnaireitem(null);
			}
			try {
				session.delete(ktek_question);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_question ktek_question) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_question);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_question ktek_question)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_question ktek_question) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_question);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_question ktek_question)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_question loadKtek_questionByCriteria(Ktek_questionCriteria ktek_questionCriteria) {
		Ktek_question[] ktek_questions = listKtek_questionByCriteria(ktek_questionCriteria);
		if(ktek_questions == null || ktek_questions.length == 0) {
			return null;
		}
		return ktek_questions[0];
	}
	
	public Ktek_question[] listKtek_questionByCriteria(Ktek_questionCriteria ktek_questionCriteria) {
		return ktek_questionCriteria.listKtek_question();
	}
}
