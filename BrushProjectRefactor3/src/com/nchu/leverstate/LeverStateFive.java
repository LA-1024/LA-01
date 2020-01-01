package com.nchu.leverstate;
import com.nchu.dialstate.*;
import com.nchu.wiper3.*;

public class LeverStateFive extends AbstractLeverState {
	
	public LeverStateFive(AbstractLever abstractLever) {
		
		this.abstractLever = abstractLever;
		this.stateValue = 90;
		this.stateName = "超高速";
		
	}
	
	public LeverStateFive(AbstractLeverState abstractLeverState) {
		this.abstractLever = abstractLeverState.abstractLever;
		this.stateName = "超高速";
		this.stateValue = 90;
	}

	@Override
	public void up() {		
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractLever.setAbstractLeverState(new LeverStateFour(this));
	}

}