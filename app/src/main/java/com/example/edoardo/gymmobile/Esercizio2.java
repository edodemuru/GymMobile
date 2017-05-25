package com.example.edoardo.gymmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edoardo on 01/03/2017.
 */

public class Esercizio2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esercizio2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Scheda");

        ImageView ExImage= (ImageView) findViewById(R.id.imageView);
        ExImage.setImageResource(R.drawable.crunch);

        TextView musclep= (TextView) findViewById(R.id.musclesprinc);
        TextView muscles= (TextView) findViewById(R.id.musclessecond);
        TextView prep=(TextView) findViewById(R.id.descript);
        TextView exec=(TextView) findViewById(R.id.exec);

        musclep.setText("Addominali");
        prep.setText("Sdraiati sulla schiena, con le gambe posizionate come da figura. La schiena deve essere ben poggiata sulla panca, e mettere le mani dietro la testa");
        exec.setText("Sollevare il busto di circa 15-20 cm dalla panca, facendo in modo che la testa, il collo e le spalle siano allineati. Riabassarlo lentamente, e ripetere l'esercizio");

    }
}

