package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAddress;
    RadioGroup rgGender;
    Button btnInput;

    String name, tel, address, gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtAddress = findViewById(R.id.edtAddress);
        rgGender = findViewById(R.id.rgGender);
        btnInput = findViewById(R.id.btnInput);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId()==R.id.rdoMan){
                    gender="남자";
                }else{
                    gender="여자";
                }
            }
        });
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                address = edtAddress.getText().toString();
                //Person p = new Person(name, gender,tel, address);
                Person p = new Person(name, gender, tel, address);
                Intent in = new Intent(getApplicationContext(), result.class);
                in.putExtra("person",p);
                startActivity(in);
            }
        });
    }
}