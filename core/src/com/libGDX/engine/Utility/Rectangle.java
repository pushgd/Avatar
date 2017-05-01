package com.libGDX.engine.Utility;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Image;
import com.libGDX.engine.Base.Vector2D;

import java.awt.Point;

/**
 * Created by Dhande on 28-04-2017.
 */

public class Rectangle
{
    public float left;
    public float right;
    public float top;
    public float bottom;
    public float width;
    public float height;
    public Vector2D position;

    public void calculateBounds(float positionX, float positionY, float width, float height)
    {
        position = new Vector2D(positionX, positionY);
        left = positionX;
        right = positionX + width ;
        top = positionY + height ;
        bottom = positionY ;
        this.width = width;
        this.height = height;
    }




    public void paint(SpriteBatch batch)
    {
        Image.Debug.drawRect(batch, position.x, position.y, width, height);
        Image.Debug.fillColor(batch,position.x,position.y,5,5, Color.BLUE);
    }

    public void paint(SpriteBatch batch,Color c)
    {
        Image.Debug.drawRect(batch, position.x, position.y, width, height,c);
        Image.Debug.fillColor(batch,position.x,position.y,5,5, c);
    }
}
