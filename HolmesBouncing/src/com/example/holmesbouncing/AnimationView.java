package com.example.holmesbouncing;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View{
	
	//Breakout Actors
	private Actor paddle;
	private Actor ball;
	
	private List <Actor> bricks;
	
	//Values to hold accel data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	//Create the handler for animation
	private Handler h;
	private int  RATE = 30; // About 30 fps

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//Initialize Actors
		paddle = new Actor(context, 200, 750, Color.BLUE, 25);
		ball = new Actor(context, 300, 300, Color.RED, 30);
		
		paddle.setWidth(200);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		//Initialize bricks array list
		bricks = new ArrayList <Actor> (0);
		
		//For loop to initialize bricks
		for (int i = 0; i < 6; i++) {
			bricks.add(new Actor(context, i*80, 100, Color.GREEN, 40));
		}
		
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).setWidth(75);
		}
		
		//Set Costume
	
		h = new Handler();
	
	}//End constructor
	
//	//onDraw method - in all View classes
//	
	public void onDraw(Canvas c) {
		//Breakout
		paddle.drawRect(c);
		ball.drawCircle(c);
		
		ball.move();
		ball.bounce(c);
		if(ball.isTouching(paddle)) {
			ball.bounceUp();
		}
		
		//Bricks draw Rectangles
		for (int i = 0; i <bricks.size(); i++) {
			//Set bricks width
			bricks.get(i).setWidth((c.getWidth()/6)-3);
			//Set the x position for the bricks
			int xPos = i * (c.getWidth()/6);
			//goTo and draw the bricks
			bricks.get(i).goTo(xPos, 100);
			bricks.get(i).drawRect(c);
			
			//Check for collisions and erase bricks
			if(ball.isTouching(bricks.get(i))) {
				if (bricks.get(i).getVisible() == true) {
					ball.bounceUp();
					bricks.get(i).setVisible(false);
				}//End if
			}//End if
		}

		//Call the runnable
		h.postDelayed(r,  RATE);
	}
	
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			invalidate();
		}
		
	};
	
	@SuppressWarnings("null")
	public boolean onTouchEvent(MotionEvent event) {
		//Fetch data from touch event
		int action = event.getActionMasked();//Get type of action
		int actionIdex = event.getActionIndex();//Get index of action
		
		//Set position of Sandy to touch data
		//cow2.goTo((int)event.getX(), (int)event.getY());
		
		//Breakout
		paddle.goTo((int)event.getX(), 750);	
		
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
