package com.cookandroid.and0801_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
Button btn2;
TextView txtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn2 = findViewById(R.id.btn2);
        txtContent = findViewById(R.id.txtContent);

        Intent in = getIntent();

        String name=in.getStringExtra("name");
        int age = in.getIntExtra("age", 0);
        ArrayList<String> hobby=in.getStringArrayListExtra("hobby");
        txtContent.setText("이름"+name+"\n 나이:"+age+"\n 취미:");
        for(String h:hobby){
            txtContent.setText(txtContent.getText().toString()+h+" ");
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}