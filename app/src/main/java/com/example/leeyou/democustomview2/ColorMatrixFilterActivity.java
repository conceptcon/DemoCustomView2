package com.example.leeyou.democustomview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.leeyou.democustomview2.customView.ColorMatrixView;

public class ColorMatrixFilterActivity extends AppCompatActivity {
    private ColorMatrixView mColorMatrixView;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix_filter);

        mColorMatrixView = (ColorMatrixView) findViewById(R.id.colorMatrixView);
        mTv = (TextView) findViewById(R.id.tv_desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_color_matrix_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                mColorMatrixView.setColorMatrix(1);
                mTv.setText("变暗效果");
                break;
            case R.id.action_2:
                mColorMatrixView.setColorMatrix(2);
                mTv.setText("变灰效果");
                break;
            case R.id.action_3:
                mColorMatrixView.setColorMatrix(3);
                mTv.setText("反相效果");
                break;
            case R.id.action_4:
                mColorMatrixView.setColorMatrix(4);
                mTv.setText("红、蓝色相互变换效果");
                break;
            case R.id.action_5:
                mColorMatrixView.setColorMatrix(5);
                mTv.setText("老旧照片效果");
                break;
            case R.id.action_6:
                mColorMatrixView.setColorMatrix(6);
                mTv.setText("去色后高对比度");
                break;
            case R.id.action_7:
                mColorMatrixView.setColorMatrix(7);
                mTv.setText("饱和度对比度加强");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
