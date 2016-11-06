package com.example.misha.a17animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the link to the Sun
        ImageView sunImageView = (ImageView)findViewById(R.id.sun);

        //animation for the Sunrise
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);

        //connect the animation
        sunImageView.startAnimation(sunRiseAnimation);

    }
}
