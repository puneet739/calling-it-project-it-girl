package com.fairdeal.core.test.regressiontests;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.factory.AgentFactory;
import com.fairdeal.core.trans.UserTransaction;

public class AgentFactoryTest {

	@Before
	public void setup(){
		//Setting the names of Table which needs to be removed
		String[] tableNames = {Agent.class.getName()};
		UserTransaction transaction= new UserTransaction(HibernateUtil.getInstance().getNewSession());
		
		//Deleting all the tables at Start
		for(String tableName: tableNames){
			Query query = transaction.getSession().createQuery("delete "+tableName);
			query.executeUpdate();
		}
		transaction.getTransaction().commit();
	}
	
	//Basic creation of agent and testing it works fine.
	@Test
	public void testAgentEntity(){
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		
		session.save(agent);
		session.getTransaction().commit();
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==1);
	}
	
	//This will have single agentObject and will be able to fetch the 
	//Agent Data from the table as well. in a single Object
	@Test
	public void testAgentEntityWithData(){
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		
		//UserTransaction aTrans = new UserTransaction(session.beginTransaction(), session);
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		
		session.save(agent);
		session.getTransaction().commit();
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==1);
	}
	
	//In this class we are using AgentFactory for creating the Agent.
	@Test
	public void testAgenFactoryCrateAgent(){
		Session session = HibernateUtil.getInstance().getNewSession();
		
		UserTransaction aTrans = new UserTransaction(session);
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		
		AgentFactory.getInstance().addAgent(aTrans, agent);
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==1);
	}

	
}
