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

public interface Ktek_questionnaireitemDAO {
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem) throws PersistentException;
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem) throws PersistentException;
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem getKtek_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_questionnaireitem(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_questionnaireitem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_questionnaireitem(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_questionnaireitem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnaireitem createKtek_questionnaireitem();
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnaireitem ktek_questionnaireitem) throws PersistentException;
	public Ktek_questionnaireitem loadKtek_questionnaireitemByCriteria(Ktek_questionnaireitemCriteria ktek_questionnaireitemCriteria);
	public Ktek_questionnaireitem[] listKtek_questionnaireitemByCriteria(Ktek_questionnaireitemCriteria ktek_questionnaireitemCriteria);
}
