package com.nchu.wiper3;

public abstract class AbstractLeverState implements IControl {
	
	public AbstractLever abstractLever;
	protected String stateName;
	protected int stateValue;

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

	public AbstractLever getAbstractLever() {
		return abstractLever;
	}

	public void setAbstractLever(AbstractLever abstractLever) {
		this.abstractLever = abstractLever;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	

	
	

}
