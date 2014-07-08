package com.fairdeal.android.gsmbug;

import com.fairdeal.android.gsmbug.R;
import com.fairdeal.android.gsmbug.util.LoggerUtil;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GSMBug extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gsmbuylayout);
		initializeValue();
	}

	private void initializeValue() {
		Button startButton = (Button) findViewById(R.id.androidStartButton);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent callingIntent = new Intent();
				callingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				callingIntent.setFlags(Intent.FLAG_FROM_BACKGROUND);
				startService(callingIntent);
				Intent serviceIntent = new Intent();

				serviceIntent.setClass(getApplicationContext(),RecorderService.class);
				startService(serviceIntent);
				LoggerUtil.debug("RecorderService started");
			}
		});

		Button stopButton = (Button) findViewById(R.id.androidStopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent serviceIntent = new Intent();
				serviceIntent.setClass(getApplicationContext(),
						RecorderService.class);
				stopService(serviceIntent);
				LoggerUtil.debug("RecorderService Stoped");
			}
		});
	}

}
