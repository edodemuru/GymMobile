package com.example.edoardo.gymmobile;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.edoardo.gymmobile.ActivityAllen;
import com.rengwuxian.materialedittext.MaterialEditText;

import com.sdsmdg.tastytoast.TastyToast;
import com.tomer.fadingtextview.FadingTextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.pedant.SweetAlert.SweetAlertDialog;
import es.dmoral.toasty.Toasty;

import static android.R.string.cancel;
import static com.example.edoardo.gymmobile.Global.p;
import static com.example.edoardo.gymmobile.R.id.done;
/*mport static com.example.edoardo.gymmobile.R.id.feedback;*/
import static com.example.edoardo.gymmobile.R.id.imageView;
import static com.example.edoardo.gymmobile.R.id.imgEx;
import static com.example.edoardo.gymmobile.R.id.none;
import static com.example.edoardo.gymmobile.R.id.textView;
import static com.example.edoardo.gymmobile.R.id.toolbar;
import static java.lang.Thread.State.TERMINATED;

/**
 * Created by Ste2016 on 20/03/2017.
 */

public class PlayList extends AppCompatActivity {


    private List<Album> hh = null;
    private long timeCountInMilliSeconds = 1 * 60000;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private ProgressBar progressBarCircle;
    private RelativeLayout low ;
    private EditText editTextMinute;
    private MaterialEditText setWeight ;
    private TextView textViewTime;
    private ImageView imageViewReset;
    private ImageView imageViewStartStop;
    private TextView peso;
    private TextView ripetizioni ;
    private TextView nomeEsercizio;
    private TextView serie ;
    private CountDownTimer countDownTimer;
    private ImageView imgEx ;
    private TastyToast finish;
    private TastyToast provaT;
    private ImageView done ;
    private Toast gg ;
    private ImageView addWeight;
    private boolean stop = false;

    // private Toasty toasty ;
    //final Album t = Global.getP() ;

    final List<Album> prova = Global.getMyList();

    /* utilizzo la lista globale contenente gli esercizi*/

    final Iterator<Album> myIteretor = prova.iterator();
    private Album t ;
    private Album fristElement;
    private static int n = 0 ;
    final Handler handler = new Handler();
    final Handler handler1 = new Handler();
    final Handler handler2 = new Handler();
    final Handler handler3 = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int l = 0 ;

