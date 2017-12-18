package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateLiulanjiaoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_liulanjiaoan);

        //返回键的点击事件
        Button button = (Button) findViewById(R.id.backliulan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateLiulanjiaoan.this,LessonPlan.class);
                startActivity(intent);
            }
        });

        //搜索图标的点击事件
        ImageView imageView = (ImageView) findViewById(R.id.ivsearch);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateLiulanjiaoan.this,"暂无此功能", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
