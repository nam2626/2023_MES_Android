package com.codenation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ListItem> list;

    public CustomListAdapter() {
        list = new ArrayList<ListItem>();
    }

    public void addItem(String title, String bloggerName, String postUrl, String postDate, String description){
        list.add(new ListItem(title,bloggerName,postUrl,postDate,description));
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
        final Context context = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_item,viewGroup,false);
        }
        TextView txtTitle = view.findViewById(R.id.txt_title);
        TextView txtBloggerName = view.findViewById(R.id.txt_blog_name);
        TextView txtPostDate = view.findViewById(R.id.txt_postdate);
        TextView txtDescription = view.findViewById(R.id.txt_description);

        txtTitle.setText(list.get(i).getTitle());
        txtBloggerName.setText(list.get(i).getBloggerName());
        txtPostDate.setText(list.get(i).getPostDate());
        txtDescription.setText(list.get(i).getDescription());

        return view;
    }
}
