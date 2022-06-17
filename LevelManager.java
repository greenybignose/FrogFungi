package com.verticesstudio.frogfungi;


import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;


public class LevelManager {
    private String level;

    FrogFungiPlayer frogFungiPlayer;
    SoundManager soundManager;

    String frogObject;
    String beegravObject;
    String beegravsecondObject;
    String beegravthirdObject;
    String beegravfourthObject;
    String bigbeegravObject;
    String bigbeegravsecondObject;
    String bighorngravObject;
    String smalloceanfishObject;
    String bigoceanfishObject;
    String oceanbugObject;
    String oceanbugsecondObject;
    String oceanbugthirdObject;
    String oceanbugfourthObject;
    String sandladybugObject;

    String swirlwaterObject;
    String swirlwatersecondObject;
    String swirlwaterthirdObject;


    String stargravObject;
    String stargravsecondObject;
    String stargravthirdObject;

    String splashflyObject;

    String redbubbleObject;

    
    String smalllavafishObject;
    String biglavafishObject;
    
    String rockbeegravObject;
    String rockbeegravsecondObject;
    String rockbeegravthirdObject;
    String rockbeegravfourthObject;   
    
    String rockbigbeegravObject;
    String rockbigbeegravsecondObject;
    String rockbigbeegravthirdObject;
    String rockbigbeegravfourthObject;

    String dustrockbeegravlavaObject;
    String dustrockbeegravlavasecondObject;
    String dustrockbeegravlavathirdObject;
    String dustrockbeegravlavafourthObject;

    String bigdustrockbeegravlavaObject;
    String bigdustrockbeegravlavasecondObject;
    String bigdustrockbeegravlavathirdObject;
    String bigdustrockbeegravlavafourthObject;

    String fungilavaObject;
    String jumpingratlavaObject;

    String guardianbeegravObject;


    String suckerbeegravObject;
    String killerbeegravObject;

    String waterdropObject;

    String lavadropObject;

    String transparentchubObject;

    String barkbugObject;

    String dustbulletObject;

    String dustbulletsecondObject;
    String dustbulletthirdObject;
    String dustbulletfourthObject;

    String ghostspinderbigdustrockbeegravlavaObject;
    String ghostspindersecondbigdustrockbeegravlavaObject;
    String ghostspinderthirdbigdustrockbeegravlavaObject;
    String ghostspinderfourthbigdustrockbeegravlavaObject;

    String ghostspinderswirlwaterObject;
    String ghostspindersecondswirlwaterObject;
    String ghostspinderthirdswirlwaterObject;

    String ghostspinderstargravObject;
    String ghostspindersecondstargravObject;
    String ghostspinderthirdstargravObject;

    String ghostspindersplashflyObject;

    String lavafurObject;
    String gravitycloudObject;


    GameObject bgLandscape;


    float BeginX;
    float BeginY;
    float bitmapWidth;
    float bitmapHeight;
    
    Integer[] firstpreyarraystart;
    Integer[] secondpreyarraystart;
    Integer[] firstpreyarrayfinish;
    Integer[] secondpreyarrayfinish;
    Integer[] arraylistofsandladybugposition;
    Integer[] arraylistoflavabugposition;
    Integer[] arraylistoflavafurposition;

    Integer[] arraylistofsuckerbeegravposition;
    Integer[] arraylistoftransparentchubposition;
    Integer[] arraylistofbarkbugposition;
    Integer[] arraylistofbarkbuglocation;
    Integer[] arraylistofbighorngravescape;
    Integer[] arraylistofredbubbleposition;

    Integer[] arraylistofwaterdropposition;
    Integer[] arraylistofwaterdropone;
    Integer[] arraylistofwaterdroptwo;
    Integer[] arraylistofwaterdropthree;
    Integer[] arraylistofwaterdropfour;
    Integer[][] arraylistofwaterdropdestination;

    Integer[] arraylistoflavadropposition;
    Integer[] arraylistoflavadropone;
    Integer[] arraylistoflavadroptwo;
    Integer[] arraylistoflavadropthree;
    Integer[] arraylistoflavadropfour;
    Integer[] arraylistoflavadropfive;
    Integer[][] arraylistoflavadropdestination;


    ArrayList<GameObject> swirlwatergameObjects;
    ArrayList<GameObject> swirlwatersecondgameObjects;
    ArrayList<GameObject> swirlwaterthirdgameObjects;



    ArrayList<GameObject> splashflygameObjects;

    ArrayList<GameObject> stargravgameObjects;
    ArrayList<GameObject> stargravsecondgameObjects;
    ArrayList<GameObject> stargravthirdgameObjects;


    ArrayList<GameObject> beegravgameObjects;
    ArrayList<GameObject> beegravsecondgameObjects;
    ArrayList<GameObject> beegravthirdgameObjects;
    ArrayList<GameObject> beegravfourthgameObjects;

    ArrayList<GameObject> bigbeegravgameObjects;
    ArrayList<GameObject> bigbeegravsecondgameObjects;
    ArrayList<GameObject> bigbeegravthirdgameObjects;
    ArrayList<GameObject> bigbeegravfourthgameObjects;

    ArrayList<GameObject> bighorngravgameObjects;
    ArrayList<GameObject> smalloceanfishgameObjects;
    ArrayList<GameObject> bigoceanfishgameObjects;
    ArrayList<GameObject> oceanbuggameObjects;
    ArrayList<GameObject> oceanbugsecondgameObjects;
    ArrayList<GameObject> oceanbugthirdgameObjects;
    ArrayList<GameObject> oceanbugfourthgameObjects;



    ArrayList<GameObject> sandladybuggameObjects;


    ArrayList<GameObject> smalllavafishgameObjects;
    ArrayList<GameObject> biglavafishgameObjects;
    ArrayList<GameObject> rockbeegravgameObjects;
    ArrayList<GameObject> rockbeegravsecondgameObjects;
    ArrayList<GameObject> rockbeegravthirdgameObjects;
    ArrayList<GameObject> rockbeegravfourthgameObjects;


    ArrayList<GameObject> rockbigbeegravgameObjects;
    ArrayList<GameObject> rockbigbeegravsecondgameObjects;
    ArrayList<GameObject> rockbigbeegravthirdgameObjects;
    ArrayList<GameObject> rockbigbeegravfourthgameObjects;



    ArrayList<GameObject> dustrockbeegravlavagameObjects;
    ArrayList<GameObject> dustrockbeegravlavasecondgameObjects;
    ArrayList<GameObject> dustrockbeegravlavathirdgameObjects;
    ArrayList<GameObject> dustrockbeegravlavafourthgameObjects;


    ArrayList<GameObject> bigdustrockbeegravlavagameObjects;
    ArrayList<GameObject> bigdustrockbeegravlavasecondgameObjects;
    ArrayList<GameObject> bigdustrockbeegravlavathirdgameObjects;
    ArrayList<GameObject> bigdustrockbeegravlavafourthgameObjects;


    ArrayList<GameObject> fungilavagameObjects;
    ArrayList<GameObject> jumpingratlavagameObjects;

    ArrayList<GameObject> guardianbeegravgameObjects;

    ArrayList<GameObject> suckerbeegravgameObjects;
    ArrayList<GameObject> killerbeegravgameObjects;

    ArrayList<GameObject> waterdropgameObjects;

    ArrayList<GameObject> lavadropgameObjects;

    ArrayList<GameObject> transparentchubgameObjects;

    ArrayList<GameObject> barkbuggameObjects;

    ArrayList<GameObject> redbubblegameObjects;

    ArrayList<GameObject> dustbulletgameObjects;

    ArrayList<GameObject> dustbulletsecondgameObjects;

    ArrayList<GameObject> dustbulletthirdgameObjects;

    ArrayList<GameObject> dustbulletfourthgameObjects;

    ArrayList<GameObject> ghostspinderbigdustrockbeegravlavagameObjects;

    ArrayList<GameObject> ghostspindersecondbigdustrockbeegravlavagameObjects;

    ArrayList<GameObject> ghostspinderthirdbigdustrockbeegravlavagameObjects;

    ArrayList<GameObject> ghostspinderfourthbigdustrockbeegravlavagameObjects;


    ArrayList<GameObject> ghostspinderswirlwatergameObjects;

    ArrayList<GameObject> ghostspindersecondswirlwatergameObjects;

    ArrayList<GameObject> ghostspinderthirdswirlwatergameObjects;

    ArrayList<GameObject> ghostspinderstargravgameObjects;

    ArrayList<GameObject> ghostspindersecondstargravgameObjects;

    ArrayList<GameObject> ghostspinderthirdstargravgameObjects;

    ArrayList<GameObject> ghostspindersplashflygameObjects;


    ArrayList<GameObject> notesonghostspindergameObjects;

    ArrayList<GameObject> lavafurgameObjects;

    ArrayList<GameObject> gravitycloudgameObjects;

    Bitmap[] bitmapsArray;

    public LevelManager(FrogFungiPlayerState frogFungiPlayerStatelm) {


        if(MainActivity.initialload == true) {
            new ReadFrogDatabase(frogFungiPlayerStatelm);

            if(frogFungiPlayerStatelm.getLives() == 0){
                frogFungiPlayerStatelm.setLives(3);
            }

        }

        soundManager = new SoundManager();

        if(frogFungiPlayerStatelm.getLevel().matches("LevelOne") && frogFungiPlayerStatelm.getWorld().matches("Ocean")) {



                frogObject = "r";
                beegravObject = "bbb";
                bigbeegravObject = "iii";
                bighorngravObject = "h";
                smalloceanfishObject = "fffff";
                bigoceanfishObject = "FFFF";
                oceanbugObject = "ooo";
                sandladybugObject = "sss";

                bgLandscape = new Ocean();

                firstpreyarraystart = new Integer[]{350, 1200, 1000, 800, 300, 470, 600, 150, 1450, 150,
                                    1600, 1100, 1400, 750, 1850, 830, 2350, 650, 2400, 1100};

                secondpreyarraystart = new Integer[]{150, 1200, 950, 1400, 1470, 1170, 2800, 1600, 150, 1250,
                                    2920, 840};

                firstpreyarrayfinish = new Integer[]{1000, 1370, 1650, 1050, 850, 700, 1100, 630, 1050, 650,
                                        2050, 1430, 1850, 950, 2350, 1150, 2930, 770, 3050, 1000};

                secondpreyarrayfinish = new Integer[]{950, 700, 1600, 1080, 2270, 570, 2370, 1130, 1050, 1650,
                                    2500, 150};

                arraylistofsandladybugposition = new Integer[]{3000, 1400, 2750, 1200, 2700, 550, 2350, 320, 2120, 350,
                                                        1600, 600, 950, 320, 540, 640, 540, 880, 420, 620,
                                                        220, 780, 420, 1560, 540, 1520, 1220, 1100, 2040, 1040,
                                                        1320, 1300, 3040, 1440, 1220, 1080, 720, 1060, 640, 980,
                                                            380, 600, 2640, 540};


                beegravgameObjects = new ArrayList<GameObject>();
                bigbeegravgameObjects = new ArrayList<GameObject>();
                bighorngravgameObjects = new ArrayList<GameObject>();
                smalloceanfishgameObjects = new ArrayList<GameObject>();
                bigoceanfishgameObjects = new ArrayList<GameObject>();
                oceanbuggameObjects = new ArrayList<GameObject>();
                sandladybuggameObjects = new ArrayList<GameObject>();


        }


       else if(frogFungiPlayerStatelm.getLevel().matches("LevelTwo") && frogFungiPlayerStatelm.getWorld().matches("Ocean")) {



            frogObject = "r";
            beegravObject = "bbbb";
            beegravsecondObject = "bbbbbbbb";
            beegravthirdObject = "bbbbbbbb";
            beegravfourthObject = "bbbbbbb";
            bigbeegravObject = "iii";
            bigbeegravsecondObject = "iiiii";
            guardianbeegravObject = "ggg";
            bighorngravObject = "h";
            smalloceanfishObject = "ffffffffff";
            bigoceanfishObject = "FFFFFF";
            oceanbugObject = "ooooo";
            oceanbugsecondObject = "ooooo";
            sandladybugObject = "ssssss";

            bgLandscape = new OceanTwo();
            firstpreyarraystart = new Integer[]{350, 1200, 1000, 800, 300, 470, 600, 150, 1450, 150,
                    1600, 1100, 1400, 750, 1850, 830, 2350, 650, 2400, 1100};

            secondpreyarraystart = new Integer[]{150, 1200, 950, 1400, 1470, 1170, 2800, 1600, 150, 1250,
                    2920, 840};

            firstpreyarrayfinish = new Integer[]{1000, 1370, 1650, 1050, 850, 700, 1100, 630, 1050, 650,
                    2050, 1430, 1850, 950, 2350, 1150, 2930, 770, 3050, 1000};

            secondpreyarrayfinish = new Integer[]{950, 700, 1600, 1080, 2270, 570, 2370, 1130, 1050, 1650,
                    2500, 150};


            arraylistofsandladybugposition = new Integer[]{3000, 1400, 2750, 1200, 2700, 550, 2350, 320, 2120, 350,
                    1600, 600, 950, 320, 540, 640, 540, 880, 420, 620,
                    220, 780, 420, 1560, 540, 1520, 1220, 1100, 2040, 1040,
                    1320, 1300, 3040, 1440, 1220, 1080, 720, 1060, 640, 980,
                    380, 600, 2640, 540};


            arraylistofbighorngravescape = new Integer[9];

            for(int x = 6; x < (bgLandscape.funginumber.length - 9); x++){

                arraylistofbighorngravescape[x - 6] = x;

            }


            beegravgameObjects = new ArrayList<GameObject>();
            beegravsecondgameObjects = new ArrayList<GameObject>();
            beegravthirdgameObjects = new ArrayList<GameObject>();
            beegravfourthgameObjects = new ArrayList<GameObject>();

            bigbeegravgameObjects = new ArrayList<GameObject>();
            bigbeegravsecondgameObjects = new ArrayList<GameObject>();

            guardianbeegravgameObjects = new ArrayList<GameObject>();
            bighorngravgameObjects = new ArrayList<GameObject>();
            smalloceanfishgameObjects = new ArrayList<GameObject>();
            bigoceanfishgameObjects = new ArrayList<GameObject>();
            oceanbuggameObjects = new ArrayList<GameObject>();
            oceanbugsecondgameObjects= new ArrayList<GameObject>();
            sandladybuggameObjects = new ArrayList<GameObject>();


        }



        else if(frogFungiPlayerStatelm.getLevel().matches("LevelThree") && frogFungiPlayerStatelm.getWorld().matches("Ocean")) {



            frogObject = "r";
            beegravObject = "bbbb";
            beegravsecondObject = "bbbbbbbb";
            beegravthirdObject = "bbbbbbbbbbb";

            suckerbeegravObject = "kkkkk";
            killerbeegravObject = "lllll";

            bigbeegravObject = "iiiii";
            bigbeegravsecondObject = "iiiiii";

            smalloceanfishObject = "ffffffffff";
            bigoceanfishObject = "FFFFFF";

            swirlwaterObject = "wwww";
            swirlwatersecondObject = "wwwwwwww";
            swirlwaterthirdObject = "wwwwwwwwww";

            stargravObject = "vvvvv";
            stargravsecondObject = "vvvvvvvvvvvv";
            stargravthirdObject = "vvvvvvvvvv";


            sandladybugObject = "ssss";

            ghostspinderswirlwaterObject = "GGGG";
            ghostspinderstargravObject = "GGGGG";


            ghostspindersecondswirlwaterObject = "GGGG";
            ghostspindersecondstargravObject = "GGGGGG";


            ghostspinderthirdswirlwaterObject = "GGGG";
            ghostspinderthirdstargravObject = "GGGG";


            bgLandscape = new OceanThree();
            firstpreyarraystart = new Integer[]{350, 1200, 1000, 800, 300, 470, 600, 150, 1450, 150,
                    1600, 1100, 1400, 750, 1850, 830, 2350, 650, 2400, 1100};

            secondpreyarraystart = new Integer[]{150, 1200, 950, 1400, 1470, 1170, 2800, 1600, 150, 1250,
                    2920, 840};

            firstpreyarrayfinish = new Integer[]{1000, 1370, 1650, 1050, 850, 700, 1100, 630, 1050, 650,
                    2050, 1430, 1850, 950, 2350, 1150, 2930, 770, 3050, 1000};

            secondpreyarrayfinish = new Integer[]{950, 700, 1600, 1080, 2270, 570, 2370, 1130, 1050, 1650,
                    2500, 150};


            arraylistofsandladybugposition = new Integer[]{3000, 1400, 2750, 1200, 2700, 550, 2350, 320, 2120, 350,
                    1600, 600, 950, 320, 540, 640, 540, 880, 420, 620,
                    220, 780, 420, 1560, 540, 1520, 1220, 1100, 2040, 1040,
                    1320, 1300, 3040, 1440, 1220, 1080, 720, 1060, 640, 980,
                    380, 600, 2640, 540};

            arraylistofsuckerbeegravposition = bgLandscape.fungiArray;



            swirlwatergameObjects = new ArrayList<GameObject>();
            swirlwatersecondgameObjects = new ArrayList<GameObject>();
            swirlwaterthirdgameObjects = new ArrayList<GameObject>();


            stargravgameObjects = new ArrayList<GameObject>();
            stargravsecondgameObjects = new ArrayList<GameObject>();
            stargravthirdgameObjects = new ArrayList<GameObject>();





            beegravgameObjects = new ArrayList<GameObject>();
            beegravsecondgameObjects = new ArrayList<GameObject>();
            beegravthirdgameObjects = new ArrayList<GameObject>();
            beegravfourthgameObjects = new ArrayList<GameObject>();

            suckerbeegravgameObjects = new ArrayList<GameObject>();
            killerbeegravgameObjects = new ArrayList<GameObject>();

            bigbeegravgameObjects = new ArrayList<GameObject>();
            bigbeegravsecondgameObjects = new ArrayList<GameObject>();
            bigbeegravthirdgameObjects = new ArrayList<GameObject>();
            bigbeegravfourthgameObjects = new ArrayList<GameObject>();



            smalloceanfishgameObjects = new ArrayList<GameObject>();
            bigoceanfishgameObjects = new ArrayList<GameObject>();

            oceanbuggameObjects = new ArrayList<GameObject>();
            oceanbugsecondgameObjects = new ArrayList<GameObject>();
            oceanbugthirdgameObjects = new ArrayList<GameObject>();
            oceanbugfourthgameObjects = new ArrayList<GameObject>();


            sandladybuggameObjects = new ArrayList<GameObject>();

            ghostspinderswirlwatergameObjects = new ArrayList<GameObject>();
            ghostspinderstargravgameObjects = new ArrayList<GameObject>();


            ghostspindersecondswirlwatergameObjects = new ArrayList<GameObject>();
            ghostspindersecondstargravgameObjects = new ArrayList<GameObject>();


            ghostspinderthirdswirlwatergameObjects = new ArrayList<GameObject>();
            ghostspinderthirdstargravgameObjects = new ArrayList<GameObject>();

            notesonghostspindergameObjects = new ArrayList<GameObject>();

        }


        else if(frogFungiPlayerStatelm.getLevel().matches("LevelFour") && frogFungiPlayerStatelm.getWorld().matches("Ocean")) {



            frogObject = "r";
            beegravObject = "bbbbbb";
            beegravsecondObject = "bbbbbbbbb";
            beegravthirdObject = "bbbbbbbbbbbb";
            beegravfourthObject = "bbbbbbbbbbb";


            suckerbeegravObject = "kkkkk";

            smalloceanfishObject = "ffffffffff";
            bigoceanfishObject = "FFFFFF";

            oceanbugObject = "oooooooo";
            oceanbugsecondObject = "oooooo";
            oceanbugthirdObject = "ooooooo";
            oceanbugfourthObject = "oooooooo";

            swirlwaterObject = "wwwwwwww";
            stargravObject = "vvvvvvvv";

            swirlwatersecondObject = "wwwwwwwwwwwwwww";
            stargravsecondObject = "vvvvvvvvvvvvvvv";

            splashflyObject = "yy";


            ghostspindersplashflyObject = "GG";

            ghostspinderswirlwaterObject = "GGGG";
            ghostspinderstargravObject = "GGGG";

            ghostspindersecondswirlwaterObject = "GGGGG";
            ghostspindersecondstargravObject = "GGGGG";


            waterdropObject = "pppp";

            bgLandscape = new OceanFour();
            firstpreyarraystart = new Integer[]{350, 1200, 1000, 800, 300, 470, 600, 150, 1450, 150,
                    1600, 1100, 1400, 750, 1850, 830, 2350, 650, 2400, 1100};

            secondpreyarraystart = new Integer[]{150, 1200, 950, 1400, 1470, 1170, 2800, 1600, 150, 1250,
                    2920, 840};

            firstpreyarrayfinish = new Integer[]{1000, 1370, 1650, 1050, 850, 700, 1100, 630, 1050, 650,
                    2050, 1430, 1850, 950, 2350, 1150, 2930, 770, 3050, 1000};

            secondpreyarrayfinish = new Integer[]{950, 700, 1600, 1080, 2270, 570, 2370, 1130, 1050, 1650,
                    2500, 150};

            arraylistofsuckerbeegravposition = new Integer[]{300, 300, 3000, 1600, 2600, 500, 500, 1200, 1700, 400};

            arraylistofwaterdropposition = new Integer[]{150, 1200, 1850, 1600, 1900, 850, 2300, 950};
            arraylistofwaterdropone = new Integer[]{bgLandscape.fungiArray[10], bgLandscape.fungiArray[11], bgLandscape.fungiArray[2], bgLandscape.fungiArray[3],
                    bgLandscape.fungiArray[4], bgLandscape.fungiArray[5], bgLandscape.fungiArray[0], bgLandscape.fungiArray[1]};

            arraylistofwaterdroptwo = new Integer[]{bgLandscape.fungiArray[8], bgLandscape.fungiArray[9], bgLandscape.fungiArray[6], bgLandscape.fungiArray[7],
                    bgLandscape.fungiArray[12], bgLandscape.fungiArray[13], bgLandscape.fungiArray[42], bgLandscape.fungiArray[43]};

            arraylistofwaterdropthree = new Integer[]{bgLandscape.fungiArray[20], bgLandscape.fungiArray[21], bgLandscape.fungiArray[14], bgLandscape.fungiArray[15],
                    bgLandscape.fungiArray[26], bgLandscape.fungiArray[27], bgLandscape.fungiArray[36], bgLandscape.fungiArray[37]};

            arraylistofwaterdropfour = new Integer[]{bgLandscape.fungiArray[40], bgLandscape.fungiArray[41], bgLandscape.fungiArray[32], bgLandscape.fungiArray[33],
                    bgLandscape.fungiArray[34], bgLandscape.fungiArray[35], bgLandscape.fungiArray[30], bgLandscape.fungiArray[31]};



            arraylistofwaterdropdestination = new Integer[][]{arraylistofwaterdropone, arraylistofwaterdroptwo, arraylistofwaterdropthree,
                    arraylistofwaterdropfour};


            beegravgameObjects = new ArrayList<GameObject>();
            beegravsecondgameObjects = new ArrayList<GameObject>();
            beegravthirdgameObjects = new ArrayList<GameObject>();
            beegravfourthgameObjects = new ArrayList<GameObject>();


            suckerbeegravgameObjects = new ArrayList<GameObject>();



            smalloceanfishgameObjects = new ArrayList<GameObject>();
            bigoceanfishgameObjects = new ArrayList<GameObject>();

            oceanbuggameObjects = new ArrayList<GameObject>();
            oceanbugsecondgameObjects = new ArrayList<GameObject>();
            oceanbugthirdgameObjects = new ArrayList<GameObject>();
            oceanbugfourthgameObjects = new ArrayList<GameObject>();

            swirlwatergameObjects = new ArrayList<GameObject>();

            swirlwatersecondgameObjects = new ArrayList<GameObject>();

            stargravgameObjects = new ArrayList<GameObject>();

            stargravsecondgameObjects = new ArrayList<GameObject>();

            ghostspinderswirlwatergameObjects = new ArrayList<GameObject>();

            ghostspindersecondswirlwatergameObjects = new ArrayList<GameObject>();

            ghostspinderstargravgameObjects = new ArrayList<GameObject>();

            ghostspindersecondstargravgameObjects = new ArrayList<GameObject>();


            splashflygameObjects = new ArrayList<GameObject>();


            ghostspindersplashflygameObjects = new ArrayList<GameObject>();


            waterdropgameObjects = new ArrayList<GameObject>();

            notesonghostspindergameObjects = new ArrayList<GameObject>();

        }



        else if(frogFungiPlayerStatelm.getLevel().matches("LevelOne") && frogFungiPlayerStatelm.getWorld().matches("Lava")){

            frogObject = "r";
            smalllavafishObject = "llllllllll";
            biglavafishObject = "LLLLLL";
            rockbeegravObject = "bbbbb";
            rockbeegravsecondObject = "bbbbbb";

            rockbigbeegravObject = "BBBB";
            rockbigbeegravsecondObject = "BBBBB";

            dustrockbeegravlavaObject = "dddddddd";
            fungilavaObject = "FFFFF";
            jumpingratlavaObject = "JJJJJ";

            
            bgLandscape = new Lava();



            firstpreyarraystart = new Integer[]{200, 1550, 150, 600, 200, 500, 1050, 350, 2100, 930,
                                                2550, 530, 2300, 230, 2050, 1300, 1650, 430, 2100, 630};

            secondpreyarraystart = new Integer[]{2700, 1070, 2550, 800, 1430, 500, 750, 270, 150, 1000, 2270, 1030};

            firstpreyarrayfinish = new Integer[]{600, 1150, 750, 700, 500, 700, 1250, 650, 2600, 1070,
                                                2850, 330, 2170, 600, 1750, 1050, 1350, 750, 2550, 650};

            secondpreyarrayfinish = new Integer[]{2000, 930, 2170, 1000, 1800, 170, 1250, 650, 650, 1250, 2550, 750};

            arraylistoflavabugposition = bgLandscape.fungiArray;


            smalllavafishgameObjects = new ArrayList<GameObject>();
            biglavafishgameObjects = new ArrayList<GameObject>();
            rockbeegravgameObjects = new ArrayList<GameObject>();
            rockbeegravsecondgameObjects = new ArrayList<GameObject>();

            rockbigbeegravgameObjects = new ArrayList<GameObject>();
            rockbigbeegravsecondgameObjects = new ArrayList<GameObject>();

            dustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            fungilavagameObjects = new ArrayList<GameObject>();
            jumpingratlavagameObjects = new ArrayList<GameObject>();
            
            
        }

        else if(frogFungiPlayerStatelm.getLevel().matches("LevelTwo") && frogFungiPlayerStatelm.getWorld().matches("Lava")){

            frogObject = "r";
            smalllavafishObject = "llllllllll";
            biglavafishObject = "LLLLLL";
            bigdustrockbeegravlavaObject = "DDDDDDDD";

            rockbeegravObject = "bbbbbbbbb";
            rockbeegravsecondObject = "bbbbbbbbb";
            rockbeegravthirdObject = "bbbbbbbbb";
            rockbeegravfourthObject = "bbbbbbbbb";

            rockbigbeegravObject = "BBBBBBB";
            rockbigbeegravsecondObject = "BBBBBBBBBBB";
            rockbigbeegravthirdObject = "BBBBBBBBBB";
            rockbigbeegravfourthObject = "BBBBBBBBB";


            dustrockbeegravlavaObject = "dddddd";
            dustrockbeegravlavasecondObject = "dddddd";
            dustrockbeegravlavathirdObject = "ddddddd";
            dustrockbeegravlavafourthObject = "ddddddd";
            ghostspinderbigdustrockbeegravlavaObject = "GGGG";
            
            
            fungilavaObject = "FFFFF";
            jumpingratlavaObject = "JJJJJ";
            transparentchubObject = "ttttt";

            bgLandscape = new LavaTwo();



            firstpreyarraystart = new Integer[]{200, 1550, 150, 600, 200, 500, 1050, 350, 2100, 930,
                    2550, 530, 2300, 230, 2050, 1300, 1650, 430, 2100, 630};

            secondpreyarraystart = new Integer[]{2700, 1070, 2550, 800, 1430, 500, 750, 270, 150, 1000, 2270, 1030};

            firstpreyarrayfinish = new Integer[]{600, 1150, 750, 700, 500, 700, 1250, 650, 2600, 1070,
                    2850, 330, 2170, 600, 1750, 1050, 1350, 750, 2550, 650};

            secondpreyarrayfinish = new Integer[]{2000, 930, 2170, 1000, 1800, 170, 1250, 650, 650, 1250, 2550, 750};

            arraylistoflavabugposition = bgLandscape.fungiArray;
            arraylistoftransparentchubposition = bgLandscape.fungiArray;



            smalllavafishgameObjects = new ArrayList<GameObject>();
            biglavafishgameObjects = new ArrayList<GameObject>();
            rockbeegravgameObjects = new ArrayList<GameObject>();
            rockbeegravsecondgameObjects = new ArrayList<GameObject>();
            rockbeegravthirdgameObjects = new ArrayList<GameObject>();
            rockbeegravfourthgameObjects = new ArrayList<GameObject>();


            rockbigbeegravgameObjects = new ArrayList<GameObject>();
            rockbigbeegravsecondgameObjects = new ArrayList<GameObject>();
            rockbigbeegravthirdgameObjects = new ArrayList<GameObject>();
            rockbigbeegravfourthgameObjects = new ArrayList<GameObject>();


            dustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            dustrockbeegravlavasecondgameObjects = new ArrayList<GameObject>();
            dustrockbeegravlavathirdgameObjects = new ArrayList<GameObject>();
            dustrockbeegravlavafourthgameObjects = new ArrayList<GameObject>();

            bigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();

            ghostspinderbigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();

            fungilavagameObjects = new ArrayList<GameObject>();
            jumpingratlavagameObjects = new ArrayList<GameObject>();
            transparentchubgameObjects = new ArrayList<GameObject>();

            notesonghostspindergameObjects = new ArrayList<GameObject>();
        }

        else if(frogFungiPlayerStatelm.getLevel().matches("LevelThree") && frogFungiPlayerStatelm.getWorld().matches("Lava")){

            frogObject = "r";
            smalllavafishObject = "llllllllll";
            biglavafishObject = "LLLLLL";
            rockbeegravObject = "bbbbbbbbbbbb";
            rockbeegravsecondObject = "bbbbbbbbbbbb";
            rockbeegravthirdObject = "bbbbbbbbbbbbbbb";
            rockbeegravfourthObject = "bbbbbbbbbbbbbb";
            rockbigbeegravObject = "BBBBBBBBBBBB";
            rockbigbeegravsecondObject = "BBBBBBBBBBBBBBB";
            lavadropObject = "vvvvv";
            barkbugObject = "kkkkkkkkkk";
            lavafurObject = "aaaaa";
            gravitycloudObject = "ccccc";
            bigdustrockbeegravlavaObject = "DDDDDDDD";
            bigdustrockbeegravlavasecondObject = "DDDDDDDDD";
            bigdustrockbeegravlavathirdObject = "DDDDDDDDDDDDDDD";
            bigdustrockbeegravlavafourthObject = "DDDDDDDDDD";
            
            ghostspinderbigdustrockbeegravlavaObject = "GGGG";
            ghostspindersecondbigdustrockbeegravlavaObject = "GGG";
            ghostspinderthirdbigdustrockbeegravlavaObject = "GGGGG";
            ghostspinderfourthbigdustrockbeegravlavaObject = "GGGGG";
            
            bgLandscape = new LavaThree();



            firstpreyarraystart = new Integer[]{200, 1550, 150, 600, 200, 500, 1050, 350, 2100, 930,
                    2550, 530, 2300, 230, 2050, 1300, 1650, 430, 2100, 630};

            secondpreyarraystart = new Integer[]{2700, 1070, 2550, 800, 1430, 500, 750, 270, 150, 1000, 2270, 1030};

            firstpreyarrayfinish = new Integer[]{600, 1150, 750, 700, 500, 700, 1250, 650, 2600, 1070,
                    2850, 330, 2170, 600, 1750, 1050, 1350, 750, 2550, 650};

            secondpreyarrayfinish = new Integer[]{2000, 930, 2170, 1000, 1800, 170, 1250, 650, 650, 1250, 2550, 750};

            arraylistoflavabugposition = bgLandscape.fungiArray;

            arraylistoflavafurposition = bgLandscape.fungiArray;


            arraylistoflavadropposition = new Integer[]{300, 1500, 1300, 1650, 2100, 900, 2100, 1700, 1000, 600};
            arraylistoflavadropone = new Integer[]{bgLandscape.fungiArray[50], bgLandscape.fungiArray[51],
                    bgLandscape.fungiArray[42], bgLandscape.fungiArray[43], bgLandscape.fungiArray[40],
                    bgLandscape.fungiArray[41]};

            arraylistoflavadroptwo = new Integer[]{bgLandscape.fungiArray[56], bgLandscape.fungiArray[57],
                    bgLandscape.fungiArray[54], bgLandscape.fungiArray[55], bgLandscape.fungiArray[66],
                    bgLandscape.fungiArray[67]};

            arraylistoflavadropthree = new Integer[]{bgLandscape.fungiArray[0], bgLandscape.fungiArray[1],
                    bgLandscape.fungiArray[2], bgLandscape.fungiArray[3],
                    bgLandscape.fungiArray[4], bgLandscape.fungiArray[5]};

            arraylistoflavadropfour = new Integer[]{bgLandscape.fungiArray[22], bgLandscape.fungiArray[23],
                    bgLandscape.fungiArray[24], bgLandscape.fungiArray[25],
                 bgLandscape.fungiArray[72], bgLandscape.fungiArray[73]};


            arraylistoflavadropfive = new Integer[]{bgLandscape.fungiArray[16], bgLandscape.fungiArray[17],
                    bgLandscape.fungiArray[12], bgLandscape.fungiArray[13], bgLandscape.fungiArray[14],
                    bgLandscape.fungiArray[15]};

            arraylistoflavadropdestination = new Integer[][]{arraylistoflavadropone, arraylistoflavadroptwo, arraylistoflavadropthree,
                arraylistoflavadropfour, arraylistoflavadropfive};

            arraylistofbarkbugposition = new Integer[]{14, 14, 14, 19, 19, 24, 24, 24, 30, 30};

            arraylistofbarkbuglocation = new Integer[]{1, 2, 3, 2, 4, 2, 3, 4, 1, 3};



            smalllavafishgameObjects = new ArrayList<GameObject>();
            biglavafishgameObjects = new ArrayList<GameObject>();
            rockbeegravgameObjects = new ArrayList<GameObject>();
            rockbeegravsecondgameObjects = new ArrayList<GameObject>();
            rockbeegravthirdgameObjects = new ArrayList<GameObject>();
            rockbeegravfourthgameObjects = new ArrayList<GameObject>();

            rockbigbeegravgameObjects = new ArrayList<GameObject>();

            rockbigbeegravsecondgameObjects = new ArrayList<GameObject>();


            lavadropgameObjects = new ArrayList<GameObject>();
            barkbuggameObjects = new ArrayList<GameObject>();
            lavafurgameObjects = new ArrayList<GameObject>();
            gravitycloudgameObjects = new ArrayList<GameObject>();

            bigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavasecondgameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavathirdgameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavafourthgameObjects = new ArrayList<GameObject>();

            
            ghostspinderbigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            ghostspindersecondbigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            ghostspinderthirdbigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            ghostspinderfourthbigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();



            notesonghostspindergameObjects = new ArrayList<GameObject>();
            
            
        }

        else if(frogFungiPlayerStatelm.getLevel().matches("LevelFour") && frogFungiPlayerStatelm.getWorld().matches("Lava")){

            frogObject = "r";
            smalllavafishObject = "llllllllll";
            biglavafishObject = "LLLLLL";
            rockbeegravObject = "bbbbbbbbbbb";
            rockbeegravsecondObject = "bbbbbbbbbbb";
            rockbeegravthirdObject = "bbbbbbbbbb";
            rockbeegravfourthObject = "bbbbbbbbbbb";

            bigdustrockbeegravlavaObject = "DDD";
            bigdustrockbeegravlavasecondObject = "DDD";
            bigdustrockbeegravlavathirdObject = "DDDDD";
            bigdustrockbeegravlavafourthObject = "DDDDD";


            redbubbleObject = "e";

            dustbulletObject = "uuu";
            dustbulletsecondObject = "uuu";
            dustbulletthirdObject = "uuuuu";
            dustbulletfourthObject = "uuuuuuuuuu";


            lavafurObject = "aaaaa";
            gravitycloudObject = "ccccc";



            bgLandscape = new LavaFour();



            firstpreyarraystart = new Integer[]{200, 1550, 150, 600, 200, 500, 1050, 350, 2100, 930,
                    2550, 530, 2300, 230, 2050, 1300, 1650, 430, 2100, 630};

            secondpreyarraystart = new Integer[]{2700, 1070, 2550, 800, 1430, 500, 750, 270, 150, 1000, 2270, 1030};

            firstpreyarrayfinish = new Integer[]{600, 1150, 750, 700, 500, 700, 1250, 650, 2600, 1070,
                    2850, 330, 2170, 600, 1750, 1050, 1350, 750, 2550, 650};

            secondpreyarrayfinish = new Integer[]{2000, 930, 2170, 1000, 1800, 170, 1250, 650, 650, 1250, 2550, 750};


            arraylistoflavabugposition = bgLandscape.fungiArray;


            arraylistoflavafurposition = bgLandscape.fungiArray;


            arraylistofredbubbleposition = new Integer[]{bgLandscape.fungiArray[70], bgLandscape.fungiArray[71]};

            smalllavafishgameObjects = new ArrayList<GameObject>();
            biglavafishgameObjects = new ArrayList<GameObject>();
            rockbeegravgameObjects = new ArrayList<GameObject>();
            rockbeegravsecondgameObjects = new ArrayList<GameObject>();
            rockbeegravthirdgameObjects = new ArrayList<GameObject>();
            rockbeegravfourthgameObjects = new ArrayList<GameObject>();

            bigdustrockbeegravlavagameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavasecondgameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavathirdgameObjects = new ArrayList<GameObject>();
            bigdustrockbeegravlavafourthgameObjects = new ArrayList<GameObject>();

            redbubblegameObjects = new ArrayList<GameObject>();
            dustbulletgameObjects = new ArrayList<GameObject>();
            dustbulletsecondgameObjects = new ArrayList<GameObject>();
            dustbulletthirdgameObjects = new ArrayList<GameObject>();
            dustbulletfourthgameObjects = new ArrayList<GameObject>();

            lavafurgameObjects = new ArrayList<GameObject>();
            gravitycloudgameObjects = new ArrayList<GameObject>();



        }




        tuningResolution(bgLandscape);


        loadMapData(frogFungiPlayerStatelm);

    }

