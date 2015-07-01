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

public class Ktek_qitem_sectionDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_qitem_sectionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_qitem_sectionDAOImpl.class);
	public Ktek_qitem_section loadKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qitem_sectionByORMID(session, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section getKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_qitem_sectionByORMID(session, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("getKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qitem_sectionByORMID(session, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section getKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_qitem_sectionByORMID(session, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_qitem_sectionByORMID(int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			Ktek_qitem_section ktek_qitem_section = new es.tekniker.framework.ktek.Ktek_qitem_section();
			ktek_qitem_section.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			ktek_qitem_section.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			
			return (Ktek_qitem_section) session.load(es.tekniker.framework.ktek.Ktek_qitem_section.class, ktek_qitem_section);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section getKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			Ktek_qitem_section ktek_qitem_section = new es.tekniker.framework.ktek.Ktek_qitem_section();
			ktek_qitem_section.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			ktek_qitem_section.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			
			return (Ktek_qitem_section) session.get(es.tekniker.framework.ktek.Ktek_qitem_section.class, ktek_qitem_section);
		}
		catch (Exception e) {
			_logger.error("getKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_qitem_section ktek_qitem_section = new es.tekniker.framework.ktek.Ktek_qitem_section();
			ktek_qitem_section.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			ktek_qitem_section.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			
			return (Ktek_qitem_section) session.load(es.tekniker.framework.ktek.Ktek_qitem_section.class, ktek_qitem_section, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section getKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_qitem_section ktek_qitem_section = new es.tekniker.framework.ktek.Ktek_qitem_section();
			ktek_qitem_section.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			ktek_qitem_section.setKtek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem);
			
			return (Ktek_qitem_section) session.get(es.tekniker.framework.ktek.Ktek_qitem_section.class, ktek_qitem_section, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_qitem_sectionByORMID(PersistentSession session, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, int ktek_fk_idquestionnaireitem_ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qitem_section(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_qitem_section(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_qitem_section(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qitem_section(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_qitem_section(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_qitem_section(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section[] listKtek_qitem_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_qitem_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section[] listKtek_qitem_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_qitem_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qitem_section(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qitem_section as Ktek_qitem_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qitem_section(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qitem_section as Ktek_qitem_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_qitem_section", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section[] listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_qitem_section(session, condition, orderBy);
			return (Ktek_qitem_section[]) list.toArray(new Ktek_qitem_section[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section[] listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_qitem_section(session, condition, orderBy, lockMode);
			return (Ktek_qitem_section[]) list.toArray(new Ktek_qitem_section[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qitem_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qitem_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_qitem_section[] ktek_qitem_sections = listKtek_qitem_sectionByQuery(session, condition, orderBy);
		if (ktek_qitem_sections != null && ktek_qitem_sections.length > 0)
			return ktek_qitem_sections[0];
		else
			return null;
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_qitem_section[] ktek_qitem_sections = listKtek_qitem_sectionByQuery(session, condition, orderBy, lockMode);
		if (ktek_qitem_sections != null && ktek_qitem_sections.length > 0)
			return ktek_qitem_sections[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_qitem_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_qitem_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qitem_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_qitem_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qitem_sectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qitem_section as Ktek_qitem_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qitem_section as Ktek_qitem_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_qitem_section", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qitem_sectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section createKtek_qitem_section() {
		return new es.tekniker.framework.ktek.Ktek_qitem_section();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_qitem_section);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_qitem_section);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section)throws PersistentException {
		try {
			if(ktek_qitem_section.getKtek_fk_idquestionnairesection() != null) {
				ktek_qitem_section.getKtek_fk_idquestionnairesection().getKtek_qitem_section().remove(ktek_qitem_section);
			}
			
			if(ktek_qitem_section.getKtek_fk_idquestionnaireitem() != null) {
				ktek_qitem_section.getKtek_fk_idquestionnaireitem().getKtek_qitem_section().remove(ktek_qitem_section);
			}
			
			return delete(ktek_qitem_section);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_qitem_section.getKtek_fk_idquestionnairesection() != null) {
				ktek_qitem_section.getKtek_fk_idquestionnairesection().getKtek_qitem_section().remove(ktek_qitem_section);
			}
			
			if(ktek_qitem_section.getKtek_fk_idquestionnaireitem() != null) {
				ktek_qitem_section.getKtek_fk_idquestionnaireitem().getKtek_qitem_section().remove(ktek_qitem_section);
			}
			
			try {
				session.delete(ktek_qitem_section);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_qitem_section);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_qitem_section);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_qitem_section ktek_qitem_section)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qitem_section loadKtek_qitem_sectionByCriteria(Ktek_qitem_sectionCriteria ktek_qitem_sectionCriteria) {
		Ktek_qitem_section[] ktek_qitem_sections = listKtek_qitem_sectionByCriteria(ktek_qitem_sectionCriteria);
		if(ktek_qitem_sections == null || ktek_qitem_sections.length == 0) {
			return null;
		}
		return ktek_qitem_sections[0];
	}
	
	public Ktek_qitem_section[] listKtek_qitem_sectionByCriteria(Ktek_qitem_sectionCriteria ktek_qitem_sectionCriteria) {
		return ktek_qitem_sectionCriteria.listKtek_qitem_section();
	}
}
