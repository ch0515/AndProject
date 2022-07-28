package com.cookandroid.and0725_04_1_evenpoint;

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
    TextView sum2;
    int csum = 0;
    int csum2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one_num = findViewById(R.id.one_num);
        two_num = findViewById(R.id.two_num);
        even_sum = findViewById(R.id.even_sum);
        sum2 = findViewById(R.id.sum2);
        Ca = findViewById(R.id.Ca);
        sum = findViewById(R.id.sum);
        even_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int one = Integer.parseInt(one_num.getText().toString());
                int two = Integer.parseInt(two_num.getText().toString());
                for (int i = one; i < two; i++) {
                    if(i%2==0){
                        csum += i;
                    }
                }
                sum.setText("짝수 계산 결과"+csum+"");
            }
        });
        Ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int one = Integer.parseInt(one_num.getText().toString());
                int two = Integer.parseInt(two_num.getText().toString());
                csum2 = two-(two%one);
                sum2.setText("가형 포인트 계산"+csum2+"");
            }
        });
    }
}