package com.libGDX.engine.Base.aniamtion;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

/**
 * Created by Dhande on 20-03-2017.
 */

public class SpriteAnimation extends Animation
{
    ArrayList<int[]> time;
    ArrayList<Sprite[]> sprites;
    int currentFrame;
    long previousTime;

    public SpriteAnimation(com.libGDX.engine.Base.aniamtion.AnimationEventListener listener)
    {
        this(1, listener);
    }

    public SpriteAnimation(int animationID, com.libGDX.engine.Base.aniamtion.AnimationEventListener listener)
    {
        super(animationID, listener);
        time = new ArrayList<int[]>();
        sprites = new ArrayList<Sprite[]>();
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
            t.flip(false, true);
            frameTime[i] = timeMS / size;
        }
        sprites.add(temp);
        time.add(frameTime);

    }

    @Override
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
                listener.onAnimationCycleComplete(animationID, currentState, cyclesToComplete);
                if (cyclesToComplete == 0)
                {
                    listener.onAnimationStateComplete(animationID, currentState);
                }


            }


        }

    }

    @Override
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

    @Override
    public void paint(SpriteBatch spriteBatch, float x, float y)
    {
        Sprite temp = sprites.get(currentState)[currentFrame];
        temp.setOrigin(0, 0);
        temp.setPosition(x, y);

        temp.draw(spriteBatch);
    }

    @Override
    public float getWidth()
    {
        return sprites.get(currentState)[currentFrame].getWidth();
    }

    @Override
    public float getHeight()
    {
        return sprites.get(currentState)[currentFrame].getHeight();
    }
}
