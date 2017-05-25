package com.example.edoardo.gymmobile;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edoardo on 28/02/2017.
 */

public class Esercizio1 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esercizio1);

        ImageView ExImage= (ImageView) findViewById(R.id.imageView);
        ExImage.setImageResource(R.drawable.cyclette3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Scheda");

        TextView musclep= (TextView) findViewById(R.id.musclesprinc);
        TextView muscles= (TextView) findViewById(R.id.musclessecond);
        TextView prep=(TextView) findViewById(R.id.descript);
        TextView exec=(TextView) findViewById(R.id.exec);

        musclep.setText("Quadricipiti");
        muscles.setText("Polpacci");
        prep.setText("Sedersi sulla cyclette, tenersi ai manubri, e selezionare ''Quick Start'' o avvia allenamento");
        exec.setText("Pedalare in avanti come se si fosse su una bicicletta, mentre ci si tiene ai manubri");

}
}
