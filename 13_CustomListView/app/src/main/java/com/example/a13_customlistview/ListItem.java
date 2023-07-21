package com.example.a13_customlistview;

import android.graphics.drawable.Drawable;

public class ListItem {
    private Drawable img;
    private String text;

    public ListItem(Drawable img, String text) {
        this.img = img;
        this.text = text;
    }

    public ListItem() {
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "img=" + img +
                ", text='" + text + '\'' +
                '}';
    }
}
