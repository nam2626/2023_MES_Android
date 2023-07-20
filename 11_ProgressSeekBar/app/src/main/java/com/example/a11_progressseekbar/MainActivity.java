package com.example.a11_progressseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰 5개 전부 연결
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        SeekBar seekBar = findViewById(R.id.seek_bar);
        TextView txtValue = findViewById(R.id.txt_value);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnReset = findViewById(R.id.btn_reset);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //바뀐값 확인, log를 찍어도 됨, txt_value에 출력해도 됨
                txtValue.setText(String.valueOf(i));
                progressBar.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}










