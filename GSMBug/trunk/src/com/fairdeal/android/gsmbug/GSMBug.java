package com.fairdeal.android.gsmbug;

import com.fairdeal.android.gsmbug.R;

import android.app.Activity;
import android.content.Intent;
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
		Button startButton = (Button)findViewById(R.id.androidStartButton);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent serviceIntent = new Intent();
				serviceIntent.setAction("com.fairdeal.android.gsmbug.RecorderService");
				startService(serviceIntent);
				System.out.println("RecorderService started");
			}
		});
		
		Button stopButton = (Button)findViewById(R.id.androidStopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent serviceIntent = new Intent();
				serviceIntent.setAction("com.fairdeal.android.gsmbug.RecorderService");
				stopService(serviceIntent);
				System.out.println("RecorderService Stoped");
			}
		});
	}

}
