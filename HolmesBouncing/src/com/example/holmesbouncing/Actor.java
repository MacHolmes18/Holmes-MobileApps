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
	
	private int w;
	private int h;
	
	//Boolean is visible to check if draw
	private boolean isVisible = true;
	
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
		w = s; //Set width
		h = s; //Set height
		paint = new Paint(); //Creates paint object
		paint.setColor(c); // Sets paint color
		dx = 0; //Sets X speed to 0
		dy = 0; //Sets Y speed to 0
		
		//Set the context
		aContext = context;
		
		}//End Constructor
	
	public void setWidth(int width) {
		w = width;
	}
	
	public void setHeight(int height) {
		h = height;
	}
	
	public boolean isTouching(Actor a) {
		boolean result = false;
		
		if ((p.x + w > a.getX() && p.x < a.getX() + a.getWidth()) &&
		    (p.y + h > a.getY() && p.y+h < a.getY() + a.getHeight())) {
			result = true;
		}
		return result;
	}
	
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
	
	public void bounceOff() {
		dx = dx * -1;
		dy = dy * -1;
	}
	
	public void bounceUp() {
		dy = dy * -1;
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
	
	public void drawRect(Canvas c) {
		if(isVisible) {
		c.drawRect(p.x, p.y, p.x+w, p.y+h, paint);
		}
	}
	
	public void setCostume(int cost) {
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
		
		//Set width and height based on custome
		w = graphic.getBitmap().getWidth();
		h = graphic.getBitmap().getHeight();
	}
	
	public int getHeight() {
		return h;
	}
	
	public int getWidth() {
		return w;
	}

	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		c.drawBitmap(getBitmap(), p.x, p.y, paint);
	}
	
	public boolean getVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean v) {
		isVisible = v;
	}
	
	
	
}























