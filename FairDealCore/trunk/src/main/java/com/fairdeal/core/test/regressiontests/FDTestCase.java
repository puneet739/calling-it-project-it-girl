/**
 * 
 */
package com.fairdeal.core.test.regressiontests;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.trans.UserTransaction;

/**
 * @author puneetb
 * 
 */
public class FDTestCase {
	
	public Session session;
	
	@Before
	public void setup() {
		session = HibernateUtil.getInstance().getNewSession();
		// Setting the names of Table which needs to be removed
		String[] tableNames = { Agent.class.getName() };
		UserTransaction transaction = new UserTransaction(HibernateUtil.getInstance().getNewSession());

		// Deleting all the tables at Start
		for (String tableName : tableNames) {
			Query query = transaction.getSession().createQuery(
					"delete " + tableName);
			query.executeUpdate();
		}
		transaction.getTransaction().commit();
	}
	
	@After
	public void tearDown() {
		session.close();
	}

	/**
	 * @return the session
	 */
	public Session getTestSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}
