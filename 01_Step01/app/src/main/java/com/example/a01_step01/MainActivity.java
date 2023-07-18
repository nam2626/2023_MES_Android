package com.example.a01_step01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTel = findViewById(R.id.btn_tel);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01000000000"));
                startActivity(intent);
            }
        });
    }

    public void onButtonClick(View view){
        Toast.makeText(this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
    }

    public void onNaverButton(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
        startActivity(intent);
    }
}







