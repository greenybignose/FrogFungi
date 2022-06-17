package com.verticesstudio.frogfungi;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class InputController implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    private GestureDetectorCompat gDetector;
    private LevelManager lgic;
    boolean Topedge;
    boolean Bottomedge;
    boolean Leftedge;
    boolean Rightedge;
    float posxinWorld;
    float posyinWorld;
    boolean frogfungi;
    boolean worlds;
    boolean frommain;

    int nextxPosition;
    int nextyPosition;
    FrogFungiPlayerState frogFungiPlayerStateic;
    boolean hit;

    InputController(LevelManager lic, FrogFungiPlayerState frogFungiPlayerStateic) {

        this.frogFungiPlayerStateic = frogFungiPlayerStateic;
        lgic = lic;
        Topedge = false;
        Bottomedge = false;
        Rightedge = false;
        Leftedge = false;

        gDetector = new GestureDetectorCompat(MainActivity.getmyAppcontext(), this);
        gDetector.setOnDoubleTapListener(this);


    }


    public void handleInput(MotionEvent motionEvent) {

        this.gDetector.onTouchEvent(motionEvent);

        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {


        }
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {


        return true;
    }


    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d("onLongPress: ", motionEvent.toString());
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent1, MotionEvent motionEvent2, float distanceX,
                            float distanceY) {
        if (motionEvent1.getAction() == MotionEvent.ACTION_DOWN && motionEvent2.getAction() == MotionEvent.ACTION_MOVE
                && motionEvent2.getPointerCount() == 1) {


            if (motionEvent1.getX() > motionEvent2.getX()) {
                Leftedge = false;
                if (Rightedge == false) {
                    lgic.bgLandscape.setxVelocity(distanceX);
                }

            }


            if (motionEvent1.getX() < motionEvent2.getX()) {
                Rightedge = false;
                if (Leftedge == false) {
                    lgic.bgLandscape.setxVelocity(distanceX);
                }
            }


            if (motionEvent1.getY() < motionEvent2.getY()) {
                Bottomedge = false;
                if (Topedge == false) {
                    lgic.bgLandscape.setyVelocity(distanceY);
                }
            }


            if (motionEvent1.getY() > motionEvent2.getY()) {
                Topedge = false;
                if (Bottomedge == false) {
                    lgic.bgLandscape.setyVelocity(distanceY);
                }
            }


        }

        return true;
    }




    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d("onShowPress: ", motionEvent.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {


        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {

        if(MainActivity.initialload == true || MainActivity.newLevelUp == true){
            MainActivity.initialload = false;
            MainActivity.newLevelUp = false;
        }

        if(MainActivity.initialload == false && MainActivity.newLevelUp == false) {
            boolean firstcondition = checkfirstcondition(motionEvent.getX(), motionEvent.getY());


            if (firstcondition == true) {
                boolean secondcondition = checksecondcondition();

                if (secondcondition == true) {
                    boolean thirdcondition = checkthirdcondition();

                    if (thirdcondition == true) {

                        if(!lgic.frogFungiPlayer.getChangeFrogPosition()) {
                            lgic.frogFungiPlayer.setnextxPosition(nextxPosition);
                            lgic.frogFungiPlayer.setnextyPosition(nextyPosition);
                            lgic.frogFungiPlayer.setChangeFrogPosition(true);
                            lgic.soundManager.playSound("frogjump");
                            if(frogFungiPlayerStateic.getWorld().matches("Ocean")) {
                                lgic.soundManager.playSound("oceanwave");
                            }
                            else if(frogFungiPlayerStateic.getWorld().matches("Lava")){
                                lgic.soundManager.playSound("lava");
                            }

                        }
                    }
                }

            }
        }

        return true;

         }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            if (lgic.frogFungiPlayer.getRectHitboxdclick().contains(motionEvent.getX(), motionEvent.getY())) {

                frogfungi = true;
                worlds = false;
                frommain = true;

                Intent frogfungiReport = new Intent(MainActivity.contextMain, FrogFungiReport.class);
                frogfungiReport.putExtra("backgroundx", lgic.bgLandscape.getbackgroundxResolution());
                frogfungiReport.putExtra("backgroundy", lgic.bgLandscape.getbackgroundyResolution());
                frogfungiReport.putExtra("frogfungi", frogfungi);
                frogfungiReport.putExtra("worlds", worlds);
                frogfungiReport.putExtra("lives", frogFungiPlayerStateic.getLives());
                frogfungiReport.putExtra("worldlevel", frogFungiPlayerStateic.getWorld());
                frogfungiReport.putExtra("levels", frogFungiPlayerStateic.getLevel());
                frogfungiReport.putExtra("prey", frogFungiPlayerStateic.getPrey());
                frogfungiReport.putExtra("food", frogFungiPlayerStateic.getFood());
                frogfungiReport.putExtra("frommain", frommain);

                MainActivity.contextMain.startActivity(frogfungiReport);

            }
        }

        return true;
    }



    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2,
                           float velocityX, float velocityY) {


        return false;
    }

  

    boolean checkfirstcondition(float motionEventX, float motionEventY) {

        hit = false;


        getlocationinWorld(motionEventX, motionEventY);


        for (int x = 0; x < lgic.bgLandscape.fungiArray.length; x += 2) {
            if ((lgic.bgLandscape.fungiArray[x] > (posxinWorld - lgic.bgLandscape.getbackgroundxResolution() / 2)) &&
                    (lgic.bgLandscape.fungiArray[x] < (posxinWorld + lgic.bgLandscape.getbackgroundxResolution() / 2)) &&

                (lgic.bgLandscape.fungiArray[x + 1] > (posyinWorld - lgic.bgLandscape.getbackgroundyResolution() / 2)) &&
                        (lgic.bgLandscape.fungiArray[x + 1] < (posyinWorld + lgic.bgLandscape.getbackgroundyResolution() / 2))) {

                    hit = true;
                    nextxPosition = lgic.bgLandscape.fungiArray[x];
                    nextyPosition = lgic.bgLandscape.fungiArray[x + 1];


                }





            else if (frogFungiPlayerStateic.getLevel().matches("LevelTwo") && hit == false) {
                if ((lgic.bgLandscape.fungiArray[x] > (posxinWorld - lgic.bgLandscape.getbackgroundxResolution() / 2)) &&
                        (lgic.bgLandscape.fungiArray[x]  < (posxinWorld + lgic.bgLandscape.getbackgroundxResolution() / 2))) {


                    if (((lgic.bgLandscape.fungiArray[x + 1] + (lgic.bgLandscape.getbackgroundyResolution() * 2))
                            > (posyinWorld - lgic.bgLandscape.getbackgroundyResolution() / 2)) &&
                            ((lgic.bgLandscape.fungiArray[x + 1] + (lgic.bgLandscape.getbackgroundyResolution() * 2))
                                    < (posyinWorld + lgic.bgLandscape.getbackgroundyResolution() / 2))) {

                        hit = true;
                        nextxPosition = lgic.bgLandscape.fungiArray[x];
                        nextyPosition = lgic.bgLandscape.fungiArray[x + 1] +  (int)lgic.bgLandscape.getbackgroundyResolution() * 2;




                    }
                }
            }

            }




            return hit;

    }

    boolean checksecondcondition() {
        boolean hit = false;


        if(Math.sqrt((double) ((nextxPosition - (-(lgic.BeginX) + (lgic.frogFungiPlayer.getWorldLocation().x + lgic.bgLandscape.getbackgroundxResolution()/2))) *
                (nextxPosition - (-(lgic.BeginX) + (lgic.frogFungiPlayer.getWorldLocation().x + lgic.bgLandscape.getbackgroundxResolution()/2))) +
                (nextyPosition - (-(lgic.BeginY) + (lgic.frogFungiPlayer.getWorldLocation().y + lgic.bgLandscape.getbackgroundyResolution()))) *
                        (nextyPosition - (-(lgic.BeginY) + (lgic.frogFungiPlayer.getWorldLocation().y + lgic.bgLandscape.getbackgroundyResolution())))))  <
                (double) (lgic.bgLandscape.getbackgroundxResolution() * 15))

        {

            hit = true;

            return hit;

        }

        return hit;
    }

        boolean checkthirdcondition(){
                boolean hit = false;


            int origX = (int)(-(lgic.BeginX) + (lgic.frogFungiPlayer.getWorldLocation().x + lgic.bgLandscape.getbackgroundxResolution()/2));
            int origY = (int) (-(lgic.BeginY) + (lgic.frogFungiPlayer.getWorldLocation().y + lgic.bgLandscape.getbackgroundyResolution()));

                    for(int x = 0; x < lgic.bgLandscape.fungiArray.length; x += 2){
                        if ( lgic.bgLandscape.fungiArray[x] == origX){
                            for( int y = 1; y < lgic.bgLandscape.fungiArray.length; y += 2){
                                if(lgic.bgLandscape.fungiArray[y] == origY){

                                    if(frogFungiPlayerStateic.getLevel().matches("LevelOne") && frogFungiPlayerStateic.getWorld().matches("Ocean")) {

                                        if (x == 18 && y == 19) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[26]) && (nextyPosition == lgic.bgLandscape.fungiArray[27])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 26 && y == 27) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if (nextxPosition == lgic.bgLandscape.fungiArray[18] && nextyPosition == lgic.bgLandscape.fungiArray[19]) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                    }

                                    else if(frogFungiPlayerStateic.getLevel().matches("LevelThree") && frogFungiPlayerStateic.getWorld().matches("Ocean")) {
                                        if (nextxPosition == lgic.bgLandscape.fungiArray[30] && nextyPosition == lgic.bgLandscape.fungiArray[31]) {
                                            if (lgic.bgLandscape.fungitype != "adultfungi") {
                                                hit = false;
                                                return hit;

                                            }

                                            if (nextxPosition == lgic.bgLandscape.fungiArray[40] && nextyPosition == lgic.bgLandscape.fungiArray[41]) {
                                                if (lgic.bgLandscape.fungitypesecond != "adultfungisecond") {
                                                    hit = false;
                                                    return hit;

                                                }


                                            }
                                        }
                                    }

                                    else if(frogFungiPlayerStateic.getLevel().matches("LevelOne") && frogFungiPlayerStateic.getWorld().matches("Lava")) {

                                        if (x == 30 && y == 31) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 34 && y == 35) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }


                                        }


                                        if (x == 52 && y == 53) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 56 && y == 57) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }
                     
                                        }

                                        if(checkprivnextfungilava(x, y) == true) {
                                            hit = true;
                                            return hit;
                                        }
                                        
                                    }



                                    else if(frogFungiPlayerStateic.getLevel().matches("LevelTwo") && frogFungiPlayerStateic.getWorld().matches("Lava")) {

                                        if (x == 10 && y == 11) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 14 && y == 15) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }


                                        }


                                        if (x == 58 && y == 59) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 62 && y == 63) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (checkprivnextfungilava(x, y) == true) {
                                            hit = true;
                                            return hit;
                                        }


                                    }


                                    else if(frogFungiPlayerStateic.getLevel().matches("LevelThree") && frogFungiPlayerStateic.getWorld().matches("Lava")) {

                                        if (x == 60 && y == 61) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 64 && y == 65) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }


                                        }


                                        if (x == 44 && y == 45) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 48 && y == 49) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if(checkprivnextfungilava(x, y) == true) {
                                            hit = true;
                                            return hit;
                                        }

                                    }

                                    else if(frogFungiPlayerStateic.getLevel().matches("LevelFour") && frogFungiPlayerStateic.getWorld().matches("Lava")) {

                                        if (x == 18 && y == 19) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 22 && y == 23) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[74]) && (nextyPosition == lgic.bgLandscape.fungiArray[75])) {
                                                hit = true;
                                                return hit;
                                            }


                                        }


                                        if (x == 6 && y == 7) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if (x == 10 && y == 11) {
                                            if (checkprivnext(x, y) == true) {
                                                hit = true;
                                                return hit;
                                            }

                                            if ((nextxPosition == lgic.bgLandscape.fungiArray[76]) && (nextyPosition == lgic.bgLandscape.fungiArray[77])) {
                                                hit = true;
                                                return hit;
                                            }

                                        }

                                        if(checkprivnextfungilava(x, y) == true) {
                                            hit = true;
                                            return hit;
                                        }

                                    }


                                    if (checkprivnext(x, y) == true) {
                                        hit = true;
                                        return hit;
                                    }



                                }


                            }


                        }
                    }



