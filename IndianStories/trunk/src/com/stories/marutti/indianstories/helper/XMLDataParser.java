/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Categories;

/**
 * @author puneetb
 * 
 */
public class XMLDataParser {

	List<Categories> categoriesList;

	/**
	 * This program is used to parse the XML to generate the categories in the
	 * XML.
	 * 
	 * @param stream
	 *            Pass the Stream of XML you received.
	 * @return
	 * @throws XmlPullParserException 
	 */
	public List<Categories> parseForCategories(InputStream stream) throws XmlPullParserException {
		categoriesList = new ArrayList<Categories>();

		try {
			XMLfunctions.XMLDocumentfromInputStream(stream);

		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}

		return null;
	}

	private void parseXML(InputStream stream) throws XmlPullParserException,
			IOException {
		XmlPullParser parser = Xml.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(stream, null);
		parser.nextTag();
		readfeed(parser);
	}

	private List readfeed(XmlPullParser parser) throws XmlPullParserException,
			IOException {
		List<Categories> category = new ArrayList<Categories>();

		parser.require(XmlPullParser.START_TAG, null,Constants.XMLConstants.CATEGORIES);
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			// Starts by looking for the entry tag
			if (name.equals(Constants.XMLConstants.CATEGORY)) {
				category.add(readEntry(parser));
			} else {
				// skip(parser);
				Log.dbg("Skipping the Reading of XML");
			}
		}
		return null;
	}

	private Categories readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null,Constants.XMLConstants.CATEGORY);
		while (parser.next() != XmlPullParser.END_TAG) {
			Categories tempCategory;
			Log.dbg("Current Tag: "+parser.getName());
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			
			String name = parser.getName();
			// Starts by looking for the entry tag
			if (name.equals(Constants.XMLConstants.NAME)) {
					tempCategory = new Categories(name);
			} else {
				// skip(parser);
			}
		}

		return null;
	}
}
