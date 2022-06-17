package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 1/20/2017.
 */
public class KillerBeeGrav extends GameObject {

    KillerBeeGrav(){

        initialcondition = true;
        flip = false;


        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("killerbeegravright");
        setBitmapNameLeft("killerbeegravleft");
        setType('l');
        setFacing("RIGHT");

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
    void updateEnemy(float fps, float empty, float emptytwo, float emptythree,
                     float emptyfour){



        if(flip == false) {
            setxVelocity(fps * .00002f);
        }
        else if(flip == true){
            setxVelocity(-fps * .00002f);
        }

        if(getxVelocity() * 15 < 0){
            flip = false;
        }

        if(getxVelocity() * 15 >= 990){
            flip = true;
        }

        if((double)getxVelocity() * 15 > 90 &&  (double)getxVelocity() * 15 < 270){
            setFacing("RIGHT");

        }

        else if((double)getxVelocity() * 15 > 450 &&  (double)getxVelocity() * 15 < 630){

            setFacing("RIGHT");
        }

        else if((double)getxVelocity() * 15 > 810 &&  (double)getxVelocity() * 15 < 990){
            setFacing("RIGHT");

        }

        else {
            setFacing("LEFT");
        }


        if((double)getxVelocity() * 15 < 360){
            currentxWorld = (float)(200 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(200 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));



        }

        else if((double)getxVelocity() * 15 < 450){
            currentxWorld = (float)(200 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(175 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));


        }

        else if((double)getxVelocity() * 15 < 540){
            currentxWorld = (float)(175 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(175 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));

        }

        else if((double)getxVelocity() * 15 < 630){
            currentxWorld = (float)(175 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(125 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));



        }


        else if((double)getxVelocity() * 15 < 720){
            currentxWorld = (float)(125 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(125 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));



        }


        else if((double)getxVelocity() * 15 < 810){
            currentxWorld = (float)(125 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(75 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));


        }

        else if((double)getxVelocity() * 15 < 900){
            currentxWorld = (float)(75 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(75 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));


        }

        else if((double)getxVelocity() * 15 < 990){
            currentxWorld = (float)(75 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
            currentyWorld = (float)(25 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));


        }


    }



}
