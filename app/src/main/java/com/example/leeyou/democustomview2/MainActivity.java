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

    }
}
