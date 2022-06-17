package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 2/10/2017.
 */
public class DustBullet extends GameObject{

    float initialdustbulletxPosition;
    float initialdustbulletyPosition;
    float localdustbulletnextxPosition;
    float localdustbulletnextyPosition;
    
    
    DustBullet(){

        initialcondition = true;
        flip = false;
        condition = "firstcondition";
        circledistance = 1;


        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("dustbulletright");
        setBitmapNameLeft("dustbulletleft");
        setBitmapNameJumpRight("dustbulletjumpright");
        setType('u');
        setFacing("RIGHT");

        worldLocation = new Vector2Point5D();
        rectHitboxcircle = new RectHitbox();

        setWorldLocation(0, 0);
    }

    void setHitBoxPosition(float currentxWorld, float currentyWorld){

        setRectHitboxcirle(getradius(),

                currentxWorld + getradius(),
                currentyWorld + getradius());



    }

    float getradius(){
        if(condition.matches("firstcondition") || condition.matches("secondcondition")){
            radius = getBitmapWidth()/3;
        }
        else if(condition.matches("thirdcondition")){
            radius = getBitmapWidth()/2;
        }

        return radius;

    }


    void updateEnemy(float fps, float dustbulletnextxPosition, float dustbulletnextyPosition, float BeginX,
                     float BeginY){


    if(condition.matches("secondcondition")) {
        setxVelocity(fps * .000008f);

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




        if ((double) getxVelocity() * 15 < 90) {

            currentxWorld = (float) (5 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (25 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        } else if ((double) getxVelocity() * 15 < 180) {
            currentxWorld = (float) (50 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (25 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 270) {
            currentxWorld = (float) (50 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (75 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 360) {
            currentxWorld = (float) (100 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (75 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 450) {
            currentxWorld = (float) (100 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (125 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 540) {
            currentxWorld = (float) (150 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (125 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        } else if ((double) getxVelocity() * 15 < 630) {
            currentxWorld = (float) (150 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (175 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 720) {
            currentxWorld = (float) (200 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (175 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 810) {

            initialdustbulletxPosition = currentxWorld;
            initialdustbulletyPosition = currentyWorld;

            currentxWorld = (float) (200 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (225 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 900) {


            initialdustbulletxPosition = currentxWorld;
            initialdustbulletyPosition = currentyWorld;


            currentxWorld = (float) (250 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (225 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        } else if ((double) getxVelocity() * 15 < 990) {


            initialdustbulletxPosition = currentxWorld;
            initialdustbulletyPosition = currentyWorld;


            currentxWorld = (float) (250 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (275 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        }
    }

     if((double) getxVelocity() * 15 > 720 && condition.matches("secondcondition")) {

            if ((dustbulletnextxPosition < initialdustbulletxPosition) &&
                    (dustbulletnextyPosition <= initialdustbulletyPosition)) {


                float currentdistance = ((dustbulletnextxPosition - initialdustbulletxPosition) * (dustbulletnextxPosition - initialdustbulletxPosition)) +
                        ((dustbulletnextyPosition - initialdustbulletyPosition) * (dustbulletnextyPosition - initialdustbulletyPosition));
                
                float nextdistance = ((dustbulletnextxPosition - currentxWorld) * (dustbulletnextxPosition - currentxWorld)) +
                        ((dustbulletnextyPosition - currentyWorld) * (dustbulletnextyPosition - currentyWorld));


                if(nextdistance > currentdistance){


                    localdustbulletnextxPosition = dustbulletnextxPosition;
                    localdustbulletnextyPosition = dustbulletnextyPosition;
                    
                    currentxWorld = initialdustbulletxPosition;
                    currentyWorld = initialdustbulletyPosition;



                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();


                    condition = "thirdcondition";
                }




            } else if ((dustbulletnextxPosition >= initialdustbulletxPosition) &&
                    (dustbulletnextyPosition < initialdustbulletyPosition)) {


                float currentdistance = ((dustbulletnextxPosition - initialdustbulletxPosition) * (dustbulletnextxPosition - initialdustbulletxPosition)) +
                        ((dustbulletnextyPosition - initialdustbulletyPosition) * (dustbulletnextyPosition - initialdustbulletyPosition));

                float nextdistance = ((dustbulletnextxPosition - currentxWorld) * (dustbulletnextxPosition - currentxWorld)) +
                        ((dustbulletnextyPosition - currentyWorld) * (dustbulletnextyPosition - currentyWorld));


                if(nextdistance > currentdistance){


                    localdustbulletnextxPosition = dustbulletnextxPosition;
                    localdustbulletnextyPosition = dustbulletnextyPosition;
                    
                    currentxWorld = initialdustbulletxPosition;
                    currentyWorld = initialdustbulletyPosition;


                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();


                    condition = "thirdcondition";
                }




            } else if ((dustbulletnextxPosition > initialdustbulletxPosition) &&
                    (dustbulletnextyPosition >= initialdustbulletyPosition)) {


                
                float currentdistance = ((dustbulletnextxPosition - initialdustbulletxPosition) * (dustbulletnextxPosition - initialdustbulletxPosition)) +
                        ((dustbulletnextyPosition - initialdustbulletyPosition) * (dustbulletnextyPosition - initialdustbulletyPosition));

                float nextdistance = ((dustbulletnextxPosition - currentxWorld) * (dustbulletnextxPosition - currentxWorld)) +
                        ((dustbulletnextyPosition - currentyWorld) * (dustbulletnextyPosition - currentyWorld));


                if(nextdistance > currentdistance){


                    localdustbulletnextxPosition = dustbulletnextxPosition;
                    localdustbulletnextyPosition = dustbulletnextyPosition;
                
                
                    currentxWorld = initialdustbulletxPosition;
                    currentyWorld = initialdustbulletyPosition;


                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();

                    condition = "thirdcondition";
                }



            } else if ((dustbulletnextxPosition <= initialdustbulletxPosition) &&
                    (dustbulletnextyPosition > initialdustbulletyPosition)) {

                float currentdistance = ((dustbulletnextxPosition - initialdustbulletxPosition) * (dustbulletnextxPosition - initialdustbulletxPosition)) +
                        ((dustbulletnextyPosition - initialdustbulletyPosition) * (dustbulletnextyPosition - initialdustbulletyPosition));

                float nextdistance = ((dustbulletnextxPosition - currentxWorld) * (dustbulletnextxPosition - currentxWorld)) +
                        ((dustbulletnextyPosition - currentyWorld) * (dustbulletnextyPosition - currentyWorld));


                if(nextdistance > currentdistance){
                    currentxWorld = initialdustbulletxPosition;
                    currentyWorld = initialdustbulletyPosition;

                    localdustbulletnextxPosition = dustbulletnextxPosition;
                    localdustbulletnextyPosition = dustbulletnextyPosition;


                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();

                    condition = "thirdcondition";
                }


            }
        }



          else  if(condition.matches("thirdcondition")) {

            if ((localdustbulletnextxPosition < (initialdustbulletxPosition + nextxPosition)) &&
                    (localdustbulletnextyPosition <= (initialdustbulletyPosition + nextyPosition))) {

                setxVelocity((float) (-fps * ((initialdustbulletxPosition + nextxPosition) - localdustbulletnextxPosition) * .0000008));

                setyVelocity((float) (-fps * ((initialdustbulletyPosition + nextyPosition) - localdustbulletnextyPosition) * .0000008));


                if (getxVelocity() < -((initialdustbulletxPosition + nextxPosition) - localdustbulletnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            } else if ((localdustbulletnextxPosition >= (initialdustbulletxPosition + nextxPosition)) &&
                    (localdustbulletnextyPosition < (initialdustbulletyPosition + nextyPosition))) {


                setxVelocity((float) (fps * (localdustbulletnextxPosition - (initialdustbulletxPosition + nextxPosition)) * .0000008));
                setyVelocity((float) (-fps * ((initialdustbulletyPosition + nextyPosition) - localdustbulletnextyPosition) * .0000008));


                if (getxVelocity() > (localdustbulletnextxPosition - (initialdustbulletxPosition + nextxPosition))) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            } else if ((localdustbulletnextxPosition > (initialdustbulletxPosition + nextxPosition)) &&
                    (localdustbulletnextyPosition >= (initialdustbulletyPosition + nextyPosition))) {


                setxVelocity((float) (fps * (localdustbulletnextxPosition - (initialdustbulletxPosition + nextxPosition)) * .0000008));
                setyVelocity((float) (fps * (localdustbulletnextyPosition - (initialdustbulletyPosition + nextyPosition)) * .0000008));


                if (getxVelocity() > (localdustbulletnextxPosition - (initialdustbulletxPosition + nextxPosition))) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";
                }


            } else if ((localdustbulletnextxPosition <= (initialdustbulletxPosition + nextxPosition)) &&
                    (localdustbulletnextyPosition > (initialdustbulletyPosition + nextyPosition))) {


                setxVelocity((float) (-fps * ((initialdustbulletxPosition + nextxPosition) - localdustbulletnextxPosition) * .0000008));
                setyVelocity((float) (fps * (localdustbulletnextyPosition - (initialdustbulletyPosition + nextyPosition)) * .0000008));


                if (getxVelocity() < -((initialdustbulletxPosition + nextxPosition) - localdustbulletnextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            }
        }




    }


}
