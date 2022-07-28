package com.cookandroid.and0726_04_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
EditText Text;
Button btn_1;
Button btn_2;
RadioGroup group;
ImageView img;
int ImgType = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실습2");
        Text = findViewById(R.id.Text);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        group = findViewById(R.id.group);
        img = findViewById(R.id.img);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable tx = Text.getText();
                Toast.makeText(getApplicationContext(),tx,Toast.LENGTH_SHORT).show();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.daum.net"));
                startActivity(urlOpen);
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.rad_1:
                        img.setImageResource(R.drawable.pie);
                        break;
                    case R.id.rad_2:
                        img.setImageResource(R.drawable.oreo);
                }
            }
        });
    }
}