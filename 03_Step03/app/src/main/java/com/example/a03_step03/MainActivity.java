package com.example.a03_step03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edt_id
        EditText edtId = findViewById(R.id.edt_id);
        //edt_passwd
        EditText edtPasswd = findViewById(R.id.edt_passwd);
        //txt_result
        TextView txtResult = findViewById(R.id.txt_result);
        //btn_login -> 로그인 이벤트까지 작성
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뷰에 입력한 내용을 뽑아오는 방법
                String id = edtId.getText().toString();
                String passwd = edtPasswd.getText().toString();
                Log.d("STEP03", id + " / " + passwd);
                txtResult.setText(id + " / " + passwd);
            }
        });



    }
}





