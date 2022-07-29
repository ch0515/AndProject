package com.cookandroid.and0728_04_contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView edtName, edtTel;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전화번호관리[황채민]");
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        btn = findViewById(R.id.btn);
        registerForContextMenu(btn);
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
        if(item.getItemId() == R.id.TelOk){
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("전화번호 등록");
            dlg.setIcon(R.mipmap.ic_launcher_round);
            final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
            dlg.setView(dlgView);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText edName = dlgView.findViewById(R.id.edtName);
                    EditText edTel = dlgView.findViewById(R.id.edtTel);
                    String str = edtName.getText().toString() + "\n"+edName.getText().toString();
                    String str2 = edtTel.getText().toString() + "\n"+edTel.getText().toString();
                    edtName.setText(str);
                    edtTel.setText(str2);
                }
            });
            dlg.show();
            return true;
        }else{
            switch (item.getItemId()) {
                case R.id.itemBlue:
                    edtName.setTextColor(Color.parseColor("#0004CD"));
                    edtTel.setTextColor(Color.parseColor("#0004CD"));
                    return true;
                case R.id.itemGreen:
                    edtName.setTextColor(Color.parseColor("#4EFD53"));
                    edtTel.setTextColor(Color.parseColor("#4EFD53"));
                    return true;
                case R.id.itemDefault:
                    edtName.setTextColor(Color.parseColor("#000000"));
                    edtTel.setTextColor(Color.parseColor("#000000"));
                    return true;
                default:
                    return false;
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflaterv = getMenuInflater();
        if(v == btn){
            menu.setHeaderTitle("메뉴선택");
            menuInflaterv.inflate(R.menu.centext, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_set:
                edtName.setText(null);
                edtTel.setText(null);
                return true;

            case R.id.context_off:
                finish();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨",Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}