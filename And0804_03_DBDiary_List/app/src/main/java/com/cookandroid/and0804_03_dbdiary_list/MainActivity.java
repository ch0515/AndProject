package com.cookandroid.and0804_03_dbdiary_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cYear = Calendar.getInstance().get(Calendar.YEAR);
                int cMonth = Calendar.getInstance().get(Calendar.MONTH);
                int cDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                String fileName = Integer.toString(cYear)+"_"+Integer.toString(cMonth+1)+"_"+Integer.toString(cDay);
                Intent in=new Intent(getApplicationContext(), MainActivity2.class);
                in.putExtra("fname",fileName);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),listmain.class);
                startActivity(in2);
            }
        });
    }
}