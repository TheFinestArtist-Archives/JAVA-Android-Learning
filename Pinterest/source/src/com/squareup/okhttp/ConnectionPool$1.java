// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.squareup.okhttp:
//            ConnectionPool, Connection

class a
    implements Runnable
{

    final ConnectionPool a;

    public void run()
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList(2);
        i = 0;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        ListIterator listiterator = ConnectionPool.a(a).listIterator(ConnectionPool.a(a).size());
_L5:
        if (!listiterator.hasPrevious()) goto _L2; else goto _L1
_L1:
        Connection connection = (Connection)listiterator.previous();
        if (connection.f() && !connection.a(ConnectionPool.b(a))) goto _L4; else goto _L3
_L3:
        listiterator.remove();
        arraylist.add(connection);
        if (arraylist.size() != 2) goto _L5; else goto _L2
_L2:
        listiterator = ConnectionPool.a(a).listIterator(ConnectionPool.a(a).size());
_L6:
        do
        {
            if (!listiterator.hasPrevious() || i <= ConnectionPool.c(a))
            {
                break MISSING_BLOCK_LABEL_210;
            }
            connection = (Connection)listiterator.previous();
        } while (!connection.i());
        arraylist.add(connection);
        listiterator.remove();
        i--;
          goto _L6
_L4:
        if (!connection.i()) goto _L5; else goto _L7
_L7:
        i++;
          goto _L5
        obj;
        JVM INSTR monitorexit ;
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); Util.a(((Connection)((Iterator) (obj)).next()).e())) { }
        break MISSING_BLOCK_LABEL_251;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (ConnectionPool connectionpool)
    {
        a = connectionpool;
        super();
    }
}
