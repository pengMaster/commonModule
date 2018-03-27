package com.mtm.common_module.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.mtm.common_module.config.InitApplicationContext;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.jess.arms.utils.ArmsUtils.startActivity;

/**
 * Created by MTM on 2017/11/16.
 *
 * @author MZP
 */

public class PackageUtils {

    public static String getPackageName() {
        return InitApplicationContext.mAppContext.getPackageName();
    }

    /**
     * 监督执法使用的方法
     * 判断文件是否存在
     *
     * @param packageName packageName
     * @return true 存在
     */
    public static boolean isPackageExists(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    public static boolean isPrinterShareExists() {
        return isPackageExists("com.dynamixsoftware.printershare");
    }

    public static boolean isPrinterShareAmazonExists() {
        return isPackageExists("com.dynamixsoftware.printershare.amazon");
    }

    public static boolean isMJDZFExists() {
        return isPackageExists("com.mtm.mobile");
    }


    /**
     * 跳转到miui的权限管理页面
     */
    public static void gotoMiuiPermission() {
        Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR");
        ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        i.setComponent(componentName);
        i.putExtra("extra_pkgname", getPackageName());
        try {
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
            gotoMeizuPermission();
        }
    }

    /**
     * 跳转到魅族的权限管理系统
     */
    public static void gotoMeizuPermission() {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("packageName", getPackageName());
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            gotoHuaweiPermission();
        }
    }

