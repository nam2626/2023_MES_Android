package com.example.a16_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnStart;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btn_start);
        btnCancel = findViewById(R.id.btn_cancel);


    }

    public class ProgressThread extends Thread{
        @Override
        public void run() {
            //프로그레스 바를 100까지 자동으로 채우는 코드
            //한번 증가할 떄 5씩 증가
            //증가후 1초동안 쉬었다가 다시 진행 - Thread.sleep(1000);
        }
    }
}







