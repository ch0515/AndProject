package com.cookandroid.and0725_05_img;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btn_Ch;
Button btn_view;
ImageView img_catdog;
int imgType = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Ch = findViewById(R.id.btn_Ch);
        btn_view = findViewById(R.id.btn_view);
        img_catdog = findViewById(R.id.img_catdog);

        btn_Ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imgType==1){
                    img_catdog.setImageResource(R.drawable.cat); imgType = 2;
                }else{
                    img_catdog.setImageResource(R.drawable.dog); imgType = 1;
                }
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (img_catdog.getVisibility()==View.VISIBLE){
                    img_catdog.setVisibility(View.INVISIBLE); btn_view.setText("보이기");
                }else{
                    img_catdog.setVisibility(View.VISIBLE); btn_view.setText("숨기기");
                }
            }
        });
    }
}