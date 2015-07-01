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

public class Ktek_userquestionnaire_planningDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_userquestionnaire_planningDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_userquestionnaire_planningDAOImpl.class);
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_userquestionnaire_planningByORMID(session, ktek_pk_iduserquestionnaireplanning);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning getKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_userquestionnaire_planningByORMID(session, ktek_pk_iduserquestionnaireplanning);
		}
		catch (Exception e) {
			_logger.error("getKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_userquestionnaire_planningByORMID(session, ktek_pk_iduserquestionnaireplanning, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning getKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_userquestionnaire_planningByORMID(session, ktek_pk_iduserquestionnaireplanning, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_userquestionnaire_planningByORMID(int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning) throws PersistentException {
		try {
			return (Ktek_userquestionnaire_planning) session.load(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning.class, new Integer(ktek_pk_iduserquestionnaireplanning));
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning getKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning) throws PersistentException {
		try {
			return (Ktek_userquestionnaire_planning) session.get(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning.class, new Integer(ktek_pk_iduserquestionnaireplanning));
		}
		catch (Exception e) {
			_logger.error("getKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_userquestionnaire_planning) session.load(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning.class, new Integer(ktek_pk_iduserquestionnaireplanning), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning getKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_userquestionnaire_planning) session.get(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning.class, new Integer(ktek_pk_iduserquestionnaireplanning), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_userquestionnaire_planningByORMID(PersistentSession session, int ktek_pk_iduserquestionnaireplanning, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_userquestionnaire_planning(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_userquestionnaire_planning(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_userquestionnaire_planning(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_userquestionnaire_planning(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_userquestionnaire_planning(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_userquestionnaire_planning(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planningByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_userquestionnaire_planningByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planningByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_userquestionnaire_planningByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_userquestionnaire_planning(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_userquestionnaire_planning as Ktek_userquestionnaire_planning");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_userquestionnaire_planning(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_userquestionnaire_planning as Ktek_userquestionnaire_planning");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_userquestionnaire_planning", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_userquestionnaire_planning(session, condition, orderBy);
			return (Ktek_userquestionnaire_planning[]) list.toArray(new Ktek_userquestionnaire_planning[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_userquestionnaire_planning(session, condition, orderBy, lockMode);
			return (Ktek_userquestionnaire_planning[]) list.toArray(new Ktek_userquestionnaire_planning[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_userquestionnaire_planningByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_userquestionnaire_planningByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_userquestionnaire_planning[] ktek_userquestionnaire_plannings = listKtek_userquestionnaire_planningByQuery(session, condition, orderBy);
		if (ktek_userquestionnaire_plannings != null && ktek_userquestionnaire_plannings.length > 0)
			return ktek_userquestionnaire_plannings[0];
		else
			return null;
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_userquestionnaire_planning[] ktek_userquestionnaire_plannings = listKtek_userquestionnaire_planningByQuery(session, condition, orderBy, lockMode);
		if (ktek_userquestionnaire_plannings != null && ktek_userquestionnaire_plannings.length > 0)
			return ktek_userquestionnaire_plannings[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_userquestionnaire_planningByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_userquestionnaire_planningByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userquestionnaire_planningByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_userquestionnaire_planningByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userquestionnaire_planningByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_userquestionnaire_planning as Ktek_userquestionnaire_planning");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_userquestionnaire_planning as Ktek_userquestionnaire_planning");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_userquestionnaire_planning", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userquestionnaire_planningByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning createKtek_userquestionnaire_planning() {
		return new es.tekniker.framework.ktek.Ktek_userquestionnaire_planning();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_userquestionnaire_planning);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_userquestionnaire_planning);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning)throws PersistentException {
		try {
			if(ktek_userquestionnaire_planning.getKtek_fk_idquestionnaire() != null) {
				ktek_userquestionnaire_planning.getKtek_fk_idquestionnaire().getKtek_userquestionnaire_planning().remove(ktek_userquestionnaire_planning);
			}
			
			if(ktek_userquestionnaire_planning.getKtek_result_questionnaire() != null) {
				ktek_userquestionnaire_planning.getKtek_result_questionnaire().setKtek_fk_iduserquestionnaireplanning(null);
			}
			
			return delete(ktek_userquestionnaire_planning);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_userquestionnaire_planning.getKtek_fk_idquestionnaire() != null) {
				ktek_userquestionnaire_planning.getKtek_fk_idquestionnaire().getKtek_userquestionnaire_planning().remove(ktek_userquestionnaire_planning);
			}
			
			if(ktek_userquestionnaire_planning.getKtek_result_questionnaire() != null) {
				ktek_userquestionnaire_planning.getKtek_result_questionnaire().setKtek_fk_iduserquestionnaireplanning(null);
			}
			
			try {
				session.delete(ktek_userquestionnaire_planning);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_userquestionnaire_planning);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_userquestionnaire_planning);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_userquestionnaire_planning ktek_userquestionnaire_planning)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_userquestionnaire_planning loadKtek_userquestionnaire_planningByCriteria(Ktek_userquestionnaire_planningCriteria ktek_userquestionnaire_planningCriteria) {
		Ktek_userquestionnaire_planning[] ktek_userquestionnaire_plannings = listKtek_userquestionnaire_planningByCriteria(ktek_userquestionnaire_planningCriteria);
		if(ktek_userquestionnaire_plannings == null || ktek_userquestionnaire_plannings.length == 0) {
			return null;
		}
		return ktek_userquestionnaire_plannings[0];
	}
	
	public Ktek_userquestionnaire_planning[] listKtek_userquestionnaire_planningByCriteria(Ktek_userquestionnaire_planningCriteria ktek_userquestionnaire_planningCriteria) {
		return ktek_userquestionnaire_planningCriteria.listKtek_userquestionnaire_planning();
	}
}
