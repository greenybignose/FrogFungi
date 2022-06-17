package com.verticesstudio.frogfungi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * Created by kucrut on 1/13/2017.
 */
public class LavaThree extends GameObject {





    LavaThree() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;

        fungiArray = new Integer[]{ 2830, 480, 3070, 760, 2780, 950, 2570, 640, 2780, 230,
                                2370, 360, 1940, 235, 1530, 320, 1765, 425, 2120, 535,
                                2430, 730, 2650, 1125, 2910, 1280, 2665, 1400, 2350, 1220,
                                2450, 1420, 2070, 1325, 1830, 1130, 1950, 1450, 1680, 1600,
                                1610, 1230, 1200, 1335, 1570, 980, 1130, 845, 775, 740,
                                910, 950, 1135, 1140, 750, 1275, 280, 1305, 630, 915,
                                180, 1085, 460, 745, 265, 420, 660, 560, 895, 315,
                                1355, 200, 1520, 580, 555, 700, 1200, 880};

        funginumber = new Integer[]{33, 7, 27, 1, 20, 21, 13, 6, 19, 36, 32, 25, 37, 35, 29, 12, 18, 14, 22,
            24, 9, 17, 23, 28, 5, 2, 4, 10, 30, 16, 26, 3, 11, 31, 34, 15, 8, 38, 39};

        listofinitialfungiposminus = new Integer[] {30, 30, 60, 25, 75, 25, 70, 25, 30, 30,
                30, 30, 135, 95, 165, 135, 65, 30, 240, 30,
                35, 35, 155, 90, 40, 30, 40, 25, 110, 35,
                135, 30, 35, 130, 30, 25, 40, 25, 90, 25,
                40, 30, 120, 110, 275, 25, 100, 70, 35, 30,
                40, 140, 40, 110, 35, 35, 95, 45, 65, 120,
                210, 190, 45, 25, 50, 30, 40, 25, 30, 25,
                140, 45, 45, 25, 85, 30, 35, 45};


        listofinitialfungipos = new Integer[fungiArray.length];

        for(int x = 0; x < fungiArray.length; x = x + 2){
            listofinitialfungipos[x] = fungiArray[x] - listofinitialfungiposminus[(funginumber[x/2] * 2) - 2];
            listofinitialfungipos[x + 1] = fungiArray[x + 1] - listofinitialfungiposminus[(funginumber[x/2] * 2) - 1];


        }


        HEIGHT = 23;
        WIDTH = 40;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setBitmapName("lava");


    }

    void initializefungiBitmap(){

        int resID;

        for(int y = 1; y < funginumber.length + 1; y++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungilava" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());


            BitmapFactory.Options options = new BitmapFactory.Options();

            options.inScaled = false;

            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            fungiBitmap.add(bitmap);

            fungiBitmap.trimToSize();


        }
    }

    void initializeBackgroundBitmap(){

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;


        int resID;

        for(int y = 0; y < HEIGHT; y++)

        {
            for (int x = 1; x <= WIDTH; x++) {
                int m = (40 * y) + x;

                if (m < 10) {


                    resID = MainActivity.getmyAppcontext().getResources().getIdentifier("slicelava_0" + m, "drawable", MainActivity.getmyAppcontext().getPackageName());

                } else {
                    resID = MainActivity.getmyAppcontext().getResources().getIdentifier("slicelava_" + m, "drawable", MainActivity.getmyAppcontext().getPackageName());

                }


                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);

                BackgroundBitmap.add(Bitmap.createScaledBitmap(bitmap, (int) getbackgroundxResolution(),
                        (int) getbackgroundyResolution(), false));

                BackgroundBitmap.trimToSize();


            }
        }


    }


}
