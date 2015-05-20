// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package crittercism.android:
//            cv, au, dk, de, 
//            di

public final class cz extends cv
{

    public Map a;
    private dk b;
    private au c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public cz(au au1)
    {
        c = au1;
        b = au1.i();
        a = new HashMap();
        d = false;
        e = false;
        f = false;
        g = false;
    }

    private void a(String s, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        a.put(s, obj);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void a()
    {
        boolean flag = b.d();
        if (d)
        {
            a("optOutStatus", Boolean.valueOf(flag));
        }
        if (!flag)
        {
            if (e)
            {
                a("crashedOnLastLoad", Boolean.valueOf(b.a().a));
            }
            if (f)
            {
                a("userUUID", c.c());
            }
            if (g)
            {
                di di1 = b.b();
                boolean flag1;
                if (di1.a && !di1.b && di1.c >= di1.d && (di1.c - di1.d) % di1.e == 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                a("shouldShowRateAppAlert", Boolean.valueOf(flag1));
                a("message", di1.f);
                a("title", di1.g);
            }
        }
    }

    public final void b()
    {
        d = true;
    }

    public final void c()
    {
        e = true;
    }

    public final void d()
    {
        f = true;
    }

    public final void e()
    {
        g = true;
    }
}
