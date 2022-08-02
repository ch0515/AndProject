package com.cookandroid.and0802_01_activity_twoway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtnum_1, edtnum_2;
Button btn_sum;
RadioGroup group;
String symbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtnum_1 = findViewById(R.id.edtnum_1);
        edtnum_2 = findViewById(R.id.edtnum_2);
        btn_sum = findViewById(R.id.btn_sum);
        group = findViewById(R.id.group);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), secondActivity.class);
                in.putExtra("Num1", Integer.parseInt(edtnum_1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(edtnum_2.getText().toString()));
                switch (group.getCheckedRadioButtonId()){
                    case R.id.rabtn_1:
                        in.putExtra("op","+"); break;
                    case R.id.rabtn_2:
                        in.putExtra("op","-"); break;
                    case R.id.rabtn_3:
                        in.putExtra("op","*"); break;
                    case R.id.rabtn_4:
                        in.putExtra("op","/"); break;
                }
                startActivityForResult(in,0);//requestCode는 세컨 액티비티 번호
                //세컨엑티비티에 return 값이 있을 때 사용(세컨에서 putExtra()해서 되돌려 받는 경우)
            }
        });
        //메서드로 onActivityResult()함수 구현
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "합계" + sum, Toast.LENGTH_SHORT).show();
        }
    }
}