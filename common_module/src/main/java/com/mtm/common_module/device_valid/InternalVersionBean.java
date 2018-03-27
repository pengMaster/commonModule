package com.mtm.common_module.device_valid;

/**
 * ***    ***     **********   ***    ***
 * ****   ****    **********   ****   ****
 * *** *  * ***       ***      *** *  * ***
 * ***  * *  ***      ***      ***  * *  ***
 * ***   **   ***     ***      ***   **   ***
 * ******************************************************************
 * Created by MTM on 2017/7/10.
 * Description: 判断设备有效性Bean
 * Android:minSdkVersion: API
 * Author:mzp
 * Version:V1.0
 * ******************************************************************
 */
public class InternalVersionBean {

    /**
     * internalVersion : 20170619
     * publishTime : 2017-06-19 19:35:52
     * filePath : http://60.247.49.230:7001/mtmdp/download/yyrj/mtmJDZF/mjdzf2_V5.2.6.apk
     * version : V5.2.6
     */

    private String internalVersion;
    private String publishTime;
    private String filePath;
    private String version;

    public String getInternalVersion() {
        return internalVersion;
    }

    public void setInternalVersion(String internalVersion) {
        this.internalVersion = internalVersion;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
