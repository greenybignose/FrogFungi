package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 1/15/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Random;


public abstract class GameObject {

        Vector2Point5D worldLocation;
        private float width;
        private float height;

        private boolean visible;
        boolean setinitialfrogposx;
        boolean setinitialfrogposy;
        boolean initialcondition;
        private char type;
        private String bitmapName;
        private String bitmapNameRight;
        private String bitmapNameLeft;
        private String bitmapNameJumpLeft;
        private String bitmapNameJumpRight;
        private float xVelocity;
        private float yVelocity;
        private float backgroundxResolution;
        private float backgroundyResolution;
        private String facing;
        Boolean changefrogfungionetime;
        int nextxPosition;
        int nextyPosition;
        int suckerbeegravrand;
        int bighorngravrand;
        int sandladybugrand;
        int transparentchubrand;
        int waterdroprand;
        int lavadroprand;
        int fungilavarand;
        int jumpingratlavarand;
        int lavafurrand;
        int gravitycloudrand;
        float steps;
        float currentxWorld;
        float circledistance;
        boolean flip;
        String fungitype;
        int fungitypepos;
        String fungitypesecond;
        int fungitypesecondpos;
        int firefungihold;
        int satellitecode;
        float currentyWorld;
        long oldTime;
        long oldTimesecond;
        float currentxPositionSaved;
        float currentyPositionSaved;
         float speed;
        Bitmap giantFungi;
        int valuehold;
        int barkbugIndex;
        float radius;

        long newTime;
        Random rand;
        String condition;
        Values enemyValue;


    ArrayList<Bitmap> BackgroundBitmap;
    ArrayList<Bitmap> fungiBitmap;
    ArrayList<Bitmap> babyfungiBitmap;
    ArrayList<Bitmap> teenfungiBitmap;
    ArrayList<Bitmap> fungispecialBitmap;
    ArrayList<Bitmap> tonguewormoneBitmap;
    ArrayList<Bitmap> tonguewormtwoBitmap;
    ArrayList<Bitmap> tonguewormthreeBitmap;
    ArrayList<Bitmap> firefungiBitmap;

    ArrayList<Values> fungitypelavastatus;

    Integer[] funginumber;
    Integer[] fungispecialnumber;
    Integer[] fungiArray;
    Integer[] listofinitialfungiposminus;
    Integer[] listofinitialfungipos;
    Integer[] tonguewormnumber;
    Integer[] firefunginumber;


    float HEIGHT;
    float WIDTH;
    float bitmapWidth;
    float bitmapHeight;
    float savedxvelocity;
    float savedyvelocity;
    float firstconditionposx;
    float firstconditionposy;
    float secondconditionposx;
    float secondconditionposy;
    float thirdconditionposx;
    float thirdconditionposy;


        boolean changeFrogPosition;
        void update(long fps){

        }


    RectHitbox rectHitboxtop;
    RectHitbox rectHitboxright;
    RectHitbox rectHitboxbottom;
    RectHitbox rectHitboxleft;
    RectHitbox rectHitboxdclick;
    RectHitbox rectHitboxcircle;

    public String getBitmapName() {
        return bitmapName;
    }


    public String getBitmapNameRight() {
            return bitmapNameRight;
        }

    public String getBitmapNameJumpRight() {
        return bitmapNameJumpRight;
    }

    public String getBitmapNameLeft() {
        return bitmapNameLeft;
    }

    public String getBitmapNameJumpLeft(){
        return bitmapNameJumpLeft;
    }


    public Bitmap prepareBitmap(String bitmapName, String Level, String World) {



        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inScaled = false;


            // Make a resource id from the bitmapetName
            int resID = MainActivity.getmyAppcontext().getResources().getIdentifier(bitmapName, "drawable",
                    MainActivity.getmyAppcontext().getPackageName());
            // Create the bitmap


            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getmyAppcontext().getResources(), resID, options);




