package com.libGDX.engine.Utility;

/**
 * Created by Dhande on 27-02-2017.
 */

public class Utility
{


    public static float getDistanceBetweenPoints(Vector2D p1, Vector2D p2)
    {

        return getDistanceeBetweenTwoPoints(p1.x, p1.y, p2.x, p2.y);
    }


    public static float getDistanceeBetweenTwoPoints(float x1, float y1, float x2, float y2)
    {
        return (float) Math.sqrt(getSquaredDistanceBetweenTwoPoints(x1, y1, x2, y2));
    }


    public static float getSquaredDistanceBetweenTwoPoints(Vector2D p1, Vector2D p2)
    {

        return getSquaredDistanceBetweenTwoPoints(p1.x, p1.y, p2.x, p2.y);
    }

    public static float getSquaredDistanceBetweenTwoPoints(float x1, float y1, float x2, float y2)
    {

        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}
