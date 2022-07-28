package com.cookandroid.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnstart, btnStop;
    RadioButton raCal, raTime;
    CalendarView cal;
    TimePicker time;
    TextView txtDate;
    int selYear, selMonth, selDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("황채민");
        chrono = findViewById(R.id.chrono);
        btnstart = findViewById(R.id.btnstart);
        btnStop = findViewById(R.id.btnStop);
        raCal = findViewById(R.id.raCal);
        raTime = findViewById(R.id.raTime);
        cal = findViewById(R.id.cal);
        time = findViewById(R.id.time);
        txtDate = findViewById(R.id.txtDate);

        cal.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        raCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });
        raTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });
    }
}