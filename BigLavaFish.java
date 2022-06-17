package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/4/2016.
 */
public class BigLavaFish extends GameObject{

    BigLavaFish(){

        initialcondition = true;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("biglavafishright");
        setBitmapNameLeft("biglavafishleft");
        setType('L');
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
    void updateEnemy(float fps, float currentbiglavafishxPosition, float currentbiglavafishyPosition, float finishbiglavafishxPosition,
                     float finishbiglavafishyPosition){



        if ((finishbiglavafishxPosition < currentbiglavafishxPosition) &&
                (finishbiglavafishyPosition <= currentbiglavafishyPosition)) {

            setxVelocity((float) (-fps * (currentbiglavafishxPosition - finishbiglavafishxPosition) * .000002));


            if (getxVelocity() > -(currentbiglavafishxPosition - finishbiglavafishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentbiglavafishyPosition - finishbiglavafishyPosition) * .000002) -
                        (fps * .0005)));
            } else if (getxVelocity() < -(currentbiglavafishxPosition - finishbiglavafishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentbiglavafishyPosition - finishbiglavafishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if (getxVelocity() < -(currentbiglavafishxPosition - finishbiglavafishxPosition)) {
                resetxVelocity();
                resetyVelocity();
            }


        }





        else if ((finishbiglavafishxPosition >= currentbiglavafishxPosition) &&
                (finishbiglavafishyPosition < currentbiglavafishyPosition)) {


            setxVelocity((float)(fps * (finishbiglavafishxPosition - currentbiglavafishxPosition) * .000002));


            if(getxVelocity() < (finishbiglavafishxPosition - currentbiglavafishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentbiglavafishyPosition - finishbiglavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishbiglavafishxPosition - currentbiglavafishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentbiglavafishyPosition - finishbiglavafishyPosition) * .000002) +
                        (fps * .0005)));
            }







            if(getxVelocity() > (finishbiglavafishxPosition - currentbiglavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();

            }








        }


        else if ((finishbiglavafishxPosition > currentbiglavafishxPosition) &&
                (finishbiglavafishyPosition >= currentbiglavafishyPosition)) {


            setxVelocity((float)(fps * (finishbiglavafishxPosition - currentbiglavafishxPosition) * .000002));


            if(getxVelocity() < (finishbiglavafishxPosition - currentbiglavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishbiglavafishyPosition - currentbiglavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishbiglavafishxPosition - currentbiglavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishbiglavafishyPosition - currentbiglavafishyPosition) * .000002) +
                        (fps * .0005)));
            }






            if(getxVelocity() > (finishbiglavafishxPosition - currentbiglavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();
            }









        }


        else if ((finishbiglavafishxPosition <= currentbiglavafishxPosition) &&
                (finishbiglavafishyPosition > currentbiglavafishyPosition)) {


            setxVelocity((float)(-fps * (currentbiglavafishxPosition - finishbiglavafishxPosition) * .000002));



            if(getxVelocity() > -(currentbiglavafishxPosition - finishbiglavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishbiglavafishyPosition - currentbiglavafishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() < -(currentbiglavafishxPosition - finishbiglavafishxPosition)/2) {

                setyVelocity((float) ((fps * (finishbiglavafishyPosition - currentbiglavafishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if(getxVelocity() < -(currentbiglavafishxPosition - finishbiglavafishxPosition) ){
                resetxVelocity();
                resetyVelocity();


            }







        }

    }


}
