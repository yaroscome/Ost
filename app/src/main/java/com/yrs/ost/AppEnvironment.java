package com.yrs.ost;

import android.app.Application;

import com.yrs.ost.commons.SimpleInjection;
import com.yrs.ost.models.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class AppEnvironment extends Application {
    private SimpleInjection simpleInjection;
    public SimpleInjection getSimpleInjection() {
        if(simpleInjection == null) {
            simpleInjection = new SimpleInjection();
        }
        return simpleInjection;
    }


    private List<Image> inMemoryImages;
    public List<Image> getInMemoryImages() {
        if (inMemoryImages == null) {
            inMemoryImages = new ArrayList<>();
        }

        return inMemoryImages;
    }

    public void setInMemoryImages(List<Image> inMemoryImages) {
        this.inMemoryImages = inMemoryImages;
    }


}
