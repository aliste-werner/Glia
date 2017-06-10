package com.projects.thirtyseven.glue;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class AuthActivity extends AppCompatActivity {
    Button skipAuthButton;
    Button toGoogleAnalyticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        changeStatusBarColor();
        getSupportActionBar().hide();
        init();


        skipAuthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AuthActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        toGoogleAnalyticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthActivity.this, AnalyticsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        skipAuthButton = (Button)findViewById(R.id.skipAuthButton);
        toGoogleAnalyticsButton = (Button)findViewById(R.id.buttonToGoogleAnalytics);
    }


    private void changeStatusBarColor() {
        Window window = AuthActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(AuthActivity.this, R.color.greyColor));
    }
}
