package com.cookandroid.and0728_03_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dog:
                img.setImageResource(R.drawable.dog);
                return true;
            case R.id.cat:
                img.setImageResource(R.drawable.cat);
                return true;
            case R.id.fox:
                img.setImageResource(R.drawable.fox2);
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨",Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}