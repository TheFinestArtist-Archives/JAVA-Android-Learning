// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal.log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package io.realm.internal.log:
//            Logger

public final class RealmLog
{

    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final List LOGGERS = new CopyOnWriteArrayList();
    public static final int NONE = 8;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public RealmLog()
    {
    }

    public static void add(Logger logger)
    {
        if (logger == null)
        {
            throw new IllegalArgumentException("A non-null logger has to be provided");
        } else
        {
            LOGGERS.add(logger);
            return;
        }
    }

    public static void d(String s)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).d(s);
        }

    }

    public static void d(String s, Throwable throwable)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).d(s, throwable);
        }

    }

    public static void e(String s)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).e(s);
        }

    }

    public static void e(String s, Throwable throwable)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).v(s, throwable);
        }

    }

    public static void i(String s)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).i(s);
        }

    }

    public static void i(String s, Throwable throwable)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).i(s, throwable);
        }

    }

    public static void remove(Logger logger)
    {
        if (logger == null)
        {
            throw new IllegalArgumentException("A non-null logger has to be provided");
        } else
        {
            LOGGERS.remove(logger);
            return;
        }
    }

    public static void v(String s)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).v(s);
        }

    }

    public static void v(String s, Throwable throwable)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).v(s, throwable);
        }

    }

    public static void w(String s)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).w(s);
        }

    }

    public static void w(String s, Throwable throwable)
    {
        for (int j = 0; j < LOGGERS.size(); j++)
        {
            ((Logger)LOGGERS.get(0)).w(s, null);
        }

    }

}
