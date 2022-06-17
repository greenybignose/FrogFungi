package com.verticesstudio.frogfungi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * Created by kucrut on 1/13/2017.
 */
public class LavaTwo extends GameObject {





    LavaTwo() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        tonguewormoneBitmap = new ArrayList<Bitmap>();
        tonguewormtwoBitmap = new ArrayList<Bitmap>();
        tonguewormthreeBitmap = new ArrayList<Bitmap>();
        firefungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;


        fungitypelavastatus = new ArrayList<Values>();



        for(int x = 0; x < 5; x++){
            fungitypelavastatus.add(new Values());
        }



        fungiArray = new Integer[]{ 790, 1390, 1120, 1290, 1390, 1490, 1840, 1620, 1690, 1310,
                                1410, 965, 790, 750, 510, 410, 280, 650, 550, 910,
                                870, 1255, 1205, 985, 1485, 1330, 1840, 1135, 1980, 1495,
                                2415, 1410, 2275, 1115, 2660, 1380, 2995, 1345, 2765, 1220,
                                3065, 925, 2755, 615, 2505, 860, 2175, 600, 1920, 255,
                                2375, 360, 2695, 225, 3020, 595, 2685, 945, 2045, 685,
                                1755, 415, 1220, 145, 1535, 625, 930, 375, 550, 740,
                                230, 950, 460, 1100, 1100, 855, 1690, 285
        };

        funginumber = new Integer[]{23, 17, 11, 22, 34, 10, 5, 36, 25, 3, 27, 9, 18, 20, 26, 24, 37, 35, 15, 14,
                        7, 33, 12, 8, 13, 21, 32, 29, 30, 6, 19, 28, 31, 4, 2, 1, 16, 38, 39};

        listofinitialfungiposminus = new Integer[] {30, 30, 60, 25, 75, 25, 70, 25, 30, 30,
                30, 30, 135, 95, 165, 135, 65, 30, 240, 30,
                35, 35, 155, 90, 40, 30, 40, 25, 110, 35,
                135, 30, 35, 130, 30, 25, 40, 25, 90, 25,
                40, 30, 120, 110, 275, 25, 100, 70, 35, 30,
                40, 140, 40, 110, 35, 35, 95, 45, 65, 120,
                210, 190, 45, 25, 50, 30, 40, 25, 30, 25,
                140, 45, 45, 25, 85, 30, 35, 45};


        listofinitialfungipos = new Integer[fungiArray.length];

        tonguewormnumber = new Integer[]{22, 12, 30, 4, 2};

        firefunginumber = new Integer[]{36, 1, 34, 33, 19};


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


        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;

        int resID;

        for(int y = 1; y < funginumber.length + 1; y++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungilava" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            fungiBitmap.add(bitmap);

            fungiBitmap.trimToSize();


        }


        for(int k = 1; k < 6; k++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("tonguewormone" + k, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            tonguewormoneBitmap.add(bitmap);

            tonguewormoneBitmap.trimToSize();


        }


        for(int l = 1; l < 6; l++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("tonguewormtwo" + l, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            tonguewormtwoBitmap.add(bitmap);

            tonguewormtwoBitmap.trimToSize();


        }

        for(int m = 1; m < 6; m++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("tonguewormthree" + m, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            tonguewormthreeBitmap.add(bitmap);

            tonguewormthreeBitmap.trimToSize();


        }


        for(int n = 1; n < firefunginumber.length + 1; n++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("firefungiadd" + n, "drawable", MainActivity.getmyAppcontext().getPackageName());


            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            firefungiBitmap.add(bitmap);

            firefungiBitmap.trimToSize();


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
