package game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Renderer;
import com.libGDX.engine.Base.Scene;
import com.libGDX.engine.Debug.Debug;


/**
 * Created by Dhande on 26-02-2017.
 */

public class GameManager
{
    public static Scene currentScene;


    public static void onGameStart()
    {
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
        currentScene.update();
//        Debug.print("Update");
    }

    static int angle = 0;

    public static void paint(SpriteBatch spriteBatch)
    {
        Renderer.drawLine(spriteBatch,400,240,800,480, 3,new Color(255/255f,100/255f,0,255));
        currentScene.paint(spriteBatch);

    }


    public static void keyDown(int keyCode)
    {
        currentScene.keyDown(keyCode);
    }

    public static void keyUp(int keyCode)
    {
        currentScene.keyUp(keyCode);
    }

    public static void touchDown(int x, int y, int pointerId, int mouseButton)
    {
        currentScene.touchDown(x, y, pointerId, mouseButton);
    }

    public static void touchUp(int x, int y, int pointerId, int mouseButton)
    {
        currentScene.touchUp(x, y, pointerId, mouseButton);
    }

    public static void touchDragged(int x, int y, int pointerId)
    {

        currentScene.touchDragged(x, y, pointerId);
    }

    public static void onPause()
    {
        currentScene.pause();
    }

}
