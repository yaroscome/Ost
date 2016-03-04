package com.yrs.ost.features.rootset;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.yrs.ost.AppEnvironment;
import com.yrs.ost.BuildConfig;
import com.yrs.ost.R;
import com.yrs.ost.features.episodes.EpisodeActivity;
import com.yrs.ost.models.Image;
import com.yrs.ost.models.Item;
import com.yrs.ost.models.Set;
import com.yrs.ost.networking.connectors.SkylarkConnector;
import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yaros on 03/03/16.
 */
public class RootSetPresenter implements RootSetContract.ActionListener {
    private List<Set> rootSetList;



    @NonNull
    private SkylarkConnector skylark;

    Context context;
    RootSetContract.View view;

    public RootSetPresenter(
            @NonNull RootSetContract.View view,
            @NonNull SkylarkConnector skylark) {
        this.view = view;
        this.skylark = skylark;
        context = (Context) view;
    }

    public void startSetDownloading(){
        Call<SkylarkGetRootSetResponse> calRootSet = skylark.getRootSet();

        calRootSet.enqueue(new Callback<SkylarkGetRootSetResponse>() {
            @Override
            public void onResponse(Call<SkylarkGetRootSetResponse> call, Response<SkylarkGetRootSetResponse> response) {

                if(response.isSuccess()) {
                    rootSetList = response.body().getRootSetList();
                    view.populateList(rootSetList);
                    Log.d(BuildConfig.DEV_TAG, rootSetList.get(0) + " ");

                } else {
                    switch (response.code()) {
                        case 404:
                            view.showErrorDialog(context.getString(R.string.ERROR_500));
                            break;
                        case 500:
                            view.showErrorDialog(context.getString(R.string.ERROR_500));
                            break;
                        default:
                            view.showErrorDialog(context.getString(R.string.ERROR_UNKNOWN));
                    }
                }
            }

            @Override
            public void onFailure(Call<SkylarkGetRootSetResponse> call, Throwable t) {
                view.showErrorDialog(context.getString(R.string.ERROR_UNKNOWN));
            }
        });
    }

    @Override
    public void getEpisodeDetails(int position) {
        Set singleSet = rootSetList.get(position);
        List<Item> itemList = singleSet.getItemList();
        if(itemList != null && !itemList.isEmpty()){
            for(Item item: singleSet.getItemList()) {
                if(item.getContentType().equals(AppEnvironment.EPISODE_STRING)){
                    view.showEpisodeDetails(item.getContentUrl());
                    break;
                }
            }
        } else {

        }
    }
}
