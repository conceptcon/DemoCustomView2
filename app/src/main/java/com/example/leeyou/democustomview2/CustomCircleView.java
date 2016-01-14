package com.example.leeyou.democustomview2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Context context;

    private int x, y;

    private int radiu = 150;

    private int[] colors = new int[]{Color.RED, Color.GREEN, Color.GRAY, Color.MAGENTA};

    public CustomCircleView(Context context) {
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

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        initPaint();
        initRes();
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);


        // 生成色彩矩阵
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1, 0, 0, 0, 0,
//                0, 1, 0, 0, 0,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        //变暗效果
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.5f, 0, 0, 0, 0,
//                0, 0.5f, 0, 0, 0,
//                0, 0, 0.5f, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        //变灰效果
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        //反相效果
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                -1, 0, 0, 1, 1,
//                0, -1, 0, 1, 1,
//                0, 0, -1, 1, 1,
//                0, 0, 0, 1, 0,
//        });

        //红色的变成了蓝色而蓝色的就变成了红色
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0, 0, 1, 0, 0,
//                0, 1, 0, 0, 0,
//                1, 0, 0, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        //老旧照片效果
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.393F, 0.769F, 0.189F, 0, 0,
//                0.349F, 0.686F, 0.168F, 0, 0,
//                0.272F, 0.534F, 0.131F, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        //去色后高对比度
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.5F, 1.5F, 1.5F, 0, -1,
                1.5F, 1.5F, 1.5F, 0, -1,
                1.5F, 1.5F, 1.5F, 0, -1,
                0, 0, 0, 1, 0,
        });

        //饱和度对比度加强
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1.438F, -0.122F, -0.016F, 0, -0.03F,
//                -0.062F, 1.378F, -0.016F, 0, 0.05F,
//                -0.062F, -0.122F, 1.483F, 0, -0.02F,
//                0, 0, 0, 1, 0,
//        });

        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(350, 400, radiu, mPaint);

        canvas.drawBitmap(mBitmap, x, y, mPaint);
    }

}
