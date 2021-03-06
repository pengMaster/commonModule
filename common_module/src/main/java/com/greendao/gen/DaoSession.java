package com.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.mtm.common_module.recent_unit.RecentUnit;
import com.mtm.common_module.user.User;

import com.greendao.gen.RecentUnitDao;
import com.greendao.gen.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig recentUnitDaoConfig;
    private final DaoConfig userDaoConfig;

    private final RecentUnitDao recentUnitDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        recentUnitDaoConfig = daoConfigMap.get(RecentUnitDao.class).clone();
        recentUnitDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        recentUnitDao = new RecentUnitDao(recentUnitDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(RecentUnit.class, recentUnitDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        recentUnitDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public RecentUnitDao getRecentUnitDao() {
        return recentUnitDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
