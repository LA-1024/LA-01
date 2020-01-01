package com.nchu.dialstate;
import com.nchu.wiper3.*;
import com.nchu.leverstate.*;

public class DialStateTwo extends AbstractDialState {
	
	public DialStateTwo(AbstractDialState abstractDialState) {
		this.abstractDial = abstractDialState.abstractDial;
		this.stateValue = 6;
		this.stateName = "2档";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateThree(this));
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateOne(this));
	}

}
