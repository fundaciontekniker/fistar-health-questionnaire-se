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

public class Ktek_questionnaireDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionnaireDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionnaireDAOImpl.class);
	public Ktek_questionnaire loadKtek_questionnaireByORMID(int ktek_pk_idquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireByORMID(session, ktek_pk_idquestionnaire);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByORMID(int ktek_pk_idquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire getKtek_questionnaireByORMID(int ktek_pk_idquestionnaire) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireByORMID(session, ktek_pk_idquestionnaire);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireByORMID(int ktek_pk_idquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByORMID(int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireByORMID(session, ktek_pk_idquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByORMID(int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire getKtek_questionnaireByORMID(int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireByORMID(session, ktek_pk_idquestionnaire, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireByORMID(int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire) throws PersistentException {
		try {
			return (Ktek_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_questionnaire.class, new Integer(ktek_pk_idquestionnaire));
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire getKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire) throws PersistentException {
		try {
			return (Ktek_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_questionnaire.class, new Integer(ktek_pk_idquestionnaire));
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaire) session.load(es.tekniker.framework.ktek.Ktek_questionnaire.class, new Integer(ktek_pk_idquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire getKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaire) session.get(es.tekniker.framework.ktek.Ktek_questionnaire.class, new Integer(ktek_pk_idquestionnaire), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireByORMID(PersistentSession session, int ktek_pk_idquestionnaire, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaire(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaire(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaire(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaire(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire[] listKtek_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire[] listKtek_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaire as Ktek_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaire as Ktek_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaire", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire[] listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_questionnaire(session, condition, orderBy);
			return (Ktek_questionnaire[]) list.toArray(new Ktek_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire[] listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_questionnaire(session, condition, orderBy, lockMode);
			return (Ktek_questionnaire[]) list.toArray(new Ktek_questionnaire[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_questionnaire[] ktek_questionnaires = listKtek_questionnaireByQuery(session, condition, orderBy);
		if (ktek_questionnaires != null && ktek_questionnaires.length > 0)
			return ktek_questionnaires[0];
		else
			return null;
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_questionnaire[] ktek_questionnaires = listKtek_questionnaireByQuery(session, condition, orderBy, lockMode);
		if (ktek_questionnaires != null && ktek_questionnaires.length > 0)
			return ktek_questionnaires[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionnaireByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaire as Ktek_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaire as Ktek_questionnaire");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaire", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire createKtek_questionnaire() {
		return new es.tekniker.framework.ktek.Ktek_questionnaire();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire)throws PersistentException {
		try {
			if(ktek_questionnaire.getKtek_formatquestionnaire() != null) {
				ktek_questionnaire.getKtek_formatquestionnaire().setKtek_fk_questionnaire(null);
			}
			
			es.tekniker.framework.ktek.Ktek_qsection_questionnaire[] lKtek_qsection_questionnaires = (es.tekniker.framework.ktek.Ktek_qsection_questionnaire[])ktek_questionnaire.getKtek_qsection_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_qsection_questionnaire[ktek_questionnaire.getKtek_qsection_questionnaire().size()]);
			for(int i = 0; i < lKtek_qsection_questionnaires.length; i++) {
				lKtek_qsection_questionnaires[i].setKtek_fk_idquestionnaire(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnaire[] lKtek_result_questionnaires = (es.tekniker.framework.ktek.Ktek_result_questionnaire[])ktek_questionnaire.getKtek_result_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaire[ktek_questionnaire.getKtek_result_questionnaire().size()]);
			for(int i = 0; i < lKtek_result_questionnaires.length; i++) {
				lKtek_result_questionnaires[i].setKtek_fk_idquestionnaire(null);
			}
			es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[] lKtek_userquestionnaire_plannings = (es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[])ktek_questionnaire.getKtek_userquestionnaire_planning().toArray(new es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[ktek_questionnaire.getKtek_userquestionnaire_planning().size()]);
			for(int i = 0; i < lKtek_userquestionnaire_plannings.length; i++) {
				lKtek_userquestionnaire_plannings[i].setKtek_fk_idquestionnaire(null);
			}
			return delete(ktek_questionnaire);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_questionnaire.getKtek_formatquestionnaire() != null) {
				ktek_questionnaire.getKtek_formatquestionnaire().setKtek_fk_questionnaire(null);
			}
			
			es.tekniker.framework.ktek.Ktek_qsection_questionnaire[] lKtek_qsection_questionnaires = (es.tekniker.framework.ktek.Ktek_qsection_questionnaire[])ktek_questionnaire.getKtek_qsection_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_qsection_questionnaire[ktek_questionnaire.getKtek_qsection_questionnaire().size()]);
			for(int i = 0; i < lKtek_qsection_questionnaires.length; i++) {
				lKtek_qsection_questionnaires[i].setKtek_fk_idquestionnaire(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnaire[] lKtek_result_questionnaires = (es.tekniker.framework.ktek.Ktek_result_questionnaire[])ktek_questionnaire.getKtek_result_questionnaire().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaire[ktek_questionnaire.getKtek_result_questionnaire().size()]);
			for(int i = 0; i < lKtek_result_questionnaires.length; i++) {
				lKtek_result_questionnaires[i].setKtek_fk_idquestionnaire(null);
			}
			es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[] lKtek_userquestionnaire_plannings = (es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[])ktek_questionnaire.getKtek_userquestionnaire_planning().toArray(new es.tekniker.framework.ktek.Ktek_userquestionnaire_planning[ktek_questionnaire.getKtek_userquestionnaire_planning().size()]);
			for(int i = 0; i < lKtek_userquestionnaire_plannings.length; i++) {
				lKtek_userquestionnaire_plannings[i].setKtek_fk_idquestionnaire(null);
			}
			try {
				session.delete(ktek_questionnaire);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_questionnaire);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_questionnaire ktek_questionnaire)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaire loadKtek_questionnaireByCriteria(Ktek_questionnaireCriteria ktek_questionnaireCriteria) {
		Ktek_questionnaire[] ktek_questionnaires = listKtek_questionnaireByCriteria(ktek_questionnaireCriteria);
		if(ktek_questionnaires == null || ktek_questionnaires.length == 0) {
			return null;
		}
		return ktek_questionnaires[0];
	}
	
	public Ktek_questionnaire[] listKtek_questionnaireByCriteria(Ktek_questionnaireCriteria ktek_questionnaireCriteria) {
		return ktek_questionnaireCriteria.listKtek_questionnaire();
	}
}
