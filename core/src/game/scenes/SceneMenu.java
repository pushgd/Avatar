package game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libGDX.engine.Base.gameComponents.Scene;
import com.libGDX.engine.Base.render.Bitmap;

import game.GameManager;
import game.gameObjects.TestGameObject2;
import game.gameObjects.TestObject;

/**
 * Created by Dhande on 26-02-2017.
 */

public class SceneMenu extends Scene
{

    BitmapFont bf;
    TestGameObject2 go2;
    FPSLogger fps;
Bitmap tileSet;
    TextureRegion t1;
   TextureRegion tiles[][];
    public SceneMenu()
    {
        bf = new BitmapFont();
        bf.setColor(Color.CORAL);
        go2 = new TestGameObject2();
        tileSet = new Bitmap("tileSet.png");
        t1 = new TextureRegion(tileSet.getTexture());
//        t1.flip(false,true);
        tiles =t1.split(32,32);
        tiles[12][9].flip(false,true);
    }

    @Override
    public void update()
    {
        go2.updateEntity();
    }

    @Override
    public void pause()
    {

    }
int i=0;int j=0;
int counter =0;
    @Override
    public void paint(SpriteBatch spriteBatch)
    {


        Bitmap.Debug.drawText(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 0);

        bf.draw(spriteBatch, "FPS " + Gdx.graphics.getFramesPerSecond(), 0, 0);

        go2.paintEntity(spriteBatch);
//        Bitmap.draw(spriteBatch,tileSet, 0,0);
counter++;
if(counter>60)
{
    counter=0;
    i++;
    if(i>tiles.length)
    {
        i=0;
        {

            j++;
            if(j>tiles[i].length)
            {
                j=0;
            }
        }

    }

}

        spriteBatch.draw(tiles[12][9],100,100);

    }

    @Override
    public void keyDown(int keycode)
    {

    }

    @Override
    public void mouseMoved(int screenX, int screenY)
    {

        go2.position.x = screenX;
        go2.position.y = screenY;

    }
}
