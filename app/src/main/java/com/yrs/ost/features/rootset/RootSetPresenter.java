package com.yrs.ost.features.rootset;

import com.google.gson.annotations.SerializedName;
import com.yrs.ost.models.Set;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class RootSetPresenter {
    @SerializedName("objects")
    List<Set> setList;

    public RootSetPresenter(List<Set> setList) {
        this.setList = setList;
    }

    public List<Set> getSetList() {
        return setList;
    }

    public void setSetList(List<Set> setList) {
        this.setList = setList;
    }

    @Override
    public String toString() {
        return "RootSetPresenter{" +
                "setList=" + setList +
                '}';
    }
}
