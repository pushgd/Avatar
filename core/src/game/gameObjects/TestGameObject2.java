package game.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.Collision;
import com.libGDX.engine.Base.GameObject;
import com.libGDX.engine.Base.Vector2D;

import game.CollisionManager;

/**
 * Created by Dhande on 01-05-2017.
 */

public class TestGameObject2 extends GameObject
{
    Collision c;

    public TestGameObject2()
    {
        position = new Vector2D(0, 0);
        c = new Collision(this, 0, 0, 40, 40);
        CollisionManager.addCollision(c);

    }

    @Override
    public void update()
    {
        c.update();
    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        c.paint(spriteBatch);
    }

    @Override
    public void onCollision(Collision collision,Collision otherCollision)
    {

    }

    @Override
    public void onAnimationStateComplete(int animationID, int completedState)
    {

    }

    @Override
    public void onAnimationCycleComplete(int animationID, int completedState, int noOfCyclesRemaining)
    {

    }
}
