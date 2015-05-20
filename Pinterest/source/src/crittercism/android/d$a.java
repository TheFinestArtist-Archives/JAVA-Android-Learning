// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package crittercism.android:
//            b, d, e

final class <init>
    implements Runnable
{

    final d a;
    private b b;

    private boolean a(b b1)
    {
label0:
        {
            String s = b1.a();
            synchronized (a.b)
            {
                Iterator iterator = a.b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (!s.contains((String)iterator.next()));
            }
            return true;
        }
        return false;
        exception;
        throw exception;
    }

    private boolean a(String s)
    {
label0:
        {
            synchronized (a.c)
            {
                Iterator iterator = a.c.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (!s.contains((String)iterator.next()));
            }
            return false;
        }
        return true;
        s;
        throw s;
    }

    public final void run()
    {
        if (a(b))
        {
            return;
        }
        String s = b.a();
        if (a(s))
        {
            int i = s.indexOf("?");
            if (i != -1)
            {
                b b1 = b;
                s = s.substring(0, i);
                if (s == null)
                {
                    throw new NullPointerException();
                }
                b1.i = s;
            }
        }
        List list = a.a;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a.a.iterator(); iterator.hasNext(); ((e)iterator.next()).a(b)) { }
        break MISSING_BLOCK_LABEL_127;
        Exception exception;
        exception;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private eption(d d1, b b1)
    {
        a = d1;
        super();
        b = b1;
    }

    b(d d1, b b1, byte byte0)
    {
        this(d1, b1);
    }
}
