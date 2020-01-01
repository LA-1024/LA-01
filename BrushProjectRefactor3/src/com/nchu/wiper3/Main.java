package com.nchu.wiper3;

import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("output.txt");
		PrintWriter pw=new PrintWriter(os);

		ConcreteLever l = new ConcreteLever();
		ConcreteDial d = new ConcreteDial();
		ConcreteBrush b = new ConcreteBrush();
		ConcreteAgent a = new ConcreteAgent(l, d, b);
		GetPossion p = new GetPossion();
		AbstractClean clean =new Clean();

		int tempTime = 0;
		int tempLevel,tempDial;
		int cleanStartTime = (int)(Math.random() * 300);
		int cleanLastTime = (int)(Math.random() *10+5);
		int r[] = p.getPossion();
		int i = 0,times = 0,rain;

		while(times<300)
		{
			if (times == cleanStartTime)
			{
				tempLevel = a.objectlever.getAbstractLeverState().getStateValue();
				tempDial = a.objectdial.getAbstractDialState().getStateValue();
				a.dealspeed(0);
				clean.cleaning(cleanLastTime,pw);
				//System.out.println("Cleaning Windshield " + cleanLastTime + " seconds. .");
				while (tempTime <= cleanLastTime + 3)
				{
					if (tempTime == 3) {
						a.dealspeed(250);
					}
					times++;
					tempTime++;
				}
			}
			a.dealspeed(r[i]);
			if (times % 10 == 0){
				pw.println(r[i]+"," + b.getSpeed());
				//System.out.println(r[i]+"," + b.getSpeed());
			}
			i++;
			times++;
		}
		pw.close();
		os.close();
	}
}
