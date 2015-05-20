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
//            NotificationTemplate, DaoSession

public class NotificationTemplateDao extends AbstractDao
{

    public static final String TABLENAME = "NOTIFICATION_TEMPLATE";

    public NotificationTemplateDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public NotificationTemplateDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'NOTIFICATION_TEMPLATE' ('UID' TEXT PRIMARY KEY NOT NULL ,'TEMPLATE_STRING' TEXT,'SUBJECTS_JSON' TEXT);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'NOTIFICATION_TEMPLATE'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, NotificationTemplate notificationtemplate)
    {
        sqlitestatement.clearBindings();
        String s = notificationtemplate.getUid();
        if (s != null)
        {
            sqlitestatement.bindString(1, s);
        }
        s = notificationtemplate.getTemplateString();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        notificationtemplate = notificationtemplate.getSubjectsJson();
        if (notificationtemplate != null)
        {
            sqlitestatement.bindString(3, notificationtemplate);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (NotificationTemplate)obj);
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((NotificationTemplate)obj);
    }

    public String getKey(NotificationTemplate notificationtemplate)
    {
        if (notificationtemplate != null)
        {
            return notificationtemplate.getUid();
        } else
        {
            return null;
        }
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public NotificationTemplate readEntity(Cursor cursor, int i)
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
        return new NotificationTemplate(s, s1, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, NotificationTemplate notificationtemplate, int i)
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
        notificationtemplate.setUid(s);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        notificationtemplate.setTemplateString(s);
        if (cursor.isNull(i + 2))
        {
            cursor = obj;
        } else
        {
            cursor = cursor.getString(i + 2);
        }
        notificationtemplate.setSubjectsJson(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (NotificationTemplate)obj, i);
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
        return updateKeyAfterInsert((NotificationTemplate)obj, l);
    }

    protected String updateKeyAfterInsert(NotificationTemplate notificationtemplate, long l)
    {
        return notificationtemplate.getUid();
    }
}
