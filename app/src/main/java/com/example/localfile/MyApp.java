package com.example.localfile;

import android.app.Application;

/**
 * @Author Coco
 * @ClassName MyApp
 * @Date 2020/9/22 15:55
 * @Description TODO
 */
public class MyApp extends Application {
    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        CrashHandler.getLog();
    }

    public static MyApp getInstance() {
        return instance;
    }
}
