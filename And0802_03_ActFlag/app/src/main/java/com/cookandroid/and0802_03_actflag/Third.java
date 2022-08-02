package com.cookandroid.and0802_03_actflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third extends AppCompatActivity {
Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(getApplicationContext(), Third.class);
//                in.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(in);
                Intent in = new Intent(getApplicationContext(), Third.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }
}