package com.yrs.ost.commons;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.yrs.ost.BuildConfig;
import com.yrs.ost.networking.connectors.SkylarkConnector;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yaros on 03/03/16.
 */
public class SimpleInjection {
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private HttpLoggingInterceptor getHttpLoggingInterceptor(){
        if(httpLoggingInterceptor == null) {
            httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return httpLoggingInterceptor;
    }


    private OkHttpClient okHttpClient;
    private OkHttpClient getOkHttpClient() {
        if(okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(getHttpLoggingInterceptor())
                    .build();
        }

        return okHttpClient;
    }

    private Gson gson;
    private Gson getGson() {
        if(gson == null) {
            gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                    .create();
        }

        return gson;
    }

    //@Singleton
    private Retrofit retrofit;
    public Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.SKYLARK_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    //@Singleton
    private SkylarkConnector skylarkConnector;
    public SkylarkConnector getSkylarkConnector() {


        if(skylarkConnector == null) {
            skylarkConnector = getRetrofit().create(SkylarkConnector.class);
        }

        return skylarkConnector;
    }

//    private Picasso picasso;
//    public Picasso getPicasso() {
//        if(picasso == null) {
//            Picasso picasso = new Picasso.Builder()
//                    //.downloader(new OkHttpDownloader());
//                    .build();
//        }
//
//        return  picasso;
//
//    }

}
