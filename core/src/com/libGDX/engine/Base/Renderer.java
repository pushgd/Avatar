package com.libGDX.engine.Base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.libGDX.engine.Debug.Debug;
import com.libGDX.engine.Utility.Utility;

import javax.swing.plaf.synth.ColorType;

/**
 * Created by Dhande on 01-03-2017.
 */

public class Renderer
{


    public static Texture pixel = new Texture("pixel.png");
    public static Sprite sprite = new Sprite(pixel);
    public static BitmapFont bf  = new BitmapFont();

    public static ShapeRenderer shapeRenderer = new ShapeRenderer();

    public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height)
    {
        float angle =((float) Math.toDegrees(Math.atan2((y1 - y2), (x1 - x2))))-180;
        float length = Utility.getDistanceeBetweenTwoPoints(x1, y1, x2, y2);
        sprite.setSize(length, height);
        sprite.setOrigin(0,0);
        sprite.setRotation(angle);
        sprite.setPosition(x1, y1);
        sprite.draw(spritebatch);
        sprite.setColor(Color.WHITE);
        sprite.setRotation(0);
    }

    public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height, Color c)
    {
        sprite.setColor(c);
        drawLine(spritebatch, x1, y1, x2, y2, height);
    }


    public static void fillColor(SpriteBatch spritebatch, float x1, float y1, float width, float height, Color c)
    {
        sprite.setColor(c);
        sprite.setSize(width, height);
        sprite.setOrigin(0,0);
        sprite.setPosition(x1, y1);
        sprite.draw(spritebatch);
        sprite.setRotation(0);
        sprite.setColor(Color.WHITE);
    }


    public static void drawRect(SpriteBatch spritebatch, float x, float y, float width, float height, Color c)
    {
        drawLine(spritebatch,x,y,x+width,y,2,c);
        drawLine(spritebatch,x,y,x,y+height,2,c);
        drawLine(spritebatch,x,y+height,x+width,y+height,2,c);
        drawLine(spritebatch,x+width,y,x+width,y+height,2,c);
    }

    public static void drawRect(SpriteBatch spritebatch, float x, float y, float width, float height)
    {
        drawLine(spritebatch,x,y,x+width,y,2, Color.YELLOW);
        drawLine(spritebatch,x,y,x,y+height,2,Color.YELLOW);
        drawLine(spritebatch,x,y+height,x+width,y+height,2,Color.YELLOW);
        drawLine(spritebatch,x+width,y,x+width,y+height,2,Color.YELLOW);
    }

    public static void drawText(SpriteBatch spriteBatch,String s,float x,float y,Color c)
    {
        bf.setColor(c);
        bf.draw(spriteBatch,s,x,y);

    }

}
