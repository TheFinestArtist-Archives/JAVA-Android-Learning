// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

// Referenced classes of package crittercism.android:
//            b, e

public final class d
{

    List a;
    final Set b;
    final Set c;
    private Executor d;

    public d(Executor executor)
    {
        this(executor, ((List) (new LinkedList())), ((List) (new LinkedList())));
    }

    private d(Executor executor, List list, List list1)
    {
        a = new LinkedList();
        b = new HashSet();
        c = new HashSet();
        d = executor;
        a(list);
        b(list1);
    }

    public final void a(b b1)
    {
        a(b1, b.a.e);
    }

    public final void a(b b1, b.a a1)
    {
        if (b1.b)
        {
            return;
        } else
        {
            b1.b = true;
            b1.c = a1;
            d.execute(new a(b1, (byte)0));
            return;
        }
    }

    public final void a(e e)
    {
        synchronized (a)
        {
            a.add(e);
        }
    }

    public final void a(List list)
    {
        synchronized (b)
        {
            b.addAll(list);
            b.remove(null);
        }
    }

    public final void b(List list)
    {
        synchronized (c)
        {
            c.addAll(list);
            c.remove(null);
        }
    }

    private class a
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

        private a(b b1)
        {
            a = d.this;
            super();
            b = b1;
        }

        a(b b1, byte byte0)
        {
            this(b1);
        }
    }

}
