package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 1/20/2017.
 */
public class BarkBug extends GameObject {

    BarkBug(){

        initialcondition = true;
        condition = "firstcondition";

        oldTime = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("barkbugright");
        setBitmapNameLeft("barkbugleft");
        setBitmapNameJumpRight("barkbugjumpright");
        setBitmapNameJumpLeft("barkbugjumpleft");
        setType('k');
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

    void updateEnemy(float fps, float barkbuglocation, float emptytwo, float emptythree,
                     float emptyfour){


        
                
                setxVelocity(fps * .00008f);



                if(barkbuglocation == 1) {


                    if(((getxVelocity() * 15) > 90) && ((getxVelocity() * 15) < 270)){
                        setFacing("RIGHT");
                    }
                    else {
                        setFacing("LEFT");
                    }


                    if ((double) getxVelocity() * 15 < 360) {
                        currentxWorld = (float) (200 * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
                        currentyWorld = (float) (200 * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


                    } else {
                        resetxVelocity();
                    }

                }

        else if(barkbuglocation == 2) {


                    if(((getxVelocity() * 15) + 90 > 90) && ((getxVelocity() * 15) + 90 < 270)){
                        setFacing("RIGHT");
                    }
                    else {
                        setFacing("LEFT");
                    }




                    if ((double) getxVelocity() * 15 < 360) {
                currentxWorld = (float) (200 * Math.cos(Math.toRadians((double) (getxVelocity() * 15) + 90)));
                currentyWorld = (float) (200 * Math.sin(Math.toRadians((double) (getxVelocity() * 15) + 90)));


            } else {
                resetxVelocity();
            }

        }


                else if(barkbuglocation == 3) {



                    if(((getxVelocity() * 15) - 90 > 90) && ((getxVelocity() * 15) - 90 < 270)){
                        setFacing("RIGHT");
                    }
                    else {
                        setFacing("LEFT");
                    }




                    if ((double) getxVelocity() * 15 < 360) {
                        currentxWorld = (float) (200 * Math.cos(Math.toRadians((double) (getxVelocity() * 15) - 180)));
                        currentyWorld = (float) (200 * Math.sin(Math.toRadians((double) (getxVelocity() * 15) - 180)));


                    } else {
                        resetxVelocity();
                    }

                }


                else if(barkbuglocation == 4) {


                    if(((getxVelocity() * 15) - 90 > 90) && ((getxVelocity() * 15) - 90 < 270)){
                        setFacing("RIGHT");
                    }
                    else {
                        setFacing("LEFT");
                    }


                    if ((double) getxVelocity() * 15 < 360) {
                        currentxWorld = (float) (200 * Math.cos(Math.toRadians((double) (getxVelocity() * 15) - 90)));
                        currentyWorld = (float) (200 * Math.sin(Math.toRadians((double) (getxVelocity() * 15) - 90)));


                    } else {
                        resetxVelocity();
                    }

                }



    }



    }





