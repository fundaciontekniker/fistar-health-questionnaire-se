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

public class Ktek_languageDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_languageDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_languageDAOImpl.class);
	public Ktek_language loadKtek_languageByORMID(int ktek_pk_idlanguage) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_languageByORMID(session, ktek_pk_idlanguage);
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByORMID(int ktek_pk_idlanguage)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language getKtek_languageByORMID(int ktek_pk_idlanguage) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_languageByORMID(session, ktek_pk_idlanguage);
		}
		catch (Exception e) {
			_logger.error("getKtek_languageByORMID(int ktek_pk_idlanguage)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_languageByORMID(session, ktek_pk_idlanguage, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language getKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return getKtek_languageByORMID(session, ktek_pk_idlanguage, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage) throws PersistentException {
		try {
			return (Ktek_language) session.load(es.tekniker.framework.ktek.Ktek_language.class, new Integer(ktek_pk_idlanguage));
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage) throws PersistentException {
		try {
			return (Ktek_language) session.get(es.tekniker.framework.ktek.Ktek_language.class, new Integer(ktek_pk_idlanguage));
		}
		catch (Exception e) {
			_logger.error("getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_language) session.load(es.tekniker.framework.ktek.Ktek_language.class, new Integer(ktek_pk_idlanguage), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_language) session.get(es.tekniker.framework.ktek.Ktek_language.class, new Integer(ktek_pk_idlanguage), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_language(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_language(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_language(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_language(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return queryKtek_language(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_language(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language[] listKtek_languageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_languageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language[] listKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return listKtek_languageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_language(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_language as Ktek_language");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_language(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_language as Ktek_language");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_language", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language[] listKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_language(session, condition, orderBy);
			return (Ktek_language[]) list.toArray(new Ktek_language[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language[] listKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_language(session, condition, orderBy, lockMode);
			return (Ktek_language[]) list.toArray(new Ktek_language[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_languageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return loadKtek_languageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_language[] ktek_languages = listKtek_languageByQuery(session, condition, orderBy);
		if (ktek_languages != null && ktek_languages.length > 0)
			return ktek_languages[0];
		else
			return null;
	}
	
	public Ktek_language loadKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_language[] ktek_languages = listKtek_languageByQuery(session, condition, orderBy, lockMode);
		if (ktek_languages != null && ktek_languages.length > 0)
			return ktek_languages[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_languageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_languageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession();
			return iterateKtek_languageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_languageByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_language as Ktek_language");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_language as Ktek_language");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_language", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language createKtek_language() {
		return new es.tekniker.framework.ktek.Ktek_language();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().saveObject(ktek_language);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_language ktek_language)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().deleteObject(ktek_language);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_language ktek_language)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_language ktek_language)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_tpsettings[] lKtek_tpsettingss = (es.tekniker.framework.ktek.Ktek_tpsettings[])ktek_language.getKtek_tpsettings().toArray(new es.tekniker.framework.ktek.Ktek_tpsettings[ktek_language.getKtek_tpsettings().size()]);
			for(int i = 0; i < lKtek_tpsettingss.length; i++) {
				lKtek_tpsettingss[i].setKtek_fk_idlanguage(null);
			}
			es.tekniker.framework.ktek.Ktek_translation_text[] lKtek_translation_texts = (es.tekniker.framework.ktek.Ktek_translation_text[])ktek_language.getKtek_translation_text().toArray(new es.tekniker.framework.ktek.Ktek_translation_text[ktek_language.getKtek_translation_text().size()]);
			for(int i = 0; i < lKtek_translation_texts.length; i++) {
				lKtek_translation_texts[i].setKtek_fk_language(null);
			}
			return delete(ktek_language);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_language ktek_language, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_tpsettings[] lKtek_tpsettingss = (es.tekniker.framework.ktek.Ktek_tpsettings[])ktek_language.getKtek_tpsettings().toArray(new es.tekniker.framework.ktek.Ktek_tpsettings[ktek_language.getKtek_tpsettings().size()]);
			for(int i = 0; i < lKtek_tpsettingss.length; i++) {
				lKtek_tpsettingss[i].setKtek_fk_idlanguage(null);
			}
			es.tekniker.framework.ktek.Ktek_translation_text[] lKtek_translation_texts = (es.tekniker.framework.ktek.Ktek_translation_text[])ktek_language.getKtek_translation_text().toArray(new es.tekniker.framework.ktek.Ktek_translation_text[ktek_language.getKtek_translation_text().size()]);
			for(int i = 0; i < lKtek_translation_texts.length; i++) {
				lKtek_translation_texts[i].setKtek_fk_language(null);
			}
			try {
				session.delete(ktek_language);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().refresh(ktek_language);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_language ktek_language)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException {
		try {
			es.tekniker.framework.ktek.commons.KTEKPersistentManager.instance().getSession().evict(ktek_language);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_language ktek_language)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_language loadKtek_languageByCriteria(Ktek_languageCriteria ktek_languageCriteria) {
		Ktek_language[] ktek_languages = listKtek_languageByCriteria(ktek_languageCriteria);
		if(ktek_languages == null || ktek_languages.length == 0) {
			return null;
		}
		return ktek_languages[0];
	}
	
	public Ktek_language[] listKtek_languageByCriteria(Ktek_languageCriteria ktek_languageCriteria) {
		return ktek_languageCriteria.listKtek_language();
	}
}
