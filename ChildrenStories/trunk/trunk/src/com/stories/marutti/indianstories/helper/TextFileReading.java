package com.stories.marutti.indianstories.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.stories.marutti.indianstories.details.Log;

public class TextFileReading {

	public static String parseStream(InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		try{
		Log.dbg("IS:::"+is);
		Log.dbg(is.toString());
		//InputStreamReader isr = new InputStreamReader(is);
		//BufferedReader bfr = new BufferedReader(isr);
		Log.dbg("*********"+bfr.toString());
				
		String currentLine = bfr.readLine();
		while(currentLine!=null){
			sb.append(currentLine);
			sb.append("\n");
			currentLine = bfr.readLine();
		}
		
		Log.dbg("*********"+sb);
		}finally{
			isr.close();
			bfr.close();
		}
		return sb.toString();
	}

}
