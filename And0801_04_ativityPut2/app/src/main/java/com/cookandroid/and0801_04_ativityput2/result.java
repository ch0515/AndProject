package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView txtResult;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtResult = findViewById(R.id.txtResult);
        btnReturn = findViewById(R.id.btnReturn);
        Intent in = getIntent();
        Person p = (Person)in.getSerializableExtra("person");
        String str = "이름:"+p.getName()+"\n성별:"+p.getGender()+"\n전화:"+p.getTel()+"\n주소"+p.getAddress();
        txtResult.setText(str);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}