// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;

// Referenced classes of package com.pinterest.api.model:
//            Notification, DaoSession

public class NotificationDao extends AbstractDao
{

    public static final String TABLENAME = "NOTIFICATION";

    public NotificationDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public NotificationDao(DaoConfig daoconfig, DaoSession daosession)
    {
        super(daoconfig, daosession);
    }

    public static void createTable(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        String s;
        if (flag)
        {
            s = "IF NOT EXISTS ";
        } else
        {
            s = "";
        }
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'NOTIFICATION' ('UID' TEXT PRIMARY KEY NOT NULL ,'STYLE' TEXT,'SECTIONS_JSON' TEXT);").toString());
    }

    public static void dropTable(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder("DROP TABLE ");
        String s;
        if (flag)
        {
            s = "IF EXISTS ";
        } else
        {
            s = "";
        }
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'NOTIFICATION'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Notification notification)
    {
        sqlitestatement.clearBindings();
        String s = notification.getUid();
        if (s != null)
        {
            sqlitestatement.bindString(1, s);
        }
        s = notification.getStyle();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        notification = notification.getSectionsJson();
        if (notification != null)
        {
            sqlitestatement.bindString(3, notification);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Notification)obj);
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Notification)obj);
    }

    public String getKey(Notification notification)
    {
        if (notification != null)
        {
            return notification.getUid();
        } else
        {
            return null;
        }
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Notification readEntity(Cursor cursor, int i)
    {
        Object obj = null;
        String s;
        String s1;
        if (cursor.isNull(i + 0))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 0);
        }
        if (cursor.isNull(i + 1))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 1);
        }
        if (cursor.isNull(i + 2))
        {
            cursor = obj;
        } else
        {
            cursor = cursor.getString(i + 2);
        }
        return new Notification(s, s1, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Notification notification, int i)
    {
        Object obj = null;
        String s;
        if (cursor.isNull(i + 0))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 0);
        }
        notification.setUid(s);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        notification.setStyle(s);
        if (cursor.isNull(i + 2))
        {
            cursor = obj;
        } else
        {
            cursor = cursor.getString(i + 2);
        }
        notification.setSectionsJson(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Notification)obj, i);
    }

    public volatile Object readKey(Cursor cursor, int i)
    {
        return readKey(cursor, i);
    }

    public String readKey(Cursor cursor, int i)
    {
        if (cursor.isNull(i + 0))
        {
            return null;
        } else
        {
            return cursor.getString(i + 0);
        }
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((Notification)obj, l);
    }

    protected String updateKeyAfterInsert(Notification notification, long l)
    {
        return notification.getUid();
    }
}
