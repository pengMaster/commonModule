package com.mtm.common_module.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.greendao.gen.DaoMaster;


/**
 * class
 * Description
 *
 * @author yangcc
 * @date 2017/11/24
 */
public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据迁移模块
//        MigrationHelper.migrate(db,
//                UserDao.class
////                ,
////                ProfessionDao.class,
////                LTestDao.class
//        );
    }
}
