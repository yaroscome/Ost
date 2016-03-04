package com.yrs.ost.networking.connectors;

import com.yrs.ost.models.Episode;
import com.yrs.ost.networking.responses.SkylarkGetEpisodeDetailsResponse;
import com.yrs.ost.networking.responses.SkylarkGetImagesResponse;
import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by yaros on 03/03/16.
 */
public interface SkylarkConnector {

    @GET("api/sets/")
    Call<SkylarkGetRootSetResponse> getRootSet();

    @GET
    Call<Episode> getEpisodeDetails(@Url String url);

    @GET("api/images/")
    Call<SkylarkGetImagesResponse> getImages();

}
