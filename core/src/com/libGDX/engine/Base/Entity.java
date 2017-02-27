package com.libGDX.engine.Base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dhande on 27-02-2017.
 */

public abstract class Entity
{

    private int baseId = 0;

    public int ID;
    private int UID;
    public Point position;
    public Point velocity;

    public Entity()
    {
        UID = baseId++;
    }

    public abstract void update();

    public abstract void paint(SpriteBatch spriteBatch);

    public int getUID()
    {
        return UID;
    }

}
