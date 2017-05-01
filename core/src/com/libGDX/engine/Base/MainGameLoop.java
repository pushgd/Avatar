package com.libGDX.engine.Base;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import game.GameManager;

public class MainGameLoop extends ApplicationAdapter implements InputProcessor
{
    public static final float MS_FOR_EACH_FRAME = 1000f / 60;
    SpriteBatch spriteBatch;
    double previous = TimeUtils.millis();
    double lag = 0.0;

    @Override
    public void create()
    {


        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        GameManager.onGameStart();

    }

    @Override
    public void render()
    {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        double current = TimeUtils.millis();
        double elapsed = current - previous;
        previous = current;
        lag += elapsed;
        while (lag >= MS_FOR_EACH_FRAME)
        {

            GameManager.update();
            lag -= MS_FOR_EACH_FRAME;
        }

        spriteBatch.begin();
        GameManager.paint(spriteBatch);
        spriteBatch.end();


    }


    @Override
    public void dispose()
    {
        spriteBatch.dispose();

    }


    public void Debug(String s)
    {
        Gdx.app.debug("Test", s);
    }


    @Override
    public boolean keyDown(int keycode)
    {
        GameManager.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        GameManager.keyUp(keycode);
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
        GameManager.touchDown(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {

        GameManager.touchUp(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        GameManager.touchDragged(screenX, screenY, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        GameManager.mouseMoved(screenX,screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    @Override
    public void pause()
    {
        super.pause();
        GameManager.onPause();
        Debug("Paused");
    }
}