        if(Level.matches("LevelOne") && World.matches("Ocean")) {

            if (bitmapName.matches("beegravright") || bitmapName.matches("beegravleft") || bitmapName.matches("smalloceanfishright")
                    || bitmapName.matches("smalloceanfishleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            } else {

                bitmap = bitmapScaleFull(bitmap);


            }
        }


        else if(Level.matches("LevelTwo") && World.matches("Ocean")) {

            if (bitmapName.matches("beegravright") || bitmapName.matches("beegravleft") || bitmapName.matches("smalloceanfishright")
                    || bitmapName.matches("smalloceanfishleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            } else {

                bitmap = bitmapScaleFull(bitmap);


            }
        }



        else if(Level.matches("LevelThree") && World.matches("Ocean")) {

            if (bitmapName.matches("beegravright") || bitmapName.matches("beegravleft") || bitmapName.matches("smalloceanfishright")
                    || bitmapName.matches("smalloceanfishleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            } else {

                bitmap = bitmapScaleFull(bitmap);


            }
        }



        else if(Level.matches("LevelFour") && World.matches("Ocean")) {

            if (bitmapName.matches("beegravright") || bitmapName.matches("beegravleft") || bitmapName.matches("smalloceanfishright")
                    || bitmapName.matches("smalloceanfishleft") || bitmapName.matches("waterdropjumpright") || bitmapName.matches("waterdropjumpleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            }

            else if (bitmapName.matches("waterdropleft") ) {

                    bitmap = bitmapScaleThreeQuarter(bitmap);
            }

            else {
                bitmap = bitmapScaleFull(bitmap);


            }
        }


        else if(Level.matches("LevelOne") && World.matches("Lava")) {

            if (bitmapName.matches("smalllavafishleft") || bitmapName.matches("smalllavafishright") || bitmapName.matches("rockbeegravleft")
                    || bitmapName.matches("rockbeegravright")) {
                bitmap = bitmapScaleHalf(bitmap);
            }
            else if(bitmapName.matches("dustrockbeegravlavaright") || bitmapName.matches("dustrockbeegravlavaleft")
                    || bitmapName.matches("jumpingratlavaleft") || bitmapName.matches("jumpingratlavaright")){
                bitmap = bitmapScaleThreeQuarter(bitmap);
            }

            else {

                bitmap = bitmapScaleFull(bitmap);


            }
        }

            else if(Level.matches("LevelTwo") && World.matches("Lava")) {

            if (bitmapName.matches("smalllavafishleft") || bitmapName.matches("smalllavafishright") || bitmapName.matches("rockbeegravleft")
                    || bitmapName.matches("rockbeegravright")) {
                bitmap = bitmapScaleHalf(bitmap);
            }
            else if(bitmapName.matches("dustrockbeegravlavaright") || bitmapName.matches("dustrockbeegravlavaleft")
                    || bitmapName.matches("jumpingratlavaleft") || bitmapName.matches("jumpingratlavaright")){
                bitmap = bitmapScaleThreeQuarter(bitmap);
            }

            else {

                bitmap = bitmapScaleFull(bitmap);


            }

           }


        else if(Level.matches("LevelThree") && World.matches("Lava")) {

            if (bitmapName.matches("smalllavafishleft") || bitmapName.matches("smalllavafishright") || bitmapName.matches("rockbeegravleft")
                    || bitmapName.matches("rockbeegravright")
                    || bitmapName.matches("lavadropjumpright") || bitmapName.matches("lavadropjumpleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            }
            else if(bitmapName.matches("lavadropleft")){
                bitmap = bitmapScaleThreeQuarter(bitmap);
            }
            else if(bitmapName.matches("gravitycloudright") || bitmapName.matches("gravitycloudleft") || bitmapName.matches("lavafurjumpright")){
                bitmap = bitmapScaleFullFourTimes(bitmap);
            }
            else {

                bitmap = bitmapScaleFull(bitmap);


            }

        }

        else if(Level.matches("LevelFour") && World.matches("Lava")) {

            if (bitmapName.matches("smalllavafishleft") || bitmapName.matches("smalllavafishright") || bitmapName.matches("rockbeegravleft")
                    || bitmapName.matches("rockbeegravright")
                    || bitmapName.matches("dustbulletright") || bitmapName.matches("dustbulletleft")) {
                bitmap = bitmapScaleHalf(bitmap);
            }
            else if(bitmapName.matches("dustbulletjumpright")){
                bitmap = bitmapScaleThreeQuarter(bitmap);
            }
            else if(bitmapName.matches("gravitycloudright") || bitmapName.matches("gravitycloudleft") || bitmapName.matches("lavafurjumpright")){
                bitmap = bitmapScaleFullFourTimes(bitmap);
            }

            else {

                bitmap = bitmapScaleFull(bitmap);


            }

        }







        setBitmapWidth(bitmap.getWidth());
            setBitmapHeight(bitmap.getHeight());

            return bitmap;
        }


    Bitmap bitmapScaleHalf(Bitmap bitmap){
        if (MainActivity.resolutionx == 800 && MainActivity.resolutiony == 480) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 10)/2,
                    (MainActivity.resolutiony / 6)/2,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 720) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 16)/2,
                    (MainActivity.resolutiony / 9)/2,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 800) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 16)/2,
                    (MainActivity.resolutiony / 10)/2,
                    false);


        } else if (MainActivity.resolutionx == 1920 && MainActivity.resolutiony == 1080) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 24)/2,
                    (int) (MainActivity.resolutiony / 13.5f)/2,
                    false);


        } else if (MainActivity.resolutionx == 2560 && MainActivity.resolutiony == 1440) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 32)/2,
                    (int) (MainActivity.resolutiony / 18)/2,
                    false);


        } else {

            bitmap = Bitmap.createScaledBitmap(bitmap, 80/2,
                    80/2, false);


        }

        return bitmap;
    }

    Bitmap bitmapScaleThreeQuarter(Bitmap bitmap){
        if (MainActivity.resolutionx == 800 && MainActivity.resolutiony == 480) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) ((MainActivity.resolutionx / 10) * 3)/4,
                    ((MainActivity.resolutiony / 6) * 3)/4,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 720) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) ((MainActivity.resolutionx / 16) * 3)/4,
                    ((MainActivity.resolutiony / 9) * 3)/4,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 800) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) ((MainActivity.resolutionx / 16) * 3)/4,
                    ((MainActivity.resolutiony / 10) * 3)/4,
                    false);


        } else if (MainActivity.resolutionx == 1920 && MainActivity.resolutiony == 1080) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) ((MainActivity.resolutionx / 24) * 3)/4,
                    (int) ((MainActivity.resolutiony / 13.5f) * 3)/4,
                    false);


        } else if (MainActivity.resolutionx == 2560 && MainActivity.resolutiony == 1440) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) ((MainActivity.resolutionx / 32) * 3)/4,
                    (int) ((MainActivity.resolutiony / 18) * 3)/4,
                    false);


        } else {

            bitmap = Bitmap.createScaledBitmap(bitmap, (80 *3)/4,
                    (80 * 3)/4, false);


        }

        return bitmap;
    }


    Bitmap bitmapScaleFull(Bitmap bitmap){
        if (MainActivity.resolutionx == 800 && MainActivity.resolutiony == 480) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) MainActivity.resolutionx / 10,
                    MainActivity.resolutiony / 6,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 720) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) MainActivity.resolutionx / 16,
                    MainActivity.resolutiony / 9,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 800) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) MainActivity.resolutionx / 16,
                    MainActivity.resolutiony / 10,
                    false);


        } else if (MainActivity.resolutionx == 1920 && MainActivity.resolutiony == 1080) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) MainActivity.resolutionx / 24,
                    (int) (MainActivity.resolutiony / 13.5f),
                    false);


        } else if (MainActivity.resolutionx == 2560 && MainActivity.resolutiony == 1440) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) MainActivity.resolutionx / 32,
                    (int) (MainActivity.resolutiony / 18),
                    false);


        } else {

            bitmap = Bitmap.createScaledBitmap(bitmap, 80,
                    80, false);


        }

        return bitmap;

    }


    Bitmap bitmapScaleFullFourTimes(Bitmap bitmap){
        if (MainActivity.resolutionx == 800 && MainActivity.resolutiony == 480) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 10) * 4,
                    (MainActivity.resolutiony / 6) * 4,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 720) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 16) * 4,
                    (MainActivity.resolutiony / 9) * 4,
                    false);


        } else if (MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 800) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 16) * 4,
                    (MainActivity.resolutiony / 10) * 4,
                    false);


        } else if (MainActivity.resolutionx == 1920 && MainActivity.resolutiony == 1080) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 24) * 4,
                    (int) (MainActivity.resolutiony / 13.5f) * 4,
                    false);


        } else if (MainActivity.resolutionx == 2560 && MainActivity.resolutiony == 1440) {

            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (MainActivity.resolutionx / 32) * 4,
                    (int) (MainActivity.resolutiony / 18) * 4,
                    false);


        } else {

            bitmap = Bitmap.createScaledBitmap(bitmap, 80 * 4,
                    80 * 4, false);


        }

        return bitmap;

    }


    public Vector2Point5D getWorldLocation() {
            return worldLocation;
        }

        public void setWorldLocation(float x, float y) {
            this.worldLocation.x = x;
            this.worldLocation.y = y;
        }

        void setBitmapWidth(float bitmapWidth){
            this.bitmapWidth = bitmapWidth;
        }

        void setBitmapHeight(float bitmapHeight){
            this.bitmapHeight = bitmapHeight;
        }

        float getBitmapWidth(){
            return bitmapWidth;
        }

        float getBitmapHeight(){
            return bitmapHeight;
        }

    public void setBitmapName(String bitmapName) {
        this.bitmapName = bitmapName;
    }



    public void setBitmapNameRight(String bitmapNameRight) {
            this.bitmapNameRight = bitmapNameRight;
        }

    public void setBitmapNameLeft(String bitmapNameLeft){
        this.bitmapNameLeft = bitmapNameLeft;
    }

    public void setBitmapNameJumpRight(String bitmapNameJumpRight) {
        this.bitmapNameJumpRight = bitmapNameJumpRight;
    }

    public void setBitmapNameJumpLeft(String bitmapNameJumpLeft){
        this.bitmapNameJumpLeft = bitmapNameJumpLeft;
    }



        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {

            this.height = height;
        }


        public boolean getVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        void setChangeFrogPosition(boolean changeFrogPosition){
            this.changeFrogPosition = changeFrogPosition;
        }

        boolean getChangeFrogPosition(){
            return changeFrogPosition;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }

        void setbackgroundxResolution(float backgroundxResolution){
            this.backgroundxResolution = backgroundxResolution;
        }

        void setbackgroundyResolution(float backgroundyResolution){
            this.backgroundyResolution = backgroundyResolution;
        }


        float getbackgroundxResolution(){
            return backgroundxResolution;
        }

        float getbackgroundyResolution(){
            return backgroundyResolution;
        }


        public String getFacing() {
            return facing;
        }


        public void setFacing(String facing) {
            this.facing = facing;
        }

        public float getxVelocity() {
            return xVelocity;
        }

        public void setxVelocity(float xVelocity) {


                this.xVelocity += xVelocity;

        }

    void resetxVelocity(){
        xVelocity = 0;
    }

        float getyVelocity() {
            return yVelocity;
        }

        void setyVelocity(float yVelocity) {

                this.yVelocity += yVelocity;
        }

    void resetyVelocity(){
        yVelocity = 0;
    }

        void setSavedxvelocity(float savedxvelocity){
            this.savedxvelocity += savedxvelocity;
        }

        void setSavedyvelocity(float savedyvelocity){
            this.savedyvelocity += savedyvelocity;
        }

        float getSavedxvelocity(){
            return this.savedxvelocity;
        }

        float getSavedyvelocity(){
            return this.savedyvelocity;
        }

        void resetSavedxvelocity() {
            savedxvelocity = 0;
        }

        void resetSavedyvelocity(){
            savedyvelocity = 0;
        }

        public void setWorldLocationY(float y) {

            this.worldLocation.y = y;
        }

        public void setWorldLocationX(float x) {

            this.worldLocation.x = x;
        }

        void initializeBackgroundBitmap(){

        }

        void initializefungiBitmap(){}

    void setRectHitboxtop(float top, float right, float bottom, float left) {
        this.rectHitboxtop.top = top;
        this.rectHitboxtop.right = right;
        this.rectHitboxtop.bottom = bottom;
        this.rectHitboxtop.left = left;
    }

    void setRectHitboxright(float top, float right, float bottom, float left) {
        this.rectHitboxright.top = top;
        this.rectHitboxright.right = right;
        this.rectHitboxright.bottom = bottom;
        this.rectHitboxright.left = left;
    }

    void setRectHitboxbottom(float top, float right, float bottom, float left) {
        this.rectHitboxbottom.top = top;
        this.rectHitboxbottom.right = right;
        this.rectHitboxbottom.bottom = bottom;
        this.rectHitboxbottom.left = left;
    }

    void setRectHitboxleft(float top, float right, float bottom, float left) {
        this.rectHitboxleft.top = top;
        this.rectHitboxleft.right = right;
        this.rectHitboxleft.bottom = bottom;
        this.rectHitboxleft.left = left;
    }

    void setRectHitboxdclick(float top, float right, float bottom, float left) {
        this.rectHitboxdclick.top = top;
        this.rectHitboxdclick.right = right;
        this.rectHitboxdclick.bottom = bottom;
        this.rectHitboxdclick.left = left;
    }

    void setRectHitboxcirle(float radius, float radiusxcenter, float radiusycenter){
        this.rectHitboxcircle.radius = radius;
        this.rectHitboxcircle.radiusxcenter = radiusxcenter;
        this.rectHitboxcircle.radiusycenter = radiusycenter;

    }

