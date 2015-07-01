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

public interface Ktek_languageDAO {
	public Ktek_language loadKtek_languageByORMID(int ktek_pk_idlanguage) throws PersistentException;
	public Ktek_language getKtek_languageByORMID(int ktek_pk_idlanguage) throws PersistentException;
	public Ktek_language loadKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language getKtek_languageByORMID(int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage) throws PersistentException;
	public Ktek_language getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage) throws PersistentException;
	public Ktek_language loadKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language getKtek_languageByORMID(PersistentSession session, int ktek_pk_idlanguage, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language[] listKtek_languageByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_language[] listKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_language(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_language(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_languageByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language[] listKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_language[] listKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_language(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_language(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language loadKtek_languageByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_language loadKtek_languageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language loadKtek_languageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_language loadKtek_languageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_language createKtek_language();
	public boolean save(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_language ktek_language, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_language ktek_language) throws PersistentException;
	public Ktek_language loadKtek_languageByCriteria(Ktek_languageCriteria ktek_languageCriteria);
	public Ktek_language[] listKtek_languageByCriteria(Ktek_languageCriteria ktek_languageCriteria);
}
