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

public class Ktek_qsection_questionnaireDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_qsection_questionnaireDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_qsection_questionnaireDAOImpl.class);
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qsection_questionnaireByORMID(session, ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_qsection_questionnaireByORMID(session, ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
		}
		catch (Exception e) {
			_logger.error("getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qsection_questionnaireByORMID(session, ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_qsection_questionnaireByORMID(session, ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			Ktek_qsection_questionnaire ktek_qsection_questionnaire = new es.tekniker.framework.ktek.Ktek_qsection_questionnaire();
			ktek_qsection_questionnaire.setKtek_fk_idquestionnaire_ktek_pk_idquestionnaire(ktek_fk_idquestionnaire_ktek_pk_idquestionnaire);
			ktek_qsection_questionnaire.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			
			return (Ktek_qsection_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_qsection_questionnaire.class, ktek_qsection_questionnaire);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException {
		try {
			Ktek_qsection_questionnaire ktek_qsection_questionnaire = new es.tekniker.framework.ktek.Ktek_qsection_questionnaire();
			ktek_qsection_questionnaire.setKtek_fk_idquestionnaire_ktek_pk_idquestionnaire(ktek_fk_idquestionnaire_ktek_pk_idquestionnaire);
			ktek_qsection_questionnaire.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			
			return (Ktek_qsection_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_qsection_questionnaire.class, ktek_qsection_questionnaire);
		}
		catch (Exception e) {
			_logger.error("getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_qsection_questionnaire ktek_qsection_questionnaire = new es.tekniker.framework.ktek.Ktek_qsection_questionnaire();
			ktek_qsection_questionnaire.setKtek_fk_idquestionnaire_ktek_pk_idquestionnaire(ktek_fk_idquestionnaire_ktek_pk_idquestionnaire);
			ktek_qsection_questionnaire.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			
			return (Ktek_qsection_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_qsection_questionnaire.class, ktek_qsection_questionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_qsection_questionnaire ktek_qsection_questionnaire = new es.tekniker.framework.ktek.Ktek_qsection_questionnaire();
			ktek_qsection_questionnaire.setKtek_fk_idquestionnaire_ktek_pk_idquestionnaire(ktek_fk_idquestionnaire_ktek_pk_idquestionnaire);
			ktek_qsection_questionnaire.setKtek_fk_idquestionnairesection_ktek_pk_idquestionnairesection(ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection);
			
			return (Ktek_qsection_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_qsection_questionnaire.class, ktek_qsection_questionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qsection_questionnaire(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_qsection_questionnaire(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_qsection_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qsection_questionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_qsection_questionnaire(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_qsection_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_qsection_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_qsection_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qsection_questionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qsection_questionnaire as Ktek_qsection_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_qsection_questionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qsection_questionnaire as Ktek_qsection_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_qsection_questionnaire", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_qsection_questionnaire(session, condition, orderBy);
			return (Ktek_qsection_questionnaire[]) list.toArray(new Ktek_qsection_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_qsection_questionnaire(session, condition, orderBy, lockMode);
			return (Ktek_qsection_questionnaire[]) list.toArray(new Ktek_qsection_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qsection_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_qsection_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_qsection_questionnaire[] ktek_qsection_questionnaires = listKtek_qsection_questionnaireByQuery(session, condition, orderBy);
		if (ktek_qsection_questionnaires != null && ktek_qsection_questionnaires.length > 0)
			return ktek_qsection_questionnaires[0];
		else
			return null;
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_qsection_questionnaire[] ktek_qsection_questionnaires = listKtek_qsection_questionnaireByQuery(session, condition, orderBy, lockMode);
		if (ktek_qsection_questionnaires != null && ktek_qsection_questionnaires.length > 0)
			return ktek_qsection_questionnaires[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_qsection_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_qsection_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qsection_questionnaire as Ktek_qsection_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_qsection_questionnaire as Ktek_qsection_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_qsection_questionnaire", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire createKtek_qsection_questionnaire() {
		return new es.tekniker.framework.ktek.Ktek_qsection_questionnaire();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_qsection_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_qsection_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire)throws PersistentException {
		try {
			if(ktek_qsection_questionnaire.getKtek_fk_idquestionnaire() != null) {
				ktek_qsection_questionnaire.getKtek_fk_idquestionnaire().getKtek_qsection_questionnaire().remove(ktek_qsection_questionnaire);
			}
			
			if(ktek_qsection_questionnaire.getKtek_fk_idquestionnairesection() != null) {
				ktek_qsection_questionnaire.getKtek_fk_idquestionnairesection().getKtek_qsection_questionnaire().remove(ktek_qsection_questionnaire);
			}
			
			return delete(ktek_qsection_questionnaire);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_qsection_questionnaire.getKtek_fk_idquestionnaire() != null) {
				ktek_qsection_questionnaire.getKtek_fk_idquestionnaire().getKtek_qsection_questionnaire().remove(ktek_qsection_questionnaire);
			}
			
			if(ktek_qsection_questionnaire.getKtek_fk_idquestionnairesection() != null) {
				ktek_qsection_questionnaire.getKtek_fk_idquestionnairesection().getKtek_qsection_questionnaire().remove(ktek_qsection_questionnaire);
			}
			
			try {
				session.delete(ktek_qsection_questionnaire);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_qsection_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_qsection_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByCriteria(Ktek_qsection_questionnaireCriteria ktek_qsection_questionnaireCriteria) {
		Ktek_qsection_questionnaire[] ktek_qsection_questionnaires = listKtek_qsection_questionnaireByCriteria(ktek_qsection_questionnaireCriteria);
		if(ktek_qsection_questionnaires == null || ktek_qsection_questionnaires.length == 0) {
			return null;
		}
		return ktek_qsection_questionnaires[0];
	}
	
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByCriteria(Ktek_qsection_questionnaireCriteria ktek_qsection_questionnaireCriteria) {
		return ktek_qsection_questionnaireCriteria.listKtek_qsection_questionnaire();
	}
}
