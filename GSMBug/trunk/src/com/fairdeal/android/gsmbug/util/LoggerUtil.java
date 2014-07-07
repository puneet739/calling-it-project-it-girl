package com.fairdeal.android.gsmbug.util;

public class LoggerUtil {

	/**
	 * Level of Logging: DEBUG = 3; INFO = 4; WARN = 5; ERROR = 6;
	 * 
	 * @see android.util.Log
	 */
	private static String className;
	private static final String log_tag = "com.fairdeal.android.gsmbug.util";

	private static final void set_classname() {
		className = Thread.currentThread().getStackTrace()[4].getClassName();
		int i = className.lastIndexOf('.');
		if (i == -1)
			return;
		className = className.substring(i + 1);
	}

	public static final void info(String msg) {
		set_classname();
		android.util.Log.i(log_tag, className + ": " + msg);
	}

	public static void error(String msg) {
		set_classname();
		android.util.Log.e(log_tag, className + ": " + msg);
	}

	public static void debug(String msg) {
		set_classname();
		android.util.Log.d(log_tag, "********** " + className + ": " + msg);
	}

	public static void warn(String msg) {
		set_classname();
		android.util.Log.w(log_tag, "********** " + className + ": " + msg);
	}

}
