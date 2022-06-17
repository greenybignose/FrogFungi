package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/4/2016.
 */
public class BigOceanFish extends GameObject {

    BigOceanFish(){

        initialcondition = true;
        steps = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("bigoceanfishright");
        setBitmapNameLeft("bigoceanfishleft");
        setType('F');
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

    void updateEnemy(float fps, float currentbigoceanfishxPosition, float currentbigoceanfishyPosition, float finishbigoceanfishxPosition,
                       float finishbigoceanfishyPosition) {


        if ((finishbigoceanfishxPosition < currentbigoceanfishxPosition) &&
                (finishbigoceanfishyPosition <= currentbigoceanfishyPosition)) {

            setxVelocity((float) (-fps * (currentbigoceanfishxPosition - finishbigoceanfishxPosition) * .000002));


            if (getxVelocity() > -(currentbigoceanfishxPosition - finishbigoceanfishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentbigoceanfishyPosition - finishbigoceanfishyPosition) * .000002) -
                        (fps * .0005)));
            } else if (getxVelocity() < -(currentbigoceanfishxPosition - finishbigoceanfishxPosition) / 2) {

                setyVelocity((float) ((-fps * (currentbigoceanfishyPosition - finishbigoceanfishyPosition) * .000002) +
                        (fps * .0005)));
            }





        if (getxVelocity() < -(currentbigoceanfishxPosition - finishbigoceanfishxPosition)) {
            resetxVelocity();
            resetyVelocity();
        }
        

    }



        
    
            else if ((finishbigoceanfishxPosition >= currentbigoceanfishxPosition) &&
                (finishbigoceanfishyPosition < currentbigoceanfishyPosition)) {


            setxVelocity((float)(fps * (finishbigoceanfishxPosition - currentbigoceanfishxPosition) * .000002));


                if(getxVelocity() < (finishbigoceanfishxPosition - currentbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((-fps * (currentbigoceanfishyPosition - finishbigoceanfishyPosition) * .000002) -
                            (fps * .0005)));
                }

                else if(getxVelocity() > (finishbigoceanfishxPosition - currentbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((-fps * (currentbigoceanfishyPosition - finishbigoceanfishyPosition) * .000002) +
                            (fps * .0005)));
                }







            if(getxVelocity() > (finishbigoceanfishxPosition - currentbigoceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();

            }

        






        }


            else if ((finishbigoceanfishxPosition > currentbigoceanfishxPosition) &&
                (finishbigoceanfishyPosition >= currentbigoceanfishyPosition)) {


            setxVelocity((float)(fps * (finishbigoceanfishxPosition - currentbigoceanfishxPosition) * .000002));


                if(getxVelocity() < (finishbigoceanfishxPosition - currentbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((fps * (finishbigoceanfishyPosition - currentbigoceanfishyPosition) * .000002) -
                            (fps * .0005)));
                }

                else if(getxVelocity() > (finishbigoceanfishxPosition - currentbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((fps * (finishbigoceanfishyPosition - currentbigoceanfishyPosition) * .000002) +
                            (fps * .0005)));
                }






            if(getxVelocity() > (finishbigoceanfishxPosition - currentbigoceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();
            }


    






        }


            else if ((finishbigoceanfishxPosition <= currentbigoceanfishxPosition) &&
                (finishbigoceanfishyPosition > currentbigoceanfishyPosition)) {


            setxVelocity((float)(-fps * (currentbigoceanfishxPosition - finishbigoceanfishxPosition) * .000002));



                if(getxVelocity() > -(currentbigoceanfishxPosition - finishbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((fps * (finishbigoceanfishyPosition - currentbigoceanfishyPosition) * .000002) -
                            (fps * .0005)));
                }

                else if(getxVelocity() < -(currentbigoceanfishxPosition - finishbigoceanfishxPosition)/2) {

                    setyVelocity((float) ((fps * (finishbigoceanfishyPosition - currentbigoceanfishyPosition) * .000002) +
                            (fps * .0005)));
                }





            if(getxVelocity() < -(currentbigoceanfishxPosition - finishbigoceanfishxPosition) ){
                resetxVelocity();
                resetyVelocity();


            }



    



        }


    


    }




}



