package com.example.mykhaylot.lionking;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Misha on 25.10.2016.
 */


public class Draw2D extends View {
    public Draw2D(Context context){
        super(context);

        //get image from resources
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.lion_king);

    }

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Point screenSize;



    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int screenWidth = screenSize.x;
        int screenHeight = screenSize.y;

        // style Filling
        mPaint.setStyle(Paint.Style.FILL);

        //fill with color
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        //draw yellow circle
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        int radius = (screenWidth + screenHeight)/30;
        int sunX = screenWidth*7/8;
        int sunY = screenHeight*1/8;
        canvas.drawCircle(sunX, sunY, radius, mPaint);

        //draw green rectangle
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(screenWidth/40, screenHeight*7/10, screenWidth*39/40, screenHeight*75/100, mPaint);

        //draw text
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(42);
        canvas.drawText(getResources().getString(R.string.printing_text), screenWidth/38, screenHeight*695/1000, mPaint);

        //draw angle text
        String str2Rotate = getResources().getString(R.string.rotate_text);
        final int textFontSize = 42;

        final float densityMultiplier = getContext().getResources().getDisplayMetrics().density;
        final float scaledPx = textFontSize * densityMultiplier;
        mPaint.setTextSize(scaledPx);
        final float textLength = mPaint.measureText(str2Rotate)/2;
        final int textHeight = textFontSize/2;

        int x = Math.round(sunX - textLength - radius - 10);
        int y = sunY + textHeight;
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(textFontSize);

        canvas.rotate(-35, sunX, sunY);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2Rotate, x, y, mPaint);

        canvas.restore();
        x = screenWidth - mBitmap.getWidth() - screenWidth/20;
        y = screenHeight*695/1000 - mBitmap.getHeight();

        canvas.drawBitmap(mBitmap, x, y, mPaint);
    }
}
