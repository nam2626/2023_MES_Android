package com.example.a12_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlert = findViewById(R.id.btn_alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMessage("데이터 로드 중입니다.");
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                while(dialog.getProgress() < 100){
                                    try {
                                        Thread.sleep(1000);
                                        dialog.incrementProgressBy(5);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                                dialog.dismiss();
                            }
                        };
                        Thread t = new Thread(r);
                        t.start();
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "예 버튼 클릭", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setButton(ProgressDialog.BUTTON_NEUTRAL, "취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 버튼 클릭", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });
    }
}






