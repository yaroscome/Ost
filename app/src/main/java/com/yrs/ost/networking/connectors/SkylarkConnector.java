package com.yrs.ost.networking.connectors;

import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yaros on 03/03/16.
 */
public interface SkylarkConnector {

    @GET("api/sets/")
    Call<SkylarkGetRootSetResponse> getRootSet();

    @GET("")
    void getEpisodeDetails();

}
