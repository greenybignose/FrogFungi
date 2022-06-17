package com.verticesstudio.frogfungi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * Created by kucrut on 1/13/2017.
 */
public class LavaFour extends GameObject {





    LavaFour() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;


        fungiArray = new Integer[]{ 1060, 760, 1320, 555, 870, 395, 660, 560, 460, 745,
                        600, 1040, 970, 1240, 1210, 1005, 1500, 750, 1690, 505,
                        1295, 165, 1005, 615, 385, 260, 565, 770, 185, 1085,
                        400, 1290, 650, 1470, 1180, 1260, 1365, 990, 1615, 1275,
                        1860, 1540, 2305, 1430, 2600, 1295, 2875, 1460, 2635, 1115,
                        2950, 820, 2630, 590, 2970, 480, 2515, 285, 2270, 450,
                        1935, 235, 1510, 355, 2070, 440, 2305, 820, 2055, 1100,
                        2425, 1225, 2690, 740, 1400, 185, 320, 785

        };

        funginumber = new Integer[]{28, 27, 21, 31, 3, 24, 7, 2, 10, 18, 14, 8, 34, 32, 26, 22, 15, 29, 4, 9,
                    36, 12, 5, 30, 25, 33, 35, 37, 1, 11, 13, 6, 20, 17, 23, 16, 19, 38, 39};



        listofinitialfungiposminus = new Integer[] {30, 30, 60, 25, 75, 25, 70, 25, 30, 30,
                30, 30, 135, 95, 165, 135, 65, 30, 240, 30,
                35, 35, 155, 90, 40, 30, 40, 25, 110, 35,
                135, 30, 35, 130, 30, 25, 120, 40, 90, 25,
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

    void initializegiantfungiBitmap() {
        int resID;

        resID = MainActivity.getmyAppcontext().getResources().getIdentifier("giantfungi", "drawable", MainActivity.getmyAppcontext().getPackageName());

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;

        Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);

        giantFungi = Bitmap.createScaledBitmap(bitmap, 4 * (int) getbackgroundxResolution(), 4 * (int) getbackgroundyResolution(), false);

    }


     void initializefungiBitmap() {

         int resID;

         for (int y = 1; y < funginumber.length + 1; y++) {


             resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungilava" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());


             BitmapFactory.Options options = new BitmapFactory.Options();

             options.inScaled = false;

             Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);


             fungiBitmap.add(bitmap);

             fungiBitmap.trimToSize();


         }

         initializegiantfungiBitmap();

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
