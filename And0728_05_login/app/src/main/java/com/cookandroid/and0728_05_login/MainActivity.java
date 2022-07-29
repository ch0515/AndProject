package com.cookandroid.and0728_05_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtid,edtpw;
Button btn1,btn2;
TextView view_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtid = findViewById(R.id.edtid);
        edtpw = findViewById(R.id.edtpw);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        view_login = findViewById(R.id.view_login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setTitle("로그인 정보");
                String str1 = edtid.getText().toString();
                String str2 = edtpw.getText().toString();
                dlg.setMessage("아이디 : "+str1+"\n비밀번호 : "+str2);
                dlg.setPositiveButton("확인",null);
                dlg.show();
                Toast.makeText(getApplicationContext(),"확인을 눌렀네요",Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu P = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.popup,P.getMenu());
                P.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.set:
                                edtid.setText(null);
                                edtpw.setText(null);
                                return true;
                            case R.id.replay:
                                finish();
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택안됨",Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                P.show();
            }
        });

    }
}