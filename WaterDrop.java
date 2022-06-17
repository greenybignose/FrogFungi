package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 1/20/2017.
 */
public class WaterDrop extends GameObject {

    WaterDrop() {

        initialcondition = true;

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        waterdroprand = 1;

        condition = "firstcondition";

        setBitmapNameRight("waterdropright");

        setBitmapNameLeft("waterdropleft");
        setBitmapNameJumpRight("waterdropjumpright");
        setBitmapNameJumpLeft("waterdropjumpleft");

        setType('p');
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

    void updateEnemy(float fps, float waterdropnextxPosition, float waterdropnextyPosition, float initialwaterdropxPosition,
                     float initialwaterdropyPosition) {


        if (waterdropnextxPosition != 0 && waterdropnextyPosition != 0) {


            if ((waterdropnextxPosition < initialwaterdropxPosition) &&
                    (waterdropnextyPosition <= initialwaterdropyPosition)) {

                setFacing("LEFT");

                setxVelocity((float) (-fps * (initialwaterdropxPosition - waterdropnextxPosition) * .00001));


                if (getxVelocity() > -(initialwaterdropxPosition - waterdropnextxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initialwaterdropyPosition - waterdropnextyPosition) * .00001) -
                            (fps * .00002)));
                } else if (getxVelocity() < -(initialwaterdropxPosition - waterdropnextxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initialwaterdropyPosition - waterdropnextyPosition) * .00001) -
                            (fps * .0002)));
                }


                if (getxVelocity() < -(initialwaterdropxPosition - waterdropnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((waterdropnextxPosition >= initialwaterdropxPosition) &&
                    (waterdropnextyPosition < initialwaterdropyPosition)) {

                setFacing("RIGHT");

                setxVelocity((float) (fps * (waterdropnextxPosition - initialwaterdropxPosition) * .00001));


                if (getxVelocity() < (waterdropnextxPosition - initialwaterdropxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initialwaterdropyPosition - waterdropnextyPosition) * .00001) -
                            (fps * .00002)));
                } else if (getxVelocity() > (waterdropnextxPosition - initialwaterdropxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initialwaterdropyPosition - waterdropnextyPosition) * .00001) -
                            (fps * .0002)));
                }


                if (getxVelocity() > (waterdropnextxPosition - initialwaterdropxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                }


            } else if ((waterdropnextxPosition > initialwaterdropxPosition) &&
                    (waterdropnextyPosition >= initialwaterdropyPosition)) {


                setFacing("RIGHT");

                setxVelocity((float) (fps * (waterdropnextxPosition - initialwaterdropxPosition) * .00001));


                if (getxVelocity() < (waterdropnextxPosition - initialwaterdropxPosition) / 2) {

                    setyVelocity((float) ((fps * (waterdropnextyPosition - initialwaterdropyPosition) * .00001) -
                            (fps * .0002)));
                } else if (getxVelocity() > (waterdropnextxPosition - initialwaterdropxPosition) / 2) {

                    setyVelocity((float) ((fps * (waterdropnextyPosition - initialwaterdropyPosition) * .00001) +
                            (fps * .0002)));
                }


                if (getxVelocity() > (waterdropnextxPosition - initialwaterdropxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((waterdropnextxPosition <= initialwaterdropxPosition) &&
                    (waterdropnextyPosition > initialwaterdropyPosition)) {

                setFacing("LEFT");

                setxVelocity((float) (-fps * (initialwaterdropxPosition - waterdropnextxPosition) * .00001));


                if (getxVelocity() > -(initialwaterdropxPosition - waterdropnextxPosition) / 2) {

                    setyVelocity((float) ((fps * (waterdropnextyPosition - initialwaterdropyPosition) * .00001) -
                            (fps * .0002)));
                } else if (getxVelocity() < -(initialwaterdropxPosition - waterdropnextxPosition) / 2) {

                    setyVelocity((float) ((fps * (waterdropnextyPosition - initialwaterdropyPosition) * .00001) +
                            (fps * .0002)));
                }


                if (getxVelocity() < -(initialwaterdropxPosition - waterdropnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();


                }


            }


        }
    }

}
