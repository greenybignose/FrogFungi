package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/4/2016.
 */
public class BigBeeGrav extends GameObject{

    BigBeeGrav(){

        initialcondition = true;
        condition = "initialcondition";

        changefrogfungionetime = true;
        currentxWorld = 0;
        currentyWorld = 0;
        firstconditionposx = 0;
        firstconditionposy = 0;
        secondconditionposx = 0;
        secondconditionposy = 0;
        thirdconditionposx = 0;
        thirdconditionposy = 0;


        setBitmapNameRight("bigbeegravright");
        setBitmapNameLeft("bigbeegravleft");
        setType('i');
        setFacing("RIGHT");
        setVisible(true);

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

    void updateEnemy(float fps, float currentfrogxPosition, float currentfrogyPosition, float settlefrogxPosition,
                       float settlefrogyPosition){



if((currentfrogxPosition == settlefrogxPosition) && (currentfrogyPosition == settlefrogyPosition)) {


    if(changefrogfungionetime == true){
        setSavedxvelocity(getxVelocity());
        setSavedyvelocity(getyVelocity());
        resetxVelocity();
        resetyVelocity();

        changefrogfungionetime = false;


    }

    if(currentfrogxPosition > currentxWorld){

        setxVelocity(fps * .004f);

        if(currentxWorld + getxVelocity() > currentfrogxPosition){
            setxVelocity(fps * -.004f);
            setSavedxvelocity(getxVelocity());
            resetxVelocity();

        }

    }

    else if(currentfrogxPosition < currentxWorld){

        setxVelocity(fps * -.004f);

        if(currentxWorld + getxVelocity() < currentfrogxPosition){
            setxVelocity(fps * .004f);
            setSavedxvelocity(getxVelocity());

            resetxVelocity();
        }

    }

    if(currentfrogyPosition > currentyWorld){

        setyVelocity(fps * .004f);

        if(currentyWorld + getyVelocity()> currentfrogyPosition){
            setyVelocity(fps * -.004f);
            setSavedyvelocity(getyVelocity());

            resetyVelocity();
        }


    }

    else if(currentfrogyPosition < currentyWorld){

        setyVelocity(fps * -.004f);

        if(currentyWorld + getyVelocity() < currentfrogyPosition){
            setyVelocity(fps * .004f);
            setSavedyvelocity(getyVelocity());

            resetyVelocity();
        }



    }

}

        else {

    if(changefrogfungionetime == false){
        changefrogfungionetime = true;
    }

    if (currentfrogxPosition > currentxWorld) {
        setxVelocity(fps * -.0008f);

    }

    if (currentfrogxPosition < currentxWorld) {
        setxVelocity(fps * .0008f);
    }

    if (currentfrogyPosition > currentyWorld) {
        setyVelocity(fps * -.0008f);
    }

    if (currentfrogyPosition < currentyWorld) {
        setyVelocity(fps * .0008f);
    }

        }



    }



    void updateEnemyLevelTwo(float fps, float currentfrogxPosition, float currentfrogyPosition, float settlefrogxPosition,
                             float settlefrogyPosition) {

        if ((currentfrogxPosition == settlefrogxPosition) && (currentfrogyPosition == settlefrogyPosition)) {


            if (changefrogfungionetime == true) {
                setSavedxvelocity(getxVelocity());
                setSavedyvelocity(getyVelocity());
                resetxVelocity();
                resetyVelocity();

                changefrogfungionetime = false;


            }


            if (currentfrogxPosition > currentxWorld) {

                setxVelocity(fps * .004f);

                if (currentxWorld + getxVelocity() > currentfrogxPosition) {
                    setxVelocity(fps * -.004f);
                    setSavedxvelocity(getxVelocity());
                    resetxVelocity();

                }

            } else if (currentfrogxPosition < currentxWorld) {

                setxVelocity(fps * -.004f);

                if (currentxWorld + getxVelocity() < currentfrogxPosition) {
                    setxVelocity(fps * .004f);
                    setSavedxvelocity(getxVelocity());

                    resetxVelocity();
                }

            }

            if (currentfrogyPosition > currentyWorld) {

                setyVelocity(fps * .004f);

                if (currentyWorld + getyVelocity() > currentfrogyPosition) {
                    setyVelocity(fps * -.004f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            } else if (currentfrogyPosition < currentyWorld) {

                setyVelocity(fps * -.004f);

                if (currentyWorld + getyVelocity() < currentfrogyPosition) {
                    setyVelocity(fps * .004f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            }


        } else {

            if (changefrogfungionetime == false) {
                changefrogfungionetime = true;
            }

            if (currentfrogxPosition > currentxWorld) {
                setxVelocity(fps * -.0008f);

            }

            if (currentfrogxPosition < currentxWorld) {
                setxVelocity(fps * .0008f);
            }

            if (currentfrogyPosition > currentyWorld) {
                setyVelocity(fps * -.0008f);
            }

            if (currentfrogyPosition < currentyWorld) {
                setyVelocity(fps * .0008f);
            }

        }

    }

    }
