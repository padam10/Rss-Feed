package com.example.hw4;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{
	//Custom list adapter which overrides getView to return the view
	// represented in the custom xml list item layout
	private ArrayList<RssItem> items;
	private Activity newActivity;

	public MyAdapter(Activity newActivity, ArrayList<RssItem> items){
		this.items = items;
		this.newActivity = newActivity;
	}
	@Override
	public int getCount() {
		return items.size();
		
	}

	@Override
	public RssItem getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View newView, ViewGroup parent) {
		View view = null;
		if(newView != null){ ////if newView is not null, we can reuse this view
			view = newView;
		}else{
			//if newView is null, inflate a new view and return it
			view = newActivity.getLayoutInflater().inflate(R.layout.itemdescription, null);

		}

		final RssItem item = getItem(position);
		TextView textview = (TextView) view.findViewById(R.id.title1);
		textview.setText(item.getTitle());
		//each button must have it's own listener, to start an
		//an activity with individual options passed in
		
		Button btn = (Button) view.findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(newActivity,DescriptionActivity.class);
				intent.putExtra("title", item.getTitle());
				intent.putExtra("description", item.getDescription());
				newActivity.startActivity(intent);
			}
		});
		return view;
	}


}