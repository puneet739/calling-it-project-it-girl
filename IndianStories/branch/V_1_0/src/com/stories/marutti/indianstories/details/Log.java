package com.stories.marutti.indianstories.details;

/**
 * This is a helperclass for Logging. 
 * @author puneetb
 */
public class Log {

	/**
	 * Level of Logging:
	 * DEBUG = 3;
	 * INFO = 4;
	 * ERROR = 6;
	 */
	private static String className;
	private static final String log_tag = "com.stories.marutti.indianstories.details";
		
	private static final void set_classname() {
		className = Thread.currentThread().getStackTrace()[4].getClassName();
		int i = className.lastIndexOf('.');
		if(i == -1) return;
		className = className.substring(i+1);
	}
	public static final void info(String msg) {
		set_classname();
		android.util.Log.i(log_tag, className + ": " + msg);
	}
	public static void err(String msg) {
		set_classname();
	    android.util.Log.e(log_tag, className + ": " + msg);
	}
	public static void dbg(String msg) {
		set_classname();
	    android.util.Log.d(log_tag, "********** "+className + ": " + msg);
	}
}
