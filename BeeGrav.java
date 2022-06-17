package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 11/24/2016.
 */
public class BeeGrav extends GameObject{

    BeeGrav(){

        initialcondition = true;

        condition = "initialcondition";


        currentxWorld = 0;
        currentyWorld = 0;
        firstconditionposx = 0;
        firstconditionposy = 0;
        secondconditionposx = 0;
        secondconditionposy = 0;
        thirdconditionposx = 0;
        thirdconditionposy = 0;

        setBitmapNameRight("beegravright");
        setBitmapNameLeft("beegravleft");
        setType('b');
        setFacing("RIGHT");
        setVisible(true);

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

    void updateEnemy(float fps, float currentfrogxPosition, float currentfrogyPosition, float currentbeegravxPosition,
                       float currentbeegravyPosition){




            if(currentfrogxPosition > currentbeegravxPosition){

                setxVelocity(fps * .002f);

                if(currentbeegravxPosition + getxVelocity() > currentfrogxPosition){
                    setxVelocity(fps * -.002f);
                    setSavedxvelocity(getxVelocity());
                    resetxVelocity();
                    
                }

            }

            else if(currentfrogxPosition < currentbeegravxPosition){
                
                setxVelocity(fps * -.002f);

                if(currentbeegravxPosition + getxVelocity() < currentfrogxPosition){
                    setxVelocity(fps * .002f);
                    setSavedxvelocity(getxVelocity());

                    resetxVelocity();
                }

            }

            if(currentfrogyPosition > currentbeegravyPosition){
                
                setyVelocity(fps * .002f);

                if(currentbeegravyPosition + getyVelocity()> currentfrogyPosition){
                    setyVelocity(fps * -.002f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }


            }

            else if(currentfrogyPosition < currentbeegravyPosition){
                
                setyVelocity(fps * -.002f);

                if(currentbeegravyPosition + getyVelocity() < currentfrogyPosition){
                    setyVelocity(fps * .002f);
                    setSavedyvelocity(getyVelocity());

                    resetyVelocity();
                }



            }



        }


    void updateEnemyLevelTwo(float fps, float currentfrogxPosition, float currentfrogyPosition, float empty,
                             float emptytoo){



        if(currentfrogxPosition > currentxWorld){

            setxVelocity(fps * .005f);

            if(currentxWorld + getxVelocity() > currentfrogxPosition){
                setxVelocity(fps * -.005f);
                setSavedxvelocity(getxVelocity());
                resetxVelocity();

            }

        }

        else if(currentfrogxPosition < currentxWorld){

            setxVelocity(fps * -.005f);

            if(currentxWorld + getxVelocity() < currentfrogxPosition){
                setxVelocity(fps * .005f);
                setSavedxvelocity(getxVelocity());

                resetxVelocity();
            }

        }

        if(currentfrogyPosition > currentyWorld){

            setyVelocity(fps * .005f);

            if(currentyWorld + getyVelocity()> currentfrogyPosition){
                setyVelocity(fps * -.005f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }


        }

        else if(currentfrogyPosition < currentyWorld){

            setyVelocity(fps * -.005f);

            if(currentyWorld + getyVelocity() < currentfrogyPosition){
                setyVelocity(fps * .005f);
                setSavedyvelocity(getyVelocity());

                resetyVelocity();
            }



        }


    }




}



