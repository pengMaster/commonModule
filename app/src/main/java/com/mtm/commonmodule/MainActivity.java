package com.mtm.commonmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jess.arms.utils.LogUtils;
import com.mtm.common_module.device_valid.IsDeviceValid;
import com.mtm.common_module.device_valid.LoginUtils;
import com.mtm.common_module.device_valid.ValidCallBack;
import com.mtm.common_module.user.User;
import com.mtm.common_module.utils.ConstantUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testModule();
    }

    /**
     * 测试用例
     */
    private void testModule() {
        User user1 = ConstantUtils.i().getUser1();
        User user2 = ConstantUtils.i().getUser2();
        LogUtils.debugInfo("user1.getUserName:"+user1.getUserName());
        LogUtils.debugInfo("user2.getUserName:"+user2.getUserName());
        String baseUrl = "http://200.200.202.88:8080/nhis/";
        IsDeviceValid.i().isDeviceValid(baseUrl, LoginUtils.LoadMode.FORMAL,
                MainActivity.this, new ValidCallBack() {
                    @Override
                    public void onSuccess(String serverUrl) {
                        LogUtils.debugInfo("onSuccess:"+serverUrl);
                    }

                    @Override
                    public void onError(String error) {
                        LogUtils.debugInfo("onError:"+error);
                    }
                });
    }
}
