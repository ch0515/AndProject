package com.cookandroid.and0726_01_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[3];
    Integer [] chkText = {R.id.chkAndroid, R.id.chk_iphone, R.id.chkWindow};
    RadioGroup rg;
    RadioButton rbRed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스실습[황채민]");
        rg = findViewById(R.id.rg);
        rbRed = findViewById(R.id.rbRed);
        rbRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Red버튼 클릭",Toast.LENGTH_SHORT).show();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbRed:
                        Toast.makeText(getApplicationContext(),"Red", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbGreen:
                        Toast.makeText(getApplicationContext(),"Green", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBlue:
                        Toast.makeText(getApplicationContext(),"Blue", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        for (int i = 0; i < chkList.length; i++) {
            chkList[i] = findViewById(chkText[i]);
        }
        for (int i = 0; i < chkList.length; i++) {
            final int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(getApplicationContext(), chkList[k].getText().toString()+"선택",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), chkList[k].getText().toString()+"취소",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void onRadioBtnClick(View v) {
        boolean chk = ((RadioButton)v).isChecked();
        if(chk){
            Toast.makeText(getApplicationContext(),((RadioButton)v).getText().toString()+"선택",Toast.LENGTH_SHORT).show();
        }else Toast.makeText(getApplicationContext(),((RadioButton)v).getText().toString()+"취소",Toast.LENGTH_SHORT).show();
    }
}