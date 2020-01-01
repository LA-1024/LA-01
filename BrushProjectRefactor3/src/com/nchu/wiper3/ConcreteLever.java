package com.nchu.wiper3;

public class ConcreteLever extends AbstractLever {

	@Override
	public void up() {
		abstractLeverState.up();
	}

	@Override
	public void down() {
		abstractLeverState.down();
	}

}
