package com.libGDX.engine.Base.render;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Utility.Utility;

/**
 * Created by Dhande on 01-03-2017.
 */

public class Bitmap
{


    private Texture texture;
    private Sprite sprite;


    public Bitmap(String path)
    {
        texture = new Texture(path);
        sprite = new Sprite(texture);
        sprite.flip(false, true);
    }

    public static void draw(SpriteBatch spriteBatch, Bitmap r, float x, float y)
    {
        r.sprite.setPosition(x, y);
        r.sprite.draw(spriteBatch);
    }

    public static void draw(SpriteBatch spriteBatch, Bitmap r, float x, float y, float originX, float originY, float rotation, float scaleX, float scaleY)
    {


        r.sprite.setPosition(x, y);
        r.sprite.setOrigin(originX, originY);
        r.sprite.setScale(scaleX, scaleY);
        r.sprite.setRotation(rotation);
//

        r.sprite.draw(spriteBatch);
    }

    public int getWidth()
    {
        return (int) (sprite.getWidth());
    }

    public int getHeight()
    {
        return (int) (sprite.getHeight());
    }

    public Texture getTexture(){return  texture;}

    public static class Debug
    {
        public static Texture pixel = new Texture("Debug/pixel.png");
        public static Sprite pixelSprite = new Sprite(pixel);
        public static BitmapFont bf = new BitmapFont(true);
        public static GlyphLayout gl = new GlyphLayout();

        public static void init()
        {
            pixelSprite.flip(false, true);
        }


        public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height)
        {
            float angle = ((float) Math.toDegrees(Math.atan2((y1 - y2), (x1 - x2)))) - 180;
            float length = Utility.getDistanceeBetweenTwoPoints(x1, y1, x2, y2);

            pixelSprite.setSize(length, height);
            pixelSprite.setOrigin(0, 0);
            pixelSprite.setRotation(angle);
            pixelSprite.setPosition(x1, y1);
            pixelSprite.draw(spritebatch);
            pixelSprite.setColor(Color.WHITE);
            pixelSprite.setRotation(0);
        }

        public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height, Color c)
        {
            pixelSprite.setColor(c);
            drawLine(spritebatch, x1, y1, x2, y2, height);
        }


        public static void fillColor(SpriteBatch spritebatch, float x1, float y1, float width, float height, Color c)
        {
            pixelSprite.setColor(c);
            pixelSprite.setSize(width, height);
            pixelSprite.setOrigin(0, 0);
            pixelSprite.setPosition(x1, y1);
            pixelSprite.draw(spritebatch);
            pixelSprite.setRotation(0);
            pixelSprite.setColor(Color.WHITE);
        }


        public static void drawRect(SpriteBatch spritebatch, float x, float y, float width, float height, Color c)
        {
            drawLine(spritebatch, x, y, x + width, y, 2, c);
            drawLine(spritebatch, x, y, x, y + height, 2, c);
            drawLine(spritebatch, x, y + height, x + width, y + height, 2, c);
            drawLine(spritebatch, x + width, y, x + width, y + height, 2, c);
        }

        public static void drawRect(SpriteBatch spritebatch, float x, float y, float width, float height)
        {
            drawLine(spritebatch, x, y, x + width, y, 2, Color.YELLOW);
            drawLine(spritebatch, x, y, x, y + height, 2, Color.YELLOW);
            drawLine(spritebatch, x, y + height, x + width, y + height, 2, Color.YELLOW);
            drawLine(spritebatch, x + width, y, x + width, y + height, 2, Color.YELLOW);
        }

        public static void drawText(SpriteBatch spriteBatch, String s, float x, float y, Color c)
        {
            bf.setColor(c);
            bf.draw(spriteBatch, s, x, y);


        }

        public static void drawText(SpriteBatch spriteBatch, String s, float x, float y)
        {
            drawText(spriteBatch, s, x, y, Color.WHITE);

        }

        public static float getTextWidth(String text)
        {
            return getTextWidth(bf, text);
        }

        public static float getTextWidth(BitmapFont font, String text)
        {
            gl.setText(font, text);
            return gl.width;
        }


        public static float getTextHeight(String text)
        {
            return getTextHeight(bf, text);
        }

        public static float getTextHeight(BitmapFont font, String text)
        {
            gl.setText(font, text);
            return gl.height;
        }
    }

}
