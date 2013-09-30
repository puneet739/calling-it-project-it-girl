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

/**
 * @author puneetb
 */
public class AgentFactoryTest extends FDTestCase {

	//Basic creation of agent and testing it works fine.
	@Test
	public void testAgentEntity(){
		//Session session = getTestSession();
		
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
		//Session session = getTestSession();
		
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
		//Session session = HibernateUtil.getInstance().getNewSession();
		
		UserTransaction aTrans = new UserTransaction(session);
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		
		AgentFactory.getInstance().addAgent(aTrans, agent);
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==1);
	}

	@Test
	public void testAgenFactorygetAgentById(){
		UserTransaction aTrans = new UserTransaction(session);
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");

		Agent agent2 = new Agent();
		agent2.setName("Rahul");
		agent2.setPhoneNumber("09971949201");
		
		Agent agent3 = new Agent();
		agent3.setName("Puneet2");
		agent3.setPhoneNumber("09971949202");
		
		int id1 = AgentFactory.getInstance().addAgent(aTrans, agent);
		int id2 = AgentFactory.getInstance().addAgent(aTrans, agent2);
		int id3 = AgentFactory.getInstance().addAgent(aTrans, agent3);
		
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==3);
		
		Agent targetAgent = AgentFactory.getInstance().getAgentbyId(aTrans, id1);
		aTrans.getTransaction().commit();
		//aTrans.getTransaction().rollback();
		assertTrue(targetAgent.equals(agent));
	}

	
}
