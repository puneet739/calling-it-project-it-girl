package com.fairdeal.core.test.regressiontests;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.entity.Agent;

public class AgentFactoryTest {

	//Basic creation of agent and testing it works fine.
	@Test
	public void testAgentEntity(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		
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
	
}
