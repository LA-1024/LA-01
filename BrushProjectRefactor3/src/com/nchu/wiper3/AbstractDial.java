package com.nchu.wiper3;
import com.nchu.dialstate.*;

public abstract class AbstractDial implements IControl {

	protected AbstractDialState abstractDialState;
	
	public AbstractDial() {
		this.abstractDialState = new DialStateOne(this);
	}
	
	public AbstractDialState getAbstractDialState() {
		return abstractDialState;
	}
	public void setAbstractDialState(AbstractDialState abstractDialState) {
		this.abstractDialState = abstractDialState;
	}
	public abstract void up();
	public abstract void down();

}
