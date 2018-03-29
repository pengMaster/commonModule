package com.mtm.common_module.device_valid;

import android.app.Application;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.LogUtils;
import com.mtm.common_module.config.InitApplicationContext;
import com.mtm.common_module.utils.Md5Util;
import com.mtm.common_module.utils.PackageUtils;
import com.mtm.common_module.utils.SPUtils;
import com.mtm.common_module.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * ******************************************************************
 * Created by MTM on 2017/7/6.
 * Description:获取安全中心的登录用户
 * Android:minSdkVersion: API
 * Author:$USER_NAME
 * Version:V1.0
 * ******************************************************************
 */
public class LoginUtils {

    private static LoginUtils instance;
    public String baseUrl;
    private Gson gson = new Gson();

    public static LoginUtils i() {
        if (instance == null) {
            instance = new LoginUtils();
        }
        return instance;
    }

    /**
     * 应用版本
     */
    public final String APP_VERSION_PROFESSIONAL = "mtmComReportCn";

    public static String getServerUrl() {
        if (isInstall("com.mtm.security")) {
            Cursor cursor = null;
            try {
                Uri uri = ContentUris
                        .withAppendedId(
                                Uri.parse("content://com.mtm.security.providers.dev/device"),
                                1);
                cursor = InitApplicationContext.mAppContext.getContentResolver().query(uri,
                        new String[]{"_server_url", "_flag"}, null, null,
                        null);
                if (cursor != null && cursor.moveToFirst()) {
                    if ("1".equals(cursor.getString(1)) || "0".equals(cursor.getString(1))) {
                        if (!TextUtils.isEmpty(cursor.getString(0))) {
                            String[] urls = cursor.getString(0).split(";");
                            return urls[0];
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return "";
    }


    //从com.mtm.security下的数据库获取 安全中心已登录的用户名密码
    public static Map<String, String> getUsernameAndPwd() {
        Map<String, String> map = new HashMap<>();
        String u = "", p = "";
        if (isInstall("com.mtm.security")) {
            Cursor cursor = null;
            try {
                Uri uri = ContentUris
                        .withAppendedId(
                                Uri.parse("content://com.mtm.security.providers.per/person"),
                                1);
                cursor = InitApplicationContext.mAppContext.getContentResolver().query(uri,
                        new String[]{"_supervisorsnumber", "_password"},
                        null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    u = cursor.getString(0);
                    p = Md5Util.getPwd(cursor.getString(1));
                }

            } catch (Exception e) {
                LogUtils.debugInfo(e.getMessage());
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

        }
        map.put("loginName", u);
        map.put("passWord", p);
        return map;
    }

    private static boolean isInstall(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    /**
     * 验证手机中是否有该包名的app
     */
    private boolean isAvilible(String... packageName) {
        PackageManager packageManager = InitApplicationContext.mAppContext.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_HOME);
        // 通过查询，获得所有ResolveInfo对象.
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo reInfo : resolveInfos) {
            for (String name : packageName) {
                if (reInfo.activityInfo.packageName.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public enum LoadMode {
        //测试,不做任何校验
        TEST,
        //正式
        FORMAL
    }

    /**
     * @param isTestIn true 测试入口的回调
     *                 验证设备是否有效:
     *                 过期/不可用 0
     *                 即将过期    1
     */
    public LoginUtils initDeviceValid(LoadMode isTestIn, final Context context) {
        if (isTestIn == LoadMode.TEST && onInitDeviceValidCallListener != null) {
            onInitDeviceValidCallListener.onSuccess(baseUrl);
            return instance;
        }

        if (isAvilible("com.mtm.launcher2", "com.mtm.launcher3", "com.mtm.mobile")) {
            StringBuilder sb = new StringBuilder();
            String deviceId = Md5Util.getMD5Str(PackageUtils.getDeviceId());
            final int[] versionCode = {PackageUtils.getAppVersionCode()};
            sb.append("http://60.247.49.230:7001/mtmdp/");
            sb.append("scjAction!getNewVersion.do?");
            //.append("type=").append(appName).append("&imei=").append(deviceId);
            OkHttpUtils.post().url(sb.toString()).addParams("type", APP_VERSION_PROFESSIONAL)
                    .addParams("imei", deviceId).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    if (onInitDeviceValidCallListener != null) {
                        if ("0".equals(SPUtils.i("deviceValid").getStringData("isDeviceValid"))) {
                            onInitDeviceValidCallListener.onError( "提示", "该设备服务不可用,请联系'系统服务商'.");
                        } else {
                            onInitDeviceValidCallListener.onResponse(context, 0);
                        }
                    }
                    e.printStackTrace();
                }

                @Override
                public void onResponse(String response, int id) {
                    if (!TextUtils.isEmpty(response)) {
                        switch (response.trim().replaceAll("\r", "").replaceAll("\n", "")) {
                            case "/Exception":
                            case "/noApp":
                            case "/noDevice":
                            case "/noUsed":
                                //过期/不可用
                                onInitDeviceValidCallListener.onError("提示", "该设备服务不可用,请联系'系统服务商'.");
                                versionCode[0] = 0;
                                //无效
                                SPUtils.i("deviceValid").saveStringData("isDeviceValid", "0");
                                break;
                            case "/Warning":
                                //即将过期
                                versionCode[0] = 1;
                                new AlertDialog.Builder(context).setTitle("提示")
                                        .setMessage("该设备服务即将过期,请联系'系统服务商'.").setCancelable(false)
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                                if (onInitDeviceValidCallListener != null) {
                                                    onInitDeviceValidCallListener.onResponse(context, versionCode[0]);
                                                }
                                            }
                                        }).show();
                                //即将过期
                                SPUtils.i("deviceValid").saveStringData("isDeviceValid", "2");
                                return;
                            default:
                                InternalVersionBean internalVersionBean = gson.fromJson(response, InternalVersionBean.class);
                                if (internalVersionBean != null && !TextUtils.isEmpty(internalVersionBean.getInternalVersion())) {
                                    //有效
                                    versionCode[0] = Integer.valueOf(internalVersionBean.getInternalVersion());
                                    SPUtils.i("deviceValid").saveStringData("isDeviceValid", "1");
                                }
                                break;
                        }
                    }
                    if (onInitDeviceValidCallListener != null) {
                        if (versionCode[0] == 0 || "0".equals(SPUtils.i("deviceValid").getStringData("isDeviceValid"))) {
                            //无效
                            onInitDeviceValidCallListener.onError("提示","该设备服务不可用,请联系'系统服务商'.");
                        } else {
                            onInitDeviceValidCallListener.onResponse(context, versionCode[0]);
                        }
                    }
                }
            });
        } else {
            onInitDeviceValidCallListener.onError("提示", "请安装'安全认证中心'和'监督执法'后重试!");
        }
        return instance;
    }

    private OnInitDeviceValidCallListener onInitDeviceValidCallListener;

    public LoginUtils setOnInitDeviceValidCallListener(OnInitDeviceValidCallListener onInitDeviceValidCallListener) {
        this.onInitDeviceValidCallListener = onInitDeviceValidCallListener;
        return instance;
    }

    public abstract static class OnInitDeviceValidCallListener {

        void onResponse(Context context, int versionCode) {
            String serverUrl = LoginUtils.getServerUrl();
            if (TextUtils.isEmpty(serverUrl)) {
                //获取认证地址
                onError( "未激活", "请进行设备激活后重试!");
                return;
            }
            Map<String, String> userData = LoginUtils.getUsernameAndPwd();
            if (userData != null && userData.size() > 0) {
                if (!TextUtils.isEmpty(userData.get("loginName")) && !TextUtils.isEmpty(userData.get("passWord"))) {
                    onSuccess(serverUrl);
                } else if (TextUtils.isEmpty(userData.get("loginName")) || TextUtils.isEmpty(userData.get("passWord"))) {
                    onError("登陆失败", "请重新进行人员认证!");
                }
            } else {
                onError( "未登录", "请在监督执法桌面 - 我的 中进行人员认证后重试!");
            }
        }

        public abstract void onSuccess(String serverUrl);

        public abstract void onError(String title,String content);

    }

//    {"internalVersion":"20170619","publishTime":"2017-06-19 19:35:52","filePath":"http://60.247.49.230:7001/mtmdp/download/yyrj/mtmJDZF/mjdzf2_V5.2.6.apk","version":"V5.2.6"}

}