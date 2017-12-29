package com.libGDX.engine.Debug;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dhande on 26-02-2017.
 */

public class Debug
{
    public static void print(String s)
    {

        String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

        Gdx.app.debug("Engine .("+className +".java:"+ lineNumber+") "  ,s);
    }

}
