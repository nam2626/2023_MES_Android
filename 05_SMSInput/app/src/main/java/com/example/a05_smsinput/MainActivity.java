package com.example.a05_smsinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtMessage = findViewById(R.id.edt_message);
        TextView txtLength = findViewById(R.id.txt_length);

        Button btnExit = findViewById(R.id.btn_close);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });

        Button btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, edtMessage.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        
        edtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //80글자까지 입력 되게끔 설정, 매번 80글자까지만 잘라내서 다시 셋팅
                if(charSequence.length()>80) {
                    edtMessage.setText(charSequence.subSequence(0, 80));
                    edtMessage.setSelection(80);
                }
                int count = edtMessage.getText().length();
                txtLength.setText(count + " / 80 글자");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}










