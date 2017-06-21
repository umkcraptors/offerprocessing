package com.businessintelli.offerprocessing.dao;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.businessintelli.offerprocessing.model.*;

public class MarketerDao implements MarketerDaoInterface <Marketer, String> {

	private Session currentSession;
	private Transaction currentTransaction;
	private EntityManager manager;

	public MarketerDao() {

	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();

		return currentSession;

	}

	public Session openCurrentSessionwithTransaction() {

		currentSession = getSessionFactory().openSession();

		currentTransaction = currentSession.beginTransaction();

		return currentSession;

	}

	public void closeCurrentSession() {

		currentSession.close();

	}

	public void closeCurrentSessionwithTransaction() {

		currentTransaction.commit();

		currentSession.close();

	}

	public static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

				.applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		return sessionFactory;

	}

	public Session getCurrentSession() {

		return currentSession;

	}

	public void setCurrentSession(Session currentSession) {

		this.currentSession = currentSession;

	}

	public Transaction getCurrentTransaction() {

		return currentTransaction;

	}

	public void setCurrentTransaction(Transaction currentTransaction) {

		this.currentTransaction = currentTransaction;

	}

	public void persist(Marketer entity) {
		Session session = MarketerDao.getSessionFactory().openSession();
//     Transaction t = session.beginTransaction();
		System.out.println(getCurrentSession());
		session.persist(entity);
		session.flush();
//		t.commit();

	}
	public void update(Marketer entity) {

		getCurrentSession().update(entity);

	}

	public Marketer findById(String id) {
		
		//return getCurrentSession().byId(Marketer.class)
		return null;
	}

	public void delete(Marketer entity) {
		
		
	}

	public List<Marketer> findAll() {
		
		return null;
	}

	public void deleteAll() {
	
	}
        
}
