package com.example.holmesbouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
	//Fields for the actor
	private Point p; //For location
	private int c; //Color
	private int s; //Size
	private int dx; //Change in X speed
	private int dy; //Change in Y speed
	private Paint paint; //Paint object
	
	//Context
	private Context aContext;
	private int costume;
	private BitmapDrawable graphic;
	
	//Constructor
	public Actor(Context context, int x, int y, int col, int size) {
		//Initialize Values
		p = new Point(x, y);
		c = col; // For the color
		s = size; //Assign the size
		paint = new Paint(); //Creates paint object
		paint.setColor(c); // Sets paint color
		dx = 0; //Sets X speed to 0
		dy = 0; //Sets Y speed to 0
		
		//Set the context
		aContext = context;
		
		}//End Constructor
	
	// Accessors and the modifiers ( Getters and Setters )
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	public int getSize() {
		return s;
	}
	
	//Modifiers - Change data in Actor
	public void setColor(int col) {
		c = col;
		paint.setColor(c);
	}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
	}
	
	public void setDX(int speed) {
		dx = speed;
	}
	
	public void setDY(int speed) {
		dy = speed;
	}
	
	public void changeDX(float a) {
		dx += a;
	}
	
	public void changeDY(float a) {
		dy += a;
	}
	
	public void move() {
		p.x += dx;
		p.y += dy;
	}
	
	public void bounce(Canvas c) {
		if(p.x > c.getWidth() || p.x < 0) {
			dx = dx * -1;
		}
		
		if(p.y > c.getHeight() || p.y <0) {
			dy = dy * -1;
		}
	}
	
	public void bounceActor(Actor a) {
		
	}
	
	//Last functions for actor
	
	public void drawCircle(Canvas c) {
		c.drawCircle(p.x, p.y, s, paint);
	}
	
	public void drawSquare(Canvas c) {
		c.drawRect(p.x, p.y, p.x+s, p.y+s, paint);
	}
	
	public void setCostume(int cost) {
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
	}

	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		c.drawBitmap(getBitmap(), p.x, p.y, paint);
	}
	
}























