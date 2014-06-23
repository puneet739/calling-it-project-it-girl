package com.fairdeal.android.gsmbug;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GSMBug extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gsmbuylayout);
		initializeValue();
		//loadRecorder();
	}
	
	   private MediaRecorder myAudioRecorder;


	private void loadRecorder() {
		myAudioRecorder = new MediaRecorder();
		myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		myAudioRecorder.setOutputFile("testFile.3gp");
		myAudioRecorder.start();
	}

	private void initializeValue() {
		Button button = (Button)findViewById(R.id.androidStartButton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("Some service started");
			}
		});
	}

}
