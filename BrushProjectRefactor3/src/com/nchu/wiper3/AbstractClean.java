package com.nchu.wiper3;

import java.io.PrintWriter;

public abstract class AbstractClean {

    protected double cap=0;

    public AbstractClean()
    {
        cap=4;
    }
    public abstract void cleaning(int time, PrintWriter pw);

    public  abstract  double getCap();

    public abstract void setCap();

}
