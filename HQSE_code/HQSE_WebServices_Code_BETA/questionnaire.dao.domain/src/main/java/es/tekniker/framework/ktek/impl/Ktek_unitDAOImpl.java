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

public class Ktek_unitDAOImpl implements es.tekniker.framework.ktek.dao.Ktek_unitDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Ktek_unitDAOImpl.class);
	public Ktek_unit loadKtek_unitByORMID(int ktek_pk_idunit) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unitByORMID(session, ktek_pk_idunit);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByORMID(int ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit getKtek_unitByORMID(int ktek_pk_idunit) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_unitByORMID(session, ktek_pk_idunit);
		}
		catch (Exception e) {
			_logger.error("getKtek_unitByORMID(int ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByORMID(int ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unitByORMID(session, ktek_pk_idunit, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByORMID(int ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit getKtek_unitByORMID(int ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return getKtek_unitByORMID(session, ktek_pk_idunit, lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_unitByORMID(int ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit) throws PersistentException {
		try {
			return (Ktek_unit) session.load(es.tekniker.framework.ktek.Ktek_unit.class, new Integer(ktek_pk_idunit));
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit getKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit) throws PersistentException {
		try {
			return (Ktek_unit) session.get(es.tekniker.framework.ktek.Ktek_unit.class, new Integer(ktek_pk_idunit));
		}
		catch (Exception e) {
			_logger.error("getKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_unit) session.load(es.tekniker.framework.ktek.Ktek_unit.class, new Integer(ktek_pk_idunit), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit getKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ktek_unit) session.get(es.tekniker.framework.ktek.Ktek_unit.class, new Integer(ktek_pk_idunit), lockMode);
		}
		catch (Exception e) {
			_logger.error("getKtek_unitByORMID(PersistentSession session, int ktek_pk_idunit, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_unit(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryKtek_unit(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return queryKtek_unit(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryKtek_unit(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit[] listKtek_unitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_unitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit[] listKtek_unitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return listKtek_unitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit as Ktek_unit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryKtek_unit(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit as Ktek_unit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_unit", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit[] listKtek_unitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKtek_unit(session, condition, orderBy);
			return (Ktek_unit[]) list.toArray(new Ktek_unit[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit[] listKtek_unitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKtek_unit(session, condition, orderBy, lockMode);
			return (Ktek_unit[]) list.toArray(new Ktek_unit[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return loadKtek_unitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ktek_unit[] ktek_units = listKtek_unitByQuery(session, condition, orderBy);
		if (ktek_units != null && ktek_units.length > 0)
			return ktek_units[0];
		else
			return null;
	}
	
	public Ktek_unit loadKtek_unitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ktek_unit[] ktek_units = listKtek_unitByQuery(session, condition, orderBy, lockMode);
		if (ktek_units != null && ktek_units.length > 0)
			return ktek_units[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateKtek_unitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_unitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession();
			return iterateKtek_unitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unitByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit as Ktek_unit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateKtek_unitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From es.tekniker.framework.ktek.Ktek_unit as Ktek_unit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ktek_unit", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateKtek_unitByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit createKtek_unit() {
		return new es.tekniker.framework.ktek.Ktek_unit();
	}
	
	public boolean save(es.tekniker.framework.ktek.Ktek_unit ktek_unit) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().saveObject(ktek_unit);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(es.tekniker.framework.ktek.Ktek_unit ktek_unit)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(es.tekniker.framework.ktek.Ktek_unit ktek_unit) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().deleteObject(ktek_unit);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(es.tekniker.framework.ktek.Ktek_unit ktek_unit)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit ktek_unit)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_unit_parameter[] lKtek_unit_parameters = (es.tekniker.framework.ktek.Ktek_unit_parameter[])ktek_unit.getKtek_unit_parameter().toArray(new es.tekniker.framework.ktek.Ktek_unit_parameter[ktek_unit.getKtek_unit_parameter().size()]);
			for(int i = 0; i < lKtek_unit_parameters.length; i++) {
				lKtek_unit_parameters[i].setKtek_fk_idunit(null);
			}
			return delete(ktek_unit);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit ktek_unit, org.orm.PersistentSession session)throws PersistentException {
		try {
			es.tekniker.framework.ktek.Ktek_unit_parameter[] lKtek_unit_parameters = (es.tekniker.framework.ktek.Ktek_unit_parameter[])ktek_unit.getKtek_unit_parameter().toArray(new es.tekniker.framework.ktek.Ktek_unit_parameter[ktek_unit.getKtek_unit_parameter().size()]);
			for(int i = 0; i < lKtek_unit_parameters.length; i++) {
				lKtek_unit_parameters[i].setKtek_fk_idunit(null);
			}
			try {
				session.delete(ktek_unit);
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
	
	public boolean refresh(es.tekniker.framework.ktek.Ktek_unit ktek_unit) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().refresh(ktek_unit);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(es.tekniker.framework.ktek.Ktek_unit ktek_unit)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(es.tekniker.framework.ktek.Ktek_unit ktek_unit) throws PersistentException {
		try {
			es.tekniker.framework.ktek.questionnaire.KTEKPersistentManager.instance().getSession().evict(ktek_unit);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(es.tekniker.framework.ktek.Ktek_unit ktek_unit)", e);
			throw new PersistentException(e);
		}
	}
	
	public Ktek_unit loadKtek_unitByCriteria(Ktek_unitCriteria ktek_unitCriteria) {
		Ktek_unit[] ktek_units = listKtek_unitByCriteria(ktek_unitCriteria);
		if(ktek_units == null || ktek_units.length == 0) {
			return null;
		}
		return ktek_units[0];
	}
	
	public Ktek_unit[] listKtek_unitByCriteria(Ktek_unitCriteria ktek_unitCriteria) {
		return ktek_unitCriteria.listKtek_unit();
	}
}
