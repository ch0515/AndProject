package com.cookandroid.and0804_02_dbcuradpidol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn1, btn2, btn3;
    ListView list;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    IdolAdapter iAdepter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("choi idolList");

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        list = findViewById(R.id.list);

        myHelper = new MyDBHelper(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtNumber = view.findViewById(R.id.txtNumber);
                String out = "그룹명 : " + txtName.getText().toString();
                out += "\n인원수 : " + txtNumber.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {            // 디비의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); // 수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2);  // 숫자는 버전의미로 아무거나
                sqlDB.close();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edt1.getText().toString().trim();
                    int num = Integer.parseInt(edt2.getText().toString().trim());

                    if (name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "그룹명을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"', "+num+");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                        edt1.setText("");
                        edt2.setText("");
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                if (cursor.getCount() > 0) {
                    iAdepter = new IdolAdapter(MainActivity.this, cursor, true);
                    list.setAdapter(iAdepter);
                } else { // 초기화 되어 테이블이 없는 경우 adepter 초기화 시킴
                    iAdepter = null;
                    list.setAdapter(iAdepter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        cursor.close();
    }
}
