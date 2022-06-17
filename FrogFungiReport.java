package com.verticesstudio.frogfungi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


import java.util.ArrayList;


/**
 * Created by kucrut on 11/24/2016.
 */
public class FrogFungiReport extends Activity {

    float backgroundx;
    float backgroundy;
    boolean frogfungi;
    boolean worlds;

    LinearLayout.LayoutParams linLayoutsecondparam;
    LinearLayout.LayoutParams linLayoutthirdparam;
    LinearLayout.LayoutParams linLayoutfourthparam;
    LinearLayout.LayoutParams linLayoutfifthparam;
    LinearLayout.LayoutParams itemsLayoutparam;
    LinearLayout linLayoutsecond;
    LinearLayout linLayoutthird;
    LinearLayout linLayoutfourth;
    LinearLayout linLayoutfifth;
    LinearLayout linparentLayout;
    
    int lives;
    String levels;
    String worldlevel;
    int prey;
    int food;
    String[] finishlevels;
    ImageButton oceanBtn;
    ImageButton lavaBtn;
    ImageButton forestBtn;
    ImageButton caveBtn;
    Typeface tf;
    boolean frommain;
    Drawable levelImg;
    Drawable preyImg;
    Drawable foodImg;
    InterstitialAd mInterstitialAd;
    ArrayList<String> arrayofLevels;



    @Override

    protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);

        arrayofLevels = new ArrayList<String>();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5555041155278389/8524553555");

        requestNewInterstitial();


        tf = Typeface.createFromAsset(getResources().getAssets(),"fonts/GoodDog.otf");

        frogfungi = false;
        worlds = false;
        finishlevels = new String[]{"LevelOne", "LevelTwo", "LevelThree", "LevelFour", "LevelFive", "LevelSix",
                                    "LevelSeven", "LevelEight"};


        backgroundx = getIntent().getExtras().getFloat("backgroundx");
        backgroundy = getIntent().getExtras().getFloat("backgroundy");



            frogfungi = getIntent().getExtras().getBoolean("frogfungi");


            worlds = getIntent().getExtras().getBoolean("worlds");
        worldlevel = getIntent().getExtras().getString("worldlevel");
        lives = getIntent().getExtras().getInt("lives");
        levels = getIntent().getExtras().getString("levels");
        prey = getIntent().getExtras().getInt("prey");
        food = getIntent().getExtras().getInt("food");
        frommain = getIntent().getExtras().getBoolean("frommain");



        if(levels.matches("LevelOne") && worldlevel.matches("Ocean")){
            for(int x = 0; x < finishlevels.length - 7; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }

       else if(levels.matches("LevelTwo") && worldlevel.matches("Ocean")){
            for(int x = 0; x < finishlevels.length - 6; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelThree") && worldlevel.matches("Ocean")){
            for(int x = 0; x < finishlevels.length - 5; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelFour") && worldlevel.matches("Ocean")){
            for(int x = 0; x < finishlevels.length - 4; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelOne") && worldlevel.matches("Lava")){
            for(int x = 0; x < finishlevels.length - 3; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelTwo") && worldlevel.matches("Lava")){
            for(int x = 0; x < finishlevels.length - 2; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelThree") && worldlevel.matches("Lava")){
            for(int x = 0; x < finishlevels.length - 1; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        else if(levels.matches("LevelFour") && worldlevel.matches("Lava")){
            for(int x = 0; x < finishlevels.length; x++){
                arrayofLevels.add(finishlevels[x]);
            }
        }


        LinearLayout.LayoutParams linLayoutparentparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linLayoutsecondparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linLayoutthirdparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linLayoutfourthparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linLayoutfifthparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        itemsLayoutparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);



        linparentLayout = new LinearLayout(this);
        linparentLayout.setLayoutParams(linLayoutparentparam);
        linparentLayout.setBackgroundResource(R.color.colorTransparent);
        linparentLayout.setOrientation(LinearLayout.VERTICAL);

        linLayoutsecond = new LinearLayout(this);
        linLayoutsecondparam.gravity = Gravity.CENTER_HORIZONTAL;
        linLayoutsecond.setLayoutParams(linLayoutsecondparam);
        linLayoutsecond.setBackgroundResource(R.color.FullTransparent);

        linLayoutsecond.setOrientation(LinearLayout.HORIZONTAL);
        
        
        linLayoutthird = new LinearLayout(this);

        linLayoutthird.setLayoutParams(linLayoutthirdparam);
        linLayoutthird.setBackgroundResource(R.color.FullTransparent);

        linLayoutthird.setOrientation(LinearLayout.HORIZONTAL);


        linLayoutfourth = new LinearLayout(this);

        linLayoutfourth.setLayoutParams(linLayoutfourthparam);
        linLayoutfourth.setBackgroundResource(R.color.FullTransparent);

        linLayoutfourth.setOrientation(LinearLayout.HORIZONTAL);



        linLayoutfifth = new LinearLayout(this);
        linLayoutfifthparam.gravity = Gravity.CENTER_VERTICAL;

        linLayoutfifth.setLayoutParams(linLayoutfifthparam);
        

        linLayoutfifth.setOrientation(LinearLayout.HORIZONTAL);











if(frogfungi == true) {





    upperviewfrogfungi();

    lowerviewfrogfungi();

    linparentLayout.addView(linLayoutsecond);

    linparentLayout.addView(linLayoutthird);

    linparentLayout.addView(linLayoutfourth);



    setContentView(linparentLayout);



}

        if(worlds == true){



            upperviewworlds();

            lowerviewworlds();

            linparentLayout.addView(linLayoutsecond);

            linparentLayout.addView(linLayoutthird);

            linparentLayout.addView(linLayoutfourth);



            setContentView(linparentLayout);


        }







    }

    @Override
    protected void onPause(){
    super.onPause();
    }

    @Override
    protected void onResume(){
    super.onResume();




    }


    private Drawable resizeButton(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, (int)backgroundx, (int)backgroundy, false);
        return new BitmapDrawable(getResources(), bitmapResized);

    }


    private Drawable resizeImage(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, (int)(backgroundx * .75), (int)(backgroundy * .75), false);
        return new BitmapDrawable(getResources(), bitmapResized);

    }

    private void upperviewfrogfungi(){

        reload();

        Drawable worldsbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.worldsbutton);


        ImageButton worldBtn = new ImageButton(this);


        worldBtn.setImageDrawable(resizeButton(worldsbutton));


        worldBtn.setLayoutParams(itemsLayoutparam);
        worldBtn.setBackgroundResource(R.color.FullTransparent);
        worldBtn.setPadding((int)backgroundx * 2, 0, 0, 0);

        linLayoutsecond.addView(worldBtn);


        worldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                worlds = true;
                frogfungi = false;

                

                linparentLayout.removeAllViews();
                linLayoutsecond.removeAllViews();
                linLayoutthird.removeAllViews();
                linLayoutfourth.removeAllViews();
                linLayoutfifth.removeAllViews();


                upperviewworlds();

                lowerviewworlds();

                linparentLayout.addView(linLayoutsecond);

                linparentLayout.addView(linLayoutthird);

                linparentLayout.addView(linLayoutfourth);

                linparentLayout.addView(linLayoutfifth);

                setContentView(linparentLayout);



            }

        });


        backAndexit();




    }

    private void upperviewworlds(){

        reload();


        Drawable frogfungibutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.frogfungibutton);


        ImageButton frogfungiBtn = new ImageButton(this);


        frogfungiBtn.setImageDrawable(resizeButton(frogfungibutton));
        frogfungiBtn.setLayoutParams(itemsLayoutparam);
        frogfungiBtn.setBackgroundResource(R.color.FullTransparent);
        frogfungiBtn.setPadding((int)backgroundx * 2,0, 0, 0);

        linLayoutsecond.addView(frogfungiBtn);


        frogfungiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                worlds = false;
                frogfungi = true;



                linparentLayout.removeAllViews();

                linLayoutsecond.removeAllViews();
                linLayoutthird.removeAllViews();
                linLayoutfourth.removeAllViews();
                linLayoutfifth.removeAllViews();

                upperviewfrogfungi();

                lowerviewfrogfungi();

                linparentLayout.addView(linLayoutsecond);

                linparentLayout.addView(linLayoutthird);

                linparentLayout.addView(linLayoutfourth);

                linparentLayout.addView(linLayoutfifth);

                setContentView(linparentLayout);

            }

        });

