package com.fairdeal.basic.log4j;

import java.util.Enumeration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This will be the default class stateing how the logs will be generated. 
 * 
 * @author puneetb
 *
 */
public class Loger {

	
    /**
     * Initialise log4j.  This needs to be done before the static logger fields
     * below are configured.
     */
    static
	{
    	// Only invoke the global configure method if nobody else has.
    	// For example, if the GAJ is used in JBoss, log4j may have already
    	// been set up.
		if (count(LogManager.getCurrentLoggers()) == 0)
		{
			BasicConfigurator.configure();
		}
		else {
		}
	}   	
    
    /** logger for application events */
    public static Logger app        = LogManager.getLogger("ga.app");
    /** logger intended for low-level agent activities only, app developers should not use this*/
    public static Logger agent      = LogManager.getLogger("ga.agent");
    /** logger intended for low-level message encoding activities only, app developers should not use this*/
    public static Logger encoder    = LogManager.getLogger("ga.encoder");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger service    = LogManager.getLogger("ga.service");
    /** logger for JDBC events */
    public static Logger jdbc       = LogManager.getLogger("ga.jdbc");
    /** logger for auditing of incoming and outgoing messages events */
    public static Logger audit      = LogManager.getLogger("ga.audit");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger pool       = LogManager.getLogger("ga.pool");
    /** logger for configuration events */
    public static Logger config     = LogManager.getLogger("ga.config");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger monitor    = LogManager.getLogger("ga.monitor");
    
    public static Logger monitor_stats    = LogManager.getLogger("ga.monitor.stats");
    
    
    /** logger for system message (shutdown, reload, etc) events */
    public static Logger sysmessage = LogManager.getLogger("ga.sysmessage");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger timer      = LogManager.getLogger("ga.timer");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger misc       = LogManager.getLogger("ga.misc");
    /** logger for guaranteed messaging events */
    public static Logger gm         = LogManager.getLogger("ga.gm");
    /** it's anyone's guess what this logger is intended for*/
    public static Logger crypto     = LogManager.getLogger("ga.crypto");
    /** logger for monetary and billing events */
    public static Logger billing	= LogManager.getLogger("ga.billing");
    /** logger for plugin events */
    public static Logger plugin     = LogManager.getLogger("ga.plugin");
    /** logger for licence events */
    public static Logger licence    = LogManager.getLogger("ga.licence");
    /** logger for resource events */
    public static Logger resource   = LogManager.getLogger("ga.resource");
    /** logger for SNMP events */
    public static Logger snmp       = LogManager.getLogger("ga.snmp");
    
    /**
     * Another static initialiser to configure particular loggers.
     * This portion of the static init obviously must be done after
     * setup of the relevant loggers.
     */
    static {
		audit.setAdditivity(false);
		monitor_stats.setAdditivity(false);
		monitor_stats.setLevel(org.apache.log4j.Level.OFF);
        // should really only be on for dev/testing
		encoder.setLevel(org.apache.log4j.Level.OFF);

        // optionally stop config logging from command line
        if ("off".equals(System.getProperty("logger.ga.config"))) {
    		config.setLevel(org.apache.log4j.Level.OFF);
        }
    }
    
//    public static void setTrans(int trans)
//    {
//        setTransID(new TransID(trans));
//    }
//    
//    public static void setTrans(long trans)
//    {
//        setTransID(new TransID(trans));
//    }
//    
//    public static void setTrans(TransID trans)
//    {
//        setTransID(trans);
//    }
//    
//    public static void setTransID(TransID trans)
//    {
//        MDC.put("trans", String.valueOf(trans.intValue()));
//    }
//    
//    public static void clearTrans()
//    {
//        clearTransID();
//    }
//    
//    public static void clearTransID()
//    {
//        MDC.remove("trans");
//    }
//    
//    public static void setType(String type)
//    {
//        if (type==null)
//            MDC.remove("type");
//        else
//            MDC.put("type",type);
//    }
//    
//    public static void clearType()
//    {
//        MDC.remove("type");
//    }
//    
    /**
     * Helper method to count the number of elements behind an enumeration.
     */
    public static int count(Enumeration e)
	{
		int count = 0;
		while (e.hasMoreElements())
		{
			count++;
			e.nextElement();
		}
		return count;
	}
//    
//    private static ConfigReloadListener sReloader;
//    
//    public static synchronized void configure()
//    {
//        if (sReloader==null) {
//            sReloader=new ConfigReloadListener() {
//                public void configReloaded() {
//                    PropertyConfigurator.configure(Config.getInstance().getGroup().getProperties());
//                }
//            };            
//            
//            Config.getInstance().addConfigReloadListener(sReloader);
//        }             
//        sReloader.configReloaded();
//    }
//    
//    /** 
//     * Creates a new instance of GA 
//     */
//    protected GA() 
//    {        
//    }
    
}
