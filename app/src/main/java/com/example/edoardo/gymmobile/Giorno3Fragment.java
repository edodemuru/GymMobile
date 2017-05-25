package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 12/02/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Giorno3Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.giorno3, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<Exercise> exerciseList=new ArrayList<Exercise>();
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
                getActivity().getApplicationContext(),
                data,
                R.layout.esercizio,
                from,
                to);

        ((ListView)getView().findViewById(R.id.exerciseListView3)).setAdapter(adapter);

    }
}