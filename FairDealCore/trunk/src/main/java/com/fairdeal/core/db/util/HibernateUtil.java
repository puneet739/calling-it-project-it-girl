package com.fairdeal.core.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fairdeal.basic.log4j.Loger;

/**
 * This class will create basic Call for setting up the Utility for Hibernate
 * 
 * @author puneetb
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory; 
	
	private static SessionFactory buildSessionFactory(){
		SessionFactory factory = null;
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			factory = configuration.buildSessionFactory();
		}catch(NullPointerException e){
			Loger.app.error("Exception caused here",e);
		}
		System.out.println("Session factory which will be returned is ::"+factory);
		return factory;
	}
	
	public static SessionFactory getSessionFactory(){
		if (sessionFactory==null) buildSessionFactory();
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
	
}
