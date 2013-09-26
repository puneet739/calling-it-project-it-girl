package com.fairdeal.core;

import org.hibernate.Session;

import com.fairdeal.core.db.util.HibernateUtil;
import com.fairdeal.core.entity.Agent;

public class Start{
	public static void main(String args[]){
		System.out.println("Test Project");
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setName("Puneet");
		agent.setPhoneNumber("09971949200");
		
		session.save(agent);
		session.getTransaction().commit();
	}
}