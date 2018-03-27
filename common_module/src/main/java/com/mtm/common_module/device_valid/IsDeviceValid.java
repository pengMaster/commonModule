package com.mtm.common_module.device_valid;

import android.content.Context;

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

    public void isDeviceValid(final String baseUrl, final LoginUtils.LoadMode isTestIn,
                              final Context context,final ValidCallBack validCallBack){
        LoginUtils.i().baseUrl = baseUrl;
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        //验证设备有效性
                        LoginUtils.i().setOnInitDeviceValidCallListener(new LoginUtils.OnInitDeviceValidCallListener() {

                            @Override
                            public void onSuccess(String serverUrl) {
                                validCallBack.onSuccess(serverUrl);
                            }

                            @Override
                            public void onError(String error) {
                                validCallBack.onError(error);
                            }

                        }).initDeviceValid(isTestIn, context);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        validCallBack.onError(s);
                    }
                });
    }
}
