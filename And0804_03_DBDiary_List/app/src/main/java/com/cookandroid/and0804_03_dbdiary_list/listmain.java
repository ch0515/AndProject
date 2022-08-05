package com.cookandroid.and0804_03_dbdiary_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listmain extends AppCompatActivity {
ListView list; MyDBHelper myHelper;
Cursor cursor; SQLiteDatabase sqlDB; DiaryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmain);
        list = findViewById(R.id.list);
        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL order by diaryDate desc;",null);
        if (cursor.getCount()>0){
            adapter = new DiaryAdapter(listmain.this, cursor,true);
            list.setAdapter(adapter);
        }else{
            adapter=null;
            list.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),"일기없음",Toast.LENGTH_SHORT).show();
        }
        sqlDB.close();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                Intent in = new Intent(getApplicationContext(),MainActivity2.class);
                in.putExtra("fname",txtName.getText().toString());
                startActivity(in);
                finish();
            }
        });
    }
}