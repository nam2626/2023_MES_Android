package com.example.a19_assetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final String TAG = "AssesManager";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        try {
            AssetManager manager = getResources().getAssets();
            Log.d(TAG, "onCreate: "+ Arrays.toString(manager.list("raw")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}









