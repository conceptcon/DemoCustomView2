package com.example.leeyou.democustomview2.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.leeyou.democustomview2.R;
import com.example.leeyou.democustomview2.util.MeasureUtil;

public class EraserView extends View {
    private static final int MIN_MOVE_DIS = 5;

    private Bitmap fgBitmap, bgBitmap;

    private Canvas mCanvas;

    private Paint mPaint;

    private Path mPath;

    private int screenW, screenH;

    private float preX, preY;

    public EraserView(Context context) {
        super(context);
    }

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);

        cal(context);

        init(context);
    }

    private void init(Context context) {
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        // 设置画笔透明度为0是关键！我们要让绘制的路径是透明的，然后让该路径与前景的底色混合“抠”出绘制路径
        mPaint.setARGB(128, 255, 0, 0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);

        fgBitmap = Bitmap.createBitmap(screenW, screenH, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(fgBitmap);

        mCanvas.drawColor(0xFF808080);

        bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a4);

        bgBitmap = Bitmap.createScaledBitmap(bgBitmap, screenW, screenH, true);

    }

    private void cal(Context context) {
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];
    }

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bgBitmap, 0, 0, null);

        canvas.drawBitmap(fgBitmap, 0, 0, null);

         /*
         * 这里要注意canvas和mCanvas是两个不同的画布对象
         * 当我们在屏幕上移动手指绘制路径时会把路径通过mCanvas绘制到fgBitmap上
         * 每当我们手指移动一次均会将路径mPath作为目标图像绘制到mCanvas上，而在上面我们先在mCanvas上绘制了中性灰色
         * 两者会因为DST_IN模式的计算只显示中性灰，但是因为mPath的透明，计算生成的混合图像也会是透明的
         * 所以我们会得到“橡皮擦”的效果
         */
        mCanvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);

                if (dx >= MIN_MOVE_DIS || dy >= MIN_MOVE_DIS) {
                    //该曲线又称为"贝塞尔曲线"(Bezier curve)，其中，x1，y1为控制点的坐标值，x2，y2为终点的坐标值；
                    mPath.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    preX = x;
                    preY = y;
                }

                break;
        }

        invalidate();

        return true;
    }
}
