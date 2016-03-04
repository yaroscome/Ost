package com.yrs.ost.features.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yrs.ost.AppEnvironment;
import com.yrs.ost.R;
import com.yrs.ost.commons.SimpleInjection;
import com.yrs.ost.features.rootset.RootSetActivity;
import com.yrs.ost.networking.connectors.SkylarkConnector;
import com.yrs.ost.networking.responses.SkylarkGetImagesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends Activity {
    AppEnvironment appEnvironment;
    SimpleInjection simpleInjection;
    SkylarkConnector skylark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appEnvironment = (AppEnvironment) getApplication();

        simpleInjection = appEnvironment.getSimpleInjection();
        skylark = simpleInjection.getSkylarkConnector();

    }

    @Override
    protected void onStart() {
        super.onStart();

        Call<SkylarkGetImagesResponse> getImagesResponseCall = skylark.getImages();
        getImagesResponseCall.enqueue(new Callback<SkylarkGetImagesResponse>() {
            @Override
            public void onResponse(Call<SkylarkGetImagesResponse> call, Response<SkylarkGetImagesResponse> response) {
                if (response.isSuccess()) {
                    appEnvironment.setInMemoryImages(response.body().getImageList());

                } else {

                }

                continueLoading();

            }

            @Override
            public void onFailure(Call<SkylarkGetImagesResponse> call, Throwable t) {
                continueLoading();
            }
        });


    }

    private void continueLoading() {
        startActivity(new Intent(this, RootSetActivity.class));
        finish();
    }
}
