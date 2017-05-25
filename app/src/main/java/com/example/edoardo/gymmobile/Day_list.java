package com.example.edoardo.gymmobile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Edoardo on 16/02/2017.
 */

public class Day_list {
    private HashMap<String,ArrayList<String>> list;
    public Day_list()
    {
        list=new HashMap<String, ArrayList<String>>();
        ArrayList<String> day=new ArrayList<String>();
        list.put("Martedì-Giovedì", day);
        day=new ArrayList<String>();
        list.put("Lunedì-Mercoledì-Venerdì", day);
        day=new ArrayList<String>();
        list.put("Martedì-Giovedì-Sabato", day);
    }
    public Collection<String> getExercise()
    {
        return list.keySet();
    }
    public Collection<String> getCitiesByCountry(String c)
    {
        return list.get(c);
    }
}
