package com.prathameshmore.zealmatholympiad;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class TakeTest extends AppCompatActivity {


    private WebView takeTest;
    private ProgressBar progressBar;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Take a test");
        actionBar.setDisplayHomeAsUpEnabled(true);


        takeTest = (WebView) findViewById(R.id.web_view);

        WebSettings webSettings = takeTest.getSettings();
        webSettings.setJavaScriptEnabled(true);
        takeTest.loadUrl("http://114.143.208.199/zmo");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        takeTest.setWebViewClient(new WebViewClient() {

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.bringToFront();
                super.onPageStarted(view, url, favicon);
            }

            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }


        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
