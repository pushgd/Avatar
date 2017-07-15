package game;

import com.libGDX.engine.Base.collision.Collision;

import java.util.ArrayList;

/**
 * Created by Dhande on 01-05-2017.
 */

public class CollisionManager
{
    private CollisionManager()
    {

    }


    private static ArrayList<Collision> collisionList;

    public static void init()
    {
        collisionList = new ArrayList<Collision>();

    }

    public static void detectCollision()
    {


        for (int i = 0; i < collisionList.size(); i++)
        {
            Collision c1 = collisionList.get(i);
            for (int j = i; j < collisionList.size(); j++)
            {
                Collision c2 = collisionList.get(j);

                if (c2.owner.UID == c1.owner.UID)
                {
                    continue;
                }
                if (c1.isColliding(c2))
                {
                    c1.owner.onCollision(c1,c2);
                    c2.owner.onCollision(c2,c1);

                }

            }
        }

    }

    public static void addCollision(Collision collision)
    {
        collisionList.add(collision);
    }

}
