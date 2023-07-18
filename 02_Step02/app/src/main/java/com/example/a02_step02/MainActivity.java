package com.example.a02_step02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        Button btnChange = findViewById(R.id.btn_change);
        ImageView imageView1 = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        btnChange.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;
            @Override
            public void onClick(View view) {
                //Toast 메세지 : 이미지 변경 버튼 클릭
                Toast.makeText(MainActivity.this, "이미지 변경 버튼 클릭", Toast.LENGTH_SHORT).show();
                flag = !flag;
                if(flag){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }else{
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}