    public int getBitmapIndexLevelOneOcean(char blockType) {
        int index;

        switch (blockType) {

            case 'b':
                index = 4;
                break;

            case 'f':
                index = 6;
                break;
            case 'F':
                index = 8;
                break;
            case 'i':
                index = 10;
                break;
            case 'h':
                index = 12;
                break;
            case 's':
                index = 14;
                break;
            case 'o':
                index = 16;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }

    public int getBitmapIndexLevelTwoOcean(char blockType) {
        int index;

        switch (blockType) {

            case 'b':
                index = 4;
                break;

            case 'f':
                index = 6;
                break;
            case 'F':
                index = 8;
                break;
            case 'i':
                index = 10;
                break;
            case 'h':
                index = 12;
                break;
            case 's':
                index = 14;
                break;
            case 'o':
                index = 16;
                break;
            case 'g':
                index = 18;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }

    public int getBitmapIndexLevelThreeOcean(char blockType) {
        int index;

        switch (blockType) {

            case 'b':
                index = 4;
                break;

            case 'f':
                index = 6;
                break;
            case 'F':
                index = 8;
                break;
            case 'i':
                index = 10;
                break;
            case 's':
                index = 12;
                break;
            case 'o':
                index = 14;
                break;
            case 'k':
                index = 16;
                break;
            case 'l':
                index = 18;
                break;
            case 'v':
                index = 20;
                break;
            case 'w':
                index = 22;
                break;

            default:
                index = 0;
                break;
        }
        return index;
    }

    public int getBitmapIndexLevelFourOcean(char blockType) {
        int index;

        switch (blockType) {

            case 'b':
                index = 4;
                break;

            case 'f':
                index = 6;
                break;
            case 'F':
                index = 8;
                break;
            case 'o':
                index = 10;
                break;
            case 'k':
                index = 12;
                break;
            case 'p':
                index = 14;
                break;
            case 'v':
                index = 18;
                break;
            case 'w':
                index = 20;
                break;
            case 'y':
                index = 22;
                break;

            default:
                index = 0;
                break;
        }
        return index;
    }



    public int getBitmapIndexLevelOneLava(char blockType) {
        int index;

        switch (blockType) {
             case 'l':
                index = 4;
                break;

            case 'L':
                index = 6;
                break;
            case 'b':
                index = 8;
                break;
            case 'B':
                index = 10;
                break;
            case 'd':
                index = 12;
                break;
            case 'F':
                index = 14;
                break;
            case 'J':
                index = 15;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }


    public int getBitmapIndexLevelTwoLava(char blockType) {
        int index;

        switch (blockType) {
            case 'l':
                index = 4;
                break;

            case 'L':
                index = 6;
                break;
            case 'b':
                index = 8;
                break;
            case 'B':
                index = 10;
                break;
            case 'd':
                index = 12;
                break;
            case 'D':
                index = 14;
                break;
            case 'F':
                index = 16;
                break;
            case 't':
                index = 17;
                break;
            case 'J':
                index = 19;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }



    public int getBitmapIndexLevelThreeLava(char blockType) {
        int index;

        switch (blockType) {
            case 'l':
                index = 4;
                break;

            case 'L':
                index = 6;
                break;
            case 'b':
                index = 8;
                break;
            case 'B':
                index = 10;
                break;
            case 'D':
                index = 12;
                break;
            case 'v':
                index = 14;
                break;
            case 'a':
                index = 18;
                break;
            case 'c':
                index = 21;
                break;
            case 'k':
                index = 23;
                break;

            default:
                index = 0;
                break;
        }
        return index;
    }


    public int getBitmapIndexLevelFourLava(char blockType) {
        int index;

        switch (blockType) {
            case 'l':
                index = 4;
                break;

            case 'L':
                index = 6;
                break;
            case 'b':
                index = 8;
                break;
            case 'a':
                index = 10;
                break;
            case 'c':
                index = 13;
                break;

            case 'D':
                index = 15;
                break;
            case 'e':
                index = 17;
                break;
            case 'u':
                index = 20;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }



    private void loadMapData(FrogFungiPlayerState frogFungiPlayerStatelmd) {


        char c;
        int currentIndex = -1;
        soundManager.loadSound(frogFungiPlayerStatelmd);



        




            if(frogFungiPlayerStatelmd.getLevel().matches("LevelOne") && frogFungiPlayerStatelmd.getWorld().matches("Ocean")) {


                levelOneOceanObject(frogFungiPlayerStatelmd);

                

            }


       else if(frogFungiPlayerStatelmd.getLevel().matches("LevelTwo") && frogFungiPlayerStatelmd.getWorld().matches("Ocean")) {


            levelTwoOceanObject(frogFungiPlayerStatelmd);



        }


            else if(frogFungiPlayerStatelmd.getLevel().matches("LevelThree") && frogFungiPlayerStatelmd.getWorld().matches("Ocean")) {


                levelThreeOceanObject(frogFungiPlayerStatelmd);



            }


            else if(frogFungiPlayerStatelmd.getLevel().matches("LevelFour") && frogFungiPlayerStatelmd.getWorld().matches("Ocean")) {


                levelFourOceanObject(frogFungiPlayerStatelmd);



            }



        else if(frogFungiPlayerStatelmd.getLevel().matches("LevelOne") && frogFungiPlayerStatelmd.getWorld().matches("Lava")) {

            levelOneLavaObject(frogFungiPlayerStatelmd);
            
        }


            else if(frogFungiPlayerStatelmd.getLevel().matches("LevelTwo") && frogFungiPlayerStatelmd.getWorld().matches("Lava")) {

                levelTwoLavaObject(frogFungiPlayerStatelmd);

            }


            else if(frogFungiPlayerStatelmd.getLevel().matches("LevelThree") && frogFungiPlayerStatelmd.getWorld().matches("Lava")) {

                levelThreeLavaObject(frogFungiPlayerStatelmd);

            }


            else if(frogFungiPlayerStatelmd.getLevel().matches("LevelFour") && frogFungiPlayerStatelmd.getWorld().matches("Lava")) {

                levelFourLavaObject(frogFungiPlayerStatelmd);

            }


        for (int j = 0; j < frogObject.length(); j++) {
            c = frogObject.charAt(j);

            currentIndex++;



            switch (c) {
                case 'r':


                    frogFungiPlayer = new FrogFungiPlayer(BeginX, BeginY, bgLandscape.getbackgroundxResolution(), bgLandscape.getbackgroundyResolution());
                    bitmapsArray[0] = frogFungiPlayer.prepareBitmap(frogFungiPlayer.getBitmapNameRight(), frogFungiPlayerStatelmd.getLevel(), frogFungiPlayerStatelmd.getWorld());
                    bitmapsArray[1] = frogFungiPlayer.prepareBitmap(frogFungiPlayer.getBitmapNameLeft(), frogFungiPlayerStatelmd.getLevel(), frogFungiPlayerStatelmd.getWorld());
                    bitmapsArray[2] = frogFungiPlayer.prepareBitmap(frogFungiPlayer.getBitmapNameJumpRight(), frogFungiPlayerStatelmd.getLevel(), frogFungiPlayerStatelmd.getWorld());
                    bitmapsArray[3] = frogFungiPlayer.prepareBitmap(frogFungiPlayer.getBitmapNameJumpLeft(), frogFungiPlayerStatelmd.getLevel(), frogFungiPlayerStatelmd.getWorld());


                    break;


            }

        }







    }



    void tuningResolution(GameObject Landscape){

        if(MainActivity.resolutiony > MainActivity.resolutionx){
            MainActivity.changeresolution = MainActivity.resolutionx;
            MainActivity.resolutionx = MainActivity.resolutiony;
            MainActivity.resolutiony = MainActivity.changeresolution;
        }


        if(MainActivity.resolutionx == 800 && MainActivity.resolutiony == 480) {

            Landscape.setbackgroundxResolution(MainActivity.resolutionx/10);
            Landscape.setbackgroundyResolution(MainActivity.resolutiony/6);



        }

        else if(MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 720){

            Landscape.setbackgroundxResolution(MainActivity.resolutionx/16);
            Landscape.setbackgroundyResolution(MainActivity.resolutiony/9);

        }

        else if(MainActivity.resolutionx == 1280 && MainActivity.resolutiony == 800){

            Landscape.setbackgroundxResolution(MainActivity.resolutionx/16);
            Landscape.setbackgroundyResolution(MainActivity.resolutiony/10);

        }



        else if(MainActivity.resolutionx == 1920 && MainActivity.resolutiony == 1080){
            Landscape.setbackgroundxResolution(MainActivity.resolutionx/24);
            Landscape.setbackgroundyResolution(MainActivity.resolutiony/13.5f);
        }


        else if(MainActivity.resolutionx == 2560 && MainActivity.resolutiony == 1440){
            Landscape.setbackgroundxResolution(MainActivity.resolutionx/32);
            Landscape.setbackgroundyResolution(MainActivity.resolutiony/18);
        }

        else {
            Landscape.setbackgroundxResolution(80);
            Landscape.setbackgroundyResolution(80);

        }

        if(Landscape.getbackgroundxResolution() != Landscape.getbackgroundyResolution()){
            Landscape.setbackgroundyResolution(Landscape.getbackgroundxResolution());
        }


        Landscape.initializeBackgroundBitmap();
        Landscape.initializefungiBitmap();




        BeginX = MainActivity.resolutionx / 2 - (Landscape.getWidth()  * Landscape.getbackgroundxResolution())/ 2;
        BeginY = MainActivity.resolutiony / 2 - (Landscape.getHeight() * Landscape.getbackgroundyResolution())/ 2;


    }
    
    
void levelOneOceanObject(FrogFungiPlayerState frogFungiPlayerState) {




    int beegravIndex = -1;
    int bigbeegravIndex = -1;
    int bighorngravIndex = -1;
    int smalloceanfishIndex = -1;
    int bigoceanfishIndex = -1;
    int startsmallfish = 0;
    int startbigfish = 0;
    int finishsmallfish = 0;
    int finishbigfish = 0;
    int oceanbugIndex = -1;
    int sandladybugIndex = -1;


    bitmapsArray = new Bitmap[18];


    beegravLevelOneOcean(beegravIndex, frogFungiPlayerState);

    bigbeegravLevelOneOcean(bigbeegravIndex, frogFungiPlayerState);

    bighorngravLevelOneOcean(bighorngravIndex, frogFungiPlayerState);

    smalloceanfishLevelOneOcean(smalloceanfishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

    bigoceanfishLevelOneOcean(bigoceanfishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

    sandladybugLevelOneOcean(sandladybugIndex, frogFungiPlayerState);

    oceanbugLevelOneOcean(oceanbugIndex, frogFungiPlayerState);


}

    void levelTwoOceanObject(FrogFungiPlayerState frogFungiPlayerState) {




        int beegravIndex = -1;
        int beegravsecondIndex = -1;
        int beegravthirdIndex = -1;
        int beegravfourthIndex = -1;
        int bigbeegravIndex = -1;
        int bigbeegravsecondIndex = -1;
        int guardianbeegravIndex = -1;
        int bighorngravIndex = -1;
        int smalloceanfishIndex = -1;
        int bigoceanfishIndex = -1;
        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;
        int oceanbugIndex = -1;
        int oceanbugsecondIndex = -1;
        int sandladybugIndex = -1;


        bitmapsArray = new Bitmap[20];
        soundManager.playSound("oceanwave");



        beegravLevelTwoOcean(beegravIndex, frogFungiPlayerState);


        beegravsecondLevelTwoOcean(beegravsecondIndex);


        beegravthirdLevelTwoOcean(beegravthirdIndex);

        beegravfourthLevelTwoOcean(beegravfourthIndex);

        bigbeegravLevelTwoOcean(bigbeegravIndex, frogFungiPlayerState);

        bigbeegravsecondLevelTwoOcean(bigbeegravsecondIndex);

        guardianbeegravLevelTwoOcean(guardianbeegravIndex, frogFungiPlayerState);
        
        bighorngravLevelTwoOcean(bighorngravIndex, frogFungiPlayerState);

        smalloceanfishLevelTwoOcean(smalloceanfishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        bigoceanfishLevelTwoOcean(bigoceanfishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        sandladybugLevelTwoOcean(sandladybugIndex, frogFungiPlayerState);

        oceanbugLevelTwoOcean(oceanbugIndex, frogFungiPlayerState);

        oceanbugsecondLevelTwoOcean(oceanbugsecondIndex);


    }

    void levelThreeOceanObject(FrogFungiPlayerState frogFungiPlayerState) {




        int beegravIndex = -1;
        int beegravsecondIndex = -1;
        int beegravthirdIndex = -1;

        int suckerbeegravIndex = -1;
        int killerbeegravIndex = -1;

        int bigbeegravIndex = -1;
        int bigbeegravsecondIndex = -1;

        int swirlwaterIndex = -1;
        int swirlwatersecondIndex = -1;
        int swirlwaterthirdIndex = -1;

        int stargravIndex = -1;
        int stargravsecondIndex = -1;
        int stargravthirdIndex = -1;

        int ghostspinderswirlwaterIndex = -1;
        int ghostspindersecondswirlwaterIndex = -1;
        int ghostspinderthirdswirlwaterIndex = -1;

        int ghostspinderstargravIndex = -1;
        int ghostspindersecondstargravIndex = -1;
        int ghostspinderthirdstargravIndex = -1;



        int smalloceanfishIndex = -1;
        int bigoceanfishIndex = -1;
        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;



        int sandladybugIndex = -1;


        bitmapsArray = new Bitmap[24];
        soundManager.playSound("oceanwave");


        beegravLevelThreeOcean(beegravIndex, frogFungiPlayerState);


        beegravsecondLevelThreeOcean(beegravsecondIndex);


        beegravthirdLevelThreeOcean(beegravthirdIndex);

        
        bigbeegravLevelThreeOcean(bigbeegravIndex, frogFungiPlayerState);

        bigbeegravsecondLevelThreeOcean(bigbeegravsecondIndex);



        suckerbeegravLevelThreeOcean(suckerbeegravIndex, frogFungiPlayerState);

        killerbeegravLevelThreeOcean(killerbeegravIndex, frogFungiPlayerState);


        smalloceanfishLevelThreeOcean(smalloceanfishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        bigoceanfishLevelThreeOcean(bigoceanfishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        sandladybugLevelThreeOcean(sandladybugIndex, frogFungiPlayerState);

       
       
       
        swirlwaterLevelThreeOcean(swirlwaterIndex, frogFungiPlayerState);

        swirlwatersecondLevelThreeOcean(swirlwatersecondIndex);


        swirlwaterthirdLevelThreeOcean(swirlwaterthirdIndex);
        
        stargravLevelThreeOcean(stargravIndex, frogFungiPlayerState);

        stargravsecondLevelThreeOcean(stargravsecondIndex);

        stargravthirdLevelThreeOcean(stargravthirdIndex);



        ghostspinderswirlwaterLevelThreeOcean(ghostspinderswirlwaterIndex);
        ghostspindersecondswirlwaterLevelThreeOcean(ghostspindersecondswirlwaterIndex);
        ghostspinderthirdswirlwaterLevelThreeOcean(ghostspinderthirdswirlwaterIndex);

        ghostspinderstargravLevelThreeOcean(ghostspinderstargravIndex);
        ghostspindersecondstargravLevelThreeOcean(ghostspindersecondstargravIndex);
        ghostspinderthirdstargravLevelThreeOcean(ghostspinderthirdstargravIndex);



    }

    void levelFourOceanObject(FrogFungiPlayerState frogFungiPlayerState) {



        int beegravIndex = -1;
        int beegravsecondIndex = -1;
        int beegravthirdIndex = -1;
        int beegravfourthIndex = -1;


        int suckerbeegravIndex = -1;


        int smalloceanfishIndex = -1;
        int bigoceanfishIndex = -1;
        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;

        int oceanbugIndex = -1;
        int oceanbugsecondIndex = -1;
        int oceanbugthirdIndex = -1;
        int oceanbugfourthIndex = -1;

        int splashflyIndex = -1;

        int swirlwaterIndex = -1;
        int swirlwatersecondIndex = -1;

        int stargravIndex = -1;
        int stargravsecondIndex = -1;

        int ghostspindersplashflyIndex = -1;

        int ghostspinderswirlwaterIndex = -1;
        int ghostspindersecondswirlwaterIndex = -1;

        int ghostspinderstargravIndex = -1;
        int ghostspindersecondstargravIndex = -1;


        int waterdropIndex = -1;

        bitmapsArray = new Bitmap[25];
        soundManager.playSound("oceanwave");

        beegravLevelFourOcean(beegravIndex, frogFungiPlayerState);

        beegravsecondLevelFourOcean(beegravsecondIndex);


        beegravthirdLevelFourOcean(beegravthirdIndex);

        beegravfourthLevelFourOcean(beegravfourthIndex);




        suckerbeegravLevelFourOcean(suckerbeegravIndex, frogFungiPlayerState);


        smalloceanfishLevelFourOcean(smalloceanfishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        bigoceanfishLevelFourOcean(bigoceanfishIndex, startbigfish, finishbigfish, frogFungiPlayerState);



        oceanbugLevelFourOcean(oceanbugIndex, frogFungiPlayerState);

        oceanbugsecondLevelFourOcean(oceanbugsecondIndex);


        oceanbugthirdLevelFourOcean(oceanbugthirdIndex);


        oceanbugfourthLevelFourOcean(oceanbugfourthIndex);


        splashflyLevelFourOcean(splashflyIndex, frogFungiPlayerState);



        swirlwaterLevelFourOcean(swirlwaterIndex, frogFungiPlayerState);

        swirlwatersecondLevelFourOcean(swirlwatersecondIndex);

        stargravLevelFourOcean(stargravIndex, frogFungiPlayerState);

        stargravsecondLevelFourOcean(stargravsecondIndex);



        ghostspindersplashflyLevelFourOcean(ghostspindersplashflyIndex);



        ghostspinderswirlwaterLevelFourOcean(ghostspinderswirlwaterIndex);

        ghostspindersecondswirlwaterLevelFourOcean(ghostspindersecondswirlwaterIndex);


        ghostspinderstargravLevelFourOcean(ghostspinderstargravIndex);

        ghostspindersecondstargravLevelFourOcean(ghostspindersecondstargravIndex);


        waterdropLevelFourOcean(waterdropIndex, frogFungiPlayerState);




        }
        
        
        




    void levelOneLavaObject(FrogFungiPlayerState frogFungiPlayerState){
        
        int smalllavafishIndex = -1;
        int biglavafishIndex = -1;
        int rockbeegravIndex = -1;
        int rockbeegravsecondIndex = -1;
        
        int rockbigbeegravIndex = -1;
        int rockbigbeegravsecondIndex = -1;
        
        int dustrockbeegravlavaIndex = -1;

        int fungilavaIndex = -1;
        int jumpingratlavaIndex = -1;


        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;


        bitmapsArray = new Bitmap[19];



        smalllavafishLevelOneLava(smalllavafishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        biglavafishLevelOneLava(biglavafishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        rockbeegravLevelOneLava(rockbeegravIndex, frogFungiPlayerState);

        rockbeegravsecondLevelOneLava(rockbeegravsecondIndex);
        
        
        rockbigbeegravLevelOneLava(rockbigbeegravIndex, frogFungiPlayerState);

        rockbigbeegravsecondLevelOneLava(rockbigbeegravsecondIndex);


        dustrockbeegravlavaLevelOneLava(dustrockbeegravlavaIndex, frogFungiPlayerState);



        fungilavaLevelOneLava(fungilavaIndex, frogFungiPlayerState);

        jumpingratlavaLevelOneLava(jumpingratlavaIndex, frogFungiPlayerState);





    }



    void levelTwoLavaObject(FrogFungiPlayerState frogFungiPlayerState){

        int smalllavafishIndex = -1;
        int biglavafishIndex = -1;
        int rockbeegravIndex = -1;
        int rockbeegravsecondIndex = -1;
        int rockbeegravthirdIndex = -1;
        int rockbeegravfourthIndex = -1;
        
        int rockbigbeegravIndex = -1;
        int rockbigbeegravsecondIndex = -1;
        int rockbigbeegravthirdIndex = -1;
        int rockbigbeegravfourthIndex = -1;



        int dustrockbeegravlavaIndex = -1;
        int dustrockbeegravlavasecondIndex = -1;
        int dustrockbeegravlavathirdIndex = -1;
        int dustrockbeegravlavafourthIndex = -1;

        int bigdustrockbeegravlavaIndex = -1;

        int ghostspinderbigdustrockbeegravlavaIndex = -1;

        int fungilavaIndex = -1;
        int jumpingratlavaIndex = -1;
        int transparentchubIndex = -1;


        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;


        bitmapsArray = new Bitmap[23];


        smalllavafishLevelTwoLava(smalllavafishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        biglavafishLevelTwoLava(biglavafishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        rockbeegravLevelTwoLava(rockbeegravIndex, frogFungiPlayerState);

        rockbeegravsecondLevelTwoLava(rockbeegravsecondIndex);


        rockbeegravthirdLevelTwoLava(rockbeegravthirdIndex);


        rockbeegravfourthLevelTwoLava(rockbeegravfourthIndex);



        rockbigbeegravLevelTwoLava(rockbigbeegravIndex, frogFungiPlayerState);
        rockbigbeegravsecondLevelTwoLava(rockbigbeegravsecondIndex);


        rockbigbeegravthirdLevelTwoLava(rockbigbeegravthirdIndex);


        rockbigbeegravfourthLevelTwoLava(rockbigbeegravfourthIndex);




        dustrockbeegravlavaLevelTwoLava(dustrockbeegravlavaIndex, frogFungiPlayerState);

        dustrockbeegravlavasecondLevelTwoLava(dustrockbeegravlavasecondIndex);


        dustrockbeegravlavathirdLevelTwoLava(dustrockbeegravlavathirdIndex);


        dustrockbeegravlavafourthLevelTwoLava(dustrockbeegravlavafourthIndex);



        transparentchubLevelTwoLava(transparentchubIndex, frogFungiPlayerState);

        fungilavaLevelTwoLava(fungilavaIndex, frogFungiPlayerState);

        jumpingratlavaLevelTwoLava(jumpingratlavaIndex, frogFungiPlayerState);


        bigdustrockbeegravlavaLevelTwoLava(bigdustrockbeegravlavaIndex, frogFungiPlayerState);


        ghostspinderbigdustrockbeegravlavaLevelTwoLava(ghostspinderbigdustrockbeegravlavaIndex);




    }



    void levelThreeLavaObject(FrogFungiPlayerState frogFungiPlayerState){

        int smalllavafishIndex = -1;
        int biglavafishIndex = -1;
        int rockbeegravIndex = -1;
        int rockbeegravsecondIndex = -1;
        int rockbeegravthirdIndex = -1;
        int rockbeegravfourthIndex = -1;
        int rockbigbeegravIndex = -1;
        int rockbigbeegravsecondIndex = -1;
        int bigdustrockbeegravlavaIndex = -1;
        int bigdustrockbeegravlavasecondIndex = -1;
        int bigdustrockbeegravlavathirdIndex = -1;
        int bigdustrockbeegravlavafourthIndex = -1;
        int lavadropIndex = -1;
        int barkbugIndex = -1;
        int ghostspinderbigdustrockbeegravlavaIndex = -1;
        int ghostspindersecondbigdustrockbeegravlavaIndex = -1;
        int ghostspinderthirdbigdustrockbeegravlavaIndex = -1;
        int ghostspinderfourthbigdustrockbeegravlavaIndex = -1;
        
        int lavafurIndex = -1;
        int gravitycloudIndex = -1;
        
        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;


        bitmapsArray = new Bitmap[27];


        smalllavafishLevelThreeLava(smalllavafishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        biglavafishLevelThreeLava(biglavafishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        rockbeegravLevelThreeLava(rockbeegravIndex, frogFungiPlayerState);


        rockbeegravsecondLevelThreeLava(rockbeegravsecondIndex);

        rockbeegravthirdLevelThreeLava(rockbeegravthirdIndex);

        rockbeegravfourthLevelThreeLava(rockbeegravfourthIndex);

        
        rockbigbeegravLevelThreeLava(rockbigbeegravIndex, frogFungiPlayerState);


        rockbigbeegravsecondLevelThreeLava(rockbigbeegravsecondIndex);
        

        bigdustrockbeegravlavaLevelThreeLava(bigdustrockbeegravlavaIndex, frogFungiPlayerState);


        bigdustrockbeegravlavasecondLevelThreeLava(bigdustrockbeegravlavasecondIndex);


        bigdustrockbeegravlavathirdLevelThreeLava(bigdustrockbeegravlavathirdIndex);


        bigdustrockbeegravlavafourthLevelThreeLava(bigdustrockbeegravlavafourthIndex);

        
        barkbugLevelThreeLava(barkbugIndex, frogFungiPlayerState);

        lavadropLevelThreeLava(lavadropIndex, frogFungiPlayerState);

        ghostspinderbigdustrockbeegravlavaLevelThreeLava(ghostspinderbigdustrockbeegravlavaIndex);

        ghostspindersecondbigdustrockbeegravlavaLevelThreeLava(ghostspindersecondbigdustrockbeegravlavaIndex);

        ghostspinderthirdbigdustrockbeegravlavaLevelThreeLava(ghostspinderthirdbigdustrockbeegravlavaIndex);

        ghostspinderfourthbigdustrockbeegravlavaLevelThreeLava(ghostspinderfourthbigdustrockbeegravlavaIndex);

        lavafurLevelThreeLava(lavafurIndex, frogFungiPlayerState);
        
        gravitycloudLevelThreeLava(gravitycloudIndex, frogFungiPlayerState);



    }



    void levelFourLavaObject(FrogFungiPlayerState frogFungiPlayerState){


        int smalllavafishIndex = -1;
        int biglavafishIndex = -1;
        int rockbeegravIndex = -1;
        int rockbeegravsecondIndex = -1;
        int rockbeegravthirdIndex = -1;
        int rockbeegravfourthIndex = -1;

        int lavafurIndex = -1;
        int gravitycloudIndex = -1;

        int bigdustrockbeegravlavaIndex = -1;
        int bigdustrockbeegravlavasecondIndex = -1;
        int bigdustrockbeegravlavathirdIndex = -1;
        int bigdustrockbeegravlavafourthIndex = -1;

        int redbubblelavaIndex = -1;

        int dustbulletlavaIndex = -1;
        int dustbulletlavasecondIndex = -1;
        int dustbulletlavathirdIndex = -1;
        int dustbulletlavafourthIndex = -1;

        int startsmallfish = 0;
        int startbigfish = 0;
        int finishsmallfish = 0;
        int finishbigfish = 0;


        bitmapsArray = new Bitmap[23];



        smalllavafishLevelFourLava(smalllavafishIndex, startsmallfish, finishsmallfish, frogFungiPlayerState);

        biglavafishLevelFourLava(biglavafishIndex, startbigfish, finishbigfish, frogFungiPlayerState);

        rockbeegravLevelFourLava(rockbeegravIndex, frogFungiPlayerState);


        rockbeegravsecondLevelFourLava(rockbeegravsecondIndex);

        rockbeegravthirdLevelFourLava(rockbeegravthirdIndex);

        rockbeegravfourthLevelFourLava(rockbeegravfourthIndex);



        bigdustrockbeegravlavaLevelFourLava(bigdustrockbeegravlavaIndex, frogFungiPlayerState);

        bigdustrockbeegravlavasecondLevelFourLava(bigdustrockbeegravlavasecondIndex);


        bigdustrockbeegravlavathirdLevelFourLava(bigdustrockbeegravlavathirdIndex);

        bigdustrockbeegravlavafourthLevelFourLava(bigdustrockbeegravlavafourthIndex);


        dustbulletlavaLevelFourLava(dustbulletlavaIndex, frogFungiPlayerState);

        dustbulletlavasecondLevelFourLava(dustbulletlavasecondIndex);

        dustbulletlavathirdLevelFourLava(dustbulletlavathirdIndex);

        dustbulletlavafourthLevelFourLava(dustbulletlavafourthIndex);


        redbubblelavaLevelFourLava(redbubblelavaIndex, frogFungiPlayerState);

        lavafurLevelFourLava(lavafurIndex, frogFungiPlayerState);

        gravitycloudLevelFourLava(gravitycloudIndex, frogFungiPlayerState);




    }


    float calculatingspeed(int enemyObject){
            float speed = 0;

        if(enemyObject == 0) {
            speed = 1;
        }
        else if((enemyObject > 0) && (enemyObject < 4)){

            speed = (enemyObject * 0.2f) + 1;

          }

        else if((enemyObject > 3) && (enemyObject < 8)) {

            speed = (enemyObject * 0.025f) + ((3 * 0.2f) + 1);


        }
        else if((enemyObject > 7) && (enemyObject < 10)) {

            speed = (enemyObject * 0.004f) + ((7 * 0.025f) + ((3 * 0.2f) + 1));


        }
        else if((enemyObject > 9) && (enemyObject < 13)) {

            speed = (enemyObject * 0.0005f) + ((9 * 0.004f) + ((7 * 0.025f) + ((3 * 0.2f) + 1)));


        }
        else if(enemyObject > 12) {

            speed = (enemyObject * 0.0008f) + ((12 * 0.0005f) + ((9 * 0.004f) + ((7 * 0.025f) + ((3 * 0.2f) + 1))));


        }
            return speed;
        }


    float calculatingghostspinderspeed(int enemyObject){
        float speed = 0;

            if(enemyObject == 0){
                speed = 11 * 2.5f;
            }
            else {
                speed = ((enemyObject * 10) + 1) * 2.5f;
            }

        return speed;
    }


    float calculatingcirclespeed(int enemyObject){
        float speed = 0;


        if(enemyObject == 0) {
            speed = 2.5f;
        }

        else if((enemyObject > 0) && (enemyObject < 4)){

            speed = enemyObject * 2.8f;

        }

        else if((enemyObject > 3) && (enemyObject < 8)) {

            speed = enemyObject * 3.1f;

        }

        else if((enemyObject > 7) && (enemyObject < 15)) {

            speed = enemyObject * 3.8f;

        }
        return speed;
    }





    void beegravLevelOneOcean(int beegravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int k = 0; k < beegravObject.length(); k++) {
            c = beegravObject.charAt(k);


            beegravIndex++;

            switch (c) {
                case 'b':


                    beegravgameObjects.add(new BeeGrav());
                    beegravgameObjects.trimToSize();
                    beegravgameObjects.get(beegravIndex).setWorldLocation(
                            BeginX + ((beegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + ((beegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));
                    beegravgameObjects.get(beegravIndex).speed = calculatingspeed(beegravIndex);

                    if (k != 0) {
                        beegravgameObjects.get(beegravIndex).setBitmapWidth(bitmapWidth);
                        beegravgameObjects.get(beegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameRight(),
                        frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameLeft(),
                        frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = beegravgameObjects.get(beegravIndex).getBitmapWidth();
                bitmapHeight = beegravgameObjects.get(beegravIndex).getBitmapHeight();

            }


        }

    }


    void bigbeegravLevelOneOcean(int bigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int l = 0; l < bigbeegravObject.length(); l++) {
            c = bigbeegravObject.charAt(l);

            bigbeegravIndex++;

            switch (c) {
                case 'i':


                    bigbeegravgameObjects.add(new BigBeeGrav());
                    bigbeegravgameObjects.trimToSize();
                    bigbeegravgameObjects.get(bigbeegravIndex).setWorldLocation(
                            BeginX + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                            BeginY + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.2f)));
                    bigbeegravgameObjects.get(bigbeegravIndex).speed = calculatingspeed(bigbeegravIndex);


                    if (l != 0) {

                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapWidth(bitmapWidth);
                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapWidth();
                bitmapHeight = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapHeight();


            }


        }

    }

    void bighorngravLevelOneOcean(int bighorngravIndex, FrogFungiPlayerState frogFungiPlayerState){

    char c;

    for (int m = 0; m < bighorngravObject.length(); m++) {
        c = bighorngravObject.charAt(m);

        bighorngravIndex++;

        switch (c) {
            case 'h':


                bighorngravgameObjects.add(new BigHornGrav());
                bighorngravgameObjects.trimToSize();
                bighorngravgameObjects.get(bighorngravIndex).speed = calculatingspeed(bighorngravIndex);

                
                break;


        }


        if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


            bitmapsArray[getBitmapIndexLevelOneOcean(c)] = bighorngravgameObjects.get(bighorngravIndex).prepareBitmap(bighorngravgameObjects.get(bighorngravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
            bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = bighorngravgameObjects.get(bighorngravIndex).prepareBitmap(bighorngravgameObjects.get(bighorngravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


        }


        bighorngravgameObjects.get(bighorngravIndex).setWorldLocation(
                BeginX + bgLandscape.fungiArray[bgLandscape.fungiArray.length - 2] -
                        bighorngravgameObjects.get(bighorngravIndex).getBitmapWidth() / 2,
                BeginY + bgLandscape.fungiArray[bgLandscape.fungiArray.length - 1] -
                        bighorngravgameObjects.get(bighorngravIndex).getBitmapHeight());




    }

}

    void smalloceanfishLevelOneOcean(int smalloceanfishIndex, int startsmallfish, int finishsmallfish, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int s = 0; s < smalloceanfishObject.length(); s++) {
            c = smalloceanfishObject.charAt(s);

            smalloceanfishIndex++;

            switch (c) {
                case 'f':


                    smalloceanfishgameObjects.add(new SmallOceanFish());
                    smalloceanfishgameObjects.trimToSize();
                    smalloceanfishgameObjects.get(smalloceanfishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);

                    if(smalloceanfishgameObjects.get(smalloceanfishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("RIGHT");

                    }

                    smalloceanfishgameObjects.get(smalloceanfishIndex).speed = calculatingspeed(smalloceanfishIndex);


                    if (s != 0) {
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapWidth(bitmapWidth);
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapWidth();
                bitmapHeight = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;
        }


    }

    void bigoceanfishLevelOneOcean(int bigoceanfishIndex, int startbigfish, int finishbigfish, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int t = 0; t < bigoceanfishObject.length(); t++) {
            c = bigoceanfishObject.charAt(t);

            bigoceanfishIndex++;

            switch (c) {
                case 'F':


                    bigoceanfishgameObjects.add(new BigOceanFish());
                    bigoceanfishgameObjects.trimToSize();
                    bigoceanfishgameObjects.get(bigoceanfishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);

                    if(bigoceanfishgameObjects.get(bigoceanfishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("RIGHT");

                    }

                    bigoceanfishgameObjects.get(bigoceanfishIndex).speed = calculatingspeed(bigoceanfishIndex);



                    if (t != 0) {
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapWidth(bitmapWidth);
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapWidth();
                bitmapHeight = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;
        }

    }


    void sandladybugLevelOneOcean(int sandladybugIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int w = 0; w < sandladybugObject.length(); w++) {
            c = sandladybugObject.charAt(w);

            sandladybugIndex++;


            switch (c) {
                case 's':


                    sandladybuggameObjects.add(new SandLadyBug());
                    sandladybuggameObjects.trimToSize();
                    sandladybuggameObjects.get(sandladybugIndex).setWorldLocation(
                            BeginX + arraylistofsandladybugposition[(sandladybugIndex + 1) * 2],
                            BeginY + arraylistofsandladybugposition[((sandladybugIndex + 1) * 2) + 1]);

                    sandladybuggameObjects.get(sandladybugIndex).sandladybugrand = (sandladybugIndex + 1) * 2;

                    sandladybuggameObjects.get(sandladybugIndex).speed = calculatingspeed(sandladybugIndex);



                    if (w != 0) {
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapWidth(bitmapWidth);
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = sandladybuggameObjects.get(sandladybugIndex).getBitmapWidth();
                bitmapHeight = sandladybuggameObjects.get(sandladybugIndex).getBitmapHeight();


            }


        }

    }

    void oceanbugLevelOneOcean(int oceanbugIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int x = 0; x < oceanbugObject.length(); x++) {
            c = oceanbugObject.charAt(x);

            oceanbugIndex++;

            switch (c) {
                case 'o':


                    oceanbuggameObjects.add(new OceanBug());
                    oceanbuggameObjects.trimToSize();
                    oceanbuggameObjects.get(oceanbugIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((oceanbugIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight()) -
                                    ((oceanbugIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.2f)));

                    oceanbuggameObjects.get(oceanbugIndex).speed = calculatingspeed(oceanbugIndex);

                    
                    if (x != 0) {
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapWidth(bitmapWidth);
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapHeight(bitmapHeight);


                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneOcean(c)] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneOcean(c) + 1] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = oceanbuggameObjects.get(oceanbugIndex).getBitmapWidth();
                bitmapHeight = oceanbuggameObjects.get(oceanbugIndex).getBitmapHeight();


            }


        }
    }


    void beegravLevelTwoOcean(int beegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int k = 0; k < beegravObject.length(); k++) {
            c = beegravObject.charAt(k);


            beegravIndex++;

            switch (c) {
                case 'b':


                    beegravgameObjects.add(new BeeGrav());
                    beegravgameObjects.trimToSize();
                    beegravgameObjects.get(beegravIndex).setWorldLocation(
                            BeginX + ((beegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + ((beegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    beegravgameObjects.get(beegravIndex).speed = calculatingspeed(beegravIndex);


                    if (k != 0) {
                        beegravgameObjects.get(beegravIndex).setBitmapWidth(bitmapWidth);
                        beegravgameObjects.get(beegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = beegravgameObjects.get(beegravIndex).getBitmapWidth();
                bitmapHeight = beegravgameObjects.get(beegravIndex).getBitmapHeight();

            }


        }


    }


    void beegravsecondLevelTwoOcean(int beegravsecondIndex){

        char c;

        for (int q = 0; q < beegravsecondObject.length(); q++) {
            c = beegravsecondObject.charAt(q);


            beegravsecondIndex++;

            switch (c) {
                case 'b':


                    beegravsecondgameObjects.add(new BeeGrav());
                    beegravsecondgameObjects.trimToSize();
                    beegravsecondgameObjects.get(beegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY +  (bgLandscape.getbackgroundyResolution() *
                                    bgLandscape.getHeight() * 0.8f));

                    beegravsecondgameObjects.get(beegravsecondIndex).speed = calculatingspeed(beegravsecondIndex);


                    beegravsecondgameObjects.get(beegravsecondIndex).setBitmapWidth(bitmapWidth);
                        beegravsecondgameObjects.get(beegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }



        }


    }


    void beegravthirdLevelTwoOcean(int beegravthirdIndex){

        char c;

        for (int q = 0; q < beegravthirdObject.length(); q++) {
            c = beegravthirdObject.charAt(q);


            beegravthirdIndex++;

            switch (c) {
                case 'b':


                    beegravthirdgameObjects.add(new BeeGrav());
                    beegravthirdgameObjects.trimToSize();
                    beegravthirdgameObjects.get(beegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 0.2f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 0.98f));

                    beegravthirdgameObjects.get(beegravthirdIndex).speed = calculatingspeed(beegravthirdIndex);

                        beegravthirdgameObjects.get(beegravthirdIndex).setBitmapWidth(bitmapWidth);
                        beegravthirdgameObjects.get(beegravthirdIndex).setBitmapHeight(bitmapHeight);



                    break;


            }



        }


    }


    void beegravfourthLevelTwoOcean(int beegravfourthIndex){

        char c;

        for (int q = 0; q < beegravfourthObject.length(); q++) {
            c = beegravfourthObject.charAt(q);


            beegravfourthIndex++;

            switch (c) {
                case 'b':


                    beegravfourthgameObjects.add(new BeeGrav());
                    beegravfourthgameObjects.trimToSize();
                    beegravfourthgameObjects.get(beegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.98f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 0.98f));

                    beegravfourthgameObjects.get(beegravfourthIndex).speed = calculatingspeed(beegravfourthIndex);


                        beegravfourthgameObjects.get(beegravfourthIndex).setBitmapWidth(bitmapWidth);
                        beegravfourthgameObjects.get(beegravfourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }




        }


    }


    void bigbeegravLevelTwoOcean(int bigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int l = 0; l < bigbeegravObject.length(); l++) {
            c = bigbeegravObject.charAt(l);

            bigbeegravIndex++;

            switch (c) {
                case 'i':


                    bigbeegravgameObjects.add(new BigBeeGrav());
                    bigbeegravgameObjects.trimToSize();
                    bigbeegravgameObjects.get(bigbeegravIndex).setWorldLocation(
                            BeginX + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.2f)),
                            BeginY + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.05f)));

                    bigbeegravgameObjects.get(bigbeegravIndex).speed = calculatingspeed(bigbeegravIndex);

                    
                    if (l != 0) {

                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapWidth(bitmapWidth);
                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapWidth();
                bitmapHeight = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapHeight();


            }


        }


    }


    void bigbeegravsecondLevelTwoOcean(int bigbeegravsecondIndex){

        char c;

        for (int l = 0; l < bigbeegravsecondObject.length(); l++) {
            c = bigbeegravsecondObject.charAt(l);

            bigbeegravsecondIndex++;

            switch (c) {
                case 'i':


                    bigbeegravsecondgameObjects.add(new BigBeeGrav());
                    bigbeegravsecondgameObjects.trimToSize();
                    bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).setWorldLocation(
                            BeginX + bgLandscape.getbackgroundxResolution(),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 0.9f));

                    bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).speed = calculatingspeed(bigbeegravsecondIndex);

                    bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                        bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).setBitmapHeight(bitmapHeight);




                    break;


            }




        }


    }



    void guardianbeegravLevelTwoOcean(int guardianbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int g = 0; g < guardianbeegravObject.length(); g++) {
            c = guardianbeegravObject.charAt(g);


            guardianbeegravIndex++;

            switch (c) {
                case 'g':


                    guardianbeegravgameObjects.add(new GuardianBeeGrav());
                    guardianbeegravgameObjects.trimToSize();
                    guardianbeegravgameObjects.get(guardianbeegravIndex).setWorldLocation(
                            BeginX + bgLandscape.fungiArray[bgLandscape.funginumber[5 * guardianbeegravIndex] * 2],
                            BeginY + bgLandscape.fungiArray[(bgLandscape.funginumber[5 * guardianbeegravIndex] * 2) + 1]);

                    guardianbeegravgameObjects.get(guardianbeegravIndex).speed = calculatingspeed(guardianbeegravIndex);


                    if (g != 0) {
                        guardianbeegravgameObjects.get(guardianbeegravIndex).setBitmapWidth(bitmapWidth);
                        guardianbeegravgameObjects.get(guardianbeegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = guardianbeegravgameObjects.get(guardianbeegravIndex).prepareBitmap(guardianbeegravgameObjects.get(guardianbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = guardianbeegravgameObjects.get(guardianbeegravIndex).prepareBitmap(guardianbeegravgameObjects.get(guardianbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = guardianbeegravgameObjects.get(guardianbeegravIndex).getBitmapWidth();
                bitmapHeight = guardianbeegravgameObjects.get(guardianbeegravIndex).getBitmapHeight();

            }


        }


    }

    void bighorngravLevelTwoOcean(int bighorngravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int m = 0; m < bighorngravObject.length(); m++) {
            c = bighorngravObject.charAt(m);

            bighorngravIndex++;

            switch (c) {
                case 'h':


                    bighorngravgameObjects.add(new BigHornGrav());
                    bighorngravgameObjects.trimToSize();

                    bighorngravgameObjects.get(bighorngravIndex).speed = calculatingspeed(bighorngravIndex);

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = bighorngravgameObjects.get(bighorngravIndex).prepareBitmap(bighorngravgameObjects.get(bighorngravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = bighorngravgameObjects.get(bighorngravIndex).prepareBitmap(bighorngravgameObjects.get(bighorngravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


            }



            bighorngravgameObjects.get(bighorngravIndex).setWorldLocation(
                    BeginX + bgLandscape.fungiArray[bgLandscape.fungiArray.length - 2] -
                            bighorngravgameObjects.get(bighorngravIndex).getBitmapWidth() / 2,
                    BeginY + bgLandscape.fungiArray[bgLandscape.fungiArray.length - 1] -
                            bighorngravgameObjects.get(bighorngravIndex).getBitmapHeight());




        }
        
    }

    void smalloceanfishLevelTwoOcean(int smalloceanfishIndex, int startsmallfish, int finishsmallfish, 
                                     FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int s = 0; s < smalloceanfishObject.length(); s++) {
            c = smalloceanfishObject.charAt(s);

            smalloceanfishIndex++;

            switch (c) {
                case 'f':


                    smalloceanfishgameObjects.add(new SmallOceanFish());
                    smalloceanfishgameObjects.trimToSize();
                    smalloceanfishgameObjects.get(smalloceanfishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);

                    if(smalloceanfishgameObjects.get(smalloceanfishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("RIGHT");

                    }

                    smalloceanfishgameObjects.get(smalloceanfishIndex).speed = calculatingspeed(smalloceanfishIndex);


                    if (s != 0) {
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapWidth(bitmapWidth);
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapWidth();
                bitmapHeight = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;
        }
        
    }

    void bigoceanfishLevelTwoOcean(int bigoceanfishIndex, int startbigfish, int finishbigfish, 
                                   FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int t = 0; t < bigoceanfishObject.length(); t++) {
            c = bigoceanfishObject.charAt(t);

            bigoceanfishIndex++;

            switch (c) {
                case 'F':


                    bigoceanfishgameObjects.add(new BigOceanFish());
                    bigoceanfishgameObjects.trimToSize();
                    bigoceanfishgameObjects.get(bigoceanfishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);

                    if(bigoceanfishgameObjects.get(bigoceanfishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("RIGHT");

                    }

                    bigoceanfishgameObjects.get(bigoceanfishIndex).speed = calculatingspeed(bigoceanfishIndex);



                    if (t != 0) {
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapWidth(bitmapWidth);
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapWidth();
                bitmapHeight = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;
        }

    }

    void sandladybugLevelTwoOcean(int sandladybugIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int w = 0; w < sandladybugObject.length(); w++) {
            c = sandladybugObject.charAt(w);

            sandladybugIndex++;


            switch (c) {
                case 's':


                    sandladybuggameObjects.add(new SandLadyBug());
                    sandladybuggameObjects.trimToSize();
                    sandladybuggameObjects.get(sandladybugIndex).setWorldLocation(
                            BeginX + arraylistofsandladybugposition[(sandladybugIndex + 1) * 2],
                            BeginY + arraylistofsandladybugposition[((sandladybugIndex + 1) * 2) + 1]);

                    sandladybuggameObjects.get(sandladybugIndex).sandladybugrand = (sandladybugIndex + 1) * 2;


                    sandladybuggameObjects.get(sandladybugIndex).speed = calculatingspeed(sandladybugIndex);


                    if (w != 0) {
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapWidth(bitmapWidth);
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = sandladybuggameObjects.get(sandladybugIndex).getBitmapWidth();
                bitmapHeight = sandladybuggameObjects.get(sandladybugIndex).getBitmapHeight();


            }


        }
        
    }

    void oceanbugLevelTwoOcean(int oceanbugIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int x = 0; x < oceanbugObject.length(); x++) {
            c = oceanbugObject.charAt(x);

            oceanbugIndex++;

            switch (c) {
                case 'o':


                    oceanbuggameObjects.add(new OceanBug());
                    oceanbuggameObjects.trimToSize();


                    oceanbuggameObjects.get(oceanbugIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    (bgLandscape.getbackgroundxResolution() * 5),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight()) -
                                    (bgLandscape.getbackgroundyResolution() * 0.2f));

                    oceanbuggameObjects.get(oceanbugIndex).speed = calculatingspeed(oceanbugIndex);


                    if (x != 0) {
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapWidth(bitmapWidth);
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapHeight(bitmapHeight);


                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = oceanbuggameObjects.get(oceanbugIndex).getBitmapWidth();
                bitmapHeight = oceanbuggameObjects.get(oceanbugIndex).getBitmapHeight();


            }


        }
        
    }

    void oceanbugsecondLevelTwoOcean(int oceanbugsecondIndex){

        char c;

        for (int x = 0; x < oceanbugsecondObject.length(); x++) {
            c = oceanbugsecondObject.charAt(x);

            oceanbugsecondIndex++;

            switch (c) {
                case 'o':


                    oceanbugsecondgameObjects.add(new OceanBug());
                    oceanbugsecondgameObjects.trimToSize();


                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()),
                            BeginY + bgLandscape.getbackgroundyResolution());

                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).speed = calculatingspeed(oceanbugsecondIndex);

                    
                        oceanbugsecondgameObjects.get(oceanbugsecondIndex).setBitmapWidth(bitmapWidth);
                        oceanbugsecondgameObjects.get(oceanbugsecondIndex).setBitmapHeight(bitmapHeight);




                    break;


            }



        }

    }


    void beegravLevelThreeOcean(int beegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int k = 0; k < beegravObject.length(); k++) {
            c = beegravObject.charAt(k);


            beegravIndex++;

            switch (c) {
                case 'b':


                    beegravgameObjects.add(new BeeGrav());
                    beegravgameObjects.trimToSize();
                    beegravgameObjects.get(beegravIndex).setWorldLocation(
                            BeginX + ((beegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                            BeginY + ((beegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    beegravgameObjects.get(beegravIndex).speed = calculatingspeed(beegravIndex);

                    if (k != 0) {
                        beegravgameObjects.get(beegravIndex).setBitmapWidth(bitmapWidth);
                        beegravgameObjects.get(beegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = beegravgameObjects.get(beegravIndex).getBitmapWidth();
                bitmapHeight = beegravgameObjects.get(beegravIndex).getBitmapHeight();

            }


        }


    }


    void beegravsecondLevelThreeOcean(int beegravsecondIndex){

        char c;

        for (int q = 0; q < beegravsecondObject.length(); q++) {
            c = beegravsecondObject.charAt(q);


            beegravsecondIndex++;

            switch (c) {
                case 'b':


                    beegravsecondgameObjects.add(new BeeGrav());
                    beegravsecondgameObjects.trimToSize();
                    beegravsecondgameObjects.get(beegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 5) + ((beegravsecondIndex + 1) *
                            bgLandscape.getbackgroundyResolution()),
                            BeginY +  (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.4f) -
                                    ((beegravsecondIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));
                    beegravsecondgameObjects.get(beegravsecondIndex).speed = calculatingspeed(beegravsecondIndex);

                    
                    beegravsecondgameObjects.get(beegravsecondIndex).setBitmapWidth(bitmapWidth);
                    beegravsecondgameObjects.get(beegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }



        }


    }


    void beegravthirdLevelThreeOcean(int beegravthirdIndex){

        char c;

        for (int q = 0; q < beegravthirdObject.length(); q++) {
            c = beegravthirdObject.charAt(q);


            beegravthirdIndex++;

            switch (c) {
                case 'b':


                    beegravthirdgameObjects.add(new BeeGrav());
                    beegravthirdgameObjects.trimToSize();
                    beegravthirdgameObjects.get(beegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * 0.01f));

                    beegravthirdgameObjects.get(beegravthirdIndex).speed = calculatingspeed(beegravthirdIndex);

                    beegravthirdgameObjects.get(beegravthirdIndex).setBitmapWidth(bitmapWidth);
                    beegravthirdgameObjects.get(beegravthirdIndex).setBitmapHeight(bitmapHeight);



                    break;


            }



        }


    }




    void suckerbeegravLevelThreeOcean(int suckerbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int a = 0; a < suckerbeegravObject.length(); a++) {
            c = suckerbeegravObject.charAt(a);

            suckerbeegravIndex++;


            switch (c) {
                case 'k':


                    suckerbeegravgameObjects.add(new SuckerBeeGrav());
                    suckerbeegravgameObjects.trimToSize();
                    suckerbeegravgameObjects.get(suckerbeegravIndex).setWorldLocation(

                            BeginX + arraylistofsuckerbeegravposition[(suckerbeegravIndex + 8) * 2],
                            BeginY + arraylistofsuckerbeegravposition[((suckerbeegravIndex + 8) * 2) + 1]);

                    suckerbeegravgameObjects.get(suckerbeegravIndex).suckerbeegravrand = (suckerbeegravIndex + 8) * 2;


                    suckerbeegravgameObjects.get(suckerbeegravIndex).speed = calculatingspeed(suckerbeegravIndex);



                    if (a != 0) {
                        suckerbeegravgameObjects.get(suckerbeegravIndex).setBitmapWidth(bitmapWidth);
                        suckerbeegravgameObjects.get(suckerbeegravIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = suckerbeegravgameObjects.get(suckerbeegravIndex).prepareBitmap(suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = suckerbeegravgameObjects.get(suckerbeegravIndex).prepareBitmap(suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapWidth();
                bitmapHeight = suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapHeight();


            }


        }

    }


    void killerbeegravLevelThreeOcean(int killerbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int e = 0; e < killerbeegravObject.length(); e++) {
            c = killerbeegravObject.charAt(e);


            killerbeegravIndex++;

            switch (c) {
                case 'l':


                    killerbeegravgameObjects.add(new KillerBeeGrav());
                    killerbeegravgameObjects.trimToSize();
                    killerbeegravgameObjects.get(killerbeegravIndex).setWorldLocation(
                            BeginX + bgLandscape.fungiArray[5 * killerbeegravIndex * 2],
                            BeginY + bgLandscape.fungiArray[(5 * killerbeegravIndex * 2) + 1]);

                    killerbeegravgameObjects.get(killerbeegravIndex).speed = calculatingcirclespeed(killerbeegravIndex);


                    if (e != 0) {
                        killerbeegravgameObjects.get(killerbeegravIndex).setBitmapWidth(bitmapWidth);
                        killerbeegravgameObjects.get(killerbeegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = killerbeegravgameObjects.get(killerbeegravIndex).prepareBitmap(killerbeegravgameObjects.get(killerbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = killerbeegravgameObjects.get(killerbeegravIndex).prepareBitmap(killerbeegravgameObjects.get(killerbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = killerbeegravgameObjects.get(killerbeegravIndex).getBitmapWidth();
                bitmapHeight = killerbeegravgameObjects.get(killerbeegravIndex).getBitmapHeight();

            }


        }



    }


    void bigbeegravLevelThreeOcean(int bigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int l = 0; l < bigbeegravObject.length(); l++) {
            c = bigbeegravObject.charAt(l);

            bigbeegravIndex++;

            switch (c) {
                case 'i':


                    bigbeegravgameObjects.add(new BigBeeGrav());
                    bigbeegravgameObjects.trimToSize();
                    bigbeegravgameObjects.get(bigbeegravIndex).setWorldLocation(
                            BeginX + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * -1.2f)),
                            BeginY + ((bigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.05f)));

                    bigbeegravgameObjects.get(bigbeegravIndex).speed = calculatingspeed(bigbeegravIndex);


                    if (l != 0) {

                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapWidth(bitmapWidth);
                        bigbeegravgameObjects.get(bigbeegravIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoOcean(c)] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoOcean(c) + 1] = bigbeegravgameObjects.get(bigbeegravIndex).prepareBitmap(bigbeegravgameObjects.get(bigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapWidth();
                bitmapHeight = bigbeegravgameObjects.get(bigbeegravIndex).getBitmapHeight();


            }


        }


    }


    void bigbeegravsecondLevelThreeOcean(int bigbeegravsecondIndex){

        char c;

        for (int l = 0; l < bigbeegravsecondObject.length(); l++) {
            c = bigbeegravsecondObject.charAt(l);

            bigbeegravsecondIndex++;

            switch (c) {
                case 'i':


                    bigbeegravsecondgameObjects.add(new BigBeeGrav());
                    bigbeegravsecondgameObjects.trimToSize();
                    bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).setWorldLocation(
                            BeginX + ((bigbeegravsecondIndex + 1) * (bgLandscape.getbackgroundxResolution() * -1.5f)),
                            BeginY + ((bigbeegravsecondIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.05f)));

                    bigbeegravsecondgameObjects.get(bigbeegravsecondIndex).speed = calculatingspeed(bigbeegravsecondIndex);


                    break;


            }




        }


    }






    void smalloceanfishLevelThreeOcean(int smalloceanfishIndex, int startsmallfish, int finishsmallfish,
                                     FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int s = 0; s < smalloceanfishObject.length(); s++) {
            c = smalloceanfishObject.charAt(s);

            smalloceanfishIndex++;

            switch (c) {
                case 'f':


                    smalloceanfishgameObjects.add(new SmallOceanFish());
                    smalloceanfishgameObjects.trimToSize();
                    smalloceanfishgameObjects.get(smalloceanfishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);

                    if(smalloceanfishgameObjects.get(smalloceanfishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("RIGHT");

                    }

                    smalloceanfishgameObjects.get(smalloceanfishIndex).speed = calculatingspeed(smalloceanfishIndex);


                    if (s != 0) {
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapWidth(bitmapWidth);
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapWidth();
                bitmapHeight = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;
        }


    }

    void bigoceanfishLevelThreeOcean(int bigoceanfishIndex, int startbigfish, int finishbigfish,
                                   FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int t = 0; t < bigoceanfishObject.length(); t++) {
            c = bigoceanfishObject.charAt(t);

            bigoceanfishIndex++;

            switch (c) {
                case 'F':


                    bigoceanfishgameObjects.add(new BigOceanFish());
                    bigoceanfishgameObjects.trimToSize();
                    bigoceanfishgameObjects.get(bigoceanfishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);

                    if(bigoceanfishgameObjects.get(bigoceanfishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("RIGHT");

                    }

                    bigoceanfishgameObjects.get(bigoceanfishIndex).speed = calculatingspeed(bigoceanfishIndex);



                    if (t != 0) {
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapWidth(bitmapWidth);
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapWidth();
                bitmapHeight = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;
        }

    }

    void sandladybugLevelThreeOcean(int sandladybugIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int w = 0; w < sandladybugObject.length(); w++) {
            c = sandladybugObject.charAt(w);

            sandladybugIndex++;


            switch (c) {
                case 's':


                    sandladybuggameObjects.add(new SandLadyBug());
                    sandladybuggameObjects.trimToSize();
                    sandladybuggameObjects.get(sandladybugIndex).setWorldLocation(
                            BeginX + arraylistofsandladybugposition[(sandladybugIndex + 1) * 2],
                            BeginY + arraylistofsandladybugposition[((sandladybugIndex + 1) * 2) + 1]);

                    sandladybuggameObjects.get(sandladybugIndex).sandladybugrand = (sandladybugIndex + 1) * 2;

                    sandladybuggameObjects.get(sandladybugIndex).speed = calculatingspeed(sandladybugIndex);


                    if (w != 0) {
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapWidth(bitmapWidth);
                        sandladybuggameObjects.get(sandladybugIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = sandladybuggameObjects.get(sandladybugIndex).prepareBitmap(sandladybuggameObjects.get(sandladybugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = sandladybuggameObjects.get(sandladybugIndex).getBitmapWidth();
                bitmapHeight = sandladybuggameObjects.get(sandladybugIndex).getBitmapHeight();


            }


        }


    }

 void swirlwaterLevelThreeOcean(int swirlwaterIndex, FrogFungiPlayerState frogFungiPlayerState){

     char c;

     for (int f = 0; f < swirlwaterObject.length(); f++) {
         c = swirlwaterObject.charAt(f);


         swirlwaterIndex++;

         switch (c) {
             case 'w':


                 swirlwatergameObjects.add(new SwirlWater());
                 swirlwatergameObjects.trimToSize();


                 if (f != 0) {
                     swirlwatergameObjects.get(swirlwaterIndex).setBitmapWidth(bitmapWidth);
                     swirlwatergameObjects.get(swirlwaterIndex).setBitmapHeight(bitmapHeight);
                 }


                 break;


         }


         if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


             bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = swirlwatergameObjects.get(swirlwaterIndex).prepareBitmap(swirlwatergameObjects.get(swirlwaterIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
             bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = swirlwatergameObjects.get(swirlwaterIndex).prepareBitmap(swirlwatergameObjects.get(swirlwaterIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


             bitmapWidth = swirlwatergameObjects.get(swirlwaterIndex).getBitmapWidth();
             bitmapHeight = swirlwatergameObjects.get(swirlwaterIndex).getBitmapHeight();

         }


     }




 }

 void swirlwatersecondLevelThreeOcean(int swirlwatersecondIndex) {
     char c;

     for (int g = 0; g < swirlwatersecondObject.length(); g++) {
         c = swirlwatersecondObject.charAt(g);


         swirlwatersecondIndex++;

         switch (c) {
             case 'w':


                 swirlwatersecondgameObjects.add(new SwirlWater());
                 swirlwatersecondgameObjects.trimToSize();


                     swirlwatersecondgameObjects.get(swirlwatersecondIndex).setBitmapWidth(bitmapWidth);
                     swirlwatersecondgameObjects.get(swirlwatersecondIndex).setBitmapHeight(bitmapHeight);


                 break;


         }

     }
 }

 void swirlwaterthirdLevelThreeOcean(int swirlwaterthirdIndex){
     char c;

     for (int h = 0; h < swirlwaterthirdObject.length(); h++) {
         c = swirlwaterthirdObject.charAt(h);


         swirlwaterthirdIndex++;

         switch (c) {
             case 'w':


                 swirlwaterthirdgameObjects.add(new SwirlWater());
                 swirlwaterthirdgameObjects.trimToSize();


                 swirlwaterthirdgameObjects.get(swirlwaterthirdIndex).setBitmapWidth(bitmapWidth);
                 swirlwaterthirdgameObjects.get(swirlwaterthirdIndex).setBitmapHeight(bitmapHeight);


                 break;


         }

     }


     }


    
    
    
    
 void stargravLevelThreeOcean(int stargravIndex, FrogFungiPlayerState frogFungiPlayerState){

     char c;

     for (int o = 0; o < stargravObject.length(); o++) {
         c = stargravObject.charAt(o);


         stargravIndex++;

         switch (c) {
             case 'v':


                 stargravgameObjects.add(new StarGrav());
                 stargravgameObjects.trimToSize();

                 if (o != 0) {
                     stargravgameObjects.get(stargravIndex).setBitmapWidth(bitmapWidth);
                     stargravgameObjects.get(stargravIndex).setBitmapHeight(bitmapHeight);
                 }


                 break;


         }


         if (bitmapsArray[getBitmapIndexLevelThreeOcean(c)] == null) {


             bitmapsArray[getBitmapIndexLevelThreeOcean(c)] = stargravgameObjects.get(stargravIndex).prepareBitmap(stargravgameObjects.get(stargravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
             bitmapsArray[getBitmapIndexLevelThreeOcean(c) + 1] = stargravgameObjects.get(stargravIndex).prepareBitmap(stargravgameObjects.get(stargravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


             bitmapWidth = stargravgameObjects.get(stargravIndex).getBitmapWidth();
             bitmapHeight = stargravgameObjects.get(stargravIndex).getBitmapHeight();

         }


     }

 }

 void stargravsecondLevelThreeOcean(int stargravsecondIndex){
     char c;

     for (int p = 0; p < stargravsecondObject.length(); p++) {
         c = stargravsecondObject.charAt(p);


         stargravsecondIndex++;

         switch (c) {
             case 'v':


                 stargravsecondgameObjects.add(new StarGrav());
                 stargravsecondgameObjects.trimToSize();


                 stargravsecondgameObjects.get(stargravsecondIndex).setBitmapWidth(bitmapWidth);
                 stargravsecondgameObjects.get(stargravsecondIndex).setBitmapHeight(bitmapHeight);


                 break;


         }

     }

 }

 void stargravthirdLevelThreeOcean(int stargravthirdIndex){
     char c;

     for (int q = 0; q < stargravthirdObject.length(); q++) {
         c = stargravthirdObject.charAt(q);


         stargravthirdIndex++;

         switch (c) {
             case 'v':


                 stargravthirdgameObjects.add(new StarGrav());
                 stargravthirdgameObjects.trimToSize();


                 stargravthirdgameObjects.get(stargravthirdIndex).setBitmapWidth(bitmapWidth);
                 stargravthirdgameObjects.get(stargravthirdIndex).setBitmapHeight(bitmapHeight);


                 break;


         }

     }

 }





    void splashflyLevelFourOcean(int splashflyIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int  d = 0; d < splashflyObject.length(); d++) {
            c = splashflyObject.charAt(d);


            splashflyIndex++;

            switch (c) {
                case 'y':


                    splashflygameObjects.add(new SplashFly());
                    splashflygameObjects.trimToSize();
                    splashflygameObjects.get(splashflyIndex).speed =
                            calculatingcirclespeed(splashflyIndex);

                    if (d != 0) {
                        splashflygameObjects.get(splashflyIndex).setBitmapWidth(bitmapWidth);
                        splashflygameObjects.get(splashflyIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = splashflygameObjects.get(splashflyIndex).prepareBitmap(splashflygameObjects.get(splashflyIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = splashflygameObjects.get(splashflyIndex).prepareBitmap(splashflygameObjects.get(splashflyIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 2] = splashflygameObjects.get(splashflyIndex).prepareBitmap(splashflygameObjects.get(splashflyIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = splashflygameObjects.get(splashflyIndex).getBitmapWidth();
                bitmapHeight = splashflygameObjects.get(splashflyIndex).getBitmapHeight();

            }


        }

    }



   void ghostspinderswirlwaterLevelThreeOcean(int ghostspinderswirlwaterIndex){
       char c;

       for (int z = 0; z < ghostspinderswirlwaterObject.length(); z++) {
           c = ghostspinderswirlwaterObject.charAt(z);


           ghostspinderswirlwaterIndex++;

           switch (c) {
               case 'G':


                   ghostspinderswirlwatergameObjects.add(new GhostSpinder());
                   ghostspinderswirlwatergameObjects.trimToSize();
                   ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).setWorldLocation(
                           BeginX + ((ghostspinderswirlwaterIndex + 1) * (bgLandscape.getbackgroundxResolution() * -2.5f)),
                           BeginY + ((ghostspinderswirlwaterIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.02f)));

                    ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).satellitecode = 1;
                   ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).speed = calculatingghostspinderspeed(ghostspinderswirlwaterIndex);


                   break;


           }
       }

   }
    
   void ghostspindersecondswirlwaterLevelThreeOcean(int ghostspindersecondswirlwaterIndex){
       char c;

       for (int t = 0; t < ghostspindersecondswirlwaterObject.length(); t++) {
           c = ghostspindersecondswirlwaterObject.charAt(t);

           ghostspindersecondswirlwaterIndex++;

           switch (c) {
               case 'G':


                   ghostspindersecondswirlwatergameObjects.add(new GhostSpinder());
                   ghostspindersecondswirlwatergameObjects.trimToSize();
                   ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).setWorldLocation(
                           BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                   ((ghostspindersecondswirlwaterIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                           BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 2.1f) -
                                   (ghostspindersecondswirlwaterIndex + 1));


                   ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).satellitecode = 2;
                   ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).speed =
                           calculatingghostspinderspeed(ghostspindersecondswirlwaterIndex);


                   break;


           }
       }
       
   }
    
   void ghostspinderthirdswirlwaterLevelThreeOcean(int ghostspinderthirdswirlwaterIndex){
       char c;

       for (int b = 0; b < ghostspinderthirdswirlwaterObject.length(); b++) {
           c = ghostspinderthirdswirlwaterObject.charAt(b);


           ghostspinderthirdswirlwaterIndex++;

           switch (c) {
               case 'G':


                   ghostspinderthirdswirlwatergameObjects.add(new GhostSpinder());
                   ghostspinderthirdswirlwatergameObjects.trimToSize();
                   ghostspinderthirdswirlwatergameObjects.get(ghostspinderthirdswirlwaterIndex).setWorldLocation(
                           BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.1f) -
                                   (ghostspinderthirdswirlwaterIndex + 1),
                           BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.3f) -
                                   ((ghostspinderthirdswirlwaterIndex + 1) * bgLandscape.getbackgroundyResolution()));


                   ghostspinderthirdswirlwatergameObjects.get(ghostspinderthirdswirlwaterIndex).satellitecode = 
                   ghostspinderthirdswirlwaterIndex + 1;
                   ghostspinderthirdswirlwatergameObjects.get(ghostspinderthirdswirlwaterIndex).speed =
                           calculatingghostspinderspeed(ghostspinderthirdswirlwaterIndex);


                   break;


           }
       }

   }


    void ghostspinderstargravLevelThreeOcean(int ghostspinderstargravIndex){
        char c;

        for (int z = 0; z < ghostspinderstargravObject.length(); z++) {
            c = ghostspinderstargravObject.charAt(z);


            ghostspinderstargravIndex++;

            switch (c) {
                case 'G':


                    ghostspinderstargravgameObjects.add(new GhostSpinder());
                    ghostspinderstargravgameObjects.trimToSize();
                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.5f) -
                                    ((ghostspinderstargravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.5f)),
                            BeginY + ((ghostspinderstargravIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.2f)));


                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).satellitecode = 1;

                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).speed =
                            calculatingghostspinderspeed(ghostspinderstargravIndex);


                    break;


            }
        }

    }

    void ghostspindersecondstargravLevelThreeOcean(int ghostspindersecondstargravIndex){
        char c;

        for (int t = 0; t < ghostspindersecondstargravObject.length(); t++) {
            c = ghostspindersecondstargravObject.charAt(t);

            ghostspindersecondstargravIndex++;

            switch (c) {
                case 'G':


                    ghostspindersecondstargravgameObjects.add(new GhostSpinder());
                    ghostspindersecondstargravgameObjects.trimToSize();
                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((ghostspindersecondstargravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 10)),
                            BeginY + ((ghostspindersecondstargravIndex + 1) * (bgLandscape.getbackgroundyResolution() * -6.2f)));

                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).satellitecode = 2;

                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).speed =
                            calculatingghostspinderspeed(ghostspindersecondstargravIndex);


                    break;


            }
        }

    }

    void ghostspinderthirdstargravLevelThreeOcean(int ghostspinderthirdstargravIndex){
        char c;

        for (int b = 0; b < ghostspinderthirdstargravObject.length(); b++) {
            c = ghostspinderthirdstargravObject.charAt(b);


            ghostspinderthirdstargravIndex++;

            switch (c) {
                case 'G':


                    ghostspinderthirdstargravgameObjects.add(new GhostSpinder());
                    ghostspinderthirdstargravgameObjects.trimToSize();
                    ghostspinderthirdstargravgameObjects.get(ghostspinderthirdstargravIndex).setWorldLocation(
                            BeginX + ((ghostspinderthirdstargravIndex + 1) * (bgLandscape.getbackgroundxResolution() * -1.5f)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.35f) -
                                    (ghostspinderthirdstargravIndex + 1));

                    ghostspinderthirdstargravgameObjects.get(ghostspinderthirdstargravIndex).satellitecode =
                            ghostspinderthirdstargravIndex + 1;

                    ghostspinderthirdstargravgameObjects.get(ghostspinderthirdstargravIndex).speed =
                            calculatingghostspinderspeed(ghostspinderthirdstargravIndex);


                    break;


            }
        }

    }


    void ghostspindersplashflyLevelFourOcean(int ghostspindersplashflyIndex){
        char c;

        for (int z = 0; z < ghostspindersplashflyObject.length(); z++) {
            c = ghostspindersplashflyObject.charAt(z);


            ghostspindersplashflyIndex++;

            switch (c) {
                case 'G':


                    ghostspindersplashflygameObjects.add(new GhostSpinder());
                    ghostspindersplashflygameObjects.trimToSize();
                    ghostspindersplashflygameObjects.get(ghostspindersplashflyIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((ghostspindersplashflyIndex + 1) * (bgLandscape.getbackgroundxResolution() * 8)),
                            BeginY + ((ghostspindersplashflyIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.2f)));


                    ghostspindersplashflygameObjects.get(ghostspindersplashflyIndex).satellitecode = 1;


                    ghostspindersplashflygameObjects.get(ghostspindersplashflyIndex).speed =
                            calculatingghostspinderspeed(ghostspindersplashflyIndex);


                    break;


            }
        }

    }







    void beegravLevelFourOcean(int beegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int k = 0; k < beegravObject.length(); k++) {
            c = beegravObject.charAt(k);


            beegravIndex++;

            switch (c) {
                case 'b':


                    beegravgameObjects.add(new BeeGrav());
                    beegravgameObjects.trimToSize();
                    beegravgameObjects.get(beegravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.8f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 0.98f));

                    beegravgameObjects.get(beegravIndex).speed = calculatingspeed(beegravIndex);


                    if (k != 0) {
                        beegravgameObjects.get(beegravIndex).setBitmapWidth(bitmapWidth);
                        beegravgameObjects.get(beegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = beegravgameObjects.get(beegravIndex).prepareBitmap(beegravgameObjects.get(beegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapWidth = beegravgameObjects.get(beegravIndex).getBitmapWidth();
                bitmapHeight = beegravgameObjects.get(beegravIndex).getBitmapHeight();

            }


        }



    }

    void beegravsecondLevelFourOcean(int beegravsecondIndex){

        char c;

        for (int q = 0; q < beegravsecondObject.length(); q++) {
            c = beegravsecondObject.charAt(q);


            beegravsecondIndex++;

            switch (c) {
                case 'b':


                    beegravsecondgameObjects.add(new BeeGrav());
                    beegravsecondgameObjects.trimToSize();
                    beegravsecondgameObjects.get(beegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.1f),
                               BeginY +  (bgLandscape.getbackgroundyResolution() *
                                    bgLandscape.getHeight() * 1.1f)
                                   );
                    beegravsecondgameObjects.get(beegravsecondIndex).speed = calculatingspeed(beegravsecondIndex);


                    beegravsecondgameObjects.get(beegravsecondIndex).setBitmapWidth(bitmapWidth);
                    beegravsecondgameObjects.get(beegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }



        }


    }


    void beegravthirdLevelFourOcean(int beegravthirdIndex){

        char c;

        for (int q = 0; q < beegravthirdObject.length(); q++) {
            c = beegravthirdObject.charAt(q);


            beegravthirdIndex++;

            switch (c) {
                case 'b':


                    beegravthirdgameObjects.add(new BeeGrav());
                    beegravthirdgameObjects.trimToSize();
                    beegravthirdgameObjects.get(beegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.7f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -2.1f));

                    beegravthirdgameObjects.get(beegravthirdIndex).speed = calculatingspeed(beegravthirdIndex);

                    beegravthirdgameObjects.get(beegravthirdIndex).setBitmapWidth(bitmapWidth);
                    beegravthirdgameObjects.get(beegravthirdIndex).setBitmapHeight(bitmapHeight);



                    break;


            }



        }


    }


    void beegravfourthLevelFourOcean(int beegravfourthIndex){

        char c;

        for (int q = 0; q < beegravfourthObject.length(); q++) {
            c = beegravfourthObject.charAt(q);


            beegravfourthIndex++;

            switch (c) {
                case 'b':


                    beegravfourthgameObjects.add(new BeeGrav());
                    beegravfourthgameObjects.trimToSize();
                    beegravfourthgameObjects.get(beegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 0.1f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * 0.1f));

                    beegravfourthgameObjects.get(beegravfourthIndex).speed = calculatingspeed(beegravfourthIndex);


                    beegravfourthgameObjects.get(beegravfourthIndex).setBitmapWidth(bitmapWidth);
                    beegravfourthgameObjects.get(beegravfourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }




        }


    }



    void swirlwaterLevelFourOcean(int swirlwaterIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int f = 0; f < swirlwaterObject.length(); f++) {
            c = swirlwaterObject.charAt(f);


            swirlwaterIndex++;

            switch (c) {
                case 'w':


                    swirlwatergameObjects.add(new SwirlWater());
                    swirlwatergameObjects.trimToSize();


                    if (f != 0) {
                        swirlwatergameObjects.get(swirlwaterIndex).setBitmapWidth(bitmapWidth);
                        swirlwatergameObjects.get(swirlwaterIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = swirlwatergameObjects.get(swirlwaterIndex).prepareBitmap(swirlwatergameObjects.get(swirlwaterIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = swirlwatergameObjects.get(swirlwaterIndex).prepareBitmap(swirlwatergameObjects.get(swirlwaterIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = swirlwatergameObjects.get(swirlwaterIndex).getBitmapWidth();
                bitmapHeight = swirlwatergameObjects.get(swirlwaterIndex).getBitmapHeight();

            }


        }




    }

    void swirlwatersecondLevelFourOcean(int swirlwatersecondIndex) {
        char c;

        for (int g = 0; g < swirlwatersecondObject.length(); g++) {
            c = swirlwatersecondObject.charAt(g);


            swirlwatersecondIndex++;

            switch (c) {
                case 'w':


                    swirlwatersecondgameObjects.add(new SwirlWater());
                    swirlwatersecondgameObjects.trimToSize();


                    swirlwatersecondgameObjects.get(swirlwatersecondIndex).setBitmapWidth(bitmapWidth);
                    swirlwatersecondgameObjects.get(swirlwatersecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }

        }
    }



    void stargravLevelFourOcean(int stargravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int o = 0; o < stargravObject.length(); o++) {
            c = stargravObject.charAt(o);


            stargravIndex++;

            switch (c) {
                case 'v':


                    stargravgameObjects.add(new StarGrav());
                    stargravgameObjects.trimToSize();

                    if (o != 0) {
                        stargravgameObjects.get(stargravIndex).setBitmapWidth(bitmapWidth);
                        stargravgameObjects.get(stargravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = stargravgameObjects.get(stargravIndex).prepareBitmap(stargravgameObjects.get(stargravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = stargravgameObjects.get(stargravIndex).prepareBitmap(stargravgameObjects.get(stargravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = stargravgameObjects.get(stargravIndex).getBitmapWidth();
                bitmapHeight = stargravgameObjects.get(stargravIndex).getBitmapHeight();

            }


        }

    }

    void stargravsecondLevelFourOcean(int stargravsecondIndex){
        char c;

        for (int p = 0; p < stargravsecondObject.length(); p++) {
            c = stargravsecondObject.charAt(p);


            stargravsecondIndex++;

            switch (c) {
                case 'v':


                    stargravsecondgameObjects.add(new StarGrav());
                    stargravsecondgameObjects.trimToSize();


                    stargravsecondgameObjects.get(stargravsecondIndex).setBitmapWidth(bitmapWidth);
                    stargravsecondgameObjects.get(stargravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }

        }

    }



    void ghostspinderswirlwaterLevelFourOcean(int ghostspinderswirlwaterIndex){
        char c;

        for (int z = 0; z < ghostspinderswirlwaterObject.length(); z++) {
            c = ghostspinderswirlwaterObject.charAt(z);


            ghostspinderswirlwaterIndex++;

            switch (c) {
                case 'G':


                    ghostspinderswirlwatergameObjects.add(new GhostSpinder());
                    ghostspinderswirlwatergameObjects.trimToSize();
                    ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.3f) -
                                     ((ghostspinderswirlwaterIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.5f)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.3f) -
                                    ((ghostspinderswirlwaterIndex + 1) * (bgLandscape.getbackgroundyResolution() * 1.2f)));

                    ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).satellitecode = 2;
                    ghostspinderswirlwatergameObjects.get(ghostspinderswirlwaterIndex).speed =
                            calculatingghostspinderspeed(ghostspinderswirlwaterIndex);


                    break;


            }
        }

    }

    void ghostspindersecondswirlwaterLevelFourOcean(int ghostspindersecondswirlwaterIndex){
        char c;

        for (int t = 0; t < ghostspindersecondswirlwaterObject.length(); t++) {
            c = ghostspindersecondswirlwaterObject.charAt(t);

            ghostspindersecondswirlwaterIndex++;

            switch (c) {
                case 'G':


                    ghostspindersecondswirlwatergameObjects.add(new GhostSpinder());
                    ghostspindersecondswirlwatergameObjects.trimToSize();
                    ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((ghostspindersecondswirlwaterIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 2.1f) -
                                    (ghostspindersecondswirlwaterIndex + 1));


                    ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).satellitecode =
                    ghostspindersecondswirlwaterIndex + 1;

                    ghostspindersecondswirlwatergameObjects.get(ghostspindersecondswirlwaterIndex).speed =
                            calculatingghostspinderspeed(ghostspindersecondswirlwaterIndex);


                    break;


            }
        }

    }

    void ghostspinderstargravLevelFourOcean(int ghostspinderstargravIndex){
        char c;

        for (int z = 0; z < ghostspinderstargravObject.length(); z++) {
            c = ghostspinderstargravObject.charAt(z);


            ghostspinderstargravIndex++;

            switch (c) {
                case 'G':


                     ghostspinderstargravgameObjects.add(new GhostSpinder());
                    ghostspinderstargravgameObjects.trimToSize();
                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -1.5f) -
                                    (ghostspinderstargravIndex + 1),
                            BeginY + ((ghostspinderstargravIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.2f)));


                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).satellitecode = 2;

                    ghostspinderstargravgameObjects.get(ghostspinderstargravIndex).speed =
                            calculatingghostspinderspeed(ghostspinderstargravIndex);


                    break;


            }
        }

    }

    void ghostspindersecondstargravLevelFourOcean(int ghostspindersecondstargravIndex){
        char c;

        for (int t = 0; t < ghostspindersecondstargravObject.length(); t++) {
            c = ghostspindersecondstargravObject.charAt(t);

            ghostspindersecondstargravIndex++;

            switch (c) {
                case 'G':


                    ghostspindersecondstargravgameObjects.add(new GhostSpinder());
                    ghostspindersecondstargravgameObjects.trimToSize();
                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((ghostspindersecondstargravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 10)),
                            BeginY + ((ghostspindersecondstargravIndex + 1) * (bgLandscape.getbackgroundyResolution() * -6.2f)));

                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).satellitecode =
                    ghostspindersecondstargravIndex + 1;

                    ghostspindersecondstargravgameObjects.get(ghostspindersecondstargravIndex).speed =
                            calculatingghostspinderspeed(ghostspindersecondstargravIndex);


                    break;


            }
        }

    }


    void suckerbeegravLevelFourOcean(int suckerbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int a = 0; a < suckerbeegravObject.length(); a++) {
            c = suckerbeegravObject.charAt(a);

            suckerbeegravIndex++;


            switch (c) {
                case 'k':


                    suckerbeegravgameObjects.add(new SuckerBeeGrav());
                    suckerbeegravgameObjects.trimToSize();
                    suckerbeegravgameObjects.get(suckerbeegravIndex).setWorldLocation(
                            BeginX + arraylistofsuckerbeegravposition[(suckerbeegravIndex) * 2],
                            BeginY + arraylistofsuckerbeegravposition[((suckerbeegravIndex) * 2) + 1]);


                    suckerbeegravgameObjects.get(suckerbeegravIndex).suckerbeegravrand = suckerbeegravIndex * 2;


                    suckerbeegravgameObjects.get(suckerbeegravIndex).speed = calculatingspeed(suckerbeegravIndex);


                    if (a != 0) {
                        suckerbeegravgameObjects.get(suckerbeegravIndex).setBitmapWidth(bitmapWidth);
                        suckerbeegravgameObjects.get(suckerbeegravIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = suckerbeegravgameObjects.get(suckerbeegravIndex).prepareBitmap(suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = suckerbeegravgameObjects.get(suckerbeegravIndex).prepareBitmap(suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapWidth();
                bitmapHeight = suckerbeegravgameObjects.get(suckerbeegravIndex).getBitmapHeight();


            }


        }


    }

    void smalloceanfishLevelFourOcean(int smalloceanfishIndex, int startsmallfish, int finishsmallfish,
                                       FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int s = 0; s < smalloceanfishObject.length(); s++) {
            c = smalloceanfishObject.charAt(s);

            smalloceanfishIndex++;

            switch (c) {
                case 'f':


                    smalloceanfishgameObjects.add(new SmallOceanFish());
                    smalloceanfishgameObjects.trimToSize();
                    smalloceanfishgameObjects.get(smalloceanfishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);

                    if(smalloceanfishgameObjects.get(smalloceanfishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        smalloceanfishgameObjects.get(smalloceanfishIndex).setFacing("RIGHT");

                    }

                    smalloceanfishgameObjects.get(smalloceanfishIndex).speed = calculatingspeed(smalloceanfishIndex);


                    if (s != 0) {
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapWidth(bitmapWidth);
                        smalloceanfishgameObjects.get(smalloceanfishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = smalloceanfishgameObjects.get(smalloceanfishIndex).prepareBitmap(smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapWidth();
                bitmapHeight = smalloceanfishgameObjects.get(smalloceanfishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;
        }


    }

    void bigoceanfishLevelFourOcean(int bigoceanfishIndex, int startbigfish, int finishbigfish,
                                     FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int t = 0; t < bigoceanfishObject.length(); t++) {
            c = bigoceanfishObject.charAt(t);

            bigoceanfishIndex++;

            switch (c) {
                case 'F':


                    bigoceanfishgameObjects.add(new BigOceanFish());
                    bigoceanfishgameObjects.trimToSize();
                    bigoceanfishgameObjects.get(bigoceanfishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);

                    if(bigoceanfishgameObjects.get(bigoceanfishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("LEFT");
                    }
                    else {

                        bigoceanfishgameObjects.get(bigoceanfishIndex).setFacing("RIGHT");

                    }

                    bigoceanfishgameObjects.get(bigoceanfishIndex).speed = calculatingspeed(bigoceanfishIndex);



                    if (t != 0) {
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapWidth(bitmapWidth);
                        bigoceanfishgameObjects.get(bigoceanfishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = bigoceanfishgameObjects.get(bigoceanfishIndex).prepareBitmap(bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapWidth();
                bitmapHeight = bigoceanfishgameObjects.get(bigoceanfishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;
        }

    }

    void oceanbugLevelFourOcean(int oceanbugIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int x = 0; x < oceanbugObject.length(); x++) {
            c = oceanbugObject.charAt(x);

            oceanbugIndex++;

            switch (c) {
                case 'o':


                    oceanbuggameObjects.add(new OceanBug());
                    oceanbuggameObjects.trimToSize();
                    oceanbuggameObjects.get(oceanbugIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    (bgLandscape.getbackgroundxResolution() * 5),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -2.2f));

                    oceanbuggameObjects.get(oceanbugIndex).speed = calculatingspeed(oceanbugIndex);

                    
                    if (x != 0) {
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapWidth(bitmapWidth);
                        oceanbuggameObjects.get(oceanbugIndex).setBitmapHeight(bitmapHeight);


                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = oceanbuggameObjects.get(oceanbugIndex).prepareBitmap(oceanbuggameObjects.get(oceanbugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = oceanbuggameObjects.get(oceanbugIndex).getBitmapWidth();
                bitmapHeight = oceanbuggameObjects.get(oceanbugIndex).getBitmapHeight();


            }
        }

    }

    void oceanbugsecondLevelFourOcean(int oceanbugsecondIndex){

        char c;

        for (int x = 0; x < oceanbugsecondObject.length(); x++) {
            c = oceanbugsecondObject.charAt(x);

            oceanbugsecondIndex++;

            switch (c) {
                case 'o':


                    oceanbugsecondgameObjects.add(new OceanBug());
                    oceanbugsecondgameObjects.trimToSize();


                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.98f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -1.3f));

                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).speed = calculatingspeed(oceanbugsecondIndex);

                    
                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).setBitmapWidth(bitmapWidth);
                    oceanbugsecondgameObjects.get(oceanbugsecondIndex).setBitmapHeight(bitmapHeight);




                    break;


            }



        }

    }

    void oceanbugthirdLevelFourOcean(int oceanbugthirdIndex){

        char c;

        for (int f = 0; f < oceanbugthirdObject.length(); f++) {
            c = oceanbugthirdObject.charAt(f);

            oceanbugthirdIndex++;

            switch (c) {
                case 'o':


                    oceanbugthirdgameObjects.add(new OceanBug());
                    oceanbugthirdgameObjects.trimToSize();


                    oceanbugthirdgameObjects.get(oceanbugthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -4.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -4.5f));

                    oceanbugthirdgameObjects.get(oceanbugthirdIndex).speed = calculatingspeed(oceanbugthirdIndex);


                    oceanbugthirdgameObjects.get(oceanbugthirdIndex).setBitmapWidth(bitmapWidth);
                    oceanbugthirdgameObjects.get(oceanbugthirdIndex).setBitmapHeight(bitmapHeight);




                    break;


            }



        }

    }


    void oceanbugfourthLevelFourOcean(int oceanbugfourthIndex){

        char c;

        for (int r = 0; r < oceanbugfourthObject.length(); r++) {
            c = oceanbugfourthObject.charAt(r);

            oceanbugfourthIndex++;

            switch (c) {
                case 'o':


                    oceanbugfourthgameObjects.add(new OceanBug());
                    oceanbugfourthgameObjects.trimToSize();


                    oceanbugfourthgameObjects.get(oceanbugfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 0.1f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 0.98f));

                    oceanbugfourthgameObjects.get(oceanbugfourthIndex).speed = calculatingspeed(oceanbugfourthIndex);


                    oceanbugfourthgameObjects.get(oceanbugfourthIndex).setBitmapWidth(bitmapWidth);
                    oceanbugfourthgameObjects.get(oceanbugfourthIndex).setBitmapHeight(bitmapHeight);




                    break;


            }



        }

    }


    void waterdropLevelFourOcean(int waterdropIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int b = 0; b < waterdropObject.length(); b++) {
            c = waterdropObject.charAt(b);

            waterdropIndex++;


            switch (c) {
                case 'p':


                    waterdropgameObjects.add(new WaterDrop());
                    waterdropgameObjects.trimToSize();

                    waterdropgameObjects.get(waterdropIndex).speed = calculatingspeed(waterdropIndex);


                    if (b != 0) {
                        waterdropgameObjects.get(waterdropIndex).setBitmapWidth(bitmapWidth);
                        waterdropgameObjects.get(waterdropIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourOcean(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourOcean(c)] = waterdropgameObjects.get(waterdropIndex).prepareBitmap(waterdropgameObjects.get(waterdropIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 1] = waterdropgameObjects.get(waterdropIndex).prepareBitmap(waterdropgameObjects.get(waterdropIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 2] = waterdropgameObjects.get(waterdropIndex).prepareBitmap(waterdropgameObjects.get(waterdropIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourOcean(c) + 3] = waterdropgameObjects.get(waterdropIndex).prepareBitmap(waterdropgameObjects.get(waterdropIndex).getBitmapNameJumpLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = waterdropgameObjects.get(waterdropIndex).getBitmapWidth();
                bitmapHeight = waterdropgameObjects.get(waterdropIndex).getBitmapHeight();


            }


            waterdropgameObjects.get(waterdropIndex).setWorldLocation(
                    BeginX + arraylistofwaterdropposition[waterdropIndex * 2] - (waterdropgameObjects.get(waterdropIndex).getBitmapWidth() / 2),
                    BeginY + arraylistofwaterdropposition[(waterdropIndex * 2) + 1] - (waterdropgameObjects.get(waterdropIndex).getBitmapHeight() / 2));



        }

    }


    void smalllavafishLevelOneLava(int smalllavafishIndex, int startsmallfish, int finishsmallfish,
                                   FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int s = 0; s < smalllavafishObject.length(); s++) {
            c = smalllavafishObject.charAt(s);

            smalllavafishIndex++;

            switch (c) {
                case 'l':


                    smalllavafishgameObjects.add(new SmallLavaFish());
                    smalllavafishgameObjects.trimToSize();
                    smalllavafishgameObjects.get(smalllavafishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);


                    if(smalllavafishgameObjects.get(smalllavafishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("LEFT");
                    }
                    else {

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("RIGHT");

                    }

                    smalllavafishgameObjects.get(smalllavafishIndex).speed = calculatingspeed(smalllavafishIndex);


                    if (s != 0) {
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapWidth(bitmapWidth);
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneLava(c)] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapWidth();
                bitmapHeight = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;

        }


    }



    void biglavafishLevelOneLava(int biglavafishIndex, int startbigfish, int finishbigfish,
                                 FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int t = 0; t < biglavafishObject.length(); t++) {
            c = biglavafishObject.charAt(t);

            biglavafishIndex++;

            switch (c) {
                case 'L':


                    biglavafishgameObjects.add(new BigLavaFish());
                    biglavafishgameObjects.trimToSize();
                    biglavafishgameObjects.get(biglavafishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);


                    if(biglavafishgameObjects.get(biglavafishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("LEFT");
                    }
                    else {

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("RIGHT");

                    }

                    biglavafishgameObjects.get(biglavafishIndex).speed = calculatingspeed(biglavafishIndex);


                    if (t != 0) {
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapWidth(bitmapWidth);
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneLava(c)] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = biglavafishgameObjects.get(biglavafishIndex).getBitmapWidth();
                bitmapHeight = biglavafishgameObjects.get(biglavafishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;


        }




    }



   void rockbeegravLevelOneLava(int rockbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
       char c;

       for (int k = 0; k < rockbeegravObject.length(); k++) {
           c = rockbeegravObject.charAt(k);


           rockbeegravIndex++;

           switch (c) {
               case 'b':


                   rockbeegravgameObjects.add(new RockBeeGrav());
                   rockbeegravgameObjects.trimToSize();
                   rockbeegravgameObjects.get(rockbeegravIndex).setWorldLocation(
                           BeginX + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                           BeginY + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                   rockbeegravgameObjects.get(rockbeegravIndex).speed = calculatingspeed(rockbeegravIndex);


                   if (k != 0) {
                       rockbeegravgameObjects.get(rockbeegravIndex).setBitmapWidth(bitmapWidth);
                       rockbeegravgameObjects.get(rockbeegravIndex).setBitmapHeight(bitmapHeight);
                   }


                   break;


           }


           if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


               bitmapsArray[getBitmapIndexLevelOneLava(c)] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
               bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


               bitmapWidth = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapWidth();
               bitmapHeight = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapHeight();

           }


       }
       
   }

    void rockbeegravsecondLevelOneLava(int rockbeegravsecondIndex){
        char c;

        for (int s = 0; s < rockbeegravsecondObject.length(); s++) {
            c = rockbeegravsecondObject.charAt(s);


            rockbeegravsecondIndex++;

            switch (c) {
                case 'b':


                    rockbeegravsecondgameObjects.add(new RockBeeGrav());
                    rockbeegravsecondgameObjects.trimToSize();
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.2f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.3f));

                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).speed = calculatingspeed(rockbeegravsecondIndex);


                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }

    
   void rockbigbeegravLevelOneLava(int rockbigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

       char c;

       for (int l = 0; l < rockbigbeegravObject.length(); l++) {
           c = rockbigbeegravObject.charAt(l);

           rockbigbeegravIndex++;

           switch (c) {
               case 'B':


                   rockbigbeegravgameObjects.add(new RockBigBeeGrav());
                   rockbigbeegravgameObjects.trimToSize();
                   rockbigbeegravgameObjects.get(rockbigbeegravIndex).setWorldLocation(
                           BeginX + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 5)),
                           BeginY + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.8f)));

                   rockbigbeegravgameObjects.get(rockbigbeegravIndex).speed = calculatingspeed(rockbigbeegravIndex);


                   if (l != 0) {

                       rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapWidth(bitmapWidth);
                       rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapHeight(bitmapHeight);

                   }


                   break;


           }


           if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


               bitmapsArray[getBitmapIndexLevelOneLava(c)] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
               bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


               bitmapWidth = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapWidth();
               bitmapHeight = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapHeight();


           }


       }
       
   }


    void rockbigbeegravsecondLevelOneLava(int rockbigbeegravsecondIndex) {

        char c;

        for (int n = 0; n < rockbigbeegravsecondObject.length(); n++) {
            c = rockbigbeegravsecondObject.charAt(n);

            rockbigbeegravsecondIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravsecondgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravsecondgameObjects.trimToSize();
                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -1.8f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.2f));

                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).speed = calculatingspeed(rockbigbeegravsecondIndex);


                        rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                        rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapHeight(bitmapHeight);



                    break;


            }
        }
    }



        void dustrockbeegravlavaLevelOneLava(int dustrockbeegravlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int y = 0; y < dustrockbeegravlavaObject.length(); y++) {
            c = dustrockbeegravlavaObject.charAt(y);


            dustrockbeegravlavaIndex++;

            switch (c) {
                case 'd':


                    dustrockbeegravlavagameObjects.add(new DustRockBeeGravLava());
                    dustrockbeegravlavagameObjects.trimToSize();
                    dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.2f) -
                                    ((dustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2.5f)),
                            BeginY + ((dustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * -0.8f)));

                    dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).speed = calculatingspeed(dustrockbeegravlavaIndex);


                    if (y != 0) {
                        dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setBitmapWidth(bitmapWidth);
                        dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelOneLava(c)] = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).prepareBitmap(dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).prepareBitmap(dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapWidth();
                bitmapHeight = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapHeight();

            }


        }

    }



   void fungilavaLevelOneLava(int fungilavaIndex, FrogFungiPlayerState frogFungiPlayerState){

       char c;

       for (int a = 0; a < fungilavaObject.length(); a++) {
           c = fungilavaObject.charAt(a);

           fungilavaIndex++;


           switch (c) {
               case 'F':


                   fungilavagameObjects.add(new FungiLava());
                   fungilavagameObjects.trimToSize();
                   fungilavagameObjects.get(fungilavaIndex).setWorldLocation(
                           BeginX + arraylistoflavabugposition[(fungilavaIndex + 10) * 2],
                           BeginY + arraylistoflavabugposition[((fungilavaIndex + 10) * 2) + 1] + (bgLandscape.getbackgroundyResolution() * 2));

                   fungilavagameObjects.get(fungilavaIndex).fungilavarand = (fungilavaIndex + 10) * 2;

                   fungilavagameObjects.get(fungilavaIndex).speed = calculatingspeed(fungilavaIndex);


                   if (a != 0) {
                       fungilavagameObjects.get(fungilavaIndex).setBitmapWidth(bitmapWidth);
                       fungilavagameObjects.get(fungilavaIndex).setBitmapHeight(bitmapHeight);


                   }

                   break;


           }


           if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


               bitmapsArray[getBitmapIndexLevelOneLava(c)] = fungilavagameObjects.get(fungilavaIndex).prepareBitmap(fungilavagameObjects.get(fungilavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


               bitmapWidth = fungilavagameObjects.get(fungilavaIndex).getBitmapWidth();
               bitmapHeight = fungilavagameObjects.get(fungilavaIndex).getBitmapHeight();


           }


       }
       
   }

   void jumpingratlavaLevelOneLava(int jumpingratlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

       char c;

       for (int b = 0; b < jumpingratlavaObject.length(); b++) {
           c = jumpingratlavaObject.charAt(b);

           jumpingratlavaIndex++;


           switch (c) {
               case 'J':


                   jumpingratlavagameObjects.add(new JumpingRatLava());
                   jumpingratlavagameObjects.trimToSize();

                   jumpingratlavagameObjects.get(jumpingratlavaIndex).speed = calculatingspeed(jumpingratlavaIndex);


                   if (b != 0) {
                       jumpingratlavagameObjects.get(jumpingratlavaIndex).setBitmapWidth(bitmapWidth);
                       jumpingratlavagameObjects.get(jumpingratlavaIndex).setBitmapHeight(bitmapHeight);


                   }

                   break;


           }


           if (bitmapsArray[getBitmapIndexLevelOneLava(c)] == null) {


               bitmapsArray[getBitmapIndexLevelOneLava(c)] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
               bitmapsArray[getBitmapIndexLevelOneLava(c) + 1] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
               bitmapsArray[getBitmapIndexLevelOneLava(c) + 2] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
               bitmapsArray[getBitmapIndexLevelOneLava(c) + 3] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameJumpLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


               bitmapWidth = jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapWidth();
               bitmapHeight = jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapHeight();


           }


           jumpingratlavagameObjects.get(jumpingratlavaIndex).setWorldLocation(
                   BeginX + arraylistoflavabugposition[(jumpingratlavaIndex + 13) * 2]
                           - (jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapWidth()/2),
                   BeginY + arraylistoflavabugposition[((jumpingratlavaIndex + 13) * 2) + 1]
                           - jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapHeight()/2);

           jumpingratlavagameObjects.get(jumpingratlavaIndex).jumpingratlavarand = (jumpingratlavaIndex + 13) * 2;



       }



   }



    void smalllavafishLevelTwoLava(int smalllavafishIndex, int startsmallfish, int finishsmallfish,
                                   FrogFungiPlayerState frogFungiPlayerState) {
        char c;

        for (int s = 0; s < smalllavafishObject.length(); s++) {
            c = smalllavafishObject.charAt(s);

            smalllavafishIndex++;

            switch (c) {
                case 'l':


                    smalllavafishgameObjects.add(new SmallLavaFish());
                    smalllavafishgameObjects.trimToSize();
                    smalllavafishgameObjects.get(smalllavafishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);


                    if(smalllavafishgameObjects.get(smalllavafishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("LEFT");
                    }
                    else {

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("RIGHT");

                    }

                    smalllavafishgameObjects.get(smalllavafishIndex).speed = calculatingspeed(smalllavafishIndex);


                    if (s != 0) {
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapWidth(bitmapWidth);
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapWidth();
                bitmapHeight = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;

        }

    }

    void biglavafishLevelTwoLava(int biglavafishIndex, int startbigfish, int finishbigfish,
                                 FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int t = 0; t < biglavafishObject.length(); t++) {
            c = biglavafishObject.charAt(t);

            biglavafishIndex++;

            switch (c) {
                case 'L':


                    biglavafishgameObjects.add(new BigLavaFish());
                    biglavafishgameObjects.trimToSize();
                    biglavafishgameObjects.get(biglavafishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);


                    if(biglavafishgameObjects.get(biglavafishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("LEFT");
                    }
                    else {

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("RIGHT");

                    }

                    biglavafishgameObjects.get(biglavafishIndex).speed = calculatingspeed(biglavafishIndex);


                    if (t != 0) {
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapWidth(bitmapWidth);
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = biglavafishgameObjects.get(biglavafishIndex).getBitmapWidth();
                bitmapHeight = biglavafishgameObjects.get(biglavafishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;


        }




    }
    
    
        void rockbeegravLevelTwoLava(int rockbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
            char c;

            for (int k = 0; k < rockbeegravObject.length(); k++) {
                c = rockbeegravObject.charAt(k);


                rockbeegravIndex++;

                switch (c) {
                    case 'b':


                        rockbeegravgameObjects.add(new RockBeeGrav());
                        rockbeegravgameObjects.trimToSize();
                        rockbeegravgameObjects.get(rockbeegravIndex).setWorldLocation(
                                BeginX + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.1f)),
                                BeginY + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                        rockbeegravgameObjects.get(rockbeegravIndex).speed = calculatingspeed(rockbeegravIndex);


                        if (k != 0) {
                            rockbeegravgameObjects.get(rockbeegravIndex).setBitmapWidth(bitmapWidth);
                            rockbeegravgameObjects.get(rockbeegravIndex).setBitmapHeight(bitmapHeight);
                        }


                        break;


                }


                if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                    bitmapsArray[getBitmapIndexLevelTwoLava(c)] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                    bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                    bitmapWidth = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapWidth();
                    bitmapHeight = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapHeight();

                }


            }

    }


    void rockbeegravsecondLevelTwoLava(int rockbeegravsecondIndex){
        char c;

        for (int s = 0; s < rockbeegravsecondObject.length(); s++) {
            c = rockbeegravsecondObject.charAt(s);


            rockbeegravsecondIndex++;

            switch (c) {
                case 'b':


                    rockbeegravsecondgameObjects.add(new RockBeeGrav());
                    rockbeegravsecondgameObjects.trimToSize();
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setWorldLocation(
                            BeginX +  (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -1.8f));

                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).speed = calculatingspeed(rockbeegravsecondIndex);


                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravthirdLevelTwoLava(int rockbeegravthirdIndex){
        char c;

        for (int m = 0; m < rockbeegravthirdObject.length(); m++) {
            c = rockbeegravthirdObject.charAt(m);


            rockbeegravthirdIndex++;

            switch (c) {
                case 'b':


                    rockbeegravthirdgameObjects.add(new RockBeeGrav());
                    rockbeegravthirdgameObjects.trimToSize();
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    (bgLandscape.getbackgroundxResolution() * 5),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.35f) -
                                     (bgLandscape.getbackgroundyResolution() * 0.8f));

                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).speed = calculatingspeed(rockbeegravthirdIndex);


                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravfourthLevelTwoLava(int rockbeegravfourthIndex){
        char c;

        for (int m = 0; m < rockbeegravfourthObject.length(); m++) {
            c = rockbeegravfourthObject.charAt(m);


            rockbeegravfourthIndex++;

            switch (c) {
                case 'b':


                    rockbeegravfourthgameObjects.add(new RockBeeGrav());
                    rockbeegravfourthgameObjects.trimToSize();
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundyResolution() * bgLandscape.getWidth() * 0.5f) -
                                    (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY +  (bgLandscape.getbackgroundyResolution() * -3.8f));

                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).speed = calculatingspeed(rockbeegravfourthIndex);


                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }


    void rockbigbeegravLevelTwoLava(int rockbigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int l = 0; l < rockbigbeegravObject.length(); l++) {
            c = rockbigbeegravObject.charAt(l);

            rockbigbeegravIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravgameObjects.trimToSize();
                    rockbigbeegravgameObjects.get(rockbigbeegravIndex).setWorldLocation(
                            BeginX + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 7)),
                            BeginY + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    rockbigbeegravgameObjects.get(rockbigbeegravIndex).speed = calculatingspeed(rockbigbeegravIndex);


                    if (l != 0) {

                        rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapWidth(bitmapWidth);
                        rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapWidth();
                bitmapHeight = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapHeight();


            }


        }


    }


    void rockbigbeegravsecondLevelTwoLava(int rockbigbeegravsecondIndex) {

        char c;

        for (int n = 0; n < rockbigbeegravsecondObject.length(); n++) {
            c = rockbigbeegravsecondObject.charAt(n);

            rockbigbeegravsecondIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravsecondgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravsecondgameObjects.trimToSize();
                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setWorldLocation(
                            BeginX +  (bgLandscape.getbackgroundxResolution() *  -1.5f),
                            BeginY + (bgLandscape.getbackgroundxResolution() * bgLandscape.getHeight() * 1.5f) -
                                 (bgLandscape.getbackgroundyResolution() * 1.8f));

                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).speed = calculatingspeed(rockbigbeegravsecondIndex);


                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapHeight(bitmapHeight);



                    break;


            }
        }
    }



    void rockbigbeegravthirdLevelTwoLava(int rockbigbeegravthirdIndex) {

        char c;

        for (int q = 0; q < rockbigbeegravthirdObject.length(); q++) {
            c = rockbigbeegravthirdObject.charAt(q);

            rockbigbeegravthirdIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravthirdgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravthirdgameObjects.trimToSize();
                    rockbigbeegravthirdgameObjects.get(rockbigbeegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -6.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -6.8f));

                    rockbigbeegravthirdgameObjects.get(rockbigbeegravthirdIndex).speed = calculatingspeed(rockbigbeegravthirdIndex);


                    rockbigbeegravthirdgameObjects.get(rockbigbeegravthirdIndex).setBitmapWidth(bitmapWidth);
                    rockbigbeegravthirdgameObjects.get(rockbigbeegravthirdIndex).setBitmapHeight(bitmapHeight);



                    break;


            }
        }
    }

    void rockbigbeegravfourthLevelTwoLava(int rockbigbeegravfourthIndex) {

        char c;

        for (int f = 0; f < rockbigbeegravfourthObject.length(); f++) {
            c = rockbigbeegravfourthObject.charAt(f);

            rockbigbeegravfourthIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravfourthgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravfourthgameObjects.trimToSize();
                    rockbigbeegravfourthgameObjects.get(rockbigbeegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -6.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.5f) -
                                    (bgLandscape.getbackgroundyResolution() * 0.8f));

                    rockbigbeegravfourthgameObjects.get(rockbigbeegravfourthIndex).speed = calculatingspeed(rockbigbeegravfourthIndex);


                    rockbigbeegravfourthgameObjects.get(rockbigbeegravfourthIndex).setBitmapWidth(bitmapWidth);
                    rockbigbeegravfourthgameObjects.get(rockbigbeegravfourthIndex).setBitmapHeight(bitmapHeight);



                    break;


            }
        }
    }



    void dustrockbeegravlavaLevelTwoLava(int dustrockbeegravlavaIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int y = 0; y < dustrockbeegravlavaObject.length(); y++) {
            c = dustrockbeegravlavaObject.charAt(y);


            dustrockbeegravlavaIndex++;

            switch (c) {
                case 'd':


                    dustrockbeegravlavagameObjects.add(new DustRockBeeGravLava());
                    dustrockbeegravlavagameObjects.trimToSize();
                    dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((dustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2.5f)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight()) -
                                    ((dustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).speed = calculatingspeed(dustrockbeegravlavaIndex);


                    if (y != 0) {
                        dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setBitmapWidth(bitmapWidth);
                        dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).prepareBitmap(dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).prepareBitmap(dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapWidth();
                bitmapHeight = dustrockbeegravlavagameObjects.get(dustrockbeegravlavaIndex).getBitmapHeight();

            }


        }


    }


    void dustrockbeegravlavasecondLevelTwoLava(int dustrockbeegravlavasecondIndex) {
        char c;

        for (int g = 0; g < dustrockbeegravlavasecondObject.length(); g++) {
            c = dustrockbeegravlavasecondObject.charAt(g);


            dustrockbeegravlavasecondIndex++;

            switch (c) {
                case 'd':


                    dustrockbeegravlavasecondgameObjects.add(new DustRockBeeGravLava());
                    dustrockbeegravlavasecondgameObjects.trimToSize();
                    dustrockbeegravlavasecondgameObjects.get(dustrockbeegravlavasecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.2f) -
                                 (bgLandscape.getbackgroundxResolution() * -1.2f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.35f) -
                                 (bgLandscape.getbackgroundyResolution() * 1.8f));

                    dustrockbeegravlavasecondgameObjects.get(dustrockbeegravlavasecondIndex).speed = calculatingspeed(dustrockbeegravlavasecondIndex);


                        dustrockbeegravlavasecondgameObjects.get(dustrockbeegravlavasecondIndex).setBitmapWidth(bitmapWidth);
                        dustrockbeegravlavasecondgameObjects.get(dustrockbeegravlavasecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }
        }
    }

    void dustrockbeegravlavathirdLevelTwoLava(int dustrockbeegravlavathirdIndex) {
        char c;

        for (int h = 0; h < dustrockbeegravlavathirdObject.length(); h++) {
            c = dustrockbeegravlavathirdObject.charAt(h);


            dustrockbeegravlavathirdIndex++;

            switch (c) {
                case 'd':


                    dustrockbeegravlavathirdgameObjects.add(new DustRockBeeGravLava());
                    dustrockbeegravlavathirdgameObjects.trimToSize();
                    dustrockbeegravlavathirdgameObjects.get(dustrockbeegravlavathirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundyResolution() * bgLandscape.getWidth() * 1.2f) -
                                         (bgLandscape.getbackgroundxResolution() * 1.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -1.8f));

                    dustrockbeegravlavathirdgameObjects.get(dustrockbeegravlavathirdIndex).speed = calculatingspeed(dustrockbeegravlavathirdIndex);


                    dustrockbeegravlavathirdgameObjects.get(dustrockbeegravlavathirdIndex).setBitmapWidth(bitmapWidth);
                    dustrockbeegravlavathirdgameObjects.get(dustrockbeegravlavathirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }
        }
    }



    void dustrockbeegravlavafourthLevelTwoLava(int dustrockbeegravlavafourthIndex) {
        char c;

        for (int r = 0; r < dustrockbeegravlavafourthObject.length(); r++) {
            c = dustrockbeegravlavafourthObject.charAt(r);


            dustrockbeegravlavafourthIndex++;

            switch (c) {
                case 'd':


                    dustrockbeegravlavafourthgameObjects.add(new DustRockBeeGravLava());
                    dustrockbeegravlavafourthgameObjects.trimToSize();
                    dustrockbeegravlavafourthgameObjects.get(dustrockbeegravlavafourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.35f) -
                                    (bgLandscape.getbackgroundxResolution() * 2.5f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.35f) -
                                    (bgLandscape.getbackgroundyResolution() * 2.8f));

                    dustrockbeegravlavafourthgameObjects.get(dustrockbeegravlavafourthIndex).speed = calculatingspeed(dustrockbeegravlavafourthIndex);


                    dustrockbeegravlavafourthgameObjects.get(dustrockbeegravlavafourthIndex).setBitmapWidth(bitmapWidth);
                    dustrockbeegravlavafourthgameObjects.get(dustrockbeegravlavafourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }
        }
    }




    void transparentchubLevelTwoLava(int transparentchubIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int q = 0; q < transparentchubObject.length(); q++) {
            c = transparentchubObject.charAt(q);

            transparentchubIndex++;


            switch (c) {
                case 't':


                    transparentchubgameObjects.add(new TransparentChub());
                    transparentchubgameObjects.trimToSize();
                    transparentchubgameObjects.get(transparentchubIndex).setWorldLocation(

                            BeginX + arraylistoftransparentchubposition[(transparentchubIndex + 5) * 2],
                            BeginY + arraylistoftransparentchubposition[((transparentchubIndex + 5) * 2) + 1]);

                    transparentchubgameObjects.get(transparentchubIndex).speed = calculatingspeed(transparentchubIndex);


                    transparentchubgameObjects.get(transparentchubIndex).transparentchubrand = (transparentchubIndex + 5) * 2;


                    if (q != 0) {
                        transparentchubgameObjects.get(transparentchubIndex).setBitmapWidth(bitmapWidth);
                        transparentchubgameObjects.get(transparentchubIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = transparentchubgameObjects.get(transparentchubIndex).prepareBitmap(transparentchubgameObjects.get(transparentchubIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = transparentchubgameObjects.get(transparentchubIndex).prepareBitmap(transparentchubgameObjects.get(transparentchubIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = transparentchubgameObjects.get(transparentchubIndex).getBitmapWidth();
                bitmapHeight = transparentchubgameObjects.get(transparentchubIndex).getBitmapHeight();


            }


        }


    }


    void bigdustrockbeegravlavaLevelTwoLava(int bigdustrockbeegravlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int z = 0; z < bigdustrockbeegravlavaObject.length(); z++) {
            c = bigdustrockbeegravlavaObject.charAt(z);


            bigdustrockbeegravlavaIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavagameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavagameObjects.trimToSize();


                    if (z != 0) {
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapWidth(bitmapWidth);
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapWidth();
                bitmapHeight = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapHeight();

            }


        }


    }



    void ghostspinderbigdustrockbeegravlavaLevelTwoLava(int ghostspinderbigdustrockbeegravlavaIndex) {

        char c;

        for (int z = 0; z < ghostspinderbigdustrockbeegravlavaObject.length(); z++) {
            c = ghostspinderbigdustrockbeegravlavaObject.charAt(z);


            ghostspinderbigdustrockbeegravlavaIndex++;

            switch (c) {
                case 'G':


                    ghostspinderbigdustrockbeegravlavagameObjects.add(new GhostSpinder());
                    ghostspinderbigdustrockbeegravlavagameObjects.trimToSize();
                    ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.1f) -
                                    ((ghostspinderbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 3.5f)),
                            BeginY + ((ghostspinderbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.2f)));


                    ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).satellitecode = 2 ;

                    ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).speed =
                            calculatingghostspinderspeed(ghostspinderbigdustrockbeegravlavaIndex);


                    break;


            }
        }
    }


    void fungilavaLevelTwoLava(int fungilavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int a = 0; a < fungilavaObject.length(); a++) {
            c = fungilavaObject.charAt(a);

            fungilavaIndex++;


            switch (c) {
                case 'F':


                    fungilavagameObjects.add(new FungiLava());
                    fungilavagameObjects.trimToSize();
                    fungilavagameObjects.get(fungilavaIndex).setWorldLocation(
                            BeginX + arraylistoflavabugposition[(fungilavaIndex + 18) * 2],
                            BeginY + arraylistoflavabugposition[((fungilavaIndex + 18) * 2) + 1] + (bgLandscape.getbackgroundyResolution() * 2));

                    fungilavagameObjects.get(fungilavaIndex).fungilavarand = (fungilavaIndex + 18) * 2;


                    fungilavagameObjects.get(fungilavaIndex).speed = calculatingspeed(fungilavaIndex);


                    if (a != 0) {
                        fungilavagameObjects.get(fungilavaIndex).setBitmapWidth(bitmapWidth);
                        fungilavagameObjects.get(fungilavaIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = fungilavagameObjects.get(fungilavaIndex).prepareBitmap(fungilavagameObjects.get(fungilavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = fungilavagameObjects.get(fungilavaIndex).getBitmapWidth();
                bitmapHeight = fungilavagameObjects.get(fungilavaIndex).getBitmapHeight();


            }


        }


    }

    void jumpingratlavaLevelTwoLava(int jumpingratlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int b = 0; b < jumpingratlavaObject.length(); b++) {
            c = jumpingratlavaObject.charAt(b);

            jumpingratlavaIndex++;


            switch (c) {
                case 'J':


                    jumpingratlavagameObjects.add(new JumpingRatLava());
                    jumpingratlavagameObjects.trimToSize();

                    jumpingratlavagameObjects.get(jumpingratlavaIndex).speed = calculatingspeed(jumpingratlavaIndex);



                    if (b != 0) {
                        jumpingratlavagameObjects.get(jumpingratlavaIndex).setBitmapWidth(bitmapWidth);
                        jumpingratlavagameObjects.get(jumpingratlavaIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelTwoLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelTwoLava(c)] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 1] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 2] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelTwoLava(c) + 3] = jumpingratlavagameObjects.get(jumpingratlavaIndex).prepareBitmap(jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapNameJumpLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapWidth();
                bitmapHeight = jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapHeight();


            }

            jumpingratlavagameObjects.get(jumpingratlavaIndex).setWorldLocation(
                    BeginX + arraylistoflavabugposition[(jumpingratlavaIndex + 13) * 2]
                            - (jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapWidth()/2),
                    BeginY + arraylistoflavabugposition[((jumpingratlavaIndex + 13) * 2) + 1]
                            - jumpingratlavagameObjects.get(jumpingratlavaIndex).getBitmapHeight()/2);


            jumpingratlavagameObjects.get(jumpingratlavaIndex).jumpingratlavarand = (jumpingratlavaIndex + 13) * 2;


        }

    }



    void smalllavafishLevelThreeLava(int smalllavafishIndex, int startsmallfish, int finishsmallfish,
                                   FrogFungiPlayerState frogFungiPlayerState) {

        char c;

        for (int s = 0; s < smalllavafishObject.length(); s++) {
            c = smalllavafishObject.charAt(s);

            smalllavafishIndex++;

            switch (c) {
                case 'l':


                    smalllavafishgameObjects.add(new SmallLavaFish());
                    smalllavafishgameObjects.trimToSize();
                    smalllavafishgameObjects.get(smalllavafishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);


                    if(smalllavafishgameObjects.get(smalllavafishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("LEFT");
                    }
                    else {

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("RIGHT");

                    }


                    smalllavafishgameObjects.get(smalllavafishIndex).speed = calculatingspeed(smalllavafishIndex);


                    if (s != 0) {
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapWidth(bitmapWidth);
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapWidth();
                bitmapHeight = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;

        }


    }

    void biglavafishLevelThreeLava(int biglavafishIndex, int startbigfish, int finishbigfish,
                                 FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int t = 0; t < biglavafishObject.length(); t++) {
            c = biglavafishObject.charAt(t);

            biglavafishIndex++;

            switch (c) {
                case 'L':


                    biglavafishgameObjects.add(new BigLavaFish());
                    biglavafishgameObjects.trimToSize();
                    biglavafishgameObjects.get(biglavafishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);


                    if(biglavafishgameObjects.get(biglavafishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("LEFT");
                    }
                    else {

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("RIGHT");

                    }


                    biglavafishgameObjects.get(biglavafishIndex).speed = calculatingspeed(biglavafishIndex);

                    if (t != 0) {
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapWidth(bitmapWidth);
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = biglavafishgameObjects.get(biglavafishIndex).getBitmapWidth();
                bitmapHeight = biglavafishgameObjects.get(biglavafishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;


        }


    }


    void rockbeegravLevelThreeLava(int rockbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int k = 0; k < rockbeegravObject.length(); k++) {
            c = rockbeegravObject.charAt(k);


            rockbeegravIndex++;

            switch (c) {
                case 'b':


                    rockbeegravgameObjects.add(new RockBeeGrav());
                    rockbeegravgameObjects.trimToSize();
                    rockbeegravgameObjects.get(rockbeegravIndex).setWorldLocation(
                            BeginX + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    rockbeegravgameObjects.get(rockbeegravIndex).speed = calculatingspeed(rockbeegravIndex);


                    if (k != 0) {
                        rockbeegravgameObjects.get(rockbeegravIndex).setBitmapWidth(bitmapWidth);
                        rockbeegravgameObjects.get(rockbeegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapWidth();
                bitmapHeight = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapHeight();

            }


        }


    }

    void rockbeegravsecondLevelThreeLava(int rockbeegravsecondIndex){
        char c;

        for (int s = 0; s < rockbeegravsecondObject.length(); s++) {
            c = rockbeegravsecondObject.charAt(s);


            rockbeegravsecondIndex++;

            switch (c) {
                case 'b':


                    rockbeegravsecondgameObjects.add(new RockBeeGrav());
                    rockbeegravsecondgameObjects.trimToSize();
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -1.8f));

                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).speed = calculatingspeed(rockbeegravsecondIndex);


                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravthirdLevelThreeLava(int rockbeegravthirdIndex){
        char c;

        for (int m = 0; m < rockbeegravthirdObject.length(); m++) {
            c = rockbeegravthirdObject.charAt(m);


            rockbeegravthirdIndex++;

            switch (c) {
                case 'b':


                    rockbeegravthirdgameObjects.add(new RockBeeGrav());
                    rockbeegravthirdgameObjects.trimToSize();
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setWorldLocation(
                            BeginX +  (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY +  (bgLandscape.getbackgroundyResolution() * 0.8f));

                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).speed = calculatingspeed(rockbeegravthirdIndex);


                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravfourthLevelThreeLava(int rockbeegravfourthIndex){
        char c;

        for (int m = 0; m < rockbeegravfourthObject.length(); m++) {
            c = rockbeegravfourthObject.charAt(m);


            rockbeegravfourthIndex++;

            switch (c) {
                case 'b':


                    rockbeegravfourthgameObjects.add(new RockBeeGrav());
                    rockbeegravfourthgameObjects.trimToSize();
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY +  (bgLandscape.getbackgroundyResolution() * 0.8f));

                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).speed = calculatingspeed(rockbeegravfourthIndex);


                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }

    
    void rockbigbeegravLevelThreeLava(int rockbigbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int l = 0; l < rockbigbeegravObject.length(); l++) {
            c = rockbigbeegravObject.charAt(l);

            rockbigbeegravIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravgameObjects.trimToSize();
                    rockbigbeegravgameObjects.get(rockbigbeegravIndex).setWorldLocation(
                            BeginX + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.2f)),
                            BeginY + ((rockbigbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 5.2f)));

                    rockbigbeegravgameObjects.get(rockbigbeegravIndex).speed = calculatingspeed(rockbigbeegravIndex);


                    if (l != 0) {

                        rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapWidth(bitmapWidth);
                        rockbigbeegravgameObjects.get(rockbigbeegravIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = rockbigbeegravgameObjects.get(rockbigbeegravIndex).prepareBitmap(rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapWidth();
                bitmapHeight = rockbigbeegravgameObjects.get(rockbigbeegravIndex).getBitmapHeight();


            }


        }

    }

    void rockbigbeegravsecondLevelThreeLava(int rockbigbeegravsecondIndex) {

        char c;

        for (int n = 0; n < rockbigbeegravsecondObject.length(); n++) {
            c = rockbigbeegravsecondObject.charAt(n);

            rockbigbeegravsecondIndex++;

            switch (c) {
                case 'B':


                    rockbigbeegravsecondgameObjects.add(new RockBigBeeGrav());
                    rockbigbeegravsecondgameObjects.trimToSize();
                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setWorldLocation(
                            BeginX +  (bgLandscape.getbackgroundxResolution() *  -1.5f),
                            BeginY + (bgLandscape.getbackgroundxResolution() * bgLandscape.getHeight() * 1.3f) -
                               (bgLandscape.getbackgroundyResolution() * 1.8f));

                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).speed = calculatingspeed(rockbigbeegravsecondIndex);


                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbigbeegravsecondgameObjects.get(rockbigbeegravsecondIndex).setBitmapHeight(bitmapHeight);



                    break;


            }
        }
    }

    
    void bigdustrockbeegravlavaLevelThreeLava(int bigdustrockbeegravlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int z = 0; z < bigdustrockbeegravlavaObject.length(); z++) {
            c = bigdustrockbeegravlavaObject.charAt(z);


            bigdustrockbeegravlavaIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavagameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavagameObjects.trimToSize();


                    if (z != 0) {
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapWidth(bitmapWidth);
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapWidth();
                bitmapHeight = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapHeight();

            }


        }


    }


    void bigdustrockbeegravlavasecondLevelThreeLava(int bigdustrockbeegravlavasecondIndex) {
        char c;

        for (int n = 0; n < bigdustrockbeegravlavasecondObject.length(); n++) {
            c = bigdustrockbeegravlavasecondObject.charAt(n);


            bigdustrockbeegravlavasecondIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavasecondgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavasecondgameObjects.trimToSize();


                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }

        }
    }

    void bigdustrockbeegravlavathirdLevelThreeLava(int bigdustrockbeegravlavathirdIndex){
        char c;

        for (int n = 0; n < bigdustrockbeegravlavathirdObject.length(); n++) {
            c = bigdustrockbeegravlavathirdObject.charAt(n);


            bigdustrockbeegravlavathirdIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavathirdgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavathirdgameObjects.trimToSize();


                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }

        }

    }


    void bigdustrockbeegravlavafourthLevelThreeLava(int bigdustrockbeegravlavafourthIndex){
        char c;

        for (int n = 0; n < bigdustrockbeegravlavafourthObject.length(); n++) {
            c = bigdustrockbeegravlavafourthObject.charAt(n);


            bigdustrockbeegravlavafourthIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavafourthgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavafourthgameObjects.trimToSize();

                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }

        }

    }



    void barkbugLevelThreeLava(int barkbugIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int o = 0; o < barkbugObject.length(); o++) {
            c = barkbugObject.charAt(o);


            barkbugIndex++;

            switch (c) {
                case 'k':


                    barkbuggameObjects.add(new BarkBug());
                    barkbuggameObjects.trimToSize();
                    barkbuggameObjects.get(barkbugIndex).setWorldLocation(
                            BeginX + bgLandscape.fungiArray[arraylistofbarkbugposition[barkbugIndex] * 2],
                            BeginY + bgLandscape.fungiArray[(arraylistofbarkbugposition[barkbugIndex] * 2) + 1]);

                    barkbuggameObjects.get(barkbugIndex).barkbugIndex = barkbugIndex;
                    barkbuggameObjects.get(barkbugIndex).speed = calculatingspeed(barkbugIndex);


                    if (o != 0) {
                        barkbuggameObjects.get(barkbugIndex).setBitmapWidth(bitmapWidth);
                        barkbuggameObjects.get(barkbugIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = barkbuggameObjects.get(barkbugIndex).prepareBitmap(barkbuggameObjects.get(barkbugIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = barkbuggameObjects.get(barkbugIndex).prepareBitmap(barkbuggameObjects.get(barkbugIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 2] = barkbuggameObjects.get(barkbugIndex).prepareBitmap(barkbuggameObjects.get(barkbugIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 3] = barkbuggameObjects.get(barkbugIndex).prepareBitmap(barkbuggameObjects.get(barkbugIndex).getBitmapNameJumpLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());




                bitmapWidth = barkbuggameObjects.get(barkbugIndex).getBitmapWidth();
                bitmapHeight = barkbuggameObjects.get(barkbugIndex).getBitmapHeight();

            }


        }

    }



    void lavafurLevelThreeLava(int lavafurIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int e = 0; e < lavafurObject.length(); e++) {
            c = lavafurObject.charAt(e);

            lavafurIndex++;


            switch (c) {
                case 'a':


                    lavafurgameObjects.add(new LavaFur());
                    lavafurgameObjects.trimToSize();
                    lavafurgameObjects.get(lavafurIndex).setWorldLocation(

                            BeginX + arraylistoflavafurposition[(lavafurIndex + 8) * 2],
                            BeginY + arraylistoflavafurposition[((lavafurIndex + 8) * 2) + 1]);

                    lavafurgameObjects.get(lavafurIndex).lavafurrand = (lavafurIndex + 8) * 2;


                    lavafurgameObjects.get(lavafurIndex).speed = calculatingspeed(lavafurIndex);



                    if (e != 0) {
                        lavafurgameObjects.get(lavafurIndex).setBitmapWidth(bitmapWidth);
                        lavafurgameObjects.get(lavafurIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {

                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 2] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = lavafurgameObjects.get(lavafurIndex).getBitmapWidth();
                bitmapHeight = lavafurgameObjects.get(lavafurIndex).getBitmapHeight();


            }


        }


    }

    void gravitycloudLevelThreeLava(int gravitycloudIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int a = 0; a < gravitycloudObject.length(); a++) {
            c = gravitycloudObject.charAt(a);

            gravitycloudIndex++;


            switch (c) {
                case 'c':


                    gravitycloudgameObjects.add(new GravityCloud());
                    gravitycloudgameObjects.trimToSize();
                    gravitycloudgameObjects.get(gravitycloudIndex).setWorldLocation(
                            BeginX + arraylistoflavabugposition[(gravitycloudIndex + 10) * 2],
                            BeginY + arraylistoflavabugposition[((gravitycloudIndex + 10) * 2) + 1] + (bgLandscape.getbackgroundyResolution() * 2));

                    gravitycloudgameObjects.get(gravitycloudIndex).gravitycloudrand = (gravitycloudIndex + 10) * 2;

                    gravitycloudgameObjects.get(gravitycloudIndex).speed = calculatingspeed(gravitycloudIndex);


                    if (a != 0) {
                        gravitycloudgameObjects.get(gravitycloudIndex).setBitmapWidth(bitmapWidth);
                        gravitycloudgameObjects.get(gravitycloudIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = gravitycloudgameObjects.get(gravitycloudIndex).prepareBitmap(gravitycloudgameObjects.get(gravitycloudIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = gravitycloudgameObjects.get(gravitycloudIndex).prepareBitmap(gravitycloudgameObjects.get(gravitycloudIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = gravitycloudgameObjects.get(gravitycloudIndex).getBitmapWidth();
                bitmapHeight = gravitycloudgameObjects.get(gravitycloudIndex).getBitmapHeight();


            }


        }



    }



    void lavadropLevelThreeLava(int lavadropIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int n = 0; n < lavadropObject.length(); n++) {
            c = lavadropObject.charAt(n);

            lavadropIndex++;


            switch (c) {
                case 'v':


                    lavadropgameObjects.add(new LavaDrop());
                    lavadropgameObjects.trimToSize();

                    lavadropgameObjects.get(lavadropIndex).speed = calculatingspeed(lavadropIndex);


                    if (n != 0) {
                        lavadropgameObjects.get(lavadropIndex).setBitmapWidth(bitmapWidth);
                        lavadropgameObjects.get(lavadropIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelThreeLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelThreeLava(c)] = lavadropgameObjects.get(lavadropIndex).prepareBitmap(lavadropgameObjects.get(lavadropIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 1] = lavadropgameObjects.get(lavadropIndex).prepareBitmap(lavadropgameObjects.get(lavadropIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 2] = lavadropgameObjects.get(lavadropIndex).prepareBitmap(lavadropgameObjects.get(lavadropIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelThreeLava(c) + 3] = lavadropgameObjects.get(lavadropIndex).prepareBitmap(lavadropgameObjects.get(lavadropIndex).getBitmapNameJumpLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = lavadropgameObjects.get(lavadropIndex).getBitmapWidth();
                bitmapHeight = lavadropgameObjects.get(lavadropIndex).getBitmapHeight();


            }

            lavadropgameObjects.get(lavadropIndex).setWorldLocation(
                    BeginX + arraylistoflavadropposition[lavadropIndex * 2] - (lavadropgameObjects.get(lavadropIndex).getBitmapWidth() / 2),
                    BeginY + arraylistoflavadropposition[(lavadropIndex * 2) + 1] - (lavadropgameObjects.get(lavadropIndex).getBitmapHeight() / 2));


        }


    }



  void ghostspinderbigdustrockbeegravlavaLevelThreeLava(int ghostspinderbigdustrockbeegravlavaIndex){

      char c;

      for (int z = 0; z < ghostspinderbigdustrockbeegravlavaObject.length(); z++) {
          c = ghostspinderbigdustrockbeegravlavaObject.charAt(z);


          ghostspinderbigdustrockbeegravlavaIndex++;

          switch (c) {
              case 'G':


                  ghostspinderbigdustrockbeegravlavagameObjects.add(new GhostSpinder());
                  ghostspinderbigdustrockbeegravlavagameObjects.trimToSize();
                  ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).setWorldLocation(
                          BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.15f) -
                                  ((ghostspinderbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                          BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.15f) -
                                  ((ghostspinderbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * 1.2f)));


                  ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).satellitecode = 2 ;

                  ghostspinderbigdustrockbeegravlavagameObjects.get(ghostspinderbigdustrockbeegravlavaIndex).speed =
                          calculatingghostspinderspeed(ghostspinderbigdustrockbeegravlavaIndex);


                  break;


          }
      }
      
  }

  void ghostspindersecondbigdustrockbeegravlavaLevelThreeLava(int ghostspindersecondbigdustrockbeegravlavaIndex){
      char c;

      for (int f = 0; f < ghostspindersecondbigdustrockbeegravlavaObject.length(); f++) {
          c = ghostspindersecondbigdustrockbeegravlavaObject.charAt(f);


          ghostspindersecondbigdustrockbeegravlavaIndex++;

          switch (c) {
              case 'G':


                  ghostspindersecondbigdustrockbeegravlavagameObjects.add(new GhostSpinder());
                  ghostspindersecondbigdustrockbeegravlavagameObjects.trimToSize();
                  ghostspindersecondbigdustrockbeegravlavagameObjects.get(ghostspindersecondbigdustrockbeegravlavaIndex).setWorldLocation(
                          BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.15f) -
                                  ((ghostspindersecondbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 1.2f)),
                          BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.15f) -
                                  ((ghostspindersecondbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * 1.2f)));


                  ghostspindersecondbigdustrockbeegravlavagameObjects.get(ghostspindersecondbigdustrockbeegravlavaIndex).satellitecode = 3;

                  ghostspindersecondbigdustrockbeegravlavagameObjects.get(ghostspindersecondbigdustrockbeegravlavaIndex).speed =
                          calculatingghostspinderspeed(ghostspindersecondbigdustrockbeegravlavaIndex);


                  break;


          }
      }
      
  }

  void ghostspinderthirdbigdustrockbeegravlavaLevelThreeLava(int ghostspinderthirdbigdustrockbeegravlavaIndex){
      char c;

      for (int g = 0; g < ghostspinderthirdbigdustrockbeegravlavaObject.length(); g++) {
          c = ghostspinderthirdbigdustrockbeegravlavaObject.charAt(g);


          ghostspinderthirdbigdustrockbeegravlavaIndex++;

          switch (c) {
              case 'G':


                  ghostspinderthirdbigdustrockbeegravlavagameObjects.add(new GhostSpinder());
                  ghostspinderthirdbigdustrockbeegravlavagameObjects.trimToSize();
                  ghostspinderthirdbigdustrockbeegravlavagameObjects.get(ghostspinderthirdbigdustrockbeegravlavaIndex).setWorldLocation(
                          BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 0.5f) -
                                  ((ghostspinderthirdbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * -0.2f)),
                          BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.15f) -
                                  ((ghostspinderthirdbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.2f)));


                  ghostspinderthirdbigdustrockbeegravlavagameObjects.get(ghostspinderthirdbigdustrockbeegravlavaIndex).satellitecode =
                  ghostspinderthirdbigdustrockbeegravlavaIndex + 1;

                  ghostspinderthirdbigdustrockbeegravlavagameObjects.get(ghostspinderthirdbigdustrockbeegravlavaIndex).speed =
                          calculatingghostspinderspeed(ghostspinderthirdbigdustrockbeegravlavaIndex);


                  break;


          }
      }

  }

  void ghostspinderfourthbigdustrockbeegravlavaLevelThreeLava(int ghostspinderfourthbigdustrockbeegravlavaIndex){
      char c;

      for (int h = 0; h < ghostspinderfourthbigdustrockbeegravlavaObject.length(); h++) {
          c = ghostspinderfourthbigdustrockbeegravlavaObject.charAt(h);


          ghostspinderfourthbigdustrockbeegravlavaIndex++;

          switch (c) {
              case 'G':


                  ghostspinderfourthbigdustrockbeegravlavagameObjects.add(new GhostSpinder());
                  ghostspinderfourthbigdustrockbeegravlavagameObjects.trimToSize();
                  ghostspinderfourthbigdustrockbeegravlavagameObjects.get(ghostspinderfourthbigdustrockbeegravlavaIndex).setWorldLocation(
                          BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                  ((ghostspinderfourthbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                          BeginY + ((ghostspinderfourthbigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * -1.05f)));


                  ghostspinderfourthbigdustrockbeegravlavagameObjects.get(ghostspinderfourthbigdustrockbeegravlavaIndex).satellitecode = 2 ;

                  ghostspinderfourthbigdustrockbeegravlavagameObjects.get(ghostspinderfourthbigdustrockbeegravlavaIndex).speed =
                          calculatingghostspinderspeed(ghostspinderfourthbigdustrockbeegravlavaIndex);


                  break;


          }
      }

  }


        void smalllavafishLevelFourLava(int smalllavafishIndex, int startsmallfish, int finishsmallfish,
                                   FrogFungiPlayerState frogFungiPlayerState) {
        char c;

        for (int s = 0; s < smalllavafishObject.length(); s++) {
            c = smalllavafishObject.charAt(s);

            smalllavafishIndex++;

            switch (c) {
                case 'l':


                    smalllavafishgameObjects.add(new SmallLavaFish());
                    smalllavafishgameObjects.trimToSize();
                    smalllavafishgameObjects.get(smalllavafishIndex).setWorldLocation(
                            BeginX + firstpreyarraystart[startsmallfish],
                            BeginY + firstpreyarraystart[startsmallfish + 1]);


                    if(smalllavafishgameObjects.get(smalllavafishIndex).getWorldLocation().x >
                            (BeginX + firstpreyarrayfinish[finishsmallfish])){

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("LEFT");
                    }
                    else {

                        smalllavafishgameObjects.get(smalllavafishIndex).setFacing("RIGHT");

                    }

                    smalllavafishgameObjects.get(smalllavafishIndex).speed = calculatingspeed(smalllavafishIndex);


                    if (s != 0) {
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapWidth(bitmapWidth);
                        smalllavafishgameObjects.get(smalllavafishIndex).setBitmapHeight(bitmapHeight);
                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = smalllavafishgameObjects.get(smalllavafishIndex).prepareBitmap(smalllavafishgameObjects.get(smalllavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapWidth();
                bitmapHeight = smalllavafishgameObjects.get(smalllavafishIndex).getBitmapHeight();


            }

            startsmallfish = startsmallfish + 2;
            finishsmallfish = finishsmallfish + 2;

        }



    }

    void biglavafishLevelFourLava(int biglavafishIndex, int startbigfish, int finishbigfish,
                                 FrogFungiPlayerState frogFungiPlayerState){


        char c;

        for (int t = 0; t < biglavafishObject.length(); t++) {
            c = biglavafishObject.charAt(t);

            biglavafishIndex++;

            switch (c) {
                case 'L':


                    biglavafishgameObjects.add(new BigLavaFish());
                    biglavafishgameObjects.trimToSize();
                    biglavafishgameObjects.get(biglavafishIndex).setWorldLocation(
                            BeginX + secondpreyarraystart[startbigfish],
                            BeginY + secondpreyarraystart[startbigfish + 1]);


                    if(biglavafishgameObjects.get(biglavafishIndex).getWorldLocation().x >
                            (BeginX + secondpreyarrayfinish[finishbigfish])){

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("LEFT");
                    }
                    else {

                        biglavafishgameObjects.get(biglavafishIndex).setFacing("RIGHT");

                    }

                    biglavafishgameObjects.get(biglavafishIndex).speed = calculatingspeed(biglavafishIndex);


                    if (t != 0) {
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapWidth(bitmapWidth);
                        biglavafishgameObjects.get(biglavafishIndex).setBitmapHeight(bitmapHeight);

                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = biglavafishgameObjects.get(biglavafishIndex).prepareBitmap(biglavafishgameObjects.get(biglavafishIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = biglavafishgameObjects.get(biglavafishIndex).getBitmapWidth();
                bitmapHeight = biglavafishgameObjects.get(biglavafishIndex).getBitmapHeight();


            }

            startbigfish = startbigfish + 2;
            finishbigfish = finishbigfish + 2;


        }



    }


    void rockbeegravLevelFourLava(int rockbeegravIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int k = 0; k < rockbeegravObject.length(); k++) {
            c = rockbeegravObject.charAt(k);


            rockbeegravIndex++;

            switch (c) {
                case 'b':


                    rockbeegravgameObjects.add(new RockBeeGrav());
                    rockbeegravgameObjects.trimToSize();
                    rockbeegravgameObjects.get(rockbeegravIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth()) -
                                    ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.55f) -
                                    ((rockbeegravIndex + 1) * (bgLandscape.getbackgroundyResolution() * 0.8f)));

                    rockbeegravgameObjects.get(rockbeegravIndex).speed = calculatingspeed(rockbeegravIndex);


                    if (k != 0) {
                        rockbeegravgameObjects.get(rockbeegravIndex).setBitmapWidth(bitmapWidth);
                        rockbeegravgameObjects.get(rockbeegravIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = rockbeegravgameObjects.get(rockbeegravIndex).prepareBitmap(rockbeegravgameObjects.get(rockbeegravIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapWidth();
                bitmapHeight = rockbeegravgameObjects.get(rockbeegravIndex).getBitmapHeight();

            }


        }

    }

    void rockbeegravsecondLevelFourLava(int rockbeegravsecondIndex){
        char c;

        for (int s = 0; s < rockbeegravsecondObject.length(); s++) {
            c = rockbeegravsecondObject.charAt(s);


            rockbeegravsecondIndex++;

            switch (c) {
                case 'b':


                    rockbeegravsecondgameObjects.add(new RockBeeGrav());
                    rockbeegravsecondgameObjects.trimToSize();
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.25f) -
                                    (bgLandscape.getbackgroundxResolution() * 1.2f),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.25f) -
                                    (bgLandscape.getbackgroundyResolution() * 1.8f));

                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).speed = calculatingspeed(rockbeegravsecondIndex);


                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravsecondgameObjects.get(rockbeegravsecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravthirdLevelFourLava(int rockbeegravthirdIndex){
        char c;

        for (int m = 0; m < rockbeegravthirdObject.length(); m++) {
            c = rockbeegravthirdObject.charAt(m);


            rockbeegravthirdIndex++;

            switch (c) {
                case 'b':


                    rockbeegravthirdgameObjects.add(new RockBeeGrav());
                    rockbeegravthirdgameObjects.trimToSize();
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * -2.2f),
                            BeginY +  (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.25f) -
                                    (bgLandscape.getbackgroundyResolution() * -0.8f));

                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).speed = calculatingspeed(rockbeegravthirdIndex);


                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravthirdgameObjects.get(rockbeegravthirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }



    void rockbeegravfourthLevelFourLava(int rockbeegravfourthIndex){
        char c;

        for (int m = 0; m < rockbeegravfourthObject.length(); m++) {
            c = rockbeegravfourthObject.charAt(m);


            rockbeegravfourthIndex++;

            switch (c) {
                case 'b':


                    rockbeegravfourthgameObjects.add(new RockBeeGrav());
                    rockbeegravfourthgameObjects.trimToSize();
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.05f) -
                                    (bgLandscape.getbackgroundxResolution() * 2),
                            BeginY + (bgLandscape.getbackgroundyResolution() * -0.8f));

                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).speed = calculatingspeed(rockbeegravfourthIndex);


                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapWidth(bitmapWidth);
                    rockbeegravfourthgameObjects.get(rockbeegravfourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }

    

    void bigdustrockbeegravlavaLevelFourLava(int bigdustrockbeegravlavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int z = 0; z < bigdustrockbeegravlavaObject.length(); z++) {
            c = bigdustrockbeegravlavaObject.charAt(z);


            bigdustrockbeegravlavaIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavagameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavagameObjects.trimToSize();
                    bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setWorldLocation(
                            BeginX + ((bigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2.8f)),
                            BeginY + ((bigdustrockbeegravlavaIndex + 1) * (bgLandscape.getbackgroundyResolution() * -0.8f)));

                    if (z != 0) {
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapWidth(bitmapWidth);
                        bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).setBitmapHeight(bitmapHeight);
                    }

                    bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).speed =
                            calculatingghostspinderspeed(bigdustrockbeegravlavaIndex);

                    bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).satellitecode = 1;



                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).prepareBitmap(bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapWidth();
                bitmapHeight = bigdustrockbeegravlavagameObjects.get(bigdustrockbeegravlavaIndex).getBitmapHeight();

            }


        }

    }

    void dustbulletlavaLevelFourLava(int dustbulletlavaIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int v = 0; v < dustbulletObject.length(); v++) {
            c = dustbulletObject.charAt(v);


            dustbulletlavaIndex++;

            switch (c) {
                case 'u':


                    dustbulletgameObjects.add(new DustBullet());
                    dustbulletgameObjects.trimToSize();

                    dustbulletgameObjects.get(dustbulletlavaIndex).speed = calculatingcirclespeed(dustbulletlavaIndex);


                    if (v != 0) {
                        dustbulletgameObjects.get(dustbulletlavaIndex).setBitmapWidth(bitmapWidth);
                        dustbulletgameObjects.get(dustbulletlavaIndex).setBitmapHeight(bitmapHeight);
                    }


                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = dustbulletgameObjects.get(dustbulletlavaIndex).prepareBitmap(dustbulletgameObjects.get(dustbulletlavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = dustbulletgameObjects.get(dustbulletlavaIndex).prepareBitmap(dustbulletgameObjects.get(dustbulletlavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 2] = dustbulletgameObjects.get(dustbulletlavaIndex).prepareBitmap(dustbulletgameObjects.get(dustbulletlavaIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = dustbulletgameObjects.get(dustbulletlavaIndex).getBitmapWidth();
                bitmapHeight = dustbulletgameObjects.get(dustbulletlavaIndex).getBitmapHeight();

            }


        }


    }


    void bigdustrockbeegravlavasecondLevelFourLava(int bigdustrockbeegravlavasecondIndex) {
        char c;

        for (int f = 0; f < bigdustrockbeegravlavasecondObject.length(); f++) {
            c = bigdustrockbeegravlavasecondObject.charAt(f);


            bigdustrockbeegravlavasecondIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavasecondgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavasecondgameObjects.trimToSize();
                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).setWorldLocation(
                            BeginX + (bgLandscape.getbackgroundxResolution() * bgLandscape.getWidth() * 1.15f) -
                                    ((bigdustrockbeegravlavasecondIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight() * 1.6f) -
                                    ((bigdustrockbeegravlavasecondIndex + 1) * (bgLandscape.getbackgroundyResolution() * 2.2f)));

                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).setBitmapHeight(bitmapHeight);


                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).speed =
                            calculatingghostspinderspeed(bigdustrockbeegravlavasecondIndex);

                    bigdustrockbeegravlavasecondgameObjects.get(bigdustrockbeegravlavasecondIndex).satellitecode = 1;


                    break;


            }


        }

    }


    void dustbulletlavasecondLevelFourLava(int dustbulletlavasecondIndex) {
        char c;

        for (int p = 0; p < dustbulletsecondObject.length(); p++) {
            c = dustbulletsecondObject.charAt(p);


            dustbulletlavasecondIndex++;

            switch (c) {
                case 'u':


                    dustbulletsecondgameObjects.add(new DustBullet());
                    dustbulletsecondgameObjects.trimToSize();

                    dustbulletsecondgameObjects.get(dustbulletlavasecondIndex).speed =
                            calculatingcirclespeed(dustbulletlavasecondIndex);


                    dustbulletsecondgameObjects.get(dustbulletlavasecondIndex).setBitmapWidth(bitmapWidth);
                    dustbulletsecondgameObjects.get(dustbulletlavasecondIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }
    }
    

    void bigdustrockbeegravlavathirdLevelFourLava(int bigdustrockbeegravlavathirdIndex) {
        char c;

        for (int g = 0; g < bigdustrockbeegravlavathirdObject.length(); g++) {
            c = bigdustrockbeegravlavathirdObject.charAt(g);


            bigdustrockbeegravlavathirdIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavathirdgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavathirdgameObjects.trimToSize();
                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).setWorldLocation(
                            BeginX + ((bigdustrockbeegravlavathirdIndex + 1) * (bgLandscape.getbackgroundxResolution())),
                            BeginY + (bgLandscape.getbackgroundyResolution() * bgLandscape.getHeight())  -
                                    ((bigdustrockbeegravlavathirdIndex + 1) * (bgLandscape.getbackgroundyResolution() * -0.2f)));

                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).setBitmapHeight(bitmapHeight);

                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).speed =
                            calculatingghostspinderspeed(bigdustrockbeegravlavathirdIndex);

                    bigdustrockbeegravlavathirdgameObjects.get(bigdustrockbeegravlavathirdIndex).satellitecode = 1;


                    break;


            }


        }
    }

    void dustbulletlavathirdLevelFourLava(int dustbulletlavathirdIndex){
        char c;

        for (int q = 0; q < dustbulletthirdObject.length(); q++) {
            c = dustbulletthirdObject.charAt(q);


            dustbulletlavathirdIndex++;

            switch (c) {
                case 'u':


                    dustbulletthirdgameObjects.add(new DustBullet());
                    dustbulletthirdgameObjects.trimToSize();

                    dustbulletthirdgameObjects.get(dustbulletlavathirdIndex).speed =
                            calculatingcirclespeed(dustbulletlavathirdIndex);


                    dustbulletthirdgameObjects.get(dustbulletlavathirdIndex).setBitmapWidth(bitmapWidth);
                    dustbulletthirdgameObjects.get(dustbulletlavathirdIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }

    }

    void bigdustrockbeegravlavafourthLevelFourLava(int bigdustrockbeegravlavafourthIndex) {
        char c;

        for (int h = 0; h < bigdustrockbeegravlavafourthObject.length(); h++) {
            c = bigdustrockbeegravlavafourthObject.charAt(h);


            bigdustrockbeegravlavafourthIndex++;

            switch (c) {
                case 'D':


                    bigdustrockbeegravlavafourthgameObjects.add(new BigDustRockBeeGravLava());
                    bigdustrockbeegravlavafourthgameObjects.trimToSize();
                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).setWorldLocation(
                            BeginX + ((bigdustrockbeegravlavafourthIndex + 1) * (bgLandscape.getbackgroundxResolution() * 2)),
                            BeginY + ((bigdustrockbeegravlavafourthIndex + 1) * (bgLandscape.getbackgroundyResolution() * -0.5f)));

                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).setBitmapWidth(bitmapWidth);
                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).setBitmapHeight(bitmapHeight);

                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).speed =
                            calculatingghostspinderspeed(bigdustrockbeegravlavafourthIndex);

                    bigdustrockbeegravlavafourthgameObjects.get(bigdustrockbeegravlavafourthIndex).satellitecode = 2;


                    break;


            }


        }
    }

    void dustbulletlavafourthLevelFourLava(int dustbulletlavafourthIndex){
        char c;

        for (int r = 0; r < dustbulletfourthObject.length(); r++) {
            c = dustbulletfourthObject.charAt(r);


            dustbulletlavafourthIndex++;

            switch (c) {
                case 'u':


                    dustbulletfourthgameObjects.add(new DustBullet());
                    dustbulletfourthgameObjects.trimToSize();

                    dustbulletfourthgameObjects.get(dustbulletlavafourthIndex).speed =
                            calculatingcirclespeed(dustbulletlavafourthIndex);


                    dustbulletfourthgameObjects.get(dustbulletlavafourthIndex).setBitmapWidth(bitmapWidth);
                    dustbulletfourthgameObjects.get(dustbulletlavafourthIndex).setBitmapHeight(bitmapHeight);


                    break;


            }


        }

    }


    void redbubblelavaLevelFourLava(int redbubblelavaIndex, FrogFungiPlayerState frogFungiPlayerState){

        char c;

        for (int q = 0; q < redbubbleObject.length(); q++) {
            c = redbubbleObject.charAt(q);


            redbubblelavaIndex++;

            switch (c) {
                case 'e':


                    redbubblegameObjects.add(new RedBubble());
                    redbubblegameObjects.trimToSize();
                    if (q != 0) {
                        redbubblegameObjects.get(redbubblelavaIndex).setBitmapWidth(bitmapWidth);
                        redbubblegameObjects.get(redbubblelavaIndex).setBitmapHeight(bitmapHeight);
                    }

                    redbubblegameObjects.get(redbubblelavaIndex).speed = calculatingspeed(redbubblelavaIndex);

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = redbubblegameObjects.get(redbubblelavaIndex).prepareBitmap(redbubblegameObjects.get(redbubblelavaIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = redbubblegameObjects.get(redbubblelavaIndex).prepareBitmap(redbubblegameObjects.get(redbubblelavaIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 2] = redbubblegameObjects.get(redbubblelavaIndex).prepareBitmap(redbubblegameObjects.get(redbubblelavaIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = redbubblegameObjects.get(redbubblelavaIndex).getBitmapWidth();
                bitmapHeight = redbubblegameObjects.get(redbubblelavaIndex).getBitmapHeight();

            }


            redbubblegameObjects.get(redbubblelavaIndex).setWorldLocation(
                    BeginX + arraylistofredbubbleposition[redbubblelavaIndex * 2] -
                            redbubblegameObjects.get(redbubblelavaIndex).getBitmapWidth()/2,
                    BeginY + arraylistofredbubbleposition[(redbubblelavaIndex * 2) + 1] -
                            redbubblegameObjects.get(redbubblelavaIndex).getBitmapHeight()/2);



        }


    }

    void lavafurLevelFourLava(int lavafurIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int e = 0; e < lavafurObject.length(); e++) {
            c = lavafurObject.charAt(e);

            lavafurIndex++;


            switch (c) {
                case 'a':


                    lavafurgameObjects.add(new LavaFur());
                    lavafurgameObjects.trimToSize();
                    lavafurgameObjects.get(lavafurIndex).setWorldLocation(

                            BeginX + arraylistoflavafurposition[(lavafurIndex + 14) * 2],
                            BeginY + arraylistoflavafurposition[((lavafurIndex + 14) * 2) + 1]);

                    lavafurgameObjects.get(lavafurIndex).lavafurrand = (lavafurIndex + 14) * 2;


                    lavafurgameObjects.get(lavafurIndex).speed = calculatingspeed(lavafurIndex);



                    if (e != 0) {
                        lavafurgameObjects.get(lavafurIndex).setBitmapWidth(bitmapWidth);
                        lavafurgameObjects.get(lavafurIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {

                bitmapsArray[getBitmapIndexLevelFourLava(c) + 2] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameJumpRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c)] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());
                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = lavafurgameObjects.get(lavafurIndex).prepareBitmap(lavafurgameObjects.get(lavafurIndex).getBitmapNameLeft(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = lavafurgameObjects.get(lavafurIndex).getBitmapWidth();
                bitmapHeight = lavafurgameObjects.get(lavafurIndex).getBitmapHeight();


            }


        }


    }

    void gravitycloudLevelFourLava(int gravitycloudIndex, FrogFungiPlayerState frogFungiPlayerState){
        char c;

        for (int a = 0; a < gravitycloudObject.length(); a++) {
            c = gravitycloudObject.charAt(a);

            gravitycloudIndex++;


            switch (c) {
                case 'c':


                    gravitycloudgameObjects.add(new GravityCloud());
                    gravitycloudgameObjects.trimToSize();
                    gravitycloudgameObjects.get(gravitycloudIndex).setWorldLocation(
                            BeginX + arraylistoflavabugposition[(gravitycloudIndex + 15) * 2],
                            BeginY + arraylistoflavabugposition[((gravitycloudIndex + 15) * 2) + 1] + (bgLandscape.getbackgroundyResolution() * 2));

                    gravitycloudgameObjects.get(gravitycloudIndex).gravitycloudrand = (gravitycloudIndex + 15) * 2;

                    gravitycloudgameObjects.get(gravitycloudIndex).speed = calculatingspeed(gravitycloudIndex);


                    if (a != 0) {
                        gravitycloudgameObjects.get(gravitycloudIndex).setBitmapWidth(bitmapWidth);
                        gravitycloudgameObjects.get(gravitycloudIndex).setBitmapHeight(bitmapHeight);


                    }

                    break;


            }


            if (bitmapsArray[getBitmapIndexLevelFourLava(c)] == null) {


                bitmapsArray[getBitmapIndexLevelFourLava(c)] = gravitycloudgameObjects.get(gravitycloudIndex).prepareBitmap(gravitycloudgameObjects.get(gravitycloudIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());

                bitmapsArray[getBitmapIndexLevelFourLava(c) + 1] = gravitycloudgameObjects.get(gravitycloudIndex).prepareBitmap(gravitycloudgameObjects.get(gravitycloudIndex).getBitmapNameRight(), frogFungiPlayerState.getLevel(), frogFungiPlayerState.getWorld());


                bitmapWidth = gravitycloudgameObjects.get(gravitycloudIndex).getBitmapWidth();
                bitmapHeight = gravitycloudgameObjects.get(gravitycloudIndex).getBitmapHeight();


            }


        }



    }





}













