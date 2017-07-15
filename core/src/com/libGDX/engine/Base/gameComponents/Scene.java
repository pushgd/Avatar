package com.libGDX.engine.Base.gameComponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Debug.Debug;

/**
 * Created by Dhande on 26-02-2017.
 */

public abstract class Scene
{
    int ID;

    abstract public void update();

    abstract public void pause();

    abstract public void paint(SpriteBatch spriteBatch);

    public void onExit()
    {
        Debug.print("Exiting scene with id " + ID);
    }


    public void keyDown(int keycode)
    {

    }


    public boolean keyUp(int keycode)
    {
        return false;
    }


    public boolean keyTyped(char character)
    {
        return false;
    }


    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }


    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }


    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }


    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }


    public boolean scrolled(int amount)
    {
        return false;
    }


}
