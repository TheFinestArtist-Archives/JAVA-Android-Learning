// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            TightDB

final class  extends Thread
{

    public final void run()
    {
        TightDB.gcGuaranteed();
    }

    ()
    {
    }
}
