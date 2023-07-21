package com.example.a14_customlistview_quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter = new CustomListAdapter();

        EditText edtNumber = findViewById(R.id.edt_number);
        Button btnCalc = findViewById(R.id.btn_calc);
        ListView lstResult = findViewById(R.id.lst_result);

        lstResult.setAdapter(adapter);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                int n = Integer.parseInt(edtNumber.getText().toString());
                for(int i=1;i<=n;i++){
                    if(n % i == 0)
                        adapter.addItem(String.valueOf(i));
                }

                adapter.notifyDataSetChanged();//리스트 아이템 최신화
            }
        });
    }
}








