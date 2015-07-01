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

public class Ktek_auditaccesslogDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_auditaccesslogDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_auditaccesslogDAOImpl.class);
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_auditaccesslogByORMID(session, ktek_pk_idauditaccesslog);
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_auditaccesslogByORMID(session, ktek_pk_idauditaccesslog);
		}
		catch (Exception e) {
			_logger.error("getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_auditaccesslogByORMID(session, ktek_pk_idauditaccesslog, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_auditaccesslogByORMID(session, ktek_pk_idauditaccesslog, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog) throws PersistentException {
		try {
			return (Ktek_auditaccesslog) session.load(es.tekniker.framework.ktek.Ktek_auditaccesslog.class, new Integer(ktek_pk_idauditaccesslog));
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog) throws PersistentException {
		try {
			return (Ktek_auditaccesslog) session.get(es.tekniker.framework.ktek.Ktek_auditaccesslog.class, new Integer(ktek_pk_idauditaccesslog));
		}
		catch (Exception e) {
			_logger.error("getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_auditaccesslog) session.load(es.tekniker.framework.ktek.Ktek_auditaccesslog.class, new Integer(ktek_pk_idauditaccesslog), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_auditaccesslog) session.get(es.tekniker.framework.ktek.Ktek_auditaccesslog.class, new Integer(ktek_pk_idauditaccesslog), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_auditaccesslog(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_auditaccesslog(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_auditaccesslog(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_auditaccesslog(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_auditaccesslog(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_auditaccesslog(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_auditaccesslogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_auditaccesslogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_auditaccesslog(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_auditaccesslog as Ktek_auditaccesslog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_auditaccesslog(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_auditaccesslog as Ktek_auditaccesslog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_auditaccesslog", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_auditaccesslog(session, condition, orderBy);
			return (Ktek_auditaccesslog[]) list.toArray(new Ktek_auditaccesslog[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_auditaccesslog(session, condition, orderBy, lockMode);
			return (Ktek_auditaccesslog[]) list.toArray(new Ktek_auditaccesslog[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_auditaccesslogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_auditaccesslogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_auditaccesslog[] ktek_auditaccesslogs = listKtek_auditaccesslogByQuery(session, condition, orderBy);
		if (ktek_auditaccesslogs != null && ktek_auditaccesslogs.length > 0)
			return ktek_auditaccesslogs[0];
		else
			return null;
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_auditaccesslog[] ktek_auditaccesslogs = listKtek_auditaccesslogByQuery(session, condition, orderBy, lockMode);
		if (ktek_auditaccesslogs != null && ktek_auditaccesslogs.length > 0)
			return ktek_auditaccesslogs[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_auditaccesslogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_auditaccesslogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_auditaccesslogByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_auditaccesslog as Ktek_auditaccesslog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_auditaccesslog as Ktek_auditaccesslog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_auditaccesslog", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog createKtek_auditaccesslog() {
		return new es.tekniker.framework.ktek.Ktek_auditaccesslog();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_auditaccesslog);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_auditaccesslog);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog)throws PersistentException {
		try {
			if(ktek_auditaccesslog.getIdaccessuser() != null) {
				ktek_auditaccesslog.getIdaccessuser().getKtek_auditaccesslog().remove(ktek_auditaccesslog);
			}
			
			if(ktek_auditaccesslog.getIdaccesseduser() != null) {
				ktek_auditaccesslog.getIdaccesseduser().getKtek_auditaccesslog1().remove(ktek_auditaccesslog);
			}
			
			return delete(ktek_auditaccesslog);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_auditaccesslog.getIdaccessuser() != null) {
				ktek_auditaccesslog.getIdaccessuser().getKtek_auditaccesslog().remove(ktek_auditaccesslog);
			}
			
			if(ktek_auditaccesslog.getIdaccesseduser() != null) {
				ktek_auditaccesslog.getIdaccesseduser().getKtek_auditaccesslog1().remove(ktek_auditaccesslog);
			}
			
			try {
				session.delete(ktek_auditaccesslog);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_auditaccesslog);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_auditaccesslog);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_auditaccesslog loadKtek_auditaccesslogByCriteria(Ktek_auditaccesslogCriteria ktek_auditaccesslogCriteria) {
		Ktek_auditaccesslog[] ktek_auditaccesslogs = listKtek_auditaccesslogByCriteria(ktek_auditaccesslogCriteria);
		if(ktek_auditaccesslogs == null || ktek_auditaccesslogs.length == 0) {
			return null;
		}
		return ktek_auditaccesslogs[0];
	}
	
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByCriteria(Ktek_auditaccesslogCriteria ktek_auditaccesslogCriteria) {
		return ktek_auditaccesslogCriteria.listKtek_auditaccesslog();
	}
}
