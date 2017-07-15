package com.libGDX.engine.Utility;

/**
 * Created by Dhande on 27-02-2017.
 */

public class Vector2D
{
    public float x, y;

    public Vector2D(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D p)
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
