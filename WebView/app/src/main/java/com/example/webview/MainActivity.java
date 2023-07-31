package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView view = findViewById(R.id.web_view);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("http://192.168.5.101:5500/Step08/13_kakaomap_3.html");
    }


}