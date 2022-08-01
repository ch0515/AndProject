package com.cookandroid.and0729_05_quiz_sdmem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Button btnIn, btnStart, btnNext;
EditText edAns, dlgEdName, dlgEdId;
TextView tvNum, tvOX, tvQuiz;
View dlgViewScore, dlgViewInput;
    String[] quiz ={"캐나다의 수도는?","호주의 수도는?","케냐의 수도는?","스페인의 수도는?","독일의 수도는?"};
    String[] ans ={"오타와","캔버라","나이로비","마드리드","베를린"};
    int index=0, //문제번호
            ans_num=0; //맞은 개수

    File myDir;              //생성할 디렉터리 변수
    String strSDPath;       //SD카드 절대주소
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        setTitle("[황채민]수도이름 맞췩 퀴즈");
                btnIn = findViewById(R.id.btnIn);
                btnStart = findViewById(R.id.btnStart);
                btnNext = findViewById(R.id.btnNext);
                edAns = findViewById(R.id.edAns);
                tvNum = findViewById(R.id.tvNum);
                tvOX = findViewById(R.id.tvOX);
                tvQuiz = findViewById(R.id.tvQuiz);
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        strSDPath += "/myQuiz/";
        myDir = new File(strSDPath);
        if (!myDir.isDirectory()) myDir.mkdir();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //문제 풀이 시작
                index=ans_num=0;
                tvNum.setText("문제 - "+(index+1));
                tvQuiz.setText(quiz[index]);
                btnIn.setEnabled(true);
                btnStart.setEnabled(false);
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edAns.getText().toString();
                if (s.equals("")){
                    Toast.makeText(getApplicationContext(), "답을 먼저 적어주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    if (s.equals(ans[index])){
                        ans_num++;
                        tvOX.setText("O : 맞았습니다.");
                    }else tvOX.setText("X : 틀렸습니다.");
                    btnNext.setEnabled(true);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAns.setText("");
                btnNext.setEnabled(false);
                index++;
                if(index < ans.length) {
                    tvOX.setText("OX");
                    tvNum.setText("문제 - "+(index+1));
                    tvQuiz.setText(quiz[index]);
                    edAns.setText("");
                } else {
                    tvOX.setText("OX");
                    tvNum.setText("문제 - Number");
                    tvQuiz.setText("문제");
                    btnIn.setEnabled(false);
                    btnStart.setEnabled(true);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("퀴즈 총 맞은 개수");
                    dlg.setMessage("총 맞은 개수: "+ans_num+"\n점수를 저장하시겠습니까?");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                            dlg2.setTitle("파일 이름 입력: 이름&ID 입력");
                            dlgViewInput = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
                            dlg2.setView(dlgViewInput);
                            dlg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dlgEdName = (EditText)dlgViewInput.findViewById(R.id.edName);
                                    dlgEdId = (EditText)dlgViewInput.findViewById(R.id.edID);
                                    String name = dlgEdName.getText().toString();
                                    String ID = dlgEdId.getText().toString();
                                    String fileName = strSDPath+name+"_"+ID+".txt";
                                    try {
                                        FileOutputStream outFs = new FileOutputStream(fileName);
                                        String str = "총 5문제 중 맞은 개수: "+ans_num;
                                        outFs.write(str.getBytes());
                                        outFs.close();
                                        Toast.makeText(getApplicationContext(),
                                                strSDPath+fileName+"에 점수 저장됨", Toast.LENGTH_SHORT).show();
                                    } catch(Exception e) {

                                    }
                                }
                            });
                            dlg2.setNegativeButton("취소", null);
                            dlg2.show();
                        }
                    });
                    dlg.setNegativeButton("취소", null);
                    dlg.show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AlertDialog.Builder dlg;
        switch (item.getItemId()){
            case R.id.item_exit:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("종료");
                dlg.setMessage("프로그램을 종료합니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
            case R.id.item_start:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("다시 풀기");
                dlg.setMessage("처음 부터 다시 풀어봅시다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        index=ans_num=0;
                        tvNum.setText("문제 - "+(index+1));
                        tvQuiz.setText(quiz[index]);
                        btnIn.setEnabled(true);
                        btnStart.setEnabled(false);
                        btnNext.setEnabled(false);
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
                return true;
            case R.id.item_score:
                dlgViewScore = View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("파일이름 입력 : 이름&ID 입력");
                dlg.setView(dlgViewScore);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgEdName = dlgViewScore.findViewById(R.id.edName);
                        dlgEdId = dlgViewScore.findViewById(R.id.edID);
                        String name = dlgEdName.getText().toString();
                        String id = dlgEdId.getText().toString();
                        String fileName = strSDPath+name+"_"+id+".txt";
                        try {
                            FileInputStream inFs = new FileInputStream(fileName);
                            byte[] txt = new byte[inFs.available()];
                            inFs.read(txt);
                            String score = new String(txt);
                            inFs.close();
                            Toast.makeText(getApplicationContext(), name+"님 점수 확인\n"+score, Toast.LENGTH_SHORT).show();
                        }catch (IOException e){
                            Toast.makeText(getApplicationContext(), "파일이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
                return true;
        }
        return false;
    }
}