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

public class Ktek_questionnairesectionDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionnairesectionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionnairesectionDAOImpl.class);
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnairesectionByORMID(session, ktek_pk_idquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnairesectionByORMID(session, ktek_pk_idquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnairesectionByORMID(session, ktek_pk_idquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnairesectionByORMID(session, ktek_pk_idquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			return (Ktek_questionnairesection) session.load(es.tekniker.framework.ktek.Ktek_questionnairesection.class, new Integer(ktek_pk_idquestionnairesection));
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			return (Ktek_questionnairesection) session.get(es.tekniker.framework.ktek.Ktek_questionnairesection.class, new Integer(ktek_pk_idquestionnairesection));
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnairesection) session.load(es.tekniker.framework.ktek.Ktek_questionnairesection.class, new Integer(ktek_pk_idquestionnairesection), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnairesection) session.get(es.tekniker.framework.ktek.Ktek_questionnairesection.class, new Integer(ktek_pk_idquestionnairesection), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnairesection(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnairesection(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnairesection(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnairesection(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnairesection(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnairesection(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnairesection(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnairesection as Ktek_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnairesection(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnairesection as Ktek_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnairesection", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_questionnairesection(session, condition, orderBy);
			return (Ktek_questionnairesection[]) list.toArray(new Ktek_questionnairesection[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_questionnairesection(session, condition, orderBy, lockMode);
			return (Ktek_questionnairesection[]) list.toArray(new Ktek_questionnairesection[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_questionnairesection[] ktek_questionnairesections = listKtek_questionnairesectionByQuery(session, condition, orderBy);
		if (ktek_questionnairesections != null && ktek_questionnairesections.length > 0)
			return ktek_questionnairesections[0];
		else
			return null;
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_questionnairesection[] ktek_questionnairesections = listKtek_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		if (ktek_questionnairesections != null && ktek_questionnairesections.length > 0)
			return ktek_questionnairesections[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnairesectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnairesectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnairesectionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnairesection as Ktek_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnairesection as Ktek_questionnairesection");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnairesection", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection createKtek_questionnairesection() {
		return new es.tekniker.framework.ktek.Ktek_questionnairesection();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_qitem_section[] lKtek_qitem_sections = (es.tekniker.framework.ktek.Ktek_qitem_section[])ktek_questionnairesection.getKtek_qitem_section().toArray(new es.tekniker.framework.ktek.Ktek_qitem_section[ktek_questionnairesection.getKtek_qitem_section().size()]);
			for(int i = 0; i < lKtek_qitem_sections.length; i++) {
				lKtek_qitem_sections[i].setKtek_fk_idquestionnairesection(null);
			}
			es.tekniker.framework.ktek.Ktek_qsection_questionnaire[] lKtek_qsection_questionnaires = (es.tekniker.framework.ktek.Ktek_qsection_questionnaire[])ktek_questionnairesection.getKtek_qsection_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_qsection_questionnaire[ktek_questionnairesection.getKtek_qsection_questionnaire().size()]);
			for(int i = 0; i < lKtek_qsection_questionnaires.length; i++) {
				lKtek_qsection_questionnaires[i].setKtek_fk_idquestionnairesection(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnairesection[] lKtek_result_questionnairesections = (es.tekniker.framework.ktek.Ktek_result_questionnairesection[])ktek_questionnairesection.getKtek_result_questionnairesection().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnairesection[ktek_questionnairesection.getKtek_result_questionnairesection().size()]);
			for(int i = 0; i < lKtek_result_questionnairesections.length; i++) {
				lKtek_result_questionnairesections[i].setKtek_fk_idquestionnairesection(null);
			}
			return delete(ktek_questionnairesection);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_qitem_section[] lKtek_qitem_sections = (es.tekniker.framework.ktek.Ktek_qitem_section[])ktek_questionnairesection.getKtek_qitem_section().toArray(new es.tekniker.framework.ktek.Ktek_qitem_section[ktek_questionnairesection.getKtek_qitem_section().size()]);
			for(int i = 0; i < lKtek_qitem_sections.length; i++) {
				lKtek_qitem_sections[i].setKtek_fk_idquestionnairesection(null);
			}
			es.tekniker.framework.ktek.Ktek_qsection_questionnaire[] lKtek_qsection_questionnaires = (es.tekniker.framework.ktek.Ktek_qsection_questionnaire[])ktek_questionnairesection.getKtek_qsection_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_qsection_questionnaire[ktek_questionnairesection.getKtek_qsection_questionnaire().size()]);
			for(int i = 0; i < lKtek_qsection_questionnaires.length; i++) {
				lKtek_qsection_questionnaires[i].setKtek_fk_idquestionnairesection(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnairesection[] lKtek_result_questionnairesections = (es.tekniker.framework.ktek.Ktek_result_questionnairesection[])ktek_questionnairesection.getKtek_result_questionnairesection().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnairesection[ktek_questionnairesection.getKtek_result_questionnairesection().size()]);
			for(int i = 0; i < lKtek_result_questionnairesections.length; i++) {
				lKtek_result_questionnairesections[i].setKtek_fk_idquestionnairesection(null);
			}
			try {
				session.delete(ktek_questionnairesection);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_questionnairesection);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnairesection loadKtek_questionnairesectionByCriteria(Ktek_questionnairesectionCriteria ktek_questionnairesectionCriteria) {
		Ktek_questionnairesection[] ktek_questionnairesections = listKtek_questionnairesectionByCriteria(ktek_questionnairesectionCriteria);
		if(ktek_questionnairesections == null || ktek_questionnairesections.length == 0) {
			return null;
		}
		return ktek_questionnairesections[0];
	}
	
	public Ktek_questionnairesection[] listKtek_questionnairesectionByCriteria(Ktek_questionnairesectionCriteria ktek_questionnairesectionCriteria) {
		return ktek_questionnairesectionCriteria.listKtek_questionnairesection();
	}
}
