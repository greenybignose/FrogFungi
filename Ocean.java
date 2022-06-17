package com.verticesstudio.frogfungi;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Ocean extends GameObject {




    Ocean() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;

        fungiArray = new Integer[]{ 380, 1515, 605, 1420, 830, 1050, 510, 810, 260, 680,
                                580, 525, 735, 295, 1130, 270, 1330, 510, 1730, 670,
                                2000,345, 2230, 280, 2495, 315, 1210, 940, 1350, 1210,
                                1620, 1275, 2000, 1185, 2430, 1400, 2660, 1200, 3065, 1420,
                                2890, 1035, 3015, 800, 2750, 655, 3125, 195};

        funginumber = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
        16, 17, 18, 19, 20, 21, 22, 23, 24};

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

    for(int y = 1; y < funginumber.length + 1; y++)

    {
                resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungiocean" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());


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
