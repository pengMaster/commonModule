package com.mtm.common_module.greendao;

import com.greendao.gen.DaoMaster;
import com.greendao.gen.DaoSession;
import com.greendao.gen.RecentUnitDao;
import com.mtm.common_module.recent_unit.RecentUnit;

import java.util.List;

/**
 * UserDao 管理
 * Description
 *
 * @author yangcc
 * @date 2017/11/24
 */
public class GreenDaoManager {
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static String dbName;

    private GreenDaoManager() {

    }

    /**
     * 静态内部类，实例化对象使用
     */
    private static class SingleInstanceHolder {
        private static final GreenDaoManager INSTANCE = new GreenDaoManager();
    }

    /**
     * 对外唯一实例的接口
     *
     * @param db 数据库名
     * @return GreenDaoManager
     */
    public static GreenDaoManager getInstance(String db) {
        dbName = db;
        init();
        return SingleInstanceHolder.INSTANCE;
    }

    /**
     * 初始化数据
     */
    private static void init() {
        MySQLiteOpenHelper devOpenHelper = new MySQLiteOpenHelper(new GreenDaoContext(), dbName, null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getmDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }


    /**
     * 获取最近单位
     * @param specCode
     * @return
     * @throws Exception
     */
    public List<RecentUnit> loadAllBySpecCode(String specCode) throws Exception {
        return mDaoSession.getRecentUnitDao().queryBuilder().where(RecentUnitDao.Properties.SpecCode.eq(specCode)).list();
    }


    /**
     * 添加单位
     * @param note
     * @return
     * @throws Exception
     */
    public long add(RecentUnit note) throws Exception {
        delete(note);
        return mDaoSession.insertOrReplace(note);
    }

    /**
     * 更新单位
     * @param note
     * @throws Exception
     */
    public void update(RecentUnit note) throws Exception {
        mDaoSession.update(note);
    }

    /**
     * 删除单位
     * @param note
     * @throws Exception
     */
    public void delete(RecentUnit note) throws Exception {
        mDaoSession.delete(note);
    }
}
