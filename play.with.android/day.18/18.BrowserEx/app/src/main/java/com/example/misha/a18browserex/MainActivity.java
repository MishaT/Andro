package com.example.misha.a18browserex;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSecondButtonClick(View v){
//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Intent intent = new Intent("ua.ho.tolkachov.Browser");
        intent.setData(Uri.parse(getResources().getString(R.string.start_page)));
        startActivity(intent);
    }
}