return hit;


}
       
    boolean checkprivnextfungilava(int xfungilava, int yfungilava){
        boolean hit = false;

        if(!((xfungilava - 2) < 0) && !((yfungilava - 2) < 1)) {
            if ((nextxPosition == lgic.bgLandscape.fungiArray[xfungilava - 2]) &&
                    (nextyPosition == lgic.bgLandscape.fungiArray[yfungilava - 2] + (lgic.bgLandscape.getbackgroundyResolution() * 2))
                    ) {
                for (GameObject fungilava : lgic.fungilavagameObjects) {
                    if (((fungilava.getWorldLocation().x - lgic.BeginX) == nextxPosition) && ((fungilava.getWorldLocation().y - lgic.BeginY)== nextyPosition)) {

                        hit = true;
                        return hit;

                    }
                }
            }
        }

        if(!((xfungilava + 2) > (lgic.bgLandscape.fungiArray.length - 1)) && !((yfungilava + 2) > lgic.bgLandscape.fungiArray.length)){
            if ((nextxPosition == lgic.bgLandscape.fungiArray[xfungilava + 2]) &&
                    (nextyPosition == lgic.bgLandscape.fungiArray[yfungilava + 2] + (lgic.bgLandscape.getbackgroundyResolution() * 2))) {
                for (GameObject fungilava : lgic.fungilavagameObjects) {
                    if (((fungilava.getWorldLocation().x - lgic.BeginX) == nextxPosition) && ((fungilava.getWorldLocation().y - lgic.BeginY)== nextyPosition)) {

                        hit = true;
                        return hit;
                    }
                }


            }
        }



        return hit;


    } 

    boolean checkprivnext(int xfungiArray, int yfungiArray){
        boolean hit = false;



        if(!((xfungiArray - 2) < 0) && !((yfungiArray - 2) < 1)){
            if (nextxPosition == lgic.bgLandscape.fungiArray[xfungiArray - 2] && nextyPosition == lgic.bgLandscape.fungiArray[yfungiArray - 2]) {
                hit = true;
                return hit;
            }
        }



    if(!((xfungiArray + 2) > (lgic.bgLandscape.fungiArray.length - 1)) && !((yfungiArray + 2) > lgic.bgLandscape.fungiArray.length)){
        if (nextxPosition == lgic.bgLandscape.fungiArray[xfungiArray + 2] && nextyPosition == lgic.bgLandscape.fungiArray[yfungiArray + 2]) {
            hit = true;
            return hit;
        }
    }



        return hit;
    }



    void getlocationinWorld(float motionEventX, float motionEventY){

        posxinWorld = -(lgic.BeginX - lgic.bgLandscape.getxVelocity()) + motionEventX;

        posyinWorld = -(lgic.BeginY - lgic.bgLandscape.getyVelocity()) + motionEventY;

    }


}

