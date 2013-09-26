package com.fairdeal.core.factory;

import java.util.Map;

import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.trans.UserTransaction;

/**
 * This will be the default factory which will be dealing with all the CURD operation for 
 * @author puneetb
 *
 */
public class AgentFactory {

	private static AgentFactory mInstance = new AgentFactory(); 
	
	/**
	 * Providing the Single Instance of AgentFactory. 
	 */
	public static AgentFactory getInstance(){
		return mInstance;
	}
	
	/**
	 *  This program will be used add the Agent into the Database. 
	 */
	public boolean addAgent(UserTransaction aTrans, Agent agent){	
		try{
			aTrans.getSession().save(agent);
			aTrans.getTransaction().commit();
		}catch(Exception e){
			aTrans.getTransaction().rollback();
			return false;
		}
		return true;
	}
	
	public Agent getAgentbyId(UserTransaction aTrans, int id){	
		return null;
	}
	
	public boolean removeAgent(UserTransaction aTrans, int id){	
		return false;
	}
	
	public String getAgentData(int id, String key){
		//Here we need to create a transaction and close it before finishing this class. 
		return null;
	}
	
	public String getAgentData(UserTransaction aTrans, int id, String key){
		return null;
	}
	
	public Map<String, String> getAgentDatamap(UserTransaction aTrans, int id){
		return null;
	}
	
	public boolean updateAgent(UserTransaction aTrans, int agentId, Agent targetAgent){	
		return false;
	}
	
}
