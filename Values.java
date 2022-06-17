package com.verticesstudio.frogfungi;

import java.util.ArrayList;

/**
 * Created by kucrut on 2/7/2017.
 */
public class Values {

    int fungitypelavapos;
    int fungitypelavastatus;
    boolean trigger;
    long oldTime;
    int lengthofcomparisonarr;

    int y;
    ArrayList<Float> bugPosition;
    ArrayList<Float> bugPositionadder;
    ArrayList<Float> bugPositiondelete;
    ArrayList<Float> bugPositionadderdelete;


    Values(){
        bugPosition = new ArrayList<Float>();
        bugPositionadder = new ArrayList<Float>();
        bugPositiondelete = new ArrayList<Float>();
        bugPositionadderdelete = new ArrayList<Float>();

        trigger = false;
        oldTime = 0;
        y = 4;
    }
}
