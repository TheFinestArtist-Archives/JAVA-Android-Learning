// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;
import de.greenrobot.dao.DbUtils;
import java.util.Random;

public abstract class DbTest extends ApplicationTestCase
{

    protected SQLiteDatabase db;
    protected final boolean inMemory;
    protected Random random;

    public DbTest()
    {
        this(true);
    }

    public DbTest(Class class1, boolean flag)
    {
        super(class1);
        inMemory = flag;
        random = new Random();
    }

    public DbTest(boolean flag)
    {
        this(android/app/Application, flag);
    }

    protected void logTableDump(String s)
    {
        DbUtils.logTableDump(db, s);
    }

    protected void setUp()
    {
        try
        {
            super.setUp();
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        createApplication();
        setUpDb();
    }

    protected void setUpDb()
    {
        if (inMemory)
        {
            db = SQLiteDatabase.create(null);
            return;
        } else
        {
            getApplication().deleteDatabase("test-db");
            db = getApplication().openOrCreateDatabase("test-db", 0, null);
            return;
        }
    }

    protected void tearDown()
    {
        db.close();
        if (!inMemory)
        {
            getApplication().deleteDatabase("test-db");
        }
        super.tearDown();
    }
}
