package com.fairdeal.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fairdeal.basic.log4j.Loger;
import com.fairdeal.core.factory.AgentFactory;

/**
 * Base entity Object for creating new Agent. 
 * 
 * @author puneetb
 *
 */
@Entity
@Table(name="agent")
public class Agent implements Serializable{

	private static final long serialVersionUID = -6294378258877811646L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email", unique=true)
	private String email;
	
	@Column(name="CreatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = new Date();
	}
	
	@Version
	private int version;
	
	@Column(name="PhoneNumber", unique=true)
	private String phoneNumber;

	@OneToMany(mappedBy="agent", cascade={javax.persistence.CascadeType.ALL})
	@MapKey(name="key")
	private Map<String, AgentData> agentDatas = new HashMap<>();
	
	//private Map<String, String> agentParams = new HashMap<>();

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

//	/**
//	 * @return the agentParams
//	 */
//	public Map getAgentParams() {
//		return agentParams;
//	}
//
//	/**
//	 * @param agentParams the agentParams to set
//	 */
//	public void setAgentParams(Map agentParams) {
//		this.agentParams = agentParams;
//	}
	
	public String getAgentParam(String key) {
		String value = null;
		try{
			value = agentDatas.get(key).getValue();
			if (value==null){
				value = AgentFactory.getInstance().getAgentData(getId(), key);
				//agentDatas.get(key).getValue();
			}
		}catch(NullPointerException ne){
			Loger.app.error("NullPointer Exception caused",ne);
		}
		return value;
	}
	
	public void addAgentParam(String key, String value){
		Loger.app.debug("test message");
		AgentData data = new AgentData();
		data.setKey(key);
		data.setAgent(this);
		data.setValue(value);
		agentDatas.put(key, data);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", email=" + email
				+ ", createdDate=" + createdDate + ", phoneNumber="
				+ phoneNumber + "]";
	}

	/**
	 * @return the agentDatas
	 */
	public Map<String, AgentData> getAgentDatas() {
		return agentDatas;
	}

	/**
	 * @param agentDatas the agentDatas to set
	 */
	public void setAgentDatas(Map<String, AgentData> agentDatas) {
		this.agentDatas = agentDatas;
	}
	
}
