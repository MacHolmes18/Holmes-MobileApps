package com.example.holmesintentexercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityOne extends Activity {
	
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_activityone);
	}
	
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_activityone);
	}
	
	public void handleClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	

}
