// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;

// Referenced classes of package com.google.android.gms.common.api:
//            Status, Result

public class f extends BaseImplementation.AbstractPendingResult
{

    public f(Looper looper)
    {
        super(looper);
    }

    protected Status b(Status status)
    {
        return status;
    }

    protected Result c(Status status)
    {
        return b(status);
    }
}
