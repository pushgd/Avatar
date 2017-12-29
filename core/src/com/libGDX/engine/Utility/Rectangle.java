package com.libGDX.engine.Utility;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.render.Bitmap;

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
    public Vector2D position = new Vector2D(0, 0);

    public void calculateBounds(float positionX, float positionY, float width, float height)
    {
        position.x = positionX;
        position.y = positionY;
        left = positionX;
        right = positionX + width;
        top = positionY ;
        bottom = positionY+height;
        this.width = width;
        this.height = height;
    }


    public void paint(SpriteBatch batch)
    {
        Bitmap.Debug.drawRect(batch, position.x, position.y, width, height);
        Bitmap.Debug.fillColor(batch, position.x, position.y, 5, 5, Color.BLUE);
    }

    public void paint(SpriteBatch batch, Color c)
    {
        Bitmap.Debug.drawRect(batch, position.x, position.y, width, height, c);
        Bitmap.Debug.fillColor(batch, position.x, position.y, 5, 5, c);
    }
}
