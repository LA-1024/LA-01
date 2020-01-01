package com.nchu.wiper3;

public class ConcreteAgent extends AbstractAgent {

	public ConcreteAgent() {

	}

	public ConcreteAgent(AbstractLever objectlever, AbstractDial objectdial, AbstractBrush objectbrush) {
		super(objectlever, objectdial, objectbrush);
	}


	@Override
	public void dealSpeed(int choice) {

		switch (choice) {
			case 1:
				this.objectlever.up();
				break;
			case 2:
				this.objectlever.down();
				break;
			case 3:
				this.objectdial.up();
				break;
			case 4:
				this.objectdial.down();
				break;
		}

		if ("间歇".equals(this.objectlever.getAbstractLeverState().getStateName())) {
			this.objectbrush.setSpeed(this.objectdial.getAbstractDialState().getStateValue());
		} else {
			this.objectbrush.setSpeed(this.objectlever.getAbstractLeverState().getStateValue());
		}

	}


	public void dealspeed(int rain) {
		if(rain>=1&&rain<=320)
		{
			while (this.objectlever.getAbstractLeverState().getStateName() != "间歇" )
			{
				if(this.objectlever.getAbstractLeverState().getStateValue()>=30)
					this.objectlever.down();
				else
					this.objectlever.up();
			}

			while (this.objectdial.getAbstractDialState().getStateValue() != rainToSpeed(rain))
			{
				if (this.objectdial.getAbstractDialState().getStateValue() > rainToSpeed(rain))
					objectdial.down();
				if (this.objectdial.getAbstractDialState().getStateValue() < rainToSpeed(rain))
					objectdial.up();
			}
		}
		else
		{
			while (this.objectlever.getAbstractLeverState().getStateValue() != rainToSpeed(rain))
			{
				if (this.objectlever.getAbstractLeverState().getStateValue() > rainToSpeed(rain))
					this.objectlever.down();
				if (this.objectlever.getAbstractLeverState().getStateValue() < rainToSpeed(rain))
					this.objectlever.up();
			}
		}
		if ("间歇".equals(this.objectlever.getAbstractLeverState().getStateName())) {
			this.objectbrush.setSpeed(this.objectdial.getAbstractDialState().getStateValue());
		} else {
			this.objectbrush.setSpeed(this.objectlever.getAbstractLeverState().getStateValue());
		}
	}

	public int rainToSpeed(int rain)
	{
		if(rain == 0) {
			return 0;
		}
		else if(rain >= 1 && rain <= 80) {
			return 4;
		}
		else if (rain >= 81 && rain <= 160) {
			return 6;
		}
		else if (rain >= 161 && rain <= 240) {
			return 12;
		}
		else if (rain >= 241 && rain <= 320) {
			return 20;
		}
		else if (rain >= 321 && rain <= 400) {
			return 30;
		}
		else if (rain >= 401 && rain <= 450) {
			return 60;
		}
		else{
			return 90;
		}

	}


}