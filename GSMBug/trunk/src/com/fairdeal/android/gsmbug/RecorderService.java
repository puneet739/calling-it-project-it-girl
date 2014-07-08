package com.fairdeal.android.gsmbug;

import java.io.IOException;

import com.fairdeal.android.gsmbug.util.LoggerUtil;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;

public class RecorderService extends Service {

	MediaRecorder recorder;

	checkRecorder checker;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startRecorder();
		return Service.START_NOT_STICKY;
	}

	private void startRecorder() {
		try {
			String mFileName = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
			mFileName += "/test.mp4";

			recorder = new MediaRecorder();
			recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
			recorder.setOutputFile(mFileName);
			recorder.prepare();
			recorder.start();
			if (checker == null)
				checker = new checkRecorder();
			checker.execute(recorder);
		} catch (IllegalStateException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDestroy() {
		System.out.println("Stoping the Recorder service. ");
		stopRecorder();
		super.onDestroy();
	}

	private void stopRecorder() {
		if (recorder != null) {
			recorder.stop();
			recorder.release();
			checker.stopBackgroundService();
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	class checkRecorder extends AsyncTask<MediaRecorder, Void, Void> {

		boolean isRunning = false;

		@Override
		protected Void doInBackground(MediaRecorder... params) {
			while (isRunning) {
				try {
					Thread.sleep(3000);
					int amplitude = params[0].getMaxAmplitude();
					LoggerUtil.debug("Calling to check the Executor : "+ amplitude);
					if (amplitude>140){
						
						String url = "9971949200";
						LoggerUtil.debug("Now calling phone Number :: "+url+" with Amplitude as: "+amplitude);
						Intent intent = new Intent(Intent.ACTION_CALL);
						intent.setData(Uri.parse("tel:" + url));
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			LoggerUtil.debug("Now finishing the task for recording the audio");
			return null;
		}
		
		public void stopBackgroundService() {
			isRunning = false;
		}
		
		@Override
		public void onPreExecute() {
			isRunning = true;
		}
	}

}
