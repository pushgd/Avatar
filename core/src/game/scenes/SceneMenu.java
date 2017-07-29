package game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.render.Image;
import com.libGDX.engine.Base.gameComponents.Scene;

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
//        go.updateEntity();
        go2.updateEntity();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
//        Image.Debug.drawText(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 0);
        bf.draw(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 0);
//        go.paintEntity(spriteBatch);
        go2.paintEntity(spriteBatch);

    }

    @Override
    public void keyDown(int keycode)
    {
        if (keycode == Input.Keys.RIGHT)
        {
            go.position.x += 5;
        }
        if (keycode == Input.Keys.LEFT)
        {
            go.position.x -= 5;
        }
        if (keycode == Input.Keys.UP)
        {
            go.position.y -= 5;
        }
        if (keycode == Input.Keys.DOWN)
        {
            go.position.y += 5;
        }
    }

    @Override
    public void mouseMoved(int screenX, int screenY)
    {

        go2.position.x = screenX;
        go2.position.y = screenY;

    }
}
