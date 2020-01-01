package com.nchu.wiper3;

import java.io.PrintWriter;

public class Clean extends AbstractClean {

    private double cap =4;//��Һ������

    public Clean()
    {
        super();
    }

    @Override
    public void cleaning(int time,PrintWriter pw)
    {
        if (cap>=1)
        {
            pw.println("Cleaning Windshield " + time + " seconds.");
            //System.out.println("Cleaning Windshield " + time + " seconds.");
            cap=cap-0.01*time;
        }
        else
        {
            pw.println("Warning: Washer fluid Insufficient.");
            //System.out.println("Warning: Washer fluid Insufficient.");
        }
    }

    @Override
    public double getCap() {
        return this.cap;
    }

    @Override
    public void setCap() {
        this.cap=4;
    }

}
