package com.yrs.ost.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaros on 03/03/16.
 */
public class Image {
    String uid;
    String url;

    @SerializedName("content_url")
    String contentUrl;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }


}
