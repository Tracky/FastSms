package com.example.fastsms.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.Serializable;
import java.sql.SQLException;

public class DbHelper extends OrmLiteSqliteOpenHelper implements Serializable {
    private Dao<Contacts, Integer> dao = null;

    private Context context;

    public DbHelper(Context context) {
        super(context, "SmartPhone", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Contacts.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Contacts.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Contacts, Integer> getDao() throws SQLException {
        if (dao == null) {
            dao = getDao(Contacts.class);
        }
        return dao;
    }
}
