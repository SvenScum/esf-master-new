package com.example.loginapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.loginapplication.Adapter.MyFragmentAdapter;
import com.example.loginapplication.Fragment.MyFragment1;
import com.example.loginapplication.Fragment.MyFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class LessonPlan extends FragmentActivity implements View.OnClickListener ,ViewPager.OnPageChangeListener{

    private NoScrollViewPager myViewPager;
    private TextView nianji,kezu;
    private boolean isScrolling = false;
    private boolean isBackScrolling = false;
    MyFragment1 myfragment1 = new MyFragment1();
    MyFragment2 myfragment2 = new MyFragment2();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessonplan);

        nianji = (TextView) findViewById(R.id.nianji);
        kezu = (TextView) findViewById(R.id.kezu);

        initView();

        //返回按钮
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfragment1.onbey();
            }
        });

        //搜索按钮
        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonPlan.this,Search.class);
                startActivity(intent);
            }
        });

        //上传按钮
        Button uploading = (Button) findViewById(R.id.uploading);
        uploading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonPlan.this,UpdateLiulanjiaoan.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        myViewPager = (NoScrollViewPager) findViewById(R.id.myViewPager);

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myfragment1);
        fragmentList.add(myfragment2);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);

        myViewPager.setCurrentItem(0);
        nianji.setTextColor(Color.BLUE);
        kezu.setTextColor(Color.BLACK);

        nianji.setOnClickListener(this);
        kezu.setOnClickListener(this);

        myViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                nianji.setTextColor(Color.BLUE);
                kezu.setTextColor(Color.BLACK);
                break;
            case  1:
                kezu.setTextColor(Color.BLUE);
                nianji.setTextColor(Color.BLACK);
                break;
            default:
                break;
        }
    }
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case 1:
                isScrolling = true;
                isBackScrolling = false;
                break;
            case 2:
                isScrolling = false;
                isBackScrolling = true;
            default:
                isScrolling = false;
                isBackScrolling = false;
                break;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nianji:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.kezu:
                myViewPager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }

}
