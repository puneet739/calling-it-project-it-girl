/**
 * Nov 24, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.puneet.android.childrenstories;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.MenuItem;

/**
 * @author puneetb
 * This is the base class, All the activity of the App should extend this.
 * In contain basic menu which need to be present everywhere.  
 * 
 */
public class BaseActivity extends Activity{

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_aboutdeveloper :
			createAboutDevDialog();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void createAboutDevDialog() {
	    Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle(R.string.about_developer_title);
	    builder.setMessage(R.string.about_developer_text);
	    builder.setCancelable(true);
	    builder.setNeutralButton("OK", null);
	    AlertDialog dialog = builder.create();
	    dialog.show();
	}
}
