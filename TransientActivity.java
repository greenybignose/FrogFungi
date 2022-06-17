package com.verticesstudio.frogfungi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;


/**
 * Created by kucrut on 11/29/2016.
 */
public class TransientActivity extends Activity {

    String worlds;
    String levels;
    int lives;
    int prey;
    int food;
    boolean frompv;
    boolean gamewin;
    Intent transInt;
    InterstitialAd mInterstitialAd;
    Random counter;
    int x;
    int counterresult;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.transient_activity);
        gamewin = false;
        counter = new Random();
        counterresult = counter.nextInt(5);
        x = 0;

        Bundle extra = getIntent().getExtras();


        if(extra != null) {


            lives = getIntent().getExtras().getInt("lives");
            worlds = getIntent().getExtras().getString("worlds");
            levels = getIntent().getExtras().getString("levels");
            prey = getIntent().getExtras().getInt("prey");
            food = getIntent().getExtras().getInt("food");

            frompv = getIntent().getExtras().getBoolean("frompv");

            if(extra.containsKey("gamewin")){
                gamewin = getIntent().getExtras().getBoolean("gamewin");
            }
        }

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5555041155278389/4176198751");

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }

            public void onAdClosed(){
                if(x < counterresult) {
                    requestNewInterstitial();
                    x++;
                }

            }



        });


        requestNewInterstitial();






        transInt = new Intent(getBaseContext(), MainActivity.class);
        transInt.putExtra("worlds", worlds);
        transInt.putExtra("levels", levels);
        transInt.putExtra("lives", lives);
        transInt.putExtra("prey", prey);
        transInt.putExtra("food", food);
        transInt.putExtra("frompv", frompv);

        if(gamewin == true){
            transInt.putExtra("gamewin", gamewin);
        }

        MainActivity.contextMain.finish();







    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();



        startActivity(transInt);
        TransientActivity.this.finish();

    }

    private void requestNewInterstitial() {


        AdRequest adRequest = new AdRequest.Builder()
                                .build();

        mInterstitialAd.loadAd(adRequest);
    }


}
