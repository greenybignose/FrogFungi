package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 12/4/2016.
 */
public class BigHornGrav extends GameObject {

    int randomize;
    boolean onetimein;

    float beginbighorngravxPosition;
    float beginbighorngravyPosition;

    BigHornGrav(){

        initialcondition = true;
        condition = "firstcondition";
        WIDTH = 40;
        HEIGHT = 23;
        onetimein = true;
        currentxPositionSaved = 0;
        currentyPositionSaved = 0;
        bighorngravrand = 0;

        currentxWorld = 0;
        currentyWorld = 0;
        changefrogfungionetime = true;

        setBitmapNameRight("bighorngravright");
        setBitmapNameLeft("bighorngravleft");
        setType('h');
        setFacing("RIGHT");
        setWidth(WIDTH);
        setHeight(HEIGHT);

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

    void updateEnemy(float fps, float nextfrogxPosition, float nextfrogyPosition, float initialbighorngravxPosition,
                       float initialbighorngravyPosition){



        if((nextfrogxPosition == initialbighorngravxPosition) && (nextfrogyPosition == initialbighorngravyPosition)) {

            setFacing("LEFT");



            if(((initialbighorngravxPosition + (getxVelocity() + getSavedxvelocity())) <  (getBitmapWidth() * getWidth() * .7f)) &&
                    changefrogfungionetime == true) {

                setxVelocity(fps * -.01f);

            if(initialbighorngravxPosition - (getxVelocity() + getSavedxvelocity()) <= getBitmapWidth() * getWidth() * .15f){
                setSavedyvelocity(getxVelocity());
               resetxVelocity();
                changefrogfungionetime = false;
            }


                setyVelocity(fps * .01f);

            if(initialbighorngravyPosition + (getyVelocity() + getSavedyvelocity()) >= getBitmapHeight() * getHeight() * .8f){
                setSavedyvelocity(getyVelocity());
                resetyVelocity();
                changefrogfungionetime = false;


            }



            }

            else if((initialbighorngravxPosition + (getxVelocity() + getSavedxvelocity())) >=  (getBitmapWidth() * getWidth() * .7f)){

                if(getSavedxvelocity() != 0){
                    resetSavedxvelocity();
                }

                if(getSavedyvelocity() != 0){
                    resetSavedyvelocity();
                }

                setxVelocity(fps * -.02f);


            }









            if(initialbighorngravyPosition + getyVelocity() - getBitmapHeight() < 0){
                setyVelocity(fps * .015f);
            }


        }

        else if((nextfrogxPosition != initialbighorngravxPosition ) &&
                (nextfrogyPosition != initialbighorngravyPosition) &&
                (getxVelocity() != 0 || changefrogfungionetime == false))  {

            setFacing("RIGHT");



            if (currentxWorld < initialbighorngravxPosition) {
                setxVelocity(fps * .003f);

            }


            if (currentyWorld > initialbighorngravyPosition) {
                setyVelocity(fps * -.003f);
            }


            if (currentyWorld < initialbighorngravyPosition) {
                    resetyVelocity();
                     currentyWorld = initialbighorngravyPosition;
                    }



            if(changefrogfungionetime == false){
                changefrogfungionetime = true;
            }

            if(getSavedxvelocity() != 0){
                setSavedxvelocity(getxVelocity());
                resetxVelocity();
            }

            if(getSavedyvelocity() != 0){
                setSavedyvelocity(getyVelocity());
                resetyVelocity();
            }



        }

    }


    void updateEnemyLevelTwo(float fps, float nextfrogxPosition, float nextfrogyPosition, float BeginX,
                             float BeginY) {


        if(condition.matches("firstcondition") && onetimein == true){
            beginbighorngravxPosition = currentxWorld;
            beginbighorngravyPosition = currentyWorld;

            onetimein = false;
        }


            if((nextfrogxPosition == beginbighorngravxPosition) && (nextfrogyPosition == beginbighorngravyPosition)) {

                if(condition.matches("firstcondition") && onetimein == false){

                    setFacing("LEFT");


                if (nextxPosition < beginbighorngravxPosition &&
                        nextyPosition > beginbighorngravyPosition) {



                    setxVelocity(fps * ((nextxPosition - beginbighorngravxPosition)/110000));


                    setyVelocity(fps * ((nextyPosition - beginbighorngravyPosition)/110000));

                }


                if ((float)((360 - (Math.toDegrees(Math.acos((double)(((getWorldLocation().x - BeginX + getxVelocity())- nextxPosition) / 200)))))/15) <=
                        (float)((360 + (Math.toDegrees(Math.asin((double)(((getWorldLocation().y - BeginY + getyVelocity()) - nextyPosition) / 200)))))/15)) {



                    setSavedyvelocity(getxVelocity());


                    resetxVelocity();
                    resetyVelocity();



                    setxVelocity((float)((360 - (Math.toDegrees(Math.acos((double)(((getWorldLocation().x -
                            BeginX + getSavedyvelocity())- nextxPosition) / 200)))))/15));



                    if(((getxVelocity() * 15) > 90) && ((getxVelocity() * 15) < 270)){
                        setFacing("RIGHT");
                    }
                    else {
                        setFacing("LEFT");
                    }



                    if((double)(getxVelocity() * 15) < 360){
                        currentxWorld = (float)(200 * Math.cos(Math.toRadians((double)(getxVelocity() * 15))));
                        currentyWorld = (float)(200 * Math.sin(Math.toRadians((double)(getxVelocity() * 15))));



                    }

                    else {
                        resetxVelocity();
                    }





                    condition = "secondcondition";
                }


            }

           else if(condition.matches("secondcondition")){

                        resetSavedyvelocity();

                    setxVelocity(fps * .00005f);


                        if(((getxVelocity() * 15) > 90) && ((getxVelocity() * 15) < 270)){
                            setFacing("RIGHT");
                        }
                        else {
                            setFacing("LEFT");
                        }



                        if((double)getxVelocity() * 15 < 360){
                            currentxWorld = (float)(200 * Math.cos(Math.toRadians((double)getxVelocity() * 15)));
                            currentyWorld = (float)(200 * Math.sin(Math.toRadians((double)getxVelocity() * 15)));



                        }

                        else {
                            resetxVelocity();
                        }





                    }

                    else if(condition.matches("thirdcondition")){

                setFacing("LEFT");


                if (currentxWorld < beginbighorngravxPosition) {
                    setxVelocity(fps * ((BeginX + currentxPositionSaved - beginbighorngravxPosition) / 110000));

                }


                if (currentyWorld > beginbighorngravyPosition) {
                    setyVelocity(fps * ((BeginY + currentyPositionSaved - beginbighorngravyPosition) / 110000));
                }

                if(currentxWorld <= (BeginX + currentxPositionSaved)  && currentyWorld >= (BeginY + currentyPositionSaved)){

                    resetxVelocity();
                    resetyVelocity();

                    currentxWorld = currentxPositionSaved;

                    setxVelocity(getSavedxvelocity());

                    condition = "secondcondition";

                }




            }





            }


            else if((nextfrogxPosition != beginbighorngravxPosition ) &&
                    (nextfrogyPosition != beginbighorngravyPosition))  {


                if(condition.matches("firstcondition")) {
                    setFacing("RIGHT");


                    if (currentxWorld < beginbighorngravxPosition) {
                        setxVelocity(fps * -((nextxPosition - beginbighorngravxPosition) / 110000));

                    }


                    if (currentyWorld > beginbighorngravyPosition) {
                        setyVelocity(fps * -((nextyPosition - beginbighorngravyPosition) / 110000));
                    }




                }

                else if(condition.matches("secondcondition")){

                    if(getSavedxvelocity() != 0){
                        resetSavedxvelocity();
                    }

                    setSavedxvelocity(getxVelocity());
                    currentxPositionSaved = currentxWorld;
                    currentyPositionSaved = currentyWorld;
                    resetxVelocity();

                    condition = "thirdcondition";

                }


                else if(condition.matches("thirdcondition")){

                    setFacing("RIGHT");


                    if (currentxWorld < beginbighorngravxPosition) {
                        setxVelocity(fps * -((BeginX + currentxPositionSaved - beginbighorngravxPosition) / 420000));

                    }


                    if (currentyWorld > beginbighorngravyPosition) {
                        setyVelocity(fps * -((BeginY + currentyPositionSaved - beginbighorngravyPosition) / 420000));
                    }


                    if(currentxWorld >= beginbighorngravxPosition &&
                            currentyWorld <=  beginbighorngravyPosition) {


                        condition = "firstcondition";

                    }




                }

            }








    }





    }





