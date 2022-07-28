package com.cookandroid.andproject0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup btnchose;
    RadioButton btn2,btn3;
    Button btnok,btnReset;
    String grade;
    CheckBox check;
    Button btnact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("황채민");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnchose = findViewById(R.id.btnchose);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnok = findViewById(R.id.btnok);
        btnReset = findViewById(R.id.btnReset);
        check = findViewById(R.id.check);
        btnact = findViewById(R.id.btnact);
        check.setChecked(true);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btnact.setEnabled(true);
                else btnact.setEnabled(false);
            }
        });
        btnchose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if(i==0) grade="2학년";
//                else grade="3학년";
                if(radioGroup.getCheckedRadioButtonId()==R.id.btn2)
                    grade=btn2.getText().toString();
                else grade = btn3.getText().toString();
            }
        });
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"선택한 학년 : "+grade,
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnchose.clearCheck();
                Toast.makeText(getApplicationContext(),"선택 취소함",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}