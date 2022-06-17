package com.verticesstudio.frogfungi;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class OceanTwo extends GameObject {




    OceanTwo() {

        BackgroundBitmap = new ArrayList<Bitmap>();
        fungiBitmap = new ArrayList<Bitmap>();
        initialcondition = true;

        fungiArray = new Integer[]{ 2270, 165, 1975, 345, 1615, 685, 1410, 355, 1070, 260,
                                    635, 310, 460, 680, 200, 855, 615, 890, 915, 1045,
                                    400, 1510, 670, 1355, 1195, 1445, 1415, 1055, 1720, 1270,
                                    2050, 1015, 2555, 1280, 3090, 1420, 2590, 1160, 2845, 1015,
                                    3050, 790, 2615, 595, 2945, 365, 2560, 235};

        funginumber = new Integer[]{1, 2, 3, 4, 24, 22, 20, 12, 9, 5, 8, 6, 17, 23, 10, 14, 16, 13,
                            18, 19, 7, 11, 21, 15};

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


        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;


        int resID;

        for(int y = 1; y < funginumber.length + 1; y++)

        {
            resID = MainActivity.getmyAppcontext().getResources().getIdentifier("fungiocean" + y, "drawable", MainActivity.getmyAppcontext().getPackageName());


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
