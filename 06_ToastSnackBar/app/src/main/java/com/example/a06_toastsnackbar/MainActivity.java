package com.example.a06_toastsnackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText xpos = findViewById(R.id.txt_xpos);
        EditText ypos = findViewById(R.id.txt_ypos);
        Button btnToast = findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //레이아웃 인플레이터 객체
                LayoutInflater inflater = getLayoutInflater();
                //레이아웃 객체를 생성
                View layout = inflater.inflate(R.layout.toast,findViewById(R.id.toast_root));
                //레이아웃 객체에 있는 텍스트 뷰를 선택
                TextView textView = layout.findViewById(R.id.txt_toast);
                textView.setText("Toast Message");
                Toast toast = Toast.makeText(MainActivity.this, null, Toast.LENGTH_SHORT);
                int x = Integer.parseInt(xpos.getText().toString());
                int y = Integer.parseInt(ypos.getText().toString());
                toast.setGravity(Gravity.TOP | Gravity.LEFT,x,y);
                toast.setView(layout);
                toast.show();
            }
        });
        Button btnSnack = findViewById(R.id.btn_snack);
        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view,"스낵바 메세지",Snackbar.LENGTH_LONG).show();
                Snackbar snackbar = Snackbar.make(view,"스낵바 메세지", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("닫기", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }

        });
        Button btnAlert = findViewById(R.id.btn_alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("제목");
                builder.setMessage("알림창 내용");
//                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //예 버튼 눌렀을 때 처리할 일
                        Toast.makeText(MainActivity.this, "예 버튼 클릭", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "아니오 버튼 클릭", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 버튼 클릭", Toast.LENGTH_SHORT).show();                        
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}












