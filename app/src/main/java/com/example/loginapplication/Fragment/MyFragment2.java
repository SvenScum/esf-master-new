package com.example.loginapplication.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import com.example.loginapplication.Bean.Subject;
import com.example.loginapplication.IndexActivity;
import com.example.loginapplication.R;
import com.example.loginapplication.Utils.IdUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.path;


/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class MyFragment2 extends Fragment {
    SwipeMenuListView mListView;
    TextView mTextView;
    private SharedPreferences sp;
    RelativeLayout kezuLayout ;
    ImageView mImageView;
    private SimpleAdapter mListAdapter;
    String responseData ;
    //message的用法
    /*android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mListAdapter = (SimpleAdapter) msg.obj;

            mListView.setAdapter(mListAdapter);
        }
    };

     Message msg = Message.obtain();
                msg.obj = mListAdapter;
                mHandler.sendMessage(msg);*/

    String url = "http://202.175.64.187:8080/learning/servlet/api/directory/teacher/4/subjects";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.kezu,null);
        mListView = (SwipeMenuListView) view.findViewById(R.id.list);
        mImageView = (ImageView) view.findViewById(R.id.iv_folder);
        /*mTextView = (TextView) view.findViewById(path);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"爱你哟",Toast.LENGTH_SHORT).show();
            }
        });*/
        kezuLayout = (RelativeLayout) view.findViewById(R.id.kezua);
        sp = getActivity().getSharedPreferences("cookie", Context.MODE_PRIVATE);

        connect(url);

        return view;
    }

    //返回上层菜单
    public void onbey() {
        try {
            int value = IdUtils.generateViewId();
            if(value > 1){

            }else {
            Intent intent = new Intent(getActivity(),IndexActivity.class);
            startActivity(intent);}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //传入登录状态
    public String connect(final String url){
        new Thread(){
            @Override
            public void run() {

                //创建OkHttpClient实例
                OkHttpClient mClient = new OkHttpClient.Builder()
                        .cookieJar(new CookieJar() {
                            @Override
                            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {}
                            //请求时携带cookie
                            @Override
                            public List<Cookie> loadForRequest(HttpUrl url) {
                                List<Cookie> cookies = new ArrayList<Cookie>();
                                //将cookie的主要参数取出
                                String domain = sp.getString("domain","");
                                System.out.println("aaaaaaaa"+domain);
                                String name = sp.getString("name","");
                                String value = sp.getString("value","");
                                String path = sp.getString("path","");
                                Boolean httpOnly = sp.getBoolean("httpOnly",false);

                                if (httpOnly){
                                    //将xml文件的参数取出后 创建拼接cookie
                                    Cookie cookie = new Cookie.Builder()
                                            .domain(domain)
                                            .name(name)
                                            .value(value)
                                            .path(path)
                                            .httpOnly()
                                            .build();
                                    System.out.println("cookieString:"+cookie.toString());//打印cookie字符串
                                    cookies.add(cookie);
                                }
                                //如果cookies不为空，则返回cookies
                                return cookies != null ? cookies : new ArrayList<Cookie>();
                            }
                        })
                        .build();
                //以get方式进行请求
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                try {
                    Response response = mClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        responseData =response.body().string();
                        System.out.println("cccc"+responseData);
                        showResponse(responseData);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("aaaccc"+responseData);
        return responseData;
    }


    private void showResponse(final String s){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                //解析数据
                Gson gson = new Gson();
                final Subject subject = gson.fromJson(s,Subject.class);

                //创建第一个路径控件
                TextView tv = new TextView(getActivity());
                tv.setId(IdUtils.generateViewId());
                RelativeLayout.LayoutParams parms= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                parms.addRule(RelativeLayout.RIGHT_OF,path);
                tv.setText(subject.getBody().get(0).getName());
                kezuLayout.addView(tv,parms);

                tv.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                    }
                });

                //获取list
                List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < subject.getBody().size();i++) {
                    Map<String, Object> listem = new HashMap<String, Object>();
                    listem.put("icon", R.drawable.floder);
                    listem.put("aaa",subject.getBody().get(i).getName());
                    System.out.println("cccc"+listem);
                    listems.add(listem);
                }

                //适配器填充
                mListAdapter = new SimpleAdapter(getActivity(),listems,R.layout.item_drawer,new String[]{"icon", "aaa"},new int[]{R.id.iv_folder,R.id.item_kezu});
                mListView.setAdapter(mListAdapter);

                //创建左滑项目
                SwipeMenuCreator menuCreator = new SwipeMenuCreator() {
                @Override
                    public void create(SwipeMenu menu) {

                    SwipeMenuItem changeitem = new SwipeMenuItem(getActivity().getApplicationContext());
                    changeitem.setBackground(new ColorDrawable(Color.parseColor("#3CADE7")));
                    changeitem.setWidth(150);
                    changeitem.setTitle("修改");
                    changeitem.setTitleColor(Color.parseColor("#ffffff"));
                    changeitem.setTitleSize(14);
                    menu.addMenuItem(changeitem);

                    SwipeMenuItem deleteitem = new SwipeMenuItem(getActivity().getApplicationContext());
                    deleteitem.setBackground(new ColorDrawable(Color.parseColor("#3CADE7")));
                    deleteitem.setWidth(150);
                    deleteitem.setTitle("删除");
                    deleteitem.setTitleColor(Color.parseColor("#ffffff"));
                    deleteitem.setTitleSize(14);
                    menu.addMenuItem(deleteitem);
                    }
                };

        //填充左滑项目
        mListView.setMenuCreator(menuCreator);
        //左滑项目的点击事件
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch(index){
                    case 0:
                        Toast.makeText(getContext(),"不可以修改", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(),"不可以删除", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }

        });
                //listview 的item的点击事件
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //positon是获取的点击的是第几个，传给newname，获取到第几个的name
                        newname(subject.getBody().get(position).getName());
                        //connect(url+subject.getBody().get(position).getName());
                        Toast.makeText(getContext(),"不爱你了哟", Toast.LENGTH_SHORT).show();

                    }//onItemClick
                });//setOnItemClickListener
            }//run
        });//runOnUiThread
    }

    //动态生成路径
    public void newname(String c){
        TextView mtv = new TextView(getActivity());
        mtv.setId(IdUtils.generateViewId());
        RelativeLayout.LayoutParams parms= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        parms.addRule(RelativeLayout.RIGHT_OF,mtv.getId()-1 );
        mtv.setText(">" + c);
        kezuLayout.addView(mtv,parms);
    }

}
