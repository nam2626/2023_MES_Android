package com.example.a06_toastsnackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText xpos = findViewById(R.id.txt_xpos);
        EditText ypos = findViewById(R.id.txt_ypos);
        Button btnToast = findViewById(R.id.btn_toast);
        Button btnAlert = findViewById(R.id.btn_alert);
        Button btnSnack = findViewById(R.id.btn_snack);
    }
}












