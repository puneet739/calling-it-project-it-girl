package com.fairdeal.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AGNET_AUTH")
public class AgentAuth {

	private final String  SEQUENCE_NUMBER_GENERATOR="AGENT_AUTH_SEQUENCE"; 
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SEQUENCE_NUMBER_GENERATOR)
	@SequenceGenerator(name=SEQUENCE_NUMBER_GENERATOR, sequenceName=SEQUENCE_NUMBER_GENERATOR, allocationSize=1)
	private int id;
	
	@Column(name="agent_id")
	private int agentId; 
	
	@Column(name="pin_type")
	private int pin_type;
	
	@Column(name="encrypted_pin")
	private String encrypted_pin;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the pin_type
	 */
	public int getPin_type() {
		return pin_type;
	}

	/**
	 * @param pin_type the pin_type to set
	 */
	public void setPin_type(int pin_type) {
		this.pin_type = pin_type;
	}

	/**
	 * @return the encrypted_pin
	 */
	public String getEncrypted_pin() {
		return encrypted_pin;
	}

	/**
	 * @param encrypted_pin the encrypted_pin to set
	 */
	public void setEncrypted_pin(String encrypted_pin) {
		this.encrypted_pin = encrypted_pin;
	}
	
	
	
}
