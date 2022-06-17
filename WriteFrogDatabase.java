package com.verticesstudio.frogfungi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kucrut on 6/10/2016.
 */


class WriteFrogDatabase implements Runnable {

    private SQLiteDatabase sqdb;
    private ContentValues cvFrog;
    private FrogFungiPlayerState frogFungiPlayerStategWmd;
    private Cursor cur;

    WriteFrogDatabase(FrogFungiPlayerState frogfungiPlayerStateWmd){
        this.frogFungiPlayerStategWmd = frogfungiPlayerStateWmd;
        cvFrog = new ContentValues();



    }

        public void run() {

            cvFrog.put(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_WORLD, frogFungiPlayerStategWmd.getWorld());
            cvFrog.put(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LEVEL, frogFungiPlayerStategWmd.getLevel());
            cvFrog.put(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_PREY, frogFungiPlayerStategWmd.getPrey());
            cvFrog.put(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_FOOD, frogFungiPlayerStategWmd.getFood());
            cvFrog.put(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LIVES, frogFungiPlayerStategWmd.getLives());

            sqdb = new FrogFungiHelpDb().getWritableDatabase();

       String[] wmdqueryno = {FrogFungiTup.FrogFungiEntry.COLUMN_NAME_NO};
            String[] wmdselectionargs = { frogFungiPlayerStategWmd.getLevel(), frogFungiPlayerStategWmd.getWorld()};


            cur = sqdb.query(FrogFungiTup.FrogFungiEntry.TABLE_NAME, wmdqueryno,
                    FrogFungiTup.FrogFungiEntry.COLUMN_NAME_LEVEL + " = ?" + " AND " +
                            FrogFungiTup.FrogFungiEntry.COLUMN_NAME_WORLD + " = ?", wmdselectionargs, null, null, null);



            if (cur != null && cur.getCount() > 0) {

                if (cur != null && cur.moveToFirst()) {

                    sqdb.update(FrogFungiTup.FrogFungiEntry.TABLE_NAME,
                            cvFrog,
                            FrogFungiTup.FrogFungiEntry.COLUMN_NAME_NO + " = " +
                                    cur.getString(cur.getColumnIndexOrThrow(FrogFungiTup.FrogFungiEntry.COLUMN_NAME_NO)),
                            null);

                    cur.close();
                }

            }

            else {


                sqdb.insert(FrogFungiTup.FrogFungiEntry.TABLE_NAME,
                        "null",
                        cvFrog);

            }


            sqdb.close();

        }

    }


