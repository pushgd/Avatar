package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.render.Bitmap;
import com.libGDX.engine.Base.gameComponents.Scene;


/**
 * Created by Dhande on 26-02-2017.
 */

public class GameManager
{
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static Scene currentScene;


    public static void onGameStart()
    {
        CollisionManager.init();
        Bitmap.Debug.init();
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

    }


    public static void paint(SpriteBatch spriteBatch)
    {


        if (currentScene != null)
        {
            currentScene.paint(spriteBatch);
        }
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
            currentScene.mouseMoved(x, y);
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
