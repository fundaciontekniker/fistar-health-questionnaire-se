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

public interface Ktek_unit_parameterDAO {
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException;
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException;
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter getKtek_unit_parameterByORMID(PersistentSession session, int ktek_fk_idquestionnaireitem_ktek_fk_idquestionnaireitem, int ktek_fk_idunit_ktek_pk_idunit, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_unit_parameter(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_unit_parameter(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_unit_parameter[] listKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_unit_parameter(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_unit_parameter(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_unit_parameter createKtek_unit_parameter();
	public boolean save(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_unit_parameter ktek_unit_parameter) throws PersistentException;
	public Ktek_unit_parameter loadKtek_unit_parameterByCriteria(Ktek_unit_parameterCriteria ktek_unit_parameterCriteria);
	public Ktek_unit_parameter[] listKtek_unit_parameterByCriteria(Ktek_unit_parameterCriteria ktek_unit_parameterCriteria);
}
