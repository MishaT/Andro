package com.example.misha.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
        canvas.drawRect(20, 850, 1000, 900, mPaint);

        //draw text
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(48);
        canvas.drawText(getResources().getString(R.string.printing_text), 20, 840, mPaint);

        //draw angle text
        int x = 550;
        int y = 470;
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(48);
        String str2Rotate = getResources().getString(R.string.rotate_text);

        canvas.rotate(-35, x + mRect.exactCenterX(), y + mRect.exactCenterY());
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2Rotate, x, y, mPaint);

        canvas.restore();

        canvas.drawBitmap(mBitmap, 400, 550, mPaint);
    }
}
