package com.verticesstudio.frogfungi;

/**
 * Created by kucrut on 1/17/2016.
 */

import android.graphics.PointF;

import java.util.ArrayList;

public class FrogFungiPlayerState {
    private int prey;
    private int food;
    private int lives;
    private String level;
    private String world;

    FrogFungiPlayerState() {
        lives = 3;
        prey = 0;
        food = 0;
        level = "LevelOne";
        world = "Ocean";
    }


    int getLives() {
        return this.lives;
    }

    int getPrey() {

        return this.prey;
    }

    int getFood() {
        return this.food;
    }

    String getLevel(){
        return this.level;
    }

    String getWorld() {
        return this.world;
    }



    void setLives(int lives) {
        this.lives = lives;
    }

    void setPrey(int prey) {
        this.prey = prey;
    }

    void setFood(int food) {
        this.food = food;
    }

    void setLevel(String level){
        this.level = level;
    }

    void setWorld(String world) {
        this.world = world;
    }

    void addLives(int lives) {
        this.lives += lives;
    }

    void addPrey(int prey) {
        this.prey += prey;
    }

    void addFood(int food) {
        this.food += food;
    }

    void delLives(int lives) {
        this.lives -= lives;
    }

    void delPrey(int prey) {
        this.prey -= prey;
    }

    void delFood(int food) {
        this.food -= food;
    }

}
