package com.example.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Fields
	private TextView textTimer;
	private Button resetButton;
	private Button pauseButton;
	private Button startButton;
	
	boolean isRunning = true;
	
	//For the handler runnable
	private int elapsedTime; //Holds the time that has passed
	
	private Handler h; // The handler
	
	private int RATE = 1000; // Milliseconds - how fast
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Bind to XML
		textTimer = (TextView)findViewById(R.id.textTimer);
		resetButton = (Button)findViewById(R.id.resetButton);
		pauseButton = (Button)findViewById(R.id.pauseButton);
		startButton = (Button)findViewById(R.id.startButton);
		
		//Initialize the counters
		elapsedTime = 15;
		
		
		
		h = new Handler();
		
		count();
		
		
	}
	
	public void pauseClicked(View v) {
		isRunning = false;
	}
	
	public void startClicked(View v) {
		isRunning = true;
	}
	
	public void reset(View v) {
		elapsedTime = 60;
		textTimer.setText(String.valueOf(elapsedTime));
	}

	private void count() {
		elapsedTime--; // elapsedTime = elapsedTime - 1
		textTimer.setText(String.valueOf(elapsedTime));
		
		if(elapsedTime < 1) {
			isRunning = false;
		}
		
		if(isRunning == true) {
			h.postDelayed(r,  RATE);
		}
	}
	
	//Define the runnable which calls the count() function
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			count(); //Call back to count function
			
		}
		
	}; //End Runnable R

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
