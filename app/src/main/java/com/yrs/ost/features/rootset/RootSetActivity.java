package com.yrs.ost.features.rootset;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.yrs.ost.AppEnvironment;
import com.yrs.ost.BuildConfig;
import com.yrs.ost.R;
import com.yrs.ost.models.Image;
import com.yrs.ost.models.Set;
import com.yrs.ost.networking.connectors.SkylarkConnector;
import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RootSetActivity extends Activity {
    AppEnvironment appEnvironment;
    ListView rootSetListView;
    RootSetAdapter rootSetAdapter;
    List<Set> rootSetList;
    List<Image> inMemoryImages;
    SkylarkConnector skylark;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_set);

        rootSetListView = (ListView) findViewById(R.id.listView);
        appEnvironment = (AppEnvironment) getApplication();
        skylark = appEnvironment.getSimpleInjection().getSkylarkConnector();
        inMemoryImages = appEnvironment.getInMemoryImages();

        Call<SkylarkGetRootSetResponse> calRootSet = skylark.getRootSet();

        calRootSet.enqueue(new Callback<SkylarkGetRootSetResponse>() {
            @Override
            public void onResponse(Call<SkylarkGetRootSetResponse> call, Response<SkylarkGetRootSetResponse> response) {

                if(response.isSuccess()) {
                    rootSetList = response.body().getRootSetList();
                    Log.d(BuildConfig.DEV_TAG, rootSetList.get(0) + " ");
                    rootSetAdapter = new RootSetAdapter(
                            RootSetActivity.this,
                            R.layout.root_set_list_item_layout,
                            rootSetList,
                            skylark,
                            inMemoryImages
                        );
                    rootSetListView.setAdapter(rootSetAdapter);


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RootSetActivity.this);
                    switch (response.code()) {

                        case 404:
                            builder.setMessage(getResources().getString(R.string.ERROR_404))
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });
                            break;
                        case 500:
                            builder.setMessage(getResources().getString(R.string.ERROR_500))
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });
                            break;
                        default:
                            builder.setMessage(getResources().getString(R.string.ERROR_UNKNOWN))
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });

                    }
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }

            @Override
            public void onFailure(Call<SkylarkGetRootSetResponse> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RootSetActivity.this);
                builder.setMessage(getResources().getString(R.string.ERROR_UNKNOWN))
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
