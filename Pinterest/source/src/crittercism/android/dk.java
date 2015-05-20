// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            dh, cf, de, di, 
//            dj, aw, df

public final class dk
{

    private df a;
    private de b;
    private dh c;
    private di d;
    private dj e;

    public dk()
    {
    }

    public final de a()
    {
        this;
        JVM INSTR monitorenter ;
        de de1 = b;
        this;
        JVM INSTR monitorexit ;
        return de1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!c.a())
        {
            b.a(aw1, cf.i.a(), cf.i.b());
            d.a(aw1, cf.h.a(), cf.h.b());
            e.a(aw1, cf.k.a(), cf.k.b());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aw1;
        throw aw1;
    }

    public final void a(de de1)
    {
        this;
        JVM INSTR monitorenter ;
        b = de1;
        this;
        JVM INSTR monitorexit ;
        return;
        de1;
        throw de1;
    }

    public final void a(di di1)
    {
        this;
        JVM INSTR monitorenter ;
        d = di1;
        this;
        JVM INSTR monitorexit ;
        return;
        di1;
        throw di1;
    }

    public final di b()
    {
        this;
        JVM INSTR monitorenter ;
        di di1 = d;
        this;
        JVM INSTR monitorexit ;
        return di1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        c = dh.a.a(aw1);
        if (c.a())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        j = aw1.b(cf.k.a(), cf.k.b());
        int i;
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        i = aw1.b(cf.l.a(), cf.l.b());
        Object obj = new dj(i);
        obj.a = ((dj) (obj)).a + 1;
        e = ((dj) (obj));
        obj = di.a.a(aw1, cf.h.a(), cf.h.b());
        obj.c = ((di) (obj)).c + 1;
        d = ((di) (obj));
        b = new de(aw1.c(cf.i.a(), cf.i.b()));
        a = new df();
        this;
        JVM INSTR monitorexit ;
        return;
        aw1;
        throw aw1;
    }

    public final dj c()
    {
        this;
        JVM INSTR monitorenter ;
        dj dj1 = e;
        this;
        JVM INSTR monitorexit ;
        return dj1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        if (c == null) goto _L2; else goto _L1
_L1:
        boolean flag = c.a();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final df e()
    {
        this;
        JVM INSTR monitorenter ;
        df df1 = a;
        this;
        JVM INSTR monitorexit ;
        return df1;
        Exception exception;
        exception;
        throw exception;
    }
}
