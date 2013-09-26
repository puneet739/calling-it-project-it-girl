package com.fairdeal.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fairdeal.basic.log4j.Loger;
import com.fairdeal.core.factory.AgentFactory;

/**
 * Base entity Object for creating new Agent. 
 * 
 * @author puneetb
 *
 */
@Entity
@Table(name="AGENT")
public class Agent implements Serializable{

	private static final long serialVersionUID = -6294378258877811646L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="CreatedDate")
	private Date createdDate;
	
	@Column(name="PhoneNumber", unique=true)
	private String phoneNumber;
	
	@ElementCollection
	private Map<String,String> agentParams = new HashMap<String,String>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the agentParams
	 */
	public Map getAgentParams() {
		return agentParams;
	}

	/**
	 * @param agentParams the agentParams to set
	 */
	public void setAgentParams(Map agentParams) {
		this.agentParams = agentParams;
	}
	
	public String getAgentParam(String key) {
		String value;
		try{
			value = agentParams.get(key);
			if (value==null){
				value = AgentFactory.getInstance().getAgentData(getId(), key);
				agentParams.put(key, value);
			}
		}catch(NullPointerException ne){
			Loger.app.error("NullPointer Exception caused",ne);
		}
		return null;
	}
	
}
