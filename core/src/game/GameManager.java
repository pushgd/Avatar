package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Image;
import com.libGDX.engine.Base.Scene;


/**
 * Created by Dhande on 26-02-2017.
 */

public class GameManager
{
    public static Scene currentScene;


    public static void onGameStart()
    {
        CollisionManager.init();
        currentScene = new game.scenes.SceneMenu();
    }


    public static void changeScene(int ID)
    {
        Scene newScene = null;
        currentScene.onExit();
        currentScene = null;
    }

    //this class is singleton
    private GameManager()
    {

    }

    public static void update()
    {
        if (currentScene != null)
        {
            currentScene.update();
        }
        CollisionManager.detectCollision();
//        Debug.print("Update");
    }

    static int angle = 0;
    static float scale = 1;
    static int direction = 1;

    public static void paint(SpriteBatch spriteBatch)
    {


        if (currentScene != null)
        {
            currentScene.paint(spriteBatch);
        }
        Image.Debug.drawText(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 480);
    }


    public static void keyDown(int keyCode)
    {
        if (currentScene != null)
        {
            currentScene.keyDown(keyCode);
        }
    }

    public static void keyUp(int keyCode)
    {

        if (currentScene != null)
        {
            currentScene.keyUp(keyCode);
        }
    }

    public static void touchDown(int x, int y, int pointerId, int mouseButton)
    {
        if (currentScene != null)
        {
            currentScene.touchDown(x, y, pointerId, mouseButton);
        }
    }

    public static void touchUp(int x, int y, int pointerId, int mouseButton)
    {
        if (currentScene != null)
        {
            currentScene.touchUp(x, y, pointerId, mouseButton);
        }
    }

    public static void touchDragged(int x, int y, int pointerId)
    {
        if (currentScene != null)
        {
            currentScene.touchDragged(x, y, pointerId);
        }
    }

    public static void mouseMoved(int x, int y)
    {
        if (currentScene != null)
        {
            currentScene.mouseMoved(x, 480 - y);
        }
    }

    public static void onPause()
    {
        if (currentScene != null)
        {
            currentScene.pause();
        }
    }

}
