package com.fairdeal.core.factory;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.fairdeal.basic.log4j.Loger;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.trans.UserTransaction;

/**
 * This will be the default factory which will be dealing with all the CURD operation for 
 * @author puneetb
 *
 */
public class AgentFactory {

	private static AgentFactory mInstance = new AgentFactory(); 
	
	private final String tableName =Agent.class.getName(); 
	/**
	 * Providing the Single Instance of AgentFactory. 
	 */
	public static AgentFactory getInstance(){
		return mInstance;
	}
	
	/**
	 *  This program will be used add the Agent into the Database. 
	 *  @return 		This will return the AgentId of newly Created Agent
	 */
	public int addAgent(UserTransaction aTrans, Agent agent){	
		try{
			aTrans.getSession().save(agent);
		}catch(Exception e){
			aTrans.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
		return agent.getId();
	}
	
	/**
	 * 
	 * @param aTrans		The Transaction which will be of this session. 
	 * @param id			The Id of the agent which need to be fetheced.
	 * @return				The Agent returned from the db of this ID. 
	 */
	public Agent getAgentbyId(UserTransaction aTrans, int id){	
		Agent agent= null;
		try{
			agent = (Agent)aTrans.getSession().get(Agent.class, id);
		}catch(NullPointerException ne){
			Loger.app.error("NullPointer Exception casued here", ne);
		}
		return agent;
	}
	
	/**
	 * This program is used to fetch the agent object from the database via EMail id. 
	 * @param aTrans	The UserTransaction which will be having session and transaction
	 * @param email		The Email, which we need to fetch
	 * @return			The agent Object from the databse, Null if no agent is found
	 */
	public Agent getAgentbyEmail(UserTransaction aTrans, String email){	
		Agent agent= null;
		try{
			Query query = aTrans.getSession().createQuery("from "+tableName+" where Email=:email" );
			query.setString("email", email);
			List<Agent> agents = query.list();
			for(Agent temp_agent: agents){
				agent=temp_agent;
			}
		}catch(NullPointerException ne){
			Loger.app.error("NullPointer Exception casued here", ne);
		}
		return agent;
	}
	
	public boolean removeAgent(UserTransaction aTrans, int agentId){	
		Agent agent = (Agent) aTrans.getSession().get(Agent.class, agentId);
		return removeAgent(aTrans,agent);
	}
	
	public boolean removeAgent(UserTransaction aTrans, Agent agent){
		if (agent!=null){
			aTrans.getSession().delete(agent);
			return true;
		}
		return false;
	}
			
	public String getAgentData(int id, String key){
		//Here we need to create a transaction and close it before finishing this class. 
		return null;
	}
	
	public String getAgentData(UserTransaction aTrans, int id, String key){
		return null;
	}
	
	public Map<String, String> getAgentDatamap(UserTransaction aTrans, int agentId){
		return null;
	}
	
	public boolean updateAgent(UserTransaction aTrans, int agentId, Agent targetAgent){	
		return false;
	}
	
}
