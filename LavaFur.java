package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 3/2/2017.
 */
public class LavaFur extends GameObject{

    LavaFur(){

        initialcondition = true;
        condition = "firstcondition";
        circledistance = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        lavafurrand = 0;

        setBitmapNameRight("lavafurright");
        setBitmapNameLeft("lavafurleft");
        setBitmapNameJumpRight("lavafurjumpright");
        setType('a');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxcircle = new RectHitbox();
        rand = new Random();

        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld){



        setRectHitboxcirle((getBitmapWidth() * (circledistance + 1))/2,

                currentxWorld + getBitmapWidth()/2,
                currentyWorld + getBitmapHeight()/2);


    }

    void updateEnemy(float fps, float lavafurnextxPosition, float lavafurnextyPosition, float initiallavafurxPosition,
                     float initiallavafuryPosition){

        if(lavafurnextxPosition > initiallavafurxPosition){
            setFacing("RIGHT");
        }
        else if(lavafurnextxPosition < initiallavafurxPosition){
            setFacing("LEFT");
        }







        if(lavafurnextxPosition != 0 && lavafurnextyPosition != 0) {


            if(lavafurnextxPosition > initiallavafurxPosition){

                setxVelocity(fps * .006f);

                if(initiallavafurxPosition + getxVelocity() + getSavedxvelocity() + getBitmapWidth() > lavafurnextxPosition + getBitmapWidth()/2){
                    setxVelocity(fps * -.006f);
                    setSavedxvelocity(getxVelocity());
                    resetxVelocity();

                }

            }

            else if(lavafurnextxPosition < initiallavafurxPosition){

                setxVelocity(fps * -.006f);

                if(initiallavafurxPosition + getxVelocity() + getSavedxvelocity() < lavafurnextxPosition - getBitmapWidth()/2){
                    setxVelocity(fps * .006f);
                    setSavedxvelocity(getxVelocity());

                    resetxVelocity();
                }

            }

            if(lavafurnextyPosition > initiallavafuryPosition){

                setyVelocity(fps * .006f);

                if(initiallavafuryPosition + getyVelocity() + getSavedyvelocity() + getBitmapHeight() > lavafurnextyPosition + getBitmapHeight()/2){
                    setyVelocity(fps * -.006f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            }

            else if(lavafurnextyPosition < initiallavafuryPosition){

                setyVelocity(fps * -.006f);

                if(initiallavafuryPosition + getyVelocity() + getSavedyvelocity() < lavafurnextyPosition - getBitmapHeight()/2){
                    setyVelocity(fps * .006f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }



            }


        }



    }

}
