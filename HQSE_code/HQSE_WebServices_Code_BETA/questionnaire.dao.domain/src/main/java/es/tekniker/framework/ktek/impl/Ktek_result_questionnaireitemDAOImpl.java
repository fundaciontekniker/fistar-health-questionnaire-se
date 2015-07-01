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

public class Ktek_result_questionnaireitemDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_result_questionnaireitemDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_result_questionnaireitemDAOImpl.class);
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireitemByORMID(session, ktek_pk_idresultquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnaireitemByORMID(session, ktek_pk_idresultquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireitemByORMID(session, ktek_pk_idresultquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_result_questionnaireitemByORMID(session, ktek_pk_idresultquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem) throws PersistentException {
		try {
			return (Ktek_result_questionnaireitem) session.load(es.tekniker.framework.ktek.Ktek_result_questionnaireitem.class, new Integer(ktek_pk_idresultquestionnaireitem));
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem) throws PersistentException {
		try {
			return (Ktek_result_questionnaireitem) session.get(es.tekniker.framework.ktek.Ktek_result_questionnaireitem.class, new Integer(ktek_pk_idresultquestionnaireitem));
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnaireitem) session.load(es.tekniker.framework.ktek.Ktek_result_questionnaireitem.class, new Integer(ktek_pk_idresultquestionnaireitem), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_result_questionnaireitem) session.get(es.tekniker.framework.ktek.Ktek_result_questionnaireitem.class, new Integer(ktek_pk_idresultquestionnaireitem), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaireitem(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnaireitem(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnaireitem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaireitem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_result_questionnaireitem(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_result_questionnaireitem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_result_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaireitem(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaireitem as Ktek_result_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_result_questionnaireitem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaireitem as Ktek_result_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnaireitem", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_result_questionnaireitem(session, condition, orderBy);
			return (Ktek_result_questionnaireitem[]) list.toArray(new Ktek_result_questionnaireitem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_result_questionnaireitem(session, condition, orderBy, lockMode);
			return (Ktek_result_questionnaireitem[]) list.toArray(new Ktek_result_questionnaireitem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_result_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_result_questionnaireitem[] ktek_result_questionnaireitems = listKtek_result_questionnaireitemByQuery(session, condition, orderBy);
		if (ktek_result_questionnaireitems != null && ktek_result_questionnaireitems.length > 0)
			return ktek_result_questionnaireitems[0];
		else
			return null;
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_result_questionnaireitem[] ktek_result_questionnaireitems = listKtek_result_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		if (ktek_result_questionnaireitems != null && ktek_result_questionnaireitems.length > 0)
			return ktek_result_questionnaireitems[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_result_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaireitem as Ktek_result_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_result_questionnaireitem as Ktek_result_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_result_questionnaireitem", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem createKtek_result_questionnaireitem() {
		return new es.tekniker.framework.ktek.Ktek_result_questionnaireitem();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_result_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_result_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem)throws PersistentException {
		try {
			if(ktek_result_questionnaireitem.getKtek_fk_idquestionnaireitem() != null) {
				ktek_result_questionnaireitem.getKtek_fk_idquestionnaireitem().getKtek_result_questionnaireitem().remove(ktek_result_questionnaireitem);
			}
			
			if(ktek_result_questionnaireitem.getKtek_fk_idresultquestionnairesection() != null) {
				ktek_result_questionnaireitem.getKtek_fk_idresultquestionnairesection().getKtek_result_questionnaireitem().remove(ktek_result_questionnaireitem);
			}
			
			return delete(ktek_result_questionnaireitem);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_result_questionnaireitem.getKtek_fk_idquestionnaireitem() != null) {
				ktek_result_questionnaireitem.getKtek_fk_idquestionnaireitem().getKtek_result_questionnaireitem().remove(ktek_result_questionnaireitem);
			}
			
			if(ktek_result_questionnaireitem.getKtek_fk_idresultquestionnairesection() != null) {
				ktek_result_questionnaireitem.getKtek_fk_idresultquestionnairesection().getKtek_result_questionnaireitem().remove(ktek_result_questionnaireitem);
			}
			
			try {
				session.delete(ktek_result_questionnaireitem);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_result_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_result_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByCriteria(Ktek_result_questionnaireitemCriteria ktek_result_questionnaireitemCriteria) {
		Ktek_result_questionnaireitem[] ktek_result_questionnaireitems = listKtek_result_questionnaireitemByCriteria(ktek_result_questionnaireitemCriteria);
		if(ktek_result_questionnaireitems == null || ktek_result_questionnaireitems.length == 0) {
			return null;
		}
		return ktek_result_questionnaireitems[0];
	}
	
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByCriteria(Ktek_result_questionnaireitemCriteria ktek_result_questionnaireitemCriteria) {
		return ktek_result_questionnaireitemCriteria.listKtek_result_questionnaireitem();
	}
}
