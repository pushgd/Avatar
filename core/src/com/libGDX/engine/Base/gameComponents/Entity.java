package com.libGDX.engine.Base.gameComponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Base.collision.Collision;

/**
 * Created by Dhande on 27-02-2017.
 */

public abstract class Entity implements com.libGDX.engine.Base.aniamtion.AnimationEventListener
{

    private static int baseId = 0;

    public int ID;
    public final int UID;
    public com.libGDX.engine.Utility.Vector2D position;
    public com.libGDX.engine.Utility.Vector2D velocity;

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

    public abstract void onCollision(Collision collision, Collision otherCollision);


}
