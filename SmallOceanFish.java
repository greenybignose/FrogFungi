package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/4/2016.
 */
public class SmallOceanFish extends GameObject {

    SmallOceanFish(){

        initialcondition = true;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("smalloceanfishright");
        setBitmapNameLeft("smalloceanfishleft");
        setType('f');
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

    void updateEnemy(float fps, float currentsmalloceanfishxPosition, float currentsmalloceanfishyPosition, float finishsmalloceanfishxPosition,
                       float finishsmalloceanfishyPosition){


        if ((finishsmalloceanfishxPosition < currentsmalloceanfishxPosition) &&
                (finishsmalloceanfishyPosition <= currentsmalloceanfishyPosition)) {

            setxVelocity((float) (-fps * (currentsmalloceanfishxPosition - finishsmalloceanfishxPosition) * .000002));


            if (getxVelocity() > -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentsmalloceanfishyPosition - finishsmalloceanfishyPosition) * .000002) -
                        (fps * .0005)));
            } else if (getxVelocity() < -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentsmalloceanfishyPosition - finishsmalloceanfishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if (getxVelocity() < -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition)) {
                resetxVelocity();
                resetyVelocity();
            }


        }





        else if ((finishsmalloceanfishxPosition >= currentsmalloceanfishxPosition) &&
                (finishsmalloceanfishyPosition < currentsmalloceanfishyPosition)) {


            setxVelocity((float)(fps * (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition) * .000002));


            if(getxVelocity() < (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentsmalloceanfishyPosition - finishsmalloceanfishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((-fps * (currentsmalloceanfishyPosition - finishsmalloceanfishyPosition) * .000002) +
                        (fps * .0005)));
            }







            if(getxVelocity() > (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();

            }








        }


        else if ((finishsmalloceanfishxPosition > currentsmalloceanfishxPosition) &&
                (finishsmalloceanfishyPosition >= currentsmalloceanfishyPosition)) {


            setxVelocity((float)(fps * (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition) * .000002));


            if(getxVelocity() < (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalloceanfishyPosition - currentsmalloceanfishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalloceanfishyPosition - currentsmalloceanfishyPosition) * .000002) +
                        (fps * .0005)));
            }






            if(getxVelocity() > (finishsmalloceanfishxPosition - currentsmalloceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();
            }









        }


        else if ((finishsmalloceanfishxPosition <= currentsmalloceanfishxPosition) &&
                (finishsmalloceanfishyPosition > currentsmalloceanfishyPosition)) {


            setxVelocity((float)(-fps * (currentsmalloceanfishxPosition - finishsmalloceanfishxPosition) * .000002));



            if(getxVelocity() > -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalloceanfishyPosition - currentsmalloceanfishyPosition) * .000002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() < -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition)/2) {

                setyVelocity((float) ((fps * (finishsmalloceanfishyPosition - currentsmalloceanfishyPosition) * .000002) +
                        (fps * .0005)));
            }





            if(getxVelocity() < -(currentsmalloceanfishxPosition - finishsmalloceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();


            }







        }



    }


}
