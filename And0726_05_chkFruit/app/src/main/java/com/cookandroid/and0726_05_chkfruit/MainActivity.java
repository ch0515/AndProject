package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox[]chk=new CheckBox[4];
        Integer [] ch = {R.id.ch1,R.id.ch2,R.id.ch3,R.id.ch4};
        for (int i=0; i<chk.length; i++){
            chk[i]=findViewById(ch[i]);
        }
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<chk.length; i++){
                    if (chk[i].isChecked()==true) {
                        result += chk[i].getText().toString();
                    }
                }
                tv.setText("선택결과:"+result);
            }
        });
        for (int i = 0; i < chk.length; i++) {
            final int k=i;
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btn.performClick();//btn의 Onclick 함수 호출
                }
            });
        }
    }
}