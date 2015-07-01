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

public class Ktek_pathologyDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_pathologyDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_pathologyDAOImpl.class);
	public Ktek_pathology loadKtek_pathologyByORMID(int ktek_pk_idpathology) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_pathologyByORMID(session, ktek_pk_idpathology);
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByORMID(int ktek_pk_idpathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology getKtek_pathologyByORMID(int ktek_pk_idpathology) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_pathologyByORMID(session, ktek_pk_idpathology);
		}
		catch (Exception e) {
			_logger.error("getKtek_pathologyByORMID(int ktek_pk_idpathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByORMID(int ktek_pk_idpathology, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_pathologyByORMID(session, ktek_pk_idpathology, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByORMID(int ktek_pk_idpathology, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology getKtek_pathologyByORMID(int ktek_pk_idpathology, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_pathologyByORMID(session, ktek_pk_idpathology, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_pathologyByORMID(int ktek_pk_idpathology, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology) throws PersistentException {
		try {
			return (Ktek_pathology) session.load(es.tekniker.framework.ktek.Ktek_pathology.class, new Integer(ktek_pk_idpathology));
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology getKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology) throws PersistentException {
		try {
			return (Ktek_pathology) session.get(es.tekniker.framework.ktek.Ktek_pathology.class, new Integer(ktek_pk_idpathology));
		}
		catch (Exception e) {
			_logger.error("getKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_pathology) session.load(es.tekniker.framework.ktek.Ktek_pathology.class, new Integer(ktek_pk_idpathology), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology getKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_pathology) session.get(es.tekniker.framework.ktek.Ktek_pathology.class, new Integer(ktek_pk_idpathology), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_pathologyByORMID(PersistentSession session, int ktek_pk_idpathology, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_pathology(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_pathology(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_pathology(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_pathology(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_pathology(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_pathology(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology[] listKtek_pathologyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_pathologyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology[] listKtek_pathologyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_pathologyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_pathology(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_pathology as Ktek_pathology");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_pathology(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_pathology as Ktek_pathology");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_pathology", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology[] listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_pathology(session, condition, orderBy);
			return (Ktek_pathology[]) list.toArray(new Ktek_pathology[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology[] listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_pathology(session, condition, orderBy, lockMode);
			return (Ktek_pathology[]) list.toArray(new Ktek_pathology[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_pathologyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_pathologyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_pathology[] ktek_pathologys = listKtek_pathologyByQuery(session, condition, orderBy);
		if (ktek_pathologys != null && ktek_pathologys.length > 0)
			return ktek_pathologys[0];
		else
			return null;
	}
	
	public Ktek_pathology loadKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_pathology[] ktek_pathologys = listKtek_pathologyByQuery(session, condition, orderBy, lockMode);
		if (ktek_pathologys != null && ktek_pathologys.length > 0)
			return ktek_pathologys[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_pathologyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_pathologyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_pathologyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_pathologyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_pathologyByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_pathology as Ktek_pathology");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_pathology as Ktek_pathology");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_pathology", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_pathologyByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology createKtek_pathology() {
		return new es.tekniker.framework.ktek.Ktek_pathology();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_pathology);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_pathology);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_pathology);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_pathology);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_pathology ktek_pathology)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_pathology loadKtek_pathologyByCriteria(Ktek_pathologyCriteria ktek_pathologyCriteria) {
		Ktek_pathology[] ktek_pathologys = listKtek_pathologyByCriteria(ktek_pathologyCriteria);
		if(ktek_pathologys == null || ktek_pathologys.length == 0) {
			return null;
		}
		return ktek_pathologys[0];
	}
	
	public Ktek_pathology[] listKtek_pathologyByCriteria(Ktek_pathologyCriteria ktek_pathologyCriteria) {
		return ktek_pathologyCriteria.listKtek_pathology();
	}
}
