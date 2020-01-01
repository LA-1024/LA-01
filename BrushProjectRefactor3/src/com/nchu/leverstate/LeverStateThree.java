package com.nchu.leverstate;
import com.nchu.dialstate.*;
import com.nchu.wiper3.*;

public class LeverStateThree extends AbstractLeverState{
	
	public LeverStateThree(AbstractLeverState abstractLeverState) {
		this.abstractLever = abstractLeverState.abstractLever;
		this.stateValue = 30;
		this.stateName = "低速";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractLever.setAbstractLeverState(new LeverStateFour(this));		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractLever.setAbstractLeverState(new LeverStateTwo(this));
	}

}
