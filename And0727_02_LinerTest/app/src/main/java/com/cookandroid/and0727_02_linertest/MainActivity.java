package com.cookandroid.and0727_02_linertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edtX, edtY;
TextView txtResult;
Spinner op;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        txtResult = findViewById(R.id.txtResult);
        op = findViewById(R.id.op);
        btn = findViewById(R.id.btn);
        op.setSelection(2); //기본으로 더하기를 초기화
        txtResult.setTextSize(20);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = op.getSelectedItemPosition();
                Integer x = Integer.parseInt(edtX.getText().toString());
                Integer y = Integer.parseInt(edtY.getText().toString());
                switch (i){
                    case 0: txtResult.setText(""+(x+y)); break;
                    case 1: txtResult.setText(""+(x-y)); break;
                    case 2: txtResult.setText(""+(x*y)); break;
                    case 3: txtResult.setText(""+(x/y)); break;
                }
            }
        });
    }
}