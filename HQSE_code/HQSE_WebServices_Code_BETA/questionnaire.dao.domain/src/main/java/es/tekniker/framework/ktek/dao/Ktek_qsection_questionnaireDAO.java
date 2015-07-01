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

public interface Ktek_qsection_questionnaireDAO {
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire getKtek_qsection_questionnaireByORMID(PersistentSession session, int ktek_fk_idquestionnaire_ktek_pk_idquestionnaire, int ktek_fk_idquestionnairesection_ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_qsection_questionnaire(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_qsection_questionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_qsection_questionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_qsection_questionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_qsection_questionnaire createKtek_qsection_questionnaire();
	public boolean save(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_qsection_questionnaire ktek_qsection_questionnaire) throws PersistentException;
	public Ktek_qsection_questionnaire loadKtek_qsection_questionnaireByCriteria(Ktek_qsection_questionnaireCriteria ktek_qsection_questionnaireCriteria);
	public Ktek_qsection_questionnaire[] listKtek_qsection_questionnaireByCriteria(Ktek_qsection_questionnaireCriteria ktek_qsection_questionnaireCriteria);
}
