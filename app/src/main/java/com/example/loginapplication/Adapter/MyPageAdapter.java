package com.example.loginapplication.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class MyPageAdapter extends PagerAdapter {

    private List<View> pageList;

    public MyPageAdapter() {}
    public MyPageAdapter(List<View> viewLists) {
        this.pageList = viewLists;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
    public Object instantiateItem(ViewGroup container, int position) {
        // 获取指定位置的控件，页面的事件都可以在这里写
        View view = pageList.get(position);
        // 将指定位置的View加入到ViewGroup
        container.addView(view);
        // 将View作为key返回
        return view;
    }
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 将当前位置的View移除
        container.removeView(pageList.get(position)); }
    /*public void destroyItem(ViewGroup container, int position, Object object) {
        // 将当前位置的View移除
        container.removeView(pageList.get(position)); }*/

}
