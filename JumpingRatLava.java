package com.verticesstudio.frogfungi;

import java.util.Random;

/**
 * Created by kucrut on 12/10/2016.
 */
public class JumpingRatLava extends  GameObject{



    JumpingRatLava() {

    initialcondition = true;

    currentxWorld = 0;
    currentyWorld = 0;
    nextxPosition = 0;
    nextyPosition = 0;

    setBitmapNameRight("jumpingratlavaright");
    setBitmapNameLeft("jumpingratlavaleft");
    setBitmapNameJumpRight("jumpingratlavajumpright");
    setBitmapNameJumpLeft("jumpingratlavajumpleft");

    setType('J');
    setFacing("RIGHT");

    worldLocation = new Vector2Point5D();
    rectHitboxtop = new RectHitbox();
    rectHitboxright = new RectHitbox();
    rectHitboxbottom = new RectHitbox();
    rectHitboxleft = new RectHitbox();
    rand = new Random();

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

    void updateEnemy(float fps, float jumpingratlavanextxPosition, float jumpingratlavanextyPosition, float initialjumpingratlavaxPosition,
                     float initialjumpingratlavayPosition){


        if ((jumpingratlavanextxPosition < initialjumpingratlavaxPosition) &&
                (jumpingratlavanextyPosition <= initialjumpingratlavayPosition)) {

            setFacing("LEFT");

            setxVelocity((float) (-fps * (initialjumpingratlavaxPosition - jumpingratlavanextxPosition) * .00002));


            if (getxVelocity() > -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition) / 2) {

                setyVelocity((float) ((-fps * (initialjumpingratlavayPosition - jumpingratlavanextyPosition) * .00002) -
                        (fps * .0005)));
            } else if (getxVelocity() < -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition) / 2) {

                setyVelocity((float) ((-fps * (initialjumpingratlavayPosition - jumpingratlavanextyPosition) * .00002) +
                        (fps * .0005)));
            }





            if (getxVelocity() < -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition)) {
                resetxVelocity();
                resetyVelocity();
            }


        }





        else if ((jumpingratlavanextxPosition >= initialjumpingratlavaxPosition) &&
                (jumpingratlavanextyPosition < initialjumpingratlavayPosition)) {

            setFacing("RIGHT");

            setxVelocity((float)(fps * (jumpingratlavanextxPosition - initialjumpingratlavaxPosition) * .00002));


            if(getxVelocity() < (jumpingratlavanextxPosition - initialjumpingratlavaxPosition)/2) {

                setyVelocity((float) ((-fps * (initialjumpingratlavayPosition - jumpingratlavanextyPosition) * .00002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (jumpingratlavanextxPosition - initialjumpingratlavaxPosition)/2) {

                setyVelocity((float) ((-fps * (initialjumpingratlavayPosition - jumpingratlavanextyPosition) * .00002) +
                        (fps * .0005)));
            }







            if(getxVelocity() > (jumpingratlavanextxPosition - initialjumpingratlavaxPosition) ){
                resetxVelocity();
                resetyVelocity();

            }








        }


        else if ((jumpingratlavanextxPosition > initialjumpingratlavaxPosition) &&
                (jumpingratlavanextyPosition >= initialjumpingratlavayPosition)) {


            setFacing("RIGHT");

            setxVelocity((float)(fps * (jumpingratlavanextxPosition - initialjumpingratlavaxPosition) * .00002));


            if(getxVelocity() < (jumpingratlavanextxPosition - initialjumpingratlavaxPosition)/2) {

                setyVelocity((float) ((fps * (jumpingratlavanextyPosition - initialjumpingratlavayPosition) * .00002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() > (jumpingratlavanextxPosition - initialjumpingratlavaxPosition)/2) {

                setyVelocity((float) ((fps * (jumpingratlavanextyPosition - initialjumpingratlavayPosition) * .00002) +
                        (fps * .0005)));
            }






            if(getxVelocity() > (jumpingratlavanextxPosition - initialjumpingratlavaxPosition) ){
                resetxVelocity();
                resetyVelocity();
            }









        }


        else if ((jumpingratlavanextxPosition <= initialjumpingratlavaxPosition) &&
                (jumpingratlavanextyPosition > initialjumpingratlavayPosition)) {

            setFacing("LEFT");

            setxVelocity((float)(-fps * (initialjumpingratlavaxPosition - jumpingratlavanextxPosition) * .00002));



            if(getxVelocity() > -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition)/2) {

                setyVelocity((float) ((fps * (jumpingratlavanextyPosition - initialjumpingratlavayPosition) * .00002) -
                        (fps * .0005)));
            }

            else if(getxVelocity() < -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition)/2) {

                setyVelocity((float) ((fps * (jumpingratlavanextyPosition - initialjumpingratlavayPosition) * .00002) +
                        (fps * .0005)));
            }





            if(getxVelocity() < -(initialjumpingratlavaxPosition - jumpingratlavanextxPosition) ){
                resetxVelocity();
                resetyVelocity();


            }







        }




    }


}
