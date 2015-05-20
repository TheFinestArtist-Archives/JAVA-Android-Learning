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
//            Conversation, DaoSession

public class ConversationDao extends AbstractDao
{

    public static final String TABLENAME = "CONVERSATION";

    public ConversationDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public ConversationDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'CONVERSATION' ('UID' TEXT PRIMARY KEY NOT NULL ,'USERS' TEXT,'EMAILS' TEXT,'UNREAD' INTEGER);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'CONVERSATION'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Conversation conversation)
    {
        sqlitestatement.clearBindings();
        String s = conversation.getUid();
        if (s != null)
        {
            sqlitestatement.bindString(1, s);
        }
        s = conversation.getUsers();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        s = conversation.getEmails();
        if (s != null)
        {
            sqlitestatement.bindString(3, s);
        }
        conversation = conversation.getUnread();
        if (conversation != null)
        {
            sqlitestatement.bindLong(4, conversation.intValue());
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Conversation)obj);
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Conversation)obj);
    }

    public String getKey(Conversation conversation)
    {
        if (conversation != null)
        {
            return conversation.getUid();
        } else
        {
            return null;
        }
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Conversation readEntity(Cursor cursor, int i)
    {
        Object obj = null;
        String s;
        String s1;
        String s2;
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
            s2 = null;
        } else
        {
            s2 = cursor.getString(i + 2);
        }
        if (cursor.isNull(i + 3))
        {
            cursor = obj;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 3));
        }
        return new Conversation(s, s1, s2, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Conversation conversation, int i)
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
        conversation.setUid(s);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        conversation.setUsers(s);
        if (cursor.isNull(i + 2))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 2);
        }
        conversation.setEmails(s);
        if (cursor.isNull(i + 3))
        {
            cursor = obj;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 3));
        }
        conversation.setUnread(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Conversation)obj, i);
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
        return updateKeyAfterInsert((Conversation)obj, l);
    }

    protected String updateKeyAfterInsert(Conversation conversation, long l)
    {
        return conversation.getUid();
    }
}
