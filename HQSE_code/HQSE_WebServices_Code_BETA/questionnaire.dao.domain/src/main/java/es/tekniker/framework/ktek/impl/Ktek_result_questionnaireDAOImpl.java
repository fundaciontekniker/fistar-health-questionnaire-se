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

public class Ktek_result_questionnaireDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_result_questionnaireDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_result_questionnaireDAOImpl.class);
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireByORMID(session, ktek_pk_idresultquestionnaire);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnaireByORMID(session, ktek_pk_idresultquestionnaire);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireByORMID(session, ktek_pk_idresultquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnaireByORMID(session, ktek_pk_idresultquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire) throws PersistentException {
		try {
			return (Ktek_result_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_result_questionnaire.class, new Integer(ktek_pk_idresultquestionnaire));
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire) throws PersistentException {
		try {
			return (Ktek_result_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_result_questionnaire.class, new Integer(ktek_pk_idresultquestionnaire));
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_result_questionnaire.class, new Integer(ktek_pk_idresultquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_result_questionnaire.class, new Integer(ktek_pk_idresultquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaire(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnaire(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnaire(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaire as Ktek_result_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaire as Ktek_result_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnaire", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_result_questionnaire(session, condition, orderBy);
			return (Ktek_result_questionnaire[]) list.toArray(new Ktek_result_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_result_questionnaire(session, condition, orderBy, lockMode);
			return (Ktek_result_questionnaire[]) list.toArray(new Ktek_result_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_result_questionnaire[] ktek_result_questionnaires = listKtek_result_questionnaireByQuery(session, condition, orderBy);
		if (ktek_result_questionnaires != null && ktek_result_questionnaires.length > 0)
			return ktek_result_questionnaires[0];
		else
			return null;
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_result_questionnaire[] ktek_result_questionnaires = listKtek_result_questionnaireByQuery(session, condition, orderBy, lockMode);
		if (ktek_result_questionnaires != null && ktek_result_questionnaires.length > 0)
			return ktek_result_questionnaires[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaire as Ktek_result_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaire as Ktek_result_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnaire", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire createKtek_result_questionnaire() {
		return new es.tekniker.framework.ktek.Ktek_result_questionnaire();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_result_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_result_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire)throws PersistentException {
		try {
			if(ktek_result_questionnaire.getKtek_fk_idquestionnaire() != null) {
				ktek_result_questionnaire.getKtek_fk_idquestionnaire().getKtek_result_questionnaire().remove(ktek_result_questionnaire);
			}
			
			if(ktek_result_questionnaire.getKtek_fk_iduserquestionnaireplanning() != null) {
				ktek_result_questionnaire.getKtek_fk_iduserquestionnaireplanning().setKtek_result_questionnaire(null);
			}
			
			es.tekniker.framework.ktek.Ktek_result_questionnairesection[] lKtek_result_questionnairesections = (es.tekniker.framework.ktek.Ktek_result_questionnairesection[])ktek_result_questionnaire.getKtek_result_questionnairesection().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnairesection[ktek_result_questionnaire.getKtek_result_questionnairesection().size()]);
			for(int i = 0; i < lKtek_result_questionnairesections.length; i++) {
				lKtek_result_questionnairesections[i].setKtek_fk_idresultquestionnaire(null);
			}
			return delete(ktek_result_questionnaire);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_result_questionnaire.getKtek_fk_idquestionnaire() != null) {
				ktek_result_questionnaire.getKtek_fk_idquestionnaire().getKtek_result_questionnaire().remove(ktek_result_questionnaire);
			}
			
			if(ktek_result_questionnaire.getKtek_fk_iduserquestionnaireplanning() != null) {
				ktek_result_questionnaire.getKtek_fk_iduserquestionnaireplanning().setKtek_result_questionnaire(null);
			}
			
			es.tekniker.framework.ktek.Ktek_result_questionnairesection[] lKtek_result_questionnairesections = (es.tekniker.framework.ktek.Ktek_result_questionnairesection[])ktek_result_questionnaire.getKtek_result_questionnairesection().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnairesection[ktek_result_questionnaire.getKtek_result_questionnairesection().size()]);
			for(int i = 0; i < lKtek_result_questionnairesections.length; i++) {
				lKtek_result_questionnairesections[i].setKtek_fk_idresultquestionnaire(null);
			}
			try {
				session.delete(ktek_result_questionnaire);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_result_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_result_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaire loadKtek_result_questionnaireByCriteria(Ktek_result_questionnaireCriteria ktek_result_questionnaireCriteria) {
		Ktek_result_questionnaire[] ktek_result_questionnaires = listKtek_result_questionnaireByCriteria(ktek_result_questionnaireCriteria);
		if(ktek_result_questionnaires == null || ktek_result_questionnaires.length == 0) {
			return null;
		}
		return ktek_result_questionnaires[0];
	}
	
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByCriteria(Ktek_result_questionnaireCriteria ktek_result_questionnaireCriteria) {
		return ktek_result_questionnaireCriteria.listKtek_result_questionnaire();
	}
}
