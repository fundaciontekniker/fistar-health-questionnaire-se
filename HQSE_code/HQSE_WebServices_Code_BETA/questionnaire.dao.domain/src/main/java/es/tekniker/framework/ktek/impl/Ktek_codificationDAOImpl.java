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

public class Ktek_codificationDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_codificationDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_codificationDAOImpl.class);
	public Ktek_codification loadKtek_codificationByORMID(int ktek_pk_idcodification) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_codificationByORMID(session, ktek_pk_idcodification);
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByORMID(int ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification getKtek_codificationByORMID(int ktek_pk_idcodification) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_codificationByORMID(session, ktek_pk_idcodification);
		}
		catch (Exception e) {
			_logger.error("getKtek_codificationByORMID(int ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByORMID(int ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_codificationByORMID(session, ktek_pk_idcodification, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByORMID(int ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification getKtek_codificationByORMID(int ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_codificationByORMID(session, ktek_pk_idcodification, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_codificationByORMID(int ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification) throws PersistentException {
		try {
			return (Ktek_codification) session.load(es.tekniker.framework.ktek.Ktek_codification.class, new Integer(ktek_pk_idcodification));
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification getKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification) throws PersistentException {
		try {
			return (Ktek_codification) session.get(es.tekniker.framework.ktek.Ktek_codification.class, new Integer(ktek_pk_idcodification));
		}
		catch (Exception e) {
			_logger.error("getKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_codification) session.load(es.tekniker.framework.ktek.Ktek_codification.class, new Integer(ktek_pk_idcodification), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification getKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_codification) session.get(es.tekniker.framework.ktek.Ktek_codification.class, new Integer(ktek_pk_idcodification), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_codificationByORMID(PersistentSession session, int ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_codification(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_codification(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_codification(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_codification(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_codification(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_codification(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification[] listKtek_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification[] listKtek_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_codification(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_codification as Ktek_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_codification(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_codification as Ktek_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_codification", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification[] listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_codification(session, condition, orderBy);
			return (Ktek_codification[]) list.toArray(new Ktek_codification[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification[] listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_codification(session, condition, orderBy, lockMode);
			return (Ktek_codification[]) list.toArray(new Ktek_codification[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_codification[] ktek_codifications = listKtek_codificationByQuery(session, condition, orderBy);
		if (ktek_codifications != null && ktek_codifications.length > 0)
			return ktek_codifications[0];
		else
			return null;
	}
	
	public Ktek_codification loadKtek_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_codification[] ktek_codifications = listKtek_codificationByQuery(session, condition, orderBy, lockMode);
		if (ktek_codifications != null && ktek_codifications.length > 0)
			return ktek_codifications[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_codification as Ktek_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_codification as Ktek_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_codification", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification createKtek_codification() {
		return new es.tekniker.framework.ktek.Ktek_codification();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_codification ktek_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_codification ktek_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_codification ktek_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_codification ktek_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_codification ktek_codification)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[] lKtek_questionnaireitem_codifications = (es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[])ktek_codification.getKtek_questionnaireitem_codification().toArray(new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[ktek_codification.getKtek_questionnaireitem_codification().size()]);
			for(int i = 0; i < lKtek_questionnaireitem_codifications.length; i++) {
				lKtek_questionnaireitem_codifications[i].setKtek_fk_idcodification(null);
			}
			return delete(ktek_codification);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_codification ktek_codification, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[] lKtek_questionnaireitem_codifications = (es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[])ktek_codification.getKtek_questionnaireitem_codification().toArray(new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[ktek_codification.getKtek_questionnaireitem_codification().size()]);
			for(int i = 0; i < lKtek_questionnaireitem_codifications.length; i++) {
				lKtek_questionnaireitem_codifications[i].setKtek_fk_idcodification(null);
			}
			try {
				session.delete(ktek_codification);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_codification ktek_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_codification ktek_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_codification ktek_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_codification ktek_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_codification loadKtek_codificationByCriteria(Ktek_codificationCriteria ktek_codificationCriteria) {
		Ktek_codification[] ktek_codifications = listKtek_codificationByCriteria(ktek_codificationCriteria);
		if(ktek_codifications == null || ktek_codifications.length == 0) {
			return null;
		}
		return ktek_codifications[0];
	}
	
	public Ktek_codification[] listKtek_codificationByCriteria(Ktek_codificationCriteria ktek_codificationCriteria) {
		return ktek_codificationCriteria.listKtek_codification();
	}
}
