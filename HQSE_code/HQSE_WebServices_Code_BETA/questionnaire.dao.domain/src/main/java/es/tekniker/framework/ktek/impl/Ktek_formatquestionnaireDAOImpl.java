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

public class Ktek_formatquestionnaireDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_formatquestionnaireDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_formatquestionnaireDAOImpl.class);
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_formatquestionnaireByORMID(session, ktek_pk_idformatquestionnaire);
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire getKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_formatquestionnaireByORMID(session, ktek_pk_idformatquestionnaire);
		}
		catch (Exception e) {
			_logger.error("getKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_formatquestionnaireByORMID(session, ktek_pk_idformatquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire getKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_formatquestionnaireByORMID(session, ktek_pk_idformatquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_formatquestionnaireByORMID(int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire) throws PersistentException {
		try {
			return (Ktek_formatquestionnaire) session.load(es.tekniker.framework.ktek.Ktek_formatquestionnaire.class, new Integer(ktek_pk_idformatquestionnaire));
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire getKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire) throws PersistentException {
		try {
			return (Ktek_formatquestionnaire) session.get(es.tekniker.framework.ktek.Ktek_formatquestionnaire.class, new Integer(ktek_pk_idformatquestionnaire));
		}
		catch (Exception e) {
			_logger.error("getKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_formatquestionnaire) session.load(es.tekniker.framework.ktek.Ktek_formatquestionnaire.class, new Integer(ktek_pk_idformatquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire getKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_formatquestionnaire) session.get(es.tekniker.framework.ktek.Ktek_formatquestionnaire.class, new Integer(ktek_pk_idformatquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_formatquestionnaireByORMID(PersistentSession session, int ktek_pk_idformatquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_formatquestionnaire(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_formatquestionnaire(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_formatquestionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_formatquestionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_formatquestionnaire(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_formatquestionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_formatquestionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_formatquestionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_formatquestionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_formatquestionnaire as Ktek_formatquestionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_formatquestionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_formatquestionnaire as Ktek_formatquestionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_formatquestionnaire", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_formatquestionnaire(session, condition, orderBy);
			return (Ktek_formatquestionnaire[]) list.toArray(new Ktek_formatquestionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_formatquestionnaire(session, condition, orderBy, lockMode);
			return (Ktek_formatquestionnaire[]) list.toArray(new Ktek_formatquestionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_formatquestionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_formatquestionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_formatquestionnaire[] ktek_formatquestionnaires = listKtek_formatquestionnaireByQuery(session, condition, orderBy);
		if (ktek_formatquestionnaires != null && ktek_formatquestionnaires.length > 0)
			return ktek_formatquestionnaires[0];
		else
			return null;
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_formatquestionnaire[] ktek_formatquestionnaires = listKtek_formatquestionnaireByQuery(session, condition, orderBy, lockMode);
		if (ktek_formatquestionnaires != null && ktek_formatquestionnaires.length > 0)
			return ktek_formatquestionnaires[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_formatquestionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_formatquestionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_formatquestionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_formatquestionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_formatquestionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_formatquestionnaire as Ktek_formatquestionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_formatquestionnaire as Ktek_formatquestionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_formatquestionnaire", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_formatquestionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire createKtek_formatquestionnaire() {
		return new es.tekniker.framework.ktek.Ktek_formatquestionnaire();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_formatquestionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_formatquestionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire)throws PersistentException {
		try {
			if(ktek_formatquestionnaire.getKtek_fk_questionnaire() != null) {
				ktek_formatquestionnaire.getKtek_fk_questionnaire().setKtek_formatquestionnaire(null);
			}
			
			return delete(ktek_formatquestionnaire);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_formatquestionnaire.getKtek_fk_questionnaire() != null) {
				ktek_formatquestionnaire.getKtek_fk_questionnaire().setKtek_formatquestionnaire(null);
			}
			
			try {
				session.delete(ktek_formatquestionnaire);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_formatquestionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_formatquestionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_formatquestionnaire ktek_formatquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_formatquestionnaire loadKtek_formatquestionnaireByCriteria(Ktek_formatquestionnaireCriteria ktek_formatquestionnaireCriteria) {
		Ktek_formatquestionnaire[] ktek_formatquestionnaires = listKtek_formatquestionnaireByCriteria(ktek_formatquestionnaireCriteria);
		if(ktek_formatquestionnaires == null || ktek_formatquestionnaires.length == 0) {
			return null;
		}
		return ktek_formatquestionnaires[0];
	}
	
	public Ktek_formatquestionnaire[] listKtek_formatquestionnaireByCriteria(Ktek_formatquestionnaireCriteria ktek_formatquestionnaireCriteria) {
		return ktek_formatquestionnaireCriteria.listKtek_formatquestionnaire();
	}
}
