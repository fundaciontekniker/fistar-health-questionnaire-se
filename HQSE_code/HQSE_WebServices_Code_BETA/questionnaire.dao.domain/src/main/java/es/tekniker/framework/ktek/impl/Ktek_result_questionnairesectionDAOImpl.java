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

public class Ktek_result_questionnairesectionDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_result_questionnairesectionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_result_questionnairesectionDAOImpl.class);
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnairesectionByORMID(session, ktek_pk_idresultquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection getKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnairesectionByORMID(session, ktek_pk_idresultquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnairesectionByORMID(session, ktek_pk_idresultquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection getKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnairesectionByORMID(session, ktek_pk_idresultquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnairesectionByORMID(int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection) throws PersistentException {
		try {
			return (Ktek_result_questionnairesection) session.load(es.tekniker.framework.ktek.Ktek_result_questionnairesection.class, new Integer(ktek_pk_idresultquestionnairesection));
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection getKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection) throws PersistentException {
		try {
			return (Ktek_result_questionnairesection) session.get(es.tekniker.framework.ktek.Ktek_result_questionnairesection.class, new Integer(ktek_pk_idresultquestionnairesection));
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnairesection) session.load(es.tekniker.framework.ktek.Ktek_result_questionnairesection.class, new Integer(ktek_pk_idresultquestionnairesection), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection getKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnairesection) session.get(es.tekniker.framework.ktek.Ktek_result_questionnairesection.class, new Integer(ktek_pk_idresultquestionnairesection), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idresultquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnairesection(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnairesection(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnairesection(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnairesection(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnairesection(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnairesection(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnairesection(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnairesection as Ktek_result_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnairesection(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnairesection as Ktek_result_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnairesection", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_result_questionnairesection(session, condition, orderBy);
			return (Ktek_result_questionnairesection[]) list.toArray(new Ktek_result_questionnairesection[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_result_questionnairesection(session, condition, orderBy, lockMode);
			return (Ktek_result_questionnairesection[]) list.toArray(new Ktek_result_questionnairesection[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_result_questionnairesection[] ktek_result_questionnairesections = listKtek_result_questionnairesectionByQuery(session, condition, orderBy);
		if (ktek_result_questionnairesections != null && ktek_result_questionnairesections.length > 0)
			return ktek_result_questionnairesections[0];
		else
			return null;
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_result_questionnairesection[] ktek_result_questionnairesections = listKtek_result_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		if (ktek_result_questionnairesections != null && ktek_result_questionnairesections.length > 0)
			return ktek_result_questionnairesections[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_result_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnairesection as Ktek_result_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnairesection as Ktek_result_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnairesection", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection createKtek_result_questionnairesection() {
		return new es.tekniker.framework.ktek.Ktek_result_questionnairesection();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_result_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_result_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection)throws PersistentException {
		try {
			if(ktek_result_questionnairesection.getKtek_fk_idquestionnairesection() != null) {
				ktek_result_questionnairesection.getKtek_fk_idquestionnairesection().getKtek_result_questionnairesection().remove(ktek_result_questionnairesection);
			}
			
			if(ktek_result_questionnairesection.getKtek_fk_idresultquestionnaire() != null) {
				ktek_result_questionnairesection.getKtek_fk_idresultquestionnaire().getKtek_result_questionnairesection().remove(ktek_result_questionnairesection);
			}
			
			es.tekniker.framework.ktek.Ktek_result_questionnaireitem[] lKtek_result_questionnaireitems = (es.tekniker.framework.ktek.Ktek_result_questionnaireitem[])ktek_result_questionnairesection.getKtek_result_questionnaireitem().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaireitem[ktek_result_questionnairesection.getKtek_result_questionnaireitem().size()]);
			for(int i = 0; i < lKtek_result_questionnaireitems.length; i++) {
				lKtek_result_questionnaireitems[i].setKtek_fk_idresultquestionnairesection(null);
			}
			return delete(ktek_result_questionnairesection);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_result_questionnairesection.getKtek_fk_idquestionnairesection() != null) {
				ktek_result_questionnairesection.getKtek_fk_idquestionnairesection().getKtek_result_questionnairesection().remove(ktek_result_questionnairesection);
			}
			
			if(ktek_result_questionnairesection.getKtek_fk_idresultquestionnaire() != null) {
				ktek_result_questionnairesection.getKtek_fk_idresultquestionnaire().getKtek_result_questionnairesection().remove(ktek_result_questionnairesection);
			}
			
			es.tekniker.framework.ktek.Ktek_result_questionnaireitem[] lKtek_result_questionnaireitems = (es.tekniker.framework.ktek.Ktek_result_questionnaireitem[])ktek_result_questionnairesection.getKtek_result_questionnaireitem().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaireitem[ktek_result_questionnairesection.getKtek_result_questionnaireitem().size()]);
			for(int i = 0; i < lKtek_result_questionnaireitems.length; i++) {
				lKtek_result_questionnaireitems[i].setKtek_fk_idresultquestionnairesection(null);
			}
			try {
				session.delete(ktek_result_questionnairesection);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_result_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_result_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_result_questionnairesection ktek_result_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnairesection loadKtek_result_questionnairesectionByCriteria(Ktek_result_questionnairesectionCriteria ktek_result_questionnairesectionCriteria) {
		Ktek_result_questionnairesection[] ktek_result_questionnairesections = listKtek_result_questionnairesectionByCriteria(ktek_result_questionnairesectionCriteria);
		if(ktek_result_questionnairesections == null || ktek_result_questionnairesections.length == 0) {
			return null;
		}
		return ktek_result_questionnairesections[0];
	}
	
	public Ktek_result_questionnairesection[] listKtek_result_questionnairesectionByCriteria(Ktek_result_questionnairesectionCriteria ktek_result_questionnairesectionCriteria) {
		return ktek_result_questionnairesectionCriteria.listKtek_result_questionnairesection();
	}
}
