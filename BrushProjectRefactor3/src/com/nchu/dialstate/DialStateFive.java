package com.nchu.dialstate;
import com.nchu.wiper3.AbstractDialState;
import com.nchu.leverstate.*;

public class DialStateFive extends AbstractDialState {
	
	public DialStateFive(AbstractDialState abstractDialState){
		this.abstractDial = abstractDialState.abstractDial;
		this.stateValue = 20;
		this.stateName = "5档";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateFour(this));
	}

}