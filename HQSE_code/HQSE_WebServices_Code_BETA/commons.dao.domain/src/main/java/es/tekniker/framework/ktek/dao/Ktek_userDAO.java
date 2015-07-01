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

public interface Ktek_userDAO {
	public Ktek_user loadKtek_userByORMID(int ktek_pk_iduser) throws PersistentException;
	public Ktek_user getKtek_userByORMID(int ktek_pk_iduser) throws PersistentException;
	public Ktek_user loadKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user getKtek_userByORMID(int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser) throws PersistentException;
	public Ktek_user getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser) throws PersistentException;
	public Ktek_user loadKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user getKtek_userByORMID(PersistentSession session, int ktek_pk_iduser, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user[] listKtek_userByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_user[] listKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_user(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_user(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_userByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user[] listKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_user[] listKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_user(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_user(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user loadKtek_userByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_user loadKtek_userByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user loadKtek_userByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_user loadKtek_userByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_user createKtek_user();
	public boolean save(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_user ktek_user, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_user ktek_user) throws PersistentException;
	public Ktek_user loadKtek_userByCriteria(Ktek_userCriteria ktek_userCriteria);
	public Ktek_user[] listKtek_userByCriteria(Ktek_userCriteria ktek_userCriteria);
}
