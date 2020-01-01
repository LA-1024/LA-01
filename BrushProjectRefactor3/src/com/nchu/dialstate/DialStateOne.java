package com.nchu.dialstate;
import com.nchu.wiper3.*;
import com.nchu.leverstate.*;

public class DialStateOne extends AbstractDialState {
	
	public DialStateOne(AbstractDial abstractDial) {
		this.abstractDial = abstractDial;
		this.stateValue = 4;
		this.stateName = "1档";
	}
	
	
	public DialStateOne(AbstractDialState abstractDialState) {
		this.abstractDial = abstractDialState.abstractDial;
		this.stateValue = 4;
		this.stateName = "1档";
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		this.abstractDial.setAbstractDialState(new DialStateTwo(this));
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

}
