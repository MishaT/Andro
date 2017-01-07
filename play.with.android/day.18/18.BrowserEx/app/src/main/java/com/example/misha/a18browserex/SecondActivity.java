package com.example.misha.a18browserex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.net.Uri;
import android.webkit.WebViewClient;

/**
 * Created by Misha on 07.01.2017.
 */
public class SecondActivity extends AppCompatActivity{
    private WebView secondWebView;

    private class localWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return(true);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        secondWebView = (WebView)findViewById(R.id.webView);
        secondWebView.setWebViewClient(new localWebViewClient());
        secondWebView.getSettings().setJavaScriptEnabled(true);

        Uri url = getIntent().getData();
        secondWebView.loadUrl(url.toString());
    }

}
