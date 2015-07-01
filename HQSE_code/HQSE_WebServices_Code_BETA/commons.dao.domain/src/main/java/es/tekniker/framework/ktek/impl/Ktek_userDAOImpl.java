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

public class Ktek_userDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_userDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_userDAOImpl.class);
	public Ktek_user loadKtek_userByORMID(int ktek_pk_iduser) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_userByORMID(session, ktek_pk_iduser);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByORMID(int ktek_pk_iduser)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user getKtek_userByORMID(int ktek_pk_iduser) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_userByORMID(session, ktek_pk_iduser);
		}
		catch (Exception e) {
			_logger.error("getKtek_userByORMID(int ktek_pk_iduser)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_userByORMID(session, ktek_pk_iduser, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user getKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_userByORMID(session, ktek_pk_iduser, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser) throws PersistentException {
		try {
			return (Ktek_user) session.load(es.tekniker.framework.ktek.Ktek_user.class, new Integer(ktek_pk_iduser));
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser) throws PersistentException {
		try {
			return (Ktek_user) session.get(es.tekniker.framework.ktek.Ktek_user.class, new Integer(ktek_pk_iduser));
		}
		catch (Exception e) {
			_logger.error("getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_user) session.load(es.tekniker.framework.ktek.Ktek_user.class, new Integer(ktek_pk_iduser), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_user) session.get(es.tekniker.framework.ktek.Ktek_user.class, new Integer(ktek_pk_iduser), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_user(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_user(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_user(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_user(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user[] listKtek_userByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_userByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user[] listKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_userByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user as Ktek_user");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_user(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user as Ktek_user");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_user", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user[] listKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_user(session, condition, orderBy);
			return (Ktek_user[]) list.toArray(new Ktek_user[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user[] listKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_user(session, condition, orderBy, lockMode);
			return (Ktek_user[]) list.toArray(new Ktek_user[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_userByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_userByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_user[] ktek_users = listKtek_userByQuery(session, condition, orderBy);
		if (ktek_users != null && ktek_users.length > 0)
			return ktek_users[0];
		else
			return null;
	}
	
	public Ktek_user loadKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_user[] ktek_users = listKtek_userByQuery(session, condition, orderBy, lockMode);
		if (ktek_users != null && ktek_users.length > 0)
			return ktek_users[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_userByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_userByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_userByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user as Ktek_user");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_user as Ktek_user");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_user", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user createKtek_user() {
		return new es.tekniker.framework.ktek.Ktek_user();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_user);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_user ktek_user)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_user);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_user ktek_user)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user ktek_user)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_auditaccesslog[] lKtek_auditaccesslogs = (es.tekniker.framework.ktek.Ktek_auditaccesslog[])ktek_user.getKtek_auditaccesslog().toArray(new es.tekniker.framework.ktek.Ktek_auditaccesslog[ktek_user.getKtek_auditaccesslog().size()]);
			for(int i = 0; i < lKtek_auditaccesslogs.length; i++) {
				lKtek_auditaccesslogs[i].setIdaccessuser(null);
			}
			es.tekniker.framework.ktek.Ktek_auditaccesslog[] lKtek_auditaccesslog1s = (es.tekniker.framework.ktek.Ktek_auditaccesslog[])ktek_user.getKtek_auditaccesslog1().toArray(new es.tekniker.framework.ktek.Ktek_auditaccesslog[ktek_user.getKtek_auditaccesslog1().size()]);
			for(int i = 0; i < lKtek_auditaccesslog1s.length; i++) {
				lKtek_auditaccesslog1s[i].setIdaccesseduser(null);
			}
			if(ktek_user.getKtek_tpsettings() != null) {
				ktek_user.getKtek_tpsettings().setKtek_fk_iduser(null);
			}
			
			if(ktek_user.getKtek_user_ext() != null) {
				ktek_user.getKtek_user_ext().setKtek_fk_iduser(null);
			}
			
			if(ktek_user.getKtek_usersessiondata() != null) {
				ktek_user.getKtek_usersessiondata().setKtek_fk_iduser(null);
			}
			
			return delete(ktek_user);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user ktek_user, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_auditaccesslog[] lKtek_auditaccesslogs = (es.tekniker.framework.ktek.Ktek_auditaccesslog[])ktek_user.getKtek_auditaccesslog().toArray(new es.tekniker.framework.ktek.Ktek_auditaccesslog[ktek_user.getKtek_auditaccesslog().size()]);
			for(int i = 0; i < lKtek_auditaccesslogs.length; i++) {
				lKtek_auditaccesslogs[i].setIdaccessuser(null);
			}
			es.tekniker.framework.ktek.Ktek_auditaccesslog[] lKtek_auditaccesslog1s = (es.tekniker.framework.ktek.Ktek_auditaccesslog[])ktek_user.getKtek_auditaccesslog1().toArray(new es.tekniker.framework.ktek.Ktek_auditaccesslog[ktek_user.getKtek_auditaccesslog1().size()]);
			for(int i = 0; i < lKtek_auditaccesslog1s.length; i++) {
				lKtek_auditaccesslog1s[i].setIdaccesseduser(null);
			}
			if(ktek_user.getKtek_tpsettings() != null) {
				ktek_user.getKtek_tpsettings().setKtek_fk_iduser(null);
			}
			
			if(ktek_user.getKtek_user_ext() != null) {
				ktek_user.getKtek_user_ext().setKtek_fk_iduser(null);
			}
			
			if(ktek_user.getKtek_usersessiondata() != null) {
				ktek_user.getKtek_usersessiondata().setKtek_fk_iduser(null);
			}
			
			try {
				session.delete(ktek_user);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_user);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_user ktek_user)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_user);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_user ktek_user)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_user loadKtek_userByCriteria(Ktek_userCriteria ktek_userCriteria) {
		Ktek_user[] ktek_users = listKtek_userByCriteria(ktek_userCriteria);
		if(ktek_users == null || ktek_users.length == 0) {
			return null;
		}
		return ktek_users[0];
	}
	
	public Ktek_user[] listKtek_userByCriteria(Ktek_userCriteria ktek_userCriteria) {
		return ktek_userCriteria.listKtek_user();
	}
}
