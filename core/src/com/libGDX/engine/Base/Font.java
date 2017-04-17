package com.libGDX.engine.Base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dhande on 18-03-2017.
 */

public class Font
{
    BitmapFont font;
    GlyphLayout gl;

    public Font(String filePathWithoutExtension)
    {
        font = new BitmapFont(Gdx.files.internal(filePathWithoutExtension + "fnt"), Gdx.files.internal(filePathWithoutExtension + "png"), false);
        gl = new GlyphLayout();
    }

    public void draw(SpriteBatch spriteBatch, String text, float x, float y)
    {
        font.draw(spriteBatch, text, x, y);
    }

    public float getHeight()
    {
        gl.setText(font, "Hii");
        return gl.height;
    }


    public float getWidth(String text)
    {
        gl.setText(font, text);
        return gl.width;
    }


}
