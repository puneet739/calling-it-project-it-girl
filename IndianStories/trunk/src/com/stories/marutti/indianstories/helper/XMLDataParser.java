/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories.helper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.view.View;

/**
 * @author puneetb
 * 
 */
public class XMLDataParser {

	public XMLDataParser() {

	}

	public void getloadCategory() {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
	        XmlPullParser xpp = factory.newPullParser();

			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		XMLDataParser parser = new XMLDataParser();
		System.out.println("Test Completed. ");
		parser.getloadCategory();
		parser.getXMLFile();
	}

	private void getXMLFile() {
		// TODO Auto-generated method stub
		
	}
}
