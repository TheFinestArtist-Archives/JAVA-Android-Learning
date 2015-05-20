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
//            DigestItem, DaoSession

public class DigestItemDao extends AbstractDao
{

    public static final String TABLENAME = "DIGEST_ITEM";

    public DigestItemDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public DigestItemDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'DIGEST_ITEM' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'UID' TEXT,'REFER_ID' TEXT,'CONTAINER_TYPE' TEXT,'DESCRIPTION' TEXT,'DESCRIPTION_ARGS' TEXT,'TOTAL_PINS' INTEGER,'USER_UID' TEXT,'BOARD_UID' TEXT,'INTEREST_UID' TEXT,'LARGE_PIN' INTEGER,'ENUM_TYPE' INTEGER);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'DIGEST_ITEM'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, DigestItem digestitem)
    {
        sqlitestatement.clearBindings();
        Object obj = digestitem.getId();
        if (obj != null)
        {
            sqlitestatement.bindLong(1, ((Long) (obj)).longValue());
        }
        obj = digestitem.getUid();
        if (obj != null)
        {
            sqlitestatement.bindString(2, ((String) (obj)));
        }
        obj = digestitem.getReferId();
        if (obj != null)
        {
            sqlitestatement.bindString(3, ((String) (obj)));
        }
        obj = digestitem.getContainerType();
        if (obj != null)
        {
            sqlitestatement.bindString(4, ((String) (obj)));
        }
        obj = digestitem.getDescription();
        if (obj != null)
        {
            sqlitestatement.bindString(5, ((String) (obj)));
        }
        obj = digestitem.getDescriptionArgs();
        if (obj != null)
        {
            sqlitestatement.bindString(6, ((String) (obj)));
        }
        obj = digestitem.getTotalPins();
        if (obj != null)
        {
            sqlitestatement.bindLong(7, ((Integer) (obj)).intValue());
        }
        obj = digestitem.getUserUid();
        if (obj != null)
        {
            sqlitestatement.bindString(8, ((String) (obj)));
        }
        obj = digestitem.getBoardUid();
        if (obj != null)
        {
            sqlitestatement.bindString(9, ((String) (obj)));
        }
        obj = digestitem.getInterestUid();
        if (obj != null)
        {
            sqlitestatement.bindString(10, ((String) (obj)));
        }
        obj = digestitem.getLargePin();
        if (obj != null)
        {
            long l;
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(11, l);
        }
        digestitem = digestitem.getEnumType();
        if (digestitem != null)
        {
            sqlitestatement.bindLong(12, digestitem.intValue());
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (DigestItem)obj);
    }

    public Long getKey(DigestItem digestitem)
    {
        if (digestitem != null)
        {
            return digestitem.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((DigestItem)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public DigestItem readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        Integer integer;
        String s5;
        String s6;
        String s7;
        Boolean boolean1;
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
        if (cursor.isNull(i + 2))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 2);
        }
        if (cursor.isNull(i + 3))
        {
            s2 = null;
        } else
        {
            s2 = cursor.getString(i + 3);
        }
        if (cursor.isNull(i + 4))
        {
            s3 = null;
        } else
        {
            s3 = cursor.getString(i + 4);
        }
        if (cursor.isNull(i + 5))
        {
            s4 = null;
        } else
        {
            s4 = cursor.getString(i + 5);
        }
        if (cursor.isNull(i + 6))
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(cursor.getInt(i + 6));
        }
        if (cursor.isNull(i + 7))
        {
            s5 = null;
        } else
        {
            s5 = cursor.getString(i + 7);
        }
        if (cursor.isNull(i + 8))
        {
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 8);
        }
        if (cursor.isNull(i + 9))
        {
            s7 = null;
        } else
        {
            s7 = cursor.getString(i + 9);
        }
        if (cursor.isNull(i + 10))
        {
            boolean1 = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
        }
        if (cursor.isNull(i + 11))
        {
            cursor = null;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 11));
        }
        return new DigestItem(long1, s, s1, s2, s3, s4, integer, s5, s6, s7, boolean1, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, DigestItem digestitem, int i)
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
        digestitem.setId(((Long) (obj)));
        if (cursor.isNull(i + 1))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 1);
        }
        digestitem.setUid(((String) (obj)));
        if (cursor.isNull(i + 2))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 2);
        }
        digestitem.setReferId(((String) (obj)));
        if (cursor.isNull(i + 3))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 3);
        }
        digestitem.setContainerType(((String) (obj)));
        if (cursor.isNull(i + 4))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 4);
        }
        digestitem.setDescription(((String) (obj)));
        if (cursor.isNull(i + 5))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 5);
        }
        digestitem.setDescriptionArgs(((String) (obj)));
        if (cursor.isNull(i + 6))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 6));
        }
        digestitem.setTotalPins(((Integer) (obj)));
        if (cursor.isNull(i + 7))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 7);
        }
        digestitem.setUserUid(((String) (obj)));
        if (cursor.isNull(i + 8))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 8);
        }
        digestitem.setBoardUid(((String) (obj)));
        if (cursor.isNull(i + 9))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 9);
        }
        digestitem.setInterestUid(((String) (obj)));
        if (cursor.isNull(i + 10))
        {
            obj = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = Boolean.valueOf(flag);
        }
        digestitem.setLargePin(((Boolean) (obj)));
        if (cursor.isNull(i + 11))
        {
            cursor = obj1;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 11));
        }
        digestitem.setEnumType(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (DigestItem)obj, i);
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

    protected Long updateKeyAfterInsert(DigestItem digestitem, long l)
    {
        digestitem.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((DigestItem)obj, l);
    }
}
