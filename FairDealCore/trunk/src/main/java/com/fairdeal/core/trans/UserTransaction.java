package com.fairdeal.core.trans;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserTransaction{

	private Transaction aTransaction;
	private Session session;
	
	public UserTransaction(Session session){
		this.aTransaction = session.beginTransaction();
		this.session = session;
	}
	
	public UserTransaction(Transaction aTransaction, Session session){
		this.aTransaction = aTransaction;
		this.session = session;
	}
	
	/**
	 * @return the aTransaction
	 */
	public org.hibernate.Transaction getTransaction() {
		return aTransaction;
	}
	/**
	 * @param aTransaction the aTransaction to set
	 */
	public void setTransaction(Transaction aTransaction) {
		this.aTransaction = aTransaction;
	}
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	} 
	
	
	
}
