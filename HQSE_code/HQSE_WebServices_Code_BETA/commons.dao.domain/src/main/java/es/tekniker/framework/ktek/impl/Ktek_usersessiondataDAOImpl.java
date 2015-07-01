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

public class Ktek_usersessiondataDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_usersessiondataDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_usersessiondataDAOImpl.class);
	public List queryKtek_usersessiondata(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_usersessiondata(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_usersessiondata(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_usersessiondata(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_usersessiondata(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_usersessiondata(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_usersessiondataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_usersessiondataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_usersessiondata(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_usersessiondata as Ktek_usersessiondata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_usersessiondata(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_usersessiondata as Ktek_usersessiondata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_usersessiondata", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_usersessiondata(session, condition, orderBy);
			return (Ktek_usersessiondata[]) list.toArray(new Ktek_usersessiondata[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_usersessiondata(session, condition, orderBy, lockMode);
			return (Ktek_usersessiondata[]) list.toArray(new Ktek_usersessiondata[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata loadKtek_usersessiondataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_usersessiondataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata loadKtek_usersessiondataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_usersessiondataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata loadKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_usersessiondata[] ktek_usersessiondatas = listKtek_usersessiondataByQuery(session, condition, orderBy);
		if (ktek_usersessiondatas != null && ktek_usersessiondatas.length > 0)
			return ktek_usersessiondatas[0];
		else
			return null;
	}
	
	public Ktek_usersessiondata loadKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_usersessiondata[] ktek_usersessiondatas = listKtek_usersessiondataByQuery(session, condition, orderBy, lockMode);
		if (ktek_usersessiondatas != null && ktek_usersessiondatas.length > 0)
			return ktek_usersessiondatas[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_usersessiondataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_usersessiondataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_usersessiondataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_usersessiondataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_usersessiondataByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_usersessiondata as Ktek_usersessiondata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_usersessiondata as Ktek_usersessiondata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_usersessiondata", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_usersessiondataByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata createKtek_usersessiondata() {
		return new es.tekniker.framework.ktek.Ktek_usersessiondata();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_usersessiondata);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_usersessiondata);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata)throws PersistentException {
		try {
			if(ktek_usersessiondata.getKtek_fk_iduser() != null) {
				ktek_usersessiondata.getKtek_fk_iduser().setKtek_usersessiondata(null);
			}
			
			return delete(ktek_usersessiondata);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_usersessiondata.getKtek_fk_iduser() != null) {
				ktek_usersessiondata.getKtek_fk_iduser().setKtek_usersessiondata(null);
			}
			
			try {
				session.delete(ktek_usersessiondata);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_usersessiondata);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_usersessiondata);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_usersessiondata ktek_usersessiondata)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_usersessiondata loadKtek_usersessiondataByCriteria(Ktek_usersessiondataCriteria ktek_usersessiondataCriteria) {
		Ktek_usersessiondata[] ktek_usersessiondatas = listKtek_usersessiondataByCriteria(ktek_usersessiondataCriteria);
		if(ktek_usersessiondatas == null || ktek_usersessiondatas.length == 0) {
			return null;
		}
		return ktek_usersessiondatas[0];
	}
	
	public Ktek_usersessiondata[] listKtek_usersessiondataByCriteria(Ktek_usersessiondataCriteria ktek_usersessiondataCriteria) {
		return ktek_usersessiondataCriteria.listKtek_usersessiondata();
	}
}
