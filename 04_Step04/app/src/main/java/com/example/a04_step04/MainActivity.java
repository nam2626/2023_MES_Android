package com.example.a04_step04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnOK;
    Button btnExit;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = findViewById(R.id.btn_ok);
        btnExit = findViewById(R.id.btn_exit);
        txt = findViewById(R.id.txt);

        //버튼 클릭시 입력한 내용을 Toast 메세지로 출력
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, txt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask(); // 종료시 태스크 리스트에 남지 않음
                //finish(); //종료가 되도 태스크 리스트에 남음
            }
        });
        //입력된 텍스트가 변했을때 이벤트 처리
        txt.addTextChangedListener(new TextWatcher() {
            //charSequence : 입력된 내용
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TextEvent", "beforeTextChanged: "+charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TextEvent", "onTextChanged: "+charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TextEvent", "afterTextChanged: "+editable.toString());
            }
        });

    }
}








