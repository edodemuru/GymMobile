package com.example.edoardo.gymmobile;

import java.io.Serializable;

/**
 * Created by Edoardo on 17/02/2017.
 */

public class Album implements Serializable{
    private String name;
    private int numOfSongs;
    private int serie;
    private double peso;
    private int thumbnail;
    private int tempoRecupero ; // Tempo di recupero in ms , es : 60000 equivale a 60 secondi

    public Album() {
    }

    public Album(String name, int numOfSongs, int serie, double peso, int thumbnail, int tempoRecupero) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.serie=serie;
        this.peso=peso;
        this.thumbnail = thumbnail;
        this.tempoRecupero=tempoRecupero ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }//ripetizioni

    public int getserie() {
        return serie;
    }

    public void setserie(int serie) {
        this.serie = serie;
    }

    public double getpeso() {
        return peso;
    }

    public void setpeso(double peso) {
        this.peso = peso;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getTime(){return tempoRecupero ;}

    public void setTime(int tempoMS) {this.tempoRecupero=tempoMS;}
}