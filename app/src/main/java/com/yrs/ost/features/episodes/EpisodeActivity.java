package com.yrs.ost.features.episodes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yrs.ost.AppEnvironment;
import com.yrs.ost.BuildConfig;
import com.yrs.ost.R;
import com.yrs.ost.models.Episode;
import com.yrs.ost.networking.connectors.SkylarkConnector;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeActivity extends Activity {
    String episodePath;
    SkylarkConnector skylark;
    TextView episodeTitleTextView;
    TextView episodeSynopsisTextView;
    ImageView episodeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);

        Intent intent = getIntent();
        AppEnvironment appEnvironment = (AppEnvironment) getApplication();
        skylark = appEnvironment.getSimpleInjection().getSkylarkConnector();
        episodePath = intent.getStringExtra(AppEnvironment.EPISODE_PATH);
        episodeTitleTextView = (TextView) findViewById(R.id.episode_title_textView);
        episodeSynopsisTextView = (TextView) findViewById(R.id.episode_synopsis_textView);
        episodeImageView = (ImageView) findViewById(R.id.episode_imageView);

        Call<Episode> getEpisodeCall = skylark.getEpisodeDetails(episodePath);
        getEpisodeCall.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                if(response.isSuccess()){
                    List<String> imageUrls = response.body().getImageUrls();
                    if(imageUrls != null && imageUrls.size() > 0) {
                        updateData(
                                response.body().getTitle(),
                                response.body().getSynopsis(),
                                imageUrls.get(0)
                            );
                    } else {
                        updateData(
                                response.body().getTitle(),
                                response.body().getSynopsis(),
                                null
                        );
                    }


                } else {
                    Log.d(BuildConfig.DEV_TAG, "NOT OK");
                }
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {
                Log.d(BuildConfig.DEV_TAG, "FAIL");
            }
        });

    }

    public void updateData(String title, String synopsis, @Nullable String imageUrl){
        episodeTitleTextView.setText(title);
        episodeSynopsisTextView.setText(synopsis);
        if(imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .centerCrop()
                    .into(episodeImageView);
        }
    }
}
