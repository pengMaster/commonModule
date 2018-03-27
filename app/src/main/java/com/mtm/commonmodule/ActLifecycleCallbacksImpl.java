package com.mtm.commonmodule;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import timber.log.Timber;


public class ActLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        //统一设置主题色   主题设置放在setContentView之前
        Timber.w(activity + " - onActivityCreated");
    }

    @Override
    public void onActivityStarted(final Activity activity) {
        Timber.w(activity + " - onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Timber.w(activity + " - onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Timber.w(activity + " - onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Timber.w(activity + " - onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Timber.w(activity + " - onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Timber.w(activity + " - onActivityDestroyed");
    }
}