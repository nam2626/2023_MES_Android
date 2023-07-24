package com.codenation;

public class ListItem {
    private String imgUrl;
    private String siteName;
    private String siteUrl;

    public ListItem() {
    }

    public ListItem(String imgUrl, String siteName, String siteUrl) {
        this.imgUrl = imgUrl;
        this.siteName = siteName;
        this.siteUrl = siteUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "imgUrl='" + imgUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                '}';
    }
}
