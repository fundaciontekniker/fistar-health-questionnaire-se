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

public interface Ktek_result_questionnaireitemDAO {
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem) throws PersistentException;
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem) throws PersistentException;
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem getKtek_result_questionnaireitemByORMID(PersistentSession session, int ktek_pk_idresultquestionnaireitem, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_result_questionnaireitem(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_result_questionnaireitem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_result_questionnaireitem(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_result_questionnaireitem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaireitem createKtek_result_questionnaireitem();
	public boolean save(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_result_questionnaireitem ktek_result_questionnaireitem) throws PersistentException;
	public Ktek_result_questionnaireitem loadKtek_result_questionnaireitemByCriteria(Ktek_result_questionnaireitemCriteria ktek_result_questionnaireitemCriteria);
	public Ktek_result_questionnaireitem[] listKtek_result_questionnaireitemByCriteria(Ktek_result_questionnaireitemCriteria ktek_result_questionnaireitemCriteria);
}
