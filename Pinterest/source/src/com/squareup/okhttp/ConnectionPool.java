// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Connection, Route, Address

public final class ConnectionPool
{

    private static final ConnectionPool a;
    private final int b;
    private final long c;
    private final LinkedList d = new LinkedList();
    private final ExecutorService e;
    private final Runnable f = new _cls1();

    private ConnectionPool(int i, long l)
    {
        e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.c("OkHttp ConnectionPool"));
        b = i;
        c = l * 1000L * 1000L;
    }

    public static ConnectionPool a()
    {
        return a;
    }

    static LinkedList a(ConnectionPool connectionpool)
    {
        return connectionpool.d;
    }

    static long b(ConnectionPool connectionpool)
    {
        return connectionpool.c;
    }

    static int c(ConnectionPool connectionpool)
    {
        return connectionpool.b;
    }

    public final Connection a(Address address)
    {
        this;
        JVM INSTR monitorenter ;
        ListIterator listiterator = d.listIterator(d.size());
_L1:
        Connection connection;
        boolean flag;
        do
        {
            if (!listiterator.hasPrevious())
            {
                break MISSING_BLOCK_LABEL_183;
            }
            connection = (Connection)listiterator.previous();
        } while (!connection.d().a.equals(address) || !connection.f() || System.nanoTime() - connection.j() >= c);
        listiterator.remove();
        flag = connection.l();
        Object obj;
        obj = connection;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Platform.a().a(connection.e());
        for (obj = connection; obj == null; obj = null)
        {
            break MISSING_BLOCK_LABEL_127;
        }

        if (((Connection) (obj)).l())
        {
            d.addFirst(obj);
        }
        e.execute(f);
        this;
        JVM INSTR monitorexit ;
        return ((Connection) (obj));
        obj;
        Util.a(connection.e());
        Platform.a();
        Platform.a((new StringBuilder("Unable to tagSocket(): ")).append(obj).toString());
          goto _L1
        address;
        throw address;
    }

    final void a(Connection connection)
    {
        while (connection.l() || !connection.b()) 
        {
            return;
        }
        if (!connection.f())
        {
            Util.a(connection.e());
            return;
        }
        try
        {
            Platform.a().b(connection.e());
        }
        catch (SocketException socketexception)
        {
            Platform.a();
            Platform.a((new StringBuilder("Unable to untagSocket(): ")).append(socketexception).toString());
            Util.a(connection.e());
            return;
        }
        this;
        JVM INSTR monitorenter ;
        d.addFirst(connection);
        connection.n();
        connection.h();
        this;
        JVM INSTR monitorexit ;
        e.execute(f);
        return;
        connection;
        this;
        JVM INSTR monitorexit ;
        throw connection;
    }

    final void b(Connection connection)
    {
        if (!connection.l())
        {
            throw new IllegalArgumentException();
        }
        e.execute(f);
        if (!connection.f())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        this;
        JVM INSTR monitorenter ;
        d.addFirst(connection);
        this;
        JVM INSTR monitorexit ;
        return;
        connection;
        this;
        JVM INSTR monitorexit ;
        throw connection;
    }

    static 
    {
        String s = System.getProperty("http.keepAlive");
        String s1 = System.getProperty("http.keepAliveDuration");
        String s2 = System.getProperty("http.maxConnections");
        long l;
        if (s1 != null)
        {
            l = Long.parseLong(s1);
        } else
        {
            l = 0x493e0L;
        }
        if (s != null && !Boolean.parseBoolean(s))
        {
            a = new ConnectionPool(0, l);
        } else
        if (s2 != null)
        {
            a = new ConnectionPool(Integer.parseInt(s2), l);
        } else
        {
            a = new ConnectionPool(5, l);
        }
    }

    private class _cls1
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

        _cls1()
        {
            a = ConnectionPool.this;
            super();
        }
    }

}
