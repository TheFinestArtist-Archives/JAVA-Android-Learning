// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// Referenced classes of package de.greenrobot.dao.test:
//            DbTest

public abstract class AbstractDaoSessionTest extends DbTest
{

    protected AbstractDaoMaster daoMaster;
    private final Class daoMasterClass;
    protected AbstractDaoSession daoSession;

    public AbstractDaoSessionTest(Class class1)
    {
        this(class1, true);
    }

    public AbstractDaoSessionTest(Class class1, Class class2, boolean flag)
    {
        super(class1, flag);
        daoMasterClass = class2;
    }

    public AbstractDaoSessionTest(Class class1, boolean flag)
    {
        super(flag);
        daoMasterClass = class1;
    }

    protected void setUp()
    {
        super.setUp();
        try
        {
            daoMaster = (AbstractDaoMaster)daoMasterClass.getConstructor(new Class[] {
                android/database/sqlite/SQLiteDatabase
            }).newInstance(new Object[] {
                db
            });
            daoMasterClass.getMethod("createAllTables", new Class[] {
                android/database/sqlite/SQLiteDatabase, Boolean.TYPE
            }).invoke(null, new Object[] {
                db, Boolean.valueOf(false)
            });
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Could not prepare DAO session test", exception);
        }
        daoSession = daoMaster.newSession();
    }
}
