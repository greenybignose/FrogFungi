package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 3/2/2017.
 */
public class GhostSpinder extends GameObject {

    GhostSpinder(){

        initialcondition = true;
        changefrogfungionetime = true;
        currentxWorld = 0;
        currentyWorld = 0;
        setType('G');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxtop = new RectHitbox();
        rectHitboxright = new RectHitbox();
        rectHitboxbottom = new RectHitbox();
        rectHitboxleft = new RectHitbox();


        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld){


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
                currentxWorld );

        setRectHitboxleft(currentyWorld,
                currentxWorld + getBitmapWidth()  * .03f,
                currentyWorld + getBitmapHeight(),
                currentxWorld);



    }

    void updateEnemy(float fps, float currentfrogxPosition, float currentfrogyPosition, float currentghostspinderxPosition,
                     float currentghostspinderyPosition){




        if(currentfrogxPosition > currentghostspinderxPosition){

            setxVelocity(fps * .00002f);

            if(currentghostspinderxPosition + getxVelocity() > currentfrogxPosition){
                setxVelocity(fps * -.00002f);
                setSavedxvelocity(getxVelocity());
                resetxVelocity();

            }

        }

        else if(currentfrogxPosition < currentghostspinderxPosition){

            setxVelocity(fps * -.00002f);

            if(currentghostspinderxPosition + getxVelocity() < currentfrogxPosition){
                setxVelocity(fps * .00002f);
                setSavedxvelocity(getxVelocity());

                resetxVelocity();
            }

        }

        if(currentfrogyPosition > currentghostspinderyPosition){

            setyVelocity(fps * .00002f);

            if(currentghostspinderyPosition + getyVelocity()> currentfrogyPosition){
                setyVelocity(fps * -.00002f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }


        }

        else if(currentfrogyPosition < currentghostspinderyPosition){

            setyVelocity(fps * -.00002f);

            if(currentghostspinderyPosition + getyVelocity() < currentfrogyPosition){
                setyVelocity(fps * .00002f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }



        }



    }



}
