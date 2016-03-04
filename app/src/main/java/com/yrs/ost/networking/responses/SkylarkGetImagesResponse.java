package com.yrs.ost.networking.responses;

import com.google.gson.annotations.SerializedName;
import com.yrs.ost.models.Image;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class SkylarkGetImagesResponse {
    @SerializedName("objects")
    private List<Image> imageList;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "SkylarkGetImagesResponse{" +
                "imageList=" + imageList +
                '}';
    }
}
