package com.mtm.common_module.device_valid;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.jess.arms.integration.AppManager;
import com.mtm.common_module.config.InitApplicationContext;
import com.mtm.common_module.utils.UIUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 设备验证
 * @author MtmWp
 * @date 2018-3-27 11:13.
 */

public class IsDeviceValid {

    private static IsDeviceValid instance;

    public static IsDeviceValid i() {
        if (instance == null) {
            instance = new IsDeviceValid();
        }
        return instance;
    }

    /**
     * 验证设备是否有效
     *
     * @param baseUrl 请求地址
     * @param isTestIn 是否为测试
     * @param context 上下文
     * @param validCallBack 回调
     */
    public void isDeviceValid(final String baseUrl, final LoginUtils.LoadMode isTestIn,
                              final Context context,final ValidCallBack validCallBack){
        LoginUtils.i().baseUrl = baseUrl;
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(final ObservableEmitter<String> e) throws Exception {
                        //验证设备有效性
                        LoginUtils.i().setOnInitDeviceValidCallListener(new LoginUtils.OnInitDeviceValidCallListener() {

                            @Override
                            public void onSuccess(String serverUrl) {
                                e.onNext(serverUrl);
                                e.onComplete();
                            }

                            @Override
                            public void onError(final String title, final String content) {
                                UIUtils.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        showInfoDialog(context,title,content);
                                    }
                                });

                            }

                        }).initDeviceValid(isTestIn, context);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        validCallBack.onSuccess(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        validCallBack.onError(throwable.getMessage());
                    }
                });
    }

    /**
     * 提示用户无法进入Dialog
     */
    public static void showInfoDialog(Context context, String title, String content) {
        new AlertDialog.Builder(context).setTitle(title)
                .setMessage(content).setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        new AppManager((Application) InitApplicationContext.mAppContext).killAll();
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);
                    }
                }).show();
    }
}
