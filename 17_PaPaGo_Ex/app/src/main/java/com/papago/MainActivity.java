package com.papago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtOrigin;
    EditText edtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTranslate = findViewById(R.id.btn_translate);
        edtOrigin = findViewById(R.id.edt_origin);
        edtResult = findViewById(R.id.edt_result);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public class PaPaGo extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //번역된 결과를 JSON으로 파싱 한 후
            //번역된 내용만 edtResult에 출력
        }

        @Override
        protected String doInBackground(Void... voids) {
            //edtOrigin 입력한 내용을 파파고로 번역된 결과를 받아서 리턴
            return null;
        }
    }
}








