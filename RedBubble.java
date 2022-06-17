package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 2/8/2017.
 */
public class RedBubble extends GameObject {

    RedBubble() {
        initialcondition = true;
        condition = "firstcondition";

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        valuehold = 0;

        setBitmapNameRight("redbubbleright");
        setBitmapNameLeft("redbubbleleft");
        setBitmapNameJumpRight("redbubblejumpright");
       

        setType('e');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxtop = new RectHitbox();
        rectHitboxright = new RectHitbox();
        rectHitboxbottom = new RectHitbox();
        rectHitboxleft = new RectHitbox();


        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld) {


        setRectHitboxtop(currentyWorld,
                currentxWorld + getBitmapWidth(),
                currentyWorld + getBitmapHeight() * .03f,
                currentxWorld);

        setRectHitboxright(currentyWorld,
                currentxWorld + getBitmapWidth(),
                currentyWorld + getBitmapHeight(),
                currentxWorld + getBitmapWidth() * .97f);

        setRectHitboxbottom(currentyWorld + getBitmapHeight() * .97f,
                currentxWorld + getBitmapWidth(),
                currentyWorld + getBitmapHeight(),
                currentxWorld);

        setRectHitboxleft(currentyWorld,
                currentxWorld + getBitmapWidth() * .03f,
                currentyWorld + getBitmapHeight(),
                currentxWorld);


    }

    void updateEnemy(float fps, float redbubblenextyPosition, float initialredbubbleyPosition, float empty,
                     float emptytwo) {



        if(initialredbubbleyPosition > redbubblenextyPosition) {


            setyVelocity(fps * -.0008f);

        }
        
        if(initialredbubbleyPosition <= redbubblenextyPosition){

            if(condition.matches("secondcondition")){
                nextyPosition = 0;
                condition = "thirdcondition";
            }
            else if(condition.matches("thirdcondition")){
                nextyPosition = 0;
                condition = "deadcondition";
                resetyVelocity();

            }

        }


    }
}