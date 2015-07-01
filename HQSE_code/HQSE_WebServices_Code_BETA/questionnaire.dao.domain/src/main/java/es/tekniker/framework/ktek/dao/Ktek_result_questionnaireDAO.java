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
*/package es.tekniker.framework.ktek.dao;

import org.orm.*;
import org.hibernate.LockMode;
import es.tekniker.framework.ktek.*;

public interface Ktek_result_questionnaireDAO {
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire) throws PersistentException;
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire) throws PersistentException;
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire getKtek_result_questionnaireByORMID(PersistentSession session, int ktek_pk_idresultquestionnaire, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_result_questionnaire(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_result_questionnaire(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_result_questionnaire(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_result_questionnaire(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_result_questionnaire createKtek_result_questionnaire();
	public boolean save(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_result_questionnaire ktek_result_questionnaire) throws PersistentException;
	public Ktek_result_questionnaire loadKtek_result_questionnaireByCriteria(Ktek_result_questionnaireCriteria ktek_result_questionnaireCriteria);
	public Ktek_result_questionnaire[] listKtek_result_questionnaireByCriteria(Ktek_result_questionnaireCriteria ktek_result_questionnaireCriteria);
}
