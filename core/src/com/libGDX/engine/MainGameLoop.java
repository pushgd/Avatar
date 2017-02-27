package com.libGDX.engine;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class MainGameLoop extends ApplicationAdapter implements InputProcessor
{
    public static final float MS_FOR_EACH_FRAME = 1000f / 60;
    SpriteBatch spriteBatch;
    Pixmap pixmap;
    double previous = TimeUtils.millis();
    double lag = 0.0;
    private Texture texture;
    private Sprite sprite;

    @Override
    public void create()
    {
        spriteBatch = new SpriteBatch();
        pixmap = new Pixmap(256, 128, Pixmap.Format.RGB888);
        pixmap.setColor(Color.RED);


        pixmap.fill();

        pixmap.setColor(Color.BLACK);
        pixmap.drawLine(0, 0, pixmap.getWidth() - 1, pixmap.getHeight() - 1);
        pixmap.drawLine(0, pixmap.getHeight() - 1, pixmap.getWidth() - 1, 0);

        pixmap.setColor(Color.YELLOW);
        pixmap.drawCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, pixmap.getHeight() / 2 - 1);

        texture = new Texture(pixmap);

        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render()
    {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            double current = TimeUtils.millis();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;
            while (lag >= MS_FOR_EACH_FRAME)
            {
                try
                {
                    Thread.sleep((long) (1000f/120));
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                lag -= MS_FOR_EACH_FRAME;
            }

            spriteBatch.begin();
            sprite.draw(spriteBatch);
            spriteBatch.end();



    }


    @Override
    public void dispose()
    {
        spriteBatch.dispose();
        texture.dispose();
    }



    public static void setInputProcessor(InputProcessor ip)
    {

    }

    public void Debug(String s)
    {
        Gdx.app.debug("Test",s);
    }


    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
