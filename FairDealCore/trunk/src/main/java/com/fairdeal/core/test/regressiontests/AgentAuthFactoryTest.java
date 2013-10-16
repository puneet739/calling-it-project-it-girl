/**
 * 
 */
package com.fairdeal.core.test.regressiontests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fairdeal.basic.Constants;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.entity.AgentAuth;
import com.fairdeal.core.factory.AgentAuthFactory;
import com.fairdeal.core.factory.AgentFactory;
import com.fairdeal.core.trans.UserTransaction;

/**
 * @author puneetb
 *
 */
public class AgentAuthFactoryTest extends FDTestCase{

	
			
	@Test
	public void testRegisterAgent(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);
		Agent agent2 = AgentFactory.getInstance().getAgentbyId(aTrans, agent1.getId());
		assertEquals(agent1, agent2);
	}
	
	@Test
	public void testRegisterAgentaddPasswordtype1(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);
		
		AgentAuth auth = AgentAuthFactory.getInstance().getAgentAuthPassword("123456", 1, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth);
		
		aTrans.getTransaction().commit();
		
		AgentAuth auth1 = AgentAuthFactory.getInstance().getAgentAuthByAgentId(aTrans,1, agent1.getId());
		
		assertNotNull(auth1);
	}
	
	
	@Test
	public void testRegisterAgentaddPasswordtype2(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);
		
		//AgentAuth auth = AgentAuthFactory.getInstance().getAgentAuthPassword("123456", 1, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		AgentAuth auth2 = AgentAuthFactory.getInstance().getAgentAuthPassword("2345622211", 2, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		
		//AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth);
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth2);
		
		aTrans.getTransaction().commit();
		AgentAuth auth1 = AgentAuthFactory.getInstance().getAgentAuthByAgentId(aTrans,2, agent1.getId());
		assertNotNull(auth1);
	}
	
	@Test
	public void testRegisterAgentaddPasswordtype12(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);
		
		AgentAuth auth1 = AgentAuthFactory.getInstance().getAgentAuthPassword("123456", 1, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1.getId());
		AgentAuth auth2 = AgentAuthFactory.getInstance().getAgentAuthPassword("2345622211", 2, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth1);
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth2);
		
		aTrans.getTransaction().commit();
		
		AgentAuth tempAuth = AgentAuthFactory.getInstance().getAgentAuthByAgentId(aTrans,2, agent1.getId());
		assertNotNull(tempAuth);
		
		tempAuth = AgentAuthFactory.getInstance().getAgentAuthByAgentId(aTrans,1, agent1.getId());
		assertNotNull(tempAuth);
	}

	
	@Test
	public void testRegistervalidate1(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);
		
		AgentAuth auth = AgentAuthFactory.getInstance().getAgentAuthPassword("123456", 1, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth);
		
		aTrans.getTransaction().commit();
		
		Boolean matched = AgentAuthFactory.getInstance().validate(aTrans, "123456", Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, 1, agent1.getId());

		assertTrue(matched);
	}
	
	
	@Test
	public void testRegistervalidate2(){
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent1 = getUtil().addAgent(1);

		AgentAuth auth = AgentAuthFactory.getInstance().getAgentAuthPassword("123456", 1, Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, agent1);
		
		AgentAuthFactory.getInstance().saveAgentAuth(aTrans, auth);
		
		aTrans.getTransaction().commit();
	
		Boolean matched = AgentAuthFactory.getInstance().validate(aTrans, "123456", Constants.EncryptionAlgo.plain, Constants.EncryptionAlgo.SHAEncryption, 2, agent1.getId());
		assertFalse(matched);
	}
}
