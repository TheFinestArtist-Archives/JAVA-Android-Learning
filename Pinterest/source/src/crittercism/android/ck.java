// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class ck
{

    private long a;
    private long b;

    public ck()
    {
        a = 0L;
        b = 0xdf8475800L;
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        long l2;
        l = System.nanoTime();
        l1 = a;
        l2 = b;
        boolean flag;
        if (l - l1 > l2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        a = System.nanoTime();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
