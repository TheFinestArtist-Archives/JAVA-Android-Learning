// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;

// Referenced classes of package de.greenrobot.dao:
//            AbstractQuery, AbstractDao, DaoException

public class CountQuery extends AbstractQuery
{

    protected CountQuery(AbstractDao abstractdao, String s, Collection collection)
    {
        super(abstractdao, s, collection);
    }

    public long count()
    {
        Cursor cursor = dao.db.rawQuery(sql, parameters);
        if (!cursor.moveToNext())
        {
            throw new DaoException("No result for count");
        }
        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        long l;
        if (!cursor.isLast())
        {
            throw new DaoException((new StringBuilder("Unexpected row count: ")).append(cursor.getCount()).toString());
        }
        if (cursor.getColumnCount() != 1)
        {
            throw new DaoException((new StringBuilder("Unexpected column count: ")).append(cursor.getColumnCount()).toString());
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
    }

    public volatile void setParameter(int i, Object obj)
    {
        super.setParameter(i, obj);
    }
}
