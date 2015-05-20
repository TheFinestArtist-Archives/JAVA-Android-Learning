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
//            Pin, DaoSession

public class PinDao extends AbstractDao
{

    public static final String TABLENAME = "PIN";

    public PinDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public PinDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(s).append("'PIN' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'UID' TEXT,'INSERTION_ID' TEXT,'USER_UID' TEXT,'PROMOTER_UID' TEXT,'BOARD_UID' TEXT,'INTEREST_UID' TEXT,'PINNED_TO_BOARD_UID' TEXT,'CREATED_AT' INTEGER,'DOMAIN' TEXT,'DESCRIPTION' TEXT,'CLEAN_DESCRIPTION' TEXT,'LINK' TEXT,'SOURCE' TEXT,'VIA_USER_UID' TEXT,'ATTR_TITLE' TEXT,'ATTR_PROVIDER_NAME' TEXT,'ATTR_PROVIDER_URL' TEXT,'ATTR_AUTHOR_NAME' TEXT,'ATTR_AUTHOR_URL' TEXT,'ATTR_PROVIDER_ICON_URL' TEXT,'IMAGE_SQUARE_URL' TEXT,'IMAGE_MEDIUM_URL' TEXT,'IMAGE_LARGE_URL' TEXT,'EMBED_URL' TEXT,'EMBED_TYPE' TEXT,'IMAGE_SQUARE_WIDTH' INTEGER,'IMAGE_SQUARE_HEIGHT' INTEGER,'IMAGE_MEDIUM_WIDTH' INTEGER,'IMAGE_MEDIUM_HEIGHT' INTEGER,'IMAGE_LARGE_WIDTH' INTEGER,").append("'IMAGE_LARGE_HEIGHT' INTEGER,'EMBED_WIDTH' INTEGER,'EMBED_HEIGHT' INTEGER,'REPIN_COUNT' INTEGER,'LIKE_COUNT' INTEGER,'COMMENT_COUNT' INTEGER,'REPINNED' INTEGER,'LIKED' INTEGER,'VIDEO' INTEGER,'DOMINANT_COLOR' TEXT,'RICH_TITLE' TEXT,'RICH_SITE_NAME' TEXT,'RICH_TYPE_NAME' TEXT,'RICH_ICON' TEXT,'METADATA_JSON' TEXT,'PLACE_UID' TEXT,'HAS_PLACE' INTEGER,'RECOMMENDATION_BLOB' TEXT,'RECOMMENDATION_REASON' TEXT,'RECOMMENDATION_BOARD_UID' TEXT,'HIDDEN_STATE' INTEGER,'FEEDBACK_TYPE' INTEGER,'VIEW_TAGS' TEXT,'CACHEABLE_ID' TEXT);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'PIN'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, Pin pin)
    {
        long l1 = 1L;
        sqlitestatement.clearBindings();
        Object obj = pin.getId();
        if (obj != null)
        {
            sqlitestatement.bindLong(1, ((Long) (obj)).longValue());
        }
        obj = pin.getUid();
        if (obj != null)
        {
            sqlitestatement.bindString(2, ((String) (obj)));
        }
        obj = pin.getInsertionId();
        if (obj != null)
        {
            sqlitestatement.bindString(3, ((String) (obj)));
        }
        obj = pin.getUserUid();
        if (obj != null)
        {
            sqlitestatement.bindString(4, ((String) (obj)));
        }
        obj = pin.getPromoterUid();
        if (obj != null)
        {
            sqlitestatement.bindString(5, ((String) (obj)));
        }
        obj = pin.getBoardUid();
        if (obj != null)
        {
            sqlitestatement.bindString(6, ((String) (obj)));
        }
        obj = pin.getInterestUid();
        if (obj != null)
        {
            sqlitestatement.bindString(7, ((String) (obj)));
        }
        obj = pin.getPinnedToBoardUid();
        if (obj != null)
        {
            sqlitestatement.bindString(8, ((String) (obj)));
        }
        obj = pin.getCreatedAt();
        if (obj != null)
        {
            sqlitestatement.bindLong(9, ((Date) (obj)).getTime());
        }
        obj = pin.getDomain();
        if (obj != null)
        {
            sqlitestatement.bindString(10, ((String) (obj)));
        }
        obj = pin.getDescription();
        if (obj != null)
        {
            sqlitestatement.bindString(11, ((String) (obj)));
        }
        obj = pin.getCleanDescription();
        if (obj != null)
        {
            sqlitestatement.bindString(12, ((String) (obj)));
        }
        obj = pin.getLink();
        if (obj != null)
        {
            sqlitestatement.bindString(13, ((String) (obj)));
        }
        obj = pin.getSource();
        if (obj != null)
        {
            sqlitestatement.bindString(14, ((String) (obj)));
        }
        obj = pin.getViaUserUid();
        if (obj != null)
        {
            sqlitestatement.bindString(15, ((String) (obj)));
        }
        obj = pin.getAttrTitle();
        if (obj != null)
        {
            sqlitestatement.bindString(16, ((String) (obj)));
        }
        obj = pin.getAttrProviderName();
        if (obj != null)
        {
            sqlitestatement.bindString(17, ((String) (obj)));
        }
        obj = pin.getAttrProviderUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(18, ((String) (obj)));
        }
        obj = pin.getAttrAuthorName();
        if (obj != null)
        {
            sqlitestatement.bindString(19, ((String) (obj)));
        }
        obj = pin.getAttrAuthorUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(20, ((String) (obj)));
        }
        obj = pin.getAttrProviderIconUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(21, ((String) (obj)));
        }
        obj = pin.getImageSquareUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(22, ((String) (obj)));
        }
        obj = pin.getImageMediumUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(23, ((String) (obj)));
        }
        obj = pin.getImageLargeUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(24, ((String) (obj)));
        }
        obj = pin.getEmbedUrl();
        if (obj != null)
        {
            sqlitestatement.bindString(25, ((String) (obj)));
        }
        obj = pin.getEmbedType();
        if (obj != null)
        {
            sqlitestatement.bindString(26, ((String) (obj)));
        }
        obj = pin.getImageSquareWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(27, ((Integer) (obj)).intValue());
        }
        obj = pin.getImageSquareHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(28, ((Integer) (obj)).intValue());
        }
        obj = pin.getImageMediumWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(29, ((Integer) (obj)).intValue());
        }
        obj = pin.getImageMediumHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(30, ((Integer) (obj)).intValue());
        }
        obj = pin.getImageLargeWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(31, ((Integer) (obj)).intValue());
        }
        obj = pin.getImageLargeHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(32, ((Integer) (obj)).intValue());
        }
        obj = pin.getEmbedWidth();
        if (obj != null)
        {
            sqlitestatement.bindLong(33, ((Integer) (obj)).intValue());
        }
        obj = pin.getEmbedHeight();
        if (obj != null)
        {
            sqlitestatement.bindLong(34, ((Integer) (obj)).intValue());
        }
        obj = pin.getRepinCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(35, ((Integer) (obj)).intValue());
        }
        obj = pin.getLikeCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(36, ((Integer) (obj)).intValue());
        }
        obj = pin.getCommentCount();
        if (obj != null)
        {
            sqlitestatement.bindLong(37, ((Integer) (obj)).intValue());
        }
        obj = pin.getRepinned();
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
            sqlitestatement.bindLong(38, l);
        }
        obj = pin.getLiked();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(39, l);
        }
        obj = pin.getVideo();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = 1L;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(40, l);
        }
        obj = pin.getDominantColor();
        if (obj != null)
        {
            sqlitestatement.bindString(41, ((String) (obj)));
        }
        obj = pin.getRichTitle();
        if (obj != null)
        {
            sqlitestatement.bindString(42, ((String) (obj)));
        }
        obj = pin.getRichSiteName();
        if (obj != null)
        {
            sqlitestatement.bindString(43, ((String) (obj)));
        }
        obj = pin.getRichTypeName();
        if (obj != null)
        {
            sqlitestatement.bindString(44, ((String) (obj)));
        }
        obj = pin.getRichIcon();
        if (obj != null)
        {
            sqlitestatement.bindString(45, ((String) (obj)));
        }
        obj = pin.getMetadataJson();
        if (obj != null)
        {
            sqlitestatement.bindString(46, ((String) (obj)));
        }
        obj = pin.getPlaceUid();
        if (obj != null)
        {
            sqlitestatement.bindString(47, ((String) (obj)));
        }
        obj = pin.getHasPlace();
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                l = l1;
            } else
            {
                l = 0L;
            }
            sqlitestatement.bindLong(48, l);
        }
        obj = pin.getRecommendationBlob();
        if (obj != null)
        {
            sqlitestatement.bindString(49, ((String) (obj)));
        }
        obj = pin.getRecommendationReason();
        if (obj != null)
        {
            sqlitestatement.bindString(50, ((String) (obj)));
        }
        obj = pin.getRecommendationBoardUid();
        if (obj != null)
        {
            sqlitestatement.bindString(51, ((String) (obj)));
        }
        obj = pin.getHiddenState();
        if (obj != null)
        {
            sqlitestatement.bindLong(52, ((Integer) (obj)).intValue());
        }
        obj = pin.getFeedbackType();
        if (obj != null)
        {
            sqlitestatement.bindLong(53, ((Integer) (obj)).intValue());
        }
        obj = pin.getViewTags();
        if (obj != null)
        {
            sqlitestatement.bindString(54, ((String) (obj)));
        }
        pin = pin.getCacheableId();
        if (pin != null)
        {
            sqlitestatement.bindString(55, pin);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (Pin)obj);
    }

    public Long getKey(Pin pin)
    {
        if (pin != null)
        {
            return pin.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((Pin)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public Pin readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        Date date;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        String s14;
        String s15;
        String s16;
        String s17;
        String s18;
        String s19;
        String s20;
        String s21;
        String s22;
        String s23;
        Integer integer;
        Integer integer1;
        Integer integer2;
        Integer integer3;
        Integer integer4;
        Integer integer5;
        Integer integer6;
        Integer integer7;
        Integer integer8;
        Integer integer9;
        Integer integer10;
        Boolean boolean1;
        Boolean boolean2;
        Boolean boolean3;
        String s24;
        String s25;
        String s26;
        String s27;
        String s28;
        String s29;
        String s30;
        Boolean boolean4;
        String s31;
        String s32;
        String s33;
        Integer integer11;
        Integer integer12;
        String s34;
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
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 7);
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
            s10 = null;
        } else
        {
            s10 = cursor.getString(i + 12);
        }
        if (cursor.isNull(i + 13))
        {
            s11 = null;
        } else
        {
            s11 = cursor.getString(i + 13);
        }
        if (cursor.isNull(i + 14))
        {
            s12 = null;
        } else
        {
            s12 = cursor.getString(i + 14);
        }
        if (cursor.isNull(i + 15))
        {
            s13 = null;
        } else
        {
            s13 = cursor.getString(i + 15);
        }
        if (cursor.isNull(i + 16))
        {
            s14 = null;
        } else
        {
            s14 = cursor.getString(i + 16);
        }
        if (cursor.isNull(i + 17))
        {
            s15 = null;
        } else
        {
            s15 = cursor.getString(i + 17);
        }
        if (cursor.isNull(i + 18))
        {
            s16 = null;
        } else
        {
            s16 = cursor.getString(i + 18);
        }
        if (cursor.isNull(i + 19))
        {
            s17 = null;
        } else
        {
            s17 = cursor.getString(i + 19);
        }
        if (cursor.isNull(i + 20))
        {
            s18 = null;
        } else
        {
            s18 = cursor.getString(i + 20);
        }
        if (cursor.isNull(i + 21))
        {
            s19 = null;
        } else
        {
            s19 = cursor.getString(i + 21);
        }
        if (cursor.isNull(i + 22))
        {
            s20 = null;
        } else
        {
            s20 = cursor.getString(i + 22);
        }
        if (cursor.isNull(i + 23))
        {
            s21 = null;
        } else
        {
            s21 = cursor.getString(i + 23);
        }
        if (cursor.isNull(i + 24))
        {
            s22 = null;
        } else
        {
            s22 = cursor.getString(i + 24);
        }
        if (cursor.isNull(i + 25))
        {
            s23 = null;
        } else
        {
            s23 = cursor.getString(i + 25);
        }
        if (cursor.isNull(i + 26))
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(cursor.getInt(i + 26));
        }
        if (cursor.isNull(i + 27))
        {
            integer1 = null;
        } else
        {
            integer1 = Integer.valueOf(cursor.getInt(i + 27));
        }
        if (cursor.isNull(i + 28))
        {
            integer2 = null;
        } else
        {
            integer2 = Integer.valueOf(cursor.getInt(i + 28));
        }
        if (cursor.isNull(i + 29))
        {
            integer3 = null;
        } else
        {
            integer3 = Integer.valueOf(cursor.getInt(i + 29));
        }
        if (cursor.isNull(i + 30))
        {
            integer4 = null;
        } else
        {
            integer4 = Integer.valueOf(cursor.getInt(i + 30));
        }
        if (cursor.isNull(i + 31))
        {
            integer5 = null;
        } else
        {
            integer5 = Integer.valueOf(cursor.getInt(i + 31));
        }
        if (cursor.isNull(i + 32))
        {
            integer6 = null;
        } else
        {
            integer6 = Integer.valueOf(cursor.getInt(i + 32));
        }
        if (cursor.isNull(i + 33))
        {
            integer7 = null;
        } else
        {
            integer7 = Integer.valueOf(cursor.getInt(i + 33));
        }
        if (cursor.isNull(i + 34))
        {
            integer8 = null;
        } else
        {
            integer8 = Integer.valueOf(cursor.getInt(i + 34));
        }
        if (cursor.isNull(i + 35))
        {
            integer9 = null;
        } else
        {
            integer9 = Integer.valueOf(cursor.getInt(i + 35));
        }
        if (cursor.isNull(i + 36))
        {
            integer10 = null;
        } else
        {
            integer10 = Integer.valueOf(cursor.getInt(i + 36));
        }
        if (cursor.isNull(i + 37))
        {
            boolean1 = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 37) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
        }
        if (cursor.isNull(i + 38))
        {
            boolean2 = null;
        } else
        {
            boolean flag1;
            if (cursor.getShort(i + 38) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean2 = Boolean.valueOf(flag1);
        }
        if (cursor.isNull(i + 39))
        {
            boolean3 = null;
        } else
        {
            boolean flag2;
            if (cursor.getShort(i + 39) != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            boolean3 = Boolean.valueOf(flag2);
        }
        if (cursor.isNull(i + 40))
        {
            s24 = null;
        } else
        {
            s24 = cursor.getString(i + 40);
        }
        if (cursor.isNull(i + 41))
        {
            s25 = null;
        } else
        {
            s25 = cursor.getString(i + 41);
        }
        if (cursor.isNull(i + 42))
        {
            s26 = null;
        } else
        {
            s26 = cursor.getString(i + 42);
        }
        if (cursor.isNull(i + 43))
        {
            s27 = null;
        } else
        {
            s27 = cursor.getString(i + 43);
        }
        if (cursor.isNull(i + 44))
        {
            s28 = null;
        } else
        {
            s28 = cursor.getString(i + 44);
        }
        if (cursor.isNull(i + 45))
        {
            s29 = null;
        } else
        {
            s29 = cursor.getString(i + 45);
        }
        if (cursor.isNull(i + 46))
        {
            s30 = null;
        } else
        {
            s30 = cursor.getString(i + 46);
        }
        if (cursor.isNull(i + 47))
        {
            boolean4 = null;
        } else
        {
            boolean flag3;
            if (cursor.getShort(i + 47) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            boolean4 = Boolean.valueOf(flag3);
        }
        if (cursor.isNull(i + 48))
        {
            s31 = null;
        } else
        {
            s31 = cursor.getString(i + 48);
        }
        if (cursor.isNull(i + 49))
        {
            s32 = null;
        } else
        {
            s32 = cursor.getString(i + 49);
        }
        if (cursor.isNull(i + 50))
        {
            s33 = null;
        } else
        {
            s33 = cursor.getString(i + 50);
        }
        if (cursor.isNull(i + 51))
        {
            integer11 = null;
        } else
        {
            integer11 = Integer.valueOf(cursor.getInt(i + 51));
        }
        if (cursor.isNull(i + 52))
        {
            integer12 = null;
        } else
        {
            integer12 = Integer.valueOf(cursor.getInt(i + 52));
        }
        if (cursor.isNull(i + 53))
        {
            s34 = null;
        } else
        {
            s34 = cursor.getString(i + 53);
        }
        if (cursor.isNull(i + 54))
        {
            cursor = null;
        } else
        {
            cursor = cursor.getString(i + 54);
        }
        return new Pin(long1, s, s1, s2, s3, s4, s5, s6, date, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, integer, integer1, integer2, integer3, integer4, integer5, integer6, integer7, integer8, integer9, integer10, boolean1, boolean2, boolean3, s24, s25, s26, s27, s28, s29, s30, boolean4, s31, s32, s33, integer11, integer12, s34, cursor);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, Pin pin, int i)
    {
        boolean flag4 = true;
        Object obj1 = null;
        Object obj;
        if (cursor.isNull(i + 0))
        {
            obj = null;
        } else
        {
            obj = Long.valueOf(cursor.getLong(i + 0));
        }
        pin.setId(((Long) (obj)));
        if (cursor.isNull(i + 1))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 1);
        }
        pin.setUid(((String) (obj)));
        if (cursor.isNull(i + 2))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 2);
        }
        pin.setInsertionId(((String) (obj)));
        if (cursor.isNull(i + 3))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 3);
        }
        pin.setUserUid(((String) (obj)));
        if (cursor.isNull(i + 4))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 4);
        }
        pin.setPromoterUid(((String) (obj)));
        if (cursor.isNull(i + 5))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 5);
        }
        pin.setBoardUid(((String) (obj)));
        if (cursor.isNull(i + 6))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 6);
        }
        pin.setInterestUid(((String) (obj)));
        if (cursor.isNull(i + 7))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 7);
        }
        pin.setPinnedToBoardUid(((String) (obj)));
        if (cursor.isNull(i + 8))
        {
            obj = null;
        } else
        {
            obj = new Date(cursor.getLong(i + 8));
        }
        pin.setCreatedAt(((Date) (obj)));
        if (cursor.isNull(i + 9))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 9);
        }
        pin.setDomain(((String) (obj)));
        if (cursor.isNull(i + 10))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 10);
        }
        pin.setDescription(((String) (obj)));
        if (cursor.isNull(i + 11))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 11);
        }
        pin.setCleanDescription(((String) (obj)));
        if (cursor.isNull(i + 12))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 12);
        }
        pin.setLink(((String) (obj)));
        if (cursor.isNull(i + 13))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 13);
        }
        pin.setSource(((String) (obj)));
        if (cursor.isNull(i + 14))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 14);
        }
        pin.setViaUserUid(((String) (obj)));
        if (cursor.isNull(i + 15))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 15);
        }
        pin.setAttrTitle(((String) (obj)));
        if (cursor.isNull(i + 16))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 16);
        }
        pin.setAttrProviderName(((String) (obj)));
        if (cursor.isNull(i + 17))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 17);
        }
        pin.setAttrProviderUrl(((String) (obj)));
        if (cursor.isNull(i + 18))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 18);
        }
        pin.setAttrAuthorName(((String) (obj)));
        if (cursor.isNull(i + 19))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 19);
        }
        pin.setAttrAuthorUrl(((String) (obj)));
        if (cursor.isNull(i + 20))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 20);
        }
        pin.setAttrProviderIconUrl(((String) (obj)));
        if (cursor.isNull(i + 21))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 21);
        }
        pin.setImageSquareUrl(((String) (obj)));
        if (cursor.isNull(i + 22))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 22);
        }
        pin.setImageMediumUrl(((String) (obj)));
        if (cursor.isNull(i + 23))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 23);
        }
        pin.setImageLargeUrl(((String) (obj)));
        if (cursor.isNull(i + 24))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 24);
        }
        pin.setEmbedUrl(((String) (obj)));
        if (cursor.isNull(i + 25))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 25);
        }
        pin.setEmbedType(((String) (obj)));
        if (cursor.isNull(i + 26))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 26));
        }
        pin.setImageSquareWidth(((Integer) (obj)));
        if (cursor.isNull(i + 27))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 27));
        }
        pin.setImageSquareHeight(((Integer) (obj)));
        if (cursor.isNull(i + 28))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 28));
        }
        pin.setImageMediumWidth(((Integer) (obj)));
        if (cursor.isNull(i + 29))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 29));
        }
        pin.setImageMediumHeight(((Integer) (obj)));
        if (cursor.isNull(i + 30))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 30));
        }
        pin.setImageLargeWidth(((Integer) (obj)));
        if (cursor.isNull(i + 31))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 31));
        }
        pin.setImageLargeHeight(((Integer) (obj)));
        if (cursor.isNull(i + 32))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 32));
        }
        pin.setEmbedWidth(((Integer) (obj)));
        if (cursor.isNull(i + 33))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 33));
        }
        pin.setEmbedHeight(((Integer) (obj)));
        if (cursor.isNull(i + 34))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 34));
        }
        pin.setRepinCount(((Integer) (obj)));
        if (cursor.isNull(i + 35))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 35));
        }
        pin.setLikeCount(((Integer) (obj)));
        if (cursor.isNull(i + 36))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 36));
        }
        pin.setCommentCount(((Integer) (obj)));
        if (cursor.isNull(i + 37))
        {
            obj = null;
        } else
        {
            boolean flag;
            if (cursor.getShort(i + 37) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = Boolean.valueOf(flag);
        }
        pin.setRepinned(((Boolean) (obj)));
        if (cursor.isNull(i + 38))
        {
            obj = null;
        } else
        {
            boolean flag1;
            if (cursor.getShort(i + 38) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = Boolean.valueOf(flag1);
        }
        pin.setLiked(((Boolean) (obj)));
        if (cursor.isNull(i + 39))
        {
            obj = null;
        } else
        {
            boolean flag2;
            if (cursor.getShort(i + 39) != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = Boolean.valueOf(flag2);
        }
        pin.setVideo(((Boolean) (obj)));
        if (cursor.isNull(i + 40))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 40);
        }
        pin.setDominantColor(((String) (obj)));
        if (cursor.isNull(i + 41))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 41);
        }
        pin.setRichTitle(((String) (obj)));
        if (cursor.isNull(i + 42))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 42);
        }
        pin.setRichSiteName(((String) (obj)));
        if (cursor.isNull(i + 43))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 43);
        }
        pin.setRichTypeName(((String) (obj)));
        if (cursor.isNull(i + 44))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 44);
        }
        pin.setRichIcon(((String) (obj)));
        if (cursor.isNull(i + 45))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 45);
        }
        pin.setMetadataJson(((String) (obj)));
        if (cursor.isNull(i + 46))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 46);
        }
        pin.setPlaceUid(((String) (obj)));
        if (cursor.isNull(i + 47))
        {
            obj = null;
        } else
        {
            boolean flag3;
            if (cursor.getShort(i + 47) != 0)
            {
                flag3 = flag4;
            } else
            {
                flag3 = false;
            }
            obj = Boolean.valueOf(flag3);
        }
        pin.setHasPlace(((Boolean) (obj)));
        if (cursor.isNull(i + 48))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 48);
        }
        pin.setRecommendationBlob(((String) (obj)));
        if (cursor.isNull(i + 49))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 49);
        }
        pin.setRecommendationReason(((String) (obj)));
        if (cursor.isNull(i + 50))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 50);
        }
        pin.setRecommendationBoardUid(((String) (obj)));
        if (cursor.isNull(i + 51))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 51));
        }
        pin.setHiddenState(((Integer) (obj)));
        if (cursor.isNull(i + 52))
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(cursor.getInt(i + 52));
        }
        pin.setFeedbackType(((Integer) (obj)));
        if (cursor.isNull(i + 53))
        {
            obj = null;
        } else
        {
            obj = cursor.getString(i + 53);
        }
        pin.setViewTags(((String) (obj)));
        if (cursor.isNull(i + 54))
        {
            cursor = obj1;
        } else
        {
            cursor = cursor.getString(i + 54);
        }
        pin.setCacheableId(cursor);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (Pin)obj, i);
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

    protected Long updateKeyAfterInsert(Pin pin, long l)
    {
        pin.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((Pin)obj, l);
    }
}
