package com.nchu.wiper3;
import java.util.Arrays;
import java.util.Random;

public class GetPossion {
	private int[] rainFall=new int[300];
	
	Random rand =new Random();
	
	public int[] getPossion() {
		int k;
//		for (int i = 0; i < 3000; i++) {
//			k=(int) (Math.sqrt(1000)*rand.nextGaussian()+300);
//			if (k>500||k<0) {
//				i--;
//				continue;
//			}
		for(int i=0;i<300;i++)
		{
			rainFall[i] =(int)(Math.random()*500);
		}
			//rainFall[i]=k;
	    return rainFall;
	}

}
