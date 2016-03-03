package com.yrs.ost.networking.responses;

import com.google.gson.annotations.SerializedName;
import com.yrs.ost.models.Set;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class SkylarkGetRootSetResponse {

    @SerializedName("objects")
    private List<Set> rootSetList;

    public List<Set> getRootSetList() {
        return rootSetList;
    }

    public void setRootSetList(List<Set> rootSetList) {
        this.rootSetList = rootSetList;
    }
}
