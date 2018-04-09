package com.eternity_myth.gank.view;

import android.app.Application;

public class GankApplication extends Application {
    private static GankApplication mInstance;

    public static GankApplication getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}