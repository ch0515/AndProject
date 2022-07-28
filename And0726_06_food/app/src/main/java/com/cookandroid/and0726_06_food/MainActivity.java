package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
CheckBox ch_box;
RadioGroup group;
RadioButton ko,ch,bt,ni;
Button set;
ImageView img;
int imgType = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch_box = findViewById(R.id.ch_box);
        group = findViewById(R.id.group);
        ko = findViewById(R.id.ko);
        ch = findViewById(R.id.ch);
        bt = findViewById(R.id.bt);
        ni = findViewById(R.id.ni);
        set = findViewById(R.id.set);
        img = findViewById(R.id.img);
        ch_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (ch_box.isChecked()==true){
                    group.setVisibility(View.VISIBLE);
                    set.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else if(ch_box.isChecked()==false){
                    group.setVisibility(View.INVISIBLE);
                    set.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.ko){
                    img.setImageResource(R.drawable.ko);
                }else if(i == R.id.ch){
                    img.setImageResource(R.drawable.ch);
                }else if(i == R.id.bt){
                    img.setImageResource(R.drawable.bt);
                }else if(i == R.id.ni){
                    img.setImageResource(R.drawable.ni);
                }
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_box.setChecked(false);
                group.clearCheck();
                img.setImageDrawable(null);
            }
        });
    }
}