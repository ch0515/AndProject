package com.cookandroid.and0727_01_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2;
    Button button1;
    int imageindex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.ImageView2);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeImage();
            }
        });
    }
    private void ChangeImage(){
        if(imageindex == 0){
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageindex = 1;
        }else if(imageindex == 1){
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageindex = 0;
        }
    }
}