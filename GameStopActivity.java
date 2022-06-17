package com.verticesstudio.frogfungi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * Created by kucrut on 11/24/2016.
 */
public class GameStopActivity extends Activity {

    float backgroundx;
    float backgroundy;
    boolean frogfungi;
    boolean worlds;
    String worldlevel;
    int lives;
    String levels;
    int prey;
    int food;
    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5555041155278389/8524553555");

        requestNewInterstitial();


        backgroundx = getIntent().getExtras().getFloat("backgroundx");
        backgroundy = getIntent().getExtras().getFloat("backgroundy");
        worldlevel = getIntent().getExtras().getString("worlds");
        lives = getIntent().getExtras().getInt("lives");
        levels = getIntent().getExtras().getString("levels");
        prey = getIntent().getExtras().getInt("prey");
        food = getIntent().getExtras().getInt("food");


        LinearLayout.LayoutParams linLayoutparentparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams linLayoutsecondparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams linLayoutthirdparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams linLayoutfourthparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        LinearLayout.LayoutParams itemsLayoutparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);



        LinearLayout linparentLayout = new LinearLayout(this);
        linparentLayout.setLayoutParams(linLayoutparentparam);
        linparentLayout.setBackgroundResource(R.color.colorTransparent);

        linparentLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout linLayoutsecond = new LinearLayout(this);
        linLayoutsecond.setLayoutParams(linLayoutsecondparam);
        linLayoutsecond.setBackgroundResource(R.color.FullTransparent);

        linLayoutsecond.setOrientation(LinearLayout.HORIZONTAL);


        LinearLayout linLayoutthird = new LinearLayout(this);
        linLayoutthird.setLayoutParams(linLayoutthirdparam);
        linLayoutthird.setBackgroundResource(R.color.FullTransparent);


        linLayoutthird.setOrientation(LinearLayout.HORIZONTAL);



        LinearLayout linLayoutfourth = new LinearLayout(this);
        linLayoutfourth.setLayoutParams(linLayoutfourthparam);



        linLayoutfourth.setOrientation(LinearLayout.HORIZONTAL);





        Drawable worldsbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.worldsbutton);



        ImageButton worldBtn = new ImageButton(this);


        worldBtn.setImageDrawable(resizeButton(worldsbutton));
        worldBtn.setLayoutParams(itemsLayoutparam);
        worldBtn.setBackgroundResource(R.color.FullTransparent);
        worldBtn.measure(0, 0);
        worldBtn.setPadding(MainActivity.resolutionx/4 - worldBtn.getMeasuredWidth()/2, 0, 0, 0);

        linLayoutsecondparam.topMargin = MainActivity.resolutiony/4 - worldBtn.getMeasuredHeight()/2;
        linLayoutsecondparam.bottomMargin = MainActivity.resolutiony/4 - worldBtn.getMeasuredHeight()/2;

        linLayoutsecond.addView(worldBtn);


        worldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                worlds = true;
                frogfungi = false;

                Intent Worlds = new Intent(getBaseContext(), FrogFungiReport.class);
                Worlds.putExtra("backgroundx", backgroundx);
                Worlds.putExtra("backgroundy", backgroundy);
                Worlds.putExtra("worlds", worlds);
                Worlds.putExtra("worldlevel", worldlevel);
                Worlds.putExtra("frogfungi", frogfungi);
                Worlds.putExtra("lives", lives);
                Worlds.putExtra("levels", levels);
                Worlds.putExtra("prey", prey);
                Worlds.putExtra("food", food);



                startActivity(Worlds);
                GameStopActivity.this.finish();


            }

        });


        Drawable frogfungibutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.frogfungibutton);


        final ImageButton frogfungiBtn = new ImageButton(this);

        frogfungiBtn.setImageDrawable(resizeButton(frogfungibutton));
        frogfungiBtn.setLayoutParams(itemsLayoutparam);
        frogfungiBtn.setBackgroundResource(R.color.FullTransparent);
        frogfungiBtn.measure(0, 0);
        frogfungiBtn.setPadding(((MainActivity.resolutionx/4) * 2) - frogfungiBtn.getMeasuredWidth()/2
                - worldBtn.getMeasuredWidth()/2, 0, 0, 0);

        linLayoutsecond.addView(frogfungiBtn);


        frogfungiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                frogfungi = true;
                worlds = false;

                Intent frogfungiReport = new Intent(getBaseContext(), FrogFungiReport.class);
                frogfungiReport.putExtra("backgroundx", backgroundx);
                frogfungiReport.putExtra("backgroundy", backgroundy);
                frogfungiReport.putExtra("lives", lives);
                frogfungiReport.putExtra("levels", levels);
                frogfungiReport.putExtra("worldlevel", worldlevel);
                frogfungiReport.putExtra("frogfungi", frogfungi);
                frogfungiReport.putExtra("worlds", worlds);



                startActivity(frogfungiReport);
                GameStopActivity.this.finish();



            }

        });


        Drawable reloadbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.reloadbutton);


        ImageButton ReloadBtn = new ImageButton(this);

        ReloadBtn.setImageDrawable(resizeButton(reloadbutton));
        ReloadBtn.setLayoutParams(itemsLayoutparam);
        ReloadBtn.measure(0, 0);
        ReloadBtn.setPadding(MainActivity.resolutionx/4 - ReloadBtn.getMeasuredWidth()/2, 0, 0, 0);

        ReloadBtn.setBackgroundResource(R.color.FullTransparent);

        linLayoutthirdparam.topMargin = MainActivity.resolutiony/4 - worldBtn.getMeasuredHeight()/2;



        linLayoutthird.addView(ReloadBtn);


        ReloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

           Intent reloadInt = new Intent(getBaseContext(), MainActivity.class);








                    reloadInt.putExtra("levels", levels);
                    reloadInt.putExtra("worlds", worldlevel);






              MainActivity.contextMain.finish();

                startActivity(reloadInt);


                mInterstitialAd.setAdListener(new AdListener() {

                    @Override
                    public void onAdLoaded() {


                        mInterstitialAd.show();

                    }

                });





                GameStopActivity.this.finish();



            }

        });

        Drawable exitbutton = ContextCompat.getDrawable(MainActivity.getmyAppcontext(), R.drawable.exitbutton);


        ImageButton exitBtn = new ImageButton(this);

        exitBtn.setImageDrawable(resizeButton(exitbutton));
        exitBtn.setLayoutParams(itemsLayoutparam);
        exitBtn.measure(0, 0);
        exitBtn.setPadding(((MainActivity.resolutionx/4) * 2) - exitBtn.getMeasuredWidth()/2
                - ReloadBtn.getMeasuredWidth()/2, 0, 0, 0);

        exitBtn.setBackgroundResource(R.color.FullTransparent);

        linLayoutthird.addView(exitBtn);

        exitBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View arg0){

                if(mInterstitialAd.isLoaded()){

                    mInterstitialAd.show();

                }



                MainActivity.contextMain.finish();
                GameStopActivity.this.finish();

            }
        });







        linparentLayout.addView(linLayoutsecond);

        linparentLayout.addView(linLayoutthird);

        linparentLayout.addView(linLayoutfourth);




        setContentView(linparentLayout);


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
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, (int)backgroundx, (int)backgroundy/2, false);
        return new BitmapDrawable(getResources(), bitmapResized);

    }


    private void requestNewInterstitial() {


        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


}
