package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 12/10/2016.
 */
public class FungiLava extends GameObject{

    FungiLava(){

        initialcondition = true;
        oldTime = 0;
        newTime = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        nextxPosition = 0;
        nextyPosition = 0;
        fungilavarand = 0;

        setBitmapNameRight("fungilava");
        setType('F');

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

    void updateEnemy(float fps, float fungilavanextxPosition, float fungilavanextyPosition, float initialfungilavaxPosition,
                     float initialfungilavayPosition){


        if(fungilavanextxPosition != 0 && fungilavanextyPosition != 0) {

            if ((fungilavanextxPosition < initialfungilavaxPosition) &&
                    (fungilavanextyPosition <= initialfungilavayPosition)) {

                setxVelocity((float) (-fps * (initialfungilavaxPosition - fungilavanextxPosition) * .000008));

                setyVelocity((float) (-fps * (initialfungilavayPosition - fungilavanextyPosition) * .000008));


                if (getxVelocity() < -(initialfungilavaxPosition - fungilavanextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((fungilavanextxPosition >= initialfungilavaxPosition) &&
                    (fungilavanextyPosition < initialfungilavayPosition)) {


                setxVelocity((float) (fps * (fungilavanextxPosition - initialfungilavaxPosition) * .000008));
                setyVelocity((float) (-fps * (initialfungilavayPosition - fungilavanextyPosition) * .000008));


                if (getxVelocity() > (fungilavanextxPosition - initialfungilavaxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                }


            } else if ((fungilavanextxPosition > initialfungilavaxPosition) &&
                    (fungilavanextyPosition >= initialfungilavayPosition)) {


                setxVelocity((float) (fps * (fungilavanextxPosition - initialfungilavaxPosition) * .000008));
                setyVelocity((float) (fps * (fungilavanextyPosition - initialfungilavayPosition) * .000008));


                if (getxVelocity() > (fungilavanextxPosition - initialfungilavaxPosition)) {
                    resetxVelocity();
                    resetyVelocity();
                }


            } else if ((fungilavanextxPosition <= initialfungilavaxPosition) &&
                    (fungilavanextyPosition > initialfungilavayPosition)) {


                setxVelocity((float) (-fps * (initialfungilavaxPosition - fungilavanextxPosition) * .000008));
                setyVelocity((float) (fps * (fungilavanextyPosition - initialfungilavayPosition) * .000008));


                if (getxVelocity() < -(initialfungilavaxPosition - fungilavanextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();


                }


            }


        }



    }


}
