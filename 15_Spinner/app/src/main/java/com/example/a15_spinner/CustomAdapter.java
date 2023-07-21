package com.example.a15_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<SpinnerItem> list;

    public CustomAdapter() {
        list = new ArrayList<SpinnerItem>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_spinner_item,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.img_national);
        TextView textView = view.findViewById(R.id.txt_national);

        SpinnerItem item = list.get(i);
        imageView.setImageDrawable(item.getDrawable());
        textView.setText(item.getText());

        return view;
    }
}
