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

public class Ktek_tpsettingsDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_tpsettingsDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_tpsettingsDAOImpl.class);
	public List queryKtek_tpsettings(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_tpsettings(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_tpsettings(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_tpsettings(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_tpsettings(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_tpsettings(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings[] listKtek_tpsettingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_tpsettingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings[] listKtek_tpsettingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_tpsettingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_tpsettings(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_tpsettings as Ktek_tpsettings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_tpsettings(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_tpsettings as Ktek_tpsettings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_tpsettings", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings[] listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_tpsettings(session, condition, orderBy);
			return (Ktek_tpsettings[]) list.toArray(new Ktek_tpsettings[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings[] listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_tpsettings(session, condition, orderBy, lockMode);
			return (Ktek_tpsettings[]) list.toArray(new Ktek_tpsettings[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings loadKtek_tpsettingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_tpsettingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings loadKtek_tpsettingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_tpsettingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings loadKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_tpsettings[] ktek_tpsettingses = listKtek_tpsettingsByQuery(session, condition, orderBy);
		if (ktek_tpsettingses != null && ktek_tpsettingses.length > 0)
			return ktek_tpsettingses[0];
		else
			return null;
	}
	
	public Ktek_tpsettings loadKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_tpsettings[] ktek_tpsettingses = listKtek_tpsettingsByQuery(session, condition, orderBy, lockMode);
		if (ktek_tpsettingses != null && ktek_tpsettingses.length > 0)
			return ktek_tpsettingses[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_tpsettingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_tpsettingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_tpsettingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_tpsettingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_tpsettingsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_tpsettings as Ktek_tpsettings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_tpsettings as Ktek_tpsettings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_tpsettings", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_tpsettingsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings createKtek_tpsettings() {
		return new es.tekniker.framework.ktek.Ktek_tpsettings();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_tpsettings);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_tpsettings);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings)throws PersistentException {
		try {
			if(ktek_tpsettings.getKtek_fk_iduser() != null) {
				ktek_tpsettings.getKtek_fk_iduser().setKtek_tpsettings(null);
			}
			
			if(ktek_tpsettings.getKtek_fk_idlanguage() != null) {
				ktek_tpsettings.getKtek_fk_idlanguage().getKtek_tpsettings().remove(ktek_tpsettings);
			}
			
			return delete(ktek_tpsettings);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_tpsettings.getKtek_fk_iduser() != null) {
				ktek_tpsettings.getKtek_fk_iduser().setKtek_tpsettings(null);
			}
			
			if(ktek_tpsettings.getKtek_fk_idlanguage() != null) {
				ktek_tpsettings.getKtek_fk_idlanguage().getKtek_tpsettings().remove(ktek_tpsettings);
			}
			
			try {
				session.delete(ktek_tpsettings);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_tpsettings);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_tpsettings);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_tpsettings ktek_tpsettings)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_tpsettings loadKtek_tpsettingsByCriteria(Ktek_tpsettingsCriteria ktek_tpsettingsCriteria) {
		Ktek_tpsettings[] ktek_tpsettingses = listKtek_tpsettingsByCriteria(ktek_tpsettingsCriteria);
		if(ktek_tpsettingses == null || ktek_tpsettingses.length == 0) {
			return null;
		}
		return ktek_tpsettingses[0];
	}
	
	public Ktek_tpsettings[] listKtek_tpsettingsByCriteria(Ktek_tpsettingsCriteria ktek_tpsettingsCriteria) {
		return ktek_tpsettingsCriteria.listKtek_tpsettings();
	}
}
