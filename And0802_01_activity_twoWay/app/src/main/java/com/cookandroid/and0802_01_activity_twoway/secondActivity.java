package com.cookandroid.and0802_01_activity_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondActivity extends AppCompatActivity {
Button btn_set;
int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_set = findViewById(R.id.btn_set);
        Intent in = getIntent();
        int x = in.getIntExtra("Num1",0);
        int y = in.getIntExtra("Num2",0);
        String op = in.getStringExtra("op");
        switch (op){
            case "+": sum = x+y; break;
            case "-": sum = x-y; break;
            case "*": sum = x*y; break;
            case "/": sum = x/y; break;
            default: sum=0;
        }
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), secondActivity.class);
                out.putExtra("sum",sum);
                setResult(RESULT_OK, out);
                finish();
            }
        });
    }
}