package com.example.leeyou.democustomview2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomLightingColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Context context;

    private int x, y;

    public CustomLightingColorFilterView(Context context) {
        super(context);

        this.context = context;

        initPaint();
        initRes();
    }

    private void initRes() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);

        x = MeasureUtil.getScreenSize((Activity) context)[0] / 2 - mBitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) context)[1] / 2 - mBitmap.getHeight() / 2;
    }

    public CustomLightingColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        initPaint();
        initRes();
    }

    public CustomLightingColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);

        mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, x, y, mPaint);
    }

}
