package com.verticesstudio.frogfungi;

import android.content.Context;

import java.util.Random;

/**
 * Created by kucrut on 1/15/2016.
 */


public class FrogFungiPlayer extends GameObject {

    float BeginX;
    float BeginY;


    FrogFungiPlayer(float BeginX, float BeginY, float backgroundXResolution, float backgroundYResolution) {
        this.BeginX = BeginX;
        this.BeginY = BeginY;
        worldLocation = new Vector2Point5D();
        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        setinitialfrogposx = false;
        setinitialfrogposy = false;
        changefrogfungionetime = true;
        condition = "firstcondition";
        rand = new Random();

        final float HEIGHT = 1;
        final float WIDTH = 1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType('r');
        // Standing still to start with
        setxVelocity(0);
        setyVelocity(0);
        setFacing("RIGHT");
        setChangeFrogPosition(false);

        setBitmapNameRight("frogfungiright");
        setBitmapNameLeft("frogfungileft");
        setBitmapNameJumpRight("frogfungijumpright");
        setBitmapNameJumpLeft("frogfungijumpleft");

        setbackgroundxResolution(backgroundXResolution);
        setbackgroundyResolution(backgroundYResolution);
        oldTime = 0;


        setWorldLocation(0, 0);

        rectHitboxtop = new RectHitbox();
        rectHitboxright = new RectHitbox();
        rectHitboxbottom = new RectHitbox();
        rectHitboxleft = new RectHitbox();
        rectHitboxdclick = new RectHitbox();
        rectHitboxcircle = new RectHitbox();


    }

    void update(long fps) {



   

            int currentWorldxLocation = (int)(-(BeginX) + (getWorldLocation().x + getbackgroundxResolution() / 2));
            int currentWorldyLocation = (int)(-(BeginY) + (getWorldLocation().y + getbackgroundyResolution()));


            if((currentWorldxLocation != getnextxPosition()) && (getnextxPosition() != 0)) {
                if ((currentWorldyLocation != getnextyPosition()) && (getnextyPosition() != 0)) {


                    if(changefrogfungionetime == true){
                        resetSavedxvelocity();
                        resetSavedyvelocity();
                        resetxVelocity();
                        resetyVelocity();

                        changefrogfungionetime = false;


                    }



                    if ((getnextxPosition() < currentWorldxLocation) &&
                            (getnextyPosition() < currentWorldyLocation)) {

                        setxVelocity((float) (-fps * (currentWorldxLocation - getnextxPosition()) * .00008));



                        if(getxVelocity() + getSavedxvelocity() < -(currentWorldxLocation - getnextxPosition()) + getBitmapWidth()/2){
                            setxVelocity(fps * (currentWorldxLocation - getnextxPosition()) * .00008f);
                            setSavedxvelocity(getxVelocity());
                            resetxVelocity();

                        }




                        if (getxVelocity() + getSavedxvelocity() > (-(currentWorldxLocation - getnextxPosition()) + (getBitmapWidth()/2)) / 2) {

                            setyVelocity((float) ((-fps * (currentWorldyLocation - getnextyPosition()) * .00008) -
                                    (fps * .00005)));




                        } else if (getxVelocity() + getSavedxvelocity() < (-(currentWorldxLocation - getnextxPosition()) + (getBitmapWidth()/2)) / 2) {

                            setyVelocity((float) ((-fps * (currentWorldyLocation - getnextyPosition()) * .00008) -
                                    (fps * .00002)));

                            if(getyVelocity() + getSavedyvelocity() < -(currentWorldyLocation - getnextyPosition()) ){
                                setyVelocity((float)((fps * (currentWorldyLocation - getnextyPosition()) * .00008f) + (fps * .00002)));
                                setSavedyvelocity(getyVelocity());

                                resetyVelocity();
                            }




                        }









                    } else if ((getnextxPosition() > currentWorldxLocation) &&
                            (getnextyPosition() < currentWorldyLocation)) {


                        setxVelocity((float)(fps * (getnextxPosition() - currentWorldxLocation) * .00008));


                        if(getxVelocity() + getSavedxvelocity() > (getnextxPosition() - currentWorldxLocation) - getBitmapWidth()/2 ){

                            setxVelocity(-fps * (getnextxPosition() - currentWorldxLocation) * .00008f);
                            setSavedxvelocity(getxVelocity());
                            resetxVelocity();

                         }






                        if(getxVelocity() + getSavedxvelocity() < ((getnextxPosition() - currentWorldxLocation) - (getBitmapWidth()/2))/2) {

                            setyVelocity((float) ((-fps * (currentWorldyLocation - getnextyPosition()) * .00008)
                                    -  (fps * .00005) ));




                        }

                        else if(getxVelocity() + getSavedxvelocity() > ((getnextxPosition() - currentWorldxLocation) - (getBitmapWidth()/2))/2) {

                            setyVelocity((float) ((-fps * (currentWorldyLocation - getnextyPosition()) * .00008)
                                    - (fps * .00002)  ));


                            if(getyVelocity() + getSavedyvelocity() < -(currentWorldyLocation - getnextyPosition())){
                                setyVelocity((fps * (currentWorldyLocation - getnextyPosition()) * .00008f) + (fps * .00002f));
                                setSavedyvelocity(getyVelocity());

                                resetyVelocity();
                            }







                        }
















                    }


                    else if ((getnextxPosition() > currentWorldxLocation) &&
                            (getnextyPosition() > currentWorldyLocation)) {


                        setxVelocity((float)(fps * (getnextxPosition() - currentWorldxLocation) * .00008));


                        if(getxVelocity() + getSavedxvelocity() > (getnextxPosition() - currentWorldxLocation) ){

                            setxVelocity(-fps * (getnextxPosition() - currentWorldxLocation) * .00008f);
                            setSavedxvelocity(getxVelocity());
                            resetxVelocity();

                        }






                        if(getxVelocity() + getSavedxvelocity() < (getnextxPosition() - currentWorldxLocation)/2) {

                            setyVelocity((float) ((fps * (getnextyPosition() - currentWorldyLocation) * .00008) -
                                    (fps * .0002)));




                        }

                        else if(getxVelocity() + getSavedxvelocity() > (getnextxPosition() - currentWorldxLocation)/2) {

                            setyVelocity((float) ((fps * (getnextyPosition() - currentWorldyLocation) * .00008) +
                                    (fps * .0002)));




                            if(getyVelocity() + getSavedyvelocity() > (getnextyPosition() - currentWorldyLocation) ){
                                setyVelocity((-fps * (currentWorldyLocation - getnextyPosition()) * .00008f) - (fps * .0002f));
                                setSavedyvelocity(getyVelocity());

                                resetyVelocity();
                            }









                        }





                    }


                    else if ((getnextxPosition() < currentWorldxLocation) &&
                            (getnextyPosition() > currentWorldyLocation)) {


                        setxVelocity(-fps * (currentWorldxLocation - getnextxPosition()) * .00008f);



                        if(getxVelocity() + getSavedxvelocity() < -(currentWorldxLocation - getnextxPosition())){
                            setxVelocity(fps * (currentWorldxLocation - getnextxPosition()) * .00008f);
                            setSavedxvelocity(getxVelocity());
                            resetxVelocity();

                        }





                        if(getxVelocity() + getSavedxvelocity() > -(currentWorldxLocation - getnextxPosition())/2) {

                            setyVelocity((float) ((fps * (getnextyPosition() - currentWorldyLocation) * .00008) -
                                    (fps * .0002)));



                        }

                        else if(getxVelocity() + getSavedxvelocity() < -(currentWorldxLocation - getnextxPosition())/2) {

                            setyVelocity((float) ((fps * (getnextyPosition() - currentWorldyLocation) * .00008) +
                                    (fps * .0002)));



                            if(getyVelocity() + getSavedyvelocity() > (getnextyPosition() - currentWorldyLocation) ){
                                setyVelocity((-fps * (currentWorldyLocation - getnextyPosition()) * .00008f) - (fps * .0002f));
                                setSavedyvelocity(getyVelocity());

                                resetyVelocity();
                            }









                        }














                    }
                }
            }
        }

