package com.libGDX.engine.Base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libGDX.engine.Utility.Rectangle;

/**
 * Created by Dhande on 28-04-2017.
 */

public class Collision
{
    private static int baseID;
    public final int ID;


    public final Entity owner;
    private float scale;
    public Rectangle worldRect;
    public Rectangle localRect;
    public Vector2D position;
    public int type;

    public Collision(Entity owner, float localX, float localY, float width, float height)
    {
        ID = baseID++;
        this.owner = owner;
        position = new Vector2D(localX, localY);
        localRect = new Rectangle();

        worldRect = new Rectangle();
        localRect.calculateBounds(position.x, position.y, width, height);
        worldRect.calculateBounds(owner.position.x + position.x, owner.position.y + position.y, width, height);
    }


    public void setScale(float scale)
    {
        this.scale = scale;
    }

    public float getScale()
    {
        return scale;
    }

    private int getID()
    {
        return ID;
    }

    public void update()
    {
        localRect.calculateBounds(0, 0, localRect.width, localRect.height);
        worldRect.calculateBounds(owner.position.x + position.x, owner.position.y + position.y, worldRect.width, worldRect.height);
    }

    public void update(float positionX, float positionY, float width, float height)
    {
        localRect.calculateBounds(0, 0, width, height);
        worldRect.calculateBounds(owner.position.x + positionX, owner.position.y + positionY, width, height);
    }

    public void paint(SpriteBatch batch)
    {
        worldRect.paint(batch);
    }

    public void paint(SpriteBatch batch, Color c)
    {
        worldRect.paint(batch, c);
    }


    public boolean isColliding(Collision other)
    {
        return worldRect.left <= other.worldRect.right && worldRect.right >= other.worldRect.left && worldRect.top <= other.worldRect.bottom && worldRect.bottom >= other.worldRect.top;
    }

    @Override
    public String toString()
    {
        return " collision {"+ID+" Owner "+owner.UID+" }";
    }
}
