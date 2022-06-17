package com.verticesstudio.frogfungi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * Created by kucrut on 1/13/2017.
 */
public class OceanThree extends GameObject {


    OceanThree() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        babyfungiBitmap = new ArrayList<Bitmap>();
        teenfungiBitmap = new ArrayList<Bitmap>();
        fungitype = "babyfungi";
        fungitypesecond = "babyfungisecond";
        initialcondition = true;




        fungiArray = new Integer[]{ 3080, 1505, 2750, 1005, 2520, 1305, 2220, 1060, 1740, 645,
                                1400, 380, 1110, 230, 810, 170, 540, 550, 150, 790,
                                570, 870, 840, 1030, 420, 1500, 670, 1365, 1090, 1430,
                                1695, 1200, 1225, 925, 1480, 775, 1880, 515, 2170, 275,
                                2620, 405, 2930, 215, 3150, 715, 2690, 565};

        funginumber = new Integer[]{12, 2, 3, 21, 19, 13, 11, 16, 9, 7, 24, 8, 5, 6, 22, 15, 14,
                            18, 20, 17, 23, 4, 1, 10};

        listofinitialfungiposminus = new Integer[] {40, 30, 30, 20, 40, 30, 60, 30, 80, 25,
                70, 30, 30, 70, 70, 30, 40, 30, 135, 25,
                40, 25, 30, 100, 50, 30, 40, 30, 130, 20,
                50, 30, 40, 100, 30, 130, 90, 30, 35, 120,
                190, 25, 30, 115, 190, 65, 50, 25};


        listofinitialfungipos = new Integer[fungiArray.length];

        for(int x = 0; x < fungiArray.length; x = x + 2){
            listofinitialfungipos[x] = fungiArray[x] - listofinitialfungiposminus[(funginumber[x/2] * 2) - 2];
            listofinitialfungipos[x + 1] = fungiArray[x + 1] - listofinitialfungiposminus[(funginumber[x/2] * 2) - 1];


        }



        HEIGHT = 23;
        WIDTH = 40;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setBitmapName("ocean");


    }


    void initializefungiBitmap(){

        int resID;

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;


        for(int y = 1; y < funginumber.length + 1; y++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungiocean" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            fungiBitmap.add(bitmap);

            fungiBitmap.trimToSize();


        }

        for(int k = 1; k < 3; k++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("babyfungi" + k, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            babyfungiBitmap.add(bitmap);

            babyfungiBitmap.trimToSize();


        }


        for(int l = 1; l < 3; l++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("teenfungi" + l, "drawable", MainActivity.getmyAppcontext().getPackageName());



            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            teenfungiBitmap.add(bitmap);

            teenfungiBitmap.trimToSize();


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


                    resID = MainActivity.getmyAppcontext().getResources().getIdentifier("slice_0" + m, "drawable", MainActivity.getmyAppcontext().getPackageName());

                } else {
                    resID = MainActivity.getmyAppcontext().getResources().getIdentifier("slice_" + m, "drawable", MainActivity.getmyAppcontext().getPackageName());

                }


                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);

                BackgroundBitmap.add(Bitmap.createScaledBitmap(bitmap, (int) getbackgroundxResolution(),
                        (int) getbackgroundyResolution(), false));



                BackgroundBitmap.trimToSize();


            }

        }


    }


}
