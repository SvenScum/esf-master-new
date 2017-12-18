package com.example.loginapplication.Gson;

import com.google.gson.Gson;


/**
 * Created by Administrator on 2017/11/28 0028.
 */

public class JsonUtils {

    public void parseUserFromJson(String jsonData){
        Gson gson = new Gson();
        gson.toJson(jsonData);
    }

}
