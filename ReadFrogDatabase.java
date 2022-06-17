package com.verticesstudio.frogfungi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kucrut on 6/15/2016.
 */
class ReadFrogDatabase {

    private SQLiteDatabase sqdb;
    private Cursor cur;


     ReadFrogDatabase(FrogFungiPlayerState frogfungiPlayerStatermd){

         sqdb = new FrogFungiHelpDb().getReadableDatabase();

        String[] rmdquery = { FrogFungiTup.FrogFungiEntry.COLUMN_NAME_WORLD,
                FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LEVEL,
        FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LIVES,
                FrogFungiTup.FrogFungiEntry.COLUMN_NAME_PREY,
                FrogFungiTup.FrogFungiEntry.COLUMN_NAME_FOOD,
                 };

        cur = sqdb.query(FrogFungiTup.FrogFungiEntry.TABLE_NAME, rmdquery, null, null, null, null, null);

        if(cur != null && cur.moveToLast()){
            frogfungiPlayerStatermd.setWorld(cur.getString(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_WORLD)));
            frogfungiPlayerStatermd.setLevel(cur.getString(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LEVEL)));
            frogfungiPlayerStatermd.setLives(cur.getInt(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LIVES)));
            frogfungiPlayerStatermd.setPrey(cur.getInt(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_PREY)));
            frogfungiPlayerStatermd.setFood(cur.getInt(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_FOOD)));

        }
        else {

            frogfungiPlayerStatermd.setWorld("Ocean");

            frogfungiPlayerStatermd.setLevel("LevelOne");

            frogfungiPlayerStatermd.setLives(3);
            frogfungiPlayerStatermd.setPrey(0);
            frogfungiPlayerStatermd.setFood(0);
        }



    sqdb.close();

    }

}
