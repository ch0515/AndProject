package com.cookandroid.and0803_01_sqlite_test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtGName, edtGNumber;
    TextView txtGNameResult, txtGNumberResult;
    Button btnClear, btnInsert, btnSelect, btnUpdate, btnDelete;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtGName=findViewById(R.id.edtGName);
        edtGNumber=findViewById(R.id.edtGNumber);
        txtGNameResult=findViewById(R.id.txtGNameResult);
        txtGNumberResult=findViewById(R.id.txtGNumberResult);
        btnClear=findViewById(R.id.btnClear);
        btnInsert=findViewById(R.id.btnInsert);
        btnSelect=findViewById(R.id.btnSelect);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        myHelper=new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB=myHelper.getWritableDatabase();
                    String sql="insert into groupTBL(gname, gnumber)";
                    sql+="values('"+edtGName.getText().toString()+"',";
                    sql+=edtGNumber.getText().toString()+");";
                    sqlDB.execSQL(sql);

                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"?????????????????????.",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"????????? ??????????????????.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=myHelper.getWritableDatabase();
                Cursor cursor;
                cursor=sqlDB.rawQuery("select * from groupTBL;", null);

                String strNames="?????????"+"\n"+"___________"+"\n";
                String strNumbers="?????????"+"\n"+"__________"+"\n";
                while(cursor.moveToNext()){
                    strNames+=cursor.getString(0)+"\n";
                    strNumbers+=cursor.getInt(1)+"\n";
                }
                txtGNameResult.setText(strNames);
                txtGNumberResult.setText(strNumbers);
                cursor.close();
                sqlDB.close();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.update, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("?????? ?????? ??????");    dlg.setView(v);
                final EditText edtUpdateGName = v.findViewById(R.id.edtUpdateGName);
                final EditText edtUpdateGNumber = v.findViewById(R.id.edtUpdateGNumber);
                dlg.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtUpdateGName.getText().toString().trim();
                            int number = Integer.parseInt(edtUpdateGNumber.getText().toString().trim());
                            if (!name.isEmpty()) {
                                String sql ="UPDATE groupTBL SET gNumber= "+ number +" WHERE gName = '"+name+"'";
                                sqlDB.execSQL(sql);     sqlDB.close();
                                Toast.makeText(getApplicationContext(),"?????????",Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }else Toast.makeText(getApplicationContext(),"????????? ????????? ???????????? ?????????.",
                                    Toast.LENGTH_SHORT).show();
                        }catch(Exception e) {
                            Toast.makeText(getApplicationContext(), "????????????", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("??????", null);   dlg.show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("?????? ??????");
                dlg.setView(v);
                final EditText edtDeleteGName = v.findViewById(R.id.edtDelGName);
                dlg.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDeleteGName.getText().toString().trim();
                            if(!name.isEmpty()){
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName='"+name+"';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(),name+"?????????",Toast.LENGTH_LONG).show();
                                btnSelect.callOnClick();
                            }else Toast.makeText(getApplicationContext(),"????????? ???????????????.",Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"????????????",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dlg.setNegativeButton("??????",null); dlg.show();
            }
        });
    }
}