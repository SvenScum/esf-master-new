package com.example.loginapplication.Utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class IdUtils {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static int generateViewId(){
        for (;;){
            final int result = sNextGeneratedId.get();
            int newValue = result + 1;
            if(newValue > 0x00FFFFFF) newValue = 1;
            if (sNextGeneratedId.compareAndSet(result,newValue));
            return result;
        }
    }
}
