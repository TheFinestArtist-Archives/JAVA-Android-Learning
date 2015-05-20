// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

// Referenced classes of package de.greenrobot.dao:
//            SqlUtils

public class TableStatements
{

    private final String allColumns[];
    private final SQLiteDatabase db;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private final String pkColumns[];
    private volatile String selectAll;
    private volatile String selectByKey;
    private volatile String selectByRowId;
    private final String tablename;
    private SQLiteStatement updateStatement;

    protected TableStatements(SQLiteDatabase sqlitedatabase, String s, String as[], String as1[])
    {
        db = sqlitedatabase;
        tablename = s;
        allColumns = as;
        pkColumns = as1;
    }

    protected SQLiteStatement getDeleteStatement()
    {
        if (deleteStatement == null)
        {
            String s = SqlUtils.createSqlDelete(tablename, pkColumns);
            deleteStatement = db.compileStatement(s);
        }
        return deleteStatement;
    }

    protected SQLiteStatement getInsertOrReplaceStatement()
    {
        if (insertOrReplaceStatement == null)
        {
            String s = SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", tablename, allColumns);
            insertOrReplaceStatement = db.compileStatement(s);
        }
        return insertOrReplaceStatement;
    }

    protected SQLiteStatement getInsertStatement()
    {
        if (insertStatement == null)
        {
            String s = SqlUtils.createSqlInsert("INSERT INTO ", tablename, allColumns);
            insertStatement = db.compileStatement(s);
        }
        return insertStatement;
    }

    protected String getSelectAll()
    {
        if (selectAll == null)
        {
            selectAll = SqlUtils.createSqlSelect(tablename, "T", allColumns);
        }
        return selectAll;
    }

    protected String getSelectByKey()
    {
        if (selectByKey == null)
        {
            StringBuilder stringbuilder = new StringBuilder(getSelectAll());
            stringbuilder.append("WHERE ");
            SqlUtils.appendColumnsEqValue(stringbuilder, "T", pkColumns);
            selectByKey = stringbuilder.toString();
        }
        return selectByKey;
    }

    public String getSelectByRowId()
    {
        if (selectByRowId == null)
        {
            selectByRowId = (new StringBuilder(String.valueOf(getSelectAll()))).append("WHERE ROWID=?").toString();
        }
        return selectByRowId;
    }

    protected SQLiteStatement getUpdateStatement()
    {
        if (updateStatement == null)
        {
            String s = SqlUtils.createSqlUpdate(tablename, allColumns, pkColumns);
            updateStatement = db.compileStatement(s);
        }
        return updateStatement;
    }
}