    void setnextxPosition(int nextxPosition){
        this.nextxPosition = nextxPosition;
    }

    void setnextyPosition(int nextyPosition){
        this.nextyPosition = nextyPosition;
    }

    int getnextxPosition(){
        return nextxPosition;
    }

    int getnextyPosition(){
        return nextyPosition;
    }

    void setHitBoxPosition(float currentxWorldPos, float currentyWorldPos) {


        setRectHitboxtop(currentyWorldPos,
                currentxWorldPos + getBitmapWidth(),
                currentyWorldPos + getBitmapHeight() * .03f,
                currentxWorldPos);

        setRectHitboxright(currentyWorldPos,
                currentxWorldPos + getBitmapWidth(),
                currentyWorldPos + getBitmapHeight(),
                currentxWorldPos + getBitmapWidth() * .97f);

        setRectHitboxbottom(currentyWorldPos + getBitmapHeight() * .97f,
                currentxWorldPos + getBitmapWidth(),
                currentyWorldPos + getBitmapHeight(),
                currentxWorldPos );

        setRectHitboxleft(currentyWorldPos,
                currentxWorldPos + getBitmapWidth()  * .03f,
                currentyWorldPos + getBitmapHeight(),
                currentxWorldPos);

        setRectHitboxdclick(currentyWorldPos,
                currentxWorldPos + getBitmapWidth(),
                currentyWorldPos + getBitmapHeight(),
                currentxWorldPos);

        setRectHitboxcirle(getBitmapWidth()/2,

                currentxWorldPos + getBitmapWidth()/2,
                currentyWorldPos + getBitmapHeight()/2);


    }

    }




