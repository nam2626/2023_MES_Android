package com.codenation;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ListItem> list;

    public CustomListAdapter() {
        list = new ArrayList<ListItem>();
    }

    public void addItem(String imgUrl, String siteName, String siteUrl){
        list.add(new ListItem(imgUrl,siteName,siteUrl));
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
        ImageView imgView = view.findViewById(R.id.thumnail_img);
        TextView txtSiteName = view.findViewById(R.id.txt_site_name);
        TextView txtSiteUrl = view.findViewById(R.id.txt_site_url);
        ListItem item = list.get(i);

        Glide.with(context).load(item.getImgUrl()).into(imgView);
        txtSiteName.setText(item.getSiteName());
        txtSiteUrl.setText(item.getSiteUrl());

        return view;
    }
}
