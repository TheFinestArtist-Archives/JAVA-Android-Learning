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
//            Board, DaoSession

public class BoardDao extends AbstractDao
{

    public static final String TABLENAME = "BOARD";

    public BoardDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public BoardDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'BOARD' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'UID' TEXT,'USER_UID' TEXT,'CREATED_AT' INTEGER,'NAME' TEXT,'CATEGORY' TEXT,'DESCRIPTION' TEXT,'URL' TEXT,'IMAGE_THUMBNAIL_URLS' TEXT,'IMAGE_PREVIEW_URL' TEXT,'IMAGE_COVER_URL' TEXT,'IMAGE_COVER_THUMBNAIL' TEXT,'FOLLOWING' INTEGER,'COLLABORATIVE' INTEGER,'COLLABORATOR_INVITES_ENABLED' INTEGER,'COLLABORATOR' INTEGER,'SECRET' INTEGER,'PIN_COUNT' INTEGER,'FOLLOWER_COUNT' INTEGER,'COLLABORATOR_COUNT' INTEGER,'LAYOUT' TEXT);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'BOARD'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Board board)
    {
        long l1 = 1L;
        sqlitestatement.clearBindings();
        Object obj = board.getId();
        if (obj != null)
        {
            sqlitestatement.bindLong(1, ((Long) (obj)).longValue());
        }
        obj = board.getUid();
        if (obj != null)
        {
            sqlitestatement.bindString(2, ((String) (obj)));
        }
        obj = board.getUserUid();
        if (obj != null)
        {
            sqlitestatement.bindString(3, ((String) (obj)));
        }
        obj = board.getCreatedAt();
        if (obj != null)
        {
            sqlitestatement.bindLong(4, ((Date) (obj)).getTime());
        }
        obj = board.getName();
        if (obj != null)
        {
            sqlitestatement.bindString(5, ((String) (obj)));
        }
        obj = board.getCategory();
        if (obj != null)
        {
            sqlitestatement.bindString(6, ((String) (obj)));
        }
        obj = board.getDescription();
        if (obj != null)
        {
            sqlitestatement.bindString(7, ((String) (obj)));
        }
        obj = board.getUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(8, ((String) (obj)));
        }
        obj = board.getImageThumbnailUrls();
        if (obj != null)
        {
            sqlitestatement.bindString(9, ((String) (obj)));
        }
        obj = board.getImagePreviewUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(10, ((String) (obj)));
        }
        obj = board.getImageCoverUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(11, ((String) (obj)));
        }
        obj = board.getImageCoverThumbnail();
        if (obj != null)
        {
            sqlitestatement.bindString(12, ((String) (obj)));
        }
        obj = board.getFollowing();
        long l;
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(13, l);
        }
        obj = board.getCollaborative();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(14, l);
        }
        obj = board.getCollaboratorInvitesEnabled();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(15, l);
        }
        obj = board.getCollaborator();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(16, l);
        }
        obj = board.getSecret();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = l1;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(17, l);
        }
        obj = board.getPinCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(18, ((Integer) (obj)).intValue());
        }
        obj = board.getFollowerCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(19, ((Integer) (obj)).intValue());
        }
        obj = board.getCollaboratorCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(20, ((Integer) (obj)).intValue());
        }
        board = board.getLayout();
        if (board != null)
        {
            sqlitestatement.bindString(21, board);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Board)obj);
    }

    public Long getKey(Board board)
    {
        if (board != null)
        {
            return board.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Board)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Board readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        Date date;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        Boolean boolean1;
        Boolean boolean2;
        Boolean boolean3;
        Boolean boolean4;
        Boolean boolean5;
        Integer integer;
        Integer integer1;
        Integer integer2;
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
            date = null;
        } else
        {
            date = new Date(cursor.getLong(i + 3));
        }
        if (cursor.isNull(i + 4))
        {
            s2 = null;
        } else
        {
            s2 = cursor.getString(i + 4);
        }
        if (cursor.isNull(i + 5))
        {
            s3 = null;
        } else
        {
            s3 = cursor.getString(i + 5);
        }
        if (cursor.isNull(i + 6))
        {
            s4 = null;
        } else
        {
            s4 = cursor.getString(i + 6);
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
            s8 = null;
        } else
        {
            s8 = cursor.getString(i + 10);
        }
        if (cursor.isNull(i + 11))
        {
            s9 = null;
        } else
        {
            s9 = cursor.getString(i + 11);
        }
        if (cursor.isNull(i + 12))
        {
            boolean1 = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 12) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
        }
        if (cursor.isNull(i + 13))
        {
            boolean2 = null;
        } else
        {
            boolean flag1;
            if (cursor.getShort(i + 13) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean2 = Boolean.valueOf(flag1);
        }
        if (cursor.isNull(i + 14))
        {
            boolean3 = null;
        } else
        {
            boolean flag2;
            if (cursor.getShort(i + 14) != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            boolean3 = Boolean.valueOf(flag2);
        }
        if (cursor.isNull(i + 15))
        {
            boolean4 = null;
        } else
        {
            boolean flag3;
            if (cursor.getShort(i + 15) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            boolean4 = Boolean.valueOf(flag3);
        }
        if (cursor.isNull(i + 16))
        {
            boolean5 = null;
        } else
        {
            boolean flag4;
            if (cursor.getShort(i + 16) != 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            boolean5 = Boolean.valueOf(flag4);
        }
        if (cursor.isNull(i + 17))
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(cursor.getInt(i + 17));
        }
        if (cursor.isNull(i + 18))
        {
            integer1 = null;
        } else
        {
            integer1 = Integer.valueOf(cursor.getInt(i + 18));
        }
        if (cursor.isNull(i + 19))
        {
            integer2 = null;
        } else
        {
            integer2 = Integer.valueOf(cursor.getInt(i + 19));
        }
        if (cursor.isNull(i + 20))
        {
            cursor = null;
        } else
        {
            cursor = cursor.getString(i + 20);
        }
        return new Board(long1, s, s1, date, s2, s3, s4, s5, s6, s7, s8, s9, boolean1, boolean2, boolean3, boolean4, boolean5, integer, integer1, integer2, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Board board, int i)
    {
        boolean flag5 = true;
        Object obj1 = null;
        Object obj;
        if (cursor.isNull(i + 0))
        {
            obj = null;
        } else
        {
            obj = Long.valueOf(cursor.getLong(i + 0));
        }
        board.setId(((Long) (obj)));
        if (cursor.isNull(i + 1))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 1);
        }
        board.setUid(((String) (obj)));
        if (cursor.isNull(i + 2))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 2);
        }
        board.setUserUid(((String) (obj)));
        if (cursor.isNull(i + 3))
        {
            obj = null;
        } else
        {
            obj = new Date(cursor.getLong(i + 3));
        }
        board.setCreatedAt(((Date) (obj)));
        if (cursor.isNull(i + 4))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 4);
        }
        board.setName(((String) (obj)));
        if (cursor.isNull(i + 5))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 5);
        }
        board.setCategory(((String) (obj)));
        if (cursor.isNull(i + 6))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 6);
        }
        board.setDescription(((String) (obj)));
        if (cursor.isNull(i + 7))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 7);
        }
        board.setUrl(((String) (obj)));
        if (cursor.isNull(i + 8))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 8);
        }
        board.setImageThumbnailUrls(((String) (obj)));
        if (cursor.isNull(i + 9))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 9);
        }
        board.setImagePreviewUrl(((String) (obj)));
        if (cursor.isNull(i + 10))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 10);
        }
        board.setImageCoverUrl(((String) (obj)));
        if (cursor.isNull(i + 11))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 11);
        }
        board.setImageCoverThumbnail(((String) (obj)));
        if (cursor.isNull(i + 12))
        {
            obj = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 12) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = Boolean.valueOf(flag);
        }
        board.setFollowing(((Boolean) (obj)));
        if (cursor.isNull(i + 13))
        {
            obj = null;
        } else
        {
            boolean flag1;
            if (cursor.getShort(i + 13) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = Boolean.valueOf(flag1);
        }
        board.setCollaborative(((Boolean) (obj)));
        if (cursor.isNull(i + 14))
        {
            obj = null;
        } else
        {
            boolean flag2;
            if (cursor.getShort(i + 14) != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = Boolean.valueOf(flag2);
        }
        board.setCollaboratorInvitesEnabled(((Boolean) (obj)));
        if (cursor.isNull(i + 15))
        {
            obj = null;
        } else
        {
            boolean flag3;
            if (cursor.getShort(i + 15) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj = Boolean.valueOf(flag3);
        }
        board.setCollaborator(((Boolean) (obj)));
        if (cursor.isNull(i + 16))
        {
            obj = null;
        } else
        {
            boolean flag4;
            if (cursor.getShort(i + 16) != 0)
            {
                flag4 = flag5;
            } else
            {
                flag4 = false;
            }
            obj = Boolean.valueOf(flag4);
        }
        board.setSecret(((Boolean) (obj)));
        if (cursor.isNull(i + 17))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 17));
        }
        board.setPinCount(((Integer) (obj)));
        if (cursor.isNull(i + 18))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 18));
        }
        board.setFollowerCount(((Integer) (obj)));
        if (cursor.isNull(i + 19))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 19));
        }
        board.setCollaboratorCount(((Integer) (obj)));
        if (cursor.isNull(i + 20))
        {
            cursor = obj1;
        } else
        {
            cursor = cursor.getString(i + 20);
        }
        board.setLayout(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Board)obj, i);
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

    protected Long updateKeyAfterInsert(Board board, long l)
    {
        board.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((Board)obj, l);
    }
}
