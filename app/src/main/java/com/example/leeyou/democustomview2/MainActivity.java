package com.example.leeyou.democustomview2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("自定义控件之画笔");

        Button btn_color_matrix_filter = (Button) findViewById(R.id.btn_color_matrix_filter);
        btn_color_matrix_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ColorMatrixFilterActivity.class));
            }
        });

        Button btn_lighting_color_filter = (Button) findViewById(R.id.btn_lighting_color_filter);
        btn_lighting_color_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LightingColorFilterActivity.class));
            }
        });

        Button btn_porter_duff_color_filter = (Button) findViewById(R.id.btn_porter_duff_color_filter);
        btn_porter_duff_color_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PorterDuffColorFilterActivity.class));
            }
        });

        Button btn_porter_duff_xfermode = (Button) findViewById(R.id.btn_porter_duff_xfermode);
        btn_porter_duff_xfermode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PorterDuffXfermodeActivity.class));
            }
        });

        Button btn_dst_in_exercise = (Button) findViewById(R.id.btn_dst_in_exercise);
        btn_dst_in_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DST_IN_Activity.class));
            }
        });

        Button btn_dst_out_exercise = (Button) findViewById(R.id.btn_dst_out_exercise);
        btn_dst_out_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DST_OUT_Activity.class));
            }
        });

        Button btn_eraser = (Button) findViewById(R.id.btn_eraser);
        btn_eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EraserActivity.class));
            }
        });

    }
}
