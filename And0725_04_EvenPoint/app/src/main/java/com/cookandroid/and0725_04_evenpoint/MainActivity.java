package com.cookandroid.and0725_04_evenpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText one_num;
EditText two_num;
Button even_sum;
Button Ca;
TextView sum;
int csum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one_num = findViewById(R.id.one_num);
        two_num = findViewById(R.id.two_num);
        even_sum = findViewById(R.id.even_sum);
        Ca = findViewById(R.id.Ca);
        sum = findViewById(R.id.sum);
        int one = Integer.parseInt(one_num.getText().toString());
        int two = Integer.parseInt(two_num.getText().toString());
        even_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = one; i < two; i++) {
                    if(i%2==0){
                        csum += i;
                    }
                }
            sum.setText(csum+"");
            }
        });
    }
}