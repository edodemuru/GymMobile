package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 12/02/2017.
 */

public class Exercise {
    private String nameEx;
    private int Numserie;
    private int NumRep;
    private double NumPeso;
    private int photoRes;

    public Exercise(String nameEx,int Numserie,int NumRep,double NumPeso,int photoRes){
        super();
        this.nameEx=nameEx;
        this.Numserie=Numserie;
        this.NumRep=NumRep;
        this.NumPeso=NumPeso;
        this.photoRes = photoRes;
    }

    public String getNameEx(){
        return nameEx;
    }

    public int getNumserie(){
        return Numserie;
    }

    public int getNumRep(){
        return NumRep;
    }

    public double getNumPeso(){
        return NumPeso;
    }
    public int getPhotoRes() {
        return photoRes;
    }


}
