package com.example.a15_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spn1 = findViewById(R.id.spn_1);
        TextView result1 = findViewById(R.id.txt_result_1);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                result1.setText(i + " - " + spn1.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        CustomAdapter adapter = new CustomAdapter();
        adapter.addItem(getDrawable(R.drawable.china),"중국");
        adapter.addItem(getDrawable(R.drawable.fance),"프랑스");
        adapter.addItem(getDrawable(R.drawable.united),"미국");
        adapter.addItem(getDrawable(R.drawable.japan),"일본");

        Spinner spn2 = findViewById(R.id.spn_2);
        spn2.setAdapter(adapter);
        TextView result2 = findViewById(R.id.txt_result_2);

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem item = (SpinnerItem) adapter.getItem(i);
                result2.setText(item.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}













