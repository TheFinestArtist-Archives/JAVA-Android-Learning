// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.Collection;

// Referenced classes of package de.greenrobot.dao:
//            AbstractQuery, AbstractDao

public class DeleteQuery extends AbstractQuery
{

    private SQLiteStatement compiledStatement;

    public DeleteQuery(AbstractDao abstractdao, String s, Collection collection)
    {
        super(abstractdao, s, collection);
    }

    public void executeDeleteWithoutDetachingEntities()
    {
        this;
        JVM INSTR monitorenter ;
        if (compiledStatement == null) goto _L2; else goto _L1
_L1:
        compiledStatement.clearBindings();
          goto _L3
_L10:
        int i;
        if (i < parameters.length) goto _L5; else goto _L4
_L4:
        compiledStatement.execute();
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        compiledStatement = dao.db.compileStatement(sql);
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L5:
        String s = parameters[i];
        if (s == null) goto _L7; else goto _L6
_L6:
        compiledStatement.bindString(i + 1, s);
          goto _L8
_L7:
        compiledStatement.bindNull(i + 1);
          goto _L8
_L3:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public volatile void setParameter(int i, Object obj)
    {
        super.setParameter(i, obj);
    }
}
