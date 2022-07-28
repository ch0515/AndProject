package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup flo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("슬습1[황채민]");
        flo = findViewById(R.id.flo);
        flo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.flo1:
                        Toast.makeText(getApplicationContext(),"장미",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.flo2:
                        Toast.makeText(getApplicationContext(),"팬지",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.flo3:
                        Toast.makeText(getApplicationContext(),"백합",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}