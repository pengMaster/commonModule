package com.mtm.common_module.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


import com.mtm.common_module.config.InitApplicationContext;


/**
 * ***    ***     **********   ***    ***
 * ****   ****    **********   ****   ****
 * *** *  * ***       ***      *** *  * ***
 * ***  * *  ***      ***      ***  * *  ***
 * ***   **   ***     ***      ***   **   ***
 * ******************************************************************
 * Created by MTM on 2017/9/26.
 * Description: Toast
 * Android:minSdkVersion: API
 *
 * @author :mzp
 *         Version: base
 *         ******************************************************************
 */

public class ToastUtils {

    private static Toast toast;
    private static Toast toast2;

    private static void initToast(final CharSequence message, final int duration) {
        if (ThreadUtils.isRunInMainThread()) {
            showToastSafe(message, duration);
        } else {
            ThreadUtils.postMain(new Runnable() {
                @Override
                public void run() {
                    showToastSafe(message, duration);
                }
            });
        }
    }

//    public static void showTop(final Activity act, final String title) {
//        if (ThreadUtils.isRunInMainThread()) {
//            show(act, title, "", 1000, Gravity.TOP);
//        } else {
//            ThreadUtils.postMain(new Runnable() {
//                @Override
//                public void run() {
//                    show(act, title, "", 1000, Gravity.TOP);
//                }
//            });
//        }
//    }
//
//    public static void showTop(final String title) {
//        try {
//            if (ThreadUtils.isRunInMainThread()) {
//                show(title, "", 1000, Gravity.TOP);
//            } else {
//                ThreadUtils.postMain(new Runnable() {
//                    @Override
//                    public void run() {
//                        show(title, "", 1000, Gravity.TOP);
//                    }
//                });
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//            showShort(title);
//        }
//    }
//
//    public static void showTop(int strResId) {
//        String title = InitApplicationContext.mAppContext.getResources().getString(strResId);
//        try {
//            if (ThreadUtils.isRunInMainThread()) {
//                show(title, "", 1000, Gravity.TOP);
//            } else {
//                ThreadUtils.postMain(new Runnable() {
//                    @Override
//                    public void run() {
//                        show(title, "", 1000, Gravity.TOP);
//                    }
//                });
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//            showShort(title);
//        }
//    }
//
//    public static void show(Activity act, String title, String message, long time, int gravity) {
//        new CookieBar.Builder(act)
//                .setTitle(title)
//                .setMessage(message)
//                .setDuration(time)
//                .setLayoutGravity(gravity)
//                .setBackgroundColor(R.color.textBlack)
//                .show();
//    }
//
//    public static void show(String title, String message, long time, int gravity) {
//        new CookieBar.Builder(MyActyManager.getInstance().getCurrentActivity())
//                .setTitle(title)
//                .setMessage(message)
//                .setDuration(time)
//                .setLayoutGravity(gravity)
//                .setBackgroundColor(R.color.textBlack)
//                .show();
//    }

    public static void showBottom() {

    }

    /**
     * 任意线程里都可以使用
     *
     * @param message  内容
     * @param duration 时间
     */
    @SuppressLint({"SetTextI18n", "ShowToast"})
    private static void showToastSafe(CharSequence message, int duration) {
        if (toast == null) {
            toast = Toast.makeText(InitApplicationContext.mAppContext, message, duration);
        } else {
            toast.setText(message);
            toast.setDuration(duration);
        }
        toast.show();
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(CharSequence message) {
        initToast(message, Toast.LENGTH_SHORT);
    }


    /**
     * 短时间显示Toast
     */
    public static void showShort(int strResId) {
        initToast(InitApplicationContext.mAppContext.getResources().getText(strResId), Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(CharSequence message) {
        initToast(message, Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(int strResId) {
        initToast(InitApplicationContext.mAppContext.getResources().getText(strResId), Toast.LENGTH_LONG);
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(CharSequence message, int duration) {
        initToast(message, duration);
    }

    public static void show(CharSequence message) {
        initToast(message, Toast.LENGTH_SHORT);
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(Context context, int strResId, int duration) {
        initToast(context.getResources().getText(strResId), duration);
    }

    /**
     * 显示有image的toast
     *
     * @param tvStr         内容
     * @param imageResource 图片id
     * @return Toast
     */
//    public static Toast showToastWithImg(final String tvStr, final int imageResource) {
//        if (toast2 == null) {
//            toast2 = new Toast(AppLifecyclesImpl.mAppContext);
//        }
//        View view = ArmsUtils.inflate(AppLifecyclesImpl.mAppContext,R.layout.layout_toast);
//        TextView tv = (TextView) view.findViewById(R.id.toast_custom_tv);
//        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
//        ImageView iv = (ImageView) view.findViewById(R.id.toast_custom_iv);
//        if (imageResource > 0) {
//            iv.setVisibility(View.VISIBLE);
//            iv.setImageResource(imageResource);
//        } else {
//            iv.setVisibility(View.GONE);
//        }
//        toast2.setView(view);
//        toast2.setGravity(Gravity.CENTER, 0, 0);
//        toast2.show();
//        return toast2;
//    }
}