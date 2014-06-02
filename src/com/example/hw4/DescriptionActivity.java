package com.example.hw4;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DescriptionActivity extends Activity{
	
	// This class displays the title and description passed from the intent extra
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description);
	
		
		String title = getIntent().getStringExtra("title");
		String description = getIntent().getStringExtra("description");
		String date = getIntent().getStringExtra("date");
		TextView tv = (TextView) findViewById(R.id.title);
		tv.setText(title);
		
		//we use a webview because the description contains html
		WebView wv = (WebView) findViewById(R.id.description);
		wv.loadData(description, "text/html", null);
	}

}