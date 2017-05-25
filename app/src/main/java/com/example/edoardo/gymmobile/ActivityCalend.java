package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 11/02/2017.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.stacktips.view.CalendarListener;
import com.stacktips.view.CustomCalendarView;
import com.stacktips.view.DayDecorator;
import com.stacktips.view.DayView;
import com.stacktips.view.utils.CalendarUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.widget.AdapterView.OnItemSelectedListener;


public class ActivityCalend extends AppCompatActivity {
    private ArrayAdapter<String> spinnerAdapter;
    CustomCalendarView calendarView;
    Spinner sp;

    RadioButton rb;
    RadioGroup rd;

    public int Hold;
    Date datepress=new Date();


    String[] days = new String[]{
            "Martedì-Giovedì",
            "Lunedì-Mercoledì-Venerdì",
            "Martedì-Giovedì-Sabato"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calend);


        rd=(RadioGroup) findViewById(R.id.days);


        calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);

        //Initialize calendar with date
        final Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        //Show monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        //Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

        //call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Calendario");

    }

    private class ColorDecorator implements DayDecorator {

        @Override
        public void decorate(DayView cell) {
            Calendar cellc=toCalendar(cell.getDate());
            Calendar pressc=toCalendar(datepress);
            if(CalendarUtils.isSameDay(cellc,pressc)){
                int color = Color.parseColor("#a9afb9");
                cell.setBackgroundColor(color);
            }
        }
    }


    private class ColorDecoratorMarGiov implements DayDecorator {
        @Override
        public void decorate(DayView dayView) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.DAY_OF_MONTH,2);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            Calendar dayv= toCalendar(dayView.getDate());
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar.add(calendar.DAY_OF_MONTH,7);

            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(calendar2.DAY_OF_MONTH,7);
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar2)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar2.add(calendar2.DAY_OF_MONTH,7);

            }
        }

    }

    private class ColorDecoratorLunMerVen implements DayDecorator {
        @Override
        public void decorate(DayView dayView) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.DAY_OF_MONTH,1);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            Calendar dayv= toCalendar(dayView.getDate());
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar.add(calendar.DAY_OF_MONTH,7);

            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(calendar2.DAY_OF_MONTH,3);
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar2)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar2.add(calendar2.DAY_OF_MONTH,7);

            }
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(calendar3.DAY_OF_MONTH,6);
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar3)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar3.add(calendar3.DAY_OF_MONTH,7);

            }
        }

    }

    private class ColorDecoratorMarGiovSab implements DayDecorator {
        @Override
        public void decorate(DayView dayView) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.DAY_OF_MONTH,7);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            Calendar dayv= toCalendar(dayView.getDate());
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar.add(calendar.DAY_OF_MONTH,7);

            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(calendar2.DAY_OF_MONTH,2);
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar2)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar2.add(calendar2.DAY_OF_MONTH,7);

            }
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(calendar3.DAY_OF_MONTH,4);
            for(int i = 0; i < daysInMonth; i++){
                if (CalendarUtils.isSameDay(dayv,calendar3)) {
                    int color = Color.parseColor("#00CC00");
                    dayView.setBackgroundColor(color);
                }
                calendar3.add(calendar3.DAY_OF_MONTH,7);

            }
        }

    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        final Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.day1:
                if (checked){
                    List<DayDecorator> decorators = new ArrayList<>();
                    decorators.add(new ColorDecoratorMarGiov());
                    calendarView.setDecorators(decorators);
                    calendarView.refreshCalendar(currentCalendar);

                }
                break;
            case R.id.day2:
                if (checked) {
                    List<DayDecorator> decorators2 = new ArrayList<>();
                    decorators2.add(new ColorDecoratorLunMerVen());
                    calendarView.setDecorators(decorators2);
                    calendarView.refreshCalendar(currentCalendar);

                }
                break;
            case R.id.day3:
                if(checked){
                    List<DayDecorator> decorators3 = new ArrayList<>();
                    decorators3.add(new ColorDecoratorMarGiovSab());
                    calendarView.setDecorators(decorators3);
                    calendarView.refreshCalendar(currentCalendar);
                }
                break;
        }
    }

}