// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// Referenced classes of package com.pinterest.api.model:
//            DaoMaster

public class tory extends tory
{

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.i("greenDAO", (new StringBuilder("Upgrading schema from version ")).append(i).append(" to ").append(j).append(" by dropping all tables").toString());
        DaoMaster.dropAllTables(sqlitedatabase, true);
        onCreate(sqlitedatabase);
    }

    public tory(Context context, String s, android.database.sqlite.tory tory)
    {
        super(context, s, tory);
    }
}
