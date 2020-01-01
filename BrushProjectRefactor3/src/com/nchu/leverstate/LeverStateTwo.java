package com.nchu.leverstate;
import com.nchu.dialstate.*;
import com.nchu.wiper3.*;

public class LeverStateTwo extends AbstractLeverState{

	
	public LeverStateTwo(AbstractLeverState abstractLeverState) {
		
		this.abstractLever = abstractLeverState.abstractLever;
		this.stateName = "间歇";
	}
	


	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractLever.setAbstractLeverState(new LeverStateThree(this));
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractLever.setAbstractLeverState(new LeverStateOne(this));
	}

}
