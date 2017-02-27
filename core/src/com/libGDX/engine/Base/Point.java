package com.libGDX.engine.Base;

/**
 * Created by Dhande on 27-02-2017.
 */

public class Point
{
    public float x, y;

    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point p)
    {
        x = p.x;
        y = p.y;
    }


    @Override
    public String toString()
    {
        return "X = "+x+" Y = "+y;
    }
}
