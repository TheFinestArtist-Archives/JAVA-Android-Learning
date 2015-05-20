// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;


// Referenced classes of package com.gracenote.gnsdk.Manager:
//            GnSdk

public abstract class GnObject
{

    protected GnObject()
    {
        GnSdk.a();
    }

    protected abstract void b();

    protected void finalize()
    {
        b();
        GnSdk.b();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }
}
