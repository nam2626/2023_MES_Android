package com.example.a13_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lst_view);
        CustomListAdapter adapter = new CustomListAdapter();
        adapter.addItem(new ListItem(getDrawable(R.drawable.facebook),"페이스북"));
        adapter.addItem(new ListItem(getDrawable(R.drawable.instagram),"인스타그램"));

        listView.setAdapter(adapter);

        //아이템 터치 했을때 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListItem item = (ListItem) adapter.getItem(i);
                Toast.makeText(MainActivity.this, item.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}







