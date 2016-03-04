package com.yrs.ost.models;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class Set {

    private String uid;
    private String title;

    private String self;

    @Nullable
    @SerializedName("image_urls")
    private List<String> imageUrls;


    @Nullable
    @SerializedName("items")
    private List<Item> itemList;

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


    @Nullable
    public List<Item> getItemList() {
        return itemList;
    }

    @Nullable
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
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
        return "Set{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", self='" + self + '\'' +
                ", imageUrls=" + imageUrls +
                ", itemList=" + itemList +
                '}';
    }
}
