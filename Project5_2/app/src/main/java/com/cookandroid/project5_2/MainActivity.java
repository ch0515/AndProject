package com.cookandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    TextView txtResult;
    Button[] btnNums = new Button[10];
    Integer[] btnNumIDs = {R.id.btnNum0,R.id.btnNum1,R.id.btnNum2,R.id.btnNum3,R.id.btnNum4,
            R.id.btnNum5,R.id.btnNum6,R.id.btnNum7,R.id.btnNum8,R.id.btnNum9};
    Button[] btns = new Button[4];
    Integer[] btnIDs = {R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("황채민");
        edtX = findViewById(R.id.edtx);
        edtY = findViewById(R.id.edty);
        txtResult = findViewById(R.id.txtResult);
        ////////////////////////////////////////
        for(int i = 0; i<btnNums.length;i++){
            btnNums[i] = findViewById(btnNumIDs[i]);//0~9버튼 findviewby...
        }
        //////////////////////////////////////////////////////
        for(int i = 0; i<btnNums.length;i++){//0~9버튼 처리작업
            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtX.isFocused()) {
                        String s = edtX.getText().toString() + index;
                        edtX.setText(s);
                    } else if (edtY.isFocused()) {
                        String s = edtY.getText().toString() + index;
                        edtY.setText(s);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            }

        ///////////////////////////////////////////////
        for(int i = 0; i<btns.length;i++){//btnAdd~btnDiv findviewby
            btns[i] = findViewById(btnIDs[i]);
        }
        for(int i = 0; i<btns.length;i++){
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = Integer.parseInt(edtX.getText().toString());
                    int y = Integer.parseInt(edtY.getText().toString());
                    int result=0;
                    switch(view.getId()){
                        case R.id.btnAdd: result = x+y; break;
                        case R.id.btnSub: result = x-y; break;
                        case R.id.btnMul: result = x*y; break;
                        case R.id.btnDiv: result = x/y; break;
                    }
                    txtResult.setText("계산결과:"+result);
                }
            });
        }
    }
}
