package game;

import com.libGDX.engine.Base.Scene;

/**
 * Created by Dhande on 26-02-2017.
 */

public class Game
{
    public static Scene currentScene;


    public static void changeScene(int ID)
    {
        Scene newScene = null;
        currentScene.onExit();
        currentScene = null;

    }


    private Game()
    {

    }


}
