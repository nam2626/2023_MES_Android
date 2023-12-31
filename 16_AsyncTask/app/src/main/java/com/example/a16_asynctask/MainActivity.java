package com.example.a16_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnStart;
    Button btnCancel;
    ProgressTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btn_start);
        btnCancel = findViewById(R.id.btn_cancel);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ProgressThread thread = new ProgressThread();
//                thread.start();
                  task = new ProgressTask();
                  task.execute();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    //태스크 실행에 필요한 데이터 타입, 진행 중에 필요한 데이터 타입, 태스크 결과값 데이터 타입
    public class ProgressTask extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            //백그라운드 작업 전에 실행할 영역, 초기화 영역
            super.onPreExecute();
            progressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            //결과값 받아서 UI 처리하는 부분
            progressBar.setProgress(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            //태스크 종료 신호를 받았을때
            Log.d("AsyncTask", "onCancelled");
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            //작업을 실제 처리하는 부분
            int value = 0;
            while(!isCancelled()){
                value++;
                if(value == 100) break;
                else
                    publishProgress(value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //현재 작업 진행 상태를 UI에 표시 ---> doInBackground에서 publishProgress 호출
            progressBar.setProgress(values[0]);
        }
    }


    public class ProgressThread extends Thread{
        @Override
        public void run() {
            //프로그레스 바를 100까지 자동으로 채우는 코드
            //한번 증가할 떄 5씩 증가
            //증가후 1초동안 쉬었다가 다시 진행 - Thread.sleep(1000);
            while(progressBar.getProgress() < 100) {
                progressBar.incrementProgressBy(5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}







