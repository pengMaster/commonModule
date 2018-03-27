package com.mtm.common_module.utils;

import android.os.Environment;

import com.mtm.common_module.user.User;
import com.mtm.common_module.user.UserModel;


/**
 * Created by mtm on 2017/10/11.
 * 基本常量
 *
 * @author MZP
 */
public class ConstantUtils {

    private static ConstantUtils mInstance;

    //---------常量---------------------------
    /**
     * 0未禁止 1 禁止修改文书
     */
    public final static String PRINT_EDIT_YES = "1";
    /**
     * 用于启动 Activity 判断
     */
    public final static String IS_MYSELF = "IS_MYSELF";


    public synchronized static ConstantUtils i() {
        if (mInstance == null) {
            mInstance = new ConstantUtils();
        }
        return mInstance;
    }
    //---------全局变量-----------------------

    private boolean isUser1Login = false;
    private boolean isUser2Login = false;
    private boolean isAllLogin = false;

    private User user1 = null;
    private User user2 = null;

    private String server;
    private String printerType;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public boolean isUser1Login() {
        return isUser1Login;
    }

    public void setUser1Login(boolean user1Login) {
        isUser1Login = user1Login;
    }

    public boolean isUser2Login() {
        return isUser2Login;
    }

    public void setUser2Login(boolean user2Login) {
        isUser2Login = user2Login;
    }

    public boolean isAllLogin() {
        return isAllLogin;
    }

    public void setAllLogin(boolean allLogin) {
        isAllLogin = allLogin;
    }

    public User getUser1() {
        //获取外部 User
        if (this.user1 == null) {
            user1 = UserModel.i().getUser1();
        }
        return user1;
    }

    public User getUser2() {
        if (this.user2 == null) {
            user2 = UserModel.i().getUser2();
        }
        return user2;
    }

    /**
     * app标识，0：学校卫生评级评价，1：传染病防治综合评价，2：医疗计分
     */
    public final static String APP_FLAG = "APP_FLAG";

    public enum APP_FLAG_VALUE {
        /**
         * 学习评价
         */
        SCHOOL(1, "#03a9f4"),
        /**
         * 传染病防治
         */
        INFECTION(2, "#00bcd4"),
        /**
         * 医疗计分
         */
        MEDICAL(3, "#009688");

        private int key;
        private String parseColor;

        APP_FLAG_VALUE(int key, String parseColor) {
            this.key = key;
            this.parseColor = parseColor;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getParseColor() {
            return parseColor;
        }

        public void setParseColor(String parseColor) {
            this.parseColor = parseColor;
        }

        public static APP_FLAG_VALUE getAppFlagValue(int key) {
            for (APP_FLAG_VALUE data : values()) {
                if (data.getKey() == key) {
                    return data;
                }
            }
            return SCHOOL;
        }
    }

    public static String getCompanyDbPath() {
        return Environment.getExternalStorageDirectory()
                + "/data/com.mtm.mobile/databases/";
    }

    public static String getSchoolDbPath() {
        return Environment.getExternalStorageDirectory()
                + "/data/com.mtm.mgrade.school/databases/";
    }

}