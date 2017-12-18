package com.example.loginapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.loginapplication.IndexActivity;
import com.example.loginapplication.OpenFile;
import com.example.loginapplication.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class MyFragment1 extends Fragment {
    //目录列表
    ListView mListView;
    //路径名称
    TextView mTextView;
    File currentParent;
    File[] currentFiles;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.nianji,null);

        mListView = (ListView) view.findViewById(R.id.list);
        mTextView = (TextView) view.findViewById(R.id.path);
        //获取系统的SD卡目录
        File root = new File("/mnt");
        //如果SD卡存在
        if (root.exists()) {
            currentParent = root;
            currentFiles = root.listFiles();//获取root目录下的所有文件
            //使用当前目录下的全部文件，文件夹来填充listview
            inflateListView(currentFiles);
        }//为listview的列表项的单击事件绑定监视器
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //用户点击了文件，则调用手机已安装软件操作该文件
                if (currentFiles[position].isFile()) {
                    Intent intent = OpenFile.openFile(currentFiles[position].getPath());
                    startActivity(intent);
                } else {
                    //获取currentFiles[position]路径下的所有文件
                    File[] tmp = currentFiles[position].listFiles();
                    if (tmp == null || tmp.length == 0) {
                        Toast.makeText(getContext(), "空文件夹!", Toast.LENGTH_SHORT).show();
                    }//if
                    else {
                        //获取用户单击的列表项对应的文件夹，设为当前的父文件夹
                        currentParent = currentFiles[position];
                        //保存当前文件夹内的全部问价和文件夹
                        currentFiles = tmp;
                        inflateListView(currentFiles);
                    }//else
                }//else
            }//onItemClick
        });

        return view;

    }

    //返回上层菜单
    public void onbey() {
        try {
            if (!"/mnt".equals(currentParent.getCanonicalPath())) {
                //获取上一层目录
                currentParent = currentParent.getParentFile();
                //列出当前目录下的所有文件
                currentFiles = currentParent.listFiles();
                //再次更新listv
                inflateListView(currentFiles);
            } else {
                    //返回浏览教案界面
                    Intent intent = new Intent(getActivity(),IndexActivity.class);
                    startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }

    //更新列表
    public void inflateListView(File[] files) {
        if (files.length == 0) {
            Toast.makeText(getContext(), "sd卡不存在", Toast.LENGTH_SHORT).show();
        } else {
            //创建一个list集合，list集合的元素是map
            List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

            for (int i = 0; i < files.length; i++) {
                Map<String, Object> listItem = new HashMap<String, Object>();
                //如果当前file是文件夹，使用folder图标；否则使用file图标
                if (files[i].isDirectory()) listItem.put("icon", R.mipmap.floder);
                else listItem.put("icon", R.mipmap.floder);
                listItem.put("fileName", files[i].getName());
                //添加list项
                listItems.add(listItem);
            }//for
            //创建一个SimpleAdapter
            SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), listItems, R.layout.listnianji, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.filename});
            //为listview设置Adpter
            mListView.setAdapter(simpleAdapter);
            try {
                mTextView.setText("当前路径为：" + currentParent.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }//catch
        }//else
    }//inflateListView

    public void onBackPressed() {
        onbey();
    }
}
