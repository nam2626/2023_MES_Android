package com.example.a14_customlistview_quest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<String> list;

    public CustomListAdapter() {
        list = new ArrayList<String>();
    }

    public void addItem(String value){
        list.add(value);
    }

    public void clear(){
        list.clear();
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
        //MainActivity가 아니라서 getLayoutInplater를 사용할수 없다.
        final Context context = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_item,viewGroup,false);
        }
        TextView textView = view.findViewById(R.id.item_txt);
        textView.setText(list.get(i));

        return view;
    }
}
