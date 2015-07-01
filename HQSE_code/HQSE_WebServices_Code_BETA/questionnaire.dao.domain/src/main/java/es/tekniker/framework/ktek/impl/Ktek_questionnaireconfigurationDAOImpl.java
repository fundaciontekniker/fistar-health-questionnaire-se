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

public class Ktek_questionnaireconfigurationDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionnaireconfigurationDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionnaireconfigurationDAOImpl.class);
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireconfigurationByORMID(session, ktek_pk_ktek_idquestionnaireconfiguration);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration getKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireconfigurationByORMID(session, ktek_pk_ktek_idquestionnaireconfiguration);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireconfigurationByORMID(session, ktek_pk_ktek_idquestionnaireconfiguration, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration getKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireconfigurationByORMID(session, ktek_pk_ktek_idquestionnaireconfiguration, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireconfigurationByORMID(int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration) throws PersistentException {
		try {
			return (Ktek_questionnaireconfiguration) session.load(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration.class, new Integer(ktek_pk_ktek_idquestionnaireconfiguration));
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration getKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration) throws PersistentException {
		try {
			return (Ktek_questionnaireconfiguration) session.get(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration.class, new Integer(ktek_pk_ktek_idquestionnaireconfiguration));
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaireconfiguration) session.load(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration.class, new Integer(ktek_pk_ktek_idquestionnaireconfiguration), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration getKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaireconfiguration) session.get(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration.class, new Integer(ktek_pk_ktek_idquestionnaireconfiguration), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireconfigurationByORMID(PersistentSession session, int ktek_pk_ktek_idquestionnaireconfiguration, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireconfiguration(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireconfiguration(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireconfiguration(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireconfiguration(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireconfiguration(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireconfiguration(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfigurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireconfigurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfigurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireconfigurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireconfiguration(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireconfiguration as Ktek_questionnaireconfiguration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireconfiguration(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireconfiguration as Ktek_questionnaireconfiguration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireconfiguration", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_questionnaireconfiguration(session, condition, orderBy);
			return (Ktek_questionnaireconfiguration[]) list.toArray(new Ktek_questionnaireconfiguration[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_questionnaireconfiguration(session, condition, orderBy, lockMode);
			return (Ktek_questionnaireconfiguration[]) list.toArray(new Ktek_questionnaireconfiguration[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireconfigurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireconfigurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_questionnaireconfiguration[] ktek_questionnaireconfigurations = listKtek_questionnaireconfigurationByQuery(session, condition, orderBy);
		if (ktek_questionnaireconfigurations != null && ktek_questionnaireconfigurations.length > 0)
			return ktek_questionnaireconfigurations[0];
		else
			return null;
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_questionnaireconfiguration[] ktek_questionnaireconfigurations = listKtek_questionnaireconfigurationByQuery(session, condition, orderBy, lockMode);
		if (ktek_questionnaireconfigurations != null && ktek_questionnaireconfigurations.length > 0)
			return ktek_questionnaireconfigurations[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionnaireconfigurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireconfigurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireconfigurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireconfigurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireconfigurationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireconfiguration as Ktek_questionnaireconfiguration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireconfiguration as Ktek_questionnaireconfiguration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireconfiguration", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireconfigurationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration createKtek_questionnaireconfiguration() {
		return new es.tekniker.framework.ktek.Ktek_questionnaireconfiguration();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_questionnaireconfiguration);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_questionnaireconfiguration);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_questionnaireconfiguration);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_questionnaireconfiguration);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_questionnaireconfiguration ktek_questionnaireconfiguration)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireconfiguration loadKtek_questionnaireconfigurationByCriteria(Ktek_questionnaireconfigurationCriteria ktek_questionnaireconfigurationCriteria) {
		Ktek_questionnaireconfiguration[] ktek_questionnaireconfigurations = listKtek_questionnaireconfigurationByCriteria(ktek_questionnaireconfigurationCriteria);
		if(ktek_questionnaireconfigurations == null || ktek_questionnaireconfigurations.length == 0) {
			return null;
		}
		return ktek_questionnaireconfigurations[0];
	}
	
	public Ktek_questionnaireconfiguration[] listKtek_questionnaireconfigurationByCriteria(Ktek_questionnaireconfigurationCriteria ktek_questionnaireconfigurationCriteria) {
		return ktek_questionnaireconfigurationCriteria.listKtek_questionnaireconfiguration();
	}
}
