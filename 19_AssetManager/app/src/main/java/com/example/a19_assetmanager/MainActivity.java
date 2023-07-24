package com.example.a19_assetmanager;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            InputStream is = manager.open("raw/desert.jpg");

            Bitmap bitmap = BitmapFactory.decodeStream(is);
//            imageView.setImageBitmap(bitmap);
//            Glide.with(this).load(bitmap).into(imageView);
            Glide.with(this).load("https://cdn.pixabay.com/photo/2023/06/23/19/34/campfire-8084064_1280.jpg").into(imageView);

            //txt/한글.txt 내용을 전부 읽어와서 TextView에 출력
            InputStream txtIn = manager.open("txt/한글.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(txtIn));
            String msg = "";
            String txt = "";
            while((txt = br.readLine()) != null){
                msg += txt + "\n";
            }
            textView.setText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}









