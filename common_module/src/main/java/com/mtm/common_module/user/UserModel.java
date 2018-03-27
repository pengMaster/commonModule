package com.mtm.common_module.user;

import com.greendao.gen.UserDao;
import com.mtm.common_module.greendao.GreenDaoManager;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * class
 * Description
 *
 * @author yangcc
 * @date 2017/11/24
 */
public class UserModel {
    private static UserModel userModel;
    private UserDao userDao;

    private UserModel() {
    }

    public static UserModel i() {
        if (userModel == null) {
            userModel = new UserModel();
            userModel.getUserDao();
        }
        return userModel;
    }

    private UserDao getUserDao() {
        if (userDao == null) {
            userDao = GreenDaoManager.getInstance().getmDaoSession().getUserDao();
        }
        return userDao;
    }

    public List<User> getUser(String sort) {
        Query query = userDao.queryBuilder().where(
                UserDao.Properties.Sort.eq(sort))
                .build();
        List<User> list = query.list();
        return list;
    }

    public User getUser1() {
        List<User> list = getUser("1");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public User getUser2() {
        List<User> list = getUser("2");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 保存用户
     * @param user
     */
    public void saveUser(User user){
        userDao.delete(user);
        userDao.insertOrReplace(user);
    }
    /**
     * 删除用户
     * @param user
     */
    public void deleteUser(User user){
        userDao.delete(user);
    }
    /**
     * 获取用户级别
     *
     * @return用户级别
     */
    public String getLevelCode(){
        String userLevel = getUser1().getUserLevel();
        String busPcode="";
        switch (userLevel) {
            case "1":
                busPcode =  getUser1().getCountryCode();
                break;
            case "2":
                busPcode =  getUser1().getProvinceCode();
                break;
            case "3":
                busPcode =  getUser1().getCityCode();
                break;
            case "4":
                busPcode =  getUser1().getDistrictCode();
                break;
        }
        return busPcode;
    }

    /**
     * 监督员1/2均登录:true
     *
     * @return
     */
    public boolean isLogin(){
        if (null == getUser1() || null == getUser2()) {
            return false;
        }
        return true;
    }

}
