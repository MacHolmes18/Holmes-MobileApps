//Mac Holmes
//All work here is honestly obtained and is my own
package com.example.holmesfinaleam;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText editText1;
	private Button buttonDollars;
	private EditText editText2;
	private Button buttonYen;
	private EditText editText3;
	private Button buttonPounds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText)findViewById(R.id.editText1);
		buttonDollars = (Button)findViewById(R.id.buttonDollars);
		editText2 = (EditText)findViewById(R.id.editText2);
		buttonYen = (Button)findViewById(R.id.buttonYen);
		editText3 = (EditText)findViewById(R.id.editText3);
		buttonPounds = (Button)findViewById(R.id.buttonPounds);
	}

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
	
	public void handleClick() {
		editText1 = (EditText)findViewById(R.id.editText1);
		buttonDollars = (Button)findViewById(R.id.buttonDollars);
		editText2 = (EditText)findViewById(R.id.editText2);
		buttonYen = (Button)findViewById(R.id.buttonYen);
		editText3 = (EditText)findViewById(R.id.editText3);
		buttonPounds = (Button)findViewById(R.id.buttonPounds);
		
		switch (v.getId()) {
		case R.id.buttonDollars:
			if(checked) {
				String Dollars = dollarsToYen(currency);
				editText1 = setText(dollars);
			}
			break;
			
			
	}
	}
	
	private String dollarsToYen() {
		dollars = 97.35 Yen;
		return String.valueOf(Yen);
	}
	
}
