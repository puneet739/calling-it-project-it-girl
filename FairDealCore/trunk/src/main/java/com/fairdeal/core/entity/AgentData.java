package com.fairdeal.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agent_data")
public class AgentData implements Serializable {

	private static final long serialVersionUID = -9220050940022338933L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="agent_data_id")
	private int aid;

	@Column(name = "key")
	private String key;

	@Column(name = "value")
	private String value;

	@ManyToOne
	@JoinColumn(name="id")
	private Agent agent;
	

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
