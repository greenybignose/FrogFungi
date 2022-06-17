package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 1/20/2017.
 */
public class LavaDrop extends GameObject {

    LavaDrop() {

        initialcondition = true;

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        lavadroprand = 1;

        condition = "firstcondition";

        setBitmapNameRight("lavadropright");

        setBitmapNameLeft("lavadropleft");
        setBitmapNameJumpRight("lavadropjumpright");
        setBitmapNameJumpLeft("lavadropjumpleft");

        setType('v');
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

    void updateEnemy(float fps, float lavadropnextxPosition, float lavadropnextyPosition, float initiallavadropxPosition,
                     float initiallavadropyPosition) {


        if (lavadropnextxPosition != 0 && lavadropnextyPosition != 0) {


            if ((lavadropnextxPosition < initiallavadropxPosition) &&
                    (lavadropnextyPosition <= initiallavadropyPosition)) {

                setFacing("LEFT");

                setxVelocity((float) (-fps * (initiallavadropxPosition - lavadropnextxPosition) * .00001));


                if (getxVelocity() > -(initiallavadropxPosition - lavadropnextxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initiallavadropyPosition - lavadropnextyPosition) * .00001) -
                            (fps * .00002)));
                } else if (getxVelocity() < -(initiallavadropxPosition - lavadropnextxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initiallavadropyPosition - lavadropnextyPosition) * .00001) -
                            (fps * .0002)));
                }


                if (getxVelocity() < -(initiallavadropxPosition - lavadropnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((lavadropnextxPosition >= initiallavadropxPosition) &&
                    (lavadropnextyPosition < initiallavadropyPosition)) {

                setFacing("RIGHT");

                setxVelocity((float) (fps * (lavadropnextxPosition - initiallavadropxPosition) * .00001));


                if (getxVelocity() < (lavadropnextxPosition - initiallavadropxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initiallavadropyPosition - lavadropnextyPosition) * .00001) -
                            (fps * .00002)));
                } else if (getxVelocity() > (lavadropnextxPosition - initiallavadropxPosition) / 2) {

                    setyVelocity((float) ((-fps * (initiallavadropyPosition - lavadropnextyPosition) * .00001) -
                            (fps * .0002)));
                }


                if (getxVelocity() > (lavadropnextxPosition - initiallavadropxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                }


            } else if ((lavadropnextxPosition > initiallavadropxPosition) &&
                    (lavadropnextyPosition >= initiallavadropyPosition)) {


                setFacing("RIGHT");

                setxVelocity((float) (fps * (lavadropnextxPosition - initiallavadropxPosition) * .00001));


                if (getxVelocity() < (lavadropnextxPosition - initiallavadropxPosition) / 2) {

                    setyVelocity((float) ((fps * (lavadropnextyPosition - initiallavadropyPosition) * .00001) -
                            (fps * .0002)));
                } else if (getxVelocity() > (lavadropnextxPosition - initiallavadropxPosition) / 2) {

                    setyVelocity((float) ((fps * (lavadropnextyPosition - initiallavadropyPosition) * .00001) +
                            (fps * .0002)));
                }


                if (getxVelocity() > (lavadropnextxPosition - initiallavadropxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((lavadropnextxPosition <= initiallavadropxPosition) &&
                    (lavadropnextyPosition > initiallavadropyPosition)) {

                setFacing("LEFT");

                setxVelocity((float) (-fps * (initiallavadropxPosition - lavadropnextxPosition) * .00001));


                if (getxVelocity() > -(initiallavadropxPosition - lavadropnextxPosition) / 2) {

                    setyVelocity((float) ((fps * (lavadropnextyPosition - initiallavadropyPosition) * .00001) -
                            (fps * .0002)));
                } else if (getxVelocity() < -(initiallavadropxPosition - lavadropnextxPosition) / 2) {

                    setyVelocity((float) ((fps * (lavadropnextyPosition - initiallavadropyPosition) * .00001) +
                            (fps * .0002)));
                }


                if (getxVelocity() < -(initiallavadropxPosition - lavadropnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();


                }


            }


        }
    }

}
