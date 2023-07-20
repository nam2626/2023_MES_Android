package com.example.a10_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

     ScrollView scrollView;
     ImageView imageView;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scroll_view);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.btn_change);

        scrollView.setHorizontalScrollBarEnabled(true); //수평 스크롤바 설정

        //리소스 이미지 -> 이미지 뷰에 R.drawble.pier
//        imageView.setImageResource(R.drawable.pier);
        Resources res = getResources();
        BitmapDrawable bitmap = (BitmapDrawable) res.getDrawable(R.drawable.pier);
        imageView.setImageDrawable(bitmap);

        //버튼 클릭하면 이미지를 변경 pier <-> nature

    }
}






