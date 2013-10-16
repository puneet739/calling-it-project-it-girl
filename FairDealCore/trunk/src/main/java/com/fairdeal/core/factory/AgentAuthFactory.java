/**
 * 
 */
package com.fairdeal.core.factory;


import java.util.List;

import org.hibernate.Query;

import com.fairdeal.basic.Constants;
import com.fairdeal.core.entity.Agent;
import com.fairdeal.core.entity.AgentAuth;
import com.fairdeal.core.trans.UserTransaction;
import com.fairdeal.encryption.EncryptionFactory;

/**
 * @author puneetb
 *
 */
public class AgentAuthFactory {

	private static AgentAuthFactory mInstance = new AgentAuthFactory();
	
	private final String tableName =AgentAuth.class.getName();
	
	public static AgentAuthFactory getInstance(){
		return mInstance;
	}
	
	public int saveAgentAuth(UserTransaction aTrans, AgentAuth auth){
		int id=0;
		try{
			aTrans.getSession().save(auth);
		}catch(Exception e){
			aTrans.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
		return auth.getId();
	}
	
	public AgentAuth getAgentAuthPassword(String pin, int pinType, String baseEncoding, String targetEncoding , Agent agent){
		return getAgentAuthPassword(pin, pinType, baseEncoding, targetEncoding, agent.getId());
	}
	
	public AgentAuth getAgentAuthPassword(String pin, int pinType, String baseEncoding, String targetEncoding , int agentId){
		AgentAuth auth = new AgentAuth();
		String encryptedPin = EncryptionFactory.getinstance().getEncrypt(agentId+pin, targetEncoding);
		auth.setAgentId(agentId);
		auth.setEncrypted_pin(encryptedPin);
		auth.setPin_type(pinType);
		return auth;
	}
	
	public AgentAuth getAgentAuthByAgentId(UserTransaction aTrans, int pinType, int agentId){
		AgentAuth finalAuth = null;
		try{
			Query query = aTrans.getSession().createQuery("from "+tableName+" where pin_type=:type and agent_id=:agentId");
			query.setString("type", ""+pinType);
			query.setString("agentId", ""+agentId);
			List<AgentAuth> auths = query.list();
			for (AgentAuth auth: auths){
				finalAuth=auth;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return finalAuth;
	}
	
	
	public boolean validate(UserTransaction aTrans, String pin, String baseEncoding, String targetEncoding, int type, int agentId){
		String encryptedPin = EncryptionFactory.getinstance().getEncrypt(agentId+pin, targetEncoding);
		Query query = aTrans.getSession().createQuery("from "+tableName+" where pin_type=:type and agent_id=:agentId and encrypted_pin=:pin");
		query.setString("type", ""+type);
		query.setString("agentId", ""+agentId);
		query.setString("pin", encryptedPin);	
		
		List result = query.list();
			if (result.size()==1) return true;
		
		return false;
	}
}
