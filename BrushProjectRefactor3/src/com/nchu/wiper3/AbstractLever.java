package com.nchu.wiper3;
import com.nchu.leverstate.*;


public abstract class AbstractLever implements IControl {

	protected AbstractLeverState abstractLeverState;

	public AbstractLever(){
		
		abstractLeverState = new LeverStateOne(this);
		
	}
	
	public AbstractLeverState getAbstractLeverState() {
		return abstractLeverState;
	}
	public void setAbstractLeverState(AbstractLeverState abstractLeverState) {
		this.abstractLeverState = abstractLeverState;
	}
	
	
	public abstract void up();
	public abstract void down();

}
