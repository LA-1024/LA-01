package com.nchu.leverstate;
import com.nchu.dialstate.*;
import com.nchu.wiper3.*;

public class LeverStateOne extends AbstractLeverState {
	
	public LeverStateOne(AbstractLever abstractLever) {
		
		this.abstractLever = abstractLever;
		this.stateValue = 0;
		this.stateName = "停止";
		
	}
	
	public LeverStateOne(AbstractLeverState abstractLeverState) {
		this.abstractLever = abstractLeverState.abstractLever;
		this.stateName = "停止";
	}

	@Override
	public void up() {
		
		this.abstractLever.setAbstractLeverState(new LeverStateTwo(this));
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

}
