package com.example.mykhaylot.lionking;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.mykhaylot.lionking.Draw2D;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Display display = getWindowManager().getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);

        //setContentView(R.layout.activity_main);
        Draw2D draw2D = new Draw2D(this);
        draw2D.screenSize = screenSize;

        setContentView(draw2D);
    }
}
