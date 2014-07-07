package com.fairdeal.android.gsmbug;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;

public class RecorderService extends Service {

	MediaRecorder player;

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

			player = new MediaRecorder();
			player.setAudioSource(MediaRecorder.AudioSource.MIC);
			player.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			player.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
			player.setOutputFile(mFileName);
			player.prepare();
			player.start();
			if (checker == null)
				checker = new checkRecorder();
			checker.execute(player);
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
		if (player != null) {
			player.stop();
			player.release();
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
					System.out.println("Calling to check the Executor : "+ amplitude);
					if (amplitude>140){
						String url = "tel:9971949200";
					    Intent callingIntent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
					    startService(callingIntent);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out
					.println("Now finishing the task for recording the audio");
			return null;
		}

		public void stopBackgroundService() {
			isRunning = false;
		}

		public void onPreExecute() {
			isRunning = true;
		}
	}

}
