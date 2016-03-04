package com.yrs.ost.models;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yaros on 04/03/16.
 */
public class Episode {
    private String uid;
    private String title;
    private String synopsis;


    @Nullable
    @SerializedName("image_urls")
    private List<String> imageUrls;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Nullable
    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(@Nullable List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
