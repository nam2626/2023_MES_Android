package com.example.a13_customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ListItem> list;

    public CustomListAdapter() {
        list = new ArrayList<ListItem>();
    }

    public void addItem(ListItem item){
        list.add(item);
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
            view = inflater.inflate(R.layout.custom_list_item,viewGroup,false);
        }

        //화면에 표시될 View로부터 위젯에 대한 참조 획득
        ImageView imageView = view.findViewById(R.id.item_img_view);
        TextView textView = view.findViewById(R.id.item_text);

        //리스트 아이템 하나 읽어와서 위젯에 데이터를 셋팅
        ListItem item = list.get(i);
        imageView.setImageDrawable(item.getImg());
        textView.setText(item.getText());

        return view;
    }
}














