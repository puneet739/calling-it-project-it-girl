package com.stories.marutti.indianstories.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;


public class XMLfileReading {
	
	String namespace1 =null;
	String startag = "stories";

	
	public void parseXML(InputStream is) {
		try {
			//InputStream is;
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(is, null);
			parser.nextTag();
			readfeed(parser);

			System.out.println("Parsing via ParseXML function");

			System.out.println("Parsing via ParseXML function");

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Exception caused");
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private List readfeed(XmlPullParser parser) throws XmlPullParserException,
			IOException {
		List entries = new ArrayList();

		parser.require(XmlPullParser.START_TAG, namespace1, startag);
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			// Starts by looking for the entry tag
			if (name.equals("Story")) {
				entries.add(readEntry(parser));
			} else {
				// skip(parser);
			}
		}
		return null;

	}

	public static class Entry {
		public final String title;
		public final String link;
		public final String summary;

		private Entry(String title, String summary, String link) {
			this.title = title;
			this.summary = summary;
			this.link = link;
		}
	}

	// Parses the contents of an entry. If it encounters a title, summary, or
	// link tag, hands them off
	// to their respective "read" methods for processing. Otherwise, skips the
	// tag.
	private Entry readEntry(XmlPullParser parser)
			throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, namespace1, "id");
		String title = null;
		String summary = null;
		String link = null;
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if (name.equals("title")) {
				title = readTitle(parser);
			} else if (name.equals("summary")) {
				summary = readSummary(parser);
			} else if (name.equals("link")) {
				link = readLink(parser);
			} else {
				// skip(parser);
			}
		}
		return new Entry(title, summary, link);
	}

	// Processes title tags in the feed.
	private String readTitle(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, namespace1, "title");
		String title = readText(parser);
		parser.require(XmlPullParser.END_TAG, namespace1, "title");
		return title;
	}

	// Processes link tags in the feed.
	private String readLink(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		String link = "";
		parser.require(XmlPullParser.START_TAG, namespace1, "link");
		String tag = parser.getName();
		String relType = parser.getAttributeValue(null, "rel");
		if (tag.equals("link")) {
			if (relType.equals("alternate")) {
				link = parser.getAttributeValue(null, "href");
				parser.nextTag();
			}
		}
		parser.require(XmlPullParser.END_TAG, namespace1, "link");
		return link;
	}

	// Processes summary tags in the feed.
	private String readSummary(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, namespace1, "summary");
		String summary = readText(parser);
		parser.require(XmlPullParser.END_TAG, namespace1, "summary");
		return summary;
	}

	// For the tags title and summary, extracts their text values.
	private String readText(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		String result = "";
		if (parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}

}
