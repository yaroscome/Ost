package com.yrs.ost.features.rootset;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yrs.ost.AppEnvironment;
import com.yrs.ost.BuildConfig;
import com.yrs.ost.R;
import com.yrs.ost.features.episodes.EpisodeActivity;
import com.yrs.ost.models.Image;
import com.yrs.ost.models.Item;
import com.yrs.ost.models.Set;
import com.yrs.ost.networking.connectors.SkylarkConnector;
import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RootSetActivity extends Activity
        implements AdapterView.OnItemClickListener, RootSetContract.View{
    AppEnvironment appEnvironment;
    ListView rootSetListView;
    RootSetAdapter rootSetAdapter;
    SkylarkConnector skylark;
    List<Image> inMemoryImages;


    private RootSetContract.ActionListener actionListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_set);

        rootSetListView = (ListView) findViewById(R.id.listView);
        appEnvironment = (AppEnvironment) getApplication();
        skylark = appEnvironment.getSimpleInjection().getSkylarkConnector();
        inMemoryImages = appEnvironment.getInMemoryImages();

        actionListener = new RootSetPresenter(
                this,
                inMemoryImages,
                skylark
            );

        actionListener.startSetDownloading();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    public void showErrorDialog(String errorMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(errorMessage)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
            });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void populateList(List<Set> rootSetList){
        rootSetAdapter = new RootSetAdapter(
                RootSetActivity.this,
                R.layout.root_set_list_item_layout,
                rootSetList,
                skylark,
                inMemoryImages
        );
        rootSetListView.setAdapter(rootSetAdapter);
        rootSetListView.setOnItemClickListener(RootSetActivity.this);
    }

    public void showEpisodeDetails(String episodePath){
        Intent intent = new Intent(this, EpisodeActivity.class);
        intent.putExtra(AppEnvironment.EPISODE_PATH, episodePath);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        actionListener.getEpisodeDetails(position);
    }
}
