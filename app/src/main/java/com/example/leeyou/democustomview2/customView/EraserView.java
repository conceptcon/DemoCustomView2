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

import static android.graphics.Canvas.ALL_SAVE_FLAG;

public class EraserView extends View {
    private static final int MIN_MOVE_DIS = 5;
    private Bitmap bgBitmap;
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

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        // 设置画笔透明度为0是关键！我们要让绘制的路径是透明的，然后让该路径与前景的底色混合"抠"出绘制路径
        mPaint.setARGB(26, 255, 0, 0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(80);

        bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a4);
        bgBitmap = Bitmap.createScaledBitmap(bgBitmap, screenW, screenH, true);
    }

    private void cal(Context context) {
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bgBitmap, 0, 0, null);

        int i = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, ALL_SAVE_FLAG);
        canvas.drawColor(0xFF828384);//画目标图像
         /*
         * 每当我们手指移动一次均会将路径mPath作为目标图像绘制到canvas上，而在上面我们先在canvas上绘制了中性灰色
         * 两者会因为DST_IN模式的计算只显示中性灰，但是因为mPath的透明，计算生成的混合图像也会是透明的
         * 所以我们会得到"橡皮擦"的效果
         */
        canvas.drawPath(mPath, mPaint);//画源图像
        canvas.restoreToCount(i);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);

                if (dx >= MIN_MOVE_DIS || dy >= MIN_MOVE_DIS) {
                    //该曲线又称为"贝塞尔曲线"(Bezier curve)，其中，x1，y1为控制点的坐标值，x2，y2为终点的坐标值；
                    //此方法和lineTo的区别在于使用quadTo会形成平滑的曲线
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
