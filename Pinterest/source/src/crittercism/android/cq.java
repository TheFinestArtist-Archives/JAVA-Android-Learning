// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            cv

public final class cq extends cv
{

    private Runnable a;

    public cq(Runnable runnable)
    {
        a = runnable;
    }

    public final void a()
    {
        a.run();
    }
}
