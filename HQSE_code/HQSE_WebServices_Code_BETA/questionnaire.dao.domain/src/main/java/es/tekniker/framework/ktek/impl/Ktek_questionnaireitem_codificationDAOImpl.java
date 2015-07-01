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

public class Ktek_questionnaireitem_codificationDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionnaireitem_codificationDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionnaireitem_codificationDAOImpl.class);
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitem_codificationByORMID(session, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, ktek_fk_idcodification_ktek_pk_idcodification);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification getKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireitem_codificationByORMID(session, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, ktek_fk_idcodification_ktek_pk_idcodification);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitem_codificationByORMID(session, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, ktek_fk_idcodification_ktek_pk_idcodification, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification getKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireitem_codificationByORMID(session, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, ktek_fk_idcodification_ktek_pk_idcodification, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitem_codificationByORMID(int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification) throws PersistentException {
		try {
			Ktek_questionnaireitem_codification ktek_questionnaireitem_codification = new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification();
			ktek_questionnaireitem_codification.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			ktek_questionnaireitem_codification.setKtek_fk_idcodification_ktek_pk_idcodification(ktek_fk_idcodification_ktek_pk_idcodification);
			
			return (Ktek_questionnaireitem_codification) session.load(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification.class, ktek_questionnaireitem_codification);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification getKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification) throws PersistentException {
		try {
			Ktek_questionnaireitem_codification ktek_questionnaireitem_codification = new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification();
			ktek_questionnaireitem_codification.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			ktek_questionnaireitem_codification.setKtek_fk_idcodification_ktek_pk_idcodification(ktek_fk_idcodification_ktek_pk_idcodification);
			
			return (Ktek_questionnaireitem_codification) session.get(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification.class, ktek_questionnaireitem_codification);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_questionnaireitem_codification ktek_questionnaireitem_codification = new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification();
			ktek_questionnaireitem_codification.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			ktek_questionnaireitem_codification.setKtek_fk_idcodification_ktek_pk_idcodification(ktek_fk_idcodification_ktek_pk_idcodification);
			
			return (Ktek_questionnaireitem_codification) session.load(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification.class, ktek_questionnaireitem_codification, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification getKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_questionnaireitem_codification ktek_questionnaireitem_codification = new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification();
			ktek_questionnaireitem_codification.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			ktek_questionnaireitem_codification.setKtek_fk_idcodification_ktek_pk_idcodification(ktek_fk_idcodification_ktek_pk_idcodification);
			
			return (Ktek_questionnaireitem_codification) session.get(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification.class, ktek_questionnaireitem_codification, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitem_codificationByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, int ktek_fk_idcodification_ktek_pk_idcodification, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem_codification(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireitem_codification(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireitem_codification(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem_codification(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireitem_codification(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireitem_codification(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification[] listKtek_questionnaireitem_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireitem_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification[] listKtek_questionnaireitem_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireitem_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem_codification(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem_codification as Ktek_questionnaireitem_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem_codification(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem_codification as Ktek_questionnaireitem_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireitem_codification", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification[] listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_questionnaireitem_codification(session, condition, orderBy);
			return (Ktek_questionnaireitem_codification[]) list.toArray(new Ktek_questionnaireitem_codification[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification[] listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_questionnaireitem_codification(session, condition, orderBy, lockMode);
			return (Ktek_questionnaireitem_codification[]) list.toArray(new Ktek_questionnaireitem_codification[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitem_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitem_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_questionnaireitem_codification[] ktek_questionnaireitem_codifications = listKtek_questionnaireitem_codificationByQuery(session, condition, orderBy);
		if (ktek_questionnaireitem_codifications != null && ktek_questionnaireitem_codifications.length > 0)
			return ktek_questionnaireitem_codifications[0];
		else
			return null;
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_questionnaireitem_codification[] ktek_questionnaireitem_codifications = listKtek_questionnaireitem_codificationByQuery(session, condition, orderBy, lockMode);
		if (ktek_questionnaireitem_codifications != null && ktek_questionnaireitem_codifications.length > 0)
			return ktek_questionnaireitem_codifications[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionnaireitem_codificationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireitem_codificationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitem_codificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireitem_codificationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitem_codificationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem_codification as Ktek_questionnaireitem_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem_codification as Ktek_questionnaireitem_codification");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireitem_codification", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitem_codificationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification createKtek_questionnaireitem_codification() {
		return new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_questionnaireitem_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_questionnaireitem_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification)throws PersistentException {
		try {
			if(ktek_questionnaireitem_codification.getKtek_fk_idquestionnaireitem() != null) {
				ktek_questionnaireitem_codification.getKtek_fk_idquestionnaireitem().getKtek_questionnaireitem_codification().remove(ktek_questionnaireitem_codification);
			}
			
			if(ktek_questionnaireitem_codification.getKtek_fk_idcodification() != null) {
				ktek_questionnaireitem_codification.getKtek_fk_idcodification().getKtek_questionnaireitem_codification().remove(ktek_questionnaireitem_codification);
			}
			
			return delete(ktek_questionnaireitem_codification);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_questionnaireitem_codification.getKtek_fk_idquestionnaireitem() != null) {
				ktek_questionnaireitem_codification.getKtek_fk_idquestionnaireitem().getKtek_questionnaireitem_codification().remove(ktek_questionnaireitem_codification);
			}
			
			if(ktek_questionnaireitem_codification.getKtek_fk_idcodification() != null) {
				ktek_questionnaireitem_codification.getKtek_fk_idcodification().getKtek_questionnaireitem_codification().remove(ktek_questionnaireitem_codification);
			}
			
			try {
				session.delete(ktek_questionnaireitem_codification);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_questionnaireitem_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_questionnaireitem_codification);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_questionnaireitem_codification ktek_questionnaireitem_codification)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem_codification loadKtek_questionnaireitem_codificationByCriteria(Ktek_questionnaireitem_codificationCriteria ktek_questionnaireitem_codificationCriteria) {
		Ktek_questionnaireitem_codification[] ktek_questionnaireitem_codifications = listKtek_questionnaireitem_codificationByCriteria(ktek_questionnaireitem_codificationCriteria);
		if(ktek_questionnaireitem_codifications == null || ktek_questionnaireitem_codifications.length == 0) {
			return null;
		}
		return ktek_questionnaireitem_codifications[0];
	}
	
	public Ktek_questionnaireitem_codification[] listKtek_questionnaireitem_codificationByCriteria(Ktek_questionnaireitem_codificationCriteria ktek_questionnaireitem_codificationCriteria) {
		return ktek_questionnaireitem_codificationCriteria.listKtek_questionnaireitem_codification();
	}
}
