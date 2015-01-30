package com.example.holmesbouncing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View{
	
	//Create some actors
	private Actor cow;
	private Actor cow2;
	
	//Values to hold accel data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	//Create the handler for animation
	private Handler h;
	private int  RATE = 30; // About 30 fps

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//Initialize the actors
		cow = new Actor(context, 100, 100, Color.YELLOW, 50);
		cow2 = new Actor(context, 200, 200, Color.RED, 50);
		
		//Set Costume
		cow.setCostume(R.drawable.cow);
		cow2.setCostume(R.drawable.cow);
		
		cow.setDX(7);
		cow.setDY(7);
		
		cow2.setDX(8);
		cow2.setDY(8);
	
		h = new Handler();
	
	}//End constructor
	
	//onDraw method - in all View classes
	public void onDraw(Canvas c) {
		cow.draw(c);
		cow2.draw(c);
	
		//Actors move
		cow.move();
		cow.bounce(c);
		
		//Read accel data and move to cow
		cow.changeDX(ax * -1);
		cow.changeDY(ay);
		
		
		cow2.move();
		cow2.bounce(c);
		
		//Call the runnable
		h.postDelayed(r,  RATE);
	}
	
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			invalidate();
		}
		
	};
	
	public boolean onTouchEvent(MotionEvent event) {
		//Fetch data from touch event
		int action = event.getActionMasked();//Get type of action
		int actionIdex = event.getActionIndex();//Get index of action
		
		//Set position of Sandy to touch data
		cow2.goTo((int)event.getX(), (int)event.getY());
		
		return true;
	}
	
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	
	
	

}//End class AnimationView
