package com.nchu.wiper3;

public abstract class AbstractAgent {
	protected AbstractLever objectlever;
	protected AbstractDial objectdial;	
	protected AbstractBrush objectbrush;
	
	public AbstractAgent(){
		
	}
	
	public AbstractAgent(AbstractLever objectlever,AbstractDial objectdial,AbstractBrush objectbrush){
		this.objectlever = objectlever;
		this.objectdial = objectdial;
		this.objectbrush = objectbrush;
	}
	
	public abstract void dealSpeed(int choice);

}
