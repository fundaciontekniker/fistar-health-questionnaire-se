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

public class Ktek_answersetDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_answersetDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_answersetDAOImpl.class);
	public Ktek_answerset loadKtek_answersetByORMID(int ktek_pk_idanswerset) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answersetByORMID(session, ktek_pk_idanswerset);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByORMID(int ktek_pk_idanswerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset getKtek_answersetByORMID(int ktek_pk_idanswerset) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_answersetByORMID(session, ktek_pk_idanswerset);
		}
		catch (Exception e) {
			_logger.error("getKtek_answersetByORMID(int ktek_pk_idanswerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByORMID(int ktek_pk_idanswerset, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answersetByORMID(session, ktek_pk_idanswerset, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByORMID(int ktek_pk_idanswerset, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset getKtek_answersetByORMID(int ktek_pk_idanswerset, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_answersetByORMID(session, ktek_pk_idanswerset, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_answersetByORMID(int ktek_pk_idanswerset, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset) throws PersistentException {
		try {
			return (Ktek_answerset) session.load(es.tekniker.framework.ktek.Ktek_answerset.class, new Integer(ktek_pk_idanswerset));
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset getKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset) throws PersistentException {
		try {
			return (Ktek_answerset) session.get(es.tekniker.framework.ktek.Ktek_answerset.class, new Integer(ktek_pk_idanswerset));
		}
		catch (Exception e) {
			_logger.error("getKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_answerset) session.load(es.tekniker.framework.ktek.Ktek_answerset.class, new Integer(ktek_pk_idanswerset), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset getKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_answerset) session.get(es.tekniker.framework.ktek.Ktek_answerset.class, new Integer(ktek_pk_idanswerset), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_answersetByORMID(PersistentSession session, int ktek_pk_idanswerset, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answerset(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_answerset(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_answerset(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answerset(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_answerset(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_answerset(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset[] listKtek_answersetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_answersetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset[] listKtek_answersetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_answersetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answerset(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answerset as Ktek_answerset");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_answerset(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answerset as Ktek_answerset");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_answerset", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset[] listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_answerset(session, condition, orderBy);
			return (Ktek_answerset[]) list.toArray(new Ktek_answerset[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset[] listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_answerset(session, condition, orderBy, lockMode);
			return (Ktek_answerset[]) list.toArray(new Ktek_answerset[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answersetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_answersetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_answerset[] ktek_answersets = listKtek_answersetByQuery(session, condition, orderBy);
		if (ktek_answersets != null && ktek_answersets.length > 0)
			return ktek_answersets[0];
		else
			return null;
	}
	
	public Ktek_answerset loadKtek_answersetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_answerset[] ktek_answersets = listKtek_answersetByQuery(session, condition, orderBy, lockMode);
		if (ktek_answersets != null && ktek_answersets.length > 0)
			return ktek_answersets[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_answersetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_answersetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answersetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_answersetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answersetByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answersetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answerset as Ktek_answerset");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_answersetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_answerset as Ktek_answerset");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_answerset", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_answersetByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset createKtek_answerset() {
		return new es.tekniker.framework.ktek.Ktek_answerset();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_answerset);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_answerset);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_answer[] lKtek_fk_idanswers = (es.tekniker.framework.ktek.Ktek_answer[])ktek_answerset.getKtek_fk_idanswer().toArray(new es.tekniker.framework.ktek.Ktek_answer[ktek_answerset.getKtek_fk_idanswer().size()]);
			for(int i = 0; i < lKtek_fk_idanswers.length; i++) {
				lKtek_fk_idanswers[i].getKtek_fk_idanswerset().remove(ktek_answerset);
			}
			es.tekniker.framework.ktek.Ktek_question[] lKtek_questions = (es.tekniker.framework.ktek.Ktek_question[])ktek_answerset.getKtek_question().toArray(new es.tekniker.framework.ktek.Ktek_question[ktek_answerset.getKtek_question().size()]);
			for(int i = 0; i < lKtek_questions.length; i++) {
				lKtek_questions[i].setKtek_fk_idanswerset(null);
			}
			return delete(ktek_answerset);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_answer[] lKtek_fk_idanswers = (es.tekniker.framework.ktek.Ktek_answer[])ktek_answerset.getKtek_fk_idanswer().toArray(new es.tekniker.framework.ktek.Ktek_answer[ktek_answerset.getKtek_fk_idanswer().size()]);
			for(int i = 0; i < lKtek_fk_idanswers.length; i++) {
				lKtek_fk_idanswers[i].getKtek_fk_idanswerset().remove(ktek_answerset);
			}
			es.tekniker.framework.ktek.Ktek_question[] lKtek_questions = (es.tekniker.framework.ktek.Ktek_question[])ktek_answerset.getKtek_question().toArray(new es.tekniker.framework.ktek.Ktek_question[ktek_answerset.getKtek_question().size()]);
			for(int i = 0; i < lKtek_questions.length; i++) {
				lKtek_questions[i].setKtek_fk_idanswerset(null);
			}
			try {
				session.delete(ktek_answerset);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_answerset);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_answerset);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_answerset ktek_answerset)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_answerset loadKtek_answersetByCriteria(Ktek_answersetCriteria ktek_answersetCriteria) {
		Ktek_answerset[] ktek_answersets = listKtek_answersetByCriteria(ktek_answersetCriteria);
		if(ktek_answersets == null || ktek_answersets.length == 0) {
			return null;
		}
		return ktek_answersets[0];
	}
	
	public Ktek_answerset[] listKtek_answersetByCriteria(Ktek_answersetCriteria ktek_answersetCriteria) {
		return ktek_answersetCriteria.listKtek_answerset();
	}
}
