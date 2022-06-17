package com.verticesstudio.frogfungi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;


public class MainActivity extends Activity implements SoundPool.OnLoadCompleteListener {
    private FrogFungiPlatformView frogFungiplatformView;



    FrogFungiPlayerState frogFungiPlayerState;


    static MainActivity contextMain = null;
    static int resolutionx = 0;
    static int resolutiony = 0;
    static boolean initialload;
    static boolean newLevelUp;
    static int changeresolution;
    String levels;
    boolean frompv;
    int PERMISSION_READ_STATE = 1;

    boolean loadedone = false;
    boolean loadedtwo = false;
    boolean loadedthree = false;

    SoundPool mSoundPool;
    final int MAX_STREAM = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialload = true;
        levels = "";
        frompv = false;
        contextMain = this;
        newLevelUp = false;


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);




        resolutiony = displaymetrics.heightPixels;
        resolutionx = displaymetrics.widthPixels;
        if(resolutiony > resolutionx){
            changeresolution = resolutionx;
            resolutionx = resolutiony;
            resolutiony = changeresolution;
        }




        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE},
                        PERMISSION_READ_STATE);
            }

        }


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(MAX_STREAM)
                    .build();

        } else {
            mSoundPool = new SoundPool(MAX_STREAM, AudioManager.STREAM_MUSIC, 0);
        }


        mSoundPool.setOnLoadCompleteListener(this);








        frogFungiPlayerState = new FrogFungiPlayerState();

        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            if (extra.containsKey("levels") && extra.containsKey("frompv")) {

                frogFungiPlayerState.setWorld(getIntent().getExtras().getString("worlds"));
                frogFungiPlayerState.setLevel(getIntent().getExtras().getString("levels"));
                frogFungiPlayerState.setLives(getIntent().getExtras().getInt("lives"));
                frogFungiPlayerState.setPrey(getIntent().getExtras().getInt("prey"));
                frogFungiPlayerState.setFood(getIntent().getExtras().getInt("food"));

                initialload = false;

                if(extra.containsKey("gamewin") && getIntent().getExtras().getBoolean("gamewin") == true) {
                    newLevelUp = true;
                }

            } else if(extra.containsKey("levels")) {
                frogFungiPlayerState.setWorld(getIntent().getExtras().getString("worlds"));
                frogFungiPlayerState.setLevel(getIntent().getExtras().getString("levels"));
                frogFungiPlayerState.setLives(3);
                frogFungiPlayerState.setFood(0);
                frogFungiPlayerState.setPrey(0);
                initialload = false;
            }

        }




        frogFungiplatformView = new FrogFungiPlatformView(frogFungiPlayerState);
        // Make our platformView the view for the Activity
        setContentView(frogFungiplatformView);




    }


    @Override
    protected void onPause() {
        super.onPause();
        frogFungiplatformView.pause();
        mSoundPool.autoPause();
        new Thread(new WriteFrogDatabase(frogFungiPlayerState)).start();


    }

    @Override
    protected void onResume() {
        super.onResume();


        frogFungiplatformView.resume();
        mSoundPool.autoResume();
    }




@Override
protected  void onDestroy(){
    super.onDestroy();



}




    static Context getmyAppcontext() {
        return contextMain.getApplicationContext();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent refresh = new Intent(this, MainActivity.class);


                    startActivity(refresh);
                    finish();

                } else {
                    finish();
                }
                return;
            }

        }
    }

    @Override
    public void onLoadComplete(SoundPool msoundPool, int sampleId, int status) {
        if(sampleId == 1 && status == 0){

           loadedone = true;
        }
        else if(sampleId == 2 && status == 0){
           loadedtwo = true;
            }

        else if(sampleId == 3 && status == 0){
            loadedthree = true;
        }

    }





}


