package com.example.leeyou.democustomview2.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.example.leeyou.democustomview2.R;

public class CustomPorterDuffColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public CustomPorterDuffColorFilterView(Context context) {
        super(context);

        initPaint();
        initRes();
    }

    public CustomPorterDuffColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
        initRes();
    }

    public CustomPorterDuffColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initRes() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.color_matrix);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.DARKEN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

}
