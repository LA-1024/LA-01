package com.nchu.dialstate;
import com.nchu.wiper3.*;
import com.nchu.leverstate.*;

public class DialStateFour extends AbstractDialState {
	
	public DialStateFour(AbstractDialState abstractDialState) {
		this.abstractDial = abstractDialState.abstractDial;
		this.stateValue = 20;
		this.stateName = "4档";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateFive(this));
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateThree(this));
	}

}