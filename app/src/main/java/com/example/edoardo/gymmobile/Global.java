package com.example.edoardo.gymmobile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ste2016 on 28/03/2017.
 */

public class Global {

    static Album p ;

    public static List <Album> getMyList() {
        List<Album> albumList ;

        albumList = new ArrayList<Album>();

        int[] covers = new int[]{
                R.drawable.cyclette4,
                R.drawable.crunch,
                R.drawable.p_piana,
                R.drawable.concentrazioni,
                R.drawable.tricipiti,
                R.drawable.crunch2,


                /*R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11*/};

        Album a = new Album("Cyclette", 10,0,0, covers[0],30000);
        albumList.add(a);

        a = new Album("Addominali", 2,2,2, covers[1],30000);
        albumList.add(a);

        a = new Album("Panca piana", 3,2,20.5, covers[2],30000);
        albumList.add(a);

        a = new Album("Concentrazioni con manubri", 3,2,10, covers[3],30000);
        albumList.add(a);

        a = new Album("Push Down Ercolina", 3,2,12, covers[4],30000);
        albumList.add(a);

        a = new Album("Abdominal Crunch", 3,2,15, covers[5],30000);
        albumList.add(a);

        return albumList ;
    }

    public static Album getP () {

        return p ;

    }


}
