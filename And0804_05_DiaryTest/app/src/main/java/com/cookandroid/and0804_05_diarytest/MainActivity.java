package com.cookandroid.and0804_05_diarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("황채민");

        dp=findViewById(R.id.datePicker1);
        edtDiary=findViewById(R.id.edtDiary);
        btnWrite=findViewById(R.id.btnWrite);
        int cYear= Calendar.getInstance().get(Calendar.YEAR);
        int cMonth= Calendar.getInstance().get(Calendar.MONTH);
        int cDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getWritableDatabase();
        myHelper.onUpgrade(sqlDB,1,2);
        sqlDB.close();

        fileName=Integer.toString(cYear)+"_"+Integer.toString(cMonth+1)+"_"+Integer.toString(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);
    }
}