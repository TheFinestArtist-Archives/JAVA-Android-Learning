// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.realm.internal:
//            Group, TableQuery, Row, SharedGroup, 
//            Table, TableView

class Context
{

    private List abandonedQueries;
    private List abandonedRows;
    private List abandonedTableViews;
    private List abandonedTables;
    private boolean isFinalized;

    Context()
    {
        abandonedTables = new ArrayList();
        abandonedTableViews = new ArrayList();
        abandonedQueries = new ArrayList();
        abandonedRows = new ArrayList();
        isFinalized = false;
    }

    public void asyncDisposeGroup(long l)
    {
        Group.nativeClose(l);
    }

    public void asyncDisposeQuery(long l)
    {
        if (isFinalized)
        {
            TableQuery.nativeClose(l);
            return;
        } else
        {
            abandonedQueries.add(Long.valueOf(l));
            return;
        }
    }

    public void asyncDisposeRow(long l)
    {
        if (isFinalized)
        {
            Row.nativeClose(l);
            return;
        } else
        {
            abandonedRows.add(Long.valueOf(l));
            return;
        }
    }

    public void asyncDisposeSharedGroup(long l)
    {
        SharedGroup.nativeClose(l);
    }

    public void asyncDisposeTable(long l, boolean flag)
    {
        if (flag || isFinalized)
        {
            Table.nativeClose(l);
            return;
        } else
        {
            abandonedTables.add(Long.valueOf(l));
            return;
        }
    }

    public void asyncDisposeTableView(long l)
    {
        if (isFinalized)
        {
            TableView.nativeClose(l);
            return;
        } else
        {
            abandonedTableViews.add(Long.valueOf(l));
            return;
        }
    }

    public void executeDelayedDisposal()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = abandonedTables.iterator(); iterator.hasNext(); Table.nativeClose(((Long)iterator.next()).longValue())) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        abandonedTables.clear();
        for (Iterator iterator1 = abandonedRows.iterator(); iterator1.hasNext(); Row.nativeClose(((Long)iterator1.next()).longValue())) { }
        abandonedRows.clear();
        for (Iterator iterator2 = abandonedTableViews.iterator(); iterator2.hasNext(); TableView.nativeClose(((Long)iterator2.next()).longValue())) { }
        abandonedTableViews.clear();
        for (Iterator iterator3 = abandonedQueries.iterator(); iterator3.hasNext(); TableQuery.nativeClose(((Long)iterator3.next()).longValue())) { }
        abandonedQueries.clear();
        this;
        JVM INSTR monitorexit ;
    }

    protected void finalize()
    {
        this;
        JVM INSTR monitorenter ;
        isFinalized = true;
        this;
        JVM INSTR monitorexit ;
        executeDelayedDisposal();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
