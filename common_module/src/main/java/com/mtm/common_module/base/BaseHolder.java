package com.mtm.common_module.base;

import android.view.View;

/**
 * ******************************************************************
 * Created by MTM on 2016/11/20.
 * Description: Holder 基类
 * Android:minSdkVersion: API
 * Author:mzp
 * Version:V1.0
 * ******************************************************************
 */

public abstract class BaseHolder<Data> {
    protected View mRootView;
    protected int mPosition;
    protected Data mData;

    public BaseHolder() {
        mRootView = initView();
        mRootView.setTag(this);
    }

    public View getRootView() {
        return mRootView;
    }

    public void setData(Data data) {
        mData = data;
        refreshView();
    }

    public Data getData() {
        return mData;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public int getPosition() {
        return mPosition;
    }


    /**
     * 子类必须覆盖用于实现UI初始化
     */
    protected abstract View initView();

    /**
     * 子类必须覆盖用于实现UI刷新
     */
    public abstract void refreshView();

}
