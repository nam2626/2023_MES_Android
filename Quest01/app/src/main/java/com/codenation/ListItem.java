package com.codenation;

public class ListItem {
    private String title;
    private String bloggerName;
    private String postUrl;
    private String postDate;
    private String description;

    public ListItem(String title, String bloggerName, String postUrl, String postDate, String description) {
        this.title = title;
        this.bloggerName = bloggerName;
        this.postUrl = postUrl;
        this.postDate = postDate;
        this.description = description;
    }

    public ListItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "title='" + title + '\'' +
                ", bloggerName='" + bloggerName + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", postDate='" + postDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
