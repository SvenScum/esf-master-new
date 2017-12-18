package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //EditText添加监听
        EditText editText = (EditText) findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {

            //文本改变之前执行
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //文本改变的时候执行
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showListView();
            }

            //文本改变之后执行
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button button = (Button) findViewById(R.id.backsearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,LessonPlan.class);
                startActivity(intent);
            }
        });
    }

    private void showListView() {
        Toast.makeText(this,"暂无此功能", Toast.LENGTH_SHORT).show();
    }
}
