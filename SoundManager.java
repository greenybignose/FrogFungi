package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 4/23/2017.
 */
public class SoundManager {
    private int frogjump = -1;
    private int frogsing = -1;
    private int oceanwave = -1;
    private int lava = -1;
    private int streamone;
    private int streamtwo;
    private int streamthree;
    private int streamfour;
    long oldTime = 0;


public void loadSound(FrogFungiPlayerState frogFungiPlayerStatesm){





        frogjump = MainActivity.contextMain.mSoundPool.load(MainActivity.contextMain, R.raw.frogjump, 1);

       frogsing = MainActivity.contextMain.mSoundPool.load(MainActivity.contextMain, R.raw.frogsing, 1);


        if(frogFungiPlayerStatesm.getWorld().matches("Ocean")){

            oceanwave = MainActivity.contextMain.mSoundPool.load(MainActivity.contextMain, R.raw.oceanwave, 1);

        }
             else if(frogFungiPlayerStatesm.getWorld().matches("Lava")){

            lava = MainActivity.contextMain.mSoundPool.load(MainActivity.contextMain, R.raw.lava, 1);

        }


}

public void playSound(String sound){
    switch(sound){

        case "frogjump":
            if(MainActivity.contextMain.loadedone) {
             streamone = MainActivity.contextMain.mSoundPool.play(frogjump, 1, 1, 1, 0, 1);
            }
            break;
        case "frogsing":
            streamtwo = MainActivity.contextMain.mSoundPool.play(frogsing, 1, 1, 1, -1, 1);
            break;
        case "oceanwave":
            if(MainActivity.contextMain.loadedthree) {

                streamthree = MainActivity.contextMain.mSoundPool.play(oceanwave, 1, 1, 1, 0, 1);
            }
            break;
        case "lava":
            if(MainActivity.contextMain.loadedthree) {

                streamfour = MainActivity.contextMain.mSoundPool.play(lava, 1, 1, 1, 0, 1);
            }
            break;

    }
}

 public void stopSound(String sound) {

        switch(sound) {
            case "frogsing":

                MainActivity.contextMain.mSoundPool.stop(streamtwo);
                break;
        }
 }



}
