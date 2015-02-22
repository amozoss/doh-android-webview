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
        mDohWebView.getSettings().setAllowFileAccess(true);
        //mDohWebView.loadUrl("file:///android_assets/html/test.html");
        loadData("doh/javascript/third_party/jquery-1.8.2.js");
        loadData("doh/javascript/third_party/2.5.3-crypto-sha1-hmac-pbkdf2.js");
        loadData("doh/javascript/third_party/2.5.3-crypto-md5.js");
        loadData("doh/javascript/third_party/2.5.3-crypto-sha256.js");
        loadData("doh/javascript/doh.js");
        loadData("doh/javascript/insecure.js");
        loadData("doh/javascript/doh_ui.js");
        loadData("doh/domain_specs.js");
        loadData("doh/html/index.html");
    }

    private void loadData(String url) {
        // can only load one file at a time this way, so it doesn't work
        mDohWebView.loadDataWithBaseURL("file:///android_assets/", getAssetsFile(getBaseContext(), url), "text/html", "utf-8", null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String getAssetsFile(Context context, String s) {
        try {

            String file = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(s)));

            // do reading
            String line = "";
            while(line != null) {
                file+=line;

                line = reader.readLine();
            }

            reader.close();
            return file;

        } catch (Exception e) {
            return "";
        }
    }
}
