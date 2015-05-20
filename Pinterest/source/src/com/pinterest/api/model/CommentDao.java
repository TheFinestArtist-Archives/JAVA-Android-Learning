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
//            Comment, DaoSession

public class CommentDao extends AbstractDao
{

    public static final String TABLENAME = "COMMENT";

    public CommentDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public CommentDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'COMMENT' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'UID' TEXT,'USER_UID' TEXT NOT NULL ,'PIN_UID' TEXT NOT NULL ,'TEXT' TEXT,'CREATED_AT' INTEGER);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'COMMENT'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Comment comment)
    {
        sqlitestatement.clearBindings();
        Object obj = comment.getId();
        if (obj != null)
        {
            sqlitestatement.bindLong(1, ((Long) (obj)).longValue());
        }
        obj = comment.getUid();
        if (obj != null)
        {
            sqlitestatement.bindString(2, ((String) (obj)));
        }
        sqlitestatement.bindString(3, comment.getUserUid());
        sqlitestatement.bindString(4, comment.getPinUid());
        obj = comment.getText();
        if (obj != null)
        {
            sqlitestatement.bindString(5, ((String) (obj)));
        }
        comment = comment.getCreatedAt();
        if (comment != null)
        {
            sqlitestatement.bindLong(6, comment.getTime());
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Comment)obj);
    }

    public Long getKey(Comment comment)
    {
        if (comment != null)
        {
            return comment.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Comment)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Comment readEntity(Cursor cursor, int i)
    {
        Object obj = null;
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        if (cursor.isNull(i + 0))
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(cursor.getLong(i + 0));
        }
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        s2 = cursor.getString(i + 2);
        s3 = cursor.getString(i + 3);
        if (cursor.isNull(i + 4))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 4);
        }
        if (cursor.isNull(i + 5))
        {
            cursor = obj;
        } else
        {
            cursor = new Date(cursor.getLong(i + 5));
        }
        return new Comment(long1, s, s2, s3, s1, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Comment comment, int i)
    {
        Object obj1 = null;
        Object obj;
        if (cursor.isNull(i + 0))
        {
            obj = null;
        } else
        {
            obj = Long.valueOf(cursor.getLong(i + 0));
        }
        comment.setId(((Long) (obj)));
        if (cursor.isNull(i + 1))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 1);
        }
        comment.setUid(((String) (obj)));
        comment.setUserUid(cursor.getString(i + 2));
        comment.setPinUid(cursor.getString(i + 3));
        if (cursor.isNull(i + 4))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 4);
        }
        comment.setText(((String) (obj)));
        if (cursor.isNull(i + 5))
        {
            cursor = obj1;
        } else
        {
            cursor = new Date(cursor.getLong(i + 5));
        }
        comment.setCreatedAt(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Comment)obj, i);
    }

    public Long readKey(Cursor cursor, int i)
    {
        if (cursor.isNull(i + 0))
        {
            return null;
        } else
        {
            return Long.valueOf(cursor.getLong(i + 0));
        }
    }

    public volatile Object readKey(Cursor cursor, int i)
    {
        return readKey(cursor, i);
    }

    protected Long updateKeyAfterInsert(Comment comment, long l)
    {
        comment.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((Comment)obj, l);
    }
}
