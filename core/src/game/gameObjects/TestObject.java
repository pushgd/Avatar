package game.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.libGDX.engine.Base.Animation;
import com.libGDX.engine.Base.GameObject;
import com.libGDX.engine.Base.Vector2D;
import com.libGDX.engine.Debug.Debug;

/**
 * Created by Dhande on 01-03-2017.
 */

public class TestObject extends GameObject
{


    public TestObject()
    {
        animation = new Animation(this);
        animation.addAnimation(new TextureAtlas("walk.atlas"), 700);
        animation.addAnimation(new TextureAtlas("melee.atlas"), 700);
        animation.setState(0, 1, true);
        position = new Vector2D(400, 0);
    }


    @Override
    public void update()
    {
//        Debug.print("width " + animation.getWidth());
        animation.update();
    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        animation.paint(spriteBatch, position.x, position.y);
    }


    @Override
    public void onAnimationStateComplete(int animationID, int completedState)
    {
        Debug.print("completed animation " + completedState);
        if (completedState == 1)
        {
            animation.setState(0, 2, true);
        }
        else
        {
            animation.setState(1, 3, true);
        }
    }

    @Override
    public void onAnimationCycleComplete(int animationID, int completedState, int noOfCyclesRemaining)
    {
        Debug.print("completed animation " + completedState + "  remaining cycles " + noOfCyclesRemaining);
    }
}
