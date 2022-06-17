package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 1/20/2017.
 */
public class TransparentChub extends GameObject {

    TransparentChub(){

        initialcondition = true;
        condition = "firstcondition";
        firefungihold = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        transparentchubrand = 0;

        setBitmapNameRight("transparentchubright");
        setBitmapNameLeft("transparentchubleft");
        setType('t');
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

    void updateEnemy(float fps, float transparentchubnextxPosition, float transparentchubnextyPosition, float initialtransparentchubxPosition,
                     float initialtransparentchubyPosition){

    if(transparentchubnextxPosition > initialtransparentchubxPosition){
        setFacing("RIGHT");
    }
        else if(transparentchubnextxPosition < initialtransparentchubxPosition){
        setFacing("LEFT");
    }







        if(transparentchubnextxPosition != 0 && transparentchubnextyPosition != 0) {


            if(transparentchubnextxPosition > initialtransparentchubxPosition){

                setxVelocity(fps * .004f);

                if(initialtransparentchubxPosition + getxVelocity() + getSavedxvelocity() + getBitmapWidth() > transparentchubnextxPosition + getBitmapWidth()/2){
                    setxVelocity(fps * -.004f);
                    setSavedxvelocity(getxVelocity());
                    resetxVelocity();

                }

            }

            else if(transparentchubnextxPosition < initialtransparentchubxPosition){

                setxVelocity(fps * -.004f);

                if(initialtransparentchubxPosition + getxVelocity() + getSavedxvelocity() < transparentchubnextxPosition - getBitmapWidth()/2){
                    setxVelocity(fps * .004f);
                    setSavedxvelocity(getxVelocity());

                    resetxVelocity();
                }

            }

            if(transparentchubnextyPosition > initialtransparentchubyPosition){

                setyVelocity(fps * .004f);

                if(initialtransparentchubyPosition + getyVelocity() + getSavedyvelocity() + getBitmapHeight() > transparentchubnextyPosition + getBitmapHeight()/2){
                    setyVelocity(fps * -.004f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            }

            else if(transparentchubnextyPosition < initialtransparentchubyPosition){

                setyVelocity(fps * -.004f);

                if(initialtransparentchubyPosition + getyVelocity() + getSavedyvelocity() < transparentchubnextyPosition - getBitmapHeight()/2){
                    setyVelocity(fps * .004f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }



            }


        }



    }


}
