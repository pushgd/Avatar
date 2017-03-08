package game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Scene;

/**
 * Created by Dhande on 26-02-2017.
 */

public class SceneMenu extends Scene
{

    BitmapFont bf;

    public SceneMenu()
    {
        bf = new BitmapFont();
        bf.setColor(Color.CORAL);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        bf.draw(spriteBatch,"From Menu Scene "+ Gdx.graphics.getWidth()+" * "+Gdx.graphics.getHeight(),400,200);
    }




}
