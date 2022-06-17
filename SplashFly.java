package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 2/10/2017.
 */
public class SplashFly extends GameObject{

    float initialspaceflyxPosition;
    float initialspaceflyyPosition;
    float localspaceflynextxPosition;
    float localspaceflynextyPosition;
    
    
    SplashFly(){

        initialcondition = true;
        flip = false;
        condition = "firstcondition";
        circledistance = 1;

        currentxWorld = 0;
        currentyWorld = 0;
        setBitmapNameRight("splashflyright");
        setBitmapNameLeft("splashflyleft");
        setBitmapNameJumpRight("splashflyjumpright");
        setType('y');
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

    void updateEnemy(float fps, float spaceflynextxPosition, float spaceflynextyPosition, float BeginX,
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

            initialspaceflyxPosition = currentxWorld;
            initialspaceflyyPosition = currentyWorld;

            currentxWorld = (float) (200 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (225 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));


        } else if ((double) getxVelocity() * 15 < 900) {


            initialspaceflyxPosition = currentxWorld;
            initialspaceflyyPosition = currentyWorld;


            currentxWorld = (float) (250 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (225 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        } else if ((double) getxVelocity() * 15 < 990) {


            initialspaceflyxPosition = currentxWorld;
            initialspaceflyyPosition = currentyWorld;


            currentxWorld = (float) (250 * circledistance * Math.cos(Math.toRadians((double) getxVelocity() * 15)));
            currentyWorld = (float) (275 * circledistance * Math.sin(Math.toRadians((double) getxVelocity() * 15)));

        }
    }

     if((double) getxVelocity() * 15 > 720 && condition.matches("secondcondition")) {

            if ((spaceflynextxPosition < initialspaceflyxPosition) &&
                    (spaceflynextyPosition <= initialspaceflyyPosition)) {


                float currentdistance = ((spaceflynextxPosition - initialspaceflyxPosition) * (spaceflynextxPosition - initialspaceflyxPosition)) +
                        ((spaceflynextyPosition - initialspaceflyyPosition) * (spaceflynextyPosition - initialspaceflyyPosition));
                
                float nextdistance = ((spaceflynextxPosition - currentxWorld) * (spaceflynextxPosition - currentxWorld)) +
                        ((spaceflynextyPosition - currentyWorld) * (spaceflynextyPosition - currentyWorld));


                if(nextdistance > currentdistance){


                    localspaceflynextxPosition = spaceflynextxPosition;
                    localspaceflynextyPosition = spaceflynextyPosition;
                    
                    currentxWorld = initialspaceflyxPosition;
                    currentyWorld = initialspaceflyyPosition;


                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();


                    condition = "thirdcondition";
                }




            } else if ((spaceflynextxPosition >= initialspaceflyxPosition) &&
                    (spaceflynextyPosition < initialspaceflyyPosition)) {


                float currentdistance = ((spaceflynextxPosition - initialspaceflyxPosition) * (spaceflynextxPosition - initialspaceflyxPosition)) +
                        ((spaceflynextyPosition - initialspaceflyyPosition) * (spaceflynextyPosition - initialspaceflyyPosition));

                float nextdistance = ((spaceflynextxPosition - currentxWorld) * (spaceflynextxPosition - currentxWorld)) +
                        ((spaceflynextyPosition - currentyWorld) * (spaceflynextyPosition - currentyWorld));


                if(nextdistance > currentdistance){


                    localspaceflynextxPosition = spaceflynextxPosition;
                    localspaceflynextyPosition = spaceflynextyPosition;
                    
                    currentxWorld = initialspaceflyxPosition;
                    currentyWorld = initialspaceflyyPosition;



                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();


                    condition = "thirdcondition";
                }




            } else if ((spaceflynextxPosition > initialspaceflyxPosition) &&
                    (spaceflynextyPosition >= initialspaceflyyPosition)) {


                
                float currentdistance = ((spaceflynextxPosition - initialspaceflyxPosition) * (spaceflynextxPosition - initialspaceflyxPosition)) +
                        ((spaceflynextyPosition - initialspaceflyyPosition) * (spaceflynextyPosition - initialspaceflyyPosition));

                float nextdistance = ((spaceflynextxPosition - currentxWorld) * (spaceflynextxPosition - currentxWorld)) +
                        ((spaceflynextyPosition - currentyWorld) * (spaceflynextyPosition - currentyWorld));


                if(nextdistance > currentdistance)

                {


                    localspaceflynextxPosition = spaceflynextxPosition;
                    localspaceflynextyPosition = spaceflynextyPosition;


                    currentxWorld = initialspaceflyxPosition;
                    currentyWorld = initialspaceflyyPosition;



                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();

                    condition = "thirdcondition";
                }

            } else if ((spaceflynextxPosition <= initialspaceflyxPosition) &&
                    (spaceflynextyPosition > initialspaceflyyPosition)) {

                float currentdistance = ((spaceflynextxPosition - initialspaceflyxPosition) * (spaceflynextxPosition - initialspaceflyxPosition)) +
                        ((spaceflynextyPosition - initialspaceflyyPosition) * (spaceflynextyPosition - initialspaceflyyPosition));

                float nextdistance = ((spaceflynextxPosition - currentxWorld) * (spaceflynextxPosition - currentxWorld)) +
                        ((spaceflynextyPosition - currentyWorld) * (spaceflynextyPosition - currentyWorld));


                if(nextdistance > currentdistance){
                    currentxWorld = initialspaceflyxPosition;
                    currentyWorld = initialspaceflyyPosition;

                    localspaceflynextxPosition = spaceflynextxPosition;
                    localspaceflynextyPosition = spaceflynextyPosition;



                    setWorldLocation(currentxWorld + BeginX, currentyWorld + BeginY);
                    resetxVelocity();

                    condition = "thirdcondition";
                }


            }
        }



          else  if(condition.matches("thirdcondition")) {

            if ((localspaceflynextxPosition < (initialspaceflyxPosition + nextxPosition)) &&
                    (localspaceflynextyPosition <= (initialspaceflyyPosition + nextyPosition))) {

                setxVelocity((float) (-fps * ((initialspaceflyxPosition + nextxPosition) - localspaceflynextxPosition) * .0000008));

                setyVelocity((float) (-fps * ((initialspaceflyyPosition + nextyPosition) - localspaceflynextyPosition) * .0000008));


                if (getxVelocity() < -((initialspaceflyxPosition + nextxPosition) - localspaceflynextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            } else if ((localspaceflynextxPosition >= (initialspaceflyxPosition + nextxPosition)) &&
                    (localspaceflynextyPosition < (initialspaceflyyPosition + nextyPosition))) {


                setxVelocity((float) (fps * (localspaceflynextxPosition - (initialspaceflyxPosition + nextxPosition)) * .0000008));
                setyVelocity((float) (-fps * ((initialspaceflyyPosition + nextyPosition) - localspaceflynextyPosition) * .0000008));


                if (getxVelocity() > (localspaceflynextxPosition - (initialspaceflyxPosition + nextxPosition))) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            } else if ((localspaceflynextxPosition > (initialspaceflyxPosition + nextxPosition)) &&
                    (localspaceflynextyPosition >= (initialspaceflyyPosition + nextyPosition))) {


                setxVelocity((float) (fps * (localspaceflynextxPosition - (initialspaceflyxPosition + nextxPosition)) * .0000008));
                setyVelocity((float) (fps * (localspaceflynextyPosition - (initialspaceflyyPosition + nextyPosition)) * .0000008));


                if (getxVelocity() > (localspaceflynextxPosition - (initialspaceflyxPosition + nextxPosition))) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";
                }


            } else if ((localspaceflynextxPosition <= (initialspaceflyxPosition + nextxPosition)) &&
                    (localspaceflynextyPosition > (initialspaceflyyPosition + nextyPosition))) {


                setxVelocity((float) (-fps * ((initialspaceflyxPosition + nextxPosition) - localspaceflynextxPosition) * .0000008));
                setyVelocity((float) (fps * (localspaceflynextyPosition - (initialspaceflyyPosition + nextyPosition)) * .0000008));


                if (getxVelocity() < -((initialspaceflyxPosition + nextxPosition) - localspaceflynextxPosition)) {
                    resetxVelocity();
                    resetyVelocity();

                    condition = "deadcondition";

                }


            }
        }




    }


}
