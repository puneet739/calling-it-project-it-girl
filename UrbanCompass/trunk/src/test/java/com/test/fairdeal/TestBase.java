package com.test.fairdeal;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TestBase {
	
		@Autowired
	    private ApplicationContext context;
		
		@Autowired
	    private MongoTemplate mongoTemplate;

	    @Before
	    public void setUp() {
	        context = new ClassPathXmlApplicationContext("test-application-bean.xml");
	        mongoTemplate = context.getBean(MongoTemplate.class);
	    }

	    public ApplicationContext getContext() {
	        return context;
	    }
	    
	    public MongoTemplate getMongoTemplate() {
	        return mongoTemplate;
	    }
	    

}
