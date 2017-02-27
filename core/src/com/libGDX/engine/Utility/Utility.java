package com.libGDX.engine.Utility;

import com.libGDX.engine.Base.Point;

/**
 * Created by Dhande on 27-02-2017.
 */

public class Utility
{


    public static float getDistanceBetweenPoints(Point p1, Point p2)
    {

        return getDistanceeBetweenTwoPoints(p1.x, p1.y, p2.x, p2.y);
    }


    public static float getDistanceeBetweenTwoPoints(float x1, float y1, float x2, float y2)
    {
        return (float) Math.sqrt(getDistanceeBetweenTwoPoints(x1, y1, x2, y2));
    }


    public static float getSquaredDistanceBetweenTwoPoints(Point p1, Point p2)
    {

        return getSquaredDistanceBetweenTwoPoints(p1.x, p1.y, p2.x, p2.y);
    }

    public static float getSquaredDistanceBetweenTwoPoints(float x1, float y1, float x2, float y2)
    {

        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}
