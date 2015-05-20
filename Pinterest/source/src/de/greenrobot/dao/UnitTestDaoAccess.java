// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Constructor;

// Referenced classes of package de.greenrobot.dao:
//            DaoConfig, AbstractDao, IdentityScope, Property

public class UnitTestDaoAccess
{

    private final AbstractDao dao;

    public UnitTestDaoAccess(SQLiteDatabase sqlitedatabase, Class class1, IdentityScope identityscope)
    {
        sqlitedatabase = new DaoConfig(sqlitedatabase, class1);
        sqlitedatabase.setIdentityScope(identityscope);
        dao = (AbstractDao)class1.getConstructor(new Class[] {
            de/greenrobot/dao/DaoConfig
        }).newInstance(new Object[] {
            sqlitedatabase
        });
    }

    public AbstractDao getDao()
    {
        return dao;
    }

    public Object getKey(Object obj)
    {
        return dao.getKey(obj);
    }

    public Property[] getProperties()
    {
        return dao.getProperties();
    }

    public boolean isEntityUpdateable()
    {
        return dao.isEntityUpdateable();
    }

    public Object readEntity(Cursor cursor, int i)
    {
        return dao.readEntity(cursor, i);
    }

    public Object readKey(Cursor cursor, int i)
    {
        return dao.readKey(cursor, i);
    }
}
