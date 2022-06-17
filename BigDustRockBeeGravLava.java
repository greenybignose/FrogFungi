package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 12/10/2016.
 */
public class BigDustRockBeeGravLava extends GameObject{




    BigDustRockBeeGravLava(){

        initialcondition = true;
        circledistance = 1;
        condition = "firstcondition";
        speed = 2.5f;


        changefrogfungionetime = true;
        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("bigdustrockbeegravlavaright");
        setBitmapNameLeft("bigdustrockbeegravlavaleft");
        setType('D');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxcircle = new RectHitbox();


        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld){


        setRectHitboxcirle(getBitmapWidth()/2,

                currentxWorld + getBitmapWidth()/2,
                currentyWorld + getBitmapHeight()/2);


    }


    void updateEnemy(float fps, float circledistance, float sizeofarray, float objectinstance,
                     float emptyfour){



if(condition.matches("firstcondition")) {

    int division = 360 / (int) sizeofarray;


    setxVelocity(fps * .00002f);


    if (((getxVelocity() * 15) > 90) && ((getxVelocity() * 15) < 270)) {
        setFacing("RIGHT");
    } else {
        setFacing("LEFT");
    }


    if ((double) ((getxVelocity() * 15) + (objectinstance * division)) < 360) {
        currentxWorld = (float) (200 * circledistance *
                Math.cos(Math.toRadians((double) ((getxVelocity() * 15) + (objectinstance * division)))));
        currentyWorld = (float) (200 * circledistance *
                Math.sin(Math.toRadians((double) ((getxVelocity() * 15) + (objectinstance * division)))));


    } else {
        resetxVelocity();
        currentxWorld =  200 * circledistance;
        currentyWorld = 0;
        condition = "secondcondition";

    }
}

else if(condition.matches("secondcondition")){



    setxVelocity(fps * .00002f);




    if(((getxVelocity() * 15) > 90) && ((getxVelocity() * 15) < 270)){
        setFacing("RIGHT");
    }
    else {
        setFacing("LEFT");
    }


    if ((double) getxVelocity() * 15 < 360) {
        currentxWorld = (float) (200 * circledistance *
                Math.cos(Math.toRadians((double) (getxVelocity() * 15))));
        currentyWorld = (float) (200 * circledistance *
                Math.sin(Math.toRadians((double) (getxVelocity() * 15))));


    } else {

        resetxVelocity();
        currentxWorld = 200 * circledistance;
        currentyWorld = 0;

    }

}





    }




    void updateEnemyLevelTwo(float fps, float currentfrogxPosition, float currentfrogyPosition, float currentbigdustrockbeegravlavaxPosition,
                     float currentbigdustrockbeegravlavayPosition){




        if(currentfrogxPosition > currentbigdustrockbeegravlavaxPosition){

            setxVelocity(fps * .00002f);

            if(currentbigdustrockbeegravlavaxPosition + getxVelocity() > currentfrogxPosition){
                setxVelocity(fps * -.00002f);
                setSavedxvelocity(getxVelocity());
                resetxVelocity();

            }

        }

        else if(currentfrogxPosition < currentbigdustrockbeegravlavaxPosition){

            setxVelocity(fps * -.00002f);

            if(currentbigdustrockbeegravlavaxPosition + getxVelocity() < currentfrogxPosition){
                setxVelocity(fps * .00002f);
                setSavedxvelocity(getxVelocity());

                resetxVelocity();
            }

        }

        if(currentfrogyPosition > currentbigdustrockbeegravlavayPosition){

            setyVelocity(fps * .00002f);

            if(currentbigdustrockbeegravlavayPosition + getyVelocity()> currentfrogyPosition){
                setyVelocity(fps * -.00002f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }


        }

        else if(currentfrogyPosition < currentbigdustrockbeegravlavayPosition){

            setyVelocity(fps * -.00002f);

            if(currentbigdustrockbeegravlavayPosition + getyVelocity() < currentfrogyPosition){
                setyVelocity(fps * .00002f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }



        }



    }



}

