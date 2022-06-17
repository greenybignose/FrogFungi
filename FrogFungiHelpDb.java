package com.verticesstudio.frogfungi;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kucrut on 6/4/2016.
 */
class FrogFungiHelpDb extends SQLiteOpenHelper {


    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + FrogFungiTup.FrogFungiEntry.TABLE_NAME + "("
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_NO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_WORLD + " TEXT,"
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LEVEL + " TEXT,"
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LIVES + " INTEGER,"
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_PREY + " INTEGER,"
            + FrogFungiTup.FrogFungiEntry.COLUMN_NAME_FOOD + " INTEGER"
            + ")";

    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXIST" + FrogFungiTup.FrogFungiEntry.TABLE_NAME;

    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "FrogFungiEntry.db";


    FrogFungiHelpDb() {
        super(MainActivity.getmyAppcontext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int a, int b){

    }
}








