package com.eternity_myth.gank;

import android.app.Activity;


import java.util.LinkedList;

public class ActivityStackManager {
    private static LinkedList<Activity> mActivityStack;
    private static ActivityStackManager mInstance;

    public static ActivityStackManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityStackManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityStackManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new LinkedList<>();
        }
        mActivityStack.add(activity);
    }


    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = mActivityStack.getLast();
        finishActivity(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (mActivityStack != null) {
                mActivityStack.remove(activity);
            }
        }
        activity.finish();
    }


}