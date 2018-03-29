package com.mtm.common_module.device_valid;

/**
 * 设备验证回调
 * @author MtmWp
 * @date 2018-3-27 11:23.
 */

public interface ValidCallBack {
    void onSuccess(String serverUrl);
    void onError(String error);
}
