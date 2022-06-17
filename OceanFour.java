package com.verticesstudio.frogfungi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * Created by kucrut on 1/13/2017.
 */
public class OceanFour extends GameObject{

    OceanFour() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        fungispecialBitmap =  new ArrayList<Bitmap>();
        initialcondition = true;


        fungiArray = new Integer[]{ 1690, 1200, 1090, 1410, 1430, 990, 740, 1410, 420, 1500,
                                850, 1030, 550, 840, 150, 790, 540, 550, 810, 165,
                                1110, 230, 1435, 385, 1880, 525, 2175, 275, 2620, 405,
                                2935, 215, 3150, 715, 2720, 505, 2485, 705, 2750, 1005,
                                3075, 1505, 2535, 1305, 2125, 1010, 1620, 635};

        funginumber = new Integer[]{15, 22, 21, 10, 5, 8, 24, 7, 9, 16, 11, 13, 20, 17, 23, 4, 1,
                    19, 18, 2, 12, 3, 6, 14};

        fungispecialnumber = new Integer[]{7, 9, 12, 20};

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


        for(int z = 1; z < fungispecialnumber.length + 1; z++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungispecialocean" + z, "drawable", MainActivity.getmyAppcontext().getPackageName());


            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


            fungispecialBitmap.add(bitmap);

            fungispecialBitmap.trimToSize();


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
