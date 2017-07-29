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


    public void keyUp(int keycode)
    {

    }


    public void keyTyped(char character)
    {

    }


    public void touchDown(int screenX, int screenY, int pointer, int button)
    {

    }


    public void touchUp(int screenX, int screenY, int pointer, int button)
    {
    }


    public void touchDragged(int screenX, int screenY, int pointer)
    {

    }


    public void mouseMoved(int screenX, int screenY)
    {

    }


    public void scrolled(int amount)
    {

    }


}
