package com.example.a13_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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
    }
}







