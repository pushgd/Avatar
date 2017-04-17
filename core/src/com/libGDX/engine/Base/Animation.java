package com.libGDX.engine.Base;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

/**
 * Created by Dhande on 20-03-2017.
 */

public class Animation
{
    ArrayList<int[]> time;
    ArrayList<Sprite[]> sprites;
    int currentFrame, currentState, cyclesToComplete;
    private int animationID;
    long previousTime;
    AnimationEventListener listener;

    public Animation(AnimationEventListener listener)
    {
        time = new ArrayList<int[]>();
        sprites = new ArrayList<Sprite[]>();
        this.listener = listener;
        cyclesToComplete = 1;
        animationID = 1;
    }

    public Animation(int animationID, AnimationEventListener listener)
    {
        time = new ArrayList<int[]>();
        sprites = new ArrayList<Sprite[]>();
        this.listener = listener;
        cyclesToComplete = 1;
        this.animationID = animationID;
    }


    public void addAnimation(TextureAtlas atlas, int timeMS)
    {
        int size = atlas.getRegions().size;
        Sprite[] temp = new Sprite[size];
        int[] frameTime = new int[size];
        for (int i = 0; i < size; i++)
        {
            Sprite t = new Sprite(atlas.findRegion((i + 1) + ""));
            temp[i] = t;
            frameTime[i] = timeMS / size;
        }
        sprites.add(temp);
        time.add(frameTime);

    }

    public void update()
    {

        if (cyclesToComplete == 0)
        {
            return;

        }

        long currentTime = TimeUtils.millis();
        int frameTime = time.get(currentState)[currentFrame];
        if (currentTime - previousTime >= frameTime)
        {

            currentFrame++;
            previousTime = TimeUtils.millis();

            if (currentFrame >= sprites.get(currentState).length)
            {
                currentFrame = sprites.get(currentState).length - 1;
                cyclesToComplete--;
                currentFrame = 0;
                listener.onAnimationCycleComplete(animationID,currentState,cyclesToComplete);
                if (cyclesToComplete == 0)
                {
                    listener.onAnimationStateComplete(animationID,currentState);
                }


            }


        }

    }

    public void setState(int stateToState, int cycles, boolean force)
    {
        if (force || currentState != stateToState)
        {
            currentState = stateToState;
            cyclesToComplete = cycles;
            currentFrame = 0;
            previousTime = TimeUtils.millis();
        }

    }

    public void paint(SpriteBatch spriteBatch, float x, float y)
    {
        Sprite temp = sprites.get(currentState)[currentFrame];
        temp.setPosition(x, y);
        temp.draw(spriteBatch);
    }

    public float getWidth()
    {
        return sprites.get(currentState)[currentFrame].getWidth();
    }

    public float getHeight()
    {
        return sprites.get(currentState)[currentFrame].getHeight();
    }
}
