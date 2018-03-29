package com.mtm.common_module.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.mtm.common_module.config.InitApplicationContext;


/**
 * ******************************************************************
 * Created by
 * MTM on 2017/1/7.
 * Description: 自定义的SharedPreferences工具类
 * Android:minSdkVersion:
 * API Author:mzp
 * Version:V1.0
 * ******************************************************************
 */
public class SPUtils {
    private static String CONFIG = "mConfig";
    private static SharedPreferences mSP;
    private static SPUtils mInstance;

    public static SPUtils i() {
        if (mInstance == null) {
            mInstance = new SPUtils();
            mSP = InitApplicationContext.mAppContext.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return mInstance;
    }

    //记录上一次的创建的配置文件名称
    private static String mfileName = "";

    /**
     * mInstance
     *
     * @param fileName SharedPreferences cinfigName
     * @return SPUtils
     */
    public static SPUtils i(String fileName) {
        if (!mfileName.equals(fileName)) {
            mfileName = fileName;
            mInstance = new SPUtils();
            mSP = InitApplicationContext.mAppContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        }
        return mInstance;
    }

    public void saveBooleanData(String key, boolean value) {
        mSP.edit().putBoolean(key, value).apply();
    }

    public SharedPreferences getSharedPreferences() {
        return mSP;
    }

    public boolean getBooleanData(String key, boolean defValue) {
        return mSP.getBoolean(key, defValue);
    }

    public void saveStringData(String key, String value) {
        mSP.edit().putString(key, value).apply();
    }

    public String getStringData(String key) {
        return mSP.getString(key, "");
    }

    public void clearAllData() {
        mSP.edit().clear().apply();
    }
}