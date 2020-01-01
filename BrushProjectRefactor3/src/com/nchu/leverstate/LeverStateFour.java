package com.nchu.leverstate;
import com.nchu.dialstate.*;
import com.nchu.wiper3.*;

public class LeverStateFour extends AbstractLeverState{
		
		public LeverStateFour(AbstractLeverState abstractLeverState) {
			this.abstractLever = abstractLeverState.abstractLever;
			this.stateValue = 60;
			this.stateName = "高速";
		}

		@Override
		public void up() {
			// TODO Auto-generated method stub
			this.abstractLever.setAbstractLeverState(new LeverStateFive(this));
			
		}

		@Override
		public void down() {
			// TODO Auto-generated method stub
			this.abstractLever.setAbstractLeverState(new LeverStateThree(this));
		}

	}
