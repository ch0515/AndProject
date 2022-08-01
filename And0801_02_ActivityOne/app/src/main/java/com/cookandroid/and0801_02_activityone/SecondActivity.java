package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
Button btnmain1;
TextView txtContent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnmain1 = findViewById(R.id.btnmain1);
        txtContent2 = findViewById(R.id.txtContent2);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txtContent2.setText("넘겨 받은 내용:"+str);
        btnmain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}