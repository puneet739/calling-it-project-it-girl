package com.fairdeal.compass.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This is an Object repository for the application. Any class which need any object, should ask this repo for that
 * particular object.
 * 
 * @author puneetbehl
 */
public class ObjectRepository implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ObjectRepository.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
}