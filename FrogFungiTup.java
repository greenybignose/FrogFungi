package com.verticesstudio.frogfungi;

import android.provider.BaseColumns;

/**
 * Created by kucrut on 6/4/2016.
 */
final class FrogFungiTup {

    FrogFungiTup(){

    }

    static abstract class FrogFungiEntry implements BaseColumns{
        public static final String TABLE_NAME = "FrogFungiDat";
        public static final String COLUMN_NAME_NO = "No";
        public static final String COLUMN_NAME_WORLD = "World";
        public static final String COLUMN_NAME_LEVEL = "Level";
        public static final String COLUMN_NAME_LIVES = "Lives";
        public static final String COLUMN_NAME_PREY = "Prey";
        public static final String COLUMN_NAME_FOOD = "Food";
    }
}
