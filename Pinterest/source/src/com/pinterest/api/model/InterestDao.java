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
//            Interest, DaoSession

public class InterestDao extends AbstractDao
{

    public static final String TABLENAME = "INTEREST";

    public InterestDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public InterestDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'INTEREST' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'UID' TEXT,'KEY' TEXT,'NAME' TEXT,'URL_NAME' TEXT,'IMAGE_SIGNATURE' TEXT,'DOMINANT_COLOR' TEXT,'FOLLOWING' INTEGER,'FEED_UPDATED_TIME' INTEGER,'PINNER_COUNT' INTEGER,'IMAGE_SMALL_URL' TEXT,'IMAGE_SMALL_WIDTH' INTEGER,'IMAGE_SMALL_HEIGHT' INTEGER,'IMAGE_HEADER_URL' TEXT,'IMAGE_HEADER_WIDTH' INTEGER,'IMAGE_HEADER_HEIGHT' INTEGER,'IMAGE_GRID_MED1_LINE_URL' TEXT,'IMAGE_GRID_MED1_LINE_WIDTH' INTEGER,'IMAGE_GRID_MED1_LINE_HEIGHT' INTEGER,'IMAGE_GRID_MED2_LINE_URL' TEXT,'IMAGE_GRID_MED2_LINE_WIDTH' INTEGER,'IMAGE_GRID_MED2_LINE_HEIGHT' INTEGER,'IMAGE_GRID_MED4_LINE_URL' TEXT,'IMAGE_GRID_MED4_LINE_WIDTH' INTEGER,'IMAGE_GRID_MED4_LINE_HEIGHT' INTEGER,'IMAGE_GRID_LG2_LINE_URL' TEXT,'IMAGE_GRID_LG2_LINE_WIDTH' INTEGER,'IMAGE_GRID_LG2_LINE_HEIGHT' INTEGER,'IMAGE_GRID_LG4_LINE_URL' TEXT,'IMAGE_GRID_LG4_LINE_WIDTH' INTEGER,'IMAGE_GRID_LG4_LINE_HEIGHT' INTEGER);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'INTEREST'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Interest interest)
    {
        sqlitestatement.clearBindings();
        Object obj = interest.getId();
        if (obj != null)
        {
            sqlitestatement.bindLong(1, ((Long) (obj)).longValue());
        }
        obj = interest.getUid();
        if (obj != null)
        {
            sqlitestatement.bindString(2, ((String) (obj)));
        }
        obj = interest.getKey();
        if (obj != null)
        {
            sqlitestatement.bindString(3, ((String) (obj)));
        }
        obj = interest.getName();
        if (obj != null)
        {
            sqlitestatement.bindString(4, ((String) (obj)));
        }
        obj = interest.getUrlName();
        if (obj != null)
        {
            sqlitestatement.bindString(5, ((String) (obj)));
        }
        obj = interest.getImageSignature();
        if (obj != null)
        {
            sqlitestatement.bindString(6, ((String) (obj)));
        }
        obj = interest.getDominantColor();
        if (obj != null)
        {
            sqlitestatement.bindString(7, ((String) (obj)));
        }
        obj = interest.getFollowing();
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
            sqlitestatement.bindLong(8, l);
        }
        obj = interest.getFeedUpdatedTime();
        if (obj != null)
        {
            sqlitestatement.bindLong(9, ((Date) (obj)).getTime());
        }
        obj = interest.getPinnerCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(10, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageSmallUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(11, ((String) (obj)));
        }
        obj = interest.getImageSmallWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(12, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageSmallHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(13, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageHeaderUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(14, ((String) (obj)));
        }
        obj = interest.getImageHeaderWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(15, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageHeaderHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(16, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed1LineUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(17, ((String) (obj)));
        }
        obj = interest.getImageGridMed1LineWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(18, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed1LineHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(19, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed2LineUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(20, ((String) (obj)));
        }
        obj = interest.getImageGridMed2LineWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(21, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed2LineHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(22, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed4LineUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(23, ((String) (obj)));
        }
        obj = interest.getImageGridMed4LineWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(24, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridMed4LineHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(25, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridLg2LineUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(26, ((String) (obj)));
        }
        obj = interest.getImageGridLg2LineWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(27, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridLg2LineHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(28, ((Integer) (obj)).intValue());
        }
        obj = interest.getImageGridLg4LineUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(29, ((String) (obj)));
        }
        obj = interest.getImageGridLg4LineWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(30, ((Integer) (obj)).intValue());
        }
        interest = interest.getImageGridLg4LineHeight();
        if (interest != null)
        {
            sqlitestatement.bindLong(31, interest.intValue());
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Interest)obj);
    }

    public Long getKey(Interest interest)
    {
        if (interest != null)
        {
            return interest.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Interest)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Interest readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Boolean boolean1;
        Date date;
        Integer integer;
        String s6;
        Integer integer1;
        Integer integer2;
        String s7;
        Integer integer3;
        Integer integer4;
        String s8;
        Integer integer5;
        Integer integer6;
        String s9;
        Integer integer7;
        Integer integer8;
        String s10;
        Integer integer9;
        Integer integer10;
        String s11;
        Integer integer11;
        Integer integer12;
        String s12;
        Integer integer13;
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
            s5 = null;
        } else
        {
            s5 = cursor.getString(i + 6);
        }
        if (cursor.isNull(i + 7))
        {
            boolean1 = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 7) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
        }
        if (cursor.isNull(i + 8))
        {
            date = null;
        } else
        {
            date = new Date(cursor.getLong(i + 8));
        }
        if (cursor.isNull(i + 9))
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(cursor.getInt(i + 9));
        }
        if (cursor.isNull(i + 10))
        {
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 10);
        }
        if (cursor.isNull(i + 11))
        {
            integer1 = null;
        } else
        {
            integer1 = Integer.valueOf(cursor.getInt(i + 11));
        }
        if (cursor.isNull(i + 12))
        {
            integer2 = null;
        } else
        {
            integer2 = Integer.valueOf(cursor.getInt(i + 12));
        }
        if (cursor.isNull(i + 13))
        {
            s7 = null;
        } else
        {
            s7 = cursor.getString(i + 13);
        }
        if (cursor.isNull(i + 14))
        {
            integer3 = null;
        } else
        {
            integer3 = Integer.valueOf(cursor.getInt(i + 14));
        }
        if (cursor.isNull(i + 15))
        {
            integer4 = null;
        } else
        {
            integer4 = Integer.valueOf(cursor.getInt(i + 15));
        }
        if (cursor.isNull(i + 16))
        {
            s8 = null;
        } else
        {
            s8 = cursor.getString(i + 16);
        }
        if (cursor.isNull(i + 17))
        {
            integer5 = null;
        } else
        {
            integer5 = Integer.valueOf(cursor.getInt(i + 17));
        }
        if (cursor.isNull(i + 18))
        {
            integer6 = null;
        } else
        {
            integer6 = Integer.valueOf(cursor.getInt(i + 18));
        }
        if (cursor.isNull(i + 19))
        {
            s9 = null;
        } else
        {
            s9 = cursor.getString(i + 19);
        }
        if (cursor.isNull(i + 20))
        {
            integer7 = null;
        } else
        {
            integer7 = Integer.valueOf(cursor.getInt(i + 20));
        }
        if (cursor.isNull(i + 21))
        {
            integer8 = null;
        } else
        {
            integer8 = Integer.valueOf(cursor.getInt(i + 21));
        }
        if (cursor.isNull(i + 22))
        {
            s10 = null;
        } else
        {
            s10 = cursor.getString(i + 22);
        }
        if (cursor.isNull(i + 23))
        {
            integer9 = null;
        } else
        {
            integer9 = Integer.valueOf(cursor.getInt(i + 23));
        }
        if (cursor.isNull(i + 24))
        {
            integer10 = null;
        } else
        {
            integer10 = Integer.valueOf(cursor.getInt(i + 24));
        }
        if (cursor.isNull(i + 25))
        {
            s11 = null;
        } else
        {
            s11 = cursor.getString(i + 25);
        }
        if (cursor.isNull(i + 26))
        {
            integer11 = null;
        } else
        {
            integer11 = Integer.valueOf(cursor.getInt(i + 26));
        }
        if (cursor.isNull(i + 27))
        {
            integer12 = null;
        } else
        {
            integer12 = Integer.valueOf(cursor.getInt(i + 27));
        }
        if (cursor.isNull(i + 28))
        {
            s12 = null;
        } else
        {
            s12 = cursor.getString(i + 28);
        }
        if (cursor.isNull(i + 29))
        {
            integer13 = null;
        } else
        {
            integer13 = Integer.valueOf(cursor.getInt(i + 29));
        }
        if (cursor.isNull(i + 30))
        {
            cursor = null;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 30));
        }
        return new Interest(long1, s, s1, s2, s3, s4, s5, boolean1, date, integer, s6, integer1, integer2, s7, integer3, integer4, s8, integer5, integer6, s9, integer7, integer8, s10, integer9, integer10, s11, integer11, integer12, s12, integer13, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Interest interest, int i)
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
        interest.setId(((Long) (obj)));
        if (cursor.isNull(i + 1))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 1);
        }
        interest.setUid(((String) (obj)));
        if (cursor.isNull(i + 2))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 2);
        }
        interest.setKey(((String) (obj)));
        if (cursor.isNull(i + 3))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 3);
        }
        interest.setName(((String) (obj)));
        if (cursor.isNull(i + 4))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 4);
        }
        interest.setUrlName(((String) (obj)));
        if (cursor.isNull(i + 5))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 5);
        }
        interest.setImageSignature(((String) (obj)));
        if (cursor.isNull(i + 6))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 6);
        }
        interest.setDominantColor(((String) (obj)));
        if (cursor.isNull(i + 7))
        {
            obj = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 7) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = Boolean.valueOf(flag);
        }
        interest.setFollowing(((Boolean) (obj)));
        if (cursor.isNull(i + 8))
        {
            obj = null;
        } else
        {
            obj = new Date(cursor.getLong(i + 8));
        }
        interest.setFeedUpdatedTime(((Date) (obj)));
        if (cursor.isNull(i + 9))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 9));
        }
        interest.setPinnerCount(((Integer) (obj)));
        if (cursor.isNull(i + 10))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 10);
        }
        interest.setImageSmallUrl(((String) (obj)));
        if (cursor.isNull(i + 11))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 11));
        }
        interest.setImageSmallWidth(((Integer) (obj)));
        if (cursor.isNull(i + 12))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 12));
        }
        interest.setImageSmallHeight(((Integer) (obj)));
        if (cursor.isNull(i + 13))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 13);
        }
        interest.setImageHeaderUrl(((String) (obj)));
        if (cursor.isNull(i + 14))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 14));
        }
        interest.setImageHeaderWidth(((Integer) (obj)));
        if (cursor.isNull(i + 15))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 15));
        }
        interest.setImageHeaderHeight(((Integer) (obj)));
        if (cursor.isNull(i + 16))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 16);
        }
        interest.setImageGridMed1LineUrl(((String) (obj)));
        if (cursor.isNull(i + 17))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 17));
        }
        interest.setImageGridMed1LineWidth(((Integer) (obj)));
        if (cursor.isNull(i + 18))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 18));
        }
        interest.setImageGridMed1LineHeight(((Integer) (obj)));
        if (cursor.isNull(i + 19))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 19);
        }
        interest.setImageGridMed2LineUrl(((String) (obj)));
        if (cursor.isNull(i + 20))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 20));
        }
        interest.setImageGridMed2LineWidth(((Integer) (obj)));
        if (cursor.isNull(i + 21))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 21));
        }
        interest.setImageGridMed2LineHeight(((Integer) (obj)));
        if (cursor.isNull(i + 22))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 22);
        }
        interest.setImageGridMed4LineUrl(((String) (obj)));
        if (cursor.isNull(i + 23))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 23));
        }
        interest.setImageGridMed4LineWidth(((Integer) (obj)));
        if (cursor.isNull(i + 24))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 24));
        }
        interest.setImageGridMed4LineHeight(((Integer) (obj)));
        if (cursor.isNull(i + 25))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 25);
        }
        interest.setImageGridLg2LineUrl(((String) (obj)));
        if (cursor.isNull(i + 26))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 26));
        }
        interest.setImageGridLg2LineWidth(((Integer) (obj)));
        if (cursor.isNull(i + 27))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 27));
        }
        interest.setImageGridLg2LineHeight(((Integer) (obj)));
        if (cursor.isNull(i + 28))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 28);
        }
        interest.setImageGridLg4LineUrl(((String) (obj)));
        if (cursor.isNull(i + 29))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 29));
        }
        interest.setImageGridLg4LineWidth(((Integer) (obj)));
        if (cursor.isNull(i + 30))
        {
            cursor = obj1;
        } else
        {
            cursor = Integer.valueOf(cursor.getInt(i + 30));
        }
        interest.setImageGridLg4LineHeight(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Interest)obj, i);
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

    protected Long updateKeyAfterInsert(Interest interest, long l)
    {
        interest.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((Interest)obj, l);
    }
}
