package com.mtm.common_module.utils;


import com.mtm.common_module.config.InitApplicationContext;

/**
 * ***    ***     **********   ***    ***
 * ****   ****    **********   ****   ****
 * *** *  * ***       ***      *** *  * ***
 * ***  * *  ***      ***      ***  * *  ***
 * ***   **   ***     ***      ***   **   ***
 * ******************************************************************
 * Created by MTM on 2017/9/26.
 * Description:
 * Android:minSdkVersion: API
 * @author :mzp
 * Version:V1.0
 * ******************************************************************
 */

public class ThreadUtils {


    /**
     * 判断当前的线程是不是在主线程
     *
     * @return true 是
     */
    public static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }

    public static void runInMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            runnable.run();
        } else {
            postMain(runnable);
        }
    }

    public static long getMainThreadId() {
        return InitApplicationContext.mMainThreadId;
    }

    public static boolean postMain(Runnable runnable) {
        return InitApplicationContext.mMainThreadHandler.post(runnable);
    }

    public static boolean postMain(Runnable runnable, long time) {
        return InitApplicationContext.mMainThreadHandler.postDelayed(runnable, time);
    }

}