package com.fairdeal.core.db.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fairdeal.basic.log4j.Loger;
import com.fairdeal.core.trans.UserTransaction;

/**
 * This class will create basic Call for setting up the Utility for Hibernate
 * 
 * @author puneetb
 */
public class HibernateUtil {

	private static HibernateUtil mInstance;
	private Session mSession;
	
	public static HibernateUtil getInstance(){
		if (mInstance == null ){
			mInstance = new HibernateUtil();
		}
		return mInstance;
	}
	
	private static SessionFactory sessionFactory; 
	
	private static SessionFactory buildSessionFactory(){
		SessionFactory factory = null;
		try{
			Configuration configuration = new Configuration();
			configuration = configuration.configure();
			factory = configuration.buildSessionFactory();
		}catch(NullPointerException e){
			Loger.app.error("Exception caused",e);
		}
		System.out.println("Session factory which will be returned is ::"+factory);
		sessionFactory = factory;
		return sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		if (sessionFactory==null) buildSessionFactory();
		return sessionFactory;
	}
	
	public Session getCurrentSession(){
		Session currentSession= null;
		try{
		currentSession = getSessionFactory().getCurrentSession();
		}catch(HibernateException ex){
			System.err.println("HibernateException caused");
			ex.printStackTrace();
			currentSession = getSessionFactory().openSession();
		}
		return currentSession;
	}
	
	public Session getNewSession(){
		Session currentSession= getSessionFactory().openSession();
		return currentSession;
	}
	
	public void shutdown() {
		getSessionFactory().close();
	}
	
	public UserTransaction getUserTransaction (Session currentSession){
		UserTransaction aTrans = new UserTransaction(currentSession);
		return aTrans;
	}
	
}
