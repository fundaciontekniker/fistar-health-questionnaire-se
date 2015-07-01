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

public class Ktek_parameterDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_parameterDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_parameterDAOImpl.class);
	public List queryKtek_parameter(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_parameter(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_parameter(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_parameter(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_parameter(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_parameter(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter[] listKtek_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter[] listKtek_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_parameter(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_parameter as Ktek_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_parameter(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_parameter as Ktek_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_parameter", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter[] listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_parameter(session, condition, orderBy);
			return (Ktek_parameter[]) list.toArray(new Ktek_parameter[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter[] listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_parameter(session, condition, orderBy, lockMode);
			return (Ktek_parameter[]) list.toArray(new Ktek_parameter[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter loadKtek_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter loadKtek_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter loadKtek_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_parameter[] ktek_parameters = listKtek_parameterByQuery(session, condition, orderBy);
		if (ktek_parameters != null && ktek_parameters.length > 0)
			return ktek_parameters[0];
		else
			return null;
	}
	
	public Ktek_parameter loadKtek_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_parameter[] ktek_parameters = listKtek_parameterByQuery(session, condition, orderBy, lockMode);
		if (ktek_parameters != null && ktek_parameters.length > 0)
			return ktek_parameters[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_parameterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_parameterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_parameterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_parameterByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_parameter as Ktek_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_parameter as Ktek_parameter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_parameter", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_parameterByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter createKtek_parameter() {
		return new es.tekniker.framework.ktek.Ktek_parameter();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter)throws PersistentException {
		try {
			if(ktek_parameter.getKtek_fk_idquestionnaireitem() != null) {
				ktek_parameter.getKtek_fk_idquestionnaireitem().setKtek_parameter(null);
			}
			
			es.tekniker.framework.ktek.Ktek_unit_parameter[] lKtek_unit_parameters = (es.tekniker.framework.ktek.Ktek_unit_parameter[])ktek_parameter.getKtek_unit_parameter().toArray(new es.tekniker.framework.ktek.Ktek_unit_parameter[ktek_parameter.getKtek_unit_parameter().size()]);
			for(int i = 0; i < lKtek_unit_parameters.length; i++) {
				lKtek_unit_parameters[i].setKtek_fk_idquestionnaireitem(null);
			}
			return delete(ktek_parameter);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(ktek_parameter.getKtek_fk_idquestionnaireitem() != null) {
				ktek_parameter.getKtek_fk_idquestionnaireitem().setKtek_parameter(null);
			}
			
			es.tekniker.framework.ktek.Ktek_unit_parameter[] lKtek_unit_parameters = (es.tekniker.framework.ktek.Ktek_unit_parameter[])ktek_parameter.getKtek_unit_parameter().toArray(new es.tekniker.framework.ktek.Ktek_unit_parameter[ktek_parameter.getKtek_unit_parameter().size()]);
			for(int i = 0; i < lKtek_unit_parameters.length; i++) {
				lKtek_unit_parameters[i].setKtek_fk_idquestionnaireitem(null);
			}
			try {
				session.delete(ktek_parameter);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_parameter);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_parameter ktek_parameter)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_parameter loadKtek_parameterByCriteria(Ktek_parameterCriteria ktek_parameterCriteria) {
		Ktek_parameter[] ktek_parameters = listKtek_parameterByCriteria(ktek_parameterCriteria);
		if(ktek_parameters == null || ktek_parameters.length == 0) {
			return null;
		}
		return ktek_parameters[0];
	}
	
	public Ktek_parameter[] listKtek_parameterByCriteria(Ktek_parameterCriteria ktek_parameterCriteria) {
		return ktek_parameterCriteria.listKtek_parameter();
	}
}
