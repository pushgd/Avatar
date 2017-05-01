package game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Scene;
import com.libGDX.engine.Debug.Debug;

import game.gameObjects.TestGameObject2;
import game.gameObjects.TestObject;

/**
 * Created by Dhande on 26-02-2017.
 */

public class SceneMenu extends Scene
{

    BitmapFont bf;
    TestObject go;
    TestGameObject2 go2;
FPSLogger fps;
    public SceneMenu()
    {
        bf = new BitmapFont();
        bf.setColor(Color.CORAL);
        go = new TestObject();
        go2 = new TestGameObject2();

    }

    @Override
    public void update()
    {
        go.updateEntity();
        go2.updateEntity();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        go.paintEntity(spriteBatch);
        go2.paint(spriteBatch);
        bf.draw(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 480);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {

        go2.position.x = screenX;
        go2.position.y = screenY;

        return super.mouseMoved(screenX, screenY);
    }
}
