package com.example.leeyou.democustomview2.customView;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.example.leeyou.democustomview2.util.MeasureUtil;
import com.example.leeyou.democustomview2.engine.PorterDuffBO;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PorterDuffView extends View {
    private PorterDuff.Mode mode = PorterDuff.Mode.ADD;

    private static final int RECT_SIZE_SMALL = 400;
    private static final int RECT_SIZE_BIG = 800;

    private Paint mPaint;

    private PorterDuffBO porterDuffBO;
    private PorterDuffXfermode porterDuffXfermode;

    private int ScreenW, ScreenH;
    private int s_l, s_t;
    private int d_l, d_t;
    private int rectX, rectY;


    public PorterDuffView(Context context) {
        super(context);
    }

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        porterDuffBO = new PorterDuffBO();

        porterDuffXfermode = new PorterDuffXfermode(mode);

        caculate(context);
    }

    private void caculate(Context context) {
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        ScreenW = screenSize[0];
        ScreenH = screenSize[1];

        s_l = 0;
        s_t = 0;

        d_l = ScreenW - RECT_SIZE_SMALL;
        d_t = 0;

        rectX = ScreenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (ScreenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    public PorterDuffView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        porterDuffBO.setSize(RECT_SIZE_SMALL);

        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

        int sc = canvas.saveLayer(0, 0, ScreenW, ScreenH, null, Canvas.ALL_SAVE_FLAG);

        porterDuffBO.setSize(RECT_SIZE_BIG);

        canvas.drawBitmap(porterDuffBO.initDisBitmap(), rectX, rectY, mPaint);

        mPaint.setXfermode(porterDuffXfermode);

        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);

        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }

    public void setMode(PorterDuff.Mode mode) {
        porterDuffXfermode = new PorterDuffXfermode(mode);
        invalidate();
    }
}
