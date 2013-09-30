/**
 * 
 */
package com.fairdeal.core.test.regressiontests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.trans.UserTransaction;

/**
 * @author puneetb
 *
 */
public class HibernateUtilTest extends FDTestCase {

	
	@Test
	public void testHibernateSession(){
		
		Session session21 = HibernateUtil.getInstance().getNewSession();
		Session session22 = HibernateUtil.getInstance().getCurrentSession();
		
		assertNotSame(session21, session22);
		
		Session session1 = HibernateUtil.getInstance().getCurrentSession();
		Session session2 = HibernateUtil.getInstance().getCurrentSession();
		
		assertSame(session1, session2);
		//assertNotSame(session1, session2);
		
		
		session1.close();
		session21.close();
	}
	
	
	
	@Test
	public void testGetNewSession(){
		Session session1 = HibernateUtil.getInstance().getNewSession();
		Session session2 = HibernateUtil.getInstance().getNewSession();
		
		assertNotSame(session1, session2);
		session1.close();
		session2.close();
	}

	@Test
	public void testGetNewUserTransactions(){
		Session session1 = HibernateUtil.getInstance().getNewSession();
		Session session2 = HibernateUtil.getInstance().getNewSession();
		
		assertNotSame(session1, session2);
		
		UserTransaction atrans = HibernateUtil.getInstance().getUserTransaction(session1);
		UserTransaction atrans2 = HibernateUtil.getInstance().getUserTransaction(session2);
		
		assertEquals(session1, atrans.getSession());
		
		assertEquals(atrans2.getTransaction(), atrans2.getSession().getTransaction());
		atrans.getTransaction().commit();
		atrans.getSession().close();
		
		atrans2.getTransaction().commit();
		assertEquals(session2, atrans2.getSession());
		
	}
	
	
	
}
