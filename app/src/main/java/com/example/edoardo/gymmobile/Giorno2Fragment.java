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

public class Giorno2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.giorno2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<Exercise> exerciseList=new ArrayList<Exercise>();
        final Exercise [] exercise={
                new Exercise("Tapis Roulant",15,0,0,R.mipmap.tapisroulant),
                new Exercise("Alzate Laterali (con manubri)",3,12,8,R.mipmap.alzatelaterali),
                new Exercise("Piegamenti",3,10,0,R.mipmap.piegamenti),
                new Exercise("Step",5,0,0,R.mipmap.step),
                new Exercise("Squat",3,12,0,R.mipmap.squat),
                new Exercise("Addominali",3,25,0,R.mipmap.addominali)
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

        ((ListView)getView().findViewById(R.id.exerciseListView2)).setAdapter(adapter);

    }
}