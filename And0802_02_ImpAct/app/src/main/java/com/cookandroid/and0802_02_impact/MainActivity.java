package com.cookandroid.and0802_02_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnDial, btnWeb, btnGoogle, btnSearch, btnSms, btnPhoto,btnContact,btnEmail,btnFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDial = findViewById(R.id.btnDal);
        btnWeb = findViewById(R.id.btnWeb);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnSearch = findViewById(R.id.btnSearch);
        btnSms = findViewById(R.id.btnSms);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnContact = findViewById(R.id.btnContact);
        btnEmail = findViewById(R.id.btnEmail);
        btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01029310865");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://maps.google.com/maps?q="+37.559133+","+126.927824);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"안드로이드");
                startActivity(intent);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","안녕하세요?");
                intent.setData(Uri.parse("smsto:"+Uri.encode("010-1234-5678")));
                startActivity(intent);
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://contacts/people/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+"birchTree@naver.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "hello");
                startActivity(intent);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트","onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        android.util.Log.i("액티비티 테스트","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트","onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트","onRestart()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트","onDestroy()");
    }


}