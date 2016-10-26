package com.example.misha.a16graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Misha on 25.10.2016.
 */

public class Draw2D extends View {
    public Draw2D(Context context){
        super(context);
    }

    private Paint mPaint = new Paint();

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // style Filling
        mPaint.setStyle(Paint.Style.FILL);

        //fill with color
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        //draw yellow cyrcle
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(950, 200, 100, mPaint);

        //draw green rectangle
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(20, 650, 1000, 800, mPaint);
    }
}
