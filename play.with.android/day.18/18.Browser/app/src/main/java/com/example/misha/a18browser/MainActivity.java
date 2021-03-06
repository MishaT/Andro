package com.example.misha.a18browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    private class localWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            String localHost = new String(getResources().getString(R.string.local_host));
            if (Uri.parse(url).getHost().endsWith(localHost)){
                return  false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }
    }

    @Override
    public void onBackPressed(){
        if (myWebView.canGoBack()){
            myWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.setWebViewClient(new localWebViewClient());

        //turn JavaScript on
        myWebView.getSettings().setJavaScriptEnabled(true);
        //set page to open
        myWebView.loadUrl(getResources().getString(R.string.first_url));
    }
}