void setHitBoxPosition(float currentxWorld, float currentyWorld){

}


    RectHitbox getrectHitboxtop() {

        return rectHitboxtop;
    }

    RectHitbox getrectHitboxright() {

        return rectHitboxright;
    }

    RectHitbox getrectHitboxbottom() {

        return rectHitboxbottom;
    }

    RectHitbox getrectHitboxleft() {

        return rectHitboxleft;
    }

    RectHitbox getrectHitboxcircle() {

        return rectHitboxcircle;

    }


    RectHitbox getRectHitboxdclick(){
        return rectHitboxdclick;
    }


    boolean checkCollisions(RectHitbox rectHitbox) {
        boolean collided = false;



    if(rectHitbox.radius == 0 && rectHitbox.radiusxcenter == 0 && rectHitbox.radiusycenter == 0){

            if (getrectHitboxtop().intersects(rectHitbox)) {


                collided = true;
                return collided;
            }

            if (getrectHitboxright().intersects(rectHitbox)) {

                collided = true;
                return collided;
            }

            if (getrectHitboxbottom().intersects(rectHitbox)) {

                collided = true;
                return collided;
            }

            if (getrectHitboxleft().intersects(rectHitbox)) {


                collided = true;
                return collided;
            }
        }
        else if(rectHitbox.radius != 0 && rectHitbox.radiusxcenter != 0 && rectHitbox.radiusycenter != 0){
        if (getrectHitboxcircle().intersectcircle(rectHitbox)) {


            collided = true;
            return collided;
        }

    }
        return collided;
    }

    void updateEnemy(float fps, float currentfrogxPosition, float currentfrogyPosition, float currentbeegravxPosition,
                       float currentbeegravyPosition) {
    }


    void updateEnemyLevelTwo(float fps, float currentfrogxPosition, float currentfrogyPosition, float currentbeegravxPosition,
                     float currentbeegravyPosition) {
    }


    float getradius(){
        return radius;
    };




}


