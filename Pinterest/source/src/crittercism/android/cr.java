// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package crittercism.android:
//            cv, bj, au, cm, 
//            ct, co, cs

public final class cr
{

    private Context a;
    private au b;
    private List c;

    public cr(Context context, au au1)
    {
        a = context;
        b = au1;
        c = new ArrayList();
    }

    public final void a()
    {
        Object obj = new ArrayList();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(new Thread((cv)iterator.next()))) { }
        for (Iterator iterator1 = ((ArrayList) (obj)).iterator(); iterator1.hasNext(); ((Thread)iterator1.next()).start()) { }
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Thread)((Iterator) (obj)).next()).join()) { }
    }

    public final void a(bj bj1, cm cm1, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (bj1.c() > 0)
        {
            bj bj2 = bj1.a(a);
            cm1 = cm1.a(bj2, bj1, s, a, b, b.i());
            bj1 = new ct(bj2, bj1, b, (new co(s, bj2.f())).a(), cm1);
            c.add(bj1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bj1;
        throw bj1;
    }

    public final void a(cs cs1, ExecutorService executorservice)
    {
        Iterator iterator = c.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cv cv1 = (cv)iterator.next();
            if (!cs1.a(cv1))
            {
                executorservice.execute(cv1);
            }
        } while (true);
    }
}
