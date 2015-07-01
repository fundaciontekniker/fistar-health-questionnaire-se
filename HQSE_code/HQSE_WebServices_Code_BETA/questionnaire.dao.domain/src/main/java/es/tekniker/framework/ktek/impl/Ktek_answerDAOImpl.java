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

public class Ktek_answerDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_answerDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_answerDAOImpl.class);
	public Ktek_answer loadKtek_answerByORMID(int ktek_pk_idanswer) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answerByORMID(session, ktek_pk_idanswer);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByORMID(int ktek_pk_idanswer)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer getKtek_answerByORMID(int ktek_pk_idanswer) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_answerByORMID(session, ktek_pk_idanswer);
		}
		catch (Exception e) {
			_logger.error("getKtek_answerByORMID(int ktek_pk_idanswer)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByORMID(int ktek_pk_idanswer, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answerByORMID(session, ktek_pk_idanswer, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByORMID(int ktek_pk_idanswer, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer getKtek_answerByORMID(int ktek_pk_idanswer, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_answerByORMID(session, ktek_pk_idanswer, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_answerByORMID(int ktek_pk_idanswer, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer) throws PersistentException {
		try {
			return (Ktek_answer) session.load(es.tekniker.framework.ktek.Ktek_answer.class, new Integer(ktek_pk_idanswer));
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer getKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer) throws PersistentException {
		try {
			return (Ktek_answer) session.get(es.tekniker.framework.ktek.Ktek_answer.class, new Integer(ktek_pk_idanswer));
		}
		catch (Exception e) {
			_logger.error("getKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_answer) session.load(es.tekniker.framework.ktek.Ktek_answer.class, new Integer(ktek_pk_idanswer), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer getKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_answer) session.get(es.tekniker.framework.ktek.Ktek_answer.class, new Integer(ktek_pk_idanswer), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_answerByORMID(PersistentSession session, int ktek_pk_idanswer, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answer(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_answer(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_answer(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answer(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_answer(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_answer(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer[] listKtek_answerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_answerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer[] listKtek_answerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_answerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answer(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answer as Ktek_answer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answer(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answer as Ktek_answer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_answer", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer[] listKtek_answerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_answer(session, condition, orderBy);
			return (Ktek_answer[]) list.toArray(new Ktek_answer[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer[] listKtek_answerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_answer(session, condition, orderBy, lockMode);
			return (Ktek_answer[]) list.toArray(new Ktek_answer[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_answer[] ktek_answers = listKtek_answerByQuery(session, condition, orderBy);
		if (ktek_answers != null && ktek_answers.length > 0)
			return ktek_answers[0];
		else
			return null;
	}
	
	public Ktek_answer loadKtek_answerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_answer[] ktek_answers = listKtek_answerByQuery(session, condition, orderBy, lockMode);
		if (ktek_answers != null && ktek_answers.length > 0)
			return ktek_answers[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_answerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_answerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_answerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answerByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answer as Ktek_answer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answer as Ktek_answer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_answer", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answerByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer createKtek_answer() {
		return new es.tekniker.framework.ktek.Ktek_answer();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_answer ktek_answer) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_answer);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_answer ktek_answer)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_answer ktek_answer) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_answer);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_answer ktek_answer)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_answer ktek_answer)throws PersistentException {
		try {
			if(ktek_answer.getKtek_fk_idquestionnaireitem() != null) {
				ktek_answer.getKtek_fk_idquestionnaireitem().getKtek_answer().remove(ktek_answer);
			}
			
			es.tekniker.framework.ktek.Ktek_answerset[] lKtek_fk_idanswersets = (es.tekniker.framework.ktek.Ktek_answerset[])ktek_answer.getKtek_fk_idanswerset().toArray(new es.tekniker.framework.ktek.Ktek_answerset[ktek_answer.getKtek_fk_idanswerset().size()]);
			for(int i = 0; i < lKtek_fk_idanswersets.length; i++) {
				lKtek_fk_idanswersets[i].getKtek_fk_idanswer().remove(ktek_answer);
			}
			return delete(ktek_answer);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_answer ktek_answer, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_answer.getKtek_fk_idquestionnaireitem() != null) {
				ktek_answer.getKtek_fk_idquestionnaireitem().getKtek_answer().remove(ktek_answer);
			}
			
			es.tekniker.framework.ktek.Ktek_answerset[] lKtek_fk_idanswersets = (es.tekniker.framework.ktek.Ktek_answerset[])ktek_answer.getKtek_fk_idanswerset().toArray(new es.tekniker.framework.ktek.Ktek_answerset[ktek_answer.getKtek_fk_idanswerset().size()]);
			for(int i = 0; i < lKtek_fk_idanswersets.length; i++) {
				lKtek_fk_idanswersets[i].getKtek_fk_idanswer().remove(ktek_answer);
			}
			try {
				session.delete(ktek_answer);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_answer ktek_answer) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_answer);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_answer ktek_answer)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_answer ktek_answer) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_answer);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_answer ktek_answer)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answer loadKtek_answerByCriteria(Ktek_answerCriteria ktek_answerCriteria) {
		Ktek_answer[] ktek_answers = listKtek_answerByCriteria(ktek_answerCriteria);
		if(ktek_answers == null || ktek_answers.length == 0) {
			return null;
		}
		return ktek_answers[0];
	}
	
	public Ktek_answer[] listKtek_answerByCriteria(Ktek_answerCriteria ktek_answerCriteria) {
		return ktek_answerCriteria.listKtek_answer();
	}
}
