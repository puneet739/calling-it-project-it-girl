/**
 * 
 */
package com.fairdeal.core.test.regressiontests;

import java.util.Date;

import org.hibernate.Session;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.factory.AgentFactory;
import com.fairdeal.core.trans.UserTransaction;

/**
 * @author puneetb
 *
 */
public class FDTestUtil {

	
	public Agent addAgent(int msisdn){
		Session session = HibernateUtil.getInstance().getNewSession();
		UserTransaction aTrans = new UserTransaction(session);
		Agent agent = new Agent();
		agent.setName("Puneet_" + msisdn);
		agent.setCreatedDate(new Date());
		agent.setEmail("puneet" + msisdn + "@fairdeal.com");
		agent.setPhoneNumber("0997194920" + msisdn);
		AgentFactory.getInstance().addAgent(aTrans, agent);
		aTrans.getTransaction().commit();
		aTrans.getSession().close();
		return agent;
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
