package com.mtm.common_module.config;

import android.content.Context;
import android.os.Handler;

import com.jess.arms.utils.DeviceUtils;

/**
 * 单例获取ApplicationContext
 *
 * @author MtmWp
 * @date 2018-3-27 09:16.
 */

public class InitApplicationContext {

    private static InitApplicationContext mApplicationContext;
    public static Context mAppContext;
    public static float phoneWidth;
    public static float phoneHeight;
    /**
     * 主线程Handler
     */
    public static Handler mMainThreadHandler;
    /**
     * 主线程ID
     */
    public static int mMainThreadId = -1;


    public static InitApplicationContext i() {
        if (mApplicationContext == null) {
            mApplicationContext = new InitApplicationContext();
        }
        return mApplicationContext;
    }

    /**
     * 获取主App context
     *
     * @param context
     */
    public void initContext(Context context) {
        mAppContext = context;
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        mMainThreadId = android.os.Process.myTid();
        phoneWidth = DeviceUtils.getScreenWidth(mAppContext);
        phoneHeight = DeviceUtils.getScreenHeight(mAppContext);
        mMainThreadHandler = new Handler();
    }
}
