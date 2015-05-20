// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import crittercism.android.ay;
import crittercism.android.cs;
import crittercism.android.cz;
import crittercism.android.dm;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.crittercism.app:
//            CritterCallback

public class CritterUserDataRequest
{

    private final CritterCallback a;
    private ay b;
    private cs c;
    private Map d;
    private cz e;

    public CritterUserDataRequest(CritterCallback crittercallback)
    {
        a = crittercallback;
        b = ay.r();
        c = b.o;
        d = new HashMap();
        e = new cz(b);
    }

    static cz a(CritterUserDataRequest critteruserdatarequest)
    {
        return critteruserdatarequest.e;
    }

    static Map a(CritterUserDataRequest critteruserdatarequest, Map map)
    {
        critteruserdatarequest.d = map;
        return map;
    }

    static ay b(CritterUserDataRequest critteruserdatarequest)
    {
        return critteruserdatarequest.b;
    }

    static Map c(CritterUserDataRequest critteruserdatarequest)
    {
        return critteruserdatarequest.d;
    }

    static CritterCallback d(CritterUserDataRequest critteruserdatarequest)
    {
        return critteruserdatarequest.a;
    }

    public void makeRequest()
    {
        this;
        JVM INSTR monitorenter ;
        _cls1 _lcls1 = new _cls1();
        if (!c.a(_lcls1))
        {
            (new dm(_lcls1)).start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public CritterUserDataRequest requestDidCrashOnLastLoad()
    {
        e.c();
        return this;
    }

    public CritterUserDataRequest requestOptOutStatus()
    {
        e.b();
        return this;
    }

    public CritterUserDataRequest requestRateMyAppInfo()
    {
        e.e();
        return this;
    }

    public CritterUserDataRequest requestUserUUID()
    {
        e.d();
        return this;
    }

    private class _cls1
        implements Runnable
    {

        final CritterUserDataRequest a;

        public final void run()
        {
            CritterUserDataRequest.a(a).run();
            CritterUserDataRequest.a(a, CritterUserDataRequest.a(a).a);
            boolean flag = CritterUserDataRequest.b(a).f.d();
            CritterUserDataRequest.d(a).onCritterDataReceived(new CritterUserData(CritterUserDataRequest.c(a), flag));
        }

        _cls1()
        {
            a = CritterUserDataRequest.this;
            super();
        }
    }

}
