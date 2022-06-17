package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 1/20/2017.
 */
public class SuckerBeeGrav extends GameObject {

    SuckerBeeGrav(){

        initialcondition = true;
        condition = "firstcondition";

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        suckerbeegravrand = 0;

        setBitmapNameRight("suckerbeegravright");
        setBitmapNameLeft("suckerbeegravleft");
        setType('k');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxtop = new RectHitbox();
        rectHitboxright = new RectHitbox();
        rectHitboxbottom = new RectHitbox();
        rectHitboxleft = new RectHitbox();
        rand = new Random();

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

    void updateEnemy(float fps, float suckerbeegravnextxPosition, float suckerbeegravnextyPosition, float initialsuckerbeegravxPosition,
                     float initialsuckerbeegravyPosition){

    if(suckerbeegravnextxPosition > initialsuckerbeegravxPosition){
        setFacing("RIGHT");
    }
        else if(suckerbeegravnextxPosition < initialsuckerbeegravxPosition){
        setFacing("LEFT");
    }







        if(suckerbeegravnextxPosition != 0 && suckerbeegravnextyPosition != 0) {


            if(suckerbeegravnextxPosition > initialsuckerbeegravxPosition){

                setxVelocity(fps * .002f);

                if(initialsuckerbeegravxPosition + getxVelocity() + getSavedxvelocity() + getBitmapWidth() > suckerbeegravnextxPosition + getBitmapWidth()/2){
                    setxVelocity(fps * -.002f);
                    setSavedxvelocity(getxVelocity());
                    resetxVelocity();

                }

            }

            else if(suckerbeegravnextxPosition < initialsuckerbeegravxPosition){

                setxVelocity(fps * -.002f);

                if(initialsuckerbeegravxPosition + getxVelocity() + getSavedxvelocity() < suckerbeegravnextxPosition - getBitmapWidth()/2){
                    setxVelocity(fps * .002f);
                    setSavedxvelocity(getxVelocity());

                    resetxVelocity();
                }

            }

            if(suckerbeegravnextyPosition > initialsuckerbeegravyPosition){

                setyVelocity(fps * .002f);

                if(initialsuckerbeegravyPosition + getyVelocity() + getSavedyvelocity() + getBitmapHeight() > suckerbeegravnextyPosition + getBitmapHeight()/2){
                    setyVelocity(fps * -.002f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            }

            else if(suckerbeegravnextyPosition < initialsuckerbeegravyPosition){

                setyVelocity(fps * -.002f);

                if(initialsuckerbeegravyPosition + getyVelocity() + getSavedyvelocity() < suckerbeegravnextyPosition - getBitmapHeight()/2){
                    setyVelocity(fps * .002f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }



            }


        }



    }


}
