package com.cookandroid.and0726_02_radioid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn_ok;
RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ok = findViewById(R.id.btn_ok);
        group = findViewById(R.id.group);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.Cosmic:
                        Toast.makeText(getApplicationContext(),"우주소녀",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.BTS:
                        Toast.makeText(getApplicationContext(),"방탄소년단",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Seventeen:
                        Toast.makeText(getApplicationContext(),"세븐틴",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}