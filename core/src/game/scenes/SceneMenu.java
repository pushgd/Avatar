package game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Scene;

import game.gameObjects.TestObject;

/**
 * Created by Dhande on 26-02-2017.
 */

public class SceneMenu extends Scene
{

    BitmapFont bf;
    TestObject go;

    public SceneMenu()
    {
        bf = new BitmapFont();
        bf.setColor(Color.CORAL);
        go = new TestObject();

    }

    @Override
    public void update()
    {
        go.update();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        go.paint(spriteBatch);
        bf.draw(spriteBatch, "From Menu Scene " + Gdx.graphics.getWidth() + " * " + Gdx.graphics.getHeight(), 400, 200);
    }


}
