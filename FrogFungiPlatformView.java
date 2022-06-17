package com.verticesstudio.frogfungi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class FrogFungiPlatformView extends SurfaceView   implements Runnable {

    private volatile boolean running;
    private Thread gameThread = null;
    private FrogFungiPlayerState ps;


    private Paint paint;
    private Bitmap bitmap;
    private Boolean UpdateFinish;
    private int xreserved;
    private int steprightbottom;
    private int stepleftbottom;

    private Canvas canvas;
    private Canvas levelcanvas;
    private SurfaceHolder ourHolder;
    long startFrameTime;
    long timeThisFrame;
    long fps;
    boolean oceanwaveplay;
    boolean frogsingplay;

    LevelManager lm;
    InputController ic;
    FrogFungiPlayerState frogFungiPlayerState;
    ArrayList<Integer> fungihasChanged;

    int suckerbeegravrandom;
    int transparentchubrandom;
    boolean hasSucked;


    FrogFungiPlatformView(FrogFungiPlayerState frogFungiPlayerState) {
        super(MainActivity.getmyAppcontext());







        this.frogFungiPlayerState = frogFungiPlayerState;

        ourHolder = getHolder();
        paint = new Paint();
        fungihasChanged = new ArrayList<Integer>();

        suckerbeegravrandom = 6;
        transparentchubrandom = 6;
        oceanwaveplay = false;
        frogsingplay = false;
        hasSucked = false;

        loadLevel(frogFungiPlayerState);


    }

    @Override
    public void run() {


        while (running) {


            startFrameTime = System.currentTimeMillis();

            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
                UpdateFinish = false;

                update();
                draw();
                lastUpdate();
            }
        }
    }

    private void update() {

        if (MainActivity.initialload == false && MainActivity.newLevelUp == false) {
            if (lm.bgLandscape.getxVelocity() >= ((lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution() / 2) - (MainActivity.resolutionx / 2))) {
                ic.Rightedge = true;
                lm.bgLandscape.resetxVelocity();
                lm.bgLandscape.setxVelocity((lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution() / 2) - (MainActivity.resolutionx / 2));


            }

            if (lm.bgLandscape.getxVelocity() <= -(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution() / 2) + (MainActivity.resolutionx / 2)) {
                ic.Leftedge = true;
                lm.bgLandscape.resetxVelocity();
                lm.bgLandscape.setxVelocity(-(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution() / 2) + (MainActivity.resolutionx / 2));

            }

            if (lm.bgLandscape.getyVelocity() >= ((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution() / 2) - (MainActivity.resolutiony / 2))) {
                ic.Bottomedge = true;
                lm.bgLandscape.resetyVelocity();
                lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution() / 2) - (MainActivity.resolutiony / 2));
            }

            if (lm.bgLandscape.getyVelocity() <= -(lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution() / 2) + (MainActivity.resolutiony / 2)) {
                ic.Topedge = true;
                lm.bgLandscape.resetyVelocity();
                lm.bgLandscape.setyVelocity(-(lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution() / 2) + (MainActivity.resolutiony / 2));
            }


            frogfungiUpdate();


            initialandarrivePosFrog();


            if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                smalloceanfishUpdate();
                bigoceanfishUpdate();

                beegravUpdate();

                bighorngravUpdate();

                
                if (lm.beegravgameObjects.isEmpty()) {
                    bigbeegravUpdate();
                    sandladybugUpdate();

                }


                if (lm.frogFungiPlayer.condition.matches("secondcondition")) {

                    oceanbugUpdate();
                } else if ((lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[26])
                        && (lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[27])) {

                    lm.frogFungiPlayer.condition = "secondcondition";

                }


                if (lm.bighorngravgameObjects.isEmpty()) {


                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelTwo");
                    frogFungiPlayerState.setWorld("Ocean");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelOne");
                    frogFungiPlayerState.setWorld("Ocean");


                }



            } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                smalloceanfishUpdate();
                bigoceanfishUpdate();


                beegravUpdate();
                beegravsecondLevelTwoOceanUpdate();


                if (lm.frogFungiPlayer.condition.matches("secondcondition") ||
                        lm.frogFungiPlayer.condition.matches("thirdcondition")) {

                    bigbeegravUpdate();
                    bigbeegravsecondLevelTwoOceanUpdate();
                    oceanbugsecondLevelTwoOceanUpdate();

                } else if ((lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[30])
                        && (lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[31])) {

                    lm.frogFungiPlayer.condition = "secondcondition";
                }


                if (lm.frogFungiPlayer.condition.matches("thirdcondition")) {

                    beegravthirdLevelTwoOceanUpdate();

                    beegravfourthLevelTwoOceanUpdate();


                } else if ((lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[46])
                        && (lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[47])) {

                    lm.frogFungiPlayer.condition = "thirdcondition";

                }


                guardianbeegravUpdate();
                sandladybugUpdate();


                oceanbugLevelTwoOceanUpdate();

                bighorngravUpdateLevelTwoOcean();


                if(lm.bighorngravgameObjects.isEmpty()){
                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelThree");
                    frogFungiPlayerState.setWorld("Ocean");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelTwo");
                    frogFungiPlayerState.setWorld("Ocean");


                }



            }

            else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {

               smalloceanfishUpdate();
                bigoceanfishUpdate();

                suckerbeegravUpdate();
                killerbeegravUpdate();

                beegravUpdate();


                bigbeegravUpdate();


                sandladybugUpdate();

                if (lm.suckerbeegravgameObjects.size() < 5) {
                    beegravsecondLevelTwoOceanUpdate();

                }

                if (lm.suckerbeegravgameObjects.size() < 4) {
                    bigbeegravsecondLevelThreeOceanUpdate();
                    ghostspinderswirlwaterLevelThreeOceanUpdate();

                }

                if (lm.suckerbeegravgameObjects.size() < 3) {
                   ghostspindersecondswirlwaterLevelThreeOceanUpdate();

                    ghostspinderstargravLevelThreeOceanUpdate();


                    beegravthirdLevelTwoOceanUpdate();
                }

                if (lm.suckerbeegravgameObjects.size() < 2) {
                    ghostspinderthirdswirlwaterLevelThreeOceanUpdate();


                    ghostspindersecondstargravLevelThreeOceanUpdate();

                    ghostspinderthirdstargravLevelThreeOceanUpdate();


                }


                if(lm.suckerbeegravgameObjects.isEmpty() && lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[46]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[47]){
                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelFour");
                    frogFungiPlayerState.setWorld("Ocean");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelThree");
                    frogFungiPlayerState.setWorld("Ocean");


                }





            } else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                smalloceanfishUpdate();
                bigoceanfishUpdate();
                suckerbeegravUpdateLevelFourOcean();

                beegravfourthLevelTwoOceanUpdate();
                beegravsecondLevelFourOceanUpdate();




                waterdropUpdate();



                if (lm.suckerbeegravgameObjects.size() < 5) {
                    beegravthirdLevelTwoOceanUpdate();
                    ghostspinderstargravLevelFourOceanUpdate();
                    oceanbugfourthLevelFourOceanUpdate();
                    ghostspinderswirlwaterLevelFourOceanUpdate();
            }

                if (lm.suckerbeegravgameObjects.size() < 4) {
                    oceanbugthirdLevelFourOceanUpdate();
                    ghostspindersecondswirlwaterLevelFourOceanUpdate();
                    ghostspindersecondstargravLevelFourOceanUpdate();

                }

                if (lm.suckerbeegravgameObjects.size() < 3) {
                    oceanbugsecondLevelTwoOceanUpdate();
                    beegravLevelFourOceanUpdate();

                }

                if (lm.suckerbeegravgameObjects.size() < 2) {
                    oceanbugLevelTwoOceanUpdate();
                    ghostspindersplashflyLevelFourOceanUpdate();
                }




                if(lm.suckerbeegravgameObjects.isEmpty() && lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[46]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[47] &&
                        frogFungiPlayerState.getFood() > 13000){

                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelOne");
                    frogFungiPlayerState.setWorld("Lava");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelFour");
                    frogFungiPlayerState.setWorld("Ocean");



                }


            } else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {


                smalllavafishUpdate();
                biglavafishUpdate();

                rockbeegravUpdate();


                dustrockbeegravlavaUpdate();


                fungilavaUpdate();

                jumpingratlavaUpdate();


                if (lm.fungilavagameObjects.size() < 4) {
                    rockbigbeegravUpdate();

                    rockbeegravsecondUpdate();
                }

                if (lm.fungilavagameObjects.size() < 3) {
                    rockbigbeegravsecondUpdate();

                }


                if(lm.fungilavagameObjects.isEmpty() && lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[72]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[73]){
                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelTwo");
                    frogFungiPlayerState.setWorld("Lava");

                    callingTransientActivity();
                    frogFungiPlayerState.setLevel("LevelOne");
                    frogFungiPlayerState.setWorld("Lava");


                }



            } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {


                smalllavafishUpdate();
                biglavafishUpdate();

                rockbeegravUpdate();
                

                rockbigbeegravUpdate();

                dustrockbeegravlavaUpdate();


                fungilavaUpdate();


                transparentchubUpdate();

                jumpingratlavaUpdate();


                if(lm.transparentchubgameObjects.size() < 4) {

                    rockbeegravsecondUpdate();
                    rockbigbeegravsecondUpdate();
                     dustrockbeegravlavasecondLevelTwoUpdate();
                }


                if(lm.transparentchubgameObjects.size() < 3) {
                    rockbeegravthirdLevelTwoLavaUpdate();

                    rockbigbeegravthirdLevelTwoUpdate();
                    dustrockbeegravlavathirdLevelTwoUpdate();

                }

             if(lm.transparentchubgameObjects.size() < 2) {
                    rockbeegravfourthLevelTwoLavaUpdate();

                    rockbigbeegravfourthLevelTwoUpdate();

                    dustrockbeegravlavafourthLevelTwoUpdate();

                }

                if(lm.fungilavagameObjects.size() < 3){
                    ghostspinderbigdustrockbeegravlavaLevelTwoLavaUpdate();

                }


                if(lm.fungilavagameObjects.isEmpty() && lm.transparentchubgameObjects.isEmpty() &&
                        lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[72]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[73]){
                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelThree");
                    frogFungiPlayerState.setWorld("Lava");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelTwo");
                    frogFungiPlayerState.setWorld("Lava");


                }



            }


            else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {


                smalllavafishUpdate();
                biglavafishUpdate();

                lavafurLevelThreeLavaUpdate();

                rockbeegravUpdate();



                barkbugUpdate();

                lavadropUpdate();




               gravitycloudLevelThreeLavaUpdate();

                if(lm.gravitycloudgameObjects.size() < 5) {

                    rockbeegravsecondUpdate();
                    rockbigbeegravUpdate();

                    ghostspinderbigdustrockbeegravlavaLevelTwoLavaUpdate();

                }

                 if(lm.gravitycloudgameObjects.size() < 4) {
                    rockbigbeegravsecondUpdate();
                    rockbeegravthirdLevelTwoLavaUpdate();
                    ghostspindersecondbigdustrockbeegravlavaLevelThreeLavaUpdate();
                 }

                if(lm.gravitycloudgameObjects.size() < 3) {
                    rockbeegravfourthLevelTwoLavaUpdate();
                    ghostspinderthirdbigdustrockbeegravlavaLevelThreeLavaUpdate();


                }


                if(lm.gravitycloudgameObjects.size() < 2) {

                    ghostspinderfourthbigdustrockbeegravlavaLevelThreeLavaUpdate();

                }


                if(lm.gravitycloudgameObjects.isEmpty() && lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[72]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[73]){
                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelFour");
                    frogFungiPlayerState.setWorld("Lava");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelThree");
                    frogFungiPlayerState.setWorld("Lava");


                }



            } else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {


                smalllavafishUpdate();
                biglavafishUpdate();

                lavafurLevelThreeLavaUpdate();

                rockbeegravUpdate();






             redbubbleUpdate();


               gravitycloudLevelThreeLavaUpdate();


                if(lm.gravitycloudgameObjects.size() < 5) {
                    rockbeegravsecondUpdate();
                    bigdustrockbeegravlavaLevelFourUpdate();


                }

                if(lm.gravitycloudgameObjects.size() < 4) {
                    rockbeegravthirdLevelTwoLavaUpdate();
                    bigdustrockbeegravlavasecondLevelFourUpdate();
                }

                if(lm.gravitycloudgameObjects.size() < 3) {
                        rockbeegravfourthLevelTwoLavaUpdate();
                    bigdustrockbeegravlavathirdLevelFourUpdate();

                }


                if(lm.gravitycloudgameObjects.size() < 2) {
                    bigdustrockbeegravlavafourthLevelFourUpdate();

                }



                if(lm.gravitycloudgameObjects.isEmpty() && lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[72]
                        && lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[73] &&
                        frogFungiPlayerState.getFood() >= 13000){

                    frogFungiPlayerState.setLives(3);
                    frogFungiPlayerState.setLevel("LevelOne");
                    frogFungiPlayerState.setWorld("Ocean");

                    callingTransientActivity();

                    frogFungiPlayerState.setLevel("LevelFour");
                    frogFungiPlayerState.setWorld("Lava");

                }

            }



            UpdateFinish = true;
        }


    }

    private void draw() {


        if (MainActivity.initialload == true || MainActivity.newLevelUp == true) {

            paint.setAntiAlias(true);
            paint.setDither(true);

            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStyle(Paint.Style.FILL);

            if (bitmap == null) {

                if (frogFungiPlayerState.getWorld().matches("Ocean")) {

                    bitmap = Bitmap.createBitmap(MainActivity.resolutionx + 10, MainActivity.resolutiony,
                            Bitmap.Config.ARGB_8888);


                } else {
                    bitmap = Bitmap.createBitmap(MainActivity.resolutionx, MainActivity.resolutiony,
                            Bitmap.Config.ARGB_8888);

                }

            }


            levelcanvas = new Canvas(bitmap);

            drawlayerOneLine();
            drawlayerTwoLine();
            drawlayerThreeLine();
            drawlayerFourLine();
            drawlayerFiveLine();
            drawlayerSixLine();


            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();


                canvas.drawBitmap(bitmap, -10, 0, paint);

                paint.setColor(Color.argb(255, 0, 0, 255));
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(MainActivity.resolutiony / 12);

                drawlayerText();


                ourHolder.unlockCanvasAndPost(canvas);

            }
        } else if (MainActivity.initialload == false && MainActivity.newLevelUp == false) {

            bitmap = null;
            float xVelocity = 0;
            float yVelocity = 0;


            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                Matrix matrix = new Matrix();

                paint.setColor(Color.argb(255, 0, 0, 255));
                canvas.drawColor(Color.argb(255, 0, 0, 255));
                paint.setAntiAlias(true);
                paint.setDither(true);


                for (int y = 0; y < lm.bgLandscape.getHeight(); y++) {
                    for (int x = 0; x < lm.bgLandscape.getWidth(); x++) {
                        int m = (40 * y) + x;

                        tuningMap();



                        if (x == 0 && y == 0) {
                            canvas.drawBitmap(
                                    lm.bgLandscape.BackgroundBitmap.get(m),
                                    (lm.BeginX + lm.bgLandscape.getbackgroundxResolution() * x) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.getbackgroundyResolution() * y) - lm.bgLandscape.getyVelocity(),
                                    paint);

                            xVelocity = lm.bgLandscape.getxVelocity();
                            yVelocity = lm.bgLandscape.getyVelocity();

                        } else {

                            canvas.drawBitmap(
                                    lm.bgLandscape.BackgroundBitmap.get(m),
                                    (lm.BeginX + lm.bgLandscape.getbackgroundxResolution() * x) - xVelocity,
                                    (lm.BeginY + lm.bgLandscape.getbackgroundyResolution() * y) - yVelocity,
                                    paint);

                        }


                    }
                }

                for (int x = 0; x < lm.bgLandscape.funginumber.length; x++) {

                    if (frogFungiPlayerState.getWorld().matches("Ocean")) {
                        if (frogFungiPlayerState.getLevel().matches("LevelThree")) {
                            if (lm.bgLandscape.funginumber[x] == 15) {
                                lm.bgLandscape.fungitypepos = x;

                                if (lm.bgLandscape.fungitype.matches("babyfungi")) {

                                    if (lm.bgLandscape.oldTime == 0) {
                                        lm.bgLandscape.oldTime = System.nanoTime();
                                    }

                                    if (TimeUnit.SECONDS.convert(System.nanoTime() - lm.bgLandscape.oldTime, TimeUnit.NANOSECONDS) >= 15) {


                                        lm.bgLandscape.fungitype = "teenfungi";
                                        lm.bgLandscape.oldTime = 0;
                                    }
                                } else if (lm.bgLandscape.fungitype.matches("teenfungi")) {

                                    if (lm.bgLandscape.oldTime == 0) {
                                        lm.bgLandscape.oldTime = System.nanoTime();
                                    }

                                    if (TimeUnit.SECONDS.convert(System.nanoTime() - lm.bgLandscape.oldTime, TimeUnit.NANOSECONDS) >= 15) {


                                        lm.bgLandscape.fungitype = "adultfungi";
                                        lm.bgLandscape.oldTime = 0;
                                    }

                                }

                                continue;
                            }

                            if (lm.bgLandscape.funginumber[x] == 23) {
                                lm.bgLandscape.fungitypesecondpos = x;

                                if (lm.bgLandscape.fungitypesecond.matches("babyfungisecond")) {
                                    if (lm.bgLandscape.oldTimesecond == 0) {
                                        lm.bgLandscape.oldTimesecond = System.nanoTime();
                                    }

                                    if (TimeUnit.SECONDS.convert(System.nanoTime() - lm.bgLandscape.oldTimesecond, TimeUnit.NANOSECONDS) >= 15) {


                                        lm.bgLandscape.fungitypesecond = "teenfungisecond";
                                        lm.bgLandscape.oldTimesecond = 0;
                                    }


                                } else if (lm.bgLandscape.fungitypesecond.matches("teenfungisecond")) {

                                    if (lm.bgLandscape.oldTimesecond == 0) {
                                        lm.bgLandscape.oldTimesecond = System.nanoTime();
                                    }

                                    if (TimeUnit.SECONDS.convert(System.nanoTime() - lm.bgLandscape.oldTimesecond, TimeUnit.NANOSECONDS) >= 15) {


                                        lm.bgLandscape.fungitypesecond = "adultfungisecond";
                                        lm.bgLandscape.oldTimesecond = 0;
                                    }

                                }

                                continue;
                            }

                        }


                        if (lm.bgLandscape.funginumber[x] == 19) {
                            xreserved = x;

                            continue;
                        } else {


                            canvas.drawBitmap(lm.bgLandscape.fungiBitmap.get(lm.bgLandscape.funginumber[x] - 1),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[x * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(x * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);
                        }


                    } else if (frogFungiPlayerState.getWorld().matches("Lava")) {
                        if (frogFungiPlayerState.getLevel().matches("LevelTwo")) {

                            tonguewormUpdate(x);


                            for (int r = 0; r < fungihasChanged.size(); r++) {

                                if (x == fungihasChanged.get(r) / 2) {
                                    continue;
                                }

                            }


                        } else if (frogFungiPlayerState.getLevel().matches("LevelFour")) {
                            if (lm.bgLandscape.funginumber[x] == 19) {
                                canvas.drawBitmap(lm.bgLandscape.giantFungi,
                                        (lm.BeginX + lm.bgLandscape.listofinitialfungipos[x * 2]) - lm.bgLandscape.getxVelocity(),
                                        (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(x * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                        paint);

                                continue;
                            }

                        }


                        canvas.drawBitmap(lm.bgLandscape.fungiBitmap.get(lm.bgLandscape.funginumber[x] - 1),
                                (lm.BeginX + lm.bgLandscape.listofinitialfungipos[x * 2]) - lm.bgLandscape.getxVelocity(),
                                (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(x * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                paint);


                    }
                }


                if (frogFungiPlayerState.getWorld().matches("Ocean")) {
                    if (frogFungiPlayerState.getLevel().matches("LevelThree")) {
                        if (lm.bgLandscape.fungitype.matches("babyfungi")) {

                            canvas.drawBitmap(lm.bgLandscape.babyfungiBitmap.get(0),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypepos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypepos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        } else if (lm.bgLandscape.fungitype.matches("teenfungi")) {

                            canvas.drawBitmap(lm.bgLandscape.teenfungiBitmap.get(0),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypepos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypepos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        } else if (lm.bgLandscape.fungitype.matches("adultfungi")) {

                            canvas.drawBitmap(lm.bgLandscape.fungiBitmap.get(14),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypepos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypepos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }

                        if (lm.bgLandscape.fungitypesecond.matches("babyfungisecond")) {

                            canvas.drawBitmap(lm.bgLandscape.babyfungiBitmap.get(1),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypesecondpos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypesecondpos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        } else if (lm.bgLandscape.fungitypesecond.matches("teenfungisecond")) {

                            canvas.drawBitmap(lm.bgLandscape.teenfungiBitmap.get(1),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypesecondpos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypesecondpos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        } else if (lm.bgLandscape.fungitypesecond.matches("adultfungisecond")) {

                            canvas.drawBitmap(lm.bgLandscape.fungiBitmap.get(22),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[lm.bgLandscape.fungitypesecondpos * 2]) - lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(lm.bgLandscape.fungitypesecondpos * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }


                    } else if (frogFungiPlayerState.getLevel().matches("LevelFour")) {
                        for (int c = 0; c < fungihasChanged.size(); c++) {


                            int funginumberindex = 0;

                            for (int j = 0; j < lm.bgLandscape.funginumber.length; j++) {
                                if (lm.bgLandscape.funginumber[j] == lm.bgLandscape.fungispecialnumber[fungihasChanged.get(c)]) {
                                    funginumberindex = j;
                                }
                            }


                            canvas.drawBitmap(lm.bgLandscape.fungispecialBitmap.get(fungihasChanged.get(c)),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[
                                            funginumberindex * 2]) -
                                            lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[
                                            (funginumberindex * 2) + 1]) -
                                            lm.bgLandscape.getyVelocity(),
                                    paint);

                        }
                    }

                    canvas.drawBitmap(lm.bgLandscape.fungiBitmap.get(18),
                            (lm.BeginX + lm.bgLandscape.listofinitialfungipos[xreserved * 2]) - lm.bgLandscape.getxVelocity(),
                            (lm.BeginY + lm.bgLandscape.listofinitialfungipos[(xreserved * 2) + 1]) - lm.bgLandscape.getyVelocity(),
                            paint);

                } else if (frogFungiPlayerState.getWorld().matches("Lava")) {
                    if (frogFungiPlayerState.getLevel().matches("LevelTwo")) {

                        for (Values fungitypelavastatus : lm.bgLandscape.fungitypelavastatus) {
                            if (fungitypelavastatus.fungitypelavastatus != 0) {


                                if (fungitypelavastatus.fungitypelavastatus == 1) {
                                    canvas.drawBitmap(lm.bgLandscape.tonguewormoneBitmap.get(lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)),
                                            (lm.BeginX +
                                                    lm.bgLandscape.listofinitialfungipos[fungitypelavastatus.fungitypelavapos * 2])
                                                    - lm.bgLandscape.getxVelocity(),
                                            (lm.BeginY +
                                                    lm.bgLandscape.listofinitialfungipos[(fungitypelavastatus.fungitypelavapos * 2) + 1])
                                                    - lm.bgLandscape.getyVelocity(),
                                            paint);
                                }
                                if (fungitypelavastatus.fungitypelavastatus == 2) {
                                    canvas.drawBitmap(lm.bgLandscape.tonguewormtwoBitmap.get(lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)),
                                            (lm.BeginX +
                                                    lm.bgLandscape.listofinitialfungipos[fungitypelavastatus.fungitypelavapos * 2])
                                                    - lm.bgLandscape.getxVelocity(),
                                            (lm.BeginY +
                                                    lm.bgLandscape.listofinitialfungipos[(fungitypelavastatus.fungitypelavapos * 2) + 1])
                                                    - lm.bgLandscape.getyVelocity(),
                                            paint);

                                }

                                if (fungitypelavastatus.fungitypelavastatus == 3) {
                                    canvas.drawBitmap(lm.bgLandscape.tonguewormthreeBitmap.get(lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)),
                                            (lm.BeginX +
                                                    lm.bgLandscape.listofinitialfungipos[fungitypelavastatus.fungitypelavapos * 2])
                                                    - lm.bgLandscape.getxVelocity(),
                                            (lm.BeginY +
                                                    lm.bgLandscape.listofinitialfungipos[(fungitypelavastatus.fungitypelavapos * 2) + 1])
                                                    - lm.bgLandscape.getyVelocity(),
                                            paint);


                                }


                            }


                        }


                        for (int c = 0; c < fungihasChanged.size(); c++) {

                            int firefunginumberindex = 0;

                            for (int j = 0; j < lm.bgLandscape.firefunginumber.length; j++) {
                                if (lm.bgLandscape.firefunginumber[j] == lm.bgLandscape.funginumber[fungihasChanged.get(c) / 2]) {
                                    firefunginumberindex = j;
                                }
                            }


                            canvas.drawBitmap(lm.bgLandscape.firefungiBitmap.get(firefunginumberindex),
                                    (lm.BeginX + lm.bgLandscape.listofinitialfungipos[
                                            fungihasChanged.get(c)]) -
                                            lm.bgLandscape.getxVelocity(),
                                    (lm.BeginY + lm.bgLandscape.listofinitialfungipos[
                                            fungihasChanged.get(c) + 1]) -
                                            lm.bgLandscape.getyVelocity(),
                                    paint);

                        }


                    }

                }


                if (lm.frogFungiPlayer.getType() == 'r') {
                    if (!matrix.isIdentity()) {
                        matrix.reset();
                    }


                    frogfungiDraw(matrix);


                }

                if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                    int finishcountersmalloceanfish = 0;
                    int finishcounterbigoceanfish = 0;

                    for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
                        if (smalloceanfish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalloceanfish]) {
                            if (smalloceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }


                                fishleveloneDraw(smalloceanfish, matrix);

                            }

                        }

                        finishcountersmalloceanfish = finishcountersmalloceanfish + 2;
                    }


                    for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
                        if (bigoceanfish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbigoceanfish]) {
                            if (bigoceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveloneDraw(bigoceanfish, matrix);

                            }
                        }

                        finishcounterbigoceanfish = finishcounterbigoceanfish + 2;
                    }


                    for (GameObject beegrav : lm.beegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);


                    }


                    if (lm.beegravgameObjects.isEmpty()) {


                        for (GameObject bigbeegrav : lm.bigbeegravgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneOceanDraw(bigbeegrav, matrix);

                        }


                        for (GameObject sandladybug : lm.sandladybuggameObjects) {


                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            sandladybugDraw(sandladybug, matrix);
                        }


                    }


                    for (GameObject bighorngrav : lm.bighorngravgameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        bighorngravDraw(bighorngrav, matrix);

                    }


                    for (GameObject oceanbug : lm.oceanbuggameObjects) {
                        if (oceanbug.initialcondition == false) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);


                        }

                    }


                } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                    int finishcountersmalloceanfish = 0;
                    int finishcounterbigoceanfish = 0;


                    for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
                        if (smalloceanfish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalloceanfish]) {
                            if (smalloceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }


                                fishleveloneDraw(smalloceanfish, matrix);

                            }

                        }

                        finishcountersmalloceanfish = finishcountersmalloceanfish + 2;
                    }


                    for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
                        if (bigoceanfish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbigoceanfish]) {
                            if (bigoceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveloneDraw(bigoceanfish, matrix);

                            }
                        }

                        finishcounterbigoceanfish = finishcounterbigoceanfish + 2;
                    }


                    for (GameObject beegrav : lm.beegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);


                    }


                    for (GameObject beegrav : lm.beegravsecondgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        if(beegrav.getVisible()) {

                            foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                        }

                    }


                    for (GameObject guardianbeegrav : lm.guardianbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        guardianbeegravLevelTwoOceanDraw(guardianbeegrav, matrix);

                    }


                    for (GameObject sandladybug : lm.sandladybuggameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        sandladybugDraw(sandladybug, matrix);

                    }


                    for (GameObject bighorngrav : lm.bighorngravgameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }

                        bighorngravLevelTwoOceanDraw(bighorngrav, matrix);

                    }

                    for (GameObject oceanbug : lm.oceanbuggameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        if(oceanbug.getVisible()) {

                            foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);
                        }
                    }


                    if (lm.frogFungiPlayer.condition.matches("secondcondition") ||
                            lm.frogFungiPlayer.condition.matches("thirdcondition")) {


                        for (GameObject bigbeegrav : lm.bigbeegravgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(bigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(bigbeegrav, matrix);

                            }
                        }


                        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(bigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(bigbeegrav, matrix);
                            }
                        }

                        for (GameObject oceanbug : lm.oceanbugsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(oceanbug.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);
                            }
                        }


                    }


                    if (lm.frogFungiPlayer.condition.matches("thirdcondition")) {

                        for (GameObject beegrav : lm.beegravthirdgameObjects) {
                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }
                        }

                        for (GameObject beegrav : lm.beegravfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }
                        }


                    }


                } else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                    int counterswirlwater = 0;
                    int counterswirlwatersecond = 0;
                    int counterswirlwaterthird = 0;
                    int counterstargrav = 0;
                    int counterstargravsecond = 0;
                    int counterstargravthird = 0;

                    int finishcountersmalloceanfish = 0;
                    int finishcounterbigoceanfish = 0;


                   for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
                        if (smalloceanfish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalloceanfish]) {
                            if (smalloceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }


                                fishleveloneDraw(smalloceanfish, matrix);

                            }

                        }

                        finishcountersmalloceanfish = finishcountersmalloceanfish + 2;
                    }


                    for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
                        if (bigoceanfish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbigoceanfish]) {
                            if (bigoceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveloneDraw(bigoceanfish, matrix);

                            }
                        }

                        finishcounterbigoceanfish = finishcounterbigoceanfish + 2;
                    }


                    for (GameObject beegrav : lm.beegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);


                    }


                    for (GameObject killerbeegrav : lm.killerbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        killerbeegravLevelThreeOceanDraw(killerbeegrav, matrix);

                    }


                    for (GameObject suckerbeegrav : lm.suckerbeegravgameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        suckerbeegravLevelThreeOceanDraw(suckerbeegrav, matrix);


                    }


                    for (GameObject bigbeegrav : lm.bigbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneOceanDraw(bigbeegrav, matrix);

                    }


                    for (GameObject sandladybug : lm.sandladybuggameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        sandladybugDraw(sandladybug, matrix);

                    }


                    if (lm.suckerbeegravgameObjects.size() < 5) {

                        for (GameObject beegrav : lm.beegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }

                        }

                    }


                    if (lm.suckerbeegravgameObjects.size() < 4) {
                        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(bigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(bigbeegrav, matrix);
                            }
                        }

                        for (GameObject ghostspinder : lm.ghostspinderswirlwatergameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.swirlwatergameObjects, counterswirlwater,
                                    ghostspinder.satellitecode);


                            counterswirlwater = counterswirlwater + ghostspinder.satellitecode;


                        }

                    }

                    if (lm.suckerbeegravgameObjects.size() < 3) {

                        for (GameObject ghostspinder : lm.ghostspindersecondswirlwatergameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,

                                    lm.swirlwatersecondgameObjects, counterswirlwatersecond, ghostspinder.satellitecode);


                            counterswirlwatersecond = counterswirlwatersecond + ghostspinder.satellitecode;

                        }

                        for (GameObject ghostspinder : lm.ghostspinderstargravgameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.stargravgameObjects, counterstargrav,
                                    ghostspinder.satellitecode);


                            counterstargrav = counterstargrav + ghostspinder.satellitecode;


                        }



                        for (GameObject beegrav : lm.beegravthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }

                        }

                    }

                    if (lm.suckerbeegravgameObjects.size() < 2) {

                        for (GameObject ghostspinder : lm.ghostspinderthirdswirlwatergameObjects) {

                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.swirlwaterthirdgameObjects, counterswirlwaterthird,
                                    ghostspinder.satellitecode);

                            counterswirlwaterthird = counterswirlwaterthird + ghostspinder.satellitecode;


                        }

                        for (GameObject ghostspinder : lm.ghostspindersecondstargravgameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.stargravsecondgameObjects, counterstargravsecond,
                                    ghostspinder.satellitecode);


                            counterstargravsecond = counterstargravsecond + ghostspinder.satellitecode;


                        }

                        for (GameObject ghostspinder : lm.ghostspinderthirdstargravgameObjects) {

                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.stargravthirdgameObjects, counterstargravthird,
                                    ghostspinder.satellitecode);


                            counterstargravthird = counterstargravthird + ghostspinder.satellitecode;


                        }



                    }


                } else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                    int finishcountersmalloceanfish = 0;
                    int finishcounterbigoceanfish = 0;
                    int counterswirlwater = 0;
                    int counterswirlwatersecond = 0;
                    int counterstargrav = 0;
                    int counterstargravsecond = 0;
                    int countersplashfly = 0;



                    for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
                        if (smalloceanfish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalloceanfish]) {
                            if (smalloceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }


                                fishleveloneDraw(smalloceanfish, matrix);

                            }

                        }

                        finishcountersmalloceanfish = finishcountersmalloceanfish + 2;
                    }


                    for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
                        if (bigoceanfish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbigoceanfish]) {
                            if (bigoceanfish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveloneDraw(bigoceanfish, matrix);

                            }
                        }

                        finishcounterbigoceanfish = finishcounterbigoceanfish + 2;
                    }

                    for (GameObject beegrav : lm.beegravsecondgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        if(beegrav.getVisible()) {

                            foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                        }

                    }



                    for (GameObject beegrav : lm.beegravfourthgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        if(beegrav.getVisible()) {

                            foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                        }
                    }


                    for (GameObject suckerbeegrav : lm.suckerbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        suckerbeegravLevelFourOceanDraw(suckerbeegrav, matrix);


                    }



                    for (GameObject waterdrop : lm.waterdropgameObjects) {
                        if (waterdrop.initialcondition == false) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            waterdropLevelFourOceanDraw(waterdrop, matrix);


                        }

                    }

                    if (lm.suckerbeegravgameObjects.size() < 5) {

                        for (GameObject beegrav : lm.beegravthirdgameObjects) {
                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }
                        }

                        for (GameObject oceanbug : lm.oceanbugfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(oceanbug.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);
                            }

                        }


                        for (GameObject ghostspinder : lm.ghostspinderswirlwatergameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.swirlwatergameObjects, counterswirlwater,
                                    ghostspinder.satellitecode);


                            counterswirlwater = counterswirlwater + ghostspinder.satellitecode;


                        }

                        for (GameObject ghostspinder : lm.ghostspinderstargravgameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.stargravgameObjects, counterstargrav,
                                    ghostspinder.satellitecode);


                            counterstargrav = counterstargrav + ghostspinder.satellitecode;


                        }




                    }


                    if (lm.suckerbeegravgameObjects.size() < 4) {

                        for (GameObject oceanbug : lm.oceanbugthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(oceanbug.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);
                            }

                        }



                        for (GameObject ghostspinder : lm.ghostspindersecondswirlwatergameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.swirlwatersecondgameObjects, counterswirlwatersecond,
                                    ghostspinder.satellitecode);


                            counterswirlwatersecond = counterswirlwatersecond + ghostspinder.satellitecode;

                        }


                        for (GameObject ghostspinder : lm.ghostspindersecondstargravgameObjects) {

                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.stargravsecondgameObjects, counterstargravsecond,
                                    ghostspinder.satellitecode);


                            counterstargravsecond = counterstargravsecond + ghostspinder.satellitecode;


                        }





                    }


                    if (lm.suckerbeegravgameObjects.size() < 3) {
                        for (GameObject oceanbug : lm.oceanbugsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(oceanbug.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);
                            }

                        }



                        for (GameObject beegrav : lm.beegravgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(beegrav.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(beegrav, matrix);
                            }

                        }






                    }





                    if (lm.suckerbeegravgameObjects.size() < 2) {

                        for (GameObject oceanbug : lm.oceanbuggameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(oceanbug.getVisible()) {

                                foodpursuitfrogLevelOneOceanDraw(oceanbug, matrix);

                            }
                        }

                        for (GameObject ghostspinder : lm.ghostspindersplashflygameObjects) {


                            satellitewithconditionghostspinderLevelThreeOceanDraw(matrix,
                                    lm.splashflygameObjects, countersplashfly,
                                    ghostspinder.satellitecode);

                            countersplashfly = countersplashfly + ghostspinder.satellitecode;


                        }



                    }

                } else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {
                    int finishcountersmalllavafish = 0;
                    int finishcounterbiglavafish = 0;

                    for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
                        if (smalllavafish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalllavafish]) {
                            if (smalllavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(smalllavafish, matrix);


                            }

                        }

                        finishcountersmalllavafish = finishcountersmalllavafish + 2;
                    }


                    for (GameObject biglavafish : lm.biglavafishgameObjects) {
                        if (biglavafish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbiglavafish]) {
                            if (biglavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(biglavafish, matrix);


                            }
                        }

                        finishcounterbiglavafish = finishcounterbiglavafish + 2;
                    }


                    for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);


                    }


                    for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavagameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneLavaDraw(dustrockbeegravlava, matrix);

                    }


                    for (GameObject fungilava : lm.fungilavagameObjects) {

                        canvas.drawBitmap(
                                lm.bitmapsArray[lm.getBitmapIndexLevelOneLava(fungilava.getType())],
                                lm.BeginX + fungilava.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2
                                        - lm.bgLandscape.getxVelocity(),
                                lm.BeginY + fungilava.currentyWorld - lm.bgLandscape.getbackgroundyResolution() / 2
                                        - lm.bgLandscape.getyVelocity(),
                                paint);

                    }


                    for (GameObject jumpingratlava : lm.jumpingratlavagameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }

                        jumpingratlavaDraw(jumpingratlava, matrix);


                    }

                    if (lm.fungilavagameObjects.size() < 4) {
                        for (GameObject rockbigbeegrav : lm.rockbigbeegravgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);

                        }


                        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }


                    }


                    if (lm.fungilavagameObjects.size() < 3) {

                        for (GameObject rockbigbeegrav : lm.rockbigbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                            }

                        }


                    }

                } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {
                    int finishcountersmalllavafish = 0;
                    int finishcounterbiglavafish = 0;
                    int counterbigdustrockbeegravlava = 0;


                    for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
                        if (smalllavafish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalllavafish]) {
                            if (smalllavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(smalllavafish, matrix);


                            }

                        }

                        finishcountersmalllavafish = finishcountersmalllavafish + 2;
                    }


                    for (GameObject biglavafish : lm.biglavafishgameObjects) {
                        if (biglavafish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbiglavafish]) {
                            if (biglavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(biglavafish, matrix);


                            }
                        }

                        finishcounterbiglavafish = finishcounterbiglavafish + 2;
                    }


                    for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);


                    }


                    for (GameObject rockbigbeegrav : lm.rockbigbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);

                    }





                    for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavagameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                            foodpursuitfrogLevelOneLavaDraw(dustrockbeegravlava, matrix);
                    }



                    for (GameObject fungilava : lm.fungilavagameObjects) {

                        canvas.drawBitmap(
                                lm.bitmapsArray[lm.getBitmapIndexLevelTwoLava(fungilava.getType())],
                                lm.BeginX + fungilava.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2
                                        - lm.bgLandscape.getxVelocity(),
                                lm.BeginY + fungilava.currentyWorld - lm.bgLandscape.getbackgroundyResolution() / 2
                                        - lm.bgLandscape.getyVelocity(),
                                paint);

                    }


                    for (GameObject jumpingratlava : lm.jumpingratlavagameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }

                        jumpingratlavaDraw(jumpingratlava, matrix);


                    }


                    for (GameObject transparentchub : lm.transparentchubgameObjects) {


                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }

                        transparentchubLevelTwoLavaDraw(transparentchub, matrix);


                    }



                    if(lm.transparentchubgameObjects.size() < 4){


                        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }


                        for (GameObject rockbigbeegrav : lm.rockbigbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                            }

                        }


                        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavasecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(dustrockbeegravlava.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(dustrockbeegravlava, matrix);
                            }
                        }




                    }

                    if(lm.transparentchubgameObjects.size() < 3){
                        for (GameObject rockbeegrav : lm.rockbeegravthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }

                        for (GameObject rockbigbeegrav : lm.rockbigbeegravthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }

                            if(rockbigbeegrav.getVisible()) {
                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                            }

                        }

                        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavathirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }

                            if(dustrockbeegravlava.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(dustrockbeegravlava, matrix);
                            }
                        }


                    }


                    if(lm.transparentchubgameObjects.size() < 2){

                        for (GameObject rockbeegrav : lm.rockbeegravfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }
                        for (GameObject rockbigbeegrav : lm.rockbigbeegravfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                            }

                        }


                        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavafourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(dustrockbeegravlava.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(dustrockbeegravlava, matrix);
                            }
                        }

                    }


                    if(lm.fungilavagameObjects.size() < 3){
                        for (GameObject ghostspinder : lm.ghostspinderbigdustrockbeegravlavagameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.bigdustrockbeegravlavagameObjects, counterbigdustrockbeegravlava,
                                    ghostspinder.satellitecode);


                            counterbigdustrockbeegravlava = counterbigdustrockbeegravlava + ghostspinder.satellitecode;


                        }

                    }


                }

                else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
                    int finishcountersmalllavafish = 0;
                    int finishcounterbiglavafish = 0;
                    int counterbigdustrockbeegravlava = 0;
                    int counterbigdustrockbeegravlavasecond = 0;
                    int counterbigdustrockbeegravlavathird = 0;
                    int counterbigdustrockbeegravlavafourth = 0;


                    for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
                        if (smalllavafish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalllavafish]) {
                            if (smalllavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(smalllavafish, matrix);


                            }

                        }

                        finishcountersmalllavafish = finishcountersmalllavafish + 2;
                    }


                    for (GameObject biglavafish : lm.biglavafishgameObjects) {
                        if (biglavafish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbiglavafish]) {
                            if (biglavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(biglavafish, matrix);


                            }
                        }

                        finishcounterbiglavafish = finishcounterbiglavafish + 2;
                    }


                    for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                            foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);

                    }


                    for (GameObject barkbug : lm.barkbuggameObjects) {
                        if (barkbug.initialcondition == false) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            barkbugLevelThreeLavaDraw(barkbug, matrix);


                        }

                    }


                    for (GameObject lavadrop : lm.lavadropgameObjects) {
                        if (lavadrop.initialcondition == false) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            lavadropLevelThreeLavaDraw(lavadrop, matrix);


                        }

                    }

                    for(GameObject lavafur: lm.lavafurgameObjects){
                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        lavafurLevelThreeLavaDraw(lavafur, matrix);

                    }


                    for (GameObject gravitycloud : lm.gravitycloudgameObjects) {

                        if (gravitycloud.getFacing().matches("RIGHT")) {

                            canvas.drawBitmap(
                                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(gravitycloud.getType())],
                                    lm.BeginX + gravitycloud.currentxWorld - lm.bgLandscape.getbackgroundxResolution()/2
                                            - lm.bgLandscape.getxVelocity(),
                                    lm.BeginY + gravitycloud.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2
                                            - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }


                       else if (gravitycloud.getFacing().matches("LEFT")) {

                            canvas.drawBitmap(
                                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(gravitycloud.getType()) + 1],
                                    lm.BeginX + gravitycloud.currentxWorld - lm.bgLandscape.getbackgroundxResolution()/2
                                            - lm.bgLandscape.getxVelocity(),
                                    lm.BeginY + gravitycloud.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2
                                            - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }
                    }


                    if(lm.gravitycloudgameObjects.size() < 5){

                        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }


                        for (GameObject rockbigbeegrav : lm.rockbigbeegravgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }



                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                        }



                        for (GameObject ghostspinder : lm.ghostspinderbigdustrockbeegravlavagameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.bigdustrockbeegravlavagameObjects, counterbigdustrockbeegravlava,
                                    ghostspinder.satellitecode);


                            counterbigdustrockbeegravlava = counterbigdustrockbeegravlava + ghostspinder.satellitecode;


                        }


                }


                    if(lm.gravitycloudgameObjects.size() < 4){

                        for (GameObject rockbeegrav : lm.rockbeegravthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }

                        for (GameObject rockbigbeegrav : lm.rockbigbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbigbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbigbeegrav, matrix);
                            }
                        }


                        for (GameObject ghostspinder : lm.ghostspindersecondbigdustrockbeegravlavagameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.bigdustrockbeegravlavasecondgameObjects, counterbigdustrockbeegravlavasecond,
                                    ghostspinder.satellitecode);


                            counterbigdustrockbeegravlavasecond = counterbigdustrockbeegravlavasecond + 
                                    ghostspinder.satellitecode;


                        }


                    }


                    if(lm.gravitycloudgameObjects.size() < 3){

                        for (GameObject rockbeegrav : lm.rockbeegravfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }


                        for (GameObject ghostspinder : lm.ghostspinderthirdbigdustrockbeegravlavagameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.bigdustrockbeegravlavathirdgameObjects, counterbigdustrockbeegravlavathird,
                                    ghostspinder.satellitecode);


                            counterbigdustrockbeegravlavathird = counterbigdustrockbeegravlavathird +
                                    ghostspinder.satellitecode;


                        }



                    }


                    if(lm.gravitycloudgameObjects.size() < 2){


                        for (GameObject ghostspinder : lm.ghostspinderfourthbigdustrockbeegravlavagameObjects) {


                            satelliteghostspinderLevelThreeOceanDraw(matrix,
                                    lm.bigdustrockbeegravlavafourthgameObjects, counterbigdustrockbeegravlavafourth,
                                    ghostspinder.satellitecode);



                            counterbigdustrockbeegravlavafourth = 
                                    counterbigdustrockbeegravlavafourth + ghostspinder.satellitecode;


                          
                        }


                    }


                }


                else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
                    int finishcountersmalllavafish = 0;
                    int finishcounterbiglavafish = 0;
                    int counterbigdustrockbeegravlava = 0;
                    int counterbigdustrockbeegravlavasecond = 0;
                    int counterbigdustrockbeegravlavathird = 0;
                    int counterbigdustrockbeegravlavafourth = 0;



                    for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
                        if (smalllavafish.currentxWorld != lm.firstpreyarrayfinish[finishcountersmalllavafish]) {
                            if (smalllavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(smalllavafish, matrix);


                            }

                        }

                        finishcountersmalllavafish = finishcountersmalllavafish + 2;
                    }


                    for (GameObject biglavafish : lm.biglavafishgameObjects) {
                        if (biglavafish.currentxWorld != lm.secondpreyarrayfinish[finishcounterbiglavafish]) {
                            if (biglavafish.getVisible()) {
                                if (!matrix.isIdentity()) {
                                    matrix.reset();
                                }

                                fishleveltwoDraw(biglavafish, matrix);


                            }
                        }

                        finishcounterbiglavafish = finishcounterbiglavafish + 2;
                    }


                    for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);


                    }








                    for (GameObject redbubble : lm.redbubblegameObjects) {

                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }


                        redbubbleLevelFourLavaDraw(redbubble, matrix);


                    }

                    for(GameObject lavafur: lm.lavafurgameObjects){
                        if (!matrix.isIdentity()) {
                            matrix.reset();
                        }




                        lavafurLevelThreeLavaDraw(lavafur, matrix);
                    }


                    for (GameObject gravitycloud : lm.gravitycloudgameObjects) {

                        if (gravitycloud.getFacing().matches("RIGHT")) {

                            canvas.drawBitmap(
                                    lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(gravitycloud.getType())],
                                    lm.BeginX + gravitycloud.currentxWorld - lm.bgLandscape.getbackgroundxResolution()/2
                                            - lm.bgLandscape.getxVelocity(),
                                    lm.BeginY + gravitycloud.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2
                                            - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }


                        else if (gravitycloud.getFacing().matches("LEFT")) {

                            canvas.drawBitmap(
                                    lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(gravitycloud.getType()) + 1],
                                    lm.BeginX + gravitycloud.currentxWorld - lm.bgLandscape.getbackgroundxResolution()/2
                                            - lm.bgLandscape.getxVelocity(),
                                    lm.BeginY + gravitycloud.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2
                                            - lm.bgLandscape.getyVelocity(),
                                    paint);

                        }



                    }






                   if(lm.gravitycloudgameObjects.size() < 5){
                        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }



                        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavagameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneLavaDraw(bigdustrockbeegravlava, matrix);


                            satellitewithconditionghostspinderLevelThreeOceanDraw(matrix,
                                    lm.dustbulletgameObjects, counterbigdustrockbeegravlava,
                                    bigdustrockbeegravlava.satellitecode);

                            counterbigdustrockbeegravlava =
                                    counterbigdustrockbeegravlava + bigdustrockbeegravlava.satellitecode;


                        }



                    }

                    if(lm.gravitycloudgameObjects.size() < 4){

                        for (GameObject rockbeegrav : lm.rockbeegravthirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }

                        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavasecondgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneLavaDraw(bigdustrockbeegravlava, matrix);


                            satellitewithconditionghostspinderLevelThreeOceanDraw(matrix,
                                    lm.dustbulletsecondgameObjects, counterbigdustrockbeegravlavasecond,
                                    bigdustrockbeegravlava.satellitecode);

                            counterbigdustrockbeegravlavasecond =
                                    counterbigdustrockbeegravlavasecond + bigdustrockbeegravlava.satellitecode;


                        }



                    }

                    if(lm.gravitycloudgameObjects.size() < 3){
                        for (GameObject rockbeegrav : lm.rockbeegravfourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            if(rockbeegrav.getVisible()) {

                                foodpursuitfrogLevelOneLavaDraw(rockbeegrav, matrix);
                            }

                        }

                        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavathirdgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneLavaDraw(bigdustrockbeegravlava, matrix);



                            satellitewithconditionghostspinderLevelThreeOceanDraw(matrix,
                                    lm.dustbulletthirdgameObjects, counterbigdustrockbeegravlavathird,
                                    bigdustrockbeegravlava.satellitecode);

                            counterbigdustrockbeegravlavathird =
                                    counterbigdustrockbeegravlavathird + bigdustrockbeegravlava.satellitecode;


                        }


                    }

                    if(lm.gravitycloudgameObjects.size() < 2){
                        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavafourthgameObjects) {

                            if (!matrix.isIdentity()) {
                                matrix.reset();
                            }


                            foodpursuitfrogLevelOneLavaDraw(bigdustrockbeegravlava, matrix);


                            satellitewithconditionghostspinderLevelThreeOceanDraw(matrix,
                                    lm.dustbulletfourthgameObjects, counterbigdustrockbeegravlavafourth,
                                    bigdustrockbeegravlava.satellitecode);

                            counterbigdustrockbeegravlavafourth =
                                    counterbigdustrockbeegravlavafourth + bigdustrockbeegravlava.satellitecode;


                        }



                    }

                }


                ourHolder.unlockCanvasAndPost(canvas);
            }
        }
    }


    public void pause() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("error", "failed to pause thread");
        }
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void loadLevel(FrogFungiPlayerState frogFungiPlayerStatell) {


        lm = new LevelManager(frogFungiPlayerStatell);

        ic = new InputController(lm, frogFungiPlayerStatell);


    }

    @Override

    public boolean onTouchEvent(MotionEvent motionEvent) {

        ic.handleInput(motionEvent);


        return true;
    }





    void initialandarrivePosFrog() {

        if (lm.frogFungiPlayer.getWorldLocation().x == 0 && lm.frogFungiPlayer.setinitialfrogposx == false) {
            lm.frogFungiPlayer.setWorldLocationX(lm.BeginX + lm.bgLandscape.fungiArray[0] - lm.bgLandscape.getbackgroundxResolution() / 2);
            lm.frogFungiPlayer.currentxWorld = (float) lm.bgLandscape.fungiArray[0];
            lm.frogFungiPlayer.setinitialfrogposx = true;

        } else if (lm.frogFungiPlayer.nextxPosition != 0 && lm.frogFungiPlayer.getChangeFrogPosition() == true && lm.frogFungiPlayer.changefrogfungionetime == true) {
            lm.frogFungiPlayer.setWorldLocationX(lm.BeginX + lm.frogFungiPlayer.nextxPosition - lm.bgLandscape.getbackgroundxResolution() / 2);

        }


        if (lm.frogFungiPlayer.getWorldLocation().y == 0 && lm.frogFungiPlayer.setinitialfrogposy == false) {
            lm.frogFungiPlayer.setWorldLocationY(lm.BeginY + lm.bgLandscape.fungiArray[1] - lm.bgLandscape.getbackgroundyResolution());
            lm.frogFungiPlayer.currentyWorld = (float) lm.bgLandscape.fungiArray[1];
            lm.frogFungiPlayer.setinitialfrogposy = true;

        } else if (lm.frogFungiPlayer.nextyPosition != 0 && lm.frogFungiPlayer.getChangeFrogPosition() == true && lm.frogFungiPlayer.changefrogfungionetime == true) {
            lm.frogFungiPlayer.setWorldLocationY(lm.BeginY + lm.frogFungiPlayer.nextyPosition - lm.bgLandscape.getbackgroundyResolution());
            lm.frogFungiPlayer.setChangeFrogPosition(false);
        }


    }


    void frogfungiUpdate() {

        lm.frogFungiPlayer.update(fps);



        if (lm.frogFungiPlayer.getChangeFrogPosition() == true) {

                frogsingplay = false;
                lm.soundManager.stopSound("frogsing");


            if ((lm.frogFungiPlayer.getxVelocity() != 0) || (lm.frogFungiPlayer.getyVelocity() != 0)) {
                lm.frogFungiPlayer.currentxWorld = lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + (lm.frogFungiPlayer.getBitmapWidth() / 2)
                        + lm.frogFungiPlayer.getSavedxvelocity() + lm.frogFungiPlayer.getxVelocity();

                lm.frogFungiPlayer.currentyWorld = lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.frogFungiPlayer.getBitmapHeight()
                        + lm.frogFungiPlayer.getSavedyvelocity() + lm.frogFungiPlayer.getyVelocity();


            } else if ((lm.frogFungiPlayer.getxVelocity() == 0) && (lm.frogFungiPlayer.getyVelocity() == 0)) {
                lm.frogFungiPlayer.currentxWorld = lm.frogFungiPlayer.getnextxPosition();
                lm.frogFungiPlayer.currentyWorld = lm.frogFungiPlayer.getnextyPosition();
                lm.frogFungiPlayer.changefrogfungionetime = true;
                if(!frogsingplay){
                    if(MainActivity.contextMain.loadedtwo) {
                        lm.soundManager.playSound("frogsing");

                        frogsingplay = true;
                    }

                }

            }


        }

    }

    void beegravUpdate() {
        for (GameObject beegrav : lm.beegravgameObjects) {


            if (beegrav.initialcondition == true) {
                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX
                        + beegrav.getxVelocity();

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY
                        + beegrav.getyVelocity();

                beegrav.initialcondition = false;
            } else {

                beegrav.updateEnemy(fps * beegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        beegrav.currentxWorld,
                        beegrav.currentyWorld);


                if (beegrav.getxVelocity() != 0) {
                    beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX
                            + beegrav.getSavedxvelocity() + beegrav.getxVelocity();
                }


                if (beegrav.getyVelocity() != 0) {
                    beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY
                            + beegrav.getSavedyvelocity() + beegrav.getyVelocity();
                }

            }


        }


    }


    void beegravsecondLevelTwoOceanUpdate() {
        for (GameObject beegrav : lm.beegravsecondgameObjects) {


            if (beegrav.initialcondition == true) {
                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX
                        + beegrav.getxVelocity();

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY
                        + beegrav.getyVelocity();

                beegrav.initialcondition = false;
            } else {

                beegrav.updateEnemy(fps * beegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        beegrav.currentxWorld,
                        beegrav.currentyWorld);


                if (beegrav.getxVelocity() != 0) {
                    beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX
                            + beegrav.getSavedxvelocity() + beegrav.getxVelocity();
                }


                if (beegrav.getyVelocity() != 0) {
                    beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY
                            + beegrav.getSavedyvelocity() + beegrav.getyVelocity();
                }

            }


        }


    }


    void beegravthirdLevelTwoOceanUpdate() {

        for (GameObject beegrav : lm.beegravthirdgameObjects) {

            if (beegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.beegravthirdgameObjects, beegrav, lm.beegravthirdObject);

                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX;

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY;

                beegrav.initialcondition = false;

                lm.beegravthirdgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentxWorld);
                lm.beegravthirdgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentyWorld);


            } else if (beegrav.initialcondition == false) {

                enemysequencePattern(lm.beegravthirdgameObjects, beegrav, beegrav.speed * 2.5f);


            }
        }
    }

    void beegravfourthLevelTwoOceanUpdate() {

        for (GameObject beegrav : lm.beegravfourthgameObjects) {

            if (beegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.beegravfourthgameObjects, beegrav, lm.beegravfourthObject);

                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX;

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY;

                beegrav.initialcondition = false;

                lm.beegravfourthgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentxWorld);
                lm.beegravfourthgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentyWorld);


            } else if (beegrav.initialcondition == false) {

                enemysequencePattern(lm.beegravfourthgameObjects, beegrav, beegrav.speed * 2.5f);

            }
        }

    }


    void bigbeegravUpdate() {

        for (GameObject bigbeegrav : lm.bigbeegravgameObjects) {


            if (bigbeegrav.initialcondition == true) {
                bigbeegrav.currentxWorld = bigbeegrav.getWorldLocation().x - lm.BeginX
                        + bigbeegrav.getxVelocity();

                bigbeegrav.currentyWorld = bigbeegrav.getWorldLocation().y - lm.BeginY
                        + bigbeegrav.getyVelocity();

                bigbeegrav.initialcondition = false;
            } else {

                bigbeegrav.updateEnemy(fps * bigbeegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2,
                        lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + lm.bgLandscape.getbackgroundxResolution() / 2,
                        lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.bgLandscape.getbackgroundyResolution()/2);


                if (bigbeegrav.getxVelocity() != 0) {
                    bigbeegrav.currentxWorld = bigbeegrav.getWorldLocation().x - lm.BeginX
                            + bigbeegrav.getSavedxvelocity() + bigbeegrav.getxVelocity();
                }


                if (bigbeegrav.getyVelocity() != 0) {
                    bigbeegrav.currentyWorld = bigbeegrav.getWorldLocation().y - lm.BeginY
                            + bigbeegrav.getSavedyvelocity() + bigbeegrav.getyVelocity();
                }


            }
        }


    }



    void bigbeegravsecondLevelTwoOceanUpdate() {

        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {

            if (bigbeegrav.initialcondition == true) {

                enemyvaluesinitialize(lm.bigbeegravsecondgameObjects, bigbeegrav, lm.bigbeegravsecondObject);


                bigbeegrav.currentxWorld = bigbeegrav.getWorldLocation().x - lm.BeginX;

                bigbeegrav.currentyWorld = bigbeegrav.getWorldLocation().y - lm.BeginY;

                bigbeegrav.initialcondition = false;

                lm.bigbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(bigbeegrav.currentxWorld);
                lm.bigbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(bigbeegrav.currentyWorld);


            } else if (bigbeegrav.initialcondition == false) {



                enemysequencePattern(lm.bigbeegravsecondgameObjects, bigbeegrav, bigbeegrav.speed * 2.5f);


            }
        }

    }


    void bigbeegravsecondLevelThreeOceanUpdate() {

        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {


            if (bigbeegrav.initialcondition == true) {
                bigbeegrav.currentxWorld = bigbeegrav.getWorldLocation().x - lm.BeginX
                        + bigbeegrav.getxVelocity();

                bigbeegrav.currentyWorld = bigbeegrav.getWorldLocation().y - lm.BeginY
                        + bigbeegrav.getyVelocity();

                bigbeegrav.initialcondition = false;
            } else {

                bigbeegrav.updateEnemy(fps * bigbeegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2,
                        lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + lm.bgLandscape.getbackgroundxResolution() / 2,
                        lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.bgLandscape.getbackgroundyResolution()/2);


                if (bigbeegrav.getxVelocity() != 0) {
                    bigbeegrav.currentxWorld = bigbeegrav.getWorldLocation().x - lm.BeginX
                            + bigbeegrav.getSavedxvelocity() + bigbeegrav.getxVelocity();
                }


                if (bigbeegrav.getyVelocity() != 0) {
                    bigbeegrav.currentyWorld = bigbeegrav.getWorldLocation().y - lm.BeginY
                            + bigbeegrav.getSavedyvelocity() + bigbeegrav.getyVelocity();
                }


            }
        }


    }



    void bighorngravUpdate() {

        for (GameObject bighorngrav : lm.bighorngravgameObjects) {


            if (bighorngrav.initialcondition == true) {
                bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX;

                bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY;

                bighorngrav.initialcondition = false;
            } else {

                bighorngrav.updateEnemy(fps * bighorngrav.speed,
                        lm.frogFungiPlayer.nextxPosition - bighorngrav.getBitmapWidth() / 2,
                        lm.frogFungiPlayer.nextyPosition - bighorngrav.getBitmapHeight(),
                        bighorngrav.getWorldLocation().x - lm.BeginX,
                        bighorngrav.getWorldLocation().y - lm.BeginY);

                bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX
                        + bighorngrav.getSavedxvelocity() + bighorngrav.getxVelocity();

                bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY
                        + bighorngrav.getSavedyvelocity() + bighorngrav.getyVelocity();


                if ((bighorngrav.getxVelocity() == 0) && (bighorngrav.getyVelocity() == 0) &&
                        (bighorngrav.currentxWorld != bighorngrav.getWorldLocation().x - lm.BeginX)) {

                    bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX;

                    bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY;

                }

            }

        }

    }


    void bighorngravUpdateLevelTwoOcean() {

        for (GameObject bighorngrav : lm.bighorngravgameObjects) {


            if (bighorngrav.initialcondition == true) {
                bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX;

                bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY;

                bighorngrav.initialcondition = false;
            } else {


                if (bighorngrav.condition.matches("firstcondition")) {


                    if (((lm.frogFungiPlayer.nextxPosition - bighorngrav.getBitmapWidth() / 2) ==
                            (bighorngrav.getWorldLocation().x - lm.BeginX)) &&
                            ((lm.frogFungiPlayer.nextyPosition - bighorngrav.getBitmapHeight()) ==
                                    (bighorngrav.getWorldLocation().y - lm.BeginY)) &&
                            bighorngrav.nextxPosition == 0 &&
                            bighorngrav.nextyPosition == 0
                            ) {


                        Integer[] bighorngravarr = preciserandom(lm.arraylistofbighorngravescape, false);


                        for (int q = 0; q < lm.arraylistofbighorngravescape.length; q++) {

                            if (lm.arraylistofbighorngravescape[q].equals(bighorngravarr[lm.bighorngravgameObjects.indexOf(bighorngrav)])) {
                                bighorngrav.bighorngravrand = q;
                                break;
                            }


                        }


                        bighorngrav.nextxPosition = lm.bgLandscape.fungiArray[lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2];
                        bighorngrav.nextyPosition = lm.bgLandscape.fungiArray[(lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2) + 1];


                    }


                    bighorngrav.updateEnemyLevelTwo(fps * bighorngrav.speed,
                            lm.frogFungiPlayer.nextxPosition - bighorngrav.getBitmapWidth() / 2,
                            lm.frogFungiPlayer.nextyPosition - bighorngrav.getBitmapHeight(),
                            lm.BeginX, lm.BeginY);

                    if (bighorngrav.condition.matches("firstcondition")) {

                        bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX
                                + bighorngrav.getxVelocity();

                        bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY
                                + bighorngrav.getyVelocity();

                    }

                    if ((bighorngrav.currentxWorld >= bighorngrav.getWorldLocation().x - lm.BeginX)
                            && (bighorngrav.currentyWorld <= bighorngrav.getWorldLocation().y - lm.BeginY)) {

                        bighorngrav.resetxVelocity();
                        bighorngrav.resetyVelocity();


                        bighorngrav.nextxPosition = 0;
                        bighorngrav.nextyPosition = 0;


                        bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX;

                        bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY;

                    }
                } else if (bighorngrav.condition.matches("secondcondition")) {


                    bighorngrav.updateEnemyLevelTwo(fps * bighorngrav.speed,
                            lm.frogFungiPlayer.nextxPosition - bighorngrav.getBitmapWidth() / 2,
                            lm.frogFungiPlayer.nextyPosition - bighorngrav.getBitmapHeight(),
                            lm.BeginX, lm.BeginY);


                } else if (bighorngrav.condition.matches("thirdcondition")) {


                    bighorngrav.updateEnemyLevelTwo(fps * bighorngrav.speed,
                            lm.frogFungiPlayer.nextxPosition - bighorngrav.getBitmapWidth() / 2,
                            lm.frogFungiPlayer.nextyPosition - bighorngrav.getBitmapHeight(),
                            lm.bgLandscape.fungiArray[lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2],
                            lm.bgLandscape.fungiArray[(lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2) + 1]);

                    if (bighorngrav.condition.matches("thirdcondition")) {

                        bighorngrav.currentxWorld = lm.bgLandscape.fungiArray[lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2] +
                                bighorngrav.currentxPositionSaved
                                + bighorngrav.getxVelocity();

                        bighorngrav.currentyWorld = lm.bgLandscape.fungiArray[(lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2) + 1] +
                                bighorngrav.currentyPositionSaved
                                + bighorngrav.getyVelocity();

                    }


                    if (bighorngrav.condition.matches("firstcondition")) {

                        bighorngrav.resetxVelocity();
                        bighorngrav.resetyVelocity();

                        bighorngrav.nextxPosition = 0;
                        bighorngrav.nextyPosition = 0;

                        bighorngrav.currentxWorld = bighorngrav.getWorldLocation().x - lm.BeginX;

                        bighorngrav.currentyWorld = bighorngrav.getWorldLocation().y - lm.BeginY;

                    }

                }

            }

        }
    }


    void smalloceanfishUpdate() {

        int finishcounter = 0;
        int notvisible = 0;

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
            if (!smalloceanfish.getVisible()) {
                notvisible++;
            }
        }

        if (notvisible > lm.smalloceanfishgameObjects.size() / 2) {
            for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {

                if (!smalloceanfish.getVisible()) {
                    smalloceanfish.setVisible(true);
                    smalloceanfish.initialcondition = true;
                }

            }
        }

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {


            if (smalloceanfish.initialcondition == true) {
                smalloceanfish.currentxWorld = smalloceanfish.getWorldLocation().x - lm.BeginX;

                smalloceanfish.currentyWorld = smalloceanfish.getWorldLocation().y - lm.BeginY;

                smalloceanfish.setVisible(true);

                smalloceanfish.initialcondition = false;
            } else {

                smalloceanfish.nextxPosition = lm.firstpreyarrayfinish[finishcounter];
                smalloceanfish.nextyPosition = lm.firstpreyarrayfinish[finishcounter + 1];


                smalloceanfish.updateEnemy(fps * smalloceanfish.speed, smalloceanfish.getWorldLocation().x - lm.BeginX,
                        smalloceanfish.getWorldLocation().y - lm.BeginY,
                        smalloceanfish.nextxPosition,
                        smalloceanfish.nextyPosition);

                smalloceanfish.currentxWorld = smalloceanfish.getWorldLocation().x - lm.BeginX
                        + smalloceanfish.getxVelocity();

                smalloceanfish.currentyWorld = smalloceanfish.getWorldLocation().y - lm.BeginY
                        + smalloceanfish.getyVelocity();


                if (smalloceanfish.getxVelocity() == 0 && smalloceanfish.currentxWorld != lm.firstpreyarrayfinish[finishcounter]) {
                    smalloceanfish.currentxWorld = smalloceanfish.nextxPosition;
                    smalloceanfish.currentyWorld = smalloceanfish.nextyPosition;


                }


                finishcounter = finishcounter + 2;

            }

        }


    }

    void bigoceanfishUpdate() {

        int finishcounter = 0;
        int notvisible = 0;

        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
            if (!bigoceanfish.getVisible()) {
                notvisible++;
            }
        }

        if (notvisible > lm.bigoceanfishgameObjects.size() / 2) {
            for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {

                if (!bigoceanfish.getVisible()) {
                    bigoceanfish.setVisible(true);
                    bigoceanfish.initialcondition = true;
                }

            }
        }


        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {


            if (bigoceanfish.initialcondition == true) {
                bigoceanfish.currentxWorld = bigoceanfish.getWorldLocation().x - lm.BeginX;

                bigoceanfish.currentyWorld = bigoceanfish.getWorldLocation().y - lm.BeginY;

                bigoceanfish.setVisible(true);

                bigoceanfish.initialcondition = false;
            } else {

                bigoceanfish.nextxPosition = lm.secondpreyarrayfinish[finishcounter];
                bigoceanfish.nextyPosition = lm.secondpreyarrayfinish[finishcounter + 1];


                bigoceanfish.updateEnemy(fps * bigoceanfish.speed, bigoceanfish.getWorldLocation().x - lm.BeginX,
                        bigoceanfish.getWorldLocation().y - lm.BeginY,
                        bigoceanfish.nextxPosition,
                        bigoceanfish.nextyPosition);

                bigoceanfish.currentxWorld = bigoceanfish.getWorldLocation().x - lm.BeginX
                        + bigoceanfish.getxVelocity();

                bigoceanfish.currentyWorld = bigoceanfish.getWorldLocation().y - lm.BeginY
                        + bigoceanfish.getyVelocity();


                if (bigoceanfish.getxVelocity() == 0 && bigoceanfish.currentxWorld != lm.secondpreyarrayfinish[finishcounter]) {
                    bigoceanfish.currentxWorld = bigoceanfish.nextxPosition;
                    bigoceanfish.currentyWorld = bigoceanfish.nextyPosition;
                }

                finishcounter = finishcounter + 2;


            }

        }
    }


    void sandladybugUpdate() {


        for (GameObject sandladybug : lm.sandladybuggameObjects) {


            if (sandladybug.initialcondition == true) {
                sandladybug.currentxWorld = sandladybug.getWorldLocation().x - lm.BeginX;

                sandladybug.currentyWorld = sandladybug.getWorldLocation().y - lm.BeginY;


                sandladybug.initialcondition = false;
            } else {


                if (sandladybug.nextxPosition != 0 && sandladybug.nextyPosition != 0) {
                    sandladybug.updateEnemy(fps * sandladybug.speed, sandladybug.nextxPosition,
                            sandladybug.nextyPosition,
                            sandladybug.getWorldLocation().x - lm.BeginX,
                            sandladybug.getWorldLocation().y - lm.BeginY);

                    sandladybug.currentxWorld = sandladybug.getWorldLocation().x - lm.BeginX
                            + sandladybug.getxVelocity();

                    sandladybug.currentyWorld = sandladybug.getWorldLocation().y - lm.BeginY
                            + sandladybug.getyVelocity();


                    if (sandladybug.getxVelocity() == 0 && sandladybug.getyVelocity() == 0) {
                        sandladybug.currentxWorld = sandladybug.nextxPosition;
                        sandladybug.currentyWorld = sandladybug.nextyPosition;

                        sandladybug.nextxPosition = 0;
                        sandladybug.nextyPosition = 0;

                        sandladybug.setWorldLocation(lm.BeginX + sandladybug.currentxWorld,
                                lm.BeginY + sandladybug.currentyWorld);


                    }
                } else {
                    if (sandladybug.oldTime == 0) {
                        sandladybug.oldTime = System.nanoTime();
                    }

                    if (TimeUnit.SECONDS.convert(System.nanoTime() - sandladybug.oldTime, TimeUnit.NANOSECONDS) >= 3) {


                        if (sandladybug.currentxWorld == lm.arraylistofsandladybugposition[sandladybug.sandladybugrand]) {
                            if (sandladybug.currentyWorld == lm.arraylistofsandladybugposition[sandladybug.sandladybugrand + 1]) {


                                Integer[] jumpsandarr = preciserandom(lm.arraylistofsandladybugposition, true);


                                for (int q = 0; q < lm.arraylistofsandladybugposition.length; q++) {

                                    if (lm.arraylistofsandladybugposition[q] == jumpsandarr[lm.sandladybuggameObjects.indexOf(sandladybug)]) {
                                        sandladybug.sandladybugrand = q;
                                        break;
                                    }


                                }


                                sandladybug.nextxPosition = lm.arraylistofsandladybugposition[sandladybug.sandladybugrand];
                                sandladybug.nextyPosition = lm.arraylistofsandladybugposition[sandladybug.sandladybugrand + 1];


                                sandladybug.oldTime = 0;

                            }
                        }
                    }
                }
            }

        }
    }


    void oceanbugUpdate() {


        for (GameObject oceanbug : lm.oceanbuggameObjects) {


            if (oceanbug.initialcondition == true) {

                oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX;

                oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY;

                oceanbug.initialcondition = false;

            } else if (oceanbug.initialcondition == false) {

                oceanbug.updateEnemy(fps * oceanbug.speed, lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        oceanbug.currentxWorld, oceanbug.currentyWorld);

                if (oceanbug.getxVelocity() != 0) {
                    oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX
                            + oceanbug.getSavedxvelocity() + oceanbug.getxVelocity();
                }


                if (oceanbug.getyVelocity() != 0) {
                    oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY
                            + oceanbug.getSavedyvelocity() + oceanbug.getyVelocity();
                }

            }
        }

    }


    void oceanbugLevelTwoOceanUpdate() {

        for (GameObject oceanbug : lm.oceanbuggameObjects) {

            if (oceanbug.initialcondition == true) {

                enemyvaluesinitialize(lm.oceanbuggameObjects, oceanbug, lm.oceanbugObject);

                oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX;

                oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY;

                oceanbug.initialcondition = false;

                lm.oceanbuggameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentxWorld);
                lm.oceanbuggameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentyWorld);


            } else if (oceanbug.initialcondition == false) {


                enemysequencePattern(lm.oceanbuggameObjects, oceanbug, oceanbug.speed * 2.5f);

            }

        }

    }


    void oceanbugsecondLevelTwoOceanUpdate() {

        for (GameObject oceanbug : lm.oceanbugsecondgameObjects) {

            if (oceanbug.initialcondition == true) {


                enemyvaluesinitialize(lm.oceanbugsecondgameObjects, oceanbug, lm.oceanbugsecondObject);

                oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX;

                oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY;

                oceanbug.initialcondition = false;

                lm.oceanbugsecondgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentxWorld);
                lm.oceanbugsecondgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentyWorld);
            } else if (oceanbug.initialcondition == false) {


                enemysequencePattern(lm.oceanbugsecondgameObjects, oceanbug, oceanbug.speed * 2.5f);


            }
        }


    }


    void oceanbugthirdLevelFourOceanUpdate() {

        for (GameObject oceanbug : lm.oceanbugthirdgameObjects) {

            if (oceanbug.initialcondition == true) {



                enemyvaluesinitialize(lm.oceanbugthirdgameObjects, oceanbug, lm.oceanbugthirdObject);

                oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX;

                oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY;

                oceanbug.initialcondition = false;

                lm.oceanbugthirdgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentxWorld);
                lm.oceanbugthirdgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentyWorld);
            } else if (oceanbug.initialcondition == false) {



                enemysequencePattern(lm.oceanbugthirdgameObjects, oceanbug, oceanbug.speed * 2.5f);

            }
        }


    }



    void oceanbugfourthLevelFourOceanUpdate() {

        for (GameObject oceanbug : lm.oceanbugfourthgameObjects) {

            if (oceanbug.initialcondition == true) {


                enemyvaluesinitialize(lm.oceanbugfourthgameObjects, oceanbug, lm.oceanbugfourthObject);

                oceanbug.currentxWorld = oceanbug.getWorldLocation().x - lm.BeginX;

                oceanbug.currentyWorld = oceanbug.getWorldLocation().y - lm.BeginY;

                oceanbug.initialcondition = false;

                lm.oceanbugfourthgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentxWorld);
                lm.oceanbugfourthgameObjects.get(0).enemyValue.bugPosition.add(oceanbug.currentyWorld);
            } else if (oceanbug.initialcondition == false) {



                enemysequencePattern(lm.oceanbugfourthgameObjects, oceanbug, oceanbug.speed * 2.5f);

            }
        }


    }




    void ghostspinderswirlwaterLevelThreeOceanUpdate() {

        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderswirlwatergameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatergameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);

            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatergameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;

        }


    }


    void satelliteghostspinderLevelThreeOceanUpdate(GameObject ghostspinderinstance, ArrayList<GameObject> satellite,
                                                    int loopingcount, float distance, int counter) {


        for (int x = 0; x < loopingcount; x++) {


            if (satellite.get(counter + x).initialcondition == true) {
                satellite.get(counter + x).currentxWorld =
                        ghostspinderinstance.currentxWorld;


                satellite.get(counter + x).currentyWorld =
                        ghostspinderinstance.currentyWorld;


                satellite.get(counter + x).initialcondition = false;
            } else {

                satellite.get(counter + x).updateEnemy(fps *
                                satellite.get(counter + x).speed * (x + 1),
                        satellite.get(counter + x).circledistance * distance,
                        loopingcount,
                        x, 0);

                satellite.get(counter + x).currentxWorld =
                        satellite.get(counter + x).currentxWorld + ghostspinderinstance.currentxWorld;

                satellite.get(counter + x).currentyWorld =
                        satellite.get(counter + x).currentyWorld + ghostspinderinstance.currentyWorld;

            }

        }
    }


    void ghostspindersecondswirlwaterLevelThreeOceanUpdate() {

        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspindersecondswirlwatergameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatersecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatersecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;
        }

    }

    void ghostspinderthirdswirlwaterLevelThreeOceanUpdate() {
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderthirdswirlwatergameObjects) {

            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwaterthirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);

            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwaterthirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);

           

            }

            counter = counter + ghostspinder.satellitecode;

        }

    }


    void ghostspinderstargravLevelThreeOceanUpdate() {

        int counter = 0;
        for (GameObject ghostspinder : lm.ghostspinderstargravgameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;
        }


    }

    void ghostspindersecondstargravLevelThreeOceanUpdate() {

        int counter = 0;
        for (GameObject ghostspinder : lm.ghostspindersecondstargravgameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravsecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravsecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }
            counter = counter + ghostspinder.satellitecode;

        }

    }


    void ghostspinderthirdstargravLevelThreeOceanUpdate() {
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderthirdstargravgameObjects) {

            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravthirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravthirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);



            }
            counter = counter + ghostspinder.satellitecode;


        }

    }


    
    


    String satellitewithconditionghostspinderLevelThreeOceanUpdate(GameObject ghostspinderinstance,
                                                                   ArrayList<GameObject> satellite, int loopcount,
                                                                   int counter) {

        String condition = "";

        for (int x = 0; x < loopcount; x++) {

            if (satellite.get(counter + x).initialcondition == true) {
                satellite.get(counter + x).currentxWorld =
                        ghostspinderinstance.currentxWorld;


                satellite.get(counter + x).currentyWorld =
                        ghostspinderinstance.currentyWorld;


                if (x == 1) {
                    satellite.get(counter + x).circledistance = satellite.get(counter + x).circledistance * 0.6f;
                }


                satellite.get(counter + x).initialcondition = false;

                satellite.get(counter + x).condition = "secondcondition";


            } else {

                if (satellite.get(counter + x).condition.matches("deadcondition")) {


                    satellite.get(counter + x).condition = "secondcondition";


                }


                if (satellite.get(counter + x).condition.matches("secondcondition")) {


                    satellite.get(counter + x).updateEnemy(fps *
                                    ghostspinderinstance.speed,
                            lm.frogFungiPlayer.currentxWorld,
                            lm.frogFungiPlayer.currentyWorld,
                            lm.BeginX, lm.BeginY
                    );

                    satellite.get(counter + x).currentxWorld = satellite.get(counter + x).currentxWorld +
                            ghostspinderinstance.currentxWorld + ghostspinderinstance.getBitmapWidth()/2;


                    satellite.get(counter + x).currentyWorld = satellite.get(counter + x).currentyWorld +
                            ghostspinderinstance.currentyWorld + ghostspinderinstance.getBitmapHeight()/2;


                }

                if (satellite.get(counter + x).condition.matches("thirdcondition")) {


                    satellite.get(counter + x).updateEnemy(fps *
                                    ghostspinderinstance.speed * 0.1f,
                            lm.frogFungiPlayer.currentxWorld,
                            lm.frogFungiPlayer.currentyWorld,
                            lm.BeginX, lm.BeginX);

                    satellite.get(counter + x).currentxWorld =
                            satellite.get(counter + x).getWorldLocation().x - lm.BeginX
                                    + satellite.get(counter + x).getxVelocity();


                    satellite.get(counter + x).currentyWorld =
                            satellite.get(counter + x).getWorldLocation().y - lm.BeginY
                                    + satellite.get(counter + x).getyVelocity();

                }


            }

            if (x == loopcount - 1) {

                condition = satellite.get(counter + x).condition;
            }
        }

        return condition;
    }




    void ghostspindersplashflyLevelFourOceanUpdate() {

        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspindersplashflygameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satellitewithconditionghostspinderLevelThreeOceanUpdate(ghostspinder,
                        lm.splashflygameObjects, ghostspinder.satellitecode, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                if (satellitewithconditionghostspinderLevelThreeOceanUpdate(ghostspinder,
                        lm.splashflygameObjects, ghostspinder.satellitecode, counter).matches("deadcondition")) {

                    satellitewithconditionghostspinderLevelThreeOceanUpdate(ghostspinder,
                            lm.splashflygameObjects, ghostspinder.satellitecode, counter);

                }


                counter = counter + ghostspinder.satellitecode;

            }


        }

    }


    void ghostspinderswirlwaterLevelFourOceanUpdate() {

        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderswirlwatergameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatergameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);

            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatergameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;

        }


    }


    void ghostspindersecondswirlwaterLevelFourOceanUpdate() {
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspindersecondswirlwatergameObjects) {

            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatersecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.swirlwatersecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondswirlwatergameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);


            }

            counter = counter + ghostspinder.satellitecode;

        }

    }



    void ghostspinderstargravLevelFourOceanUpdate() {

        int counter = 0;
        for (GameObject ghostspinder : lm.ghostspinderstargravgameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderstargravgameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;
        }


    }



    void ghostspindersecondstargravLevelFourOceanUpdate() {
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspindersecondstargravgameObjects) {

            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravsecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondstargravgameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.stargravsecondgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspindersecondstargravgameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);

            }
            counter = counter + ghostspinder.satellitecode;


        }

    }





    void beegravLevelFourOceanUpdate() {

        for (GameObject beegrav : lm.beegravgameObjects) {

            if (beegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.beegravgameObjects, beegrav, lm.beegravObject);

                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX;

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY;

                beegrav.initialcondition = false;

                lm.beegravgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentxWorld);
                lm.beegravgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentyWorld);


            } else if (beegrav.initialcondition == false) {

                enemysequencePattern(lm.beegravgameObjects, beegrav, beegrav.speed * 2.5f);


            }
        }

    }

    void beegravsecondLevelFourOceanUpdate() {

        for (GameObject beegrav : lm.beegravsecondgameObjects) {

            if (beegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.beegravsecondgameObjects, beegrav, lm.beegravsecondObject);

                beegrav.currentxWorld = beegrav.getWorldLocation().x - lm.BeginX;

                beegrav.currentyWorld = beegrav.getWorldLocation().y - lm.BeginY;

                beegrav.initialcondition = false;

                lm.beegravsecondgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentxWorld);
                lm.beegravsecondgameObjects.get(0).enemyValue.bugPosition.add(beegrav.currentyWorld);


            } else if (beegrav.initialcondition == false) {


                enemysequencePattern(lm.beegravsecondgameObjects, beegrav, beegrav.speed * 2.5f);

            }
        }

    }

    void smalllavafishUpdate() {

        int finishcounter = 0;
        int notvisible = 0;

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
            if (!smalllavafish.getVisible()) {
                notvisible++;
            }
        }

        if (notvisible > lm.smalllavafishgameObjects.size() / 2) {
            for (GameObject smalllavafish : lm.smalllavafishgameObjects) {

                if (!smalllavafish.getVisible()) {
                    smalllavafish.setVisible(true);
                    smalllavafish.initialcondition = true;
                }

            }
        }

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {


            if (smalllavafish.initialcondition == true) {
                smalllavafish.currentxWorld = smalllavafish.getWorldLocation().x - lm.BeginX;

                smalllavafish.currentyWorld = smalllavafish.getWorldLocation().y - lm.BeginY;

                smalllavafish.setVisible(true);

                smalllavafish.initialcondition = false;
            } else {


                smalllavafish.updateEnemy(fps * smalllavafish.speed, smalllavafish.getWorldLocation().x - lm.BeginX,
                        smalllavafish.getWorldLocation().y - lm.BeginY,
                        lm.firstpreyarrayfinish[finishcounter],
                        lm.firstpreyarrayfinish[finishcounter + 1]);

                smalllavafish.currentxWorld = smalllavafish.getWorldLocation().x - lm.BeginX
                        + smalllavafish.getxVelocity();

                smalllavafish.currentyWorld = smalllavafish.getWorldLocation().y - lm.BeginY
                        + smalllavafish.getyVelocity();


                if (smalllavafish.getxVelocity() == 0 && smalllavafish.currentxWorld != lm.firstpreyarrayfinish[finishcounter]) {
                    smalllavafish.currentxWorld = lm.firstpreyarrayfinish[finishcounter];
                    smalllavafish.currentyWorld = lm.firstpreyarrayfinish[finishcounter + 1];


                }


                finishcounter = finishcounter + 2;

            }

        }


    }

    void biglavafishUpdate() {

        int finishcounter = 0;
        int notvisible = 0;

        for (GameObject biglavafish : lm.biglavafishgameObjects) {
            if (!biglavafish.getVisible()) {
                notvisible++;
            }
        }

        if (notvisible > lm.biglavafishgameObjects.size() / 2) {
            for (GameObject biglavafish : lm.biglavafishgameObjects) {

                if (!biglavafish.getVisible()) {
                    biglavafish.setVisible(true);
                    biglavafish.initialcondition = true;
                }

            }
        }


        for (GameObject biglavafish : lm.biglavafishgameObjects) {


            if (biglavafish.initialcondition == true) {
                biglavafish.currentxWorld = biglavafish.getWorldLocation().x - lm.BeginX;

                biglavafish.currentyWorld = biglavafish.getWorldLocation().y - lm.BeginY;

                biglavafish.setVisible(true);

                biglavafish.initialcondition = false;
            } else {

                biglavafish.updateEnemy(fps * biglavafish.speed, biglavafish.getWorldLocation().x - lm.BeginX,
                        biglavafish.getWorldLocation().y - lm.BeginY,
                        lm.secondpreyarrayfinish[finishcounter],
                        lm.secondpreyarrayfinish[finishcounter + 1]);

                biglavafish.currentxWorld = biglavafish.getWorldLocation().x - lm.BeginX
                        + biglavafish.getxVelocity();

                biglavafish.currentyWorld = biglavafish.getWorldLocation().y - lm.BeginY
                        + biglavafish.getyVelocity();


                if (biglavafish.getxVelocity() == 0 && biglavafish.currentxWorld != lm.secondpreyarrayfinish[finishcounter]) {
                    biglavafish.currentxWorld = lm.secondpreyarrayfinish[finishcounter];
                    biglavafish.currentyWorld = lm.secondpreyarrayfinish[finishcounter + 1];
                }

                finishcounter = finishcounter + 2;


            }

        }
    }


    void rockbeegravUpdate() {
        for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {


            if (rockbeegrav.initialcondition == true) {
                rockbeegrav.currentxWorld = rockbeegrav.getWorldLocation().x - lm.BeginX
                        + rockbeegrav.getxVelocity();

                rockbeegrav.currentyWorld = rockbeegrav.getWorldLocation().y - lm.BeginY
                        + rockbeegrav.getyVelocity();

                rockbeegrav.initialcondition = false;
            } else {

                rockbeegrav.updateEnemy(fps * rockbeegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        rockbeegrav.currentxWorld,
                        rockbeegrav.currentyWorld);

                if (rockbeegrav.getxVelocity() != 0) {
                    rockbeegrav.currentxWorld = rockbeegrav.getWorldLocation().x - lm.BeginX
                            + rockbeegrav.getSavedxvelocity() + rockbeegrav.getxVelocity();
                }


                if (rockbeegrav.getyVelocity() != 0) {
                    rockbeegrav.currentyWorld = rockbeegrav.getWorldLocation().y - lm.BeginY
                            + rockbeegrav.getSavedyvelocity() + rockbeegrav.getyVelocity();
                }


            }


        }


    }


    void rockbeegravsecondUpdate() {

        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {

            if (rockbeegrav.initialcondition == true) {



                enemyvaluesinitialize(lm.rockbeegravsecondgameObjects, rockbeegrav, lm.rockbeegravsecondObject);

                rockbeegrav.currentxWorld = rockbeegrav.getWorldLocation().x - lm.BeginX;

                rockbeegrav.currentyWorld = rockbeegrav.getWorldLocation().y - lm.BeginY;

                rockbeegrav.initialcondition = false;

                lm.rockbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentxWorld);
                lm.rockbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentyWorld);


            } else if (rockbeegrav.initialcondition == false) {


                enemysequencePattern(lm.rockbeegravsecondgameObjects, rockbeegrav, rockbeegrav.speed * 2.5f);

            }

        }

    }

    void rockbeegravthirdLevelTwoLavaUpdate() {

        for (GameObject rockbeegrav : lm.rockbeegravthirdgameObjects) {

            if (rockbeegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.rockbeegravthirdgameObjects, rockbeegrav, lm.rockbeegravthirdObject);

                rockbeegrav.currentxWorld = rockbeegrav.getWorldLocation().x - lm.BeginX;

                rockbeegrav.currentyWorld = rockbeegrav.getWorldLocation().y - lm.BeginY;

                rockbeegrav.initialcondition = false;

                lm.rockbeegravthirdgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentxWorld);
                lm.rockbeegravthirdgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentyWorld);


            } else if (rockbeegrav.initialcondition == false) {

                enemysequencePattern(lm.rockbeegravthirdgameObjects, rockbeegrav, rockbeegrav.speed * 2.5f);


            }

        }

    }


    void rockbeegravfourthLevelTwoLavaUpdate() {

        for (GameObject rockbeegrav : lm.rockbeegravfourthgameObjects) {

            if (rockbeegrav.initialcondition == true) {



                enemyvaluesinitialize(lm.rockbeegravfourthgameObjects, rockbeegrav,
                        lm.rockbeegravfourthObject);

                rockbeegrav.currentxWorld = rockbeegrav.getWorldLocation().x - lm.BeginX;

                rockbeegrav.currentyWorld = rockbeegrav.getWorldLocation().y - lm.BeginY;

                rockbeegrav.initialcondition = false;

                lm.rockbeegravfourthgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentxWorld);
                lm.rockbeegravfourthgameObjects.get(0).enemyValue.bugPosition.add(rockbeegrav.currentyWorld);


            } else if (rockbeegrav.initialcondition == false) {

                enemysequencePattern(lm.rockbeegravfourthgameObjects, rockbeegrav, rockbeegrav.speed * 2.5f);


            }

        }

    }


    void rockbigbeegravUpdate() {
        for (GameObject rockbigbeegrav : lm.rockbigbeegravgameObjects) {


            if (rockbigbeegrav.initialcondition == true) {
                rockbigbeegrav.currentxWorld = rockbigbeegrav.getWorldLocation().x - lm.BeginX
                        + rockbigbeegrav.getxVelocity();

                rockbigbeegrav.currentyWorld = rockbigbeegrav.getWorldLocation().y - lm.BeginY
                        + rockbigbeegrav.getyVelocity();

                rockbigbeegrav.initialcondition = false;
            } else {

                rockbigbeegrav.updateEnemy(fps * rockbigbeegrav.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2,
                        lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + lm.bgLandscape.getbackgroundxResolution() / 2,
                        lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.bgLandscape.getbackgroundyResolution()/2);


                if (rockbigbeegrav.getxVelocity() != 0) {
                    rockbigbeegrav.currentxWorld = rockbigbeegrav.getWorldLocation().x - lm.BeginX
                            + rockbigbeegrav.getSavedxvelocity() + rockbigbeegrav.getxVelocity();
                }


                if (rockbigbeegrav.getyVelocity() != 0) {
                    rockbigbeegrav.currentyWorld = rockbigbeegrav.getWorldLocation().y - lm.BeginY
                            + rockbigbeegrav.getSavedyvelocity() + rockbigbeegrav.getyVelocity();
                }


            }


        }


    }


    void rockbigbeegravsecondUpdate() {

        for (GameObject rockbigbeegrav : lm.rockbigbeegravsecondgameObjects) {

            if (rockbigbeegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.rockbigbeegravsecondgameObjects, rockbigbeegrav, lm.rockbigbeegravsecondObject);


                rockbigbeegrav.currentxWorld = rockbigbeegrav.getWorldLocation().x - lm.BeginX;

                rockbigbeegrav.currentyWorld = rockbigbeegrav.getWorldLocation().y - lm.BeginY;

                rockbigbeegrav.initialcondition = false;

                lm.rockbigbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentxWorld);
                lm.rockbigbeegravsecondgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentyWorld);


            } else if (rockbigbeegrav.initialcondition == false) {

                enemysequencePattern(lm.rockbigbeegravsecondgameObjects, rockbigbeegrav, rockbigbeegrav.speed * 2.5f);


            }

        }

    }


    void rockbigbeegravthirdLevelTwoUpdate() {

        for (GameObject rockbigbeegrav : lm.rockbigbeegravthirdgameObjects) {

            if (rockbigbeegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.rockbigbeegravthirdgameObjects, rockbigbeegrav, lm.rockbigbeegravthirdObject);


                rockbigbeegrav.currentxWorld = rockbigbeegrav.getWorldLocation().x - lm.BeginX;

                rockbigbeegrav.currentyWorld = rockbigbeegrav.getWorldLocation().y - lm.BeginY;

                rockbigbeegrav.initialcondition = false;

                lm.rockbigbeegravthirdgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentxWorld);
                lm.rockbigbeegravthirdgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentyWorld);


            } else if (rockbigbeegrav.initialcondition == false) {

                enemysequencePattern(lm.rockbigbeegravthirdgameObjects, rockbigbeegrav, rockbigbeegrav.speed * 2.5f);


            }

        }

    }

    void rockbigbeegravfourthLevelTwoUpdate() {

        for (GameObject rockbigbeegrav : lm.rockbigbeegravfourthgameObjects) {

            if (rockbigbeegrav.initialcondition == true) {


                enemyvaluesinitialize(lm.rockbigbeegravfourthgameObjects, rockbigbeegrav, lm.rockbigbeegravfourthObject);

                rockbigbeegrav.currentxWorld = rockbigbeegrav.getWorldLocation().x - lm.BeginX;

                rockbigbeegrav.currentyWorld = rockbigbeegrav.getWorldLocation().y - lm.BeginY;

                rockbigbeegrav.initialcondition = false;

                lm.rockbigbeegravfourthgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentxWorld);
                lm.rockbigbeegravfourthgameObjects.get(0).enemyValue.bugPosition.add(rockbigbeegrav.currentyWorld);


            } else if (rockbigbeegrav.initialcondition == false) {


                enemysequencePattern(lm.rockbigbeegravfourthgameObjects, rockbigbeegrav, rockbigbeegrav.speed * 2.5f);


            }

        }

    }


    void dustrockbeegravlavaUpdate() {
        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavagameObjects) {


            if (dustrockbeegravlava.initialcondition == true) {
                dustrockbeegravlava.currentxWorld = dustrockbeegravlava.getWorldLocation().x - lm.BeginX
                        + dustrockbeegravlava.getxVelocity();

                dustrockbeegravlava.currentyWorld = dustrockbeegravlava.getWorldLocation().y - lm.BeginY
                        + dustrockbeegravlava.getyVelocity();

                dustrockbeegravlava.initialcondition = false;
            } else {

                dustrockbeegravlava.updateEnemy(fps * dustrockbeegravlava.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        dustrockbeegravlava.currentxWorld,
                        dustrockbeegravlava.currentyWorld);


                if (dustrockbeegravlava.getxVelocity() != 0) {
                    dustrockbeegravlava.currentxWorld = dustrockbeegravlava.getWorldLocation().x - lm.BeginX
                            + dustrockbeegravlava.getSavedxvelocity() + dustrockbeegravlava.getxVelocity();
                }


                if (dustrockbeegravlava.getyVelocity() != 0) {
                    dustrockbeegravlava.currentyWorld = dustrockbeegravlava.getWorldLocation().y - lm.BeginY
                            + dustrockbeegravlava.getSavedyvelocity() + dustrockbeegravlava.getyVelocity();
                }


            }


        }


    }

    void dustrockbeegravlavasecondLevelTwoUpdate() {

        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavasecondgameObjects) {

            if (dustrockbeegravlava.initialcondition == true) {



                enemyvaluesinitialize(lm.dustrockbeegravlavasecondgameObjects, dustrockbeegravlava, 
                        lm.dustrockbeegravlavasecondObject);

                dustrockbeegravlava.currentxWorld = dustrockbeegravlava.getWorldLocation().x - lm.BeginX;

                dustrockbeegravlava.currentyWorld = dustrockbeegravlava.getWorldLocation().y - lm.BeginY;

                dustrockbeegravlava.initialcondition = false;

                lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentxWorld);
                lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentyWorld);


            } else if (dustrockbeegravlava.initialcondition == false) {


                enemysequencePattern(lm.dustrockbeegravlavasecondgameObjects, dustrockbeegravlava, dustrockbeegravlava.speed * 2.5f);

            }

        }

    }


    void dustrockbeegravlavathirdLevelTwoUpdate() {

        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavathirdgameObjects) {

            if (dustrockbeegravlava.initialcondition == true) {


                enemyvaluesinitialize(lm.dustrockbeegravlavathirdgameObjects, dustrockbeegravlava,
                        lm.dustrockbeegravlavathirdObject);

                dustrockbeegravlava.currentxWorld = dustrockbeegravlava.getWorldLocation().x - lm.BeginX;

                dustrockbeegravlava.currentyWorld = dustrockbeegravlava.getWorldLocation().y - lm.BeginY;

                dustrockbeegravlava.initialcondition = false;

                lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentxWorld);
                lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentyWorld);


            } else if (dustrockbeegravlava.initialcondition == false) {


                enemysequencePattern(lm.dustrockbeegravlavathirdgameObjects, dustrockbeegravlava, dustrockbeegravlava.speed * 2.5f);
            }

        }

    }


    void dustrockbeegravlavafourthLevelTwoUpdate() {

        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavafourthgameObjects) {

            if (dustrockbeegravlava.initialcondition == true) {


                enemyvaluesinitialize(lm.dustrockbeegravlavafourthgameObjects, dustrockbeegravlava,
                        lm.dustrockbeegravlavafourthObject);

                dustrockbeegravlava.currentxWorld = dustrockbeegravlava.getWorldLocation().x - lm.BeginX;

                dustrockbeegravlava.currentyWorld = dustrockbeegravlava.getWorldLocation().y - lm.BeginY;

                dustrockbeegravlava.initialcondition = false;

                lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentxWorld);
                lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue.bugPosition.add(dustrockbeegravlava.currentyWorld);


            } else if (dustrockbeegravlava.initialcondition == false) {

                enemysequencePattern(lm.dustrockbeegravlavafourthgameObjects, dustrockbeegravlava, dustrockbeegravlava.speed * 2.5f);

            }

        }

    }


    void ghostspinderbigdustrockbeegravlavaLevelTwoLavaUpdate() {

        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderbigdustrockbeegravlavagameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavagameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavagameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


            }

            counter = counter + ghostspinder.satellitecode;
        }


    }

   void ghostspindersecondbigdustrockbeegravlavaLevelThreeLavaUpdate(){

       int counter = 0;

       for (GameObject ghostspinder : lm.ghostspindersecondbigdustrockbeegravlavagameObjects) {


           if (ghostspinder.initialcondition == true) {
               ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                       + ghostspinder.getxVelocity();

               ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                       + ghostspinder.getyVelocity();

               ghostspinder.initialcondition = false;

               satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavasecondgameObjects, ghostspinder.satellitecode,
                       (lm.ghostspindersecondbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


           } else {

               ghostspinder.updateEnemy(fps * ghostspinder.speed,
                       lm.frogFungiPlayer.currentxWorld,
                       lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                       ghostspinder.currentxWorld,
                       ghostspinder.currentyWorld);

               if (ghostspinder.getxVelocity() != 0) {
                   ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                           + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
               }


               if (ghostspinder.getyVelocity() != 0) {
                   ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                           + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

               }


               satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavasecondgameObjects, ghostspinder.satellitecode,
                       (lm.ghostspindersecondbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.25f, counter);


           }

           counter = counter + ghostspinder.satellitecode;
       }

   }


    void ghostspinderthirdbigdustrockbeegravlavaLevelThreeLavaUpdate(){
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderthirdbigdustrockbeegravlavagameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavathirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavathirdgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderthirdbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.75f, counter);


            }

            counter = counter + ghostspinder.satellitecode;
        }


    }



    void ghostspinderfourthbigdustrockbeegravlavaLevelThreeLavaUpdate(){
        int counter = 0;

        for (GameObject ghostspinder : lm.ghostspinderfourthbigdustrockbeegravlavagameObjects) {


            if (ghostspinder.initialcondition == true) {
                ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                        + ghostspinder.getxVelocity();

                ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                        + ghostspinder.getyVelocity();

                ghostspinder.initialcondition = false;

                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavafourthgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderfourthbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.35f, counter);


            } else {

                ghostspinder.updateEnemy(fps * ghostspinder.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        ghostspinder.currentxWorld,
                        ghostspinder.currentyWorld);

                if (ghostspinder.getxVelocity() != 0) {
                    ghostspinder.currentxWorld = ghostspinder.getWorldLocation().x - lm.BeginX
                            + ghostspinder.getSavedxvelocity() + ghostspinder.getxVelocity();
                }


                if (ghostspinder.getyVelocity() != 0) {
                    ghostspinder.currentyWorld = ghostspinder.getWorldLocation().y - lm.BeginY
                            + ghostspinder.getSavedyvelocity() + ghostspinder.getyVelocity();

                }


                satelliteghostspinderLevelThreeOceanUpdate(ghostspinder, lm.bigdustrockbeegravlavafourthgameObjects, ghostspinder.satellitecode,
                        (lm.ghostspinderfourthbigdustrockbeegravlavagameObjects.indexOf(ghostspinder) + 1) * 0.35f, counter);


            }
                counter = counter + ghostspinder.satellitecode;

            }


        }




    void bigdustrockbeegravlavaLevelFourUpdate() {
        
        int counter = 0;
        
        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavagameObjects) {


            if (bigdustrockbeegravlava.initialcondition == true) {
                bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                        + bigdustrockbeegravlava.getxVelocity();

                bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                        + bigdustrockbeegravlava.getyVelocity();

                bigdustrockbeegravlava.initialcondition = false;

                satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletgameObjects, bigdustrockbeegravlava.satellitecode, counter);

            } else {

                bigdustrockbeegravlava.updateEnemyLevelTwo(fps * bigdustrockbeegravlava.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        bigdustrockbeegravlava.currentxWorld,
                        bigdustrockbeegravlava.currentyWorld);

                if (bigdustrockbeegravlava.getxVelocity() != 0) {
                    bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                            + bigdustrockbeegravlava.getSavedxvelocity() + bigdustrockbeegravlava.getxVelocity();
                }

                if (bigdustrockbeegravlava.getyVelocity() != 0) {
                    bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                            + bigdustrockbeegravlava.getSavedyvelocity() + bigdustrockbeegravlava.getyVelocity();
                }


                if (satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletgameObjects, bigdustrockbeegravlava.satellitecode, counter).matches("deadcondition")) {

                    satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                            lm.dustbulletgameObjects, bigdustrockbeegravlava.satellitecode, counter);

                }



            }

            
            counter = counter + bigdustrockbeegravlava.satellitecode;

        }


    }



    void bigdustrockbeegravlavasecondLevelFourUpdate() {

        int counter = 0;

        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavasecondgameObjects) {


            if (bigdustrockbeegravlava.initialcondition == true) {
                bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                        + bigdustrockbeegravlava.getxVelocity();

                bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                        + bigdustrockbeegravlava.getyVelocity();

                bigdustrockbeegravlava.initialcondition = false;

                satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletsecondgameObjects, bigdustrockbeegravlava.satellitecode, counter);

            } else {

                bigdustrockbeegravlava.updateEnemyLevelTwo(fps * bigdustrockbeegravlava.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        bigdustrockbeegravlava.currentxWorld,
                        bigdustrockbeegravlava.currentyWorld);

                if (bigdustrockbeegravlava.getxVelocity() != 0) {
                    bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                            + bigdustrockbeegravlava.getSavedxvelocity() + bigdustrockbeegravlava.getxVelocity();
                }

                if (bigdustrockbeegravlava.getyVelocity() != 0) {
                    bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                            + bigdustrockbeegravlava.getSavedyvelocity() + bigdustrockbeegravlava.getyVelocity();
                }

                if (satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletsecondgameObjects, bigdustrockbeegravlava.satellitecode, counter).matches("deadcondition")) {

                    satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                            lm.dustbulletsecondgameObjects, bigdustrockbeegravlava.satellitecode, counter);

                }



            }
            counter = counter + bigdustrockbeegravlava.satellitecode;

        }


    }



    void bigdustrockbeegravlavathirdLevelFourUpdate() {

        int counter = 0;

        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavathirdgameObjects) {


            if (bigdustrockbeegravlava.initialcondition == true) {
                bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                        + bigdustrockbeegravlava.getxVelocity();

                bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                        + bigdustrockbeegravlava.getyVelocity();

                bigdustrockbeegravlava.initialcondition = false;

                satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletthirdgameObjects, bigdustrockbeegravlava.satellitecode, counter);

            } else {

                bigdustrockbeegravlava.updateEnemyLevelTwo(fps * bigdustrockbeegravlava.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        bigdustrockbeegravlava.currentxWorld,
                        bigdustrockbeegravlava.currentyWorld);

                if (bigdustrockbeegravlava.getxVelocity() != 0) {
                    bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                            + bigdustrockbeegravlava.getSavedxvelocity() + bigdustrockbeegravlava.getxVelocity();
                }

                if (bigdustrockbeegravlava.getyVelocity() != 0) {
                    bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                            + bigdustrockbeegravlava.getSavedyvelocity() + bigdustrockbeegravlava.getyVelocity();
                }

                if (satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletthirdgameObjects, bigdustrockbeegravlava.satellitecode, counter).matches("deadcondition")) {

                    satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                            lm.dustbulletthirdgameObjects, bigdustrockbeegravlava.satellitecode, counter);

                }



            }
            counter = counter + bigdustrockbeegravlava.satellitecode;

        }


    }


    void bigdustrockbeegravlavafourthLevelFourUpdate() {

        int counter = 0;

        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavafourthgameObjects) {


            if (bigdustrockbeegravlava.initialcondition == true) {
                bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                        + bigdustrockbeegravlava.getxVelocity();

                bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                        + bigdustrockbeegravlava.getyVelocity();

                bigdustrockbeegravlava.initialcondition = false;

                satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletfourthgameObjects, bigdustrockbeegravlava.satellitecode, counter);

            } else {

                bigdustrockbeegravlava.updateEnemyLevelTwo(fps * bigdustrockbeegravlava.speed,
                        lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                        bigdustrockbeegravlava.currentxWorld,
                        bigdustrockbeegravlava.currentyWorld);

                if (bigdustrockbeegravlava.getxVelocity() != 0) {
                    bigdustrockbeegravlava.currentxWorld = bigdustrockbeegravlava.getWorldLocation().x - lm.BeginX
                            + bigdustrockbeegravlava.getSavedxvelocity() + bigdustrockbeegravlava.getxVelocity();
                }

                if (bigdustrockbeegravlava.getyVelocity() != 0) {
                    bigdustrockbeegravlava.currentyWorld = bigdustrockbeegravlava.getWorldLocation().y - lm.BeginY
                            + bigdustrockbeegravlava.getSavedyvelocity() + bigdustrockbeegravlava.getyVelocity();
                }

                if (satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                        lm.dustbulletfourthgameObjects, bigdustrockbeegravlava.satellitecode, counter).matches("deadcondition")) {

                    satellitewithconditionghostspinderLevelThreeOceanUpdate(bigdustrockbeegravlava,
                            lm.dustbulletfourthgameObjects, bigdustrockbeegravlava.satellitecode, counter);

                }



            }
            counter = counter + bigdustrockbeegravlava.satellitecode;

        }


    }
    
    
    


    void fungilavaUpdate() {


        for (GameObject fungilava : lm.fungilavagameObjects) {


            if (fungilava.initialcondition == true) {
                fungilava.currentxWorld = fungilava.getWorldLocation().x - lm.BeginX;

                fungilava.currentyWorld = fungilava.getWorldLocation().y - lm.BeginY;


                fungilava.initialcondition = false;
            } else {

                if (fungilava.nextxPosition != 0 && fungilava.nextyPosition != 0) {

                    fungilava.updateEnemy(fps * fungilava.speed, fungilava.nextxPosition, fungilava.nextyPosition,
                            fungilava.getWorldLocation().x - lm.BeginX,
                            fungilava.getWorldLocation().y - lm.BeginY);

                    fungilava.currentxWorld = fungilava.getWorldLocation().x - lm.BeginX
                            + fungilava.getxVelocity();

                    fungilava.currentyWorld = fungilava.getWorldLocation().y - lm.BeginY
                            + fungilava.getyVelocity();


                    if (fungilava.getxVelocity() != 0 && fungilava.oldTime != 0) {
                        fungilava.oldTime = 0;
                    }

                    if (fungilava.getxVelocity() == 0 && fungilava.getyVelocity() == 0) {
                        fungilava.currentxWorld = fungilava.nextxPosition;
                        fungilava.currentyWorld = fungilava.nextyPosition;

                        fungilava.nextxPosition = 0;
                        fungilava.nextyPosition = 0;

                        fungilava.setWorldLocation(lm.BeginX + fungilava.currentxWorld,
                                lm.BeginY + fungilava.currentyWorld);

                    }
                } else {
                    if (fungilava.oldTime == 0) {
                        fungilava.oldTime = System.nanoTime();
                    }

                    if (TimeUnit.SECONDS.convert(System.nanoTime() - fungilava.oldTime, TimeUnit.NANOSECONDS) >= 3) {


                        if (fungilava.currentxWorld == lm.arraylistoflavabugposition[fungilava.fungilavarand]) {
                            if (fungilava.currentyWorld == lm.arraylistoflavabugposition[fungilava.fungilavarand + 1]
                                    + (int) (lm.bgLandscape.getbackgroundyResolution() * 2)) {


                                Integer[] fungiarr = preciserandom(lm.arraylistoflavabugposition, true);


                                for (int q = 0; q < lm.arraylistoflavabugposition.length; q++) {

                                    if (lm.arraylistoflavabugposition[q].equals(fungiarr[lm.fungilavagameObjects.indexOf(fungilava)])) {
                                        fungilava.fungilavarand = q;
                                        break;
                                    }


                                }


                                fungilava.nextxPosition = lm.arraylistoflavabugposition[fungilava.fungilavarand];
                                fungilava.nextyPosition = lm.arraylistoflavabugposition[fungilava.fungilavarand + 1] + (int) (lm.bgLandscape.getbackgroundyResolution() * 2);


                                fungilava.oldTime = 0;


                            }
                        }
                    }
                }
            }
        }
    }


    void jumpingratlavaUpdate() {


        for (GameObject jumpingratlava : lm.jumpingratlavagameObjects) {


            if (jumpingratlava.initialcondition == true) {
                jumpingratlava.currentxWorld = jumpingratlava.getWorldLocation().x - lm.BeginX;

                jumpingratlava.currentyWorld = jumpingratlava.getWorldLocation().y - lm.BeginY;


                jumpingratlava.initialcondition = false;
            } else {


                if (jumpingratlava.nextxPosition != 0 && jumpingratlava.nextyPosition != 0) {

                    jumpingratlava.updateEnemy(fps * jumpingratlava.speed, jumpingratlava.nextxPosition, jumpingratlava.nextyPosition,
                            jumpingratlava.getWorldLocation().x - lm.BeginX,
                            jumpingratlava.getWorldLocation().y - lm.BeginY);


                    jumpingratlava.currentxWorld = jumpingratlava.getWorldLocation().x - lm.BeginX
                            + jumpingratlava.getxVelocity();

                    jumpingratlava.currentyWorld = jumpingratlava.getWorldLocation().y - lm.BeginY
                            + jumpingratlava.getyVelocity();


                    if (jumpingratlava.getxVelocity() == 0 && jumpingratlava.getyVelocity() == 0) {
                        jumpingratlava.currentxWorld = jumpingratlava.nextxPosition;
                        jumpingratlava.currentyWorld = jumpingratlava.nextyPosition;

                        jumpingratlava.setWorldLocation(lm.BeginX + jumpingratlava.currentxWorld,
                                lm.BeginY + jumpingratlava.currentyWorld);

                        jumpingratlava.nextxPosition = 0;
                        jumpingratlava.nextyPosition = 0;

                    }

                } else {

                    if (jumpingratlava.oldTime == 0) {
                        jumpingratlava.oldTime = System.nanoTime();
                    }
                    if (TimeUnit.SECONDS.convert(System.nanoTime() - jumpingratlava.oldTime, TimeUnit.NANOSECONDS) >= 3) {

                        if (jumpingratlava.currentxWorld == lm.arraylistoflavabugposition[jumpingratlava.jumpingratlavarand]
                                - (int) (jumpingratlava.getBitmapWidth() / 2)) {
                            if (jumpingratlava.currentyWorld == lm.arraylistoflavabugposition[jumpingratlava.jumpingratlavarand + 1]
                                    - (int) (jumpingratlava.getBitmapHeight() / 2)) {

                                Integer[] jumpratarr = preciserandom(lm.arraylistoflavabugposition, true);

                                for (int q = 0; q < lm.arraylistoflavabugposition.length; q++) {

                                    if (lm.arraylistoflavabugposition[q].equals(jumpratarr[lm.jumpingratlavagameObjects.indexOf(jumpingratlava)])) {
                                        jumpingratlava.jumpingratlavarand = q;
                                        break;
                                    }
                                    ;

                                }


                                jumpingratlava.nextxPosition = lm.arraylistoflavabugposition[jumpingratlava.jumpingratlavarand]
                                        - (int) (jumpingratlava.getBitmapWidth() / 2);
                                jumpingratlava.nextyPosition = lm.arraylistoflavabugposition[jumpingratlava.jumpingratlavarand + 1]
                                        - (int) (jumpingratlava.getBitmapHeight() / 2);

                                jumpingratlava.oldTime = 0;

                            }
                        }
                    }
                }
            }
        }
    }


    void guardianbeegravUpdate() {

        for (GameObject guardianbeegrav : lm.guardianbeegravgameObjects) {
            if (guardianbeegrav.initialcondition == true) {
                guardianbeegrav.currentxWorld = guardianbeegrav.getWorldLocation().x - lm.BeginX;

                guardianbeegrav.currentyWorld = guardianbeegrav.getWorldLocation().y - lm.BeginY;

                guardianbeegrav.initialcondition = false;
            } else {

                guardianbeegrav.updateEnemy(fps * guardianbeegrav.speed, 0, 0, 0, 0);


            }


        }


    }


    void suckerbeegravUpdate() {

        for (GameObject suckerbeegrav : lm.suckerbeegravgameObjects) {


            if (suckerbeegrav.initialcondition == true) {
                suckerbeegrav.currentxWorld = suckerbeegrav.getWorldLocation().x - lm.BeginX;

                suckerbeegrav.currentyWorld = suckerbeegrav.getWorldLocation().y - lm.BeginY;


                suckerbeegrav.initialcondition = false;
            } else {
                if (suckerbeegrav.nextxPosition != 0 && suckerbeegrav.nextyPosition != 0) {
                    suckerbeegrav.updateEnemy(fps * suckerbeegrav.speed, suckerbeegrav.nextxPosition, suckerbeegrav.nextyPosition,
                            suckerbeegrav.getWorldLocation().x - lm.BeginX,
                            suckerbeegrav.getWorldLocation().y - lm.BeginY);

                    suckerbeegrav.currentxWorld = suckerbeegrav.getWorldLocation().x - lm.BeginX
                            + suckerbeegrav.getSavedxvelocity() + suckerbeegrav.getxVelocity();

                    suckerbeegrav.currentyWorld = suckerbeegrav.getWorldLocation().y - lm.BeginY
                            + suckerbeegrav.getSavedyvelocity() + suckerbeegrav.getyVelocity();


                    checksuckerbeegravlastUpdate(suckerbeegrav);


                    if (suckerbeegrav.getxVelocity() == 0 && suckerbeegrav.getyVelocity() == 0 &&
                            suckerbeegrav.nextxPosition != 0) {
                        suckerbeegrav.currentxWorld = suckerbeegrav.nextxPosition;
                        suckerbeegrav.currentyWorld = suckerbeegrav.nextyPosition;

                        suckerbeegrav.setWorldLocation(lm.BeginX + suckerbeegrav.currentxWorld,
                                lm.BeginY + suckerbeegrav.currentyWorld);


                        suckerbeegrav.nextxPosition = 0;
                        suckerbeegrav.nextyPosition = 0;

                        suckerbeegrav.resetSavedxvelocity();
                        suckerbeegrav.resetSavedyvelocity();


                    }
                } else if (suckerbeegrav.nextxPosition == 0 && suckerbeegrav.nextyPosition == 0) {


                    if (suckerbeegrav.currentxWorld == lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand]) {
                        if (suckerbeegrav.currentyWorld == lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand + 1]) {

                            Integer[] suckerbeegravarr = preciserandom(lm.arraylistofsuckerbeegravposition, true);


                            for (int q = 0; q < lm.arraylistofsuckerbeegravposition.length; q++) {

                                if (lm.arraylistofsuckerbeegravposition[q] == suckerbeegravarr[lm.suckerbeegravgameObjects.indexOf(suckerbeegrav)]) {
                                    suckerbeegrav.suckerbeegravrand = q;
                                    break;
                                }


                            }


                            suckerbeegrav.nextxPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand];
                            suckerbeegrav.nextyPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand + 1];


                        }
                    }
                }


            }

        }

    }


    void suckerbeegravUpdateLevelFourOcean() {


        for (GameObject suckerbeegrav : lm.suckerbeegravgameObjects) {


            if (suckerbeegrav.initialcondition == true) {
                suckerbeegrav.currentxWorld = suckerbeegrav.getWorldLocation().x - lm.BeginX;

                suckerbeegrav.currentyWorld = suckerbeegrav.getWorldLocation().y - lm.BeginY;


                suckerbeegrav.initialcondition = false;
            } else {


                if (suckerbeegrav.oldTime == 0) {
                    suckerbeegrav.oldTime = System.nanoTime();
                }
                if (TimeUnit.SECONDS.convert(System.nanoTime() - suckerbeegrav.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    if (suckerbeegravrandom == 6) {
                        suckerbeegravrandom = suckerbeegrav.rand.nextInt(lm.suckerbeegravgameObjects.size());
                    }

                    if (lm.suckerbeegravgameObjects.indexOf(suckerbeegrav) == suckerbeegravrandom) {


                        if (suckerbeegrav.getxVelocity() == 0 && suckerbeegrav.getyVelocity() == 0 && suckerbeegrav.currentxWorld != suckerbeegrav.nextxPosition &&
                                suckerbeegrav.nextxPosition != 0 && suckerbeegrav.condition.matches("thirdcondition") && hasSucked == true) {

                            suckerbeegrav.currentxWorld = suckerbeegrav.nextxPosition;
                            suckerbeegrav.currentyWorld = suckerbeegrav.nextyPosition;

                            suckerbeegrav.setWorldLocation(lm.BeginX + suckerbeegrav.currentxWorld,
                                    lm.BeginY + suckerbeegrav.currentyWorld

                            );

                            suckerbeegrav.resetSavedxvelocity();
                            suckerbeegrav.resetSavedyvelocity();


                            if (suckerbeegrav.oldTime != 0) {
                                suckerbeegrav.oldTime = 0;
                                suckerbeegrav.condition = "secondcondition";
                                suckerbeegravrandom = 6;
                                hasSucked = false;
                            }


                        }


                        for (int x = 0; x < lm.arraylistofsuckerbeegravposition.length; x = x + 2) {
                            if (suckerbeegrav.currentxWorld == lm.arraylistofsuckerbeegravposition[x]) {
                                if (suckerbeegrav.currentyWorld == lm.arraylistofsuckerbeegravposition[x + 1]) {


                                    suckerbeegrav.suckerbeegravrand = suckerbeegrav.rand.nextInt(lm.bgLandscape.fungispecialnumber.length);


                                    int funginumberindex = 0;

                                    for (int j = 0; j < lm.bgLandscape.funginumber.length; j++) {
                                        if (lm.bgLandscape.funginumber[j] == lm.bgLandscape.fungispecialnumber[suckerbeegrav.suckerbeegravrand]) {
                                            funginumberindex = j;
                                            break;
                                        }
                                    }


                                    suckerbeegrav.nextxPosition = lm.bgLandscape.fungiArray[funginumberindex * 2];
                                    suckerbeegrav.nextyPosition = lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1];

                                    suckerbeegrav.condition = "thirdcondition";
                                }
                            }
                        }
                    } else {

                        suckerbeegrav.condition = "firstcondition";
                        if (suckerbeegrav.oldTime != 0) {
                            suckerbeegrav.oldTime = 0;
                        }
                    }
                } else {

                    if (suckerbeegrav.condition.matches("secondcondition")) {
                        Integer[] suckerbeegravarr = preciserandom(lm.arraylistofsuckerbeegravposition, true);


                        for (int q = 0; q < lm.arraylistofsuckerbeegravposition.length; q++) {

                            if (lm.arraylistofsuckerbeegravposition[q] == suckerbeegravarr[lm.suckerbeegravgameObjects.indexOf(suckerbeegrav)]) {
                                suckerbeegrav.suckerbeegravrand = q;
                                break;
                            }


                        }


                        suckerbeegrav.nextxPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand];
                        suckerbeegrav.nextyPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand + 1];
                        suckerbeegrav.condition = "firstcondition";

                    } else if (suckerbeegrav.condition.matches("firstcondition")) {

                        if (suckerbeegrav.currentxWorld == lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand]) {
                            if (suckerbeegrav.currentyWorld == lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand + 1]) {


                                Integer[] suckerbeegravarr = preciserandom(lm.arraylistofsuckerbeegravposition, true);


                                for (int q = 0; q < lm.arraylistofsuckerbeegravposition.length; q++) {

                                    if (lm.arraylistofsuckerbeegravposition[q] == suckerbeegravarr[lm.suckerbeegravgameObjects.indexOf(suckerbeegrav)]) {
                                        suckerbeegrav.suckerbeegravrand = q;
                                        break;
                                    }


                                }


                                suckerbeegrav.nextxPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand];
                                suckerbeegrav.nextyPosition = lm.arraylistofsuckerbeegravposition[suckerbeegrav.suckerbeegravrand + 1];

                            }
                        }
                    }
                }


                suckerbeegrav.updateEnemy(fps * suckerbeegrav.speed, suckerbeegrav.nextxPosition,
                        suckerbeegrav.nextyPosition,
                        suckerbeegrav.getWorldLocation().x - lm.BeginX,
                        suckerbeegrav.getWorldLocation().y - lm.BeginY);

                suckerbeegrav.currentxWorld = suckerbeegrav.getWorldLocation().x - lm.BeginX
                        + suckerbeegrav.getxVelocity() + suckerbeegrav.getSavedxvelocity();

                suckerbeegrav.currentyWorld = suckerbeegrav.getWorldLocation().y - lm.BeginY
                        + suckerbeegrav.getyVelocity() + suckerbeegrav.getSavedyvelocity();


                if (suckerbeegrav.condition.matches("thirdcondition")) {


                    int funginumberindex = 0;

                    for (int j = 0; j < lm.bgLandscape.funginumber.length; j++) {
                        if (lm.bgLandscape.funginumber[j] == lm.bgLandscape.fungispecialnumber[suckerbeegrav.suckerbeegravrand]) {
                            funginumberindex = j;
                            break;
                        }
                    }


                    if (suckerbeegrav.currentxWorld < lm.bgLandscape.fungiArray[funginumberindex * 2]) {
                        if (suckerbeegrav.currentxWorld + suckerbeegrav.getBitmapWidth() >=
                                lm.bgLandscape.fungiArray[funginumberindex * 2]) {

                            if (suckerbeegrav.currentyWorld < lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() >=
                                        lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                    setFungihasChanged(suckerbeegrav);
                                }
                            }

                            if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() > lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {


                                if (suckerbeegrav.currentyWorld <=
                                        lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                    setFungihasChanged(suckerbeegrav);
                                }

                            }

                        }
                    } else if (suckerbeegrav.currentxWorld + suckerbeegrav.getBitmapWidth() > lm.bgLandscape.fungiArray[funginumberindex * 2]) {

                        if (suckerbeegrav.currentxWorld <=
                                lm.bgLandscape.fungiArray[funginumberindex * 2]) {


                            if (suckerbeegrav.currentyWorld < lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() >=
                                        lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                    setFungihasChanged(suckerbeegrav);
                                }
                            }


                            if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() > lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                if (suckerbeegrav.currentyWorld <=
                                        lm.bgLandscape.fungiArray[(funginumberindex * 2) + 1]) {

                                    setFungihasChanged(suckerbeegrav);
                                }
                            }
                        }


                    }


                }


                if (suckerbeegrav.getxVelocity() == 0 && suckerbeegrav.getyVelocity() == 0 &&
                        suckerbeegrav.currentxWorld != suckerbeegrav.nextxPosition &&
                        suckerbeegrav.condition.matches("firstcondition")) {

                    suckerbeegrav.currentxWorld = suckerbeegrav.nextxPosition;
                    suckerbeegrav.currentyWorld = suckerbeegrav.nextyPosition;


                    suckerbeegrav.setWorldLocation(lm.BeginX + suckerbeegrav.currentxWorld,
                            lm.BeginY + suckerbeegrav.currentyWorld
                    );


                    suckerbeegrav.resetSavedxvelocity();
                    suckerbeegrav.resetSavedyvelocity();


                }


            }

        }
    }


    void setFungihasChanged(GameObject suckerbeegrav) {

        boolean checkfungichanged = true;

        if (fungihasChanged.size() < 4) {
            for (int z = 0; z < fungihasChanged.size(); z++) {
                if (fungihasChanged.get(z) == suckerbeegrav.suckerbeegravrand) {
                    checkfungichanged = false;
                }
            }
            if (checkfungichanged == true) {
                fungihasChanged.add(suckerbeegrav.suckerbeegravrand);
            }
        }

        hasSucked = true;

    }


    void setFireFungihasChanged(GameObject transparentchub) {

        boolean checkfungichanged = true;


        if (fungihasChanged.size() < 4) {
            for (int z = 0; z < fungihasChanged.size(); z++) {
                if (fungihasChanged.get(z) == transparentchub.transparentchubrand) {
                    checkfungichanged = false;
                }
            }
            if (checkfungichanged == true) {
                fungihasChanged.add(transparentchub.transparentchubrand);
                transparentchub.condition = "secondcondition";
                transparentchub.firefungihold = transparentchub.transparentchubrand;
            }
        }


    }


    void killerbeegravUpdate() {

        for (GameObject killerbeegrav : lm.killerbeegravgameObjects) {
            if (killerbeegrav.initialcondition == true) {
                killerbeegrav.currentxWorld = killerbeegrav.getWorldLocation().x - lm.BeginX;

                killerbeegrav.currentyWorld = killerbeegrav.getWorldLocation().y - lm.BeginY;

                killerbeegrav.initialcondition = false;
            } else {

                killerbeegrav.updateEnemy(fps * killerbeegrav.speed, 0, 0, 0, 0);


            }


        }


    }


    void waterdropUpdate() {


        for (GameObject waterdrop : lm.waterdropgameObjects) {


            if (waterdrop.condition.matches("deadcondition")) {

                waterdrop.condition = "firstcondition";


                lm.waterdropgameObjects.get(lm.waterdropgameObjects.indexOf(waterdrop)).setWorldLocation(
                        lm.BeginX + lm.arraylistofwaterdropposition[lm.waterdropgameObjects.indexOf(waterdrop) * 2] - (waterdrop.getBitmapWidth() / 2),
                        lm.BeginY + lm.arraylistofwaterdropposition[(lm.waterdropgameObjects.indexOf(waterdrop) * 2) + 1] - waterdrop.getBitmapHeight() / 2);

                waterdrop.currentxWorld = waterdrop.getWorldLocation().x - lm.BeginX;

                waterdrop.currentyWorld = waterdrop.getWorldLocation().y - lm.BeginY;

                waterdrop.resetxVelocity();
                waterdrop.resetyVelocity();

            }


            if (waterdrop.condition.matches("firstcondition")) {


                if (waterdrop.oldTime == 0) {
                    waterdrop.oldTime = System.nanoTime();
                }
                if (TimeUnit.SECONDS.convert(System.nanoTime() - waterdrop.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    waterdrop.condition = "secondcondition";

                    if (waterdrop.oldTime != 0) {
                        waterdrop.oldTime = 0;
                    }
                    waterdrop.nextxPosition = 0;
                    waterdrop.nextyPosition = 0;


                }
            }

            if (waterdrop.initialcondition == true && waterdrop.condition.matches("firstcondition")) {

                waterdrop.currentxWorld = waterdrop.getWorldLocation().x - lm.BeginX;

                waterdrop.currentyWorld = waterdrop.getWorldLocation().y - lm.BeginY;


                waterdrop.initialcondition = false;

            }


            if (waterdrop.condition.matches("secondcondition")) {
                if (waterdrop.nextxPosition != 0 && waterdrop.nextyPosition != 0) {
                    waterdrop.updateEnemy(fps * waterdrop.speed, waterdrop.nextxPosition, waterdrop.nextyPosition,
                            waterdrop.getWorldLocation().x - lm.BeginX,
                            waterdrop.getWorldLocation().y - lm.BeginY);


                    waterdrop.currentxWorld = waterdrop.getWorldLocation().x - lm.BeginX
                            + waterdrop.getxVelocity();

                    waterdrop.currentyWorld = waterdrop.getWorldLocation().y - lm.BeginY
                            + waterdrop.getyVelocity();


                    if (waterdrop.getxVelocity() == 0 && waterdrop.getyVelocity() == 0) {
                        waterdrop.currentxWorld = waterdrop.nextxPosition;
                        waterdrop.currentyWorld = waterdrop.nextyPosition;


                        waterdrop.setWorldLocation(lm.BeginX + waterdrop.currentxWorld,
                                lm.BeginY + waterdrop.currentyWorld);


                        waterdrop.condition = "thirdcondition";


                    }
                } else if (waterdrop.nextxPosition == 0 && waterdrop.nextyPosition == 0) {

                    Integer[] waterdroparr = preciserandom(lm.arraylistofwaterdropdestination[lm.waterdropgameObjects.indexOf(waterdrop)],
                            true);


                    for (int q = 0; q < lm.arraylistofwaterdropdestination[lm.waterdropgameObjects.indexOf(waterdrop)].length; q++) {

                        if (lm.arraylistofwaterdropdestination[lm.waterdropgameObjects.indexOf(waterdrop)][q] ==
                                waterdroparr[0]) {
                            waterdrop.waterdroprand = q;
                            break;
                        }


                    }


                    waterdrop.nextxPosition = lm.arraylistofwaterdropdestination[lm.waterdropgameObjects.indexOf(waterdrop)][waterdrop.waterdroprand]
                            - (int) (waterdrop.getBitmapWidth() / 2);
                    waterdrop.nextyPosition = lm.arraylistofwaterdropdestination[lm.waterdropgameObjects.indexOf(waterdrop)][waterdrop.waterdroprand + 1]
                            - (int) (waterdrop.getBitmapHeight() / 2);


                }


            }

            if (waterdrop.condition.matches("thirdcondition")) {

                if (waterdrop.oldTime == 0) {
                    waterdrop.oldTime = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - waterdrop.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    waterdrop.condition = "firstcondition";


                    lm.waterdropgameObjects.get(lm.waterdropgameObjects.indexOf(waterdrop)).setWorldLocation(
                            lm.BeginX + lm.arraylistofwaterdropposition[lm.waterdropgameObjects.indexOf(waterdrop) * 2] - (waterdrop.getBitmapWidth() / 2),
                            lm.BeginY + lm.arraylistofwaterdropposition[(lm.waterdropgameObjects.indexOf(waterdrop) * 2) + 1] - waterdrop.getBitmapHeight() / 2);

                    waterdrop.currentxWorld = waterdrop.getWorldLocation().x - lm.BeginX;

                    waterdrop.currentyWorld = waterdrop.getWorldLocation().y - lm.BeginY;


                    if (waterdrop.oldTime != 0) {
                        waterdrop.oldTime = 0;
                    }


                }


            }


        }
    }


    void transparentchubUpdate() {


        for (GameObject transparentchub : lm.transparentchubgameObjects) {


            if (transparentchub.initialcondition == true) {
                transparentchub.currentxWorld = transparentchub.getWorldLocation().x - lm.BeginX;

                transparentchub.currentyWorld = transparentchub.getWorldLocation().y - lm.BeginY;


                transparentchub.initialcondition = false;
            } else {


                if (transparentchub.nextxPosition != 0 && transparentchub.nextyPosition != 0) {


                    transparentchub.updateEnemy(fps * transparentchub.speed, transparentchub.nextxPosition,
                            transparentchub.nextyPosition,
                            transparentchub.getWorldLocation().x - lm.BeginX,
                            transparentchub.getWorldLocation().y - lm.BeginY);

                    transparentchub.currentxWorld = transparentchub.getWorldLocation().x - lm.BeginX
                            + transparentchub.getxVelocity() + transparentchub.getSavedxvelocity();

                    transparentchub.currentyWorld = transparentchub.getWorldLocation().y - lm.BeginY
                            + transparentchub.getyVelocity() + transparentchub.getSavedyvelocity();


                    if (!transparentchub.condition.matches("secondcondition")) {


                        int firefunginumberindex = 60;

                        for (int j = 0; j < lm.bgLandscape.firefunginumber.length; j++) {
                            if (lm.bgLandscape.firefunginumber[j] == lm.bgLandscape.funginumber[transparentchub.transparentchubrand / 2]) {
                                firefunginumberindex = j;
                                break;
                            }
                        }

                        if (firefunginumberindex != 60) {


                            if (transparentchub.currentxWorld < lm.bgLandscape.fungiArray[transparentchub.transparentchubrand]) {
                                if (transparentchub.currentxWorld + transparentchub.getBitmapWidth() >=
                                        lm.bgLandscape.fungiArray[transparentchub.transparentchubrand]) {

                                    if (transparentchub.currentyWorld < lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                        if (transparentchub.currentyWorld + transparentchub.getBitmapHeight() >=
                                                lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                            setFireFungihasChanged(transparentchub);
                                        }
                                    }

                                    if (transparentchub.currentyWorld + transparentchub.getBitmapHeight() > lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {


                                        if (transparentchub.currentyWorld <=
                                                lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                            setFireFungihasChanged(transparentchub);
                                        }

                                    }

                                }
                            } else if (transparentchub.currentxWorld + transparentchub.getBitmapWidth() > lm.bgLandscape.fungiArray[transparentchub.transparentchubrand]) {

                                if (transparentchub.currentxWorld <=
                                        lm.bgLandscape.fungiArray[transparentchub.transparentchubrand]) {


                                    if (transparentchub.currentyWorld < lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                        if (transparentchub.currentyWorld + transparentchub.getBitmapHeight() >=
                                                lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                            setFireFungihasChanged(transparentchub);
                                        }
                                    }


                                    if (transparentchub.currentyWorld + transparentchub.getBitmapHeight() > lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                        if (transparentchub.currentyWorld <=
                                                lm.bgLandscape.fungiArray[(transparentchub.transparentchubrand) + 1]) {

                                            setFireFungihasChanged(transparentchub);
                                        }
                                    }
                                }


                            }
                        }
                    }


                    if (transparentchub.getxVelocity() == 0 && transparentchub.getyVelocity() == 0 &&
                            transparentchub.nextxPosition != 0) {

                        transparentchub.currentxWorld = transparentchub.nextxPosition;
                        transparentchub.currentyWorld = transparentchub.nextyPosition;

                        transparentchub.nextxPosition = 0;
                        transparentchub.nextyPosition = 0;

                        transparentchub.setWorldLocation(lm.BeginX + transparentchub.currentxWorld,
                                lm.BeginY + transparentchub.currentyWorld
                        );


                        transparentchub.resetSavedxvelocity();
                        transparentchub.resetSavedyvelocity();


                    }
                } else if (transparentchub.nextxPosition == 0 && transparentchub.nextyPosition == 0) {

                    if (transparentchub.currentxWorld == lm.arraylistoftransparentchubposition[transparentchub.transparentchubrand]) {
                        if (transparentchub.currentyWorld == lm.arraylistoftransparentchubposition[transparentchub.transparentchubrand + 1]) {


                            Integer[] transparentchubarr = preciserandom(lm.arraylistoftransparentchubposition, true);


                            for (int q = 0; q < lm.arraylistoftransparentchubposition.length; q++) {

                                if (lm.arraylistoftransparentchubposition[q] == transparentchubarr[lm.transparentchubgameObjects.indexOf(transparentchub)]) {
                                    transparentchub.transparentchubrand = q;
                                    break;
                                }


                            }


                            transparentchub.nextxPosition = lm.arraylistoftransparentchubposition[transparentchub.transparentchubrand];
                            transparentchub.nextyPosition = lm.arraylistoftransparentchubposition[transparentchub.transparentchubrand + 1];

                        }
                    }
                }
            }

        }
    }


    void barkbugUpdate() {

        for (GameObject barkbug : lm.barkbuggameObjects) {
            if (barkbug.initialcondition == true) {
                barkbug.currentxWorld = barkbug.getWorldLocation().x - lm.BeginX;

                barkbug.currentyWorld = barkbug.getWorldLocation().y - lm.BeginY;

                barkbug.initialcondition = false;
            } else {

                if (barkbug.oldTime == 0) {
                    barkbug.oldTime = System.nanoTime();
                }
                if (TimeUnit.SECONDS.convert(System.nanoTime() - barkbug.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    if (barkbug.getFacing().matches("RIGHT") && barkbug.condition.matches("firstcondition")) {

                        barkbug.condition = "secondcondition";
                    } else if (barkbug.getFacing().matches("RIGHT") && barkbug.condition.matches("secondcondition")) {


                        barkbug.condition = "firstcondition";

                    } else if (barkbug.getFacing().matches("LEFT") && barkbug.condition.matches("firstcondition")) {


                        barkbug.condition = "secondcondition";

                    } else if (barkbug.getFacing().matches("LEFT") && barkbug.condition.matches("secondcondition")) {


                        barkbug.condition = "firstcondition";


                    }

                    barkbug.oldTime = 0;

                }

                barkbug.updateEnemy(fps * (barkbug.speed * 2.5f),
                        lm.arraylistofbarkbuglocation[barkbug.barkbugIndex], 0, 0, 0);


            }


        }


    }


    void lavadropUpdate() {


        for (GameObject lavadrop : lm.lavadropgameObjects) {


            if (lavadrop.condition.matches("deadcondition")) {

                lavadrop.condition = "firstcondition";


                lm.lavadropgameObjects.get(lm.lavadropgameObjects.indexOf(lavadrop)).setWorldLocation(
                        lm.BeginX + lm.arraylistoflavadropposition[lm.lavadropgameObjects.indexOf(lavadrop) * 2] - (lavadrop.getBitmapWidth() / 2),
                        lm.BeginY + lm.arraylistoflavadropposition[(lm.lavadropgameObjects.indexOf(lavadrop) * 2) + 1] - lavadrop.getBitmapHeight() / 2);

                lavadrop.currentxWorld = lavadrop.getWorldLocation().x - lm.BeginX;

                lavadrop.currentyWorld = lavadrop.getWorldLocation().y - lm.BeginY;


                lavadrop.resetxVelocity();
                lavadrop.resetyVelocity();


            }


            if (lavadrop.condition.matches("firstcondition")) {


                if (lavadrop.oldTime == 0) {
                    lavadrop.oldTime = System.nanoTime();
                }
                if (TimeUnit.SECONDS.convert(System.nanoTime() - lavadrop.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    lavadrop.condition = "secondcondition";

                    if (lavadrop.oldTime != 0) {
                        lavadrop.oldTime = 0;
                    }
                    lavadrop.nextxPosition = 0;
                    lavadrop.nextyPosition = 0;


                }
            }

            if (lavadrop.initialcondition == true && lavadrop.condition.matches("firstcondition")) {

                lavadrop.currentxWorld = lavadrop.getWorldLocation().x - lm.BeginX;

                lavadrop.currentyWorld = lavadrop.getWorldLocation().y - lm.BeginY;


                lavadrop.initialcondition = false;

            }


            if (lavadrop.condition.matches("secondcondition")) {


                if (lavadrop.nextxPosition != 0 && lavadrop.nextyPosition != 0) {

                    lavadrop.updateEnemy(fps * lavadrop.speed, lavadrop.nextxPosition, lavadrop.nextyPosition,
                            lavadrop.getWorldLocation().x - lm.BeginX,
                            lavadrop.getWorldLocation().y - lm.BeginY);


                    lavadrop.currentxWorld = lavadrop.getWorldLocation().x - lm.BeginX
                            + lavadrop.getxVelocity();

                    lavadrop.currentyWorld = lavadrop.getWorldLocation().y - lm.BeginY
                            + lavadrop.getyVelocity();


                    if (lavadrop.getxVelocity() == 0 && lavadrop.getyVelocity() == 0) {
                        lavadrop.currentxWorld = lavadrop.nextxPosition;
                        lavadrop.currentyWorld = lavadrop.nextyPosition;

                        lavadrop.nextxPosition = 0;
                        lavadrop.nextyPosition = 0;

                        lavadrop.setWorldLocation(lm.BeginX + lavadrop.currentxWorld,
                                lm.BeginY + lavadrop.currentyWorld);


                        lavadrop.condition = "thirdcondition";


                    }
                } else if (lavadrop.nextxPosition == 0 && lavadrop.nextyPosition == 0) {

                    Integer[] lavadroparr = preciserandom(lm.arraylistoflavadropdestination[lm.lavadropgameObjects.indexOf(lavadrop)],
                            true);


                    for (int q = 0; q < lm.arraylistoflavadropdestination[lm.lavadropgameObjects.indexOf(lavadrop)].length; q++) {

                        if (lm.arraylistoflavadropdestination[lm.lavadropgameObjects.indexOf(lavadrop)][q].equals(lavadroparr[0])) {

                            lavadrop.lavadroprand = q;
                            break;
                        }


                    }


                    lavadrop.nextxPosition = lm.arraylistoflavadropdestination[lm.lavadropgameObjects.indexOf(lavadrop)][lavadrop.lavadroprand]
                            - (int) (lavadrop.getBitmapWidth() / 2);
                    lavadrop.nextyPosition = lm.arraylistoflavadropdestination[lm.lavadropgameObjects.indexOf(lavadrop)][lavadrop.lavadroprand + 1]
                            - (int) (lavadrop.getBitmapHeight() / 2);


                }

            }

            if (lavadrop.condition.matches("thirdcondition")) {

                if (lavadrop.oldTime == 0) {
                    lavadrop.oldTime = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - lavadrop.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                    lavadrop.condition = "firstcondition";


                    lm.lavadropgameObjects.get(lm.lavadropgameObjects.indexOf(lavadrop)).setWorldLocation(
                            lm.BeginX + lm.arraylistoflavadropposition[lm.lavadropgameObjects.indexOf(lavadrop) * 2] - (lavadrop.getBitmapWidth() / 2),
                            lm.BeginY + lm.arraylistoflavadropposition[(lm.lavadropgameObjects.indexOf(lavadrop) * 2) + 1] - lavadrop.getBitmapHeight() / 2);

                    lavadrop.currentxWorld = lavadrop.getWorldLocation().x - lm.BeginX;

                    lavadrop.currentyWorld = lavadrop.getWorldLocation().y - lm.BeginY;


                    if (lavadrop.oldTime != 0) {
                        lavadrop.oldTime = 0;
                    }


                }


            }


        }
    }


    void redbubbleUpdate() {

        for (GameObject redbubble : lm.redbubblegameObjects) {
            if (redbubble.initialcondition == true) {
                redbubble.currentxWorld = redbubble.getWorldLocation().x - lm.BeginX;

                redbubble.currentyWorld = redbubble.getWorldLocation().y - lm.BeginY;

                redbubble.initialcondition = false;
            } else {

                if(redbubble.oldTimesecond == 0){
                    redbubble.oldTimesecond = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - redbubble.oldTimesecond, TimeUnit.NANOSECONDS) >= 120) {
                        if(redbubble.valuehold != 0){

                            frogFungiPlayerState.delFood(redbubble.valuehold);
                            redbubble.valuehold = 0;
                        }

                    redbubble.oldTimesecond = 0;

                }


                    if (redbubble.condition.matches("firstcondition")) {

                    if (redbubble.oldTime == 0) {
                        redbubble.oldTime = System.nanoTime();
                    }

                    if (TimeUnit.SECONDS.convert(System.nanoTime() - redbubble.oldTime, TimeUnit.NANOSECONDS) >= 5) {

                        redbubble.condition = "secondcondition";

                        redbubble.oldTime = 0;
                    }



                } else if (redbubble.condition.matches("secondcondition")) {

                    if (redbubble.nextyPosition == 0) {
                        redbubble.nextyPosition = (int) ((redbubble.getWorldLocation().y - lm.BeginY) - (2 * redbubble.getBitmapHeight()));
                    }
                } else if (redbubble.condition.matches("thirdcondition")) {

                    if (redbubble.nextyPosition == 0) {
                        redbubble.nextyPosition = (int) ((redbubble.getWorldLocation().y - lm.BeginY) - (4 * redbubble.getBitmapHeight()));
                    }
                } else if (redbubble.condition.matches("deadcondition")) {

                    if (redbubble.oldTime == 0) {
                        redbubble.oldTime = System.nanoTime();
                    }

                    if (TimeUnit.SECONDS.convert(System.nanoTime() - redbubble.oldTime, TimeUnit.NANOSECONDS) >= 1) {


                        redbubble.condition = "firstcondition";

                        redbubble.oldTime = 0;
                    }

                        redbubble.resetyVelocity();


                        redbubble.currentxWorld = redbubble.getWorldLocation().x - lm.BeginX;

                        redbubble.currentyWorld = redbubble.getWorldLocation().y - lm.BeginY;


                    }

                if (redbubble.condition.matches("secondcondition") || redbubble.condition.matches("thirdcondition")) {


                    redbubble.updateEnemy(fps * redbubble.speed,
                            redbubble.nextyPosition,
                            redbubble.currentyWorld,
                            0, 0);


                    redbubble.currentyWorld = redbubble.getWorldLocation().y - lm.BeginY
                            + redbubble.getyVelocity();


                }

            }
        }
    }


    void lavafurLevelThreeLavaUpdate() {

        for (GameObject lavafur : lm.lavafurgameObjects) {


            if (lavafur.initialcondition == true) {
                lavafur.currentxWorld = lavafur.getWorldLocation().x - lm.BeginX;

                lavafur.currentyWorld = lavafur.getWorldLocation().y - lm.BeginY;


                lavafur.initialcondition = false;
            } else {

                if (lavafur.condition.matches("firstcondition")) {


                    if (lavafur.nextxPosition != 0 && lavafur.nextyPosition != 0) {
                        lavafur.updateEnemy(fps * lavafur.speed, lavafur.nextxPosition, lavafur.nextyPosition,
                                lavafur.getWorldLocation().x - lm.BeginX,
                                lavafur.getWorldLocation().y - lm.BeginY);

                        lavafur.currentxWorld = lavafur.getWorldLocation().x - lm.BeginX
                                + lavafur.getSavedxvelocity() + lavafur.getxVelocity();

                        lavafur.currentyWorld = lavafur.getWorldLocation().y - lm.BeginY
                                + lavafur.getSavedyvelocity() + lavafur.getyVelocity();


                        if (lavafur.getxVelocity() == 0 && lavafur.getyVelocity() == 0 &&
                                lavafur.nextxPosition != 0) {
                            lavafur.currentxWorld = lavafur.nextxPosition;
                            lavafur.currentyWorld = lavafur.nextyPosition;

                            lavafur.setWorldLocation(lm.BeginX + lavafur.currentxWorld,
                                    lm.BeginY + lavafur.currentyWorld);


                            lavafur.nextxPosition = 0;
                            lavafur.nextyPosition = 0;

                            lavafur.resetSavedxvelocity();
                            lavafur.resetSavedyvelocity();


                        }
                    } else if (lavafur.nextxPosition == 0 && lavafur.nextyPosition == 0) {


                        if (lavafur.currentxWorld == lm.arraylistoflavafurposition[lavafur.lavafurrand]) {
                            if (lavafur.currentyWorld == lm.arraylistoflavafurposition[lavafur.lavafurrand + 1]) {

                                Integer[] lavafurarr = preciserandom(lm.arraylistoflavafurposition, true);


                                for (int q = 0; q < lm.arraylistoflavafurposition.length; q++) {

                                    if (lm.arraylistoflavafurposition[q] == lavafurarr[lm.lavafurgameObjects.indexOf(lavafur)]) {
                                        lavafur.lavafurrand = q;
                                        break;
                                    }


                                }


                                lavafur.nextxPosition = lm.arraylistoflavafurposition[lavafur.lavafurrand];
                                lavafur.nextyPosition = lm.arraylistoflavafurposition[lavafur.lavafurrand + 1];


                            }
                        }
                    }

                    checklavafurcondition(lavafur);


                }
            }
        }

    }




    void checklavafurcondition(GameObject lavafur){



    if(Math.sqrt((((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth()/2) - (lavafur.currentxWorld + lavafur.getBitmapWidth()/2)) *
            ((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth()/2) - (lavafur.currentxWorld + lavafur.getBitmapWidth()/2))) +
    (((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight()/2) - (lavafur.currentyWorld + lavafur.getBitmapHeight()/2)) *
            ((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight()/2) - (lavafur.currentyWorld + lavafur.getBitmapHeight()/2)))) <
            (lavafur.getBitmapWidth() * (4 / 2) + lm.frogFungiPlayer.getBitmapWidth()/2)) {


            lavafur.condition = "secondcondition";



    }
}



    void gravitycloudLevelThreeLavaUpdate() {

        for (GameObject gravitycloud : lm.gravitycloudgameObjects) {


            if (gravitycloud.initialcondition == true) {
                gravitycloud.currentxWorld = gravitycloud.getWorldLocation().x - lm.BeginX;

                gravitycloud.currentyWorld = gravitycloud.getWorldLocation().y - lm.BeginY;


                gravitycloud.initialcondition = false;
            } else {

                if (gravitycloud.nextxPosition != 0 && gravitycloud.nextyPosition != 0) {

                    gravitycloud.updateEnemy(fps * gravitycloud.speed, gravitycloud.nextxPosition, gravitycloud.nextyPosition,
                            gravitycloud.getWorldLocation().x - lm.BeginX,
                            gravitycloud.getWorldLocation().y - lm.BeginY);

                    gravitycloud.currentxWorld = gravitycloud.getWorldLocation().x - lm.BeginX
                            + gravitycloud.getxVelocity();

                    gravitycloud.currentyWorld = gravitycloud.getWorldLocation().y - lm.BeginY
                            + gravitycloud.getyVelocity();


                    if (gravitycloud.getxVelocity() != 0 && gravitycloud.oldTime != 0) {
                        gravitycloud.oldTime = 0;
                    }

                    if (gravitycloud.getxVelocity() == 0 && gravitycloud.getyVelocity() == 0) {
                        gravitycloud.currentxWorld = gravitycloud.nextxPosition;
                        gravitycloud.currentyWorld = gravitycloud.nextyPosition;

                        gravitycloud.nextxPosition = 0;
                        gravitycloud.nextyPosition = 0;

                        gravitycloud.setWorldLocation(lm.BeginX + gravitycloud.currentxWorld,
                                lm.BeginY + gravitycloud.currentyWorld);

                    }
                } else {
                    if (gravitycloud.oldTime == 0) {
                        gravitycloud.oldTime = System.nanoTime();
                    }

                    if (TimeUnit.SECONDS.convert(System.nanoTime() - gravitycloud.oldTime, TimeUnit.NANOSECONDS) >= 1) {


                        if (gravitycloud.currentxWorld == lm.arraylistoflavabugposition[gravitycloud.gravitycloudrand]) {
                            if (gravitycloud.currentyWorld == lm.arraylistoflavabugposition[gravitycloud.gravitycloudrand + 1]
                                    + (int) (lm.bgLandscape.getbackgroundyResolution() * 2)) {


                                Integer[] fungiarr = preciserandom(lm.arraylistoflavabugposition, true);


                                for (int q = 0; q < lm.arraylistoflavabugposition.length; q++) {

                                    if (lm.arraylistoflavabugposition[q].equals(fungiarr[lm.gravitycloudgameObjects.indexOf(gravitycloud)])) {
                                        gravitycloud.gravitycloudrand = q;
                                        break;
                                    }


                                }


                                gravitycloud.nextxPosition = lm.arraylistoflavabugposition[gravitycloud.gravitycloudrand];
                                gravitycloud.nextyPosition = lm.arraylistoflavabugposition[gravitycloud.gravitycloudrand + 1] + (int) (lm.bgLandscape.getbackgroundyResolution() * 2);


                                gravitycloud.oldTime = 0;


                            }
                        }
                    }
                }
            }

            checkgravitycloudcondition(gravitycloud);
        }
    }


    void checkgravitycloudcondition(GameObject gravitycloud){



            if (gravitycloud.getrectHitboxcircle().radiusxcenter != 0 && gravitycloud.getrectHitboxcircle().radiusycenter != 0) {

                if (((float) (Math.sqrt(((lm.frogFungiPlayer.getrectHitboxcircle().radiusxcenter - gravitycloud.getrectHitboxcircle().radiusxcenter) *
                        (lm.frogFungiPlayer.getrectHitboxcircle().radiusxcenter - gravitycloud.getrectHitboxcircle().radiusxcenter)) +
                        ((lm.frogFungiPlayer.getrectHitboxcircle().radiusycenter - gravitycloud.getrectHitboxcircle().radiusycenter) *
                                (lm.frogFungiPlayer.getrectHitboxcircle().radiusycenter - gravitycloud.getrectHitboxcircle().radiusycenter)))) >
                        gravitycloud.getBitmapWidth() / 2) && gravitycloud.condition.matches("secondcondition")) {

                    checkdiedcondition();

                } else if (gravitycloud.condition.matches("firstcondition")) {

                    if ((float) (Math.sqrt(((lm.frogFungiPlayer.getrectHitboxcircle().radiusxcenter - gravitycloud.getrectHitboxcircle().radiusxcenter) *
                            (lm.frogFungiPlayer.getrectHitboxcircle().radiusxcenter - gravitycloud.getrectHitboxcircle().radiusxcenter)) +
                            ((lm.frogFungiPlayer.getrectHitboxcircle().radiusycenter - gravitycloud.getrectHitboxcircle().radiusycenter) *
                                    (lm.frogFungiPlayer.getrectHitboxcircle().radiusycenter - gravitycloud.getrectHitboxcircle().radiusycenter)))) <
                            gravitycloud.getBitmapWidth() / 2) {


                        gravitycloud.condition = "secondcondition";


                    }
                }
            }

    }



    void frogfungiDraw(Matrix matrix) {

        if (((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2) < lm.frogFungiPlayer.getWorldLocation().x) &&
                lm.frogFungiPlayer.changeFrogPosition == true) {

            if (lm.frogFungiPlayer.getFacing().matches("RIGHT")) {
                lm.frogFungiPlayer.setFacing("LEFT");

            }


            if ((lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()) < lm.frogFungiPlayer.getWorldLocation().y) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight()) - (lm.frogFungiPlayer.nextyPosition - lm.frogFungiPlayer.getBitmapHeight())),
                        (double) ((lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2) - (lm.frogFungiPlayer.nextxPosition - lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        lm.frogFungiPlayer.getBitmapWidth() / 2,

                        lm.frogFungiPlayer.getBitmapHeight() / 2
                );

                matrix.postTranslate((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())
                                - lm.bgLandscape.getyVelocity());


            } else if ((lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()) > lm.frogFungiPlayer.getWorldLocation().y) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.nextyPosition - lm.frogFungiPlayer.getBitmapHeight()) - (lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())),
                        (double) ((lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2) - (lm.frogFungiPlayer.nextxPosition - lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totalleftbottom = 0;

                if (lm.frogFungiPlayer.getxVelocity() == 0) {

                    totalleftbottom = (-45 - leftbottom) + stepleftbottom;
                    stepleftbottom = stepleftbottom + 5;


                    if (totalleftbottom < -90 || totalleftbottom > 0) {
                        totalleftbottom = -90;
                    }

                } else {


                    totalleftbottom = -45 - leftbottom;

                    if (totalleftbottom < -90 || totalleftbottom > 0) {
                        totalleftbottom = -90;
                    }

                }


                matrix.postRotate(totalleftbottom,
                        lm.frogFungiPlayer.getBitmapWidth() / 2,

                        lm.frogFungiPlayer.getBitmapHeight() / 2
                );

                matrix.postTranslate((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())
                                - lm.bgLandscape.getyVelocity());


            }


            canvas.drawBitmap(
                    lm.bitmapsArray[3],
                    matrix,
                    paint);
        } else if (((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2) > lm.frogFungiPlayer.getWorldLocation().x) &&
                lm.frogFungiPlayer.changeFrogPosition == true) {

            if (lm.frogFungiPlayer.getFacing().matches("LEFT")) {
                lm.frogFungiPlayer.setFacing("RIGHT");

            }


            if ((lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()) < lm.frogFungiPlayer.getWorldLocation().y) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight()) - (lm.frogFungiPlayer.nextyPosition - lm.frogFungiPlayer.getBitmapHeight())),
                        (double) -((lm.frogFungiPlayer.nextxPosition - lm.frogFungiPlayer.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        lm.frogFungiPlayer.getBitmapWidth() / 2,

                        lm.frogFungiPlayer.getBitmapHeight() / 2

                );

                matrix.postTranslate((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())
                                - lm.bgLandscape.getyVelocity()
                );

            } else if ((lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()) > lm.frogFungiPlayer.getWorldLocation().y) {

                float totalrightbottom = 0;


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.nextyPosition - lm.frogFungiPlayer.getBitmapHeight()) - (lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())),
                        (double) -((lm.frogFungiPlayer.nextxPosition - lm.frogFungiPlayer.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2))));


                if (lm.frogFungiPlayer.getxVelocity() == 0) {

                    totalrightbottom = (45 + 90 - (rightbottom - 90)) - steprightbottom;
                    steprightbottom = steprightbottom + 5;


                    if (totalrightbottom > 90 || totalrightbottom < 0) {
                        totalrightbottom = 90;
                    }

                } else {


                    totalrightbottom = (45 + 90) - (rightbottom - 90);

                    if (totalrightbottom > 90 || totalrightbottom < 0) {
                        totalrightbottom = 90;
                    }

                }


                matrix.postRotate(totalrightbottom
                        ,
                        lm.frogFungiPlayer.getBitmapWidth() / 2,

                        lm.frogFungiPlayer.getBitmapHeight() / 2
                );

                matrix.postTranslate((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())
                                - lm.bgLandscape.getyVelocity()
                );


            }


            canvas.drawBitmap(
                    lm.bitmapsArray[2],
                    matrix,
                    paint);


        } else if (((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2) == lm.frogFungiPlayer.getWorldLocation().x) &&
                lm.frogFungiPlayer.changeFrogPosition == false) {

            matrix.postTranslate((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.frogFungiPlayer.getBitmapWidth() / 2)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.frogFungiPlayer.getBitmapHeight())
                            - lm.bgLandscape.getyVelocity()
            );


            if (lm.frogFungiPlayer.getFacing().matches("LEFT")) {

                canvas.drawBitmap(
                        lm.bitmapsArray[1],
                        matrix,
                        paint);

            } else {


                canvas.drawBitmap(
                        lm.bitmapsArray[0],
                        matrix,
                        paint);

            }
        }


    }


    void fishleveloneDraw(GameObject fish, Matrix matrix) {


        if (fish.getFacing().matches("LEFT")) {


            matrix.postRotate(fish.steps,
                    fish.getBitmapWidth() / 2,

                    fish.getBitmapHeight() / 2
            );

            if (lm.BeginX + fish.currentxWorld > (fish.getWorldLocation().x - (fish.getWorldLocation().x - (lm.BeginX + fish.nextxPosition)) / 2)) {
                fish.steps = fish.steps - 0.2f;
            } else {
                fish.steps = fish.steps - 0.1f;
            }


            matrix.postTranslate((lm.BeginX + fish.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + fish.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(fish, matrix);




        } else if (fish.getFacing().matches("RIGHT")) {


            matrix.postRotate(fish.steps,
                    fish.getBitmapWidth() / 2,

                    fish.getBitmapHeight() / 2

            );


            if (lm.BeginX + fish.currentxWorld < fish.getWorldLocation().x + ((lm.BeginX + fish.nextxPosition) - fish.getWorldLocation().x) / 2) {
                fish.steps = fish.steps + 0.2f;
            } else {
                fish.steps = fish.steps + 0.1f;
            }


            matrix.postTranslate((lm.BeginX + fish.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + fish.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );

            drawBitmapToCanvas(fish, matrix);

        }


    }


    void foodpursuitfrogLevelOneOceanDraw(GameObject foodpursuitfrog, Matrix matrix) {

        if (foodpursuitfrog.currentxWorld <= lm.frogFungiPlayer.currentxWorld) {

            if (foodpursuitfrog.getFacing().matches("LEFT")) {
                foodpursuitfrog.setFacing("RIGHT");
            }


            if (lm.frogFungiPlayer.currentyWorld <= foodpursuitfrog.currentyWorld) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2) - (lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2)),
                        (double) -((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2) - (foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2


                );

            } else if (lm.frogFungiPlayer.currentyWorld > foodpursuitfrog.currentyWorld) {


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2) - (foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2)),
                        (double) -((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2) - (foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2))));

                float totalrightbottom = 45 + 90 - (rightbottom - 90);


                matrix.postRotate(totalrightbottom,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + foodpursuitfrog.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + foodpursuitfrog.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(foodpursuitfrog, matrix);

        } else if (foodpursuitfrog.currentxWorld > lm.frogFungiPlayer.currentxWorld) {

            if (foodpursuitfrog.getFacing().matches("RIGHT")) {
                foodpursuitfrog.setFacing("LEFT");

            }


            if (lm.frogFungiPlayer.currentyWorld <= foodpursuitfrog.currentyWorld) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2) - (lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2)),
                        (double) ((foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2

                );

            } else if (lm.frogFungiPlayer.currentyWorld > foodpursuitfrog.currentyWorld) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2) - (foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2)),
                        (double) ((foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totalleftbottom = -45 - leftbottom;


                matrix.postRotate(totalleftbottom,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + foodpursuitfrog.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + foodpursuitfrog.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(foodpursuitfrog, matrix);

        }


    }


    void sandladybugDraw(GameObject sandladybug, Matrix matrix) {

        if ((sandladybug.nextxPosition == 0) &&
                (sandladybug.nextyPosition == 0)) {

            sandladybug.setFacing("LEFT");

            matrix.postTranslate( lm.BeginX + sandladybug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + sandladybug.currentyWorld
                            - lm.bgLandscape.getyVelocity()
                    );

          drawBitmapToCanvas(sandladybug, matrix);

        } else {

            sandladybug.setFacing("RIGHT");

            matrix.postTranslate(  lm.BeginX + sandladybug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + sandladybug.currentyWorld
                            - lm.bgLandscape.getyVelocity()
                    );

            drawBitmapToCanvas(sandladybug, matrix);

        }


    }


    void bighorngravDraw(GameObject bighorngrav, Matrix matrix){


        matrix.postTranslate(lm.BeginX + bighorngrav.currentxWorld
                        - lm.bgLandscape.getxVelocity(),
                lm.BeginY + bighorngrav.currentyWorld
                        - lm.bgLandscape.getyVelocity());

        drawBitmapToCanvas(bighorngrav, matrix);

    }


    void bighorngravLevelTwoOceanDraw(GameObject bighorngrav, Matrix matrix){

        if(bighorngrav.condition.matches("firstcondition") || bighorngrav.condition.matches("thirdcondition")) {

            matrix.postTranslate(lm.BeginX + bighorngrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bighorngrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());
        }

        else if(bighorngrav.condition.matches("secondcondition")){

            matrix.postTranslate(lm.BeginX + bighorngrav.currentxWorld +
                            lm.bgLandscape.fungiArray[lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2]
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bighorngrav.currentyWorld +
                            lm.bgLandscape.fungiArray[(lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2) + 1]
                            - lm.bgLandscape.getyVelocity());


        }
        
            
        drawBitmapToCanvas(bighorngrav, matrix);

    }



    void guardianbeegravLevelTwoOceanDraw(GameObject guardianbeegrav, Matrix matrix) {

        matrix.postTranslate(lm.BeginX + guardianbeegrav.currentxWorld +
                        lm.bgLandscape.fungiArray[lm.bgLandscape.funginumber[5 * (lm.guardianbeegravgameObjects.indexOf(guardianbeegrav))] * 2]
                        - lm.bgLandscape.getxVelocity(),
                lm.BeginY + guardianbeegrav.currentyWorld +
                        lm.bgLandscape.fungiArray[(lm.bgLandscape.funginumber[5 * (lm.guardianbeegravgameObjects.indexOf(guardianbeegrav))] * 2) + 1]
                        - lm.bgLandscape.getyVelocity());


        if (guardianbeegrav.getFacing().matches("RIGHT")) {

            drawBitmapToCanvas(guardianbeegrav, matrix);

        }

        if (guardianbeegrav.getFacing().matches("LEFT")) {


            drawBitmapToCanvas(guardianbeegrav, matrix);

        }


    }


    void killerbeegravLevelThreeOceanDraw(GameObject killerbeegrav, Matrix matrix) {

        matrix.postTranslate(lm.BeginX + killerbeegrav.currentxWorld +
                        lm.bgLandscape.fungiArray[5 * (lm.killerbeegravgameObjects.indexOf(killerbeegrav)) * 2]
                        - lm.bgLandscape.getxVelocity(),
                lm.BeginY + killerbeegrav.currentyWorld +
                        lm.bgLandscape.fungiArray[(5 * (lm.killerbeegravgameObjects.indexOf(killerbeegrav)) * 2) + 1]
                        - lm.bgLandscape.getyVelocity());


        if (killerbeegrav.getFacing().matches("RIGHT")) {

            drawBitmapToCanvas(killerbeegrav, matrix);


        }

        if (killerbeegrav.getFacing().matches("LEFT")) {

            drawBitmapToCanvas(killerbeegrav, matrix);


        }


    }


    void suckerbeegravLevelThreeOceanDraw(GameObject suckerbeegrav, Matrix matrix) {

        if (suckerbeegrav.currentxWorld <= suckerbeegrav.nextxPosition) {

            if (suckerbeegrav.getFacing().matches("LEFT")) {
                suckerbeegrav.setFacing("RIGHT");
            }

            
            if (suckerbeegrav.nextyPosition <= suckerbeegrav.currentyWorld) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((suckerbeegrav.currentyWorld) - (suckerbeegrav.nextyPosition)),
                        (double) -((suckerbeegrav.nextxPosition) - (suckerbeegrav.currentxWorld))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2


                );

            } else if (suckerbeegrav.nextyPosition > suckerbeegrav.currentyWorld) {


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((suckerbeegrav.nextyPosition) - (suckerbeegrav.currentyWorld)),
                        (double) -((suckerbeegrav.nextxPosition) - (suckerbeegrav.currentxWorld))));

                float totalrightbottom = 45 + 90 - (rightbottom - 90);


                matrix.postRotate(totalrightbottom,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + suckerbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + suckerbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeOcean(suckerbeegrav.getType())],
                    matrix,
                    paint);


        } else if (suckerbeegrav.currentxWorld > suckerbeegrav.nextxPosition) {

            if (suckerbeegrav.getFacing().matches("RIGHT")) {
                suckerbeegrav.setFacing("LEFT");

            }


            if (suckerbeegrav.nextyPosition <= suckerbeegrav.currentyWorld) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((suckerbeegrav.currentyWorld) - (suckerbeegrav.nextyPosition)),
                        (double) ((suckerbeegrav.currentxWorld) - (suckerbeegrav.nextxPosition))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            } else if (suckerbeegrav.nextyPosition > suckerbeegrav.currentyWorld) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((suckerbeegrav.nextyPosition) - (suckerbeegrav.currentyWorld)),
                        (double) ((suckerbeegrav.currentxWorld) - (suckerbeegrav.nextxPosition))));

                float totalleftbottom = -45 - leftbottom;


                matrix.postRotate(totalleftbottom,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + suckerbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + suckerbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeOcean(suckerbeegrav.getType()) + 1],
                    matrix,
                    paint);


        }


    }


    void suckerbeegravLevelFourOceanDraw(GameObject suckerbeegrav, Matrix matrix) {

        if (suckerbeegrav.currentxWorld <= suckerbeegrav.nextxPosition) {

            if (suckerbeegrav.getFacing().matches("LEFT")) {
                suckerbeegrav.setFacing("RIGHT");
            }


            if (suckerbeegrav.nextyPosition <= suckerbeegrav.currentyWorld) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((suckerbeegrav.currentyWorld) - (suckerbeegrav.nextyPosition)),
                        (double) -((suckerbeegrav.nextxPosition) - (suckerbeegrav.currentxWorld))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2


                );

            } else if (suckerbeegrav.nextyPosition > suckerbeegrav.currentyWorld) {


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((suckerbeegrav.nextyPosition) - (suckerbeegrav.currentyWorld)),
                        (double) -((suckerbeegrav.nextxPosition) - (suckerbeegrav.currentxWorld))));

                float totalrightbottom = 45 + 90 - (rightbottom - 90);


                matrix.postRotate(totalrightbottom,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + suckerbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + suckerbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(suckerbeegrav.getType())],
                    matrix,
                    paint);


        } else if (suckerbeegrav.currentxWorld > suckerbeegrav.nextxPosition) {

            if (suckerbeegrav.getFacing().matches("RIGHT")) {
                suckerbeegrav.setFacing("LEFT");

            }


            if (suckerbeegrav.nextyPosition <= suckerbeegrav.currentyWorld) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((suckerbeegrav.currentyWorld) - (suckerbeegrav.nextyPosition)),
                        (double) ((suckerbeegrav.currentxWorld) - (suckerbeegrav.nextxPosition))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            } else if (suckerbeegrav.nextyPosition > suckerbeegrav.currentyWorld) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((suckerbeegrav.nextyPosition) - (suckerbeegrav.currentyWorld)),
                        (double) ((suckerbeegrav.currentxWorld) - (suckerbeegrav.nextxPosition))));

                float totalleftbottom = -45 - leftbottom;


                matrix.postRotate(totalleftbottom,
                        suckerbeegrav.getBitmapWidth() / 2,

                        suckerbeegrav.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + suckerbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + suckerbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(suckerbeegrav.getType()) + 1],
                    matrix,
                    paint);


        }

    }



    void waterdropLevelFourOceanDraw(GameObject waterdrop, Matrix matrix) {


        if (waterdrop.getFacing().matches("LEFT") && waterdrop.condition.matches("thirdcondition")) {

            matrix.postTranslate((lm.BeginX + waterdrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + waterdrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(waterdrop.getType()) + 3],
                    matrix,
                    paint);

        }


        if (waterdrop.getFacing().matches("RIGHT") && waterdrop.condition.matches("thirdcondition")) {

            matrix.postTranslate((lm.BeginX + waterdrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + waterdrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(waterdrop.getType()) + 2],
                    matrix,
                    paint);

        }


        if (waterdrop.getFacing().matches("RIGHT") && waterdrop.condition.matches("firstcondition")) {

            matrix.postTranslate((lm.BeginX + waterdrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + waterdrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(waterdrop.getType())],
                    matrix,
                    paint);


        }


        if (waterdrop.getFacing().matches("LEFT") && waterdrop.condition.matches("secondcondition")) {


            matrix.postRotate(waterdrop.steps,
                    waterdrop.getBitmapWidth() / 2,

                    waterdrop.getBitmapHeight() / 2
            );


            if (lm.BeginX + waterdrop.currentxWorld > (waterdrop.getWorldLocation().x - (waterdrop.getWorldLocation().x - (lm.BeginX + waterdrop.nextxPosition)) / 2)) {
                waterdrop.steps = waterdrop.steps - 0.2f;
            } else {
                waterdrop.steps = waterdrop.steps - 0.1f;
            }

            matrix.postTranslate((lm.BeginX + waterdrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + waterdrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(waterdrop.getType()) + 1],
                    matrix,
                    paint);


        } else if (waterdrop.getFacing().matches("RIGHT") && waterdrop.condition.matches("secondcondition")) {

            matrix.postRotate(waterdrop.steps,
                    waterdrop.getBitmapWidth() / 2,

                    waterdrop.getBitmapHeight() / 2
            );


            if (lm.BeginX + waterdrop.currentxWorld < waterdrop.getWorldLocation().x + ((lm.BeginX + waterdrop.nextxPosition) - waterdrop.getWorldLocation().x) / 2) {
                waterdrop.steps = waterdrop.steps + 0.2f;
            } else {
                waterdrop.steps = waterdrop.steps + 0.1f;
            }


            matrix.postTranslate((lm.BeginX + waterdrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + waterdrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(waterdrop.getType()) + 1],
                    matrix,
                    paint);


        }

    }

    void satelliteghostspinderLevelThreeOceanDraw(Matrix matrix,
                                                  ArrayList<GameObject> satellite,
                                                  int counter, int looptimes){

        for(int x = 0; x < looptimes; x++) {

            if (!matrix.isIdentity()) {
                matrix.reset();
            }


            matrix.postTranslate(lm.BeginX + satellite.get(counter +
                    x).currentxWorld - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + satellite.get(counter +
                    x).currentyWorld - lm.bgLandscape.getyVelocity());


            if (satellite.get(counter + x).getFacing().matches("RIGHT")) {

                drawBitmapToCanvas(satellite.get(counter + x), matrix);

            }

            if (satellite.get(counter + x).getFacing().matches("LEFT")) {


                drawBitmapToCanvas(satellite.get(counter + x), matrix);

            }


        }

    }

    void satellitewithconditionghostspinderLevelThreeOceanDraw(Matrix matrix,
                                    ArrayList<GameObject> satellite,
                                                    int counter, int loopcount){

        for(int x = 0; x < loopcount; x++) {

            if (!matrix.isIdentity()) {
                matrix.reset();
            }

            matrix.postTranslate(lm.BeginX + satellite.get(counter + x).currentxWorld +

                            -lm.bgLandscape.getxVelocity(),
                    lm.BeginY + satellite.get(counter + x).currentyWorld +

                            -lm.bgLandscape.getyVelocity());



            if (satellite.get(counter + x).condition.matches("firstcondition")) {



                if (satellite.get(counter + x).getFacing().matches("LEFT")) {

                    drawBitmapToCanvas(satellite.get(counter + x), matrix);


                }


               else if (satellite.get(counter + x).getFacing().matches("RIGHT")) {

                    drawBitmapToCanvas(satellite.get(counter + x), matrix);


                }


            } else if (satellite.get(counter + x).condition.matches("secondcondition")) {


                if (satellite.get(counter + x).getFacing().matches("RIGHT")) {

                    drawBitmapToCanvas(satellite.get(counter + x), matrix);


                }

               else if (satellite.get(counter + x).getFacing().matches("LEFT")) {

                    drawBitmapToCanvas(satellite.get(counter + x), matrix);


                }

            } else if (satellite.get(counter + x).condition.matches("thirdcondition")) {

                if(frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelThreeOcean(satellite.get(counter + x).getType()) + 2],
                            matrix,
                            paint);
                }

             else if(frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(satellite.get(counter + x).getType()) + 2],
                            matrix,
                            paint);
                }


                else if(frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {

                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(satellite.get(counter + x).getType()) + 2],
                            matrix,
                            paint);
                }


                else if(frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {

                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(satellite.get(counter + x).getType()) + 2],
                            matrix,
                            paint);
                }



            }




        }
    }



    void fishleveltwoDraw(GameObject fish, Matrix matrix) {

        if (fish.getFacing().matches("LEFT")) {


            matrix.postRotate(fish.steps,
                    fish.getBitmapWidth() / 2,

                    fish.getBitmapHeight() / 2
            );


            if (lm.BeginX + fish.currentxWorld > (fish.getWorldLocation().x - (fish.getWorldLocation().x - (lm.BeginX + fish.nextxPosition)) / 2)) {
                fish.steps = fish.steps - 0.2f;
            } else {
                fish.steps = fish.steps - 0.1f;
            }

            matrix.postTranslate((lm.BeginX + fish.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + fish.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(fish, matrix);



        } else if (fish.getFacing().matches("RIGHT")) {

            matrix.postRotate(fish.steps,
                    fish.getBitmapWidth() / 2,

                    fish.getBitmapHeight() / 2
            );


            if (lm.BeginX + fish.currentxWorld < fish.getWorldLocation().x + ((lm.BeginX + fish.nextxPosition) - fish.getWorldLocation().x) / 2) {
                fish.steps = fish.steps + 0.2f;
            } else {
                fish.steps = fish.steps + 0.1f;
            }


            matrix.postTranslate((lm.BeginX + fish.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + fish.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(fish, matrix);

        }
    }

    void jumpingratlavaDraw(GameObject jumpingratlava, Matrix matrix) {

        if (jumpingratlava.getFacing().matches("LEFT") && jumpingratlava.getxVelocity() == 0) {

            matrix.postTranslate((lm.BeginX + jumpingratlava.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + jumpingratlava.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );

            drawBitmapToCanvas(jumpingratlava, matrix);

        }


        if (jumpingratlava.getFacing().matches("RIGHT") && jumpingratlava.getxVelocity() == 0) {

            matrix.postTranslate((lm.BeginX + jumpingratlava.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + jumpingratlava.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );



            drawBitmapToCanvas(jumpingratlava, matrix);


        }


        if (jumpingratlava.getFacing().matches("LEFT") && jumpingratlava.getxVelocity() != 0) {


            matrix.postRotate(jumpingratlava.steps,
                    jumpingratlava.getBitmapWidth() / 2,

                    jumpingratlava.getBitmapHeight() / 2
            );


            if (lm.BeginX + jumpingratlava.currentxWorld > (jumpingratlava.getWorldLocation().x - (jumpingratlava.getWorldLocation().x - (lm.BeginX + jumpingratlava.nextxPosition)) / 2)) {
                jumpingratlava.steps = jumpingratlava.steps - 0.2f;
            } else {
                jumpingratlava.steps = jumpingratlava.steps - 0.1f;
            }

            matrix.postTranslate((lm.BeginX + jumpingratlava.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + jumpingratlava.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            if(frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {

                canvas.drawBitmap(
                        lm.bitmapsArray[lm.getBitmapIndexLevelOneLava(jumpingratlava.getType()) + 3],
                        matrix,
                        paint);

            }

          else  if(frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {

                canvas.drawBitmap(
                        lm.bitmapsArray[lm.getBitmapIndexLevelTwoLava(jumpingratlava.getType()) + 3],
                        matrix,
                        paint);

            }

        } else if (jumpingratlava.getFacing().matches("RIGHT") && jumpingratlava.getxVelocity() != 0) {

            matrix.postRotate(jumpingratlava.steps,
                    jumpingratlava.getBitmapWidth() / 2,

                    jumpingratlava.getBitmapHeight() / 2
            );


            if (lm.BeginX + jumpingratlava.currentxWorld < jumpingratlava.getWorldLocation().x + ((lm.BeginX + jumpingratlava.nextxPosition) - jumpingratlava.getWorldLocation().x) / 2) {
                jumpingratlava.steps = jumpingratlava.steps + 0.2f;
            } else {
                jumpingratlava.steps = jumpingratlava.steps + 0.1f;
            }


            matrix.postTranslate((lm.BeginX + jumpingratlava.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + jumpingratlava.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );

            if(frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {

                canvas.drawBitmap(
                        lm.bitmapsArray[lm.getBitmapIndexLevelOneLava(jumpingratlava.getType()) + 2],
                        matrix,
                        paint);

            }

          else  if(frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {

                canvas.drawBitmap(
                        lm.bitmapsArray[lm.getBitmapIndexLevelTwoLava(jumpingratlava.getType()) + 2],
                        matrix,
                        paint);

            }
        }


    }



    void barkbugLevelThreeLavaDraw(GameObject barkbug, Matrix matrix) {

        matrix.postTranslate(lm.BeginX + barkbug.currentxWorld +
                        lm.bgLandscape.fungiArray[lm.arraylistofbarkbugposition[barkbug.barkbugIndex] * 2]
                        - lm.bgLandscape.getxVelocity(),
                lm.BeginY + barkbug.currentyWorld +
                        lm.bgLandscape.fungiArray[(lm.arraylistofbarkbugposition[barkbug.barkbugIndex] * 2) + 1]
                        - lm.bgLandscape.getyVelocity());


        if (barkbug.getFacing().matches("RIGHT") && barkbug.condition.matches("firstcondition")) {

            drawBitmapToCanvas(barkbug, matrix);

        }

        else if (barkbug.getFacing().matches("RIGHT") && barkbug.condition.matches("secondcondition")) {


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(barkbug.getType()) + 2],
                    matrix,
                    paint);


        }

            else if (barkbug.getFacing().matches("LEFT") && barkbug.condition.matches("firstcondition")) {


                drawBitmapToCanvas(barkbug, matrix);

            }

        else if (barkbug.getFacing().matches("LEFT") && barkbug.condition.matches("secondcondition")) {


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(barkbug.getType()) + 3],
                    matrix,
                    paint);
            }

        }


    void lavadropLevelThreeLavaDraw(GameObject lavadrop, Matrix matrix) {


        if (lavadrop.getFacing().matches("LEFT") && lavadrop.condition.matches("thirdcondition")) {

            matrix.postTranslate((lm.BeginX + lavadrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lavadrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavadrop.getType()) + 3],
                    matrix,
                    paint);

        }


        if (lavadrop.getFacing().matches("RIGHT") && lavadrop.condition.matches("thirdcondition")) {

            matrix.postTranslate((lm.BeginX + lavadrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lavadrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavadrop.getType()) + 2],
                    matrix,
                    paint);

        }


        if (lavadrop.getFacing().matches("RIGHT") && lavadrop.condition.matches("firstcondition")) {

            matrix.postTranslate((lm.BeginX + lavadrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lavadrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavadrop.getType())],
                    matrix,
                    paint);


        }


        if (lavadrop.getFacing().matches("LEFT") && lavadrop.condition.matches("secondcondition")) {


            matrix.postRotate(lavadrop.steps,
                    lavadrop.getBitmapWidth() / 2,

                    lavadrop.getBitmapHeight() / 2
            );


            if (lm.BeginX + lavadrop.currentxWorld > (lavadrop.getWorldLocation().x - (lavadrop.getWorldLocation().x - (lm.BeginX + lavadrop.nextxPosition)) / 2)) {
                lavadrop.steps = lavadrop.steps - 0.2f;
            } else {
                lavadrop.steps = lavadrop.steps - 0.1f;
            }

            matrix.postTranslate((lm.BeginX + lavadrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lavadrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavadrop.getType()) + 1],
                    matrix,
                    paint);


        } else if (lavadrop.getFacing().matches("RIGHT") && lavadrop.condition.matches("secondcondition")) {

            matrix.postRotate(lavadrop.steps,
                    lavadrop.getBitmapWidth() / 2,

                    lavadrop.getBitmapHeight() / 2
            );


            if (lm.BeginX + lavadrop.currentxWorld < lavadrop.getWorldLocation().x + ((lm.BeginX + lavadrop.nextxPosition) - lavadrop.getWorldLocation().x) / 2) {
                lavadrop.steps = lavadrop.steps + 0.2f;
            } else {
                lavadrop.steps = lavadrop.steps + 0.1f;
            }


            matrix.postTranslate((lm.BeginX + lavadrop.currentxWorld)
                            - lm.bgLandscape.getxVelocity(),
                    (lm.BeginY + lavadrop.currentyWorld)
                            - lm.bgLandscape.getyVelocity()
            );


            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavadrop.getType()) + 1],
                    matrix,
                    paint);


        }

    }
    
    
    void lavafurLevelThreeLavaDraw(GameObject lavafur, Matrix matrix){
        
        if(lavafur.condition.matches("firstcondition")){

            matrix.postTranslate(lm.BeginX + lavafur.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + lavafur.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(lavafur, matrix);

        }
        
        else if(lavafur.condition.matches("secondcondition")){

            if(((lavafur.circledistance + 1) * (lavafur.getBitmapWidth()/2)) >= (lavafur.getBitmapWidth()/2) * 8){
                lavafur.condition = "deadcondition";
            }
            else {
                lavafur.circledistance = lavafur.circledistance + 0.05f;


                matrix.postTranslate(lm.BeginX + lavafur.currentxWorld - (lavafur.getBitmapWidth()) - (lavafur.getBitmapWidth()/2)
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + lavafur.currentyWorld - (lavafur.getBitmapHeight()) - (lavafur.getBitmapHeight()/2)
                                - lm.bgLandscape.getyVelocity()
                );

                matrix.postScale((lavafur.circledistance + 1) / 4,
                        (lavafur.circledistance + 1) / 4,
                        lm.BeginX + lavafur.currentxWorld + (lavafur.getBitmapWidth()/2)
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + lavafur.currentyWorld + (lavafur.getBitmapHeight()/2)
                                - lm.bgLandscape.getyVelocity());


                if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {


                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(lavafur.getType()) + 2],
                            matrix,
                            paint);
                }

               else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {


                    canvas.drawBitmap(
                            lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(lavafur.getType()) + 2],
                            matrix,
                            paint);
                }
            }

        }
    }



    void redbubbleLevelFourLavaDraw(GameObject redbubble, Matrix matrix) {

        matrix.postTranslate(lm.BeginX + redbubble.currentxWorld
                        - lm.bgLandscape.getxVelocity(),
                lm.BeginY + redbubble.currentyWorld
                        - lm.bgLandscape.getyVelocity());


        if (redbubble.condition.matches("firstcondition")) {

            redbubble.setFacing("RIGHT");

            drawBitmapToCanvas(redbubble, matrix);

        }

        else if(redbubble.condition.matches("secondcondition")){
            redbubble.setFacing("LEFT");

            drawBitmapToCanvas(redbubble, matrix);

        }

        else if(redbubble.condition.matches("thirdcondition")){

            canvas.drawBitmap(
                    lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(redbubble.getType()) + 2],
                    matrix,
                    paint);
        }



        }










    void foodpursuitfrogLevelOneLavaDraw(GameObject foodpursuitfrog, Matrix matrix) {

        if (foodpursuitfrog.currentxWorld <= lm.frogFungiPlayer.currentxWorld) {

            if (foodpursuitfrog.getFacing().matches("LEFT")) {
                foodpursuitfrog.setFacing("RIGHT");
            }


            if (lm.frogFungiPlayer.currentyWorld <= foodpursuitfrog.currentyWorld) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2) - (lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2)),
                        (double) -((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2) - (foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2

                );

            } else if (lm.frogFungiPlayer.currentyWorld > foodpursuitfrog.currentyWorld) {


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2) - (foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2)),
                        (double) -((lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2) - (foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2))));

                float totalrightbottom = 45 + 90 - (rightbottom - 90);


                matrix.postRotate(totalrightbottom
                        ,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2
                );

            }


            matrix.postTranslate(lm.BeginX + foodpursuitfrog.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + foodpursuitfrog.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );



            drawBitmapToCanvas(foodpursuitfrog, matrix);


        } else if (foodpursuitfrog.currentxWorld > lm.frogFungiPlayer.currentxWorld) {

            if (foodpursuitfrog.getFacing().matches("RIGHT")) {
                foodpursuitfrog.setFacing("LEFT");

            }


            if (lm.frogFungiPlayer.currentyWorld <= foodpursuitfrog.currentyWorld) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2) - (lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2)),
                        (double) ((foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2
                );

            } else if (lm.frogFungiPlayer.currentyWorld > foodpursuitfrog.currentyWorld) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((lm.frogFungiPlayer.currentyWorld + lm.frogFungiPlayer.getBitmapHeight() / 2) - (foodpursuitfrog.currentyWorld + foodpursuitfrog.getBitmapHeight() / 2)),
                        (double) ((foodpursuitfrog.currentxWorld + foodpursuitfrog.getBitmapWidth() / 2) - (lm.frogFungiPlayer.currentxWorld + lm.frogFungiPlayer.getBitmapWidth() / 2))));

                float totalleftbottom = -45 - leftbottom;


                matrix.postRotate(totalleftbottom,
                        foodpursuitfrog.getBitmapWidth() / 2,

                        foodpursuitfrog.getBitmapHeight() / 2
                );

            }


            matrix.postTranslate(lm.BeginX + foodpursuitfrog.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + foodpursuitfrog.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(foodpursuitfrog, matrix);

        }


    }



    void transparentchubLevelTwoLavaDraw(GameObject transparentchub, Matrix matrix) {

        if (transparentchub.currentxWorld <= transparentchub.nextxPosition) {

            if (transparentchub.getFacing().matches("LEFT")) {
                transparentchub.setFacing("RIGHT");
            }


            if (transparentchub.nextyPosition <= transparentchub.currentyWorld) {


                float righttop = (float) Math.toDegrees(Math.atan2((double) -((transparentchub.currentyWorld) - (transparentchub.nextyPosition)),
                        (double) -((transparentchub.nextxPosition) - (transparentchub.currentxWorld))));

                float totalrighttop = -45 - (righttop + 90);


                matrix.postRotate(totalrighttop,
                        transparentchub.getBitmapWidth() / 2,

                        transparentchub.getBitmapHeight() / 2


                );

            } else if (transparentchub.nextyPosition > transparentchub.currentyWorld) {


                float rightbottom = (float) Math.toDegrees(Math.atan2((double) ((transparentchub.nextyPosition) - (transparentchub.currentyWorld)),
                        (double) -((transparentchub.nextxPosition) - (transparentchub.currentxWorld))));

                float totalrightbottom = 45 + 90 - (rightbottom - 90);


                matrix.postRotate(totalrightbottom,
                        transparentchub.getBitmapWidth() / 2,

                        transparentchub.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + transparentchub.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + transparentchub.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );


            drawBitmapToCanvas(transparentchub, matrix);


        } else if (transparentchub.currentxWorld > transparentchub.nextxPosition) {

            if (transparentchub.getFacing().matches("RIGHT")) {
                transparentchub.setFacing("LEFT");

            }


            if (transparentchub.nextyPosition <= transparentchub.currentyWorld) {


                float lefttop = (float) Math.toDegrees(Math.atan2((double) -((transparentchub.currentyWorld) - (transparentchub.nextyPosition)),
                        (double) ((transparentchub.currentxWorld) - (transparentchub.nextxPosition))));

                float totallefttop = 45 - (lefttop + 90);


                matrix.postRotate(totallefttop,
                        transparentchub.getBitmapWidth() / 2,

                        transparentchub.getBitmapHeight() / 2

                );

            } else if (transparentchub.nextyPosition > transparentchub.currentyWorld) {


                float leftbottom = (float) Math.toDegrees(Math.atan2((double) ((transparentchub.nextyPosition) - (transparentchub.currentyWorld)),
                        (double) ((transparentchub.currentxWorld) - (transparentchub.nextxPosition))));

                float totalleftbottom = -45 - leftbottom;


                matrix.postRotate(totalleftbottom,
                        transparentchub.getBitmapWidth() / 2,

                        transparentchub.getBitmapHeight() / 2

                );

            }

            matrix.postTranslate(lm.BeginX + transparentchub.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + transparentchub.currentyWorld
                            - lm.bgLandscape.getyVelocity()
            );



            drawBitmapToCanvas(transparentchub, matrix);

        }


    }



    void lastUpdate() {

        if (MainActivity.initialload == false && MainActivity.newLevelUp == false && UpdateFinish == true) {

            if (lm.frogFungiPlayer.getType() == 'r') {
                lm.frogFungiPlayer.setHitBoxPosition((lm.BeginX + lm.frogFungiPlayer.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution())
                                - lm.bgLandscape.getyVelocity());
            }


if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
             if (smalloceanfish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {


        if (smalloceanfish.getFacing().matches("RIGHT")) {
            smalloceanfish.setFacing("LEFT");
        } else {
            smalloceanfish.setFacing("RIGHT");
        }

            lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalloceanfish.getWorldLocation().x - lm.BeginX);
             lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalloceanfish.getWorldLocation().y - lm.BeginY);

                smalloceanfish.setWorldLocation(lm.BeginX + smalloceanfish.currentxWorld, lm.BeginY + smalloceanfish.currentyWorld);
                smalloceanfish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
             if (bigoceanfish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
                if (bigoceanfish.getFacing().matches("RIGHT")) {
                    bigoceanfish.setFacing("LEFT");
        }        else if (bigoceanfish.getFacing().matches("LEFT")) {
                    bigoceanfish.setFacing("RIGHT");
        }

              lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (bigoceanfish.getWorldLocation().x - lm.BeginX);
                lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (bigoceanfish.getWorldLocation().y - lm.BeginY);

                 bigoceanfish.setWorldLocation(lm.BeginX + bigoceanfish.currentxWorld, lm.BeginY + bigoceanfish.currentyWorld);

                bigoceanfish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;

        }



         beegravHitBox(deletearrayFood);


        smalloceanfishHitBox();


        bigoceanfishHitBox();

        if (lm.beegravgameObjects.isEmpty()) {

            bigbeegravHitBox(deletearrayFood);

            sandladybugHitBox(deletearrayFood);

        }


       bighorngravHitBox(deletearrayFood);


        oceanbugHitBox(deletearrayFood);




                            if (lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[26] &&
                            lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[27]) {

                                if (frogFungiPlayerState.getFood() < 50) {


                                        checkdiedcondition();

                                        }


        }


        }

     else  if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
        if (smalloceanfish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {


        if (smalloceanfish.getFacing().matches("RIGHT")) {
        smalloceanfish.setFacing("LEFT");
        } else {
        smalloceanfish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalloceanfish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalloceanfish.getWorldLocation().y - lm.BeginY);

        smalloceanfish.setWorldLocation(lm.BeginX + smalloceanfish.currentxWorld, lm.BeginY + smalloceanfish.currentyWorld);
        smalloceanfish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
        if (bigoceanfish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (bigoceanfish.getFacing().matches("RIGHT")) {
        bigoceanfish.setFacing("LEFT");
        } else if (bigoceanfish.getFacing().matches("LEFT")) {
        bigoceanfish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (bigoceanfish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (bigoceanfish.getWorldLocation().y - lm.BeginY);

        bigoceanfish.setWorldLocation(lm.BeginX + bigoceanfish.currentxWorld, lm.BeginY + bigoceanfish.currentyWorld);

        bigoceanfish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;

        }



            beegravHitBox(deletearrayFood);

            beegravsecondHitBox(deletearrayFood);

           guardianbeegravHitBox(deletearrayFood);

            smalloceanfishHitBox();


            bigoceanfishHitBox();




            bighorngravLevelTwoOceanHitBox(deletearrayFood);

            sandladybugHitBox(deletearrayFood);

            oceanbugLevelTwoOceanHitBox(deletearrayFood);



            if(lm.frogFungiPlayer.condition.matches("secondcondition") ||
                    lm.frogFungiPlayer.condition.matches("thirdcondition")) {

                bigbeegravHitBox(deletearrayFood);

                bigbeegravsecondHitBox(deletearrayFood);

                oceanbugsecondHitBox(deletearrayFood);


            }

            if(lm.frogFungiPlayer.condition.matches("thirdcondition")){

                beegravthirdHitBox(deletearrayFood);

                beegravfourthHitBox(deletearrayFood);


            }


                if (lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[30] &&
                            lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[31]) {

                        if (frogFungiPlayerState.getFood() < 150) {


                                 checkdiedcondition();

                                }


        }


        }


       else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();

            int finishcountersmallfish = 0;
                int finishcounterbigfish = 0;

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
        if (smalloceanfish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {


        if (smalloceanfish.getFacing().matches("RIGHT")) {
        smalloceanfish.setFacing("LEFT");
        } else {
        smalloceanfish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalloceanfish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalloceanfish.getWorldLocation().y - lm.BeginY);

        smalloceanfish.setWorldLocation(lm.BeginX + smalloceanfish.currentxWorld, lm.BeginY + smalloceanfish.currentyWorld);
        smalloceanfish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

                    for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
                            if (bigoceanfish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
                                if (bigoceanfish.getFacing().matches("RIGHT")) {
                                     bigoceanfish.setFacing("LEFT");
                                    } else if (bigoceanfish.getFacing().matches("LEFT")) {
                                         bigoceanfish.setFacing("RIGHT");
                                         }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (bigoceanfish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (bigoceanfish.getWorldLocation().y - lm.BeginY);

        bigoceanfish.setWorldLocation(lm.BeginX + bigoceanfish.currentxWorld, lm.BeginY + bigoceanfish.currentyWorld);

        bigoceanfish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;

        }


            beegravHitBox(deletearrayFood);

           killerbeegravHitBox(deletearrayFood);

            suckerbeegravHitBox(deletearrayFood);

            smalloceanfishHitBox();


            bigoceanfishHitBox();

            bigbeegravHitBox(deletearrayFood);

            sandladybugHitBox(deletearrayFood);



            if(lm.suckerbeegravgameObjects.size() < 5) {

                beegravsecondHitBox(deletearrayFood);
                
                
            }

            if(lm.suckerbeegravgameObjects.size() < 4) {
                bigbeegravsecondLevelThreeOceanHitBox(deletearrayFood);

                swirlwaterHitBox(deletearrayFood);

            }

            if(lm.suckerbeegravgameObjects.size() < 3) {
                beegravthirdHitBox(deletearrayFood);

                swirlwatersecondHitBox(deletearrayFood);
                
                stargravHitBox(deletearrayFood);

            }


            if(lm.suckerbeegravgameObjects.size() < 2) {
                swirlwaterthirdHitBox(deletearrayFood);
                
                stargravsecondHitBox(deletearrayFood);
                stargravthirdHitBox(deletearrayFood);
            }














            if (lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[32] &&
                        lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[33]) {

                     if (frogFungiPlayerState.getFood() < 350) {


                                checkdiedcondition();

                        }


        }


        }

       else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
        if (smalloceanfish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {


        if (smalloceanfish.getFacing().matches("RIGHT")) {
        smalloceanfish.setFacing("LEFT");
        } else {
        smalloceanfish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalloceanfish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalloceanfish.getWorldLocation().y - lm.BeginY);

        smalloceanfish.setWorldLocation(lm.BeginX + smalloceanfish.currentxWorld, lm.BeginY + smalloceanfish.currentyWorld);
        smalloceanfish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
        if (bigoceanfish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (bigoceanfish.getFacing().matches("RIGHT")) {
        bigoceanfish.setFacing("LEFT");
        } else if (bigoceanfish.getFacing().matches("LEFT")) {
        bigoceanfish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (bigoceanfish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (bigoceanfish.getWorldLocation().y - lm.BeginY);

        bigoceanfish.setWorldLocation(lm.BeginX + bigoceanfish.currentxWorld, lm.BeginY + bigoceanfish.currentyWorld);

        bigoceanfish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;

        }







    
            suckerbeegravHitBox(deletearrayFood);

            smalloceanfishHitBox();


            bigoceanfishHitBox();

            beegravsecondHitBox(deletearrayFood);
            beegravfourthHitBox(deletearrayFood);



            waterdropHitBox(deletearrayFood);


    
    
        if(lm.suckerbeegravgameObjects.size() < 5){
            beegravthirdHitBox(deletearrayFood);
            oceanbugfourthHitBox(deletearrayFood);
            swirlwaterHitBox(deletearrayFood);
            stargravHitBox(deletearrayFood);
              }

            if(lm.suckerbeegravgameObjects.size() < 4){
            oceanbugthirdHitBox(deletearrayFood);
            swirlwatersecondHitBox(deletearrayFood);
            stargravsecondHitBox(deletearrayFood);

            }


            if(lm.suckerbeegravgameObjects.size() < 3){

            oceanbugsecondHitBox(deletearrayFood);

                beegravLevelFourOceanHitBox(deletearrayFood);

            }

            if(lm.suckerbeegravgameObjects.size() < 2){
                oceanbugLevelTwoOceanHitBox(deletearrayFood);
                splashflyHitBox(deletearrayFood);

            }


                        if (lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[46] &&
                                lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[47]) {

                            if (frogFungiPlayerState.getFood() < 750) {


                                    checkdiedcondition();

        }


        }

            if(!fungihasChanged.isEmpty()) {

                for (int x = 0; x < fungihasChanged.size(); x++) {

                    int valuecount = 0;

                    if(x == 0){

                        valuecount = 100;
                    }

                    else {

                        valuecount = (x * x * 100);

                    }


                    int funginumberindex = 0;

                    for (int j = 0; j < lm.bgLandscape.funginumber.length; j++) {
                        if (lm.bgLandscape.funginumber[j] == lm.bgLandscape.fungispecialnumber[fungihasChanged.get(x)]) {
                            funginumberindex = j;
                        }
                    }


                    if (lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[funginumberindex * 2] &&
                            frogFungiPlayerState.getFood() < valuecount) {
                        checkdiedcondition();
                    }
                }
            }

        }


        else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
        if (smalllavafish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {
        if (smalllavafish.getFacing().matches("RIGHT")) {
        smalllavafish.setFacing("LEFT");
        } else {
        smalllavafish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalllavafish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalllavafish.getWorldLocation().y - lm.BeginY);

        smalllavafish.setWorldLocation(lm.BeginX + smalllavafish.currentxWorld, lm.BeginY + smalllavafish.currentyWorld);

        smalllavafish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject biglavafish : lm.biglavafishgameObjects) {
        if (biglavafish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (biglavafish.getFacing().matches("RIGHT")) {
        biglavafish.setFacing("LEFT");
        } else {
        biglavafish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (biglavafish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (biglavafish.getWorldLocation().y - lm.BeginY);

        biglavafish.setWorldLocation(lm.BeginX + biglavafish.currentxWorld, lm.BeginY + biglavafish.currentyWorld);

        biglavafish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;


        }

        smalllavafishHitBox();

            biglavafishHitBox();

            rockbeegravHitBox(deletearrayFood);

            dustrockbeegravlavaHitBox(deletearrayFood);


            if(lm.fungilavagameObjects.size() < 4) {

                rockbigbeegravHitBox(deletearrayFood);

                rockbeegravsecondHitBox(deletearrayFood);

            }

            if(lm.fungilavagameObjects.size() < 3) {

                rockbigbeegravsecondHitBox(deletearrayFood);

            }

            fungilavaHitBox(deletearrayFood);

            jumpingratlavaHitBox(deletearrayFood);


        }

        else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
        if (smalllavafish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {
        if (smalllavafish.getFacing().matches("RIGHT")) {
        smalllavafish.setFacing("LEFT");
        } else {
        smalllavafish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalllavafish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalllavafish.getWorldLocation().y - lm.BeginY);

        smalllavafish.setWorldLocation(lm.BeginX + smalllavafish.currentxWorld, lm.BeginY + smalllavafish.currentyWorld);

        smalllavafish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject biglavafish : lm.biglavafishgameObjects) {
        if (biglavafish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (biglavafish.getFacing().matches("RIGHT")) {
        biglavafish.setFacing("LEFT");
        } else {
        biglavafish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (biglavafish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (biglavafish.getWorldLocation().y - lm.BeginY);

        biglavafish.setWorldLocation(lm.BeginX + biglavafish.currentxWorld, lm.BeginY + biglavafish.currentyWorld);

        biglavafish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;


        }


            smalllavafishHitBox();

            biglavafishHitBox();

            rockbeegravHitBox(deletearrayFood);

            rockbigbeegravHitBox(deletearrayFood);

            dustrockbeegravlavaHitBox(deletearrayFood);


            fungilavaHitBox(deletearrayFood);

            jumpingratlavaHitBox(deletearrayFood);

            transparentchubHitBox(deletearrayFood);


            if(lm.transparentchubgameObjects.size() < 4){

                rockbeegravsecondHitBox(deletearrayFood);
                rockbigbeegravsecondHitBox(deletearrayFood);
                dustrockbeegravlavasecondHitBox(deletearrayFood);

            }

            if(lm.transparentchubgameObjects.size() < 3){
                rockbeegravthirdHitBox(deletearrayFood);
                rockbigbeegravthirdHitBox(deletearrayFood);
                dustrockbeegravlavathirdHitBox(deletearrayFood);

            }

            if(lm.transparentchubgameObjects.size() < 2){
                rockbeegravfourthHitBox(deletearrayFood);
                rockbigbeegravfourthHitBox(deletearrayFood);
                dustrockbeegravlavafourthHitBox(deletearrayFood);


            }

            if(lm.fungilavagameObjects.size() < 3){
                bigdustrockbeegravlavaHitBox(deletearrayFood);
            }


        for(int x = 0; x < fungihasChanged.size(); x++){
        if(lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[fungihasChanged.get(x)] &&
        lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[fungihasChanged.get(x) + 1]){

        checkdiedcondition();

        }

        }

        }

        else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
        if (smalllavafish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {
        if (smalllavafish.getFacing().matches("RIGHT")) {
        smalllavafish.setFacing("LEFT");
        } else {
        smalllavafish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalllavafish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalllavafish.getWorldLocation().y - lm.BeginY);

        smalllavafish.setWorldLocation(lm.BeginX + smalllavafish.currentxWorld, lm.BeginY + smalllavafish.currentyWorld);

        smalllavafish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject biglavafish : lm.biglavafishgameObjects) {
        if (biglavafish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (biglavafish.getFacing().matches("RIGHT")) {
        biglavafish.setFacing("LEFT");
        } else {
        biglavafish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (biglavafish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (biglavafish.getWorldLocation().y - lm.BeginY);

        biglavafish.setWorldLocation(lm.BeginX + biglavafish.currentxWorld, lm.BeginY + biglavafish.currentyWorld);

        biglavafish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;


        }



            smalllavafishHitBox();

            biglavafishHitBox();

            rockbeegravHitBox(deletearrayFood);

            lavafurHitBox(deletearrayFood);
            
            gravitycloudHitBox(deletearrayFood);
            
            barkbugHitBox(deletearrayFood);

            lavadropHitBox(deletearrayFood);

            
            if(lm.gravitycloudgameObjects.size() < 5){
                rockbeegravsecondHitBox(deletearrayFood);

                rockbigbeegravHitBox(deletearrayFood);

                bigdustrockbeegravlavaHitBox(deletearrayFood);
            }

            if(lm.gravitycloudgameObjects.size() < 4){

                rockbeegravthirdHitBox(deletearrayFood);

                rockbigbeegravsecondHitBox(deletearrayFood);

                bigdustrockbeegravlavasecondHitBox(deletearrayFood);
                
            }

            if(lm.gravitycloudgameObjects.size() < 3){
                rockbeegravfourthHitBox(deletearrayFood);
                bigdustrockbeegravlavathirdHitBox(deletearrayFood);
                
            }


            if(lm.gravitycloudgameObjects.size() < 2){
                bigdustrockbeegravlavafourthHitBox(deletearrayFood);
            }
        }




        else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
        ArrayList<GameObject> deletearrayFood = new ArrayList<GameObject>();
        int finishcountersmallfish = 0;
        int finishcounterbigfish = 0;

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
        if (smalllavafish.currentxWorld == lm.firstpreyarrayfinish[finishcountersmallfish]) {
        if (smalllavafish.getFacing().matches("RIGHT")) {
        smalllavafish.setFacing("LEFT");
        } else {
        smalllavafish.setFacing("RIGHT");
        }

        lm.firstpreyarrayfinish[finishcountersmallfish] = (int) (smalllavafish.getWorldLocation().x - lm.BeginX);
        lm.firstpreyarrayfinish[finishcountersmallfish + 1] = (int) (smalllavafish.getWorldLocation().y - lm.BeginY);

        smalllavafish.setWorldLocation(lm.BeginX + smalllavafish.currentxWorld, lm.BeginY + smalllavafish.currentyWorld);

        smalllavafish.steps = 0;

        }

        finishcountersmallfish = finishcountersmallfish + 2;

        }

        for (GameObject biglavafish : lm.biglavafishgameObjects) {
        if (biglavafish.currentxWorld == lm.secondpreyarrayfinish[finishcounterbigfish]) {
        if (biglavafish.getFacing().matches("RIGHT")) {
        biglavafish.setFacing("LEFT");
        } else {
        biglavafish.setFacing("RIGHT");
        }

        lm.secondpreyarrayfinish[finishcounterbigfish] = (int) (biglavafish.getWorldLocation().x - lm.BeginX);
        lm.secondpreyarrayfinish[finishcounterbigfish + 1] = (int) (biglavafish.getWorldLocation().y - lm.BeginY);

        biglavafish.setWorldLocation(lm.BeginX + biglavafish.currentxWorld, lm.BeginY + biglavafish.currentyWorld);

        biglavafish.steps = 0;

        }

        finishcounterbigfish = finishcounterbigfish + 2;


        }


            smalllavafishHitBox();

            biglavafishHitBox();

            rockbeegravHitBox(deletearrayFood);



            redbubbleHitBox(deletearrayFood);

            lavafurHitBox(deletearrayFood);

            gravitycloudHitBox(deletearrayFood);


        if(lm.gravitycloudgameObjects.size() < 5){

            rockbeegravsecondHitBox(deletearrayFood);

            bigdustrockbeegravlavaHitBox(deletearrayFood);

            dustbulletHitBox(deletearrayFood);


        }


            if(lm.gravitycloudgameObjects.size() < 4){
                rockbeegravthirdHitBox(deletearrayFood);
                bigdustrockbeegravlavasecondHitBox(deletearrayFood);

                dustbulletsecondHitBox(deletearrayFood);


            }


            if(lm.gravitycloudgameObjects.size() < 3){
                rockbeegravfourthHitBox(deletearrayFood);
                bigdustrockbeegravlavathirdHitBox(deletearrayFood);

                dustbulletthirdHitBox(deletearrayFood);

            }

            if(lm.gravitycloudgameObjects.size() < 2){
                bigdustrockbeegravlavafourthHitBox(deletearrayFood);
                dustbulletfourthHitBox(deletearrayFood);

            }
        }


        }

        }


        void checkdiedcondition() {


        if (frogFungiPlayerState.getLives() != 1) {
        frogFungiPlayerState.delLives(1);


        boolean frompv = true;


        Intent mainIntent = new Intent(MainActivity.contextMain, TransientActivity.class);
        mainIntent.putExtra("worlds", frogFungiPlayerState.getWorld());
        mainIntent.putExtra("levels", frogFungiPlayerState.getLevel());
        mainIntent.putExtra("lives", frogFungiPlayerState.getLives());
        mainIntent.putExtra("prey", frogFungiPlayerState.getPrey());
        mainIntent.putExtra("food", frogFungiPlayerState.getFood());

        mainIntent.putExtra("frompv", frompv);

        MainActivity.contextMain.startActivity(mainIntent);


        } else {


        frogFungiPlayerState.delLives(1);

        Intent gameStop = new Intent(MainActivity.contextMain, GameStopActivity.class);
        gameStop.putExtra("backgroundx", lm.bgLandscape.getbackgroundxResolution());
        gameStop.putExtra("backgroundy", lm.bgLandscape.getbackgroundyResolution());
        gameStop.putExtra("lives", frogFungiPlayerState.getLives());
        gameStop.putExtra("worlds", frogFungiPlayerState.getWorld());
        gameStop.putExtra("levels", frogFungiPlayerState.getLevel());
        gameStop.putExtra("prey", frogFungiPlayerState.getPrey());
        gameStop.putExtra("food", frogFungiPlayerState.getFood());


        MainActivity.contextMain.startActivity(gameStop);


        }


        }


    void checkfirstcondition(ArrayList<GameObject> arrayofFood, GameObject foodObject){

        if(arrayofFood.indexOf(foodObject) != 0 && foodObject.condition.matches("initialcondition") &&
                arrayofFood.size() == arrayofFood.get(0).enemyValue.lengthofcomparisonarr) {
            if (arrayofFood.get(0).condition.matches("secondcondition")) {
                if (arrayofFood.get(0).enemyValue != null) {

                    arrayofFood.get(0).enemyValue.lengthofcomparisonarr =
                            arrayofFood.get(0).enemyValue.lengthofcomparisonarr - 1;

                    arrayofFood.get(0).enemyValue.bugPositiondelete.add(
                            arrayofFood.get(0).enemyValue.bugPosition.get(arrayofFood.indexOf(foodObject) * 2));


                    arrayofFood.get(0).enemyValue.bugPositiondelete.add(
                            arrayofFood.get(0).enemyValue.bugPosition.get((arrayofFood.indexOf(foodObject) * 2) + 1));


                    arrayofFood.get(0).enemyValue.bugPositionadderdelete.add(
                            arrayofFood.get(0).enemyValue.bugPositionadder.get(arrayofFood.indexOf(foodObject) * 2));


                    arrayofFood.get(0).enemyValue.bugPositionadderdelete.add(
                            arrayofFood.get(0).enemyValue.bugPositionadder.get((arrayofFood.indexOf(foodObject) * 2) + 1));

                }
            } else if (arrayofFood.get(0).condition.matches("firstcondition")) {
                if (arrayofFood.get(0).enemyValue != null) {

                    foodObject.setVisible(false);
                }

            }
        }

        else if(arrayofFood.indexOf(foodObject) == 0 && foodObject.enemyValue != null &&
                arrayofFood.size() == foodObject.enemyValue.lengthofcomparisonarr) {

            for (GameObject food : arrayofFood) {
                food.condition = "firstcondition";
            }

        }

    }



        void checkcollitioncondition(int food, GameObject foodObject, ArrayList<GameObject> arrayofFood,
                                     ArrayList<GameObject> deletearrayFood) {

        if(foodObject.getrectHitboxtop() != null) {
            if ((lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxtop())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxright())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxbottom())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxleft()))
                    && lm.frogFungiPlayer.changeFrogPosition == false) {


                checkdiedcondition();

            } else if ((lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxtop())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxright())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxbottom())
                    || lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxleft()))
                    && lm.frogFungiPlayer.changeFrogPosition == true) {


                stilldied(food, foodObject);

                notdied(food, foodObject, arrayofFood, deletearrayFood);

            }

        }
          else if(foodObject.getrectHitboxcircle() != null) {

            
            if(arrayofFood == lm.lavafurgameObjects) {
                checklavafurdeadcondition(foodObject, arrayofFood, deletearrayFood);

            }
            
            
            if (lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxcircle()) && lm.frogFungiPlayer.changeFrogPosition == false){
                checkdiedcondition();
            }
            
            
            else if (lm.frogFungiPlayer.checkCollisions(foodObject.getrectHitboxcircle()) && lm.frogFungiPlayer.changeFrogPosition == true)
                {



                    stilldiedcircle(foodObject);
                    notdiedcircle(food, foodObject, arrayofFood, deletearrayFood);


            }
            }


            }

    void checkdeletebugPositionarray(Values enemyObjectvalues) {


        if (enemyObjectvalues.bugPositiondelete.size() != 0) {
            for (Float deletebugPosition : enemyObjectvalues.bugPositiondelete) {
                enemyObjectvalues.bugPosition.remove(deletebugPosition);
                enemyObjectvalues.bugPosition.trimToSize();
            }
        }

            if (enemyObjectvalues.bugPositionadderdelete.size() != 0) {
                for (Float deletebugPositionadder : enemyObjectvalues.bugPositionadderdelete) {
                    enemyObjectvalues.bugPositionadder.remove(deletebugPositionadder);
                    enemyObjectvalues.bugPositionadder.trimToSize();
                }
            }

                enemyObjectvalues.bugPositiondelete.clear();
                enemyObjectvalues.bugPositionadderdelete.clear();


            }




        void checkdeletearrayFood(ArrayList<GameObject> arrayofFood, ArrayList<GameObject> deletearrayFood) {


        if (deletearrayFood.size() != 0) {
        for (GameObject deletefood : deletearrayFood) {
        arrayofFood.remove(deletefood);
        arrayofFood.trimToSize();
        }


        deletearrayFood.clear();



        }
        }

    void checkdeletearrayghostspinder(ArrayList<GameObject> arrayofghostspinder, ArrayList<GameObject> notesonghostspinder) {

        ArrayList<GameObject> deletearrayghostspinder = new ArrayList<GameObject>();

        for(GameObject ghostspinder: arrayofghostspinder){
            for(GameObject ghostspindernotes: notesonghostspinder){
                if(ghostspinder == ghostspindernotes){
                      ghostspinder.satellitecode = ghostspinder.satellitecode - 1;

                    if(ghostspinder.satellitecode == 0){
                        deletearrayghostspinder.add(ghostspinder);
                    }

                }

            }
        }



        if (deletearrayghostspinder.size() != 0) {
            for (GameObject deleteghost : deletearrayghostspinder) {
                arrayofghostspinder.remove(deleteghost);
                arrayofghostspinder.trimToSize();
            }



        }

        lm.notesonghostspindergameObjects.clear();
        notesonghostspinder.clear();
        deletearrayghostspinder.clear();

    }


    void checksuckerbeegravlastUpdate(GameObject suckerbeegrav) {
        if (lm.bgLandscape.fungitype.matches("adultfungi") &&
        suckerbeegrav.nextxPosition == lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypepos * 2] &&
        suckerbeegrav.nextyPosition == lm.bgLandscape.fungiArray[(lm.bgLandscape.fungitypepos * 2) + 1]) {


        fourwaysuckerbeegravLevelThreeChecked(suckerbeegrav, lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypepos * 2],
        lm.bgLandscape.fungiArray[(lm.bgLandscape.fungitypepos * 2) + 1]);


        }


        if (lm.bgLandscape.fungitypesecond.matches("adultfungisecond") &&
        suckerbeegrav.nextxPosition == lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypesecondpos * 2] &&
        suckerbeegrav.nextyPosition == lm.bgLandscape.fungiArray[(lm.bgLandscape.fungitypesecondpos * 2) + 1]) {


        fourwaysuckerbeegravLevelThreeChecked(suckerbeegrav, lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypesecondpos * 2],
        lm.bgLandscape.fungiArray[(lm.bgLandscape.fungitypesecondpos * 2) + 1]);


        }


        }


        void fourwaysuckerbeegravLevelThreeChecked(GameObject suckerbeegrav, int fungiArrayvaluex, int fungiArrayvaluey) {

        if (suckerbeegrav.currentxWorld < fungiArrayvaluex) {
        if (suckerbeegrav.currentxWorld + suckerbeegrav.getBitmapWidth() >=
        fungiArrayvaluex) {


        if (suckerbeegrav.currentyWorld < fungiArrayvaluey) {

        if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() >=
        fungiArrayvaluey) {

        setFungiAdulthasChanged(fungiArrayvaluex);

        }
        }
        if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() > fungiArrayvaluey) {

        if (suckerbeegrav.currentyWorld <=
        fungiArrayvaluey) {

        setFungiAdulthasChanged(fungiArrayvaluex);
        }
        }
        }
        } else if (suckerbeegrav.currentxWorld + suckerbeegrav.getBitmapWidth() > fungiArrayvaluex) {

        if (suckerbeegrav.currentxWorld <=
        fungiArrayvaluex) {


        if (suckerbeegrav.currentyWorld < fungiArrayvaluey) {

        if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() >=
        fungiArrayvaluey) {

        setFungiAdulthasChanged(fungiArrayvaluex);

        }
        }

        if (suckerbeegrav.currentyWorld + suckerbeegrav.getBitmapHeight() > fungiArrayvaluey) {


        if (suckerbeegrav.currentyWorld <=
        fungiArrayvaluey) {

        setFungiAdulthasChanged(fungiArrayvaluex);
        }

        }
        }

        }


        }

        void setFungiAdulthasChanged(int fungiArrayvaluex) {

        if (fungiArrayvaluex == lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypepos * 2]) {

        lm.bgLandscape.fungitype = "babyfungi";


        } else if (fungiArrayvaluex == lm.bgLandscape.fungiArray[lm.bgLandscape.fungitypesecondpos * 2]) {

        lm.bgLandscape.fungitypesecond = "babyfungisecond";
        }

        }







        void drawlayerOneLine() {


        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 150, 0, 0));
        paint.setStrokeWidth(20);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 150, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 150, 0, 0));
        paint.setStrokeWidth(20);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 150, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 150, 0, 0));
        paint.setStrokeWidth(20);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 150, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 150, 0, 0));
        paint.setStrokeWidth(20);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 150, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        20, paint);
        }


        }

        }

        }


        void drawlayerTwoLine() {


        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 170, 0, 0));
        paint.setStrokeWidth(18);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 170, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 170, 0, 0));
        paint.setStrokeWidth(18);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 170, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 170, 0, 0));
        paint.setStrokeWidth(18);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 170, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 170, 0, 0));
        paint.setStrokeWidth(18);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 170, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        18, paint);
        }


        }

        }

        }


        void drawlayerThreeLine() {


        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 190, 0, 0));
        paint.setStrokeWidth(16);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 190, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 190, 0, 0));
        paint.setStrokeWidth(16);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 190, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 190, 0, 0));
        paint.setStrokeWidth(16);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 190, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 190, 0, 0));
        paint.setStrokeWidth(16);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 190, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        16, paint);
        }


        }

        }

        }


        void drawlayerFourLine() {


        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 210, 0, 0));
        paint.setStrokeWidth(14);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 210, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 210, 0, 0));
        paint.setStrokeWidth(14);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 210, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 210, 0, 0));
        paint.setStrokeWidth(14);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 210, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 210, 0, 0));
        paint.setStrokeWidth(14);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 210, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        14, paint);
        }


        }

        }

        }

        void drawlayerFiveLine() {


        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 230, 0, 0));
        paint.setStrokeWidth(12);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 230, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 230, 0, 0));
        paint.setStrokeWidth(12);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 230, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 230, 0, 0));
        paint.setStrokeWidth(12);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 230, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 230, 0, 0));
        paint.setStrokeWidth(12);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 230, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        12, paint);
        }


        }

        }

        }


        void drawlayerSixLine() {

        for (int x = 0; x < lm.bgLandscape.fungiArray.length; x = x + 2) {

        if ((x + 2) >= lm.bgLandscape.fungiArray.length) {

        break;

        } else {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if (x == 18) {

        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setStrokeWidth(10);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 8] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 9] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 255, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);


        } else if (x == 24) {

        continue;

        } else {

        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setStrokeWidth(10);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 255, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);
        }

        } else if (frogFungiPlayerState.getWorld().matches("Lava")) {

        if ((x == 72) || (x == 74)) {
        continue;
        } else {


        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setStrokeWidth(10);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 255, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);
        }

        } else {

        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setStrokeWidth(10);

        levelcanvas.drawLine((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        paint);


        paint.setColor(Color.argb(255, 255, 255, 0));

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 1] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);

        levelcanvas.drawCircle((float) lm.bgLandscape.fungiArray[x + 2] * (MainActivity.resolutionx / (lm.bgLandscape.getWidth() * 80)),
        (float) lm.bgLandscape.fungiArray[x + 3] * (MainActivity.resolutiony / (lm.bgLandscape.getHeight() * 80)),
        10, paint);
        }


        }

        }

        }


        void drawlayerText() {

        Typeface tf = Typeface.createFromAsset(getResources().getAssets(),"fonts/GoodDog.otf");

        paint.setTypeface(tf);

        paint.setColor(Color.argb(255, 200, 0, 255));

        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        paint.setStrokeWidth(1);



        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        paint.setTextSize(MainActivity.resolutiony / 8);

        canvas.drawText(getResources().getString(R.string.level_1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

        paint.setTextSize(MainActivity.resolutiony / 12);

        if (paint.measureText(getResources().getString(R.string.topstring1lvl1) +
                getResources().getString(R.string.topstring2lvl1)) > MainActivity.resolutionx * .75f) {

        canvas.drawText(getResources().getString(R.string.topstring1lvl1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
        canvas.drawText(getResources().getString(R.string.topstring2lvl1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


        } else {

        canvas.drawText(getResources().getString(R.string.topstring1lvl1) + " " +
                getResources().getString(R.string.topstring2lvl1),
        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

        }

        if (paint.measureText(getResources().getString(R.string.bottomstring1lvl1) +
                getResources().getString(R.string.bottomstring2lvl1)) > MainActivity.resolutionx * .75f) {

        canvas.drawText(getResources().getString(R.string.bottomstring1lvl1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
        canvas.drawText(getResources().getString(R.string.bottomstring2lvl1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


        } else {

        canvas.drawText(getResources().getString(R.string.bottomstring1lvl1) + " " +
                getResources().getString(R.string.bottomstring2lvl1), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

        }


        } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {

            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl2) +
                    getResources().getString(R.string.topstring2lvl2)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl2) + " " +
                                getResources().getString(R.string.topstring2lvl2),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl2) +
                    getResources().getString(R.string.bottomstring2lvl2)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl2) + " " +
                        getResources().getString(R.string.bottomstring2lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }


        } else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {

            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl3) +
                    getResources().getString(R.string.topstring2lvl3)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl3) + " " +
                                getResources().getString(R.string.topstring2lvl3),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl3) +
                    getResources().getString(R.string.bottomstring2lvl3)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl3) + " " +
                        getResources().getString(R.string.bottomstring2lvl3), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }

        } else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {
            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl4) +
                    getResources().getString(R.string.topstring2lvl4)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl4) + " " +
                                getResources().getString(R.string.topstring2lvl4),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl4) +
                    getResources().getString(R.string.bottomstring2lvl4)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl4) + " " +
                        getResources().getString(R.string.bottomstring2lvl4), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }


        } else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {

            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl5) +
                    getResources().getString(R.string.topstring2lvl5)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl5) + " " +
                                getResources().getString(R.string.topstring2lvl5),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl5) +
                    getResources().getString(R.string.bottomstring2lvl5)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl5) + " " +
                        getResources().getString(R.string.bottomstring2lvl5), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }

        } else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {
            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl6) +
                    getResources().getString(R.string.topstring2lvl6)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl6) + " " +
                                getResources().getString(R.string.topstring2lvl6),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl6) +
                    getResources().getString(R.string.bottomstring2lvl6)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl6) + " " +
                        getResources().getString(R.string.bottomstring2lvl6), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }

        } else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_7), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl7) +
                    getResources().getString(R.string.topstring2lvl7)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl7), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl7), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl7) + " " +
                                getResources().getString(R.string.topstring2lvl7),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl7) +
                    getResources().getString(R.string.bottomstring2lvl7)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl7), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl2), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl7) + " " +
                        getResources().getString(R.string.bottomstring2lvl7), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }

        } else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
            paint.setTextSize(MainActivity.resolutiony / 8);

            canvas.drawText(getResources().getString(R.string.level_8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 4), paint);

            paint.setTextSize(MainActivity.resolutiony / 12);

            if (paint.measureText(getResources().getString(R.string.topstring1lvl8) +
                    getResources().getString(R.string.topstring2lvl8)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.topstring1lvl8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.topstring2lvl8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 1), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.topstring1lvl8) + " " +
                                getResources().getString(R.string.topstring2lvl8),
                        MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 - (MainActivity.resolutiony / 12 * 2), paint);

            }

            if (paint.measureText(getResources().getString(R.string.bottomstring1lvl8) +
                    getResources().getString(R.string.bottomstring2lvl8)) > MainActivity.resolutionx * .75f) {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);
                canvas.drawText(getResources().getString(R.string.bottomstring2lvl8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 3), paint);


            } else {

                canvas.drawText(getResources().getString(R.string.bottomstring1lvl8) + " " +
                        getResources().getString(R.string.bottomstring2lvl8), MainActivity.resolutionx / 2, MainActivity.resolutiony / 2 + (MainActivity.resolutiony / 12 * 2), paint);

            }


        }

        }


        void drawBitmapToCanvas(GameObject gameObject, Matrix matrix) {

        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Ocean")) {

        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelOneOcean(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelOneOcean(gameObject.getType())],
        matrix,
        paint);


        }


        }

        if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelTwoOcean(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelTwoOcean(gameObject.getType())],
        matrix,
        paint);


        }




        }

        if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelThreeOcean(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelThreeOcean(gameObject.getType())],
        matrix,
        paint);


        }




        }

        if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelFourOcean(gameObject.getType())],
        matrix,
        paint);


        }





        }


        if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelOneLava(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelOneLava(gameObject.getType())],
        matrix,
        paint);


        }





        }

        if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelTwoLava(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelTwoLava(gameObject.getType())],
        matrix,
        paint);


        }




        }

        if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelThreeLava(gameObject.getType())],
        matrix,
        paint);


        }


        }

        if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {


        if(gameObject.getFacing().matches("LEFT")) {

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(gameObject.getType()) + 1],
        matrix,
        paint);
        }

        else if(gameObject.getFacing().matches("RIGHT")){

        canvas.drawBitmap(
        lm.bitmapsArray[lm.getBitmapIndexLevelFourLava(gameObject.getType())],
        matrix,
        paint);


        }




        }


        }


        void tonguewormUpdate(int x) {



        for (Values fungitypelavastatus : lm.bgLandscape.fungitypelavastatus) {

            if (lm.bgLandscape.funginumber[x] == lm.bgLandscape.tonguewormnumber[lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)] &&
                    lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[x * 2] &&
                    lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[(x * 2) + 1] &&
                    fungitypelavastatus.fungitypelavastatus == 3) {

                if (fungitypelavastatus.oldTime == 0) {
                    fungitypelavastatus.oldTime = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - fungitypelavastatus.oldTime, TimeUnit.NANOSECONDS) >= 5) {
                    checkdiedcondition();

                }


            }

            else if(lm.bgLandscape.funginumber[x] == lm.bgLandscape.tonguewormnumber[lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)] &&
                    fungitypelavastatus.oldTime != 0 && fungitypelavastatus.fungitypelavastatus == 3){
                fungitypelavastatus.oldTime = 0;
            }


            if (lm.bgLandscape.funginumber[x] == lm.bgLandscape.tonguewormnumber[lm.bgLandscape.fungitypelavastatus.indexOf(fungitypelavastatus)] &&
                    lm.frogFungiPlayer.currentxWorld == lm.bgLandscape.fungiArray[x * 2] &&
                    lm.frogFungiPlayer.currentyWorld == lm.bgLandscape.fungiArray[(x * 2) + 1]) {


                if (fungitypelavastatus.fungitypelavastatus == 0) {

                    fungitypelavastatus.fungitypelavastatus = 1;

                    fungitypelavastatus.fungitypelavapos = x;
                }
            }
             else if (fungitypelavastatus.fungitypelavastatus == 1) {

                if (fungitypelavastatus.oldTime == 0) {
                    fungitypelavastatus.oldTime = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - fungitypelavastatus.oldTime, TimeUnit.NANOSECONDS) >= 1) {


                    fungitypelavastatus.fungitypelavastatus = 2;
                    fungitypelavastatus.oldTime = 0;

                }

            } else if (fungitypelavastatus.fungitypelavastatus == 2) {

                if (fungitypelavastatus.oldTime == 0) {
                    fungitypelavastatus.oldTime = System.nanoTime();
                }

                if (TimeUnit.SECONDS.convert(System.nanoTime() - fungitypelavastatus.oldTime, TimeUnit.NANOSECONDS) >= 1) {


                    fungitypelavastatus.fungitypelavastatus = 3;
                    fungitypelavastatus.oldTime = 0;


                }
            }
            }


        }


        void stilldied(int food, GameObject foodObject) {


        if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        if (foodObject.getType() == 'g') {

        frogFungiPlayerState.addFood(food);

        checkdiedcondition();
        }
        }

        else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        if (foodObject.getType() == 'l') {

        frogFungiPlayerState.addFood(food);

        checkdiedcondition();
        }

            else if(foodObject.getType() == 'y'){
            checkdiedcondition();
        }

        }




        else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {
        if (foodObject.getType() == 'p') {
        if (foodObject.condition.matches("firstcondition") || foodObject.condition.matches("thirdcondition")) {


        frogFungiPlayerState.addFood(food);

        checkdiedcondition();
        }


        }
        else if(foodObject.getType() == 'y'){
            checkdiedcondition();
        }


        }


        else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {

            if (foodObject.getType() == 'F') {
                if ((foodObject.getWorldLocation().x == lm.BeginX + foodObject.currentxWorld) &&
                        (foodObject.getWorldLocation().y == lm.BeginY + foodObject.currentyWorld)) {

                    frogFungiPlayerState.addFood(food);

                    checkdiedcondition();
                }
            }
        }


        else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {

            if (foodObject.getType() == 'F') {
                if ((foodObject.getWorldLocation().x == lm.BeginX + foodObject.currentxWorld) &&
                        (foodObject.getWorldLocation().y == lm.BeginY + foodObject.currentyWorld)) {

                    frogFungiPlayerState.addFood(food);

                    checkdiedcondition();
                }
            }
        }



        else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'v') {
                if (foodObject.condition.matches("firstcondition") || foodObject.condition.matches("thirdcondition")) {


                frogFungiPlayerState.addFood(food);

                checkdiedcondition();
                }
            }


            if(foodObject.getType() == 'k'){

                if(foodObject.condition.matches("secondcondition")){
                    frogFungiPlayerState.addFood(food);

                        checkdiedcondition();

                        }
                }

       }






        }

        void notdied(int food, GameObject foodObject, ArrayList<GameObject> arrayofFood,
                     ArrayList<GameObject> deletearrayFood ){


            if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Ocean")) {
                if (foodObject.getType() == 'o' &&  arrayofFood == lm.oceanbuggameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }

           else if (foodObject.getType() == 'o' && arrayofFood == lm.oceanbugsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }

                else if (foodObject.getType() == 'b' && arrayofFood == lm.beegravthirdgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }


                else if (foodObject.getType() == 'b' && arrayofFood == lm.beegravfourthgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }

                }

                else if (foodObject.getType() == 'i' && arrayofFood == lm.bigbeegravsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }


                else {
                        frogFungiPlayerState.addFood(food);
                        deletearrayFood.add(foodObject);


                    }

                }

          else  if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Ocean")) {

                if (foodObject.getType() == 'b' && arrayofFood == lm.beegravthirdgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }

            else if(foodObject.getType() == 'w' && arrayofFood == lm.swirlwatergameObjects){
                    int satellitecodecounter = 0;


                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderswirlwatergameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;
                        
                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }

                    
                }


                else if(foodObject.getType() == 'w' && arrayofFood == lm.swirlwatersecondgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspindersecondswirlwatergameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }

                }


                else if(foodObject.getType() == 'w' && arrayofFood == lm.swirlwaterthirdgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderthirdswirlwatergameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }


                }

                else if(foodObject.getType() == 'v' && arrayofFood == lm.stargravgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderstargravgameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }


                }


                else if(foodObject.getType() == 'v' && arrayofFood == lm.stargravsecondgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspindersecondstargravgameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }



                }


                else if(foodObject.getType() == 'v' && arrayofFood == lm.stargravthirdgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderthirdstargravgameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }



                }



                else {
                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);


                }




            }
                else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Ocean")) {


                if (foodObject.getType() == 'b' && arrayofFood == lm.beegravgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }


             else  if (foodObject.getType() == 'b' && arrayofFood == lm.beegravsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }

                }


                else if (foodObject.getType() == 'b' && arrayofFood == lm.beegravthirdgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }


                else if (foodObject.getType() == 'b' && arrayofFood == lm.beegravfourthgameObjects) {


                    frogFungiPlayerState.addFood(food);

                    checkfirstcondition(arrayofFood, foodObject);


                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }


                else if (foodObject.getType() == 'o' && arrayofFood == lm.oceanbuggameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);


                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }



                else if (foodObject.getType() == 'o' && arrayofFood == lm.oceanbugsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);


                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }

                else if (foodObject.getType() == 'o' && arrayofFood == lm.oceanbugthirdgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }


                }

                else if (foodObject.getType() == 'o' && arrayofFood == lm.oceanbugfourthgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }


                else if(foodObject.getType() == 'w' && arrayofFood == lm.swirlwatergameObjects){
                    int satellitecodecounter = 0;


                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderswirlwatergameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }


                }


                else if(foodObject.getType() == 'w' && arrayofFood == lm.swirlwatersecondgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspindersecondswirlwatergameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }

                }

                else if(foodObject.getType() == 'v' && arrayofFood == lm.stargravgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspinderstargravgameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }


                }


                else if(foodObject.getType() == 'v' && arrayofFood == lm.stargravsecondgameObjects){
                    int satellitecodecounter = 0;

                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);

                    for(GameObject ghostspinder: lm.ghostspindersecondstargravgameObjects){
                        satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                        if(arrayofFood.indexOf(foodObject) < satellitecodecounter){
                            lm.notesonghostspindergameObjects.add(ghostspinder);

                            break;
                        }

                    }



                }



                else if (foodObject.getType() == 'p') {
        if (foodObject.getBitmapNameLeft().matches("waterdropleft")) {

        foodObject.condition = "deadcondition";


        frogFungiPlayerState.addFood(food);

        }
        }

        else {
        frogFungiPlayerState.addFood(food);
        deletearrayFood.add(foodObject);


        }

        }

        else if (frogFungiPlayerState.getLevel().matches("LevelOne") && frogFungiPlayerState.getWorld().matches("Lava")) {
       
            

                if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravsecondgameObjects) {


                frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }

            }

             else if (foodObject.getType() == 'B' && arrayofFood == lm.rockbigbeegravsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

                    if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                        deletearrayFood.add(foodObject);
                    }



                }


                else {
                    frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);


                }

                
            }
            
            
            
        else if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {
        if(foodObject.getType() == 't'){

        frogFungiPlayerState.addFood(food);

        if((fungihasChanged.size() != 0) && (foodObject.firefungihold != 0)) {
        fungihasChanged.remove(fungihasChanged.indexOf(foodObject.firefungihold));
        }

        deletearrayFood.add(foodObject);



        }

              else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



                }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravthirdgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravfourthgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }



        else if (foodObject.getType() == 'B' && arrayofFood == lm.rockbigbeegravsecondgameObjects) {


                    frogFungiPlayerState.addFood(food);
                    checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }


        }

        else if (foodObject.getType() == 'B' && arrayofFood == lm.rockbigbeegravthirdgameObjects) {


            frogFungiPlayerState.addFood(food);

            checkfirstcondition(arrayofFood, foodObject);

             if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                 deletearrayFood.add(foodObject);
             }


        }

        else if (foodObject.getType() == 'B' && arrayofFood == lm.rockbigbeegravfourthgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }

        }

        else if (foodObject.getType() == 'd' && arrayofFood == lm.dustrockbeegravlavasecondgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }


        }

        else if (foodObject.getType() == 'd' && arrayofFood == lm.dustrockbeegravlavathirdgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }


        }

        else if (foodObject.getType() == 'd' && arrayofFood == lm.dustrockbeegravlavafourthgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }


        }



        else {
        frogFungiPlayerState.addFood(food);
        deletearrayFood.add(foodObject);


        }

        }


        else if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
        if (foodObject.getType() == 'v') {
        if (foodObject.getBitmapNameLeft().matches("lavadropleft")) {

        foodObject.condition = "deadcondition";

        frogFungiPlayerState.addFood(food);


        }
        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravsecondgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravthirdgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }

        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravfourthgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }



        else if (foodObject.getType() == 'B' && arrayofFood == lm.rockbigbeegravsecondgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }




        else {

        frogFungiPlayerState.addFood(food);
        deletearrayFood.add(foodObject);


        }
        }

        else if(frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {

        if (foodObject.getType() == 'e') {
        if (foodObject.condition.matches("secondcondition") || foodObject.condition.matches("thirdcondition")) {

        foodObject.valuehold = foodObject.valuehold + food;
        foodObject.condition = "deadcondition";

        frogFungiPlayerState.addFood(food);


        }
        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravsecondgameObjects) {

            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravthirdgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }

        }


        else if (foodObject.getType() == 'b' && arrayofFood == lm.rockbeegravfourthgameObjects) {


            frogFungiPlayerState.addFood(food);
            checkfirstcondition(arrayofFood, foodObject);

            if(foodObject.getVisible() || foodObject.condition.matches("secondcondition")) {
                deletearrayFood.add(foodObject);
            }



        }






        else {

        frogFungiPlayerState.addFood(food);
        deletearrayFood.add(foodObject);


        }





        }


        else {


        frogFungiPlayerState.addFood(food);
        deletearrayFood.add(foodObject);


        }


        }


    void checklavafurdeadcondition(GameObject foodObject, ArrayList<GameObject> arrayofFood,
                 ArrayList<GameObject> deletearrayFood ) {


        if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'a' && arrayofFood == lm.lavafurgameObjects) {

                if(foodObject.condition.matches("deadcondition")){
                    deletearrayFood.add(foodObject);

                }


            }

        }


       else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'a' && arrayofFood == lm.lavafurgameObjects) {

                if(foodObject.condition.matches("deadcondition")){
                    deletearrayFood.add(foodObject);

                }


            }

        }


    }


    void notdiedcircle(int food, GameObject foodObject, ArrayList<GameObject> arrayofFood,
                                   ArrayList<GameObject> deletearrayFood ) {



        if (frogFungiPlayerState.getLevel().matches("LevelTwo") && frogFungiPlayerState.getWorld().matches("Lava")) {

            if(foodObject.getType() == 'D' && arrayofFood == lm.bigdustrockbeegravlavagameObjects) {
                int satellitecodecounter = 0;

                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);

                for (GameObject ghostspinder : lm.ghostspinderbigdustrockbeegravlavagameObjects) {
                    satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                    if (arrayofFood.indexOf(foodObject) < satellitecodecounter) {
                        lm.notesonghostspindergameObjects.add(ghostspinder);

                        break;
                    }

                }

            }

        }





        if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'c' && arrayofFood == lm.gravitycloudgameObjects) {


                frogFungiPlayerState.addFood(food);
                   deletearrayFood.add(foodObject);



            }

            else if(foodObject.getType() == 'D' && arrayofFood == lm.bigdustrockbeegravlavagameObjects){
                int satellitecodecounter = 0;


                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);

                for(GameObject ghostspinder: lm.ghostspinderbigdustrockbeegravlavagameObjects){
                    satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                    if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                        lm.notesonghostspindergameObjects.add(ghostspinder);

                        break;
                    }

                }


            }

            else if(foodObject.getType() == 'D' && arrayofFood == lm.bigdustrockbeegravlavasecondgameObjects){
                int satellitecodecounter = 0;


                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);

                for(GameObject ghostspinder: lm.ghostspindersecondbigdustrockbeegravlavagameObjects){
                    satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                    if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                        lm.notesonghostspindergameObjects.add(ghostspinder);

                        break;
                    }

                }


            }

            else if(foodObject.getType() == 'D' && arrayofFood == lm.bigdustrockbeegravlavathirdgameObjects){
                int satellitecodecounter = 0;


                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);

                for(GameObject ghostspinder: lm.ghostspinderthirdbigdustrockbeegravlavagameObjects){
                    satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                    if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                        lm.notesonghostspindergameObjects.add(ghostspinder);

                        break;
                    }

                }


            }

            else if(foodObject.getType() == 'D' && arrayofFood == lm.bigdustrockbeegravlavafourthgameObjects){
                int satellitecodecounter = 0;


                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);

                for(GameObject ghostspinder: lm.ghostspinderfourthbigdustrockbeegravlavagameObjects){
                    satellitecodecounter = satellitecodecounter + ghostspinder.satellitecode;

                    if(arrayofFood.indexOf(foodObject) < satellitecodecounter){

                        lm.notesonghostspindergameObjects.add(ghostspinder);

                        break;
                    }

                }


            }



        }


        else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'c' && arrayofFood == lm.gravitycloudgameObjects) {


                frogFungiPlayerState.addFood(food);
                    deletearrayFood.add(foodObject);



            }
            else {

                frogFungiPlayerState.addFood(food);
                deletearrayFood.add(foodObject);


            }



        }


    }




    void stilldiedcircle(GameObject foodObject) {


        if (frogFungiPlayerState.getLevel().matches("LevelThree") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'a') {

                checkdiedcondition();
            }


        }

        else if (frogFungiPlayerState.getLevel().matches("LevelFour") && frogFungiPlayerState.getWorld().matches("Lava")) {
            if (foodObject.getType() == 'a') {

                checkdiedcondition();
            }

            else if(foodObject.getType() == 'u'){
                checkdiedcondition();
            }



        }
    }





        void callingTransientActivity(){
        boolean frompv = true;

        Intent mainIntent = new Intent(MainActivity.contextMain, TransientActivity.class);
        mainIntent.putExtra("worlds", frogFungiPlayerState.getWorld());
        mainIntent.putExtra("levels", frogFungiPlayerState.getLevel());
        mainIntent.putExtra("lives", frogFungiPlayerState.getLives());
        mainIntent.putExtra("prey", frogFungiPlayerState.getPrey());
        mainIntent.putExtra("food", frogFungiPlayerState.getFood());
        mainIntent.putExtra("gamewin", true);


        mainIntent.putExtra("frompv", frompv);

        MainActivity.contextMain.startActivity(mainIntent);

        }


    void beegravHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject beegrav : lm.beegravgameObjects) {


            beegrav.setHitBoxPosition(lm.BeginX + beegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + beegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(10, beegrav, lm.beegravgameObjects, deletearrayFood);

        }




        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.beegravgameObjects, deletearrayFood);
        }
    }


    void beegravLevelFourOceanHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject beegrav : lm.beegravgameObjects) {


            beegrav.setHitBoxPosition(lm.BeginX + beegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + beegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!beegrav.getVisible() &&
                    ((!lm.beegravgameObjects.isEmpty() && lm.beegravgameObjects.get(0).condition.matches("condtion"))
                            || (!lm.beegravgameObjects.isEmpty() && lm.beegravgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.beegravgameObjects, beegrav);
                deletearrayFood.add(beegrav);


            }

            else if(beegrav.getVisible()) {

                checkcollitioncondition(10, beegrav, lm.beegravgameObjects, deletearrayFood);
            }
        }


        if(!lm.beegravgameObjects.isEmpty() &&
                lm.beegravgameObjects.get(0).enemyValue != null &&
                lm.beegravgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.beegravgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.beegravgameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.beegravgameObjects, deletearrayFood);
        }
    }


    void smalloceanfishHitBox(){

        for (GameObject smalloceanfish : lm.smalloceanfishgameObjects) {
            if(smalloceanfish.getVisible()) {
                smalloceanfish.setHitBoxPosition((lm.BeginX + smalloceanfish.currentxWorld)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + smalloceanfish.currentyWorld)
                                - lm.bgLandscape.getyVelocity());


                if (lm.frogFungiPlayer.checkCollisions(smalloceanfish.getrectHitboxtop())
                        || lm.frogFungiPlayer.checkCollisions(smalloceanfish.getrectHitboxright())
                        || lm.frogFungiPlayer.checkCollisions(smalloceanfish.getrectHitboxbottom())
                        || lm.frogFungiPlayer.checkCollisions(smalloceanfish.getrectHitboxleft())) {


                    smalloceanfish.setVisible(false);
                    frogFungiPlayerState.addPrey(1);

                }
            }
        }

    }



    void bigoceanfishHitBox() {

        for (GameObject bigoceanfish : lm.bigoceanfishgameObjects) {
            if(bigoceanfish.getVisible()) {
                bigoceanfish.setHitBoxPosition((lm.BeginX + bigoceanfish.currentxWorld)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + bigoceanfish.currentyWorld)
                                - lm.bgLandscape.getyVelocity());


                if (lm.frogFungiPlayer.checkCollisions(bigoceanfish.getrectHitboxtop())
                        || lm.frogFungiPlayer.checkCollisions(bigoceanfish.getrectHitboxright())
                        || lm.frogFungiPlayer.checkCollisions(bigoceanfish.getrectHitboxbottom())
                        || lm.frogFungiPlayer.checkCollisions(bigoceanfish.getrectHitboxleft())) {

                    bigoceanfish.setVisible(false);
                    frogFungiPlayerState.addPrey(5);

                }
            }
        }

    }

    void bigbeegravHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject bigbeegrav : lm.bigbeegravgameObjects) {


            bigbeegrav.setHitBoxPosition(lm.BeginX + bigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, bigbeegrav, lm.bigbeegravgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigbeegravgameObjects, deletearrayFood);
        }
    }

    void bighorngravHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject bighorngrav : lm.bighorngravgameObjects) {


            bighorngrav.setHitBoxPosition(lm.BeginX + bighorngrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bighorngrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(1000, bighorngrav, lm.bighorngravgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bighorngravgameObjects, deletearrayFood);
        }

    }


    void sandladybugHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject sandladybug : lm.sandladybuggameObjects) {


            sandladybug.setHitBoxPosition(lm.BeginX + sandladybug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + sandladybug.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(200, sandladybug, lm.sandladybuggameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.sandladybuggameObjects, deletearrayFood);
        }

    }

    void oceanbugHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject oceanbug : lm.oceanbuggameObjects) {


            oceanbug.setHitBoxPosition(lm.BeginX + oceanbug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + oceanbug.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(50, oceanbug, lm.oceanbuggameObjects, deletearrayFood);


        }

        
        if(!deletearrayFood.isEmpty()) {


            checkdeletearrayFood(lm.oceanbuggameObjects, deletearrayFood);
        }
    }

    void oceanbugLevelTwoOceanHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject oceanbug : lm.oceanbuggameObjects) {


            oceanbug.setHitBoxPosition(lm.BeginX + oceanbug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + oceanbug.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!oceanbug.getVisible() &&
                    ((!lm.oceanbuggameObjects.isEmpty() && lm.oceanbuggameObjects.get(0).condition.matches("condtion"))
                            || (!lm.oceanbuggameObjects.isEmpty() && lm.oceanbuggameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.oceanbuggameObjects, oceanbug);
                deletearrayFood.add(oceanbug);


            }

            else if(oceanbug.getVisible()) {

                checkcollitioncondition(50, oceanbug, lm.oceanbuggameObjects, deletearrayFood);
            }

        }


        if(!lm.oceanbuggameObjects.isEmpty() &&
                lm.oceanbuggameObjects.get(0).enemyValue != null &&
                lm.oceanbuggameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.oceanbuggameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.oceanbuggameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {


            checkdeletearrayFood(lm.oceanbuggameObjects, deletearrayFood);
        }
    }




    void beegravsecondHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject beegrav : lm.beegravsecondgameObjects) {


            beegrav.setHitBoxPosition(lm.BeginX + beegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + beegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!beegrav.getVisible() &&
                    ((!lm.beegravsecondgameObjects.isEmpty() && lm.beegravsecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.beegravsecondgameObjects.isEmpty() && lm.beegravsecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.beegravsecondgameObjects, beegrav);
                deletearrayFood.add(beegrav);


            }

            else if(beegrav.getVisible()) {

                checkcollitioncondition(10, beegrav, lm.beegravsecondgameObjects, deletearrayFood);
            }
        }


        if(!lm.beegravsecondgameObjects.isEmpty() &&
                lm.beegravsecondgameObjects.get(0).enemyValue != null &&
                lm.beegravsecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.beegravsecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.beegravsecondgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.beegravsecondgameObjects, deletearrayFood);
        }
    }


    void beegravthirdHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject beegrav : lm.beegravthirdgameObjects) {


            beegrav.setHitBoxPosition(lm.BeginX + beegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + beegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!beegrav.getVisible() &&
                    ((!lm.beegravthirdgameObjects.isEmpty() && lm.beegravthirdgameObjects.get(0).condition.matches("thirdcondtion"))
                            || (!lm.beegravthirdgameObjects.isEmpty() && lm.beegravthirdgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.beegravthirdgameObjects, beegrav);
                deletearrayFood.add(beegrav);


            }

            else if(beegrav.getVisible()) {

                checkcollitioncondition(10, beegrav, lm.beegravthirdgameObjects, deletearrayFood);
            }
        }


        if(!lm.beegravthirdgameObjects.isEmpty() &&
                lm.beegravthirdgameObjects.get(0).enemyValue != null &&
                lm.beegravthirdgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.beegravthirdgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

                       
            checkdeletebugPositionarray(lm.beegravthirdgameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {


            checkdeletearrayFood(lm.beegravthirdgameObjects, deletearrayFood);

        }


    }


    void beegravfourthHitBox(ArrayList<GameObject> deletearrayFood){

        for (GameObject beegrav : lm.beegravfourthgameObjects) {


            beegrav.setHitBoxPosition(lm.BeginX + beegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + beegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!beegrav.getVisible() &&
                    ((!lm.beegravfourthgameObjects.isEmpty() && lm.beegravfourthgameObjects.get(0).condition.matches("fourthcondtion"))
                            || (!lm.beegravfourthgameObjects.isEmpty() && lm.beegravfourthgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.beegravfourthgameObjects, beegrav);
                deletearrayFood.add(beegrav);


            }

            else if(beegrav.getVisible()) {

                checkcollitioncondition(10, beegrav, lm.beegravfourthgameObjects, deletearrayFood);
            }
        }

        if(!lm.beegravfourthgameObjects.isEmpty() &&
                lm.beegravfourthgameObjects.get(0).enemyValue != null &&
                lm.beegravfourthgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.beegravfourthgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.beegravfourthgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.beegravfourthgameObjects, deletearrayFood);
        }

    }

    void guardianbeegravHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject guardianbeegrav : lm.guardianbeegravgameObjects) {


            guardianbeegrav.setHitBoxPosition(lm.BeginX + guardianbeegrav.currentxWorld +
                            lm.bgLandscape.fungiArray[lm.bgLandscape.funginumber[5 * (lm.guardianbeegravgameObjects.indexOf(guardianbeegrav))] * 2]
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + guardianbeegrav.currentyWorld +
                            lm.bgLandscape.fungiArray[(lm.bgLandscape.funginumber[5 * (lm.guardianbeegravgameObjects.indexOf(guardianbeegrav))] * 2) + 1]
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(80, guardianbeegrav, lm.guardianbeegravgameObjects, deletearrayFood);

        }
        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.guardianbeegravgameObjects, deletearrayFood);
        }

    }


    void bigbeegravsecondHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {


            bigbeegrav.setHitBoxPosition(lm.BeginX + bigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!bigbeegrav.getVisible() &&
                    ((!lm.bigbeegravsecondgameObjects.isEmpty() && lm.bigbeegravsecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.bigbeegravsecondgameObjects.isEmpty() && lm.bigbeegravsecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.bigbeegravsecondgameObjects, bigbeegrav);
                deletearrayFood.add(bigbeegrav);


            }

            else if(bigbeegrav.getVisible()) {

                checkcollitioncondition(250, bigbeegrav, lm.bigbeegravsecondgameObjects, deletearrayFood);

            }
        }

        if(!lm.bigbeegravsecondgameObjects.isEmpty() &&
                lm.bigbeegravsecondgameObjects.get(0).enemyValue != null &&
                lm.bigbeegravsecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.bigbeegravsecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.bigbeegravsecondgameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigbeegravsecondgameObjects, deletearrayFood);
        }

    }

    void bigbeegravsecondLevelThreeOceanHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject bigbeegrav : lm.bigbeegravsecondgameObjects) {


            bigbeegrav.setHitBoxPosition(lm.BeginX + bigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

                checkcollitioncondition(250, bigbeegrav, lm.bigbeegravsecondgameObjects, deletearrayFood);

        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigbeegravsecondgameObjects, deletearrayFood);
        }

    }


    void  bighorngravLevelTwoOceanHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject bighorngrav : lm.bighorngravgameObjects) {


            if(bighorngrav.condition.matches("firstcondition") || bighorngrav.condition.matches("thirdcondition")){

                bighorngrav.setHitBoxPosition(lm.BeginX + bighorngrav.currentxWorld
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + bighorngrav.currentyWorld
                                - lm.bgLandscape.getyVelocity());


            }
            else if(bighorngrav.condition.matches("secondcondition")){
                bighorngrav.setHitBoxPosition(lm.BeginX + bighorngrav.currentxWorld +
                                lm.bgLandscape.fungiArray[lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2]
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + bighorngrav.currentyWorld +
                                lm.bgLandscape.fungiArray[(lm.arraylistofbighorngravescape[bighorngrav.bighorngravrand] * 2) + 1]
                                - lm.bgLandscape.getyVelocity());

            }


            checkcollitioncondition(1000, bighorngrav, lm.bighorngravgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bighorngravgameObjects, deletearrayFood);
        }

    }



    void oceanbugsecondHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject oceanbug : lm.oceanbugsecondgameObjects) {


            oceanbug.setHitBoxPosition(lm.BeginX + oceanbug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + oceanbug.currentyWorld
                            - lm.bgLandscape.getyVelocity());
            
            if(!oceanbug.getVisible() &&
                    ((!lm.oceanbugsecondgameObjects.isEmpty() && lm.oceanbugsecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.oceanbugsecondgameObjects.isEmpty() && lm.oceanbugsecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.oceanbugsecondgameObjects, oceanbug);
                deletearrayFood.add(oceanbug);


            }

            else if(oceanbug.getVisible()) {

                checkcollitioncondition(50, oceanbug, lm.oceanbugsecondgameObjects, deletearrayFood);

            }
        }


        if(!lm.oceanbugsecondgameObjects.isEmpty() &&
                lm.oceanbugsecondgameObjects.get(0).enemyValue != null &&
                lm.oceanbugsecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.oceanbugsecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.oceanbugsecondgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.oceanbugsecondgameObjects, deletearrayFood);
        }

    }


    void  killerbeegravHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject killerbeegrav : lm.killerbeegravgameObjects) {


            killerbeegrav.setHitBoxPosition(lm.BeginX + killerbeegrav.currentxWorld +
                            lm.bgLandscape.fungiArray[5 * (lm.killerbeegravgameObjects.indexOf(killerbeegrav)) * 2]
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + killerbeegrav.currentyWorld +
                            lm.bgLandscape.fungiArray[(5 * (lm.killerbeegravgameObjects.indexOf(killerbeegrav)) * 2) + 1]
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(10, killerbeegrav, lm.killerbeegravgameObjects, deletearrayFood);

        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.killerbeegravgameObjects, deletearrayFood);
        }
    }


    void suckerbeegravHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject suckerbeegrav : lm.suckerbeegravgameObjects) {


            suckerbeegrav.setHitBoxPosition(lm.BeginX + suckerbeegrav.currentxWorld - suckerbeegrav.getBitmapWidth() / 2
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + suckerbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(500, suckerbeegrav, lm.suckerbeegravgameObjects, deletearrayFood);


        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.suckerbeegravgameObjects, deletearrayFood);
        }
    }



    void  oceanbugthirdHitBox(ArrayList<GameObject> deletearrayFood) {


        for (GameObject oceanbug : lm.oceanbugthirdgameObjects) {


            oceanbug.setHitBoxPosition(lm.BeginX + oceanbug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + oceanbug.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!oceanbug.getVisible() &&
                    ((!lm.oceanbugthirdgameObjects.isEmpty() && lm.oceanbugthirdgameObjects.get(0).condition.matches("thirdcondtion"))
                            || (!lm.oceanbugthirdgameObjects.isEmpty() && lm.oceanbugthirdgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.oceanbugthirdgameObjects, oceanbug);
                deletearrayFood.add(oceanbug);


            }

            else if(oceanbug.getVisible()) {

                checkcollitioncondition(50, oceanbug, lm.oceanbugthirdgameObjects, deletearrayFood);
            }

        }


        if(!lm.oceanbugthirdgameObjects.isEmpty() &&
                lm.oceanbugthirdgameObjects.get(0).enemyValue != null &&
                lm.oceanbugthirdgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.oceanbugthirdgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.oceanbugthirdgameObjects.get(0).enemyValue);
        }




        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.oceanbugthirdgameObjects, deletearrayFood);

        }

    }


    void  oceanbugfourthHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject oceanbug : lm.oceanbugfourthgameObjects) {


            oceanbug.setHitBoxPosition(lm.BeginX + oceanbug.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + oceanbug.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!oceanbug.getVisible() &&
                    ((!lm.oceanbugfourthgameObjects.isEmpty() && lm.oceanbugfourthgameObjects.get(0).condition.matches("fourthcondtion"))
                            || (!lm.oceanbugfourthgameObjects.isEmpty() && lm.oceanbugfourthgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.oceanbugfourthgameObjects, oceanbug);
                deletearrayFood.add(oceanbug);


            }

            else if(oceanbug.getVisible()) {

                checkcollitioncondition(50, oceanbug, lm.oceanbugfourthgameObjects, deletearrayFood);

            }
        }


        if(!lm.oceanbugfourthgameObjects.isEmpty() &&
                lm.oceanbugfourthgameObjects.get(0).enemyValue != null &&
                lm.oceanbugfourthgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.oceanbugfourthgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.oceanbugfourthgameObjects.get(0).enemyValue);
        }




        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.oceanbugfourthgameObjects, deletearrayFood);

        }

    }



    void swirlwaterHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject swirlwater : lm.swirlwatergameObjects) {


            swirlwater.setHitBoxPosition(lm.BeginX + swirlwater.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + swirlwater.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, swirlwater, lm.swirlwatergameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.swirlwatergameObjects, deletearrayFood);
      
            
        }

        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderswirlwatergameObjects, lm.notesonghostspindergameObjects);
        }

        
    }

    void swirlwatersecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject swirlwater : lm.swirlwatersecondgameObjects) {


            swirlwater.setHitBoxPosition(lm.BeginX + swirlwater.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + swirlwater.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, swirlwater, lm.swirlwatersecondgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.swirlwatersecondgameObjects, deletearrayFood);

        }


        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspindersecondswirlwatergameObjects, lm.notesonghostspindergameObjects);
        }


    }

    void swirlwaterthirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject swirlwater : lm.swirlwaterthirdgameObjects) {


            swirlwater.setHitBoxPosition(lm.BeginX + swirlwater.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + swirlwater.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, swirlwater, lm.swirlwaterthirdgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.swirlwaterthirdgameObjects, deletearrayFood);

        }


        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderthirdswirlwatergameObjects, lm.notesonghostspindergameObjects);
        }

    }

    void stargravHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject stargrav : lm.stargravgameObjects) {


            stargrav.setHitBoxPosition(lm.BeginX + stargrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + stargrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, stargrav, lm.stargravgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.stargravgameObjects, deletearrayFood);

        }



        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderstargravgameObjects, lm.notesonghostspindergameObjects);
        }



    }

    void stargravsecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject stargrav : lm.stargravsecondgameObjects) {


            stargrav.setHitBoxPosition(lm.BeginX + stargrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + stargrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, stargrav, lm.stargravsecondgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.stargravsecondgameObjects, deletearrayFood);

        }


        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspindersecondstargravgameObjects, lm.notesonghostspindergameObjects);
        }


    }

    void stargravthirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject stargrav : lm.stargravthirdgameObjects) {


            stargrav.setHitBoxPosition(lm.BeginX + stargrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + stargrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(250, stargrav, lm.stargravthirdgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.stargravthirdgameObjects, deletearrayFood);

        }


        if(!lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderthirdstargravgameObjects, lm.notesonghostspindergameObjects);
        }


    }

    
    void splashflyHitBox(ArrayList<GameObject> deletearrayFood){

        for(int x = 0; x < lm.splashflygameObjects.size(); x++) {

                lm.splashflygameObjects.get(x).setHitBoxPosition(lm.BeginX +
                                lm.splashflygameObjects.get(x).currentxWorld
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + lm.splashflygameObjects.get(x).currentyWorld
                                - lm.bgLandscape.getyVelocity());

                checkcollitioncondition(10, lm.splashflygameObjects.get(x),
                        lm.splashflygameObjects, deletearrayFood);



            }
        }

    

    void  waterdropHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject waterdrop : lm.waterdropgameObjects) {


            waterdrop.setHitBoxPosition(lm.BeginX + waterdrop.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + waterdrop.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(50, waterdrop, lm.waterdropgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.waterdropgameObjects, deletearrayFood);

        }

    }

    void smalllavafishHitBox() {

        for (GameObject smalllavafish : lm.smalllavafishgameObjects) {
            if(smalllavafish.getVisible()) {
                smalllavafish.setHitBoxPosition((lm.BeginX + smalllavafish.currentxWorld)
                                - lm.bgLandscape.getxVelocity(),
                        (lm.BeginY + smalllavafish.currentyWorld)
                                - lm.bgLandscape.getyVelocity());


                if (lm.frogFungiPlayer.checkCollisions(smalllavafish.getrectHitboxtop())
                        || lm.frogFungiPlayer.checkCollisions(smalllavafish.getrectHitboxright())
                        || lm.frogFungiPlayer.checkCollisions(smalllavafish.getrectHitboxbottom())
                        || lm.frogFungiPlayer.checkCollisions(smalllavafish.getrectHitboxleft())) {


                    smalllavafish.setVisible(false);
                    frogFungiPlayerState.addPrey(1);

                }
            }
        }

    }

   void biglavafishHitBox(){
       for (GameObject biglavafish : lm.biglavafishgameObjects) {
           if(biglavafish.getVisible()) {
               biglavafish.setHitBoxPosition((lm.BeginX + biglavafish.currentxWorld)
                               - lm.bgLandscape.getxVelocity(),
                       (lm.BeginY + biglavafish.currentyWorld)
                               - lm.bgLandscape.getyVelocity());


               if (lm.frogFungiPlayer.checkCollisions(biglavafish.getrectHitboxtop())
                       || lm.frogFungiPlayer.checkCollisions(biglavafish.getrectHitboxright())
                       || lm.frogFungiPlayer.checkCollisions(biglavafish.getrectHitboxbottom())
                       || lm.frogFungiPlayer.checkCollisions(biglavafish.getrectHitboxleft())) {

                   biglavafish.setVisible(false);
                   frogFungiPlayerState.addPrey(5);

               }
           }
       }

   }


    void rockbeegravHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbeegrav : lm.rockbeegravgameObjects) {


            rockbeegrav.setHitBoxPosition(lm.BeginX + rockbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(10, rockbeegrav, lm.rockbeegravgameObjects, deletearrayFood);

        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbeegravgameObjects, deletearrayFood);

        }
    }

    void rockbeegravsecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbeegrav : lm.rockbeegravsecondgameObjects) {


            rockbeegrav.setHitBoxPosition(lm.BeginX + rockbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!rockbeegrav.getVisible() &&
                    ((!lm.rockbeegravsecondgameObjects.isEmpty() && lm.rockbeegravsecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.rockbeegravsecondgameObjects.isEmpty() && lm.rockbeegravsecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbeegravsecondgameObjects, rockbeegrav);
                deletearrayFood.add(rockbeegrav);


            }

            else if(rockbeegrav.getVisible()) {

                checkcollitioncondition(10, rockbeegrav, lm.rockbeegravsecondgameObjects, deletearrayFood);
            }
        }

        if(!lm.rockbeegravsecondgameObjects.isEmpty() &&
                lm.rockbeegravsecondgameObjects.get(0).enemyValue != null &&
                lm.rockbeegravsecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbeegravsecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbeegravsecondgameObjects.get(0).enemyValue);
        }





        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbeegravsecondgameObjects, deletearrayFood);

        }
    }

    void rockbeegravthirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbeegrav : lm.rockbeegravthirdgameObjects) {


            rockbeegrav.setHitBoxPosition(lm.BeginX + rockbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!rockbeegrav.getVisible() &&
                    ((!lm.rockbeegravthirdgameObjects.isEmpty() && lm.rockbeegravthirdgameObjects.get(0).condition.matches("thirdcondtion"))
                            || (!lm.rockbeegravthirdgameObjects.isEmpty() && lm.rockbeegravthirdgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbeegravthirdgameObjects, rockbeegrav);
                deletearrayFood.add(rockbeegrav);


            }

            else if(rockbeegrav.getVisible()) {

                checkcollitioncondition(10, rockbeegrav, lm.rockbeegravthirdgameObjects, deletearrayFood);
            }
        }


        if(!lm.rockbeegravthirdgameObjects.isEmpty() &&
                lm.rockbeegravthirdgameObjects.get(0).enemyValue != null &&
                lm.rockbeegravthirdgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbeegravthirdgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbeegravthirdgameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbeegravthirdgameObjects, deletearrayFood);

        }
    }

    void rockbeegravfourthHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbeegrav : lm.rockbeegravfourthgameObjects) {


            rockbeegrav.setHitBoxPosition(lm.BeginX + rockbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!rockbeegrav.getVisible() &&
                    ((!lm.rockbeegravfourthgameObjects.isEmpty() && lm.rockbeegravfourthgameObjects.get(0).condition.matches("fourthcondtion"))
                            || (!lm.rockbeegravfourthgameObjects.isEmpty() && lm.rockbeegravfourthgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbeegravfourthgameObjects, rockbeegrav);
                deletearrayFood.add(rockbeegrav);


            }

            else if(rockbeegrav.getVisible()) {

                checkcollitioncondition(10, rockbeegrav, lm.rockbeegravfourthgameObjects, deletearrayFood);
            }
        }


        if(!lm.rockbeegravfourthgameObjects.isEmpty() &&
                lm.rockbeegravfourthgameObjects.get(0).enemyValue != null &&
                lm.rockbeegravfourthgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbeegravfourthgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbeegravfourthgameObjects.get(0).enemyValue);
        }





        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbeegravfourthgameObjects, deletearrayFood);

        }
    }


    void rockbigbeegravHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbigbeegrav : lm.rockbigbeegravgameObjects) {


            rockbigbeegrav.setHitBoxPosition(lm.BeginX + rockbigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

                checkcollitioncondition(20, rockbigbeegrav, lm.rockbigbeegravgameObjects, deletearrayFood);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbigbeegravgameObjects, deletearrayFood);

        }
    }

    void rockbigbeegravsecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbigbeegrav : lm.rockbigbeegravsecondgameObjects) {


            rockbigbeegrav.setHitBoxPosition(lm.BeginX + rockbigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!rockbigbeegrav.getVisible() &&
                    ((!lm.rockbigbeegravsecondgameObjects.isEmpty() && lm.rockbigbeegravsecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.rockbigbeegravsecondgameObjects.isEmpty() && lm.rockbigbeegravsecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbigbeegravsecondgameObjects, rockbigbeegrav);
                deletearrayFood.add(rockbigbeegrav);


            }

            else if(rockbigbeegrav.getVisible()) {

                checkcollitioncondition(20, rockbigbeegrav, lm.rockbigbeegravsecondgameObjects, deletearrayFood);
            }
        }

        if(!lm.rockbigbeegravsecondgameObjects.isEmpty() &&
                lm.rockbigbeegravsecondgameObjects.get(0).enemyValue != null &&
                lm.rockbigbeegravsecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbigbeegravsecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbigbeegravsecondgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbigbeegravsecondgameObjects, deletearrayFood);

        }
    }


    void rockbigbeegravthirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbigbeegrav : lm.rockbigbeegravthirdgameObjects) {


            rockbigbeegrav.setHitBoxPosition(lm.BeginX + rockbigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!rockbigbeegrav.getVisible() &&
                    ((!lm.rockbigbeegravthirdgameObjects.isEmpty() && lm.rockbigbeegravthirdgameObjects.get(0).condition.matches("secondcondtion"))
        || (!lm.rockbigbeegravthirdgameObjects.isEmpty() && lm.rockbigbeegravthirdgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbigbeegravthirdgameObjects, rockbigbeegrav);
                deletearrayFood.add(rockbigbeegrav);


            }

            else if(rockbigbeegrav.getVisible()) {
                checkcollitioncondition(20, rockbigbeegrav, lm.rockbigbeegravthirdgameObjects, deletearrayFood);
            }
        }

        if(!lm.rockbigbeegravthirdgameObjects.isEmpty() &&
                lm.rockbigbeegravthirdgameObjects.get(0).enemyValue != null &&
                lm.rockbigbeegravthirdgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbigbeegravthirdgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbigbeegravthirdgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbigbeegravthirdgameObjects, deletearrayFood);

        }
    }



    void rockbigbeegravfourthHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject rockbigbeegrav : lm.rockbigbeegravfourthgameObjects) {


            rockbigbeegrav.setHitBoxPosition(lm.BeginX + rockbigbeegrav.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + rockbigbeegrav.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!rockbigbeegrav.getVisible() &&
                    ((!lm.rockbigbeegravfourthgameObjects.isEmpty() && lm.rockbigbeegravfourthgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.rockbigbeegravfourthgameObjects.isEmpty() && lm.rockbigbeegravfourthgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.rockbigbeegravfourthgameObjects, rockbigbeegrav);
                deletearrayFood.add(rockbigbeegrav);


            }

            else if(rockbigbeegrav.getVisible()) {


                checkcollitioncondition(20, rockbigbeegrav, lm.rockbigbeegravfourthgameObjects, deletearrayFood);
            }
        }

        if(!lm.rockbigbeegravfourthgameObjects.isEmpty() &&
                lm.rockbigbeegravfourthgameObjects.get(0).enemyValue != null &&
                lm.rockbigbeegravfourthgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.rockbigbeegravfourthgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.rockbigbeegravfourthgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.rockbigbeegravfourthgameObjects, deletearrayFood);

        }
    }
    
    
    
    void dustrockbeegravlavaHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavagameObjects) {


            dustrockbeegravlava.setHitBoxPosition(lm.BeginX + dustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(10, dustrockbeegravlava, lm.dustrockbeegravlavagameObjects, deletearrayFood);

        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.dustrockbeegravlavagameObjects, deletearrayFood);
        }
    }


    void dustrockbeegravlavasecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavasecondgameObjects) {


            dustrockbeegravlava.setHitBoxPosition(lm.BeginX + dustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            if(!dustrockbeegravlava.getVisible() &&
                    ((!lm.dustrockbeegravlavasecondgameObjects.isEmpty() && lm.dustrockbeegravlavasecondgameObjects.get(0).condition.matches("secondcondtion"))
                            || (!lm.dustrockbeegravlavasecondgameObjects.isEmpty() && lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.dustrockbeegravlavasecondgameObjects, dustrockbeegravlava);
                deletearrayFood.add(dustrockbeegravlava);


            }

            else if(dustrockbeegravlava.getVisible()) {

                checkcollitioncondition(10, dustrockbeegravlava, lm.dustrockbeegravlavasecondgameObjects, deletearrayFood);
            }
        }

        if(!lm.dustrockbeegravlavasecondgameObjects.isEmpty() &&
                lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue != null &&
                lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.dustrockbeegravlavasecondgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.dustrockbeegravlavasecondgameObjects, deletearrayFood);
        }
    }

    void dustrockbeegravlavathirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavathirdgameObjects) {


            dustrockbeegravlava.setHitBoxPosition(lm.BeginX + dustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());



            if(!dustrockbeegravlava.getVisible() &&
                    ((!lm.dustrockbeegravlavathirdgameObjects.isEmpty() && lm.dustrockbeegravlavathirdgameObjects.get(0).condition.matches("thirdcondtion"))
                            || (!lm.dustrockbeegravlavathirdgameObjects.isEmpty() && lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.dustrockbeegravlavathirdgameObjects, dustrockbeegravlava);
                deletearrayFood.add(dustrockbeegravlava);


            }

            else if(dustrockbeegravlava.getVisible()) {

                checkcollitioncondition(10, dustrockbeegravlava, lm.dustrockbeegravlavathirdgameObjects, deletearrayFood);
            }
        }


        if(!lm.dustrockbeegravlavathirdgameObjects.isEmpty() &&
                lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue != null &&
                lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.dustrockbeegravlavathirdgameObjects.get(0).enemyValue);
        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.dustrockbeegravlavathirdgameObjects, deletearrayFood);
        }
    }


    void dustrockbeegravlavafourthHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject dustrockbeegravlava : lm.dustrockbeegravlavafourthgameObjects) {


            dustrockbeegravlava.setHitBoxPosition(lm.BeginX + dustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            if(!dustrockbeegravlava.getVisible() &&
                    ((!lm.dustrockbeegravlavafourthgameObjects.isEmpty() && lm.dustrockbeegravlavafourthgameObjects.get(0).condition.matches("fourthcondtion"))
                            || (!lm.dustrockbeegravlavafourthgameObjects.isEmpty() && lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue == null))) {

                checkfirstcondition(lm.dustrockbeegravlavafourthgameObjects, dustrockbeegravlava);
                deletearrayFood.add(dustrockbeegravlava);


            }

            else if(dustrockbeegravlava.getVisible()) {

                checkcollitioncondition(10, dustrockbeegravlava, lm.dustrockbeegravlavafourthgameObjects, deletearrayFood);
            }
        }


        if(!lm.dustrockbeegravlavafourthgameObjects.isEmpty() &&
                lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue != null &&
                lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue.bugPositiondelete.size() > 0 &&
                lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue.bugPositionadderdelete.size() > 0){

            checkdeletebugPositionarray(lm.dustrockbeegravlavafourthgameObjects.get(0).enemyValue);
        }



        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.dustrockbeegravlavafourthgameObjects, deletearrayFood);
        }
    }




    void fungilavaHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject fungilava : lm.fungilavagameObjects) {


            fungilava.setHitBoxPosition(lm.BeginX + fungilava.currentxWorld - lm.bgLandscape.getbackgroundxResolution() / 2
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + fungilava.currentyWorld - lm.bgLandscape.getbackgroundyResolution() / 2
                            - lm.bgLandscape.getyVelocity()
            );


            checkcollitioncondition(100, fungilava, lm.fungilavagameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.fungilavagameObjects, deletearrayFood);
        }
    }

    void jumpingratlavaHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject jumpingratlava : lm.jumpingratlavagameObjects) {


            jumpingratlava.setHitBoxPosition(lm.BeginX + jumpingratlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + jumpingratlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(100, jumpingratlava, lm.jumpingratlavagameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.jumpingratlavagameObjects, deletearrayFood);

        }
    }


    void transparentchubHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject transparentchub : lm.transparentchubgameObjects) {


            transparentchub.setHitBoxPosition(lm.BeginX + transparentchub.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + transparentchub.currentyWorld
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(100, transparentchub, lm.transparentchubgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.transparentchubgameObjects, deletearrayFood);
        }
    }


    void barkbugHitBox(ArrayList<GameObject> deletearrayFood) {

        for (GameObject barkbug : lm.barkbuggameObjects) {


            barkbug.setHitBoxPosition(lm.BeginX + barkbug.currentxWorld +
                            lm.bgLandscape.fungiArray[lm.arraylistofbarkbugposition[barkbug.barkbugIndex] * 2]
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + barkbug.currentyWorld +
                            lm.bgLandscape.fungiArray[(lm.arraylistofbarkbugposition[barkbug.barkbugIndex] * 2) + 1]
                            - lm.bgLandscape.getyVelocity());


            checkcollitioncondition(10, barkbug, lm.barkbuggameObjects, deletearrayFood);

        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.barkbuggameObjects, deletearrayFood);
        }

    }


    void lavadropHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject lavadrop : lm.lavadropgameObjects) {


            lavadrop.setHitBoxPosition(lm.BeginX + lavadrop.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + lavadrop.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(50, lavadrop, lm.lavadropgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.lavadropgameObjects, deletearrayFood);

        }

    }


    void bigdustrockbeegravlavaHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavagameObjects) {


            bigdustrockbeegravlava.setHitBoxPosition(lm.BeginX + bigdustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigdustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, bigdustrockbeegravlava, lm.bigdustrockbeegravlavagameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigdustrockbeegravlavagameObjects, deletearrayFood);


        }

        if(lm.notesonghostspindergameObjects != null && !lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderbigdustrockbeegravlavagameObjects, lm.notesonghostspindergameObjects);
        }


    }

    void bigdustrockbeegravlavasecondHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavasecondgameObjects) {


            bigdustrockbeegravlava.setHitBoxPosition(lm.BeginX + bigdustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigdustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, bigdustrockbeegravlava, lm.bigdustrockbeegravlavasecondgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigdustrockbeegravlavasecondgameObjects, deletearrayFood);


        }

        if(lm.notesonghostspindergameObjects != null && !lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspindersecondbigdustrockbeegravlavagameObjects, lm.notesonghostspindergameObjects);
        }


    }


    void bigdustrockbeegravlavathirdHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavathirdgameObjects) {


            bigdustrockbeegravlava.setHitBoxPosition(lm.BeginX + bigdustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigdustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, bigdustrockbeegravlava, lm.bigdustrockbeegravlavathirdgameObjects, deletearrayFood);


        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigdustrockbeegravlavathirdgameObjects, deletearrayFood);


        }

        if(lm.notesonghostspindergameObjects != null && !lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderthirdbigdustrockbeegravlavagameObjects, lm.notesonghostspindergameObjects);
        }


    }



    void bigdustrockbeegravlavafourthHitBox(ArrayList<GameObject> deletearrayFood){
        for (GameObject bigdustrockbeegravlava : lm.bigdustrockbeegravlavafourthgameObjects) {


            bigdustrockbeegravlava.setHitBoxPosition(lm.BeginX + bigdustrockbeegravlava.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + bigdustrockbeegravlava.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, bigdustrockbeegravlava, lm.bigdustrockbeegravlavafourthgameObjects, deletearrayFood);


        }


        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.bigdustrockbeegravlavafourthgameObjects, deletearrayFood);


        }

        if(lm.notesonghostspindergameObjects != null && !lm.notesonghostspindergameObjects.isEmpty()){
            checkdeletearrayghostspinder(lm.ghostspinderfourthbigdustrockbeegravlavagameObjects, lm.notesonghostspindergameObjects);
        }


    }

    void dustbulletHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject dustbullet : lm.dustbulletgameObjects) {


            dustbullet.setHitBoxPosition(lm.BeginX + dustbullet.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustbullet.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, dustbullet, lm.dustbulletgameObjects, deletearrayFood);


        }

    }

    void dustbulletsecondHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject dustbullet : lm.dustbulletsecondgameObjects) {


            dustbullet.setHitBoxPosition(lm.BeginX + dustbullet.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustbullet.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, dustbullet, lm.dustbulletsecondgameObjects, deletearrayFood);


        }

    }


    void dustbulletthirdHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject dustbullet : lm.dustbulletthirdgameObjects) {


            dustbullet.setHitBoxPosition(lm.BeginX + dustbullet.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustbullet.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, dustbullet, lm.dustbulletthirdgameObjects, deletearrayFood);


        }

    }


    void dustbulletfourthHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject dustbullet : lm.dustbulletfourthgameObjects) {


            dustbullet.setHitBoxPosition(lm.BeginX + dustbullet.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + dustbullet.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, dustbullet, lm.dustbulletfourthgameObjects, deletearrayFood);


        }

    }



    void lavafurHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject lavafur : lm.lavafurgameObjects) {


            lavafur.setHitBoxPosition(lm.BeginX + lavafur.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + lavafur.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, lavafur, lm.lavafurgameObjects, deletearrayFood);


        }

        if (!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.lavafurgameObjects, deletearrayFood);


        }
    }


    void gravitycloudHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject gravitycloud : lm.gravitycloudgameObjects) {


            gravitycloud.setHitBoxPosition(lm.BeginX + gravitycloud.currentxWorld
                            - lm.bgLandscape.getxVelocity(),
                    lm.BeginY + gravitycloud.currentyWorld
                            - lm.bgLandscape.getyVelocity());

            checkcollitioncondition(300, gravitycloud, lm.gravitycloudgameObjects, deletearrayFood);


        }

        if (!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.gravitycloudgameObjects, deletearrayFood);


        }
    }



    void redbubbleHitBox(ArrayList<GameObject> deletearrayFood) {
        for (GameObject redbubble : lm.redbubblegameObjects) {


            if(!redbubble.condition.matches("deadcondition")) {


                redbubble.setHitBoxPosition(lm.BeginX + redbubble.currentxWorld
                                - lm.bgLandscape.getxVelocity(),
                        lm.BeginY + redbubble.currentyWorld
                                - lm.bgLandscape.getyVelocity());


                checkcollitioncondition(1000, redbubble, lm.redbubblegameObjects, deletearrayFood);
            }

        }

        if(!deletearrayFood.isEmpty()) {

            checkdeletearrayFood(lm.redbubblegameObjects, deletearrayFood);
        }

    }


        Integer[] preciserandom(Integer[] integerarray, boolean needgetonlyx) {

            Integer[] integerarrayonlyx = new Integer[integerarray.length / 2];


            if (needgetonlyx == true) {
                for (int d = 0; d < integerarray.length; d = d + 2) {
                    integerarrayonlyx[d / 2] = integerarray[d];
                }
            }

            else if(needgetonlyx == false){

                integerarrayonlyx = new Integer[integerarray.length];
                integerarrayonlyx = integerarray;
            }

            Integer[] arrayofrandhalf = new Integer[integerarrayonlyx.length / 2];
            Integer[] arrayofrandhalfsecond = new Integer[integerarrayonlyx.length / 2];
            Integer[] arrayofquarterfirst = new Integer[1];
            Integer[] arrayofquartersecond = new Integer[1];
            Integer[] arrayofquarterthird = new Integer[1];
            Integer[] arrayofquarterfourth = new Integer[1];
            Integer[] arrayofresult = new Integer[1];
            Integer[] arrayoffirstrand = new Integer[1];
            Integer[] arrayofsecondrand = new Integer[1];




            if (integerarrayonlyx.length != 0 && ((integerarrayonlyx.length % 2) == 0)) {



                for (int x = 0; x < integerarrayonlyx.length / 2; x++) {

                    arrayofrandhalf[x] = integerarrayonlyx[x];

                }

                for (int y = integerarrayonlyx.length / 2; y < integerarrayonlyx.length; y++) {
                    arrayofrandhalfsecond[y - (integerarrayonlyx.length / 2)] = integerarrayonlyx[y];
                }


                if (arrayofrandhalf.length > 1 && ((arrayofrandhalf.length % 2) == 0)) {
                    arrayofquarterfirst = new Integer[arrayofrandhalf.length / 2];
                    arrayofquartersecond = new Integer[arrayofrandhalf.length / 2];


                    for (int x = 0; x < arrayofrandhalf.length / 2; x++) {

                        arrayofquarterfirst[x] = arrayofrandhalf[x];

                    }

                    for (int y = arrayofrandhalf.length / 2; y < arrayofrandhalf.length; y++) {
                        arrayofquartersecond[y - (arrayofrandhalf.length / 2)] = arrayofrandhalf[y];
                    }
                }

                else if (arrayofrandhalf.length > 1 && ((arrayofrandhalf.length % 2) != 0)) {
                    arrayofquarterfirst = new Integer[(arrayofrandhalf.length - 1)/2];
                    arrayofquartersecond = new Integer[arrayofrandhalf.length - ((arrayofrandhalf.length - 1)/2)];



                    for (int x = 0; x < ((arrayofrandhalf.length - 1)/ 2); x++) {

                        arrayofquarterfirst[x] = arrayofrandhalf[x];

                    }

                    for (int y = (arrayofrandhalf.length - 1)/ 2; y < arrayofrandhalf.length; y++) {
                        arrayofquartersecond[y - ((arrayofrandhalf.length - 1)/ 2)] = arrayofrandhalf[y];
                    }

                }



                if (arrayofrandhalfsecond.length > 1 && ((arrayofrandhalfsecond.length % 2) == 0)) {
                    arrayofquarterthird = new Integer[arrayofrandhalfsecond.length / 2];
                    arrayofquarterfourth = new Integer[arrayofrandhalfsecond.length / 2];


                    for (int a = 0; a < (arrayofrandhalfsecond.length / 2); a++) {

                        arrayofquarterthird[a] = arrayofrandhalfsecond[a];

                    }

                    for (int b = arrayofrandhalfsecond.length / 2; b < arrayofrandhalfsecond.length; b++) {
                        arrayofquarterfourth[b - (arrayofrandhalfsecond.length/2)] = arrayofrandhalfsecond[b];
                    }


                }


                else if (arrayofrandhalfsecond.length > 1 && ((arrayofrandhalfsecond.length % 2) != 0)) {

                    arrayofquarterthird = new Integer[(arrayofrandhalfsecond.length - 1)/2];
                    arrayofquarterfourth = new Integer[arrayofrandhalfsecond.length - ((arrayofrandhalfsecond.length - 1)/2)];


                    for (int a = 0; a < (arrayofrandhalfsecond.length -1) / 2; a++) {

                        arrayofquarterthird[a] = arrayofrandhalfsecond[a];

                    }

                    for (int b = (arrayofrandhalfsecond.length - 1) / 2; b < arrayofrandhalfsecond.length; b++) {
                        arrayofquarterfourth[b - ((arrayofrandhalfsecond.length - 1)/ 2)] = arrayofrandhalfsecond[b];
                    }


                }




            }

            else if(integerarrayonlyx.length != 0 && ((integerarrayonlyx.length % 2) != 0)) {

                arrayofrandhalf = new Integer[(integerarrayonlyx.length - 1)/2];
                arrayofrandhalfsecond = new Integer[integerarrayonlyx.length - ((integerarrayonlyx.length - 1)/2)];


                for (int x = 0; x < (integerarrayonlyx.length - 1)/ 2; x++) {

                    arrayofrandhalf[x] = integerarrayonlyx[x];

                }

                for (int y = (integerarrayonlyx.length - 1)/ 2; y < integerarrayonlyx.length; y++) {
                    arrayofrandhalfsecond[y - ((integerarrayonlyx.length - 1)/ 2)] = integerarrayonlyx[y];
                }


                if (arrayofrandhalf.length > 1 && ((arrayofrandhalf.length % 2) == 0)) {
                    arrayofquarterfirst = new Integer[arrayofrandhalf.length / 2];
                    arrayofquartersecond = new Integer[arrayofrandhalf.length / 2];


                    for (int x = 0; x < arrayofrandhalf.length / 2; x++) {

                        arrayofquarterfirst[x] = arrayofrandhalf[x];

                    }

                    for (int y = arrayofrandhalf.length / 2; y < arrayofrandhalf.length; y++) {
                        arrayofquartersecond[y - (arrayofrandhalf.length / 2)] = arrayofrandhalf[y];
                    }
                }

                   else if (arrayofrandhalf.length > 1 && ((arrayofrandhalf.length % 2) != 0)) {
                    arrayofquarterfirst = new Integer[(arrayofrandhalf.length - 1)/2];
                    arrayofquartersecond = new Integer[arrayofrandhalf.length - ((arrayofrandhalf.length - 1)/2)];



                    for (int x = 0; x < ((arrayofrandhalf.length - 1)/ 2); x++) {

                            arrayofquarterfirst[x] = arrayofrandhalf[x];

                        }

                        for (int y = (arrayofrandhalf.length - 1)/ 2; y < arrayofrandhalf.length; y++) {
                            arrayofquartersecond[y - ((arrayofrandhalf.length - 1)/ 2)] = arrayofrandhalf[y];
                        }

                    }



                    if (arrayofrandhalfsecond.length > 1 && ((arrayofrandhalfsecond.length % 2) == 0)) {
                        arrayofquarterthird = new Integer[arrayofrandhalfsecond.length / 2];
                        arrayofquarterfourth = new Integer[arrayofrandhalfsecond.length / 2];


                        for (int a = 0; a < (arrayofrandhalfsecond.length / 2); a++) {

                        arrayofquarterthird[a] = arrayofrandhalfsecond[a];

                    }

                    for (int b = arrayofrandhalfsecond.length / 2; b < arrayofrandhalfsecond.length; b++) {
                        arrayofquarterfourth[b - (arrayofrandhalfsecond.length/2)] = arrayofrandhalfsecond[b];
                    }


                }


                   else if (arrayofrandhalfsecond.length > 1 && ((arrayofrandhalfsecond.length % 2) != 0)) {

                        arrayofquarterthird = new Integer[(arrayofrandhalfsecond.length - 1)/2];
                        arrayofquarterfourth = new Integer[arrayofrandhalfsecond.length - ((arrayofrandhalfsecond.length - 1)/2)];


                        for (int a = 0; a < (arrayofrandhalfsecond.length -1) / 2; a++) {

                            arrayofquarterthird[a] = arrayofrandhalfsecond[a];

                        }

                        for (int b = (arrayofrandhalfsecond.length - 1) / 2; b < arrayofrandhalfsecond.length; b++) {
                            arrayofquarterfourth[b - ((arrayofrandhalfsecond.length - 1)/ 2)] = arrayofrandhalfsecond[b];
                        }


                    }


            }


            if (arrayofquarterfirst.length != 0 && arrayofquarterfirst != null) {

                arrayofresult = new Integer[arrayofquarterfirst.length + arrayofquartersecond.length + arrayofquarterthird.length + arrayofquarterfourth.length];

                for (int a = 0; a < arrayofquarterthird.length; a++) {

                    arrayofresult[a] = arrayofquarterthird[a];

                }

                for (int b = arrayofquarterthird.length; b < arrayofquarterthird.length + arrayofquarterfourth.length; b++) {
                    arrayofresult[b] = arrayofquarterfourth[b - arrayofquarterthird.length];
                }


                for (int c = arrayofquarterthird.length + arrayofquarterfourth.length;
                     c < arrayofquarterthird.length + arrayofquarterfourth.length + arrayofquarterfirst.length; c++) {
                    arrayofresult[c] = arrayofquarterfirst[c - (arrayofquarterthird.length + arrayofquarterfourth.length)];
                }


                for (int d = arrayofquarterthird.length + arrayofquarterfourth.length + arrayofquarterfirst.length;
                     d < arrayofquarterthird.length + arrayofquarterfourth.length + arrayofquarterfirst.length +
                             arrayofquartersecond.length; d++) {
                    arrayofresult[d] = arrayofquartersecond[d - (arrayofquarterthird.length + arrayofquarterfourth.length + arrayofquarterfirst.length)];
                }
            }

            if(arrayofresult.length != 0 && arrayofresult != null){
                Random rand = new Random();

                   int randresult = rand.nextInt(arrayofresult.length - 1);

                if(randresult != 0){
                    arrayoffirstrand = new Integer[randresult];
                    arrayofsecondrand = new Integer[arrayofresult.length - randresult];


                    for(int k = 0; k < arrayoffirstrand.length; k++){
                        arrayoffirstrand[k] = arrayofresult[k];
                    }

                    for(int l = arrayoffirstrand.length; l < arrayoffirstrand.length + arrayofsecondrand.length; l++){
                        arrayofsecondrand[l - arrayoffirstrand.length] = arrayofresult[l];
                    }

                    for(int m = 0; m < arrayofsecondrand.length; m++){
                        arrayofresult[m] = arrayofsecondrand[m];
                    }


                    for(int n = arrayofsecondrand.length; n < arrayofresult.length; n++){
                        arrayofresult[n] = arrayoffirstrand[n - arrayofsecondrand.length];
                    }

                }

            }


            return arrayofresult;

    }


    void enemyvaluesinitialize(ArrayList<GameObject> arrayofenemies, GameObject gameobject, String arrayofenemieschar){
        if (arrayofenemies.indexOf(gameobject) == 0) {
            gameobject.enemyValue = new Values();
            gameobject.enemyValue.lengthofcomparisonarr = arrayofenemieschar.length();

        }

    }




    void enemysequencePattern(ArrayList<GameObject> enemyarray, GameObject gameObject, float gameObjectspeed){


        if (enemyarray.indexOf(gameObject) == 0 && gameObject.enemyValue != null &&
                enemyarray.size() == gameObject.enemyValue.lengthofcomparisonarr){

            if((gameObject instanceof BigBeeGrav) || (gameObject instanceof RockBigBeeGrav)) {

                gameObject.updateEnemyLevelTwo(fps * gameObjectspeed, lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution() / 2,
                        lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + lm.bgLandscape.getbackgroundxResolution() / 2,
                        lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.bgLandscape.getbackgroundyResolution() / 2);

            }

            else {

                gameObject.updateEnemyLevelTwo(fps * gameObjectspeed, lm.frogFungiPlayer.currentxWorld,
                        lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2), 0, 0);


            }

            if (gameObject.getxVelocity() != 0) {
                gameObject.currentxWorld = gameObject.getWorldLocation().x - lm.BeginX
                        + gameObject.getSavedxvelocity() + gameObject.getxVelocity();
            }


            if (gameObject.getyVelocity() != 0) {
                gameObject.currentyWorld = gameObject.getWorldLocation().y - lm.BeginY
                        + gameObject.getSavedyvelocity() + gameObject.getyVelocity();
            }


            if (gameObject.condition.matches("initialcondition")) {


                gameObject.enemyValue.bugPosition.set(1, gameObject.currentyWorld);

                gameObject.enemyValue.bugPosition.set(0, gameObject.currentxWorld);

                if ((((gameObject.enemyValue.bugPosition.get(2) + gameObject.getBitmapWidth() / 2) -
                        (gameObject.enemyValue.bugPosition.get(0) + gameObject.getBitmapWidth() / 2))
                        * ((gameObject.enemyValue.bugPosition.get(2) + gameObject.getBitmapWidth() / 2) -
                        (gameObject.enemyValue.bugPosition.get(0) + gameObject.getBitmapWidth() / 2))) +

                        (((gameObject.enemyValue.bugPosition.get(3) + gameObject.getBitmapHeight() / 2) -
                                (gameObject.enemyValue.bugPosition.get(1) + gameObject.getBitmapHeight() / 2))
                                * ((gameObject.enemyValue.bugPosition.get(3) + gameObject.getBitmapHeight() / 2) -
                                (gameObject.enemyValue.bugPosition.get(1) + gameObject.getBitmapHeight() / 2)))
                        > ((gameObject.getBitmapWidth() * gameObject.getBitmapWidth()) +
                        (gameObject.getBitmapHeight() * gameObject.getBitmapHeight()))

                        ) {


                    gameObject.condition = "firstcondition";
                }

            } else if (gameObject.condition.matches("firstcondition")) {

                gameObject.firstconditionposx = gameObject.enemyValue.bugPosition.get(0) - gameObject.currentxWorld;
                gameObject.firstconditionposy = gameObject.enemyValue.bugPosition.get(1) - gameObject.currentyWorld;


                gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposy);


                gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposx);


                if (gameObject.enemyValue.bugPositionadder.size() < 4) {


                    gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposy);

                    gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposx);
                }


                for (int x = gameObject.enemyValue.y; x < gameObject.enemyValue.bugPositionadder.size(); x = x + 2) {

                    if (gameObject.condition.matches("firstcondition")) {

                        gameObject.enemyValue.bugPositionadder.remove(gameObject.enemyValue.bugPositionadder.size() - 1);
                        gameObject.enemyValue.bugPositionadder.remove(gameObject.enemyValue.bugPositionadder.size() - 1);


                        if ((((gameObject.enemyValue.bugPosition.get(x) + gameObject.getBitmapWidth() / 2)
                                - ((gameObject.enemyValue.bugPosition.get(x - 2) - gameObject.enemyValue.bugPositionadder.get(x - 2)) + gameObject.getBitmapWidth() / 2))
                                * ((gameObject.enemyValue.bugPosition.get(x) + gameObject.getBitmapWidth() / 2)
                                - ((gameObject.enemyValue.bugPosition.get(x - 2) - gameObject.enemyValue.bugPositionadder.get(x - 2)) + gameObject.getBitmapWidth() / 2))) +


                                (((gameObject.enemyValue.bugPosition.get(x + 1) + gameObject.getBitmapHeight() / 2)
                                        - ((gameObject.enemyValue.bugPosition.get(x - 1) - gameObject.enemyValue.bugPositionadder.get(x - 1)) + gameObject.getBitmapHeight() / 2))
                                        * ((gameObject.enemyValue.bugPosition.get(x + 1) + gameObject.getBitmapHeight() / 2)
                                        - ((gameObject.enemyValue.bugPosition.get(x - 1) - gameObject.enemyValue.bugPositionadder.get(x - 1)) + gameObject.getBitmapHeight() / 2)))
                                > ((gameObject.getBitmapWidth() * gameObject.getBitmapWidth()) +
                                (gameObject.getBitmapHeight() * gameObject.getBitmapHeight())))

                        {

                            for (int z = 0; z < gameObject.enemyValue.y; z++) {
                                gameObject.enemyValue.bugPosition.set(z, gameObject.enemyValue.bugPosition.get(z) - gameObject.enemyValue.bugPositionadder.get(z));
                            }

                            if ((enemyarray.size() * 2) == (gameObject.enemyValue.bugPositionadder.size() + 2)) {
                                gameObject.condition = "secondcondition";
                            }


                            gameObject.enemyValue.bugPositionadder.clear();

                            gameObject.enemyValue.y = gameObject.enemyValue.y + 2;


                        }
                    }
                }

            } else if (gameObject.condition.matches("secondcondition")) {


                gameObject.firstconditionposx = gameObject.enemyValue.bugPosition.get(0) - gameObject.currentxWorld;
                gameObject.firstconditionposy = gameObject.enemyValue.bugPosition.get(1) - gameObject.currentyWorld;


                gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposy);


                gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposx);


                for (int k = 2; k < gameObject.enemyValue.bugPosition.size(); k = k + 2) {

                    gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposy);

                    gameObject.enemyValue.bugPositionadder.add(0, gameObject.firstconditionposx);


                }


                while (gameObject.enemyValue.bugPositionadder.size() > gameObject.enemyValue.y) {
                    gameObject.enemyValue.bugPositionadder.remove(gameObject.enemyValue.bugPositionadder.size() - 1);
                    gameObject.enemyValue.bugPositionadder.remove(gameObject.enemyValue.bugPositionadder.size() - 1);
                }



            }

        } else {

            if (gameObject.condition.matches("initialcondition")) {
                for (int a = 1; a < enemyarray.size(); a++) {

                    if (enemyarray.indexOf(gameObject) == a && enemyarray.get(0).enemyValue.bugPositionadder.size() > a * 2) {
                        gameObject.currentxWorld = enemyarray.get(0).enemyValue.bugPosition.get(enemyarray.indexOf(gameObject) * 2) -
                                enemyarray.get(0).enemyValue.bugPositionadder.get(enemyarray.indexOf(gameObject) * 2);
                        gameObject.currentyWorld = enemyarray.get(0).enemyValue.bugPosition.get((enemyarray.indexOf(gameObject) * 2) + 1) -
                                enemyarray.get(0).enemyValue.bugPositionadder.get((enemyarray.indexOf(gameObject) * 2) + 1);
                    } else if (enemyarray.indexOf(gameObject) == a) {
                        gameObject.currentxWorld = enemyarray.get(0).enemyValue.bugPosition.get(enemyarray.indexOf(gameObject) * 2);
                        gameObject.currentyWorld = enemyarray.get(0).enemyValue.bugPosition.get((enemyarray.indexOf(gameObject) * 2) + 1);

                    }
                }
            } else if (gameObject.condition.matches("firstcondition")) {

                gameObject.setWorldLocation(lm.BeginX + gameObject.currentxWorld, lm.BeginY + gameObject.currentyWorld);

                gameObject.currentxWorld = gameObject.getWorldLocation().x - lm.BeginX;
                gameObject.currentyWorld = gameObject.getWorldLocation().y - lm.BeginY;

                gameObject.condition = "secondcondition";

            } else if (gameObject.condition.matches("secondcondition")) {

              if((gameObject instanceof BigBeeGrav) || (gameObject instanceof RockBigBeeGrav)){

                  updateBigBeeNow(gameObject);

              }
                 else {

                  gameObject.updateEnemy(fps * gameObject.speed, lm.frogFungiPlayer.currentxWorld,
                          lm.frogFungiPlayer.currentyWorld - (lm.frogFungiPlayer.getBitmapHeight() / 2),
                          gameObject.currentxWorld, gameObject.currentyWorld);

              }

                if (gameObject.getxVelocity() != 0) {
                    gameObject.currentxWorld = gameObject.getWorldLocation().x - lm.BeginX
                            + gameObject.getSavedxvelocity() + gameObject.getxVelocity();
                }


                if (gameObject.getyVelocity() != 0) {
                    gameObject.currentyWorld = gameObject.getWorldLocation().y - lm.BeginY
                            + gameObject.getSavedyvelocity() + gameObject.getyVelocity();
                }


            }
        }
    }

    void updateBigBeeNow(GameObject gameObject){

        gameObject.updateEnemy(fps * gameObject.speed, lm.frogFungiPlayer.currentxWorld,
                lm.frogFungiPlayer.currentyWorld - lm.bgLandscape.getbackgroundyResolution()/2,
                lm.frogFungiPlayer.getWorldLocation().x - lm.BeginX + lm.bgLandscape.getbackgroundxResolution() / 2,
                lm.frogFungiPlayer.getWorldLocation().y - lm.BeginY + lm.bgLandscape.getbackgroundyResolution()/2);

    }

    void tuningMap(){
        if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelOne") &&
                frogFungiPlayerState.getWorld().matches("Ocean")){
            lm.bgLandscape.setxVelocity(-(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/2);
            lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/2);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelTwo") &&
                frogFungiPlayerState.getWorld().matches("Ocean")){
            lm.bgLandscape.setxVelocity((lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/4);
            lm.bgLandscape.setyVelocity(-(lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/2);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelThree") &&
                frogFungiPlayerState.getWorld().matches("Ocean")){
            lm.bgLandscape.setxVelocity((lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/2);
            lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/2);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelFour") &&
                frogFungiPlayerState.getWorld().matches("Ocean")){
            lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/5);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelOne") &&
                frogFungiPlayerState.getWorld().matches("Lava")){
            lm.bgLandscape.setxVelocity(-(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/4);
            lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/5);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelTwo") &&
                frogFungiPlayerState.getWorld().matches("Lava")){
            lm.bgLandscape.setxVelocity(-(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/4);
            lm.bgLandscape.setyVelocity((lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/4);
            lm.bgLandscape.initialcondition = false;
        }

        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelThree") &&
                frogFungiPlayerState.getWorld().matches("Lava")){
            lm.bgLandscape.setxVelocity((lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/2);
            lm.bgLandscape.setyVelocity(-(lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/4);
            lm.bgLandscape.initialcondition = false;
        }


        else if(lm.bgLandscape.initialcondition == true && frogFungiPlayerState.getLevel().matches("LevelFour") &&
                frogFungiPlayerState.getWorld().matches("Lava")){
            lm.bgLandscape.setxVelocity(-(lm.bgLandscape.getWidth() * lm.bgLandscape.getbackgroundxResolution())/5);
            lm.bgLandscape.setyVelocity(-(lm.bgLandscape.getHeight() * lm.bgLandscape.getbackgroundyResolution())/5);
            lm.bgLandscape.initialcondition = false;
        }
    }

}

