package com.example.leeyou.democustomview2.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.leeyou.democustomview2.R;
import com.example.leeyou.democustomview2.util.MeasureUtil;

public class DstOutView extends View {
    private Paint mPaint;
    private Bitmap bitmapSrc;
    private PorterDuffXfermode porterDuffXfermode;

    private int x, y;
    private int screenW, screenH;

    public DstOutView(Context context) {
        super(context);
    }

    public DstOutView(Context context, AttributeSet attrs) {
        super(context, attrs);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

        initPaint();

        initRes(context);
    }

    private void initRes(Context context) {
        bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a3_mask);

        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];

        x = screenW / 2 - bitmapSrc.getWidth() / 2;
        y = screenH / 2 - bitmapSrc.getHeight() / 2;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public DstOutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.WHITE);

        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawColor(0xFF0080FF);

        mPaint.setXfermode(porterDuffXfermode);

        canvas.drawBitmap(bitmapSrc, x, y, mPaint);

        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }
}
