package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/4/2016.
 */
public class SmallLavaFish extends  GameObject {

    SmallLavaFish(){

        initialcondition = true;
        steps = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("smalllavafishright");
        setBitmapNameLeft("smalllavafishleft");
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
                currentxWorld );

        setRectHitboxright(currentyWorld,
                currentxWorld + getBitmapWidth(),
                currentyWorld + getBitmapHeight(),
                currentxWorld + getBitmapWidth() * .97f);

        setRectHitboxbottom(currentyWorld + getBitmapHeight() * .97f,
                currentxWorld + getBitmapWidth(),
                currentyWorld + getBitmapHeight(),
                currentxWorld );

        setRectHitboxleft(currentyWorld,
                currentxWorld + getBitmapWidth() * .03f,
                currentyWorld + getBitmapHeight(),
                currentxWorld);



    }

    void updateEnemy(float fps, float currentsmalllavafishxPosition, float currentsmalllavafishyPosition, float finishsmalllavafishxPosition,
                     float finishsmalllavafishyPosition){


        if ((finishsmalllavafishxPosition < currentsmalllavafishxPosition) &&
                (finishsmalllavafishyPosition <= currentsmalllavafishyPosition)) {

            setxVelocity((float) (-fps * (currentsmalllavafishxPosition - finishsmalllavafishxPosition) * .000002));


            if (getxVelocity() > -(currentsmalllavafishxPosition - finishsmalllavafishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentsmalllavafishyPosition - finishsmalllavafishyPosition) * .000002) -
                        (fps * .0005)));
            } else if (getxVelocity() < -(currentsmalllavafishxPosition - finishsmalllavafishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentsmalllavafishyPosition - finishsmalllavafishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if (getxVelocity() < -(currentsmalllavafishxPosition - finishsmalllavafishxPosition)) {
                resetxVelocity();
                resetyVelocity();
            }


        }





        else if ((finishsmalllavafishxPosition >= currentsmalllavafishxPosition) &&
                (finishsmalllavafishyPosition < currentsmalllavafishyPosition)) {


            setxVelocity((float)(fps * (finishsmalllavafishxPosition - currentsmalllavafishxPosition) * .000002));


            if(getxVelocity() < (finishsmalllavafishxPosition - currentsmalllavafishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentsmalllavafishyPosition - finishsmalllavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishsmalllavafishxPosition - currentsmalllavafishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentsmalllavafishyPosition - finishsmalllavafishyPosition) * .000002) +
                        (fps * .0005)));
            }







            if(getxVelocity() > (finishsmalllavafishxPosition - currentsmalllavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();

            }








        }


        else if ((finishsmalllavafishxPosition > currentsmalllavafishxPosition) &&
                (finishsmalllavafishyPosition >= currentsmalllavafishyPosition)) {


            setxVelocity((float)(fps * (finishsmalllavafishxPosition - currentsmalllavafishxPosition) * .000002));


            if(getxVelocity() < (finishsmalllavafishxPosition - currentsmalllavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalllavafishyPosition - currentsmalllavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishsmalllavafishxPosition - currentsmalllavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalllavafishyPosition - currentsmalllavafishyPosition) * .000002) +
                        (fps * .0005)));
            }






            if(getxVelocity() > (finishsmalllavafishxPosition - currentsmalllavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();
            }









        }


        else if ((finishsmalllavafishxPosition <= currentsmalllavafishxPosition) &&
                (finishsmalllavafishyPosition > currentsmalllavafishyPosition)) {


            setxVelocity((float)(-fps * (currentsmalllavafishxPosition - finishsmalllavafishxPosition) * .000002));



            if(getxVelocity() > -(currentsmalllavafishxPosition - finishsmalllavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalllavafishyPosition - currentsmalllavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() < -(currentsmalllavafishxPosition - finishsmalllavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalllavafishyPosition - currentsmalllavafishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if(getxVelocity() < -(currentsmalllavafishxPosition - finishsmalllavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();


            }







        }



    }



}
