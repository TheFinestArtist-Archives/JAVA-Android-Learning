// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import java.util.Date;

// Referenced classes of package com.pinterest.api.model:
//            ConversationMessage, DaoSession

public class ConversationMessageDao extends AbstractDao
{

    public static final String TABLENAME = "CONVERSATION_MESSAGE";

    public ConversationMessageDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public ConversationMessageDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'CONVERSATION_MESSAGE' ('UID' TEXT PRIMARY KEY NOT NULL ,'CONVERSATION_ID' TEXT,'SENDER_ID' TEXT,'PIN_ID' TEXT,'BOARD_ID' TEXT,'USER_ID' TEXT,'TEXT' TEXT,'CREATED_AT' INTEGER);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'CONVERSATION_MESSAGE'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, ConversationMessage conversationmessage)
    {
        sqlitestatement.clearBindings();
        String s = conversationmessage.getUid();
        if (s != null)
        {
            sqlitestatement.bindString(1, s);
        }
        s = conversationmessage.getConversationId();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        s = conversationmessage.getSenderId();
        if (s != null)
        {
            sqlitestatement.bindString(3, s);
        }
        s = conversationmessage.getPinId();
        if (s != null)
        {
            sqlitestatement.bindString(4, s);
        }
        s = conversationmessage.getBoardId();
        if (s != null)
        {
            sqlitestatement.bindString(5, s);
        }
        s = conversationmessage.getUserId();
        if (s != null)
        {
            sqlitestatement.bindString(6, s);
        }
        s = conversationmessage.getText();
        if (s != null)
        {
            sqlitestatement.bindString(7, s);
        }
        conversationmessage = conversationmessage.getCreatedAt();
        if (conversationmessage != null)
        {
            sqlitestatement.bindLong(8, conversationmessage.getTime());
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (ConversationMessage)obj);
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((ConversationMessage)obj);
    }

    public String getKey(ConversationMessage conversationmessage)
    {
        if (conversationmessage != null)
        {
            return conversationmessage.getUid();
        } else
        {
            return null;
        }
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public ConversationMessage readEntity(Cursor cursor, int i)
    {
        Object obj = null;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
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
            s3 = null;
        } else
        {
            s3 = cursor.getString(i + 3);
        }
        if (cursor.isNull(i + 4))
        {
            s4 = null;
        } else
        {
            s4 = cursor.getString(i + 4);
        }
        if (cursor.isNull(i + 5))
        {
            s5 = null;
        } else
        {
            s5 = cursor.getString(i + 5);
        }
        if (cursor.isNull(i + 6))
        {
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 6);
        }
        if (cursor.isNull(i + 7))
        {
            cursor = obj;
        } else
        {
            cursor = new Date(cursor.getLong(i + 7));
        }
        return new ConversationMessage(s, s1, s2, s3, s4, s5, s6, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, ConversationMessage conversationmessage, int i)
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
        conversationmessage.setUid(s);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        conversationmessage.setConversationId(s);
        if (cursor.isNull(i + 2))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 2);
        }
        conversationmessage.setSenderId(s);
        if (cursor.isNull(i + 3))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 3);
        }
        conversationmessage.setPinId(s);
        if (cursor.isNull(i + 4))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 4);
        }
        conversationmessage.setBoardId(s);
        if (cursor.isNull(i + 5))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 5);
        }
        conversationmessage.setUserId(s);
        if (cursor.isNull(i + 6))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 6);
        }
        conversationmessage.setText(s);
        if (cursor.isNull(i + 7))
        {
            cursor = obj;
        } else
        {
            cursor = new Date(cursor.getLong(i + 7));
        }
        conversationmessage.setCreatedAt(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (ConversationMessage)obj, i);
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
        return updateKeyAfterInsert((ConversationMessage)obj, l);
    }

    protected String updateKeyAfterInsert(ConversationMessage conversationmessage, long l)
    {
        return conversationmessage.getUid();
    }
}
