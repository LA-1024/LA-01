package com.nchu.dialstate;
import com.nchu.wiper3.*;
import com.nchu.leverstate.*;

public class DialStateThree extends AbstractDialState {
	
	public DialStateThree(AbstractDialState abstractDialState) {
		this.abstractDial = abstractDialState.abstractDial;
		this.stateValue = 12;
		this.stateName = "3档";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateFour(this));
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateTwo(this));
	}

	
	
}
