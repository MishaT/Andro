package com.example.misha.a18browserex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Misha on 07.01.2017.
 */
public class SecondActivity extends AppCompatActivity{
    private WebView secondWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        secondWebView = (WebView)findViewById(R.id.webView);
        secondWebView.getSettings().setJavaScriptEnabled(true);
        secondWebView.loadUrl(getResources().getString(R.string.start_page));
    }
}
