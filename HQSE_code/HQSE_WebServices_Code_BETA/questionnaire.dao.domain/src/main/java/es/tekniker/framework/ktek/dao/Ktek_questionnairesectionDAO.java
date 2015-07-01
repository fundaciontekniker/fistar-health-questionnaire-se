package es.tekniker.framework.ktek.dao;

import org.orm.*;
import org.hibernate.LockMode;
import es.tekniker.framework.ktek.*;

public interface Ktek_questionnairesectionDAO {
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection getKtek_questionnairesectionByORMID(PersistentSession session, int ktek_pk_idquestionnairesection, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_questionnairesection(String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_questionnairesection(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_questionnairesection[] listKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryKtek_questionnairesection(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryKtek_questionnairesection(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(String condition, String orderBy) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ktek_questionnairesection createKtek_questionnairesection();
	public boolean save(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException;
	public boolean delete(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException;
	public boolean deleteAndDissociate(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException;
	public boolean evict(es.tekniker.framework.ktek.Ktek_questionnairesection ktek_questionnairesection) throws PersistentException;
	public Ktek_questionnairesection loadKtek_questionnairesectionByCriteria(Ktek_questionnairesectionCriteria ktek_questionnairesectionCriteria);
	public Ktek_questionnairesection[] listKtek_questionnairesectionByCriteria(Ktek_questionnairesectionCriteria ktek_questionnairesectionCriteria);
}
