package com.fairdeal.android.gsmbug;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GSMBug extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("Hello World, Android - mkyong.com");
        setContentView(text);
    }
}
