package com.libGDX.engine.Base.aniamtion;

/**
 * Created by Dhande on 17-04-2017.
 */

public interface AnimationEventListener
{
    public void onAnimationStateComplete(int animationID,int completedState);
    public void onAnimationCycleComplete(int animationID,int completedState,int noOfCyclesRemaining);
    public void onAnimationEvent(float eventNumber,float animationState);
}
