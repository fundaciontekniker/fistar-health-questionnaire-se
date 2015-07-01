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
package es.tekniker.framework.ktek.dao;

import org.orm.*;
import org.hibernate.LockMode;
import es.tekniker.framework.ktek.*;

public interface Ktek_auditaccesslogDAO {
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog) throws PersistentException;
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog) throws PersistentException;
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog getKtek_auditaccesslogByORMID(PersistentSession session, int ktek_pk_idauditaccesslog, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_auditaccesslog(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_auditaccesslog(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_auditaccesslog(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_auditaccesslog(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_auditaccesslog createKtek_auditaccesslog();
	public boolean save(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_auditaccesslog ktek_auditaccesslog) throws PersistentException;
	public Ktek_auditaccesslog loadKtek_auditaccesslogByCriteria(Ktek_auditaccesslogCriteria ktek_auditaccesslogCriteria);
	public Ktek_auditaccesslog[] listKtek_auditaccesslogByCriteria(Ktek_auditaccesslogCriteria ktek_auditaccesslogCriteria);
}
