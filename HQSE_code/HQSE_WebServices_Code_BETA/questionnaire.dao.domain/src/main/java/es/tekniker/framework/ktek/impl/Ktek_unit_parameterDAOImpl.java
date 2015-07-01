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

public class Ktek_unit_parameterDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_unit_parameterDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_unit_parameterDAOImpl.class);
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unit_parameterByORMID(session, ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, ktek_fk_idunit_ktek_pk_idunit);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_unit_parameterByORMID(session, ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, ktek_fk_idunit_ktek_pk_idunit);
		}
		catch (Exception e) {
			_logger.error("getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unit_parameterByORMID(session, ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, ktek_fk_idunit_ktek_pk_idunit, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_unit_parameterByORMID(session, ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, ktek_fk_idunit_ktek_pk_idunit, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException {
		try {
			Ktek_unit_parameter ktek_unit_parameter = new es.tekniker.framework.ktek.Ktek_unit_parameter();
			ktek_unit_parameter.setKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem);
			ktek_unit_parameter.setKtek_fk_idunit_ktek_pk_idunit(ktek_fk_idunit_ktek_pk_idunit);
			
			return (Ktek_unit_parameter) session.load(es.tekniker.framework.ktek.Ktek_unit_parameter.class, ktek_unit_parameter);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException {
		try {
			Ktek_unit_parameter ktek_unit_parameter = new es.tekniker.framework.ktek.Ktek_unit_parameter();
			ktek_unit_parameter.setKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem);
			ktek_unit_parameter.setKtek_fk_idunit_ktek_pk_idunit(ktek_fk_idunit_ktek_pk_idunit);
			
			return (Ktek_unit_parameter) session.get(es.tekniker.framework.ktek.Ktek_unit_parameter.class, ktek_unit_parameter);
		}
		catch (Exception e) {
			_logger.error("getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_unit_parameter ktek_unit_parameter = new es.tekniker.framework.ktek.Ktek_unit_parameter();
			ktek_unit_parameter.setKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem);
			ktek_unit_parameter.setKtek_fk_idunit_ktek_pk_idunit(ktek_fk_idunit_ktek_pk_idunit);
			
			return (Ktek_unit_parameter) session.load(es.tekniker.framework.ktek.Ktek_unit_parameter.class, ktek_unit_parameter, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ktek_unit_parameter ktek_unit_parameter = new es.tekniker.framework.ktek.Ktek_unit_parameter();
			ktek_unit_parameter.setKtek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem(ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem);
			ktek_unit_parameter.setKtek_fk_idunit_ktek_pk_idunit(ktek_fk_idunit_ktek_pk_idunit);
			
			return (Ktek_unit_parameter) session.get(es.tekniker.framework.ktek.Ktek_unit_parameter.class, ktek_unit_parameter, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit_parameter(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_unit_parameter(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_unit_parameter(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit_parameter(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_unit_parameter(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_unit_parameter(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_unit_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_unit_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit_parameter(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit_parameter as Ktek_unit_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit_parameter(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit_parameter as Ktek_unit_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_unit_parameter", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_unit_parameter(session, condition, orderBy);
			return (Ktek_unit_parameter[]) list.toArray(new Ktek_unit_parameter[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_unit_parameter(session, condition, orderBy, lockMode);
			return (Ktek_unit_parameter[]) list.toArray(new Ktek_unit_parameter[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unit_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unit_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_unit_parameter[] ktek_unit_parameters = listKtek_unit_parameterByQuery(session, condition, orderBy);
		if (ktek_unit_parameters != null && ktek_unit_parameters.length > 0)
			return ktek_unit_parameters[0];
		else
			return null;
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_unit_parameter[] ktek_unit_parameters = listKtek_unit_parameterByQuery(session, condition, orderBy, lockMode);
		if (ktek_unit_parameters != null && ktek_unit_parameters.length > 0)
			return ktek_unit_parameters[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_unit_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_unit_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unit_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit_parameter as Ktek_unit_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit_parameter as Ktek_unit_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_unit_parameter", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter createKtek_unit_parameter() {
		return new es.tekniker.framework.ktek.Ktek_unit_parameter();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_unit_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_unit_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter)throws PersistentException {
		try {
			if(ktek_unit_parameter.getKtek_fk_idquestionnaireitem() != null) {
				ktek_unit_parameter.getKtek_fk_idquestionnaireitem().getKtek_unit_parameter().remove(ktek_unit_parameter);
			}
			
			if(ktek_unit_parameter.getKtek_fk_idunit() != null) {
				ktek_unit_parameter.getKtek_fk_idunit().getKtek_unit_parameter().remove(ktek_unit_parameter);
			}
			
			return delete(ktek_unit_parameter);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_unit_parameter.getKtek_fk_idquestionnaireitem() != null) {
				ktek_unit_parameter.getKtek_fk_idquestionnaireitem().getKtek_unit_parameter().remove(ktek_unit_parameter);
			}
			
			if(ktek_unit_parameter.getKtek_fk_idunit() != null) {
				ktek_unit_parameter.getKtek_fk_idunit().getKtek_unit_parameter().remove(ktek_unit_parameter);
			}
			
			try {
				session.delete(ktek_unit_parameter);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_unit_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_unit_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit_parameter loadKtek_unit_parameterByCriteria(Ktek_unit_parameterCriteria ktek_unit_parameterCriteria) {
		Ktek_unit_parameter[] ktek_unit_parameters = listKtek_unit_parameterByCriteria(ktek_unit_parameterCriteria);
		if(ktek_unit_parameters == null || ktek_unit_parameters.length == 0) {
			return null;
		}
		return ktek_unit_parameters[0];
	}
	
	public Ktek_unit_parameter[] listKtek_unit_parameterByCriteria(Ktek_unit_parameterCriteria ktek_unit_parameterCriteria) {
		return ktek_unit_parameterCriteria.listKtek_unit_parameter();
	}
}
