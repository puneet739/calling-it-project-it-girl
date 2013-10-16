package com.fairdeal.core.test.regressiontests;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.junit.Test;

import static org.junit.Assert.*;

import com.fairdeal.basic.log4j.Loger;
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
		AgentFactory.getInstance().addAgent(aTrans, agent2);
		AgentFactory.getInstance().addAgent(aTrans, agent3);
		
		Query query = session.createQuery("from "+Agent.class.getName());
		List list = query.list();
		
		assertTrue(list.size()==3);
		
		Agent targetAgent = AgentFactory.getInstance().getAgentbyId(aTrans, id1);
		aTrans.getTransaction().commit();
		assertTrue(targetAgent.equals(agent));
	}

	@Test
	public void testAgenFactorygetAgentByEmail(){
		UserTransaction aTrans = new UserTransaction(session);
		addAgents();
		Agent agent = AgentFactory.getInstance().getAgentbyEmail(aTrans, "puneet0@fairdeal.com");
		assertEquals("puneet0@fairdeal.com", agent.getEmail());
		assertEquals("Puneet_0", agent.getName());
		assertEquals("09971949200", agent.getPhoneNumber());
	}
	
	@Test
	public void testdeleteAgent(){
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
		Agent agent_new = (Agent) aTrans.getSession().get(Agent.class, id1);
		assertNotNull(agent_new);
		
		AgentFactory.getInstance().removeAgent(aTrans, id1);
		
		agent_new = (Agent) aTrans.getSession().get(Agent.class, id1);
		assertNull(agent_new);
		
		agent_new=(Agent) aTrans.getSession().get(Agent.class, id2);
		assertNotNull(agent_new);
		aTrans.getTransaction().commit();
	}
	
	@Test
	public void testaddAgentData(){
		Loger.app.debug("test message");
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		agent.setCreatedDate(new Date());
		agent.setEmail("puneet739@gmail.com");
		
		for (int i=0; i<4; i++){
			agent.addAgentParam("testKey"+i, "testValue"+i);
		}
		
		int agentId = AgentFactory.getInstance().addAgent(aTrans, agent);
		
		aTrans.getTransaction().commit();
		
		Agent agent1 = AgentFactory.getInstance().getAgentbyId(aTrans, agentId);
		
		for (int i=0; i<4; i++){
			assertEquals("testValue"+i, agent1.getAgentParam("testKey"+i));
		}
	}
	
	@Test
	public void testgetAgentData() {
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		agent.setCreatedDate(new Date());
		agent.setEmail("puneet739@gmail.com");

		int agentId = AgentFactory.getInstance().addAgent(aTrans, agent);

		for (int i = 0; i < 4; i++) {
			agent.addAgentParam("testKey" + i, "testValue" + i);
		}
		aTrans.getTransaction().commit();

		String value = null;

		value = AgentFactory.getInstance().getAgentData(agentId, "testKey0");
		assertEquals("testValue0", value);

		value = AgentFactory.getInstance().getAgentData(agentId, "tesssss");
		assertNull(value);
	}
	
	@Test(expected=StaleStateException.class)
	public void testSaveUpdatedAgent(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		agent.setCreatedDate(new Date());
		agent.setEmail("puneet739@gmail.com");
		
		int agentId = AgentFactory.getInstance().addAgent(aTrans, agent);
		
		aTrans.getTransaction().commit();
		
		UserTransaction aTrans1= HibernateUtil.getInstance().getUserTransaction(HibernateUtil.getInstance().getNewSession());
		Agent agent_1 = AgentFactory.getInstance().getAgentbyId(aTrans1, agentId);
		UserTransaction aTrans2= HibernateUtil.getInstance().getUserTransaction(HibernateUtil.getInstance().getNewSession());
		Agent agent_2 = AgentFactory.getInstance().getAgentbyId(aTrans2, agentId);
		
		agent_1.setEmail("puneet1@gmail.com");
		AgentFactory.getInstance().addAgent(aTrans1, agent_1);
		aTrans1.getTransaction().commit();
		
		agent_2.setPhoneNumber("9971949202");
		AgentFactory.getInstance().addAgent(aTrans2, agent_2);
		aTrans2.getTransaction().commit();
		
		Agent finalAgent = AgentFactory.getInstance().getAgentbyId(aTrans2, agentId);
		assertEquals("puneet1@gmail.com", finalAgent.getEmail());
		assertEquals("9971949202", finalAgent.getPhoneNumber());
		
	}
	
	
	
	
	public void addAgents(){
		Session session = HibernateUtil.getInstance().getNewSession();
		UserTransaction aTrans = new UserTransaction(session);
		
		for (int i=0; i<10; i++){
			Agent agent = new Agent();
			agent.setName("Puneet_"+i);
			agent.setCreatedDate(new Date());
			agent.setEmail("puneet"+i+"@fairdeal.com");
			agent.setPhoneNumber("0997194920"+i);
			AgentFactory.getInstance().addAgent(aTrans, agent);
		}
		aTrans.getTransaction().commit();
		aTrans.getSession().close();
	}
	
	
	
}

	