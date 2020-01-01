package com.nchu.wiper3;

public abstract class AbstractDialState implements IControl  {
	
	public AbstractDial abstractDial;
	protected int stateValue;
	protected String stateName;
	
	@Override
	public abstract void up();
	@Override
	public abstract void down();

	public int getStateValue() {
		return stateValue;
	}
	public void setStateValue(int stateValue) {
		this.stateValue = stateValue;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	

}
