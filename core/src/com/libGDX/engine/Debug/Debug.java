package com.libGDX.engine.Debug;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dhande on 26-02-2017.
 */

public class Debug
{
    public static void print(String s)
    {

        Gdx.app.debug("Engine",s);
    }

}