backAndexit();

    }

    private void reload(){
        Drawable reloadbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.reloadbutton);


        ImageButton ReloadBtn = new ImageButton(this);

        ReloadBtn.setImageDrawable(resizeButton(reloadbutton));
        ReloadBtn.setLayoutParams(itemsLayoutparam);
        ReloadBtn.setBackgroundResource(R.color.FullTransparent);
        ReloadBtn.setPadding(0, 0, 0, 0);

        linLayoutsecond.addView(ReloadBtn);


        ReloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {




                Intent reloadInt = new Intent(getBaseContext(), MainActivity.class);







                reloadInt.putExtra("levels", levels);
                reloadInt.putExtra("worlds", worldlevel);

                MainActivity.contextMain.finish();

                startActivity(reloadInt);


                if(mInterstitialAd.isLoaded()){

                    mInterstitialAd.show();
                }


                FrogFungiReport.this.finish();

            }

        });

    }



    private void lowerviewfrogfungi(){


        if(MainActivity.resolutiony > MainActivity.resolutionx){
            MainActivity.changeresolution = MainActivity.resolutionx;
            MainActivity.resolutionx = MainActivity.resolutiony;
            MainActivity.resolutiony = MainActivity.changeresolution;
        }

        Drawable livesImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.frogfungiright);

        ImageView livesView = new ImageView(this);


        livesView.setImageDrawable(resizeImage(livesImg));
        livesView.setLayoutParams(itemsLayoutparam);
        livesView.setBackgroundResource(R.color.FullTransparent);

        livesView.measure(0, 0);
        livesView.setPadding(MainActivity.resolutionx/5 - livesView.getMeasuredWidth()/2, 0, 0, 0);

       linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - livesView.getMeasuredHeight()/2);
       linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - livesView.getMeasuredHeight()/2);

        linLayoutthird.addView(livesView);


        TextView livesCount = new TextView(this);
        livesCount.setLayoutParams(itemsLayoutparam);
        livesCount.setText(String.valueOf(lives));
        livesCount.setTypeface(tf);
        livesCount.setTextSize(backgroundy/4);

        livesCount.measure(0, 0);
        livesCount.setPadding(MainActivity.resolutionx/5 - livesCount.getMeasuredWidth()/2
                - livesView.getMeasuredWidth()/2, 0, 0, 0);

        linLayoutthird.addView(livesCount);




        if(worldlevel.matches("Ocean")) {
            levelImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.slice_01);
        }
        else if(worldlevel.matches("Lava")){
            levelImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.slicelava_01);

        }




        ImageView levelView = new ImageView(this);

        levelView.setImageDrawable(resizeImage(levelImg));
        itemsLayoutparam.gravity = Gravity.CENTER_VERTICAL;
        levelView.setLayoutParams(itemsLayoutparam);

        levelView.setBackgroundResource(R.color.FullTransparent);

        levelView.measure(0, 0 );

        levelView.setPadding(MainActivity.resolutionx/5 - levelView.getMeasuredWidth()/2
                   - livesCount.getMeasuredWidth()/2, 0, 0, 0);

        linLayoutthird.addView(levelView);

        TextView levelCount = new TextView(this);
        levelCount.setLayoutParams(itemsLayoutparam);
        levelCount.setText(levels);
        levelCount.setTypeface(tf);
        levelCount.measure(0, 0);
        levelCount.setTextSize(backgroundy/4);

        levelCount.setPadding(MainActivity.resolutionx/5 - levelCount.getMeasuredWidth()/2
                - levelView.getMeasuredWidth()/2, 0, 0, 0);

        linLayoutthird.addView(levelCount);



        if(worldlevel.matches("Ocean")) {
            foodImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.beegravright);
        }
        else if(worldlevel.matches("Lava")){
            foodImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.rockbeegravright);

        }


        ImageView foodView = new ImageView(this);


        foodView.setImageDrawable(resizeImage(foodImg));
        foodView.setLayoutParams(itemsLayoutparam);
        foodView.setBackgroundResource(R.color.FullTransparent);
        foodView.measure(0, 0);
        foodView.setPadding(MainActivity.resolutionx/5 - foodView.getMeasuredWidth()/2, 0, 0, 0);



        linLayoutfourth.addView(foodView);


        TextView foodCount = new TextView(this);
        foodCount.setLayoutParams(itemsLayoutparam);
        foodCount.setText(String.valueOf(food));
        foodCount.setTypeface(tf);
        foodCount.setTextSize(backgroundy/4);
        foodCount.measure(0, 0);
        foodCount.setPadding(MainActivity.resolutionx/5 - foodCount.getMeasuredWidth()/2
                - foodView.getMeasuredWidth()/2, 0, 0, 0);


        linLayoutfourth.addView(foodCount);




        if(worldlevel.matches("Ocean")) {
            preyImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.smalloceanfishright);
        }
        else if(worldlevel.matches("Lava")){
            preyImg = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.smalllavafishright);

        }


        ImageView preyView = new ImageView(this);

        preyView.setImageDrawable(resizeImage(preyImg));
        itemsLayoutparam.gravity = Gravity.CENTER_VERTICAL;
        preyView.setLayoutParams(itemsLayoutparam);

        preyView.setBackgroundResource(R.color.FullTransparent);
        preyView.measure(0, 0);
        preyView.setPadding(MainActivity.resolutionx/5 - preyView.getMeasuredWidth()/2
                - foodCount.getMeasuredWidth()/2, 0, 0, 0);


        linLayoutfourth.addView(preyView);

        TextView preyCount = new TextView(this);
        preyCount.setLayoutParams(itemsLayoutparam);
        preyCount.setText(String.valueOf(prey));
        preyCount.setTypeface(tf);
        preyCount.setTextSize(backgroundy/4);

        preyCount.measure(0, 0);
        preyCount.setPadding(MainActivity.resolutionx/5 - preyCount.getMeasuredWidth()/2
                - preyView.getMeasuredWidth()/2, 0, 0, 0);



        linLayoutfourth.addView(preyCount);








    }


    private void lowerviewworlds() {


        for (int x = 0; x < arrayofLevels.size(); x++) {

            Paint paint = new Paint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(tf);
            paint.setColor(Color.argb(255, 255, 0, 0));
            paint.setTextSize(backgroundx/2);


            Bitmap bitmap = Bitmap.createBitmap((int)backgroundx/2, (int)backgroundy/2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);


            Bitmap bitmapocean = BitmapFactory.decodeResource(getResources(), R.drawable.slice_01);

            Bitmap bitmapoceanresize = Bitmap.createScaledBitmap(bitmapocean, (int) backgroundx / 2, (int) backgroundy / 2, false);



            Bitmap bitmaplava = BitmapFactory.decodeResource(getResources(), R.drawable.slicelava_01);

            Bitmap bitmaplavaresize = Bitmap.createScaledBitmap(bitmaplava, (int) backgroundx / 2, (int) backgroundy / 2, false);





            if (arrayofLevels.get(x).matches("LevelOne")) {


                canvas.drawBitmap(bitmapoceanresize, 0, 0, paint);

                canvas.drawText("1", 20, 30, paint);


                oceanBtn = new ImageButton(this);
                oceanBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                oceanBtn.setLayoutParams(itemsLayoutparam);
                oceanBtn.setBackgroundResource(R.color.FullTransparent);
                oceanBtn.measure(0, 0);
                oceanBtn.setPadding(MainActivity.resolutionx/5 - oceanBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);


                linLayoutthird.addView(oceanBtn);

                oceanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelOne");
                        oceanInt.putExtra("worlds", "Ocean");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            else if (arrayofLevels.get(x).matches("LevelTwo")) {


                canvas.drawBitmap(bitmapoceanresize, 0, 0, paint);

                canvas.drawText("2", 20, 30, paint);


                oceanBtn = new ImageButton(this);
                oceanBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                oceanBtn.setLayoutParams(itemsLayoutparam);
                oceanBtn.setBackgroundResource(R.color.FullTransparent);
                oceanBtn.measure(0, 0);
                oceanBtn.setPadding(MainActivity.resolutionx/5 - oceanBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);


                linLayoutthird.addView(oceanBtn);

                oceanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelTwo");
                        oceanInt.putExtra("worlds", "Ocean");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            else if (arrayofLevels.get(x).matches("LevelThree")) {


                canvas.drawBitmap(bitmapoceanresize, 0, 0, paint);

                canvas.drawText("3", 20, 30, paint);


                oceanBtn = new ImageButton(this);
                oceanBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                oceanBtn.setLayoutParams(itemsLayoutparam);
                oceanBtn.setBackgroundResource(R.color.FullTransparent);
                oceanBtn.measure(0, 0);
                oceanBtn.setPadding(MainActivity.resolutionx/5 - oceanBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);


                linLayoutthird.addView(oceanBtn);

                oceanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelThree");
                        oceanInt.putExtra("worlds", "Ocean");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }



            else if (arrayofLevels.get(x).matches("LevelFour")) {


                canvas.drawBitmap(bitmapoceanresize, 0, 0, paint);

                canvas.drawText("4", 20, 30, paint);


                oceanBtn = new ImageButton(this);
                oceanBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                oceanBtn.setLayoutParams(itemsLayoutparam);
                oceanBtn.setBackgroundResource(R.color.FullTransparent);
                oceanBtn.measure(0, 0);
                oceanBtn.setPadding(MainActivity.resolutionx/5 - oceanBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - oceanBtn.getMeasuredHeight()/2);


                linLayoutthird.addView(oceanBtn);

                oceanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelFour");
                        oceanInt.putExtra("worlds", "Ocean");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            else if (arrayofLevels.get(x).matches("LevelFive")) {


                canvas.drawBitmap(bitmaplavaresize, 0, 0, paint);

                canvas.drawText("1", 20, 30, paint);


                lavaBtn = new ImageButton(this);
                lavaBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                lavaBtn.setLayoutParams(itemsLayoutparam);
                lavaBtn.setBackgroundResource(R.color.FullTransparent);
                lavaBtn.measure(0, 0);
                lavaBtn.setPadding(MainActivity.resolutionx/5 - lavaBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);


                linLayoutfourth.addView(lavaBtn);

                lavaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelOne");
                        oceanInt.putExtra("worlds", "Lava");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            else if (arrayofLevels.get(x).matches("LevelSix")) {


                canvas.drawBitmap(bitmaplavaresize, 0, 0, paint);

                canvas.drawText("2", 20, 30, paint);


                lavaBtn = new ImageButton(this);
                lavaBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                lavaBtn.setLayoutParams(itemsLayoutparam);
                lavaBtn.setBackgroundResource(R.color.FullTransparent);
                lavaBtn.measure(0, 0);
                lavaBtn.setPadding(MainActivity.resolutionx/5 - lavaBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);


                linLayoutfourth.addView(lavaBtn);

                lavaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelTwo");
                        oceanInt.putExtra("worlds", "Lava");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            else if (arrayofLevels.get(x).matches("LevelSeven")) {


                canvas.drawBitmap(bitmaplavaresize, 0, 0, paint);

                canvas.drawText("3", 20, 30, paint);


                lavaBtn = new ImageButton(this);
                lavaBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                lavaBtn.setLayoutParams(itemsLayoutparam);
                lavaBtn.setBackgroundResource(R.color.FullTransparent);
                lavaBtn.measure(0, 0);
                lavaBtn.setPadding(MainActivity.resolutionx/5 - lavaBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);


                linLayoutfourth.addView(lavaBtn);

                lavaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelThree");
                        oceanInt.putExtra("worlds", "Lava");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }



            else if (arrayofLevels.get(x).matches("LevelEight")) {


                canvas.drawBitmap(bitmaplavaresize, 0, 0, paint);

                canvas.drawText("4", 20, 30, paint);


                lavaBtn = new ImageButton(this);
                lavaBtn.setImageDrawable(new BitmapDrawable(getResources(), bitmap));




                lavaBtn.setLayoutParams(itemsLayoutparam);
                lavaBtn.setBackgroundResource(R.color.FullTransparent);
                lavaBtn.measure(0, 0);
                lavaBtn.setPadding(MainActivity.resolutionx/5 - lavaBtn.getMeasuredWidth()/2, 0, 0, 0);

                linLayoutthirdparam.topMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);
                linLayoutthirdparam.bottomMargin = (int)((MainActivity.resolutiony - backgroundy)/4 - lavaBtn.getMeasuredHeight()/2);


                linLayoutfourth.addView(lavaBtn);

                lavaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {


                        Intent oceanInt = new Intent(getBaseContext(), MainActivity.class);
                        oceanInt.putExtra("levels", "LevelFour");
                        oceanInt.putExtra("worlds", "Lava");

                        MainActivity.contextMain.finish();

                        startActivity(oceanInt);

                        FrogFungiReport.this.finish();

                    }
                });
            }


            

        }




    }

    private void backAndexit(){



        if(frommain == true) {
            Drawable backbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.back);


            ImageButton backBtn = new ImageButton(this);

            backBtn.setImageDrawable(resizeButton(backbutton));
            backBtn.setLayoutParams(itemsLayoutparam);
            backBtn.setBackgroundResource(R.color.FullTransparent);
            backBtn.setPadding((int) backgroundx * 2, 0, 0, 0);

            linLayoutsecond.addView(backBtn);

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {

                    FrogFungiReport.this.finish();
                }
            });

        }

        Drawable exitbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.exitbutton);


        ImageButton exitBtn = new ImageButton(this);

        exitBtn.setImageDrawable(resizeButton(exitbutton));
        exitBtn.setLayoutParams(itemsLayoutparam);
        exitBtn.setBackgroundResource(R.color.FullTransparent);
        exitBtn.setPadding((int)backgroundx * 2, 0, 0, 0);

        linLayoutsecond.addView(exitBtn);

        exitBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View arg0){

                if(mInterstitialAd.isLoaded()){

                    mInterstitialAd.show();

                }





                MainActivity.contextMain.finish();
                FrogFungiReport.this.finish();

            }
        });



    }

    private void requestNewInterstitial() {


        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


}
