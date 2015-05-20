// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            cq

public final class dm extends Thread
{

    public dm(Runnable runnable)
    {
        super(new cq(runnable));
    }

    public dm(Runnable runnable, String s)
    {
        super(new cq(runnable), s);
    }
}
