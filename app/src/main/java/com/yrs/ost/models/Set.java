package com.yrs.ost.models;

/**
 * Created by yaros on 03/03/16.
 */
public class Set {

    private String uid;
    private String title;
    private String tempImage;

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

    public String getTempImage() {
        return tempImage;
    }

    public void setTempImage(String tempImage) {
        this.tempImage = tempImage;
    }

    @Override
    public String toString() {
        return "Set{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", tempImage='" + tempImage + '\'' +
                '}';
    }
}
