package com.yrs.ost;

import android.app.Application;

import com.yrs.ost.commons.SimpleInjection;

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

}
