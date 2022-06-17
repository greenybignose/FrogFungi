package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 12/4/2016.
 */
public class SandLadyBug extends GameObject {

    SandLadyBug(){

    initialcondition = true;
    oldTime = 0;

    currentxWorld = 0;
    currentyWorld = 0;
    nextxPosition = 0;
    nextyPosition = 0;

    setBitmapNameRight("sandladybugright");
    setBitmapNameLeft("sandladybugleft");
    setType('s');

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

    void updateEnemy(float fps, float sandladybugnextxPosition, float sandladybugnextyPosition, float initialsandladybugxPosition,
                     float initialsandladybugyPosition){

    if(sandladybugnextxPosition != 0 && sandladybugnextyPosition != 0 &&
            (initialsandladybugxPosition != sandladybugnextxPosition ||
                    initialsandladybugyPosition != sandladybugnextyPosition)) {

    if ((sandladybugnextxPosition < initialsandladybugxPosition) &&
            (sandladybugnextyPosition <= initialsandladybugyPosition)) {

        setxVelocity((float) (-fps * (initialsandladybugxPosition - sandladybugnextxPosition) * .000002));

        setyVelocity((float) (-fps * (initialsandladybugyPosition - sandladybugnextyPosition) * .000002));


        if (getxVelocity() < -(initialsandladybugxPosition - sandladybugnextxPosition)) {
            resetxVelocity();
            resetyVelocity();
        }


    } else if ((sandladybugnextxPosition >= initialsandladybugxPosition) &&
            (sandladybugnextyPosition < initialsandladybugyPosition)) {


        setxVelocity((float) (fps * (sandladybugnextxPosition - initialsandladybugxPosition) * .000002));
        setyVelocity((float) (-fps * (initialsandladybugyPosition - sandladybugnextyPosition) * .000002));


        if (getxVelocity() > (sandladybugnextxPosition - initialsandladybugxPosition)) {
            resetxVelocity();
            resetyVelocity();

        }


    } else if ((sandladybugnextxPosition > initialsandladybugxPosition) &&
            (sandladybugnextyPosition >= initialsandladybugyPosition)) {


        setxVelocity((float) (fps * (sandladybugnextxPosition - initialsandladybugxPosition) * .000002));
        setyVelocity((float) (fps * (sandladybugnextyPosition - initialsandladybugyPosition) * .000002));


        if (getxVelocity() > (sandladybugnextxPosition - initialsandladybugxPosition)) {
            resetxVelocity();
            resetyVelocity();
        }


    } else if ((sandladybugnextxPosition <= initialsandladybugxPosition) &&
            (sandladybugnextyPosition > initialsandladybugyPosition)) {


        setxVelocity((float) (-fps * (initialsandladybugxPosition - sandladybugnextxPosition) * .000002));
        setyVelocity((float) (fps * (sandladybugnextyPosition - initialsandladybugyPosition) * .000002));


        if (getxVelocity() < -(initialsandladybugxPosition - sandladybugnextxPosition)) {
            resetxVelocity();
            resetyVelocity();


        }


    }


}

    }


}