    /**
     * 华为的权限管理页面
     */
    public static void gotoHuaweiPermission() {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
            intent.setComponent(comp);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            startActivity(getAppDetailSettingIntent());
        }

    }

    /**
     * 获取应用详情页面intent
     *
     * @return
     */
    public static Intent getAppDetailSettingIntent() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        return localIntent;
    }


    /**
     * 检查当前应用是否有某项权限
     *
     * @param permName 权限名称
     * @return
     */
    public static boolean checkPermission(String permName) {
        return checkPermission(permName, InitApplicationContext.mAppContext.getPackageName());
    }

    /**
     * 检查包名所在的程序是否有某项权限
     *
     * @param permName 权限名称
     * @param pkgName  程序所在的包名
     * @return
     */
    public static boolean checkPermission(String permName, String pkgName) {
        PackageManager pm = InitApplicationContext.mAppContext.getPackageManager();
        try {
            boolean isHave = (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permName, pkgName));
            return isHave;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取App包 信息版本号
     *
     * @return
     */
    public static PackageInfo getPackageInfo() {
        PackageManager packageManager = InitApplicationContext.mAppContext.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(InitApplicationContext.mAppContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    public static int getAppVersionCode() {
        PackageInfo pi = getPackageInfo();
        return pi == null ? -1 : pi.versionCode;
    }

    public static String getAppVersionName() {
        PackageInfo pi = getPackageInfo();
        return pi == null ? "" : pi.versionName;
    }


    /**
     * 调用系统安装应用
     */
    public static boolean install(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        InitApplicationContext.mAppContext.startActivity(intent);
        return true;
    }

    /**
     * 调用系统卸载应用
     */
    public static void uninstallApk(String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        Uri packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        InitApplicationContext.mAppContext.startActivity(intent);
    }

    /**
     * 打开已安装应用的详情
     */
    public static void goToInstalledAppDetails(String packageName) {
        Intent intent = new Intent();
        int sdkVersion = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.fromParts("package", packageName, null));
        } else {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra((sdkVersion == Build.VERSION_CODES.FROYO ? "pkg"
                    : "com.android.settings.ApplicationPkgName"), packageName);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        InitApplicationContext.mAppContext.startActivity(intent);
    }


    /**
     * 调用系统分享
     */
    public static void shareToOtherApp(String title, String content, String dialogTitle) {
        Intent intentItem = new Intent(Intent.ACTION_SEND);
        intentItem.setType("text/plain");
        intentItem.putExtra(Intent.EXTRA_SUBJECT, title);
        intentItem.putExtra(Intent.EXTRA_TEXT, content);
        intentItem.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        InitApplicationContext.mAppContext.startActivity(Intent.createChooser(intentItem, dialogTitle));
    }

    /**
     * 判断是否前台运行
     * 须配置android.permission.GET_TASKS权限
     *
     * @return
     */
    public static boolean isRunningForeground() {
        ActivityManager am = (ActivityManager) InitApplicationContext.mAppContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskList = am.getRunningTasks(1);
        if (taskList != null && !taskList.isEmpty()) {
            ComponentName componentName = taskList.get(0).topActivity;
            if (componentName != null && componentName.getPackageName().equals(InitApplicationContext.mAppContext.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是系统应用
     *
     * @param packageName
     * @return
     */
    public static boolean isSystemApplication(String packageName) {
        PackageManager packageManager = InitApplicationContext.mAppContext.getPackageManager();
        if (packageManager == null || packageName == null || packageName.length() == 0) {
            return false;
        }
        try {
            ApplicationInfo app = packageManager.getApplicationInfo(packageName, 0);
            return (app != null && (app.flags & ApplicationInfo.FLAG_SYSTEM) > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取指定程序应用信息
     *
     * @param pkg
     * @return
     */
    public static ApplicationInfo getApplicationInfo(String pkg) {
        try {
            return InitApplicationContext.mAppContext.getPackageManager().getApplicationInfo(pkg, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定程序包信息
     *
     * @param pkg
     * @return
     */
    public static PackageInfo getPackageInfo(String pkg) {
        try {
            return InitApplicationContext.mAppContext.getPackageManager().getPackageInfo(pkg, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取已安装的全部应用信息
     *
     * @return
     */
    public static List<PackageInfo> getInsatalledPackages() {
        return InitApplicationContext.mAppContext.getPackageManager().getInstalledPackages(0);
    }

    /**
     * 检测应用是否安装
     *
     * @param pkg
     * @return
     */
    public static boolean isInsatalled(String pkg) {
        if (!CheckUtils.isEmpty(pkg)) {
            List<PackageInfo> list = getInsatalledPackages();
            if (!CheckUtils.isEmpty(list)) {
                for (PackageInfo pi : list) {
                    if (pkg.equalsIgnoreCase(pi.packageName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 通过包名启动某个应用
     *
     * @param packageName
     * @return
     */
    public static boolean startAppByPackageName(String packageName) {
        return startAppByPackageName(packageName, null);
    }

    /**
     * 通过包名启动某个应用 带参数
     *
     * @param packageName
     * @param param
     * @return
     */
    public static boolean startAppByPackageName(String packageName, Map<String, String> param) {
        PackageInfo pi = null;
        try {
            pi = InitApplicationContext.mAppContext.getPackageManager().getPackageInfo(packageName, 0);
            Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
            resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
                resolveIntent.setPackage(pi.packageName);
            }

            List<ResolveInfo> apps = InitApplicationContext.mAppContext.getPackageManager().queryIntentActivities(resolveIntent, 0);

            ResolveInfo ri = apps.iterator().next();
            if (ri != null) {
                String packageName1 = ri.activityInfo.packageName;
                String className = ri.activityInfo.name;

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);

                ComponentName cn = new ComponentName(packageName1, className);

                intent.setComponent(cn);
                if (param != null) {
                    for (Map.Entry<String, String> en : param.entrySet()) {
                        intent.putExtra(en.getKey(), en.getValue());
                    }
                }
                InitApplicationContext.mAppContext.startActivity(intent);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.show("启动失败");
        }
        return false;
    }


    public static String getDeviceId() {
        final TelephonyManager tm = (TelephonyManager) InitApplicationContext.mAppContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null || deviceId.length() == 0) {
            deviceId = Settings.Secure.getString(InitApplicationContext.mAppContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return deviceId;
    }

    public static String getVersionCode() {
        String versionCode = "";/**/
        try {
            PackageInfo info = InitApplicationContext.mAppContext.getPackageManager().getPackageInfo(
                    InitApplicationContext.mAppContext.getPackageName(), 0);
            versionCode = String.valueOf(info.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("---versionCode---", e.getMessage());
        }
        Log.d("---versionCode---", versionCode);
        return versionCode;
    }

    public static String getVersionName() {
        String versionName = "";
        try {
            PackageInfo info = InitApplicationContext.mAppContext.getPackageManager().getPackageInfo(
                    InitApplicationContext.mAppContext.getPackageName(), 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("---versionName---", e.getMessage());
        }
        return versionName;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }


}