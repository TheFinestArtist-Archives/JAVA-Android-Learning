// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import java.util.List;

// Referenced classes of package de.greenrobot.dao:
//            AbstractQuery, AbstractDao, LazyList, DaoException, 
//            CloseableListIterator

public class Query extends AbstractQuery
{

    private int limitPosition;
    private int offsetPosition;

    Query(AbstractDao abstractdao, String s, Collection collection)
    {
        super(abstractdao, s, collection);
        limitPosition = -1;
        offsetPosition = -1;
    }

    public List list()
    {
        android.database.Cursor cursor = dao.db.rawQuery(sql, parameters);
        return dao.loadAllAndCloseCursor(cursor);
    }

    public CloseableListIterator listIterator()
    {
        return listLazyUncached().listIteratorAutoClose();
    }

    public LazyList listLazy()
    {
        android.database.Cursor cursor = dao.db.rawQuery(sql, parameters);
        return new LazyList(dao, cursor, true);
    }

    public LazyList listLazyUncached()
    {
        android.database.Cursor cursor = dao.db.rawQuery(sql, parameters);
        return new LazyList(dao, cursor, false);
    }

    public void setLimit(int i)
    {
        if (limitPosition == -1)
        {
            throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        } else
        {
            parameters[limitPosition] = Integer.toString(i);
            return;
        }
    }

    void setLimitPosition(int i)
    {
        limitPosition = i;
    }

    public void setOffset(int i)
    {
        if (offsetPosition == -1)
        {
            throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        } else
        {
            parameters[offsetPosition] = Integer.toString(i);
            return;
        }
    }

    void setOffsetPosition(int i)
    {
        offsetPosition = i;
    }

    public void setParameter(int i, Object obj)
    {
        if (i >= 0 && (i == limitPosition || i == offsetPosition))
        {
            throw new IllegalArgumentException((new StringBuilder("Illegal parameter index: ")).append(i).toString());
        }
        if (obj != null)
        {
            parameters[i] = obj.toString();
            return;
        } else
        {
            parameters[i] = null;
            return;
        }
    }

    public Object unique()
    {
        android.database.Cursor cursor = dao.db.rawQuery(sql, parameters);
        return dao.loadUniqueAndCloseCursor(cursor);
    }

    public Object uniqueOrThrow()
    {
        Object obj = unique();
        if (obj == null)
        {
            throw new DaoException("No entity found for query");
        } else
        {
            return obj;
        }
    }
}
