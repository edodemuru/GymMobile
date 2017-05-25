package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 11/02/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.example.edoardo.gymmobile.R.id.exerciseListView;


public class ActivityScheda extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheda);



        /*final ArrayList<Exercise> exerciseList=new ArrayList<Exercise>();
        final Exercise [] exercise={
                new Exercise("Cyclette",10,0,0,R.mipmap.cyclette),
                new Exercise("Addominali",2,8,6,R.mipmap.addominali),
                new Exercise("Panca piana",3,12,20.5,R.mipmap.pancapiana),
                new Exercise("Bicipiti",3,12,10,R.mipmap.images),
                new Exercise("Tricipiti",3,12,12,R.mipmap.tricipiti),
                new Exercise("Crunch",3,20,15,R.mipmap.crunc)
        };


        for(int i=0;i<exercise.length;i++){
            exerciseList.add(exercise[i]);
        }

        ArrayList<HashMap<String, Object>> data=new ArrayList<HashMap<String,Object>>();

        for(int i=0; i<exerciseList.size();i++){
            Exercise e=exerciseList.get(i);
            HashMap<String,Object> exerciseMap=new HashMap<String, Object>();
            exerciseMap.put("exercise",e.getNameEx());
            exerciseMap.put("NumSerie",e.getNumserie());
            exerciseMap.put("NumRep",e.getNumRep());
            exerciseMap.put("NumPeso",e.getNumPeso());
            exerciseMap.put("PhotoRes",e.getPhotoRes());
            data.add(exerciseMap);
        }

        String[] from={"exercise","NumSerie","NumRep","NumPeso","PhotoRes"};
        int[] to={R.id.exerciseName,R.id.num1,R.id.num2,R.id.num3,R.id.exerciseImage};

        SimpleAdapter adapter=new SimpleAdapter(
                getApplicationContext(),
                data,
                R.layout.esercizio,
                from,
                to);

        ((ListView)findViewById(R.id.exerciseListView)).setAdapter(adapter);
        };*/
    }
}
