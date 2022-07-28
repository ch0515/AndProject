package com.cookandroid.and0727_03_gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView img;
RadioGroup group;
RadioButton food1, food2, food3;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        group = findViewById(R.id.group);
        food1 = findViewById(R.id.food1);
        food2 = findViewById(R.id.food2);
        food3 = findViewById(R.id.food3);
        btn = findViewById(R.id.btn);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.food1){
                    img.setImageResource(R.drawable.nougat);
                }else if(i == R.id.food2){
                    img.setImageResource(R.drawable.pie);
                }else if(i == R.id.food3){
                    img.setImageResource(R.drawable.oreo);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.food1: Toast.makeText(getApplicationContext(),food1.getText().toString(),Toast.LENGTH_SHORT).show();break;
                    case R.id.food2: Toast.makeText(getApplicationContext(),food2.getText().toString(),Toast.LENGTH_SHORT).show();break;
                    case R.id.food3: Toast.makeText(getApplicationContext(),food3.getText().toString(),Toast.LENGTH_SHORT).show();break;
                }
            }
        });
    }
}