        // Gestisco thread per il timer //
       /* final Handler handler = new Handler();
        final Handler handler1 = new Handler();
        final Handler handler2 = new Handler();*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        initListeners(); /*inizializzo gli elementi dell'interfaccia*/
        setWeight.setVisibility(View.INVISIBLE);
        addWeight.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);






        t = myIteretor.next();
        fristElement=t; // primo elemento della lista

        ripetizioni.setText("Ripetizioni:" + Integer.toString(t.getNumOfSongs()));
        nomeEsercizio.setText(t.getName());
        serie.setText("Serie:" + n + "/" + Integer.toString(t.getserie()));
        peso.setText("Peso: " + t.getpeso());
        imgEx.setImageResource(t.getThumbnail());

        imageViewStartStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int time ;

                if (n>=t.getserie()) {
                    //controllo se le serie sono state tutte effettuate, di conseguenza attendo più tempo for rest//

                    if (t.getserie() == 0) {
                        // tempo da trascorrere per esercizi Cardio
                        time = 30000;

                        startStop(time);
                        setWeight.setVisibility(View.INVISIBLE);
                        addWeight.setVisibility(View.INVISIBLE);


                    } else { // tempo che intercorre tra un esercizio e l'altro

                        time = 60000;

                        startStop(time);
                        // Toasty.success(PlayList.this, "Esercizio completato", Toast.LENGTH_SHORT, true).show();
                    }

                    addWeight.setOnClickListener(new View.OnClickListener() { // Edit text per inserire il peso
                        @Override
                        public void onClick(View v) {
                            //setWeight.setVisibility(View.VISIBLE);
                            //addWeight.setVisibility(View.INVISIBLE);


                            //done.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(),"Peso modificato",Toast.LENGTH_SHORT).show();
                            t.setpeso(Integer.parseInt(setWeight.getText().toString()));

                            setWeight.setText("");






                        }
                    });

                        //Una volta trascorso il tempo di recupero passo all'esercizio successivo
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                imgEx.setVisibility(View.INVISIBLE);
                                low.setVisibility(View.INVISIBLE);
                                setWeight.setVisibility(View.INVISIBLE);
                                addWeight.setVisibility(View.INVISIBLE);
                                done.setVisibility(View.INVISIBLE);// nascondo la v di done

                                

                                if (myIteretor.hasNext()) {
                                    TastyToast.makeText(getApplicationContext(), "Esercizio completato", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                                }
                                    imageViewStartStop.setVisibility(View.VISIBLE);
                                 // prova per vedere se riesco ad imbtogliare i toast
                                    handler2.postDelayed(new Runnable() {
                                        public void run() {
                                            // do something after 3000 ms//

                                            imgEx.setVisibility(View.VISIBLE);
                                            low.setVisibility(View.VISIBLE);
                                            done.setVisibility(View.INVISIBLE);// nascondo la v di done


                                        }
                                    }, 3500);

                                n = 0;
                                //Toasty.success(PlayList.this, "Esercizio completato", Toast.LENGTH_SHORT, true).show();
                                if (myIteretor.hasNext()) {
                                    t = myIteretor.next();
                                    ripetizioni.setText("Ripetizioni:" + Integer.toString(t.getNumOfSongs()));
                                    nomeEsercizio.setText(t.getName());
                                    serie.setText("Serie:" + n + "/" + Integer.toString(t.getserie()));
                                    imgEx.setImageResource(t.getThumbnail());

                                    setWeight.setVisibility(View.VISIBLE);
                                    addWeight.setVisibility(View.VISIBLE);

                                } else {

                                    t = fristElement;
                                    n = 0;

                                    imgEx.setVisibility(View.INVISIBLE);
                                    low.setVisibility(View.INVISIBLE);

                                    new SweetAlertDialog(PlayList.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setTitleText("Fatto")
                                            .setContentText("Allenamento Terminato!")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sDialog) {
                                                    sDialog.dismissWithAnimation();
                                                    //stop=true;

                                                    // torno all'activity precedente//
                                                    PlayList.super.onBackPressed();

                                                }
                                            }).show();
                                    // prova per vedere se riesco ad imbtogliare i toast
                                 /*   handler3.postDelayed(new Runnable() {
                                        public void run() {
                                            // do something after 3000 ms//

                                            // definisco l'intenzione di aprire l'Activity "Page1.java"
                                            Intent openPage1 = new Intent(PlayList.this, ActivityAllen.class);
                                            // passo all'attivazione dell'activity page1.java
                                            startActivity(openPage1);


                                        }
                                    }, 3500);*/


                                    //finish.makeText(getApplicationContext(), "Allenamento Terminato", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                                    }
                                }
                        }, time);


                }else { // Attendo tra una serie e l'altra ( sempre lo stesso eseercizio)

                    startStop(t.getTime()); // avvio il timer

                    addWeight.setOnClickListener(new View.OnClickListener() { // Edit text per inserire il peso
                        @Override
                        public void onClick(View v) {
                            //setWeight.setVisibility(View.INVISIBLE);
                            //addWeight.setVisibility(View.INVISIBLE);
                            //done.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(),"Peso modificato",Toast.LENGTH_SHORT).show();
                            t.setpeso(Integer.parseInt(setWeight.getText().toString()));
                        }
                    });

                    // t = myIteretor.next();
                    if (!stop) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                imageViewStartStop.setVisibility(View.VISIBLE);
                                n = n + 1;
                                serie.setText("Serie:" + n + "/" + Integer.toString(t.getserie()));
                                peso.setText("Peso: " + t.getpeso());
                                done.setVisibility(View.INVISIBLE);// nascondo la v di done

                            }
                        }, t.getTime());
                    }
                }

            }

        });


        initToolBar();


    }

    /**
     * method to initialize the click listeners
     */
    private void initListeners() {


        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        setWeight = (MaterialEditText) findViewById(R.id.MaterialText);
        addWeight=(ImageView) findViewById(R.id.aggiungiPeso);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        imgEx = (ImageView) findViewById(R.id.imgEx) ;
        done = (ImageView) findViewById(R.id.done);
        imageViewReset = (ImageView) findViewById(R.id.imageViewReset);
        imageViewStartStop = (ImageView) findViewById(R.id.imageViewStartStop);
        peso = (TextView) findViewById(R.id.textView7);
        nomeEsercizio=(TextView) findViewById(R.id.nomeEsercizio);
        ripetizioni = (TextView) findViewById(R.id.textView10);
        serie = (TextView) findViewById(R.id.textView11);
        low =  (RelativeLayout) findViewById(R.id.nasc);
        finish = new TastyToast();
        provaT = new TastyToast();
        gg = new Toast(PlayList.this);

        /* inizializzo timer */
        //imageViewReset.setOnClickListener(this);
        //imageViewStartStop.setOnClickListener(this);
    }

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    //@Override
   /* public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewReset:
                reset();
                break;
            case R.id.imageViewStartStop:
                startStop();
                break;
        }



    }
*/
    /**
     * method to reset count down timer
     */
    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();
    }


    /**
     * method to start and stop count down timer
     */
    private void startStop(int time) {
        if (timerStatus == TimerStatus.STOPPED) {

            // call to initialize the timer values
            // Funzione che inizializza il timer con il tempo che trascorrerà
            setTimerValues(time);
            // call to initialize the progress bar values
            setProgressBarValues();
            // showing the reset icon
            /*imageViewReset.setVisibility(View.VISIBLE);
            // changing play icon to stop icon
            imageViewStartStop.setImageResource(R.drawable.icon_stop);*/
            // making edit text not editable
            //editTextMinute.setEnabled(false);
            // changing the timer status to started
            imageViewStartStop.setImageResource(R.drawable.icon_start2);
            timerStatus = TimerStatus.STARTED;
            imageViewStartStop.setVisibility(View.GONE);
            // call to start the count down timer
            startCountDownTimer();
            setWeight.setVisibility(View.VISIBLE);
            addWeight.setVisibility(View.VISIBLE);

        } else {

            // hiding the reset icon
            imageViewReset.setVisibility(View.GONE);
            // changing stop icon to start icon
            imageViewStartStop.setImageResource(R.drawable.icon_start2);
            // making edit text editable
            // editTextMinute.setEnabled(true);
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            stopCountDownTimer();


        }



    }

    /**
     * method to initialize the values for count down timer
     */
    private void setTimerValues(int time) {
        /*int time = 0;
        if (!editTextMinute.getText().toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {
            // toast message to fill edit text
            Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
        }*/
        // assigning values after converting to milliseconds
        // timeCountInMilliSeconds = time * 60 * 1000;
        timeCountInMilliSeconds = time ;
    }

    /**
     * method to start count down timer
     */
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // hiding the reset icon
                imageViewReset.setVisibility(View.GONE);
                // changing stop icon to start icon
                imageViewStartStop.setImageResource(R.drawable.icon_start2);
                // making edit text editable
                //editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
                /*prova per aumentare il numero delle serie*/
                // serie.setText("TIMER");
            }

        }.start();
        countDownTimer.start();
    }

    /**
     * method to stop count down timer
     */
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    /**
     * method to set circular progress bar values
     */
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }




    public void initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar7);

        toolbar.setTitle("Gym");

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.arrow_left);

        toolbar.setNavigationOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        new SweetAlertDialog(PlayList.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Sei sicuro?")
                                .setContentText("No Pain no Gain! Non abbandonare il tuo allenamento")
                                .setConfirmText("Termina")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();
                                        //stop=true;

                                        handler.removeMessages(0);
                                        handler1.removeMessages(0);
                                        handler2.removeMessages(0);


                                        // torno all'activity precedente//
                                        PlayList.super.onBackPressed();







                                    }
                                }).setCancelText("Continua")
                                .showCancelButton(true)
                                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.cancel();
                                    }
                                }).show();

                        // Toast.makeText(PlayList.this, "clicking the toolbar!", Toast.LENGTH_SHORT).show();

                    }

                }
        );

    }




}



    /*Sostituisco l'immagine */









