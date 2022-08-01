package com.cookandroid.and0801_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btn1;
EditText edt1, edt2;
CheckBox che1, che2, che3;
String name;
int age;
ArrayList<String> hobby = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        che1 = findViewById(R.id.che1);
        che2 = findViewById(R.id.che2);
        che3 = findViewById(R.id.che3);
        che1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(che1.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(che1.getText().toString()));
                }
            }
        });
        che2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(che2.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(che2.getText().toString()));
                }
            }
        });
        che3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(che3.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(che3.getText().toString()));
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt1.getText().toString();
                try {
                    age = Integer.parseInt(edt2.getText().toString());
                }catch (Exception e){}
                Intent in = new Intent(getApplicationContext(),MainActivity2.class);
                in.putExtra("name",name);
                in.putExtra("age",age);
                in.putExtra("hobby",hobby);
                startActivity(in);
            }
        });
    }
}