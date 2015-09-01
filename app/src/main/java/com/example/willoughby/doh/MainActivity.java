package com.example.willoughby.doh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity extends Activity {
    private WebView mDohWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDohWebView = (WebView)findViewById(R.id.activity_main_doh_webview);
        mDohWebView.getSettings().setJavaScriptEnabled(true);
        mDohWebView.getSettings().setAllowFileAccessFromFileURLs(true);  // Enable HTML Imports to access file://.
        mDohWebView.getSettings().setAllowFileAccess(true);
        mDohWebView.loadUrl("file:///android_asset/dist/index.html");
    }

    @Override
    public void onBackPressed() {
        if (mDohWebView.canGoBack()) {
            mDohWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
