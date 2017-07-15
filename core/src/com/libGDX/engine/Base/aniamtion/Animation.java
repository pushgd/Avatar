package com.libGDX.engine.Base.aniamtion;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dhande on 09/07/2017.
 */

public abstract class Animation
{

    public final int animationID;
    public int currentState;
    AnimationEventListener listener;
    int cyclesToComplete;


    public Animation(int animationID, AnimationEventListener listener)
    {
        this.animationID = animationID;
        this.listener = listener;
        cyclesToComplete = 1;
    }

    public abstract void update();

    public abstract void paint(SpriteBatch spriteBatch, float x, float y);

    public abstract void setState(int stateToState, int cycles, boolean force);

    public abstract float getWidth();

    public abstract float getHeight();


}
