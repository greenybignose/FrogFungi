package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 3/6/2017.
 */
public class GravityCloud extends GameObject{

    GravityCloud(){

        initialcondition = true;
        oldTime = 0;
        newTime = 0;
        condition = "firstcondition";

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        gravitycloudrand = 0;

        setBitmapNameRight("gravitycloudleft");
        setBitmapNameRight("gravitycloudright");
        setType('c');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxcircle = new RectHitbox();
        rand = new Random();

        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld){

        setRectHitboxcirle(getBitmapWidth()/8,

                currentxWorld + getBitmapWidth()/2 - getBitmapWidth()/8,
                currentyWorld + getBitmapHeight()/2 - getBitmapHeight()/8);




    }

    void updateEnemy(float fps, float gravitycloudnextxPosition, float gravitycloudnextyPosition, float initialgravitycloudxPosition,
                     float initialgravitycloudyPosition){

        if(gravitycloudnextxPosition > initialgravitycloudxPosition){
            setFacing("RIGHT");
        }
        else if(gravitycloudnextxPosition < initialgravitycloudxPosition){
            setFacing("LEFT");
        }

        
        if(gravitycloudnextxPosition != 0 && gravitycloudnextyPosition != 0) {

            if ((gravitycloudnextxPosition < initialgravitycloudxPosition) &&
                    (gravitycloudnextyPosition <= initialgravitycloudyPosition)) {

                setxVelocity((float) (-fps * (initialgravitycloudxPosition - gravitycloudnextxPosition) * .000002));

                setyVelocity((float) (-fps * (initialgravitycloudyPosition - gravitycloudnextyPosition) * .000002));


                if (getxVelocity() < -(initialgravitycloudxPosition - gravitycloudnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((gravitycloudnextxPosition >= initialgravitycloudxPosition) &&
                    (gravitycloudnextyPosition < initialgravitycloudyPosition)) {


                setxVelocity((float) (fps * (gravitycloudnextxPosition - initialgravitycloudxPosition) * .000002));
                setyVelocity((float) (-fps * (initialgravitycloudyPosition - gravitycloudnextyPosition) * .000002));


                if (getxVelocity() > (gravitycloudnextxPosition - initialgravitycloudxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                }


            } else if ((gravitycloudnextxPosition > initialgravitycloudxPosition) &&
                    (gravitycloudnextyPosition >= initialgravitycloudyPosition)) {


                setxVelocity((float) (fps * (gravitycloudnextxPosition - initialgravitycloudxPosition) * .000002));
                setyVelocity((float) (fps * (gravitycloudnextyPosition - initialgravitycloudyPosition) * .000002));


                if (getxVelocity() > (gravitycloudnextxPosition - initialgravitycloudxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((gravitycloudnextxPosition <= initialgravitycloudxPosition) &&
                    (gravitycloudnextyPosition > initialgravitycloudyPosition)) {


                setxVelocity((float) (-fps * (initialgravitycloudxPosition - gravitycloudnextxPosition) * .000002));
                setyVelocity((float) (fps * (gravitycloudnextyPosition - initialgravitycloudyPosition) * .000002));


                if (getxVelocity() < -(initialgravitycloudxPosition - gravitycloudnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();


                }


            }


        }



    }

}
