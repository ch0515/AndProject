package com.cookandroid.project7_1optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn;
    EditText Ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("황채민[옵션메뉴실습]");
        linear = findViewById(R.id.linear);
        btn = findViewById(R.id.btn);
        Ed = findViewById(R.id.Ed);

    }//onCreate 여기까지

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInf = getMenuInflater();
        mInf.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nP = Integer.parseInt(Ed.getText().toString());
        switch (item.getItemId()){
            case R.id.itemGreen:
                linear.setBackgroundColor(Color.GREEN); break;
            case R.id.itemBlue:
                linear.setBackgroundColor(Color.BLUE); break;
            case R.id.itemWhite:
                linear.setBackgroundColor(Color.WHITE); break;
            case R.id.itemRotation:
                btn.setRotation(nP); break;
            case R.id.itemSizeUp:
                btn.setScaleX(2); btn.setScaleY(2); break;
            case R.id.itemReturn:
                btn.setRotation(0);
                btn.setScaleX(1); btn.setScaleY(1); break;
        }
        return false;
    }
}