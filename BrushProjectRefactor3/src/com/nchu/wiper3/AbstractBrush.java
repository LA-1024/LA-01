package com.nchu.wiper3;

public abstract class AbstractBrush {

	protected int speed;
	
	public AbstractBrush(){
		speed = 0;
	}
	
	public AbstractBrush(int speed){
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}
		
	public void setSpeed(int speed){
		this.speed = speed;
	}

}
