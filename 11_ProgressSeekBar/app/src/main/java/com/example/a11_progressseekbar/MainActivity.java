package com.example.a11_progressseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        //ADD 버튼 클릭시 seekbar의 값을 5씩 증가, 동시에 progressbar 도 같이 증가가 되야함
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.incrementProgressBy(5);
            }
        });
        //RESET 버튼 클릭시 seekbar의 값을 0으로 초기화
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setProgress(0);
            }
        });

    }
}










