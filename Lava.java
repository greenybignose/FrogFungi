package com.verticesstudio.frogfungi;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Lava extends GameObject {




    Lava() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;


        fungiArray = new Integer[]{ 780, 1160, 575, 1390, 355, 1070, 580, 780, 260, 685,
                                    145, 395, 620, 460, 995, 595, 1095, 840, 1470, 800,
                                      1670, 530, 1225, 225, 1480, 510, 1785, 340, 1970, 460,
                                    2155, 320, 2355, 530, 2605, 335, 2820, 470, 3010, 630,
                                   2790, 795, 3030, 970, 3130, 1250, 2845, 1510, 2625, 1180,
                                    2520, 950, 2305, 830, 2110, 1050, 2390, 1365, 2155, 1445,
                                    1870, 1650, 1530, 1440, 1885, 1265, 1640, 1100, 1475, 1265,
                                    1305, 1230, 1115, 1110, 2410, 230, 2165, 1120
                                };

        funginumber = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,  11, 13, 12, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39};

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
