package com.libGDX.engine.Base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dhande on 27-02-2017.
 */

public abstract class Entity implements AnimationEventListener
{

    private static int baseId = 0;

    public int ID;
    public final int UID;
    public Vector2D position;
    public Vector2D velocity;

    public Entity()
    {
        UID = baseId++;
    }


    public final void updateEntity()
    {
        update();
    }

    public final void paintEntity(SpriteBatch spriteBatch)
    {
        paint(spriteBatch);
    }

    public abstract void update();

    public abstract void paint(SpriteBatch spriteBatch);

    public abstract void onCollision(Collision collision,Collision otherCollision);



}
