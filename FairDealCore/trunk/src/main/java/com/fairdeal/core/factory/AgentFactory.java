package com.fairdeal.core.factory;

import java.util.Map;

import com.fairdeal.core.entity.Agent;

/**
 * This will be the default factory which will be dealing with all the CURD operation for 
 * @author puneetb
 *
 */
public class AgentFactory {

	
	
	public boolean addAgent(Agent agent){	
		return false;
	}
	
	public Agent getAgentbyId(int id){	
		return null;
	}
	
	public boolean removeAgent(int id){	
		return false;
	}
	
	public Map<String, String> getAgentData(int id){
		return null;
	}
	
	public boolean updateAgent(int agentId, Agent targetAgent){	
		return false;
	}
	
}
