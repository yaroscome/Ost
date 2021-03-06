package com.yrs.ost.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaros on 03/03/16.
 */
public class Item {


    private String uid;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("content_url")
    private String contentUrl;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
