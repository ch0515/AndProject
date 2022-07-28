package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn_1, btn_2, btn_3, view2_btn2, view3_btn2;
LinearLayout view1, view2, view3;
TextView view1_txt;
EditText view2_data, view3_data;
int total = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실습5은행");
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view1_txt = findViewById(R.id.view1_txt);
        view2_data = findViewById(R.id.view2_data);
        view2_btn2 = findViewById(R.id.view2_btn2);
        view3_data = findViewById(R.id.view3_data);
        view3_btn2 = findViewById(R.id.view3_btn2);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                btn_1.setBackgroundColor(Color.parseColor("#FFEB3B"));
                btn_2.setBackgroundColor(Color.parseColor("#C3BFA2"));
                btn_3.setBackgroundColor(Color.parseColor("#C3BFA2"));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.INVISIBLE);
                btn_1.setBackgroundColor(Color.parseColor("#C3BFA2"));
                btn_2.setBackgroundColor(Color.parseColor("#FFEB3B"));
                btn_3.setBackgroundColor(Color.parseColor("#C3BFA2"));
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);
                btn_1.setBackgroundColor(Color.parseColor("#C3BFA2"));
                btn_2.setBackgroundColor(Color.parseColor("#FFEB3B"));
                btn_3.setBackgroundColor(Color.parseColor("#C3BFA2"));
            }
        });
        view2_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(view2_data.getText().toString());
                total += n;
                view1_txt.setText("잔액"+total);
                view2_data.setText("0");
            }
        });
        view3_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(view3_data.getText().toString());
                total -= n;
                view1_txt.setText("잔액"+total);
                view3_data.setText("0");
            }
        });
    }
}