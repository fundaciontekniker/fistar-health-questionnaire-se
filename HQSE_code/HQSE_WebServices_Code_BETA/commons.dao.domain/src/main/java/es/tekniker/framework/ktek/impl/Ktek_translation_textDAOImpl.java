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

public class Ktek_translation_textDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_translation_textDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_translation_textDAOImpl.class);
	public Ktek_translation_text loadKtek_translation_textByORMID(int ktek_pk_translation_text) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_translation_textByORMID(session, ktek_pk_translation_text);
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByORMID(int ktek_pk_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text getKtek_translation_textByORMID(int ktek_pk_translation_text) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_translation_textByORMID(session, ktek_pk_translation_text);
		}
		catch (Exception e) {
			_logger.error("getKtek_translation_textByORMID(int ktek_pk_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByORMID(int ktek_pk_translation_text, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_translation_textByORMID(session, ktek_pk_translation_text, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByORMID(int ktek_pk_translation_text, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text getKtek_translation_textByORMID(int ktek_pk_translation_text, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_translation_textByORMID(session, ktek_pk_translation_text, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_translation_textByORMID(int ktek_pk_translation_text, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text) throws PersistentException {
		try {
			return (Ktek_translation_text) session.load(es.tekniker.framework.ktek.Ktek_translation_text.class, new Integer(ktek_pk_translation_text));
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text getKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text) throws PersistentException {
		try {
			return (Ktek_translation_text) session.get(es.tekniker.framework.ktek.Ktek_translation_text.class, new Integer(ktek_pk_translation_text));
		}
		catch (Exception e) {
			_logger.error("getKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_translation_text) session.load(es.tekniker.framework.ktek.Ktek_translation_text.class, new Integer(ktek_pk_translation_text), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text getKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_translation_text) session.get(es.tekniker.framework.ktek.Ktek_translation_text.class, new Integer(ktek_pk_translation_text), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_translation_textByORMID(PersistentSession session, int ktek_pk_translation_text, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_translation_text(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_translation_text(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_translation_text(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_translation_text(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_translation_text(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_translation_text(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text[] listKtek_translation_textByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_translation_textByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text[] listKtek_translation_textByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_translation_textByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_translation_text(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_translation_text as Ktek_translation_text");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_translation_text(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_translation_text as Ktek_translation_text");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_translation_text", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text[] listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_translation_text(session, condition, orderBy);
			return (Ktek_translation_text[]) list.toArray(new Ktek_translation_text[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text[] listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_translation_text(session, condition, orderBy, lockMode);
			return (Ktek_translation_text[]) list.toArray(new Ktek_translation_text[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_translation_textByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_translation_textByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_translation_text[] ktek_translation_texts = listKtek_translation_textByQuery(session, condition, orderBy);
		if (ktek_translation_texts != null && ktek_translation_texts.length > 0)
			return ktek_translation_texts[0];
		else
			return null;
	}
	
	public Ktek_translation_text loadKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_translation_text[] ktek_translation_texts = listKtek_translation_textByQuery(session, condition, orderBy, lockMode);
		if (ktek_translation_texts != null && ktek_translation_texts.length > 0)
			return ktek_translation_texts[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_translation_textByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_translation_textByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_translation_textByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_translation_textByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_translation_textByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_translation_text as Ktek_translation_text");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_translation_text as Ktek_translation_text");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_translation_text", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_translation_textByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text createKtek_translation_text() {
		return new es.tekniker.framework.ktek.Ktek_translation_text();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_translation_text);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_translation_text);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text)throws PersistentException {
		try {
			if(ktek_translation_text.getKtek_fk_language() != null) {
				ktek_translation_text.getKtek_fk_language().getKtek_translation_text().remove(ktek_translation_text);
			}
			
			return delete(ktek_translation_text);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_translation_text.getKtek_fk_language() != null) {
				ktek_translation_text.getKtek_fk_language().getKtek_translation_text().remove(ktek_translation_text);
			}
			
			try {
				session.delete(ktek_translation_text);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_translation_text);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_translation_text);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_translation_text ktek_translation_text)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_translation_text loadKtek_translation_textByCriteria(Ktek_translation_textCriteria ktek_translation_textCriteria) {
		Ktek_translation_text[] ktek_translation_texts = listKtek_translation_textByCriteria(ktek_translation_textCriteria);
		if(ktek_translation_texts == null || ktek_translation_texts.length == 0) {
			return null;
		}
		return ktek_translation_texts[0];
	}
	
	public Ktek_translation_text[] listKtek_translation_textByCriteria(Ktek_translation_textCriteria ktek_translation_textCriteria) {
		return ktek_translation_textCriteria.listKtek_translation_text();
	}
}
