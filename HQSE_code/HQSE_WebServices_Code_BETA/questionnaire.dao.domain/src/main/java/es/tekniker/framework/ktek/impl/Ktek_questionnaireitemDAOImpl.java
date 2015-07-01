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

public class Ktek_questionnaireitemDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_questionnaireitemDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_questionnaireitemDAOImpl.class);
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitemByORMID(session, ktek_pk_idquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireitemByORMID(session, ktek_pk_idquestionnaireitem);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitemByORMID(session, ktek_pk_idquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_questionnaireitemByORMID(session, ktek_pk_idquestionnaireitem, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			return (Ktek_questionnaireitem) session.load(es.tekniker.framework.ktek.Ktek_questionnaireitem.class, new Integer(ktek_pk_idquestionnaireitem));
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem) throws PersistentException {
		try {
			return (Ktek_questionnaireitem) session.get(es.tekniker.framework.ktek.Ktek_questionnaireitem.class, new Integer(ktek_pk_idquestionnaireitem));
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaireitem) session.load(es.tekniker.framework.ktek.Ktek_questionnaireitem.class, new Integer(ktek_pk_idquestionnaireitem), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_questionnaireitem) session.get(es.tekniker.framework.ktek.Ktek_questionnaireitem.class, new Integer(ktek_pk_idquestionnaireitem), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireitem(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireitem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_questionnaireitem(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_questionnaireitem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem as Ktek_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_questionnaireitem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem as Ktek_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireitem", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_questionnaireitem(session, condition, orderBy);
			return (Ktek_questionnaireitem[]) list.toArray(new Ktek_questionnaireitem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_questionnaireitem(session, condition, orderBy, lockMode);
			return (Ktek_questionnaireitem[]) list.toArray(new Ktek_questionnaireitem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_questionnaireitem[] ktek_questionnaireitems = listKtek_questionnaireitemByQuery(session, condition, orderBy);
		if (ktek_questionnaireitems != null && ktek_questionnaireitems.length > 0)
			return ktek_questionnaireitems[0];
		else
			return null;
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_questionnaireitem[] ktek_questionnaireitems = listKtek_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		if (ktek_questionnaireitems != null && ktek_questionnaireitems.length > 0)
			return ktek_questionnaireitems[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireitemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_questionnaireitemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem as Ktek_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_questionnaireitem as Ktek_questionnaireitem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_questionnaireitem", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem createKtek_questionnaireitem() {
		return new es.tekniker.framework.ktek.Ktek_questionnaireitem();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem)throws PersistentException {
		try {
			if(ktek_questionnaireitem.getKtek_parameter() != null) {
				ktek_questionnaireitem.getKtek_parameter().setKtek_fk_idquestionnaireitem(null);
			}
			
			es.tekniker.framework.ktek.Ktek_qitem_section[] lKtek_qitem_sections = (es.tekniker.framework.ktek.Ktek_qitem_section[])ktek_questionnaireitem.getKtek_qitem_section().toArray(new es.tekniker.framework.ktek.Ktek_qitem_section[ktek_questionnaireitem.getKtek_qitem_section().size()]);
			for(int i = 0; i < lKtek_qitem_sections.length; i++) {
				lKtek_qitem_sections[i].setKtek_fk_idquestionnaireitem(null);
			}
			if(ktek_questionnaireitem.getKtek_question() != null) {
				ktek_questionnaireitem.getKtek_question().setKtek_fk_idquestionnaireitem(null);
			}
			
			es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[] lKtek_questionnaireitem_codifications = (es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[])ktek_questionnaireitem.getKtek_questionnaireitem_codification().toArray(new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[ktek_questionnaireitem.getKtek_questionnaireitem_codification().size()]);
			for(int i = 0; i < lKtek_questionnaireitem_codifications.length; i++) {
				lKtek_questionnaireitem_codifications[i].setKtek_fk_idquestionnaireitem(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnaireitem[] lKtek_result_questionnaireitems = (es.tekniker.framework.ktek.Ktek_result_questionnaireitem[])ktek_questionnaireitem.getKtek_result_questionnaireitem().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaireitem[ktek_questionnaireitem.getKtek_result_questionnaireitem().size()]);
			for(int i = 0; i < lKtek_result_questionnaireitems.length; i++) {
				lKtek_result_questionnaireitems[i].setKtek_fk_idquestionnaireitem(null);
			}
			return delete(ktek_questionnaireitem);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_questionnaireitem.getKtek_parameter() != null) {
				ktek_questionnaireitem.getKtek_parameter().setKtek_fk_idquestionnaireitem(null);
			}
			
			es.tekniker.framework.ktek.Ktek_qitem_section[] lKtek_qitem_sections = (es.tekniker.framework.ktek.Ktek_qitem_section[])ktek_questionnaireitem.getKtek_qitem_section().toArray(new es.tekniker.framework.ktek.Ktek_qitem_section[ktek_questionnaireitem.getKtek_qitem_section().size()]);
			for(int i = 0; i < lKtek_qitem_sections.length; i++) {
				lKtek_qitem_sections[i].setKtek_fk_idquestionnaireitem(null);
			}
			if(ktek_questionnaireitem.getKtek_question() != null) {
				ktek_questionnaireitem.getKtek_question().setKtek_fk_idquestionnaireitem(null);
			}
			
			es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[] lKtek_questionnaireitem_codifications = (es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[])ktek_questionnaireitem.getKtek_questionnaireitem_codification().toArray(new es.tekniker.framework.ktek.Ktek_questionnaireitem_codification[ktek_questionnaireitem.getKtek_questionnaireitem_codification().size()]);
			for(int i = 0; i < lKtek_questionnaireitem_codifications.length; i++) {
				lKtek_questionnaireitem_codifications[i].setKtek_fk_idquestionnaireitem(null);
			}
			es.tekniker.framework.ktek.Ktek_result_questionnaireitem[] lKtek_result_questionnaireitems = (es.tekniker.framework.ktek.Ktek_result_questionnaireitem[])ktek_questionnaireitem.getKtek_result_questionnaireitem().toArray(new es.tekniker.framework.ktek.Ktek_result_questionnaireitem[ktek_questionnaireitem.getKtek_result_questionnaireitem().size()]);
			for(int i = 0; i < lKtek_result_questionnaireitems.length; i++) {
				lKtek_result_questionnaireitems[i].setKtek_fk_idquestionnaireitem(null);
			}
			try {
				session.delete(ktek_questionnaireitem);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_questionnaireitem);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_questionnaireitem loadKtek_questionnaireitemByCriteria(Ktek_questionnaireitemCriteria ktek_questionnaireitemCriteria) {
		Ktek_questionnaireitem[] ktek_questionnaireitems = listKtek_questionnaireitemByCriteria(ktek_questionnaireitemCriteria);
		if(ktek_questionnaireitems == null || ktek_questionnaireitems.length == 0) {
			return null;
		}
		return ktek_questionnaireitems[0];
	}
	
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByCriteria(Ktek_questionnaireitemCriteria ktek_questionnaireitemCriteria) {
		return ktek_questionnaireitemCriteria.listKtek_questionnaireitem();
	}
}
