package com.yrs.ost.features.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yrs.ost.R;
import com.yrs.ost.features.rootset.RootSetActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        startActivity(new Intent(this, RootSetActivity.class));
        finish();

    }
}
