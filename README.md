策略模式


案例:计算车费

- ## 功能简介
   - 封装设备验证
   - 封装用户信息
   - 封装Base类
   - 封装常用Utils类

- ## 使用方法
    ### 1.Add it in your root build.gradle
    ```java
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    ```
     ### 2.Add it in your App build.gradle 
    ```java
    dependencies {
        compile 'com.github.pengMaster:commonModule:v1.1'
    }
    ``` 
    
     ### 3.App下AndroidManifest.xml中添加权限 
    ```java
    <!-- 写入扩展存储，向扩展卡写入数据，用于写入离线定位数据 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <!-- 访问网络，网络定位需要上网 -->
    <uses-permission android:name="android.permission.INTERNET" />

    ```    

     ### 4.在App的Application下初始化 
    ```java
        InitApplicationContext.i().initContext(mAppContext);
    ```    

- ## 功能

    ### 1.获取用户
    ```java
        //----------------- 用户1 ---------------
        User user1 = ConstantUtils.i().getUser1();
        //----------------- 用户2 ---------------
        User user2 = ConstantUtils.i().getUser2();
    ```
    
    ### 1.设备验证
    ```java
        String baseUrl = "http://200.200.********/nhis/";
        IsDeviceValid.i().isDeviceValid(baseUrl, LoginUtils.LoadMode.FORMAL,
                MainActivity.this, new ValidCallBack() {
                    @Override
                    public void onSuccess(String serverUrl) {
                        //验证成功
                        LogUtils.debugInfo("onSuccess:"+serverUrl);
                    }

                    @Override
                    public void onError(String error) {
                        //验证失败
                        LogUtils.debugInfo("onError:"+error);
                    }
                });
    ```
    
    ### 3.Base类以及Utils类直接调取使用
    
    
    注: [github地址:https://github.com/pengMaster/commonModule](https://github.com/pengMaster/commonModule)

