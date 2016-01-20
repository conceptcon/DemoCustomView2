package com.example.leeyou.democustomview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.leeyou.democustomview2.customView.CustomCircleView;

public class ColorMatrixFilterActivity extends AppCompatActivity {
    CustomCircleView customCircleView;
    TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix_filter);

        customCircleView = (CustomCircleView) findViewById(R.id.customCircleView);

        tv_desc = (TextView) findViewById(R.id.tv_desc);
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
                customCircleView.setColorMatrix(1);
                tv_desc.setText("变暗效果");
                break;
            case R.id.action_2:
                customCircleView.setColorMatrix(2);
                tv_desc.setText("变灰效果");
                break;
            case R.id.action_3:
                customCircleView.setColorMatrix(3);
                tv_desc.setText("反相效果");
                break;
            case R.id.action_4:
                customCircleView.setColorMatrix(4);
                tv_desc.setText("红、蓝色相互变换效果");
                break;
            case R.id.action_5:
                customCircleView.setColorMatrix(5);
                tv_desc.setText("老旧照片效果");
                break;
            case R.id.action_6:
                customCircleView.setColorMatrix(6);
                tv_desc.setText("去色后高对比度");
                break;
            case R.id.action_7:
                customCircleView.setColorMatrix(7);
                tv_desc.setText("饱和度对比度加强");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
