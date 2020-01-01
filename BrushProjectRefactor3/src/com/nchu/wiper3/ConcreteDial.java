package com.nchu.wiper3;

public class ConcreteDial extends AbstractDial {

	@Override
	public void up() {
		abstractDialState.up();
	}

	@Override
	public void down() {
		abstractDialState.down();
	}

}
