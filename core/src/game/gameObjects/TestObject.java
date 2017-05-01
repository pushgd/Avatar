package game.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.libGDX.engine.Base.Animation;
import com.libGDX.engine.Base.Collision;
import com.libGDX.engine.Base.GameObject;
import com.libGDX.engine.Base.Vector2D;
import com.libGDX.engine.Debug.Debug;

import game.CollisionManager;

/**
 * Created by Dhande on 01-03-2017.
 */

public class TestObject extends GameObject
{

    Collision collision, collision2;

    public TestObject()
    {
        animation = new Animation(this);
        animation.addAnimation(new TextureAtlas("walk.atlas"), 700);
        animation.addAnimation(new TextureAtlas("melee.atlas"), 700);
        animation.setState(0, 1, true);
        position = new Vector2D(400, 0);
        collision = new Collision(this, 0, 0, 40, 40);
        collision.type = 1;
        collision2 = new Collision(this, animation.getWidth() , animation.getHeight() / 2, 40, 40);
        collision2.type = 2;
        CollisionManager.addCollision(collision);
        CollisionManager.addCollision(collision2);
    }


    @Override
    public void update()
    {
//        Debug.print("width " + animation.getWidth());
        animation.update();
        collision.update(collision.position.x, collision.position.y, animation.getWidth(), animation.getHeight());
        collision2.update(collision2.position.x, collision2.position.y, animation.getWidth() / 2, animation.getHeight() / 2);

    }

    @Override
    public void paint(SpriteBatch spriteBatch)
    {
        animation.paint(spriteBatch, position.x, position.y);
        collision.paint(spriteBatch);
        collision2.paint(spriteBatch, Color.PINK);
    }

    @Override
    public void onCollision(Collision collision,Collision otherCollision)
    {

    }


    @Override
    public void onAnimationStateComplete(int animationID, int completedState)
    {
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

    }
}
