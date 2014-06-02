package com.example.hw4;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listview = (ListView) findViewById(R.id.listView); 
        final Activity goTo = this;
        
        // this is a no name thread
        (new Thread(new Runnable(){
        	ArrayList<RssItem> RssItem;
			@Override
			public void run() {
				try {
					
					this.RssItem = MyPullParser.parse("http://www.nba.com/bulls/rss.xml");
					MainActivity.this.runOnUiThread(new Runnable(){
						@Override
						public void run() {
							listview.setAdapter(new MyAdapter(goTo, RssItem));
							
						}
					});
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        })).start();
    } 
}
   