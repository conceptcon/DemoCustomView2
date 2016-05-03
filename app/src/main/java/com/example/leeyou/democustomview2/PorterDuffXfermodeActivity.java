package com.example.leeyou.democustomview2;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.leeyou.democustomview2.customView.PorterDuffView;

public class PorterDuffXfermodeActivity extends AppCompatActivity {
    PorterDuffView porterDuff = null;
    TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff_xfermode);

        porterDuff = (PorterDuffView) findViewById(R.id.porterDuffView);

        tv_desc = (TextView) findViewById(R.id.tv_desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_porter_duff_xfermode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                porterDuff.setMode(PorterDuff.Mode.ADD);
                tv_desc.setText("ADD 计算方式：Saturate(S + D)；Chinese：饱和相加\nADD模式简单来说就是对图像饱和度进行相加，这个模式在应用中不常用");
                break;
            case R.id.action_clear:
                porterDuff.setMode(PorterDuff.Mode.CLEAR);
                tv_desc.setText("CLEAR 计算方式：[0, 0]；Chinese：清除");
                break;
            case R.id.action_darken:
                porterDuff.setMode(PorterDuff.Mode.DARKEN);
                tv_desc.setText("DARKEN 计算方式：[Sa + Da - Sa*Da, Sc*(1 - Da) + Dc*(1 - Sa) + min(Sc, Dc)]；Chinese：变暗\n两个图像混合，较深的颜色总是会覆盖较浅的颜色，如果两者深浅相同则混合，如图，黄色覆盖了红色而蓝色和青色因为是跟透明混合所以不变");
                break;
            case R.id.action_dst:
                porterDuff.setMode(PorterDuff.Mode.DST);
                tv_desc.setText("DST 计算方式：[Da, Dc]；Chinese：只绘制目标图像");
                break;
            case R.id.action_dst_atop:
                porterDuff.setMode(PorterDuff.Mode.DST_ATOP);
                tv_desc.setText("DST_ATOP 计算方式：[Sa, Sa * Dc + Sc * (1 - Da)]；Chinese：在源图像和目标图像相交的地方绘制目标图像而在不相交的地方绘制源图像");
                break;
            case R.id.action_dst_in:
                porterDuff.setMode(PorterDuff.Mode.DST_IN);
                tv_desc.setText("DST_IN 计算方式：[Sa * Da, Sa * Dc]；Chinese：只在源图像和目标图像相交的地方绘制目标图像");
                break;
            case R.id.action_dst_out:
                porterDuff.setMode(PorterDuff.Mode.DST_OUT);
                tv_desc.setText("DST_OUT 计算方式：[Da * (1 - Sa), Dc * (1 - Sa)]；Chinese：只在源图像和目标图像不相交的地方绘制目标图像");
                break;
            case R.id.action_dst_over:
                porterDuff.setMode(PorterDuff.Mode.DST_OVER);
                tv_desc.setText("DST_OVER 计算方式：[Sa + (1 - Sa)*Da, Rc = Dc + (1 - Da)*Sc]；Chinese：在源图像的上方绘制目标图像");
                break;
            case R.id.action_lighten:
                porterDuff.setMode(PorterDuff.Mode.LIGHTEN);
                tv_desc.setText("LIGHTEN 计算方式：[Sa + Da - Sa*Da, Sc*(1 - Da) + Dc*(1 - Sa) + max(Sc, Dc)]；Chinese：变亮");
                break;
            case R.id.action_multiply:
                porterDuff.setMode(PorterDuff.Mode.MULTIPLY);
                tv_desc.setText("MULTIPLY 计算方式：[Sa * Da, Sc * Dc]；Chinese：正片叠底\n源图像素颜色值乘以目标图像素颜色值除以255即得混合后图像像素的颜色值");
                break;
            case R.id.action_overlay:
                porterDuff.setMode(PorterDuff.Mode.OVERLAY);
                tv_desc.setText("OVERLAY 计算方式：未给出；Chinese：叠加\n这个模式没有在官方的API DEMO中给出，谷歌也没有给出其计算方式，在实际效果中其对亮色和暗色不起作用，也就是说黑白色无效，它会将源色与目标色混合产生一种中间色，这种中间色生成的规律也很简单，如果源色比目标色暗，那么让目标色的颜色倍增否则颜色递减。");
                break;
            case R.id.action_screen:
                porterDuff.setMode(PorterDuff.Mode.SCREEN);
                tv_desc.setText("SCREEN 计算方式：[Sa + Da - Sa * Da, Sc + Dc - Sc * Dc]；Chinese：滤色");
                break;
            case R.id.action_src:
                porterDuff.setMode(PorterDuff.Mode.SRC);
                tv_desc.setText("SRC 计算方式：[Sa, Sc]；Chinese：显示源图");
                break;
            case R.id.action_src_atop:
                porterDuff.setMode(PorterDuff.Mode.SRC_ATOP);
                tv_desc.setText("SRC_ATOP 计算方式：[Da, Sc * Da + (1 - Sa) * Dc]；Chinese：在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像");
                break;
            case R.id.action_src_in:
                porterDuff.setMode(PorterDuff.Mode.SRC_IN);
                tv_desc.setText("SRC_IN 计算方式：[Sa * Da, Sc * Da]；Chinese：只在源图像和目标图像相交的地方绘制源图像");
                break;
            case R.id.action_src_out:
                porterDuff.setMode(PorterDuff.Mode.SRC_OUT);
                tv_desc.setText("SRC_OUT 计算方式：[Sa * (1 - Da), Sc * (1 - Da)]；Chinese：只在源图像和目标图像不相交的地方绘制源图像");
                break;
            case R.id.action_src_over:
                porterDuff.setMode(PorterDuff.Mode.SRC_OVER);
                tv_desc.setText("SRC_OVER 计算方式：[Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc]；Chinese：在目标图像的顶部绘制源图像");
                break;
            case R.id.action_xor:
                porterDuff.setMode(PorterDuff.Mode.XOR);
                tv_desc.setText("XOR 计算方式：[Sa + Da - 2 * Sa * Da, Sc * (1 - Da) + (1 - Sa) * Dc]；Chinese：在源图像和目标图像重叠之外的任何地方绘制他们，而在不重叠的地方不绘制任何内容");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
