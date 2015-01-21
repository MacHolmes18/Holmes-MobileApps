package com.example.texttospeech;

import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import android.text.Editable;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	// XML objects
	private Button speak;
	private EditText enterText;
	
	//Variable to store text for speaking
	private String phrase;
	
	//Text to speech object
	private TextToSpeech speaker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Bind XML objects
		speak = (Button)findViewById(R.id.speechButton);
		enterText = (EditText)findViewById(R.id.enterText);
		
		speaker = new TextToSpeech(this, this);
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

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
	
	//Speak function called by the button
	public void speak(View v) {
		//Pitch
		speaker.setPitch(1);
		
		// Get the input text
		Editable input = enterText.getText();
		
		// Convert input text into a String
		phrase = input.toString();
		
		//Speaking the phrase aloud
		speaker.speak(phrase, 1, null);
		
	}
	
	public void handleClick(View v) {
		Button french = (Button)findViewById(R.id.buttonFrench);
		Button german = (Button)findViewById(R.id.buttonGerman);
		Button english = (Button)findViewById(R.id.buttonEnglish);
		Button italian = (Button)findViewById(R.id.buttonItalian);
		
		switch (v.getId()) {
		case R.id.buttonEnglish:
			speaker.setLanguage(Locale.ENGLISH);
			v.setBackgroundColor(Color.GREEN);
			german.setBackgroundColor(Color.WHITE);
			french.setBackgroundColor(Color.WHITE);
			italian.setBackgroundColor(Color.WHITE);
			break;
		case R.id.buttonFrench:
			speaker.setLanguage(Locale.FRENCH);
			v.setBackgroundColor(Color.GREEN);
			english.setBackgroundColor(Color.WHITE);
			german.setBackgroundColor(Color.WHITE);
			italian.setBackgroundColor(Color.WHITE);
			break;
		case R.id.buttonGerman:
			speaker.setLanguage(Locale.GERMAN);
			v.setBackgroundColor(Color.GREEN);
			english.setBackgroundColor(Color.WHITE);
			french.setBackgroundColor(Color.WHITE);
			italian.setBackgroundColor(Color.WHITE);
			break;
		case R.id.buttonItalian:
			speaker.setLanguage(Locale.ITALIAN);
			v.setBackgroundColor(Color.GREEN);
			english.setBackgroundColor(Color.WHITE);
			french.setBackgroundColor(Color.WHITE);
			german.setBackgroundColor(Color.WHITE);
			break;
		}
	}
	
}
