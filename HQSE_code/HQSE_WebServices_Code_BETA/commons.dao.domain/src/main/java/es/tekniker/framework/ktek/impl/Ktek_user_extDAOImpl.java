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

public class Ktek_user_extDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_user_extDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_user_extDAOImpl.class);
	public List queryKtek_user_ext(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_user_ext(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_user_ext(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user_ext(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_user_ext(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_user_ext(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext[] listKtek_user_extByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_user_extByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext[] listKtek_user_extByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_user_extByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user_ext(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user_ext as Ktek_user_ext");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user_ext(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user_ext as Ktek_user_ext");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_user_ext", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext[] listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_user_ext(session, condition, orderBy);
			return (Ktek_user_ext[]) list.toArray(new Ktek_user_ext[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext[] listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_user_ext(session, condition, orderBy, lockMode);
			return (Ktek_user_ext[]) list.toArray(new Ktek_user_ext[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext loadKtek_user_extByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_user_extByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext loadKtek_user_extByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_user_extByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext loadKtek_user_extByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_user_ext[] ktek_user_exts = listKtek_user_extByQuery(session, condition, orderBy);
		if (ktek_user_exts != null && ktek_user_exts.length > 0)
			return ktek_user_exts[0];
		else
			return null;
	}
	
	public Ktek_user_ext loadKtek_user_extByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_user_ext[] ktek_user_exts = listKtek_user_extByQuery(session, condition, orderBy, lockMode);
		if (ktek_user_exts != null && ktek_user_exts.length > 0)
			return ktek_user_exts[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_user_extByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_user_extByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_user_extByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_user_extByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_user_extByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_user_extByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user_ext as Ktek_user_ext");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_user_extByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user_ext as Ktek_user_ext");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_user_ext", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_user_extByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext createKtek_user_ext() {
		return new es.tekniker.framework.ktek.Ktek_user_ext();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_user_ext);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_user_ext);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext)throws PersistentException {
		try {
			if(ktek_user_ext.getKtek_fk_iduser() != null) {
				ktek_user_ext.getKtek_fk_iduser().setKtek_user_ext(null);
			}
			
			return delete(ktek_user_ext);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_user_ext.getKtek_fk_iduser() != null) {
				ktek_user_ext.getKtek_fk_iduser().setKtek_user_ext(null);
			}
			
			try {
				session.delete(ktek_user_ext);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_user_ext);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_user_ext);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_user_ext ktek_user_ext)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user_ext loadKtek_user_extByCriteria(Ktek_user_extCriteria ktek_user_extCriteria) {
		Ktek_user_ext[] ktek_user_exts = listKtek_user_extByCriteria(ktek_user_extCriteria);
		if(ktek_user_exts == null || ktek_user_exts.length == 0) {
			return null;
		}
		return ktek_user_exts[0];
	}
	
	public Ktek_user_ext[] listKtek_user_extByCriteria(Ktek_user_extCriteria ktek_user_extCriteria) {
		return ktek_user_extCriteria.listKtek_user_ext();
	}
}
